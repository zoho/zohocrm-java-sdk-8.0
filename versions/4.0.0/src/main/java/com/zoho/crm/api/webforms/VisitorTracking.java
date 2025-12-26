package com.zoho.crm.api.webforms;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class VisitorTracking implements Model
{
	private String portalName;

	private String trackingCode;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of portalName
	 * @return A String representing the portalName
	 */
	public String getPortalName()
	{
		return  this.portalName;

	}

	/**
	 * The method to set the value to portalName
	 * @param portalName A String representing the portalName
	 */
	public void setPortalName(String portalName)
	{
		 this.portalName = portalName;

		 this.keyModified.put("portal_name", 1);

	}

	/**
	 * The method to get the value of trackingCode
	 * @return A String representing the trackingCode
	 */
	public String getTrackingCode()
	{
		return  this.trackingCode;

	}

	/**
	 * The method to set the value to trackingCode
	 * @param trackingCode A String representing the trackingCode
	 */
	public void setTrackingCode(String trackingCode)
	{
		 this.trackingCode = trackingCode;

		 this.keyModified.put("tracking_code", 1);

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