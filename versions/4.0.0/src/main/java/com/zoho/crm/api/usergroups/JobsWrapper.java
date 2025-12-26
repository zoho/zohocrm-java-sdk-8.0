package com.zoho.crm.api.usergroups;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class JobsWrapper implements Model
{
	private List<Jobs> deletionJobs;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of deletionJobs
	 * @return An instance of List<Jobs>
	 */
	public List<Jobs> getDeletionJobs()
	{
		return  this.deletionJobs;

	}

	/**
	 * The method to set the value to deletionJobs
	 * @param deletionJobs An instance of List<Jobs>
	 */
	public void setDeletionJobs(List<Jobs> deletionJobs)
	{
		 this.deletionJobs = deletionJobs;

		 this.keyModified.put("deletion_jobs", 1);

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