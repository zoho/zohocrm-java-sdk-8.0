package com.zoho.crm.api.webforms;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class ButtonAttributes implements Model
{
	private String color;

	private String name;

	private String align;

	private String borderRadiusPx;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


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
	 * The method to get the value of name
	 * @return A String representing the name
	 */
	public String getName()
	{
		return  this.name;

	}

	/**
	 * The method to set the value to name
	 * @param name A String representing the name
	 */
	public void setName(String name)
	{
		 this.name = name;

		 this.keyModified.put("name", 1);

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
	 * The method to get the value of borderRadiusPx
	 * @return A String representing the borderRadiusPx
	 */
	public String getBorderRadiusPx()
	{
		return  this.borderRadiusPx;

	}

	/**
	 * The method to set the value to borderRadiusPx
	 * @param borderRadiusPx A String representing the borderRadiusPx
	 */
	public void setBorderRadiusPx(String borderRadiusPx)
	{
		 this.borderRadiusPx = borderRadiusPx;

		 this.keyModified.put("border_radius_px", 1);

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