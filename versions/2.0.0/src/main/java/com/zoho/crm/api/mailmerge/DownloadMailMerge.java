package com.zoho.crm.api.mailmerge;

import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class DownloadMailMerge implements Model
{
	private MailMergeTemplate mailMergeTemplate;

	private Choice<String> outputFormat;

	private String fileName;

	private String password;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of mailMergeTemplate
	 * @return An instance of MailMergeTemplate
	 */
	public MailMergeTemplate getMailMergeTemplate()
	{
		return  this.mailMergeTemplate;

	}

	/**
	 * The method to set the value to mailMergeTemplate
	 * @param mailMergeTemplate An instance of MailMergeTemplate
	 */
	public void setMailMergeTemplate(MailMergeTemplate mailMergeTemplate)
	{
		 this.mailMergeTemplate = mailMergeTemplate;

		 this.keyModified.put("mail_merge_template", 1);

	}

	/**
	 * The method to get the value of outputFormat
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getOutputFormat()
	{
		return  this.outputFormat;

	}

	/**
	 * The method to set the value to outputFormat
	 * @param outputFormat An instance of Choice<String>
	 */
	public void setOutputFormat(Choice<String> outputFormat)
	{
		 this.outputFormat = outputFormat;

		 this.keyModified.put("output_format", 1);

	}

	/**
	 * The method to get the value of fileName
	 * @return A String representing the fileName
	 */
	public String getFileName()
	{
		return  this.fileName;

	}

	/**
	 * The method to set the value to fileName
	 * @param fileName A String representing the fileName
	 */
	public void setFileName(String fileName)
	{
		 this.fileName = fileName;

		 this.keyModified.put("file_name", 1);

	}

	/**
	 * The method to get the value of password
	 * @return A String representing the password
	 */
	public String getPassword()
	{
		return  this.password;

	}

	/**
	 * The method to set the value to password
	 * @param password A String representing the password
	 */
	public void setPassword(String password)
	{
		 this.password = password;

		 this.keyModified.put("password", 1);

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