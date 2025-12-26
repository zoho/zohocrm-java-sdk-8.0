package samples.shifthours;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.shifthours.APIException;
import com.zoho.crm.api.shifthours.BreakCustomTiming;
import com.zoho.crm.api.shifthours.BreakHours;
import com.zoho.crm.api.shifthours.Holidays;
import com.zoho.crm.api.shifthours.ResponseWrapper;
import com.zoho.crm.api.shifthours.ResponseHandler;
import com.zoho.crm.api.shifthours.ShiftCount;
import com.zoho.crm.api.shifthours.ShiftCustomTiming;
import com.zoho.crm.api.shifthours.ShiftHours;
import com.zoho.crm.api.shifthours.ShiftHoursOperations;
import com.zoho.crm.api.shifthours.Users;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;
import com.zoho.crm.api.dc.DataCenter.Environment;

public class GetShiftHour
{
	public static void getShiftHour(Long id) throws Exception
	{
		ShiftHoursOperations shifthoursoperations = new ShiftHoursOperations("440248020813");
		APIResponse<ResponseHandler> response = shifthoursoperations.getShiftHour(id);
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
				ResponseHandler responseObject = (ResponseHandler) response.getObject();
				if (responseObject instanceof ResponseWrapper)
				{
					ResponseWrapper responseWrapper = (ResponseWrapper) responseObject;
					ShiftCount shiftcount = responseWrapper.getShiftCount();
					System.out.println("Shift_count :");
					System.out.println("total_shift_with_user :" + shiftcount.getTotalShiftWithUser());
					System.out.println("total_shift :" + shiftcount.getTotalShift());
					List<ShiftHours> shifthours = responseWrapper.getShiftHours();
					if (shifthours != null)
					{
						for (ShiftHours shifthour : shifthours)
						{
							System.out.println("name : " + shifthour.getName());
							System.out.println("same_as_everyday : " + shifthour.getSameAsEveryday());
							System.out.println("users_count : " + shifthour.getUsersCount());
							System.out.println("timezone : " + shifthour.getTimezone());
							List<String> shiftDays = shifthour.getShiftDays();
							if (shiftDays != null)
							{
								System.out.println("ShiftDays : ");
								for (String shiftDay : shiftDays)
								{
									System.out.println(shiftDay);
								}
							}
							List<LocalTime> dailyTiming = shifthour.getDailyTiming();
							if (dailyTiming != null)
							{
								System.out.println("Daily_timing : ");
								for (LocalTime dailytiming : dailyTiming)
								{
									System.out.println(dailytiming);
								}
							}
							List<ShiftCustomTiming> customTiming = shifthour.getCustomTiming();
							if (customTiming != null)
							{
								System.out.println("custom_timing : ");
								for (ShiftCustomTiming customtiming : customTiming)
								{
									List<LocalTime> shiftTiming = customtiming.getShiftTiming();
									if (shiftTiming != null)
									{
										System.out.println("shift_timing :");
										for (LocalTime shifttiming : shiftTiming)
										{
											System.out.println(shifttiming);
										}
									}
									System.out.println("days : " + customtiming.getDays());
								}
							}
							List<Holidays> holidays = shifthour.getHolidays();
							if (holidays != null)
							{
								System.out.println("holidays : ");
								for (Holidays holiday : holidays)
								{
									System.out.println("date : " + holiday.getDate());
									System.out.println("year : " + holiday.getYear());
									System.out.println("name : " + holiday.getName());
									System.out.println("id : " + holiday.getId());
								}
							}
							List<Users> users = shifthour.getUsers();
							if (users != null)
							{
								System.out.println("Users : ");
								for (Users user : users)
								{
									System.out.println("User_Id : " + user.getId());
									System.out.println("User_name : " + user.getName());
									System.out.println("User_email : " + user.getEmail());
									System.out.println("User_role : " + user.getRole());
									System.out.println("User_ZUID : " + user.getZuid());
									System.out.println("effective_from : " + user.getEffectiveFrom());
								}
							}
							List<BreakHours> breakHours = shifthour.getBreakHours();
							if (breakHours != null)
							{
								for (BreakHours breakhour : breakHours)
								{
									System.out.println("breakHour_ID : " + breakhour.getId());
									System.out.println("same_as_everyday : " + breakhour.getSameAsEveryday());
									List<String> breakdays = breakhour.getBreakDays();
									if (breakdays != null)
									{
										for (String breakday : breakdays)
										{
											System.out.println("breakdays : " + breakday);
										}
									}
									List<LocalTime> dailyTimings = breakhour.getDailyTiming();
									if (dailyTimings != null)
									{
										for (LocalTime dailytiming : dailyTimings)
										{
											System.out.println("dailyTiming : " + dailytiming);
										}
									}
									List<BreakCustomTiming> breakHoursCustomTimings = breakhour.getCustomTiming();
									if (breakHoursCustomTimings != null)
									{
										for (BreakCustomTiming breakHourCustomTiming : breakHoursCustomTimings)
										{
											System.out.println("CustomTiming : ");
											List<LocalTime> breakTimings = breakHourCustomTiming.getBreakTiming();
											if (breakTimings != null)
											{
												for (LocalTime breakTiming : breakTimings)
												{
													System.out.println("breakTiming : " + breakTiming);
												}
												System.out.println("days : " + breakHourCustomTiming.getDays());
											}
										}
									}
								}
							}
						}
					}
				}
				else if (responseObject instanceof APIException)
				{
					APIException exception = (APIException) responseObject;
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
			getShiftHour(440248001283021l);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
