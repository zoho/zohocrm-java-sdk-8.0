package samples.usertypeusers;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.crm.api.usertypeusers.UserTypeUsersOperations;
import com.zoho.crm.api.usertypeusers.Users;
import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.usertypeusers.APIException;
import com.zoho.crm.api.usertypeusers.Info;
import com.zoho.crm.api.usertypeusers.ResponseHandler;
import com.zoho.crm.api.usertypeusers.ResponseWrapper;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetUsersOfUserType
{
	public static void getUsersOfUserType(String portalName, Long userTypeId) throws Exception
	{
		UserTypeUsersOperations userTypeOperations = new UserTypeUsersOperations(userTypeId, portalName);
		ParameterMap paramInstance = new ParameterMap();
		APIResponse<ResponseHandler> response = userTypeOperations.getUsersOfUserType(paramInstance);
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
					List<Users> users = responseWrapper.getUsers();
					for (Users user : users)
					{
						System.out.println("Users PersonalityId: " + user.getPersonalityId());
						System.out.println("Users Confirm: " + user.getConfirm());
						System.out.println("Users StatusReasonS: " + user.getStatusReasonS());
						System.out.println("Users InvitedTime: " + user.getInvitedTime());
						System.out.println("Users Module: " + user.getModule());
						System.out.println("Users Name: " + user.getName());
						System.out.println("Users Active: " + user.getActive());
						System.out.println("Users Email: " + user.getEmail());
					}
					Info info = responseWrapper.getInfo();
					if (info != null)
					{
						if (info.getPerPage() != null)
						{
							System.out.println("Users Info PerPage: " + info.getPerPage().toString());
						}
						if (info.getCount() != null)
						{
							System.out.println("Users Info Count: " + info.getCount().toString());
						}
						if (info.getPage() != null)
						{
							System.out.println("Users Info Page: " + info.getPage());
						}
						if (info.getMoreRecords() != null)
						{
							System.out.println("Users Info MoreRecords: " + info.getMoreRecords().toString());
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
			else if (response.getStatusCode() != 204)
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
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").redirectURL("Redirect_URL").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			String portalName = "PortalsAPItest101";
			Long userTypeId = 440248001304019l;
			getUsersOfUserType(portalName, userTypeId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
