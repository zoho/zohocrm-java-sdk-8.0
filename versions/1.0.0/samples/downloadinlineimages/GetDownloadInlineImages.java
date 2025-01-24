package samples.downloadinlineimages;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.downloadinlineimages.APIException;
import com.zoho.crm.api.downloadinlineimages.DownloadInlineImagesOperations;
import com.zoho.crm.api.downloadinlineimages.DownloadInlineImagesOperations.GetDownloadInlineImagesParam;
import com.zoho.crm.api.downloadinlineimages.FileBodyWrapper;
import com.zoho.crm.api.downloadinlineimages.ResponseHandler;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;
import com.zoho.crm.api.util.StreamWrapper;
import com.zoho.crm.api.dc.DataCenter.Environment;

public class GetDownloadInlineImages
{
	public static void getDownloadInlineImages(String module, Long recordId, Long userId, String messageId, String id, String destinationFolder) throws Exception
	{
		DownloadInlineImagesOperations downloadInlineImagesOperations = new DownloadInlineImagesOperations();
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(GetDownloadInlineImagesParam.MESSAGE_ID, messageId);
		paramInstance.add(GetDownloadInlineImagesParam.USER_ID, userId);
		paramInstance.add(GetDownloadInlineImagesParam.ID, id);
		APIResponse<ResponseHandler> response = downloadInlineImagesOperations.getDownloadInlineImages(recordId, module, paramInstance);
		if (response != null)
		{
			System.out.println("Status Code : " + response.getStatusCode());
			if (response.getStatusCode() == 204)
			{
				System.out.println("No Content");
				return;
			}
			if (response.isExpected())
			{
				ResponseHandler responseHandler = response.getObject();
				if (responseHandler instanceof FileBodyWrapper)
				{
					FileBodyWrapper fileBodyWrapper = (FileBodyWrapper) responseHandler;
					StreamWrapper streamWrapper = fileBodyWrapper.getFile();
					File file = new File(destinationFolder + File.separatorChar + streamWrapper.getName());
					InputStream is = streamWrapper.getStream();
					OutputStream os = new FileOutputStream(file);
					byte[] buffer = new byte[1024];
					int bytesRead;
					while ((bytesRead = is.read(buffer)) != -1)
					{
						os.write(buffer, 0, bytesRead);
					}
					is.close();
					os.flush();
					os.close();
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
					System.out.println("Message: " + exception.getMessage().getValue());
				}
			}
			else
			{
				Model responseObject = response.getModel();
				Class<? extends Model> clas = responseObject.getClass();
				java.lang.reflect.Field[] fields = clas.getDeclaredFields();
				for (java.lang.reflect.Field field : fields)
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
			String module = "Leads";
			Long recordId = 4402480774074l;
			Long userId = 4402480254001l;
			String id = "645baab5ea43dd52829264d7d1017304deeb964d78a3321";
			String messageId = "c6085fae06cbd7b75001fefab46bf0f413bb368a1d6902b140927cfe9e18";
			String destinationFolder = "/users/zohocrm-java-sdk-sample/file";
			getDownloadInlineImages(module, recordId, userId, messageId, id, destinationFolder);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
