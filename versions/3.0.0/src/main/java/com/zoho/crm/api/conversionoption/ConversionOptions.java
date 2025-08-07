package com.zoho.crm.api.conversionoption;

import com.zoho.crm.api.modules.Modules;
import com.zoho.crm.api.record.Record;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class ConversionOptions implements Model
{
	private Modules modulePreference;

	private List<Record> contacts;

	private List<Record> deals;

	private List<Record> accounts;

	private PreferenceFieldMatchedValue preferenceFieldMatchedValue;

	private List<Modules> modulesWithMultipleLayouts;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of modulePreference
	 * @return An instance of Modules
	 */
	public Modules getModulePreference()
	{
		return  this.modulePreference;

	}

	/**
	 * The method to set the value to modulePreference
	 * @param modulePreference An instance of Modules
	 */
	public void setModulePreference(Modules modulePreference)
	{
		 this.modulePreference = modulePreference;

		 this.keyModified.put("module_preference", 1);

	}

	/**
	 * The method to get the value of contacts
	 * @return An instance of List<Record>
	 */
	public List<Record> getContacts()
	{
		return  this.contacts;

	}

	/**
	 * The method to set the value to contacts
	 * @param contacts An instance of List<Record>
	 */
	public void setContacts(List<Record> contacts)
	{
		 this.contacts = contacts;

		 this.keyModified.put("Contacts", 1);

	}

	/**
	 * The method to get the value of deals
	 * @return An instance of List<Record>
	 */
	public List<Record> getDeals()
	{
		return  this.deals;

	}

	/**
	 * The method to set the value to deals
	 * @param deals An instance of List<Record>
	 */
	public void setDeals(List<Record> deals)
	{
		 this.deals = deals;

		 this.keyModified.put("Deals", 1);

	}

	/**
	 * The method to get the value of accounts
	 * @return An instance of List<Record>
	 */
	public List<Record> getAccounts()
	{
		return  this.accounts;

	}

	/**
	 * The method to set the value to accounts
	 * @param accounts An instance of List<Record>
	 */
	public void setAccounts(List<Record> accounts)
	{
		 this.accounts = accounts;

		 this.keyModified.put("Accounts", 1);

	}

	/**
	 * The method to get the value of preferenceFieldMatchedValue
	 * @return An instance of PreferenceFieldMatchedValue
	 */
	public PreferenceFieldMatchedValue getPreferenceFieldMatchedValue()
	{
		return  this.preferenceFieldMatchedValue;

	}

	/**
	 * The method to set the value to preferenceFieldMatchedValue
	 * @param preferenceFieldMatchedValue An instance of PreferenceFieldMatchedValue
	 */
	public void setPreferenceFieldMatchedValue(PreferenceFieldMatchedValue preferenceFieldMatchedValue)
	{
		 this.preferenceFieldMatchedValue = preferenceFieldMatchedValue;

		 this.keyModified.put("preference_field_matched_value", 1);

	}

	/**
	 * The method to get the value of modulesWithMultipleLayouts
	 * @return An instance of List<Modules>
	 */
	public List<Modules> getModulesWithMultipleLayouts()
	{
		return  this.modulesWithMultipleLayouts;

	}

	/**
	 * The method to set the value to modulesWithMultipleLayouts
	 * @param modulesWithMultipleLayouts An instance of List<Modules>
	 */
	public void setModulesWithMultipleLayouts(List<Modules> modulesWithMultipleLayouts)
	{
		 this.modulesWithMultipleLayouts = modulesWithMultipleLayouts;

		 this.keyModified.put("modules_with_multiple_layouts", 1);

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