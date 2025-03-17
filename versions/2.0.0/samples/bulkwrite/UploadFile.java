package samples.bulkwrite;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.HeaderMap;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.bulkwrite.APIException;
import com.zoho.crm.api.bulkwrite.ActionResponse;
import com.zoho.crm.api.bulkwrite.BulkWriteOperations;
import com.zoho.crm.api.bulkwrite.BulkWriteOperations.UploadFileHeader;
import com.zoho.crm.api.bulkwrite.SuccessResponse;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;
import com.zoho.crm.api.util.StreamWrapper;
import java.util.Map;

public class UploadFile
{
	public static void uploadFile(String orgID, String absoluteFilePath) throws Exception
	{

		BulkWriteOperations bulkWriteOperations = new BulkWriteOperations();
		com.zoho.crm.api.bulkwrite.FileBodyWrapper fileBodyWrapper = new com.zoho.crm.api.bulkwrite.FileBodyWrapper();
		StreamWrapper streamWrapper = new StreamWrapper(absoluteFilePath);
		// FileInputStream stream = new FileInputStream(absoluteFilePath);
		// StreamWrapper streamWrapper = new StreamWrapper("Leads.zip", stream);
		fileBodyWrapper.setFile(streamWrapper);
		HeaderMap headerInstance = new HeaderMap();
		headerInstance.add(UploadFileHeader.FEATURE, "bulk-write");
		headerInstance.add(UploadFileHeader.X_CRM_ORG, orgID);
		APIResponse<ActionResponse> response = bulkWriteOperations.uploadFile(fileBodyWrapper, headerInstance);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionResponse actionResponse = response.getObject();
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
					System.out.println("Message: " + successResponse.getMessage().getValue());
				}
				else if (actionResponse instanceof APIException)
				{
					APIException exception = (APIException) actionResponse;
					if (exception.getStatus() != null)
					{
						System.out.println("Status: " + exception.getStatus().getValue());
					}
					if (exception.getCode() != null)
					{
						System.out.println("Code: " + exception.getCode().getValue());
					}
					if (exception.getMessage() != null)
					{
						System.out.println("Message: " + exception.getMessage().getValue());
					}
					System.out.println("Details: ");
					if (exception.getDetails() != null)
					{
						for (Map.Entry<String, Object> entry : exception.getDetails().entrySet())
						{
							System.out.println(entry.getKey() + ": " + entry.getValue());
						}
					}
					if (exception.getErrorMessage() != null)
					{
						System.out.println("ErrorMessage: " + exception.getErrorMessage().getValue());
					}
					System.out.println("ErrorCode: " + exception.getErrorCode());
					if (exception.getXError() != null)
					{
						System.out.println("XError: " + exception.getXError().getValue());
					}
					if (exception.getInfo() != null)
					{
						System.out.println("Info: " + exception.getInfo().getValue());
					}
					if (exception.getXInfo() != null)
					{
						System.out.println("XInfo: " + exception.getXInfo().getValue());
					}
					System.out.println("HttpStatus: " + exception.getHttpStatus());
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
			String orgID = "xxxxx";
			String absoluteFilePath = "/Users/Leads.zip";
			uploadFile(orgID, absoluteFilePath);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
