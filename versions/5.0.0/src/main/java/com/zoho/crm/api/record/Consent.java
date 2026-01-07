package com.zoho.crm.api.record;

import com.zoho.crm.api.tags.Tag;
import com.zoho.crm.api.users.MinifiedUser;
import com.zoho.crm.api.util.Model;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

public class Consent extends Record implements Model
{

	/**
	 * The method to get the value of owner
	 * @return An instance of MinifiedUser
	 */
	public MinifiedUser getOwner()
	{
		return (MinifiedUser) this.getKeyValue("Owner");

	}

	/**
	 * The method to set the value to owner
	 * @param owner An instance of MinifiedUser
	 */
	public void setOwner(MinifiedUser owner)
	{
		 this.addKeyValue("Owner", owner);

	}

	/**
	 * The method to get the value of contactThroughEmail
	 * @return A Boolean representing the contactThroughEmail
	 */
	public Boolean getContactThroughEmail()
	{
		return (Boolean) this.getKeyValue("Contact_Through_Email");

	}

	/**
	 * The method to set the value to contactThroughEmail
	 * @param contactThroughEmail A Boolean representing the contactThroughEmail
	 */
	public void setContactThroughEmail(Boolean contactThroughEmail)
	{
		 this.addKeyValue("Contact_Through_Email", contactThroughEmail);

	}

	/**
	 * The method to get the value of contactThroughSocial
	 * @return A Boolean representing the contactThroughSocial
	 */
	public Boolean getContactThroughSocial()
	{
		return (Boolean) this.getKeyValue("Contact_Through_Social");

	}

	/**
	 * The method to set the value to contactThroughSocial
	 * @param contactThroughSocial A Boolean representing the contactThroughSocial
	 */
	public void setContactThroughSocial(Boolean contactThroughSocial)
	{
		 this.addKeyValue("Contact_Through_Social", contactThroughSocial);

	}

	/**
	 * The method to get the value of contactThroughSurvey
	 * @return A Boolean representing the contactThroughSurvey
	 */
	public Boolean getContactThroughSurvey()
	{
		return (Boolean) this.getKeyValue("Contact_Through_Survey");

	}

	/**
	 * The method to set the value to contactThroughSurvey
	 * @param contactThroughSurvey A Boolean representing the contactThroughSurvey
	 */
	public void setContactThroughSurvey(Boolean contactThroughSurvey)
	{
		 this.addKeyValue("Contact_Through_Survey", contactThroughSurvey);

	}

	/**
	 * The method to get the value of contactThroughPhone
	 * @return A Boolean representing the contactThroughPhone
	 */
	public Boolean getContactThroughPhone()
	{
		return (Boolean) this.getKeyValue("Contact_Through_Phone");

	}

	/**
	 * The method to set the value to contactThroughPhone
	 * @param contactThroughPhone A Boolean representing the contactThroughPhone
	 */
	public void setContactThroughPhone(Boolean contactThroughPhone)
	{
		 this.addKeyValue("Contact_Through_Phone", contactThroughPhone);

	}

	/**
	 * The method to get the value of mailSentTime
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getMailSentTime()
	{
		return (OffsetDateTime) this.getKeyValue("Mail_Sent_Time");

	}

	/**
	 * The method to set the value to mailSentTime
	 * @param mailSentTime An instance of OffsetDateTime
	 */
	public void setMailSentTime(OffsetDateTime mailSentTime)
	{
		 this.addKeyValue("Mail_Sent_Time", mailSentTime);

	}

	/**
	 * The method to get the value of consentDate
	 * @return An instance of LocalDate
	 */
	public LocalDate getConsentDate()
	{
		return (LocalDate) this.getKeyValue("Consent_Date");

	}

	/**
	 * The method to set the value to consentDate
	 * @param consentDate An instance of LocalDate
	 */
	public void setConsentDate(LocalDate consentDate)
	{
		 this.addKeyValue("Consent_Date", consentDate);

	}

	/**
	 * The method to get the value of consentRemarks
	 * @return A String representing the consentRemarks
	 */
	public String getConsentRemarks()
	{
		return (String) this.getKeyValue("Consent_Remarks");

	}

	/**
	 * The method to set the value to consentRemarks
	 * @param consentRemarks A String representing the consentRemarks
	 */
	public void setConsentRemarks(String consentRemarks)
	{
		 this.addKeyValue("Consent_Remarks", consentRemarks);

	}

	/**
	 * The method to get the value of consentThrough
	 * @return A String representing the consentThrough
	 */
	public String getConsentThrough()
	{
		return (String) this.getKeyValue("Consent_Through");

	}

	/**
	 * The method to set the value to consentThrough
	 * @param consentThrough A String representing the consentThrough
	 */
	public void setConsentThrough(String consentThrough)
	{
		 this.addKeyValue("Consent_Through", consentThrough);

	}

	/**
	 * The method to get the value of dataProcessingBasis
	 * @return A String representing the dataProcessingBasis
	 */
	public String getDataProcessingBasis()
	{
		return (String) this.getKeyValue("Data_Processing_Basis");

	}

	/**
	 * The method to set the value to dataProcessingBasis
	 * @param dataProcessingBasis A String representing the dataProcessingBasis
	 */
	public void setDataProcessingBasis(String dataProcessingBasis)
	{
		 this.addKeyValue("Data_Processing_Basis", dataProcessingBasis);

	}

	/**
	 * The method to get the value of id
	 * @return A Long representing the id
	 */
	public Long getId()
	{
		return (Long) this.getKeyValue("id");

	}

	/**
	 * The method to set the value to id
	 * @param id A Long representing the id
	 */
	public void setId(Long id)
	{
		 this.addKeyValue("id", id);

	}

	/**
	 * The method to get the value of createdBy
	 * @return An instance of MinifiedUser
	 */
	public MinifiedUser getCreatedBy()
	{
		return (MinifiedUser) this.getKeyValue("Created_By");

	}

	/**
	 * The method to set the value to createdBy
	 * @param createdBy An instance of MinifiedUser
	 */
	public void setCreatedBy(MinifiedUser createdBy)
	{
		 this.addKeyValue("Created_By", createdBy);

	}

	/**
	 * The method to get the value of createdTime
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getCreatedTime()
	{
		return (OffsetDateTime) this.getKeyValue("Created_Time");

	}

	/**
	 * The method to set the value to createdTime
	 * @param createdTime An instance of OffsetDateTime
	 */
	public void setCreatedTime(OffsetDateTime createdTime)
	{
		 this.addKeyValue("Created_Time", createdTime);

	}

	/**
	 * The method to get the value of modifiedBy
	 * @return An instance of MinifiedUser
	 */
	public MinifiedUser getModifiedBy()
	{
		return (MinifiedUser) this.getKeyValue("Modified_By");

	}

	/**
	 * The method to set the value to modifiedBy
	 * @param modifiedBy An instance of MinifiedUser
	 */
	public void setModifiedBy(MinifiedUser modifiedBy)
	{
		 this.addKeyValue("Modified_By", modifiedBy);

	}

	/**
	 * The method to get the value of modifiedTime
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getModifiedTime()
	{
		return (OffsetDateTime) this.getKeyValue("Modified_Time");

	}

	/**
	 * The method to set the value to modifiedTime
	 * @param modifiedTime An instance of OffsetDateTime
	 */
	public void setModifiedTime(OffsetDateTime modifiedTime)
	{
		 this.addKeyValue("Modified_Time", modifiedTime);

	}

	/**
	 * The method to get the value of tag
	 * @return An instance of List<Tag>
	 */
	public List<Tag> getTag()
	{
		return (List<Tag>) this.getKeyValue("Tag");

	}

	/**
	 * The method to set the value to tag
	 * @param tag An instance of List<Tag>
	 */
	public void setTag(List<Tag> tag)
	{
		 this.addKeyValue("Tag", tag);

	}

	/**
	 * The method to get the value of name
	 * @return A String representing the name
	 */
	public String getName()
	{
		return (String) this.getKeyValue("name");

	}

	/**
	 * The method to set the value to name
	 * @param name A String representing the name
	 */
	public void setName(String name)
	{
		 this.addKeyValue("name", name);

	}
}