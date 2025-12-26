package com.zoho.crm.api.emailcomposemeta;

import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class FromAddress implements Model
{
	private String userName;

	private String type;

	private String email;

	private Long id;

	private Choice<Boolean> default1;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of userName
	 * @return A String representing the userName
	 */
	public String getUserName()
	{
		return  this.userName;

	}

	/**
	 * The method to set the value to userName
	 * @param userName A String representing the userName
	 */
	public void setUserName(String userName)
	{
		 this.userName = userName;

		 this.keyModified.put("user_name", 1);

	}

	/**
	 * The method to get the value of type
	 * @return A String representing the type
	 */
	public String getType()
	{
		return  this.type;

	}

	/**
	 * The method to set the value to type
	 * @param type A String representing the type
	 */
	public void setType(String type)
	{
		 this.type = type;

		 this.keyModified.put("type", 1);

	}

	/**
	 * The method to get the value of email
	 * @return A String representing the email
	 */
	public String getEmail()
	{
		return  this.email;

	}

	/**
	 * The method to set the value to email
	 * @param email A String representing the email
	 */
	public void setEmail(String email)
	{
		 this.email = email;

		 this.keyModified.put("email", 1);

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
	 * The method to get the value of default
	 * @return An instance of Choice<Boolean>
	 */
	public Choice<Boolean> getDefault()
	{
		return  this.default1;

	}

	/**
	 * The method to set the value to default
	 * @param default1 An instance of Choice<Boolean>
	 */
	public void setDefault(Choice<Boolean> default1)
	{
		 this.default1 = default1;

		 this.keyModified.put("default", 1);

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