package samples.fromaddresses;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.fromaddresses.APIException;
import com.zoho.crm.api.fromaddresses.Address;
import com.zoho.crm.api.fromaddresses.FromAddressesOperations;
import com.zoho.crm.api.fromaddresses.ResponseHandler;
import com.zoho.crm.api.fromaddresses.ResponseWrapper;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetEmailAddresses
{
	public static void getEmailAddresses(String userId) throws Exception
	{
		FromAddressesOperations sendMailsOperations = new FromAddressesOperations(userId);
		APIResponse<ResponseHandler> response = sendMailsOperations.getFromAddresses();
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
					List<Address> userAddresses = responseWrapper.getFromAddresses();
					for (Address userAddress : userAddresses)
					{
						System.out.println("UserAdress Email: " + userAddress.getEmail());
						System.out.println("UserAdress Type: " + userAddress.getType());
						System.out.println("UserAdress UserName: " + userAddress.getUserName());
						System.out.println("UserAdress Default: " + userAddress.getDefault());
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
			String userId = "";
			getEmailAddresses(userId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
