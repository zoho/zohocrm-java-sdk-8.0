package samples.duplicatecheckpreference;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.duplicatecheckpreference.APIException;
import com.zoho.crm.api.duplicatecheckpreference.CurrentField;
import com.zoho.crm.api.duplicatecheckpreference.DuplicateCheckPreference;
import com.zoho.crm.api.duplicatecheckpreference.DuplicateCheckPreferenceOperations;
import com.zoho.crm.api.duplicatecheckpreference.FieldMappings;
import com.zoho.crm.api.duplicatecheckpreference.MappedField;
import com.zoho.crm.api.duplicatecheckpreference.MappedModule;
import com.zoho.crm.api.duplicatecheckpreference.ResponseHandler;
import com.zoho.crm.api.duplicatecheckpreference.ResponseWrapper;
import com.zoho.crm.api.duplicatecheckpreference.TypeConfiguration;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetDuplicateCheckPreference
{
	public static void getDuplicateCheckPreference(String moduleAPIName) throws Exception
	{
		DuplicateCheckPreferenceOperations duplicateCheckPreferenceOperations = new DuplicateCheckPreferenceOperations(moduleAPIName);
		APIResponse<ResponseHandler> response = duplicateCheckPreferenceOperations.getDuplicateCheckPreference();
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
					DuplicateCheckPreference duplicateCheckPreference = responseWrapper.getDuplicateCheckPreference();
					System.out.println("DuplicateCheckPreference Type : " + duplicateCheckPreference.getType().getValue());
					List<TypeConfiguration> typeConfigurations = duplicateCheckPreference.getTypeConfigurations();
					if(typeConfigurations != null)
					{
						for(TypeConfiguration typeConfiguration : typeConfigurations)
						{
							MappedModule mappedModule = typeConfiguration.getMappedModule();
							if(mappedModule != null)
							{
								System.out.println("DuplicateCheckPreference TypeConfiguration MappedModule Id : " + mappedModule.getId());
								System.out.println("DuplicateCheckPreference TypeConfiguration MappedModule Name : " + mappedModule.getName());
								System.out.println("DuplicateCheckPreference TypeConfiguration MappedModule APIName : " + mappedModule.getAPIName());
							}
							List<FieldMappings> fieldMappings = typeConfiguration.getFieldMappings();
							if(fieldMappings != null)
							{
								for(FieldMappings fieldMapping : fieldMappings)
								{
									CurrentField currentField = fieldMapping.getCurrentField();
									if(currentField != null)
									{
										System.out.println("DuplicateCheckPreference TypeConfiguration FieldMappings CurrentField Id : " + currentField.getId());
										System.out.println("DuplicateCheckPreference TypeConfiguration FieldMappings CurrentField Name : " + currentField.getName());
										System.out.println("DuplicateCheckPreference TypeConfiguration FieldMappings CurrentField APIName : " + currentField.getAPIName());
									}
									MappedField mappedField = fieldMapping.getMappedField();
									if(mappedField != null)
									{
										System.out.println("DuplicateCheckPreference TypeConfiguration FieldMappings MappedField Id : " + mappedField.getId());
										System.out.println("DuplicateCheckPreference TypeConfiguration FieldMappings MappedField Name : " + mappedField.getName());
										System.out.println("DuplicateCheckPreference TypeConfiguration FieldMappings MappedField APIName : " + mappedField.getAPIName());
									}
								}
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
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			String moduleAPIName = "Leads";
			getDuplicateCheckPreference(moduleAPIName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
