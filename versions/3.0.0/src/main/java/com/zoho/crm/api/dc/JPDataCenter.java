package com.zoho.crm.api.dc;

/**
 * This class represents the properties of Zoho CRM in Japan Domain.
 */
public class JPDataCenter extends DataCenter
{
	private static final JPDataCenter JP = new JPDataCenter();

	private JPDataCenter()
	{
	}

	/**
	 * This Environment class instance represents the Zoho CRM Production Environment in Japan Domain.
	 */
	public static final Environment PRODUCTION = new Environment()
	{
		/**
		 * This method to get Zoho CRM production API URL.
		 * 
		 * @return A String representing the Zoho CRM production API URL.
		 */
		public String getUrl()
		{
			return "https://www.zohoapis.jp";
		}

		/**
		 * This method to get Zoho CRM Accounts URL.
		 * 
		 * @return A String representing the accounts URL.
		 */
		public String getAccountsUrl()
		{
			return JP.getIAMUrl();
		}

		/**
		 * This method to get Zoho CRM File Upload URL.
		 * 
		 * @return A String representing the File Upload URL.
		 */
		public String getFileUploadUrl()
		{
			return JP.getFileUploadUrl();
		}
	};

	/**
	 * This Environment class instance represents the Zoho CRM Sandbox Environment in Japan Domain.
	 */
	public static final Environment SANDBOX = new Environment()
	{
		/**
		 * This method to get Zoho CRM sandbox API URL.
		 * 
		 * @return A String representing the Zoho CRM sandbox API URL.
		 */
		public String getUrl()
		{
			return "https://sandbox.zohoapis.jp";
		}

		/**
		 * This method to get Zoho CRM Accounts URL.
		 * 
		 * @return A String representing the accounts URL.
		 */
		public String getAccountsUrl()
		{
			return JP.getIAMUrl();
		}

		/**
		 * This method to get Zoho CRM File Upload URL.
		 * 
		 * @return A String representing the File Upload URL.
		 */
		public String getFileUploadUrl()
		{
			return JP.getFileUploadUrl();
		}
	};

	/**
	 * This Environment class instance represents the Zoho CRM Developer Environment in Japan Domain.
	 */
	public static final Environment DEVELOPER = new Environment()
	{
		/**
		 * This method to get Zoho CRM developer API URL.
		 * 
		 * @return A String representing the Zoho CRM developer API URL.
		 */
		public String getUrl()
		{
			return "https://developer.zohoapis.jp";
		}

		/**
		 * This method to get Zoho CRM Accounts URL.
		 * 
		 * @return A String representing the accounts URL.
		 */
		public String getAccountsUrl()
		{
			return JP.getIAMUrl();
		}

		/**
		 * This method to get Zoho CRM File Upload URL.
		 * 
		 * @return A String representing the File Upload URL.
		 */
		public String getFileUploadUrl()
		{
			return JP.getFileUploadUrl();
		}
	};

	@Override
	public String getIAMUrl()
	{
		return "https://accounts.zoho.jp/oauth/v2/token";
	}

	@Override
	public String getFileUploadUrl()
	{
		return "https://content.zohoapis.jp";
	}
}
