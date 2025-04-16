package com.zoho.crm.api.sharingrules;

import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class SharingRules implements Model
{
	private Long id;

	private Choice<String> permissionType;

	private Boolean superiorsAllowed;

	private String name;

	private Choice<String> type;

	private Shared sharedFrom;

	private Shared sharedTo;

	private Criteria criteria;

	private Module module;

	private Choice<String> status;

	private Boolean matchLimitExceeded;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


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
	 * The method to get the value of superiorsAllowed
	 * @return A Boolean representing the superiorsAllowed
	 */
	public Boolean getSuperiorsAllowed()
	{
		return  this.superiorsAllowed;

	}

	/**
	 * The method to set the value to superiorsAllowed
	 * @param superiorsAllowed A Boolean representing the superiorsAllowed
	 */
	public void setSuperiorsAllowed(Boolean superiorsAllowed)
	{
		 this.superiorsAllowed = superiorsAllowed;

		 this.keyModified.put("superiors_allowed", 1);

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
	 * The method to get the value of type
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getType()
	{
		return  this.type;

	}

	/**
	 * The method to set the value to type
	 * @param type An instance of Choice<String>
	 */
	public void setType(Choice<String> type)
	{
		 this.type = type;

		 this.keyModified.put("type", 1);

	}

	/**
	 * The method to get the value of sharedFrom
	 * @return An instance of Shared
	 */
	public Shared getSharedFrom()
	{
		return  this.sharedFrom;

	}

	/**
	 * The method to set the value to sharedFrom
	 * @param sharedFrom An instance of Shared
	 */
	public void setSharedFrom(Shared sharedFrom)
	{
		 this.sharedFrom = sharedFrom;

		 this.keyModified.put("shared_from", 1);

	}

	/**
	 * The method to get the value of sharedTo
	 * @return An instance of Shared
	 */
	public Shared getSharedTo()
	{
		return  this.sharedTo;

	}

	/**
	 * The method to set the value to sharedTo
	 * @param sharedTo An instance of Shared
	 */
	public void setSharedTo(Shared sharedTo)
	{
		 this.sharedTo = sharedTo;

		 this.keyModified.put("shared_to", 1);

	}

	/**
	 * The method to get the value of criteria
	 * @return An instance of Criteria
	 */
	public Criteria getCriteria()
	{
		return  this.criteria;

	}

	/**
	 * The method to set the value to criteria
	 * @param criteria An instance of Criteria
	 */
	public void setCriteria(Criteria criteria)
	{
		 this.criteria = criteria;

		 this.keyModified.put("criteria", 1);

	}

	/**
	 * The method to get the value of module
	 * @return An instance of Module
	 */
	public Module getModule()
	{
		return  this.module;

	}

	/**
	 * The method to set the value to module
	 * @param module An instance of Module
	 */
	public void setModule(Module module)
	{
		 this.module = module;

		 this.keyModified.put("module", 1);

	}

	/**
	 * The method to get the value of status
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getStatus()
	{
		return  this.status;

	}

	/**
	 * The method to set the value to status
	 * @param status An instance of Choice<String>
	 */
	public void setStatus(Choice<String> status)
	{
		 this.status = status;

		 this.keyModified.put("status", 1);

	}

	/**
	 * The method to get the value of matchLimitExceeded
	 * @return A Boolean representing the matchLimitExceeded
	 */
	public Boolean getMatchLimitExceeded()
	{
		return  this.matchLimitExceeded;

	}

	/**
	 * The method to set the value to matchLimitExceeded
	 * @param matchLimitExceeded A Boolean representing the matchLimitExceeded
	 */
	public void setMatchLimitExceeded(Boolean matchLimitExceeded)
	{
		 this.matchLimitExceeded = matchLimitExceeded;

		 this.keyModified.put("match_limit_exceeded", 1);

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