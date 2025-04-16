package com.zoho.crm.api.layouts;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class ActionsAllowed implements Model
{
	private Boolean edit;

	private Boolean rename;

	private Boolean clone;

	private Boolean downgrade;

	private Boolean delete;

	private Boolean deactivate;

	private Boolean setLayoutPermissions;

	private Boolean addField;

	private Boolean changeTabTraversal;

	private Boolean reorder;

	private Boolean removeField;

	private Boolean changeColumnCount;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


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
	 * The method to get the value of rename
	 * @return A Boolean representing the rename
	 */
	public Boolean getRename()
	{
		return  this.rename;

	}

	/**
	 * The method to set the value to rename
	 * @param rename A Boolean representing the rename
	 */
	public void setRename(Boolean rename)
	{
		 this.rename = rename;

		 this.keyModified.put("rename", 1);

	}

	/**
	 * The method to get the value of clone
	 * @return A Boolean representing the clone
	 */
	public Boolean getClone()
	{
		return  this.clone;

	}

	/**
	 * The method to set the value to clone
	 * @param clone A Boolean representing the clone
	 */
	public void setClone(Boolean clone)
	{
		 this.clone = clone;

		 this.keyModified.put("clone", 1);

	}

	/**
	 * The method to get the value of downgrade
	 * @return A Boolean representing the downgrade
	 */
	public Boolean getDowngrade()
	{
		return  this.downgrade;

	}

	/**
	 * The method to set the value to downgrade
	 * @param downgrade A Boolean representing the downgrade
	 */
	public void setDowngrade(Boolean downgrade)
	{
		 this.downgrade = downgrade;

		 this.keyModified.put("downgrade", 1);

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
	 * The method to get the value of deactivate
	 * @return A Boolean representing the deactivate
	 */
	public Boolean getDeactivate()
	{
		return  this.deactivate;

	}

	/**
	 * The method to set the value to deactivate
	 * @param deactivate A Boolean representing the deactivate
	 */
	public void setDeactivate(Boolean deactivate)
	{
		 this.deactivate = deactivate;

		 this.keyModified.put("deactivate", 1);

	}

	/**
	 * The method to get the value of setLayoutPermissions
	 * @return A Boolean representing the setLayoutPermissions
	 */
	public Boolean getSetLayoutPermissions()
	{
		return  this.setLayoutPermissions;

	}

	/**
	 * The method to set the value to setLayoutPermissions
	 * @param setLayoutPermissions A Boolean representing the setLayoutPermissions
	 */
	public void setSetLayoutPermissions(Boolean setLayoutPermissions)
	{
		 this.setLayoutPermissions = setLayoutPermissions;

		 this.keyModified.put("set_layout_permissions", 1);

	}

	/**
	 * The method to get the value of addField
	 * @return A Boolean representing the addField
	 */
	public Boolean getAddField()
	{
		return  this.addField;

	}

	/**
	 * The method to set the value to addField
	 * @param addField A Boolean representing the addField
	 */
	public void setAddField(Boolean addField)
	{
		 this.addField = addField;

		 this.keyModified.put("add_field", 1);

	}

	/**
	 * The method to get the value of changeTabTraversal
	 * @return A Boolean representing the changeTabTraversal
	 */
	public Boolean getChangeTabTraversal()
	{
		return  this.changeTabTraversal;

	}

	/**
	 * The method to set the value to changeTabTraversal
	 * @param changeTabTraversal A Boolean representing the changeTabTraversal
	 */
	public void setChangeTabTraversal(Boolean changeTabTraversal)
	{
		 this.changeTabTraversal = changeTabTraversal;

		 this.keyModified.put("change_tab_traversal", 1);

	}

	/**
	 * The method to get the value of reorder
	 * @return A Boolean representing the reorder
	 */
	public Boolean getReorder()
	{
		return  this.reorder;

	}

	/**
	 * The method to set the value to reorder
	 * @param reorder A Boolean representing the reorder
	 */
	public void setReorder(Boolean reorder)
	{
		 this.reorder = reorder;

		 this.keyModified.put("reorder", 1);

	}

	/**
	 * The method to get the value of removeField
	 * @return A Boolean representing the removeField
	 */
	public Boolean getRemoveField()
	{
		return  this.removeField;

	}

	/**
	 * The method to set the value to removeField
	 * @param removeField A Boolean representing the removeField
	 */
	public void setRemoveField(Boolean removeField)
	{
		 this.removeField = removeField;

		 this.keyModified.put("remove_field", 1);

	}

	/**
	 * The method to get the value of changeColumnCount
	 * @return A Boolean representing the changeColumnCount
	 */
	public Boolean getChangeColumnCount()
	{
		return  this.changeColumnCount;

	}

	/**
	 * The method to set the value to changeColumnCount
	 * @param changeColumnCount A Boolean representing the changeColumnCount
	 */
	public void setChangeColumnCount(Boolean changeColumnCount)
	{
		 this.changeColumnCount = changeColumnCount;

		 this.keyModified.put("change_column_count", 1);

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