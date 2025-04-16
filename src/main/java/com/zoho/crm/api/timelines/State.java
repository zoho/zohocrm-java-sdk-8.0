package com.zoho.crm.api.timelines;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class State implements Model
{
	private String triggerType;

	private String name;

	private Boolean isLastState;

	private Long id;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of triggerType
	 * @return A String representing the triggerType
	 */
	public String getTriggerType()
	{
		return  this.triggerType;

	}

	/**
	 * The method to set the value to triggerType
	 * @param triggerType A String representing the triggerType
	 */
	public void setTriggerType(String triggerType)
	{
		 this.triggerType = triggerType;

		 this.keyModified.put("trigger_type", 1);

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
	 * The method to get the value of isLastState
	 * @return A Boolean representing the isLastState
	 */
	public Boolean getIsLastState()
	{
		return  this.isLastState;

	}

	/**
	 * The method to set the value to isLastState
	 * @param isLastState A Boolean representing the isLastState
	 */
	public void setIsLastState(Boolean isLastState)
	{
		 this.isLastState = isLastState;

		 this.keyModified.put("is_last_state", 1);

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