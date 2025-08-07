package com.zoho.crm.api.emailsignatures;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class ActionWrapper implements Model, ActionHandler
{
	private List<ActionResponse> emailSignatures;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of emailSignatures
	 * @return An instance of List<ActionResponse>
	 */
	public List<ActionResponse> getEmailSignatures()
	{
		return  this.emailSignatures;

	}

	/**
	 * The method to set the value to emailSignatures
	 * @param emailSignatures An instance of List<ActionResponse>
	 */
	public void setEmailSignatures(List<ActionResponse> emailSignatures)
	{
		 this.emailSignatures = emailSignatures;

		 this.keyModified.put("email_signatures", 1);

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