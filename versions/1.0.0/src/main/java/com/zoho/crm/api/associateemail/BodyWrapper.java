package com.zoho.crm.api.associateemail;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class BodyWrapper implements Model
{
	private List<AssociateEmail> emails;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of emails
	 * @return An instance of List<AssociateEmail>
	 */
	public List<AssociateEmail> getEmails()
	{
		return  this.emails;

	}

	/**
	 * The method to set the value to emails
	 * @param emails An instance of List<AssociateEmail>
	 */
	public void setEmails(List<AssociateEmail> emails)
	{
		 this.emails = emails;

		 this.keyModified.put("Emails", 1);

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