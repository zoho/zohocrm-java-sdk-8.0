package samples.tags;

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
import com.zoho.crm.api.tags.Info;
import com.zoho.crm.api.tags.ResponseHandler;
import com.zoho.crm.api.tags.ResponseWrapper;
import com.zoho.crm.api.tags.TagsOperations;
import com.zoho.crm.api.tags.TagsOperations.GetTagsParam;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetTags
{
	public static void getTags(String moduleAPIName) throws Exception
	{
		TagsOperations tagsOperations = new TagsOperations();
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(GetTagsParam.MODULE, moduleAPIName);
//		paramInstance.add(GetTagsParam.MY_TAGS, Boolean.FALSE);
		APIResponse<ResponseHandler> response = tagsOperations.getTags(paramInstance);
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
					List<com.zoho.crm.api.tags.Tag> tags = responseWrapper.getTags();
					for (com.zoho.crm.api.tags.Tag tag : tags)
					{
						System.out.println("Tag CreatedTime: " + tag.getCreatedTime());
						System.out.println("Tag ModifiedTime: " + tag.getModifiedTime());
						System.out.println("Tag ColorCode: " + tag.getColorCode());
						System.out.println("Tag Name: " + tag.getName());
						com.zoho.crm.api.users.MinifiedUser modifiedBy = tag.getModifiedBy();
						if (modifiedBy != null)
						{
							System.out.println("Tag Modified By User-ID: " + modifiedBy.getId());
							System.out.println("Tag Modified By User-Name: " + modifiedBy.getName());
						}
						System.out.println("Tag ID: " + tag.getId());
						com.zoho.crm.api.users.MinifiedUser createdBy = tag.getCreatedBy();
						if (createdBy != null)
						{
							System.out.println("Tag Created By User-ID: " + createdBy.getId());
							System.out.println("Tag Created By User-Name: " + createdBy.getName());
						}
					}
					Info info = responseWrapper.getInfo();
					if (info != null)
					{
						if (info.getCount() != null)
						{
							System.out.println("Tag Info Count: " + info.getCount().toString());
						}
						if (info.getAllowedCount() != null)
						{
							System.out.println("Tag Info AllowedCount: " + info.getAllowedCount().toString());
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
			getTags(moduleAPIName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
