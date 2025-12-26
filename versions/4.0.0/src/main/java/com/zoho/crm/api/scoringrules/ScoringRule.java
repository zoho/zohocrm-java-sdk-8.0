package com.zoho.crm.api.scoringrules;

import com.zoho.crm.api.modules.Modules;
import com.zoho.crm.api.users.MinifiedUser;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class ScoringRule implements Model
{
	private String name;

	private String description;

	private String id;

	private Layout layout;

	private String createdTime;

	private String modifiedTime;

	private Modules module;

	private MinifiedUser modifiedBy;

	private Boolean active;

	private MinifiedUser createdBy;

	private List<FieldRule> fieldRules;

	private List<SignalRule> signalRules;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


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
	 * The method to get the value of description
	 * @return A String representing the description
	 */
	public String getDescription()
	{
		return  this.description;

	}

	/**
	 * The method to set the value to description
	 * @param description A String representing the description
	 */
	public void setDescription(String description)
	{
		 this.description = description;

		 this.keyModified.put("description", 1);

	}

	/**
	 * The method to get the value of id
	 * @return A String representing the id
	 */
	public String getId()
	{
		return  this.id;

	}

	/**
	 * The method to set the value to id
	 * @param id A String representing the id
	 */
	public void setId(String id)
	{
		 this.id = id;

		 this.keyModified.put("id", 1);

	}

	/**
	 * The method to get the value of layout
	 * @return An instance of Layout
	 */
	public Layout getLayout()
	{
		return  this.layout;

	}

	/**
	 * The method to set the value to layout
	 * @param layout An instance of Layout
	 */
	public void setLayout(Layout layout)
	{
		 this.layout = layout;

		 this.keyModified.put("layout", 1);

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
	 * The method to get the value of module
	 * @return An instance of Modules
	 */
	public Modules getModule()
	{
		return  this.module;

	}

	/**
	 * The method to set the value to module
	 * @param module An instance of Modules
	 */
	public void setModule(Modules module)
	{
		 this.module = module;

		 this.keyModified.put("module", 1);

	}

	/**
	 * The method to get the value of modifiedBy
	 * @return An instance of MinifiedUser
	 */
	public MinifiedUser getModifiedBy()
	{
		return  this.modifiedBy;

	}

	/**
	 * The method to set the value to modifiedBy
	 * @param modifiedBy An instance of MinifiedUser
	 */
	public void setModifiedBy(MinifiedUser modifiedBy)
	{
		 this.modifiedBy = modifiedBy;

		 this.keyModified.put("modified_by", 1);

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
	 * The method to get the value of createdBy
	 * @return An instance of MinifiedUser
	 */
	public MinifiedUser getCreatedBy()
	{
		return  this.createdBy;

	}

	/**
	 * The method to set the value to createdBy
	 * @param createdBy An instance of MinifiedUser
	 */
	public void setCreatedBy(MinifiedUser createdBy)
	{
		 this.createdBy = createdBy;

		 this.keyModified.put("created_by", 1);

	}

	/**
	 * The method to get the value of fieldRules
	 * @return An instance of List<FieldRule>
	 */
	public List<FieldRule> getFieldRules()
	{
		return  this.fieldRules;

	}

	/**
	 * The method to set the value to fieldRules
	 * @param fieldRules An instance of List<FieldRule>
	 */
	public void setFieldRules(List<FieldRule> fieldRules)
	{
		 this.fieldRules = fieldRules;

		 this.keyModified.put("field_rules", 1);

	}

	/**
	 * The method to get the value of signalRules
	 * @return An instance of List<SignalRule>
	 */
	public List<SignalRule> getSignalRules()
	{
		return  this.signalRules;

	}

	/**
	 * The method to set the value to signalRules
	 * @param signalRules An instance of List<SignalRule>
	 */
	public void setSignalRules(List<SignalRule> signalRules)
	{
		 this.signalRules = signalRules;

		 this.keyModified.put("signal_rules", 1);

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