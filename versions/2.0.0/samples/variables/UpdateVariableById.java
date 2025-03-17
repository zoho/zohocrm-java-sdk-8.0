package samples.variables;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;
import com.zoho.crm.api.variables.APIException;
import com.zoho.crm.api.variables.ActionHandler;
import com.zoho.crm.api.variables.ActionResponse;
import com.zoho.crm.api.variables.ActionWrapper;
import com.zoho.crm.api.variables.BodyWrapper;
import com.zoho.crm.api.variables.SuccessResponse;
import com.zoho.crm.api.variables.VariablesOperations;
import com.zoho.crm.api.variables.VariablesOperations.GetVariableByIDParam;

public class UpdateVariableById
{
	public static void updateVariableById(Long variableId) throws Exception
	{
		VariablesOperations variablesOperations = new VariablesOperations();
		BodyWrapper request = new BodyWrapper();
		List<com.zoho.crm.api.variables.Variable> variableList = new ArrayList<com.zoho.crm.api.variables.Variable>();
		com.zoho.crm.api.variables.Variable variable1 = new com.zoho.crm.api.variables.Variable();
		variable1.setAPIName("TestAPIName");
		variableList.add(variable1);
		request.setVariables(variableList);
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(GetVariableByIDParam.GROUP, "34770613089001");// "General"
		APIResponse<ActionHandler> response = variablesOperations.updateVariableById(variableId, request, paramInstance);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ActionWrapper)
				{
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
					List<ActionResponse> actionResponses = actionWrapper.getVariables();
					for (ActionResponse actionResponse : actionResponses)
					{
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
			Long variableId = 34770613320163l;
			updateVariableById(variableId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
