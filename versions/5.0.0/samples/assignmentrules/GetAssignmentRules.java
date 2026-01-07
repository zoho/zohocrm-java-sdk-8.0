package samples.assignmentrules;

import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.assignmentrules.APIException;
import com.zoho.crm.api.assignmentrules.AssignmentRulesOperations;
import com.zoho.crm.api.assignmentrules.DefaultAssignee;
import com.zoho.crm.api.assignmentrules.ResponseHandler;
import com.zoho.crm.api.assignmentrules.ResponseWrapper;
import com.zoho.crm.api.assignmentrules.AssignmentRulesOperations.GetAssignmentRulesParam;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.modules.MinifiedModule;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetAssignmentRules
{
	public static void getAssignmentRules(String moduleAPIName) throws Exception
	{
		AssignmentRulesOperations assignmentRuleOperations = new AssignmentRulesOperations();
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(GetAssignmentRulesParam.MODULE, moduleAPIName);
		APIResponse<ResponseHandler> response = assignmentRuleOperations.getAssignmentRules(paramInstance);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.getStatusCode() == 204)
			{
				System.out.println("No Content");
				return;
			}
			if (response.isExpected())
			{
				ResponseHandler responseHandler = response.getObject();

				if (responseHandler instanceof ResponseWrapper)
				{
					ResponseWrapper responseWrapper = (ResponseWrapper) responseHandler;
					List<com.zoho.crm.api.assignmentrules.AssignmentRules> assignmentRules = responseWrapper.getAssignmentRules();
					for (com.zoho.crm.api.assignmentrules.AssignmentRules assignmentRule : assignmentRules)
					{
						System.out.println("AssignmentRule Modified Time: " + assignmentRule.getModifiedTime().toString());
						System.out.println("AssignmentRule Created Time: " + assignmentRule.getCreatedTime().toString());
						DefaultAssignee defaultAssignee = assignmentRule.getDefaultAssignee();
						if (defaultAssignee != null)
						{
							System.out.println("AssignmentRule DefaultUser User-ID: " + defaultAssignee.getId());
							System.out.println("AssignmentRule DefaultUser User-Name: " + defaultAssignee.getName());
						}
						MinifiedModule module = assignmentRule.getModule();
						if (module != null)
						{
							System.out.println("AssignmentRule Module ID: " + module.getId());
							System.out.println("AssignmentRule Module API Name: " + module.getAPIName());
						}
						System.out.println("AssignmentRule Name: " + assignmentRule.getName());
						com.zoho.crm.api.users.MinifiedUser modifiedBy = assignmentRule.getModifiedBy();
						if (modifiedBy != null)
						{
							System.out.println("AssignmentRule Modified By User-Name: " + modifiedBy.getName());
							System.out.println("AssignmentRule Modified By User-ID: " + modifiedBy.getId());
						}
						com.zoho.crm.api.users.MinifiedUser createdBy = assignmentRule.getCreatedBy();
						if (createdBy != null)
						{
							System.out.println("AssignmentRule Created By User-Name: " + createdBy.getName());
							System.out.println("AssignmentRule Created By User-ID: " + createdBy.getId());
						}
						System.out.println("AssignmentRule ID: " + assignmentRule.getId());
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

	public static void main(String[] args)
	{
		try
		{
			Environment environment = USDataCenter.PRODUCTION;
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").redirectURL("Redirect_URL").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			String moduleAPIName = "Leads";
			getAssignmentRules(moduleAPIName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
