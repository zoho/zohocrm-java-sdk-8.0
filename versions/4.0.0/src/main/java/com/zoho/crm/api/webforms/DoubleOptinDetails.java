package com.zoho.crm.api.webforms;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class DoubleOptinDetails implements Model
{
	private DoubleOptinEmailTemplate emailTemplate;

	private String confirmPageContent;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of emailTemplate
	 * @return An instance of DoubleOptinEmailTemplate
	 */
	public DoubleOptinEmailTemplate getEmailTemplate()
	{
		return  this.emailTemplate;

	}

	/**
	 * The method to set the value to emailTemplate
	 * @param emailTemplate An instance of DoubleOptinEmailTemplate
	 */
	public void setEmailTemplate(DoubleOptinEmailTemplate emailTemplate)
	{
		 this.emailTemplate = emailTemplate;

		 this.keyModified.put("email_template", 1);

	}

	/**
	 * The method to get the value of confirmPageContent
	 * @return A String representing the confirmPageContent
	 */
	public String getConfirmPageContent()
	{
		return  this.confirmPageContent;

	}

	/**
	 * The method to set the value to confirmPageContent
	 * @param confirmPageContent A String representing the confirmPageContent
	 */
	public void setConfirmPageContent(String confirmPageContent)
	{
		 this.confirmPageContent = confirmPageContent;

		 this.keyModified.put("confirm_page_content", 1);

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