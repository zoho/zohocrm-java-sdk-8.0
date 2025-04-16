package samples.tags;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.tags.APIException;
import com.zoho.crm.api.tags.ExistingTagRequestWrapper;
import com.zoho.crm.api.tags.RecordActionHandler;
import com.zoho.crm.api.tags.RecordActionResponse;
import com.zoho.crm.api.tags.RecordActionWrapper;
import com.zoho.crm.api.tags.RecordSuccessResponse;
import com.zoho.crm.api.tags.TagsOperations;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class RemoveTagsFromMultipleRecords
{
	public static void removeTagsFromMultipleRecords(String moduleAPIName, List<Long> recordIds) throws Exception
	{
		TagsOperations tagsOperations = new TagsOperations();
		ExistingTagRequestWrapper request = new ExistingTagRequestWrapper();
		List<com.zoho.crm.api.tags.ExistingTag> tagList = new ArrayList<com.zoho.crm.api.tags.ExistingTag>();
		com.zoho.crm.api.tags.ExistingTag tag1 = new com.zoho.crm.api.tags.ExistingTag();
		tag1.setName("tagNam3e3e12345");
		tagList.add(tag1);
		request.setTags(tagList);
		request.setIds(recordIds);
		ParameterMap paramInstance = new ParameterMap();
		APIResponse<RecordActionHandler> response = tagsOperations.removeTagsFromMultipleRecords(moduleAPIName, request, paramInstance);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				RecordActionHandler recordActionHandler = response.getObject();
				if (recordActionHandler instanceof RecordActionWrapper)
				{
					RecordActionWrapper recordActionWrapper = (RecordActionWrapper) recordActionHandler;
					List<RecordActionResponse> actionResponses = recordActionWrapper.getData();
					for (RecordActionResponse actionResponse : actionResponses)
					{
						if (actionResponse instanceof RecordSuccessResponse)
						{
							RecordSuccessResponse successResponse = (RecordSuccessResponse) actionResponse;
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
					if (recordActionWrapper.getLockedCount() != null)
					{
						System.out.println("Locked Count: " + recordActionWrapper.getLockedCount().toString());
					}
					if (recordActionWrapper.getSuccessCount() != null)
					{
						System.out.println("Success Count: " + recordActionWrapper.getSuccessCount());
					}
					if (recordActionWrapper.getWfScheduler() != null)
					{
						System.out.println("WF Scheduler: " + recordActionWrapper.getWfScheduler());
					}
				}
				else if (recordActionHandler instanceof APIException)
				{
					APIException exception = (APIException) recordActionHandler;
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
			String moduleAPIName = "Leads";
			ArrayList<Long> recordIds = new ArrayList<Long>(Arrays.asList(34770615623115l, 34770616114067l));
			removeTagsFromMultipleRecords(moduleAPIName, recordIds);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
