package samples.sharingrules;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.sharingrules.SharingRulesOperations;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.sharingrules.APIException;
import com.zoho.crm.api.sharingrules.ActionHandler;
import com.zoho.crm.api.sharingrules.ActionResponse;
import com.zoho.crm.api.sharingrules.ActionWrapper;
import com.zoho.crm.api.sharingrules.SharingRules;
import com.zoho.crm.api.sharingrules.BodyWrapper;
import com.zoho.crm.api.sharingrules.SuccessResponse;
import com.zoho.crm.api.sharingrules.Shared;
import com.zoho.crm.api.sharingrules.Resource;
import com.zoho.crm.api.sharingrules.Criteria;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;

public class UpdateSharingRule
{

	public static void updateSharingRule(Long id, String moduleAPIName) throws Exception
	{
		SharingRulesOperations sharingRulesOperations = new SharingRulesOperations(moduleAPIName);
		BodyWrapper request = new BodyWrapper();
		List<SharingRules> sharingRules = new ArrayList<>();
		SharingRules sharingRule = new SharingRules();
		
		sharingRule.setType(new Choice<String>("Record_Owner_Based"));
		Shared sharedFrom = new Shared();
		Resource resource = new Resource();
		resource.setId(3477036002l);
		sharedFrom.setResource(resource);
		sharedFrom.setType(new Choice<String>("groups"));
		sharedFrom.setSubordinates(false);
		sharingRule.setSharedFrom(sharedFrom);
		
//		sharingRule.setType(new Choice<String>("Criteria_Based"));
//		Criteria criteria = new Criteria();
//		criteria.setComparator("equal");
//		com.zoho.crm.api.sharingrules.Field field = new com.zoho.crm.api.sharingrules.Field();
//		field.setAPIName("Wizard");
//		field.setId(1111195003l);
//		criteria.setField(field);
//		JSONObject value = new JSONObject();
//		value.put("name", "TestWizards");
//		value.put("id", "11111195001");
//		criteria.setValue(value);
//		sharingRule.setCriteria(criteria);
		
		sharingRule.setSuperiorsAllowed(false);
		
		Shared sharedTo = new Shared();
		resource = new Resource();
		resource.setId(3477236002l);
		sharedTo.setResource(resource);
		sharedTo.setType(new Choice<String>("groups"));
		sharedTo.setSubordinates(false);
		sharingRule.setSharedTo(sharedTo);
		
		sharingRule.setPermissionType(new Choice<String>("read_write_delete"));
		
		sharingRules.add(sharingRule);
		request.setSharingRules(sharingRules);
		APIResponse<ActionHandler> response = sharingRulesOperations.updateSharingRule(id, request);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ActionWrapper)
				{
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
					List<ActionResponse> actionResponses = actionWrapper.getSharingRules();
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
							System.out.println("Message: " + successResponse.getMessage().getValue());
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
							System.out.println("Message: " + exception.getMessage().getValue());
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
				Field[] fields = clas.getDeclaredFields();
				for (Field field1 : fields)
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
			String moduleAPIName = "Leads";
			Long id = 34770551001l;
			updateSharingRule(id, moduleAPIName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
