package samples.globalpicklists;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.globalpicklists.APIException;
import com.zoho.crm.api.globalpicklists.GlobalPicklistsOperations;
import com.zoho.crm.api.globalpicklists.ReplaceBodyWrapper;
import com.zoho.crm.api.globalpicklists.ReplacePicklistValue;
import com.zoho.crm.api.globalpicklists.ReplaceSuccessResponse;
import com.zoho.crm.api.globalpicklists.ReplaceActionHandler;
import com.zoho.crm.api.globalpicklists.ReplaceActionResponse;
import com.zoho.crm.api.globalpicklists.ReplaceActionWrapper;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class ReplacePicklistValues
{
	public static void replacePicklistValues(Long id) throws Exception
	{
		GlobalPicklistsOperations sendMailsOperations = new GlobalPicklistsOperations();
		ReplaceBodyWrapper request = new ReplaceBodyWrapper();
		List<com.zoho.crm.api.globalpicklists.ReplacePicklistValues> replacePicklistValues = new ArrayList<com.zoho.crm.api.globalpicklists.ReplacePicklistValues>();
		com.zoho.crm.api.globalpicklists.ReplacePicklistValues replacePicklistValue = new com.zoho.crm.api.globalpicklists.ReplacePicklistValues();
		ReplacePicklistValue oldValue = new ReplacePicklistValue();
		oldValue.setDisplayValue("Facebook1");
		oldValue.setId(3477055045l);
		replacePicklistValue.setOldValue(oldValue);
		ReplacePicklistValue newValue = new ReplacePicklistValue();
		newValue.setDisplayValue("Facebook");
		newValue.setId(34770655028l);
		replacePicklistValue.setNewValue(newValue);
		replacePicklistValues.add(replacePicklistValue);
		request.setReplacePicklistValues(replacePicklistValues);
		APIResponse<ReplaceActionHandler> response = sendMailsOperations.replacePicklistValues(id, request);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ReplaceActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ReplaceActionWrapper)
				{
					ReplaceActionWrapper actionWrapper = (ReplaceActionWrapper) actionHandler;
					List<ReplaceActionResponse> actionResponses = actionWrapper.getReplacePicklistValues();
					for (ReplaceActionResponse actionResponse : actionResponses)
					{
						if (actionResponse instanceof ReplaceSuccessResponse)
						{
							ReplaceSuccessResponse successResponse = (ReplaceSuccessResponse) actionResponse;
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
			Long id = 3477955025l;
			replacePicklistValues(id);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
