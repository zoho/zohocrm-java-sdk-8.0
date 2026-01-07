package com.zoho.crm.api.webforms;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Logo implements Model
{
	private String imageName;

	private String align;

	private String size;

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
	 * The method to get the value of align
	 * @return A String representing the align
	 */
	public String getAlign()
	{
		return  this.align;

	}

	/**
	 * The method to set the value to align
	 * @param align A String representing the align
	 */
	public void setAlign(String align)
	{
		 this.align = align;

		 this.keyModified.put("align", 1);

	}

	/**
	 * The method to get the value of size
	 * @return A String representing the size
	 */
	public String getSize()
	{
		return  this.size;

	}

	/**
	 * The method to set the value to size
	 * @param size A String representing the size
	 */
	public void setSize(String size)
	{
		 this.size = size;

		 this.keyModified.put("size", 1);

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