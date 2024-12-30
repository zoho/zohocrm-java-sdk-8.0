package samples.blueprint;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.blueprint.APIException;
import com.zoho.crm.api.blueprint.BlueprintOperations;
import com.zoho.crm.api.blueprint.Currency;
import com.zoho.crm.api.blueprint.Escalation;
import com.zoho.crm.api.blueprint.Field;
import com.zoho.crm.api.blueprint.Layout;
import com.zoho.crm.api.blueprint.NextTransition;
import com.zoho.crm.api.blueprint.ProcessInfo;
import com.zoho.crm.api.blueprint.Profile;
import com.zoho.crm.api.blueprint.ResponseHandler;
import com.zoho.crm.api.blueprint.ResponseWrapper;
import com.zoho.crm.api.blueprint.Transition;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.fields.External;
import com.zoho.crm.api.fields.Maps;
import com.zoho.crm.api.blueprint.Module;
import com.zoho.crm.api.fields.MultiModuleLookup;
import com.zoho.crm.api.fields.PickListValue;
import com.zoho.crm.api.blueprint.MultiSelectLookup;
import com.zoho.crm.api.blueprint.ToolTip;
import com.zoho.crm.api.fields.Unique;
import com.zoho.crm.api.blueprint.ViewType;
import com.zoho.crm.api.record.Record;
import com.zoho.crm.api.users.MinifiedUser;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetBlueprint
{
	@SuppressWarnings("unused")
	public static void getBlueprint(String moduleAPIName, String recordId) throws Exception
	{
		BlueprintOperations bluePrintOperations = new BlueprintOperations(recordId, moduleAPIName);
		APIResponse<ResponseHandler> response = bluePrintOperations.getBlueprint();
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (Arrays.asList(204, 304).contains(response.getStatusCode()))
			{
				System.out.println(response.getStatusCode() == 204 ? "No Content" : "Not Modified");
				return;
			}
			if (response.isExpected())
			{
				ResponseHandler responseHandler = response.getObject();
				if (responseHandler instanceof ResponseWrapper)
				{
					ResponseWrapper responseWrapper = (ResponseWrapper) responseHandler;
					com.zoho.crm.api.blueprint.BluePrint bluePrint = responseWrapper.getBlueprint();
					ProcessInfo processInfo = bluePrint.getProcessInfo();
					if (processInfo != null)
					{
						System.out.println("ProcessInfo Field-ID: " + processInfo.getFieldId());
						Escalation escalation = processInfo.getEscalation();
						if (escalation != null)
						{
							System.out.println("Escalation days: " + escalation.getDays());
							System.out.println("Escalation status: " + escalation.getStatus());
						}
						System.out.println("ProcessInfo isContinuous: " + processInfo.getIsContinuous());
						System.out.println("ProcessInfo API Name: " + processInfo.getAPIName());
						System.out.println("ProcessInfo Continuous: " + processInfo.getContinuous());
						System.out.println("ProcessInfo FieldLabel: " + processInfo.getFieldLabel());
						System.out.println("ProcessInfo Name: " + processInfo.getName());
						System.out.println("ProcessInfo ColumnName: " + processInfo.getColumnName());
						System.out.println("ProcessInfo FieldValue: " + processInfo.getFieldValue());
						System.out.println("ProcessInfo ID: " + processInfo.getId());
						System.out.println("ProcessInfo FieldName: " + processInfo.getFieldName());
					}
					List<Transition> transitions = bluePrint.getTransitions();
					for (Transition transition : transitions)
					{
						List<NextTransition> nextTransitions = transition.getNextTransitions();
						for (NextTransition nextTransition : nextTransitions)
						{
							System.out.println("NextTransition ID: " + nextTransition.getId());
							System.out.println("NextTransition criteria_matched: " + nextTransition.getCriteriaMatched());
							System.out.println("NextTransition Name: " + nextTransition.getName());
							System.out.println("NextTransition type: " + nextTransition.getType());
						}
						Transition parentTransition = transition.getParentTransition();
						if (parentTransition != null)
						{
							System.out.println("Parenttransition ID: " + parentTransition.getId());
						}
						Record data = transition.getData();
						if (data != null)
						{
							System.out.println("Record ID: " + data.getId());
							MinifiedUser createdBy = data.getCreatedBy();
							if (createdBy != null)
							{
								System.out.println("Record Created By User-ID: " + createdBy.getId());
								System.out.println("Record Created By User-Name: " + createdBy.getName());
							}
							if (data.getCreatedTime() != null)
							{
								System.out.println("Record Created Time: " + data.getCreatedTime().toString());
							}
							if (data.getModifiedTime() != null)
							{
								System.out.println("Record Modified Time: " + data.getModifiedTime().toString());
							}
							MinifiedUser modifiedBy = data.getModifiedBy();
							if (modifiedBy != null)
							{
								System.out.println("Record Modified By User-ID: " + modifiedBy.getId());
								System.out.println("Record Modified By user-Name: " + modifiedBy.getName());
							}
							for (Map.Entry<String, Object> entry : data.getKeyValues().entrySet())
							{
								System.out.println(entry.getKey() + ": " + entry.getValue());
							}
						}

						System.out.println("Transition NextFieldValue: " + transition.getNextFieldValue());
						System.out.println("Transition Name: " + transition.getName());
						System.out.println("Transition CriteriaMatched: " + transition.getCriteriaMatched().toString());
						System.out.println("Transition ID: " + transition.getId());
						System.out.println("Transition Fields: ");
						List<Field> fields = transition.getFields();
						for (Field fieldHandler : fields)
						{
							Field field = (Field) fieldHandler;

							if (field.getSystemMandatory() != null)
							{
								System.out.println("Field is SystemMandatory: " + field.getSystemMandatory());
							}
							System.out.println("Field is Private" + field.getPrivate());
							System.out.println("Transition Fields Webhook: " + field.getWebhook());
							System.out.println("Transition Fields JsonType: " + field.getJsonType());
							System.out.println("Transition Fields DisplayLabel: " + field.getDisplayLabel());
							System.out.println("Transition Fields UiType: " + field.getUiType());
							System.out.println("Transition Fields ValidationRule: " + field.getValidationRule());
							System.out.println("Transition Fields DataType: " + field.getDataType());
							System.out.println("Transition Fields Type: " + field.getType());
							System.out.println("Transition Fields ColumnName: " + field.getColumnName());
							System.out.println("Transition Fields PersonalityName: " + field.getPersonalityName());
							System.out.println("Transition Fields ID: " + field.getId());
							System.out.println("Transition Fields TransitionSequence: " + field.getTransitionSequence().toString());
							if (field.getMandatory() != null)
							{
								System.out.println("Transition Fields Mandatory: " + field.getMandatory().toString());
							}
							Layout layout = field.getLayouts();
							if (layout != null)
							{
								System.out.println("Transition Fields Layout ID: " + layout.getId());
								System.out.println("Transition Fields Layout Name: " + layout.getName());
							}
							System.out.println("Field PickListValuesSortedLexically: " + field.getPickListValuesSortedLexically());
							System.out.println("Field Sortable: " + field.getSortable());
							System.out.println("Field TransitionSequence: " + field.getTransitionSequence());
							External external = field.getExternal();
							if (external != null)
							{
								System.out.println("Field External Show: " + external.getShow());
								System.out.println("Field External Type: " + external.getType());
								System.out.println("Field External AllowMultipleConfig: " + external.getAllowMultipleConfig());
							}
							Unique unique = field.getUnique();
							if (unique != null)
							{
								System.out.println("Field Unique Casesensitive : " + unique.getCasesensitive());
							}
							if (field.getHistoryTracking() != null)
							{
								System.out.println("Field HistoryTracking: " + field.getHistoryTracking());
							}
							System.out.println("Field DataType: " + field.getDataType());
							System.out.println("Transition Fields APIName: " + field.getAPIName());
							System.out.println("Transition Fields Content: " + field.getContent());
							if (field.getSystemMandatory() != null)
							{
								System.out.println("Transition Fields SystemMandatory: " + field.getSystemMandatory().toString());
							}
							System.out.println("Transition Fields FieldLabel: " + field.getFieldLabel());
							MultiModuleLookup multiModuleLookup = field.getMultiModuleLookup();
							if (multiModuleLookup != null)
							{
								System.out.println("Field MultiModuleLookup APIName: " + multiModuleLookup.getAPIName());
								System.out.println("Field MultiModuleLookup DisplayLabel: " + multiModuleLookup.getDisplayLabel());
								for (com.zoho.crm.api.modules.MinifiedModule module : multiModuleLookup.getModules())
								{
									System.out.println("Field MultiModuleLookup Module ID: " + module.getId());
									System.out.println("Field MultiModuleLookup Module APIName: " + module.getAPIName());
								}
							}
							Currency currency = field.getCurrency();
							if (currency != null)
							{
								System.out.println("Field Currency RoundingOption: " + currency.getRoundingOption());
								if (currency.getPrecision() != null)
								{
									System.out.println("Field Currency Precision: " + currency.getPrecision());
								}
							}
							ToolTip toolTip = field.getTooltip();
							if (toolTip != null)
							{
								System.out.println("Transition Fields Tooltip Name: " + toolTip.getName());
								System.out.println("Transition Fields Tooltip Value: " + toolTip.getValue());
							}
							System.out.println("Transition Fields CreatedSource: " + field.getCreatedSource());
							if (field.getFieldReadOnly() != null)
							{
								System.out.println("Transition Fields FieldReadOnly: " + field.getFieldReadOnly().toString());
							}
							if (field.getDisplayType() != null)
							{
								System.out.println("Transition Fields DisplayType: " + field.getDisplayType().toString());
							}
							if (field.getReadOnly() != null)
							{
								System.out.println("Transition Fields ReadOnly: " + field.getReadOnly().toString());
							}
							System.out.println("Transition Fields AssociationDetails: " + field.getAssociationDetails());
							if (field.getQuickSequenceNumber() != null)
							{
								System.out.println("Transition Fields QuickSequenceNumber: " + field.getQuickSequenceNumber().toString());
							}
							if (field.getCustomField() != null)
							{
								System.out.println("Transition Fields CustomField: " + field.getCustomField().toString());
							}
							Module lookup = field.getLookup();
							if (lookup != null)
							{
								System.out.println("Field ModuleLookup DisplayLabel: " + lookup.getDisplayLabel());
								System.out.println("Field ModuleLookup APIName: " + lookup.getAPIName());
								System.out.println("Field ModuleLookup Module: " + lookup.getModule());
								if (lookup.getId() != null)
								{
									System.out.println("Field ModuleLookup ID: " + lookup.getId());
								}
							}
							System.out.println("Field Filterable: " + field.getFilterable());
							if (field.getVisible() != null)
							{
								System.out.println("Transition Fields Visible: " + field.getVisible().toString());
							}
							List<Profile> profiles = field.getProfiles();
							if (profiles != null)
							{
								for (Profile profile : profiles)
								{
									System.out.println("Field Profile PermissionType: " + profile.getPermissionType());
									System.out.println("Field Profile Name: " + profile.getName());
									System.out.println("Field Profile Id: " + profile.getId());
								}
							}
							if (field.getFormula() != null)
							{
								if (field.getFormula().getExpression() != null)
								{
									System.out.println("Field Formula Expression :  " + field.getFormula().getExpression());
								}
							}
							if (field.getDecimalPlace() != null)
							{
								System.out.println("Field DecimalPlace: " + field.getDecimalPlace());
							}
							if (field.getLength() != null)
							{
								System.out.println("Transition Fields Length: " + field.getLength().toString());
							}
							System.out.println("Transition Fields DecimalPlace: " + field.getDecimalPlace());
							ViewType viewType = field.getViewType();
							if (viewType != null)
							{
								System.out.println("Transition Fields ViewType View: " + viewType.getView().toString());
								System.out.println("Transition Fields ViewType Edit: " + viewType.getEdit().toString());
								System.out.println("Transition Fields ViewType Create: " + viewType.getCreate().toString());
								System.out.println("Transition Fields ViewType QuickCreate: " + viewType.getQuickCreate().toString());
							}
							List<PickListValue> pickListValues = field.getPickListValues();
							if (pickListValues != null)
							{
								for (PickListValue pickListValue : pickListValues)
								{
									printPickListValue(pickListValue);
								}
							}
							MultiSelectLookup multiSelectLookup = field.getMultiselectlookup();
							if (multiSelectLookup != null)
							{
								System.out.println("Transition Fields MultiSelectLookup DisplayLabel: " + multiSelectLookup.getDisplayLabel());
								System.out.println("Transition Fields MultiSelectLookup LinkingModule: " + multiSelectLookup.getLinkingModule());
								System.out.println("Transition Fields MultiSelectLookup LookupApiname: " + multiSelectLookup.getLookupApiname());
								System.out.println("Transition Fields MultiSelectLookup APIName: " + multiSelectLookup.getAPIName());
								System.out.println("Transition Fields MultiSelectLookup ConnectedlookupApiname: " + multiSelectLookup.getConnectedlookupApiname());
								System.out.println("Transition Fields MultiSelectLookup ID: " + multiSelectLookup.getId());
							}
							com.zoho.crm.api.blueprint.AutoNumber autoNumber = field.getAutoNumber();
							if (autoNumber != null)
							{
								System.out.println("Transition Fields AutoNumber Prefix: " + autoNumber.getPrefix());
								System.out.println("Transition Fields AutoNumber Suffix: " + autoNumber.getSuffix());
								if (autoNumber.getStartNumber() != null)
								{
									System.out.println("Transition Fields Auto StartNumber: " + autoNumber.getStartNumber().toString());
								}
							}
							System.out.println("Transition Fields ConvertMapping: ");
							if (field.getConvertMapping() != null)
							{
								for (Map.Entry<String, Object> entry : field.getConvertMapping().entrySet())
								{
									System.out.println(entry.getKey() + ": ");
									System.out.println(entry.getValue());
								}
							}
						}
						System.out.println("Transition CriteriaMessage: " + transition.getCriteriaMessage());
						System.out.println("Transition PercentPartialSave: " + transition.getPercentPartialSave());
						System.out.println("Transition ExecutionTime: " + transition.getExecutionTime());
						System.out.println("Transition Type: " + transition.getType());
					}
				}
				else if (responseHandler instanceof APIException)
				{
					APIException exception = (APIException) responseHandler;
					System.out.println("Status: " + exception.getStatus().getValue());
					System.out.println("Code: " + exception.getCode().getValue());
					System.out.println("Details: ");
					for (Map.Entry<String, Object> entry : exception.getDetails().entrySet())
					{
						System.out.println(entry.getKey() + ": " + entry.getValue());
					}
					System.out.println("Message: " + exception.getMessage().getValue());
				}
			}
			else
			{
				Model responseObject = response.getModel();
				Class<? extends Model> clas = responseObject.getClass();
				java.lang.reflect.Field[] fields = clas.getDeclaredFields();
				for (java.lang.reflect.Field field : fields)
				{
					field.setAccessible(true);
					System.out.println(field.getName() + ":" + field.get(responseObject));
				}
			}
		}
	}

	public static void printPickListValue(PickListValue pickListValue)
	{
		System.out.println(" Fields PickListValue DisplayValue: " + pickListValue.getDisplayValue());
		System.out.println(" Fields PickListValue SequenceNumber: " + pickListValue.getSequenceNumber().toString());
		System.out.println(" Fields PickListValue ExpectedDataType: " + pickListValue.getExpectedDataType());
		System.out.println(" Fields PickListValue ActualValue: " + pickListValue.getActualValue());
		System.out.println(" Fields PickListValue SysRefName: " + pickListValue.getSysRefName());
		System.out.println(" Fields PickListValue Type: " + pickListValue.getType());
		System.out.println(" Fields PickListValue Id: " + pickListValue.getId());
		for (Maps map : pickListValue.getMaps())
		{
			System.out.println(map);
			List<PickListValue> pickListValues = map.getPickListValues();
			if (pickListValues != null)
			{
				for (PickListValue plv : pickListValues)
				{
					printPickListValue(plv);
				}
			}
		}
	}

	public static void main(String[] args)
	{
		try
		{
			Environment environment = USDataCenter.PRODUCTION;
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").redirectURL("Redirect_URL").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			String moduleAPIName = "Leads";
			String recordId = "3477057";
			getBlueprint(moduleAPIName, recordId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
