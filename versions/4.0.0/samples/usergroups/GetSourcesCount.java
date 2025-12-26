package samples.usergroups;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.usergroups.APIException;
import com.zoho.crm.api.usergroups.ResponseHandler;
import com.zoho.crm.api.usergroups.SourcesCount;
import com.zoho.crm.api.usergroups.SourcesCountWrapper;
import com.zoho.crm.api.usergroups.UserGroupsOperations;
import com.zoho.crm.api.usergroups.Users;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetSourcesCount
{
	public static void getSourcesCount(Long groupId) throws Exception
	{
		UserGroupsOperations userGroupsOperations = new UserGroupsOperations();
		APIResponse<ResponseHandler> response = userGroupsOperations.getSourcesCount(groupId);
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
				if (responseHandler instanceof SourcesCountWrapper)
				{
					SourcesCountWrapper responseWrapper = (SourcesCountWrapper) responseHandler;
					List<SourcesCount> sourcesCount = responseWrapper.getSourcesCount();
					for (SourcesCount count : sourcesCount)
					{
						System.out.println("Sources Count Territories: " + count.getTerritories());
						System.out.println("Sources Count Roles: " + count.getRoles());
						System.out.println("Sources Count Groups: " + count.getGroups());
						Users users = count.getUsers();
						if (users != null)
						{
							System.out.println("Sources Users Inactive: " + users.getInactive());
							System.out.println("Sources Users Deleted: " + users.getDeleted());
							System.out.println("Sources Users Groups: " + users.getActive());
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
			Long groupId = 347706117236002l;
			getSourcesCount(groupId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
