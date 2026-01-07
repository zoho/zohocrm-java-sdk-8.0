package com.zoho.crm.api.webforms;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class AcknowledgeVisitor implements Model
{
	private FromAddress replyToAddress;

	private String templateName;

	private AutoResponseRule autoResponseRule;

	private String templateId;

	private FromAddress fromAddress;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of replyToAddress
	 * @return An instance of FromAddress
	 */
	public FromAddress getReplyToAddress()
	{
		return  this.replyToAddress;

	}

	/**
	 * The method to set the value to replyToAddress
	 * @param replyToAddress An instance of FromAddress
	 */
	public void setReplyToAddress(FromAddress replyToAddress)
	{
		 this.replyToAddress = replyToAddress;

		 this.keyModified.put("reply_to_address", 1);

	}

	/**
	 * The method to get the value of templateName
	 * @return A String representing the templateName
	 */
	public String getTemplateName()
	{
		return  this.templateName;

	}

	/**
	 * The method to set the value to templateName
	 * @param templateName A String representing the templateName
	 */
	public void setTemplateName(String templateName)
	{
		 this.templateName = templateName;

		 this.keyModified.put("template_name", 1);

	}

	/**
	 * The method to get the value of autoResponseRule
	 * @return An instance of AutoResponseRule
	 */
	public AutoResponseRule getAutoResponseRule()
	{
		return  this.autoResponseRule;

	}

	/**
	 * The method to set the value to autoResponseRule
	 * @param autoResponseRule An instance of AutoResponseRule
	 */
	public void setAutoResponseRule(AutoResponseRule autoResponseRule)
	{
		 this.autoResponseRule = autoResponseRule;

		 this.keyModified.put("auto_response_rule", 1);

	}

	/**
	 * The method to get the value of templateId
	 * @return A String representing the templateId
	 */
	public String getTemplateId()
	{
		return  this.templateId;

	}

	/**
	 * The method to set the value to templateId
	 * @param templateId A String representing the templateId
	 */
	public void setTemplateId(String templateId)
	{
		 this.templateId = templateId;

		 this.keyModified.put("template_id", 1);

	}

	/**
	 * The method to get the value of fromAddress
	 * @return An instance of FromAddress
	 */
	public FromAddress getFromAddress()
	{
		return  this.fromAddress;

	}

	/**
	 * The method to set the value to fromAddress
	 * @param fromAddress An instance of FromAddress
	 */
	public void setFromAddress(FromAddress fromAddress)
	{
		 this.fromAddress = fromAddress;

		 this.keyModified.put("from_address", 1);

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