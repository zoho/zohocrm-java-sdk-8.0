package samples.record;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.record.APIException;
import com.zoho.crm.api.record.MassUpdate;
import com.zoho.crm.api.record.MassUpdateResponse;
import com.zoho.crm.api.record.MassUpdateResponseHandler;
import com.zoho.crm.api.record.MassUpdateResponseWrapper;
import com.zoho.crm.api.record.RecordOperations;
import com.zoho.crm.api.record.RecordOperations.GetMassUpdateStatusParam;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetMassUpdateStatus
{
	public static void getMassUpdateStatus(String moduleAPIName, String jobId) throws Exception
	{
		RecordOperations recordOperations = new RecordOperations(moduleAPIName);
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(GetMassUpdateStatusParam.JOB_ID, jobId);
		APIResponse<MassUpdateResponseHandler> response = recordOperations.getMassUpdateStatus(paramInstance);
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
				MassUpdateResponseHandler massUpdateResponseHandler = response.getObject();
				if (massUpdateResponseHandler instanceof MassUpdateResponseWrapper)
				{
					MassUpdateResponseWrapper massUpdateResponseWrapper = (MassUpdateResponseWrapper) massUpdateResponseHandler;
					List<MassUpdateResponse> massUpdateResponses = massUpdateResponseWrapper.getData();
					for (MassUpdateResponse massUpdateResponse : massUpdateResponses)
					{
						if (massUpdateResponse instanceof MassUpdate)
						{
							MassUpdate massUpdate = (MassUpdate) massUpdateResponse;
							System.out.println("MassUpdate Status: " + massUpdate.getStatus().getValue());
							System.out.println("MassUpdate FailedCount: " + massUpdate.getFailedCount().toString());
							System.out.println("MassUpdate UpdatedCount: " + massUpdate.getUpdatedCount().toString());
							System.out.println("MassUpdate NotUpdatedCount: " + massUpdate.getNotUpdatedCount());
							System.out.println("MassUpdate TotalCount: " + massUpdate.getTotalCount().toString());
						}
						else if (massUpdateResponse instanceof APIException)
						{
							APIException exception = (APIException) massUpdateResponse;
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
				else if (massUpdateResponseHandler instanceof APIException)
				{
					APIException exception = (APIException) massUpdateResponseHandler;
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
			String jobId = "347706117121011";
			getMassUpdateStatus(moduleAPIName, jobId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
