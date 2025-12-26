package com.zoho.crm.api.wizards;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class ChartData implements Model
{
	private List<Node> nodes;

	private List<Connection> connections;

	private ButtonBackground colorPalette;

	private Integer canvasWidth;

	private Integer canvasHeight;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of nodes
	 * @return An instance of List<Node>
	 */
	public List<Node> getNodes()
	{
		return  this.nodes;

	}

	/**
	 * The method to set the value to nodes
	 * @param nodes An instance of List<Node>
	 */
	public void setNodes(List<Node> nodes)
	{
		 this.nodes = nodes;

		 this.keyModified.put("nodes", 1);

	}

	/**
	 * The method to get the value of connections
	 * @return An instance of List<Connection>
	 */
	public List<Connection> getConnections()
	{
		return  this.connections;

	}

	/**
	 * The method to set the value to connections
	 * @param connections An instance of List<Connection>
	 */
	public void setConnections(List<Connection> connections)
	{
		 this.connections = connections;

		 this.keyModified.put("connections", 1);

	}

	/**
	 * The method to get the value of colorPalette
	 * @return An instance of ButtonBackground
	 */
	public ButtonBackground getColorPalette()
	{
		return  this.colorPalette;

	}

	/**
	 * The method to set the value to colorPalette
	 * @param colorPalette An instance of ButtonBackground
	 */
	public void setColorPalette(ButtonBackground colorPalette)
	{
		 this.colorPalette = colorPalette;

		 this.keyModified.put("color_palette", 1);

	}

	/**
	 * The method to get the value of canvasWidth
	 * @return An Integer representing the canvasWidth
	 */
	public Integer getCanvasWidth()
	{
		return  this.canvasWidth;

	}

	/**
	 * The method to set the value to canvasWidth
	 * @param canvasWidth An Integer representing the canvasWidth
	 */
	public void setCanvasWidth(Integer canvasWidth)
	{
		 this.canvasWidth = canvasWidth;

		 this.keyModified.put("canvas_width", 1);

	}

	/**
	 * The method to get the value of canvasHeight
	 * @return An Integer representing the canvasHeight
	 */
	public Integer getCanvasHeight()
	{
		return  this.canvasHeight;

	}

	/**
	 * The method to set the value to canvasHeight
	 * @param canvasHeight An Integer representing the canvasHeight
	 */
	public void setCanvasHeight(Integer canvasHeight)
	{
		 this.canvasHeight = canvasHeight;

		 this.keyModified.put("canvas_height", 1);

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