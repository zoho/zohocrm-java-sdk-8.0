package com.zoho.crm.api.getrelatedrecordscount;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class SuccessResponse implements Model, ActionResponse
{
	private Integer count;

	private RelatedList relatedList;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of count
	 * @return An Integer representing the count
	 */
	public Integer getCount()
	{
		return  this.count;

	}

	/**
	 * The method to set the value to count
	 * @param count An Integer representing the count
	 */
	public void setCount(Integer count)
	{
		 this.count = count;

		 this.keyModified.put("count", 1);

	}

	/**
	 * The method to get the value of relatedList
	 * @return An instance of RelatedList
	 */
	public RelatedList getRelatedList()
	{
		return  this.relatedList;

	}

	/**
	 * The method to set the value to relatedList
	 * @param relatedList An instance of RelatedList
	 */
	public void setRelatedList(RelatedList relatedList)
	{
		 this.relatedList = relatedList;

		 this.keyModified.put("related_list", 1);

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