package com.zoho.crm.api.backup;

import com.zoho.crm.api.util.Model;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;

public class Urls implements Model
{
	private List<String> dataLinks;

	private List<String> attachmentLinks;

	private OffsetDateTime expiryDate;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of dataLinks
	 * @return An instance of List<String>
	 */
	public List<String> getDataLinks()
	{
		return  this.dataLinks;

	}

	/**
	 * The method to set the value to dataLinks
	 * @param dataLinks An instance of List<String>
	 */
	public void setDataLinks(List<String> dataLinks)
	{
		 this.dataLinks = dataLinks;

		 this.keyModified.put("data_links", 1);

	}

	/**
	 * The method to get the value of attachmentLinks
	 * @return An instance of List<String>
	 */
	public List<String> getAttachmentLinks()
	{
		return  this.attachmentLinks;

	}

	/**
	 * The method to set the value to attachmentLinks
	 * @param attachmentLinks An instance of List<String>
	 */
	public void setAttachmentLinks(List<String> attachmentLinks)
	{
		 this.attachmentLinks = attachmentLinks;

		 this.keyModified.put("attachment_links", 1);

	}

	/**
	 * The method to get the value of expiryDate
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getExpiryDate()
	{
		return  this.expiryDate;

	}

	/**
	 * The method to set the value to expiryDate
	 * @param expiryDate An instance of OffsetDateTime
	 */
	public void setExpiryDate(OffsetDateTime expiryDate)
	{
		 this.expiryDate = expiryDate;

		 this.keyModified.put("expiry_date", 1);

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