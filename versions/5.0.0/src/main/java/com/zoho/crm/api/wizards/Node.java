package com.zoho.crm.api.wizards;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Node implements Model
{
	private Integer posY;

	private Integer posX;

	private Boolean startNode;

	private Screen screen;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of posY
	 * @return An Integer representing the posY
	 */
	public Integer getPosY()
	{
		return  this.posY;

	}

	/**
	 * The method to set the value to posY
	 * @param posY An Integer representing the posY
	 */
	public void setPosY(Integer posY)
	{
		 this.posY = posY;

		 this.keyModified.put("pos_y", 1);

	}

	/**
	 * The method to get the value of posX
	 * @return An Integer representing the posX
	 */
	public Integer getPosX()
	{
		return  this.posX;

	}

	/**
	 * The method to set the value to posX
	 * @param posX An Integer representing the posX
	 */
	public void setPosX(Integer posX)
	{
		 this.posX = posX;

		 this.keyModified.put("pos_x", 1);

	}

	/**
	 * The method to get the value of startNode
	 * @return A Boolean representing the startNode
	 */
	public Boolean getStartNode()
	{
		return  this.startNode;

	}

	/**
	 * The method to set the value to startNode
	 * @param startNode A Boolean representing the startNode
	 */
	public void setStartNode(Boolean startNode)
	{
		 this.startNode = startNode;

		 this.keyModified.put("start_node", 1);

	}

	/**
	 * The method to get the value of screen
	 * @return An instance of Screen
	 */
	public Screen getScreen()
	{
		return  this.screen;

	}

	/**
	 * The method to set the value to screen
	 * @param screen An instance of Screen
	 */
	public void setScreen(Screen screen)
	{
		 this.screen = screen;

		 this.keyModified.put("screen", 1);

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