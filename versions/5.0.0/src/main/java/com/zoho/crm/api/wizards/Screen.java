package com.zoho.crm.api.wizards;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class Screen implements Model
{
	private String displayLabel;

	private String apiName;

	private Long id;

	private String referenceId;

	private List<ConditionalRules> conditionalRules;

	private List<Segment> segments;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of displayLabel
	 * @return A String representing the displayLabel
	 */
	public String getDisplayLabel()
	{
		return  this.displayLabel;

	}

	/**
	 * The method to set the value to displayLabel
	 * @param displayLabel A String representing the displayLabel
	 */
	public void setDisplayLabel(String displayLabel)
	{
		 this.displayLabel = displayLabel;

		 this.keyModified.put("display_label", 1);

	}

	/**
	 * The method to get the value of apiName
	 * @return A String representing the apiName
	 */
	public String getAPIName()
	{
		return  this.apiName;

	}

	/**
	 * The method to set the value to apiName
	 * @param apiName A String representing the apiName
	 */
	public void setAPIName(String apiName)
	{
		 this.apiName = apiName;

		 this.keyModified.put("api_name", 1);

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
	 * The method to get the value of referenceId
	 * @return A String representing the referenceId
	 */
	public String getReferenceId()
	{
		return  this.referenceId;

	}

	/**
	 * The method to set the value to referenceId
	 * @param referenceId A String representing the referenceId
	 */
	public void setReferenceId(String referenceId)
	{
		 this.referenceId = referenceId;

		 this.keyModified.put("reference_id", 1);

	}

	/**
	 * The method to get the value of conditionalRules
	 * @return An instance of List<ConditionalRules>
	 */
	public List<ConditionalRules> getConditionalRules()
	{
		return  this.conditionalRules;

	}

	/**
	 * The method to set the value to conditionalRules
	 * @param conditionalRules An instance of List<ConditionalRules>
	 */
	public void setConditionalRules(List<ConditionalRules> conditionalRules)
	{
		 this.conditionalRules = conditionalRules;

		 this.keyModified.put("conditional_rules", 1);

	}

	/**
	 * The method to get the value of segments
	 * @return An instance of List<Segment>
	 */
	public List<Segment> getSegments()
	{
		return  this.segments;

	}

	/**
	 * The method to set the value to segments
	 * @param segments An instance of List<Segment>
	 */
	public void setSegments(List<Segment> segments)
	{
		 this.segments = segments;

		 this.keyModified.put("segments", 1);

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