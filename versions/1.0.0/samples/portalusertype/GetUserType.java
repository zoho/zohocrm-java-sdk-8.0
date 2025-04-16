package samples.portalusertype;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.portalusertype.PortalUserTypeOperations;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.portalusertype.APIException;
import com.zoho.crm.api.portalusertype.Fields;
import com.zoho.crm.api.portalusertype.Filters;
import com.zoho.crm.api.portalusertype.Layouts;
import com.zoho.crm.api.portalusertype.Modules;
import com.zoho.crm.api.portalusertype.Permissions;
import com.zoho.crm.api.portalusertype.PersonalityModule;
import com.zoho.crm.api.portalusertype.ResponseHandler;
import com.zoho.crm.api.portalusertype.ResponseWrapper;
import com.zoho.crm.api.portalusertype.Views;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetUserType
{
	public static void getUserType(String portalName, String userTypeId) throws Exception
	{
		PortalUserTypeOperations userTypeOperations = new PortalUserTypeOperations(portalName);
		APIResponse<ResponseHandler> response = userTypeOperations.getUserType(userTypeId);
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
					List<com.zoho.crm.api.portalusertype.UserType> userType = responseWrapper.getUserType();
					for (com.zoho.crm.api.portalusertype.UserType userType1 : userType)
					{
						System.out.println("UserType Default: " + userType1.getDefault());

						PersonalityModule personalityModule = userType1.getPersonalityModule();
						if (personalityModule != null)
						{
							System.out.println("UserType PersonalityModule ID: " + personalityModule.getId());
							System.out.println("UserType PersonalityModule APIName: " + personalityModule.getAPIName());

							System.out.println("UserType PersonalityModule PluralLabel: " + personalityModule.getPluralLabel());
						}

						System.out.println("UserType Name: " + userType1.getName());

						System.out.println("UserType Active: " + userType1.getActive());

						System.out.println("UserType Id: " + userType1.getId());
						System.out.println("UserType NoOfUsers: " + userType1.getNoOfUsers());

						List<Modules> modules = userType1.getModules();
						if (modules != null)
						{
							modules.forEach(module ->
							{
								System.out.println("UserType Modules PluralLabel: " + module.getPluralLabel());
								System.out.println("UserType Modules SharedType: " + module.getSharedType());

								System.out.println("UserType Modules APIName: " + module.getAPIName());

								Permissions permissions = module.getPermissions();

								if (permissions != null)
								{
									System.out.println("UserType Modules Permissions View: " + permissions.getView());

									System.out.println("UserType Modules Permissions Edit: " + permissions.getEdit());

									System.out.println("UserType Modules Permissions EditSharedRecords: " + permissions.getEditSharedRecords());

									System.out.println("UserType Modules Permissions Create: " + permissions.getCreate());

									System.out.println("UserType Modules Permissions Delete: " + permissions.getDelete());
								}

								System.out.println("UserType Modules Id: " + module.getId());

								List<Filters> filters = module.getFilters();

								if (filters != null)
								{
									filters.forEach(filter ->
									{
										System.out.println("UserType Modules Filters APIName: " + filter.getAPIName());

										System.out.println("UserType Modules Filters DisplayLabel: " + filter.getDisplayLabel());

										System.out.println("UserType Modules Filters Id: " + filter.getId());
									});
								}

								List<Fields> fields = module.getFields();

								if (fields != null)
								{
									fields.forEach(field ->
									{
										System.out.println("UserType Modules Fields APIName: " + field.getAPIName());

										System.out.println("UserType Modules Fields ReadOnly: " + field.getReadOnly());

										System.out.println("UserType Modules Fields Id: " + field.getId());
									});
								}

								List<Layouts> layouts = module.getLayouts();

								if (layouts != null)
								{
									layouts.forEach(layout ->
									{
										System.out.println("UserType Modules Layouts Name: " + layout.getName());

										System.out.println("UserType Modules Layouts DisplayLabel: " + layout.getDisplayLabel());

										System.out.println("UserType Modules Layouts Id: " + layout.getId());
									});
								}

								Views views = module.getViews();

								if (views != null)
								{
									System.out.println("UserType Modules Views DisplayLabel: " + views.getDisplayLabel());

									System.out.println("UserType Modules Views Name: " + views.getName());

									System.out.println("UserType Modules Views Id: " + views.getId());

									System.out.println("UserType Modules Permissions Type: " + views.getType());
								}
							});
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
			String portalName = "PortalsAPItest100";
			String userTypeId = "440248001304019";
			getUserType(portalName, userTypeId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
