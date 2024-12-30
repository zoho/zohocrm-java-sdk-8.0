package samples.appointmentpreferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.appointmentpreference.APIException;
import com.zoho.crm.api.appointmentpreference.ActionHandler;
import com.zoho.crm.api.appointmentpreference.ActionResponse;
import com.zoho.crm.api.appointmentpreference.ActionWrapper;
import com.zoho.crm.api.appointmentpreference.AppointmentPreference;
import com.zoho.crm.api.appointmentpreference.AppointmentPreferenceOperations;
import com.zoho.crm.api.appointmentpreference.BodyWrapper;
import com.zoho.crm.api.appointmentpreference.DealRecordConfiguration;
import com.zoho.crm.api.appointmentpreference.Field;
import com.zoho.crm.api.appointmentpreference.FieldMappings;
import com.zoho.crm.api.appointmentpreference.Layout;
import com.zoho.crm.api.appointmentpreference.SuccessResponse;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;

public class UpdateAppointmentPreference
{
	public static void updateAppointmentPreference() throws Exception
	{
		AppointmentPreferenceOperations appointmentPreferenceOperations = new AppointmentPreferenceOperations();
		BodyWrapper request = new BodyWrapper();
		AppointmentPreference appointmentPreferences = new AppointmentPreference();
		appointmentPreferences.setAllowBookingOutsideBusinesshours(false);
		appointmentPreferences.setAllowBookingOutsideServiceAvailability(true);
		appointmentPreferences.setWhenAppointmentCompleted(new Choice<String>("create_deal"));
		appointmentPreferences.setWhenDurationExceeds("ask_appointment_provider_to_complete");
		appointmentPreferences.setShowJobSheet(true);
		DealRecordConfiguration dealRecordConfiguration = new DealRecordConfiguration();
		Layout layout = new Layout();
		layout.setAPIName("Standard");
		layout.setId(4402480173l);
		dealRecordConfiguration.setLayout(layout);
		List<FieldMappings> mappings = new ArrayList<>();
		FieldMappings fieldMappings = new FieldMappings();
		fieldMappings.setType(new Choice<String>("static"));
		fieldMappings.setValue("Closed Won");
		Field field = new Field();
		field.setAPIName("Stage");
		field.setId(440248001308017l);
		fieldMappings.setField(field);
		mappings.add(fieldMappings);
		dealRecordConfiguration.setFieldMappings(mappings);
		appointmentPreferences.setDealRecordConfiguration(dealRecordConfiguration);
		request.setAppointmentPreferences(appointmentPreferences);
		APIResponse<ActionHandler> response = appointmentPreferenceOperations.updateAppointmentPreference(request);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ActionWrapper)
				{
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
					ActionResponse actionResponse = actionWrapper.getAppointmentPreferences();
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
						System.out.println("Message: " + exception.getMessage());
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
				for (java.lang.reflect.Field field1 : fields)
				{
					field1.setAccessible(true);
					System.out.println(field1.getName() + ":" + field1.get(responseObject));
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
			updateAppointmentPreference();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
