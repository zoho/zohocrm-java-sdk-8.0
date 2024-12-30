package samples.apis;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.apis.APIException;
import com.zoho.crm.api.apis.APIsOperations;
import com.zoho.crm.api.apis.OperationTypes;
import com.zoho.crm.api.apis.ResponseHandler;
import com.zoho.crm.api.apis.ResponseWrapper;
import com.zoho.crm.api.apis.SupportedAPI;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetSupportedAPI
{
	public static void getSupportedAPI() throws Exception
	{
		String filters = null;
		APIsOperations apisOperations = new APIsOperations(filters);
		APIResponse<ResponseHandler> response = apisOperations.getSupportedAPI();
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.getStatusCode() == 204)
			{
				System.out.println("No Content");
				return;
			}
			if (response.isExpected())
			{
				ResponseHandler responseHandler = response.getObject();
				if (responseHandler instanceof ResponseWrapper)
				{
					ResponseWrapper responseWrapper = (ResponseWrapper) responseHandler;
					List<SupportedAPI> apis = responseWrapper.getApis();
					if (apis != null)
					{
						for(SupportedAPI api : apis)
						{
							System.out.println("API Path : " + api.getPath());
							List<OperationTypes> operationTypes = api.getOperationTypes();
							for(OperationTypes operationType :operationTypes)
							{
								System.out.println("API Operation Method : " + operationType.getMethod());
								System.out.println("API Operation OAuthScope : " + operationType.getOauthScope());
								System.out.println("API Operation MaxCredits : " + operationType.getMaxCredits());
								System.out.println("API Operation MinCredits : " + operationType.getMinCredits());
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
			else if (response.getStatusCode() != 204)
			{
				Model responseObject = response.getModel();
				Class<? extends Model> clas = responseObject.getClass();
				Field[] fields = clas.getDeclaredFields();
				for (Field field1 : fields)
				{
					field1.setAccessible(true);
					System.out.println(field1.getName() + ":" + field1.get(responseObject));
				}
			}
		}
	}

	public static void main(String[] args)
	{
		try
		{
			Environment environment = USDataCenter.PRODUCTION;
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			getSupportedAPI();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
