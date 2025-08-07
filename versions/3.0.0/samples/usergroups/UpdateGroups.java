package samples.usergroups;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.usergroups.APIException;
import com.zoho.crm.api.usergroups.ActionHandler;
import com.zoho.crm.api.usergroups.ActionResponse;
import com.zoho.crm.api.usergroups.ActionWrapper;
import com.zoho.crm.api.usergroups.BodyWrapper;
import com.zoho.crm.api.usergroups.SuccessResponse;
import com.zoho.crm.api.usergroups.UserGroupsOperations;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;

public class UpdateGroups
{
	public static void updateGroups() throws Exception
	{
		UserGroupsOperations userGroupsOperations = new UserGroupsOperations();
		BodyWrapper request = new BodyWrapper();
		List<com.zoho.crm.api.usergroups.Groups> userList = new ArrayList<com.zoho.crm.api.usergroups.Groups>();
		com.zoho.crm.api.usergroups.Groups user1 = new com.zoho.crm.api.usergroups.Groups();
		user1.setId(31242354353423l);
		user1.setName("test group");
		user1.setDescription("my group");
		List<com.zoho.crm.api.usergroups.Sources> sources = new ArrayList<>();
		com.zoho.crm.api.usergroups.Sources source = new com.zoho.crm.api.usergroups.Sources();
		source.setType(new Choice<String>("users"));
		com.zoho.crm.api.usergroups.Source source1 = new com.zoho.crm.api.usergroups.Source();
		source1.setId(4402480254001l);
		source.setSource(source1);
		sources.add(source);
		user1.setSources(sources);
		userList.add(user1);
		request.setUserGroups(userList);
		APIResponse<ActionHandler> response = userGroupsOperations.updateGroups(request);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ActionWrapper)
				{
					ActionWrapper responseWrapper = (ActionWrapper) actionHandler;
					List<ActionResponse> actionResponses = responseWrapper.getUserGroups();
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
			updateGroups();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
