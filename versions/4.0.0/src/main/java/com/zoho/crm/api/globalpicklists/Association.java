package com.zoho.crm.api.globalpicklists;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class Association implements Model
{
	private Field field;

	private Module module;

	private List<Layout> layouts;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of field
	 * @return An instance of Field
	 */
	public Field getField()
	{
		return  this.field;

	}

	/**
	 * The method to set the value to field
	 * @param field An instance of Field
	 */
	public void setField(Field field)
	{
		 this.field = field;

		 this.keyModified.put("field", 1);

	}

	/**
	 * The method to get the value of module
	 * @return An instance of Module
	 */
	public Module getModule()
	{
		return  this.module;

	}

	/**
	 * The method to set the value to module
	 * @param module An instance of Module
	 */
	public void setModule(Module module)
	{
		 this.module = module;

		 this.keyModified.put("module", 1);

	}

	/**
	 * The method to get the value of layouts
	 * @return An instance of List<Layout>
	 */
	public List<Layout> getLayouts()
	{
		return  this.layouts;

	}

	/**
	 * The method to set the value to layouts
	 * @param layouts An instance of List<Layout>
	 */
	public void setLayouts(List<Layout> layouts)
	{
		 this.layouts = layouts;

		 this.keyModified.put("layouts", 1);

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