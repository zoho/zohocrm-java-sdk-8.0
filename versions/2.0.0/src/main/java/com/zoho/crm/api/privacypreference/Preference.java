package com.zoho.crm.api.privacypreference;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Preference implements Model
{
	private String consentModules;

	private String restrictTptFields;

	private String excludeAPIZoho;

	private String awaitingPeriod;

	private String consentMailSend;

	private String excludeExportFields;

	private String limitActions;

	private String excludeExport;

	private String restrictZohoInteg;

	private String excludeAPIZohoFields;

	private String durationTiming;

	private String dataProcessingDuration;

	private String restrictTptServices;

	private String excludeAPITptFields;

	private String restrictZohoIntegServices;

	private String privacySettingStatus;

	private String doubleOptIn;

	private String restrictZohoIntegFields;

	private String excludeAPITpt;

	private String blockList;

	private String restrictTpt;

	private String actionsWhileAwaiting;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of consentModules
	 * @return A String representing the consentModules
	 */
	public String getConsentModules()
	{
		return  this.consentModules;

	}

	/**
	 * The method to set the value to consentModules
	 * @param consentModules A String representing the consentModules
	 */
	public void setConsentModules(String consentModules)
	{
		 this.consentModules = consentModules;

		 this.keyModified.put("consent_modules", 1);

	}

	/**
	 * The method to get the value of restrictTptFields
	 * @return A String representing the restrictTptFields
	 */
	public String getRestrictTptFields()
	{
		return  this.restrictTptFields;

	}

	/**
	 * The method to set the value to restrictTptFields
	 * @param restrictTptFields A String representing the restrictTptFields
	 */
	public void setRestrictTptFields(String restrictTptFields)
	{
		 this.restrictTptFields = restrictTptFields;

		 this.keyModified.put("restrict_tpt_fields", 1);

	}

	/**
	 * The method to get the value of excludeapiZoho
	 * @return A String representing the excludeAPIZoho
	 */
	public String getExcludeAPIZoho()
	{
		return  this.excludeAPIZoho;

	}

	/**
	 * The method to set the value to excludeapiZoho
	 * @param excludeAPIZoho A String representing the excludeAPIZoho
	 */
	public void setExcludeAPIZoho(String excludeAPIZoho)
	{
		 this.excludeAPIZoho = excludeAPIZoho;

		 this.keyModified.put("exclude_api_zoho", 1);

	}

	/**
	 * The method to get the value of awaitingPeriod
	 * @return A String representing the awaitingPeriod
	 */
	public String getAwaitingPeriod()
	{
		return  this.awaitingPeriod;

	}

	/**
	 * The method to set the value to awaitingPeriod
	 * @param awaitingPeriod A String representing the awaitingPeriod
	 */
	public void setAwaitingPeriod(String awaitingPeriod)
	{
		 this.awaitingPeriod = awaitingPeriod;

		 this.keyModified.put("awaiting_period", 1);

	}

	/**
	 * The method to get the value of consentMailSend
	 * @return A String representing the consentMailSend
	 */
	public String getConsentMailSend()
	{
		return  this.consentMailSend;

	}

	/**
	 * The method to set the value to consentMailSend
	 * @param consentMailSend A String representing the consentMailSend
	 */
	public void setConsentMailSend(String consentMailSend)
	{
		 this.consentMailSend = consentMailSend;

		 this.keyModified.put("consent_mail_send", 1);

	}

	/**
	 * The method to get the value of excludeExportFields
	 * @return A String representing the excludeExportFields
	 */
	public String getExcludeExportFields()
	{
		return  this.excludeExportFields;

	}

	/**
	 * The method to set the value to excludeExportFields
	 * @param excludeExportFields A String representing the excludeExportFields
	 */
	public void setExcludeExportFields(String excludeExportFields)
	{
		 this.excludeExportFields = excludeExportFields;

		 this.keyModified.put("exclude_export_fields", 1);

	}

	/**
	 * The method to get the value of limitActions
	 * @return A String representing the limitActions
	 */
	public String getLimitActions()
	{
		return  this.limitActions;

	}

	/**
	 * The method to set the value to limitActions
	 * @param limitActions A String representing the limitActions
	 */
	public void setLimitActions(String limitActions)
	{
		 this.limitActions = limitActions;

		 this.keyModified.put("limit_actions", 1);

	}

	/**
	 * The method to get the value of excludeExport
	 * @return A String representing the excludeExport
	 */
	public String getExcludeExport()
	{
		return  this.excludeExport;

	}

	/**
	 * The method to set the value to excludeExport
	 * @param excludeExport A String representing the excludeExport
	 */
	public void setExcludeExport(String excludeExport)
	{
		 this.excludeExport = excludeExport;

		 this.keyModified.put("exclude_export", 1);

	}

	/**
	 * The method to get the value of restrictZohoInteg
	 * @return A String representing the restrictZohoInteg
	 */
	public String getRestrictZohoInteg()
	{
		return  this.restrictZohoInteg;

	}

	/**
	 * The method to set the value to restrictZohoInteg
	 * @param restrictZohoInteg A String representing the restrictZohoInteg
	 */
	public void setRestrictZohoInteg(String restrictZohoInteg)
	{
		 this.restrictZohoInteg = restrictZohoInteg;

		 this.keyModified.put("restrict_zoho_integ", 1);

	}

	/**
	 * The method to get the value of excludeapiZohoFields
	 * @return A String representing the excludeAPIZohoFields
	 */
	public String getExcludeAPIZohoFields()
	{
		return  this.excludeAPIZohoFields;

	}

	/**
	 * The method to set the value to excludeapiZohoFields
	 * @param excludeAPIZohoFields A String representing the excludeAPIZohoFields
	 */
	public void setExcludeAPIZohoFields(String excludeAPIZohoFields)
	{
		 this.excludeAPIZohoFields = excludeAPIZohoFields;

		 this.keyModified.put("exclude_api_zoho_fields", 1);

	}

	/**
	 * The method to get the value of durationTiming
	 * @return A String representing the durationTiming
	 */
	public String getDurationTiming()
	{
		return  this.durationTiming;

	}

	/**
	 * The method to set the value to durationTiming
	 * @param durationTiming A String representing the durationTiming
	 */
	public void setDurationTiming(String durationTiming)
	{
		 this.durationTiming = durationTiming;

		 this.keyModified.put("duration_timing", 1);

	}

	/**
	 * The method to get the value of dataProcessingDuration
	 * @return A String representing the dataProcessingDuration
	 */
	public String getDataProcessingDuration()
	{
		return  this.dataProcessingDuration;

	}

	/**
	 * The method to set the value to dataProcessingDuration
	 * @param dataProcessingDuration A String representing the dataProcessingDuration
	 */
	public void setDataProcessingDuration(String dataProcessingDuration)
	{
		 this.dataProcessingDuration = dataProcessingDuration;

		 this.keyModified.put("data_processing_duration", 1);

	}

	/**
	 * The method to get the value of restrictTptServices
	 * @return A String representing the restrictTptServices
	 */
	public String getRestrictTptServices()
	{
		return  this.restrictTptServices;

	}

	/**
	 * The method to set the value to restrictTptServices
	 * @param restrictTptServices A String representing the restrictTptServices
	 */
	public void setRestrictTptServices(String restrictTptServices)
	{
		 this.restrictTptServices = restrictTptServices;

		 this.keyModified.put("restrict_tpt_services", 1);

	}

	/**
	 * The method to get the value of excludeapiTptFields
	 * @return A String representing the excludeAPITptFields
	 */
	public String getExcludeAPITptFields()
	{
		return  this.excludeAPITptFields;

	}

	/**
	 * The method to set the value to excludeapiTptFields
	 * @param excludeAPITptFields A String representing the excludeAPITptFields
	 */
	public void setExcludeAPITptFields(String excludeAPITptFields)
	{
		 this.excludeAPITptFields = excludeAPITptFields;

		 this.keyModified.put("exclude_api_tpt_fields", 1);

	}

	/**
	 * The method to get the value of restrictZohoIntegServices
	 * @return A String representing the restrictZohoIntegServices
	 */
	public String getRestrictZohoIntegServices()
	{
		return  this.restrictZohoIntegServices;

	}

	/**
	 * The method to set the value to restrictZohoIntegServices
	 * @param restrictZohoIntegServices A String representing the restrictZohoIntegServices
	 */
	public void setRestrictZohoIntegServices(String restrictZohoIntegServices)
	{
		 this.restrictZohoIntegServices = restrictZohoIntegServices;

		 this.keyModified.put("restrict_zoho_integ_services", 1);

	}

	/**
	 * The method to get the value of privacySettingStatus
	 * @return A String representing the privacySettingStatus
	 */
	public String getPrivacySettingStatus()
	{
		return  this.privacySettingStatus;

	}

	/**
	 * The method to set the value to privacySettingStatus
	 * @param privacySettingStatus A String representing the privacySettingStatus
	 */
	public void setPrivacySettingStatus(String privacySettingStatus)
	{
		 this.privacySettingStatus = privacySettingStatus;

		 this.keyModified.put("privacy_setting_status", 1);

	}

	/**
	 * The method to get the value of doubleOptIn
	 * @return A String representing the doubleOptIn
	 */
	public String getDoubleOptIn()
	{
		return  this.doubleOptIn;

	}

	/**
	 * The method to set the value to doubleOptIn
	 * @param doubleOptIn A String representing the doubleOptIn
	 */
	public void setDoubleOptIn(String doubleOptIn)
	{
		 this.doubleOptIn = doubleOptIn;

		 this.keyModified.put("double_opt_in", 1);

	}

	/**
	 * The method to get the value of restrictZohoIntegFields
	 * @return A String representing the restrictZohoIntegFields
	 */
	public String getRestrictZohoIntegFields()
	{
		return  this.restrictZohoIntegFields;

	}

	/**
	 * The method to set the value to restrictZohoIntegFields
	 * @param restrictZohoIntegFields A String representing the restrictZohoIntegFields
	 */
	public void setRestrictZohoIntegFields(String restrictZohoIntegFields)
	{
		 this.restrictZohoIntegFields = restrictZohoIntegFields;

		 this.keyModified.put("restrict_zoho_integ_fields", 1);

	}

	/**
	 * The method to get the value of excludeapiTpt
	 * @return A String representing the excludeAPITpt
	 */
	public String getExcludeAPITpt()
	{
		return  this.excludeAPITpt;

	}

	/**
	 * The method to set the value to excludeapiTpt
	 * @param excludeAPITpt A String representing the excludeAPITpt
	 */
	public void setExcludeAPITpt(String excludeAPITpt)
	{
		 this.excludeAPITpt = excludeAPITpt;

		 this.keyModified.put("exclude_api_tpt", 1);

	}

	/**
	 * The method to get the value of blockList
	 * @return A String representing the blockList
	 */
	public String getBlockList()
	{
		return  this.blockList;

	}

	/**
	 * The method to set the value to blockList
	 * @param blockList A String representing the blockList
	 */
	public void setBlockList(String blockList)
	{
		 this.blockList = blockList;

		 this.keyModified.put("block_list", 1);

	}

	/**
	 * The method to get the value of restrictTpt
	 * @return A String representing the restrictTpt
	 */
	public String getRestrictTpt()
	{
		return  this.restrictTpt;

	}

	/**
	 * The method to set the value to restrictTpt
	 * @param restrictTpt A String representing the restrictTpt
	 */
	public void setRestrictTpt(String restrictTpt)
	{
		 this.restrictTpt = restrictTpt;

		 this.keyModified.put("restrict_tpt", 1);

	}

	/**
	 * The method to get the value of actionsWhileAwaiting
	 * @return A String representing the actionsWhileAwaiting
	 */
	public String getActionsWhileAwaiting()
	{
		return  this.actionsWhileAwaiting;

	}

	/**
	 * The method to set the value to actionsWhileAwaiting
	 * @param actionsWhileAwaiting A String representing the actionsWhileAwaiting
	 */
	public void setActionsWhileAwaiting(String actionsWhileAwaiting)
	{
		 this.actionsWhileAwaiting = actionsWhileAwaiting;

		 this.keyModified.put("actions_while_awaiting", 1);

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