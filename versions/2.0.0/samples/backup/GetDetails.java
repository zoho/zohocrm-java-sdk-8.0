package samples.backup;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.backup.APIException;
import com.zoho.crm.api.backup.BackupOperations;
import com.zoho.crm.api.backup.ResponseWrapper;
import com.zoho.crm.api.backup.Requester;
import com.zoho.crm.api.backup.ResponseHandler;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetDetails
{
	public static void getDetails() throws Exception
	{
		BackupOperations backupOperations = new BackupOperations();
		APIResponse<ResponseHandler> response = backupOperations.getDetails();
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
					com.zoho.crm.api.backup.Backup backup = responseWrapper.getBackup();
					if (backup != null)
					{
						System.out.println("Backup Rrule: " + backup.getRrule());
						System.out.println("Backup Id: " + backup.getId());
						System.out.println("Backup StartDate: " + backup.getStartDate());
						System.out.println("Backup ScheduledDate: " + backup.getScheduledDate());
						System.out.println("Backup Status: " + backup.getStatus());
						Requester requester = backup.getRequester();
						if (requester != null)
						{
							System.out.println("Backup Requester Id: " + requester.getId());
							System.out.println("Backup Requester Name: " + requester.getName());
							System.out.println("Backup Requester Zuid: " + requester.getZuid());
						}
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
			getDetails();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
