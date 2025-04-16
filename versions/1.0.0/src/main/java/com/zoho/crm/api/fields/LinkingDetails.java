package com.zoho.crm.api.fields;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class LinkingDetails implements Model
{
	private LinkingModule module;

	private LookupField lookupField;

	private LookupField connectedLookupField;

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
	 * The method to get the value of lookupField
	 * @return An instance of LookupField
	 */
	public LookupField getLookupField()
	{
		return  this.lookupField;

	}

	/**
	 * The method to set the value to lookupField
	 * @param lookupField An instance of LookupField
	 */
	public void setLookupField(LookupField lookupField)
	{
		 this.lookupField = lookupField;

		 this.keyModified.put("lookup_field", 1);

	}

	/**
	 * The method to get the value of connectedLookupField
	 * @return An instance of LookupField
	 */
	public LookupField getConnectedLookupField()
	{
		return  this.connectedLookupField;

	}

	/**
	 * The method to set the value to connectedLookupField
	 * @param connectedLookupField An instance of LookupField
	 */
	public void setConnectedLookupField(LookupField connectedLookupField)
	{
		 this.connectedLookupField = connectedLookupField;

		 this.keyModified.put("connected_lookup_field", 1);

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