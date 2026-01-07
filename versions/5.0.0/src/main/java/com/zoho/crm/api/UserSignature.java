package com.zoho.crm.api;

import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.Constants;
import com.zoho.crm.api.util.Utility;

public class UserSignature
{
	private String name;

	public UserSignature(String name) throws SDKException
	{
		Utility.assertNotNull(name, Constants.MANDATORY_VALUE_ERROR, Constants.MANDATORY_KEY_ERROR.concat(" - ").concat(Constants.NAME));
		this.name = name;
	}

	public String getName()
	{
		return name;
	}
}
