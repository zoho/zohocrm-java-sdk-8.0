package samples.availablecurrencies;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.availablecurrencies.APIException;
import com.zoho.crm.api.availablecurrencies.AvailableCurrenciesOperations;
import com.zoho.crm.api.availablecurrencies.ResponseHandler;
import com.zoho.crm.api.availablecurrencies.ResponseWrapper;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetAvailableCurrencies
{
	public static void getAvailableCurrencies() throws Exception
	{
		AvailableCurrenciesOperations currenciesOperations = new AvailableCurrenciesOperations();
		APIResponse<ResponseHandler> response = currenciesOperations.getAvailableCurrencies();
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
					List<com.zoho.crm.api.availablecurrencies.Currency> currenciesList = responseWrapper.getAvailableCurrencies();
					for (com.zoho.crm.api.availablecurrencies.Currency currency : currenciesList)
					{
						System.out.println("Currency DisplayValue: " + currency.getDisplayValue());
						System.out.println("Currency DecimalSeparator: " + currency.getDecimalSeparator());
						System.out.println("Currency Symbol: " + currency.getSymbol());
						System.out.println("Currency ThousandSeparator: " + currency.getThousandSeparator());
						System.out.println("Currency IsoCode: " + currency.getIsoCode());
						System.out.println("Currency DisplayName: " + currency.getDisplayName());
						System.out.println("Currency DecimalPlaces: " + currency.getDecimalPlaces());
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
			getAvailableCurrencies();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
