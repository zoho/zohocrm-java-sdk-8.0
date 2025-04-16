package com.zoho.crm.api.ziapeopleenrichment;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class EnrichBasedOn implements Model
{
	private Social social;

	private String name;

	private Company company;

	private String email;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of social
	 * @return An instance of Social
	 */
	public Social getSocial()
	{
		return  this.social;

	}

	/**
	 * The method to set the value to social
	 * @param social An instance of Social
	 */
	public void setSocial(Social social)
	{
		 this.social = social;

		 this.keyModified.put("social", 1);

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
	 * The method to get the value of company
	 * @return An instance of Company
	 */
	public Company getCompany()
	{
		return  this.company;

	}

	/**
	 * The method to set the value to company
	 * @param company An instance of Company
	 */
	public void setCompany(Company company)
	{
		 this.company = company;

		 this.keyModified.put("company", 1);

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