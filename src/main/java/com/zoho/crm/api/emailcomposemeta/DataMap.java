package com.zoho.crm.api.emailcomposemeta;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class DataMap implements Model
{
	private User user;

	private FeaturesAvailable featuresAvailable;

	private List<FromAddress> fromAddress;

	private List<String> relayDomains;

	private String mergefieldsdata;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of user
	 * @return An instance of User
	 */
	public User getUser()
	{
		return  this.user;

	}

	/**
	 * The method to set the value to user
	 * @param user An instance of User
	 */
	public void setUser(User user)
	{
		 this.user = user;

		 this.keyModified.put("user", 1);

	}

	/**
	 * The method to get the value of featuresAvailable
	 * @return An instance of FeaturesAvailable
	 */
	public FeaturesAvailable getFeaturesAvailable()
	{
		return  this.featuresAvailable;

	}

	/**
	 * The method to set the value to featuresAvailable
	 * @param featuresAvailable An instance of FeaturesAvailable
	 */
	public void setFeaturesAvailable(FeaturesAvailable featuresAvailable)
	{
		 this.featuresAvailable = featuresAvailable;

		 this.keyModified.put("features_available", 1);

	}

	/**
	 * The method to get the value of fromAddress
	 * @return An instance of List<FromAddress>
	 */
	public List<FromAddress> getFromAddress()
	{
		return  this.fromAddress;

	}

	/**
	 * The method to set the value to fromAddress
	 * @param fromAddress An instance of List<FromAddress>
	 */
	public void setFromAddress(List<FromAddress> fromAddress)
	{
		 this.fromAddress = fromAddress;

		 this.keyModified.put("from_address", 1);

	}

	/**
	 * The method to get the value of relayDomains
	 * @return An instance of List<String>
	 */
	public List<String> getRelayDomains()
	{
		return  this.relayDomains;

	}

	/**
	 * The method to set the value to relayDomains
	 * @param relayDomains An instance of List<String>
	 */
	public void setRelayDomains(List<String> relayDomains)
	{
		 this.relayDomains = relayDomains;

		 this.keyModified.put("relay_domains", 1);

	}

	/**
	 * The method to get the value of mergefieldsdata
	 * @return A String representing the mergefieldsdata
	 */
	public String getMergefieldsdata()
	{
		return  this.mergefieldsdata;

	}

	/**
	 * The method to set the value to mergefieldsdata
	 * @param mergefieldsdata A String representing the mergefieldsdata
	 */
	public void setMergefieldsdata(String mergefieldsdata)
	{
		 this.mergefieldsdata = mergefieldsdata;

		 this.keyModified.put("mergeFieldsData", 1);

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