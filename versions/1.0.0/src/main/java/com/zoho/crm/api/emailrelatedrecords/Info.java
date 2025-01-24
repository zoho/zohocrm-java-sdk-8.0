package com.zoho.crm.api.emailrelatedrecords;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Info implements Model
{
	private Integer count;

	private String nextIndex;

	private String prevIndex;

	private Integer perPage;

	private Boolean moreRecords;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of count
	 * @return An Integer representing the count
	 */
	public Integer getCount()
	{
		return  this.count;

	}

	/**
	 * The method to set the value to count
	 * @param count An Integer representing the count
	 */
	public void setCount(Integer count)
	{
		 this.count = count;

		 this.keyModified.put("count", 1);

	}

	/**
	 * The method to get the value of nextIndex
	 * @return A String representing the nextIndex
	 */
	public String getNextIndex()
	{
		return  this.nextIndex;

	}

	/**
	 * The method to set the value to nextIndex
	 * @param nextIndex A String representing the nextIndex
	 */
	public void setNextIndex(String nextIndex)
	{
		 this.nextIndex = nextIndex;

		 this.keyModified.put("next_index", 1);

	}

	/**
	 * The method to get the value of prevIndex
	 * @return A String representing the prevIndex
	 */
	public String getPrevIndex()
	{
		return  this.prevIndex;

	}

	/**
	 * The method to set the value to prevIndex
	 * @param prevIndex A String representing the prevIndex
	 */
	public void setPrevIndex(String prevIndex)
	{
		 this.prevIndex = prevIndex;

		 this.keyModified.put("prev_index", 1);

	}

	/**
	 * The method to get the value of perPage
	 * @return An Integer representing the perPage
	 */
	public Integer getPerPage()
	{
		return  this.perPage;

	}

	/**
	 * The method to set the value to perPage
	 * @param perPage An Integer representing the perPage
	 */
	public void setPerPage(Integer perPage)
	{
		 this.perPage = perPage;

		 this.keyModified.put("per_page", 1);

	}

	/**
	 * The method to get the value of moreRecords
	 * @return A Boolean representing the moreRecords
	 */
	public Boolean getMoreRecords()
	{
		return  this.moreRecords;

	}

	/**
	 * The method to set the value to moreRecords
	 * @param moreRecords A Boolean representing the moreRecords
	 */
	public void setMoreRecords(Boolean moreRecords)
	{
		 this.moreRecords = moreRecords;

		 this.keyModified.put("more_records", 1);

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