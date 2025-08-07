package com.zoho.crm.api.ziapeopleenrichment;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class SocialMedia implements Model
{
	private String mediaType;

	private List<String> mediaUrl;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of mediaType
	 * @return A String representing the mediaType
	 */
	public String getMediaType()
	{
		return  this.mediaType;

	}

	/**
	 * The method to set the value to mediaType
	 * @param mediaType A String representing the mediaType
	 */
	public void setMediaType(String mediaType)
	{
		 this.mediaType = mediaType;

		 this.keyModified.put("media_type", 1);

	}

	/**
	 * The method to get the value of mediaUrl
	 * @return An instance of List<String>
	 */
	public List<String> getMediaUrl()
	{
		return  this.mediaUrl;

	}

	/**
	 * The method to set the value to mediaUrl
	 * @param mediaUrl An instance of List<String>
	 */
	public void setMediaUrl(List<String> mediaUrl)
	{
		 this.mediaUrl = mediaUrl;

		 this.keyModified.put("media_url", 1);

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