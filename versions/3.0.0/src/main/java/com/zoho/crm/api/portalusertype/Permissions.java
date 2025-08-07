package com.zoho.crm.api.portalusertype;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Permissions implements Model
{
	private Boolean view;

	private Boolean edit;

	private Boolean editSharedRecords;

	private Boolean create;

	private Boolean delete;

	private Boolean deleteAttachment;

	private Boolean createAttachment;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of view
	 * @return A Boolean representing the view
	 */
	public Boolean getView()
	{
		return  this.view;

	}

	/**
	 * The method to set the value to view
	 * @param view A Boolean representing the view
	 */
	public void setView(Boolean view)
	{
		 this.view = view;

		 this.keyModified.put("view", 1);

	}

	/**
	 * The method to get the value of edit
	 * @return A Boolean representing the edit
	 */
	public Boolean getEdit()
	{
		return  this.edit;

	}

	/**
	 * The method to set the value to edit
	 * @param edit A Boolean representing the edit
	 */
	public void setEdit(Boolean edit)
	{
		 this.edit = edit;

		 this.keyModified.put("edit", 1);

	}

	/**
	 * The method to get the value of editSharedRecords
	 * @return A Boolean representing the editSharedRecords
	 */
	public Boolean getEditSharedRecords()
	{
		return  this.editSharedRecords;

	}

	/**
	 * The method to set the value to editSharedRecords
	 * @param editSharedRecords A Boolean representing the editSharedRecords
	 */
	public void setEditSharedRecords(Boolean editSharedRecords)
	{
		 this.editSharedRecords = editSharedRecords;

		 this.keyModified.put("edit_shared_records", 1);

	}

	/**
	 * The method to get the value of create
	 * @return A Boolean representing the create
	 */
	public Boolean getCreate()
	{
		return  this.create;

	}

	/**
	 * The method to set the value to create
	 * @param create A Boolean representing the create
	 */
	public void setCreate(Boolean create)
	{
		 this.create = create;

		 this.keyModified.put("create", 1);

	}

	/**
	 * The method to get the value of delete
	 * @return A Boolean representing the delete
	 */
	public Boolean getDelete()
	{
		return  this.delete;

	}

	/**
	 * The method to set the value to delete
	 * @param delete A Boolean representing the delete
	 */
	public void setDelete(Boolean delete)
	{
		 this.delete = delete;

		 this.keyModified.put("delete", 1);

	}

	/**
	 * The method to get the value of deleteAttachment
	 * @return A Boolean representing the deleteAttachment
	 */
	public Boolean getDeleteAttachment()
	{
		return  this.deleteAttachment;

	}

	/**
	 * The method to set the value to deleteAttachment
	 * @param deleteAttachment A Boolean representing the deleteAttachment
	 */
	public void setDeleteAttachment(Boolean deleteAttachment)
	{
		 this.deleteAttachment = deleteAttachment;

		 this.keyModified.put("delete_attachment", 1);

	}

	/**
	 * The method to get the value of createAttachment
	 * @return A Boolean representing the createAttachment
	 */
	public Boolean getCreateAttachment()
	{
		return  this.createAttachment;

	}

	/**
	 * The method to set the value to createAttachment
	 * @param createAttachment A Boolean representing the createAttachment
	 */
	public void setCreateAttachment(Boolean createAttachment)
	{
		 this.createAttachment = createAttachment;

		 this.keyModified.put("create_attachment", 1);

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