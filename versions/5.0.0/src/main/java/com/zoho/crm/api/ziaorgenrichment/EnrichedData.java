package com.zoho.crm.api.ziaorgenrichment;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class EnrichedData implements Model
{
	private String orgStatus;

	private List<Description> description;

	private String ceo;

	private String secondaryEmail;

	private String revenue;

	private String yearsInIndustry;

	private List<String> otherContacts;

	private String technoGraphicData;

	private String logo;

	private String secondaryContact;

	private String id;

	private List<String> otherEmails;

	private String signIn;

	private String website;

	private List<Address> address;

	private String signUp;

	private String orgType;

	private List<Address> headQuarters;

	private String noOfEmployees;

	private List<String> territoryList;

	private String foundingYear;

	private List<Industry> industries;

	private String name;

	private String primaryEmail;

	private List<String> businessModel;

	private String primaryContact;

	private List<SocialMedia> socialMedia;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of orgStatus
	 * @return A String representing the orgStatus
	 */
	public String getOrgStatus()
	{
		return  this.orgStatus;

	}

	/**
	 * The method to set the value to orgStatus
	 * @param orgStatus A String representing the orgStatus
	 */
	public void setOrgStatus(String orgStatus)
	{
		 this.orgStatus = orgStatus;

		 this.keyModified.put("org_status", 1);

	}

	/**
	 * The method to get the value of description
	 * @return An instance of List<Description>
	 */
	public List<Description> getDescription()
	{
		return  this.description;

	}

	/**
	 * The method to set the value to description
	 * @param description An instance of List<Description>
	 */
	public void setDescription(List<Description> description)
	{
		 this.description = description;

		 this.keyModified.put("description", 1);

	}

	/**
	 * The method to get the value of ceo
	 * @return A String representing the ceo
	 */
	public String getCeo()
	{
		return  this.ceo;

	}

	/**
	 * The method to set the value to ceo
	 * @param ceo A String representing the ceo
	 */
	public void setCeo(String ceo)
	{
		 this.ceo = ceo;

		 this.keyModified.put("ceo", 1);

	}

	/**
	 * The method to get the value of secondaryEmail
	 * @return A String representing the secondaryEmail
	 */
	public String getSecondaryEmail()
	{
		return  this.secondaryEmail;

	}

	/**
	 * The method to set the value to secondaryEmail
	 * @param secondaryEmail A String representing the secondaryEmail
	 */
	public void setSecondaryEmail(String secondaryEmail)
	{
		 this.secondaryEmail = secondaryEmail;

		 this.keyModified.put("secondary_email", 1);

	}

	/**
	 * The method to get the value of revenue
	 * @return A String representing the revenue
	 */
	public String getRevenue()
	{
		return  this.revenue;

	}

	/**
	 * The method to set the value to revenue
	 * @param revenue A String representing the revenue
	 */
	public void setRevenue(String revenue)
	{
		 this.revenue = revenue;

		 this.keyModified.put("revenue", 1);

	}

	/**
	 * The method to get the value of yearsInIndustry
	 * @return A String representing the yearsInIndustry
	 */
	public String getYearsInIndustry()
	{
		return  this.yearsInIndustry;

	}

	/**
	 * The method to set the value to yearsInIndustry
	 * @param yearsInIndustry A String representing the yearsInIndustry
	 */
	public void setYearsInIndustry(String yearsInIndustry)
	{
		 this.yearsInIndustry = yearsInIndustry;

		 this.keyModified.put("years_in_industry", 1);

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
	 * The method to get the value of technoGraphicData
	 * @return A String representing the technoGraphicData
	 */
	public String getTechnoGraphicData()
	{
		return  this.technoGraphicData;

	}

	/**
	 * The method to set the value to technoGraphicData
	 * @param technoGraphicData A String representing the technoGraphicData
	 */
	public void setTechnoGraphicData(String technoGraphicData)
	{
		 this.technoGraphicData = technoGraphicData;

		 this.keyModified.put("techno_graphic_data", 1);

	}

	/**
	 * The method to get the value of logo
	 * @return A String representing the logo
	 */
	public String getLogo()
	{
		return  this.logo;

	}

	/**
	 * The method to set the value to logo
	 * @param logo A String representing the logo
	 */
	public void setLogo(String logo)
	{
		 this.logo = logo;

		 this.keyModified.put("logo", 1);

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
	 * The method to get the value of otherEmails
	 * @return An instance of List<String>
	 */
	public List<String> getOtherEmails()
	{
		return  this.otherEmails;

	}

	/**
	 * The method to set the value to otherEmails
	 * @param otherEmails An instance of List<String>
	 */
	public void setOtherEmails(List<String> otherEmails)
	{
		 this.otherEmails = otherEmails;

		 this.keyModified.put("other_emails", 1);

	}

	/**
	 * The method to get the value of signIn
	 * @return A String representing the signIn
	 */
	public String getSignIn()
	{
		return  this.signIn;

	}

	/**
	 * The method to set the value to signIn
	 * @param signIn A String representing the signIn
	 */
	public void setSignIn(String signIn)
	{
		 this.signIn = signIn;

		 this.keyModified.put("sign_in", 1);

	}

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
	 * The method to get the value of address
	 * @return An instance of List<Address>
	 */
	public List<Address> getAddress()
	{
		return  this.address;

	}

	/**
	 * The method to set the value to address
	 * @param address An instance of List<Address>
	 */
	public void setAddress(List<Address> address)
	{
		 this.address = address;

		 this.keyModified.put("address", 1);

	}

	/**
	 * The method to get the value of signUp
	 * @return A String representing the signUp
	 */
	public String getSignUp()
	{
		return  this.signUp;

	}

	/**
	 * The method to set the value to signUp
	 * @param signUp A String representing the signUp
	 */
	public void setSignUp(String signUp)
	{
		 this.signUp = signUp;

		 this.keyModified.put("sign_up", 1);

	}

	/**
	 * The method to get the value of orgType
	 * @return A String representing the orgType
	 */
	public String getOrgType()
	{
		return  this.orgType;

	}

	/**
	 * The method to set the value to orgType
	 * @param orgType A String representing the orgType
	 */
	public void setOrgType(String orgType)
	{
		 this.orgType = orgType;

		 this.keyModified.put("org_type", 1);

	}

	/**
	 * The method to get the value of headQuarters
	 * @return An instance of List<Address>
	 */
	public List<Address> getHeadQuarters()
	{
		return  this.headQuarters;

	}

	/**
	 * The method to set the value to headQuarters
	 * @param headQuarters An instance of List<Address>
	 */
	public void setHeadQuarters(List<Address> headQuarters)
	{
		 this.headQuarters = headQuarters;

		 this.keyModified.put("head_quarters", 1);

	}

	/**
	 * The method to get the value of noOfEmployees
	 * @return A String representing the noOfEmployees
	 */
	public String getNoOfEmployees()
	{
		return  this.noOfEmployees;

	}

	/**
	 * The method to set the value to noOfEmployees
	 * @param noOfEmployees A String representing the noOfEmployees
	 */
	public void setNoOfEmployees(String noOfEmployees)
	{
		 this.noOfEmployees = noOfEmployees;

		 this.keyModified.put("no_of_employees", 1);

	}

	/**
	 * The method to get the value of territoryList
	 * @return An instance of List<String>
	 */
	public List<String> getTerritoryList()
	{
		return  this.territoryList;

	}

	/**
	 * The method to set the value to territoryList
	 * @param territoryList An instance of List<String>
	 */
	public void setTerritoryList(List<String> territoryList)
	{
		 this.territoryList = territoryList;

		 this.keyModified.put("territory_list", 1);

	}

	/**
	 * The method to get the value of foundingYear
	 * @return A String representing the foundingYear
	 */
	public String getFoundingYear()
	{
		return  this.foundingYear;

	}

	/**
	 * The method to set the value to foundingYear
	 * @param foundingYear A String representing the foundingYear
	 */
	public void setFoundingYear(String foundingYear)
	{
		 this.foundingYear = foundingYear;

		 this.keyModified.put("founding_year", 1);

	}

	/**
	 * The method to get the value of industries
	 * @return An instance of List<Industry>
	 */
	public List<Industry> getIndustries()
	{
		return  this.industries;

	}

	/**
	 * The method to set the value to industries
	 * @param industries An instance of List<Industry>
	 */
	public void setIndustries(List<Industry> industries)
	{
		 this.industries = industries;

		 this.keyModified.put("industries", 1);

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
	 * The method to get the value of businessModel
	 * @return An instance of List<String>
	 */
	public List<String> getBusinessModel()
	{
		return  this.businessModel;

	}

	/**
	 * The method to set the value to businessModel
	 * @param businessModel An instance of List<String>
	 */
	public void setBusinessModel(List<String> businessModel)
	{
		 this.businessModel = businessModel;

		 this.keyModified.put("business_model", 1);

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