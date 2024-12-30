package com.zoho.crm.api.cadencesexecution;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.Map;

public class Analytics implements Model
{
	private Map<String, Object> analytics;

	private ParentFollowUp parentFollowUp;

	private Action action;

	private Long id;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of analytics
	 * @return An instance of Map<String,Object>
	 */
	public Map<String, Object> getAnalytics()
	{
		return  this.analytics;

	}

	/**
	 * The method to set the value to analytics
	 * @param analytics An instance of Map<String,Object>
	 */
	public void setAnalytics(Map<String, Object> analytics)
	{
		 this.analytics = analytics;

		 this.keyModified.put("analytics", 1);

	}

	/**
	 * The method to get the value of parentFollowUp
	 * @return An instance of ParentFollowUp
	 */
	public ParentFollowUp getParentFollowUp()
	{
		return  this.parentFollowUp;

	}

	/**
	 * The method to set the value to parentFollowUp
	 * @param parentFollowUp An instance of ParentFollowUp
	 */
	public void setParentFollowUp(ParentFollowUp parentFollowUp)
	{
		 this.parentFollowUp = parentFollowUp;

		 this.keyModified.put("parent_follow_up", 1);

	}

	/**
	 * The method to get the value of action
	 * @return An instance of Action
	 */
	public Action getAction()
	{
		return  this.action;

	}

	/**
	 * The method to set the value to action
	 * @param action An instance of Action
	 */
	public void setAction(Action action)
	{
		 this.action = action;

		 this.keyModified.put("action", 1);

	}

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