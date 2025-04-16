package com.zoho.crm.api.convertlead;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class CarryOverTags implements Model
{
	private List<String> contacts;

	private List<String> accounts;

	private List<String> deals;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of contacts
	 * @return An instance of List<String>
	 */
	public List<String> getContacts()
	{
		return  this.contacts;

	}

	/**
	 * The method to set the value to contacts
	 * @param contacts An instance of List<String>
	 */
	public void setContacts(List<String> contacts)
	{
		 this.contacts = contacts;

		 this.keyModified.put("Contacts", 1);

	}

	/**
	 * The method to get the value of accounts
	 * @return An instance of List<String>
	 */
	public List<String> getAccounts()
	{
		return  this.accounts;

	}

	/**
	 * The method to set the value to accounts
	 * @param accounts An instance of List<String>
	 */
	public void setAccounts(List<String> accounts)
	{
		 this.accounts = accounts;

		 this.keyModified.put("Accounts", 1);

	}

	/**
	 * The method to get the value of deals
	 * @return An instance of List<String>
	 */
	public List<String> getDeals()
	{
		return  this.deals;

	}

	/**
	 * The method to set the value to deals
	 * @param deals An instance of List<String>
	 */
	public void setDeals(List<String> deals)
	{
		 this.deals = deals;

		 this.keyModified.put("Deals", 1);

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