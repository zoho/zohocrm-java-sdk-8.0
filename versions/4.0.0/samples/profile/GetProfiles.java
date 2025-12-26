package samples.profile;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.profiles.APIException;
import com.zoho.crm.api.profiles.DefaultView;
import com.zoho.crm.api.profiles.ResponseWrapper;
import com.zoho.crm.api.profiles.ProfilesOperations;
import com.zoho.crm.api.profiles.ResponseHandler;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetProfiles
{
	public static void getProfiles() throws Exception
	{
		ProfilesOperations profilesOperations = new ProfilesOperations();
		ParameterMap paramInstance = new ParameterMap();
		APIResponse<ResponseHandler> response = profilesOperations.getProfiles(paramInstance);
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
					List<com.zoho.crm.api.profiles.Profile> profiles = responseWrapper.getProfiles();
					for (com.zoho.crm.api.profiles.Profile profile : profiles)
					{
						System.out.println("Profile DisplayLabel: " + profile.getDisplayLabel());
						if (profile.getCreatedTime() != null)
						{
							System.out.println("Profile CreatedTime: " + profile.getCreatedTime());
						}
						if (profile.getModifiedTime() != null)
						{
							System.out.println("Profile ModifiedTime: " + profile.getModifiedTime());
						}
						DefaultView defaultView = profile.getDefaultView();
						if (defaultView != null)
						{
							System.out.println("Default view Name : " + defaultView.getName());
							System.out.println("Default view id : " + defaultView.getId());
							System.out.println("Default view type : " + defaultView.getType());
						}
						System.out.println("Profile Name: " + profile.getName());
						System.out.println("is custom profile?  " + profile.getCustom());
						System.out.println("is deleted profile?  " + profile.getDelete());
						System.out.println("permission type   " + profile.getPermissionType());
						com.zoho.crm.api.users.MinifiedUser modifiedBy = profile.getModifiedBy();
						if (modifiedBy != null)
						{
							System.out.println("Profile Modified By User-ID: " + modifiedBy.getId());
							System.out.println("Profile Modified By User-Name: " + modifiedBy.getName());
							System.out.println("Profile Modified By User-Email: " + modifiedBy.getEmail());
						}
						System.out.println("Profile Description: " + profile.getDescription());
						System.out.println("Profile ID: " + profile.getId());
						com.zoho.crm.api.users.MinifiedUser createdBy = profile.getCreatedBy();
						if (createdBy != null)
						{
							System.out.println("Profile Created By User-ID: " + createdBy.getId());
							System.out.println("Profile Created By User-Name: " + createdBy.getName());
							System.out.println("Profile Created By User-Email: " + createdBy.getEmail());
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
			getProfiles();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
