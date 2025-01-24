package com.zoho.crm.api.privacypreference;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class Config implements Model
{
	private List<Tpt> tpt;

	private List<Section> section;

	private List<Tpt> zohoInteg;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of tpt
	 * @return An instance of List<Tpt>
	 */
	public List<Tpt> getTpt()
	{
		return  this.tpt;

	}

	/**
	 * The method to set the value to tpt
	 * @param tpt An instance of List<Tpt>
	 */
	public void setTpt(List<Tpt> tpt)
	{
		 this.tpt = tpt;

		 this.keyModified.put("tpt", 1);

	}

	/**
	 * The method to get the value of section
	 * @return An instance of List<Section>
	 */
	public List<Section> getSection()
	{
		return  this.section;

	}

	/**
	 * The method to set the value to section
	 * @param section An instance of List<Section>
	 */
	public void setSection(List<Section> section)
	{
		 this.section = section;

		 this.keyModified.put("section", 1);

	}

	/**
	 * The method to get the value of zohoInteg
	 * @return An instance of List<Tpt>
	 */
	public List<Tpt> getZohoInteg()
	{
		return  this.zohoInteg;

	}

	/**
	 * The method to set the value to zohoInteg
	 * @param zohoInteg An instance of List<Tpt>
	 */
	public void setZohoInteg(List<Tpt> zohoInteg)
	{
		 this.zohoInteg = zohoInteg;

		 this.keyModified.put("zoho_integ", 1);

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