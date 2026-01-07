package com.zoho.crm.api.usertypeusers;

import com.zoho.crm.api.util.Model;
import java.time.OffsetDateTime;
import java.util.HashMap;

public class Users implements Model
{
	private Long personalityId;

	private Boolean confirm;

	private String statusReasonS;

	private OffsetDateTime invitedTime;

	private String module;

	private String name;

	private Boolean active;

	private String email;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of personalityId
	 * @return A Long representing the personalityId
	 */
	public Long getPersonalityId()
	{
		return  this.personalityId;

	}

	/**
	 * The method to set the value to personalityId
	 * @param personalityId A Long representing the personalityId
	 */
	public void setPersonalityId(Long personalityId)
	{
		 this.personalityId = personalityId;

		 this.keyModified.put("personality_id", 1);

	}

	/**
	 * The method to get the value of confirm
	 * @return A Boolean representing the confirm
	 */
	public Boolean getConfirm()
	{
		return  this.confirm;

	}

	/**
	 * The method to set the value to confirm
	 * @param confirm A Boolean representing the confirm
	 */
	public void setConfirm(Boolean confirm)
	{
		 this.confirm = confirm;

		 this.keyModified.put("confirm", 1);

	}

	/**
	 * The method to get the value of statusReasonS
	 * @return A String representing the statusReasonS
	 */
	public String getStatusReasonS()
	{
		return  this.statusReasonS;

	}

	/**
	 * The method to set the value to statusReasonS
	 * @param statusReasonS A String representing the statusReasonS
	 */
	public void setStatusReasonS(String statusReasonS)
	{
		 this.statusReasonS = statusReasonS;

		 this.keyModified.put("status_reason__s", 1);

	}

	/**
	 * The method to get the value of invitedTime
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getInvitedTime()
	{
		return  this.invitedTime;

	}

	/**
	 * The method to set the value to invitedTime
	 * @param invitedTime An instance of OffsetDateTime
	 */
	public void setInvitedTime(OffsetDateTime invitedTime)
	{
		 this.invitedTime = invitedTime;

		 this.keyModified.put("invited_time", 1);

	}

	/**
	 * The method to get the value of module
	 * @return A String representing the module
	 */
	public String getModule()
	{
		return  this.module;

	}

	/**
	 * The method to set the value to module
	 * @param module A String representing the module
	 */
	public void setModule(String module)
	{
		 this.module = module;

		 this.keyModified.put("module", 1);

	}

	/**
	 * The method to get the value of name
	 * @return A String representing the name
	 */
	public String getName()
	{
		return  this.name;

	}

	/**
	 * The method to set the value to name
	 * @param name A String representing the name
	 */
	public void setName(String name)
	{
		 this.name = name;

		 this.keyModified.put("name", 1);

	}

	/**
	 * The method to get the value of active
	 * @return A Boolean representing the active
	 */
	public Boolean getActive()
	{
		return  this.active;

	}

	/**
	 * The method to set the value to active
	 * @param active A Boolean representing the active
	 */
	public void setActive(Boolean active)
	{
		 this.active = active;

		 this.keyModified.put("active", 1);

	}

	/**
	 * The method to get the value of email
	 * @return A String representing the email
	 */
	public String getEmail()
	{
		return  this.email;

	}

	/**
	 * The method to set the value to email
	 * @param email A String representing the email
	 */
	public void setEmail(String email)
	{
		 this.email = email;

		 this.keyModified.put("email", 1);

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