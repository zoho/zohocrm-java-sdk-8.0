package com.zoho.crm.api.timelines;

import com.zoho.crm.api.util.Model;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;

public class Timeline implements Model
{
	private OffsetDateTime auditedTime;

	private String action;

	private Long id;

	private String source;

	private String extension;

	private String type;

	private NameIdStructure doneBy;

	private RelatedRecord relatedRecord;

	private AutomationDetail automationDetails;

	private Record record;

	private List<FieldHistory> fieldHistory;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of auditedTime
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getAuditedTime()
	{
		return  this.auditedTime;

	}

	/**
	 * The method to set the value to auditedTime
	 * @param auditedTime An instance of OffsetDateTime
	 */
	public void setAuditedTime(OffsetDateTime auditedTime)
	{
		 this.auditedTime = auditedTime;

		 this.keyModified.put("audited_time", 1);

	}

	/**
	 * The method to get the value of action
	 * @return A String representing the action
	 */
	public String getAction()
	{
		return  this.action;

	}

	/**
	 * The method to set the value to action
	 * @param action A String representing the action
	 */
	public void setAction(String action)
	{
		 this.action = action;

		 this.keyModified.put("action", 1);

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
	 * The method to get the value of source
	 * @return A String representing the source
	 */
	public String getSource()
	{
		return  this.source;

	}

	/**
	 * The method to set the value to source
	 * @param source A String representing the source
	 */
	public void setSource(String source)
	{
		 this.source = source;

		 this.keyModified.put("source", 1);

	}

	/**
	 * The method to get the value of extension
	 * @return A String representing the extension
	 */
	public String getExtension()
	{
		return  this.extension;

	}

	/**
	 * The method to set the value to extension
	 * @param extension A String representing the extension
	 */
	public void setExtension(String extension)
	{
		 this.extension = extension;

		 this.keyModified.put("extension", 1);

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

		 this.keyModified.put("type", 1);

	}

	/**
	 * The method to get the value of doneBy
	 * @return An instance of NameIdStructure
	 */
	public NameIdStructure getDoneBy()
	{
		return  this.doneBy;

	}

	/**
	 * The method to set the value to doneBy
	 * @param doneBy An instance of NameIdStructure
	 */
	public void setDoneBy(NameIdStructure doneBy)
	{
		 this.doneBy = doneBy;

		 this.keyModified.put("done_by", 1);

	}

	/**
	 * The method to get the value of relatedRecord
	 * @return An instance of RelatedRecord
	 */
	public RelatedRecord getRelatedRecord()
	{
		return  this.relatedRecord;

	}

	/**
	 * The method to set the value to relatedRecord
	 * @param relatedRecord An instance of RelatedRecord
	 */
	public void setRelatedRecord(RelatedRecord relatedRecord)
	{
		 this.relatedRecord = relatedRecord;

		 this.keyModified.put("related_record", 1);

	}

	/**
	 * The method to get the value of automationDetails
	 * @return An instance of AutomationDetail
	 */
	public AutomationDetail getAutomationDetails()
	{
		return  this.automationDetails;

	}

	/**
	 * The method to set the value to automationDetails
	 * @param automationDetails An instance of AutomationDetail
	 */
	public void setAutomationDetails(AutomationDetail automationDetails)
	{
		 this.automationDetails = automationDetails;

		 this.keyModified.put("automation_details", 1);

	}

	/**
	 * The method to get the value of record
	 * @return An instance of Record
	 */
	public Record getRecord()
	{
		return  this.record;

	}

	/**
	 * The method to set the value to record
	 * @param record An instance of Record
	 */
	public void setRecord(Record record)
	{
		 this.record = record;

		 this.keyModified.put("record", 1);

	}

	/**
	 * The method to get the value of fieldHistory
	 * @return An instance of List<FieldHistory>
	 */
	public List<FieldHistory> getFieldHistory()
	{
		return  this.fieldHistory;

	}

	/**
	 * The method to set the value to fieldHistory
	 * @param fieldHistory An instance of List<FieldHistory>
	 */
	public void setFieldHistory(List<FieldHistory> fieldHistory)
	{
		 this.fieldHistory = fieldHistory;

		 this.keyModified.put("field_history", 1);

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