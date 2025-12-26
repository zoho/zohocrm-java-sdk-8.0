package com.zoho.crm.api.emailtemplates;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Attachment implements Model
{
	private Long size;

	private String fileName;

	private String fileId;

	private Long id;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of size
	 * @return A Long representing the size
	 */
	public Long getSize()
	{
		return  this.size;

	}

	/**
	 * The method to set the value to size
	 * @param size A Long representing the size
	 */
	public void setSize(Long size)
	{
		 this.size = size;

		 this.keyModified.put("size", 1);

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
	 * The method to get the value of fileId
	 * @return A String representing the fileId
	 */
	public String getFileId()
	{
		return  this.fileId;

	}

	/**
	 * The method to set the value to fileId
	 * @param fileId A String representing the fileId
	 */
	public void setFileId(String fileId)
	{
		 this.fileId = fileId;

		 this.keyModified.put("file_id", 1);

	}

	/**
	 * The method to get the value of id
	 * @return A Long representing the id
	 */
	public Long getId()
	{
		return  this.id;

	}

	/**
	 * The method to set the value to id
	 * @param id A Long representing the id
	 */
	public void setId(Long id)
	{
		 this.id = id;

		 this.keyModified.put("id", 1);

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