package samples.masschangeowner;

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
import com.zoho.crm.api.masschangeowner.APIException;
import com.zoho.crm.api.masschangeowner.MassChangeOwnerOperations;
import com.zoho.crm.api.masschangeowner.MassChangeOwnerOperations.CheckStatusParam;
import com.zoho.crm.api.masschangeowner.ResponseHandler;
import com.zoho.crm.api.masschangeowner.ResponseWrapper;
import com.zoho.crm.api.masschangeowner.Status;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class CheckStatus
{
	public static void checkStatus(Long jobId, String module) throws Exception
	{
		MassChangeOwnerOperations massChangeOwnerOperations = new MassChangeOwnerOperations(module);
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(CheckStatusParam.JOB_ID, jobId);
		APIResponse<ResponseHandler> response = massChangeOwnerOperations.checkStatus(paramInstance);
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
						System.out.println("MassChangeOwner TotalCount: " + status1.getTotalCount());
						System.out.println("MassChangeOwner UpdatedCount: " + status1.getUpdatedCount());
						System.out.println("MassChangeOwner NotUpdatedCount: " + status1.getNotUpdatedCount());
						System.out.println("MassChangeOwner FailedCount: " + status1.getFailedCount());
						System.out.println("MassChangeOwner Status: " + status1.getStatus());
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
			String moduleAPIName = "Leads";
			Long jobId = 347706117101007l;
			checkStatus(jobId, moduleAPIName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
