package samples.sharingrules;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.sharingrules.APIException;
import com.zoho.crm.api.sharingrules.SharingRules;
import com.zoho.crm.api.sharingrules.SharingRulesOperations;
import com.zoho.crm.api.sharingrules.SharingRulesOperations.GetSharingRulesParam;
import com.zoho.crm.api.sharingrules.ResponseHandler;
import com.zoho.crm.api.sharingrules.ResponseWrapper;
import com.zoho.crm.api.sharingrules.Module;
import com.zoho.crm.api.sharingrules.Shared;
import com.zoho.crm.api.sharingrules.Resource;
import com.zoho.crm.api.sharingrules.FiltersBody;
import com.zoho.crm.api.sharingrules.Info;
import com.zoho.crm.api.sharingrules.Criteria;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class SearchSharingRules
{
	public static void searchSharingRules(String moduleAPIName) throws Exception
	{
		SharingRulesOperations sharingRulesOperations = new SharingRulesOperations(moduleAPIName);
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(GetSharingRulesParam.PAGE, 1);
		paramInstance.add(GetSharingRulesParam.PER_PAGE, 5);
		FiltersBody filtersBody = new FiltersBody();
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
		group41Criteria1.setValue(List.of(1111078l, 111117098l));
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
		group42Criteria1.setValue(List.of(111117078l, 111198l));
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
		
		filtersBody.setFilters(new ArrayList<>(Arrays.asList(criteria)));
		APIResponse<ResponseHandler> response = sharingRulesOperations.searchSharingRules(filtersBody, paramInstance);
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
					List<SharingRules> sharingRules = responseWrapper.getSharingRules();
					for (SharingRules sharingRule : sharingRules)
					{
						Module module = sharingRule.getModule();
						if(module != null)
						{
							System.out.println("SharingRules Module APIName: " + module.getAPIName());
							System.out.println("SharingRules Module Name: " + module.getName());
							System.out.println("SharingRules Module Id: " + module.getId());
						}
						System.out.println("SharingRules SuperiorsAllowed: " + sharingRule.getSuperiorsAllowed());
						System.out.println("SharingRules Type: " + sharingRule.getType().getValue());
						Shared sharedTo = sharingRule.getSharedTo();
						if(sharedTo != null)
						{
							Resource resource = sharedTo.getResource();
							if(resource != null)
							{
								System.out.println("SharingRules SharedTo Resource Name: " + resource.getName());
								System.out.println("SharingRules SharedTo Resource Id: " + resource.getId());
							}
							System.out.println("SharingRules SharedTo Type: " + sharedTo.getType());
							System.out.println("SharingRules SharedTo Subordinates: " + sharedTo.getSubordinates());
						}
						
						Shared sharedFrom = sharingRule.getSharedFrom();
						if(sharedFrom != null)
						{
							Resource resource = sharedFrom.getResource();
							if(resource != null)
							{
								System.out.println("SharingRules SharedFrom Resource Name: " + resource.getName());
								System.out.println("SharingRules SharedFrom Resource Id: " + resource.getId());
							}
							System.out.println("SharingRules SharedFrom Type: " + sharedFrom.getType());
							System.out.println("SharingRules SharedFrom Subordinates: " + sharedFrom.getSubordinates());
						}
						
						System.out.println("SharingRules PermissionType: " + sharingRule.getPermissionType().getValue());
						System.out.println("SharingRules Name: " + sharingRule.getName());
						System.out.println("SharingRules Id: " + sharingRule.getId());
						System.out.println("SharingRules Status: " + sharingRule.getStatus().getValue());
						System.out.println("SharingRules MatchLimitExceeded: " + sharingRule.getMatchLimitExceeded());
					}
					Info info = responseWrapper.getInfo();
					System.out.println("SharingRules Info PerPage: " + info.getPerPage());
					System.out.println("SharingRules Info Count: " + info.getCount());
					System.out.println("SharingRules Info Page: " + info.getPage());
					System.out.println("SharingRules Info MoreRecords: " + info.getMoreRecords());
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
			searchSharingRules(moduleAPIName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
