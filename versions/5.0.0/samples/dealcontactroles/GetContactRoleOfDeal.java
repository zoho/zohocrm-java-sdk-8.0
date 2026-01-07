package samples.dealcontactroles;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.dealcontactroles.APIException;
import com.zoho.crm.api.dealcontactroles.ResponseWrapper;
import com.zoho.crm.api.dealcontactroles.Data;
import com.zoho.crm.api.dealcontactroles.DealContactRolesOperations;
import com.zoho.crm.api.dealcontactroles.Info;
import com.zoho.crm.api.dealcontactroles.ResponseHandler;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.users.MinifiedUser;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;
import com.zoho.crm.api.dealcontactroles.ContactRole;

public class GetContactRoleOfDeal
{

	@SuppressWarnings("unchecked")
	public static void getContactRoleOfDeal(Long contactId, Long dealId) throws IllegalArgumentException, IllegalAccessException, SDKException
	{
		DealContactRolesOperations contactRolesOperations = new DealContactRolesOperations();
		APIResponse<ResponseHandler> response = contactRolesOperations.getAssociatedContactRolesSpecificToContact(contactId, dealId);
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
					List<Data> records = responseWrapper.getData();
					for (Data record : records)
					{
						System.out.println("Record ID: " + record.getId());
						MinifiedUser createdBy = record.getCreatedBy();
						if (createdBy != null)
						{
							System.out.println("Record Created By User-ID: " + createdBy.getId());
							System.out.println("Record Created By User-Name: " + createdBy.getName());
							System.out.println("Record Created By User-Email: " + createdBy.getEmail());
						}
						System.out.println("Record CreatedTime: " + record.getCreatedTime());
						MinifiedUser modifiedBy = record.getModifiedBy();
						if (modifiedBy != null)
						{
							System.out.println("Record Modified By User-ID: " + modifiedBy.getId());
							System.out.println("Record Modified By User-Name: " + modifiedBy.getName());
							System.out.println("Record Modified By User-Email: " + modifiedBy.getEmail());
						}
						System.out.println("Record CreatedTime: " + record.getModifiedTime());
						// To get particular field value
						System.out.println("Record Field Value: " + record.getKeyValue("Last_Name"));// FieldApiName
						System.out.println("Record KeyValues:");
						for (Map.Entry<String, Object> entry : record.getKeyValues().entrySet())
						{
							String keyName = entry.getKey();
							Object value = entry.getValue();
							if (value instanceof List)
							{
								System.out.println("Record KeyName : " + keyName);
								List<?> dataList = (List<?>) value;
								for (Object data : dataList)
								{
									if (data instanceof Map)
									{
										System.out.println("Record KeyName : " + keyName + " - Value : ");
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
							else if (value instanceof ContactRole)
							{
								ContactRole contactrole = (ContactRole) value;
								if (contactrole != null)
								{
									System.out.println("Record ContactRole Name : " + contactrole.getName());
									System.out.println("Record ContactRole Id : " + contactrole.getId());
								}
							}
							else if (value instanceof Map)
							{
								System.out.println("Record KeyName : " + keyName + " - Value : ");
								for (Map.Entry<String, Object> mapValue : ((HashMap<String, Object>) value).entrySet())
								{
									System.out.println(mapValue.getKey() + " : " + mapValue.getValue());
								}
							}
							else
							{
								System.out.println("Record KeyName : " + keyName + " - Value : " + value);
							}
						}
					}
					Info info = responseWrapper.getInfo();
					if (info != null)
					{
						if (info.getCount() != null)
						{
							System.out.println("Record Info Count: " + info.getCount().toString());
						}
						if (info.getMoreRecords() != null)
						{
							System.out.println("Record Info MoreRecords: " + info.getMoreRecords().toString());
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
			else
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
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").redirectURL("Redirect_URL").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			Long dealId = 440248001177050l;
			Long contactId = 440248001030088l;
			getContactRoleOfDeal(contactId, dealId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
