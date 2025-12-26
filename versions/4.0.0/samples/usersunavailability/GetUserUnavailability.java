package samples.usersunavailability;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.usersunavailability.APIException;
import com.zoho.crm.api.usersunavailability.Info;
import com.zoho.crm.api.usersunavailability.ResponseHandler;
import com.zoho.crm.api.usersunavailability.ResponseWrapper;
import com.zoho.crm.api.usersunavailability.User;
import com.zoho.crm.api.usersunavailability.UsersUnavailabilityOperations;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetUserUnavailability
{
	public static void getUserUnavailability(String id) throws Exception
	{
		UsersUnavailabilityOperations usersUnavailabilityOperations = new UsersUnavailabilityOperations();
		ParameterMap paramInstance = new ParameterMap();
		APIResponse<ResponseHandler> response = usersUnavailabilityOperations.getUserUnavailability(id, paramInstance);
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
					List<com.zoho.crm.api.usersunavailability.UsersUnavailability> users = responseWrapper.getUsersUnavailability();
					for (com.zoho.crm.api.usersunavailability.UsersUnavailability usersUnavailability : users)
					{
						System.out.println("UsersUnavailability Comments: " + usersUnavailability.getComments());
						System.out.println("UsersUnavailability From: " + usersUnavailability.getFrom());
						System.out.println("UsersUnavailability Id: " + usersUnavailability.getId());
						System.out.println("UsersUnavailability to: " + usersUnavailability.getTo());
						User user = usersUnavailability.getUser();
						if (user != null)
						{
							System.out.println("UsersUnavailability User-Name: " + user.getName());
							System.out.println("UsersUnavailability User-Id: " + user.getId());
							System.out.println("UsersUnavailability User-ZuId: " + user.getZuid());
						}
					}
					Info info = responseWrapper.getInfo();
					if (info != null)
					{
						if (info.getPerPage() != null)
						{
							System.out.println("User Info PerPage: " + info.getPerPage().toString());
						}
						if (info.getCount() != null)
						{
							System.out.println("User Info Count: " + info.getCount().toString());
						}
						if (info.getPage() != null)
						{
							System.out.println("User Info Page: " + info.getPage().toString());
						}
						if (info.getMoreRecords() != null)
						{
							System.out.println("User Info MoreRecords: " + info.getMoreRecords().toString());
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

	public static void main(String[] args)
	{
		try
		{
			Environment environment = USDataCenter.PRODUCTION;

			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").redirectURL("Redirect_URL").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			String userId = "440248001308076";
			getUserUnavailability(userId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
