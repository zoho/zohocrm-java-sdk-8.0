package com.zoho.crm.api.recordlocking;

import com.zoho.crm.api.record.Record;
import com.zoho.crm.api.tags.Tag;
import com.zoho.crm.api.users.MinifiedUser;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.time.OffsetDateTime;
import java.util.List;

public class RecordLock extends Record implements Model
{

	/**
	 * The method to get the value of lockSourceS
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getLockSourceS()
	{
		return (Choice<String>) this.getKeyValue("lock_source__s");

	}

	/**
	 * The method to set the value to lockSourceS
	 * @param lockSourceS An instance of Choice<String>
	 */
	public void setLockSourceS(Choice<String> lockSourceS)
	{
		 this.addKeyValue("lock_source__s", lockSourceS);

	}

	/**
	 * The method to get the value of lockedByS
	 * @return An instance of MinifiedUser
	 */
	public MinifiedUser getLockedByS()
	{
		return (MinifiedUser) this.getKeyValue("locked_by__s");

	}

	/**
	 * The method to set the value to lockedByS
	 * @param lockedByS An instance of MinifiedUser
	 */
	public void setLockedByS(MinifiedUser lockedByS)
	{
		 this.addKeyValue("locked_by__s", lockedByS);

	}

	/**
	 * The method to get the value of lockedForS
	 * @return An instance of LockedForS
	 */
	public LockedForS getLockedForS()
	{
		return (LockedForS) this.getKeyValue("locked_for_s");

	}

	/**
	 * The method to set the value to lockedForS
	 * @param lockedForS An instance of LockedForS
	 */
	public void setLockedForS(LockedForS lockedForS)
	{
		 this.addKeyValue("locked_for_s", lockedForS);

	}

	/**
	 * The method to get the value of lockedReasonS
	 * @return A String representing the lockedReasonS
	 */
	public String getLockedReasonS()
	{
		return (String) this.getKeyValue("locked_reason__s");

	}

	/**
	 * The method to set the value to lockedReasonS
	 * @param lockedReasonS A String representing the lockedReasonS
	 */
	public void setLockedReasonS(String lockedReasonS)
	{
		 this.addKeyValue("locked_reason__s", lockedReasonS);

	}

	/**
	 * The method to get the value of lockedTimeS
	 * @return A String representing the lockedTimeS
	 */
	public String getLockedTimeS()
	{
		return (String) this.getKeyValue("Locked_time__s");

	}

	/**
	 * The method to set the value to lockedTimeS
	 * @param lockedTimeS A String representing the lockedTimeS
	 */
	public void setLockedTimeS(String lockedTimeS)
	{
		 this.addKeyValue("Locked_time__s", lockedTimeS);

	}

	/**
	 * The method to get the value of recordLockingConfigurationIdS
	 * @return A Long representing the recordLockingConfigurationIdS
	 */
	public Long getRecordLockingConfigurationIdS()
	{
		return (Long) this.getKeyValue("record_locking_configuration_id__s");

	}

	/**
	 * The method to set the value to recordLockingConfigurationIdS
	 * @param recordLockingConfigurationIdS A Long representing the recordLockingConfigurationIdS
	 */
	public void setRecordLockingConfigurationIdS(Long recordLockingConfigurationIdS)
	{
		 this.addKeyValue("record_locking_configuration_id__s", recordLockingConfigurationIdS);

	}

	/**
	 * The method to get the value of recordLockingRuleIdS
	 * @return A Long representing the recordLockingRuleIdS
	 */
	public Long getRecordLockingRuleIdS()
	{
		return (Long) this.getKeyValue("record_locking_rule_id__s");

	}

	/**
	 * The method to set the value to recordLockingRuleIdS
	 * @param recordLockingRuleIdS A Long representing the recordLockingRuleIdS
	 */
	public void setRecordLockingRuleIdS(Long recordLockingRuleIdS)
	{
		 this.addKeyValue("record_locking_rule_id__s", recordLockingRuleIdS);

	}

	/**
	 * The method to get the value of id
	 * @return A Long representing the id
	 */
	public Long getId()
	{
		return (Long) this.getKeyValue("id");

	}

	/**
	 * The method to set the value to id
	 * @param id A Long representing the id
	 */
	public void setId(Long id)
	{
		 this.addKeyValue("id", id);

	}

	/**
	 * The method to get the value of createdBy
	 * @return An instance of MinifiedUser
	 */
	public MinifiedUser getCreatedBy()
	{
		return (MinifiedUser) this.getKeyValue("Created_By");

	}

	/**
	 * The method to set the value to createdBy
	 * @param createdBy An instance of MinifiedUser
	 */
	public void setCreatedBy(MinifiedUser createdBy)
	{
		 this.addKeyValue("Created_By", createdBy);

	}

	/**
	 * The method to get the value of createdTime
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getCreatedTime()
	{
		return (OffsetDateTime) this.getKeyValue("Created_Time");

	}

	/**
	 * The method to set the value to createdTime
	 * @param createdTime An instance of OffsetDateTime
	 */
	public void setCreatedTime(OffsetDateTime createdTime)
	{
		 this.addKeyValue("Created_Time", createdTime);

	}

	/**
	 * The method to get the value of modifiedBy
	 * @return An instance of MinifiedUser
	 */
	public MinifiedUser getModifiedBy()
	{
		return (MinifiedUser) this.getKeyValue("Modified_By");

	}

	/**
	 * The method to set the value to modifiedBy
	 * @param modifiedBy An instance of MinifiedUser
	 */
	public void setModifiedBy(MinifiedUser modifiedBy)
	{
		 this.addKeyValue("Modified_By", modifiedBy);

	}

	/**
	 * The method to get the value of modifiedTime
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getModifiedTime()
	{
		return (OffsetDateTime) this.getKeyValue("Modified_Time");

	}

	/**
	 * The method to set the value to modifiedTime
	 * @param modifiedTime An instance of OffsetDateTime
	 */
	public void setModifiedTime(OffsetDateTime modifiedTime)
	{
		 this.addKeyValue("Modified_Time", modifiedTime);

	}

	/**
	 * The method to get the value of tag
	 * @return An instance of List<Tag>
	 */
	public List<Tag> getTag()
	{
		return (List<Tag>) this.getKeyValue("Tag");

	}

	/**
	 * The method to set the value to tag
	 * @param tag An instance of List<Tag>
	 */
	public void setTag(List<Tag> tag)
	{
		 this.addKeyValue("Tag", tag);

	}

	/**
	 * The method to get the value of name
	 * @return A String representing the name
	 */
	public String getName()
	{
		return (String) this.getKeyValue("name");

	}

	/**
	 * The method to set the value to name
	 * @param name A String representing the name
	 */
	public void setName(String name)
	{
		 this.addKeyValue("name", name);

	}
}