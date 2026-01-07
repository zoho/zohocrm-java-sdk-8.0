package com.zoho.crm.api.sharerecords;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class ActionWrapper implements Model, ActionHandler
{
	private List<ActionResponse> share;

	private Boolean notify;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of share
	 * @return An instance of List<ActionResponse>
	 */
	public List<ActionResponse> getShare()
	{
		return  this.share;

	}

	/**
	 * The method to set the value to share
	 * @param share An instance of List<ActionResponse>
	 */
	public void setShare(List<ActionResponse> share)
	{
		 this.share = share;

		 this.keyModified.put("share", 1);

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