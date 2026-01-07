package samples.variables;

import java.util.Arrays;
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
import com.zoho.crm.api.variables.ResponseHandler;
import com.zoho.crm.api.variables.ResponseWrapper;
import com.zoho.crm.api.variables.VariableGroup;
import com.zoho.crm.api.variables.VariablesOperations;
import com.zoho.crm.api.variables.VariablesOperations.GetVariablesParam;

public class GetVariables
{
	public static void getVariables() throws Exception
	{
		VariablesOperations variablesOperations = new VariablesOperations();
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(GetVariablesParam.GROUP, "General");
		APIResponse<ResponseHandler> response = variablesOperations.getVariables(paramInstance);
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
					List<com.zoho.crm.api.variables.Variable> variables = responseWrapper.getVariables();
					for (com.zoho.crm.api.variables.Variable variable : variables)
					{
						System.out.println("Variable APIName: " + variable.getAPIName());
						System.out.println("Variable Name: " + variable.getName());
						System.out.println("Variable Description: " + variable.getDescription());
						System.out.println("Variable ID: " + variable.getId());
						System.out.println("Variable Source: " + variable.getSource());
						System.out.println("Variable Type: " + variable.getType());
						VariableGroup variableGroup = variable.getVariableGroup();
						if (variableGroup != null)
						{
							System.out.println("Variable VariableGroup APIName: " + variableGroup.getAPIName());
							System.out.println("Variable VariableGroup ID: " + variableGroup.getId());
						}
						System.out.println("Variable Value: " + variable.getValue());
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
			getVariables();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
