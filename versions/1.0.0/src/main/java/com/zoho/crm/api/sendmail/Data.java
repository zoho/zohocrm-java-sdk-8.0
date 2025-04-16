package com.zoho.crm.api.sendmail;

import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;

public class Data implements Model
{
	private From from;

	private List<To> to;

	private List<Cc> cc;

	private List<Cc> bcc;

	private To replyTo;

	private Boolean orgEmail;

	private OffsetDateTime scheduledTime;

	private Choice<String> mailFormat;

	private Boolean consentEmail;

	private String content;

	private String subject;

	private InReplyTo inReplyTo;

	private Template template;

	private InventoryDetails inventoryDetails;

	private DataSubjectRequest dataSubjectRequest;

	private List<Attachment> attachments;

	private LinkedRecord linkedRecord;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of from
	 * @return An instance of From
	 */
	public From getFrom()
	{
		return  this.from;

	}

	/**
	 * The method to set the value to from
	 * @param from An instance of From
	 */
	public void setFrom(From from)
	{
		 this.from = from;

		 this.keyModified.put("from", 1);

	}

	/**
	 * The method to get the value of to
	 * @return An instance of List<To>
	 */
	public List<To> getTo()
	{
		return  this.to;

	}

	/**
	 * The method to set the value to to
	 * @param to An instance of List<To>
	 */
	public void setTo(List<To> to)
	{
		 this.to = to;

		 this.keyModified.put("to", 1);

	}

	/**
	 * The method to get the value of cc
	 * @return An instance of List<Cc>
	 */
	public List<Cc> getCc()
	{
		return  this.cc;

	}

	/**
	 * The method to set the value to cc
	 * @param cc An instance of List<Cc>
	 */
	public void setCc(List<Cc> cc)
	{
		 this.cc = cc;

		 this.keyModified.put("cc", 1);

	}

	/**
	 * The method to get the value of bcc
	 * @return An instance of List<Cc>
	 */
	public List<Cc> getBcc()
	{
		return  this.bcc;

	}

	/**
	 * The method to set the value to bcc
	 * @param bcc An instance of List<Cc>
	 */
	public void setBcc(List<Cc> bcc)
	{
		 this.bcc = bcc;

		 this.keyModified.put("bcc", 1);

	}

	/**
	 * The method to get the value of replyTo
	 * @return An instance of To
	 */
	public To getReplyTo()
	{
		return  this.replyTo;

	}

	/**
	 * The method to set the value to replyTo
	 * @param replyTo An instance of To
	 */
	public void setReplyTo(To replyTo)
	{
		 this.replyTo = replyTo;

		 this.keyModified.put("reply_to", 1);

	}

	/**
	 * The method to get the value of orgEmail
	 * @return A Boolean representing the orgEmail
	 */
	public Boolean getOrgEmail()
	{
		return  this.orgEmail;

	}

	/**
	 * The method to set the value to orgEmail
	 * @param orgEmail A Boolean representing the orgEmail
	 */
	public void setOrgEmail(Boolean orgEmail)
	{
		 this.orgEmail = orgEmail;

		 this.keyModified.put("org_email", 1);

	}

	/**
	 * The method to get the value of scheduledTime
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getScheduledTime()
	{
		return  this.scheduledTime;

	}

	/**
	 * The method to set the value to scheduledTime
	 * @param scheduledTime An instance of OffsetDateTime
	 */
	public void setScheduledTime(OffsetDateTime scheduledTime)
	{
		 this.scheduledTime = scheduledTime;

		 this.keyModified.put("scheduled_time", 1);

	}

	/**
	 * The method to get the value of mailFormat
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getMailFormat()
	{
		return  this.mailFormat;

	}

	/**
	 * The method to set the value to mailFormat
	 * @param mailFormat An instance of Choice<String>
	 */
	public void setMailFormat(Choice<String> mailFormat)
	{
		 this.mailFormat = mailFormat;

		 this.keyModified.put("mail_format", 1);

	}

	/**
	 * The method to get the value of consentEmail
	 * @return A Boolean representing the consentEmail
	 */
	public Boolean getConsentEmail()
	{
		return  this.consentEmail;

	}

	/**
	 * The method to set the value to consentEmail
	 * @param consentEmail A Boolean representing the consentEmail
	 */
	public void setConsentEmail(Boolean consentEmail)
	{
		 this.consentEmail = consentEmail;

		 this.keyModified.put("consent_email", 1);

	}

	/**
	 * The method to get the value of content
	 * @return A String representing the content
	 */
	public String getContent()
	{
		return  this.content;

	}

	/**
	 * The method to set the value to content
	 * @param content A String representing the content
	 */
	public void setContent(String content)
	{
		 this.content = content;

		 this.keyModified.put("content", 1);

	}

	/**
	 * The method to get the value of subject
	 * @return A String representing the subject
	 */
	public String getSubject()
	{
		return  this.subject;

	}

	/**
	 * The method to set the value to subject
	 * @param subject A String representing the subject
	 */
	public void setSubject(String subject)
	{
		 this.subject = subject;

		 this.keyModified.put("subject", 1);

	}

	/**
	 * The method to get the value of inReplyTo
	 * @return An instance of InReplyTo
	 */
	public InReplyTo getInReplyTo()
	{
		return  this.inReplyTo;

	}

	/**
	 * The method to set the value to inReplyTo
	 * @param inReplyTo An instance of InReplyTo
	 */
	public void setInReplyTo(InReplyTo inReplyTo)
	{
		 this.inReplyTo = inReplyTo;

		 this.keyModified.put("in_reply_to", 1);

	}

	/**
	 * The method to get the value of template
	 * @return An instance of Template
	 */
	public Template getTemplate()
	{
		return  this.template;

	}

	/**
	 * The method to set the value to template
	 * @param template An instance of Template
	 */
	public void setTemplate(Template template)
	{
		 this.template = template;

		 this.keyModified.put("template", 1);

	}

	/**
	 * The method to get the value of inventoryDetails
	 * @return An instance of InventoryDetails
	 */
	public InventoryDetails getInventoryDetails()
	{
		return  this.inventoryDetails;

	}

	/**
	 * The method to set the value to inventoryDetails
	 * @param inventoryDetails An instance of InventoryDetails
	 */
	public void setInventoryDetails(InventoryDetails inventoryDetails)
	{
		 this.inventoryDetails = inventoryDetails;

		 this.keyModified.put("inventory_details", 1);

	}

	/**
	 * The method to get the value of dataSubjectRequest
	 * @return An instance of DataSubjectRequest
	 */
	public DataSubjectRequest getDataSubjectRequest()
	{
		return  this.dataSubjectRequest;

	}

	/**
	 * The method to set the value to dataSubjectRequest
	 * @param dataSubjectRequest An instance of DataSubjectRequest
	 */
	public void setDataSubjectRequest(DataSubjectRequest dataSubjectRequest)
	{
		 this.dataSubjectRequest = dataSubjectRequest;

		 this.keyModified.put("data_subject_request", 1);

	}

	/**
	 * The method to get the value of attachments
	 * @return An instance of List<Attachment>
	 */
	public List<Attachment> getAttachments()
	{
		return  this.attachments;

	}

	/**
	 * The method to set the value to attachments
	 * @param attachments An instance of List<Attachment>
	 */
	public void setAttachments(List<Attachment> attachments)
	{
		 this.attachments = attachments;

		 this.keyModified.put("attachments", 1);

	}

	/**
	 * The method to get the value of linkedRecord
	 * @return An instance of LinkedRecord
	 */
	public LinkedRecord getLinkedRecord()
	{
		return  this.linkedRecord;

	}

	/**
	 * The method to set the value to linkedRecord
	 * @param linkedRecord An instance of LinkedRecord
	 */
	public void setLinkedRecord(LinkedRecord linkedRecord)
	{
		 this.linkedRecord = linkedRecord;

		 this.keyModified.put("linked_record", 1);

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