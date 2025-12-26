package samples.relatedrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.HeaderMap;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.relatedrecords.APIException;
import com.zoho.crm.api.relatedrecords.ActionHandler;
import com.zoho.crm.api.relatedrecords.ActionResponse;
import com.zoho.crm.api.relatedrecords.ActionWrapper;
import com.zoho.crm.api.relatedrecords.BodyWrapper;
import com.zoho.crm.api.relatedrecords.RelatedRecordsOperations;
import com.zoho.crm.api.relatedrecords.SuccessResponse;
import com.zoho.crm.api.relatedrecords.RelatedRecordsOperations.UpdateRelatedRecordsUsingExternalIDHeader;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class UpdateRelatedRecordsUsingExternalId
{
	public static void updateRelatedRecordsUsingExternalId(String moduleAPIName, String externalValue, String relatedListAPIName) throws Exception
	{
		String xExternal = "Leads.External,Products.Products_External";
		RelatedRecordsOperations relatedRecordsOperations = new RelatedRecordsOperations(relatedListAPIName, moduleAPIName);
		BodyWrapper request = new BodyWrapper();
		List<com.zoho.crm.api.record.Record> records = new ArrayList<com.zoho.crm.api.record.Record>();
		com.zoho.crm.api.record.Record record1 = new com.zoho.crm.api.record.Record();

		/*
		 * Call addKeyValue method that takes two arguments 1 -> A string that is the Field's API Name 2 -> Value
		 */
		record1.addKeyValue("Products_External", "AutomatedSDKExternal");
		record1.addKeyValue("list_price", 50.56);
		records.add(record1);

		com.zoho.crm.api.record.Record record2 = new com.zoho.crm.api.record.Record();

		/*
		 * Call addKeyValue method that takes two arguments 1 -> A string that is the Field's API Name 2 -> Value
		 */
		record2.addKeyValue("Products_External", "AutomatedSDKExternal");
		record2.addKeyValue("list_price", 50.56);
		records.add(record2);
		request.setData(records);
		HeaderMap headerInstance = new HeaderMap();
		headerInstance.add(UpdateRelatedRecordsUsingExternalIDHeader.X_EXTERNAL, xExternal);
		APIResponse<ActionHandler> response = relatedRecordsOperations.updateRelatedRecordsUsingExternalId(externalValue, request, headerInstance);
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
							System.out.println("Message: " + exception.getMessage().getValue());
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
			String externalValue = "34770615177002";
			String relatedListAPIName = "Products";
			updateRelatedRecordsUsingExternalId(moduleAPIName, externalValue, relatedListAPIName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
