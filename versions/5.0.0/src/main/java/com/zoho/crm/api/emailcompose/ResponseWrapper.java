package com.zoho.crm.api.emailcompose;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class ResponseWrapper implements Model, ResponseHandler
{
	private List<EmailCompose> emailCompose;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of emailCompose
	 * @return An instance of List<EmailCompose>
	 */
	public List<EmailCompose> getEmailCompose()
	{
		return  this.emailCompose;

	}

	/**
	 * The method to set the value to emailCompose
	 * @param emailCompose An instance of List<EmailCompose>
	 */
	public void setEmailCompose(List<EmailCompose> emailCompose)
	{
		 this.emailCompose = emailCompose;

		 this.keyModified.put("email_compose", 1);

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