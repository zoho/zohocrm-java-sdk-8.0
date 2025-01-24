package com.zoho.crm.api.sharingrules;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class SummaryResponseWrapper implements Model, SummaryResponseHandler
{
	private List<RulesSummary> sharingRulesSummary;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of sharingRulesSummary
	 * @return An instance of List<RulesSummary>
	 */
	public List<RulesSummary> getSharingRulesSummary()
	{
		return  this.sharingRulesSummary;

	}

	/**
	 * The method to set the value to sharingRulesSummary
	 * @param sharingRulesSummary An instance of List<RulesSummary>
	 */
	public void setSharingRulesSummary(List<RulesSummary> sharingRulesSummary)
	{
		 this.sharingRulesSummary = sharingRulesSummary;

		 this.keyModified.put("sharing_rules_summary", 1);

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