package com.zoho.crm.api.duplicatecheckpreference;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class TypeConfiguration implements Model
{
	private List<FieldMappings> fieldMappings;

	private MappedModule mappedModule;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of fieldMappings
	 * @return An instance of List<FieldMappings>
	 */
	public List<FieldMappings> getFieldMappings()
	{
		return  this.fieldMappings;

	}

	/**
	 * The method to set the value to fieldMappings
	 * @param fieldMappings An instance of List<FieldMappings>
	 */
	public void setFieldMappings(List<FieldMappings> fieldMappings)
	{
		 this.fieldMappings = fieldMappings;

		 this.keyModified.put("field_mappings", 1);

	}

	/**
	 * The method to get the value of mappedModule
	 * @return An instance of MappedModule
	 */
	public MappedModule getMappedModule()
	{
		return  this.mappedModule;

	}

	/**
	 * The method to set the value to mappedModule
	 * @param mappedModule An instance of MappedModule
	 */
	public void setMappedModule(MappedModule mappedModule)
	{
		 this.mappedModule = mappedModule;

		 this.keyModified.put("mapped_module", 1);

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