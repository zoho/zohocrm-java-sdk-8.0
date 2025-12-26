package com.zoho.crm.api.emailrelatedrecords;

import com.zoho.crm.api.users.MinifiedUser;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;

public class Email implements Model
{
	private List<Attachments> attachments;

	private String threadId;

	private List<UserDetails> cc;

	private String summary;

	private MinifiedUser owner;

	private Boolean read;

	private String content;

	private Boolean sent;

	private String subject;

	private Object activityInfo;

	private Choice<String> intent;

	private Choice<String> sentimentInfo;

	private String messageId;

	private String source;

	private LinkedRecord linkedRecord;

	private String sentTime;

	private String emotion;

	private UserDetails from;

	private List<UserDetails> to;

	private OffsetDateTime time;

	private List<Status> status;

	private Boolean hasAttachment;

	private Boolean hasThreadAttachment;

	private Boolean editable;

	private String mailFormat;

	private UserDetails replyTo;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


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
	 * The method to get the value of threadId
	 * @return A String representing the threadId
	 */
	public String getThreadId()
	{
		return  this.threadId;

	}

	/**
	 * The method to set the value to threadId
	 * @param threadId A String representing the threadId
	 */
	public void setThreadId(String threadId)
	{
		 this.threadId = threadId;

		 this.keyModified.put("thread_id", 1);

	}

	/**
	 * The method to get the value of cc
	 * @return An instance of List<UserDetails>
	 */
	public List<UserDetails> getCc()
	{
		return  this.cc;

	}

	/**
	 * The method to set the value to cc
	 * @param cc An instance of List<UserDetails>
	 */
	public void setCc(List<UserDetails> cc)
	{
		 this.cc = cc;

		 this.keyModified.put("cc", 1);

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

		 this.keyModified.put("owner", 1);

	}

	/**
	 * The method to get the value of read
	 * @return A Boolean representing the read
	 */
	public Boolean getRead()
	{
		return  this.read;

	}

	/**
	 * The method to set the value to read
	 * @param read A Boolean representing the read
	 */
	public void setRead(Boolean read)
	{
		 this.read = read;

		 this.keyModified.put("read", 1);

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
	 * The method to get the value of activityInfo
	 * @return An instance of Object
	 */
	public Object getActivityInfo()
	{
		return  this.activityInfo;

	}

	/**
	 * The method to set the value to activityInfo
	 * @param activityInfo An instance of Object
	 */
	public void setActivityInfo(Object activityInfo)
	{
		 this.activityInfo = activityInfo;

		 this.keyModified.put("activity_info", 1);

	}

	/**
	 * The method to get the value of intent
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getIntent()
	{
		return  this.intent;

	}

	/**
	 * The method to set the value to intent
	 * @param intent An instance of Choice<String>
	 */
	public void setIntent(Choice<String> intent)
	{
		 this.intent = intent;

		 this.keyModified.put("intent", 1);

	}

	/**
	 * The method to get the value of sentimentInfo
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getSentimentInfo()
	{
		return  this.sentimentInfo;

	}

	/**
	 * The method to set the value to sentimentInfo
	 * @param sentimentInfo An instance of Choice<String>
	 */
	public void setSentimentInfo(Choice<String> sentimentInfo)
	{
		 this.sentimentInfo = sentimentInfo;

		 this.keyModified.put("sentiment_info", 1);

	}

	/**
	 * The method to get the value of messageId
	 * @return A String representing the messageId
	 */
	public String getMessageId()
	{
		return  this.messageId;

	}

	/**
	 * The method to set the value to messageId
	 * @param messageId A String representing the messageId
	 */
	public void setMessageId(String messageId)
	{
		 this.messageId = messageId;

		 this.keyModified.put("message_id", 1);

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
	 * The method to get the value of sentTime
	 * @return A String representing the sentTime
	 */
	public String getSentTime()
	{
		return  this.sentTime;

	}

	/**
	 * The method to set the value to sentTime
	 * @param sentTime A String representing the sentTime
	 */
	public void setSentTime(String sentTime)
	{
		 this.sentTime = sentTime;

		 this.keyModified.put("sent_time", 1);

	}

	/**
	 * The method to get the value of emotion
	 * @return A String representing the emotion
	 */
	public String getEmotion()
	{
		return  this.emotion;

	}

	/**
	 * The method to set the value to emotion
	 * @param emotion A String representing the emotion
	 */
	public void setEmotion(String emotion)
	{
		 this.emotion = emotion;

		 this.keyModified.put("emotion", 1);

	}

	/**
	 * The method to get the value of from
	 * @return An instance of UserDetails
	 */
	public UserDetails getFrom()
	{
		return  this.from;

	}

	/**
	 * The method to set the value to from
	 * @param from An instance of UserDetails
	 */
	public void setFrom(UserDetails from)
	{
		 this.from = from;

		 this.keyModified.put("from", 1);

	}

	/**
	 * The method to get the value of to
	 * @return An instance of List<UserDetails>
	 */
	public List<UserDetails> getTo()
	{
		return  this.to;

	}

	/**
	 * The method to set the value to to
	 * @param to An instance of List<UserDetails>
	 */
	public void setTo(List<UserDetails> to)
	{
		 this.to = to;

		 this.keyModified.put("to", 1);

	}

	/**
	 * The method to get the value of time
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getTime()
	{
		return  this.time;

	}

	/**
	 * The method to set the value to time
	 * @param time An instance of OffsetDateTime
	 */
	public void setTime(OffsetDateTime time)
	{
		 this.time = time;

		 this.keyModified.put("time", 1);

	}

	/**
	 * The method to get the value of status
	 * @return An instance of List<Status>
	 */
	public List<Status> getStatus()
	{
		return  this.status;

	}

	/**
	 * The method to set the value to status
	 * @param status An instance of List<Status>
	 */
	public void setStatus(List<Status> status)
	{
		 this.status = status;

		 this.keyModified.put("status", 1);

	}

	/**
	 * The method to get the value of hasAttachment
	 * @return A Boolean representing the hasAttachment
	 */
	public Boolean getHasAttachment()
	{
		return  this.hasAttachment;

	}

	/**
	 * The method to set the value to hasAttachment
	 * @param hasAttachment A Boolean representing the hasAttachment
	 */
	public void setHasAttachment(Boolean hasAttachment)
	{
		 this.hasAttachment = hasAttachment;

		 this.keyModified.put("has_attachment", 1);

	}

	/**
	 * The method to get the value of hasThreadAttachment
	 * @return A Boolean representing the hasThreadAttachment
	 */
	public Boolean getHasThreadAttachment()
	{
		return  this.hasThreadAttachment;

	}

	/**
	 * The method to set the value to hasThreadAttachment
	 * @param hasThreadAttachment A Boolean representing the hasThreadAttachment
	 */
	public void setHasThreadAttachment(Boolean hasThreadAttachment)
	{
		 this.hasThreadAttachment = hasThreadAttachment;

		 this.keyModified.put("has_thread_attachment", 1);

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

		 this.keyModified.put("editable", 1);

	}

	/**
	 * The method to get the value of mailFormat
	 * @return A String representing the mailFormat
	 */
	public String getMailFormat()
	{
		return  this.mailFormat;

	}

	/**
	 * The method to set the value to mailFormat
	 * @param mailFormat A String representing the mailFormat
	 */
	public void setMailFormat(String mailFormat)
	{
		 this.mailFormat = mailFormat;

		 this.keyModified.put("mail_format", 1);

	}

	/**
	 * The method to get the value of replyTo
	 * @return An instance of UserDetails
	 */
	public UserDetails getReplyTo()
	{
		return  this.replyTo;

	}

	/**
	 * The method to set the value to replyTo
	 * @param replyTo An instance of UserDetails
	 */
	public void setReplyTo(UserDetails replyTo)
	{
		 this.replyTo = replyTo;

		 this.keyModified.put("reply_to", 1);

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