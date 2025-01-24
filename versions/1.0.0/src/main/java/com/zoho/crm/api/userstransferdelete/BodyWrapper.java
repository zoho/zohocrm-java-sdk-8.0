package com.zoho.crm.api.userstransferdelete;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class BodyWrapper implements Model
{
	private List<TransferAndDelete> transferAndDelete;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of transferAndDelete
	 * @return An instance of List<TransferAndDelete>
	 */
	public List<TransferAndDelete> getTransferAndDelete()
	{
		return  this.transferAndDelete;

	}

	/**
	 * The method to set the value to transferAndDelete
	 * @param transferAndDelete An instance of List<TransferAndDelete>
	 */
	public void setTransferAndDelete(List<TransferAndDelete> transferAndDelete)
	{
		 this.transferAndDelete = transferAndDelete;

		 this.keyModified.put("transfer_and_delete", 1);

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