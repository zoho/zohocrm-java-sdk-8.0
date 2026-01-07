package com.zoho.crm.api.ziaenrichment;

import com.zoho.crm.api.util.Model;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;

public class DataEnrichment implements Model
{
	private Module module;

	private String type;

	private List<OutputData> outputDataFieldMapping;

	private List<InputData> inputDataFieldMapping;

	private Long id;

	private Boolean status;

	private OffsetDateTime createdTime;

	private User createdBy;

	private OffsetDateTime modifiedTime;

	private User modifiedBy;

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
	 * The method to get the value of outputDataFieldMapping
	 * @return An instance of List<OutputData>
	 */
	public List<OutputData> getOutputDataFieldMapping()
	{
		return  this.outputDataFieldMapping;

	}

	/**
	 * The method to set the value to outputDataFieldMapping
	 * @param outputDataFieldMapping An instance of List<OutputData>
	 */
	public void setOutputDataFieldMapping(List<OutputData> outputDataFieldMapping)
	{
		 this.outputDataFieldMapping = outputDataFieldMapping;

		 this.keyModified.put("output_data_field_mapping", 1);

	}

	/**
	 * The method to get the value of inputDataFieldMapping
	 * @return An instance of List<InputData>
	 */
	public List<InputData> getInputDataFieldMapping()
	{
		return  this.inputDataFieldMapping;

	}

	/**
	 * The method to set the value to inputDataFieldMapping
	 * @param inputDataFieldMapping An instance of List<InputData>
	 */
	public void setInputDataFieldMapping(List<InputData> inputDataFieldMapping)
	{
		 this.inputDataFieldMapping = inputDataFieldMapping;

		 this.keyModified.put("input_data_field_mapping", 1);

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
	 * The method to get the value of status
	 * @return A Boolean representing the status
	 */
	public Boolean getStatus()
	{
		return  this.status;

	}

	/**
	 * The method to set the value to status
	 * @param status A Boolean representing the status
	 */
	public void setStatus(Boolean status)
	{
		 this.status = status;

		 this.keyModified.put("status", 1);

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