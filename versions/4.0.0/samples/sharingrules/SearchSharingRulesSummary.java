package samples.sharingrules;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.sharingrules.APIException;
import com.zoho.crm.api.sharingrules.Criteria;
import com.zoho.crm.api.sharingrules.FiltersBody;
import com.zoho.crm.api.sharingrules.SharingRulesOperations;
import com.zoho.crm.api.sharingrules.SummaryResponseHandler;
import com.zoho.crm.api.sharingrules.SummaryResponseWrapper;
import com.zoho.crm.api.sharingrules.Module;
import com.zoho.crm.api.sharingrules.RulesSummary;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class SearchSharingRulesSummary
{
	public static void searchSharingRulesSummary(String moduleAPIName) throws Exception
	{
		SharingRulesOperations sharingRulesOperations = new SharingRulesOperations(moduleAPIName);
		FiltersBody request = new FiltersBody();
		Criteria criteria = new Criteria();
		criteria.setGroupOperator("and");
		List<Criteria> group = new ArrayList<>();
		
		Criteria groupCriteria1 = new Criteria();
		com.zoho.crm.api.sharingrules.Field field1 = new com.zoho.crm.api.sharingrules.Field();
		field1.setAPIName("shared_from.type");
		groupCriteria1.setField(field1);
		groupCriteria1.setValue("${EMPTY}");
		groupCriteria1.setComparator("equal");
		group.add(groupCriteria1);
		
		
		Criteria groupCriteria2 = new Criteria();
		com.zoho.crm.api.sharingrules.Field field2 = new com.zoho.crm.api.sharingrules.Field();
		field2.setAPIName("superiors_allowed");
		groupCriteria2.setField(field2);
		groupCriteria2.setValue("false");
		groupCriteria2.setComparator("equal");
		group.add(groupCriteria2);
		
		Criteria groupCriteria3 = new Criteria();
		com.zoho.crm.api.sharingrules.Field field3 = new com.zoho.crm.api.sharingrules.Field();
		field3.setAPIName("status");
		groupCriteria3.setField(field3);
		groupCriteria3.setValue("active");
		groupCriteria3.setComparator("equal");
		group.add(groupCriteria3);
		
		
		Criteria groupCriteria4 = new Criteria();
		groupCriteria4.setGroupOperator("or");
		
		List<Criteria> group4 = new ArrayList<>();
		
		Criteria group4Criteria1 = new Criteria();
		group4Criteria1.setGroupOperator("and");
		
		List<Criteria> group41 = new ArrayList<>();
		
		Criteria group41Criteria1 = new Criteria();
		com.zoho.crm.api.sharingrules.Field group41Criteria1field1 = new com.zoho.crm.api.sharingrules.Field();
		group41Criteria1field1.setAPIName("shared_to.resource.id");
		group41Criteria1.setField(group41Criteria1field1);
		group41Criteria1.setValue(List.of(11111777078l, 11111777098l));
		group41Criteria1.setComparator("in");
		group41.add(group41Criteria1);
		
		Criteria group41Criteria2 = new Criteria();
		com.zoho.crm.api.sharingrules.Field group41Criteria1field2 = new com.zoho.crm.api.sharingrules.Field();
		group41Criteria1field2.setAPIName("shared_to.type");
		group41Criteria2.setField(group41Criteria1field2);
		group41Criteria2.setValue("groups");
		group41Criteria2.setComparator("equal");
		group41.add(group41Criteria2);
		
		group4Criteria1.setGroup(group41);
		group4.add(group4Criteria1);
		
		
		Criteria group4Criteria2 = new Criteria();
		group4Criteria2.setGroupOperator("and");
		
		List<Criteria> group42 = new ArrayList<>();
		
		Criteria group42Criteria1 = new Criteria();
		com.zoho.crm.api.sharingrules.Field group42Criteria1field1 = new com.zoho.crm.api.sharingrules.Field();
		group42Criteria1field1.setAPIName("shared_to.resource.id");
		group42Criteria1.setField(group42Criteria1field1);
		group42Criteria1.setValue(List.of(11111777078l, 11111777098l));
		group42Criteria1.setComparator("in");
		group42.add(group42Criteria1);
		
		Criteria group42Criteria2 = new Criteria();
		com.zoho.crm.api.sharingrules.Field group42Criteria1field2 = new com.zoho.crm.api.sharingrules.Field();
		group42Criteria1field2.setAPIName("shared_to.type");
		group42Criteria2.setField(group42Criteria1field2);
		group42Criteria2.setValue("roles");
		group42Criteria2.setComparator("equal");
		group42.add(group42Criteria2);
		
		group4Criteria2.setGroup(group42);
		group4.add(group4Criteria2);
		
		groupCriteria4.setGroup(group4);
		group.add(groupCriteria4);
		
		criteria.setGroup(group);
		
		request.setFilters(new ArrayList<>(Arrays.asList(criteria)));
		APIResponse<SummaryResponseHandler> response = sharingRulesOperations.searchSharingRulesSummary(request);
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
			searchSharingRulesSummary(moduleAPIName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
