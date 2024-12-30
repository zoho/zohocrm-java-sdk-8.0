package com.zoho.crm.api.emailcompose;

import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class EmailCompose implements Model
{
	private DefaultFromAddress defaultFromAddress;

	private DefaultReplytoAddress defaultReplytoAddress;

	private Font font;

	private Choice<String> type;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of defaultFromAddress
	 * @return An instance of DefaultFromAddress
	 */
	public DefaultFromAddress getDefaultFromAddress()
	{
		return  this.defaultFromAddress;

	}

	/**
	 * The method to set the value to defaultFromAddress
	 * @param defaultFromAddress An instance of DefaultFromAddress
	 */
	public void setDefaultFromAddress(DefaultFromAddress defaultFromAddress)
	{
		 this.defaultFromAddress = defaultFromAddress;

		 this.keyModified.put("default_from_address", 1);

	}

	/**
	 * The method to get the value of defaultReplytoAddress
	 * @return An instance of DefaultReplytoAddress
	 */
	public DefaultReplytoAddress getDefaultReplytoAddress()
	{
		return  this.defaultReplytoAddress;

	}

	/**
	 * The method to set the value to defaultReplytoAddress
	 * @param defaultReplytoAddress An instance of DefaultReplytoAddress
	 */
	public void setDefaultReplytoAddress(DefaultReplytoAddress defaultReplytoAddress)
	{
		 this.defaultReplytoAddress = defaultReplytoAddress;

		 this.keyModified.put("default_replyto_address", 1);

	}

	/**
	 * The method to get the value of font
	 * @return An instance of Font
	 */
	public Font getFont()
	{
		return  this.font;

	}

	/**
	 * The method to set the value to font
	 * @param font An instance of Font
	 */
	public void setFont(Font font)
	{
		 this.font = font;

		 this.keyModified.put("font", 1);

	}

	/**
	 * The method to get the value of type
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getType()
	{
		return  this.type;

	}

	/**
	 * The method to set the value to type
	 * @param type An instance of Choice<String>
	 */
	public void setType(Choice<String> type)
	{
		 this.type = type;

		 this.keyModified.put("type", 1);

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