package samples.functions;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.HeaderMap;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.Param;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.functions.FunctionsOperations;
import com.zoho.crm.api.functions.ResponseWrapper;
import com.zoho.crm.api.functions.APIException;
import com.zoho.crm.api.functions.SuccessResponse;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class ExecuteFunctionUsingParameters
{
	public static void executeFunctionUsingParameters() throws Exception
	{
		String functionName = "get_record_lead";
		String authType = "oauth";
		Map<String, String> param = new HashMap<>();
        param.put("1221", "2111221");
        param.put("15221", "21113221");
        param.put("12421", "211341221");

        HashMap<String, String> arg = new HashMap<>();
        arg.put("12223322", "iuubnf");

        HashMap<String, Object> arguments1 = new HashMap<>();
        arguments1.put("zoho", arg);
        
		FunctionsOperations functionsOperations = new FunctionsOperations(functionName, authType, arguments1);
		ParameterMap paramInstance = new ParameterMap();
        paramInstance.add(new Param<>("Java", Map.class.getCanonicalName()), param);
        HeaderMap headerInstance = new HeaderMap();
        APIResponse<ResponseWrapper> response = functionsOperations.executeFunctionUsingParameters(paramInstance, headerInstance);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ResponseWrapper responseWrapper = response.getObject();
				if (responseWrapper instanceof SuccessResponse)
				{
					SuccessResponse successResponse = (SuccessResponse) responseWrapper;
					System.out.println("Code: " + successResponse.getCode().getValue());
					System.out.println("Details: ");
					for (Map.Entry<String, Object> entry : successResponse.getDetails().entrySet())
					{
						System.out.println(entry.getKey() + ": " + entry.getValue());
					}
					System.out.println("Message: " + successResponse.getMessage().getValue());
				}
				else if (responseWrapper instanceof APIException)
				{
					APIException exception = (APIException) responseWrapper;
					System.out.println("Status: " + exception.getStatus().getValue());
					System.out.println("Code: " + exception.getCode().getValue());
					System.out.println("Details: ");
					for (Map.Entry<String, Object> entry : exception.getDetails().entrySet())
					{
						System.out.println(entry.getKey() + ": " + entry.getValue());
					}
					System.out.println("Message: " + exception.getMessage().getValue());
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
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			executeFunctionUsingParameters();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
