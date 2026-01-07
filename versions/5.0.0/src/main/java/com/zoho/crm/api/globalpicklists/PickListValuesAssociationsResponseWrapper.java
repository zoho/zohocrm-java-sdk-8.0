package com.zoho.crm.api.globalpicklists;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class PickListValuesAssociationsResponseWrapper implements Model, PickListValuesAssociationsResponseHandler
{
	private List<PickListValuesAssociation> pickListValuesAssociations;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of pickListValuesAssociations
	 * @return An instance of List<PickListValuesAssociation>
	 */
	public List<PickListValuesAssociation> getPickListValuesAssociations()
	{
		return  this.pickListValuesAssociations;

	}

	/**
	 * The method to set the value to pickListValuesAssociations
	 * @param pickListValuesAssociations An instance of List<PickListValuesAssociation>
	 */
	public void setPickListValuesAssociations(List<PickListValuesAssociation> pickListValuesAssociations)
	{
		 this.pickListValuesAssociations = pickListValuesAssociations;

		 this.keyModified.put("pick_list_values_associations", 1);

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