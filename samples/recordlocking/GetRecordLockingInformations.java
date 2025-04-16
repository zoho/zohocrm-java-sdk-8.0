package samples.recordlocking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.recordlocking.APIException;
import com.zoho.crm.api.recordlocking.Info;
import com.zoho.crm.api.recordlocking.LockedForS;
import com.zoho.crm.api.recordlocking.RecordLockingOperations;
import com.zoho.crm.api.recordlocking.RecordLockingOperations.GetRecordLockingInformationsParam;
import com.zoho.crm.api.recordlocking.ResponseHandler;
import com.zoho.crm.api.recordlocking.ResponseWrapper;
import com.zoho.crm.api.users.MinifiedUser;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetRecordLockingInformations
{
	public static void getRecordLockingInformations(String moduleAPIName, Long recordId) throws Exception
	{
		RecordLockingOperations recordLockingOperations = new RecordLockingOperations(recordId, moduleAPIName);
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(GetRecordLockingInformationsParam.FIELDS, "Lock_Source__s");
		paramInstance.add(GetRecordLockingInformationsParam.PAGE_TOKEN, "");
		paramInstance.add(GetRecordLockingInformationsParam.PAGE, 1);
		paramInstance.add(GetRecordLockingInformationsParam.PER_PAGE, 2);
		APIResponse<ResponseHandler> response = recordLockingOperations.getRecordLockingInformations(paramInstance);
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
					List<com.zoho.crm.api.recordlocking.RecordLock> recordLocks = responseWrapper.getData();
					for (com.zoho.crm.api.recordlocking.RecordLock recordLock : recordLocks)
					{
						for (Map.Entry<String, Object> entry : recordLock.getKeyValues().entrySet())
						{
							String keyName = entry.getKey();
							Object value = entry.getValue();
							if(value instanceof MinifiedUser)
							{
								com.zoho.crm.api.users.MinifiedUser lockedByS = (MinifiedUser) value;
								if (lockedByS != null)
								{
									System.out.println("RecordLocking LockedByS User-ID: " + lockedByS.getId());
									System.out.println("RecordLocking LockedByS User-Name: " + lockedByS.getName());
									System.out.println("RecordLocking LockedByS User-Email: " + lockedByS.getEmail());
								}
							}
							if(value instanceof LockedForS)
							{
								LockedForS lockedForS = (LockedForS) value;
								if (lockedForS != null)
								{
									System.out.println("RecordLocking LockedForS By User-ID: " + lockedForS.getId());
									System.out.println("RecordLocking LockedForS By User-Name: " + lockedForS.getName());
									System.out.println("RecordLocking LockedForS Module KeyName : " + keyName + " - Value : ");
									for (Map.Entry<String, Object> mapValue : ((HashMap<String, Object>) lockedForS.getModule()).entrySet())
									{
										System.out.println(mapValue.getKey() + " : " + mapValue.getValue());
									}
								}
							}
							if (value instanceof List)
							{
								System.out.println("RecordLocking KeyName : " + keyName);
								List<?> dataList = (List<?>) value;
								for (Object data : dataList)
								{
									if (data instanceof Map)
									{
										System.out.println("RecordLocking KeyName : " + keyName + " - Value : ");
										for (Map.Entry<String, Object> mapValue : ((HashMap<String, Object>) data).entrySet())
										{
											System.out.println(mapValue.getKey() + " : " + mapValue.getValue());
										}
									}
									else
									{
										System.out.println(data);
									}
								}
							}
							else if (value instanceof Map)
							{
								System.out.println("RecordLocking KeyName : " + keyName + " - Value : ");
								for (Map.Entry<String, Object> mapValue : ((HashMap<String, Object>) value).entrySet())
								{
									System.out.println(mapValue.getKey() + " : " + mapValue.getValue());
								}
							}
							else
							{
								System.out.println("RecordLocking KeyName : " + keyName + " - Value : " + value);
							}
						}
					}
					Info info = responseWrapper.getInfo();
					if (info != null)
					{
						if (info.getCount() != null)
						{
							System.out.println("RecordLocking Info Count: " + info.getCount().toString());
						}
						if (info.getMoreRecords() != null)
						{
							System.out.println("RecordLocking Info MoreRecords: " + info.getMoreRecords().toString());
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
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			String moduleAPIName = "Leads";
			long recordId = 34770619001l;
			getRecordLockingInformations(moduleAPIName, recordId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
