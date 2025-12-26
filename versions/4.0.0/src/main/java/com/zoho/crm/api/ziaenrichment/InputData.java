package com.zoho.crm.api.ziaenrichment;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class InputData implements Model
{
	private EnrichField enrichField;

	private CrmField crmField;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of enrichField
	 * @return An instance of EnrichField
	 */
	public EnrichField getEnrichField()
	{
		return  this.enrichField;

	}

	/**
	 * The method to set the value to enrichField
	 * @param enrichField An instance of EnrichField
	 */
	public void setEnrichField(EnrichField enrichField)
	{
		 this.enrichField = enrichField;

		 this.keyModified.put("enrich_field", 1);

	}

	/**
	 * The method to get the value of crmField
	 * @return An instance of CrmField
	 */
	public CrmField getCrmField()
	{
		return  this.crmField;

	}

	/**
	 * The method to set the value to crmField
	 * @param crmField An instance of CrmField
	 */
	public void setCrmField(CrmField crmField)
	{
		 this.crmField = crmField;

		 this.keyModified.put("crm_field", 1);

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