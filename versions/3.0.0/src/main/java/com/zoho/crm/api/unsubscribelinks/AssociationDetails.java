package com.zoho.crm.api.unsubscribelinks;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class AssociationDetails implements Model
{
	private Long id;

	private List<AssociatedPlaces> associatedPlaces;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of id
	 * @return A Long representing the id
	 */
	public Long getId()
	{
		return  this.id;

	}

	/**
	 * The method to set the value to id
	 * @param id A Long representing the id
	 */
	public void setId(Long id)
	{
		 this.id = id;

		 this.keyModified.put("id", 1);

	}

	/**
	 * The method to get the value of associatedPlaces
	 * @return An instance of List<AssociatedPlaces>
	 */
	public List<AssociatedPlaces> getAssociatedPlaces()
	{
		return  this.associatedPlaces;

	}

	/**
	 * The method to set the value to associatedPlaces
	 * @param associatedPlaces An instance of List<AssociatedPlaces>
	 */
	public void setAssociatedPlaces(List<AssociatedPlaces> associatedPlaces)
	{
		 this.associatedPlaces = associatedPlaces;

		 this.keyModified.put("associated_places", 1);

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