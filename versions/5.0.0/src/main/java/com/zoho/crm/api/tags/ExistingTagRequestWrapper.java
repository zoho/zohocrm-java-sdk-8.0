package com.zoho.crm.api.tags;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class ExistingTagRequestWrapper implements Model
{
	private List<ExistingTag> tags;

	private List<Long> ids;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of tags
	 * @return An instance of List<ExistingTag>
	 */
	public List<ExistingTag> getTags()
	{
		return  this.tags;

	}

	/**
	 * The method to set the value to tags
	 * @param tags An instance of List<ExistingTag>
	 */
	public void setTags(List<ExistingTag> tags)
	{
		 this.tags = tags;

		 this.keyModified.put("tags", 1);

	}

	/**
	 * The method to get the value of ids
	 * @return An instance of List<Long>
	 */
	public List<Long> getIds()
	{
		return  this.ids;

	}

	/**
	 * The method to set the value to ids
	 * @param ids An instance of List<Long>
	 */
	public void setIds(List<Long> ids)
	{
		 this.ids = ids;

		 this.keyModified.put("ids", 1);

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