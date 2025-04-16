package samples.fields;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.fields.APIException;
import com.zoho.crm.api.fields.ActionHandler;
import com.zoho.crm.api.fields.ActionResponse;
import com.zoho.crm.api.fields.ActionWrapper;
import com.zoho.crm.api.fields.BodyWrapper;
import com.zoho.crm.api.fields.Criteria;
import com.zoho.crm.api.fields.Crypt;
import com.zoho.crm.api.fields.Expression;
import com.zoho.crm.api.fields.External;
import com.zoho.crm.api.fields.Fields;
import com.zoho.crm.api.fields.FieldsOperations;
import com.zoho.crm.api.fields.FieldsOperations.CreateFieldParam;
import com.zoho.crm.api.fields.ForecastCategory;
import com.zoho.crm.api.fields.FunctionParameter;
import com.zoho.crm.api.fields.MinifiedField;
import com.zoho.crm.api.fields.PickListValue;
import com.zoho.crm.api.fields.Profile;
import com.zoho.crm.api.fields.RollupSummary;
import com.zoho.crm.api.fields.SuccessResponse;
import com.zoho.crm.api.fields.Tooltip;
import com.zoho.crm.api.fields.Unique;
import com.zoho.crm.api.modules.MinifiedModule;
import com.zoho.crm.api.relatedlists.RelatedList;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class UpdateField
{
	public static void updateField(String moduleAPIName, Long fieldId) throws Exception
	{
		FieldsOperations fieldsOperations = new FieldsOperations();
		BodyWrapper bodyWrapper = new BodyWrapper();
		List<Fields> fields = new ArrayList<Fields>();
		
		/**Sample Input: Field Type - Text*/
		Fields field = new Fields();
		field.setFieldLabel("SDK");
		field.setDisplayLabel("SDK");
		field.setDataType("text");
		field.setLength(180);
		Tooltip toolTip = new Tooltip();
		toolTip.setName("static_text");
		toolTip.setValue("Enter your name");
		field.setTooltip(toolTip);
		Unique unique = new Unique();
		unique.setCasesensitive("false");
		field.setUnique(unique);
		Crypt crypt = new Crypt();
		crypt.setMode("decryption");
		field.setCrypt(crypt);
		External external = new External();
		external.setType("user");
		external.setShow(true);
		field.setExternal(external);
		List<Profile> profiles = new ArrayList<Profile>();
		Profile profile = new Profile();
		profile.setId(34770610026014l);
		profile.setPermissionType("read_write");
		profiles.add(profile);
		field.setProfiles(profiles);
		fields.add(field);
		/** end*/
		
		/**Sample Input: Field Type - Picklist */
		Fields picklistfield = new Fields();
		picklistfield.setFieldLabel("Select Region5");
		picklistfield.setDataType("picklist");
		Tooltip toolTip1 = new Tooltip();
		toolTip1.setName("info_icon");
		toolTip1.setValue("Select your region here");
		picklistfield.setTooltip(toolTip1);
		picklistfield.setLength(120);
		List<Profile> picklistfieldprofiles = new ArrayList<Profile>();
		Profile profile1 = new Profile();
		profile1.setId(753477395001l);
		profile1.setPermissionType("read_write");
		picklistfieldprofiles.add(profile1);
		
		List<PickListValue> picklistvalues = new ArrayList<PickListValue>();
		
		// Sample for adding picklist values to picklist field.
		PickListValue picklistvalue = new PickListValue();
		picklistvalue = new PickListValue();
		picklistvalue.setDisplayValue("Left");
		picklistvalue.setActualValue("IN_Left");
		picklistvalues.add(picklistvalue);
		
		picklistvalue = new PickListValue();
		picklistvalue.setDisplayValue("Top");
		picklistvalue.setActualValue("IN_Top");
		picklistvalues.add(picklistvalue);
		
		picklistvalue = new PickListValue();
		picklistvalue.setDisplayValue("Down");
		picklistvalue.setActualValue("IN_Down");
		picklistvalues.add(picklistvalue);
		
		// Sample for updating the picklistvalue in picklist field.
		PickListValue picklistvalue1 = new PickListValue();
		picklistvalue1.setDisplayValue("South_Updated");
		picklistvalue1.setActualValue("IN_South");
		picklistvalue1.setId(75347706075l);
		picklistvalues.add(picklistvalue1);
		
		// Sample for removing the picklist value from picklist field.
		PickListValue picklistvalue2 = new PickListValue();
		picklistvalue2.setDisplayValue("West");
		picklistvalue2.setActualValue("IN_West");
		picklistvalue2.setId(7534776071l);
		picklistvalue2.setDelete(true);
		picklistvalues.add(picklistvalue2);
		picklistfield.setPickListValues(picklistvalues);
		fields.add(picklistfield);
		/** end */
		
		Fields stagepicklistfield = new Fields();
		stagepicklistfield.setFieldLabel("Stage");
		stagepicklistfield.setDataType("picklist");
		Tooltip stageToolTip = new Tooltip();
		stageToolTip.setName("info_icon");
		stageToolTip.setValue("Select your deals stage here");
		stagepicklistfield.setTooltip(stageToolTip);
		stagepicklistfield.setLength(120);
		List<Profile> stagepicklistfieldprofiles = new ArrayList<Profile>();
		Profile stageProfile1 = new Profile();
		stageProfile1.setId(347726011l);
		stageProfile1.setPermissionType("read_write");
		stagepicklistfieldprofiles.add(stageProfile1);
		stagepicklistfield.setProfiles(stagepicklistfieldprofiles);
		
		List<PickListValue> stagepicklistvalues = new ArrayList<PickListValue>();
		
		// Update Sample for Deals Stage field picklist.
		// Note: Please add the all picklist actual_value and id.
		PickListValue stagePickList = new PickListValue();
		stagePickList.setDisplayValue("Qualification");
		stagePickList.setSequenceNumber(1);
		stagePickList.setDealCategory("Open");
		stagePickList.setReferenceValue("Qualification");
		stagePickList.setProbability(15);
		ForecastCategory forecastCategory = new ForecastCategory();
		forecastCategory.setName("Pipeline");
		forecastCategory.setId(3477006787l);
		stagePickList.setForecastCategory(forecastCategory);
		stagePickList.setActualValue("Qualification");
		stagePickList.setId(3477066801l);
		stagePickList.setForecastType("Open");
		stagePickList.setType(new Choice<String>("used"));
		stagepicklistvalues.add(stagePickList);
		
		stagepicklistfield.setPickListValues(stagepicklistvalues);
		
		stagepicklistfield.setPickListValuesSortedLexically(true);
		stagepicklistfield.setEnableColourCode(true);
		fields.add(stagepicklistfield);
		
		Fields rollupSummaryField = new Fields();
		rollupSummaryField.setFieldLabel("Total");
		rollupSummaryField.setDataType("rollup_summary");
		RollupSummary rollupSummary = new RollupSummary();
		rollupSummary.setReturnType("currency");
		Expression expression = new Expression();
		FunctionParameter functionParameter = new FunctionParameter();
		functionParameter.setAPIName("Total");
		expression.setFunctionParameters(new ArrayList<>(Arrays.asList(functionParameter)));
		Criteria criteria = new Criteria();
		criteria.setComparator("AND");
		List<Criteria> group = new ArrayList<>();
		
		Criteria groupCriteria1 = new Criteria();
		groupCriteria1.setComparator("equal");
		MinifiedField groupCriteria1Field = new MinifiedField();
		groupCriteria1Field.setAPIName("Billing_Country");
		groupCriteria1.setValue("United States");
		groupCriteria1.setField(groupCriteria1Field);
		group.add(groupCriteria1);
		
		Criteria groupCriteria2 = new Criteria();
		groupCriteria2.setComparator("greater_than");
		MinifiedField groupCriteria2Field = new MinifiedField();
		groupCriteria2Field.setAPIName("Invoice_Date");
		groupCriteria2.setValue("2024-11-27");
		groupCriteria2.setField(groupCriteria2Field);
		group.add(groupCriteria2);
		
		criteria.setGroup(group);
		expression.setCriteria(criteria);
		expression.setFunction("SUM");
		
		MinifiedModule basedOnModule = new MinifiedModule();
		basedOnModule.setAPIName("Invoices");
		rollupSummary.setBasedOnModule(basedOnModule);
		
		RelatedList relatedList = new RelatedList();
		relatedList.setAPIName("Invoices");
		rollupSummary.setRelatedList(relatedList);
		
		rollupSummary.setExpression(expression);
		rollupSummaryField.setRollupSummary(rollupSummary);
		fields.add(rollupSummaryField);
		
		bodyWrapper.setFields(fields);
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(CreateFieldParam.MODULE, moduleAPIName);
		APIResponse<ActionHandler> response = fieldsOperations.updateField(fieldId, bodyWrapper, paramInstance);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ActionWrapper)
				{
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
					List<ActionResponse> actionResponses = actionWrapper.getFields();
					for (ActionResponse actionResponse : actionResponses)
					{
						if (actionResponse instanceof SuccessResponse)
						{
							SuccessResponse successResponse = (SuccessResponse) actionResponse;
							System.out.println("Status: " + successResponse.getStatus().getValue());
							System.out.println("Code: " + successResponse.getCode().getValue());
							System.out.println("Details: ");
							for (Map.Entry<String, Object> entry : successResponse.getDetails().entrySet())
							{
								System.out.println(entry.getKey() + ": " + entry.getValue());
							}
							System.out.println("Message: " + successResponse.getMessage());
						}
						else if (actionResponse instanceof APIException)
						{
							APIException exception = (APIException) actionResponse;
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
				}
				else if (actionHandler instanceof APIException)
				{
					APIException exception = (APIException) actionHandler;
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
				Field[] fields1 = clas.getDeclaredFields();
				for (Field field1 : fields1)
				{
					field1.setAccessible(true);
					System.out.println(field1.getName() + ":" + field1.get(responseObject));
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
			String moduleAPIName = "Invoices";
			Long fieldId = 347702565l;
			updateField(moduleAPIName, fieldId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}