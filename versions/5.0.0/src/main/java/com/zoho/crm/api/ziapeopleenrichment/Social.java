package com.zoho.crm.api.ziapeopleenrichment;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Social implements Model
{
	private String twitter;

	private String facebook;

	private String linkedin;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of twitter
	 * @return A String representing the twitter
	 */
	public String getTwitter()
	{
		return  this.twitter;

	}

	/**
	 * The method to set the value to twitter
	 * @param twitter A String representing the twitter
	 */
	public void setTwitter(String twitter)
	{
		 this.twitter = twitter;

		 this.keyModified.put("twitter", 1);

	}

	/**
	 * The method to get the value of facebook
	 * @return A String representing the facebook
	 */
	public String getFacebook()
	{
		return  this.facebook;

	}

	/**
	 * The method to set the value to facebook
	 * @param facebook A String representing the facebook
	 */
	public void setFacebook(String facebook)
	{
		 this.facebook = facebook;

		 this.keyModified.put("facebook", 1);

	}

	/**
	 * The method to get the value of linkedin
	 * @return A String representing the linkedin
	 */
	public String getLinkedin()
	{
		return  this.linkedin;

	}

	/**
	 * The method to set the value to linkedin
	 * @param linkedin A String representing the linkedin
	 */
	public void setLinkedin(String linkedin)
	{
		 this.linkedin = linkedin;

		 this.keyModified.put("linkedin", 1);

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