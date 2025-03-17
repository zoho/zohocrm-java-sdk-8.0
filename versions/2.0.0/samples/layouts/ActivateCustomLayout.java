package samples.layouts;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.layouts.APIException;
import com.zoho.crm.api.layouts.ActionHandler;
import com.zoho.crm.api.layouts.ActionResponse;
import com.zoho.crm.api.layouts.ActionWrapper;
import com.zoho.crm.api.layouts.BodyWrapper;
import com.zoho.crm.api.layouts.Layouts;
import com.zoho.crm.api.layouts.LayoutsOperations;
import com.zoho.crm.api.layouts.SuccessResponse;
import com.zoho.crm.api.layouts.LayoutsOperations.ActivateCustomLayoutParam;
import com.zoho.crm.api.layouts.Profiles;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class ActivateCustomLayout
{
	public static void updateCustomLayouts(Long id, String moduleAPIName) throws Exception
	{
		LayoutsOperations layoutsOperations = new LayoutsOperations();
		
		BodyWrapper request = new BodyWrapper();
		List<Layouts> layouts = new ArrayList<Layouts>();
		Layouts layout = new Layouts();
		
		List<Profiles> profiles = new ArrayList<Profiles>();
		Profiles profile = new Profiles();
		profile.setId(347706124277005l);
		profiles.add(profile);
		
		layout.setProfiles(profiles);
		layouts.add(layout);
		request.setLayouts(layouts);
		
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(ActivateCustomLayoutParam.MODULE, moduleAPIName);
		APIResponse<ActionHandler> response = layoutsOperations.activateCustomLayout(id, request, paramInstance);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ActionWrapper)
				{
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
					List<ActionResponse> actionResponses = actionWrapper.getLayouts();
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
							System.out.println("Message: " + successResponse.getMessage().getValue());
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
							System.out.println("Message: " + exception.getMessage().getValue());
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
			String moduleAPIName = "Leads";
			Long id = 3477657472l;
			updateCustomLayouts(id, moduleAPIName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
