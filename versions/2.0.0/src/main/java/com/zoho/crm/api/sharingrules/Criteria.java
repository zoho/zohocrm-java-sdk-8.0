package com.zoho.crm.api.sharingrules;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class Criteria implements Model
{
	private String groupOperator;

	private List<Criteria> group;

	private String comparator;

	private Field field;

	private Object value;

	private String type;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of groupOperator
	 * @return A String representing the groupOperator
	 */
	public String getGroupOperator()
	{
		return  this.groupOperator;

	}

	/**
	 * The method to set the value to groupOperator
	 * @param groupOperator A String representing the groupOperator
	 */
	public void setGroupOperator(String groupOperator)
	{
		 this.groupOperator = groupOperator;

		 this.keyModified.put("group_operator", 1);

	}

	/**
	 * The method to get the value of group
	 * @return An instance of List<Criteria>
	 */
	public List<Criteria> getGroup()
	{
		return  this.group;

	}

	/**
	 * The method to set the value to group
	 * @param group An instance of List<Criteria>
	 */
	public void setGroup(List<Criteria> group)
	{
		 this.group = group;

		 this.keyModified.put("group", 1);

	}

	/**
	 * The method to get the value of comparator
	 * @return A String representing the comparator
	 */
	public String getComparator()
	{
		return  this.comparator;

	}

	/**
	 * The method to set the value to comparator
	 * @param comparator A String representing the comparator
	 */
	public void setComparator(String comparator)
	{
		 this.comparator = comparator;

		 this.keyModified.put("comparator", 1);

	}

	/**
	 * The method to get the value of field
	 * @return An instance of Field
	 */
	public Field getField()
	{
		return  this.field;

	}

	/**
	 * The method to set the value to field
	 * @param field An instance of Field
	 */
	public void setField(Field field)
	{
		 this.field = field;

		 this.keyModified.put("field", 1);

	}

	/**
	 * The method to get the value of value
	 * @return An instance of Object
	 */
	public Object getValue()
	{
		return  this.value;

	}

	/**
	 * The method to set the value to value
	 * @param value An instance of Object
	 */
	public void setValue(Object value)
	{
		 this.value = value;

		 this.keyModified.put("value", 1);

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