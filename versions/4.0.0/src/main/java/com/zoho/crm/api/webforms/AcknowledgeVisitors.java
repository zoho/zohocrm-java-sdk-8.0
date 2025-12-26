package com.zoho.crm.api.webforms;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class AcknowledgeVisitors implements Model
{
	private String templateName;

	private Long templateId;

	private FromAddress fromAddress;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


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
	 * The method to get the value of templateId
	 * @return A Long representing the templateId
	 */
	public Long getTemplateId()
	{
		return  this.templateId;

	}

	/**
	 * The method to set the value to templateId
	 * @param templateId A Long representing the templateId
	 */
	public void setTemplateId(Long templateId)
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