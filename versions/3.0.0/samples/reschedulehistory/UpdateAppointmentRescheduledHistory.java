package samples.reschedulehistory;

import java.lang.reflect.Field;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.reschedulehistory.APIException;
import com.zoho.crm.api.reschedulehistory.ActionHandler;
import com.zoho.crm.api.reschedulehistory.ActionResponse;
import com.zoho.crm.api.reschedulehistory.ActionWrapper;
import com.zoho.crm.api.reschedulehistory.AppointmentName;
import com.zoho.crm.api.reschedulehistory.BodyWrapper;
import com.zoho.crm.api.reschedulehistory.RescheduleHistory;
import com.zoho.crm.api.reschedulehistory.RescheduleHistoryOperations;
import com.zoho.crm.api.reschedulehistory.SuccessResponse;
import com.zoho.crm.api.reschedulehistory.User;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class UpdateAppointmentRescheduledHistory
{
	public static void updateAppointmentRescheduledHistory(Long id) throws Exception
	{
		RescheduleHistoryOperations rescheduleHistoryOperations = new RescheduleHistoryOperations();
		BodyWrapper request = new BodyWrapper();
		List<RescheduleHistory> data = new ArrayList<>();
		RescheduleHistory rescheduleHistory = new RescheduleHistory();
		AppointmentName appointmentName = new AppointmentName();
		appointmentName.setName("Name");
		appointmentName.setId(440248001298112l);
		rescheduleHistory.setAppointmentName(appointmentName);
		User rescheduledBy = new User();
		rescheduledBy.setId(4402480254001l);
		rescheduledBy.setName("UserName");
		rescheduleHistory.setRescheduledBy(rescheduledBy);
		rescheduleHistory.setRescheduledTo(OffsetDateTime.of(2023, 11, 20, 10, 00, 01, 00, ZoneOffset.of("+05:30")));
		rescheduleHistory.setRescheduledFrom(OffsetDateTime.of(2023, 11, 20, 11, 00, 01, 00, ZoneOffset.of("+05:30")));
		rescheduleHistory.setRescheduledTime(OffsetDateTime.of(2023, 11, 20, 10, 00, 01, 00, ZoneOffset.of("+05:30")));
		rescheduleHistory.setRescheduleNote("Customer unavailable");
		rescheduleHistory.setRescheduleReason("By Customer");
		data.add(rescheduleHistory);
		request.setData(data);
		APIResponse<ActionHandler> response = rescheduleHistoryOperations.updateAppointmentRescheduledHistory(id, request);
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
			Long id = 35687346127843l;
			updateAppointmentRescheduledHistory(id);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
