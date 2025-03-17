package com.zoho.crm.api.mailmerge;

import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Signers implements Model
{
	private String recipientName;

	private Choice<String> actionType;

	private Address recipient;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of recipientName
	 * @return A String representing the recipientName
	 */
	public String getRecipientName()
	{
		return  this.recipientName;

	}

	/**
	 * The method to set the value to recipientName
	 * @param recipientName A String representing the recipientName
	 */
	public void setRecipientName(String recipientName)
	{
		 this.recipientName = recipientName;

		 this.keyModified.put("recipient_name", 1);

	}

	/**
	 * The method to get the value of actionType
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getActionType()
	{
		return  this.actionType;

	}

	/**
	 * The method to set the value to actionType
	 * @param actionType An instance of Choice<String>
	 */
	public void setActionType(Choice<String> actionType)
	{
		 this.actionType = actionType;

		 this.keyModified.put("action_type", 1);

	}

	/**
	 * The method to get the value of recipient
	 * @return An instance of Address
	 */
	public Address getRecipient()
	{
		return  this.recipient;

	}

	/**
	 * The method to set the value to recipient
	 * @param recipient An instance of Address
	 */
	public void setRecipient(Address recipient)
	{
		 this.recipient = recipient;

		 this.keyModified.put("recipient", 1);

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