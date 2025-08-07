package com.zoho.crm.api.emailcomposemeta;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class User implements Model
{
	private String fullName;

	private String email;

	private String zuid;

	private String zgid;

	private Signature signature;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of fullName
	 * @return A String representing the fullName
	 */
	public String getFullName()
	{
		return  this.fullName;

	}

	/**
	 * The method to set the value to fullName
	 * @param fullName A String representing the fullName
	 */
	public void setFullName(String fullName)
	{
		 this.fullName = fullName;

		 this.keyModified.put("full_name", 1);

	}

	/**
	 * The method to get the value of email
	 * @return A String representing the email
	 */
	public String getEmail()
	{
		return  this.email;

	}

	/**
	 * The method to set the value to email
	 * @param email A String representing the email
	 */
	public void setEmail(String email)
	{
		 this.email = email;

		 this.keyModified.put("email", 1);

	}

	/**
	 * The method to get the value of zuid
	 * @return A String representing the zuid
	 */
	public String getZuid()
	{
		return  this.zuid;

	}

	/**
	 * The method to set the value to zuid
	 * @param zuid A String representing the zuid
	 */
	public void setZuid(String zuid)
	{
		 this.zuid = zuid;

		 this.keyModified.put("zuid", 1);

	}

	/**
	 * The method to get the value of zgid
	 * @return A String representing the zgid
	 */
	public String getZgid()
	{
		return  this.zgid;

	}

	/**
	 * The method to set the value to zgid
	 * @param zgid A String representing the zgid
	 */
	public void setZgid(String zgid)
	{
		 this.zgid = zgid;

		 this.keyModified.put("zgid", 1);

	}

	/**
	 * The method to get the value of signature
	 * @return An instance of Signature
	 */
	public Signature getSignature()
	{
		return  this.signature;

	}

	/**
	 * The method to set the value to signature
	 * @param signature An instance of Signature
	 */
	public void setSignature(Signature signature)
	{
		 this.signature = signature;

		 this.keyModified.put("signature", 1);

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