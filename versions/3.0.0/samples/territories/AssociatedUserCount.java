package samples.territories;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.territories.APIException;
import com.zoho.crm.api.territories.AssociatedUsersCount;
import com.zoho.crm.api.territories.AssociatedUsersCountWrapper;
import com.zoho.crm.api.territories.Info;
import com.zoho.crm.api.territories.MinifiedTerritory;
import com.zoho.crm.api.territories.ResponseHandler;
import com.zoho.crm.api.territories.TerritoriesOperations;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class AssociatedUserCount
{
	public static void getAssociatedUsercount() throws Exception
	{
		TerritoriesOperations territoriesOperations = new TerritoriesOperations();
		APIResponse<ResponseHandler> response = territoriesOperations.getAssociatedUserCount();
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
				if (responseHandler instanceof AssociatedUsersCountWrapper)
				{
					AssociatedUsersCountWrapper responseWrapper = (AssociatedUsersCountWrapper) responseHandler;
					List<AssociatedUsersCount> territoryList = responseWrapper.getAssociatedUsersCount();
					for (com.zoho.crm.api.territories.AssociatedUsersCount territorycount : territoryList)
					{
						System.out.println("AssociatedUsersCount count: " + territorycount.getCount());
						MinifiedTerritory territory = territorycount.getTerritory();
						if (territory != null)
						{
							System.out.println("AssociatedUsersCount Name" + territory.getName());
							System.out.println("AssociatedUsersCount ID" + territory.getId());
							System.out.println("AssociatedUsersCount Subordinates" + territory.getSubordinates());
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

	public static void main(String[] args)
	{
		try
		{
			Environment environment = USDataCenter.PRODUCTION;

			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").redirectURL("Redirect_URL").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			getAssociatedUsercount();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
