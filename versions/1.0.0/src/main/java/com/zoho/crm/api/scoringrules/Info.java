package com.zoho.crm.api.scoringrules;

import com.zoho.crm.api.util.Model;
import java.time.OffsetDateTime;
import java.util.HashMap;

public class Info implements Model
{
	private Boolean call;

	private Integer perPage;

	private String nextPageToken;

	private Integer count;

	private Integer page;

	private String previousPageToken;

	private OffsetDateTime pageTokenExpiry;

	private Boolean email;

	private Boolean moreRecords;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of call
	 * @return A Boolean representing the call
	 */
	public Boolean getCall()
	{
		return  this.call;

	}

	/**
	 * The method to set the value to call
	 * @param call A Boolean representing the call
	 */
	public void setCall(Boolean call)
	{
		 this.call = call;

		 this.keyModified.put("call", 1);

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
	 * The method to get the value of nextPageToken
	 * @return A String representing the nextPageToken
	 */
	public String getNextPageToken()
	{
		return  this.nextPageToken;

	}

	/**
	 * The method to set the value to nextPageToken
	 * @param nextPageToken A String representing the nextPageToken
	 */
	public void setNextPageToken(String nextPageToken)
	{
		 this.nextPageToken = nextPageToken;

		 this.keyModified.put("next_page_token", 1);

	}

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
	 * The method to get the value of page
	 * @return An Integer representing the page
	 */
	public Integer getPage()
	{
		return  this.page;

	}

	/**
	 * The method to set the value to page
	 * @param page An Integer representing the page
	 */
	public void setPage(Integer page)
	{
		 this.page = page;

		 this.keyModified.put("page", 1);

	}

	/**
	 * The method to get the value of previousPageToken
	 * @return A String representing the previousPageToken
	 */
	public String getPreviousPageToken()
	{
		return  this.previousPageToken;

	}

	/**
	 * The method to set the value to previousPageToken
	 * @param previousPageToken A String representing the previousPageToken
	 */
	public void setPreviousPageToken(String previousPageToken)
	{
		 this.previousPageToken = previousPageToken;

		 this.keyModified.put("previous_page_token", 1);

	}

	/**
	 * The method to get the value of pageTokenExpiry
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getPageTokenExpiry()
	{
		return  this.pageTokenExpiry;

	}

	/**
	 * The method to set the value to pageTokenExpiry
	 * @param pageTokenExpiry An instance of OffsetDateTime
	 */
	public void setPageTokenExpiry(OffsetDateTime pageTokenExpiry)
	{
		 this.pageTokenExpiry = pageTokenExpiry;

		 this.keyModified.put("page_token_expiry", 1);

	}

	/**
	 * The method to get the value of email
	 * @return A Boolean representing the email
	 */
	public Boolean getEmail()
	{
		return  this.email;

	}

	/**
	 * The method to set the value to email
	 * @param email A Boolean representing the email
	 */
	public void setEmail(Boolean email)
	{
		 this.email = email;

		 this.keyModified.put("email", 1);

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