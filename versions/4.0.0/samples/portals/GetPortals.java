package samples.portals;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.portals.APIException;
import com.zoho.crm.api.portals.Owner;
import com.zoho.crm.api.portals.PortalsOperations;
import com.zoho.crm.api.portals.ResponseHandler;
import com.zoho.crm.api.portals.ResponseWrapper;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetPortals
{
	public static void getPortals() throws Exception
	{
		PortalsOperations portalsOperations = new PortalsOperations();
		APIResponse<ResponseHandler> response = portalsOperations.getPortals();
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
					List<com.zoho.crm.api.portals.Portals> portals = responseWrapper.getPortals();
					for (com.zoho.crm.api.portals.Portals portal : portals)
					{
						System.out.println("Portals CreatedTime: " + portal.getCreatedTime());
						System.out.println("Portals ModifiedTime: " + portal.getModifiedTime());
						Owner modifiedBy = portal.getModifiedBy();
						if (modifiedBy != null)
						{
							System.out.println("Portals ModifiedBy User-ID: " + modifiedBy.getId());
							System.out.println("Portals ModifiedBy User-Name: " + modifiedBy.getName());
						}
						Owner createdBy = portal.getCreatedBy();
						if (createdBy != null)
						{
							System.out.println("Portals CreatedBy User-ID: " + createdBy.getId());
							System.out.println("Portals CreatedBy User-Name: " + createdBy.getName());
						}
						System.out.println("Portals Zaid: " + portal.getZaid());
						System.out.println("Portals Name: " + portal.getName());
						System.out.println("Portals Active: " + portal.getActive());
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
			getPortals();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
