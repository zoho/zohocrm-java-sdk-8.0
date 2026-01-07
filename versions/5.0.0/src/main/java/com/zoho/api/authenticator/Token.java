package com.zoho.api.authenticator;

import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIHTTPConnector;

public interface Token
{
	/**
	 * This method to set authentication token to APIHTTPConnector instance.
	 * 
	 * @param urlConnection A APIHTTPConnector class instance.
	 * @throws SDKException if a problem occurs.
	 */
	public void authenticate(APIHTTPConnector urlConnection) throws SDKException;

	public Boolean revoke(String id) throws SDKException;

	public void remove() throws SDKException;

	public void generateToken() throws SDKException;

	public String getId();
}
