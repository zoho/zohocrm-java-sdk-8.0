package com.zoho.crm.api.unsubscribelinks;

import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.time.OffsetDateTime;
import java.util.HashMap;

public class UnsubscribeLinks implements Model
{
	private Long id;

	private String name;

	private Choice<String> pageType;

	private String customLocationUrl;

	private String standardPageMessage;

	private Choice<String> submissionActionType;

	private String submissionMessage;

	private String submissionRedirectUrl;

	private String locationUrlType;

	private String actionOnUnsubscribe;

	private User createdBy;

	private User modifiedBy;

	private OffsetDateTime modifiedTime;

	private OffsetDateTime createdTime;

	private String landingUrl;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


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
	 * The method to get the value of name
	 * @return A String representing the name
	 */
	public String getName()
	{
		return  this.name;

	}

	/**
	 * The method to set the value to name
	 * @param name A String representing the name
	 */
	public void setName(String name)
	{
		 this.name = name;

		 this.keyModified.put("name", 1);

	}

	/**
	 * The method to get the value of pageType
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getPageType()
	{
		return  this.pageType;

	}

	/**
	 * The method to set the value to pageType
	 * @param pageType An instance of Choice<String>
	 */
	public void setPageType(Choice<String> pageType)
	{
		 this.pageType = pageType;

		 this.keyModified.put("page_type", 1);

	}

	/**
	 * The method to get the value of customLocationUrl
	 * @return A String representing the customLocationUrl
	 */
	public String getCustomLocationUrl()
	{
		return  this.customLocationUrl;

	}

	/**
	 * The method to set the value to customLocationUrl
	 * @param customLocationUrl A String representing the customLocationUrl
	 */
	public void setCustomLocationUrl(String customLocationUrl)
	{
		 this.customLocationUrl = customLocationUrl;

		 this.keyModified.put("custom_location_url", 1);

	}

	/**
	 * The method to get the value of standardPageMessage
	 * @return A String representing the standardPageMessage
	 */
	public String getStandardPageMessage()
	{
		return  this.standardPageMessage;

	}

	/**
	 * The method to set the value to standardPageMessage
	 * @param standardPageMessage A String representing the standardPageMessage
	 */
	public void setStandardPageMessage(String standardPageMessage)
	{
		 this.standardPageMessage = standardPageMessage;

		 this.keyModified.put("standard_page_message", 1);

	}

	/**
	 * The method to get the value of submissionActionType
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getSubmissionActionType()
	{
		return  this.submissionActionType;

	}

	/**
	 * The method to set the value to submissionActionType
	 * @param submissionActionType An instance of Choice<String>
	 */
	public void setSubmissionActionType(Choice<String> submissionActionType)
	{
		 this.submissionActionType = submissionActionType;

		 this.keyModified.put("submission_action_type", 1);

	}

	/**
	 * The method to get the value of submissionMessage
	 * @return A String representing the submissionMessage
	 */
	public String getSubmissionMessage()
	{
		return  this.submissionMessage;

	}

	/**
	 * The method to set the value to submissionMessage
	 * @param submissionMessage A String representing the submissionMessage
	 */
	public void setSubmissionMessage(String submissionMessage)
	{
		 this.submissionMessage = submissionMessage;

		 this.keyModified.put("submission_message", 1);

	}

	/**
	 * The method to get the value of submissionRedirectUrl
	 * @return A String representing the submissionRedirectUrl
	 */
	public String getSubmissionRedirectUrl()
	{
		return  this.submissionRedirectUrl;

	}

	/**
	 * The method to set the value to submissionRedirectUrl
	 * @param submissionRedirectUrl A String representing the submissionRedirectUrl
	 */
	public void setSubmissionRedirectUrl(String submissionRedirectUrl)
	{
		 this.submissionRedirectUrl = submissionRedirectUrl;

		 this.keyModified.put("submission_redirect_url", 1);

	}

	/**
	 * The method to get the value of locationUrlType
	 * @return A String representing the locationUrlType
	 */
	public String getLocationUrlType()
	{
		return  this.locationUrlType;

	}

	/**
	 * The method to set the value to locationUrlType
	 * @param locationUrlType A String representing the locationUrlType
	 */
	public void setLocationUrlType(String locationUrlType)
	{
		 this.locationUrlType = locationUrlType;

		 this.keyModified.put("location_url_type", 1);

	}

	/**
	 * The method to get the value of actionOnUnsubscribe
	 * @return A String representing the actionOnUnsubscribe
	 */
	public String getActionOnUnsubscribe()
	{
		return  this.actionOnUnsubscribe;

	}

	/**
	 * The method to set the value to actionOnUnsubscribe
	 * @param actionOnUnsubscribe A String representing the actionOnUnsubscribe
	 */
	public void setActionOnUnsubscribe(String actionOnUnsubscribe)
	{
		 this.actionOnUnsubscribe = actionOnUnsubscribe;

		 this.keyModified.put("action_on_unsubscribe", 1);

	}

	/**
	 * The method to get the value of createdBy
	 * @return An instance of User
	 */
	public User getCreatedBy()
	{
		return  this.createdBy;

	}

	/**
	 * The method to set the value to createdBy
	 * @param createdBy An instance of User
	 */
	public void setCreatedBy(User createdBy)
	{
		 this.createdBy = createdBy;

		 this.keyModified.put("created_by", 1);

	}

	/**
	 * The method to get the value of modifiedBy
	 * @return An instance of User
	 */
	public User getModifiedBy()
	{
		return  this.modifiedBy;

	}

	/**
	 * The method to set the value to modifiedBy
	 * @param modifiedBy An instance of User
	 */
	public void setModifiedBy(User modifiedBy)
	{
		 this.modifiedBy = modifiedBy;

		 this.keyModified.put("modified_by", 1);

	}

	/**
	 * The method to get the value of modifiedTime
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getModifiedTime()
	{
		return  this.modifiedTime;

	}

	/**
	 * The method to set the value to modifiedTime
	 * @param modifiedTime An instance of OffsetDateTime
	 */
	public void setModifiedTime(OffsetDateTime modifiedTime)
	{
		 this.modifiedTime = modifiedTime;

		 this.keyModified.put("modified_time", 1);

	}

	/**
	 * The method to get the value of createdTime
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getCreatedTime()
	{
		return  this.createdTime;

	}

	/**
	 * The method to set the value to createdTime
	 * @param createdTime An instance of OffsetDateTime
	 */
	public void setCreatedTime(OffsetDateTime createdTime)
	{
		 this.createdTime = createdTime;

		 this.keyModified.put("created_time", 1);

	}

	/**
	 * The method to get the value of landingUrl
	 * @return A String representing the landingUrl
	 */
	public String getLandingUrl()
	{
		return  this.landingUrl;

	}

	/**
	 * The method to set the value to landingUrl
	 * @param landingUrl A String representing the landingUrl
	 */
	public void setLandingUrl(String landingUrl)
	{
		 this.landingUrl = landingUrl;

		 this.keyModified.put("landing_url", 1);

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