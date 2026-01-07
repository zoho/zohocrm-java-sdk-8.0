package samples.usersunavailability;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.usersunavailability.APIException;
import com.zoho.crm.api.usersunavailability.Info;
import com.zoho.crm.api.usersunavailability.ResponseHandler;
import com.zoho.crm.api.usersunavailability.ResponseWrapper;
import com.zoho.crm.api.usersunavailability.User;
import com.zoho.crm.api.usersunavailability.UsersUnavailabilityOperations;
import com.zoho.crm.api.usersunavailability.UsersUnavailabilityOperations.GetUsersUnavailabilityParam;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetUsersUnavailabilites
{
	public static void getUsersUnavailability() throws Exception
	{
		UsersUnavailabilityOperations usersUnavailabilityOperations = new UsersUnavailabilityOperations();
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(GetUsersUnavailabilityParam.GROUP_IDS, "34770619,3477061912");
		paramInstance.add(GetUsersUnavailabilityParam.INCLUDE_INNER_DETAILS, "56xxx8");
		paramInstance.add(GetUsersUnavailabilityParam.ROLE_IDS, "343370619,3403706191");
		paramInstance.add(GetUsersUnavailabilityParam.TERRITORY_IDS, "343370619,3403706191");
		JSONObject filters = new JSONObject();
		filters.put("group_operator", "or");
		JSONArray group = new JSONArray();
		JSONObject criteria1 = new JSONObject();
		criteria1.put("comparator", "between");
		JSONObject criteria1Field = new JSONObject();
		criteria1Field.put("api_name", "from");
		criteria1.put("field", criteria1Field);
		JSONArray criteria1Value = new JSONArray();
		criteria1Value.put("2021-02-18T19:00:00+05:30");
		criteria1Value.put("2021-02-19T19:00:00+05:30");
		criteria1.put("value", criteria1Value);
		group.put(criteria1);
		JSONObject criteria2 = new JSONObject();
		criteria2.put("comparator", "between");
		JSONObject criteria2Field = new JSONObject();
		criteria2Field.put("api_name", "to");
		criteria2.put("field", criteria2Field);
		JSONArray criteria2Value = new JSONArray();
		criteria2Value.put("2021-02-18T20:00:00+05:30");
		criteria2Value.put("2021-02-19T20:00:00+05:30");
		criteria2.put("value", criteria2Value);
		group.put(criteria2);
		filters.put("group", group);
		paramInstance.add(GetUsersUnavailabilityParam.FILTERS, filters.toString());
		APIResponse<ResponseHandler> response = usersUnavailabilityOperations.getUsersUnavailability(paramInstance);
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
					List<com.zoho.crm.api.usersunavailability.UsersUnavailability> users = responseWrapper.getUsersUnavailability();
					for (com.zoho.crm.api.usersunavailability.UsersUnavailability usersUnavailability : users)
					{
						System.out.println("UsersUnavailability Comments: " + usersUnavailability.getComments());
						System.out.println("UsersUnavailability From: " + usersUnavailability.getFrom());
						System.out.println("UsersUnavailability Id: " + usersUnavailability.getId());
						System.out.println("UsersUnavailability to: " + usersUnavailability.getTo());
						User user = usersUnavailability.getUser();
						if (user != null)
						{
							System.out.println("UsersUnavailability User-Name: " + user.getName());
							System.out.println("UsersUnavailability User-Id: " + user.getId());
							System.out.println("UsersUnavailability User-ZuId: " + user.getZuid());
						}
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
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").redirectURL("Redirect_URL").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			getUsersUnavailability();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
