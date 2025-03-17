package samples.currencies;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.currencies.APIException;
import com.zoho.crm.api.currencies.ActionHandler;
import com.zoho.crm.api.currencies.ActionResponse;
import com.zoho.crm.api.currencies.ActionWrapper;
import com.zoho.crm.api.currencies.BodyWrapper;
import com.zoho.crm.api.currencies.CurrenciesOperations;
import com.zoho.crm.api.currencies.Format;
import com.zoho.crm.api.currencies.SuccessResponse;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;

public class UpdateCurrencies
{
	public static void updateCurrencies() throws Exception
	{
		CurrenciesOperations currenciesOperations = new CurrenciesOperations();
		BodyWrapper bodyWrapper = new BodyWrapper();
		List<com.zoho.crm.api.currencies.Currency> currencies = new ArrayList<com.zoho.crm.api.currencies.Currency>();
		com.zoho.crm.api.currencies.Currency currency = new com.zoho.crm.api.currencies.Currency();
		currency.setPrefixSymbol(true);
		currency.setId(34770617368016l);
		currency.setExchangeRate("5.0");
		currency.setIsActive(true);
		Format format = new Format();
		format.setDecimalSeparator(new Choice<String>("Period"));
		format.setThousandSeparator(new Choice<String>("Comma"));
		format.setDecimalPlaces(new Choice<String>("2"));
		currency.setFormat(format);
		currencies.add(currency);
		bodyWrapper.setCurrencies(currencies);
		APIResponse<ActionHandler> response = currenciesOperations.updateCurrencies(bodyWrapper);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ActionWrapper)
				{
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
					List<ActionResponse> actionResponses = actionWrapper.getCurrencies();
					for (ActionResponse actionResponse : actionResponses)
					{
						if (actionResponse instanceof SuccessResponse)
						{
							SuccessResponse successResponse = (SuccessResponse) actionResponse;
							System.out.println("Status: " + successResponse.getStatus().getValue());
							System.out.println("Code: " + successResponse.getCode().getValue());
							System.out.println("Details: ");
							for (Map.Entry<String, Object> entry : successResponse.getDetails().entrySet())
							{
								System.out.println(entry.getKey() + ": " + entry.getValue());
							}
							System.out.println("Message: " + successResponse.getMessage());
						}
						else if (actionResponse instanceof APIException)
						{
							APIException exception = (APIException) actionResponse;
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
			updateCurrencies();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
