package samples.businesshours;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.businesshours.APIException;
import com.zoho.crm.api.businesshours.ActionHandler;
import com.zoho.crm.api.businesshours.ActionResponse;
import com.zoho.crm.api.businesshours.ActionWrapper;
import com.zoho.crm.api.businesshours.BodyWrapper;
import com.zoho.crm.api.businesshours.BreakHoursCustomTiming;
import com.zoho.crm.api.businesshours.BusinessHours;
import com.zoho.crm.api.businesshours.BusinessHoursOperations;
import com.zoho.crm.api.businesshours.SuccessResponse;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;

public class UpdateBusinessHours
{
	public static void updateBusinessHours() throws Exception
	{
		BusinessHoursOperations businessHoursOperations = new BusinessHoursOperations("4402480020813");
		BodyWrapper request = new BodyWrapper();
		BusinessHours businessHours = new BusinessHours();
		businessHours.setId(347706118993003l);
		businessHours.setSameAsEveryday(false);
		List<Choice<String>> businessdays = new ArrayList<Choice<String>>();
		businessdays.add(new Choice<String>("Monday"));
		businessdays.add(new Choice<String>("Tuesday"));
		businessdays.add(new Choice<String>("Wednesday"));
		businessHours.setBusinessDays(businessdays);
		businessHours.setWeekStartsOn(new Choice<String>("Monday"));
		BreakHoursCustomTiming bhct = new BreakHoursCustomTiming();
		bhct.setDays(new Choice<String>("Monday"));
		List<String> businessTiming = new ArrayList<String>();
		businessTiming.add("09:00");
		businessTiming.add("17:00");
		bhct.setBusinessTiming(businessTiming);
		//
		BreakHoursCustomTiming bhct1 = new BreakHoursCustomTiming();
		bhct1.setDays(new Choice<String>("Tuesday"));
		List<String> businessTiming1 = new ArrayList<String>();
		businessTiming1.add("10:30");
		businessTiming1.add("17:00");
		bhct1.setBusinessTiming(businessTiming1);
		//
		BreakHoursCustomTiming bhct2 = new BreakHoursCustomTiming();
		bhct2.setDays(new Choice<String>("Wednesday"));
		List<String> businessTiming2 = new ArrayList<String>();
		businessTiming2.add("11:00");
		businessTiming2.add("17:00");
		bhct2.setBusinessTiming(businessTiming2);
		//
		List<BreakHoursCustomTiming> customTiming = new ArrayList<BreakHoursCustomTiming>();
		customTiming.add(bhct);
		customTiming.add(bhct1);
		customTiming.add(bhct2);
		businessHours.setCustomTiming(customTiming);
		// when sameasEveryday is true
		List<String> dailyTiming = new ArrayList<String>();
		dailyTiming.add("10:00");
		dailyTiming.add("19:00");
		businessHours.setDailyTiming(dailyTiming);
		businessHours.setType(new Choice<String>("custom"));
		request.setBusinessHours(businessHours);
		APIResponse<ActionHandler> response = businessHoursOperations.updateBusinessHours(request);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ActionWrapper)
				{
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
					ActionResponse actionResponse = actionWrapper.getBusinessHours();
					if (actionResponse instanceof SuccessResponse)
					{
						SuccessResponse businesshourscreated = (SuccessResponse) actionResponse;
						System.out.println("Status: " + businesshourscreated.getStatus().getValue());
						System.out.println("Code: " + businesshourscreated.getCode().getValue());
						System.out.println("Details: ");
						for (Map.Entry<String, Object> entry : businesshourscreated.getDetails().entrySet())
						{
							System.out.println(entry.getKey() + ": " + entry.getValue());
						}
						System.out.println("Message: " + businesshourscreated.getMessage().getValue());
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
			updateBusinessHours();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
