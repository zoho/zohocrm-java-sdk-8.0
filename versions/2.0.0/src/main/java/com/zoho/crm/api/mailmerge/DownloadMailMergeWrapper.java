package com.zoho.crm.api.mailmerge;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class DownloadMailMergeWrapper implements Model
{
	private List<DownloadMailMerge> downloadMailMerge;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of downloadMailMerge
	 * @return An instance of List<DownloadMailMerge>
	 */
	public List<DownloadMailMerge> getDownloadMailMerge()
	{
		return  this.downloadMailMerge;

	}

	/**
	 * The method to set the value to downloadMailMerge
	 * @param downloadMailMerge An instance of List<DownloadMailMerge>
	 */
	public void setDownloadMailMerge(List<DownloadMailMerge> downloadMailMerge)
	{
		 this.downloadMailMerge = downloadMailMerge;

		 this.keyModified.put("download_mail_merge", 1);

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