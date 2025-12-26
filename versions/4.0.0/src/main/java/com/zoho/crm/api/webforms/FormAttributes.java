package com.zoho.crm.api.webforms;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class FormAttributes implements Model
{
	private String color;

	private Integer width;

	private FontAttributes fontAttributes;

	private String align;

	private Logo logo;

	private Background background;

	private Boolean displayFormName;

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
	 * The method to get the value of width
	 * @return An Integer representing the width
	 */
	public Integer getWidth()
	{
		return  this.width;

	}

	/**
	 * The method to set the value to width
	 * @param width An Integer representing the width
	 */
	public void setWidth(Integer width)
	{
		 this.width = width;

		 this.keyModified.put("width", 1);

	}

	/**
	 * The method to get the value of fontAttributes
	 * @return An instance of FontAttributes
	 */
	public FontAttributes getFontAttributes()
	{
		return  this.fontAttributes;

	}

	/**
	 * The method to set the value to fontAttributes
	 * @param fontAttributes An instance of FontAttributes
	 */
	public void setFontAttributes(FontAttributes fontAttributes)
	{
		 this.fontAttributes = fontAttributes;

		 this.keyModified.put("font_attributes", 1);

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
	 * The method to get the value of logo
	 * @return An instance of Logo
	 */
	public Logo getLogo()
	{
		return  this.logo;

	}

	/**
	 * The method to set the value to logo
	 * @param logo An instance of Logo
	 */
	public void setLogo(Logo logo)
	{
		 this.logo = logo;

		 this.keyModified.put("logo", 1);

	}

	/**
	 * The method to get the value of background
	 * @return An instance of Background
	 */
	public Background getBackground()
	{
		return  this.background;

	}

	/**
	 * The method to set the value to background
	 * @param background An instance of Background
	 */
	public void setBackground(Background background)
	{
		 this.background = background;

		 this.keyModified.put("background", 1);

	}

	/**
	 * The method to get the value of displayFormName
	 * @return A Boolean representing the displayFormName
	 */
	public Boolean getDisplayFormName()
	{
		return  this.displayFormName;

	}

	/**
	 * The method to set the value to displayFormName
	 * @param displayFormName A Boolean representing the displayFormName
	 */
	public void setDisplayFormName(Boolean displayFormName)
	{
		 this.displayFormName = displayFormName;

		 this.keyModified.put("display_form_name", 1);

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