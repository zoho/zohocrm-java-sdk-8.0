package samples.usergroups;

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
import com.zoho.crm.api.usergroups.APIException;
import com.zoho.crm.api.usergroups.AssociatedUser;
import com.zoho.crm.api.usergroups.AssociatedUserCount;
import com.zoho.crm.api.usergroups.Info;
import com.zoho.crm.api.usergroups.ResponseHandler;
import com.zoho.crm.api.usergroups.UserGroup;
import com.zoho.crm.api.usergroups.UserGroupsOperations;
import com.zoho.crm.api.usergroups.UserGroupsOperations.GetAssociatedUsersCountParam;
import com.zoho.crm.api.usergroups.Criteria;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;

public class GetAssociatedUsersCount
{
	public static void getAssociatedUsersCount() throws Exception
	{
		UserGroupsOperations userGroupsOperations = new UserGroupsOperations();
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(GetAssociatedUsersCountParam.PAGE, "1");
		paramInstance.add(GetAssociatedUsersCountParam.PER_PAGE, "10");
		Criteria criteria = new Criteria();
		criteria.setGroupOperator(new Choice<String>("OR"));
		List<Criteria> group = new ArrayList<Criteria>();
		Criteria group1 = new Criteria();
		group1.setComparator("equal");
		group1.setValue("test group");
		com.zoho.crm.api.usergroups.Field field1 = new com.zoho.crm.api.usergroups.Field();
		field1.setAPIName("name");
		group1.setField(field1);
		group.add(group1);
		
		Criteria group2 = new Criteria();
		group2.setComparator("equal");
		group2.setValue("Tier2");
		com.zoho.crm.api.usergroups.Field field2 = new com.zoho.crm.api.usergroups.Field();
		field2.setAPIName("name");
		group2.setField(field2);
		group.add(group2);
		
		criteria.setGroup(group);
		paramInstance.add(GetAssociatedUsersCountParam.FILTERS, criteria);
		
		APIResponse<ResponseHandler> response = userGroupsOperations.getAssociatedUsersCount(paramInstance);
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
				if (responseHandler instanceof AssociatedUserCount)
				{
					List<AssociatedUser> associatedUsersCount = ((AssociatedUserCount) responseHandler).getAssociatedUsersCount();
					if (associatedUsersCount != null)
					{
						for (AssociatedUser associatedUser : associatedUsersCount)
						{
							System.out.println("AssociatedUser count: " + associatedUser.getCount());
							UserGroup userGroup = associatedUser.getUserGroup();
							if (userGroup != null)
							{
								System.out.println("AssociatedUser Name: " + userGroup.getName());
								System.out.println("AssociatedUser ID: " + userGroup.getId());
							}
						}
					}
					Info info = ((AssociatedUserCount) responseHandler).getInfo();
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
			getAssociatedUsersCount();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
