package com.zoho.crm.api.emailcomposemeta;

import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class FeaturesAvailable implements Model
{
	private Choice<Boolean> zsurveyEnabled;

	private Choice<Boolean> inlineComposeWindow;

	private Choice<Boolean> scheduleMail;

	private Choice<Boolean> emailCloudPicker;

	private Choice<Boolean> formIntegrationEnabled;

	private Choice<Boolean> isprivacyenabled;

	private Choice<Boolean> autoSuggestion;

	private Choice<Boolean> unsubscribeLink;

	private Choice<Boolean> bestTimeToContact;

	private Choice<Boolean> attachTeamdrive;

	private Choice<Boolean> islivedeskenabled;

	private Boolean subjectLineSuggestion;

	private Boolean emailPreference;

	private Boolean attachment;

	private Boolean mandateunsublink;

	private Boolean oldComposeRevert;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of zsurveyEnabled
	 * @return An instance of Choice<Boolean>
	 */
	public Choice<Boolean> getZsurveyEnabled()
	{
		return  this.zsurveyEnabled;

	}

	/**
	 * The method to set the value to zsurveyEnabled
	 * @param zsurveyEnabled An instance of Choice<Boolean>
	 */
	public void setZsurveyEnabled(Choice<Boolean> zsurveyEnabled)
	{
		 this.zsurveyEnabled = zsurveyEnabled;

		 this.keyModified.put("zsurvey_enabled", 1);

	}

	/**
	 * The method to get the value of inlineComposeWindow
	 * @return An instance of Choice<Boolean>
	 */
	public Choice<Boolean> getInlineComposeWindow()
	{
		return  this.inlineComposeWindow;

	}

	/**
	 * The method to set the value to inlineComposeWindow
	 * @param inlineComposeWindow An instance of Choice<Boolean>
	 */
	public void setInlineComposeWindow(Choice<Boolean> inlineComposeWindow)
	{
		 this.inlineComposeWindow = inlineComposeWindow;

		 this.keyModified.put("inline_compose_window", 1);

	}

	/**
	 * The method to get the value of scheduleMail
	 * @return An instance of Choice<Boolean>
	 */
	public Choice<Boolean> getScheduleMail()
	{
		return  this.scheduleMail;

	}

	/**
	 * The method to set the value to scheduleMail
	 * @param scheduleMail An instance of Choice<Boolean>
	 */
	public void setScheduleMail(Choice<Boolean> scheduleMail)
	{
		 this.scheduleMail = scheduleMail;

		 this.keyModified.put("Schedule_Mail", 1);

	}

	/**
	 * The method to get the value of emailCloudPicker
	 * @return An instance of Choice<Boolean>
	 */
	public Choice<Boolean> getEmailCloudPicker()
	{
		return  this.emailCloudPicker;

	}

	/**
	 * The method to set the value to emailCloudPicker
	 * @param emailCloudPicker An instance of Choice<Boolean>
	 */
	public void setEmailCloudPicker(Choice<Boolean> emailCloudPicker)
	{
		 this.emailCloudPicker = emailCloudPicker;

		 this.keyModified.put("EMAIL_CLOUD_PICKER", 1);

	}

	/**
	 * The method to get the value of formIntegrationEnabled
	 * @return An instance of Choice<Boolean>
	 */
	public Choice<Boolean> getFormIntegrationEnabled()
	{
		return  this.formIntegrationEnabled;

	}

	/**
	 * The method to set the value to formIntegrationEnabled
	 * @param formIntegrationEnabled An instance of Choice<Boolean>
	 */
	public void setFormIntegrationEnabled(Choice<Boolean> formIntegrationEnabled)
	{
		 this.formIntegrationEnabled = formIntegrationEnabled;

		 this.keyModified.put("form_integration_enabled", 1);

	}

	/**
	 * The method to get the value of isprivacyenabled
	 * @return An instance of Choice<Boolean>
	 */
	public Choice<Boolean> getIsprivacyenabled()
	{
		return  this.isprivacyenabled;

	}

	/**
	 * The method to set the value to isprivacyenabled
	 * @param isprivacyenabled An instance of Choice<Boolean>
	 */
	public void setIsprivacyenabled(Choice<Boolean> isprivacyenabled)
	{
		 this.isprivacyenabled = isprivacyenabled;

		 this.keyModified.put("isPrivacyEnabled", 1);

	}

	/**
	 * The method to get the value of autoSuggestion
	 * @return An instance of Choice<Boolean>
	 */
	public Choice<Boolean> getAutoSuggestion()
	{
		return  this.autoSuggestion;

	}

	/**
	 * The method to set the value to autoSuggestion
	 * @param autoSuggestion An instance of Choice<Boolean>
	 */
	public void setAutoSuggestion(Choice<Boolean> autoSuggestion)
	{
		 this.autoSuggestion = autoSuggestion;

		 this.keyModified.put("auto_suggestion", 1);

	}

	/**
	 * The method to get the value of unsubscribeLink
	 * @return An instance of Choice<Boolean>
	 */
	public Choice<Boolean> getUnsubscribeLink()
	{
		return  this.unsubscribeLink;

	}

	/**
	 * The method to set the value to unsubscribeLink
	 * @param unsubscribeLink An instance of Choice<Boolean>
	 */
	public void setUnsubscribeLink(Choice<Boolean> unsubscribeLink)
	{
		 this.unsubscribeLink = unsubscribeLink;

		 this.keyModified.put("UNSUBSCRIBE_LINK", 1);

	}

	/**
	 * The method to get the value of bestTimeToContact
	 * @return An instance of Choice<Boolean>
	 */
	public Choice<Boolean> getBestTimeToContact()
	{
		return  this.bestTimeToContact;

	}

	/**
	 * The method to set the value to bestTimeToContact
	 * @param bestTimeToContact An instance of Choice<Boolean>
	 */
	public void setBestTimeToContact(Choice<Boolean> bestTimeToContact)
	{
		 this.bestTimeToContact = bestTimeToContact;

		 this.keyModified.put("best_time_to_contact", 1);

	}

	/**
	 * The method to get the value of attachTeamdrive
	 * @return An instance of Choice<Boolean>
	 */
	public Choice<Boolean> getAttachTeamdrive()
	{
		return  this.attachTeamdrive;

	}

	/**
	 * The method to set the value to attachTeamdrive
	 * @param attachTeamdrive An instance of Choice<Boolean>
	 */
	public void setAttachTeamdrive(Choice<Boolean> attachTeamdrive)
	{
		 this.attachTeamdrive = attachTeamdrive;

		 this.keyModified.put("attach_teamdrive", 1);

	}

	/**
	 * The method to get the value of islivedeskenabled
	 * @return An instance of Choice<Boolean>
	 */
	public Choice<Boolean> getIslivedeskenabled()
	{
		return  this.islivedeskenabled;

	}

	/**
	 * The method to set the value to islivedeskenabled
	 * @param islivedeskenabled An instance of Choice<Boolean>
	 */
	public void setIslivedeskenabled(Choice<Boolean> islivedeskenabled)
	{
		 this.islivedeskenabled = islivedeskenabled;

		 this.keyModified.put("isLiveDeskEnabled", 1);

	}

	/**
	 * The method to get the value of subjectLineSuggestion
	 * @return A Boolean representing the subjectLineSuggestion
	 */
	public Boolean getSubjectLineSuggestion()
	{
		return  this.subjectLineSuggestion;

	}

	/**
	 * The method to set the value to subjectLineSuggestion
	 * @param subjectLineSuggestion A Boolean representing the subjectLineSuggestion
	 */
	public void setSubjectLineSuggestion(Boolean subjectLineSuggestion)
	{
		 this.subjectLineSuggestion = subjectLineSuggestion;

		 this.keyModified.put("subject_line_suggestion", 1);

	}

	/**
	 * The method to get the value of emailPreference
	 * @return A Boolean representing the emailPreference
	 */
	public Boolean getEmailPreference()
	{
		return  this.emailPreference;

	}

	/**
	 * The method to set the value to emailPreference
	 * @param emailPreference A Boolean representing the emailPreference
	 */
	public void setEmailPreference(Boolean emailPreference)
	{
		 this.emailPreference = emailPreference;

		 this.keyModified.put("EMAIL_PREFERENCE", 1);

	}

	/**
	 * The method to get the value of attachment
	 * @return A Boolean representing the attachment
	 */
	public Boolean getAttachment()
	{
		return  this.attachment;

	}

	/**
	 * The method to set the value to attachment
	 * @param attachment A Boolean representing the attachment
	 */
	public void setAttachment(Boolean attachment)
	{
		 this.attachment = attachment;

		 this.keyModified.put("ATTACHMENT", 1);

	}

	/**
	 * The method to get the value of mandateunsublink
	 * @return A Boolean representing the mandateunsublink
	 */
	public Boolean getMandateunsublink()
	{
		return  this.mandateunsublink;

	}

	/**
	 * The method to set the value to mandateunsublink
	 * @param mandateunsublink A Boolean representing the mandateunsublink
	 */
	public void setMandateunsublink(Boolean mandateunsublink)
	{
		 this.mandateunsublink = mandateunsublink;

		 this.keyModified.put("mandateUnsubLink", 1);

	}

	/**
	 * The method to get the value of oldComposeRevert
	 * @return A Boolean representing the oldComposeRevert
	 */
	public Boolean getOldComposeRevert()
	{
		return  this.oldComposeRevert;

	}

	/**
	 * The method to set the value to oldComposeRevert
	 * @param oldComposeRevert A Boolean representing the oldComposeRevert
	 */
	public void setOldComposeRevert(Boolean oldComposeRevert)
	{
		 this.oldComposeRevert = oldComposeRevert;

		 this.keyModified.put("OLD_COMPOSE_REVERT", 1);

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