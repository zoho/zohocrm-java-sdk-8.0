package com.zoho.crm.api.sharingrules;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class RulesSummary implements Model
{
	private Module module;

	private Boolean ruleComputationStatus;

	private Integer ruleCount;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of module
	 * @return An instance of Module
	 */
	public Module getModule()
	{
		return  this.module;

	}

	/**
	 * The method to set the value to module
	 * @param module An instance of Module
	 */
	public void setModule(Module module)
	{
		 this.module = module;

		 this.keyModified.put("module", 1);

	}

	/**
	 * The method to get the value of ruleComputationStatus
	 * @return A Boolean representing the ruleComputationStatus
	 */
	public Boolean getRuleComputationStatus()
	{
		return  this.ruleComputationStatus;

	}

	/**
	 * The method to set the value to ruleComputationStatus
	 * @param ruleComputationStatus A Boolean representing the ruleComputationStatus
	 */
	public void setRuleComputationStatus(Boolean ruleComputationStatus)
	{
		 this.ruleComputationStatus = ruleComputationStatus;

		 this.keyModified.put("rule_computation_status", 1);

	}

	/**
	 * The method to get the value of ruleCount
	 * @return An Integer representing the ruleCount
	 */
	public Integer getRuleCount()
	{
		return  this.ruleCount;

	}

	/**
	 * The method to set the value to ruleCount
	 * @param ruleCount An Integer representing the ruleCount
	 */
	public void setRuleCount(Integer ruleCount)
	{
		 this.ruleCount = ruleCount;

		 this.keyModified.put("rule_count", 1);

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