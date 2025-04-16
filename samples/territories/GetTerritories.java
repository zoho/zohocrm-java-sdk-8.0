package samples.territories;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.territories.APIException;
import com.zoho.crm.api.territories.Criteria;
import com.zoho.crm.api.territories.Info;
import com.zoho.crm.api.territories.Manager;
import com.zoho.crm.api.territories.ResponseHandler;
import com.zoho.crm.api.territories.ResponseWrapper;
import com.zoho.crm.api.territories.TerritoriesOperations;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetTerritories
{
	public static void getTerritories() throws Exception
	{
		TerritoriesOperations territoriesOperations = new TerritoriesOperations();
		ParameterMap paramInstance = new ParameterMap();
		APIResponse<ResponseHandler> response = territoriesOperations.getTerritories(paramInstance);
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
					List<com.zoho.crm.api.territories.Territories> territoryList = responseWrapper.getTerritories();
					for (com.zoho.crm.api.territories.Territories territory : territoryList)
					{
						System.out.println("Territory CreatedTime: " + territory.getCreatedTime());
						System.out.println("Territory permission type: " + territory.getPermissionType());
						System.out.println("Territory ModifiedTime: " + territory.getModifiedTime());
						Manager manager = territory.getManager();
						if (manager != null)
						{
							System.out.println("Territory Manager User-Name: " + manager.getName());
							System.out.println("Territory Manager User-ID: " + manager.getId());
						}
						Criteria accountRuleCriteria = territory.getAccountRuleCriteria();
						if (accountRuleCriteria != null)
						{
							printCriteria(accountRuleCriteria);
						}
						System.out.println("Territory Name: " + territory.getName());
						com.zoho.crm.api.users.MinifiedUser modifiedBy = territory.getModifiedBy();
						if (modifiedBy != null)
						{
							System.out.println("Territory Modified By User-Name: " + modifiedBy.getName());
							System.out.println("Territory Modified By User-ID: " + modifiedBy.getId());
						}
						Criteria dealRuleCriteria1 = territory.getDealRuleCriteria();
						if (dealRuleCriteria1 != null)
						{
							printCriteria(dealRuleCriteria1);
						}
						System.out.println("Territory Description: " + territory.getDescription());
						System.out.println("Territory ID: " + territory.getId());
						com.zoho.crm.api.users.MinifiedUser createdBy = territory.getCreatedBy();
						if (modifiedBy != null)
						{
							System.out.println("Territory Created By User-Name: " + createdBy.getName());
							System.out.println("Territory Created By User-ID: " + createdBy.getId());
						}
						com.zoho.crm.api.territories.ReportingTo reportingTo = territory.getReportingTo();
						if (reportingTo != null)
						{
							System.out.println("Territory reporting By Territory-Name: " + reportingTo.getName());
							System.out.println("Territory reporting By Territory-ID: " + reportingTo.getId());
						}
					}
					Info info = responseWrapper.getInfo();
					if (info != null)
					{
						if (info.getPerPage() != null)
						{
							System.out.println("Territory Info PerPage: " + info.getPerPage().toString());
						}
						if (info.getCount() != null)
						{
							System.out.println("Territory Info Count: " + info.getCount().toString());
						}
						if (info.getPage() != null)
						{
							System.out.println("Territory Info Page: " + info.getPage().toString());
						}
						if (info.getMoreRecords() != null)
						{
							System.out.println("Territory Info MoreRecords: " + info.getMoreRecords().toString());
						}
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

	private static void printCriteria(Criteria criteria)
	{
		if (criteria.getComparator() != null)
		{
			System.out.println("CustomView Criteria Comparator: " + criteria.getComparator());
		}
		if (criteria.getField() != null)
		{
			System.out.println("CustomView Criteria field name: " + criteria.getField().getAPIName());
		}
		if (criteria.getValue() != null)
		{
			System.out.println("CustomView Criteria Value: " + criteria.getValue().toString());
		}
		List<Criteria> criteriaGroup = criteria.getGroup();
		if (criteriaGroup != null)
		{
			for (Criteria criteria1 : criteriaGroup)
			{
				printCriteria(criteria1);
			}
		}
		if (criteria.getGroupOperator() != null)
		{
			System.out.println("CustomView Criteria Group Operator: " + criteria.getGroupOperator());
		}
	}

	public static void main(String[] args)
	{
		try
		{
			Environment environment = USDataCenter.PRODUCTION;

			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").redirectURL("Redirect_URL").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			getTerritories();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
