package samples.fiscalyear;

import java.util.Arrays;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.fiscalyear.APIException;
import com.zoho.crm.api.fiscalyear.FiscalYearOperations;
import com.zoho.crm.api.fiscalyear.ResponseHandler;
import com.zoho.crm.api.fiscalyear.ResponseWrapper;
import com.zoho.crm.api.fiscalyear.Year;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.dc.INDataCenter;

public class GetFiscalYear
{
	public static void getFiscalYear() throws Exception
	{
		FiscalYearOperations fiscalyearoperations = new FiscalYearOperations();
		APIResponse<ResponseHandler> response = fiscalyearoperations.getFiscalYear();
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
					Year fiscalYear = responseWrapper.getFiscalYear();
					if (fiscalYear != null)
					{
						System.out.println("FiscalYear startMonth :" + fiscalYear.getStartMonth().getValue());
						System.out.println("FiscalYear displayBasedOn :" + fiscalYear.getDisplayBasedOn().getValue());
						System.out.println("FiscalYear Id : " + fiscalYear.getId());
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
			Environment environment = INDataCenter.PRODUCTION;
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").redirectURL("Redirect_URL").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			getFiscalYear();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
