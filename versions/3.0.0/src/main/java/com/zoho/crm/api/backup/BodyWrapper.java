package com.zoho.crm.api.backup;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class BodyWrapper implements Model
{
	private Backup backup;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of backup
	 * @return An instance of Backup
	 */
	public Backup getBackup()
	{
		return  this.backup;

	}

	/**
	 * The method to set the value to backup
	 * @param backup An instance of Backup
	 */
	public void setBackup(Backup backup)
	{
		 this.backup = backup;

		 this.keyModified.put("backup", 1);

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