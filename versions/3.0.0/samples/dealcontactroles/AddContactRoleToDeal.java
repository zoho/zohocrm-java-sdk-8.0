package samples.dealcontactroles;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.dealcontactroles.APIException;
import com.zoho.crm.api.dealcontactroles.ActionHandler;
import com.zoho.crm.api.dealcontactroles.ActionResponse;
import com.zoho.crm.api.dealcontactroles.ActionWrapper;
import com.zoho.crm.api.dealcontactroles.BodyWrapper;
import com.zoho.crm.api.dealcontactroles.ContactRole;
import com.zoho.crm.api.dealcontactroles.Data;
import com.zoho.crm.api.dealcontactroles.DealContactRolesOperations;
import com.zoho.crm.api.dealcontactroles.SuccessResponse;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;

public class AddContactRoleToDeal
{
	public static void addContactRoleToDeal(Long contactId, Long dealId) throws SDKException
	{
		DealContactRolesOperations contactRolesOperations = new DealContactRolesOperations();
		BodyWrapper bodyWrapper = new BodyWrapper();
		List<Data> data = new ArrayList<Data>();
		Data data1 = new Data();
		ContactRole contactRole = new ContactRole();
		contactRole.setId(4402480388001l);
		contactRole.setName("contactRole1");
		data1.setContactRole(contactRole);
		data.add(data1);
		bodyWrapper.setData(data);
		APIResponse<ActionHandler> response = contactRolesOperations.associateContactRoleToDeal(contactId, dealId, bodyWrapper);
		if (response != null)
		{
			System.out.println("Status code : " + response.getStatusCode());
			ActionHandler actionHandler = response.getObject();
			if (actionHandler instanceof ActionWrapper)
			{
				ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
				List<ActionResponse> actionResponses = actionWrapper.getData();
				for (ActionResponse actionResponse : actionResponses)
				{
					if (actionResponse instanceof SuccessResponse)
					{
						SuccessResponse successResponse = (SuccessResponse) actionResponse;
						System.out.println("Status: " + successResponse.getStatus().getValue());
						System.out.println("Code: " + successResponse.getCode().getValue());
						System.out.println("Details: ");
						if (successResponse.getDetails() != null)
						{
							for (Map.Entry<String, Object> entry : successResponse.getDetails().entrySet())
							{
								System.out.println(entry.getKey() + ": " + entry.getValue());
							}
						}
						System.out.println("Message: " + successResponse.getMessage());
					}
					else if (actionResponse instanceof APIException)
					{
						APIException exception = (APIException) actionResponse;
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
			}
			else if (actionHandler instanceof APIException)
			{
				APIException exception = (APIException) actionHandler;
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
	}

	public static void main(String[] args)
	{
		try
		{
			Environment environment = USDataCenter.PRODUCTION;
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").redirectURL("Redirect_URL").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			Long dealId = 440248001177050l;
			Long contactId = 440248001030088l;
			addContactRoleToDeal(contactId, dealId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
