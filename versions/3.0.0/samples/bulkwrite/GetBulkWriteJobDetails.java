package samples.bulkwrite;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.bulkwrite.APIException;
import com.zoho.crm.api.bulkwrite.BulkWriteOperations;
import com.zoho.crm.api.bulkwrite.BulkWriteResponse;
import com.zoho.crm.api.bulkwrite.CallBack;
import com.zoho.crm.api.bulkwrite.DefaultValue;
import com.zoho.crm.api.bulkwrite.FieldMapping;
import com.zoho.crm.api.bulkwrite.Resource;
import com.zoho.crm.api.bulkwrite.ResponseWrapper;
import com.zoho.crm.api.bulkwrite.Result;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.modules.MinifiedModule;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetBulkWriteJobDetails
{
	public static void getBulkWriteJobDetails(String jobId) throws Exception
	{
		BulkWriteOperations bulkWriteOperations = new BulkWriteOperations();
		APIResponse<ResponseWrapper> response = bulkWriteOperations.getBulkWriteJobDetails(jobId);
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
				ResponseWrapper responseWrapper = response.getObject();
				if (responseWrapper instanceof BulkWriteResponse)
				{
					BulkWriteResponse bulkWriteResponse = (BulkWriteResponse) responseWrapper;
					System.out.println("Bulk write Job Status: " + bulkWriteResponse.getStatus());
					System.out.println("Bulk write CharacterEncoding: " + bulkWriteResponse.getCharacterEncoding());
					List<Resource> resources = bulkWriteResponse.getResource();
					if (resources != null)
					{
						for (Resource resource : resources)
						{
							System.out.println("Bulk write Resource Status: " + resource.getStatus().getValue());
							System.out.println("Bulk write Resource Type: " + resource.getType().getValue());
							MinifiedModule module = resource.getModule();
							if (module != null)
							{
								System.out.println("Bulkwrite Resource Module Name : " + module.getAPIName());
								System.out.println("Bulkwrite Resource Module Id : " + module.getId());
							}
							List<FieldMapping> fieldMappings = resource.getFieldMappings();
							if (fieldMappings != null)
							{
								for (FieldMapping fieldMapping : fieldMappings)
								{
									System.out.println("Bulk write Resource FieldMapping Module: " + fieldMapping.getAPIName());
									if (fieldMapping.getIndex() != null)
									{
										System.out.println("Bulk write Resource FieldMapping Index: " + fieldMapping.getIndex().toString());
									}
									if (fieldMapping.getFormat() != null)
									{
										System.out.println("Bulk write Resource FieldMapping Format: " + fieldMapping.getFormat());
									}
									if (fieldMapping.getModule() != null)
									{
										System.out.println("Bulk write Resource FieldMapping Module: " + fieldMapping.getModule());
									}
									if (fieldMapping.getFindBy() != null)
									{
										System.out.println("Bulk write Resource FieldMapping FindBy: " + fieldMapping.getFindBy());
									}
									if (fieldMapping.getDefaultValue() != null)
									{
										DefaultValue defaultValue = fieldMapping.getDefaultValue();

										if (defaultValue != null)
										{
											System.out.println("Name : " + defaultValue.getName());

											System.out.println("Module : " + defaultValue.getModule());

											System.out.println("Value : " + defaultValue.getValue());
										}
									}
								}
							}
							com.zoho.crm.api.bulkwrite.File file = resource.getFile();
							if (file != null)
							{
								System.out.println("Bulk write Resource File Status: " + file.getStatus().getValue());
								System.out.println("Bulk write Resource File Name: " + file.getName());
								System.out.println("Bulk write Resource File AddedCount: " + file.getAddedCount().toString());
								System.out.println("Bulk write Resource File SkippedCount: " + file.getSkippedCount().toString());
								System.out.println("Bulk write Resource File UpdatedCount: " + file.getUpdatedCount().toString());
								System.out.println("Bulk write Resource File TotalCount: " + file.getTotalCount().toString());
							}
							System.out.println("Bulk write Resource FindBy: " + resource.getFindBy());
							System.out.println("Bulk write Resource Code: " + resource.getCode());
						}
					}
					CallBack callback = bulkWriteResponse.getCallback();
					if (callback != null)
					{
						System.out.println("Bulk write CallBack Url: " + callback.getUrl());
						System.out.println("Bulk write CallBack Method: " + callback.getMethod().getValue());
					}
					System.out.println("Bulk write ID: " + bulkWriteResponse.getId().toString());
					Result result = bulkWriteResponse.getResult();
					if (result != null)
					{
						System.out.println("Bulk write DownloadUrl: " + result.getDownloadUrl());
					}
					com.zoho.crm.api.users.MinifiedUser createdBy = bulkWriteResponse.getCreatedBy();
					if (createdBy != null)
					{
						System.out.println("Bulkread Created By User-ID: " + createdBy.getId());
						System.out.println("Bulkread Created By user-Name: " + createdBy.getName());
					}
					System.out.println("Bulk write Operation: " + bulkWriteResponse.getOperation());
					System.out.println("Bulk write File CreatedTime: " + bulkWriteResponse.getCreatedTime().toString());
				}
				else if (responseWrapper instanceof APIException)
				{
					APIException exception = (APIException) responseWrapper;
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
			String jobID = "347706117222006l";
			getBulkWriteJobDetails(jobID);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
