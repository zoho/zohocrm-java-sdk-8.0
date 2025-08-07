package com.zoho.crm.api.modules;

import com.zoho.crm.api.fields.Lookup;
import com.zoho.crm.api.fields.QueryDetails;
import com.zoho.crm.api.fields.ShowFields;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class ModuleFieldLookup extends Lookup implements Model
{
	private QueryDetails queryDetails;

	private MinifiedModule module;

	private String displayLabel;

	private String apiName;

	private Long id;

	private Boolean revalidateFilterDuringEdit;

	private List<ShowFields> showFields;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of queryDetails
	 * @return An instance of QueryDetails
	 */
	public QueryDetails getQueryDetails()
	{
		return  this.queryDetails;

	}

	/**
	 * The method to set the value to queryDetails
	 * @param queryDetails An instance of QueryDetails
	 */
	public void setQueryDetails(QueryDetails queryDetails)
	{
		 this.queryDetails = queryDetails;

		 this.keyModified.put("query_details", 1);

	}

	/**
	 * The method to get the value of module
	 * @return An instance of MinifiedModule
	 */
	public MinifiedModule getModule()
	{
		return  this.module;

	}

	/**
	 * The method to set the value to module
	 * @param module An instance of MinifiedModule
	 */
	public void setModule(MinifiedModule module)
	{
		 this.module = module;

		 this.keyModified.put("module", 1);

	}

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
	 * The method to get the value of revalidateFilterDuringEdit
	 * @return A Boolean representing the revalidateFilterDuringEdit
	 */
	public Boolean getRevalidateFilterDuringEdit()
	{
		return  this.revalidateFilterDuringEdit;

	}

	/**
	 * The method to set the value to revalidateFilterDuringEdit
	 * @param revalidateFilterDuringEdit A Boolean representing the revalidateFilterDuringEdit
	 */
	public void setRevalidateFilterDuringEdit(Boolean revalidateFilterDuringEdit)
	{
		 this.revalidateFilterDuringEdit = revalidateFilterDuringEdit;

		 this.keyModified.put("revalidate_filter_during_edit", 1);

	}

	/**
	 * The method to get the value of showFields
	 * @return An instance of List<ShowFields>
	 */
	public List<ShowFields> getShowFields()
	{
		return  this.showFields;

	}

	/**
	 * The method to set the value to showFields
	 * @param showFields An instance of List<ShowFields>
	 */
	public void setShowFields(List<ShowFields> showFields)
	{
		 this.showFields = showFields;

		 this.keyModified.put("show_fields", 1);

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