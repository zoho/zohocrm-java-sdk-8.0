package com.zoho.crm.api.emaildrafts;

import com.zoho.crm.api.util.Model;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;

public class EmailDrafts implements Model
{
	private String id;

	private OffsetDateTime modifiedTime;

	private OffsetDateTime createdTime;

	private String from;

	private List<To> to;

	private String replyTo;

	private List<To> cc;

	private List<To> bcc;

	private Template template;

	private InventoryDetails inventoryDetails;

	private List<Attachments> attachments;

	private ScheduleDetails scheduleDetails;

	private Boolean richText;

	private Boolean emailOptOut;

	private String subject;

	private String content;

	private String summary;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


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
	 * The method to get the value of from
	 * @return A String representing the from
	 */
	public String getFrom()
	{
		return  this.from;

	}

	/**
	 * The method to set the value to from
	 * @param from A String representing the from
	 */
	public void setFrom(String from)
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
	 * The method to get the value of replyTo
	 * @return A String representing the replyTo
	 */
	public String getReplyTo()
	{
		return  this.replyTo;

	}

	/**
	 * The method to set the value to replyTo
	 * @param replyTo A String representing the replyTo
	 */
	public void setReplyTo(String replyTo)
	{
		 this.replyTo = replyTo;

		 this.keyModified.put("reply_to", 1);

	}

	/**
	 * The method to get the value of cc
	 * @return An instance of List<To>
	 */
	public List<To> getCc()
	{
		return  this.cc;

	}

	/**
	 * The method to set the value to cc
	 * @param cc An instance of List<To>
	 */
	public void setCc(List<To> cc)
	{
		 this.cc = cc;

		 this.keyModified.put("cc", 1);

	}

	/**
	 * The method to get the value of bcc
	 * @return An instance of List<To>
	 */
	public List<To> getBcc()
	{
		return  this.bcc;

	}

	/**
	 * The method to set the value to bcc
	 * @param bcc An instance of List<To>
	 */
	public void setBcc(List<To> bcc)
	{
		 this.bcc = bcc;

		 this.keyModified.put("bcc", 1);

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
	 * The method to get the value of attachments
	 * @return An instance of List<Attachments>
	 */
	public List<Attachments> getAttachments()
	{
		return  this.attachments;

	}

	/**
	 * The method to set the value to attachments
	 * @param attachments An instance of List<Attachments>
	 */
	public void setAttachments(List<Attachments> attachments)
	{
		 this.attachments = attachments;

		 this.keyModified.put("attachments", 1);

	}

	/**
	 * The method to get the value of scheduleDetails
	 * @return An instance of ScheduleDetails
	 */
	public ScheduleDetails getScheduleDetails()
	{
		return  this.scheduleDetails;

	}

	/**
	 * The method to set the value to scheduleDetails
	 * @param scheduleDetails An instance of ScheduleDetails
	 */
	public void setScheduleDetails(ScheduleDetails scheduleDetails)
	{
		 this.scheduleDetails = scheduleDetails;

		 this.keyModified.put("schedule_details", 1);

	}

	/**
	 * The method to get the value of richText
	 * @return A Boolean representing the richText
	 */
	public Boolean getRichText()
	{
		return  this.richText;

	}

	/**
	 * The method to set the value to richText
	 * @param richText A Boolean representing the richText
	 */
	public void setRichText(Boolean richText)
	{
		 this.richText = richText;

		 this.keyModified.put("rich_text", 1);

	}

	/**
	 * The method to get the value of emailOptOut
	 * @return A Boolean representing the emailOptOut
	 */
	public Boolean getEmailOptOut()
	{
		return  this.emailOptOut;

	}

	/**
	 * The method to set the value to emailOptOut
	 * @param emailOptOut A Boolean representing the emailOptOut
	 */
	public void setEmailOptOut(Boolean emailOptOut)
	{
		 this.emailOptOut = emailOptOut;

		 this.keyModified.put("email_opt_out", 1);

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
	 * The method to get the value of summary
	 * @return A String representing the summary
	 */
	public String getSummary()
	{
		return  this.summary;

	}

	/**
	 * The method to set the value to summary
	 * @param summary A String representing the summary
	 */
	public void setSummary(String summary)
	{
		 this.summary = summary;

		 this.keyModified.put("summary", 1);

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