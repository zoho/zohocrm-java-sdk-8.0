package com.zoho.crm.api.webforms;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Fields implements Model
{
	private Layout layout;

	private String help;

	private Fields field;

	private Module module;

	private String secretKey;

	private String recaptchaLabel;

	private Boolean hidden;

	private String siteKey;

	private Boolean advanced;

	private String apiName;

	private String fieldLabel;

	private String theme;

	private Long id;

	private Boolean required;

	private String fieldName;

	private String dateFormat;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of layout
	 * @return An instance of Layout
	 */
	public Layout getLayout()
	{
		return  this.layout;

	}

	/**
	 * The method to set the value to layout
	 * @param layout An instance of Layout
	 */
	public void setLayout(Layout layout)
	{
		 this.layout = layout;

		 this.keyModified.put("layout", 1);

	}

	/**
	 * The method to get the value of help
	 * @return A String representing the help
	 */
	public String getHelp()
	{
		return  this.help;

	}

	/**
	 * The method to set the value to help
	 * @param help A String representing the help
	 */
	public void setHelp(String help)
	{
		 this.help = help;

		 this.keyModified.put("help", 1);

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
	 * The method to get the value of module
	 * @return An instance of Module
	 */
	public Module getModule()
	{
		return  this.module;

	}

	/**
	 * The method to set the value to module
	 * @param module An instance of Module
	 */
	public void setModule(Module module)
	{
		 this.module = module;

		 this.keyModified.put("module", 1);

	}

	/**
	 * The method to get the value of secretKey
	 * @return A String representing the secretKey
	 */
	public String getSecretKey()
	{
		return  this.secretKey;

	}

	/**
	 * The method to set the value to secretKey
	 * @param secretKey A String representing the secretKey
	 */
	public void setSecretKey(String secretKey)
	{
		 this.secretKey = secretKey;

		 this.keyModified.put("secret_key", 1);

	}

	/**
	 * The method to get the value of recaptchaLabel
	 * @return A String representing the recaptchaLabel
	 */
	public String getRecaptchaLabel()
	{
		return  this.recaptchaLabel;

	}

	/**
	 * The method to set the value to recaptchaLabel
	 * @param recaptchaLabel A String representing the recaptchaLabel
	 */
	public void setRecaptchaLabel(String recaptchaLabel)
	{
		 this.recaptchaLabel = recaptchaLabel;

		 this.keyModified.put("recaptcha_label", 1);

	}

	/**
	 * The method to get the value of hidden
	 * @return A Boolean representing the hidden
	 */
	public Boolean getHidden()
	{
		return  this.hidden;

	}

	/**
	 * The method to set the value to hidden
	 * @param hidden A Boolean representing the hidden
	 */
	public void setHidden(Boolean hidden)
	{
		 this.hidden = hidden;

		 this.keyModified.put("hidden", 1);

	}

	/**
	 * The method to get the value of siteKey
	 * @return A String representing the siteKey
	 */
	public String getSiteKey()
	{
		return  this.siteKey;

	}

	/**
	 * The method to set the value to siteKey
	 * @param siteKey A String representing the siteKey
	 */
	public void setSiteKey(String siteKey)
	{
		 this.siteKey = siteKey;

		 this.keyModified.put("site_key", 1);

	}

	/**
	 * The method to get the value of advanced
	 * @return A Boolean representing the advanced
	 */
	public Boolean getAdvanced()
	{
		return  this.advanced;

	}

	/**
	 * The method to set the value to advanced
	 * @param advanced A Boolean representing the advanced
	 */
	public void setAdvanced(Boolean advanced)
	{
		 this.advanced = advanced;

		 this.keyModified.put("advanced", 1);

	}

	/**
	 * The method to get the value of apiName
	 * @return A String representing the apiName
	 */
	public String getAPIName()
	{
		return  this.apiName;

	}

	/**
	 * The method to set the value to apiName
	 * @param apiName A String representing the apiName
	 */
	public void setAPIName(String apiName)
	{
		 this.apiName = apiName;

		 this.keyModified.put("api_name", 1);

	}

	/**
	 * The method to get the value of fieldLabel
	 * @return A String representing the fieldLabel
	 */
	public String getFieldLabel()
	{
		return  this.fieldLabel;

	}

	/**
	 * The method to set the value to fieldLabel
	 * @param fieldLabel A String representing the fieldLabel
	 */
	public void setFieldLabel(String fieldLabel)
	{
		 this.fieldLabel = fieldLabel;

		 this.keyModified.put("field_label", 1);

	}

	/**
	 * The method to get the value of theme
	 * @return A String representing the theme
	 */
	public String getTheme()
	{
		return  this.theme;

	}

	/**
	 * The method to set the value to theme
	 * @param theme A String representing the theme
	 */
	public void setTheme(String theme)
	{
		 this.theme = theme;

		 this.keyModified.put("theme", 1);

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
	 * The method to get the value of required
	 * @return A Boolean representing the required
	 */
	public Boolean getRequired()
	{
		return  this.required;

	}

	/**
	 * The method to set the value to required
	 * @param required A Boolean representing the required
	 */
	public void setRequired(Boolean required)
	{
		 this.required = required;

		 this.keyModified.put("required", 1);

	}

	/**
	 * The method to get the value of fieldName
	 * @return A String representing the fieldName
	 */
	public String getFieldName()
	{
		return  this.fieldName;

	}

	/**
	 * The method to set the value to fieldName
	 * @param fieldName A String representing the fieldName
	 */
	public void setFieldName(String fieldName)
	{
		 this.fieldName = fieldName;

		 this.keyModified.put("field_name", 1);

	}

	/**
	 * The method to get the value of dateFormat
	 * @return A String representing the dateFormat
	 */
	public String getDateFormat()
	{
		return  this.dateFormat;

	}

	/**
	 * The method to set the value to dateFormat
	 * @param dateFormat A String representing the dateFormat
	 */
	public void setDateFormat(String dateFormat)
	{
		 this.dateFormat = dateFormat;

		 this.keyModified.put("date_format", 1);

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