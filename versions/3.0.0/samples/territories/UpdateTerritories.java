package samples.territories;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.territories.APIException;
import com.zoho.crm.api.territories.ActionHandler;
import com.zoho.crm.api.territories.ActionResponse;
import com.zoho.crm.api.territories.ActionWrapper;
import com.zoho.crm.api.territories.BodyWrapper;
import com.zoho.crm.api.territories.Criteria;
import com.zoho.crm.api.territories.Field;
import com.zoho.crm.api.territories.Manager;
import com.zoho.crm.api.territories.ReportingTo;
import com.zoho.crm.api.territories.SuccessResponse;
import com.zoho.crm.api.territories.Territories;
import com.zoho.crm.api.territories.TerritoriesOperations;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;

public class UpdateTerritories
{
	public static void updateTerritories() throws Exception
	{
		TerritoriesOperations territoriesOperations = new TerritoriesOperations();
		BodyWrapper request = new BodyWrapper();
		List<Territories> territories = new ArrayList<>();
		Territories territory = new Territories();
		territory.setId(32133234546765l);
		territory.setName("territoryName");
		Criteria criteria = new Criteria();
		criteria.setComparator("equal");
		criteria.setValue("3");
		Field field = new Field();
		field.setAPIName("Account_Name");
		field.setId(32321323411l);
		criteria.setField(field);
		territory.setAccountRuleCriteria(criteria);
		Criteria criteria1 = new Criteria();
		criteria1.setComparator("not_between");
		List<String> value = new ArrayList<>();
		value.add("2023-08-10");
		value.add("2023-08-30");
		criteria1.setValue(value);
		Field field1 = new Field();
		field1.setAPIName("Closing_Date");
		field1.setId(323213231223411l);
		criteria1.setField(field1);
		territory.setDealRuleCriteria(criteria1);
		territory.setDescription("description");
		territory.setPermissionType(new Choice<>("read_only"));
		ReportingTo reportingTo = new ReportingTo();
		reportingTo.setId(312324234312l);
		territory.setReportingTo(reportingTo);
		Manager manager = new Manager();
		manager.setId(324234564533l);
		territory.setManager(manager);
		territories.add(territory);
		request.setTerritories(territories);
		APIResponse<ActionHandler> response = territoriesOperations.updateTerritories(request);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ActionWrapper)
				{
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
					List<ActionResponse> actionResponses = actionWrapper.getTerritories();
					if (actionResponses != null)
					{
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
				java.lang.reflect.Field[] fields = clas.getDeclaredFields();
				for (java.lang.reflect.Field field2 : fields)
				{
					field2.setAccessible(true);
					System.out.println(field2.getName() + ":" + field2.get(responseObject));
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
			updateTerritories();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
