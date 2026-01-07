package samples.modules;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.modules.APIException;
import com.zoho.crm.api.modules.ActionHandler;
import com.zoho.crm.api.modules.ActionResponse;
import com.zoho.crm.api.modules.ActionWrapper;
import com.zoho.crm.api.modules.BodyWrapper;
import com.zoho.crm.api.modules.Modules;
import com.zoho.crm.api.modules.ModulesOperations;
import com.zoho.crm.api.modules.SuccessResponse;
import com.zoho.crm.api.profiles.MinifiedProfile;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class CreateCustomModules
{
	public static void createCustomModules() throws Exception
	{
		ModulesOperations moduleOperations = new ModulesOperations();
		List<Modules> modules = new ArrayList<Modules>();
		List<MinifiedProfile> profiles = new ArrayList<MinifiedProfile>();
		Modules module = new Modules();
		module.setPluralLabel("Stocks");
		module.setSingularLabel("Stock");
		MinifiedProfile profile = new MinifiedProfile();
		profile.setId(3477061277005l);
		profiles.add(profile);
		module.setProfiles(profiles);
		module.setAPIName("stock");
		JSONObject displayField = new JSONObject();
		displayField.put("field_label", "My name field label");
		displayField.put("data_type", "autonumber");
		JSONObject autoNumber = new JSONObject();
		autoNumber.put("prefix", "ZOHOCRM");
		autoNumber.put("start_number", "1003");
		autoNumber.put("suffix", "BRANCH");
		displayField.put("auto_number", autoNumber);
		module.setDisplayField(displayField);
		modules.add(module);
		BodyWrapper request = new BodyWrapper();
		request.setModules(modules);
		APIResponse<ActionHandler> response = moduleOperations.createCustomModules(request);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ActionWrapper)
				{
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
					List<ActionResponse> actionResponses = actionWrapper.getModules();
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
					if (exception.getDetails() != null)
					{
						for (Map.Entry<String, Object> entry : exception.getDetails().entrySet())
						{
							System.out.println(entry.getKey() + ": " + entry.getValue());
						}
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
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			createCustomModules();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
