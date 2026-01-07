package samples.ziaenrichment;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ziaenrichment.APIException;
import com.zoho.crm.api.ziaenrichment.CrmField;
import com.zoho.crm.api.ziaenrichment.DataEnrichment;
import com.zoho.crm.api.ziaenrichment.EnrichField;
import com.zoho.crm.api.ziaenrichment.InputData;
import com.zoho.crm.api.ziaenrichment.ResponseHandler;
import com.zoho.crm.api.ziaenrichment.ZiaEnrichmentOperations;
import com.zoho.crm.api.ziaenrichment.ResponseWrapper;
import com.zoho.crm.api.ziaenrichment.Module;
import com.zoho.crm.api.ziaenrichment.OutputData;
import com.zoho.crm.api.ziaenrichment.User;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetZiaEnrichment
{
	public static void getZiaEnrichment() throws Exception
	{
		ZiaEnrichmentOperations ziaEnrichmentOperations = new ZiaEnrichmentOperations();
		APIResponse<ResponseHandler> response = ziaEnrichmentOperations.getZiaEnrichment();
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.getStatusCode() == 204)
			{
				System.out.println("No Content");
				return;
			}
			if (response.isExpected())
			{
				ResponseHandler responseHandler = response.getObject();
				if (responseHandler instanceof ResponseWrapper)
				{
					ResponseWrapper responseWrapper = (ResponseWrapper) responseHandler;
					List<DataEnrichment> dataEnrichment = responseWrapper.getDataEnrichment();
					if(dataEnrichment != null)
					{
						for(DataEnrichment dataEnrichment1 : dataEnrichment)
						{
							Module module = dataEnrichment1.getModule();
							if(module != null)
							{
								System.out.println("DataEnrichment Module OrgStatus : " + module.getAPIName());
								System.out.println("DataEnrichment Module Id : " + module.getId());
							}
							
							System.out.println("DataEnrichment Type : " + dataEnrichment1.getType());
							List<OutputData> outputDataFieldMapping = dataEnrichment1.getOutputDataFieldMapping();
							if(outputDataFieldMapping != null)
							{
								for(OutputData outputDataFieldMapping1 : outputDataFieldMapping)
								{
									EnrichField enrichField = outputDataFieldMapping1.getEnrichField();
									if(enrichField != null)
									{
										System.out.println("DataEnrichment OutputDataFieldMapping EnrichField Name: " + enrichField.getName());
										System.out.println("DataEnrichment OutputDataFieldMapping EnrichField DisplayLabel : " + enrichField.getDisplayLabel());
									}
									CrmField crmField = outputDataFieldMapping1.getCrmField();
									if(crmField != null)
									{
										System.out.println("DataEnrichment OutputDataFieldMapping CrmField Id: " + crmField.getId());
										System.out.println("DataEnrichment OutputDataFieldMapping CrmField APIName : " + crmField.getAPIName());
										System.out.println("DataEnrichment OutputDataFieldMapping CrmField Name : " + crmField.getName());
									}
								}
							}
							List<InputData> inputDataFieldMapping = dataEnrichment1.getInputDataFieldMapping();
							if(inputDataFieldMapping != null)
							{
								for(InputData inputDataFieldMapping1 : inputDataFieldMapping)
								{
									EnrichField enrichField = inputDataFieldMapping1.getEnrichField();
									if(enrichField != null)
									{
										System.out.println("DataEnrichment OutputDataFieldMapping EnrichField Name: " + enrichField.getName());
										System.out.println("DataEnrichment OutputDataFieldMapping EnrichField DisplayLabel : " + enrichField.getDisplayLabel());
									}
									CrmField crmField = inputDataFieldMapping1.getCrmField();
									if(crmField != null)
									{
										System.out.println("DataEnrichment OutputDataFieldMapping CrmField Id: " + crmField.getId());
										System.out.println("DataEnrichment OutputDataFieldMapping CrmField APIName : " + crmField.getAPIName());
										System.out.println("DataEnrichment OutputDataFieldMapping CrmField Name : " + crmField.getName());
									}
								}
							}
							System.out.println("DataEnrichment Id : " + dataEnrichment1.getId());
							System.out.println("DataEnrichment Status : " + dataEnrichment1.getStatus());
							System.out.println("DataEnrichment CreatedTime : " + dataEnrichment1.getCreatedTime());
							User createdBy = dataEnrichment1.getCreatedBy();
							if(createdBy != null)
							{
								System.out.println("DataEnrichment CreatedBy User Id : " + createdBy.getId());
								System.out.println("DataEnrichment CreatedBy User Name: " + createdBy.getName());
							}
							System.out.println("DataEnrichment ModifiedTime : " + dataEnrichment1.getModifiedTime());
							User modifiedBy = dataEnrichment1.getModifiedBy();
							if(modifiedBy != null)
							{
								System.out.println("DataEnrichment ModifiedBy User Id : " + modifiedBy.getId());
								System.out.println("DataEnrichment ModifiedBy User Name: " + modifiedBy.getName());
							}
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
			else if (response.getStatusCode() != 204)
			{
				Model responseObject = response.getModel();
				Class<? extends Model> clas = responseObject.getClass();
				Field[] fields = clas.getDeclaredFields();
				for (Field field1 : fields)
				{
					field1.setAccessible(true);
					System.out.println(field1.getName() + ":" + field1.get(responseObject));
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
			getZiaEnrichment();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
