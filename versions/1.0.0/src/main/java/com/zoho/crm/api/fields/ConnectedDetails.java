package com.zoho.crm.api.fields;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class ConnectedDetails implements Model
{
	private LinkingModule module;

	private LookupField field;

	private List<LookupLayout> layouts;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of module
	 * @return An instance of LinkingModule
	 */
	public LinkingModule getModule()
	{
		return  this.module;

	}

	/**
	 * The method to set the value to module
	 * @param module An instance of LinkingModule
	 */
	public void setModule(LinkingModule module)
	{
		 this.module = module;

		 this.keyModified.put("module", 1);

	}

	/**
	 * The method to get the value of field
	 * @return An instance of LookupField
	 */
	public LookupField getField()
	{
		return  this.field;

	}

	/**
	 * The method to set the value to field
	 * @param field An instance of LookupField
	 */
	public void setField(LookupField field)
	{
		 this.field = field;

		 this.keyModified.put("field", 1);

	}

	/**
	 * The method to get the value of layouts
	 * @return An instance of List<LookupLayout>
	 */
	public List<LookupLayout> getLayouts()
	{
		return  this.layouts;

	}

	/**
	 * The method to set the value to layouts
	 * @param layouts An instance of List<LookupLayout>
	 */
	public void setLayouts(List<LookupLayout> layouts)
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