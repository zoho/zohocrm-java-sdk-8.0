package samples.usertypeusers;

import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.usertypeusers.APIException;
import com.zoho.crm.api.usertypeusers.StatusActionHandler;
import com.zoho.crm.api.usertypeusers.StatusActionResponse;
import com.zoho.crm.api.usertypeusers.StatusActionWrapper;
import com.zoho.crm.api.usertypeusers.SuccessResponse;
import com.zoho.crm.api.usertypeusers.UserTypeUsersOperations;
import com.zoho.crm.api.usertypeusers.UserTypeUsersOperations.ChangeUsersStatusParam;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class ChangeUsersStatus
{
	public static void changeUsersStatus(String portalName, Long userTypeId, Long userId) throws Exception
	{
		UserTypeUsersOperations userTypeUsersOperations = new UserTypeUsersOperations(userTypeId, portalName);
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(ChangeUsersStatusParam.ACTIVE, false);
		APIResponse<StatusActionHandler> response = userTypeUsersOperations.changeUsersStatus(userId, paramInstance);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				StatusActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof StatusActionWrapper)
				{
					StatusActionWrapper actionWrapper = (StatusActionWrapper) actionHandler;
					List<StatusActionResponse> actionResponses = actionWrapper.getChangeStatus();
					for (StatusActionResponse actionResponse : actionResponses)
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
			String portalName = "PortalsAPItest101";
			Long userTypeId = 3421008l;
			Long userId = 347746007l;
			changeUsersStatus(portalName, userTypeId, userId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
