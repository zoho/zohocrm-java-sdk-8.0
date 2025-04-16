package com.zoho.crm.api.getrelatedrecordscount;

import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Params implements Model
{
	private Boolean approved;

	private Boolean converted;

	private Boolean associated;

	private Choice<String> category;

	private Choice<String> approvalState;

	private Filters filters;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of approved
	 * @return A Boolean representing the approved
	 */
	public Boolean getApproved()
	{
		return  this.approved;

	}

	/**
	 * The method to set the value to approved
	 * @param approved A Boolean representing the approved
	 */
	public void setApproved(Boolean approved)
	{
		 this.approved = approved;

		 this.keyModified.put("approved", 1);

	}

	/**
	 * The method to get the value of converted
	 * @return A Boolean representing the converted
	 */
	public Boolean getConverted()
	{
		return  this.converted;

	}

	/**
	 * The method to set the value to converted
	 * @param converted A Boolean representing the converted
	 */
	public void setConverted(Boolean converted)
	{
		 this.converted = converted;

		 this.keyModified.put("converted", 1);

	}

	/**
	 * The method to get the value of associated
	 * @return A Boolean representing the associated
	 */
	public Boolean getAssociated()
	{
		return  this.associated;

	}

	/**
	 * The method to set the value to associated
	 * @param associated A Boolean representing the associated
	 */
	public void setAssociated(Boolean associated)
	{
		 this.associated = associated;

		 this.keyModified.put("associated", 1);

	}

	/**
	 * The method to get the value of category
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getCategory()
	{
		return  this.category;

	}

	/**
	 * The method to set the value to category
	 * @param category An instance of Choice<String>
	 */
	public void setCategory(Choice<String> category)
	{
		 this.category = category;

		 this.keyModified.put("category", 1);

	}

	/**
	 * The method to get the value of approvalState
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getApprovalState()
	{
		return  this.approvalState;

	}

	/**
	 * The method to set the value to approvalState
	 * @param approvalState An instance of Choice<String>
	 */
	public void setApprovalState(Choice<String> approvalState)
	{
		 this.approvalState = approvalState;

		 this.keyModified.put("approval_state", 1);

	}

	/**
	 * The method to get the value of filters
	 * @return An instance of Filters
	 */
	public Filters getFilters()
	{
		return  this.filters;

	}

	/**
	 * The method to set the value to filters
	 * @param filters An instance of Filters
	 */
	public void setFilters(Filters filters)
	{
		 this.filters = filters;

		 this.keyModified.put("filters", 1);

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