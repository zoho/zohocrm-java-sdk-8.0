package com.zoho.crm.api.mailmerge;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class SignMailMergeWrapper implements Model
{
	private List<SignMailMerge> signMailMerge;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of signMailMerge
	 * @return An instance of List<SignMailMerge>
	 */
	public List<SignMailMerge> getSignMailMerge()
	{
		return  this.signMailMerge;

	}

	/**
	 * The method to set the value to signMailMerge
	 * @param signMailMerge An instance of List<SignMailMerge>
	 */
	public void setSignMailMerge(List<SignMailMerge> signMailMerge)
	{
		 this.signMailMerge = signMailMerge;

		 this.keyModified.put("sign_mail_merge", 1);

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