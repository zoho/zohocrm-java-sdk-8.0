package com.zoho.crm.api.attachments;

import com.zoho.crm.api.users.MinifiedUser;
import com.zoho.crm.api.util.Model;
import java.time.OffsetDateTime;
import java.util.HashMap;

public class Attachment implements Model
{
	private MinifiedUser owner;

	private MinifiedUser modifiedBy;

	private MinifiedUser createdBy;

	private ParentId parentId;

	private String sharingPermission;

	private String recordStatusS;

	private Integer attachmentType;

	private Long id;

	private OffsetDateTime modifiedTime;

	private OffsetDateTime createdTime;

	private String fileName;

	private String size;

	private Boolean editable;

	private String fileId;

	private String type;

	private String seModule;

	private String state;

	private String linkUrl;

	private String attachmentSourceS;

	private String fileIdS;

	private String fieldStates;

	private String ziaVisions;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of owner
	 * @return An instance of MinifiedUser
	 */
	public MinifiedUser getOwner()
	{
		return  this.owner;

	}

	/**
	 * The method to set the value to owner
	 * @param owner An instance of MinifiedUser
	 */
	public void setOwner(MinifiedUser owner)
	{
		 this.owner = owner;

		 this.keyModified.put("Owner", 1);

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

		 this.keyModified.put("Modified_By", 1);

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

		 this.keyModified.put("Created_By", 1);

	}

	/**
	 * The method to get the value of parentId
	 * @return An instance of ParentId
	 */
	public ParentId getParentId()
	{
		return  this.parentId;

	}

	/**
	 * The method to set the value to parentId
	 * @param parentId An instance of ParentId
	 */
	public void setParentId(ParentId parentId)
	{
		 this.parentId = parentId;

		 this.keyModified.put("Parent_Id", 1);

	}

	/**
	 * The method to get the value of sharingPermission
	 * @return A String representing the sharingPermission
	 */
	public String getSharingPermission()
	{
		return  this.sharingPermission;

	}

	/**
	 * The method to set the value to sharingPermission
	 * @param sharingPermission A String representing the sharingPermission
	 */
	public void setSharingPermission(String sharingPermission)
	{
		 this.sharingPermission = sharingPermission;

		 this.keyModified.put("$sharing_permission", 1);

	}

	/**
	 * The method to get the value of recordStatusS
	 * @return A String representing the recordStatusS
	 */
	public String getRecordStatusS()
	{
		return  this.recordStatusS;

	}

	/**
	 * The method to set the value to recordStatusS
	 * @param recordStatusS A String representing the recordStatusS
	 */
	public void setRecordStatusS(String recordStatusS)
	{
		 this.recordStatusS = recordStatusS;

		 this.keyModified.put("Record_Status__s", 1);

	}

	/**
	 * The method to get the value of attachmentType
	 * @return An Integer representing the attachmentType
	 */
	public Integer getAttachmentType()
	{
		return  this.attachmentType;

	}

	/**
	 * The method to set the value to attachmentType
	 * @param attachmentType An Integer representing the attachmentType
	 */
	public void setAttachmentType(Integer attachmentType)
	{
		 this.attachmentType = attachmentType;

		 this.keyModified.put("$attachment_type", 1);

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

		 this.keyModified.put("Modified_Time", 1);

	}

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

		 this.keyModified.put("Created_Time", 1);

	}

	/**
	 * The method to get the value of fileName
	 * @return A String representing the fileName
	 */
	public String getFileName()
	{
		return  this.fileName;

	}

	/**
	 * The method to set the value to fileName
	 * @param fileName A String representing the fileName
	 */
	public void setFileName(String fileName)
	{
		 this.fileName = fileName;

		 this.keyModified.put("File_Name", 1);

	}

	/**
	 * The method to get the value of size
	 * @return A String representing the size
	 */
	public String getSize()
	{
		return  this.size;

	}

	/**
	 * The method to set the value to size
	 * @param size A String representing the size
	 */
	public void setSize(String size)
	{
		 this.size = size;

		 this.keyModified.put("Size", 1);

	}

	/**
	 * The method to get the value of editable
	 * @return A Boolean representing the editable
	 */
	public Boolean getEditable()
	{
		return  this.editable;

	}

	/**
	 * The method to set the value to editable
	 * @param editable A Boolean representing the editable
	 */
	public void setEditable(Boolean editable)
	{
		 this.editable = editable;

		 this.keyModified.put("$editable", 1);

	}

	/**
	 * The method to get the value of fileId
	 * @return A String representing the fileId
	 */
	public String getFileId()
	{
		return  this.fileId;

	}

	/**
	 * The method to set the value to fileId
	 * @param fileId A String representing the fileId
	 */
	public void setFileId(String fileId)
	{
		 this.fileId = fileId;

		 this.keyModified.put("$file_id", 1);

	}

	/**
	 * The method to get the value of type
	 * @return A String representing the type
	 */
	public String getType()
	{
		return  this.type;

	}

	/**
	 * The method to set the value to type
	 * @param type A String representing the type
	 */
	public void setType(String type)
	{
		 this.type = type;

		 this.keyModified.put("$type", 1);

	}

	/**
	 * The method to get the value of seModule
	 * @return A String representing the seModule
	 */
	public String getSeModule()
	{
		return  this.seModule;

	}

	/**
	 * The method to set the value to seModule
	 * @param seModule A String representing the seModule
	 */
	public void setSeModule(String seModule)
	{
		 this.seModule = seModule;

		 this.keyModified.put("$se_module", 1);

	}

	/**
	 * The method to get the value of state
	 * @return A String representing the state
	 */
	public String getState()
	{
		return  this.state;

	}

	/**
	 * The method to set the value to state
	 * @param state A String representing the state
	 */
	public void setState(String state)
	{
		 this.state = state;

		 this.keyModified.put("$state", 1);

	}

	/**
	 * The method to get the value of linkUrl
	 * @return A String representing the linkUrl
	 */
	public String getLinkUrl()
	{
		return  this.linkUrl;

	}

	/**
	 * The method to set the value to linkUrl
	 * @param linkUrl A String representing the linkUrl
	 */
	public void setLinkUrl(String linkUrl)
	{
		 this.linkUrl = linkUrl;

		 this.keyModified.put("$link_url", 1);

	}

	/**
	 * The method to get the value of attachmentSourceS
	 * @return A String representing the attachmentSourceS
	 */
	public String getAttachmentSourceS()
	{
		return  this.attachmentSourceS;

	}

	/**
	 * The method to set the value to attachmentSourceS
	 * @param attachmentSourceS A String representing the attachmentSourceS
	 */
	public void setAttachmentSourceS(String attachmentSourceS)
	{
		 this.attachmentSourceS = attachmentSourceS;

		 this.keyModified.put("Attachment_Source__s", 1);

	}

	/**
	 * The method to get the value of fileIdS
	 * @return A String representing the fileIdS
	 */
	public String getFileIdS()
	{
		return  this.fileIdS;

	}

	/**
	 * The method to set the value to fileIdS
	 * @param fileIdS A String representing the fileIdS
	 */
	public void setFileIdS(String fileIdS)
	{
		 this.fileIdS = fileIdS;

		 this.keyModified.put("File_Id__s", 1);

	}

	/**
	 * The method to get the value of fieldStates
	 * @return A String representing the fieldStates
	 */
	public String getFieldStates()
	{
		return  this.fieldStates;

	}

	/**
	 * The method to set the value to fieldStates
	 * @param fieldStates A String representing the fieldStates
	 */
	public void setFieldStates(String fieldStates)
	{
		 this.fieldStates = fieldStates;

		 this.keyModified.put("$field_states", 1);

	}

	/**
	 * The method to get the value of ziaVisions
	 * @return A String representing the ziaVisions
	 */
	public String getZiaVisions()
	{
		return  this.ziaVisions;

	}

	/**
	 * The method to set the value to ziaVisions
	 * @param ziaVisions A String representing the ziaVisions
	 */
	public void setZiaVisions(String ziaVisions)
	{
		 this.ziaVisions = ziaVisions;

		 this.keyModified.put("$zia_visions", 1);

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