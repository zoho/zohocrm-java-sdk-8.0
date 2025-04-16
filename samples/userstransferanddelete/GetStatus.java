package samples.userstransferanddelete;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.userstransferdelete.APIException;
import com.zoho.crm.api.userstransferdelete.ResponseHandler;
import com.zoho.crm.api.userstransferdelete.ResponseWrapper;
import com.zoho.crm.api.userstransferdelete.Status;
import com.zoho.crm.api.userstransferdelete.UsersTransferDeleteOperations;
import com.zoho.crm.api.userstransferdelete.UsersTransferDeleteOperations.GetStatusParam;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetStatus
{
	public static void getStatus() throws Exception
	{
		UsersTransferDeleteOperations usersTransferDeleteOperations = new UsersTransferDeleteOperations();
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(GetStatusParam.JOB_ID, 32838742872382l);
		APIResponse<ResponseHandler> response = usersTransferDeleteOperations.getStatus(paramInstance);
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
					List<Status> transferAndDelete = responseWrapper.getTransferAndDelete();
					if (transferAndDelete != null)
					{
						for (Status status : transferAndDelete)
						{
							System.out.println("TransferAndDelete Status: " + status.getStatus());
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
			getStatus();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
