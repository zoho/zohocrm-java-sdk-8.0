package samples.globalpicklists;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.globalpicklists.APIException;
import com.zoho.crm.api.globalpicklists.GlobalPicklistsOperations;
import com.zoho.crm.api.globalpicklists.ReplacedResponseHandler;
import com.zoho.crm.api.globalpicklists.ReplacedResponseWrapper;
import com.zoho.crm.api.globalpicklists.ReplacedValue;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetReplaceValues
{
	public static void getReplaceValues(Long id) throws Exception
	{
		GlobalPicklistsOperations sendMailsOperations = new GlobalPicklistsOperations();
		APIResponse<ReplacedResponseHandler> response = sendMailsOperations.getReplaceValues(id);
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
				ReplacedResponseHandler responseHandler = response.getObject();
				if (responseHandler instanceof ReplacedResponseWrapper)
				{
					ReplacedResponseWrapper responseWrapper = (ReplacedResponseWrapper) responseHandler;
					List<ReplacedValue> replacedValues = responseWrapper.getReplacedValues();
					for (ReplacedValue replacedValue : replacedValues)
					{
						System.out.println("GlobalPicklists ActualValue: " + replacedValue.getActualValue());
						System.out.println("GlobalPicklists DisplayValue: " + replacedValue.getDisplayValue());
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
			Long id = 347706120955025l;
			getReplaceValues(id);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
