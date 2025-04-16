package samples.massconvert;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.massconvert.APIException;
import com.zoho.crm.api.massconvert.MassConvertOperations;
import com.zoho.crm.api.massconvert.ResponseHandler;
import com.zoho.crm.api.massconvert.ResponseWrapper;
import com.zoho.crm.api.massconvert.Status;
import com.zoho.crm.api.massconvert.MassConvertOperations.GetJobStatusParam;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetJobStatus
{
	public static void getJobStatus(Long jobId) throws Exception
	{
		MassConvertOperations massConvertOperations = new MassConvertOperations();
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(GetJobStatusParam.JOB_ID, jobId);
		APIResponse<ResponseHandler> response = massConvertOperations.getJobStatus(paramInstance);
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
					List<Status> status = responseWrapper.getData();
					for (Status status1 : status)
					{
						System.out.println("MassConvert TotalCount: " + status1.getTotalCount());
						System.out.println("MassConvert ConvertedCount: " + status1.getConvertedCount());
						System.out.println("MassConvert NotConvertedCount: " + status1.getNotConvertedCount());
						System.out.println("MassConvert FailedCount: " + status1.getFailedCount());
						System.out.println("MassConvert Status: " + status1.getStatus());
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
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			Long jobId = 347706116704007l;
			getJobStatus(jobId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
