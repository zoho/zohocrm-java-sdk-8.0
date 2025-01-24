package samples.recordlockingconfiguration;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
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
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;

public class UpdateRecordLockingConfiguration
{
	public static void updateRecordLockingConfiguration(Long id, String moduleName) throws Exception
	{
		RecordLockingConfigurationOperations recordLockingConfigurationOperations = new RecordLockingConfigurationOperations(moduleName);
		BodyWrapper bodyWrapper = new BodyWrapper();
		List<RecordLock> lockRecords = new ArrayList<RecordLock>();
		RecordLock recordLock = new RecordLock();
		recordLock.setLockedFor("all_profiles_except_excluded_profiles");
		
		List<LockingRules> lockingRules = new ArrayList<LockingRules>();
		
		LockingRules lockingRule = new LockingRules();
		lockingRule.setId(5843104766010l);
		lockingRule.setDelete(true);
		lockingRules.add(lockingRule);
		
		lockingRule = new LockingRules();
		lockingRule.setName("email rule 34");
		lockingRule.setId(5843104766034l);
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
		
		lockingRule = new LockingRules();
		lockingRule.setName("email rule 5");
		lockingRule.setLockExistingRecords(false);
		Criteria criteria1 = new Criteria();
		criteria1.setComparator("equal");
		com.zoho.crm.api.recordlockingconfiguration.Field field12 = new com.zoho.crm.api.recordlockingconfiguration.Field();
		field12.setAPIName("Email");
		field12.setId(5843104002599l);
		criteria1.setField(field12);
		criteria1.setValue("test5@zoho.com");
		lockingRule.setCriteria(criteria1);
		lockingRules.add(lockingRule);
		
		recordLock.setLockingRules(lockingRules);
		
		recordLock.setLockForPortalUsers(true);
		
		List<String> restrictedCommunications = new ArrayList<String>(Arrays.asList("send_mail"));
		recordLock.setRestrictedCommunications(restrictedCommunications);
		recordLock.setSystemDefined(false);
		recordLock.setLockType(new Choice<String>("both"));
		
		List<RestrictedCustomButton> restrictedCustomButtons = new ArrayList<RestrictedCustomButton>();
		RestrictedCustomButton restrictedCustomButton = new RestrictedCustomButton();
		restrictedCustomButton.setName("Send with Zoho Sign");
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
		APIResponse<ActionHandler> response = recordLockingConfigurationOperations.updateRecordLockingConfiguration(id, bodyWrapper);
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
			Long id = 34770938001l;
			updateRecordLockingConfiguration(id, moduleAPIName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
