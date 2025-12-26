package samples.fields;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.fields.APIException;
import com.zoho.crm.api.fields.AssociationDetails;
import com.zoho.crm.api.fields.AutoNumber;
import com.zoho.crm.api.fields.ConnectedDetails;
import com.zoho.crm.api.fields.ResponseWrapper;
import com.zoho.crm.api.fields.ConvertMapping;
import com.zoho.crm.api.fields.Crypt;
import com.zoho.crm.api.fields.Currency;
import com.zoho.crm.api.fields.Fields;
import com.zoho.crm.api.fields.FieldsOperations;
import com.zoho.crm.api.fields.FieldsOperations.GetFieldsParam;
import com.zoho.crm.api.fields.Formula;
import com.zoho.crm.api.fields.HistoryTracking;
import com.zoho.crm.api.fields.HistoryTrackingModule;
import com.zoho.crm.api.fields.LinkingDetails;
import com.zoho.crm.api.fields.LinkingModule;
import com.zoho.crm.api.fields.Lookup;
import com.zoho.crm.api.fields.LookupField;
import com.zoho.crm.api.fields.LookupLayout;
import com.zoho.crm.api.fields.LookupRelatedList;
import com.zoho.crm.api.fields.Maps;
import com.zoho.crm.api.fields.MultiModuleLookup;
import com.zoho.crm.api.fields.Multiselectlookup;
import com.zoho.crm.api.fields.OperationType;
import com.zoho.crm.api.fields.PickListValue;
import com.zoho.crm.api.fields.Private;
import com.zoho.crm.api.fields.Profile;
import com.zoho.crm.api.fields.ResponseHandler;
import com.zoho.crm.api.fields.Tooltip;
import com.zoho.crm.api.fields.Unique;
import com.zoho.crm.api.fields.ViewType;
import com.zoho.crm.api.globalpicklists.Picklist;
import com.zoho.crm.api.layouts.Layouts;
import com.zoho.crm.api.modules.MinifiedModule;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetField
{
	public static void getField(String moduleAPIName, Long fieldId) throws Exception
	{
		FieldsOperations fieldOperations = new FieldsOperations();
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(GetFieldsParam.MODULE, moduleAPIName);
		APIResponse<ResponseHandler> response = fieldOperations.getField(fieldId, paramInstance);
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
					List<Fields> fields = responseWrapper.getFields();
					for (Fields field : fields)
					{
						System.out.println("Field SystemMandatory: " + field.getSystemMandatory().toString());
						System.out.println("Field Webhook: " + field.getWebhook().toString());
						OperationType operationType = field.getOperationType();
						if(operationType != null)
						{
							System.out.println("Field OperationType WebUpdate: " + operationType.getWebUpdate());
							System.out.println("Field OperationType APICreate: " + operationType.getAPICreate());
							System.out.println("Field OperationType WebCreate: " + operationType.getWebCreate());
							System.out.println("Field OperationType APIUpdate: " + operationType.getAPIUpdate());
						}
						System.out.println("Field JsonType: " + field.getJsonType());
						Private privateInfo = field.getPrivate();
						if (privateInfo != null)
						{
							System.out.println("Private Details");
							System.out.println("Field Private Type: " + privateInfo.getType());
							System.out.println("Field Private Export: " + privateInfo.getExport());
							System.out.println("Field Private Restricted: " + privateInfo.getRestricted());
						}
						Crypt crypt = field.getCrypt();
						if (crypt != null)
						{
							System.out.println("Field Crypt Mode: " + crypt.getMode());
							System.out.println("Field Crypt Column: " + crypt.getColumn());
							System.out.println("Field Crypt Table: " + crypt.getTable());
							System.out.println("Field Crypt Status: " + crypt.getStatus().toString());
							List<String> encFldIds = crypt.getEncfldids();
							if (encFldIds != null)
							{
								System.out.println("EncFldIds : ");
								for (String encFldId : encFldIds)
								{
									System.out.println(encFldId);
								}
							}
							System.out.println("Field Crypt Notify: " + crypt.getNotify());
						}
						System.out.println("Field FieldLabel: " + field.getFieldLabel());
						Tooltip tooltip = field.getTooltip();
						if (tooltip != null)
						{
							System.out.println("Field ToolTip Name: " + tooltip.getName());
							System.out.println("Field ToolTip Value: " + tooltip.getValue());
						}
						System.out.println("Field CreatedSource: " + field.getCreatedSource());
						System.out.println("Field Type :" + field.getType());
						System.out.println("Field FieldReadOnly: " + field.getFieldReadOnly().toString());
						System.out.println("Field DisplayLabel: " + field.getDisplayLabel());
						if (field.getDisplayType() != null)
						{
							System.out.println("Field DisplayType : " + field.getDisplayType().toString());
						}
						if (field.getUiType() != null)
						{
							// get UI type of field
							System.out.println("Field UI Type " + field.getUiType());
						}
						System.out.println("Field ReadOnly: " + field.getReadOnly().toString());
						AssociationDetails associationDetails = field.getAssociationDetails();
						if (associationDetails != null)
						{
							LookupField lookupField = associationDetails.getLookupField();
							if (lookupField != null)
							{
								System.out.println("Field AssociationDetails LookupField ID: " + lookupField.getId());
								System.out.println("Field AssociationDetails LookupField Name: " + lookupField.getAPIName());
							}
							LookupField relatedField = associationDetails.getRelatedField();
							if (relatedField != null)
							{
								System.out.println("Field AssociationDetails RelatedField ID: " + relatedField.getId());
								System.out.println("Field AssociationDetails RelatedField Name: " + relatedField.getAPIName());
							}
						}
						if (field.getQuickSequenceNumber() != null)
						{
							System.out.println("Field QuickSequenceNumber: " + field.getQuickSequenceNumber().toString());
						}
						System.out.println("Field BusinesscardSupported: " + field.getBusinesscardSupported().toString());
						MultiModuleLookup multiModuleLookup = field.getMultiModuleLookup();
						if (multiModuleLookup != null)
						{
							System.out.println("Field MultiModuleLookup APIName: " + multiModuleLookup.getAPIName());
							System.out.println("Field MultiModuleLookup DisplayLabel: " + multiModuleLookup.getDisplayLabel());
							for (MinifiedModule module : multiModuleLookup.getModules())
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
								System.out.println("Field Currency Precision: " + currency.getPrecision().toString());
							}
						}
						System.out.println("Field ID: " + field.getId().toString());
						if (field.getCustomField() != null)
						{
							System.out.println("Field CustomField: " + field.getCustomField().toString());
						}
						Lookup lookup = field.getLookup();
						if (lookup != null)
						{
							System.out.println("Field ModuleLookup DisplayLabel: " + lookup.getDisplayLabel());
							System.out.println("Field ModuleLookup APIName: " + lookup.getAPIName());
							System.out.println("Field ModuleLookup Module: " + lookup.getModule());
							if (lookup.getId() != null)
							{
								System.out.println("Field ModuleLookup ID: " + lookup.getId().toString());
							}
						}
						System.out.println("Field Filterable: " + field.getFilterable());
						if (field.getVisible() != null)
						{
							System.out.println("Field Visible: " + field.getVisible().toString());
						}
						List<Profile> fieldProfiles = field.getProfiles();
						for (Profile fieldProfile : fieldProfiles)
						{
							System.out.println("Profile permission Type " + fieldProfile.getPermissionType());
							System.out.println("Profile Name  " + fieldProfile.getName());
							System.out.println("Profile ID  " + fieldProfile.getId());
						}
						if (field.getLength() != null)
						{
							System.out.println("Field Length: " + field.getLength().toString());
						}
						ViewType viewType = field.getViewType();
						if (viewType != null)
						{
							System.out.println("Field ViewType View: " + viewType.getView().toString());
							System.out.println("Field ViewType Edit: " + viewType.getEdit().toString());
							System.out.println("Field ViewType Create: " + viewType.getCreate().toString());
							System.out.println("Field ViewType QuickCreate: " + viewType.getQuickCreate().toString());
						}
						if (field.getDisplayField() != null)
						{
							System.out.println("Field DisplayField " + field.getDisplayField());
						}
						if (field.getPickListValuesSortedLexically() != null)
						{
							System.out.println("Field pick list values lexically sorted: " + field.getPickListValuesSortedLexically());
						}
						if (field.getSortable() != null)
						{
							System.out.println("Field sortable " + field.getSortable());
						}
						MinifiedModule subform = field.getAssociatedModule();
						if (subform != null)
						{
							System.out.println("Field Subform Module: " + subform.getModule());
							System.out.println("Field Subform ID: " + subform.getId().toString());
						}
						if (field.getExternal() != null)
						{
							System.out.println("Get External show " + field.getExternal().getShow());
							System.out.println("Get External type" + field.getExternal().getType());
							System.out.println("allow multiple config" + field.getExternal().getAllowMultipleConfig());
						}
						System.out.println("Field APIName: " + field.getAPIName().toString());
						Object unique1 = field.getUnique();
						if (unique1 != null)
						{
							if (unique1 instanceof Unique)
							{
								Unique unique = (Unique) unique1;
								System.out.println("Field Unique Casesensitive : " + unique.getCasesensitive());
							}
							else
							{
								System.out.println("Field Unique : " + unique1.toString());
							}
						}
						if (field.getHistoryTracking() != null)
						{
							HistoryTracking historytracking = field.getHistoryTracking();
							HistoryTrackingModule module = historytracking.getModule();
							if (module != null)
							{
								Layouts moduleLayout = module.getLayout();
								if (moduleLayout != null)
								{
									System.out.println("Module layout id" + moduleLayout.getId());
								}
								System.out.println("Module  display label" + module.getDisplayLabel());
								System.out.println("Module  api name" + module.getAPIName());
								System.out.println("Module  id" + module.getId());
								System.out.println("Module  module" + module.getModule());
								System.out.println("Module  module name" + module.getModuleName());
							}
							MinifiedModule durationConfigured = historytracking.getDurationConfiguredField();
							if (durationConfigured != null)
							{
								System.out.println("historytracking duration configured field" + durationConfigured.getId());
							}
						}
						System.out.println("Field DataType: " + field.getDataType().toString());
						Formula formula = field.getFormula();
						if (formula != null)
						{
							System.out.println("Field Formula ReturnType : " + formula.getReturnType());
							if (formula.getExpression() != null)
							{
								System.out.println("Field Formula Expression : " + formula.getExpression().toString());
							}
						}
						if (field.getDecimalPlace() != null)
						{
							System.out.println("Field DecimalPlace: " + field.getDecimalPlace().toString());
						}
						System.out.println("Field MassUpdate: " + field.getMassUpdate().toString());
						if (field.getBlueprintSupported() != null)
						{
							System.out.println("Field BlueprintSupported: " + field.getBlueprintSupported().toString());
						}
						Multiselectlookup multiSelectLookup = field.getMultiselectlookup();
						if (multiSelectLookup != null)
						{
							LinkingDetails linkingDetails = multiSelectLookup.getLinkingDetails();
							LinkingModule module = linkingDetails.getModule();
							System.out.println("Field Multiselectlookup LinkingDetails Module Visibility: " + module.getVisibility());
							System.out.println("Field Multiselectlookup LinkingDetails Module PluralLabel: " + module.getPluralLabel());
							System.out.println("Field Multiselectlookup LinkingDetails Module APIName: " + module.getAPIName());
							System.out.println("Field Multiselectlookup LinkingDetails Module Id: " + module.getId());

							LookupField lookupfield = linkingDetails.getLookupField();
							System.out.println("Field MultiSelectLookup LinkingDetails LookupField APIName: " + lookupfield.getAPIName());
							System.out.println("Field MultiSelectLookup LinkingDetails LookupField FieldLabel: " + lookupfield.getFieldLabel());
							System.out.println("Field MultiSelectLookup LinkingDetails LookupField Id: " + lookupfield.getId());

							LookupField connectedLookupField = linkingDetails.getConnectedLookupField();
							System.out.println("Field MultiSelectLookup LinkingDetails ConnectedLookupField APIName: " + connectedLookupField.getAPIName());
							System.out.println("Field MultiSelectLookup LinkingDetails ConnectedLookupField FieldLabel: " + connectedLookupField.getFieldLabel());
							System.out.println("Field MultiSelectLookup LinkingDetails ConnectedLookupField Id: " + connectedLookupField.getId());

							ConnectedDetails connectedDetails = multiSelectLookup.getConnectedDetails();
							LookupField lookupField = connectedDetails.getField();
							System.out.println("Field Multiselectlookup ConnectedDetails Field APIName: " + lookupField.getAPIName());
							System.out.println("Field Multiselectlookup ConnectedDetails Field FieldLabel: " + lookupField.getFieldLabel());
							System.out.println("Field Multiselectlookup ConnectedDetails Field id: " + lookupField.getId());

							LinkingModule connectedModule = connectedDetails.getModule();
							System.out.println("Field MultiSelectLookup ConnectedDetails Module PluralLabel: " + connectedModule.getPluralLabel());
							System.out.println("Field MultiSelectLookup ConnectedDetails Module APIName: " + connectedModule.getAPIName());
							System.out.println("Field MultiSelectLookup ConnectedDetails Module Id: " + connectedModule.getId());

							List<LookupLayout> layouts = connectedDetails.getLayouts();
							if (layouts != null)
							{
								for (LookupLayout layout : layouts)
								{
									System.out.println("Field MultiSelectLookup ConnectedDetails Layouts APIName: " + layout.getAPIName());
									System.out.println("Field MultiSelectLookup ConnectedDetails Layouts Id: " + layout.getId());
								}
							}

							LookupRelatedList relatedList = multiSelectLookup.getRelatedList();
							if (relatedList != null)
							{
								System.out.println("Field MultiSelectLookup RelatedList DisplayLabel: " + relatedList.getDisplayLabel());
								System.out.println("Field MultiSelectLookup RelatedList APIName: " + relatedList.getAPIName());
								System.out.println("Field MultiSelectLookup RelatedList Id: " + relatedList.getId());
							}
						}
						List<PickListValue> pickListValues = field.getPickListValues();
						if (pickListValues != null)
						{
							for (PickListValue pickListValue : pickListValues)
							{
								printPickListValue(pickListValue);
							}
						}
						if (field.getConvertMapping() != null)
						{
							ConvertMapping convertMapping = field.getConvertMapping();
							System.out.println(convertMapping.getAccounts());
							System.out.println(convertMapping.getContacts());
							System.out.println(convertMapping.getDeals());
						}
						if (field.getSequenceNumber() != null)
						{
							System.out.println("Field sequence number " + field.getSequenceNumber());
						}
						if (field.getHistoryTracking() != null)
						{
							System.out.println("Field HistoryTracking: " + field.getHistoryTracking().toString());
						}
						AutoNumber autoNumber = field.getAutoNumber61();
						if (autoNumber != null)
						{
							System.out.println("Field AutoNumber Prefix: " + autoNumber.getPrefix());
							System.out.println("Field AutoNumber Suffix: " + autoNumber.getSuffix());
							if (autoNumber.getStartNumber() != null)
							{
								System.out.println("Field AutoNumber StartNumber: " + autoNumber.getStartNumber().toString());
							}
						}
						if (field.getDefaultValue() != null)
						{
							System.out.println("Field DefaultValue: " + field.getDefaultValue().toString());
						}
						if (field.getMultiuserlookup() != null)
						{
							Multiselectlookup multiuserlookup = field.getMultiuserlookup();
							LinkingDetails linkingDetails = multiuserlookup.getLinkingDetails();
							LinkingModule module = linkingDetails.getModule();
							System.out.println("Field Multiuserlookup LinkingDetails Module Visibility: " + module.getVisibility());
							System.out.println("Field Multiuserlookup LinkingDetails Module PluralLabel: " + module.getPluralLabel());
							System.out.println("Field Multiuserlookup LinkingDetails Module APIName: " + module.getAPIName());
							System.out.println("Field Multiuserlookup LinkingDetails Module Id: " + module.getId());

							LookupField lookupfield = linkingDetails.getLookupField();
							System.out.println("Field Multiuserlookup LinkingDetails LookupField APIName: " + lookupfield.getAPIName());
							System.out.println("Field Multiuserlookup LinkingDetails LookupField FieldLabel: " + lookupfield.getFieldLabel());
							System.out.println("Field Multiuserlookup LinkingDetails LookupField Id: " + lookupfield.getId());

							LookupField connectedLookupField = linkingDetails.getConnectedLookupField();
							System.out.println("Field Multiuserlookup LinkingDetails ConnectedLookupField APIName: " + connectedLookupField.getAPIName());
							System.out.println("Field Multiuserlookup LinkingDetails ConnectedLookupField FieldLabel: " + connectedLookupField.getFieldLabel());
							System.out.println("Field Multiuserlookup LinkingDetails ConnectedLookupField Id: " + connectedLookupField.getId());

							System.out.println("Field Multiuserlookup RecordAccess: " + multiuserlookup.getRecordAccess());
						}
						Picklist globalPicklist = field.getGlobalPicklist();
						if (globalPicklist != null)
						{
							System.out.println("Fields GlobalPicklist Id: " + globalPicklist.getId());
							System.out.println("Fields GlobalPicklist APIName: " + globalPicklist.getAPIName());
						}
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
					System.out.println("Message: " + exception.getMessage());
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
		System.out.println(" Fields PickListValue Probability: " + pickListValue.getProbability());
		System.out.println(" Fields PickListValue ForecastCategory: " + pickListValue.getForecastCategory());
		System.out.println(" Fields PickListValue SequenceNumber: " + pickListValue.getSequenceNumber());
		System.out.println(" Fields PickListValue ExpectedDataType: " + pickListValue.getExpectedDataType());
		System.out.println(" Fields PickListValue ActualValue: " + pickListValue.getActualValue());
		System.out.println(" Fields PickListValue SysRefName: " + pickListValue.getSysRefName());
		System.out.println(" Fields PickListValue Type: " + pickListValue.getType());
		System.out.println(" Fields PickListValue Id: " + pickListValue.getId());
		System.out.println(" Fields PickListValue ForecastType: " + pickListValue.getForecastType());
		Picklist globalPicklist = pickListValue.getGlobalPicklistValue();
		if (globalPicklist != null)
		{
			System.out.println("Fields GlobalPicklistValue Id: " + globalPicklist.getId());
			System.out.println("Fields GlobalPicklistValue APIName: " + globalPicklist.getAPIName());
		}
		if (pickListValue.getMaps() != null)
		{
			for (Maps map : pickListValue.getMaps())
			{
				System.out.println(map);
				List<PickListValue> pickListValues = map.getPickListValues();
				if (pickListValues != null)
				{
					for (PickListValue pickListValue1 : pickListValues)
					{
						printPickListValue(pickListValue1);
					}
				}
			}
		}
	}

	public static void main(String[] args)
	{
		try
		{
			Environment environment = USDataCenter.PRODUCTION;
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			String moduleAPIName = "Leads";
			Long fieldId = 181292626l;
			getField(moduleAPIName, fieldId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
