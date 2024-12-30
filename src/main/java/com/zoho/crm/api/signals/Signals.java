package com.zoho.crm.api.signals;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Signals implements Model
{
	private String displayLabel;

	private String namespace;

	private Boolean chatEnabled;

	private Boolean enabled;

	private Long id;

	private FeatureAvailability featureAvailability;

	private Extension extension;

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
	 * The method to get the value of namespace
	 * @return A String representing the namespace
	 */
	public String getNamespace()
	{
		return  this.namespace;

	}

	/**
	 * The method to set the value to namespace
	 * @param namespace A String representing the namespace
	 */
	public void setNamespace(String namespace)
	{
		 this.namespace = namespace;

		 this.keyModified.put("namespace", 1);

	}

	/**
	 * The method to get the value of chatEnabled
	 * @return A Boolean representing the chatEnabled
	 */
	public Boolean getChatEnabled()
	{
		return  this.chatEnabled;

	}

	/**
	 * The method to set the value to chatEnabled
	 * @param chatEnabled A Boolean representing the chatEnabled
	 */
	public void setChatEnabled(Boolean chatEnabled)
	{
		 this.chatEnabled = chatEnabled;

		 this.keyModified.put("chat_enabled", 1);

	}

	/**
	 * The method to get the value of enabled
	 * @return A Boolean representing the enabled
	 */
	public Boolean getEnabled()
	{
		return  this.enabled;

	}

	/**
	 * The method to set the value to enabled
	 * @param enabled A Boolean representing the enabled
	 */
	public void setEnabled(Boolean enabled)
	{
		 this.enabled = enabled;

		 this.keyModified.put("enabled", 1);

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
	 * The method to get the value of featureAvailability
	 * @return An instance of FeatureAvailability
	 */
	public FeatureAvailability getFeatureAvailability()
	{
		return  this.featureAvailability;

	}

	/**
	 * The method to set the value to featureAvailability
	 * @param featureAvailability An instance of FeatureAvailability
	 */
	public void setFeatureAvailability(FeatureAvailability featureAvailability)
	{
		 this.featureAvailability = featureAvailability;

		 this.keyModified.put("feature_availability", 1);

	}

	/**
	 * The method to get the value of extension
	 * @return An instance of Extension
	 */
	public Extension getExtension()
	{
		return  this.extension;

	}

	/**
	 * The method to set the value to extension
	 * @param extension An instance of Extension
	 */
	public void setExtension(Extension extension)
	{
		 this.extension = extension;

		 this.keyModified.put("extension", 1);

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