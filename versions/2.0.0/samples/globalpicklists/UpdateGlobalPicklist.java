package samples.globalpicklists;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.globalpicklists.APIException;
import com.zoho.crm.api.globalpicklists.ActionHandler;
import com.zoho.crm.api.globalpicklists.ActionResponse;
import com.zoho.crm.api.globalpicklists.ActionWrapper;
import com.zoho.crm.api.globalpicklists.BodyWrapper;
import com.zoho.crm.api.globalpicklists.GlobalPicklistsOperations;
import com.zoho.crm.api.globalpicklists.PickListValues;
import com.zoho.crm.api.globalpicklists.Picklist;
import com.zoho.crm.api.globalpicklists.SuccessResponse;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;

public class UpdateGlobalPicklist
{
	public static void updateGlobalPicklist(Long id) throws Exception
	{
		GlobalPicklistsOperations globalPicklistsOperations = new GlobalPicklistsOperations();
		BodyWrapper bodyWrapper = new BodyWrapper();
		List<Picklist> globalPicklists = new ArrayList<Picklist>();
		Picklist globalPicklist = new Picklist();
		globalPicklist.setDisplayLabel("SourceTest1");
		globalPicklist.setDescription("desc");
		globalPicklist.setPickListValuesSortedLexically(false);
		List<PickListValues> pickListValues = new ArrayList<PickListValues>();
		PickListValues pickListValue = new PickListValues();
		pickListValue.setDisplayValue("Cold Call");
		pickListValue.setSequenceNumber(2);
		pickListValue.setActualValue("Cold Call");
		pickListValue.setType(new Choice<String>("used"));
		pickListValues.add(pickListValue);
		
		pickListValue = new PickListValues();
		pickListValue.setDisplayValue("Facebook");
		pickListValue.setSequenceNumber(16);
		pickListValue.setActualValue("Facebook");
		pickListValue.setType(new Choice<String>("used"));
		pickListValues.add(pickListValue);
		
		pickListValue = new PickListValues();
		pickListValue.setDisplayValue("Twitter");
		pickListValue.setSequenceNumber(15);
		pickListValue.setActualValue("Twitter");
		pickListValue.setType(new Choice<String>("unused"));
		pickListValues.add(pickListValue);
		
		pickListValue = new PickListValues();
		pickListValue.setDisplayValue("Google+");
		pickListValue.setSequenceNumber(3);
		pickListValue.setActualValue("Google+");
		pickListValue.setType(new Choice<String>("used"));
		pickListValues.add(pickListValue);
		
		globalPicklist.setPickListValues(pickListValues);
		globalPicklists.add(globalPicklist);
		bodyWrapper.setGlobalPicklists(globalPicklists);
		APIResponse<ActionHandler> response = globalPicklistsOperations.updateGlobalPicklist(id, bodyWrapper);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ActionWrapper)
				{
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
					List<ActionResponse> actionResponses = actionWrapper.getGlobalPicklists();
					for (ActionResponse actionResponse : actionResponses)
					{
						if (actionResponse instanceof SuccessResponse)
						{
							SuccessResponse successResponse = (SuccessResponse) actionResponse;
							System.out.println("Status: " + successResponse.getStatus().getValue());
							System.out.println("Code: " + successResponse.getCode().getValue());
							System.out.println("Details: ");
							for (Map.Entry<String, Object> entry : successResponse.getDetails().entrySet())
							{
								System.out.println(entry.getKey() + ": " + entry.getValue());
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
			else
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
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").redirectURL("Redirect_URL").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			Long id = 347706120961002l;
			updateGlobalPicklist(id);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
