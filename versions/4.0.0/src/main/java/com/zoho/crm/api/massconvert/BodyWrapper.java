package com.zoho.crm.api.massconvert;

import com.zoho.crm.api.record.Record;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class BodyWrapper implements Model
{
	private Record deals;

	private MoveAttachmentsTo moveAttachmentsTo;

	private AssignTo assignTo;

	private List<MoveAttachmentsTo> carryOverTags;

	private List<RelatedModule> relatedModules;

	private PortalUserType portalUserType;

	private List<Long> ids;

	private Boolean applyAssignmentThreshold;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


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
	 * The method to get the value of assignTo
	 * @return An instance of AssignTo
	 */
	public AssignTo getAssignTo()
	{
		return  this.assignTo;

	}

	/**
	 * The method to set the value to assignTo
	 * @param assignTo An instance of AssignTo
	 */
	public void setAssignTo(AssignTo assignTo)
	{
		 this.assignTo = assignTo;

		 this.keyModified.put("assign_to", 1);

	}

	/**
	 * The method to get the value of carryOverTags
	 * @return An instance of List<MoveAttachmentsTo>
	 */
	public List<MoveAttachmentsTo> getCarryOverTags()
	{
		return  this.carryOverTags;

	}

	/**
	 * The method to set the value to carryOverTags
	 * @param carryOverTags An instance of List<MoveAttachmentsTo>
	 */
	public void setCarryOverTags(List<MoveAttachmentsTo> carryOverTags)
	{
		 this.carryOverTags = carryOverTags;

		 this.keyModified.put("carry_over_tags", 1);

	}

	/**
	 * The method to get the value of relatedModules
	 * @return An instance of List<RelatedModule>
	 */
	public List<RelatedModule> getRelatedModules()
	{
		return  this.relatedModules;

	}

	/**
	 * The method to set the value to relatedModules
	 * @param relatedModules An instance of List<RelatedModule>
	 */
	public void setRelatedModules(List<RelatedModule> relatedModules)
	{
		 this.relatedModules = relatedModules;

		 this.keyModified.put("related_modules", 1);

	}

	/**
	 * The method to get the value of portalUserType
	 * @return An instance of PortalUserType
	 */
	public PortalUserType getPortalUserType()
	{
		return  this.portalUserType;

	}

	/**
	 * The method to set the value to portalUserType
	 * @param portalUserType An instance of PortalUserType
	 */
	public void setPortalUserType(PortalUserType portalUserType)
	{
		 this.portalUserType = portalUserType;

		 this.keyModified.put("portal_user_type", 1);

	}

	/**
	 * The method to get the value of ids
	 * @return An instance of List<Long>
	 */
	public List<Long> getIds()
	{
		return  this.ids;

	}

	/**
	 * The method to set the value to ids
	 * @param ids An instance of List<Long>
	 */
	public void setIds(List<Long> ids)
	{
		 this.ids = ids;

		 this.keyModified.put("ids", 1);

	}

	/**
	 * The method to get the value of applyAssignmentThreshold
	 * @return A Boolean representing the applyAssignmentThreshold
	 */
	public Boolean getApplyAssignmentThreshold()
	{
		return  this.applyAssignmentThreshold;

	}

	/**
	 * The method to set the value to applyAssignmentThreshold
	 * @param applyAssignmentThreshold A Boolean representing the applyAssignmentThreshold
	 */
	public void setApplyAssignmentThreshold(Boolean applyAssignmentThreshold)
	{
		 this.applyAssignmentThreshold = applyAssignmentThreshold;

		 this.keyModified.put("apply_assignment_threshold", 1);

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