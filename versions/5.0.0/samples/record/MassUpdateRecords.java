package samples.record;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.record.APIException;
import com.zoho.crm.api.record.MassUpdateActionHandler;
import com.zoho.crm.api.record.MassUpdateActionResponse;
import com.zoho.crm.api.record.MassUpdateActionWrapper;
import com.zoho.crm.api.record.MassUpdateBodyWrapper;
import com.zoho.crm.api.record.MassUpdateSuccessResponse;
import com.zoho.crm.api.record.RecordOperations;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class MassUpdateRecords
{
	public static void massUpdateRecords(String moduleAPIName) throws Exception
	{
		RecordOperations recordOperations = new RecordOperations(moduleAPIName);
		MassUpdateBodyWrapper request = new MassUpdateBodyWrapper();
		List<com.zoho.crm.api.record.Record> records = new ArrayList<com.zoho.crm.api.record.Record>();
		com.zoho.crm.api.record.Record record1 = new com.zoho.crm.api.record.Record();

		/*
		 * Call addKeyValue method that takes two arguments 1 -> A string that is the Field's API Name 2 -> Value
		 */
		record1.addKeyValue("City", "Value");
//		record1.addKeyValue("Company", "Value");

		records.add(record1);
		request.setData(records);

		request.setCvid("3477061087501");
		List<String> ids = new ArrayList<String>(Arrays.asList("34770615922192"));
		request.setIds(ids);
//		Territory territory = new Territory();
//		territory.setId("");
//		territory.setIncludeChild(true);
//		request.setTerritory(territory);
		request.setOverWrite(true);

		APIResponse<MassUpdateActionHandler> response = recordOperations.massUpdateRecords(request);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				MassUpdateActionHandler massUpdateActionHandler = response.getObject();
				if (massUpdateActionHandler instanceof MassUpdateActionWrapper)
				{
					MassUpdateActionWrapper massUpdateActionWrapper = (MassUpdateActionWrapper) massUpdateActionHandler;
					List<MassUpdateActionResponse> massUpdateActionResponses = massUpdateActionWrapper.getData();
					for (MassUpdateActionResponse massUpdateActionResponse : massUpdateActionResponses)
					{
						if (massUpdateActionResponse instanceof MassUpdateSuccessResponse)
						{
							MassUpdateSuccessResponse massUpdateSuccessResponse = (MassUpdateSuccessResponse) massUpdateActionResponse;
							System.out.println("Status: " + massUpdateSuccessResponse.getStatus().getValue());
							System.out.println("Code: " + massUpdateSuccessResponse.getCode().getValue());
							System.out.println("Details: ");
							for (Map.Entry<String, Object> entry : massUpdateSuccessResponse.getDetails().entrySet())
							{
								System.out.println(entry.getKey() + ": " + entry.getValue());
							}
							System.out.println("Message: " + massUpdateSuccessResponse.getMessage().getValue());
						}
						else if (massUpdateActionResponse instanceof APIException)
						{
							APIException exception = (APIException) massUpdateActionResponse;
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
				else if (massUpdateActionHandler instanceof APIException)
				{
					APIException exception = (APIException) massUpdateActionHandler;
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
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").redirectURL("Redirect_URL").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			String moduleAPIName = "Leads";
			massUpdateRecords(moduleAPIName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
