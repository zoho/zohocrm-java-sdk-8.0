package com.zoho.crm.api.shifthours;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class ShiftCount implements Model
{
	private Integer totalShiftWithUser;

	private Integer totalShift;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of totalShiftWithUser
	 * @return An Integer representing the totalShiftWithUser
	 */
	public Integer getTotalShiftWithUser()
	{
		return  this.totalShiftWithUser;

	}

	/**
	 * The method to set the value to totalShiftWithUser
	 * @param totalShiftWithUser An Integer representing the totalShiftWithUser
	 */
	public void setTotalShiftWithUser(Integer totalShiftWithUser)
	{
		 this.totalShiftWithUser = totalShiftWithUser;

		 this.keyModified.put("total_shift_with_user", 1);

	}

	/**
	 * The method to get the value of totalShift
	 * @return An Integer representing the totalShift
	 */
	public Integer getTotalShift()
	{
		return  this.totalShift;

	}

	/**
	 * The method to set the value to totalShift
	 * @param totalShift An Integer representing the totalShift
	 */
	public void setTotalShift(Integer totalShift)
	{
		 this.totalShift = totalShift;

		 this.keyModified.put("total_shift", 1);

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