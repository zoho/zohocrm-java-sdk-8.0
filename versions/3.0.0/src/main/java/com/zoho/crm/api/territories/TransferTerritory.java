package com.zoho.crm.api.territories;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class TransferTerritory implements Model
{
	private Long id;

	private Long transferToId;

	private Boolean deletePreviousForecasts;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


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
	 * The method to get the value of transferToId
	 * @return A Long representing the transferToId
	 */
	public Long getTransferToId()
	{
		return  this.transferToId;

	}

	/**
	 * The method to set the value to transferToId
	 * @param transferToId A Long representing the transferToId
	 */
	public void setTransferToId(Long transferToId)
	{
		 this.transferToId = transferToId;

		 this.keyModified.put("transfer_to_id", 1);

	}

	/**
	 * The method to get the value of deletePreviousForecasts
	 * @return A Boolean representing the deletePreviousForecasts
	 */
	public Boolean getDeletePreviousForecasts()
	{
		return  this.deletePreviousForecasts;

	}

	/**
	 * The method to set the value to deletePreviousForecasts
	 * @param deletePreviousForecasts A Boolean representing the deletePreviousForecasts
	 */
	public void setDeletePreviousForecasts(Boolean deletePreviousForecasts)
	{
		 this.deletePreviousForecasts = deletePreviousForecasts;

		 this.keyModified.put("delete_previous_forecasts", 1);

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