package samples.tags;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.tags.APIException;
import com.zoho.crm.api.tags.NewTagRequestWrapper;
import com.zoho.crm.api.tags.RecordActionHandler;
import com.zoho.crm.api.tags.RecordActionResponse;
import com.zoho.crm.api.tags.RecordActionWrapper;
import com.zoho.crm.api.tags.RecordSuccessResponse;
import com.zoho.crm.api.tags.TagsOperations;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class AddTagsToRecord
{
	public static void addTagsToRecord(String moduleAPIName, long recordId) throws Exception
	{
		TagsOperations tagsOperations = new TagsOperations();
		NewTagRequestWrapper request = new NewTagRequestWrapper();
		List<com.zoho.crm.api.tags.Tag> tagList = new ArrayList<com.zoho.crm.api.tags.Tag>();
		com.zoho.crm.api.tags.Tag tag1 = new com.zoho.crm.api.tags.Tag();
		tag1.setName("tagNam3e3e12345");
		tagList.add(tag1);
		request.setTags(tagList);
		request.setOverWrite(false);
		ParameterMap paramInstance = new ParameterMap();
		APIResponse<RecordActionHandler> response = tagsOperations.addTags(moduleAPIName, recordId, request, paramInstance);
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
								if (entry.getKey().equals("tags"))
								{
									@SuppressWarnings("unchecked")
									List<com.zoho.crm.api.tags.RecordDetailTag> tags = (List<com.zoho.crm.api.tags.RecordDetailTag>) entry.getValue();
									for (com.zoho.crm.api.tags.RecordDetailTag tag : tags)
									{
										System.out.println("Tag ColorCode: " + tag.getColorCode());
										System.out.println("Tag Name: " + tag.getName());
										System.out.println("Tag ID: " + tag.getId());
									}
								}
								else
								{
									System.out.println(entry.getKey() + ": " + entry.getValue());
								}
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
			Long recordId = 34770615623115L;
			addTagsToRecord(moduleAPIName, recordId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
