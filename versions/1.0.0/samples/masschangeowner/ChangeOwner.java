package samples.masschangeowner;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.masschangeowner.APIException;
import com.zoho.crm.api.masschangeowner.ActionHandler;
import com.zoho.crm.api.masschangeowner.ActionResponse;
import com.zoho.crm.api.masschangeowner.ActionWrapper;
import com.zoho.crm.api.masschangeowner.BodyWrapper;
import com.zoho.crm.api.masschangeowner.MassChangeOwnerOperations;
import com.zoho.crm.api.masschangeowner.Owner;
import com.zoho.crm.api.masschangeowner.SuccessResponse;
import com.zoho.crm.api.masschangeowner.Territory;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class ChangeOwner
{
	public static void changeOwner(String moduleAPIName) throws Exception
	{
		MassChangeOwnerOperations massChangeOwnerOperations = new MassChangeOwnerOperations(moduleAPIName);
		BodyWrapper bodyWrapper = new BodyWrapper();
		bodyWrapper.setCvid(347706115237021l);
		Owner owner = new Owner();
		owner.setId(3477061173021l);
		bodyWrapper.setOwner(owner);
		Territory territory = new Territory();
		territory.setId(36523977622003l);
		territory.setIncludeChild(true);
		bodyWrapper.setTerritory(territory);
		APIResponse<ActionHandler> response = massChangeOwnerOperations.changeOwner(bodyWrapper);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ActionWrapper)
				{
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
					List<ActionResponse> actionResponses = actionWrapper.getData();
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
			String moduleAPIName = "DOT";
			changeOwner(moduleAPIName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
