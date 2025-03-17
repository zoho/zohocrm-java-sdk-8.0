package samples.bulkwrite;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.bulkwrite.APIException;
import com.zoho.crm.api.bulkwrite.ActionResponse;
import com.zoho.crm.api.bulkwrite.BulkWriteOperations;
import com.zoho.crm.api.bulkwrite.CallBack;
import com.zoho.crm.api.bulkwrite.DefaultValue;
import com.zoho.crm.api.bulkwrite.FieldMapping;
import com.zoho.crm.api.bulkwrite.RequestWrapper;
import com.zoho.crm.api.bulkwrite.Resource;
import com.zoho.crm.api.bulkwrite.SuccessResponse;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.modules.MinifiedModule;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;

public class CreateBulkWriteJob
{
	public static void createBulkWriteJob(String moduleAPIName, String fileId) throws Exception
	{
		BulkWriteOperations bulkWriteOperations = new BulkWriteOperations();
		RequestWrapper requestWrapper = new RequestWrapper();
		CallBack callback = new CallBack();
		callback.setUrl("https://www.example.com/callback");
		callback.setMethod(new Choice<String>("post"));
		requestWrapper.setCallback(callback);
		requestWrapper.setCharacterEncoding("UTF-8");
		requestWrapper.setOperation(new Choice<String>("upsert"));
		List<Resource> resource = new ArrayList<Resource>();
		Resource resourceIns = new Resource();
		resourceIns.setType(new Choice<String>("data"));
		resourceIns.setFileId(fileId);
		resourceIns.setIgnoreEmpty(true);
		resourceIns.setFindBy("Email");
		MinifiedModule module = new MinifiedModule();
		module.setAPIName(moduleAPIName);
		resourceIns.setModule(module);
		List<FieldMapping> fieldMappings = new ArrayList<FieldMapping>();
		FieldMapping fieldMapping;
		fieldMapping = new FieldMapping();
		fieldMapping.setAPIName("Last_Name");
		fieldMapping.setIndex(0);
		fieldMappings.add(fieldMapping);
		fieldMapping = new FieldMapping();
		fieldMapping.setAPIName("Email");
		fieldMapping.setIndex(1);
		fieldMappings.add(fieldMapping);
		fieldMapping = new FieldMapping();
		fieldMapping.setAPIName("Company");
		fieldMapping.setIndex(2);
		fieldMappings.add(fieldMapping);
		fieldMapping = new FieldMapping();
		fieldMapping.setAPIName("Phone");
		fieldMapping.setIndex(3);
		fieldMappings.add(fieldMapping);
		fieldMapping = new FieldMapping();
		fieldMapping.setAPIName("Website");
		// fieldMapping.setFormat("");
		// fieldMapping.setFindBy("");
		DefaultValue defaultValue = new DefaultValue();
		defaultValue.setValue("https://www.zohoapis.com");
		fieldMapping.setDefaultValue(defaultValue);
		fieldMappings.add(fieldMapping);
		resourceIns.setFieldMappings(fieldMappings);
		resource.add(resourceIns);
		requestWrapper.setResource(resource);
		APIResponse<ActionResponse> response = bulkWriteOperations.createBulkWriteJob(requestWrapper);
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
			String fileId = "34770611727001";
			createBulkWriteJob(moduleAPIName, fileId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
