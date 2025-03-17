package com.zoho.crm.api.signalsnotifications;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class Signals implements Model
{
	private String signalNamespace;

	private String email;

	private String subject;

	private String message;

	private String module;

	private Long id;

	private List<Action> actions;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of signalNamespace
	 * @return A String representing the signalNamespace
	 */
	public String getSignalNamespace()
	{
		return  this.signalNamespace;

	}

	/**
	 * The method to set the value to signalNamespace
	 * @param signalNamespace A String representing the signalNamespace
	 */
	public void setSignalNamespace(String signalNamespace)
	{
		 this.signalNamespace = signalNamespace;

		 this.keyModified.put("signal_namespace", 1);

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
	 * The method to get the value of subject
	 * @return A String representing the subject
	 */
	public String getSubject()
	{
		return  this.subject;

	}

	/**
	 * The method to set the value to subject
	 * @param subject A String representing the subject
	 */
	public void setSubject(String subject)
	{
		 this.subject = subject;

		 this.keyModified.put("subject", 1);

	}

	/**
	 * The method to get the value of message
	 * @return A String representing the message
	 */
	public String getMessage()
	{
		return  this.message;

	}

	/**
	 * The method to set the value to message
	 * @param message A String representing the message
	 */
	public void setMessage(String message)
	{
		 this.message = message;

		 this.keyModified.put("message", 1);

	}

	/**
	 * The method to get the value of module
	 * @return A String representing the module
	 */
	public String getModule()
	{
		return  this.module;

	}

	/**
	 * The method to set the value to module
	 * @param module A String representing the module
	 */
	public void setModule(String module)
	{
		 this.module = module;

		 this.keyModified.put("module", 1);

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
	 * The method to get the value of actions
	 * @return An instance of List<Action>
	 */
	public List<Action> getActions()
	{
		return  this.actions;

	}

	/**
	 * The method to set the value to actions
	 * @param actions An instance of List<Action>
	 */
	public void setActions(List<Action> actions)
	{
		 this.actions = actions;

		 this.keyModified.put("actions", 1);

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