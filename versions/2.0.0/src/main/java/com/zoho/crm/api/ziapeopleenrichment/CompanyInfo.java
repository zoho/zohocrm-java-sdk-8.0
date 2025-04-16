package com.zoho.crm.api.ziapeopleenrichment;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class CompanyInfo implements Model
{
	private String name;

	private List<Industry> industries;

	private List<Experience> experiences;

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
	 * The method to get the value of industries
	 * @return An instance of List<Industry>
	 */
	public List<Industry> getIndustries()
	{
		return  this.industries;

	}

	/**
	 * The method to set the value to industries
	 * @param industries An instance of List<Industry>
	 */
	public void setIndustries(List<Industry> industries)
	{
		 this.industries = industries;

		 this.keyModified.put("industries", 1);

	}

	/**
	 * The method to get the value of experiences
	 * @return An instance of List<Experience>
	 */
	public List<Experience> getExperiences()
	{
		return  this.experiences;

	}

	/**
	 * The method to set the value to experiences
	 * @param experiences An instance of List<Experience>
	 */
	public void setExperiences(List<Experience> experiences)
	{
		 this.experiences = experiences;

		 this.keyModified.put("experiences", 1);

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