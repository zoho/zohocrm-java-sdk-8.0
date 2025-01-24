package samples.callpreferences;

import java.lang.reflect.Field;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.callpreferences.APIException;
import com.zoho.crm.api.callpreferences.ActionHandler;
import com.zoho.crm.api.callpreferences.ActionResponse;
import com.zoho.crm.api.callpreferences.ActionWrapper;
import com.zoho.crm.api.callpreferences.CallPreferencesOperations;
import com.zoho.crm.api.callpreferences.BodyWrapper;
import com.zoho.crm.api.callpreferences.CallPreferences;
import com.zoho.crm.api.callpreferences.SuccessResponse;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class UpdateCallPreference
{
	public static void updateCallPreference() throws Exception
	{
		CallPreferencesOperations callPreferencesOperations = new CallPreferencesOperations();
		BodyWrapper bodyWrapper = new BodyWrapper();
		CallPreferences callPreferences = new CallPreferences();
		callPreferences.setShowFromNumber(true);
		callPreferences.setShowToNumber(true);
		bodyWrapper.setCallPreferences(callPreferences);
		APIResponse<ActionHandler> response = callPreferencesOperations.updateCallPreference(bodyWrapper);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ActionWrapper)
				{
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
					ActionResponse actionResponse = actionWrapper.getCallPreferences();
					if (actionResponse instanceof SuccessResponse)
					{
						SuccessResponse successResponse = (SuccessResponse) actionResponse;
						System.out.println("Status: " + successResponse.getStatus().getValue());
						System.out.println("Code: " + successResponse.getCode().getValue());
						System.out.println("Details: ");
						for (Map.Entry<String, Object> entry : successResponse.getDetails().entrySet())
						{
							System.out.println(entry.getKey() + ": " + entry.getValue());
						}
						System.out.println("Message: " + successResponse.getMessage());
					}
					else if (actionResponse instanceof APIException)
					{
						APIException exception = (APIException) actionResponse;
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
			updateCallPreference();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
