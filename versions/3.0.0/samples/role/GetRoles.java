package samples.role;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.roles.APIException;
import com.zoho.crm.api.roles.ReportingTo;
import com.zoho.crm.api.roles.ResponseHandler;
import com.zoho.crm.api.roles.ResponseWrapper;
import com.zoho.crm.api.roles.RolesOperations;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetRoles
{
	public static void getRoles() throws Exception
	{
		RolesOperations rolesOperations = new RolesOperations();
		APIResponse<ResponseHandler> response = rolesOperations.getRoles();
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
					List<com.zoho.crm.api.roles.Role> roles = responseWrapper.getRoles();
					for (com.zoho.crm.api.roles.Role role : roles)
					{
						System.out.println("Role DisplayLabel: " + role.getDisplayLabel());
						ReportingTo forecastManager = role.getForecastManager();
						if (forecastManager != null)
						{
							System.out.println("Role Forecast Manager User-ID: " + forecastManager.getId());
							System.out.println("Role Forecast Manager User-Name: " + forecastManager.getName());
						}
						System.out.println("Role ShareWithPeers: " + role.getShareWithPeers().toString());
						System.out.println("Role Name: " + role.getName());
						System.out.println("Role Description: " + role.getDescription());
						System.out.println("Role ID: " + role.getId());
						ReportingTo reportingTo = role.getReportingTo();
						if (reportingTo != null)
						{
							System.out.println("Role ReportingTo User-ID: " + reportingTo.getId());
							System.out.println("Role ReportingTo User-Name: " + reportingTo.getName());
						}
						System.out.println("Role AdminUser: " + role.getAdminUser());
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
			getRoles();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
