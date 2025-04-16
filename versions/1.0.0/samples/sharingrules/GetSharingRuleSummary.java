package samples.sharingrules;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.sharingrules.APIException;
import com.zoho.crm.api.sharingrules.SharingRulesOperations;
import com.zoho.crm.api.sharingrules.SummaryResponseHandler;
import com.zoho.crm.api.sharingrules.SummaryResponseWrapper;
import com.zoho.crm.api.sharingrules.Module;
import com.zoho.crm.api.sharingrules.RulesSummary;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetSharingRuleSummary
{
	public static void getSharingRuleSummary(String moduleAPIName) throws Exception
	{
		SharingRulesOperations sharingRulesOperations = new SharingRulesOperations(moduleAPIName);
		APIResponse<SummaryResponseHandler> response = sharingRulesOperations.getSharingRuleSummary();
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
				SummaryResponseHandler responseHandler = response.getObject();
				if (responseHandler instanceof SummaryResponseWrapper)
				{
					SummaryResponseWrapper responseWrapper = (SummaryResponseWrapper) responseHandler;
					List<RulesSummary> rulesSummary = responseWrapper.getSharingRulesSummary();
					for (RulesSummary ruleSummary : rulesSummary)
					{
						Module module = ruleSummary.getModule();
						if(module != null)
						{
							System.out.println("RulesSummary Module APIName: " + module.getAPIName());
							System.out.println("RulesSummary Module Id: " + module.getId());
						}
						System.out.println("RulesSummary RuleComputationStatus: " + ruleSummary.getRuleComputationStatus());
						System.out.println("RulesSummary RuleCount: " + ruleSummary.getRuleCount());
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
			else if (response.getStatusCode() != 204)
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
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			String moduleAPIName = "Leads";
			getSharingRuleSummary(moduleAPIName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
