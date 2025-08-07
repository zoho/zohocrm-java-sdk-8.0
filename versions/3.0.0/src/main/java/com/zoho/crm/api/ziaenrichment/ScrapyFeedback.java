package com.zoho.crm.api.ziaenrichment;

import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class ScrapyFeedback implements Model
{
	private Choice<String> enrichId;

	private Choice<String> type;

	private Choice<String> feedback;

	private String comment;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of enrichId
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getEnrichId()
	{
		return  this.enrichId;

	}

	/**
	 * The method to set the value to enrichId
	 * @param enrichId An instance of Choice<String>
	 */
	public void setEnrichId(Choice<String> enrichId)
	{
		 this.enrichId = enrichId;

		 this.keyModified.put("enrich_id", 1);

	}

	/**
	 * The method to get the value of type
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getType()
	{
		return  this.type;

	}

	/**
	 * The method to set the value to type
	 * @param type An instance of Choice<String>
	 */
	public void setType(Choice<String> type)
	{
		 this.type = type;

		 this.keyModified.put("type", 1);

	}

	/**
	 * The method to get the value of feedback
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getFeedback()
	{
		return  this.feedback;

	}

	/**
	 * The method to set the value to feedback
	 * @param feedback An instance of Choice<String>
	 */
	public void setFeedback(Choice<String> feedback)
	{
		 this.feedback = feedback;

		 this.keyModified.put("feedback", 1);

	}

	/**
	 * The method to get the value of comment
	 * @return A String representing the comment
	 */
	public String getComment()
	{
		return  this.comment;

	}

	/**
	 * The method to set the value to comment
	 * @param comment A String representing the comment
	 */
	public void setComment(String comment)
	{
		 this.comment = comment;

		 this.keyModified.put("comment", 1);

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