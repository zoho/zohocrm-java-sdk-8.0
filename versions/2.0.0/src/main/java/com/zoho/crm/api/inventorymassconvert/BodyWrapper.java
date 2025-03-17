package com.zoho.crm.api.inventorymassconvert;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class BodyWrapper implements Model
{
	private List<ConvertTo> convertTo;

	private User assignTo;

	private List<RelatedModules> relatedModules;

	private List<Long> ids;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of convertTo
	 * @return An instance of List<ConvertTo>
	 */
	public List<ConvertTo> getConvertTo()
	{
		return  this.convertTo;

	}

	/**
	 * The method to set the value to convertTo
	 * @param convertTo An instance of List<ConvertTo>
	 */
	public void setConvertTo(List<ConvertTo> convertTo)
	{
		 this.convertTo = convertTo;

		 this.keyModified.put("convert_to", 1);

	}

	/**
	 * The method to get the value of assignTo
	 * @return An instance of User
	 */
	public User getAssignTo()
	{
		return  this.assignTo;

	}

	/**
	 * The method to set the value to assignTo
	 * @param assignTo An instance of User
	 */
	public void setAssignTo(User assignTo)
	{
		 this.assignTo = assignTo;

		 this.keyModified.put("assign_to", 1);

	}

	/**
	 * The method to get the value of relatedModules
	 * @return An instance of List<RelatedModules>
	 */
	public List<RelatedModules> getRelatedModules()
	{
		return  this.relatedModules;

	}

	/**
	 * The method to set the value to relatedModules
	 * @param relatedModules An instance of List<RelatedModules>
	 */
	public void setRelatedModules(List<RelatedModules> relatedModules)
	{
		 this.relatedModules = relatedModules;

		 this.keyModified.put("related_modules", 1);

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