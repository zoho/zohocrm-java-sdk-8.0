package com.zoho.crm.api.changeowner;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class BodyWrapper implements Model
{
	private Owner owner;

	private Boolean notify;

	private List<RelatedModules> relatedModules;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of owner
	 * @return An instance of Owner
	 */
	public Owner getOwner()
	{
		return  this.owner;

	}

	/**
	 * The method to set the value to owner
	 * @param owner An instance of Owner
	 */
	public void setOwner(Owner owner)
	{
		 this.owner = owner;

		 this.keyModified.put("owner", 1);

	}

	/**
	 * The method to get the value of notify
	 * @return A Boolean representing the notify
	 */
	public Boolean getNotify()
	{
		return  this.notify;

	}

	/**
	 * The method to set the value to notify
	 * @param notify A Boolean representing the notify
	 */
	public void setNotify(Boolean notify)
	{
		 this.notify = notify;

		 this.keyModified.put("notify", 1);

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