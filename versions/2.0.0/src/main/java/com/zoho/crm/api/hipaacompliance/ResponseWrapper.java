package com.zoho.crm.api.hipaacompliance;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class ResponseWrapper implements Model
{
	private HipaaCompliance hipaaCompliance;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of hipaaCompliance
	 * @return An instance of HipaaCompliance
	 */
	public HipaaCompliance getHipaaCompliance()
	{
		return  this.hipaaCompliance;

	}

	/**
	 * The method to set the value to hipaaCompliance
	 * @param hipaaCompliance An instance of HipaaCompliance
	 */
	public void setHipaaCompliance(HipaaCompliance hipaaCompliance)
	{
		 this.hipaaCompliance = hipaaCompliance;

		 this.keyModified.put("hipaa_compliance", 1);

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