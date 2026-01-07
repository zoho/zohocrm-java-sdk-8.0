package com.zoho.crm.api.shifthours;

import com.zoho.crm.api.util.Model;
import java.time.LocalDate;
import java.util.HashMap;

public class Users implements Model
{
	private Role role;

	private String name;

	private Long id;

	private String email;

	private String zuid;

	private LocalDate effectiveFrom;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of role
	 * @return An instance of Role
	 */
	public Role getRole()
	{
		return  this.role;

	}

	/**
	 * The method to set the value to role
	 * @param role An instance of Role
	 */
	public void setRole(Role role)
	{
		 this.role = role;

		 this.keyModified.put("role", 1);

	}

	/**
	 * The method to get the value of name
	 * @return A String representing the name
	 */
	public String getName()
	{
		return  this.name;

	}

	/**
	 * The method to set the value to name
	 * @param name A String representing the name
	 */
	public void setName(String name)
	{
		 this.name = name;

		 this.keyModified.put("name", 1);

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
	 * The method to get the value of email
	 * @return A String representing the email
	 */
	public String getEmail()
	{
		return  this.email;

	}

	/**
	 * The method to set the value to email
	 * @param email A String representing the email
	 */
	public void setEmail(String email)
	{
		 this.email = email;

		 this.keyModified.put("email", 1);

	}

	/**
	 * The method to get the value of zuid
	 * @return A String representing the zuid
	 */
	public String getZuid()
	{
		return  this.zuid;

	}

	/**
	 * The method to set the value to zuid
	 * @param zuid A String representing the zuid
	 */
	public void setZuid(String zuid)
	{
		 this.zuid = zuid;

		 this.keyModified.put("zuid", 1);

	}

	/**
	 * The method to get the value of effectiveFrom
	 * @return An instance of LocalDate
	 */
	public LocalDate getEffectiveFrom()
	{
		return  this.effectiveFrom;

	}

	/**
	 * The method to set the value to effectiveFrom
	 * @param effectiveFrom An instance of LocalDate
	 */
	public void setEffectiveFrom(LocalDate effectiveFrom)
	{
		 this.effectiveFrom = effectiveFrom;

		 this.keyModified.put("effective_from", 1);

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