package com.zoho.crm.api.emailtemplates;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class LastVersionStatistics implements Model
{
	private Integer tracked;

	private Integer delivered;

	private Integer opened;

	private Integer bounced;

	private Integer sent;

	private Integer clicked;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of tracked
	 * @return An Integer representing the tracked
	 */
	public Integer getTracked()
	{
		return  this.tracked;

	}

	/**
	 * The method to set the value to tracked
	 * @param tracked An Integer representing the tracked
	 */
	public void setTracked(Integer tracked)
	{
		 this.tracked = tracked;

		 this.keyModified.put("tracked", 1);

	}

	/**
	 * The method to get the value of delivered
	 * @return An Integer representing the delivered
	 */
	public Integer getDelivered()
	{
		return  this.delivered;

	}

	/**
	 * The method to set the value to delivered
	 * @param delivered An Integer representing the delivered
	 */
	public void setDelivered(Integer delivered)
	{
		 this.delivered = delivered;

		 this.keyModified.put("delivered", 1);

	}

	/**
	 * The method to get the value of opened
	 * @return An Integer representing the opened
	 */
	public Integer getOpened()
	{
		return  this.opened;

	}

	/**
	 * The method to set the value to opened
	 * @param opened An Integer representing the opened
	 */
	public void setOpened(Integer opened)
	{
		 this.opened = opened;

		 this.keyModified.put("opened", 1);

	}

	/**
	 * The method to get the value of bounced
	 * @return An Integer representing the bounced
	 */
	public Integer getBounced()
	{
		return  this.bounced;

	}

	/**
	 * The method to set the value to bounced
	 * @param bounced An Integer representing the bounced
	 */
	public void setBounced(Integer bounced)
	{
		 this.bounced = bounced;

		 this.keyModified.put("bounced", 1);

	}

	/**
	 * The method to get the value of sent
	 * @return An Integer representing the sent
	 */
	public Integer getSent()
	{
		return  this.sent;

	}

	/**
	 * The method to set the value to sent
	 * @param sent An Integer representing the sent
	 */
	public void setSent(Integer sent)
	{
		 this.sent = sent;

		 this.keyModified.put("sent", 1);

	}

	/**
	 * The method to get the value of clicked
	 * @return An Integer representing the clicked
	 */
	public Integer getClicked()
	{
		return  this.clicked;

	}

	/**
	 * The method to set the value to clicked
	 * @param clicked An Integer representing the clicked
	 */
	public void setClicked(Integer clicked)
	{
		 this.clicked = clicked;

		 this.keyModified.put("clicked", 1);

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