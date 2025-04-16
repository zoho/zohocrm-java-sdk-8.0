package com.zoho.crm.api.fieldmapdependency;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class MapDependency implements Model
{
	private Parent parent;

	private Child child;

	private List<PickListMapping> pickListValues;

	private Boolean internal;

	private Boolean active;

	private Long id;

	private Integer source;

	private Integer category;

	private SubModule subModule;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of parent
	 * @return An instance of Parent
	 */
	public Parent getParent()
	{
		return  this.parent;

	}

	/**
	 * The method to set the value to parent
	 * @param parent An instance of Parent
	 */
	public void setParent(Parent parent)
	{
		 this.parent = parent;

		 this.keyModified.put("parent", 1);

	}

	/**
	 * The method to get the value of child
	 * @return An instance of Child
	 */
	public Child getChild()
	{
		return  this.child;

	}

	/**
	 * The method to set the value to child
	 * @param child An instance of Child
	 */
	public void setChild(Child child)
	{
		 this.child = child;

		 this.keyModified.put("child", 1);

	}

	/**
	 * The method to get the value of pickListValues
	 * @return An instance of List<PickListMapping>
	 */
	public List<PickListMapping> getPickListValues()
	{
		return  this.pickListValues;

	}

	/**
	 * The method to set the value to pickListValues
	 * @param pickListValues An instance of List<PickListMapping>
	 */
	public void setPickListValues(List<PickListMapping> pickListValues)
	{
		 this.pickListValues = pickListValues;

		 this.keyModified.put("pick_list_values", 1);

	}

	/**
	 * The method to get the value of internal
	 * @return A Boolean representing the internal
	 */
	public Boolean getInternal()
	{
		return  this.internal;

	}

	/**
	 * The method to set the value to internal
	 * @param internal A Boolean representing the internal
	 */
	public void setInternal(Boolean internal)
	{
		 this.internal = internal;

		 this.keyModified.put("internal", 1);

	}

	/**
	 * The method to get the value of active
	 * @return A Boolean representing the active
	 */
	public Boolean getActive()
	{
		return  this.active;

	}

	/**
	 * The method to set the value to active
	 * @param active A Boolean representing the active
	 */
	public void setActive(Boolean active)
	{
		 this.active = active;

		 this.keyModified.put("active", 1);

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
	 * The method to get the value of source
	 * @return An Integer representing the source
	 */
	public Integer getSource()
	{
		return  this.source;

	}

	/**
	 * The method to set the value to source
	 * @param source An Integer representing the source
	 */
	public void setSource(Integer source)
	{
		 this.source = source;

		 this.keyModified.put("source", 1);

	}

	/**
	 * The method to get the value of category
	 * @return An Integer representing the category
	 */
	public Integer getCategory()
	{
		return  this.category;

	}

	/**
	 * The method to set the value to category
	 * @param category An Integer representing the category
	 */
	public void setCategory(Integer category)
	{
		 this.category = category;

		 this.keyModified.put("category", 1);

	}

	/**
	 * The method to get the value of subModule
	 * @return An instance of SubModule
	 */
	public SubModule getSubModule()
	{
		return  this.subModule;

	}

	/**
	 * The method to set the value to subModule
	 * @param subModule An instance of SubModule
	 */
	public void setSubModule(SubModule subModule)
	{
		 this.subModule = subModule;

		 this.keyModified.put("sub_module", 1);

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