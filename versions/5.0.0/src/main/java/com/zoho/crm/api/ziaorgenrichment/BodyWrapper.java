package com.zoho.crm.api.ziaorgenrichment;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class BodyWrapper implements Model
{
	private List<ZiaOrgEnrichment> ziaOrgEnrichment;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of ziaOrgEnrichment
	 * @return An instance of List<ZiaOrgEnrichment>
	 */
	public List<ZiaOrgEnrichment> getZiaOrgEnrichment()
	{
		return  this.ziaOrgEnrichment;

	}

	/**
	 * The method to set the value to ziaOrgEnrichment
	 * @param ziaOrgEnrichment An instance of List<ZiaOrgEnrichment>
	 */
	public void setZiaOrgEnrichment(List<ZiaOrgEnrichment> ziaOrgEnrichment)
	{
		 this.ziaOrgEnrichment = ziaOrgEnrichment;

		 this.keyModified.put("__zia_org_enrichment", 1);

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