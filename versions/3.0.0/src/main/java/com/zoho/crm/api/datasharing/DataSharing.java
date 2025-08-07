package com.zoho.crm.api.datasharing;

import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class DataSharing implements Model
{
	private Choice<String> shareType;

	private Boolean publicInPortals;

	private Module module;

	private Boolean ruleComputationRunning;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of shareType
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getShareType()
	{
		return  this.shareType;

	}

	/**
	 * The method to set the value to shareType
	 * @param shareType An instance of Choice<String>
	 */
	public void setShareType(Choice<String> shareType)
	{
		 this.shareType = shareType;

		 this.keyModified.put("share_type", 1);

	}

	/**
	 * The method to get the value of publicInPortals
	 * @return A Boolean representing the publicInPortals
	 */
	public Boolean getPublicInPortals()
	{
		return  this.publicInPortals;

	}

	/**
	 * The method to set the value to publicInPortals
	 * @param publicInPortals A Boolean representing the publicInPortals
	 */
	public void setPublicInPortals(Boolean publicInPortals)
	{
		 this.publicInPortals = publicInPortals;

		 this.keyModified.put("public_in_portals", 1);

	}

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
	 * The method to get the value of ruleComputationRunning
	 * @return A Boolean representing the ruleComputationRunning
	 */
	public Boolean getRuleComputationRunning()
	{
		return  this.ruleComputationRunning;

	}

	/**
	 * The method to set the value to ruleComputationRunning
	 * @param ruleComputationRunning A Boolean representing the ruleComputationRunning
	 */
	public void setRuleComputationRunning(Boolean ruleComputationRunning)
	{
		 this.ruleComputationRunning = ruleComputationRunning;

		 this.keyModified.put("rule_computation_running", 1);

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