package samples.cadencesexecution;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.cadencesexecution.BodyWrapper;
import com.zoho.crm.api.cadencesexecution.CadencesExecutionOperations;
import com.zoho.crm.api.cadencesexecution.ActionHandler;
import com.zoho.crm.api.cadencesexecution.ActionWrapper;
import com.zoho.crm.api.cadencesexecution.ActionResponse;
import com.zoho.crm.api.cadencesexecution.SuccessResponse;
import com.zoho.crm.api.cadencesexecution.APIException;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class UnenrollCadences
{
	public static void unenrolCadences(String moduleAPIName) throws Exception
	{
		CadencesExecutionOperations cadencesExecutionOperations = new CadencesExecutionOperations();
		BodyWrapper request = new BodyWrapper();
		List<String> cadencesIds = new ArrayList<String>();
		cadencesIds.add("34770785001");
		request.setCadencesIds(cadencesIds);
		List<String> ids = new ArrayList<String>();
		ids.add("347750001");
		request.setIds(ids);
		APIResponse<ActionHandler> response = cadencesExecutionOperations.unenrollCadences(moduleAPIName, request);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ActionWrapper)
				{
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
					List<ActionResponse> actionresponses = actionWrapper.getData();
					for (ActionResponse actionresponse : actionresponses)
					{
						if (actionresponse instanceof SuccessResponse)
						{
							SuccessResponse successresponse = (SuccessResponse) actionresponse;
							System.out.println("Status: " + successresponse.getStatus().getValue());
							System.out.println("Code: " + successresponse.getCode().getValue());
							System.out.println("Details: ");
							for (Map.Entry<String, Object> entry : successresponse.getDetails().entrySet())
							{
								System.out.println(entry.getKey() + ": " + entry.getValue());
							}
							System.out.println("Message: " + successresponse.getMessage());
						}
						else if (actionresponse instanceof APIException)
						{
							APIException exception = (APIException) actionresponse;
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
			String moduleAPIName = "Leads";
			unenrolCadences(moduleAPIName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
