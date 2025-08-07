package com.zoho.crm.api.portalinvite;

import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Portal implements Model
{
	private Long id;

	private Long userTypeId;

	private Choice<String> type;

	private Choice<String> language;

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
	 * The method to get the value of userTypeId
	 * @return A Long representing the userTypeId
	 */
	public Long getUserTypeId()
	{
		return  this.userTypeId;

	}

	/**
	 * The method to set the value to userTypeId
	 * @param userTypeId A Long representing the userTypeId
	 */
	public void setUserTypeId(Long userTypeId)
	{
		 this.userTypeId = userTypeId;

		 this.keyModified.put("user_type_id", 1);

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
	 * The method to get the value of language
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getLanguage()
	{
		return  this.language;

	}

	/**
	 * The method to set the value to language
	 * @param language An instance of Choice<String>
	 */
	public void setLanguage(Choice<String> language)
	{
		 this.language = language;

		 this.keyModified.put("language", 1);

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