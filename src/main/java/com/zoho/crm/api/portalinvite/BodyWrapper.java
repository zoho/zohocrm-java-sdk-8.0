package com.zoho.crm.api.portalinvite;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class BodyWrapper implements Model
{
	private List<PortalInvite> portalInvite;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of portalInvite
	 * @return An instance of List<PortalInvite>
	 */
	public List<PortalInvite> getPortalInvite()
	{
		return  this.portalInvite;

	}

	/**
	 * The method to set the value to portalInvite
	 * @param portalInvite An instance of List<PortalInvite>
	 */
	public void setPortalInvite(List<PortalInvite> portalInvite)
	{
		 this.portalInvite = portalInvite;

		 this.keyModified.put("portal_invite", 1);

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