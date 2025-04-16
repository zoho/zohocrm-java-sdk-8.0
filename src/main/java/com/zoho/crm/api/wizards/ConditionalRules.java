package com.zoho.crm.api.wizards;

import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class ConditionalRules implements Model
{
	private Long queryId;

	private Choice<String> executeOn;

	private Criteria criteria;

	private List<Actions> actions;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of queryId
	 * @return A Long representing the queryId
	 */
	public Long getQueryId()
	{
		return  this.queryId;

	}

	/**
	 * The method to set the value to queryId
	 * @param queryId A Long representing the queryId
	 */
	public void setQueryId(Long queryId)
	{
		 this.queryId = queryId;

		 this.keyModified.put("query_id", 1);

	}

	/**
	 * The method to get the value of executeOn
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getExecuteOn()
	{
		return  this.executeOn;

	}

	/**
	 * The method to set the value to executeOn
	 * @param executeOn An instance of Choice<String>
	 */
	public void setExecuteOn(Choice<String> executeOn)
	{
		 this.executeOn = executeOn;

		 this.keyModified.put("execute_on", 1);

	}

	/**
	 * The method to get the value of criteria
	 * @return An instance of Criteria
	 */
	public Criteria getCriteria()
	{
		return  this.criteria;

	}

	/**
	 * The method to set the value to criteria
	 * @param criteria An instance of Criteria
	 */
	public void setCriteria(Criteria criteria)
	{
		 this.criteria = criteria;

		 this.keyModified.put("criteria", 1);

	}

	/**
	 * The method to get the value of actions
	 * @return An instance of List<Actions>
	 */
	public List<Actions> getActions()
	{
		return  this.actions;

	}

	/**
	 * The method to set the value to actions
	 * @param actions An instance of List<Actions>
	 */
	public void setActions(List<Actions> actions)
	{
		 this.actions = actions;

		 this.keyModified.put("actions", 1);

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