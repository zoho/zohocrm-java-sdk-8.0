package samples.recordlockingconfiguration;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.fields.MinifiedField;
import com.zoho.crm.api.recordlockingconfiguration.APIException;
import com.zoho.crm.api.recordlockingconfiguration.ActionHandler;
import com.zoho.crm.api.recordlockingconfiguration.ActionResponse;
import com.zoho.crm.api.recordlockingconfiguration.ActionWrapper;
import com.zoho.crm.api.recordlockingconfiguration.BodyWrapper;
import com.zoho.crm.api.recordlockingconfiguration.Criteria;
import com.zoho.crm.api.recordlockingconfiguration.LockExcludedProfile;
import com.zoho.crm.api.recordlockingconfiguration.LockingRules;
import com.zoho.crm.api.recordlockingconfiguration.RecordLock;
import com.zoho.crm.api.recordlockingconfiguration.RecordLockingConfigurationOperations;
import com.zoho.crm.api.recordlockingconfiguration.RestrictedCustomButton;
import com.zoho.crm.api.recordlockingconfiguration.SuccessResponse;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AddRecordLockingConfiguration
{
	public static void addRecordLockingConfiguration(String moduleName) throws Exception
	{
		RecordLockingConfigurationOperations recordLockingConfigurationOperations = new RecordLockingConfigurationOperations(moduleName);
		BodyWrapper bodyWrapper = new BodyWrapper();
		List<RecordLock> lockRecords = new ArrayList<RecordLock>();
		RecordLock recordLock = new RecordLock();
		recordLock.setLockedFor("all_profiles_except_excluded_profiles");
		
		List<MinifiedField> excludedFields = new ArrayList<MinifiedField>();
		MinifiedField excludedField = new MinifiedField();
		excludedField.setAPIName("Annual_Revenue");
		excludedField.setId(5843104002617l);
		excludedFields.add(excludedField);
		recordLock.setExcludedFields(excludedFields);
		
		recordLock.setFeatureType("record_locking");
		
		List<LockingRules> lockingRules = new ArrayList<LockingRules>();
		LockingRules lockingRule = new LockingRules();
		lockingRule.setName("rr");
		lockingRule.setLockExistingRecords(false);
		Criteria criteria = new Criteria();
		criteria.setComparator("equal");
		
		com.zoho.crm.api.recordlockingconfiguration.Field field1 = new com.zoho.crm.api.recordlockingconfiguration.Field();
		field1.setAPIName("Email");
		field1.setId(5843104002599l);
		criteria.setField(field1);
		criteria.setValue("test@zoho.com");
		lockingRule.setCriteria(criteria);

		lockingRules.add(lockingRule);
		recordLock.setLockingRules(lockingRules);
		
		List<String> restrictedActions = new ArrayList<String>(Arrays.asList("update","delete","change_owner"));
		recordLock.setRestrictedActions(restrictedActions);
		recordLock.setLockForPortalUsers(true);
		
		List<String> restrictedCommunications = new ArrayList<String>(Arrays.asList("send_mail"));
		recordLock.setRestrictedCommunications(restrictedCommunications);
		recordLock.setSystemDefined(false);
		recordLock.setLockType(new Choice<String>("both"));
		
		List<RestrictedCustomButton> restrictedCustomButtons = new ArrayList<RestrictedCustomButton>();
		RestrictedCustomButton restrictedCustomButton = new RestrictedCustomButton();
		restrictedCustomButton.setName("Send Doc");
		restrictedCustomButton.setId(5843104485570l);
		restrictedCustomButtons.add(restrictedCustomButton);
		recordLock.setRestrictedCustomButtons(restrictedCustomButtons);
		
		List<LockExcludedProfile> lockExcludedProfiles = new ArrayList<LockExcludedProfile>();
		LockExcludedProfile lockExcludedProfile = new LockExcludedProfile();
		lockExcludedProfile.setName("Administrator");
		lockExcludedProfile.setId(5843104026011l);
		lockExcludedProfiles.add(lockExcludedProfile);
		recordLock.setLockExcludedProfiles(lockExcludedProfiles);
		
		lockRecords.add(recordLock);
		bodyWrapper.setRecordLockingConfigurations(lockRecords);
		APIResponse<ActionHandler> response = recordLockingConfigurationOperations.addRecordLockingConfiguration(bodyWrapper);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ActionWrapper)
				{
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
					List<ActionResponse> actionResponses = actionWrapper.getRecordLockingConfigurations();
					for (ActionResponse actionResponse : actionResponses)
					{
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
							for (Map.Entry<String, Object> entry : exception.getDetails().entrySet())
							{
								System.out.println(entry.getKey() + ": " + entry.getValue());
							}
							System.out.println("Message: " + exception.getMessage().getValue());
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
					System.out.println("Message: " + exception.getMessage().getValue());
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
			String moduleAPIName = "Deals";
			addRecordLockingConfiguration(moduleAPIName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
