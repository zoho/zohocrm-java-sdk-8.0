package com.zoho.crm.api.picklistvalues;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class PickListValues implements Model
{
	private Integer sequenceNumber;

	private String displayValue;

	private String referenceValue;

	private String colourCode;

	private String actualValue;

	private Long id;

	private String type;

	private List<LayoutAssociation> layoutAssociations;

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
	 * The method to get the value of displayValue
	 * @return A String representing the displayValue
	 */
	public String getDisplayValue()
	{
		return  this.displayValue;

	}

	/**
	 * The method to set the value to displayValue
	 * @param displayValue A String representing the displayValue
	 */
	public void setDisplayValue(String displayValue)
	{
		 this.displayValue = displayValue;

		 this.keyModified.put("display_value", 1);

	}

	/**
	 * The method to get the value of referenceValue
	 * @return A String representing the referenceValue
	 */
	public String getReferenceValue()
	{
		return  this.referenceValue;

	}

	/**
	 * The method to set the value to referenceValue
	 * @param referenceValue A String representing the referenceValue
	 */
	public void setReferenceValue(String referenceValue)
	{
		 this.referenceValue = referenceValue;

		 this.keyModified.put("reference_value", 1);

	}

	/**
	 * The method to get the value of colourCode
	 * @return A String representing the colourCode
	 */
	public String getColourCode()
	{
		return  this.colourCode;

	}

	/**
	 * The method to set the value to colourCode
	 * @param colourCode A String representing the colourCode
	 */
	public void setColourCode(String colourCode)
	{
		 this.colourCode = colourCode;

		 this.keyModified.put("colour_code", 1);

	}

	/**
	 * The method to get the value of actualValue
	 * @return A String representing the actualValue
	 */
	public String getActualValue()
	{
		return  this.actualValue;

	}

	/**
	 * The method to set the value to actualValue
	 * @param actualValue A String representing the actualValue
	 */
	public void setActualValue(String actualValue)
	{
		 this.actualValue = actualValue;

		 this.keyModified.put("actual_value", 1);

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
	 * The method to get the value of layoutAssociations
	 * @return An instance of List<LayoutAssociation>
	 */
	public List<LayoutAssociation> getLayoutAssociations()
	{
		return  this.layoutAssociations;

	}

	/**
	 * The method to set the value to layoutAssociations
	 * @param layoutAssociations An instance of List<LayoutAssociation>
	 */
	public void setLayoutAssociations(List<LayoutAssociation> layoutAssociations)
	{
		 this.layoutAssociations = layoutAssociations;

		 this.keyModified.put("layout_associations", 1);

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