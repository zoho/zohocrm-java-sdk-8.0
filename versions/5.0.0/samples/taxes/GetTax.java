package samples.taxes;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.taxes.APIException;
import com.zoho.crm.api.taxes.OrgTax;
import com.zoho.crm.api.taxes.Preference;
import com.zoho.crm.api.taxes.ResponseHandler;
import com.zoho.crm.api.taxes.ResponseWrapper;
import com.zoho.crm.api.taxes.TaxesOperations;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetTax
{
	public static void getTax(Long taxId) throws Exception
	{
		TaxesOperations taxesOperations = new TaxesOperations();
		APIResponse<ResponseHandler> response = taxesOperations.getTax(taxId);
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
					OrgTax orgTax = responseWrapper.getOrgTaxes();
					List<com.zoho.crm.api.taxes.Tax> taxes = orgTax.getTaxes();
					for (com.zoho.crm.api.taxes.Tax tax : taxes)
					{
						System.out.println("Tax DisplayLabel: " + tax.getDisplayLabel());
						System.out.println("Tax Name: " + tax.getName());
						System.out.println("Tax ID: " + tax.getId());
						System.out.println("Tax Value: " + tax.getValue().toString());
					}
					Preference preference = orgTax.getPreference();
					if (preference != null)
					{
						System.out.println("Preference AutoPopulateTax: " + preference.getAutoPopulateTax().toString());
						System.out.println("Preference ModifyTaxRates: " + preference.getModifyTaxRates().toString());
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
			Environment environment = USDataCenter.PRODUCTION;
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").redirectURL("Redirect_URL").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			Long taxId = 34770616054012l;
			getTax(taxId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
