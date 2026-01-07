package samples.usersunavailability;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.usersunavailability.APIException;
import com.zoho.crm.api.usersunavailability.ActionHandler;
import com.zoho.crm.api.usersunavailability.ActionResponse;
import com.zoho.crm.api.usersunavailability.ActionWrapper;
import com.zoho.crm.api.usersunavailability.BodyWrapper;
import com.zoho.crm.api.usersunavailability.SuccessResponse;
import com.zoho.crm.api.usersunavailability.UsersUnavailabilityOperations;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class UpdateUserUnavailability
{
	public static void updateUserUnavailability(String id) throws Exception
	{
		UsersUnavailabilityOperations usersOperations = new UsersUnavailabilityOperations();
		BodyWrapper request = new BodyWrapper();
		List<com.zoho.crm.api.usersunavailability.UsersUnavailability> userList = new ArrayList<com.zoho.crm.api.usersunavailability.UsersUnavailability>();
		com.zoho.crm.api.usersunavailability.UsersUnavailability user1 = new com.zoho.crm.api.usersunavailability.UsersUnavailability();
		user1.setComments("Unavailable");
		OffsetDateTime from = OffsetDateTime.of(2022, 04, 02, 11, 00, 01, 00, ZoneOffset.of("+05:30"));
		user1.setFrom(from);
		OffsetDateTime to = OffsetDateTime.of(2022, 05, 05, 11, 00, 01, 00, ZoneOffset.of("+05:30"));
		user1.setTo(to);
		userList.add(user1);
		request.setUsersUnavailability(userList);
		APIResponse<ActionHandler> response = usersOperations.updateUserUnavailability(id, request);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ActionWrapper)
				{
					ActionWrapper responseWrapper = (ActionWrapper) actionHandler;
					List<ActionResponse> actionResponses = responseWrapper.getUsersUnavailability();
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
			String id = "347706117225001";
			updateUserUnavailability(id);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
