package samples.taxes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.taxes.APIException;
import com.zoho.crm.api.taxes.ActionHandler;
import com.zoho.crm.api.taxes.ActionResponse;
import com.zoho.crm.api.taxes.ActionWrapper;
import com.zoho.crm.api.taxes.BodyWrapper;
import com.zoho.crm.api.taxes.OrgTax;
import com.zoho.crm.api.taxes.Preference;
import com.zoho.crm.api.taxes.SuccessResponse;
import com.zoho.crm.api.taxes.TaxesOperations;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class UpdateTaxes
{
	public static void updateTaxes() throws Exception
	{
		TaxesOperations taxesOperations = new TaxesOperations();
		BodyWrapper request = new BodyWrapper();
		OrgTax orgTax = new OrgTax();
		List<com.zoho.crm.api.taxes.Tax> taxList = new ArrayList<com.zoho.crm.api.taxes.Tax>();
		com.zoho.crm.api.taxes.Tax tax1 = new com.zoho.crm.api.taxes.Tax();
		tax1.setId(347706114923002l);
		tax1.setName("MyTax1134313223");
		tax1.setSequenceNumber(1);
		tax1.setValue(15.04);
//		tax1.setDelete(null);
		taxList.add(tax1);
		orgTax.setTaxes(taxList);
		Preference preference = new Preference();
		preference.setAutoPopulateTax(false);
		preference.setModifyTaxRates(false);
		orgTax.setPreference(preference);
		request.setOrgTaxes(orgTax);
		APIResponse<ActionHandler> response = taxesOperations.updateTaxes(request);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ActionWrapper)
				{
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
					ActionResponse actionResponse = actionWrapper.getOrgTaxes();
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
						System.out.println("Message: " + successResponse.getMessage().getValue());
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
						System.out.println("Message: " + exception.getMessage().getValue());
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
			updateTaxes();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
