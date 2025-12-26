package samples.usergroups;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.modules.MinifiedModule;
import com.zoho.crm.api.usergroups.APIException;
import com.zoho.crm.api.usergroups.AssociationModule;
import com.zoho.crm.api.usergroups.AssociationResponse;
import com.zoho.crm.api.usergroups.AssociationWrapper;
import com.zoho.crm.api.usergroups.Resource;
import com.zoho.crm.api.usergroups.ResponseHandler;
import com.zoho.crm.api.usergroups.UserGroupsOperations;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetAssociations
{
	public static void getAssociations(Long groupId) throws Exception
	{
		UserGroupsOperations userGroupsOperations = new UserGroupsOperations();
		APIResponse<ResponseHandler> response = userGroupsOperations.getAssociations(groupId);
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
				if (responseHandler instanceof AssociationWrapper)
				{
					AssociationWrapper assoicationWrapper = (AssociationWrapper) responseHandler;
					List<AssociationResponse> associations = assoicationWrapper.getAssociations();
					if (associations != null)
					{
						for (AssociationResponse associationResponse : associations)
						{
							System.out.println("Associations Type : " + associationResponse.getType());
							Resource resource = associationResponse.getResource();
							if (resource != null)
							{
								System.out.println("Associations Resource Id : " + resource.getId());
								System.out.println("Associations Resource Name : " + resource.getName());
							}
							AssociationModule detail = associationResponse.getDetail();
							if (detail != null)
							{
								MinifiedModule module = detail.getModule();
								if (module != null)
								{
									System.out.println("Associations Module Id : " + module.getId());
									System.out.println("Associations Module Id : " + module.getAPIName());
									System.out.println("Associations Module Id : " + module.getModule());
								}
							}
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
			Long groupId = 44024801326019l;
			getAssociations(groupId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
