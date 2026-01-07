package samples.recordlockingconfiguration;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.fields.MinifiedField;
import com.zoho.crm.api.recordlockingconfiguration.APIException;
import com.zoho.crm.api.recordlockingconfiguration.Criteria;
import com.zoho.crm.api.recordlockingconfiguration.LockExcludedProfile;
import com.zoho.crm.api.recordlockingconfiguration.LockingRules;
import com.zoho.crm.api.recordlockingconfiguration.RecordLockingConfigurationOperations;
import com.zoho.crm.api.recordlockingconfiguration.RecordLockingConfigurationOperations.GetRecordLockingConfigurationsParam;
import com.zoho.crm.api.recordlockingconfiguration.ResponseHandler;
import com.zoho.crm.api.recordlockingconfiguration.ResponseWrapper;
import com.zoho.crm.api.recordlockingconfiguration.RestrictedCustomButton;
import com.zoho.crm.api.users.MinifiedUser;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetRecordLockingConfigurations
{
	public static void getRecordLockingConfigurations(String moduleAPIName) throws Exception
	{
		RecordLockingConfigurationOperations recordLockingConfigurationOperations = new RecordLockingConfigurationOperations(moduleAPIName);
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(GetRecordLockingConfigurationsParam.FEATURE_TYPE, "record_locking");
		APIResponse<ResponseHandler> response = recordLockingConfigurationOperations.getRecordLockingConfigurations(paramInstance);
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
					List<com.zoho.crm.api.recordlockingconfiguration.RecordLock> recordLocks = responseWrapper.getRecordLockingConfigurations();
					for (com.zoho.crm.api.recordlockingconfiguration.RecordLock recordLock : recordLocks)
					{
						System.out.println("RecordLockingConfigurationOperations LockedFor: " + recordLock.getCreatedTime());
						System.out.println("RecordLockingConfigurationOperations LockedFor: " + recordLock.getLockedFor());
						
						List<MinifiedField> excludedFields = recordLock.getExcludedFields(); 
						if(excludedFields != null)
						{
							for(MinifiedField excludedField : excludedFields)
							{
								System.out.println("RecordLockingConfigurationOperations ExcludedFields APIName: " + excludedField.getAPIName());
								System.out.println("RecordLockingConfigurationOperations ExcludedFields Id: " + excludedField.getId());
							}
						}
						MinifiedUser createdBy = recordLock.getCreatedBy();
						if(createdBy != null)
						{
							System.out.println("RecordLockingConfigurationOperations CreatedBy User Name: " + createdBy.getName());
							System.out.println("RecordLockingConfigurationOperations CreatedBy User Id: " + createdBy.getId());
						}
						System.out.println("RecordLockingConfigurationOperations FeatureType: " + recordLock.getFeatureType());
						List<LockingRules> lockingRules = recordLock.getLockingRules();
						if(lockingRules != null)
						{
							for(LockingRules lockingRule : lockingRules)
							{
								System.out.println("RecordLockingConfigurationOperations LockingRules Name: " + lockingRule.getName());
								System.out.println("RecordLockingConfigurationOperations LockingRules Id: " + lockingRule.getId());
								System.out.println("RecordLockingConfigurationOperations LockingRules LockExistingRecords: " + lockingRule.getLockExistingRecords());
								Criteria criteria = lockingRule.getCriteria();
								if (criteria != null)
								{
									printCriteria(criteria);
								}
							}
						}
						List<String> restrictedActions = recordLock.getRestrictedActions();
						if(restrictedActions != null)
						{
							for(String restrictedAction : restrictedActions)
							{
								System.out.println("RecordLockingConfigurationOperations RestrictedActions : " + restrictedAction);
							}
						}
						System.out.println("RecordLockingConfigurationOperations LockForPortalUsers: " + recordLock.getLockForPortalUsers());
						System.out.println("RecordLockingConfigurationOperations ModifiedTime: " + recordLock.getModifiedTime());
						List<String> restrictedCommunications = recordLock.getRestrictedCommunications();
						if(restrictedCommunications != null)
						{
							for(String restrictedCommunication : restrictedCommunications)
							{
								System.out.println("RecordLockingConfigurationOperations RestrictedCommunications : " + restrictedCommunication);
							}
						}
						System.out.println("RecordLockingConfigurationOperations SystemDefined: " + recordLock.getSystemDefined());
						MinifiedUser modifiedBy = recordLock.getModifiedBy();
						if(modifiedBy != null)
						{
							System.out.println("RecordLockingConfigurationOperations ModifiedBy User Name: " + modifiedBy.getName());
							System.out.println("RecordLockingConfigurationOperations ModifiedBy User Id: " + modifiedBy.getId());
						}
						System.out.println("RecordLockingConfigurationOperations Id: " + recordLock.getId());
						System.out.println("RecordLockingConfigurationOperations LockType: " + recordLock.getLockType().getValue());
						
						List<RestrictedCustomButton> restrictedCustomButtons = recordLock.getRestrictedCustomButtons();
						if(restrictedCustomButtons != null)
						{
							for(RestrictedCustomButton restrictedCustomButton : restrictedCustomButtons)
							{
								System.out.println("RecordLockingConfigurationOperations RestrictedCustomButton Name: " + restrictedCustomButton.getName());
								System.out.println("RecordLockingConfigurationOperations RestrictedCustomButton Id: " + restrictedCustomButton.getId());
							}
						}
						
						List<LockExcludedProfile> lockExcludedProfiles = recordLock.getLockExcludedProfiles();
						if(lockExcludedProfiles != null)
						{
							for(LockExcludedProfile lockExcludedProfile : lockExcludedProfiles)
							{
								System.out.println("RecordLockingConfigurationOperations LockExcludedProfile Name: " + lockExcludedProfile.getName());
								System.out.println("RecordLockingConfigurationOperations LockExcludedProfile Id: " + lockExcludedProfile.getId());
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
	
	private static void printCriteria(Criteria criteria)
	{
		if (criteria.getComparator() != null)
		{
			System.out.println("Criteria Comparator: " + criteria.getComparator());
		}
		if (criteria.getValue() != null)
		{
			System.out.println("Criteria Value: " + criteria.getValue().toString());
		}
		if (criteria.getField() != null)
		{
			System.out.println("Criteria field name: " + criteria.getField().getAPIName());
		}
		List<Criteria> criteriaGroup = criteria.getGroup();
		if (criteriaGroup != null)
		{
			for (Criteria criteria1 : criteriaGroup)
			{
				printCriteria(criteria1);
			}
		}
		if (criteria.getGroupOperator() != null)
		{
			System.out.println("Criteria Group Operator: " + criteria.getGroupOperator());
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
			getRecordLockingConfigurations(moduleAPIName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
