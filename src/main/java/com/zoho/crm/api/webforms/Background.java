package com.zoho.crm.api.webforms;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Background implements Model
{
	private String imageName;

	private String color;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of imageName
	 * @return A String representing the imageName
	 */
	public String getImageName()
	{
		return  this.imageName;

	}

	/**
	 * The method to set the value to imageName
	 * @param imageName A String representing the imageName
	 */
	public void setImageName(String imageName)
	{
		 this.imageName = imageName;

		 this.keyModified.put("image_name", 1);

	}

	/**
	 * The method to get the value of color
	 * @return A String representing the color
	 */
	public String getColor()
	{
		return  this.color;

	}

	/**
	 * The method to set the value to color
	 * @param color A String representing the color
	 */
	public void setColor(String color)
	{
		 this.color = color;

		 this.keyModified.put("color", 1);

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