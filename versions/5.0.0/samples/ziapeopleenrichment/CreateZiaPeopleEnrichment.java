package samples.ziapeopleenrichment;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.ziapeopleenrichment.BodyWrapper;
import com.zoho.crm.api.ziapeopleenrichment.Company;
import com.zoho.crm.api.ziapeopleenrichment.EnrichBasedOn;
import com.zoho.crm.api.ziapeopleenrichment.Social;
import com.zoho.crm.api.ziapeopleenrichment.ZiaPeopleEnrichmentOperations;
import com.zoho.crm.api.ziapeopleenrichment.ZiaPeopleEnrichmentOperations.CreateZiaPeopleEnrichmentParam;
import com.zoho.crm.api.ziapeopleenrichment.ActionHandler;
import com.zoho.crm.api.ziapeopleenrichment.ActionWrapper;
import com.zoho.crm.api.ziapeopleenrichment.ActionResponse;
import com.zoho.crm.api.ziapeopleenrichment.SuccessResponse;
import com.zoho.crm.api.ziapeopleenrichment.ZiaPeopleEnrichment;
import com.zoho.crm.api.ziapeopleenrichment.APIException;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class CreateZiaPeopleEnrichment
{
	public static void createZiaPeopleEnrichment() throws Exception
	{
		ZiaPeopleEnrichmentOperations ziaPeopleEnrichmentOperations = new ZiaPeopleEnrichmentOperations();
		BodyWrapper request = new BodyWrapper();
		List<ZiaPeopleEnrichment> ziapeopleenrichment = new ArrayList<ZiaPeopleEnrichment>();
		ZiaPeopleEnrichment ziapeopleenrichment1 = new ZiaPeopleEnrichment();
		EnrichBasedOn enrichBasedOn = new EnrichBasedOn();
		enrichBasedOn.setName("zoho");
		enrichBasedOn.setEmail("sales@zohocorp.com");
		Company company = new Company();
		company.setName("zoho");
		company.setWebsite("www.zoho.com");
		enrichBasedOn.setCompany(company);
		Social social = new Social();
		social.setFacebook("facebook.com/zoho");
		social.setLinkedin("linkedin.com/zoho");
		social.setTwitter("twitter.com/zoho");
		enrichBasedOn.setSocial(social);
		ziapeopleenrichment1.setEnrichBasedOn(enrichBasedOn);
		ziapeopleenrichment.add(ziapeopleenrichment1);
		request.setZiaPeopleEnrichment(ziapeopleenrichment);
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(CreateZiaPeopleEnrichmentParam.MODULE, "Leads");
		APIResponse<ActionHandler> response = ziaPeopleEnrichmentOperations.createZiaPeopleEnrichment(request, paramInstance);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ActionWrapper)
				{
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
					List<ActionResponse> actionresponses = actionWrapper.getZiaPeopleEnrichment();
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
			createZiaPeopleEnrichment();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
