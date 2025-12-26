package com.zoho.crm.api.templates;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class Wrapper implements Model
{
	private List<Templates> templates;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of templates
	 * @return An instance of List<Templates>
	 */
	public List<Templates> getTemplates()
	{
		return  this.templates;

	}

	/**
	 * The method to set the value to templates
	 * @param templates An instance of List<Templates>
	 */
	public void setTemplates(List<Templates> templates)
	{
		 this.templates = templates;

		 this.keyModified.put("templates", 1);

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