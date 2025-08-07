package com.zoho.crm.api.util;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

import org.json.JSONObject;

/**
 * This class processes the API response object to the POJO object and POJO object to an XML object.
 */
public class XMLConverter extends Converter
{

	public XMLConverter(CommonAPIHandler commonAPIHandler)
	{
		super(commonAPIHandler);
	}

	@Override
	public Object formRequest(Object requestInstance, String pack, Integer instanceNumber, JSONObject memberDetail) throws Exception
	{
		return null;
	}

	@Override
	public void appendToRequest(HttpEntityEnclosingRequestBase requestBase, Object requestObject) throws Exception
	{
	}

	@Override
	public ArrayList<Object> getWrappedResponse(Object response, String pack) throws Exception
	{
		return new ArrayList<>(Arrays.asList(getResponse(response, pack)));
	}

	@Override
	public Object getResponse(Object response, String pack)
	{
		return null;
	}
}
