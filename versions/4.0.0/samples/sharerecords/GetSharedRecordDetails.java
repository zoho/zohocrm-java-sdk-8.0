package samples.sharerecords;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.sharerecords.APIException;
import com.zoho.crm.api.sharerecords.ResponseHandler;
import com.zoho.crm.api.sharerecords.ResponseWrapper;
import com.zoho.crm.api.sharerecords.ShareRecord;
import com.zoho.crm.api.sharerecords.ShareRecordsOperations;
import com.zoho.crm.api.sharerecords.SharedThrough;
import com.zoho.crm.api.sharerecords.ShareRecordsOperations.GetSharedRecordDetailsParam;
import com.zoho.crm.api.users.Users;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetSharedRecordDetails
{
	public static void getSharedRecordDetails(String moduleAPIName, Long recordId) throws Exception
	{
		ShareRecordsOperations shareRecordsOperations = new ShareRecordsOperations(recordId, moduleAPIName);
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(GetSharedRecordDetailsParam.VIEW, "summary");
//		paramInstance.add(GetSharedRecordDetailsParam.SHAREDTO, 3477061173021l);
		APIResponse<ResponseHandler> response = shareRecordsOperations.getSharedRecordDetails(paramInstance);
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
					List<ShareRecord> shareRecords = responseWrapper.getShare();
					for (ShareRecord shareRecord : shareRecords)
					{

						Users sharedWith = shareRecord.getSharedWith();

						if (sharedWith != null)
						{
							System.out.println("ShareRecord sharedWith Name: " + sharedWith.getName());
							System.out.println("ShareRecord sharedWith Id: " + sharedWith.getId());
							System.out.println("ShareRecord sharedWith Type: " + sharedWith.getKeyValue("type"));
							System.out.println("ShareRecord sharedWith Zuid: " + sharedWith.getZuid());
						}

						System.out.println("ShareRecord ShareRelatedRecords: " + shareRecord.getShareRelatedRecords().toString());
						SharedThrough sharedThrough = shareRecord.getSharedThrough();
						if (sharedThrough != null)
						{
							com.zoho.crm.api.sharerecords.Module module = sharedThrough.getModule();
							if (module != null)
							{
								System.out.println("ShareRecord SharedThrough Module ID: " + module.getId().toString());
								System.out.println("ShareRecord SharedThrough Module Name: " + module.getName());
							}

							System.out.println("ShareRecord SharedThrough Name: " + sharedThrough.getName());
							System.out.println("ShareRecord SharedThrough ID: " + sharedThrough.getId());
						}
						System.out.println("ShareRecord SharedTime: " + shareRecord.getSharedTime());
						System.out.println("ShareRecord Permission: " + shareRecord.getPermission());
						com.zoho.crm.api.users.Users sharedBy = shareRecord.getSharedBy();
						if (sharedBy != null)
						{
							System.out.println("ShareRecord SharedBy-ID: " + sharedBy.getId());
							System.out.println("ShareRecord SharedBy-Name: " + sharedBy.getName());
							System.out.println("ShareRecord SharedBy-Zuid: " + sharedBy.getZuid());
						}
						com.zoho.crm.api.users.Users user = shareRecord.getUser();
						if (user != null)
						{
							System.out.println("ShareRecord User-ID: " + user.getId());
							System.out.println("ShareRecord User-Name: " + user.getName());
							System.out.println("ShareRecord User-Zuid: " + user.getZuid());
						}
						System.out.println("ShareRecord Type: " + shareRecord.getType().getValue());
					}
					if (responseWrapper.getShareableUser() != null)
					{
						List<com.zoho.crm.api.users.Users> shareableUsers = responseWrapper.getShareableUser();
						for (com.zoho.crm.api.users.Users shareableUser : shareableUsers)
						{
							System.out.println("ShareRecord User-ID: " + shareableUser.getId());
							System.out.println("ShareRecord User-FullName: " + shareableUser.getFullName());
							System.out.println("ShareRecord User-Zuid: " + shareableUser.getZuid());
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
			getSharedRecordDetails(moduleAPIName, recordId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
