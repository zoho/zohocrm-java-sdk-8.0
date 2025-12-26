package com.zoho.crm.api.layouts;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class ConvertMapping implements Model
{
	private MinifiedLayout contacts;

	private DealLayoutMapping deals;

	private MinifiedLayout accounts;

	private MinifiedLayout invoices;

	private MinifiedLayout salesorders;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of contacts
	 * @return An instance of MinifiedLayout
	 */
	public MinifiedLayout getContacts()
	{
		return  this.contacts;

	}

	/**
	 * The method to set the value to contacts
	 * @param contacts An instance of MinifiedLayout
	 */
	public void setContacts(MinifiedLayout contacts)
	{
		 this.contacts = contacts;

		 this.keyModified.put("Contacts", 1);

	}

	/**
	 * The method to get the value of deals
	 * @return An instance of DealLayoutMapping
	 */
	public DealLayoutMapping getDeals()
	{
		return  this.deals;

	}

	/**
	 * The method to set the value to deals
	 * @param deals An instance of DealLayoutMapping
	 */
	public void setDeals(DealLayoutMapping deals)
	{
		 this.deals = deals;

		 this.keyModified.put("Deals", 1);

	}

	/**
	 * The method to get the value of accounts
	 * @return An instance of MinifiedLayout
	 */
	public MinifiedLayout getAccounts()
	{
		return  this.accounts;

	}

	/**
	 * The method to set the value to accounts
	 * @param accounts An instance of MinifiedLayout
	 */
	public void setAccounts(MinifiedLayout accounts)
	{
		 this.accounts = accounts;

		 this.keyModified.put("Accounts", 1);

	}

	/**
	 * The method to get the value of invoices
	 * @return An instance of MinifiedLayout
	 */
	public MinifiedLayout getInvoices()
	{
		return  this.invoices;

	}

	/**
	 * The method to set the value to invoices
	 * @param invoices An instance of MinifiedLayout
	 */
	public void setInvoices(MinifiedLayout invoices)
	{
		 this.invoices = invoices;

		 this.keyModified.put("Invoices", 1);

	}

	/**
	 * The method to get the value of salesorders
	 * @return An instance of MinifiedLayout
	 */
	public MinifiedLayout getSalesorders()
	{
		return  this.salesorders;

	}

	/**
	 * The method to set the value to salesorders
	 * @param salesorders An instance of MinifiedLayout
	 */
	public void setSalesorders(MinifiedLayout salesorders)
	{
		 this.salesorders = salesorders;

		 this.keyModified.put("SalesOrders", 1);

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