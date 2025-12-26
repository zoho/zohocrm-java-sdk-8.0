package com.zoho.crm.api.recordlockingconfiguration;

import com.zoho.crm.api.fields.MinifiedField;
import com.zoho.crm.api.users.MinifiedUser;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;

public class RecordLock implements Model
{
	private OffsetDateTime createdTime;

	private String lockedFor;

	private List<MinifiedField> excludedFields;

	private MinifiedUser createdBy;

	private String featureType;

	private List<LockingRules> lockingRules;

	private List<String> restrictedActions;

	private Boolean lockForPortalUsers;

	private OffsetDateTime modifiedTime;

	private List<String> restrictedCommunications;

	private Boolean systemDefined;

	private MinifiedUser modifiedBy;

	private Long id;

	private Choice<String> lockType;

	private List<RestrictedCustomButton> restrictedCustomButtons;

	private List<LockExcludedProfile> lockExcludedProfiles;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of createdTime
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getCreatedTime()
	{
		return  this.createdTime;

	}

	/**
	 * The method to set the value to createdTime
	 * @param createdTime An instance of OffsetDateTime
	 */
	public void setCreatedTime(OffsetDateTime createdTime)
	{
		 this.createdTime = createdTime;

		 this.keyModified.put("created_time", 1);

	}

	/**
	 * The method to get the value of lockedFor
	 * @return A String representing the lockedFor
	 */
	public String getLockedFor()
	{
		return  this.lockedFor;

	}

	/**
	 * The method to set the value to lockedFor
	 * @param lockedFor A String representing the lockedFor
	 */
	public void setLockedFor(String lockedFor)
	{
		 this.lockedFor = lockedFor;

		 this.keyModified.put("locked_for", 1);

	}

	/**
	 * The method to get the value of excludedFields
	 * @return An instance of List<MinifiedField>
	 */
	public List<MinifiedField> getExcludedFields()
	{
		return  this.excludedFields;

	}

	/**
	 * The method to set the value to excludedFields
	 * @param excludedFields An instance of List<MinifiedField>
	 */
	public void setExcludedFields(List<MinifiedField> excludedFields)
	{
		 this.excludedFields = excludedFields;

		 this.keyModified.put("excluded_fields", 1);

	}

	/**
	 * The method to get the value of createdBy
	 * @return An instance of MinifiedUser
	 */
	public MinifiedUser getCreatedBy()
	{
		return  this.createdBy;

	}

	/**
	 * The method to set the value to createdBy
	 * @param createdBy An instance of MinifiedUser
	 */
	public void setCreatedBy(MinifiedUser createdBy)
	{
		 this.createdBy = createdBy;

		 this.keyModified.put("created_by", 1);

	}

	/**
	 * The method to get the value of featureType
	 * @return A String representing the featureType
	 */
	public String getFeatureType()
	{
		return  this.featureType;

	}

	/**
	 * The method to set the value to featureType
	 * @param featureType A String representing the featureType
	 */
	public void setFeatureType(String featureType)
	{
		 this.featureType = featureType;

		 this.keyModified.put("feature_type", 1);

	}

	/**
	 * The method to get the value of lockingRules
	 * @return An instance of List<LockingRules>
	 */
	public List<LockingRules> getLockingRules()
	{
		return  this.lockingRules;

	}

	/**
	 * The method to set the value to lockingRules
	 * @param lockingRules An instance of List<LockingRules>
	 */
	public void setLockingRules(List<LockingRules> lockingRules)
	{
		 this.lockingRules = lockingRules;

		 this.keyModified.put("locking_rules", 1);

	}

	/**
	 * The method to get the value of restrictedActions
	 * @return An instance of List<String>
	 */
	public List<String> getRestrictedActions()
	{
		return  this.restrictedActions;

	}

	/**
	 * The method to set the value to restrictedActions
	 * @param restrictedActions An instance of List<String>
	 */
	public void setRestrictedActions(List<String> restrictedActions)
	{
		 this.restrictedActions = restrictedActions;

		 this.keyModified.put("restricted_actions", 1);

	}

	/**
	 * The method to get the value of lockForPortalUsers
	 * @return A Boolean representing the lockForPortalUsers
	 */
	public Boolean getLockForPortalUsers()
	{
		return  this.lockForPortalUsers;

	}

	/**
	 * The method to set the value to lockForPortalUsers
	 * @param lockForPortalUsers A Boolean representing the lockForPortalUsers
	 */
	public void setLockForPortalUsers(Boolean lockForPortalUsers)
	{
		 this.lockForPortalUsers = lockForPortalUsers;

		 this.keyModified.put("lock_for_portal_users", 1);

	}

	/**
	 * The method to get the value of modifiedTime
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getModifiedTime()
	{
		return  this.modifiedTime;

	}

	/**
	 * The method to set the value to modifiedTime
	 * @param modifiedTime An instance of OffsetDateTime
	 */
	public void setModifiedTime(OffsetDateTime modifiedTime)
	{
		 this.modifiedTime = modifiedTime;

		 this.keyModified.put("modified_time", 1);

	}

	/**
	 * The method to get the value of restrictedCommunications
	 * @return An instance of List<String>
	 */
	public List<String> getRestrictedCommunications()
	{
		return  this.restrictedCommunications;

	}

	/**
	 * The method to set the value to restrictedCommunications
	 * @param restrictedCommunications An instance of List<String>
	 */
	public void setRestrictedCommunications(List<String> restrictedCommunications)
	{
		 this.restrictedCommunications = restrictedCommunications;

		 this.keyModified.put("restricted_communications", 1);

	}

	/**
	 * The method to get the value of systemDefined
	 * @return A Boolean representing the systemDefined
	 */
	public Boolean getSystemDefined()
	{
		return  this.systemDefined;

	}

	/**
	 * The method to set the value to systemDefined
	 * @param systemDefined A Boolean representing the systemDefined
	 */
	public void setSystemDefined(Boolean systemDefined)
	{
		 this.systemDefined = systemDefined;

		 this.keyModified.put("system_defined", 1);

	}

	/**
	 * The method to get the value of modifiedBy
	 * @return An instance of MinifiedUser
	 */
	public MinifiedUser getModifiedBy()
	{
		return  this.modifiedBy;

	}

	/**
	 * The method to set the value to modifiedBy
	 * @param modifiedBy An instance of MinifiedUser
	 */
	public void setModifiedBy(MinifiedUser modifiedBy)
	{
		 this.modifiedBy = modifiedBy;

		 this.keyModified.put("modified_by", 1);

	}

	/**
	 * The method to get the value of id
	 * @return A Long representing the id
	 */
	public Long getId()
	{
		return  this.id;

	}

	/**
	 * The method to set the value to id
	 * @param id A Long representing the id
	 */
	public void setId(Long id)
	{
		 this.id = id;

		 this.keyModified.put("id", 1);

	}

	/**
	 * The method to get the value of lockType
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getLockType()
	{
		return  this.lockType;

	}

	/**
	 * The method to set the value to lockType
	 * @param lockType An instance of Choice<String>
	 */
	public void setLockType(Choice<String> lockType)
	{
		 this.lockType = lockType;

		 this.keyModified.put("lock_type", 1);

	}

	/**
	 * The method to get the value of restrictedCustomButtons
	 * @return An instance of List<RestrictedCustomButton>
	 */
	public List<RestrictedCustomButton> getRestrictedCustomButtons()
	{
		return  this.restrictedCustomButtons;

	}

	/**
	 * The method to set the value to restrictedCustomButtons
	 * @param restrictedCustomButtons An instance of List<RestrictedCustomButton>
	 */
	public void setRestrictedCustomButtons(List<RestrictedCustomButton> restrictedCustomButtons)
	{
		 this.restrictedCustomButtons = restrictedCustomButtons;

		 this.keyModified.put("restricted_custom_buttons", 1);

	}

	/**
	 * The method to get the value of lockExcludedProfiles
	 * @return An instance of List<LockExcludedProfile>
	 */
	public List<LockExcludedProfile> getLockExcludedProfiles()
	{
		return  this.lockExcludedProfiles;

	}

	/**
	 * The method to set the value to lockExcludedProfiles
	 * @param lockExcludedProfiles An instance of List<LockExcludedProfile>
	 */
	public void setLockExcludedProfiles(List<LockExcludedProfile> lockExcludedProfiles)
	{
		 this.lockExcludedProfiles = lockExcludedProfiles;

		 this.keyModified.put("lock_excluded_profiles", 1);

	}

	/**
	 * The method to check if the user has modified the given key
	 * @param key A String representing the key
	 * @return An Integer representing the modification
	 */
	public Integer isKeyModified(String key)
	{
		if((( this.keyModified.containsKey(key))))
		{
			return  this.keyModified.get(key);

		}
		return null;

	}

	/**
	 * The method to mark the given key as modified
	 * @param key A String representing the key
	 * @param modification An Integer representing the modification
	 */
	public void setKeyModified(String key, Integer modification)
	{
		 this.keyModified.put(key, modification);

	}
}