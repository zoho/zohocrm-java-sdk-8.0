package com.zoho.crm.api.cadences;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Cadences implements Model
{
	private Summary summary;

	private String createdTime;

	private Module module;

	private Boolean active;

	private ExecutionDetail executionDetails;

	private Boolean published;

	private String type;

	private User createdBy;

	private String modifiedTime;

	private String name;

	private User modifiedBy;

	private Long id;

	private CustomView customView;

	private String status;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of summary
	 * @return An instance of Summary
	 */
	public Summary getSummary()
	{
		return  this.summary;

	}

	/**
	 * The method to set the value to summary
	 * @param summary An instance of Summary
	 */
	public void setSummary(Summary summary)
	{
		 this.summary = summary;

		 this.keyModified.put("summary", 1);

	}

	/**
	 * The method to get the value of createdTime
	 * @return A String representing the createdTime
	 */
	public String getCreatedTime()
	{
		return  this.createdTime;

	}

	/**
	 * The method to set the value to createdTime
	 * @param createdTime A String representing the createdTime
	 */
	public void setCreatedTime(String createdTime)
	{
		 this.createdTime = createdTime;

		 this.keyModified.put("created_time", 1);

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
	 * The method to get the value of active
	 * @return A Boolean representing the active
	 */
	public Boolean getActive()
	{
		return  this.active;

	}

	/**
	 * The method to set the value to active
	 * @param active A Boolean representing the active
	 */
	public void setActive(Boolean active)
	{
		 this.active = active;

		 this.keyModified.put("active", 1);

	}

	/**
	 * The method to get the value of executionDetails
	 * @return An instance of ExecutionDetail
	 */
	public ExecutionDetail getExecutionDetails()
	{
		return  this.executionDetails;

	}

	/**
	 * The method to set the value to executionDetails
	 * @param executionDetails An instance of ExecutionDetail
	 */
	public void setExecutionDetails(ExecutionDetail executionDetails)
	{
		 this.executionDetails = executionDetails;

		 this.keyModified.put("execution_details", 1);

	}

	/**
	 * The method to get the value of published
	 * @return A Boolean representing the published
	 */
	public Boolean getPublished()
	{
		return  this.published;

	}

	/**
	 * The method to set the value to published
	 * @param published A Boolean representing the published
	 */
	public void setPublished(Boolean published)
	{
		 this.published = published;

		 this.keyModified.put("published", 1);

	}

	/**
	 * The method to get the value of type
	 * @return A String representing the type
	 */
	public String getType()
	{
		return  this.type;

	}

	/**
	 * The method to set the value to type
	 * @param type A String representing the type
	 */
	public void setType(String type)
	{
		 this.type = type;

		 this.keyModified.put("type", 1);

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
	 * The method to get the value of modifiedTime
	 * @return A String representing the modifiedTime
	 */
	public String getModifiedTime()
	{
		return  this.modifiedTime;

	}

	/**
	 * The method to set the value to modifiedTime
	 * @param modifiedTime A String representing the modifiedTime
	 */
	public void setModifiedTime(String modifiedTime)
	{
		 this.modifiedTime = modifiedTime;

		 this.keyModified.put("modified_time", 1);

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
	 * The method to get the value of customView
	 * @return An instance of CustomView
	 */
	public CustomView getCustomView()
	{
		return  this.customView;

	}

	/**
	 * The method to set the value to customView
	 * @param customView An instance of CustomView
	 */
	public void setCustomView(CustomView customView)
	{
		 this.customView = customView;

		 this.keyModified.put("custom_view", 1);

	}

	/**
	 * The method to get the value of status
	 * @return A String representing the status
	 */
	public String getStatus()
	{
		return  this.status;

	}

	/**
	 * The method to set the value to status
	 * @param status A String representing the status
	 */
	public void setStatus(String status)
	{
		 this.status = status;

		 this.keyModified.put("status", 1);

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