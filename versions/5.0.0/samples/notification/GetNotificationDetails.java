package samples.notification;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.notifications.APIException;
import com.zoho.crm.api.notifications.Info;
import com.zoho.crm.api.notifications.NotificationsOperations;
import com.zoho.crm.api.notifications.ResponseHandler;
import com.zoho.crm.api.notifications.ResponseWrapper;
import com.zoho.crm.api.notifications.NotificationsOperations.GetNotificationsParam;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetNotificationDetails
{
	public static void getNotificationDetails() throws Exception
	{
		NotificationsOperations notificationOperations = new NotificationsOperations();
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(GetNotificationsParam.CHANNEL_ID, 106800211l);
		paramInstance.add(GetNotificationsParam.MODULE, "Accounts");
		paramInstance.add(GetNotificationsParam.PAGE, 1);
		paramInstance.add(GetNotificationsParam.PER_PAGE, 2);
		APIResponse<ResponseHandler> response = notificationOperations.getNotifications(paramInstance);
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
					List<com.zoho.crm.api.notifications.Notification> notifications = responseWrapper.getWatch();
					for (com.zoho.crm.api.notifications.Notification notification : notifications)
					{
						System.out.println("Notification NotifyOnRelatedAction: " + notification.getNotifyOnRelatedAction());
						System.out.println("Notification ChannelExpiry: " + notification.getChannelExpiry());
						System.out.println("Notification ResourceUri: " + notification.getResourceUri());
						System.out.println("Notification ResourceId: " + notification.getResourceId());
						System.out.println("Notification NotifyUrl: " + notification.getNotifyUrl());
						System.out.println("Notification ResourceName: " + notification.getResourceName());
						System.out.println("Notification ChannelId: " + notification.getChannelId());
						List<String> fields = notification.getEvents();
						if (fields != null)
						{
							for (Object fieldName : fields)
							{
								System.out.println("Notification Events: " + fieldName);
							}
						}
						System.out.println("Notification Token: " + notification.getToken());
					}
					Info info = responseWrapper.getInfo();
					if (info != null)
					{
						if (info.getPerPage() != null)
						{
							System.out.println("Record Info PerPage: " + info.getPerPage().toString());
						}
						if (info.getCount() != null)
						{
							System.out.println("Record Info Count: " + info.getCount().toString());
						}
						if (info.getPage() != null)
						{
							System.out.println("Record Info Page: " + info.getPage().toString());
						}
						if (info.getMoreRecords() != null)
						{
							System.out.println("Record Info MoreRecords: " + info.getMoreRecords().toString());
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
			getNotificationDetails();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
