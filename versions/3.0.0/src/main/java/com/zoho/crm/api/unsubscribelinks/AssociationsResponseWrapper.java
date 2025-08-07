package com.zoho.crm.api.unsubscribelinks;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class AssociationsResponseWrapper implements Model, AssociationsResponseHandler
{
	private List<AssociationDetails> associations;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of associations
	 * @return An instance of List<AssociationDetails>
	 */
	public List<AssociationDetails> getAssociations()
	{
		return  this.associations;

	}

	/**
	 * The method to set the value to associations
	 * @param associations An instance of List<AssociationDetails>
	 */
	public void setAssociations(List<AssociationDetails> associations)
	{
		 this.associations = associations;

		 this.keyModified.put("associations", 1);

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