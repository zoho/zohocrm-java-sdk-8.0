package com.zoho.crm.api.emaildrafts;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class To implements Model
{
	private String userName;

	private String email;

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