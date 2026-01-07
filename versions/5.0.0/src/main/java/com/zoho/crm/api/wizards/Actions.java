package com.zoho.crm.api.wizards;

import com.zoho.crm.api.fields.Fields;
import com.zoho.crm.api.profiles.Profile;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class Actions implements Model
{
	private Long id;

	private String type;

	private Segment segment;

	private Fields fields;

	private Fields field;

	private Object value;

	private List<Profile> exemptedProfiles;

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
	 * The method to get the value of segment
	 * @return An instance of Segment
	 */
	public Segment getSegment()
	{
		return  this.segment;

	}

	/**
	 * The method to set the value to segment
	 * @param segment An instance of Segment
	 */
	public void setSegment(Segment segment)
	{
		 this.segment = segment;

		 this.keyModified.put("segment", 1);

	}

	/**
	 * The method to get the value of fields
	 * @return An instance of Fields
	 */
	public Fields getFields()
	{
		return  this.fields;

	}

	/**
	 * The method to set the value to fields
	 * @param fields An instance of Fields
	 */
	public void setFields(Fields fields)
	{
		 this.fields = fields;

		 this.keyModified.put("fields", 1);

	}

	/**
	 * The method to get the value of field
	 * @return An instance of Fields
	 */
	public Fields getField()
	{
		return  this.field;

	}

	/**
	 * The method to set the value to field
	 * @param field An instance of Fields
	 */
	public void setField(Fields field)
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
	 * The method to get the value of exemptedProfiles
	 * @return An instance of List<Profile>
	 */
	public List<Profile> getExemptedProfiles()
	{
		return  this.exemptedProfiles;

	}

	/**
	 * The method to set the value to exemptedProfiles
	 * @param exemptedProfiles An instance of List<Profile>
	 */
	public void setExemptedProfiles(List<Profile> exemptedProfiles)
	{
		 this.exemptedProfiles = exemptedProfiles;

		 this.keyModified.put("exempted_profiles", 1);

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