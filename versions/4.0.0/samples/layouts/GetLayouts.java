package samples.layouts;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.fields.AssociationDetails;
import com.zoho.crm.api.fields.AutoNumber;
import com.zoho.crm.api.fields.ConnectedDetails;
import com.zoho.crm.api.fields.Crypt;
import com.zoho.crm.api.fields.Currency;
import com.zoho.crm.api.fields.Fields;
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
import com.zoho.crm.api.fields.Multiselectlookup;
import com.zoho.crm.api.fields.PickListValue;
import com.zoho.crm.api.fields.Private;
import com.zoho.crm.api.fields.Unique;
import com.zoho.crm.api.fields.ViewType;
import com.zoho.crm.api.layouts.APIException;
import com.zoho.crm.api.layouts.ConvertMapping;
import com.zoho.crm.api.layouts.DealLayoutMapping;
import com.zoho.crm.api.layouts.DefaultView;
import com.zoho.crm.api.layouts.LayoutsOperations;
import com.zoho.crm.api.layouts.Profiles;
import com.zoho.crm.api.layouts.Properties;
import com.zoho.crm.api.layouts.ResponseHandler;
import com.zoho.crm.api.layouts.ResponseWrapper;
import com.zoho.crm.api.layouts.Sections;
import com.zoho.crm.api.layouts.SectionField;
import com.zoho.crm.api.layouts.Tooltip;
import com.zoho.crm.api.modules.MinifiedModule;
import com.zoho.crm.api.layouts.LayoutsOperations.GetLayoutsParam;
import com.zoho.crm.api.layouts.MinifiedLayout;
import com.zoho.crm.api.users.MinifiedUser;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetLayouts
{
	public static void getLayouts(String moduleAPIName) throws Exception
	{
		LayoutsOperations layoutsOperations = new LayoutsOperations();
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(GetLayoutsParam.MODULE, moduleAPIName);
		APIResponse<ResponseHandler> response = layoutsOperations.getLayouts(paramInstance);
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
					List<com.zoho.crm.api.layouts.Layouts> layouts = responseWrapper.getLayouts();
					for (com.zoho.crm.api.layouts.Layouts layout : layouts)
					{
						if (layout.getCreatedTime() != null)
						{
							System.out.println("Layout CreatedTime: " + layout.getCreatedTime().toString());
						}
						if (layout.getConvertMapping() != null)
						{
							ConvertMapping convertMapping = layout.getConvertMapping();
							MinifiedLayout accounts = convertMapping.getAccounts();
							MinifiedLayout contacts = convertMapping.getContacts();
							DealLayoutMapping deals = convertMapping.getDeals();
						}
						System.out.println("Layout Visible: " + layout.getVisible().toString());
						MinifiedUser createdFor = layout.getCreatedFor();
						if (createdFor != null)
						{
							System.out.println("Layout CreatedFor User-Name: " + createdFor.getName());
							System.out.println("Layout CreatedFor User-ID: " + createdFor.getId());
							System.out.println("Layout CreatedFor User-Email: " + createdFor.getEmail());
						}
						List<Profiles> profiles = layout.getProfiles();
						if (profiles != null)
						{
							for (Profiles profile : profiles)
							{
								System.out.println("Layout Profile Default: " + profile.getDefault().toString());
								System.out.println("Layout Profile Name: " + profile.getName().toString());
								System.out.println("Layout Profile ID: " + profile.getId().toString());
								DefaultView defaultView = profile.getDefaultView();
								if (defaultView != null)
								{
									System.out.println("Layout Profile DefaultView Name: " + defaultView.getName());
									System.out.println("Layout Profile DefaultView ID: " + defaultView.getId());
									System.out.println("Layout Profile DefaultView Type: " + defaultView.getType());
								}
							}
						}
						MinifiedUser createdBy = layout.getCreatedBy();
						if (createdBy != null)
						{
							System.out.println("Layout CreatedBy User-Name: " + createdBy.getName());
							System.out.println("Layout CreatedBy User-ID: " + createdBy.getId());
							System.out.println("Layout CreatedBy User-Email: " + createdBy.getEmail());
						}
						List<Sections> sections = layout.getSections();
						if (sections != null)
						{
							for (Sections section : sections)
							{
								System.out.println("Layout Section DisplayLabel: " + section.getDisplayLabel());
								System.out.println("Layout Section SequenceNumber: " + section.getSequenceNumber().toString());
								System.out.println("Layout Section IsSubformSection: " + section.getIssubformsection().toString());
								System.out.println("Layout Section TabTraversal: " + section.getTabTraversal().toString());
								System.out.println("Layout Section APIName: " + section.getAPIName());
								System.out.println("Layout Section ColumnCount: " + section.getColumnCount().toString());
								System.out.println("Layout Section Name: " + section.getName());
								System.out.println("Layout Section GeneratedType: " + section.getGeneratedType());
								System.out.println("Layout Section Type: " + section.getType());
								List<SectionField> fields = section.getFields();
								if (fields != null)
								{
									for (Fields field : fields)
									{
										printField(field);
									}
								}
								Properties properties = section.getProperties();
								if (properties != null)
								{
									System.out.println("Layout Section Properties ReorderRows: " + properties.getReorderRows().toString());
									Tooltip tooltip = properties.getTooltip();
									if (tooltip != null)
									{
										System.out.println("Layout Section Properties ToolTip Name:" + tooltip.getName().toString());
										System.out.println("Layout Section Properties ToolTip Value:" + tooltip.getValue().toString());
									}
									System.out.println("Layout Section Properties MaximumRows: " + properties.getMaximumRows().toString());
								}
							}
						}
						System.out.println("Layout buisness card: " + layout.getShowBusinessCard());
						if (layout.getModifiedTime() != null)
						{
							System.out.println("Layout ModifiedTime: " + layout.getModifiedTime().toString());
						}
						System.out.println("Layout Name: " + layout.getName());
						MinifiedUser modifiedBy = layout.getModifiedBy();
						if (modifiedBy != null)
						{
							System.out.println("Layout ModifiedBy User-Name: " + modifiedBy.getName());
							System.out.println("Layout ModifiedBy User-ID: " + modifiedBy.getId());
							System.out.println("Layout ModifiedBy User-Email: " + modifiedBy.getEmail());
						}
						System.out.println("Layout ID: " + layout.getId());
						System.out.println("Layout Status: " + layout.getStatus());
						System.out.println("Layout DisplayType : " + layout.getDisplayType());
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

	private static void printField(Fields field)
	{
		System.out.println("Field SystemMandatory: " + field.getSystemMandatory().toString());
		System.out.println("Field Webhook: " + field.getWebhook().toString());
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
		com.zoho.crm.api.fields.Tooltip tooltip = field.getTooltip();
		if (tooltip != null)
		{
			System.out.println("Field ToolTip Name: " + tooltip.getName());
			System.out.println("Field ToolTip Value: " + tooltip.getValue());
		}
		System.out.println("Field CreatedSource: " + field.getCreatedSource());
		System.out.println("Field FieldReadOnly: " + field.getFieldReadOnly().toString());
		System.out.println("Field DisplayLabel: " + field.getDisplayLabel());
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
		System.out.println("Field Filterable: " + field.getFilterable());
		if (field.getConvertMapping() != null)
		{
			if (field.getConvertMapping() != null)
			{
				com.zoho.crm.api.fields.ConvertMapping convertMapping = field.getConvertMapping();
				System.out.println(convertMapping.getAccounts());
				System.out.println(convertMapping.getContacts());
				System.out.println(convertMapping.getDeals());
			}
		}
		if (field.getHistoryTracking() != null)
		{
			HistoryTracking historytracking = field.getHistoryTracking();
			HistoryTrackingModule module = historytracking.getModule();
			if (module != null)
			{
				com.zoho.crm.api.layouts.Layouts moduleLayout = module.getLayout();
				if (moduleLayout != null)
				{
					System.out.println("Module layout id" + moduleLayout.getId());
				}
				System.out.println("Module layout display label" + module.getDisplayLabel());
				System.out.println("Module layout api name" + module.getAPIName());
				System.out.println("Module layout module" + module.getId());
				System.out.println("Module layout id" + module.getModule());
				System.out.println("Module layout module name" + module.getModuleName());
			}
			MinifiedModule durationConfigured = historytracking.getDurationConfiguredField();
			if (durationConfigured != null)
			{
				System.out.println("historytracking duration configured field" + durationConfigured.getId());
			}
		}
		System.out.println("Field BusinesscardSupported: " + field.getBusinesscardSupported());
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
			System.out.println("Field CustomField: " + field.getCustomField());
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
		if (field.getVisible() != null)
		{
			System.out.println("Field Visible: " + field.getVisible().toString());
		}
		if (field.getPickListValuesSortedLexically() != null)
		{
			System.out.println("Field pick list values lexically sorted: " + field.getPickListValuesSortedLexically());
		}
		if (field.getSortable() != null)
		{
			System.out.println("Field sortable " + field.getSortable());
		}
		if (field.getUiType() != null)
		{
			System.out.println("Field UI tyle " + field.getUiType());
		}
		if (field.getSequenceNumber() != null)
		{
			System.out.println("Field sequence number " + field.getSequenceNumber());
		}
		List<com.zoho.crm.api.fields.Profile> fieldProfiles = field.getProfiles();
		for (com.zoho.crm.api.fields.Profile fieldProfile : fieldProfiles)
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
		MinifiedModule subform = field.getAssociatedModule();
		if (subform != null)
		{
			System.out.println("Field Subform Module: " + subform.getModule());
			System.out.println("Field Subform ID: " + subform.getId().toString());
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
		System.out.println("Field MassUpdate: " + field.getMassUpdate());
		if (field.getBlueprintSupported() != null)
		{
			System.out.println("Field BlueprintSupported: " + field.getBlueprintSupported());
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
			if(layouts != null)
			{
				for(LookupLayout layout : layouts)
				{
					System.out.println("Field MultiSelectLookup ConnectedDetails Layouts APIName: " + layout.getAPIName());
					System.out.println("Field MultiSelectLookup ConnectedDetails Layouts Id: " + layout.getId());
				}
			}
			
			LookupRelatedList relatedList = multiSelectLookup.getRelatedList();
			if(relatedList != null)
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
		if (field.getDisplayType() != null)
		{
			System.out.println("Field display type : " + field.getDisplayType().toString());
		}
		System.out.println("Get field type" + field.getType());
		if (field.getExternal() != null)
		{
			System.out.println("Get External show " + field.getExternal().getShow());
			System.out.println("Get External type" + field.getExternal().getType());
			System.out.println("allow multiple config" + field.getExternal().getAllowMultipleConfig());
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
					System.out.println(plv);
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
			getLayouts(moduleAPIName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
