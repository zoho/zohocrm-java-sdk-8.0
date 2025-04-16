package com.zoho.crm.api.associateemail;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Available implements Model
{
	private Boolean available;

	private Record record;

	private LinkedRecord linkedRecord;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of available
	 * @return A Boolean representing the available
	 */
	public Boolean getAvailable()
	{
		return  this.available;

	}

	/**
	 * The method to set the value to available
	 * @param available A Boolean representing the available
	 */
	public void setAvailable(Boolean available)
	{
		 this.available = available;

		 this.keyModified.put("available", 1);

	}

	/**
	 * The method to get the value of record
	 * @return An instance of Record
	 */
	public Record getRecord()
	{
		return  this.record;

	}

	/**
	 * The method to set the value to record
	 * @param record An instance of Record
	 */
	public void setRecord(Record record)
	{
		 this.record = record;

		 this.keyModified.put("record", 1);

	}

	/**
	 * The method to get the value of linkedRecord
	 * @return An instance of LinkedRecord
	 */
	public LinkedRecord getLinkedRecord()
	{
		return  this.linkedRecord;

	}

	/**
	 * The method to set the value to linkedRecord
	 * @param linkedRecord An instance of LinkedRecord
	 */
	public void setLinkedRecord(LinkedRecord linkedRecord)
	{
		 this.linkedRecord = linkedRecord;

		 this.keyModified.put("linked_record", 1);

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