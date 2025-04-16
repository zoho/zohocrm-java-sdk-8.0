package samples.tags;

import java.util.Arrays;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.tags.APIException;
import com.zoho.crm.api.tags.CountResponseWrapper;
import com.zoho.crm.api.tags.ResponseHandler;
import com.zoho.crm.api.tags.TagsOperations;
import com.zoho.crm.api.tags.TagsOperations.GetRecordCountForTagParam;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetRecordCountForTag
{
	public static void getRecordCountForTag(String moduleAPIName, Long tagId) throws Exception
	{
		TagsOperations tagsOperations = new TagsOperations();
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(GetRecordCountForTagParam.MODULE, moduleAPIName);
		APIResponse<ResponseHandler> response = tagsOperations.getRecordCountForTag(tagId, paramInstance);
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
				ResponseHandler countHandler = response.getObject();
				if (countHandler instanceof CountResponseWrapper)
				{
					CountResponseWrapper countWrapper = (CountResponseWrapper) countHandler;
					System.out.println("Tag Count: " + countWrapper.getCount());
				}
				else if (countHandler instanceof APIException)
				{
					APIException exception = (APIException) countHandler;
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
			Long tagId = 440248001279032l;
			getRecordCountForTag(moduleAPIName, tagId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
