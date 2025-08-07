package com.zoho.crm.api.coql;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class ParseErrorDetails implements Model, DetailsWrapper
{
	private Integer line;

	private Integer column;

	private String near;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of line
	 * @return An Integer representing the line
	 */
	public Integer getLine()
	{
		return  this.line;

	}

	/**
	 * The method to set the value to line
	 * @param line An Integer representing the line
	 */
	public void setLine(Integer line)
	{
		 this.line = line;

		 this.keyModified.put("line", 1);

	}

	/**
	 * The method to get the value of column
	 * @return An Integer representing the column
	 */
	public Integer getColumn()
	{
		return  this.column;

	}

	/**
	 * The method to set the value to column
	 * @param column An Integer representing the column
	 */
	public void setColumn(Integer column)
	{
		 this.column = column;

		 this.keyModified.put("column", 1);

	}

	/**
	 * The method to get the value of near
	 * @return A String representing the near
	 */
	public String getNear()
	{
		return  this.near;

	}

	/**
	 * The method to set the value to near
	 * @param near A String representing the near
	 */
	public void setNear(String near)
	{
		 this.near = near;

		 this.keyModified.put("near", 1);

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