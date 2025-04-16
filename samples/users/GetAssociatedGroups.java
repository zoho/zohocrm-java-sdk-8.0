package samples.users;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.users.APIException;
import com.zoho.crm.api.users.AssociatedGroup;
import com.zoho.crm.api.users.AssociatedGroupsWrapper;
import com.zoho.crm.api.users.MinifiedUser;
import com.zoho.crm.api.users.ResponseHandler;
import com.zoho.crm.api.users.UsersOperations;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetAssociatedGroups
{
	public static void getAssociatedGroups(Long userId) throws Exception
	{
		UsersOperations usersOperations = new UsersOperations();
		ParameterMap parameterMap = new ParameterMap();
		APIResponse<ResponseHandler> response = usersOperations.getAssociatedGroups(userId, parameterMap);
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
				if (responseHandler instanceof AssociatedGroupsWrapper)
				{
					AssociatedGroupsWrapper associatedGroupsWrapper = (AssociatedGroupsWrapper) responseHandler;
					List<AssociatedGroup> userGroups = associatedGroupsWrapper.getUserGroups();
					if (userGroups != null)
					{
						for (AssociatedGroup userGroup : userGroups)
						{
							System.out.println("AssociateGroup ID : " + userGroup.getId());
							System.out.println("AssociateGroup Name : " + userGroup.getName());
							System.out.println("AssociateGroup Description : " + userGroup.getDescription());
							System.out.println("AssociateGroup CreatedTime : " + userGroup.getCreatedTime());
							System.out.println("AssociateGroup ModifiedTime : " + userGroup.getModifiedTime());
							MinifiedUser createdBy = userGroup.getCreatedBy();
							if (createdBy != null)
							{
								System.out.println("AssociateGroup CreatedBy ID : " + createdBy.getId());
								System.out.println("AssociateGroup CreatedBy Name : " + createdBy.getName());
								System.out.println("AssociateGroup CreatedBy Email : " + createdBy.getEmail());
							}
							MinifiedUser modifiedBy = userGroup.getModifiedBy();
							if (modifiedBy != null)
							{
								System.out.println("AssociateGroup modifiedBy ID : " + modifiedBy.getId());
								System.out.println("AssociateGroup modifiedBy Name : " + modifiedBy.getName());
								System.out.println("AssociateGroup modifiedBy Email : " + modifiedBy.getEmail());
							}
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
			long userId = 4402480254001l;
			getAssociatedGroups(userId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
