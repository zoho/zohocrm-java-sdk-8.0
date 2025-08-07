package com.zoho.crm.api.usergroups;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class SourcesCount implements Model
{
	private Integer territories;

	private Integer roles;

	private Integer groups;

	private Users users;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of territories
	 * @return An Integer representing the territories
	 */
	public Integer getTerritories()
	{
		return  this.territories;

	}

	/**
	 * The method to set the value to territories
	 * @param territories An Integer representing the territories
	 */
	public void setTerritories(Integer territories)
	{
		 this.territories = territories;

		 this.keyModified.put("territories", 1);

	}

	/**
	 * The method to get the value of roles
	 * @return An Integer representing the roles
	 */
	public Integer getRoles()
	{
		return  this.roles;

	}

	/**
	 * The method to set the value to roles
	 * @param roles An Integer representing the roles
	 */
	public void setRoles(Integer roles)
	{
		 this.roles = roles;

		 this.keyModified.put("roles", 1);

	}

	/**
	 * The method to get the value of groups
	 * @return An Integer representing the groups
	 */
	public Integer getGroups()
	{
		return  this.groups;

	}

	/**
	 * The method to set the value to groups
	 * @param groups An Integer representing the groups
	 */
	public void setGroups(Integer groups)
	{
		 this.groups = groups;

		 this.keyModified.put("groups", 1);

	}

	/**
	 * The method to get the value of users
	 * @return An instance of Users
	 */
	public Users getUsers()
	{
		return  this.users;

	}

	/**
	 * The method to set the value to users
	 * @param users An instance of Users
	 */
	public void setUsers(Users users)
	{
		 this.users = users;

		 this.keyModified.put("users", 1);

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