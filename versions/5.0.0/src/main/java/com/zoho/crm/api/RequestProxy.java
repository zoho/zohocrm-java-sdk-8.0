package com.zoho.crm.api;

import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.Constants;
import com.zoho.crm.api.util.Utility;

/**
 * This class represents the properties of proxy for the user.
 */
public class RequestProxy
{
	private String host;
	private Integer port;
	private String userDomain;
	private String user;
	private String password;

	/**
	 * Creates a RequestProxy class instance with the specified parameters.
	 * 
	 * @param host       A String containing the hostname or address of the proxy server
	 * @param port       A Integer containing The port number of the proxy server
	 * @param user       A String containing the user name of the proxy server
	 * @param password   A String containing the password of the proxy server
	 * @param userDomain A String containing the domain of the proxy server
	 * @throws SDKException
	 */
	private RequestProxy(String host, Integer port, String user, String password, String userDomain)
	{
		this.host = host;
		this.port = port;
		this.userDomain = userDomain;
		this.user = user;
		this.password = password;
	}

	/**
	 * This is a getter method to get Proxy host.
	 * 
	 * @return the host
	 */
	public String getHost()
	{
		return host;
	}

	/**
	 * This is a getter method to get Proxy port.
	 * 
	 * @return the port
	 */
	public Integer getPort()
	{
		return port;
	}

	/**
	 * This is a getter method to get Proxy userDomain.
	 * 
	 * @return the userDomain
	 */
	public String getUserDomain()
	{
		return userDomain;
	}

	/**
	 * This is a getter method to get Proxy user name.
	 * 
	 * @return the user
	 */
	public String getUser()
	{
		return user;
	}

	/**
	 * This is a getter method to get Proxy password.
	 * 
	 * @return the password
	 */
	public String getPassword()
	{
		return password;
	}

	public static class Builder
	{
		private String host;
		private Integer port;
		private String userDomain;
		private String user;
		private String password = "";

		public Builder()
		{
		}

		public Builder host(String host) throws SDKException
		{
			Utility.assertNotNull(host, Constants.REQUEST_PROXY_ERROR, Constants.HOST_ERROR_MESSAGE);
			this.host = host;
			return this;
		}

		public Builder port(Integer port) throws SDKException
		{
			Utility.assertNotNull(port, Constants.REQUEST_PROXY_ERROR, Constants.PORT_ERROR_MESSAGE);
			this.port = port;
			return this;
		}

		public Builder userDomain(String userDomain)
		{
			this.userDomain = userDomain;
			return this;
		}

		public Builder user(String user)
		{
			this.user = user;
			return this;
		}

		public Builder password(String password)
		{
			this.password = password;
			return this;
		}

		public RequestProxy build() throws SDKException
		{
			Utility.assertNotNull(host, Constants.REQUEST_PROXY_ERROR, Constants.HOST_ERROR_MESSAGE);
			Utility.assertNotNull(port, Constants.REQUEST_PROXY_ERROR, Constants.PORT_ERROR_MESSAGE);
			return new RequestProxy(this.host, this.port, this.user, this.password, this.userDomain);
		}
	}
}
