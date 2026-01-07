package samples.getrelatedrecordscount;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.getrelatedrecordscount.GetRelatedRecordsCountOperations;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.getrelatedrecordscount.APIException;
import com.zoho.crm.api.getrelatedrecordscount.ActionHandler;
import com.zoho.crm.api.getrelatedrecordscount.ActionResponse;
import com.zoho.crm.api.getrelatedrecordscount.ActionWrapper;
import com.zoho.crm.api.getrelatedrecordscount.RelatedList;
import com.zoho.crm.api.getrelatedrecordscount.BodyWrapper;
import com.zoho.crm.api.getrelatedrecordscount.GetRelatedRecordCount;
import com.zoho.crm.api.getrelatedrecordscount.SuccessResponse;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetRelatedRecordsCount
{

	public static void getRelatedRecordsCount(Long recordId, String moduleAPIName) throws Exception
	{
		GetRelatedRecordsCountOperations getRelatedRecordsCountOperations = new GetRelatedRecordsCountOperations(recordId, moduleAPIName);
		BodyWrapper request = new BodyWrapper();
		List<GetRelatedRecordCount> getRelatedRecordsCount = new ArrayList<>();
		GetRelatedRecordCount getRelatedRecordsCount1 = new GetRelatedRecordCount();
		RelatedList relatedList = new RelatedList();
		relatedList.setAPIName("Notes");
		relatedList.setId(34770602197l);
		getRelatedRecordsCount1.setRelatedList(relatedList);
		getRelatedRecordsCount.add(getRelatedRecordsCount1);
		request.setGetRelatedRecordsCount(getRelatedRecordsCount);
		APIResponse<ActionHandler> response = getRelatedRecordsCountOperations.getRelatedRecordsCount(request);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ActionWrapper)
				{
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
					List<ActionResponse> actionResponses = actionWrapper.getGetRelatedRecordsCount();
					for (ActionResponse actionResponse : actionResponses)
					{
						if (actionResponse instanceof SuccessResponse)
						{
							SuccessResponse successResponse = (SuccessResponse) actionResponse;
							System.out.println("Count: " + successResponse.getCount());
							relatedList = successResponse.getRelatedList();
							if(relatedList != null)
							{
								System.out.println("RelatedList APIName: " + relatedList.getAPIName());
								System.out.println("RelatedList Id: " + relatedList.getId());
							}
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
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			Long recordId = 34770002l;
			String moduleAPIName = "Leads";
			getRelatedRecordsCount(recordId, moduleAPIName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
