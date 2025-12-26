package samples.currencies;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.currencies.APIException;
import com.zoho.crm.api.currencies.CurrenciesOperations;
import com.zoho.crm.api.currencies.Format;
import com.zoho.crm.api.currencies.ResponseHandler;
import com.zoho.crm.api.currencies.ResponseWrapper;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetCurrencies
{
	public static void getCurrencies() throws Exception
	{
		CurrenciesOperations currenciesOperations = new CurrenciesOperations();
		APIResponse<ResponseHandler> response = currenciesOperations.getCurrencies();
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
					List<com.zoho.crm.api.currencies.Currency> currenciesList = responseWrapper.getCurrencies();
					for (com.zoho.crm.api.currencies.Currency currency : currenciesList)
					{
						System.out.println("Currency Symbol: " + currency.getSymbol());
						System.out.println("Currency CreatedTime: " + currency.getCreatedTime());
						System.out.println("Currency IsActive: " + currency.getIsActive().toString());
						System.out.println("Currency ExchangeRate: " + currency.getExchangeRate());
						Format format = currency.getFormat();
						if (format != null)
						{
							System.out.println("Currency Format DecimalSeparator: " + format.getDecimalSeparator().getValue());
							System.out.println("Currency Format ThousandSeparator: " + format.getThousandSeparator().getValue());
							System.out.println("Currency Format DecimalPlaces: " + format.getDecimalPlaces().getValue());
						}
						com.zoho.crm.api.users.MinifiedUser createdBy = currency.getCreatedBy();
						if (createdBy != null)
						{
							System.out.println("Currency CreatedBy User-Name: " + createdBy.getName());
							System.out.println("Currency CreatedBy User-ID: " + createdBy.getId());
						}
						System.out.println("Currency PrefixSymbol: " + currency.getPrefixSymbol().toString());
						System.out.println("Currency IsBase: " + currency.getIsBase().toString());
						System.out.println("Currency ModifiedTime: " + currency.getModifiedTime());
						System.out.println("Currency Name: " + currency.getName());
						com.zoho.crm.api.users.MinifiedUser modifiedBy = currency.getModifiedBy();
						if (modifiedBy != null)
						{
							System.out.println("Currency ModifiedBy User-Name: " + modifiedBy.getName());
							System.out.println("Currency ModifiedBy User-ID: " + modifiedBy.getId());
						}
						System.out.println("Currency Id: " + currency.getId());
						System.out.println("Currency IsoCode: " + currency.getIsoCode());
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
			getCurrencies();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
