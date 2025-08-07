package com.zoho.crm.api.blueprint;

import com.zoho.crm.api.fields.External;
import com.zoho.crm.api.fields.MultiModuleLookup;
import com.zoho.crm.api.fields.PickListValue;
import com.zoho.crm.api.fields.Private;
import com.zoho.crm.api.fields.Unique;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Field implements Model
{
	private External external;

	private Choice<Integer> displayType;

	private Boolean filterable;

	private Boolean pickListValuesSortedLexically;

	private Boolean sortable;

	private Integer uiType;

	private Private private1;

	private Boolean systemMandatory;

	private Boolean webhook;

	private String jsonType;

	private Crypt crypt;

	private String fieldLabel;

	private ToolTip tooltip;

	private String createdSource;

	private Layout layouts;

	private Boolean fieldReadOnly;

	private String content;

	private String displayLabel;

	private String validationRule;

	private Boolean readOnly;

	private AssociationDetails associationDetails;

	private MultiModuleLookup multiModuleLookup;

	private Currency currency;

	private String id;

	private Boolean customField;

	private Module lookup;

	private Map<String, Object> convertMapping;

	private Boolean visible;

	private Integer length;

	private String columnName;

	private String type;

	private ViewType viewType;

	private Integer transitionSequence;

	private String apiName;

	private Unique unique;

	private Boolean historyTracking;

	private String dataType;

	private Formula formula;

	private String decimalPlace;

	private MultiSelectLookup multiselectlookup;

	private List<PickListValue> pickListValues;

	private AutoNumber autoNumber;

	private String personalityName;

	private Boolean mandatory;

	private Long quickSequenceNumber;

	private List<Profile> profiles;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of external
	 * @return An instance of External
	 */
	public External getExternal()
	{
		return  this.external;

	}

	/**
	 * The method to set the value to external
	 * @param external An instance of External
	 */
	public void setExternal(External external)
	{
		 this.external = external;

		 this.keyModified.put("external", 1);

	}

	/**
	 * The method to get the value of displayType
	 * @return An instance of Choice<Integer>
	 */
	public Choice<Integer> getDisplayType()
	{
		return  this.displayType;

	}

	/**
	 * The method to set the value to displayType
	 * @param displayType An instance of Choice<Integer>
	 */
	public void setDisplayType(Choice<Integer> displayType)
	{
		 this.displayType = displayType;

		 this.keyModified.put("display_type", 1);

	}

	/**
	 * The method to get the value of filterable
	 * @return A Boolean representing the filterable
	 */
	public Boolean getFilterable()
	{
		return  this.filterable;

	}

	/**
	 * The method to set the value to filterable
	 * @param filterable A Boolean representing the filterable
	 */
	public void setFilterable(Boolean filterable)
	{
		 this.filterable = filterable;

		 this.keyModified.put("filterable", 1);

	}

	/**
	 * The method to get the value of pickListValuesSortedLexically
	 * @return A Boolean representing the pickListValuesSortedLexically
	 */
	public Boolean getPickListValuesSortedLexically()
	{
		return  this.pickListValuesSortedLexically;

	}

	/**
	 * The method to set the value to pickListValuesSortedLexically
	 * @param pickListValuesSortedLexically A Boolean representing the pickListValuesSortedLexically
	 */
	public void setPickListValuesSortedLexically(Boolean pickListValuesSortedLexically)
	{
		 this.pickListValuesSortedLexically = pickListValuesSortedLexically;

		 this.keyModified.put("pick_list_values_sorted_lexically", 1);

	}

	/**
	 * The method to get the value of sortable
	 * @return A Boolean representing the sortable
	 */
	public Boolean getSortable()
	{
		return  this.sortable;

	}

	/**
	 * The method to set the value to sortable
	 * @param sortable A Boolean representing the sortable
	 */
	public void setSortable(Boolean sortable)
	{
		 this.sortable = sortable;

		 this.keyModified.put("sortable", 1);

	}

	/**
	 * The method to get the value of uiType
	 * @return An Integer representing the uiType
	 */
	public Integer getUiType()
	{
		return  this.uiType;

	}

	/**
	 * The method to set the value to uiType
	 * @param uiType An Integer representing the uiType
	 */
	public void setUiType(Integer uiType)
	{
		 this.uiType = uiType;

		 this.keyModified.put("ui_type", 1);

	}

	/**
	 * The method to get the value of private
	 * @return An instance of Private
	 */
	public Private getPrivate()
	{
		return  this.private1;

	}

	/**
	 * The method to set the value to private
	 * @param private1 An instance of Private
	 */
	public void setPrivate(Private private1)
	{
		 this.private1 = private1;

		 this.keyModified.put("private", 1);

	}

	/**
	 * The method to get the value of systemMandatory
	 * @return A Boolean representing the systemMandatory
	 */
	public Boolean getSystemMandatory()
	{
		return  this.systemMandatory;

	}

	/**
	 * The method to set the value to systemMandatory
	 * @param systemMandatory A Boolean representing the systemMandatory
	 */
	public void setSystemMandatory(Boolean systemMandatory)
	{
		 this.systemMandatory = systemMandatory;

		 this.keyModified.put("system_mandatory", 1);

	}

	/**
	 * The method to get the value of webhook
	 * @return A Boolean representing the webhook
	 */
	public Boolean getWebhook()
	{
		return  this.webhook;

	}

	/**
	 * The method to set the value to webhook
	 * @param webhook A Boolean representing the webhook
	 */
	public void setWebhook(Boolean webhook)
	{
		 this.webhook = webhook;

		 this.keyModified.put("webhook", 1);

	}

	/**
	 * The method to get the value of jsonType
	 * @return A String representing the jsonType
	 */
	public String getJsonType()
	{
		return  this.jsonType;

	}

	/**
	 * The method to set the value to jsonType
	 * @param jsonType A String representing the jsonType
	 */
	public void setJsonType(String jsonType)
	{
		 this.jsonType = jsonType;

		 this.keyModified.put("json_type", 1);

	}

	/**
	 * The method to get the value of crypt
	 * @return An instance of Crypt
	 */
	public Crypt getCrypt()
	{
		return  this.crypt;

	}

	/**
	 * The method to set the value to crypt
	 * @param crypt An instance of Crypt
	 */
	public void setCrypt(Crypt crypt)
	{
		 this.crypt = crypt;

		 this.keyModified.put("crypt", 1);

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
	 * The method to get the value of tooltip
	 * @return An instance of ToolTip
	 */
	public ToolTip getTooltip()
	{
		return  this.tooltip;

	}

	/**
	 * The method to set the value to tooltip
	 * @param tooltip An instance of ToolTip
	 */
	public void setTooltip(ToolTip tooltip)
	{
		 this.tooltip = tooltip;

		 this.keyModified.put("tooltip", 1);

	}

	/**
	 * The method to get the value of createdSource
	 * @return A String representing the createdSource
	 */
	public String getCreatedSource()
	{
		return  this.createdSource;

	}

	/**
	 * The method to set the value to createdSource
	 * @param createdSource A String representing the createdSource
	 */
	public void setCreatedSource(String createdSource)
	{
		 this.createdSource = createdSource;

		 this.keyModified.put("created_source", 1);

	}

	/**
	 * The method to get the value of layouts
	 * @return An instance of Layout
	 */
	public Layout getLayouts()
	{
		return  this.layouts;

	}

	/**
	 * The method to set the value to layouts
	 * @param layouts An instance of Layout
	 */
	public void setLayouts(Layout layouts)
	{
		 this.layouts = layouts;

		 this.keyModified.put("layouts", 1);

	}

	/**
	 * The method to get the value of fieldReadOnly
	 * @return A Boolean representing the fieldReadOnly
	 */
	public Boolean getFieldReadOnly()
	{
		return  this.fieldReadOnly;

	}

	/**
	 * The method to set the value to fieldReadOnly
	 * @param fieldReadOnly A Boolean representing the fieldReadOnly
	 */
	public void setFieldReadOnly(Boolean fieldReadOnly)
	{
		 this.fieldReadOnly = fieldReadOnly;

		 this.keyModified.put("field_read_only", 1);

	}

	/**
	 * The method to get the value of content
	 * @return A String representing the content
	 */
	public String getContent()
	{
		return  this.content;

	}

	/**
	 * The method to set the value to content
	 * @param content A String representing the content
	 */
	public void setContent(String content)
	{
		 this.content = content;

		 this.keyModified.put("content", 1);

	}

	/**
	 * The method to get the value of displayLabel
	 * @return A String representing the displayLabel
	 */
	public String getDisplayLabel()
	{
		return  this.displayLabel;

	}

	/**
	 * The method to set the value to displayLabel
	 * @param displayLabel A String representing the displayLabel
	 */
	public void setDisplayLabel(String displayLabel)
	{
		 this.displayLabel = displayLabel;

		 this.keyModified.put("display_label", 1);

	}

	/**
	 * The method to get the value of validationRule
	 * @return A String representing the validationRule
	 */
	public String getValidationRule()
	{
		return  this.validationRule;

	}

	/**
	 * The method to set the value to validationRule
	 * @param validationRule A String representing the validationRule
	 */
	public void setValidationRule(String validationRule)
	{
		 this.validationRule = validationRule;

		 this.keyModified.put("validation_rule", 1);

	}

	/**
	 * The method to get the value of readOnly
	 * @return A Boolean representing the readOnly
	 */
	public Boolean getReadOnly()
	{
		return  this.readOnly;

	}

	/**
	 * The method to set the value to readOnly
	 * @param readOnly A Boolean representing the readOnly
	 */
	public void setReadOnly(Boolean readOnly)
	{
		 this.readOnly = readOnly;

		 this.keyModified.put("read_only", 1);

	}

	/**
	 * The method to get the value of associationDetails
	 * @return An instance of AssociationDetails
	 */
	public AssociationDetails getAssociationDetails()
	{
		return  this.associationDetails;

	}

	/**
	 * The method to set the value to associationDetails
	 * @param associationDetails An instance of AssociationDetails
	 */
	public void setAssociationDetails(AssociationDetails associationDetails)
	{
		 this.associationDetails = associationDetails;

		 this.keyModified.put("association_details", 1);

	}

	/**
	 * The method to get the value of multiModuleLookup
	 * @return An instance of MultiModuleLookup
	 */
	public MultiModuleLookup getMultiModuleLookup()
	{
		return  this.multiModuleLookup;

	}

	/**
	 * The method to set the value to multiModuleLookup
	 * @param multiModuleLookup An instance of MultiModuleLookup
	 */
	public void setMultiModuleLookup(MultiModuleLookup multiModuleLookup)
	{
		 this.multiModuleLookup = multiModuleLookup;

		 this.keyModified.put("multi_module_lookup", 1);

	}

	/**
	 * The method to get the value of currency
	 * @return An instance of Currency
	 */
	public Currency getCurrency()
	{
		return  this.currency;

	}

	/**
	 * The method to set the value to currency
	 * @param currency An instance of Currency
	 */
	public void setCurrency(Currency currency)
	{
		 this.currency = currency;

		 this.keyModified.put("currency", 1);

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
	 * The method to get the value of customField
	 * @return A Boolean representing the customField
	 */
	public Boolean getCustomField()
	{
		return  this.customField;

	}

	/**
	 * The method to set the value to customField
	 * @param customField A Boolean representing the customField
	 */
	public void setCustomField(Boolean customField)
	{
		 this.customField = customField;

		 this.keyModified.put("custom_field", 1);

	}

	/**
	 * The method to get the value of lookup
	 * @return An instance of Module
	 */
	public Module getLookup()
	{
		return  this.lookup;

	}

	/**
	 * The method to set the value to lookup
	 * @param lookup An instance of Module
	 */
	public void setLookup(Module lookup)
	{
		 this.lookup = lookup;

		 this.keyModified.put("lookup", 1);

	}

	/**
	 * The method to get the value of convertMapping
	 * @return An instance of Map<String,Object>
	 */
	public Map<String, Object> getConvertMapping()
	{
		return  this.convertMapping;

	}

	/**
	 * The method to set the value to convertMapping
	 * @param convertMapping An instance of Map<String,Object>
	 */
	public void setConvertMapping(Map<String, Object> convertMapping)
	{
		 this.convertMapping = convertMapping;

		 this.keyModified.put("convert_mapping", 1);

	}

	/**
	 * The method to get the value of visible
	 * @return A Boolean representing the visible
	 */
	public Boolean getVisible()
	{
		return  this.visible;

	}

	/**
	 * The method to set the value to visible
	 * @param visible A Boolean representing the visible
	 */
	public void setVisible(Boolean visible)
	{
		 this.visible = visible;

		 this.keyModified.put("visible", 1);

	}

	/**
	 * The method to get the value of length
	 * @return An Integer representing the length
	 */
	public Integer getLength()
	{
		return  this.length;

	}

	/**
	 * The method to set the value to length
	 * @param length An Integer representing the length
	 */
	public void setLength(Integer length)
	{
		 this.length = length;

		 this.keyModified.put("length", 1);

	}

	/**
	 * The method to get the value of columnName
	 * @return A String representing the columnName
	 */
	public String getColumnName()
	{
		return  this.columnName;

	}

	/**
	 * The method to set the value to columnName
	 * @param columnName A String representing the columnName
	 */
	public void setColumnName(String columnName)
	{
		 this.columnName = columnName;

		 this.keyModified.put("column_name", 1);

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

		 this.keyModified.put("_type", 1);

	}

	/**
	 * The method to get the value of viewType
	 * @return An instance of ViewType
	 */
	public ViewType getViewType()
	{
		return  this.viewType;

	}

	/**
	 * The method to set the value to viewType
	 * @param viewType An instance of ViewType
	 */
	public void setViewType(ViewType viewType)
	{
		 this.viewType = viewType;

		 this.keyModified.put("view_type", 1);

	}

	/**
	 * The method to get the value of transitionSequence
	 * @return An Integer representing the transitionSequence
	 */
	public Integer getTransitionSequence()
	{
		return  this.transitionSequence;

	}

	/**
	 * The method to set the value to transitionSequence
	 * @param transitionSequence An Integer representing the transitionSequence
	 */
	public void setTransitionSequence(Integer transitionSequence)
	{
		 this.transitionSequence = transitionSequence;

		 this.keyModified.put("transition_sequence", 1);

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
	 * The method to get the value of unique
	 * @return An instance of Unique
	 */
	public Unique getUnique()
	{
		return  this.unique;

	}

	/**
	 * The method to set the value to unique
	 * @param unique An instance of Unique
	 */
	public void setUnique(Unique unique)
	{
		 this.unique = unique;

		 this.keyModified.put("unique", 1);

	}

	/**
	 * The method to get the value of historyTracking
	 * @return A Boolean representing the historyTracking
	 */
	public Boolean getHistoryTracking()
	{
		return  this.historyTracking;

	}

	/**
	 * The method to set the value to historyTracking
	 * @param historyTracking A Boolean representing the historyTracking
	 */
	public void setHistoryTracking(Boolean historyTracking)
	{
		 this.historyTracking = historyTracking;

		 this.keyModified.put("history_tracking", 1);

	}

	/**
	 * The method to get the value of dataType
	 * @return A String representing the dataType
	 */
	public String getDataType()
	{
		return  this.dataType;

	}

	/**
	 * The method to set the value to dataType
	 * @param dataType A String representing the dataType
	 */
	public void setDataType(String dataType)
	{
		 this.dataType = dataType;

		 this.keyModified.put("data_type", 1);

	}

	/**
	 * The method to get the value of formula
	 * @return An instance of Formula
	 */
	public Formula getFormula()
	{
		return  this.formula;

	}

	/**
	 * The method to set the value to formula
	 * @param formula An instance of Formula
	 */
	public void setFormula(Formula formula)
	{
		 this.formula = formula;

		 this.keyModified.put("formula", 1);

	}

	/**
	 * The method to get the value of decimalPlace
	 * @return A String representing the decimalPlace
	 */
	public String getDecimalPlace()
	{
		return  this.decimalPlace;

	}

	/**
	 * The method to set the value to decimalPlace
	 * @param decimalPlace A String representing the decimalPlace
	 */
	public void setDecimalPlace(String decimalPlace)
	{
		 this.decimalPlace = decimalPlace;

		 this.keyModified.put("decimal_place", 1);

	}

	/**
	 * The method to get the value of multiselectlookup
	 * @return An instance of MultiSelectLookup
	 */
	public MultiSelectLookup getMultiselectlookup()
	{
		return  this.multiselectlookup;

	}

	/**
	 * The method to set the value to multiselectlookup
	 * @param multiselectlookup An instance of MultiSelectLookup
	 */
	public void setMultiselectlookup(MultiSelectLookup multiselectlookup)
	{
		 this.multiselectlookup = multiselectlookup;

		 this.keyModified.put("multiselectlookup", 1);

	}

	/**
	 * The method to get the value of pickListValues
	 * @return An instance of List<PickListValue>
	 */
	public List<PickListValue> getPickListValues()
	{
		return  this.pickListValues;

	}

	/**
	 * The method to set the value to pickListValues
	 * @param pickListValues An instance of List<PickListValue>
	 */
	public void setPickListValues(List<PickListValue> pickListValues)
	{
		 this.pickListValues = pickListValues;

		 this.keyModified.put("pick_list_values", 1);

	}

	/**
	 * The method to get the value of autoNumber
	 * @return An instance of AutoNumber
	 */
	public AutoNumber getAutoNumber()
	{
		return  this.autoNumber;

	}

	/**
	 * The method to set the value to autoNumber
	 * @param autoNumber An instance of AutoNumber
	 */
	public void setAutoNumber(AutoNumber autoNumber)
	{
		 this.autoNumber = autoNumber;

		 this.keyModified.put("auto_number", 1);

	}

	/**
	 * The method to get the value of personalityName
	 * @return A String representing the personalityName
	 */
	public String getPersonalityName()
	{
		return  this.personalityName;

	}

	/**
	 * The method to set the value to personalityName
	 * @param personalityName A String representing the personalityName
	 */
	public void setPersonalityName(String personalityName)
	{
		 this.personalityName = personalityName;

		 this.keyModified.put("personality_name", 1);

	}

	/**
	 * The method to get the value of mandatory
	 * @return A Boolean representing the mandatory
	 */
	public Boolean getMandatory()
	{
		return  this.mandatory;

	}

	/**
	 * The method to set the value to mandatory
	 * @param mandatory A Boolean representing the mandatory
	 */
	public void setMandatory(Boolean mandatory)
	{
		 this.mandatory = mandatory;

		 this.keyModified.put("mandatory", 1);

	}

	/**
	 * The method to get the value of quickSequenceNumber
	 * @return A Long representing the quickSequenceNumber
	 */
	public Long getQuickSequenceNumber()
	{
		return  this.quickSequenceNumber;

	}

	/**
	 * The method to set the value to quickSequenceNumber
	 * @param quickSequenceNumber A Long representing the quickSequenceNumber
	 */
	public void setQuickSequenceNumber(Long quickSequenceNumber)
	{
		 this.quickSequenceNumber = quickSequenceNumber;

		 this.keyModified.put("quick_sequence_number", 1);

	}

	/**
	 * The method to get the value of profiles
	 * @return An instance of List<Profile>
	 */
	public List<Profile> getProfiles()
	{
		return  this.profiles;

	}

	/**
	 * The method to set the value to profiles
	 * @param profiles An instance of List<Profile>
	 */
	public void setProfiles(List<Profile> profiles)
	{
		 this.profiles = profiles;

		 this.keyModified.put("profiles", 1);

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