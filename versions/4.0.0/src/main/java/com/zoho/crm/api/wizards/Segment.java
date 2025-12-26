package com.zoho.crm.api.wizards;

import com.zoho.crm.api.fields.Fields;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class Segment implements Model
{
	private Integer sequenceNumber;

	private String displayLabel;

	private Integer columnCount;

	private Long id;

	private String type;

	private List<Fields> fields;

	private List<Button> buttons;

	private List<Element> elements;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


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
	 * The method to get the value of columnCount
	 * @return An Integer representing the columnCount
	 */
	public Integer getColumnCount()
	{
		return  this.columnCount;

	}

	/**
	 * The method to set the value to columnCount
	 * @param columnCount An Integer representing the columnCount
	 */
	public void setColumnCount(Integer columnCount)
	{
		 this.columnCount = columnCount;

		 this.keyModified.put("column_count", 1);

	}

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
	 * The method to get the value of fields
	 * @return An instance of List<Fields>
	 */
	public List<Fields> getFields()
	{
		return  this.fields;

	}

	/**
	 * The method to set the value to fields
	 * @param fields An instance of List<Fields>
	 */
	public void setFields(List<Fields> fields)
	{
		 this.fields = fields;

		 this.keyModified.put("fields", 1);

	}

	/**
	 * The method to get the value of buttons
	 * @return An instance of List<Button>
	 */
	public List<Button> getButtons()
	{
		return  this.buttons;

	}

	/**
	 * The method to set the value to buttons
	 * @param buttons An instance of List<Button>
	 */
	public void setButtons(List<Button> buttons)
	{
		 this.buttons = buttons;

		 this.keyModified.put("buttons", 1);

	}

	/**
	 * The method to get the value of elements
	 * @return An instance of List<Element>
	 */
	public List<Element> getElements()
	{
		return  this.elements;

	}

	/**
	 * The method to set the value to elements
	 * @param elements An instance of List<Element>
	 */
	public void setElements(List<Element> elements)
	{
		 this.elements = elements;

		 this.keyModified.put("elements", 1);

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