package com.zoho.crm.api.conversionoption;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class PreferenceFieldMatchedValue implements Model
{
	private List<PreferenceFieldMatch> contacts;

	private List<PreferenceFieldMatch> accounts;

	private List<PreferenceFieldMatch> deals;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of contacts
	 * @return An instance of List<PreferenceFieldMatch>
	 */
	public List<PreferenceFieldMatch> getContacts()
	{
		return  this.contacts;

	}

	/**
	 * The method to set the value to contacts
	 * @param contacts An instance of List<PreferenceFieldMatch>
	 */
	public void setContacts(List<PreferenceFieldMatch> contacts)
	{
		 this.contacts = contacts;

		 this.keyModified.put("Contacts", 1);

	}

	/**
	 * The method to get the value of accounts
	 * @return An instance of List<PreferenceFieldMatch>
	 */
	public List<PreferenceFieldMatch> getAccounts()
	{
		return  this.accounts;

	}

	/**
	 * The method to set the value to accounts
	 * @param accounts An instance of List<PreferenceFieldMatch>
	 */
	public void setAccounts(List<PreferenceFieldMatch> accounts)
	{
		 this.accounts = accounts;

		 this.keyModified.put("Accounts", 1);

	}

	/**
	 * The method to get the value of deals
	 * @return An instance of List<PreferenceFieldMatch>
	 */
	public List<PreferenceFieldMatch> getDeals()
	{
		return  this.deals;

	}

	/**
	 * The method to set the value to deals
	 * @param deals An instance of List<PreferenceFieldMatch>
	 */
	public void setDeals(List<PreferenceFieldMatch> deals)
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