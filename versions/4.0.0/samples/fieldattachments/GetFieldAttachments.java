package samples.fieldattachments;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.fieldattachments.APIException;
import com.zoho.crm.api.fieldattachments.FieldAttachmentsOperations;
import com.zoho.crm.api.fieldattachments.FileBodyWrapper;
import com.zoho.crm.api.fieldattachments.ResponseHandler;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;
import com.zoho.crm.api.util.StreamWrapper;

public class GetFieldAttachments
{
	public static void getFieldAttachments(String destinationFolder, String moduleAPIName, Long recordId, Long attachmentID) throws Exception
	{
		FieldAttachmentsOperations fieldAttachmentsOperations = new FieldAttachmentsOperations(moduleAPIName, recordId, attachmentID);
		APIResponse<ResponseHandler> response = fieldAttachmentsOperations.getFieldAttachments();
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
					java.io.File file = new java.io.File(destinationFolder + java.io.File.separatorChar + streamWrapper.getName());
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
					System.out.println("Message: " + exception.getMessage());
				}
			}
			else if (response.getStatusCode() != 204)
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
			String destinationFolder = "/users/zohocrm-java-sdk-sample/file";
			String moduleAPIName = "Leads";
			Long recordId = 4402480774074l;
			Long attachmentID = 440248001286011l;
			getFieldAttachments(destinationFolder, moduleAPIName, recordId, attachmentID);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
