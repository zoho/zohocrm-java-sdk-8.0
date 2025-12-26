package samples.profile;

import java.lang.reflect.Field;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.profiles.APIException;
import com.zoho.crm.api.profiles.ActionHandler;
import com.zoho.crm.api.profiles.ProfilesOperations;
import com.zoho.crm.api.profiles.ProfilesOperations.DeleteProfileParam;
import com.zoho.crm.api.profiles.SuccessResponse;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class DeleteProfile
{
	public static void deleteProfile(Long profileId, Long existingprofileid) throws Exception
	{
		ProfilesOperations profilesOperations = new ProfilesOperations();
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(DeleteProfileParam.TRANSFER_TO, existingprofileid);
		APIResponse<ActionHandler> response = profilesOperations.deleteProfile(profileId, paramInstance);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof SuccessResponse)
				{
					SuccessResponse successResponse = (SuccessResponse) actionHandler;
					System.out.println("Status: " + successResponse.getStatus().getValue());
					System.out.println("Code: " + successResponse.getCode().getValue());
					System.out.println("Details: ");
					for (Map.Entry<String, Object> entry : successResponse.getDetails().entrySet())
					{
						System.out.println(entry.getKey() + ": " + entry.getValue());
					}
					System.out.println("Message: " + successResponse.getMessage());
				}
				else if (actionHandler instanceof APIException)
				{
					APIException exception = (APIException) actionHandler;
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
			Long profileId = 3477061026011l;
			Long existingprofileid = 347706116715008l;
			deleteProfile(profileId, existingprofileid);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
