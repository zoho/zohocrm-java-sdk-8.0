package com.zoho.crm.api.associateemail;

import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;

public class AssociateEmail implements Model
{
	private From from;

	private List<To> to;

	private List<To> cc;

	private List<To> bcc;

	private List<Attachments> attachments;

	private String content;

	private Choice<String> mailFormat;

	private String subject;

	private String originalMessageId;

	private Boolean sent;

	private OffsetDateTime dateTime;

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
	 * The method to get the value of originalMessageId
	 * @return A String representing the originalMessageId
	 */
	public String getOriginalMessageId()
	{
		return  this.originalMessageId;

	}

	/**
	 * The method to set the value to originalMessageId
	 * @param originalMessageId A String representing the originalMessageId
	 */
	public void setOriginalMessageId(String originalMessageId)
	{
		 this.originalMessageId = originalMessageId;

		 this.keyModified.put("original_message_id", 1);

	}

	/**
	 * The method to get the value of sent
	 * @return A Boolean representing the sent
	 */
	public Boolean getSent()
	{
		return  this.sent;

	}

	/**
	 * The method to set the value to sent
	 * @param sent A Boolean representing the sent
	 */
	public void setSent(Boolean sent)
	{
		 this.sent = sent;

		 this.keyModified.put("sent", 1);

	}

	/**
	 * The method to get the value of dateTime
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getDateTime()
	{
		return  this.dateTime;

	}

	/**
	 * The method to set the value to dateTime
	 * @param dateTime An instance of OffsetDateTime
	 */
	public void setDateTime(OffsetDateTime dateTime)
	{
		 this.dateTime = dateTime;

		 this.keyModified.put("date_time", 1);

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