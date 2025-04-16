package samples.convertlead;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.convertlead.APIException;
import com.zoho.crm.api.convertlead.ActionHandler;
import com.zoho.crm.api.convertlead.ActionResponse;
import com.zoho.crm.api.convertlead.ActionWrapper;
import com.zoho.crm.api.convertlead.BodyWrapper;
import com.zoho.crm.api.convertlead.ConvertLeadOperations;
import com.zoho.crm.api.convertlead.LeadConverter;
import com.zoho.crm.api.convertlead.SuccessResponse;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.record.Field;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.users.MinifiedUser;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;

public class ConvertLead
{
	public static void convertLead(Long leadId) throws Exception
	{
		ConvertLeadOperations convertLeadOperations = new ConvertLeadOperations(leadId);
		BodyWrapper request = new BodyWrapper();
		List<LeadConverter> data = new ArrayList<LeadConverter>();
		LeadConverter record1 = new LeadConverter();
		record1.setOverwrite(true);
		record1.setNotifyLeadOwner(true);
		record1.setNotifyNewEntityOwner(true);

		com.zoho.crm.api.record.Record accounts = new com.zoho.crm.api.record.Record();
		accounts.setId(34770607004l);
		record1.setAccounts(accounts);

		com.zoho.crm.api.record.Record contacts = new com.zoho.crm.api.record.Record();
		contacts.setId(3477064004l);
		record1.setContacts(contacts);

		MinifiedUser assignTo = new MinifiedUser();
		assignTo.setId(3477173021l);
		record1.setAssignTo(assignTo);

		com.zoho.crm.api.record.Record deals = new com.zoho.crm.api.record.Record();

		/*
		 * Call addFieldValue method that takes two arguments 1 -> Call Field "." and choose the module from the displayed list and press "." and choose the field name from the displayed list. 2 -> Value
		 */
		deals.addFieldValue(Field.Deals.DEAL_NAME, "deal_name");
		deals.addFieldValue(Field.Deals.DESCRIPTION, "deals description");
		deals.addFieldValue(Field.Deals.CLOSING_DATE, LocalDate.of(2021, 1, 13));
		deals.addFieldValue(Field.Deals.STAGE, new Choice<String>("Closed Won"));
		deals.addFieldValue(Field.Deals.AMOUNT, 50.7);

		/*
		 * Call addKeyValue method that takes two arguments 1 -> A string that is the Field's API Name 2 -> Value
		 */
		deals.addKeyValue("Custom_field", "Value");
		deals.addKeyValue("Pipeline", new Choice<String>("Qualification"));

		record1.setDeals(deals);
		data.add(record1);

		request.setData(data);
		APIResponse<ActionHandler> response = convertLeadOperations.convertLead(request);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
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
							for (Map.Entry<String, Object> entry : successResponse.getDetails().entrySet())
							{
								System.out.println(entry.getKey() + ": " + entry.getValue());
							}
							System.out.println("Message: " + successResponse.getMessage().getValue());
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
							System.out.println("Message: " + exception.getMessage().getValue());
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
					System.out.println("Message: " + exception.getMessage().getValue());
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
			Long leadId = 347706057l;
			convertLead(leadId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
