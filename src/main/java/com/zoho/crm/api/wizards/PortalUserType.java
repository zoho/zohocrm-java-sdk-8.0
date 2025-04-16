package com.zoho.crm.api.wizards;

import com.zoho.crm.api.layouts.Layouts;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class PortalUserType implements Model
{
	private Long id;

	private Layouts layout;

	private ChartData chartData;

	private List<Screen> screens;

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
	 * The method to get the value of layout
	 * @return An instance of Layouts
	 */
	public Layouts getLayout()
	{
		return  this.layout;

	}

	/**
	 * The method to set the value to layout
	 * @param layout An instance of Layouts
	 */
	public void setLayout(Layouts layout)
	{
		 this.layout = layout;

		 this.keyModified.put("layout", 1);

	}

	/**
	 * The method to get the value of chartData
	 * @return An instance of ChartData
	 */
	public ChartData getChartData()
	{
		return  this.chartData;

	}

	/**
	 * The method to set the value to chartData
	 * @param chartData An instance of ChartData
	 */
	public void setChartData(ChartData chartData)
	{
		 this.chartData = chartData;

		 this.keyModified.put("chart_data", 1);

	}

	/**
	 * The method to get the value of screens
	 * @return An instance of List<Screen>
	 */
	public List<Screen> getScreens()
	{
		return  this.screens;

	}

	/**
	 * The method to set the value to screens
	 * @param screens An instance of List<Screen>
	 */
	public void setScreens(List<Screen> screens)
	{
		 this.screens = screens;

		 this.keyModified.put("screens", 1);

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