package com.zoho.crm.api.mailmerge;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class MailMerge implements Model
{
	private MailMergeTemplate mailMergeTemplate;

	private Address fromAddress;

	private List<Address> toAddress;

	private List<Address> ccEmail;

	private List<Address> bccEmail;

	private String subject;

	private String message;

	private String type;

	private String attachmentName;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of mailMergeTemplate
	 * @return An instance of MailMergeTemplate
	 */
	public MailMergeTemplate getMailMergeTemplate()
	{
		return  this.mailMergeTemplate;

	}

	/**
	 * The method to set the value to mailMergeTemplate
	 * @param mailMergeTemplate An instance of MailMergeTemplate
	 */
	public void setMailMergeTemplate(MailMergeTemplate mailMergeTemplate)
	{
		 this.mailMergeTemplate = mailMergeTemplate;

		 this.keyModified.put("mail_merge_template", 1);

	}

	/**
	 * The method to get the value of fromAddress
	 * @return An instance of Address
	 */
	public Address getFromAddress()
	{
		return  this.fromAddress;

	}

	/**
	 * The method to set the value to fromAddress
	 * @param fromAddress An instance of Address
	 */
	public void setFromAddress(Address fromAddress)
	{
		 this.fromAddress = fromAddress;

		 this.keyModified.put("from_address", 1);

	}

	/**
	 * The method to get the value of toAddress
	 * @return An instance of List<Address>
	 */
	public List<Address> getToAddress()
	{
		return  this.toAddress;

	}

	/**
	 * The method to set the value to toAddress
	 * @param toAddress An instance of List<Address>
	 */
	public void setToAddress(List<Address> toAddress)
	{
		 this.toAddress = toAddress;

		 this.keyModified.put("to_address", 1);

	}

	/**
	 * The method to get the value of ccEmail
	 * @return An instance of List<Address>
	 */
	public List<Address> getCcEmail()
	{
		return  this.ccEmail;

	}

	/**
	 * The method to set the value to ccEmail
	 * @param ccEmail An instance of List<Address>
	 */
	public void setCcEmail(List<Address> ccEmail)
	{
		 this.ccEmail = ccEmail;

		 this.keyModified.put("cc_email", 1);

	}

	/**
	 * The method to get the value of bccEmail
	 * @return An instance of List<Address>
	 */
	public List<Address> getBccEmail()
	{
		return  this.bccEmail;

	}

	/**
	 * The method to set the value to bccEmail
	 * @param bccEmail An instance of List<Address>
	 */
	public void setBccEmail(List<Address> bccEmail)
	{
		 this.bccEmail = bccEmail;

		 this.keyModified.put("bcc_email", 1);

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
	 * The method to get the value of message
	 * @return A String representing the message
	 */
	public String getMessage()
	{
		return  this.message;

	}

	/**
	 * The method to set the value to message
	 * @param message A String representing the message
	 */
	public void setMessage(String message)
	{
		 this.message = message;

		 this.keyModified.put("message", 1);

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
	 * The method to get the value of attachmentName
	 * @return A String representing the attachmentName
	 */
	public String getAttachmentName()
	{
		return  this.attachmentName;

	}

	/**
	 * The method to set the value to attachmentName
	 * @param attachmentName A String representing the attachmentName
	 */
	public void setAttachmentName(String attachmentName)
	{
		 this.attachmentName = attachmentName;

		 this.keyModified.put("attachment_name", 1);

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