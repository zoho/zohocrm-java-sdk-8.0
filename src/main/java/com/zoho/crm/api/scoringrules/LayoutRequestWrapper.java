package com.zoho.crm.api.scoringrules;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class LayoutRequestWrapper implements Model
{
	private Layout layout;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of layout
	 * @return An instance of Layout
	 */
	public Layout getLayout()
	{
		return  this.layout;

	}

	/**
	 * The method to set the value to layout
	 * @param layout An instance of Layout
	 */
	public void setLayout(Layout layout)
	{
		 this.layout = layout;

		 this.keyModified.put("layout", 1);

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