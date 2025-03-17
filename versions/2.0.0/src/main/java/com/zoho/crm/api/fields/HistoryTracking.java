package com.zoho.crm.api.fields;

import com.zoho.crm.api.modules.MinifiedModule;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class HistoryTracking implements Model
{
	private String relatedListName;

	private Choice<String> durationConfiguration;

	private List<MinifiedField> followedFields;

	private HistoryTrackingModule module;

	private MinifiedModule durationConfiguredField;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of relatedListName
	 * @return A String representing the relatedListName
	 */
	public String getRelatedListName()
	{
		return  this.relatedListName;

	}

	/**
	 * The method to set the value to relatedListName
	 * @param relatedListName A String representing the relatedListName
	 */
	public void setRelatedListName(String relatedListName)
	{
		 this.relatedListName = relatedListName;

		 this.keyModified.put("related_list_name", 1);

	}

	/**
	 * The method to get the value of durationConfiguration
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getDurationConfiguration()
	{
		return  this.durationConfiguration;

	}

	/**
	 * The method to set the value to durationConfiguration
	 * @param durationConfiguration An instance of Choice<String>
	 */
	public void setDurationConfiguration(Choice<String> durationConfiguration)
	{
		 this.durationConfiguration = durationConfiguration;

		 this.keyModified.put("duration_configuration", 1);

	}

	/**
	 * The method to get the value of followedFields
	 * @return An instance of List<MinifiedField>
	 */
	public List<MinifiedField> getFollowedFields()
	{
		return  this.followedFields;

	}

	/**
	 * The method to set the value to followedFields
	 * @param followedFields An instance of List<MinifiedField>
	 */
	public void setFollowedFields(List<MinifiedField> followedFields)
	{
		 this.followedFields = followedFields;

		 this.keyModified.put("followed_fields", 1);

	}

	/**
	 * The method to get the value of module
	 * @return An instance of HistoryTrackingModule
	 */
	public HistoryTrackingModule getModule()
	{
		return  this.module;

	}

	/**
	 * The method to set the value to module
	 * @param module An instance of HistoryTrackingModule
	 */
	public void setModule(HistoryTrackingModule module)
	{
		 this.module = module;

		 this.keyModified.put("module", 1);

	}

	/**
	 * The method to get the value of durationConfiguredField
	 * @return An instance of MinifiedModule
	 */
	public MinifiedModule getDurationConfiguredField()
	{
		return  this.durationConfiguredField;

	}

	/**
	 * The method to set the value to durationConfiguredField
	 * @param durationConfiguredField An instance of MinifiedModule
	 */
	public void setDurationConfiguredField(MinifiedModule durationConfiguredField)
	{
		 this.durationConfiguredField = durationConfiguredField;

		 this.keyModified.put("duration_configured_field", 1);

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