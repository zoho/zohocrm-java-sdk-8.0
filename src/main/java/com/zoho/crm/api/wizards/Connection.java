package com.zoho.crm.api.wizards;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Connection implements Model
{
	private Button sourceButton;

	private Screen targetScreen;

	private Long id;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of sourceButton
	 * @return An instance of Button
	 */
	public Button getSourceButton()
	{
		return  this.sourceButton;

	}

	/**
	 * The method to set the value to sourceButton
	 * @param sourceButton An instance of Button
	 */
	public void setSourceButton(Button sourceButton)
	{
		 this.sourceButton = sourceButton;

		 this.keyModified.put("source_button", 1);

	}

	/**
	 * The method to get the value of targetScreen
	 * @return An instance of Screen
	 */
	public Screen getTargetScreen()
	{
		return  this.targetScreen;

	}

	/**
	 * The method to set the value to targetScreen
	 * @param targetScreen An instance of Screen
	 */
	public void setTargetScreen(Screen targetScreen)
	{
		 this.targetScreen = targetScreen;

		 this.keyModified.put("target_screen", 1);

	}

	/**
	 * The method to get the value of id
	 * @return A Long representing the id
	 */
	public Long getId()
	{
		return  this.id;

	}

	/**
	 * The method to set the value to id
	 * @param id A Long representing the id
	 */
	public void setId(Long id)
	{
		 this.id = id;

		 this.keyModified.put("id", 1);

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