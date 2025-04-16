package com.zoho.crm.api.convertlead;

import com.zoho.crm.api.record.Record;
import com.zoho.crm.api.users.MinifiedUser;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class LeadConverter implements Model
{
	private Boolean overwrite;

	private Boolean notifyLeadOwner;

	private Boolean notifyNewEntityOwner;

	private MoveAttachmentsTo moveAttachmentsTo;

	private Record accounts;

	private Record contacts;

	private MinifiedUser assignTo;

	private Record deals;

	private Choice<Boolean> addToExistingRecord;

	private CarryOverTags carryOverTags;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of overwrite
	 * @return A Boolean representing the overwrite
	 */
	public Boolean getOverwrite()
	{
		return  this.overwrite;

	}

	/**
	 * The method to set the value to overwrite
	 * @param overwrite A Boolean representing the overwrite
	 */
	public void setOverwrite(Boolean overwrite)
	{
		 this.overwrite = overwrite;

		 this.keyModified.put("overwrite", 1);

	}

	/**
	 * The method to get the value of notifyLeadOwner
	 * @return A Boolean representing the notifyLeadOwner
	 */
	public Boolean getNotifyLeadOwner()
	{
		return  this.notifyLeadOwner;

	}

	/**
	 * The method to set the value to notifyLeadOwner
	 * @param notifyLeadOwner A Boolean representing the notifyLeadOwner
	 */
	public void setNotifyLeadOwner(Boolean notifyLeadOwner)
	{
		 this.notifyLeadOwner = notifyLeadOwner;

		 this.keyModified.put("notify_lead_owner", 1);

	}

	/**
	 * The method to get the value of notifyNewEntityOwner
	 * @return A Boolean representing the notifyNewEntityOwner
	 */
	public Boolean getNotifyNewEntityOwner()
	{
		return  this.notifyNewEntityOwner;

	}

	/**
	 * The method to set the value to notifyNewEntityOwner
	 * @param notifyNewEntityOwner A Boolean representing the notifyNewEntityOwner
	 */
	public void setNotifyNewEntityOwner(Boolean notifyNewEntityOwner)
	{
		 this.notifyNewEntityOwner = notifyNewEntityOwner;

		 this.keyModified.put("notify_new_entity_owner", 1);

	}

	/**
	 * The method to get the value of moveAttachmentsTo
	 * @return An instance of MoveAttachmentsTo
	 */
	public MoveAttachmentsTo getMoveAttachmentsTo()
	{
		return  this.moveAttachmentsTo;

	}

	/**
	 * The method to set the value to moveAttachmentsTo
	 * @param moveAttachmentsTo An instance of MoveAttachmentsTo
	 */
	public void setMoveAttachmentsTo(MoveAttachmentsTo moveAttachmentsTo)
	{
		 this.moveAttachmentsTo = moveAttachmentsTo;

		 this.keyModified.put("move_attachments_to", 1);

	}

	/**
	 * The method to get the value of accounts
	 * @return An instance of Record
	 */
	public Record getAccounts()
	{
		return  this.accounts;

	}

	/**
	 * The method to set the value to accounts
	 * @param accounts An instance of Record
	 */
	public void setAccounts(Record accounts)
	{
		 this.accounts = accounts;

		 this.keyModified.put("Accounts", 1);

	}

	/**
	 * The method to get the value of contacts
	 * @return An instance of Record
	 */
	public Record getContacts()
	{
		return  this.contacts;

	}

	/**
	 * The method to set the value to contacts
	 * @param contacts An instance of Record
	 */
	public void setContacts(Record contacts)
	{
		 this.contacts = contacts;

		 this.keyModified.put("Contacts", 1);

	}

	/**
	 * The method to get the value of assignTo
	 * @return An instance of MinifiedUser
	 */
	public MinifiedUser getAssignTo()
	{
		return  this.assignTo;

	}

	/**
	 * The method to set the value to assignTo
	 * @param assignTo An instance of MinifiedUser
	 */
	public void setAssignTo(MinifiedUser assignTo)
	{
		 this.assignTo = assignTo;

		 this.keyModified.put("assign_to", 1);

	}

	/**
	 * The method to get the value of deals
	 * @return An instance of Record
	 */
	public Record getDeals()
	{
		return  this.deals;

	}

	/**
	 * The method to set the value to deals
	 * @param deals An instance of Record
	 */
	public void setDeals(Record deals)
	{
		 this.deals = deals;

		 this.keyModified.put("Deals", 1);

	}

	/**
	 * The method to get the value of addToExistingRecord
	 * @return An instance of Choice<Boolean>
	 */
	public Choice<Boolean> getAddToExistingRecord()
	{
		return  this.addToExistingRecord;

	}

	/**
	 * The method to set the value to addToExistingRecord
	 * @param addToExistingRecord An instance of Choice<Boolean>
	 */
	public void setAddToExistingRecord(Choice<Boolean> addToExistingRecord)
	{
		 this.addToExistingRecord = addToExistingRecord;

		 this.keyModified.put("add_to_existing_record", 1);

	}

	/**
	 * The method to get the value of carryOverTags
	 * @return An instance of CarryOverTags
	 */
	public CarryOverTags getCarryOverTags()
	{
		return  this.carryOverTags;

	}

	/**
	 * The method to set the value to carryOverTags
	 * @param carryOverTags An instance of CarryOverTags
	 */
	public void setCarryOverTags(CarryOverTags carryOverTags)
	{
		 this.carryOverTags = carryOverTags;

		 this.keyModified.put("carry_over_tags", 1);

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