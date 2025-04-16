package samples.record;

import java.util.Arrays;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.record.APIException;
import com.zoho.crm.api.record.CountHandler;
import com.zoho.crm.api.record.CountWrapper;
import com.zoho.crm.api.record.RecordOperations;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetRecordCount
{
	public static void getRecordCount() throws Exception
	{
		String moduleAPIName = "Leads";
		RecordOperations recordOperations = new RecordOperations(moduleAPIName);
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(RecordOperations.RecordCountParam.PHONE, "(990) -");
		APIResponse<CountHandler> response = recordOperations.recordCount(paramInstance);
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
				CountHandler countHandler = response.getObject();
				if (countHandler instanceof CountWrapper)
				{
					CountWrapper countWrapper = (CountWrapper) countHandler;
					System.out.println("Record Count: " + countWrapper.getCount());
				}
				else if (countHandler instanceof APIException)
				{
					APIException exception = (APIException) countHandler;
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
			getRecordCount();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
