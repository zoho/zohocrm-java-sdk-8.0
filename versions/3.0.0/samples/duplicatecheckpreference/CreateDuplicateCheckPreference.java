package samples.duplicatecheckpreference;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.duplicatecheckpreference.APIException;
import com.zoho.crm.api.duplicatecheckpreference.ActionHandler;
import com.zoho.crm.api.duplicatecheckpreference.ActionResponse;
import com.zoho.crm.api.duplicatecheckpreference.ActionWrapper;
import com.zoho.crm.api.duplicatecheckpreference.BodyWrapper;
import com.zoho.crm.api.duplicatecheckpreference.CurrentField;
import com.zoho.crm.api.duplicatecheckpreference.DuplicateCheckPreference;
import com.zoho.crm.api.duplicatecheckpreference.DuplicateCheckPreferenceOperations;
import com.zoho.crm.api.duplicatecheckpreference.FieldMappings;
import com.zoho.crm.api.duplicatecheckpreference.MappedField;
import com.zoho.crm.api.duplicatecheckpreference.MappedModule;
import com.zoho.crm.api.duplicatecheckpreference.SuccessResponse;
import com.zoho.crm.api.duplicatecheckpreference.TypeConfiguration;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CreateDuplicateCheckPreference
{
	public static void createDuplicateCheckPreference(String moduleAPIName) throws Exception
	{
		DuplicateCheckPreferenceOperations duplicateCheckPreferenceOperations = new DuplicateCheckPreferenceOperations(moduleAPIName);
		BodyWrapper request = new BodyWrapper();
		DuplicateCheckPreference duplicateCheckPreference = new DuplicateCheckPreference();
		duplicateCheckPreference.setType(new Choice<String>("converted_records"));
		
		List<TypeConfiguration> typeConfigurations = new ArrayList<TypeConfiguration>();
		TypeConfiguration typeConfiguration = new TypeConfiguration();
		MappedModule mappedModule = new MappedModule();
		mappedModule.setId("3412175");
		mappedModule.setAPIName("Leads");
		typeConfiguration.setMappedModule(mappedModule);
		List<FieldMappings> fieldMappings = new ArrayList<FieldMappings>();
		FieldMappings fieldMapping = new FieldMappings();
		CurrentField currentField = new CurrentField();
		currentField.setId("3476570001");
		currentField.setAPIName("Email_1");
		fieldMapping.setCurrentField(currentField);
		
		MappedField mappedField = new MappedField();
		mappedField.setId("34123537018");
		mappedField.setAPIName("Email_2");
		fieldMapping.setMappedField(mappedField);
		
		fieldMappings.add(fieldMapping);
		typeConfiguration.setFieldMappings(fieldMappings);
		typeConfigurations.add(typeConfiguration);
		duplicateCheckPreference.setTypeConfigurations(typeConfigurations);
		request.setDuplicateCheckPreference(duplicateCheckPreference);
		APIResponse<ActionHandler> response = duplicateCheckPreferenceOperations.createDuplicateCheckPreference(request);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ActionWrapper)
				{
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
					ActionResponse actionresponse = actionWrapper.getDuplicateCheckPreference();
					if (actionresponse instanceof SuccessResponse)
					{
						SuccessResponse successresponse = (SuccessResponse) actionresponse;
						System.out.println("Status: " + successresponse.getStatus().getValue());
						System.out.println("Code: " + successresponse.getCode().getValue());
						System.out.println("Details: ");
						for (Map.Entry<String, Object> entry : successresponse.getDetails().entrySet())
						{
							System.out.println(entry.getKey() + ": " + entry.getValue());
						}
						System.out.println("Message: " + successresponse.getMessage());
					}
					else if (actionresponse instanceof APIException)
					{
						APIException exception = (APIException) actionresponse;
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
			createDuplicateCheckPreference(moduleAPIName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
