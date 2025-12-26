package com.zoho.crm.api.userstransferdelete;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class TransferAndDeleteByID implements Model
{
	private Transfer transfer;

	private MoveSubordinate moveSubordinate;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of transfer
	 * @return An instance of Transfer
	 */
	public Transfer getTransfer()
	{
		return  this.transfer;

	}

	/**
	 * The method to set the value to transfer
	 * @param transfer An instance of Transfer
	 */
	public void setTransfer(Transfer transfer)
	{
		 this.transfer = transfer;

		 this.keyModified.put("transfer", 1);

	}

	/**
	 * The method to get the value of moveSubordinate
	 * @return An instance of MoveSubordinate
	 */
	public MoveSubordinate getMoveSubordinate()
	{
		return  this.moveSubordinate;

	}

	/**
	 * The method to set the value to moveSubordinate
	 * @param moveSubordinate An instance of MoveSubordinate
	 */
	public void setMoveSubordinate(MoveSubordinate moveSubordinate)
	{
		 this.moveSubordinate = moveSubordinate;

		 this.keyModified.put("move_subordinate", 1);

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