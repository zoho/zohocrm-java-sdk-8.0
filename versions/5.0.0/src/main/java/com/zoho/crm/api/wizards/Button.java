package com.zoho.crm.api.wizards;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Button implements Model
{
	private Long id;

	private Integer sequenceNumber;

	private String displayLabel;

	private Criteria criteria;

	private Screen targetScreen;

	private String type;

	private Message message;

	private String color;

	private String shape;

	private String backgroundColor;

	private String visibility;

	private Object resource;

	private Transition transition;

	private String category;

	private String referenceId;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


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
	 * The method to get the value of sequenceNumber
	 * @return An Integer representing the sequenceNumber
	 */
	public Integer getSequenceNumber()
	{
		return  this.sequenceNumber;

	}

	/**
	 * The method to set the value to sequenceNumber
	 * @param sequenceNumber An Integer representing the sequenceNumber
	 */
	public void setSequenceNumber(Integer sequenceNumber)
	{
		 this.sequenceNumber = sequenceNumber;

		 this.keyModified.put("sequence_number", 1);

	}

	/**
	 * The method to get the value of displayLabel
	 * @return A String representing the displayLabel
	 */
	public String getDisplayLabel()
	{
		return  this.displayLabel;

	}

	/**
	 * The method to set the value to displayLabel
	 * @param displayLabel A String representing the displayLabel
	 */
	public void setDisplayLabel(String displayLabel)
	{
		 this.displayLabel = displayLabel;

		 this.keyModified.put("display_label", 1);

	}

	/**
	 * The method to get the value of criteria
	 * @return An instance of Criteria
	 */
	public Criteria getCriteria()
	{
		return  this.criteria;

	}

	/**
	 * The method to set the value to criteria
	 * @param criteria An instance of Criteria
	 */
	public void setCriteria(Criteria criteria)
	{
		 this.criteria = criteria;

		 this.keyModified.put("criteria", 1);

	}

	/**
	 * The method to get the value of targetScreen
	 * @return An instance of Screen
	 */
	public Screen getTargetScreen()
	{
		return  this.targetScreen;

	}

	/**
	 * The method to set the value to targetScreen
	 * @param targetScreen An instance of Screen
	 */
	public void setTargetScreen(Screen targetScreen)
	{
		 this.targetScreen = targetScreen;

		 this.keyModified.put("target_screen", 1);

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
	 * The method to get the value of message
	 * @return An instance of Message
	 */
	public Message getMessage()
	{
		return  this.message;

	}

	/**
	 * The method to set the value to message
	 * @param message An instance of Message
	 */
	public void setMessage(Message message)
	{
		 this.message = message;

		 this.keyModified.put("message", 1);

	}

	/**
	 * The method to get the value of color
	 * @return A String representing the color
	 */
	public String getColor()
	{
		return  this.color;

	}

	/**
	 * The method to set the value to color
	 * @param color A String representing the color
	 */
	public void setColor(String color)
	{
		 this.color = color;

		 this.keyModified.put("color", 1);

	}

	/**
	 * The method to get the value of shape
	 * @return A String representing the shape
	 */
	public String getShape()
	{
		return  this.shape;

	}

	/**
	 * The method to set the value to shape
	 * @param shape A String representing the shape
	 */
	public void setShape(String shape)
	{
		 this.shape = shape;

		 this.keyModified.put("shape", 1);

	}

	/**
	 * The method to get the value of backgroundColor
	 * @return A String representing the backgroundColor
	 */
	public String getBackgroundColor()
	{
		return  this.backgroundColor;

	}

	/**
	 * The method to set the value to backgroundColor
	 * @param backgroundColor A String representing the backgroundColor
	 */
	public void setBackgroundColor(String backgroundColor)
	{
		 this.backgroundColor = backgroundColor;

		 this.keyModified.put("background_color", 1);

	}

	/**
	 * The method to get the value of visibility
	 * @return A String representing the visibility
	 */
	public String getVisibility()
	{
		return  this.visibility;

	}

	/**
	 * The method to set the value to visibility
	 * @param visibility A String representing the visibility
	 */
	public void setVisibility(String visibility)
	{
		 this.visibility = visibility;

		 this.keyModified.put("visibility", 1);

	}

	/**
	 * The method to get the value of resource
	 * @return An instance of Object
	 */
	public Object getResource()
	{
		return  this.resource;

	}

	/**
	 * The method to set the value to resource
	 * @param resource An instance of Object
	 */
	public void setResource(Object resource)
	{
		 this.resource = resource;

		 this.keyModified.put("resource", 1);

	}

	/**
	 * The method to get the value of transition
	 * @return An instance of Transition
	 */
	public Transition getTransition()
	{
		return  this.transition;

	}

	/**
	 * The method to set the value to transition
	 * @param transition An instance of Transition
	 */
	public void setTransition(Transition transition)
	{
		 this.transition = transition;

		 this.keyModified.put("transition", 1);

	}

	/**
	 * The method to get the value of category
	 * @return A String representing the category
	 */
	public String getCategory()
	{
		return  this.category;

	}

	/**
	 * The method to set the value to category
	 * @param category A String representing the category
	 */
	public void setCategory(String category)
	{
		 this.category = category;

		 this.keyModified.put("category", 1);

	}

	/**
	 * The method to get the value of referenceId
	 * @return A String representing the referenceId
	 */
	public String getReferenceId()
	{
		return  this.referenceId;

	}

	/**
	 * The method to set the value to referenceId
	 * @param referenceId A String representing the referenceId
	 */
	public void setReferenceId(String referenceId)
	{
		 this.referenceId = referenceId;

		 this.keyModified.put("reference_id", 1);

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