package samples.record;

import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.record.APIException;
import com.zoho.crm.api.record.FileBodyWrapper;
import com.zoho.crm.api.record.FileHandler;
import com.zoho.crm.api.record.RecordOperations;
import com.zoho.crm.api.record.SuccessResponse;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;
import com.zoho.crm.api.util.StreamWrapper;

public class UploadPhoto
{
	public static void uploadPhoto(String moduleAPIName, long recordId, String absoluteFilePath) throws Exception
	{
		RecordOperations recordOperations = new RecordOperations(moduleAPIName);
		FileBodyWrapper fileBodyWrapper = new FileBodyWrapper();
		StreamWrapper streamWrapper = new StreamWrapper(absoluteFilePath);
		fileBodyWrapper.setFile(streamWrapper);
		ParameterMap paramInstance = new ParameterMap();
//		paramInstance.add(UploadPhotoParam.RESTRICT_TRIGGERS, "workflow");
		APIResponse<FileHandler> response = recordOperations.uploadPhoto(recordId, fileBodyWrapper, paramInstance);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				FileHandler fileHandler = response.getObject();
				if (fileHandler instanceof SuccessResponse)
				{
					SuccessResponse successResponse = (SuccessResponse) fileHandler;
					System.out.println("Status: " + successResponse.getStatus().getValue());
					System.out.println("Code: " + successResponse.getCode().getValue());
					System.out.println("Details: ");
					for (Map.Entry<String, Object> entry : successResponse.getDetails().entrySet())
					{
						System.out.println(entry.getKey() + ": " + entry.getValue());
					}
					System.out.println("Message: " + successResponse.getMessage().getValue());
				}
				else if (fileHandler instanceof APIException)
				{
					APIException exception = (APIException) fileHandler;
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
			String moduleAPIName = "Leads";
			Long recordId = 34770615177002L;
			String absoluteFilePath = "/Users/zohocrm-java-sdk-sample/file/download.png";
			uploadPhoto(moduleAPIName, recordId, absoluteFilePath);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
