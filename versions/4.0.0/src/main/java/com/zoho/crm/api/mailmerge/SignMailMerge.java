package com.zoho.crm.api.mailmerge;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class SignMailMerge implements Model
{
	private MailMergeTemplate mailMergeTemplate;

	private Boolean signInOrder;

	private String fileName;

	private List<Signers> signers;

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
	 * The method to get the value of signInOrder
	 * @return A Boolean representing the signInOrder
	 */
	public Boolean getSignInOrder()
	{
		return  this.signInOrder;

	}

	/**
	 * The method to set the value to signInOrder
	 * @param signInOrder A Boolean representing the signInOrder
	 */
	public void setSignInOrder(Boolean signInOrder)
	{
		 this.signInOrder = signInOrder;

		 this.keyModified.put("sign_in_order", 1);

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

		 this.keyModified.put("file_name", 1);

	}

	/**
	 * The method to get the value of signers
	 * @return An instance of List<Signers>
	 */
	public List<Signers> getSigners()
	{
		return  this.signers;

	}

	/**
	 * The method to set the value to signers
	 * @param signers An instance of List<Signers>
	 */
	public void setSigners(List<Signers> signers)
	{
		 this.signers = signers;

		 this.keyModified.put("signers", 1);

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