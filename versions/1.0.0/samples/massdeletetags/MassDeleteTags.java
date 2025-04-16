package samples.massdeletetags;

import com.zoho.crm.api.massdeletetags.MassDeleteTagsOperations;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.massdeletetags.ActionResponse;
import com.zoho.crm.api.massdeletetags.BodyWrapper;
import com.zoho.crm.api.massdeletetags.MassDelete;
import com.zoho.crm.api.massdeletetags.Module;
import com.zoho.crm.api.massdeletetags.Tag;
import com.zoho.crm.api.massdeletetags.APIException;
import com.zoho.crm.api.massdeletetags.SuccessResponse;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class MassDeleteTags
{
	public static void massDeleteTags() throws Exception
	{
		MassDeleteTagsOperations massDeleteTagsOperations = new MassDeleteTagsOperations();
		BodyWrapper request = new BodyWrapper();
		List<MassDelete> massDelete = new ArrayList<MassDelete>();
		MassDelete massDelete1 = new MassDelete();
		Module module = new Module();
		module.setAPIName("Leads");
		module.setId(347706002175l);
		massDelete1.setModule(module);
		List<Tag> tags = new ArrayList<Tag>();
		Tag tag = new Tag();
		tag.setId(34770689001l);
		tags.add(tag);
		tag = new Tag();
		tag.setId(34770628007l);
		tags.add(tag);
		massDelete1.setTags(tags);
		massDelete.add(massDelete1);
		request.setMassDelete(massDelete);
		APIResponse<ActionResponse> response = massDeleteTagsOperations.massDeleteTags(request);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionResponse actionResponse = response.getObject();
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
					System.out.println("Message: " + successResponse.getMessage());
				}
				else if (actionResponse instanceof APIException)
				{
					APIException exception = (APIException) actionResponse;
					System.out.println("Status: " + exception.getStatus().getValue());
					System.out.println("Code: " + exception.getCode().getValue());
					System.out.println("Details: ");
					if (exception.getDetails() != null)
					{
						for (Map.Entry<String, Object> entry : exception.getDetails().entrySet())
						{
							System.out.println(entry.getKey() + ": " + entry.getValue());
						}
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
			massDeleteTags();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
