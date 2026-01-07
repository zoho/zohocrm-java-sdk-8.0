package com.zoho.crm.api.wizards;

import com.zoho.crm.api.modules.Modules;
import com.zoho.crm.api.profiles.Profile;
import com.zoho.crm.api.users.MinifiedUser;
import com.zoho.crm.api.util.Model;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;

public class Wizard implements Model
{
	private OffsetDateTime createdTime;

	private OffsetDateTime modifiedTime;

	private Modules module;

	private String name;

	private MinifiedUser modifiedBy;

	private List<Profile> profiles;

	private Boolean active;

	private List<Container> containers;

	private Long id;

	private MinifiedUser createdBy;

	private List<PortalUserType> portalUserTypes;

	private List<ExemptedPortalUserType> exemptedPortalUserTypes;

	private Wizard parentWizard;

	private Boolean draft;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of createdTime
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getCreatedTime()
	{
		return  this.createdTime;

	}

	/**
	 * The method to set the value to createdTime
	 * @param createdTime An instance of OffsetDateTime
	 */
	public void setCreatedTime(OffsetDateTime createdTime)
	{
		 this.createdTime = createdTime;

		 this.keyModified.put("created_time", 1);

	}

	/**
	 * The method to get the value of modifiedTime
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getModifiedTime()
	{
		return  this.modifiedTime;

	}

	/**
	 * The method to set the value to modifiedTime
	 * @param modifiedTime An instance of OffsetDateTime
	 */
	public void setModifiedTime(OffsetDateTime modifiedTime)
	{
		 this.modifiedTime = modifiedTime;

		 this.keyModified.put("modified_time", 1);

	}

	/**
	 * The method to get the value of module
	 * @return An instance of Modules
	 */
	public Modules getModule()
	{
		return  this.module;

	}

	/**
	 * The method to set the value to module
	 * @param module An instance of Modules
	 */
	public void setModule(Modules module)
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
	 * The method to get the value of modifiedBy
	 * @return An instance of MinifiedUser
	 */
	public MinifiedUser getModifiedBy()
	{
		return  this.modifiedBy;

	}

	/**
	 * The method to set the value to modifiedBy
	 * @param modifiedBy An instance of MinifiedUser
	 */
	public void setModifiedBy(MinifiedUser modifiedBy)
	{
		 this.modifiedBy = modifiedBy;

		 this.keyModified.put("modified_by", 1);

	}

	/**
	 * The method to get the value of profiles
	 * @return An instance of List<Profile>
	 */
	public List<Profile> getProfiles()
	{
		return  this.profiles;

	}

	/**
	 * The method to set the value to profiles
	 * @param profiles An instance of List<Profile>
	 */
	public void setProfiles(List<Profile> profiles)
	{
		 this.profiles = profiles;

		 this.keyModified.put("profiles", 1);

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
	 * The method to get the value of containers
	 * @return An instance of List<Container>
	 */
	public List<Container> getContainers()
	{
		return  this.containers;

	}

	/**
	 * The method to set the value to containers
	 * @param containers An instance of List<Container>
	 */
	public void setContainers(List<Container> containers)
	{
		 this.containers = containers;

		 this.keyModified.put("containers", 1);

	}

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
	 * The method to get the value of createdBy
	 * @return An instance of MinifiedUser
	 */
	public MinifiedUser getCreatedBy()
	{
		return  this.createdBy;

	}

	/**
	 * The method to set the value to createdBy
	 * @param createdBy An instance of MinifiedUser
	 */
	public void setCreatedBy(MinifiedUser createdBy)
	{
		 this.createdBy = createdBy;

		 this.keyModified.put("created_by", 1);

	}

	/**
	 * The method to get the value of portalUserTypes
	 * @return An instance of List<PortalUserType>
	 */
	public List<PortalUserType> getPortalUserTypes()
	{
		return  this.portalUserTypes;

	}

	/**
	 * The method to set the value to portalUserTypes
	 * @param portalUserTypes An instance of List<PortalUserType>
	 */
	public void setPortalUserTypes(List<PortalUserType> portalUserTypes)
	{
		 this.portalUserTypes = portalUserTypes;

		 this.keyModified.put("portal_user_types", 1);

	}

	/**
	 * The method to get the value of exemptedPortalUserTypes
	 * @return An instance of List<ExemptedPortalUserType>
	 */
	public List<ExemptedPortalUserType> getExemptedPortalUserTypes()
	{
		return  this.exemptedPortalUserTypes;

	}

	/**
	 * The method to set the value to exemptedPortalUserTypes
	 * @param exemptedPortalUserTypes An instance of List<ExemptedPortalUserType>
	 */
	public void setExemptedPortalUserTypes(List<ExemptedPortalUserType> exemptedPortalUserTypes)
	{
		 this.exemptedPortalUserTypes = exemptedPortalUserTypes;

		 this.keyModified.put("exempted_portal_user_types", 1);

	}

	/**
	 * The method to get the value of parentWizard
	 * @return An instance of Wizard
	 */
	public Wizard getParentWizard()
	{
		return  this.parentWizard;

	}

	/**
	 * The method to set the value to parentWizard
	 * @param parentWizard An instance of Wizard
	 */
	public void setParentWizard(Wizard parentWizard)
	{
		 this.parentWizard = parentWizard;

		 this.keyModified.put("parent_wizard", 1);

	}

	/**
	 * The method to get the value of draft
	 * @return A Boolean representing the draft
	 */
	public Boolean getDraft()
	{
		return  this.draft;

	}

	/**
	 * The method to set the value to draft
	 * @param draft A Boolean representing the draft
	 */
	public void setDraft(Boolean draft)
	{
		 this.draft = draft;

		 this.keyModified.put("draft", 1);

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