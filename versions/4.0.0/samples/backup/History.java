package samples.backup;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.backup.APIException;
import com.zoho.crm.api.backup.BackupOperations;
import com.zoho.crm.api.backup.HistoryWrapper;
import com.zoho.crm.api.backup.Info;
import com.zoho.crm.api.backup.Requester;
import com.zoho.crm.api.backup.ResponseHandler;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class History
{
	public static void history() throws Exception
	{
		BackupOperations backupOperations = new BackupOperations();
		ParameterMap paramInstance = new ParameterMap();

		APIResponse<ResponseHandler> response = backupOperations.history(paramInstance);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ResponseHandler responseHandler = response.getObject();
				if (responseHandler instanceof HistoryWrapper)
				{
					HistoryWrapper historyWrapper = (HistoryWrapper) responseHandler;
					List<com.zoho.crm.api.backup.History> history = historyWrapper.getHistory();

					for (com.zoho.crm.api.backup.History history1 : history)
					{
						System.out.println("History Id: " + history1.getId());
						Requester doneBy = history1.getDoneBy();
						if (doneBy != null)
						{
							System.out.println("History DoneBy Id: " + doneBy.getId());
							System.out.println("History DoneBy Name: " + doneBy.getName());
							System.out.println("History DoneBy Zuid: " + doneBy.getZuid());
						}
						System.out.println("History LogTime: " + history1.getLogTime());
						System.out.println("History State: " + history1.getState());
						System.out.println("History Action: " + history1.getAction());
						System.out.println("History RepeatType: " + history1.getRepeatType());
						System.out.println("History FileName: " + history1.getFileName());
						System.out.println("History Count: " + history1.getCount());
					}
					Info info = historyWrapper.getInfo();
					if (info != null)
					{
						if (info.getPerPage() != null)
						{
							System.out.println("History Info PerPage: " + info.getPerPage().toString());
						}
						if (info.getCount() != null)
						{
							System.out.println("History Info Count: " + info.getCount().toString());
						}
						if (info.getPage() != null)
						{
							System.out.println("History Info Page: " + info.getPage());
						}
						if (info.getMoreRecords() != null)
						{
							System.out.println("History Info MoreRecords: " + info.getMoreRecords().toString());
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
			history();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
