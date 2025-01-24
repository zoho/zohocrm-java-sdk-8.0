package samples.ziaorgenrichment;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.ziaorgenrichment.BodyWrapper;
import com.zoho.crm.api.ziaorgenrichment.EnrichBasedOn;
import com.zoho.crm.api.ziaorgenrichment.ZiaOrgEnrichmentOperations;
import com.zoho.crm.api.ziaorgenrichment.ZiaOrgEnrichmentOperations.CreateZiaOrgEnrichmentParam;
import com.zoho.crm.api.ziaorgenrichment.ActionHandler;
import com.zoho.crm.api.ziaorgenrichment.ActionWrapper;
import com.zoho.crm.api.ziaorgenrichment.ActionResponse;
import com.zoho.crm.api.ziaorgenrichment.SuccessResponse;
import com.zoho.crm.api.ziaorgenrichment.ZiaOrgEnrichment;
import com.zoho.crm.api.ziaorgenrichment.APIException;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class CreateZiaOrgEnrichment
{
	public static void createZiaOrgEnrichment() throws Exception
	{
		ZiaOrgEnrichmentOperations ziaOrgEnrichmentOperations = new ZiaOrgEnrichmentOperations();
		BodyWrapper request = new BodyWrapper();
		List<ZiaOrgEnrichment> ziaorgenrichment = new ArrayList<ZiaOrgEnrichment>();
		ZiaOrgEnrichment ziaorgenrichment1 = new ZiaOrgEnrichment();
		EnrichBasedOn enrichBasedOn = new EnrichBasedOn();
		enrichBasedOn.setName("zoho");
		enrichBasedOn.setEmail("sales@zohocorp.com");
		enrichBasedOn.setWebsite("www.zoho.com");
		ziaorgenrichment1.setEnrichBasedOn(enrichBasedOn);
		ziaorgenrichment.add(ziaorgenrichment1);
		request.setZiaOrgEnrichment(ziaorgenrichment);
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(CreateZiaOrgEnrichmentParam.MODULE, "Vendors");
		APIResponse<ActionHandler> response = ziaOrgEnrichmentOperations.createZiaOrgEnrichment(request, paramInstance);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ActionWrapper)
				{
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
					List<ActionResponse> actionresponses = actionWrapper.getZiaOrgEnrichment();
					for (ActionResponse actionresponse : actionresponses)
					{
						if (actionresponse instanceof SuccessResponse)
						{
							SuccessResponse successresponse = (SuccessResponse) actionresponse;
							System.out.println("Status: " + successresponse.getStatus().getValue());
							System.out.println("Code: " + successresponse.getCode().getValue());
							System.out.println("Details: ");
							for (Map.Entry<String, Object> entry : successresponse.getDetails().entrySet())
							{
								System.out.println(entry.getKey() + ": " + entry.getValue());
							}
							System.out.println("Message: " + successresponse.getMessage());
						}
						else if (actionresponse instanceof APIException)
						{
							APIException exception = (APIException) actionresponse;
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
				for (Field field1 : fields)
				{
					field1.setAccessible(true);
					System.out.println(field1.getName() + ":" + field1.get(responseObject));
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
			createZiaOrgEnrichment();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
