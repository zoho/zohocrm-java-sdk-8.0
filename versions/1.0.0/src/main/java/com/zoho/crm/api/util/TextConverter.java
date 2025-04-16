//$Id$
package com.zoho.crm.api.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.util.EntityUtils;

import org.json.JSONObject;

import com.zoho.crm.api.Initializer;

public class TextConverter extends Converter
{
	public TextConverter(CommonAPIHandler commonAPIHandler)
	{
		super(commonAPIHandler);
	}

	@Override
	public Object formRequest(Object requestInstance, String pack, Integer instanceNumber, JSONObject memberDetail) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void appendToRequest(HttpEntityEnclosingRequestBase requestBase, Object requestObject) throws Exception
	{
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Object> getWrappedResponse(Object response, String pack) throws Exception
	{
		HttpEntity responseEntity = ((HttpResponse) response).getEntity();
		if (responseEntity != null)
		{
			Object responseObject = EntityUtils.toString(responseEntity);
			return new ArrayList<>(Arrays.asList(getResponse(responseObject, pack)));
		}
		return null;
	}

	@Override
	public Object getResponse(Object response, String packageName) throws Exception
	{
		JSONObject classDetail = Initializer.jsonDetails.getJSONObject(packageName);
		String responseString = response.toString();
		if (responseString == null || responseString.equals("null") || responseString.isEmpty() || responseString.trim().length() == 0)
		{
			return null;
		}
		Object instance = null;
		Constructor<?> constructor = Class.forName(packageName).getDeclaredConstructors()[0];
		if (Modifier.isPrivate(constructor.getModifiers()))
		{
			constructor.setAccessible(true);
		}
		instance = constructor.newInstance();
		for (String memberName : classDetail.keySet())
		{
			JSONObject keyDetail = classDetail.getJSONObject(memberName);
			String keyName = keyDetail.has(Constants.NAME) ? keyDetail.getString(Constants.NAME) : null;
			if (keyName != null)
			{
				Field member = instance.getClass().getDeclaredField(memberName);
				member.setAccessible(true);
				member.set(instance, responseString);
			}
		}
		return instance;
	}
}
