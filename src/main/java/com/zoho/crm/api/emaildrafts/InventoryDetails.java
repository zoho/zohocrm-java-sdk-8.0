package com.zoho.crm.api.emaildrafts;

import com.zoho.crm.api.record.Record;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class InventoryDetails implements Model
{
	private InventoryTemplate inventoryTemplate;

	private Record record;

	private String paperType;

	private String viewType;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of inventoryTemplate
	 * @return An instance of InventoryTemplate
	 */
	public InventoryTemplate getInventoryTemplate()
	{
		return  this.inventoryTemplate;

	}

	/**
	 * The method to set the value to inventoryTemplate
	 * @param inventoryTemplate An instance of InventoryTemplate
	 */
	public void setInventoryTemplate(InventoryTemplate inventoryTemplate)
	{
		 this.inventoryTemplate = inventoryTemplate;

		 this.keyModified.put("inventory_template", 1);

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
	 * The method to get the value of paperType
	 * @return A String representing the paperType
	 */
	public String getPaperType()
	{
		return  this.paperType;

	}

	/**
	 * The method to set the value to paperType
	 * @param paperType A String representing the paperType
	 */
	public void setPaperType(String paperType)
	{
		 this.paperType = paperType;

		 this.keyModified.put("paper_type", 1);

	}

	/**
	 * The method to get the value of viewType
	 * @return A String representing the viewType
	 */
	public String getViewType()
	{
		return  this.viewType;

	}

	/**
	 * The method to set the value to viewType
	 * @param viewType A String representing the viewType
	 */
	public void setViewType(String viewType)
	{
		 this.viewType = viewType;

		 this.keyModified.put("view_type", 1);

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