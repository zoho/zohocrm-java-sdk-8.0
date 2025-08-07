package samples.massdeletetags;

import com.zoho.crm.api.massdeletetags.MassDeleteTagsOperations;
import com.zoho.crm.api.massdeletetags.MassDeleteTagsOperations.GetStatusParam;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.massdeletetags.StatusResponseHandler;
import com.zoho.crm.api.massdeletetags.MassDeleteDetails;
import com.zoho.crm.api.massdeletetags.APIException;
import com.zoho.crm.api.massdeletetags.StatusResponseWrapper;
import com.zoho.crm.api.massdeletetags.StatusActionResponse;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;
import com.zoho.crm.api.ParameterMap;

public class GetStatus
{
	public static void getStatus() throws Exception
	{
		MassDeleteTagsOperations massDeleteTagsOperations = new MassDeleteTagsOperations();
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(GetStatusParam.JOB_ID, "3477022003");
		APIResponse<StatusResponseHandler> response = massDeleteTagsOperations.getStatus(paramInstance);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				StatusResponseHandler responseHandler = response.getObject();
				if (responseHandler instanceof StatusResponseWrapper)
				{
					StatusResponseWrapper statusResponseWrapper = (StatusResponseWrapper) responseHandler;
					List<StatusActionResponse> statusActionResponse = statusResponseWrapper.getMassDelete();
					for (StatusActionResponse statusActionResponse1 : statusActionResponse)
					{
						if (statusActionResponse1 instanceof MassDeleteDetails)
						{
							MassDeleteDetails massDeleteDetail = (MassDeleteDetails) statusActionResponse1;
							System.out.println("Status JobId: " + massDeleteDetail.getJobId());
							System.out.println("Status TotalCount: " + massDeleteDetail.getTotalCount());
							System.out.println("Status FailedCount: " + massDeleteDetail.getFailedCount());
							System.out.println("Status DeletedCount: " + massDeleteDetail.getDeletedCount());
							System.out.println("Job Status: " + massDeleteDetail.getStatus().getValue());
						}
						else if (statusActionResponse1 instanceof APIException)
						{
							APIException exception = (APIException) statusActionResponse1;
							System.out.println("Status: " + exception.getStatus().getValue());
							System.out.println("Code: " + exception.getCode().getValue());
							System.out.println("Details: ");
							if (exception.getDetails() != null)
							{
								for (Map.Entry<String, Object> entry : exception.getDetails().entrySet())
								{
									System.out.println(entry.getKey() + ": " + entry.getValue());
								}
							}
							System.out.println("Message: " + exception.getMessage());
						}

					}
				}
				else if (responseHandler instanceof APIException)
				{
					APIException exception = (APIException) responseHandler;
					System.out.println("Status: " + exception.getStatus().getValue());
					System.out.println("Code: " + exception.getCode().getValue());
					System.out.println("Details: ");
					if (exception.getDetails() != null)
					{
						for (Map.Entry<String, Object> entry : exception.getDetails().entrySet())
						{
							System.out.println(entry.getKey() + ": " + entry.getValue());
						}
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
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			getStatus();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
