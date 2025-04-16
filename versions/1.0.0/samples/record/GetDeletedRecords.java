package samples.record;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.HeaderMap;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.record.APIException;
import com.zoho.crm.api.record.DeletedRecord;
import com.zoho.crm.api.record.DeletedRecordsHandler;
import com.zoho.crm.api.record.DeletedRecordsWrapper;
import com.zoho.crm.api.record.Info;
import com.zoho.crm.api.record.RecordOperations;
import com.zoho.crm.api.record.RecordOperations.GetDeletedRecordsHeader;
import com.zoho.crm.api.record.RecordOperations.GetDeletedRecordsParam;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetDeletedRecords
{
	public static void getDeletedRecords(String moduleAPIName) throws Exception
	{
		RecordOperations recordOperations = new RecordOperations(moduleAPIName);
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(GetDeletedRecordsParam.TYPE, "permanent");// all, recycle, permanent
		paramInstance.add(GetDeletedRecordsParam.PAGE, 1);
		paramInstance.add(GetDeletedRecordsParam.PER_PAGE, 2);
		HeaderMap headerInstance = new HeaderMap();
		OffsetDateTime ifModifiedSince = OffsetDateTime.of(2020, 05, 02, 12, 00, 30, 00, ZoneOffset.of("+05:30"));
		headerInstance.add(GetDeletedRecordsHeader.IF_MODIFIED_SINCE, ifModifiedSince);
		APIResponse<DeletedRecordsHandler> response = recordOperations.getDeletedRecords(paramInstance, headerInstance);
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
				DeletedRecordsHandler deletedRecordsHandler = response.getObject();
				if (deletedRecordsHandler instanceof DeletedRecordsWrapper)
				{
					DeletedRecordsWrapper deletedRecordsWrapper = (DeletedRecordsWrapper) deletedRecordsHandler;
					List<DeletedRecord> deletedRecords = deletedRecordsWrapper.getData();
					for (DeletedRecord deletedRecord : deletedRecords)
					{
						com.zoho.crm.api.users.MinifiedUser deletedBy = deletedRecord.getDeletedBy();
						if (deletedBy != null)
						{
							System.out.println("DeletedRecord Deleted By User-Name: " + deletedBy.getName());
							System.out.println("DeletedRecord Deleted By User-ID: " + deletedBy.getId());
						}
						System.out.println("DeletedRecord ID: " + deletedRecord.getId());
						System.out.println("DeletedRecord DisplayName: " + deletedRecord.getDisplayName());
						System.out.println("DeletedRecord Type: " + deletedRecord.getType());
						com.zoho.crm.api.users.MinifiedUser createdBy = deletedRecord.getCreatedBy();
						if (createdBy != null)
						{
							System.out.println("DeletedRecord Created By User-Name: " + createdBy.getName());
							System.out.println("DeletedRecord Created By User-ID: " + createdBy.getId());
						}
						System.out.println("DeletedRecord DeletedTime: " + deletedRecord.getDeletedTime());
					}
					Info info = deletedRecordsWrapper.getInfo();
					if (info != null)
					{
						if (info.getPerPage() != null)
						{
							System.out.println("Record Info PerPage: " + info.getPerPage().toString());
						}
						if (info.getCount() != null)
						{
							System.out.println("Record Info Count: " + info.getCount().toString());
						}
						if (info.getPage() != null)
						{
							System.out.println("Record Info Page: " + info.getPage().toString());
						}
						if (info.getMoreRecords() != null)
						{
							System.out.println("Record Info MoreRecords: " + info.getMoreRecords().toString());
						}
					}
				}
				else if (deletedRecordsHandler instanceof APIException)
				{
					APIException exception = (APIException) deletedRecordsHandler;
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
			getDeletedRecords(moduleAPIName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
