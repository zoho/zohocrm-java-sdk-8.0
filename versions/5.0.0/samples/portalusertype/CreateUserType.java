package samples.portalusertype;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.portalusertype.APIException;
import com.zoho.crm.api.portalusertype.ActionHandler;
import com.zoho.crm.api.portalusertype.ActionResponse;
import com.zoho.crm.api.portalusertype.ActionWrapper;
import com.zoho.crm.api.portalusertype.BodyWrapper;
import com.zoho.crm.api.portalusertype.Fields;
import com.zoho.crm.api.portalusertype.Layouts;
import com.zoho.crm.api.portalusertype.Modules;
import com.zoho.crm.api.portalusertype.Permissions;
import com.zoho.crm.api.portalusertype.PersonalityModule;
import com.zoho.crm.api.portalusertype.SuccessResponse;
import com.zoho.crm.api.portalusertype.UserType;
import com.zoho.crm.api.portalusertype.Views;
import com.zoho.crm.api.portalusertype.PortalUserTypeOperations;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class CreateUserType
{
	public static void createUserType(String portal) throws Exception
	{
		PortalUserTypeOperations portalUserTypeOperations = new PortalUserTypeOperations(portal);
		BodyWrapper bodyWrapper = new BodyWrapper();
		List<UserType> userTypes = new ArrayList<UserType>();
		UserType userType = new UserType();
		userType.setName("Lead");
		PersonalityModule personalityModule = new PersonalityModule();
		personalityModule.setAPIName("Leads");
		userType.setPersonalityModule(personalityModule);
		userType.setActive(true);
		List<Modules> modules = new ArrayList<Modules>();
		Modules module = new Modules();
		List<Layouts> layouts = new ArrayList<Layouts>();
		Layouts layout = new Layouts();
		layout.setId(194728195055l);
		layouts.add(layout);
		module.setLayouts(layouts);
		Permissions permissions = new Permissions();
		permissions.setView(true);
		module.setPermissions(permissions);
		Views views = new Views();
		views.setId(194728191501l);
		views.setType("custom_view");
		module.setViews(views);
		List<Fields> fields = new ArrayList<Fields>();
		Fields field = new Fields();
		field.setId(194728103857l);
		field.setReadOnly(false);
		fields.add(field);
		module.setId(194728100125l);
		module.setSharedType("private");
		modules.add(module);
		userType.setModules(modules);
		userTypes.add(userType);
		bodyWrapper.setUserType(userTypes);
		APIResponse<ActionHandler> response = portalUserTypeOperations.createUserType(bodyWrapper);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ActionWrapper)
				{
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
					List<ActionResponse> actionResponses = actionWrapper.getUserType();
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
				Field[] fields1 = clas.getDeclaredFields();
				for (Field field1 : fields1)
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
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").redirectURL("Redirect_URL").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			String portal = "PortalsAPItest110";
			createUserType(portal);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
