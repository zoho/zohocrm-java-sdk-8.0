package samples.appointmentpreferences;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.appointmentpreference.APIException;
import com.zoho.crm.api.appointmentpreference.AppointmentPreference;
import com.zoho.crm.api.appointmentpreference.AppointmentPreferenceOperations;
import com.zoho.crm.api.appointmentpreference.ResponseHandler;
import com.zoho.crm.api.appointmentpreference.ResponseWrapper;
import com.zoho.crm.api.appointmentpreference.AppointmentPreferenceOperations.GetAppointmentPreferenceParam;
import com.zoho.crm.api.appointmentpreference.DealRecordConfiguration;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.appointmentpreference.FieldMappings;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetAppointmentPreference
{
	public static void getAppointmentPreference() throws Exception
	{
		AppointmentPreferenceOperations appointmentPreferenceOperations = new AppointmentPreferenceOperations();
		ParameterMap paraminstance = new ParameterMap();
		paraminstance.add(GetAppointmentPreferenceParam.INCLUDE, "");
		APIResponse<ResponseHandler> response = appointmentPreferenceOperations.getAppointmentPreference(paraminstance);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.getStatusCode() == 204)
			{
				System.out.println("No Content");
				return;
			}
			if (response.isExpected())
			{
				ResponseHandler responseHandler = response.getObject();
				if (responseHandler instanceof ResponseWrapper)
				{
					ResponseWrapper responseWrapper = (ResponseWrapper) responseHandler;
					AppointmentPreference appointmentPreferences = responseWrapper.getAppointmentPreferences();
					if (appointmentPreferences != null)
					{
						System.out.println("AppointmentPreference showJobSheet : " + appointmentPreferences.getShowJobSheet());
						System.out.println("AppointmentPreference whenDurationExceeds : " + appointmentPreferences.getWhenDurationExceeds());
						System.out.println("AppointmentPreference allowBookingOutsideServiceAvailability : " + appointmentPreferences.getAllowBookingOutsideServiceAvailability());
						System.out.println("AppointmentPreference whenAppointmentCompleted : " + appointmentPreferences.getWhenAppointmentCompleted().getValue());
						System.out.println("AppointmentPreference allowBookingOutsideBusinesshours : " + appointmentPreferences.getAllowBookingOutsideBusinesshours());
						DealRecordConfiguration dealRecordConfiguration = appointmentPreferences.getDealRecordConfiguration();
						if (dealRecordConfiguration != null)
						{
							com.zoho.crm.api.appointmentpreference.Layout layout = dealRecordConfiguration.getLayout();
							if (layout != null)
							{
								System.out.println("Layout Id :" + layout.getId());
								System.out.println("LayoutName : " + layout.getAPIName());
							}
							List<com.zoho.crm.api.appointmentpreference.FieldMappings> fieldMappings = dealRecordConfiguration.getFieldMappings();
							if (fieldMappings != null)
							{
								for (FieldMappings fieldMapping : fieldMappings)
								{
									System.out.println("FieldMAppings Type: " + fieldMapping.getType().getValue());
									System.out.println("FieldMappings Value: " + fieldMapping.getValue());
									com.zoho.crm.api.appointmentpreference.Field field = fieldMapping.getField();
									if (field != null)
									{
										System.out.println("Field APIName : " + field.getAPIName());
										System.out.println("Field Id : " + field.getId());
									}
								}
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
			else if (response.getStatusCode() != 204)
			{
				Model responseObject = response.getModel();
				Class<? extends Model> clas = responseObject.getClass();
				Field[] fields = clas.getDeclaredFields();
				for (Field field1 : fields)
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
			getAppointmentPreference();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
