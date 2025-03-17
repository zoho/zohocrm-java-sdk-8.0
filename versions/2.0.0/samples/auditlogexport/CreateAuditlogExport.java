package samples.auditlogexport;

import java.lang.reflect.Field;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.auditlogexport.AuditLogExport;
import com.zoho.crm.api.auditlogexport.AuditLogExportOperations;
import com.zoho.crm.api.auditlogexport.BodyWrapper;
import com.zoho.crm.api.auditlogexport.Criteria;
import com.zoho.crm.api.auditlogexport.ActionHandler;
import com.zoho.crm.api.auditlogexport.ActionWrapper;
import com.zoho.crm.api.auditlogexport.ActionResponse;
import com.zoho.crm.api.auditlogexport.SuccessResponse;
import com.zoho.crm.api.auditlogexport.APIException;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class CreateAuditlogExport
{
	public static void createAuditlogExport() throws Exception
	{
		AuditLogExportOperations auditLogExportOperations = new AuditLogExportOperations();
		BodyWrapper request = new BodyWrapper();
		List<AuditLogExport> auditLogExport = new ArrayList<AuditLogExport>();
		AuditLogExport auditLogExport1 = new AuditLogExport();
		Criteria criteria = new Criteria();
		criteria.setComparator("between");
		com.zoho.crm.api.auditlogexport.Field field = new com.zoho.crm.api.auditlogexport.Field();
		field.setAPIName("audited_time");
		criteria.setField(field);
		List<OffsetDateTime> values = new ArrayList<OffsetDateTime>();
		values.add(OffsetDateTime.of(2024, 01, 02, 10, 00, 00, 00, ZoneOffset.of("+05:30")));
		values.add(OffsetDateTime.of(2024, 01, 03, 10, 00, 00, 00, ZoneOffset.of("+05:30")));
		criteria.setValue(values);
		auditLogExport1.setCriteria(criteria);
		auditLogExport.add(auditLogExport1);
		request.setAuditLogExport(auditLogExport);
		APIResponse<ActionHandler> response = auditLogExportOperations.createAuditlogExport(request);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ActionWrapper)
				{
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
					List<ActionResponse> actionresponses = actionWrapper.getAuditLogExport();
					for (ActionResponse actionresponse : actionresponses)
					{
						if (actionresponse instanceof SuccessResponse)
						{
							SuccessResponse successresponse = (SuccessResponse) actionresponse;
							System.out.println("Status: " + successresponse.getStatus().getValue());
							System.out.println("Code: " + successresponse.getCode().getValue());
							System.out.println("Details: ");
							for (Map.Entry<String, Object> entry : successresponse.getDetails().entrySet())
							{
								System.out.println(entry.getKey() + ": " + entry.getValue());
							}
							System.out.println("Message: " + successresponse.getMessage());
						}
						else if (actionresponse instanceof APIException)
						{
							APIException exception = (APIException) actionresponse;
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
					System.out.println("Message: " + exception.getMessage());
				}
			}
			else
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

	public static void main(String[] args)
	{
		try
		{
			Environment environment = USDataCenter.PRODUCTION;
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			createAuditlogExport();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
