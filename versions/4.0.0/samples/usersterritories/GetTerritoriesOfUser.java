package samples.usersterritories;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.usersterritories.APIException;
import com.zoho.crm.api.usersterritories.Info;
import com.zoho.crm.api.usersterritories.Manager;
import com.zoho.crm.api.usersterritories.ResponseHandler;
import com.zoho.crm.api.usersterritories.ResponseWrapper;
import com.zoho.crm.api.usersterritories.Territory;
import com.zoho.crm.api.usersterritories.UsersTerritoriesOperations;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetTerritoriesOfUser
{
	public static void getTerritoriesOfUser(Long userId) throws Exception
	{
		UsersTerritoriesOperations usersTerritoriesOperations = new UsersTerritoriesOperations(userId);
		APIResponse<ResponseHandler> response = usersTerritoriesOperations.getTerritoriesOfUser();
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
					List<Territory> usersTerritory = responseWrapper.getTerritories();
					for (Territory territory : usersTerritory)
					{
						System.out.println("User Territory ID: " + territory.getId());
						Manager manager = territory.getManager();
						if (manager != null)
						{
							System.out.println("User Territory Manager Name: " + manager.getName());
							System.out.println("User Territory Manager ID: " + manager.getId());
						}
						Manager reportingTo = territory.getReportingTo();
						if (reportingTo != null)
						{
							System.out.println("User Territory ReportingTo Name: " + reportingTo.getName());
							System.out.println("User Territory ReportingTo ID: " + reportingTo.getId());
						}
						System.out.println("User Territory Name: " + territory.getName());
					}
					Info info = responseWrapper.getInfo();
					if (info != null)
					{
						if (info.getPerPage() != null)
						{
							System.out.println("User Info PerPage: " + info.getPerPage().toString());
						}
						if (info.getCount() != null)
						{
							System.out.println("User Info Count: " + info.getCount().toString());
						}
						if (info.getPage() != null)
						{
							System.out.println("User Info Page: " + info.getPage().toString());
						}
						if (info.getMoreRecords() != null)
						{
							System.out.println("User Info MoreRecords: " + info.getMoreRecords().toString());
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
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			Long userId = 4402480254001l;
			getTerritoriesOfUser(userId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
