package com.zoho.crm.api.usergroups;

import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Assign implements Model
{
	private Choice<String> feature;

	private Long relatedEntityId;

	private Integer page;

	private Integer perPage;

	private Long id;

	private Criteria filters;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of feature
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getFeature()
	{
		return  this.feature;

	}

	/**
	 * The method to set the value to feature
	 * @param feature An instance of Choice<String>
	 */
	public void setFeature(Choice<String> feature)
	{
		 this.feature = feature;

		 this.keyModified.put("feature", 1);

	}

	/**
	 * The method to get the value of relatedEntityId
	 * @return A Long representing the relatedEntityId
	 */
	public Long getRelatedEntityId()
	{
		return  this.relatedEntityId;

	}

	/**
	 * The method to set the value to relatedEntityId
	 * @param relatedEntityId A Long representing the relatedEntityId
	 */
	public void setRelatedEntityId(Long relatedEntityId)
	{
		 this.relatedEntityId = relatedEntityId;

		 this.keyModified.put("related_entity_id", 1);

	}

	/**
	 * The method to get the value of page
	 * @return An Integer representing the page
	 */
	public Integer getPage()
	{
		return  this.page;

	}

	/**
	 * The method to set the value to page
	 * @param page An Integer representing the page
	 */
	public void setPage(Integer page)
	{
		 this.page = page;

		 this.keyModified.put("page", 1);

	}

	/**
	 * The method to get the value of perPage
	 * @return An Integer representing the perPage
	 */
	public Integer getPerPage()
	{
		return  this.perPage;

	}

	/**
	 * The method to set the value to perPage
	 * @param perPage An Integer representing the perPage
	 */
	public void setPerPage(Integer perPage)
	{
		 this.perPage = perPage;

		 this.keyModified.put("per_page", 1);

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
	 * The method to get the value of filters
	 * @return An instance of Criteria
	 */
	public Criteria getFilters()
	{
		return  this.filters;

	}

	/**
	 * The method to set the value to filters
	 * @param filters An instance of Criteria
	 */
	public void setFilters(Criteria filters)
	{
		 this.filters = filters;

		 this.keyModified.put("filters", 1);

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