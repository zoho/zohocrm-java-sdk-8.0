package samples.holidays;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.holidays.APIException;
import com.zoho.crm.api.holidays.Holiday;
import com.zoho.crm.api.holidays.HolidaysOperations;
import com.zoho.crm.api.holidays.ResponseHandler;
import com.zoho.crm.api.holidays.ResponseWrapper;
import com.zoho.crm.api.holidays.ShiftHour;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetHoliday
{
	public static void getHoliday(Long id) throws Exception
	{
		HolidaysOperations holidaysoperations = new HolidaysOperations("4402480020813");
		APIResponse<ResponseHandler> response = holidaysoperations.getHoliday(id);
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
				if (responseHandler instanceof ResponseWrapper)
				{
					ResponseWrapper responseWrapper = (ResponseWrapper) responseHandler;
					List<Holiday> holidays = responseWrapper.getHolidays();
					if (holidays != null)
					{
						for (Holiday holiday : holidays)
						{
							System.out.println("Holidays ID: " + holiday.getId());
							System.out.println("Holidays Name: " + holiday.getName());
							System.out.println("Holidays Date: " + holiday.getDate());
							System.out.println("Holidays Year: " + holiday.getYear());
							System.out.println("Holidays Type: " + holiday.getType());
							ShiftHour shifthour = holiday.getShiftHour();
							if (shifthour != null)
							{
								System.out.println("Holidays ShiftHour Name : " + shifthour.getName());
								System.out.println("Holidays Shifthour Id : " + shifthour.getId());
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
			long id = 440248001308004l;
			getHoliday(id);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
