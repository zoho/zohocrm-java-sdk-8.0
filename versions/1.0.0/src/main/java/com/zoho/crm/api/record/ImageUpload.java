package com.zoho.crm.api.record;

import com.zoho.crm.api.users.MinifiedUser;
import com.zoho.crm.api.util.Model;
import java.time.OffsetDateTime;
import java.util.HashMap;

public class ImageUpload implements Model
{
	private String previewIdS;

	private String fileNameS;

	private String descriptionS;

	private String sizeS;

	private String id;

	private Long sequenceNumberS;

	private String stateS;

	private String fileIdS;

	private String delete;

	private OffsetDateTime createdTimeS;

	private OffsetDateTime modifiedTimeS;

	private MinifiedUser createdByS;

	private MinifiedUser ownerS;

	private MinifiedUser modifiedByS;

	private String attachmentSourceS;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of previewIdS
	 * @return A String representing the previewIdS
	 */
	public String getPreviewIdS()
	{
		return  this.previewIdS;

	}

	/**
	 * The method to set the value to previewIdS
	 * @param previewIdS A String representing the previewIdS
	 */
	public void setPreviewIdS(String previewIdS)
	{
		 this.previewIdS = previewIdS;

		 this.keyModified.put("Preview_Id__s", 1);

	}

	/**
	 * The method to get the value of fileNameS
	 * @return A String representing the fileNameS
	 */
	public String getFileNameS()
	{
		return  this.fileNameS;

	}

	/**
	 * The method to set the value to fileNameS
	 * @param fileNameS A String representing the fileNameS
	 */
	public void setFileNameS(String fileNameS)
	{
		 this.fileNameS = fileNameS;

		 this.keyModified.put("File_Name__s", 1);

	}

	/**
	 * The method to get the value of descriptionS
	 * @return A String representing the descriptionS
	 */
	public String getDescriptionS()
	{
		return  this.descriptionS;

	}

	/**
	 * The method to set the value to descriptionS
	 * @param descriptionS A String representing the descriptionS
	 */
	public void setDescriptionS(String descriptionS)
	{
		 this.descriptionS = descriptionS;

		 this.keyModified.put("Description__s", 1);

	}

	/**
	 * The method to get the value of sizeS
	 * @return A String representing the sizeS
	 */
	public String getSizeS()
	{
		return  this.sizeS;

	}

	/**
	 * The method to set the value to sizeS
	 * @param sizeS A String representing the sizeS
	 */
	public void setSizeS(String sizeS)
	{
		 this.sizeS = sizeS;

		 this.keyModified.put("Size__s", 1);

	}

	/**
	 * The method to get the value of id
	 * @return A String representing the id
	 */
	public String getId()
	{
		return  this.id;

	}

	/**
	 * The method to set the value to id
	 * @param id A String representing the id
	 */
	public void setId(String id)
	{
		 this.id = id;

		 this.keyModified.put("id", 1);

	}

	/**
	 * The method to get the value of sequenceNumberS
	 * @return A Long representing the sequenceNumberS
	 */
	public Long getSequenceNumberS()
	{
		return  this.sequenceNumberS;

	}

	/**
	 * The method to set the value to sequenceNumberS
	 * @param sequenceNumberS A Long representing the sequenceNumberS
	 */
	public void setSequenceNumberS(Long sequenceNumberS)
	{
		 this.sequenceNumberS = sequenceNumberS;

		 this.keyModified.put("Sequence_Number__s", 1);

	}

	/**
	 * The method to get the value of stateS
	 * @return A String representing the stateS
	 */
	public String getStateS()
	{
		return  this.stateS;

	}

	/**
	 * The method to set the value to stateS
	 * @param stateS A String representing the stateS
	 */
	public void setStateS(String stateS)
	{
		 this.stateS = stateS;

		 this.keyModified.put("State__s", 1);

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
	 * The method to get the value of delete
	 * @return A String representing the delete
	 */
	public String getDelete()
	{
		return  this.delete;

	}

	/**
	 * The method to set the value to delete
	 * @param delete A String representing the delete
	 */
	public void setDelete(String delete)
	{
		 this.delete = delete;

		 this.keyModified.put("_delete", 1);

	}

	/**
	 * The method to get the value of createdTimeS
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getCreatedTimeS()
	{
		return  this.createdTimeS;

	}

	/**
	 * The method to set the value to createdTimeS
	 * @param createdTimeS An instance of OffsetDateTime
	 */
	public void setCreatedTimeS(OffsetDateTime createdTimeS)
	{
		 this.createdTimeS = createdTimeS;

		 this.keyModified.put("Created_Time__s", 1);

	}

	/**
	 * The method to get the value of modifiedTimeS
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getModifiedTimeS()
	{
		return  this.modifiedTimeS;

	}

	/**
	 * The method to set the value to modifiedTimeS
	 * @param modifiedTimeS An instance of OffsetDateTime
	 */
	public void setModifiedTimeS(OffsetDateTime modifiedTimeS)
	{
		 this.modifiedTimeS = modifiedTimeS;

		 this.keyModified.put("Modified_Time__s", 1);

	}

	/**
	 * The method to get the value of createdByS
	 * @return An instance of MinifiedUser
	 */
	public MinifiedUser getCreatedByS()
	{
		return  this.createdByS;

	}

	/**
	 * The method to set the value to createdByS
	 * @param createdByS An instance of MinifiedUser
	 */
	public void setCreatedByS(MinifiedUser createdByS)
	{
		 this.createdByS = createdByS;

		 this.keyModified.put("Created_By__s", 1);

	}

	/**
	 * The method to get the value of ownerS
	 * @return An instance of MinifiedUser
	 */
	public MinifiedUser getOwnerS()
	{
		return  this.ownerS;

	}

	/**
	 * The method to set the value to ownerS
	 * @param ownerS An instance of MinifiedUser
	 */
	public void setOwnerS(MinifiedUser ownerS)
	{
		 this.ownerS = ownerS;

		 this.keyModified.put("Owner__s", 1);

	}

	/**
	 * The method to get the value of modifiedByS
	 * @return An instance of MinifiedUser
	 */
	public MinifiedUser getModifiedByS()
	{
		return  this.modifiedByS;

	}

	/**
	 * The method to set the value to modifiedByS
	 * @param modifiedByS An instance of MinifiedUser
	 */
	public void setModifiedByS(MinifiedUser modifiedByS)
	{
		 this.modifiedByS = modifiedByS;

		 this.keyModified.put("Modified_By__s", 1);

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