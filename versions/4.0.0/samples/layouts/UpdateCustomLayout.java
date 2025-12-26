package samples.layouts;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.fields.PickListValue;
import com.zoho.crm.api.layouts.APIException;
import com.zoho.crm.api.layouts.ActionHandler;
import com.zoho.crm.api.layouts.ActionResponse;
import com.zoho.crm.api.layouts.ActionWrapper;
import com.zoho.crm.api.layouts.BodyWrapper;
import com.zoho.crm.api.layouts.Delete1;
import com.zoho.crm.api.layouts.Layouts;
import com.zoho.crm.api.layouts.LayoutsOperations;
import com.zoho.crm.api.layouts.SuccessResponse;
import com.zoho.crm.api.layouts.LayoutsOperations.UpdateCustomLayoutParam;
import com.zoho.crm.api.layouts.SectionField;
import com.zoho.crm.api.layouts.Sections;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class UpdateCustomLayout
{
	public static void updateCustomLayouts(Long id, String moduleAPIName) throws Exception
	{
		LayoutsOperations layoutsOperations = new LayoutsOperations();
		 BodyWrapper request = new BodyWrapper();
		List<Layouts> layouts = new ArrayList<Layouts>();
		Layouts layout = new Layouts();
		
		List<Sections> sections = new ArrayList<Sections>();
		Sections section = new Sections();
		section.setId(34770447317l);
		List<SectionField> sectionFields = new ArrayList<SectionField>();
		
		SectionField sectionField = new SectionField();
		sectionField.setFieldLabel("JAVASDK");
		sectionField.setDataType("boolean");
		sectionFields.add(sectionField);
		
		sectionField = new SectionField();
		sectionField.setId(34778447113l);
		sectionField.setFieldLabel("Subform123");
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
		
		sectionField.setPickListValues(picklistvalues);
		sectionFields.add(sectionField);
		
		sectionField = new SectionField();
		sectionField.setId(34770447113l);
		Delete1 delete = new Delete1();
		delete.setPermanent(false);
		sectionField.setDelete(delete);
		sectionFields.add(sectionField);
		
		section.setFields(sectionFields);
		sections.add(section);
		
		layout.setSections(sections);
		layouts.add(layout);
		
		request.setLayouts(layouts);
		
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(UpdateCustomLayoutParam.MODULE, moduleAPIName);
		APIResponse<ActionHandler> response = layoutsOperations.updateCustomLayout(id, request, paramInstance);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ActionWrapper)
				{
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
					List<ActionResponse> actionResponses = actionWrapper.getLayouts();
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
					if (exception.getDetails() != null)
					{
						for (Map.Entry<String, Object> entry : exception.getDetails().entrySet())
						{
							System.out.println(entry.getKey() + ": " + entry.getValue());
						}
					}
					System.out.println("Message: " + exception.getMessage());
				}
			}
			else
			{
				Model responseObject = response.getModel();
				Class<? extends Model> clas = responseObject.getClass();
				Field[] fields = clas.getDeclaredFields();
				for (Field field : fields)
				{
					field.setAccessible(true);
					System.out.println(field.getName() + ":" + field.get(responseObject));
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
			Long id = 3477091055l;
			updateCustomLayouts(id, moduleAPIName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
