package com.zoho.crm.api.cadencesexecution;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class AnalyticsAlert implements Model
{
	private Integer emailCount;

	private Integer clikedEmailCount;

	private Integer bouncedEmailCount;

	private Integer repliedEmailCount;

	private Integer emailSpamCount;

	private Integer sentEmailCount;

	private Integer unsentEmailCount;

	private Integer openedEmailCount;

	private Integer unsubscribedEmailCount;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of emailCount
	 * @return An Integer representing the emailCount
	 */
	public Integer getEmailCount()
	{
		return  this.emailCount;

	}

	/**
	 * The method to set the value to emailCount
	 * @param emailCount An Integer representing the emailCount
	 */
	public void setEmailCount(Integer emailCount)
	{
		 this.emailCount = emailCount;

		 this.keyModified.put("email_count", 1);

	}

	/**
	 * The method to get the value of clikedEmailCount
	 * @return An Integer representing the clikedEmailCount
	 */
	public Integer getClikedEmailCount()
	{
		return  this.clikedEmailCount;

	}

	/**
	 * The method to set the value to clikedEmailCount
	 * @param clikedEmailCount An Integer representing the clikedEmailCount
	 */
	public void setClikedEmailCount(Integer clikedEmailCount)
	{
		 this.clikedEmailCount = clikedEmailCount;

		 this.keyModified.put("cliked_email_count", 1);

	}

	/**
	 * The method to get the value of bouncedEmailCount
	 * @return An Integer representing the bouncedEmailCount
	 */
	public Integer getBouncedEmailCount()
	{
		return  this.bouncedEmailCount;

	}

	/**
	 * The method to set the value to bouncedEmailCount
	 * @param bouncedEmailCount An Integer representing the bouncedEmailCount
	 */
	public void setBouncedEmailCount(Integer bouncedEmailCount)
	{
		 this.bouncedEmailCount = bouncedEmailCount;

		 this.keyModified.put("bounced_email_count", 1);

	}

	/**
	 * The method to get the value of repliedEmailCount
	 * @return An Integer representing the repliedEmailCount
	 */
	public Integer getRepliedEmailCount()
	{
		return  this.repliedEmailCount;

	}

	/**
	 * The method to set the value to repliedEmailCount
	 * @param repliedEmailCount An Integer representing the repliedEmailCount
	 */
	public void setRepliedEmailCount(Integer repliedEmailCount)
	{
		 this.repliedEmailCount = repliedEmailCount;

		 this.keyModified.put("replied_email_count", 1);

	}

	/**
	 * The method to get the value of emailSpamCount
	 * @return An Integer representing the emailSpamCount
	 */
	public Integer getEmailSpamCount()
	{
		return  this.emailSpamCount;

	}

	/**
	 * The method to set the value to emailSpamCount
	 * @param emailSpamCount An Integer representing the emailSpamCount
	 */
	public void setEmailSpamCount(Integer emailSpamCount)
	{
		 this.emailSpamCount = emailSpamCount;

		 this.keyModified.put("email_spam_count", 1);

	}

	/**
	 * The method to get the value of sentEmailCount
	 * @return An Integer representing the sentEmailCount
	 */
	public Integer getSentEmailCount()
	{
		return  this.sentEmailCount;

	}

	/**
	 * The method to set the value to sentEmailCount
	 * @param sentEmailCount An Integer representing the sentEmailCount
	 */
	public void setSentEmailCount(Integer sentEmailCount)
	{
		 this.sentEmailCount = sentEmailCount;

		 this.keyModified.put("sent_email_count", 1);

	}

	/**
	 * The method to get the value of unsentEmailCount
	 * @return An Integer representing the unsentEmailCount
	 */
	public Integer getUnsentEmailCount()
	{
		return  this.unsentEmailCount;

	}

	/**
	 * The method to set the value to unsentEmailCount
	 * @param unsentEmailCount An Integer representing the unsentEmailCount
	 */
	public void setUnsentEmailCount(Integer unsentEmailCount)
	{
		 this.unsentEmailCount = unsentEmailCount;

		 this.keyModified.put("unsent_email_count", 1);

	}

	/**
	 * The method to get the value of openedEmailCount
	 * @return An Integer representing the openedEmailCount
	 */
	public Integer getOpenedEmailCount()
	{
		return  this.openedEmailCount;

	}

	/**
	 * The method to set the value to openedEmailCount
	 * @param openedEmailCount An Integer representing the openedEmailCount
	 */
	public void setOpenedEmailCount(Integer openedEmailCount)
	{
		 this.openedEmailCount = openedEmailCount;

		 this.keyModified.put("opened_email_count", 1);

	}

	/**
	 * The method to get the value of unsubscribedEmailCount
	 * @return An Integer representing the unsubscribedEmailCount
	 */
	public Integer getUnsubscribedEmailCount()
	{
		return  this.unsubscribedEmailCount;

	}

	/**
	 * The method to set the value to unsubscribedEmailCount
	 * @param unsubscribedEmailCount An Integer representing the unsubscribedEmailCount
	 */
	public void setUnsubscribedEmailCount(Integer unsubscribedEmailCount)
	{
		 this.unsubscribedEmailCount = unsubscribedEmailCount;

		 this.keyModified.put("unsubscribed_email_count", 1);

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