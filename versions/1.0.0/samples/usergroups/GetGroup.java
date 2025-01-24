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
import com.zoho.crm.api.usergroups.Owner;
import com.zoho.crm.api.usergroups.ResponseHandler;
import com.zoho.crm.api.usergroups.ResponseWrapper;
import com.zoho.crm.api.usergroups.Source;
import com.zoho.crm.api.usergroups.Sources;
import com.zoho.crm.api.usergroups.UserGroupsOperations;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetGroup
{
	public static void getGroup(Long groupId) throws Exception
	{
		UserGroupsOperations userGroupsOperations = new UserGroupsOperations();
		APIResponse<ResponseHandler> response = userGroupsOperations.getGroup(groupId);
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
					List<com.zoho.crm.api.usergroups.Groups> users = responseWrapper.getUserGroups();
					for (com.zoho.crm.api.usergroups.Groups user : users)
					{
						Owner createdBy = user.getCreatedBy();
						if (createdBy != null)
						{
							System.out.println("UserGroups Created By User-Name: " + createdBy.getName());
							System.out.println("UserGroups Created By User-ID: " + createdBy.getId());
						}
						Owner modifiedBy = user.getModifiedBy();
						if (modifiedBy != null)
						{
							System.out.println("UserGroups Modified By User-Name: " + modifiedBy.getName());
							System.out.println("UserGroups Modified By User-ID: " + modifiedBy.getId());
						}
						System.out.println("User ModifiedTime: " + user.getModifiedTime());
						System.out.println("User CreatedTime: " + user.getCreatedTime());
						System.out.println("UserGroups Description: " + user.getDescription());
						System.out.println("UserGroups Id: " + user.getId());
						System.out.println("UserGroups Name: " + user.getName());
						List<Sources> sources = user.getSources();
						if (sources != null)
						{
							sources.forEach(source ->
							{
								System.out.println("UserGroups Sources Type: " + source.getType().getValue());
								Source source1 = source.getSource();
								if (source1 != null)
								{
									System.out.println("UserGroups Sources Id: " + source1.getId());
								}
								System.out.println("UserGroups Sources Subordinates: " + source.getSubordinates());
								System.out.println("UserGroups Sources SubTerritories: " + source.getSubTerritories());
							});
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
			Long groupId = 440248001307102l;
			getGroup(groupId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
