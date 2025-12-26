package samples.auditlogexport;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.auditlogexport.APIException;
import com.zoho.crm.api.auditlogexport.AuditLogExportOperations;
import com.zoho.crm.api.auditlogexport.FileBodyWrapper;
import com.zoho.crm.api.auditlogexport.ResponseHandler;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;
import com.zoho.crm.api.util.StreamWrapper;

public class DownloadExportAuditLogResult
{
	public static void downloadExportAuditLogResult(String downloadUrl, String destinationFolder) throws Exception
	{
		AuditLogExportOperations auditLogExportOperations = new AuditLogExportOperations();
		APIResponse<ResponseHandler> response = auditLogExportOperations.downloadExportAuditLogResult(downloadUrl);
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
					if (exception.getStatus() != null)
					{
						System.out.println("Status: " + exception.getStatus().getValue());
					}
					if (exception.getCode() != null)
					{
						System.out.println("Code: " + exception.getCode().getValue());
					}
					if (exception.getDetails() != null)
					{
						System.out.println("Details: ");
						for (Map.Entry<String, Object> entry : exception.getDetails().entrySet())
						{
							System.out.println(entry.getKey() + ": " + entry.getValue());
						}
					}
					if (exception.getMessage() != null)
					{
						System.out.println("Message: " + exception.getMessage());
					}
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
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			String downloadUrl = "https://download-accl.zoho.com/v2/crm/xxxxx/auditlog/3477725001/AuditLog.csv";
			String destinationFolder = "/Users/user_name/Documents";
			downloadExportAuditLogResult(downloadUrl, destinationFolder);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
