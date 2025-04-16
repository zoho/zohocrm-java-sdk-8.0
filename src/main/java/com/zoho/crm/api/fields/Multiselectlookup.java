package com.zoho.crm.api.fields;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Multiselectlookup implements Model
{
	private LinkingDetails linkingDetails;

	private ConnectedDetails connectedDetails;

	private LookupRelatedList relatedList;

	private Boolean recordAccess;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of linkingDetails
	 * @return An instance of LinkingDetails
	 */
	public LinkingDetails getLinkingDetails()
	{
		return  this.linkingDetails;

	}

	/**
	 * The method to set the value to linkingDetails
	 * @param linkingDetails An instance of LinkingDetails
	 */
	public void setLinkingDetails(LinkingDetails linkingDetails)
	{
		 this.linkingDetails = linkingDetails;

		 this.keyModified.put("linking_details", 1);

	}

	/**
	 * The method to get the value of connectedDetails
	 * @return An instance of ConnectedDetails
	 */
	public ConnectedDetails getConnectedDetails()
	{
		return  this.connectedDetails;

	}

	/**
	 * The method to set the value to connectedDetails
	 * @param connectedDetails An instance of ConnectedDetails
	 */
	public void setConnectedDetails(ConnectedDetails connectedDetails)
	{
		 this.connectedDetails = connectedDetails;

		 this.keyModified.put("connected_details", 1);

	}

	/**
	 * The method to get the value of relatedList
	 * @return An instance of LookupRelatedList
	 */
	public LookupRelatedList getRelatedList()
	{
		return  this.relatedList;

	}

	/**
	 * The method to set the value to relatedList
	 * @param relatedList An instance of LookupRelatedList
	 */
	public void setRelatedList(LookupRelatedList relatedList)
	{
		 this.relatedList = relatedList;

		 this.keyModified.put("related_list", 1);

	}

	/**
	 * The method to get the value of recordAccess
	 * @return A Boolean representing the recordAccess
	 */
	public Boolean getRecordAccess()
	{
		return  this.recordAccess;

	}

	/**
	 * The method to set the value to recordAccess
	 * @param recordAccess A Boolean representing the recordAccess
	 */
	public void setRecordAccess(Boolean recordAccess)
	{
		 this.recordAccess = recordAccess;

		 this.keyModified.put("record_access", 1);

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