package samples.backup;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.backup.APIException;
import com.zoho.crm.api.backup.BackupOperations;
import com.zoho.crm.api.backup.ResponseHandler;
import com.zoho.crm.api.backup.Urls;
import com.zoho.crm.api.backup.UrlsWrapper;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetUrls
{
	public static void getUrls() throws Exception
	{
		BackupOperations backupOperations = new BackupOperations();
		APIResponse<ResponseHandler> response = backupOperations.getUrls();
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
				if (responseHandler instanceof UrlsWrapper)
				{
					UrlsWrapper responseWrapper = (UrlsWrapper) responseHandler;
					Urls urls = responseWrapper.getUrls();
					if (urls != null)
					{
						List<String> dataLinks = urls.getDataLinks();
						if (dataLinks != null)
						{
							System.out.println("Urls DataLinks: ");
							dataLinks.forEach(url ->
							{
								System.out.println(url);
							});
						}
						List<String> attachmentLinks = urls.getAttachmentLinks();
						if (attachmentLinks != null)
						{
							System.out.println("Urls AttachmentLinks: ");
							attachmentLinks.forEach(url ->
							{
								System.out.println(url);
							});
						}
						System.out.println("Urls ExpiryDate: " + urls.getExpiryDate());
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
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").redirectURL("Redirect_URL").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			getUrls();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
