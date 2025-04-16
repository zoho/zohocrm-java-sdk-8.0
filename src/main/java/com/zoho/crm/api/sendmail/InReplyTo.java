package com.zoho.crm.api.sendmail;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class InReplyTo implements Model
{
	private String messageId;

	private Owner owner;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of messageId
	 * @return A String representing the messageId
	 */
	public String getMessageId()
	{
		return  this.messageId;

	}

	/**
	 * The method to set the value to messageId
	 * @param messageId A String representing the messageId
	 */
	public void setMessageId(String messageId)
	{
		 this.messageId = messageId;

		 this.keyModified.put("message_id", 1);

	}

	/**
	 * The method to get the value of owner
	 * @return An instance of Owner
	 */
	public Owner getOwner()
	{
		return  this.owner;

	}

	/**
	 * The method to set the value to owner
	 * @param owner An instance of Owner
	 */
	public void setOwner(Owner owner)
	{
		 this.owner = owner;

		 this.keyModified.put("owner", 1);

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