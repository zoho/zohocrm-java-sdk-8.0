package com.zoho.crm.api.webforms;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class AcknowledgeVisitor implements Model
{
	private AutoResponseRule autoResponseRule;

	private Long templateId;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


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