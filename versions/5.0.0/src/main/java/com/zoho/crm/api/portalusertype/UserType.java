package com.zoho.crm.api.portalusertype;

import com.zoho.crm.api.util.Model;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;

public class UserType implements Model
{
	private PersonalityModule personalityModule;

	private OffsetDateTime createdTime;

	private OffsetDateTime modifiedTime;

	private Owner modifiedBy;

	private Owner createdBy;

	private String name;

	private Boolean active;

	private Boolean default1;

	private Integer noOfUsers;

	private Long id;

	private List<Modules> modules;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of personalityModule
	 * @return An instance of PersonalityModule
	 */
	public PersonalityModule getPersonalityModule()
	{
		return  this.personalityModule;

	}

	/**
	 * The method to set the value to personalityModule
	 * @param personalityModule An instance of PersonalityModule
	 */
	public void setPersonalityModule(PersonalityModule personalityModule)
	{
		 this.personalityModule = personalityModule;

		 this.keyModified.put("personality_module", 1);

	}

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
	 * The method to get the value of modifiedBy
	 * @return An instance of Owner
	 */
	public Owner getModifiedBy()
	{
		return  this.modifiedBy;

	}

	/**
	 * The method to set the value to modifiedBy
	 * @param modifiedBy An instance of Owner
	 */
	public void setModifiedBy(Owner modifiedBy)
	{
		 this.modifiedBy = modifiedBy;

		 this.keyModified.put("modified_by", 1);

	}

	/**
	 * The method to get the value of createdBy
	 * @return An instance of Owner
	 */
	public Owner getCreatedBy()
	{
		return  this.createdBy;

	}

	/**
	 * The method to set the value to createdBy
	 * @param createdBy An instance of Owner
	 */
	public void setCreatedBy(Owner createdBy)
	{
		 this.createdBy = createdBy;

		 this.keyModified.put("created_by", 1);

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
	 * The method to get the value of active
	 * @return A Boolean representing the active
	 */
	public Boolean getActive()
	{
		return  this.active;

	}

	/**
	 * The method to set the value to active
	 * @param active A Boolean representing the active
	 */
	public void setActive(Boolean active)
	{
		 this.active = active;

		 this.keyModified.put("active", 1);

	}

	/**
	 * The method to get the value of default
	 * @return A Boolean representing the default1
	 */
	public Boolean getDefault()
	{
		return  this.default1;

	}

	/**
	 * The method to set the value to default
	 * @param default1 A Boolean representing the default1
	 */
	public void setDefault(Boolean default1)
	{
		 this.default1 = default1;

		 this.keyModified.put("default", 1);

	}

	/**
	 * The method to get the value of noOfUsers
	 * @return An Integer representing the noOfUsers
	 */
	public Integer getNoOfUsers()
	{
		return  this.noOfUsers;

	}

	/**
	 * The method to set the value to noOfUsers
	 * @param noOfUsers An Integer representing the noOfUsers
	 */
	public void setNoOfUsers(Integer noOfUsers)
	{
		 this.noOfUsers = noOfUsers;

		 this.keyModified.put("no_of_users", 1);

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
	 * The method to get the value of modules
	 * @return An instance of List<Modules>
	 */
	public List<Modules> getModules()
	{
		return  this.modules;

	}

	/**
	 * The method to set the value to modules
	 * @param modules An instance of List<Modules>
	 */
	public void setModules(List<Modules> modules)
	{
		 this.modules = modules;

		 this.keyModified.put("modules", 1);

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