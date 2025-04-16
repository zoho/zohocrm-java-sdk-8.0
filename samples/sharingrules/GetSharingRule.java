package samples.sharingrules;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.sharingrules.APIException;
import com.zoho.crm.api.sharingrules.SharingRules;
import com.zoho.crm.api.sharingrules.SharingRulesOperations;
import com.zoho.crm.api.sharingrules.ResponseHandler;
import com.zoho.crm.api.sharingrules.ResponseWrapper;
import com.zoho.crm.api.sharingrules.Module;
import com.zoho.crm.api.sharingrules.Shared;
import com.zoho.crm.api.sharingrules.Resource;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetSharingRule
{
	public static void getSharingRule(String moduleAPIName, Long id) throws Exception
	{
		SharingRulesOperations sharingRulesOperations = new SharingRulesOperations(moduleAPIName);
		APIResponse<ResponseHandler> response = sharingRulesOperations.getSharingRule(id);
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
					List<SharingRules> sharingRules = responseWrapper.getSharingRules();
					for (SharingRules sharingRule : sharingRules)
					{
						Module module = sharingRule.getModule();
						if(module != null)
						{
							System.out.println("SharingRules Module APIName: " + module.getAPIName());
							System.out.println("SharingRules Module Name: " + module.getName());
							System.out.println("SharingRules Module Id: " + module.getId());
						}
						System.out.println("SharingRules SuperiorsAllowed: " + sharingRule.getSuperiorsAllowed());
						System.out.println("SharingRules Type: " + sharingRule.getType().getValue());
						Shared sharedTo = sharingRule.getSharedTo();
						if(sharedTo != null)
						{
							Resource resource = sharedTo.getResource();
							if(resource != null)
							{
								System.out.println("SharingRules SharedTo Resource Name: " + resource.getName());
								System.out.println("SharingRules SharedTo Resource Id: " + resource.getId());
							}
							System.out.println("SharingRules SharedTo Type: " + sharedTo.getType());
							System.out.println("SharingRules SharedTo Subordinates: " + sharedTo.getSubordinates());
						}
						
						Shared sharedFrom = sharingRule.getSharedFrom();
						if(sharedFrom != null)
						{
							Resource resource = sharedFrom.getResource();
							if(resource != null)
							{
								System.out.println("SharingRules SharedFrom Resource Name: " + resource.getName());
								System.out.println("SharingRules SharedFrom Resource Id: " + resource.getId());
							}
							System.out.println("SharingRules SharedFrom Type: " + sharedFrom.getType());
							System.out.println("SharingRules SharedFrom Subordinates: " + sharedFrom.getSubordinates());
						}
						
						System.out.println("SharingRules PermissionType: " + sharingRule.getPermissionType().getValue());
						System.out.println("SharingRules Name: " + sharingRule.getName());
						System.out.println("SharingRules Id: " + sharingRule.getId());
						System.out.println("SharingRules Status: " + sharingRule.getStatus().getValue());
						System.out.println("SharingRules MatchLimitExceeded: " + sharingRule.getMatchLimitExceeded());
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
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			String moduleAPIName = "Leads";
			Long id = 347706151001l;
			getSharingRule(moduleAPIName, id);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
