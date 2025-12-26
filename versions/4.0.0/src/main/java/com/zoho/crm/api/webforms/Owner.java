package com.zoho.crm.api.webforms;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.Map;

public class Owner implements Model
{
	private String name;

	private String id;

	private Boolean systemMail;

	private Map<String, Object> emailTemplate;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of name
	 * @return A String representing the name
	 */
	public String getName()
	{
		return  this.name;

	}

	/**
	 * The method to set the value to name
	 * @param name A String representing the name
	 */
	public void setName(String name)
	{
		 this.name = name;

		 this.keyModified.put("name", 1);

	}

	/**
	 * The method to get the value of id
	 * @return A String representing the id
	 */
	public String getId()
	{
		return  this.id;

	}

	/**
	 * The method to set the value to id
	 * @param id A String representing the id
	 */
	public void setId(String id)
	{
		 this.id = id;

		 this.keyModified.put("id", 1);

	}

	/**
	 * The method to get the value of systemMail
	 * @return A Boolean representing the systemMail
	 */
	public Boolean getSystemMail()
	{
		return  this.systemMail;

	}

	/**
	 * The method to set the value to systemMail
	 * @param systemMail A Boolean representing the systemMail
	 */
	public void setSystemMail(Boolean systemMail)
	{
		 this.systemMail = systemMail;

		 this.keyModified.put("system_mail", 1);

	}

	/**
	 * The method to get the value of emailTemplate
	 * @return An instance of Map<String,Object>
	 */
	public Map<String, Object> getEmailTemplate()
	{
		return  this.emailTemplate;

	}

	/**
	 * The method to set the value to emailTemplate
	 * @param emailTemplate An instance of Map<String,Object>
	 */
	public void setEmailTemplate(Map<String, Object> emailTemplate)
	{
		 this.emailTemplate = emailTemplate;

		 this.keyModified.put("email_template", 1);

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