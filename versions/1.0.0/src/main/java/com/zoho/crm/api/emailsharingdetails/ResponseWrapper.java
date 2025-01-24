package com.zoho.crm.api.emailsharingdetails;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class ResponseWrapper implements Model, ResponseHandler
{
	private List<EmailSharings> emailsSharingDetails;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of emailsSharingDetails
	 * @return An instance of List<EmailSharings>
	 */
	public List<EmailSharings> getEmailsSharingDetails()
	{
		return  this.emailsSharingDetails;

	}

	/**
	 * The method to set the value to emailsSharingDetails
	 * @param emailsSharingDetails An instance of List<EmailSharings>
	 */
	public void setEmailsSharingDetails(List<EmailSharings> emailsSharingDetails)
	{
		 this.emailsSharingDetails = emailsSharingDetails;

		 this.keyModified.put("__emails_sharing_details", 1);

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