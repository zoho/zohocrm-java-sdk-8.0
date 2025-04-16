package com.zoho.crm.api.fields;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class EmailParser implements Model
{
	private Boolean fieldsUpdateSupported;

	private Boolean recordOperationsSupported;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of fieldsUpdateSupported
	 * @return A Boolean representing the fieldsUpdateSupported
	 */
	public Boolean getFieldsUpdateSupported()
	{
		return  this.fieldsUpdateSupported;

	}

	/**
	 * The method to set the value to fieldsUpdateSupported
	 * @param fieldsUpdateSupported A Boolean representing the fieldsUpdateSupported
	 */
	public void setFieldsUpdateSupported(Boolean fieldsUpdateSupported)
	{
		 this.fieldsUpdateSupported = fieldsUpdateSupported;

		 this.keyModified.put("fields_update_supported", 1);

	}

	/**
	 * The method to get the value of recordOperationsSupported
	 * @return A Boolean representing the recordOperationsSupported
	 */
	public Boolean getRecordOperationsSupported()
	{
		return  this.recordOperationsSupported;

	}

	/**
	 * The method to set the value to recordOperationsSupported
	 * @param recordOperationsSupported A Boolean representing the recordOperationsSupported
	 */
	public void setRecordOperationsSupported(Boolean recordOperationsSupported)
	{
		 this.recordOperationsSupported = recordOperationsSupported;

		 this.keyModified.put("record_operations_supported", 1);

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