package samples.sharerecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.sharerecords.APIException;
import com.zoho.crm.api.sharerecords.ActionHandler;
import com.zoho.crm.api.sharerecords.ActionResponse;
import com.zoho.crm.api.sharerecords.ActionWrapper;
import com.zoho.crm.api.sharerecords.BodyWrapper;
import com.zoho.crm.api.sharerecords.ShareRecordsOperations;
import com.zoho.crm.api.sharerecords.SuccessResponse;
import com.zoho.crm.api.users.Users;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;

public class ShareRecord
{
	public static void shareRecord(String moduleAPIName, Long recordId) throws Exception
	{
		ShareRecordsOperations shareRecordsOperations = new ShareRecordsOperations(recordId, moduleAPIName);
		BodyWrapper request = new BodyWrapper();
		List<com.zoho.crm.api.sharerecords.ShareRecord> shareList = new ArrayList<com.zoho.crm.api.sharerecords.ShareRecord>();
		com.zoho.crm.api.sharerecords.ShareRecord share1 = new com.zoho.crm.api.sharerecords.ShareRecord();
		for (int i = 0; i < 9; i++)
		{
			share1 = new com.zoho.crm.api.sharerecords.ShareRecord();
			share1.setShareRelatedRecords(true);
			share1.setPermission("read_write");
			Users user = new Users();
			user.setId(3477061173021l);
			share1.setUser(user);
			Users sharedWith = new Users();
			sharedWith.setId(34770615791024l);
			sharedWith.addKeyValue("type", "users");
			share1.setSharedWith(sharedWith);
			share1.setType(new Choice<String>("private"));
			shareList.add(share1);
		}
		share1 = new com.zoho.crm.api.sharerecords.ShareRecord();
		share1.setShareRelatedRecords(true);
		share1.setPermission("read_write");
		Users user = new Users();
		user.setId(3477061173021l);
		share1.setUser(user);
		Users sharedWith = new Users();
		sharedWith.setId(34770615791024l);
		sharedWith.addKeyValue("type", "users");
		share1.setSharedWith(sharedWith);
		share1.setType(new Choice<String>("private"));
		shareList.add(share1);
		request.setNotify(true);
		request.setShare(shareList);
		APIResponse<ActionHandler> response = shareRecordsOperations.shareRecord(request);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ActionWrapper)
				{
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
					List<ActionResponse> actionResponses = actionWrapper.getShare();
					for (ActionResponse actionResponse : actionResponses)
					{
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
				}
				else if (actionHandler instanceof APIException)
				{
					APIException exception = (APIException) actionHandler;
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
			shareRecord(moduleAPIName, recordId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
