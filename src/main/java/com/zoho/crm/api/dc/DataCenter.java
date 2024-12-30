package com.zoho.crm.api.dc;

import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.Constants;

/**
 * The abstract class represents the properties of Zoho CRM DataCenter.
 */
public abstract class DataCenter
{
	/**
	 * This method to get accounts URL. URL to be used when calling an OAuth accounts.
	 * 
	 * @return A String representing the accounts URL.
	 */
	public abstract String getIAMUrl();

	/**
	 * This method to get File Upload URL.
	 * 
	 * @return A String representing the File Upload URL.
	 */
	public abstract String getFileUploadUrl();

	/**
	 * The abstract class represents the properties of Zoho CRM Environment.
	 */
	public static abstract class Environment
	{
		/**
		 * This method to get Zoho CRM API URL.
		 * 
		 * @return A String representing the Zoho CRM API URL.
		 */
		public abstract String getUrl();

		/**
		 * This method to get Zoho CRM Accounts URL.
		 * 
		 * @return A String representing the accounts URL.
		 */
		public abstract String getAccountsUrl();

		/**
		 * This method to get File Upload URL.
		 * 
		 * @return A String representing the File Upload URL.
		 */
		public abstract String getFileUploadUrl();
	}

	public static Environment get(String config) throws SDKException
	{
		if (Constants.US_DATACENTER.stream().anyMatch(a -> a.equals(config)))
		{
			if (config.contains(Constants.SANDBOX))
			{
				return USDataCenter.SANDBOX;
			}
			else if (config.contains(Constants.DEVELOPER))
			{
				return USDataCenter.DEVELOPER;
			}
			return USDataCenter.PRODUCTION;
		}
		else if (Constants.JP_DATACENTER.stream().anyMatch(a -> a.equals(config)))
		{
			if (config.contains(Constants.SANDBOX))
			{
				return JPDataCenter.SANDBOX;
			}
			else if (config.contains(Constants.DEVELOPER))
			{
				return JPDataCenter.DEVELOPER;
			}
			return JPDataCenter.PRODUCTION;
		}
		else if (Constants.IN_DATACENTER.stream().anyMatch(a -> a.equals(config)))
		{
			if (config.contains(Constants.SANDBOX))
			{
				return INDataCenter.SANDBOX;
			}
			else if (config.contains(Constants.DEVELOPER))
			{
				return INDataCenter.DEVELOPER;
			}
			return INDataCenter.PRODUCTION;
		}
		else if (Constants.EU_DATACENTER.stream().anyMatch(a -> a.equals(config)))
		{
			if (config.contains(Constants.SANDBOX))
			{
				return EUDataCenter.SANDBOX;
			}
			else if (config.contains(Constants.DEVELOPER))
			{
				return EUDataCenter.DEVELOPER;
			}
			return EUDataCenter.PRODUCTION;
		}
		else if (Constants.CN_DATACENTER.stream().anyMatch(a -> a.equals(config)))
		{
			if (config.contains(Constants.SANDBOX))
			{
				return CNDataCenter.SANDBOX;
			}
			else if (config.contains(Constants.DEVELOPER))
			{
				return CNDataCenter.DEVELOPER;
			}
			return CNDataCenter.PRODUCTION;
		}
		else if (Constants.AU_DATACENTER.stream().anyMatch(a -> a.equals(config)))
		{
			if (config.contains(Constants.SANDBOX))
			{
				return AUDataCenter.SANDBOX;
			}
			else if (config.contains(Constants.DEVELOPER))
			{
				return AUDataCenter.DEVELOPER;
			}
			return AUDataCenter.PRODUCTION;
		}
		else if (Constants.CA_DATACENTER.stream().anyMatch(a -> a.equals(config)))
		{
			if (config.contains(Constants.SANDBOX))
			{
				return CADataCenter.SANDBOX;
			}
			else if (config.contains(Constants.DEVELOPER))
			{
				return CADataCenter.DEVELOPER;
			}
			return CADataCenter.PRODUCTION;
		}
		return null;
	}
}
