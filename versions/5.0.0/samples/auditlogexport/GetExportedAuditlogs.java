package samples.auditlogexport;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.auditlogexport.APIException;
import com.zoho.crm.api.auditlogexport.AuditLogExport;
import com.zoho.crm.api.auditlogexport.AuditLogExportOperations;
import com.zoho.crm.api.auditlogexport.ResponseHandler;
import com.zoho.crm.api.auditlogexport.ResponseWrapper;
import com.zoho.crm.api.auditlogexport.User;
import com.zoho.crm.api.auditlogexport.Criteria;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetExportedAuditlogs
{
	public static void getExportedAuditlogs() throws Exception
	{
		AuditLogExportOperations auditLogExportOperations = new AuditLogExportOperations();
		APIResponse<ResponseHandler> response = auditLogExportOperations.getExportedAuditlogs();
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.getStatusCode() == 204)
			{
				System.out.println("No Content");
				return;
			}
			if (response.isExpected())
			{
				ResponseHandler responseHandler = response.getObject();
				if (responseHandler instanceof ResponseWrapper)
				{
					ResponseWrapper responseWrapper = (ResponseWrapper) responseHandler;
					List<AuditLogExport> auditLogExport = responseWrapper.getAuditLogExport();
					if (auditLogExport != null)
					{
						for(AuditLogExport auditLogExport1 : auditLogExport)
						{
							Criteria criteria = auditLogExport1.getCriteria();
							if (criteria != null)
							{
								printCriteria(criteria);
							}
							System.out.println("AuditLogExport Id : " + auditLogExport1.getId());
							System.out.println("AuditLogExport Status : " + auditLogExport1.getStatus());
							User createdBy = auditLogExport1.getCreatedBy();
							if(createdBy != null)
							{
								System.out.println("AuditLogExport User Id : " + createdBy.getId());
								System.out.println("AuditLogExport User Id : " + createdBy.getName());
							}
							List<String> downloadLinks = auditLogExport1.getDownloadLinks();
							if(downloadLinks != null)
							{
								for(String link : downloadLinks)
								{
									System.out.println("AuditLogExport DownloadLink : " + link);
								}
							}
							System.out.println("AuditLogExport JobStartTime : " + auditLogExport1.getJobStartTime());
							System.out.println("AuditLogExport JobEndTime : " + auditLogExport1.getJobEndTime());
							System.out.println("AuditLogExport ExpiryDate : " + auditLogExport1.getExpiryDate());
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
				for (Field field1 : fields)
				{
					field1.setAccessible(true);
					System.out.println(field1.getName() + ":" + field1.get(responseObject));
				}
			}
		}
	}
	
	private static void printCriteria(Criteria criteria)
	{
		if (criteria.getComparator() != null)
		{
			System.out.println("ExportedAuditlogs Criteria Comparator: " + criteria.getComparator());
		}
		if (criteria.getValue() != null)
		{
			System.out.println("ExportedAuditlogs Criteria Value: " + criteria.getValue().toString());
		}
		if (criteria.getField() != null)
		{
			System.out.println("ExportedAuditlogs Criteria field name: " + criteria.getField().getAPIName());
		}
		List<Criteria> criteriaGroup = criteria.getGroup();
		if (criteriaGroup != null)
		{
			for (Criteria criteria1 : criteriaGroup)
			{
				printCriteria(criteria1);
			}
		}
		if (criteria.getGroupOperator() != null)
		{
			System.out.println("ExportedAuditlogs Criteria Group Operator: " + criteria.getGroupOperator());
		}
	}

	public static void main(String[] args)
	{
		try
		{
			Environment environment = USDataCenter.PRODUCTION;
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			getExportedAuditlogs();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
