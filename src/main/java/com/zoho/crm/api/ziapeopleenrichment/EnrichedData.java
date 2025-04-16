package com.zoho.crm.api.ziapeopleenrichment;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class EnrichedData implements Model
{
	private String website;

	private List<EmailInfo> emailInfos;

	private String gender;

	private CompanyInfo companyInfo;

	private String lastName;

	private List<Object> educations;

	private String middleName;

	private List<Object> skills;

	private List<String> otherContacts;

	private List<Address> addressListInfo;

	private Address primaryAddressInfo;

	private String name;

	private String secondaryContact;

	private String primaryEmail;

	private String designation;

	private String id;

	private List<Object> interests;

	private String firstName;

	private String primaryContact;

	private List<SocialMedia> socialMedia;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of website
	 * @return A String representing the website
	 */
	public String getWebsite()
	{
		return  this.website;

	}

	/**
	 * The method to set the value to website
	 * @param website A String representing the website
	 */
	public void setWebsite(String website)
	{
		 this.website = website;

		 this.keyModified.put("website", 1);

	}

	/**
	 * The method to get the value of emailInfos
	 * @return An instance of List<EmailInfo>
	 */
	public List<EmailInfo> getEmailInfos()
	{
		return  this.emailInfos;

	}

	/**
	 * The method to set the value to emailInfos
	 * @param emailInfos An instance of List<EmailInfo>
	 */
	public void setEmailInfos(List<EmailInfo> emailInfos)
	{
		 this.emailInfos = emailInfos;

		 this.keyModified.put("email_infos", 1);

	}

	/**
	 * The method to get the value of gender
	 * @return A String representing the gender
	 */
	public String getGender()
	{
		return  this.gender;

	}

	/**
	 * The method to set the value to gender
	 * @param gender A String representing the gender
	 */
	public void setGender(String gender)
	{
		 this.gender = gender;

		 this.keyModified.put("gender", 1);

	}

	/**
	 * The method to get the value of companyInfo
	 * @return An instance of CompanyInfo
	 */
	public CompanyInfo getCompanyInfo()
	{
		return  this.companyInfo;

	}

	/**
	 * The method to set the value to companyInfo
	 * @param companyInfo An instance of CompanyInfo
	 */
	public void setCompanyInfo(CompanyInfo companyInfo)
	{
		 this.companyInfo = companyInfo;

		 this.keyModified.put("company_info", 1);

	}

	/**
	 * The method to get the value of lastName
	 * @return A String representing the lastName
	 */
	public String getLastName()
	{
		return  this.lastName;

	}

	/**
	 * The method to set the value to lastName
	 * @param lastName A String representing the lastName
	 */
	public void setLastName(String lastName)
	{
		 this.lastName = lastName;

		 this.keyModified.put("last_name", 1);

	}

	/**
	 * The method to get the value of educations
	 * @return An instance of List<Object>
	 */
	public List<Object> getEducations()
	{
		return  this.educations;

	}

	/**
	 * The method to set the value to educations
	 * @param educations An instance of List<Object>
	 */
	public void setEducations(List<Object> educations)
	{
		 this.educations = educations;

		 this.keyModified.put("educations", 1);

	}

	/**
	 * The method to get the value of middleName
	 * @return A String representing the middleName
	 */
	public String getMiddleName()
	{
		return  this.middleName;

	}

	/**
	 * The method to set the value to middleName
	 * @param middleName A String representing the middleName
	 */
	public void setMiddleName(String middleName)
	{
		 this.middleName = middleName;

		 this.keyModified.put("middle_name", 1);

	}

	/**
	 * The method to get the value of skills
	 * @return An instance of List<Object>
	 */
	public List<Object> getSkills()
	{
		return  this.skills;

	}

	/**
	 * The method to set the value to skills
	 * @param skills An instance of List<Object>
	 */
	public void setSkills(List<Object> skills)
	{
		 this.skills = skills;

		 this.keyModified.put("skills", 1);

	}

	/**
	 * The method to get the value of otherContacts
	 * @return An instance of List<String>
	 */
	public List<String> getOtherContacts()
	{
		return  this.otherContacts;

	}

	/**
	 * The method to set the value to otherContacts
	 * @param otherContacts An instance of List<String>
	 */
	public void setOtherContacts(List<String> otherContacts)
	{
		 this.otherContacts = otherContacts;

		 this.keyModified.put("other_contacts", 1);

	}

	/**
	 * The method to get the value of addressListInfo
	 * @return An instance of List<Address>
	 */
	public List<Address> getAddressListInfo()
	{
		return  this.addressListInfo;

	}

	/**
	 * The method to set the value to addressListInfo
	 * @param addressListInfo An instance of List<Address>
	 */
	public void setAddressListInfo(List<Address> addressListInfo)
	{
		 this.addressListInfo = addressListInfo;

		 this.keyModified.put("address_list_info", 1);

	}

	/**
	 * The method to get the value of primaryAddressInfo
	 * @return An instance of Address
	 */
	public Address getPrimaryAddressInfo()
	{
		return  this.primaryAddressInfo;

	}

	/**
	 * The method to set the value to primaryAddressInfo
	 * @param primaryAddressInfo An instance of Address
	 */
	public void setPrimaryAddressInfo(Address primaryAddressInfo)
	{
		 this.primaryAddressInfo = primaryAddressInfo;

		 this.keyModified.put("primary_address_info", 1);

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
	 * The method to get the value of secondaryContact
	 * @return A String representing the secondaryContact
	 */
	public String getSecondaryContact()
	{
		return  this.secondaryContact;

	}

	/**
	 * The method to set the value to secondaryContact
	 * @param secondaryContact A String representing the secondaryContact
	 */
	public void setSecondaryContact(String secondaryContact)
	{
		 this.secondaryContact = secondaryContact;

		 this.keyModified.put("secondary_contact", 1);

	}

	/**
	 * The method to get the value of primaryEmail
	 * @return A String representing the primaryEmail
	 */
	public String getPrimaryEmail()
	{
		return  this.primaryEmail;

	}

	/**
	 * The method to set the value to primaryEmail
	 * @param primaryEmail A String representing the primaryEmail
	 */
	public void setPrimaryEmail(String primaryEmail)
	{
		 this.primaryEmail = primaryEmail;

		 this.keyModified.put("primary_email", 1);

	}

	/**
	 * The method to get the value of designation
	 * @return A String representing the designation
	 */
	public String getDesignation()
	{
		return  this.designation;

	}

	/**
	 * The method to set the value to designation
	 * @param designation A String representing the designation
	 */
	public void setDesignation(String designation)
	{
		 this.designation = designation;

		 this.keyModified.put("designation", 1);

	}

	/**
	 * The method to get the value of id
	 * @return A String representing the id
	 */
	public String getId()
	{
		return  this.id;

	}

	/**
	 * The method to set the value to id
	 * @param id A String representing the id
	 */
	public void setId(String id)
	{
		 this.id = id;

		 this.keyModified.put("id", 1);

	}

	/**
	 * The method to get the value of interests
	 * @return An instance of List<Object>
	 */
	public List<Object> getInterests()
	{
		return  this.interests;

	}

	/**
	 * The method to set the value to interests
	 * @param interests An instance of List<Object>
	 */
	public void setInterests(List<Object> interests)
	{
		 this.interests = interests;

		 this.keyModified.put("interests", 1);

	}

	/**
	 * The method to get the value of firstName
	 * @return A String representing the firstName
	 */
	public String getFirstName()
	{
		return  this.firstName;

	}

	/**
	 * The method to set the value to firstName
	 * @param firstName A String representing the firstName
	 */
	public void setFirstName(String firstName)
	{
		 this.firstName = firstName;

		 this.keyModified.put("first_name", 1);

	}

	/**
	 * The method to get the value of primaryContact
	 * @return A String representing the primaryContact
	 */
	public String getPrimaryContact()
	{
		return  this.primaryContact;

	}

	/**
	 * The method to set the value to primaryContact
	 * @param primaryContact A String representing the primaryContact
	 */
	public void setPrimaryContact(String primaryContact)
	{
		 this.primaryContact = primaryContact;

		 this.keyModified.put("primary_contact", 1);

	}

	/**
	 * The method to get the value of socialMedia
	 * @return An instance of List<SocialMedia>
	 */
	public List<SocialMedia> getSocialMedia()
	{
		return  this.socialMedia;

	}

	/**
	 * The method to set the value to socialMedia
	 * @param socialMedia An instance of List<SocialMedia>
	 */
	public void setSocialMedia(List<SocialMedia> socialMedia)
	{
		 this.socialMedia = socialMedia;

		 this.keyModified.put("social_media", 1);

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