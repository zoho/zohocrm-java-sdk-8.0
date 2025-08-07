package samples.portalusertype;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.portalusertype.PortalUserTypeOperations;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.portalusertype.APIException;
import com.zoho.crm.api.portalusertype.Owner;
import com.zoho.crm.api.portalusertype.PersonalityModule;
import com.zoho.crm.api.portalusertype.ResponseHandler;
import com.zoho.crm.api.portalusertype.ResponseWrapper;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetUserTypes
{
	public static void getUserTypes(String portalName) throws Exception
	{
		PortalUserTypeOperations userTypeOperations = new PortalUserTypeOperations(portalName);
		ParameterMap paramInstance = new ParameterMap();
		APIResponse<ResponseHandler> response = userTypeOperations.getUserTypes(paramInstance);
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
						System.out.println("UserType CreatedTime: " + userType1.getCreatedTime());

						System.out.println("UserType Default: " + userType1.getDefault());

						System.out.println("UserType ModifiedTime: " + userType1.getModifiedTime());

						PersonalityModule personalityModule = userType1.getPersonalityModule();
						if (personalityModule != null)
						{
							System.out.println("UserType PersonalityModule ID: " + personalityModule.getId());
							System.out.println("UserType PersonalityModule APIName: " + personalityModule.getAPIName());

							System.out.println("UserType PersonalityModule PluralLabel: " + personalityModule.getPluralLabel());
						}

						System.out.println("UserType Name: " + userType1.getName());

						Owner modifiedBy = userType1.getModifiedBy();
						if (modifiedBy != null)
						{
							System.out.println("UserType ModifiedBy User-ID: " + modifiedBy.getId());
							System.out.println("UserType ModifiedBy User-Name: " + modifiedBy.getName());
						}

						System.out.println("UserType Active: " + userType1.getActive());

						System.out.println("UserType Id: " + userType1.getId());

						Owner createdBy = userType1.getCreatedBy();
						if (createdBy != null)
						{
							System.out.println("UserType CreatedBy User-ID: " + createdBy.getId());
							System.out.println("UserType CreatedBy User-Name: " + createdBy.getName());
						}

						System.out.println("UserType NoOfUsers: " + userType1.getNoOfUsers());
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
			getUserTypes(portalName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
