package com.zoho.crm.api.wizards;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class ButtonBackground implements Model
{
	private List<String> buttonBackground;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of buttonBackground
	 * @return An instance of List<String>
	 */
	public List<String> getButtonBackground()
	{
		return  this.buttonBackground;

	}

	/**
	 * The method to set the value to buttonBackground
	 * @param buttonBackground An instance of List<String>
	 */
	public void setButtonBackground(List<String> buttonBackground)
	{
		 this.buttonBackground = buttonBackground;

		 this.keyModified.put("button_background", 1);

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