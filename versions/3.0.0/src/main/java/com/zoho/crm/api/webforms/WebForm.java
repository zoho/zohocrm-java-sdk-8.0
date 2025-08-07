package com.zoho.crm.api.webforms;

import com.zoho.crm.api.util.Model;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;

public class WebForm implements Model
{
	private String googleSite;

	private String encryptedFormId;

	private Owner owner;

	private User userType;

	private AcknowledgeVisitors acknowledgeVisitor;

	private List<ButtonAttributes> buttonAttributes;

	private String encryptedZgid;

	private OffsetDateTime createdTime;

	private AnalyticsData analyticsData;

	private Module module;

	private String encryptedModule;

	private Boolean active;

	private Boolean adwordEnabled;

	private Owner notifyOwner;

	private User createdBy;

	private FormAttributes formAttributes;

	private List<String> locationUrl;

	private String landingUrl;

	private Boolean doubleOptinEnabled;

	private Layout layout;

	private List<Tags> tags;

	private Boolean approvalRequest;

	private String type;

	private Boolean createContact;

	private AssignmentRule assignmentRule;

	private String name;

	private Long id;

	private SpamControll spamControl;

	private List<Fields> fields;

	private List<Fields> formFields;

	private List<Abtesting> abtesting;

	private String visitorTracking;

	private OffsetDateTime lastSubmittedTime;

	private String actionOnSubmit;

	private String actionValue;

	private Suggestion suggestion;

	private String embedCode;

	private List<String> codeFormats;

	private String sourceCode;

	private String iframeCode;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of googleSite
	 * @return A String representing the googleSite
	 */
	public String getGoogleSite()
	{
		return  this.googleSite;

	}

	/**
	 * The method to set the value to googleSite
	 * @param googleSite A String representing the googleSite
	 */
	public void setGoogleSite(String googleSite)
	{
		 this.googleSite = googleSite;

		 this.keyModified.put("google_site", 1);

	}

	/**
	 * The method to get the value of encryptedFormId
	 * @return A String representing the encryptedFormId
	 */
	public String getEncryptedFormId()
	{
		return  this.encryptedFormId;

	}

	/**
	 * The method to set the value to encryptedFormId
	 * @param encryptedFormId A String representing the encryptedFormId
	 */
	public void setEncryptedFormId(String encryptedFormId)
	{
		 this.encryptedFormId = encryptedFormId;

		 this.keyModified.put("encrypted_form_id", 1);

	}

	/**
	 * The method to get the value of owner
	 * @return An instance of Owner
	 */
	public Owner getOwner()
	{
		return  this.owner;

	}

	/**
	 * The method to set the value to owner
	 * @param owner An instance of Owner
	 */
	public void setOwner(Owner owner)
	{
		 this.owner = owner;

		 this.keyModified.put("owner", 1);

	}

	/**
	 * The method to get the value of userType
	 * @return An instance of User
	 */
	public User getUserType()
	{
		return  this.userType;

	}

	/**
	 * The method to set the value to userType
	 * @param userType An instance of User
	 */
	public void setUserType(User userType)
	{
		 this.userType = userType;

		 this.keyModified.put("user_type", 1);

	}

	/**
	 * The method to get the value of acknowledgeVisitor
	 * @return An instance of AcknowledgeVisitors
	 */
	public AcknowledgeVisitors getAcknowledgeVisitor()
	{
		return  this.acknowledgeVisitor;

	}

	/**
	 * The method to set the value to acknowledgeVisitor
	 * @param acknowledgeVisitor An instance of AcknowledgeVisitors
	 */
	public void setAcknowledgeVisitor(AcknowledgeVisitors acknowledgeVisitor)
	{
		 this.acknowledgeVisitor = acknowledgeVisitor;

		 this.keyModified.put("acknowledge_visitor", 1);

	}

	/**
	 * The method to get the value of buttonAttributes
	 * @return An instance of List<ButtonAttributes>
	 */
	public List<ButtonAttributes> getButtonAttributes()
	{
		return  this.buttonAttributes;

	}

	/**
	 * The method to set the value to buttonAttributes
	 * @param buttonAttributes An instance of List<ButtonAttributes>
	 */
	public void setButtonAttributes(List<ButtonAttributes> buttonAttributes)
	{
		 this.buttonAttributes = buttonAttributes;

		 this.keyModified.put("button_attributes", 1);

	}

	/**
	 * The method to get the value of encryptedZgid
	 * @return A String representing the encryptedZgid
	 */
	public String getEncryptedZgid()
	{
		return  this.encryptedZgid;

	}

	/**
	 * The method to set the value to encryptedZgid
	 * @param encryptedZgid A String representing the encryptedZgid
	 */
	public void setEncryptedZgid(String encryptedZgid)
	{
		 this.encryptedZgid = encryptedZgid;

		 this.keyModified.put("encrypted_zgid", 1);

	}

	/**
	 * The method to get the value of createdTime
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getCreatedTime()
	{
		return  this.createdTime;

	}

	/**
	 * The method to set the value to createdTime
	 * @param createdTime An instance of OffsetDateTime
	 */
	public void setCreatedTime(OffsetDateTime createdTime)
	{
		 this.createdTime = createdTime;

		 this.keyModified.put("created_time", 1);

	}

	/**
	 * The method to get the value of analyticsData
	 * @return An instance of AnalyticsData
	 */
	public AnalyticsData getAnalyticsData()
	{
		return  this.analyticsData;

	}

	/**
	 * The method to set the value to analyticsData
	 * @param analyticsData An instance of AnalyticsData
	 */
	public void setAnalyticsData(AnalyticsData analyticsData)
	{
		 this.analyticsData = analyticsData;

		 this.keyModified.put("analytics_data", 1);

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
	 * The method to get the value of encryptedModule
	 * @return A String representing the encryptedModule
	 */
	public String getEncryptedModule()
	{
		return  this.encryptedModule;

	}

	/**
	 * The method to set the value to encryptedModule
	 * @param encryptedModule A String representing the encryptedModule
	 */
	public void setEncryptedModule(String encryptedModule)
	{
		 this.encryptedModule = encryptedModule;

		 this.keyModified.put("encrypted_module", 1);

	}

	/**
	 * The method to get the value of active
	 * @return A Boolean representing the active
	 */
	public Boolean getActive()
	{
		return  this.active;

	}

	/**
	 * The method to set the value to active
	 * @param active A Boolean representing the active
	 */
	public void setActive(Boolean active)
	{
		 this.active = active;

		 this.keyModified.put("active", 1);

	}

	/**
	 * The method to get the value of adwordEnabled
	 * @return A Boolean representing the adwordEnabled
	 */
	public Boolean getAdwordEnabled()
	{
		return  this.adwordEnabled;

	}

	/**
	 * The method to set the value to adwordEnabled
	 * @param adwordEnabled A Boolean representing the adwordEnabled
	 */
	public void setAdwordEnabled(Boolean adwordEnabled)
	{
		 this.adwordEnabled = adwordEnabled;

		 this.keyModified.put("adword_enabled", 1);

	}

	/**
	 * The method to get the value of notifyOwner
	 * @return An instance of Owner
	 */
	public Owner getNotifyOwner()
	{
		return  this.notifyOwner;

	}

	/**
	 * The method to set the value to notifyOwner
	 * @param notifyOwner An instance of Owner
	 */
	public void setNotifyOwner(Owner notifyOwner)
	{
		 this.notifyOwner = notifyOwner;

		 this.keyModified.put("notify_owner", 1);

	}

	/**
	 * The method to get the value of createdBy
	 * @return An instance of User
	 */
	public User getCreatedBy()
	{
		return  this.createdBy;

	}

	/**
	 * The method to set the value to createdBy
	 * @param createdBy An instance of User
	 */
	public void setCreatedBy(User createdBy)
	{
		 this.createdBy = createdBy;

		 this.keyModified.put("created_by", 1);

	}

	/**
	 * The method to get the value of formAttributes
	 * @return An instance of FormAttributes
	 */
	public FormAttributes getFormAttributes()
	{
		return  this.formAttributes;

	}

	/**
	 * The method to set the value to formAttributes
	 * @param formAttributes An instance of FormAttributes
	 */
	public void setFormAttributes(FormAttributes formAttributes)
	{
		 this.formAttributes = formAttributes;

		 this.keyModified.put("form_attributes", 1);

	}

	/**
	 * The method to get the value of locationUrl
	 * @return An instance of List<String>
	 */
	public List<String> getLocationUrl()
	{
		return  this.locationUrl;

	}

	/**
	 * The method to set the value to locationUrl
	 * @param locationUrl An instance of List<String>
	 */
	public void setLocationUrl(List<String> locationUrl)
	{
		 this.locationUrl = locationUrl;

		 this.keyModified.put("location_url", 1);

	}

	/**
	 * The method to get the value of landingUrl
	 * @return A String representing the landingUrl
	 */
	public String getLandingUrl()
	{
		return  this.landingUrl;

	}

	/**
	 * The method to set the value to landingUrl
	 * @param landingUrl A String representing the landingUrl
	 */
	public void setLandingUrl(String landingUrl)
	{
		 this.landingUrl = landingUrl;

		 this.keyModified.put("landing_url", 1);

	}

	/**
	 * The method to get the value of doubleOptinEnabled
	 * @return A Boolean representing the doubleOptinEnabled
	 */
	public Boolean getDoubleOptinEnabled()
	{
		return  this.doubleOptinEnabled;

	}

	/**
	 * The method to set the value to doubleOptinEnabled
	 * @param doubleOptinEnabled A Boolean representing the doubleOptinEnabled
	 */
	public void setDoubleOptinEnabled(Boolean doubleOptinEnabled)
	{
		 this.doubleOptinEnabled = doubleOptinEnabled;

		 this.keyModified.put("double_optin_enabled", 1);

	}

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
	 * The method to get the value of tags
	 * @return An instance of List<Tags>
	 */
	public List<Tags> getTags()
	{
		return  this.tags;

	}

	/**
	 * The method to set the value to tags
	 * @param tags An instance of List<Tags>
	 */
	public void setTags(List<Tags> tags)
	{
		 this.tags = tags;

		 this.keyModified.put("tags", 1);

	}

	/**
	 * The method to get the value of approvalRequest
	 * @return A Boolean representing the approvalRequest
	 */
	public Boolean getApprovalRequest()
	{
		return  this.approvalRequest;

	}

	/**
	 * The method to set the value to approvalRequest
	 * @param approvalRequest A Boolean representing the approvalRequest
	 */
	public void setApprovalRequest(Boolean approvalRequest)
	{
		 this.approvalRequest = approvalRequest;

		 this.keyModified.put("approval_request", 1);

	}

	/**
	 * The method to get the value of type
	 * @return A String representing the type
	 */
	public String getType()
	{
		return  this.type;

	}

	/**
	 * The method to set the value to type
	 * @param type A String representing the type
	 */
	public void setType(String type)
	{
		 this.type = type;

		 this.keyModified.put("type", 1);

	}

	/**
	 * The method to get the value of createContact
	 * @return A Boolean representing the createContact
	 */
	public Boolean getCreateContact()
	{
		return  this.createContact;

	}

	/**
	 * The method to set the value to createContact
	 * @param createContact A Boolean representing the createContact
	 */
	public void setCreateContact(Boolean createContact)
	{
		 this.createContact = createContact;

		 this.keyModified.put("create_contact", 1);

	}

	/**
	 * The method to get the value of assignmentRule
	 * @return An instance of AssignmentRule
	 */
	public AssignmentRule getAssignmentRule()
	{
		return  this.assignmentRule;

	}

	/**
	 * The method to set the value to assignmentRule
	 * @param assignmentRule An instance of AssignmentRule
	 */
	public void setAssignmentRule(AssignmentRule assignmentRule)
	{
		 this.assignmentRule = assignmentRule;

		 this.keyModified.put("assignment_rule", 1);

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
	 * The method to get the value of spamControl
	 * @return An instance of SpamControll
	 */
	public SpamControll getSpamControl()
	{
		return  this.spamControl;

	}

	/**
	 * The method to set the value to spamControl
	 * @param spamControl An instance of SpamControll
	 */
	public void setSpamControl(SpamControll spamControl)
	{
		 this.spamControl = spamControl;

		 this.keyModified.put("spam_control", 1);

	}

	/**
	 * The method to get the value of fields
	 * @return An instance of List<Fields>
	 */
	public List<Fields> getFields()
	{
		return  this.fields;

	}

	/**
	 * The method to set the value to fields
	 * @param fields An instance of List<Fields>
	 */
	public void setFields(List<Fields> fields)
	{
		 this.fields = fields;

		 this.keyModified.put("fields", 1);

	}

	/**
	 * The method to get the value of formFields
	 * @return An instance of List<Fields>
	 */
	public List<Fields> getFormFields()
	{
		return  this.formFields;

	}

	/**
	 * The method to set the value to formFields
	 * @param formFields An instance of List<Fields>
	 */
	public void setFormFields(List<Fields> formFields)
	{
		 this.formFields = formFields;

		 this.keyModified.put("form_fields", 1);

	}

	/**
	 * The method to get the value of abtesting
	 * @return An instance of List<Abtesting>
	 */
	public List<Abtesting> getAbtesting()
	{
		return  this.abtesting;

	}

	/**
	 * The method to set the value to abtesting
	 * @param abtesting An instance of List<Abtesting>
	 */
	public void setAbtesting(List<Abtesting> abtesting)
	{
		 this.abtesting = abtesting;

		 this.keyModified.put("abtesting", 1);

	}

	/**
	 * The method to get the value of visitorTracking
	 * @return A String representing the visitorTracking
	 */
	public String getVisitorTracking()
	{
		return  this.visitorTracking;

	}

	/**
	 * The method to set the value to visitorTracking
	 * @param visitorTracking A String representing the visitorTracking
	 */
	public void setVisitorTracking(String visitorTracking)
	{
		 this.visitorTracking = visitorTracking;

		 this.keyModified.put("visitor_tracking", 1);

	}

	/**
	 * The method to get the value of lastSubmittedTime
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getLastSubmittedTime()
	{
		return  this.lastSubmittedTime;

	}

	/**
	 * The method to set the value to lastSubmittedTime
	 * @param lastSubmittedTime An instance of OffsetDateTime
	 */
	public void setLastSubmittedTime(OffsetDateTime lastSubmittedTime)
	{
		 this.lastSubmittedTime = lastSubmittedTime;

		 this.keyModified.put("last_submitted_time", 1);

	}

	/**
	 * The method to get the value of actionOnSubmit
	 * @return A String representing the actionOnSubmit
	 */
	public String getActionOnSubmit()
	{
		return  this.actionOnSubmit;

	}

	/**
	 * The method to set the value to actionOnSubmit
	 * @param actionOnSubmit A String representing the actionOnSubmit
	 */
	public void setActionOnSubmit(String actionOnSubmit)
	{
		 this.actionOnSubmit = actionOnSubmit;

		 this.keyModified.put("action_on_submit", 1);

	}

	/**
	 * The method to get the value of actionValue
	 * @return A String representing the actionValue
	 */
	public String getActionValue()
	{
		return  this.actionValue;

	}

	/**
	 * The method to set the value to actionValue
	 * @param actionValue A String representing the actionValue
	 */
	public void setActionValue(String actionValue)
	{
		 this.actionValue = actionValue;

		 this.keyModified.put("action_value", 1);

	}

	/**
	 * The method to get the value of suggestion
	 * @return An instance of Suggestion
	 */
	public Suggestion getSuggestion()
	{
		return  this.suggestion;

	}

	/**
	 * The method to set the value to suggestion
	 * @param suggestion An instance of Suggestion
	 */
	public void setSuggestion(Suggestion suggestion)
	{
		 this.suggestion = suggestion;

		 this.keyModified.put("suggestion", 1);

	}

	/**
	 * The method to get the value of embedCode
	 * @return A String representing the embedCode
	 */
	public String getEmbedCode()
	{
		return  this.embedCode;

	}

	/**
	 * The method to set the value to embedCode
	 * @param embedCode A String representing the embedCode
	 */
	public void setEmbedCode(String embedCode)
	{
		 this.embedCode = embedCode;

		 this.keyModified.put("embed_code", 1);

	}

	/**
	 * The method to get the value of codeFormats
	 * @return An instance of List<String>
	 */
	public List<String> getCodeFormats()
	{
		return  this.codeFormats;

	}

	/**
	 * The method to set the value to codeFormats
	 * @param codeFormats An instance of List<String>
	 */
	public void setCodeFormats(List<String> codeFormats)
	{
		 this.codeFormats = codeFormats;

		 this.keyModified.put("code_formats", 1);

	}

	/**
	 * The method to get the value of sourceCode
	 * @return A String representing the sourceCode
	 */
	public String getSourceCode()
	{
		return  this.sourceCode;

	}

	/**
	 * The method to set the value to sourceCode
	 * @param sourceCode A String representing the sourceCode
	 */
	public void setSourceCode(String sourceCode)
	{
		 this.sourceCode = sourceCode;

		 this.keyModified.put("source_code", 1);

	}

	/**
	 * The method to get the value of iframeCode
	 * @return A String representing the iframeCode
	 */
	public String getIframeCode()
	{
		return  this.iframeCode;

	}

	/**
	 * The method to set the value to iframeCode
	 * @param iframeCode A String representing the iframeCode
	 */
	public void setIframeCode(String iframeCode)
	{
		 this.iframeCode = iframeCode;

		 this.keyModified.put("iframe_code", 1);

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