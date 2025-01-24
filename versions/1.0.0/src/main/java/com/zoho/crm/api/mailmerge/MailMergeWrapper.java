package com.zoho.crm.api.mailmerge;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class MailMergeWrapper implements Model
{
	private List<MailMerge> sendMailMerge;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of sendMailMerge
	 * @return An instance of List<MailMerge>
	 */
	public List<MailMerge> getSendMailMerge()
	{
		return  this.sendMailMerge;

	}

	/**
	 * The method to set the value to sendMailMerge
	 * @param sendMailMerge An instance of List<MailMerge>
	 */
	public void setSendMailMerge(List<MailMerge> sendMailMerge)
	{
		 this.sendMailMerge = sendMailMerge;

		 this.keyModified.put("send_mail_merge", 1);

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