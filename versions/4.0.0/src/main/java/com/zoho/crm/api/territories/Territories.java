package com.zoho.crm.api.territories;

import com.zoho.crm.api.users.MinifiedUser;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.time.OffsetDateTime;
import java.util.HashMap;

public class Territories implements Model
{
	private OffsetDateTime createdTime;

	private OffsetDateTime modifiedTime;

	private Manager manager;

	private ReportingTo reportingTo;

	private Choice<String> permissionType;

	private MinifiedUser modifiedBy;

	private String description;

	private Long id;

	private MinifiedUser createdBy;

	private Criteria accountRuleCriteria;

	private Criteria dealRuleCriteria;

	private Criteria leadRuleCriteria;

	private String name;

	private String apiName;

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
	 * The method to get the value of manager
	 * @return An instance of Manager
	 */
	public Manager getManager()
	{
		return  this.manager;

	}

	/**
	 * The method to set the value to manager
	 * @param manager An instance of Manager
	 */
	public void setManager(Manager manager)
	{
		 this.manager = manager;

		 this.keyModified.put("manager", 1);

	}

	/**
	 * The method to get the value of reportingTo
	 * @return An instance of ReportingTo
	 */
	public ReportingTo getReportingTo()
	{
		return  this.reportingTo;

	}

	/**
	 * The method to set the value to reportingTo
	 * @param reportingTo An instance of ReportingTo
	 */
	public void setReportingTo(ReportingTo reportingTo)
	{
		 this.reportingTo = reportingTo;

		 this.keyModified.put("reporting_to", 1);

	}

	/**
	 * The method to get the value of permissionType
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getPermissionType()
	{
		return  this.permissionType;

	}

	/**
	 * The method to set the value to permissionType
	 * @param permissionType An instance of Choice<String>
	 */
	public void setPermissionType(Choice<String> permissionType)
	{
		 this.permissionType = permissionType;

		 this.keyModified.put("permission_type", 1);

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
	 * The method to get the value of description
	 * @return A String representing the description
	 */
	public String getDescription()
	{
		return  this.description;

	}

	/**
	 * The method to set the value to description
	 * @param description A String representing the description
	 */
	public void setDescription(String description)
	{
		 this.description = description;

		 this.keyModified.put("description", 1);

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
	 * The method to get the value of accountRuleCriteria
	 * @return An instance of Criteria
	 */
	public Criteria getAccountRuleCriteria()
	{
		return  this.accountRuleCriteria;

	}

	/**
	 * The method to set the value to accountRuleCriteria
	 * @param accountRuleCriteria An instance of Criteria
	 */
	public void setAccountRuleCriteria(Criteria accountRuleCriteria)
	{
		 this.accountRuleCriteria = accountRuleCriteria;

		 this.keyModified.put("account_rule_criteria", 1);

	}

	/**
	 * The method to get the value of dealRuleCriteria
	 * @return An instance of Criteria
	 */
	public Criteria getDealRuleCriteria()
	{
		return  this.dealRuleCriteria;

	}

	/**
	 * The method to set the value to dealRuleCriteria
	 * @param dealRuleCriteria An instance of Criteria
	 */
	public void setDealRuleCriteria(Criteria dealRuleCriteria)
	{
		 this.dealRuleCriteria = dealRuleCriteria;

		 this.keyModified.put("deal_rule_criteria", 1);

	}

	/**
	 * The method to get the value of leadRuleCriteria
	 * @return An instance of Criteria
	 */
	public Criteria getLeadRuleCriteria()
	{
		return  this.leadRuleCriteria;

	}

	/**
	 * The method to set the value to leadRuleCriteria
	 * @param leadRuleCriteria An instance of Criteria
	 */
	public void setLeadRuleCriteria(Criteria leadRuleCriteria)
	{
		 this.leadRuleCriteria = leadRuleCriteria;

		 this.keyModified.put("lead_rule_criteria", 1);

	}

	/**
	 * The method to get the value of name
	 * @return A String representing the name
	 */
	public String getName()
	{
		return  this.name;

	}

	/**
	 * The method to set the value to name
	 * @param name A String representing the name
	 */
	public void setName(String name)
	{
		 this.name = name;

		 this.keyModified.put("name", 1);

	}

	/**
	 * The method to get the value of apiName
	 * @return A String representing the apiName
	 */
	public String getAPIName()
	{
		return  this.apiName;

	}

	/**
	 * The method to set the value to apiName
	 * @param apiName A String representing the apiName
	 */
	public void setAPIName(String apiName)
	{
		 this.apiName = apiName;

		 this.keyModified.put("api_name", 1);

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