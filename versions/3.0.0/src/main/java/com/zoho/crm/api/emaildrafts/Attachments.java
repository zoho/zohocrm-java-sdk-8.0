package com.zoho.crm.api.emaildrafts;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Attachments implements Model
{
	private String serviceName;

	private String fileSize;

	private String id;

	private String fileName;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of serviceName
	 * @return A String representing the serviceName
	 */
	public String getServiceName()
	{
		return  this.serviceName;

	}

	/**
	 * The method to set the value to serviceName
	 * @param serviceName A String representing the serviceName
	 */
	public void setServiceName(String serviceName)
	{
		 this.serviceName = serviceName;

		 this.keyModified.put("service_name", 1);

	}

	/**
	 * The method to get the value of fileSize
	 * @return A String representing the fileSize
	 */
	public String getFileSize()
	{
		return  this.fileSize;

	}

	/**
	 * The method to set the value to fileSize
	 * @param fileSize A String representing the fileSize
	 */
	public void setFileSize(String fileSize)
	{
		 this.fileSize = fileSize;

		 this.keyModified.put("file_size", 1);

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