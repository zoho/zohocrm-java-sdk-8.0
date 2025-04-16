package samples.contactroles;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.contactroles.APIException;
import com.zoho.crm.api.contactroles.ResponseWrapper;
import com.zoho.crm.api.contactroles.ContactRole;
import com.zoho.crm.api.contactroles.ContactRolesOperations;
import com.zoho.crm.api.contactroles.ResponseHandler;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetContactRole
{
	public static void getContactRole(Long contactRoleId) throws Exception
	{
		ContactRolesOperations contactRolesOperations = new ContactRolesOperations();
		APIResponse<ResponseHandler> response = contactRolesOperations.getRole(contactRoleId);
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
					List<ContactRole> contactRoles = responseWrapper.getContactRoles();
					for (ContactRole contactRole : contactRoles)
					{
						System.out.println("ContactRole ID: " + contactRole.getId());
						System.out.println("ContactRole Name: " + contactRole.getName());
						System.out.println("ContactRole SequenceNumber: " + contactRole.getSequenceNumber());
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
			Long contactRoleId = 4770615208001l;
			getContactRole(contactRoleId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
