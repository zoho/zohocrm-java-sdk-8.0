package samples.territoryusers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
 
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.territoryusers.APIException;
import com.zoho.crm.api.territoryusers.Info;
import com.zoho.crm.api.territoryusers.ResponseHandler;
import com.zoho.crm.api.territoryusers.ResponseWrapper;
import com.zoho.crm.api.territoryusers.TerritoryUsersOperations;
import com.zoho.crm.api.users.Users;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetTerritoryUsers
{
	public static void getTerritoryUsers(Long territory) throws Exception
	{
		TerritoryUsersOperations territoryUsersOperations = new TerritoryUsersOperations();
		APIResponse<ResponseHandler> response = territoryUsersOperations.getTerritoryUsers(territory);
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
					ResponseWrapper responseWrapper = (ResponseWrapper)responseHandler;
					List<Users> users = responseWrapper.getUsers();
					if (users != null)
					{
						for (Users user : users)
						{
							System.out.println("Territory User ID : " + user.getId());
						}
					}
					Info info = responseWrapper.getInfo();
					if (info != null)
					{
						if (info.getPerPage() != null)
						{
							System.out.println("Territory Info PerPage: " + info.getPerPage().toString());
						}
						if (info.getCount() != null)
						{
							System.out.println("Territory Info Count: " + info.getCount().toString());
						}
						if (info.getPage() != null)
						{
							System.out.println("Territory Info Page: " + info.getPage().toString());
						}
						if (info.getMoreRecords() != null)
						{
							System.out.println("Territory Info MoreRecords: " + info.getMoreRecords().toString());
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
			long territory = 440248001305227l;
			getTerritoryUsers(territory);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
