package samples.sharerecords;

import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.sharerecords.APIException;
import com.zoho.crm.api.sharerecords.DeleteActionHandler;
import com.zoho.crm.api.sharerecords.DeleteActionResponse;
import com.zoho.crm.api.sharerecords.DeleteActionWrapper;
import com.zoho.crm.api.sharerecords.ShareRecordsOperations;
import com.zoho.crm.api.sharerecords.SuccessResponse;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class RevokeSharedRecord
{
	public static void revokeSharedRecord(String moduleAPIName, Long recordId) throws Exception
	{
		ShareRecordsOperations shareRecordsOperations = new ShareRecordsOperations(recordId, moduleAPIName);
		APIResponse<DeleteActionHandler> response = shareRecordsOperations.revokeSharedRecord();
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				DeleteActionHandler deleteActionHandler = response.getObject();
				if (deleteActionHandler instanceof DeleteActionWrapper)
				{
					DeleteActionWrapper deleteActionWrapper = (DeleteActionWrapper) deleteActionHandler;
					DeleteActionResponse deleteActionResponse = deleteActionWrapper.getShare();
					if (deleteActionResponse instanceof SuccessResponse)
					{
						SuccessResponse successResponse = (SuccessResponse) deleteActionResponse;
						System.out.println("Status: " + successResponse.getStatus().getValue());
						System.out.println("Code: " + successResponse.getCode().getValue());
						System.out.println("Details: ");
						for (Map.Entry<String, Object> entry : successResponse.getDetails().entrySet())
						{
							System.out.println(entry.getKey() + ": " + entry.getValue());
						}
						System.out.println("Message: " + successResponse.getMessage().getValue());
					}
					else if (deleteActionResponse instanceof APIException)
					{
						APIException exception = (APIException) deleteActionResponse;
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
				else if (deleteActionHandler instanceof APIException)
				{
					APIException exception = (APIException) deleteActionHandler;
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
			Long recordId = 347706114963002l;
			String moduleAPIName = "Leads";
			revokeSharedRecord(moduleAPIName, recordId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
