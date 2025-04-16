package samples.modules;

import java.lang.reflect.Field;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.HeaderMap;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.modules.APIException;
import com.zoho.crm.api.modules.Argument;
import com.zoho.crm.api.modules.MinifiedModule;
import com.zoho.crm.api.modules.Modules;
import com.zoho.crm.api.modules.ModulesOperations;
import com.zoho.crm.api.modules.ResponseHandler;
import com.zoho.crm.api.modules.ResponseWrapper;
import com.zoho.crm.api.modules.ModulesOperations.GetModulesHeader;
import com.zoho.crm.api.modules.ModulesOperations.GetModulesParam;
import com.zoho.crm.api.profiles.MinifiedProfile;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;

public class GetModules
{
	public static void getModules() throws Exception
	{
		ModulesOperations moduleOperations = new ModulesOperations();
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(GetModulesParam.STATUS, new Choice<String>("user_hidden"));//user_hidden,system_hidden,scheduled_for_deletion,visible
		HeaderMap headerInstance = new HeaderMap();
		OffsetDateTime ifmodifiedsince = OffsetDateTime.of(2020, 05, 20, 10, 00, 00, 01, ZoneOffset.of("+05:30"));
		headerInstance.add(GetModulesHeader.IF_MODIFIED_SINCE, ifmodifiedsince);
		APIResponse<ResponseHandler> response = moduleOperations.getModules(paramInstance, headerInstance);
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
					List<Modules> modules = responseWrapper.getModules();
					for (Modules module : modules)
					{
						System.out.println("Module GlobalSearchSupported: " + module.getGlobalSearchSupported());
						System.out.println("Module Deletable: " + module.getDeletable());
						System.out.println("Module Description: " + module.getDescription());
						System.out.println("Module Creatable: " + module.getCreatable());
						System.out.println("Module InventoryTemplateSupported: " + module.getInventoryTemplateSupported());
						if (module.getModifiedTime() != null)
						{
							System.out.println("Module ModifiedTime: " + module.getModifiedTime());
						}
						System.out.println("Module PluralLabel: " + module.getPluralLabel());
						System.out.println("Module PresenceSubMenu: " + module.getPresenceSubMenu());
						System.out.println("Module TriggersSupported: " + module.getTriggersSupported());
						System.out.println("Module Id: " + module.getId());
						System.out.println("Module IsBlueprintSupported: " + module.getIsblueprintsupported());
						System.out.println("Module visible: " + module.getVisible());
						System.out.println("Module Visibility: " + module.getVisibility());
						System.out.println("Module Convertable: " + module.getConvertable());
						System.out.println("Module Editable: " + module.getEditable());
						System.out.println("Module EmailtemplateSupport: " + module.getEmailtemplateSupport());
						List<MinifiedProfile> profiles = module.getProfiles();
						if (profiles != null)
						{
							for (MinifiedProfile profile : profiles)
							{
								System.out.println("Module Profile Name: " + profile.getName());
								System.out.println("Module Profile Id: " + profile.getId());
							}
						}
						System.out.println("Module FilterSupported: " + module.getFilterSupported());
						System.out.println("Module ShowAsTab: " + module.getShowAsTab());
						System.out.println("Module WebLink: " + module.getWebLink());
						System.out.println("Module SequenceNumber: " + module.getSequenceNumber());
						System.out.println("Module SingularLabel: " + module.getSingularLabel());
						System.out.println("Module Viewable: " + module.getViewable());
						System.out.println("Module APISupported: " + module.getAPISupported());
						System.out.println("Module APIName: " + module.getAPIName());
						System.out.println("Module QuickCreate: " + module.getQuickCreate());
						com.zoho.crm.api.users.MinifiedUser modifiedBy = module.getModifiedBy();
						if (modifiedBy != null)
						{
							System.out.println("Module Modified By User-Name: " + modifiedBy.getName());
							System.out.println("Module Modified By User-ID: " + modifiedBy.getId());
						}
						System.out.println("Module GeneratedType: " + module.getGeneratedType().getValue());
						System.out.println("Module FeedsRequired: " + module.getFeedsRequired());
						System.out.println("Module ScoringSupported: " + module.getScoringSupported());
						System.out.println("Module WebformSupported: " + module.getWebformSupported());
						List<Argument> arguments = module.getArguments();
						if (arguments != null)
						{
							for (Argument argument : arguments)
							{
								System.out.println("Module Argument Name: " + argument.getName());
								System.out.println("Module Argument Value: " + argument.getValue());
							}
						}
						System.out.println("Module ModuleName: " + module.getModuleName());
						System.out.println("Module BusinessCardFieldLimit: " + module.getBusinessCardFieldLimit());
						MinifiedModule parentModule = module.getParentModule();
						if (parentModule != null)
						{
							System.out.println("Module Parent Module Name: " + parentModule.getAPIName());
							System.out.println("Module Parent Module Id: " + parentModule.getId());
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
			getModules();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
