package com.zoho.crm.api.reschedulehistory;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Approval implements Model
{
	private Boolean delegate;

	private Boolean approve;

	private Boolean reject;

	private Boolean resubmit;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of delegate
	 * @return A Boolean representing the delegate
	 */
	public Boolean getDelegate()
	{
		return  this.delegate;

	}

	/**
	 * The method to set the value to delegate
	 * @param delegate A Boolean representing the delegate
	 */
	public void setDelegate(Boolean delegate)
	{
		 this.delegate = delegate;

		 this.keyModified.put("delegate", 1);

	}

	/**
	 * The method to get the value of approve
	 * @return A Boolean representing the approve
	 */
	public Boolean getApprove()
	{
		return  this.approve;

	}

	/**
	 * The method to set the value to approve
	 * @param approve A Boolean representing the approve
	 */
	public void setApprove(Boolean approve)
	{
		 this.approve = approve;

		 this.keyModified.put("approve", 1);

	}

	/**
	 * The method to get the value of reject
	 * @return A Boolean representing the reject
	 */
	public Boolean getReject()
	{
		return  this.reject;

	}

	/**
	 * The method to set the value to reject
	 * @param reject A Boolean representing the reject
	 */
	public void setReject(Boolean reject)
	{
		 this.reject = reject;

		 this.keyModified.put("reject", 1);

	}

	/**
	 * The method to get the value of resubmit
	 * @return A Boolean representing the resubmit
	 */
	public Boolean getResubmit()
	{
		return  this.resubmit;

	}

	/**
	 * The method to set the value to resubmit
	 * @param resubmit A Boolean representing the resubmit
	 */
	public void setResubmit(Boolean resubmit)
	{
		 this.resubmit = resubmit;

		 this.keyModified.put("resubmit", 1);

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