package samples.signals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.signals.APIException;
import com.zoho.crm.api.signals.Extension;
import com.zoho.crm.api.signals.FeatureAvailability;
import com.zoho.crm.api.signals.ResponseHandler;
import com.zoho.crm.api.signals.ResponseWrapper;
import com.zoho.crm.api.signals.Signals;
import com.zoho.crm.api.signals.SignalsOperations;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetSignals
{
	public static void getSignals() throws Exception
	{
		SignalsOperations signalsOperations = new SignalsOperations();
		APIResponse<ResponseHandler> response = signalsOperations.getSignals();
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
					List<Signals> signals = responseWrapper.getSignals();
					for (Signals signal : signals)
					{
						System.out.println("Signals DisplayLabel: " + signal.getDisplayLabel());
						Extension extension = signal.getExtension();
						if (extension != null)
						{
							System.out.println("Signals Extension DisplayLabel: " + extension.getDisplayLabel());
							System.out.println("Signals Extension Namespace: " + extension.getNamespace());
							System.out.println("Signals Extension Id: " + extension.getId());
							System.out.println("Signals Extension Type: " + extension.getType());
						}
						FeatureAvailability featureAvailability = signal.getFeatureAvailability();
						if (featureAvailability != null)
						{
							System.out.println("Signals FeatureAvailability Scoring: " + featureAvailability.getScoring());
							System.out.println("Signals FeatureAvailability Signals: " + featureAvailability.getSignals());
						}
						System.out.println("Signals Namespace: " + signal.getNamespace());
						System.out.println("Signals ChatEnabled: " + signal.getChatEnabled());
						System.out.println("Signals Id: " + signal.getId());
						System.out.println("Signals Enabled: " + signal.getEnabled());
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
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			getSignals();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
