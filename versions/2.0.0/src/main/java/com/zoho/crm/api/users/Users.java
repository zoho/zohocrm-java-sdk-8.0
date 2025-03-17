package com.zoho.crm.api.users;

import com.zoho.crm.api.record.Record;
import com.zoho.crm.api.tags.Tag;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.TimeZone;

public class Users extends Record implements Model
{

	/**
	 * The method to get the value of country
	 * @return A String representing the country
	 */
	public String getCountry()
	{
		return (String) this.getKeyValue("country");

	}

	/**
	 * The method to set the value to country
	 * @param country A String representing the country
	 */
	public void setCountry(String country)
	{
		 this.addKeyValue("country", country);

	}

	/**
	 * The method to get the value of language
	 * @return A String representing the language
	 */
	public String getLanguage()
	{
		return (String) this.getKeyValue("language");

	}

	/**
	 * The method to set the value to language
	 * @param language A String representing the language
	 */
	public void setLanguage(String language)
	{
		 this.addKeyValue("language", language);

	}

	/**
	 * The method to get the value of microsoft
	 * @return A Boolean representing the microsoft
	 */
	public Boolean getMicrosoft()
	{
		return (Boolean) this.getKeyValue("microsoft");

	}

	/**
	 * The method to set the value to microsoft
	 * @param microsoft A Boolean representing the microsoft
	 */
	public void setMicrosoft(Boolean microsoft)
	{
		 this.addKeyValue("microsoft", microsoft);

	}

	/**
	 * The method to get the value of shiftEffectiveFrom
	 * @return An instance of Object
	 */
	public Object getShiftEffectiveFrom()
	{
		return (Object) this.getKeyValue("$shift_effective_from");

	}

	/**
	 * The method to set the value to shiftEffectiveFrom
	 * @param shiftEffectiveFrom An instance of Object
	 */
	public void setShiftEffectiveFrom(Object shiftEffectiveFrom)
	{
		 this.addKeyValue("$shift_effective_from", shiftEffectiveFrom);

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
	 * The method to get the value of state
	 * @return A String representing the state
	 */
	public String getState()
	{
		return (String) this.getKeyValue("state");

	}

	/**
	 * The method to set the value to state
	 * @param state A String representing the state
	 */
	public void setState(String state)
	{
		 this.addKeyValue("state", state);

	}

	/**
	 * The method to get the value of fax
	 * @return A String representing the fax
	 */
	public String getFax()
	{
		return (String) this.getKeyValue("fax");

	}

	/**
	 * The method to set the value to fax
	 * @param fax A String representing the fax
	 */
	public void setFax(String fax)
	{
		 this.addKeyValue("fax", fax);

	}

	/**
	 * The method to get the value of countryLocale
	 * @return A String representing the countryLocale
	 */
	public String getCountryLocale()
	{
		return (String) this.getKeyValue("country_locale");

	}

	/**
	 * The method to set the value to countryLocale
	 * @param countryLocale A String representing the countryLocale
	 */
	public void setCountryLocale(String countryLocale)
	{
		 this.addKeyValue("country_locale", countryLocale);

	}

	/**
	 * The method to get the value of zip
	 * @return A String representing the zip
	 */
	public String getZip()
	{
		return (String) this.getKeyValue("zip");

	}

	/**
	 * The method to set the value to zip
	 * @param zip A String representing the zip
	 */
	public void setZip(String zip)
	{
		 this.addKeyValue("zip", zip);

	}

	/**
	 * The method to get the value of createdTime
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getCreatedTime()
	{
		return (OffsetDateTime) this.getKeyValue("created_time");

	}

	/**
	 * The method to set the value to createdTime
	 * @param createdTime An instance of OffsetDateTime
	 */
	public void setCreatedTime(OffsetDateTime createdTime)
	{
		 this.addKeyValue("created_time", createdTime);

	}

	/**
	 * The method to get the value of timeFormat
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getTimeFormat()
	{
		return (Choice<String>) this.getKeyValue("time_format");

	}

	/**
	 * The method to set the value to timeFormat
	 * @param timeFormat An instance of Choice<String>
	 */
	public void setTimeFormat(Choice<String> timeFormat)
	{
		 this.addKeyValue("time_format", timeFormat);

	}

	/**
	 * The method to get the value of offset
	 * @return An Integer representing the offset
	 */
	public Integer getOffset()
	{
		return (Integer) this.getKeyValue("offset");

	}

	/**
	 * The method to set the value to offset
	 * @param offset An Integer representing the offset
	 */
	public void setOffset(Integer offset)
	{
		 this.addKeyValue("offset", offset);

	}

	/**
	 * The method to get the value of imapStatus
	 * @return A Boolean representing the imapStatus
	 */
	public Boolean getImapStatus()
	{
		return (Boolean) this.getKeyValue("imap_status");

	}

	/**
	 * The method to set the value to imapStatus
	 * @param imapStatus A Boolean representing the imapStatus
	 */
	public void setImapStatus(Boolean imapStatus)
	{
		 this.addKeyValue("imap_status", imapStatus);

	}

	/**
	 * The method to get the value of imageLink
	 * @return A String representing the imageLink
	 */
	public String getImageLink()
	{
		return (String) this.getKeyValue("image_link");

	}

	/**
	 * The method to set the value to imageLink
	 * @param imageLink A String representing the imageLink
	 */
	public void setImageLink(String imageLink)
	{
		 this.addKeyValue("image_link", imageLink);

	}

	/**
	 * The method to get the value of ezuid
	 * @return A String representing the ezuid
	 */
	public String getEzuid()
	{
		return (String) this.getKeyValue("ezuid");

	}

	/**
	 * The method to set the value to ezuid
	 * @param ezuid A String representing the ezuid
	 */
	public void setEzuid(String ezuid)
	{
		 this.addKeyValue("ezuid", ezuid);

	}

	/**
	 * The method to get the value of profile
	 * @return An instance of Profile
	 */
	public Profile getProfile()
	{
		return (Profile) this.getKeyValue("profile");

	}

	/**
	 * The method to set the value to profile
	 * @param profile An instance of Profile
	 */
	public void setProfile(Profile profile)
	{
		 this.addKeyValue("profile", profile);

	}

	/**
	 * The method to get the value of role
	 * @return An instance of Role
	 */
	public Role getRole()
	{
		return (Role) this.getKeyValue("role");

	}

	/**
	 * The method to set the value to role
	 * @param role An instance of Role
	 */
	public void setRole(Role role)
	{
		 this.addKeyValue("role", role);

	}

	/**
	 * The method to get the value of createdBy
	 * @return An instance of MinifiedUser
	 */
	public MinifiedUser getCreatedBy()
	{
		return (MinifiedUser) this.getKeyValue("created_by");

	}

	/**
	 * The method to set the value to createdBy
	 * @param createdBy An instance of MinifiedUser
	 */
	public void setCreatedBy(MinifiedUser createdBy)
	{
		 this.addKeyValue("created_by", createdBy);

	}

	/**
	 * The method to get the value of fullName
	 * @return A String representing the fullName
	 */
	public String getFullName()
	{
		return (String) this.getKeyValue("full_name");

	}

	/**
	 * The method to set the value to fullName
	 * @param fullName A String representing the fullName
	 */
	public void setFullName(String fullName)
	{
		 this.addKeyValue("full_name", fullName);

	}

	/**
	 * The method to get the value of zuid
	 * @return A String representing the zuid
	 */
	public String getZuid()
	{
		return (String) this.getKeyValue("zuid");

	}

	/**
	 * The method to set the value to zuid
	 * @param zuid A String representing the zuid
	 */
	public void setZuid(String zuid)
	{
		 this.addKeyValue("zuid", zuid);

	}

	/**
	 * The method to get the value of phone
	 * @return A String representing the phone
	 */
	public String getPhone()
	{
		return (String) this.getKeyValue("phone");

	}

	/**
	 * The method to set the value to phone
	 * @param phone A String representing the phone
	 */
	public void setPhone(String phone)
	{
		 this.addKeyValue("phone", phone);

	}

	/**
	 * The method to get the value of dob
	 * @return An instance of LocalDate
	 */
	public LocalDate getDob()
	{
		return (LocalDate) this.getKeyValue("dob");

	}

	/**
	 * The method to set the value to dob
	 * @param dob An instance of LocalDate
	 */
	public void setDob(LocalDate dob)
	{
		 this.addKeyValue("dob", dob);

	}

	/**
	 * The method to get the value of status
	 * @return A String representing the status
	 */
	public String getStatus()
	{
		return (String) this.getKeyValue("status");

	}

	/**
	 * The method to set the value to status
	 * @param status A String representing the status
	 */
	public void setStatus(String status)
	{
		 this.addKeyValue("status", status);

	}

	/**
	 * The method to get the value of customizeInfo
	 * @return An instance of CustomizeInfo
	 */
	public CustomizeInfo getCustomizeInfo()
	{
		return (CustomizeInfo) this.getKeyValue("customize_info");

	}

	/**
	 * The method to set the value to customizeInfo
	 * @param customizeInfo An instance of CustomizeInfo
	 */
	public void setCustomizeInfo(CustomizeInfo customizeInfo)
	{
		 this.addKeyValue("customize_info", customizeInfo);

	}

	/**
	 * The method to get the value of city
	 * @return A String representing the city
	 */
	public String getCity()
	{
		return (String) this.getKeyValue("city");

	}

	/**
	 * The method to set the value to city
	 * @param city A String representing the city
	 */
	public void setCity(String city)
	{
		 this.addKeyValue("city", city);

	}

	/**
	 * The method to get the value of signature
	 * @return A String representing the signature
	 */
	public String getSignature()
	{
		return (String) this.getKeyValue("signature");

	}

	/**
	 * The method to set the value to signature
	 * @param signature A String representing the signature
	 */
	public void setSignature(String signature)
	{
		 this.addKeyValue("signature", signature);

	}

	/**
	 * The method to get the value of sortOrderPreferenceS
	 * @return A String representing the sortOrderPreferenceS
	 */
	public String getSortOrderPreferenceS()
	{
		return (String) this.getKeyValue("sort_order_preference__s");

	}

	/**
	 * The method to set the value to sortOrderPreferenceS
	 * @param sortOrderPreferenceS A String representing the sortOrderPreferenceS
	 */
	public void setSortOrderPreferenceS(String sortOrderPreferenceS)
	{
		 this.addKeyValue("sort_order_preference__s", sortOrderPreferenceS);

	}

	/**
	 * The method to get the value of category
	 * @return A String representing the category
	 */
	public String getCategory()
	{
		return (String) this.getKeyValue("category");

	}

	/**
	 * The method to set the value to category
	 * @param category A String representing the category
	 */
	public void setCategory(String category)
	{
		 this.addKeyValue("category", category);

	}

	/**
	 * The method to get the value of dateFormat
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getDateFormat()
	{
		return (Choice<String>) this.getKeyValue("date_format");

	}

	/**
	 * The method to set the value to dateFormat
	 * @param dateFormat An instance of Choice<String>
	 */
	public void setDateFormat(Choice<String> dateFormat)
	{
		 this.addKeyValue("date_format", dateFormat);

	}

	/**
	 * The method to get the value of confirm
	 * @return A Boolean representing the confirm
	 */
	public Boolean getConfirm()
	{
		return (Boolean) this.getKeyValue("confirm");

	}

	/**
	 * The method to set the value to confirm
	 * @param confirm A Boolean representing the confirm
	 */
	public void setConfirm(Boolean confirm)
	{
		 this.addKeyValue("confirm", confirm);

	}

	/**
	 * The method to get the value of decimalSeparator
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getDecimalSeparator()
	{
		return (Choice<String>) this.getKeyValue("decimal_separator");

	}

	/**
	 * The method to set the value to decimalSeparator
	 * @param decimalSeparator An instance of Choice<String>
	 */
	public void setDecimalSeparator(Choice<String> decimalSeparator)
	{
		 this.addKeyValue("decimal_separator", decimalSeparator);

	}

	/**
	 * The method to get the value of numberSeparator
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getNumberSeparator()
	{
		return (Choice<String>) this.getKeyValue("number_separator");

	}

	/**
	 * The method to set the value to numberSeparator
	 * @param numberSeparator An instance of Choice<String>
	 */
	public void setNumberSeparator(Choice<String> numberSeparator)
	{
		 this.addKeyValue("number_separator", numberSeparator);

	}

	/**
	 * The method to get the value of timeZone
	 * @return An instance of TimeZone
	 */
	public TimeZone getTimeZone()
	{
		return (TimeZone) this.getKeyValue("time_zone");

	}

	/**
	 * The method to set the value to timeZone
	 * @param timeZone An instance of TimeZone
	 */
	public void setTimeZone(TimeZone timeZone)
	{
		 this.addKeyValue("time_zone", timeZone);

	}

	/**
	 * The method to get the value of lastName
	 * @return A String representing the lastName
	 */
	public String getLastName()
	{
		return (String) this.getKeyValue("last_name");

	}

	/**
	 * The method to set the value to lastName
	 * @param lastName A String representing the lastName
	 */
	public void setLastName(String lastName)
	{
		 this.addKeyValue("last_name", lastName);

	}

	/**
	 * The method to get the value of mobile
	 * @return A String representing the mobile
	 */
	public String getMobile()
	{
		return (String) this.getKeyValue("mobile");

	}

	/**
	 * The method to set the value to mobile
	 * @param mobile A String representing the mobile
	 */
	public void setMobile(String mobile)
	{
		 this.addKeyValue("mobile", mobile);

	}

	/**
	 * The method to get the value of currentShift
	 * @return An instance of Shift
	 */
	public Shift getCurrentShift()
	{
		return (Shift) this.getKeyValue("$current_shift");

	}

	/**
	 * The method to set the value to currentShift
	 * @param currentShift An instance of Shift
	 */
	public void setCurrentShift(Shift currentShift)
	{
		 this.addKeyValue("$current_shift", currentShift);

	}

	/**
	 * The method to get the value of reportingTo
	 * @return An instance of MinifiedUser
	 */
	public MinifiedUser getReportingTo()
	{
		return (MinifiedUser) this.getKeyValue("Reporting_To");

	}

	/**
	 * The method to set the value to reportingTo
	 * @param reportingTo An instance of MinifiedUser
	 */
	public void setReportingTo(MinifiedUser reportingTo)
	{
		 this.addKeyValue("Reporting_To", reportingTo);

	}

	/**
	 * The method to get the value of currency
	 * @return A String representing the currency
	 */
	public String getCurrency()
	{
		return (String) this.getKeyValue("Currency");

	}

	/**
	 * The method to set the value to currency
	 * @param currency A String representing the currency
	 */
	public void setCurrency(String currency)
	{
		 this.addKeyValue("Currency", currency);

	}

	/**
	 * The method to get the value of nextShift
	 * @return An instance of Shift
	 */
	public Shift getNextShift()
	{
		return (Shift) this.getKeyValue("$next_shift");

	}

	/**
	 * The method to set the value to nextShift
	 * @param nextShift An instance of Shift
	 */
	public void setNextShift(Shift nextShift)
	{
		 this.addKeyValue("$next_shift", nextShift);

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
	 * The method to get the value of website
	 * @return A String representing the website
	 */
	public String getWebsite()
	{
		return (String) this.getKeyValue("website");

	}

	/**
	 * The method to set the value to website
	 * @param website A String representing the website
	 */
	public void setWebsite(String website)
	{
		 this.addKeyValue("website", website);

	}

	/**
	 * The method to get the value of statusReasonS
	 * @return A String representing the statusReasonS
	 */
	public String getStatusReasonS()
	{
		return (String) this.getKeyValue("status_reason__s");

	}

	/**
	 * The method to set the value to statusReasonS
	 * @param statusReasonS A String representing the statusReasonS
	 */
	public void setStatusReasonS(String statusReasonS)
	{
		 this.addKeyValue("status_reason__s", statusReasonS);

	}

	/**
	 * The method to get the value of email
	 * @return A String representing the email
	 */
	public String getEmail()
	{
		return (String) this.getKeyValue("email");

	}

	/**
	 * The method to set the value to email
	 * @param email A String representing the email
	 */
	public void setEmail(String email)
	{
		 this.addKeyValue("email", email);

	}

	/**
	 * The method to get the value of firstName
	 * @return A String representing the firstName
	 */
	public String getFirstName()
	{
		return (String) this.getKeyValue("first_name");

	}

	/**
	 * The method to set the value to firstName
	 * @param firstName A String representing the firstName
	 */
	public void setFirstName(String firstName)
	{
		 this.addKeyValue("first_name", firstName);

	}

	/**
	 * The method to get the value of sandboxdeveloper
	 * @return A Boolean representing the sandboxdeveloper
	 */
	public Boolean getSandboxdeveloper()
	{
		return (Boolean) this.getKeyValue("sandboxDeveloper");

	}

	/**
	 * The method to set the value to sandboxdeveloper
	 * @param sandboxdeveloper A Boolean representing the sandboxdeveloper
	 */
	public void setSandboxdeveloper(Boolean sandboxdeveloper)
	{
		 this.addKeyValue("sandboxDeveloper", sandboxdeveloper);

	}

	/**
	 * The method to get the value of alias
	 * @return A String representing the alias
	 */
	public String getAlias()
	{
		return (String) this.getKeyValue("alias");

	}

	/**
	 * The method to set the value to alias
	 * @param alias A String representing the alias
	 */
	public void setAlias(String alias)
	{
		 this.addKeyValue("alias", alias);

	}

	/**
	 * The method to get the value of street
	 * @return A String representing the street
	 */
	public String getStreet()
	{
		return (String) this.getKeyValue("street");

	}

	/**
	 * The method to set the value to street
	 * @param street A String representing the street
	 */
	public void setStreet(String street)
	{
		 this.addKeyValue("street", street);

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
	 * The method to get the value of isonline
	 * @return A Boolean representing the isonline
	 */
	public Boolean getIsonline()
	{
		return (Boolean) this.getKeyValue("Isonline");

	}

	/**
	 * The method to set the value to isonline
	 * @param isonline A Boolean representing the isonline
	 */
	public void setIsonline(Boolean isonline)
	{
		 this.addKeyValue("Isonline", isonline);

	}

	/**
	 * The method to get the value of locale
	 * @return A String representing the locale
	 */
	public String getLocale()
	{
		return (String) this.getKeyValue("locale");

	}

	/**
	 * The method to set the value to locale
	 * @param locale A String representing the locale
	 */
	public void setLocale(String locale)
	{
		 this.addKeyValue("locale", locale);

	}

	/**
	 * The method to get the value of nameFormatS
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getNameFormatS()
	{
		return (Choice<String>) this.getKeyValue("name_format__s");

	}

	/**
	 * The method to set the value to nameFormatS
	 * @param nameFormatS An instance of Choice<String>
	 */
	public void setNameFormatS(Choice<String> nameFormatS)
	{
		 this.addKeyValue("name_format__s", nameFormatS);

	}

	/**
	 * The method to get the value of personalAccount
	 * @return A Boolean representing the personalAccount
	 */
	public Boolean getPersonalAccount()
	{
		return (Boolean) this.getKeyValue("personal_account");

	}

	/**
	 * The method to set the value to personalAccount
	 * @param personalAccount A Boolean representing the personalAccount
	 */
	public void setPersonalAccount(Boolean personalAccount)
	{
		 this.addKeyValue("personal_account", personalAccount);

	}

	/**
	 * The method to get the value of defaultTabGroup
	 * @return A String representing the defaultTabGroup
	 */
	public String getDefaultTabGroup()
	{
		return (String) this.getKeyValue("default_tab_group");

	}

	/**
	 * The method to set the value to defaultTabGroup
	 * @param defaultTabGroup A String representing the defaultTabGroup
	 */
	public void setDefaultTabGroup(String defaultTabGroup)
	{
		 this.addKeyValue("default_tab_group", defaultTabGroup);

	}

	/**
	 * The method to get the value of theme
	 * @return An instance of Theme
	 */
	public Theme getTheme()
	{
		return (Theme) this.getKeyValue("theme");

	}

	/**
	 * The method to set the value to theme
	 * @param theme An instance of Theme
	 */
	public void setTheme(Theme theme)
	{
		 this.addKeyValue("theme", theme);

	}

	/**
	 * The method to get the value of ntcNotificationType
	 * @return An instance of List<Long>
	 */
	public List<Long> getNtcNotificationType()
	{
		return (List<Long>) this.getKeyValue("ntc_notification_type");

	}

	/**
	 * The method to set the value to ntcNotificationType
	 * @param ntcNotificationType An instance of List<Long>
	 */
	public void setNtcNotificationType(List<Long> ntcNotificationType)
	{
		 this.addKeyValue("ntc_notification_type", ntcNotificationType);

	}

	/**
	 * The method to get the value of ntcEnabled
	 * @return A Boolean representing the ntcEnabled
	 */
	public Boolean getNtcEnabled()
	{
		return (Boolean) this.getKeyValue("ntc_enabled");

	}

	/**
	 * The method to set the value to ntcEnabled
	 * @param ntcEnabled A Boolean representing the ntcEnabled
	 */
	public void setNtcEnabled(Boolean ntcEnabled)
	{
		 this.addKeyValue("ntc_enabled", ntcEnabled);

	}

	/**
	 * The method to get the value of rtlEnabled
	 * @return A Boolean representing the rtlEnabled
	 */
	public Boolean getRtlEnabled()
	{
		return (Boolean) this.getKeyValue("rtl_enabled");

	}

	/**
	 * The method to set the value to rtlEnabled
	 * @param rtlEnabled A Boolean representing the rtlEnabled
	 */
	public void setRtlEnabled(Boolean rtlEnabled)
	{
		 this.addKeyValue("rtl_enabled", rtlEnabled);

	}

	/**
	 * The method to get the value of telephonyEnabled
	 * @return A Boolean representing the telephonyEnabled
	 */
	public Boolean getTelephonyEnabled()
	{
		return (Boolean) this.getKeyValue("telephony_enabled");

	}

	/**
	 * The method to set the value to telephonyEnabled
	 * @param telephonyEnabled A Boolean representing the telephonyEnabled
	 */
	public void setTelephonyEnabled(Boolean telephonyEnabled)
	{
		 this.addKeyValue("telephony_enabled", telephonyEnabled);

	}

	/**
	 * The method to get the value of sortOrderPreference
	 * @return A String representing the sortOrderPreference
	 */
	public String getSortOrderPreference()
	{
		return (String) this.getKeyValue("sort_order_preference");

	}

	/**
	 * The method to set the value to sortOrderPreference
	 * @param sortOrderPreference A String representing the sortOrderPreference
	 */
	public void setSortOrderPreference(String sortOrderPreference)
	{
		 this.addKeyValue("sort_order_preference", sortOrderPreference);

	}

	/**
	 * The method to get the value of createdBy17
	 * @return An instance of MinifiedUser
	 */
	public MinifiedUser getCreatedBy17()
	{
		return (MinifiedUser) this.getKeyValue("Created_By");

	}

	/**
	 * The method to set the value to createdBy17
	 * @param createdBy17 An instance of MinifiedUser
	 */
	public void setCreatedBy17(MinifiedUser createdBy17)
	{
		 this.addKeyValue("Created_By", createdBy17);

	}

	/**
	 * The method to get the value of createdTime9
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getCreatedTime9()
	{
		return (OffsetDateTime) this.getKeyValue("Created_Time");

	}

	/**
	 * The method to set the value to createdTime9
	 * @param createdTime9 An instance of OffsetDateTime
	 */
	public void setCreatedTime9(OffsetDateTime createdTime9)
	{
		 this.addKeyValue("Created_Time", createdTime9);

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