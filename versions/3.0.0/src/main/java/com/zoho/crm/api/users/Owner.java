package com.zoho.crm.api.users;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Owner implements Model
{
	private String name;

	private Long id;

	private String lastName;

	private String firstName;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


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
	 * The method to get the value of lastName
	 * @return A String representing the lastName
	 */
	public String getLastName()
	{
		return  this.lastName;

	}

	/**
	 * The method to set the value to lastName
	 * @param lastName A String representing the lastName
	 */
	public void setLastName(String lastName)
	{
		 this.lastName = lastName;

		 this.keyModified.put("last_name", 1);

	}

	/**
	 * The method to get the value of firstName
	 * @return A String representing the firstName
	 */
	public String getFirstName()
	{
		return  this.firstName;

	}

	/**
	 * The method to set the value to firstName
	 * @param firstName A String representing the firstName
	 */
	public void setFirstName(String firstName)
	{
		 this.firstName = firstName;

		 this.keyModified.put("first_name", 1);

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