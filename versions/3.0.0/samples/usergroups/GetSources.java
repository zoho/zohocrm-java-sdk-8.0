package samples.usergroups;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.usergroups.APIException;
import com.zoho.crm.api.usergroups.Info;
import com.zoho.crm.api.usergroups.ResponseHandler;
import com.zoho.crm.api.usergroups.Source;
import com.zoho.crm.api.usergroups.Sources;
import com.zoho.crm.api.usergroups.SourcesWrapper;
import com.zoho.crm.api.usergroups.UserGroupsOperations;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetSources
{
	public static void getSources(Long groupId) throws Exception
	{
		UserGroupsOperations userGroupsOperations = new UserGroupsOperations();
		ParameterMap paramInstance = new ParameterMap();
		APIResponse<ResponseHandler> response = userGroupsOperations.getSources(groupId, paramInstance);
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
				if (responseHandler instanceof SourcesWrapper)
				{
					SourcesWrapper responseWrapper = (SourcesWrapper) responseHandler;
					List<Sources> sources = responseWrapper.getSources();
					for (Sources source : sources)
					{
						Source source1 = source.getSource();
						if (source1 != null)
						{
							System.out.println("Sources  User-Name: " + source1.getName());
							System.out.println("Sources User-ID: " + source1.getId());
						}
						System.out.println("Sources Type: " + source.getType().getValue());
						System.out.println("Sources Subordinates: " + source.getSubordinates());
					}
					Info info = responseWrapper.getInfo();
					if (info != null)
					{
						if (info.getPerPage() != null)
						{
							System.out.println("Sources Info PerPage: " + info.getPerPage().toString());
						}
						if (info.getCount() != null)
						{
							System.out.println("Sources Info Count: " + info.getCount().toString());
						}
						if (info.getPage() != null)
						{
							System.out.println("Sources Info Page: " + info.getPage());
						}
						if (info.getMoreRecords() != null)
						{
							System.out.println("Sources Info MoreRecords: " + info.getMoreRecords().toString());
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
			Long groupId = 440248001219057l;
			getSources(groupId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
