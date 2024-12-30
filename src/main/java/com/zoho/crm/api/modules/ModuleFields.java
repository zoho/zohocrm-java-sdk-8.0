package com.zoho.crm.api.modules;

import com.zoho.crm.api.fields.AssociationDetails;
import com.zoho.crm.api.fields.AutoNumber;
import com.zoho.crm.api.fields.ConvertMapping;
import com.zoho.crm.api.fields.Crypt;
import com.zoho.crm.api.fields.Currency;
import com.zoho.crm.api.fields.EmailParser;
import com.zoho.crm.api.fields.External;
import com.zoho.crm.api.fields.Fields;
import com.zoho.crm.api.fields.FileUpoladOption;
import com.zoho.crm.api.fields.Formula;
import com.zoho.crm.api.fields.HipaaCompliance;
import com.zoho.crm.api.fields.HistoryTracking;
import com.zoho.crm.api.fields.LayoutAssociation;
import com.zoho.crm.api.fields.Lookup;
import com.zoho.crm.api.fields.MultiModuleLookup;
import com.zoho.crm.api.fields.Multiselectlookup;
import com.zoho.crm.api.fields.OperationType;
import com.zoho.crm.api.fields.PickListValue;
import com.zoho.crm.api.fields.Private;
import com.zoho.crm.api.fields.Profile;
import com.zoho.crm.api.fields.ReferFromField;
import com.zoho.crm.api.fields.RollupSummary;
import com.zoho.crm.api.fields.Subform;
import com.zoho.crm.api.fields.Textarea;
import com.zoho.crm.api.fields.Tooltip;
import com.zoho.crm.api.fields.Unique;
import com.zoho.crm.api.fields.ViewType;
import com.zoho.crm.api.globalpicklists.Picklist;
import com.zoho.crm.api.util.Model;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;

public class ModuleFields extends Fields implements Model
{
	private Boolean blueprintSupported;

	private String jsonType;

	private Integer length;

	private Integer decimalPlace;

	private MultiModuleLookup multiModuleLookup;

	private SharingProperties sharingProperties;

	private Currency currency;

	private List<FileUpoladOption> fileUpoladOptionlist;

	private Lookup lookup;

	private Subform subform;

	private Formula formula;

	private Multiselectlookup multiselectlookup;

	private Multiselectlookup multiuserlookup;

	private List<PickListValue> pickListValues;

	private List<MinifiedModule> allowedModules;

	private Boolean hipaaComplianceEnabled;

	private HipaaCompliance hipaaCompliance;

	private MinifiedModule associatedModule;

	private String dataType;

	private OperationType operationType;

	private Boolean systemMandatory;

	private Boolean webhook;

	private Integer sequenceNumber;

	private String defaultValue;

	private Boolean virtualField;

	private Boolean fieldReadOnly;

	private List<String> customizableProperties;

	private Boolean readOnly;

	private Boolean customField;

	private Boolean businesscardSupported;

	private Boolean filterable;

	private Boolean visible;

	private Boolean availableInUserLayout;

	private Boolean displayField;

	private Boolean pickListValuesSortedLexically;

	private Boolean sortable;

	private List<LayoutAssociation> layoutAssociations;

	private Boolean separator;

	private Boolean searchable;

	private Boolean enableColourCode;

	private Boolean massUpdate;

	private String createdSource;

	private String type;

	private String displayLabel;

	private String columnName;

	private String apiName;

	private Integer displayType;

	private Integer uiType;

	private Boolean colourCodeEnabledBySystem;

	private String quickSequenceNumber;

	private EmailParser emailParser;

	private RollupSummary rollupSummary;

	private ReferFromField referFromField;

	private OffsetDateTime createdTime;

	private OffsetDateTime modifiedTime;

	private Integer showType;

	private Integer category;

	private Long id;

	private List<Profile> profiles;

	private ViewType viewType;

	private Unique unique;

	private MinifiedModule subModule;

	private External external;

	private Private private1;

	private ConvertMapping convertMapping;

	private AutoNumber autonumber;

	private AutoNumber autoNumber65;

	private Crypt crypt;

	private Tooltip tooltip;

	private HistoryTracking historyTracking;

	private AssociationDetails associationDetails;

	private String additionalColumn;

	private String fieldLabel;

	private Picklist globalPicklist;

	private Boolean updateExistingRecords;

	private Boolean numberSeparator;

	private Textarea textarea;

	private Boolean staticField;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of blueprintSupported
	 * @return A Boolean representing the blueprintSupported
	 */
	public Boolean getBlueprintSupported()
	{
		return  this.blueprintSupported;

	}

	/**
	 * The method to set the value to blueprintSupported
	 * @param blueprintSupported A Boolean representing the blueprintSupported
	 */
	public void setBlueprintSupported(Boolean blueprintSupported)
	{
		 this.blueprintSupported = blueprintSupported;

		 this.keyModified.put("blueprint_supported", 1);

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
	 * The method to get the value of decimalPlace
	 * @return An Integer representing the decimalPlace
	 */
	public Integer getDecimalPlace()
	{
		return  this.decimalPlace;

	}

	/**
	 * The method to set the value to decimalPlace
	 * @param decimalPlace An Integer representing the decimalPlace
	 */
	public void setDecimalPlace(Integer decimalPlace)
	{
		 this.decimalPlace = decimalPlace;

		 this.keyModified.put("decimal_place", 1);

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
	 * The method to get the value of sharingProperties
	 * @return An instance of SharingProperties
	 */
	public SharingProperties getSharingProperties()
	{
		return  this.sharingProperties;

	}

	/**
	 * The method to set the value to sharingProperties
	 * @param sharingProperties An instance of SharingProperties
	 */
	public void setSharingProperties(SharingProperties sharingProperties)
	{
		 this.sharingProperties = sharingProperties;

		 this.keyModified.put("sharing_properties", 1);

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
	 * The method to get the value of fileUpoladOptionlist
	 * @return An instance of List<FileUpoladOption>
	 */
	public List<FileUpoladOption> getFileUpoladOptionlist()
	{
		return  this.fileUpoladOptionlist;

	}

	/**
	 * The method to set the value to fileUpoladOptionlist
	 * @param fileUpoladOptionlist An instance of List<FileUpoladOption>
	 */
	public void setFileUpoladOptionlist(List<FileUpoladOption> fileUpoladOptionlist)
	{
		 this.fileUpoladOptionlist = fileUpoladOptionlist;

		 this.keyModified.put("file_upolad_optionlist", 1);

	}

	/**
	 * The method to get the value of lookup
	 * @return An instance of Lookup
	 */
	public Lookup getLookup()
	{
		return  this.lookup;

	}

	/**
	 * The method to set the value to lookup
	 * @param lookup An instance of Lookup
	 */
	public void setLookup(Lookup lookup)
	{
		 this.lookup = lookup;

		 this.keyModified.put("lookup", 1);

	}

	/**
	 * The method to get the value of subform
	 * @return An instance of Subform
	 */
	public Subform getSubform()
	{
		return  this.subform;

	}

	/**
	 * The method to set the value to subform
	 * @param subform An instance of Subform
	 */
	public void setSubform(Subform subform)
	{
		 this.subform = subform;

		 this.keyModified.put("subform", 1);

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
	 * The method to get the value of multiselectlookup
	 * @return An instance of Multiselectlookup
	 */
	public Multiselectlookup getMultiselectlookup()
	{
		return  this.multiselectlookup;

	}

	/**
	 * The method to set the value to multiselectlookup
	 * @param multiselectlookup An instance of Multiselectlookup
	 */
	public void setMultiselectlookup(Multiselectlookup multiselectlookup)
	{
		 this.multiselectlookup = multiselectlookup;

		 this.keyModified.put("multiselectlookup", 1);

	}

	/**
	 * The method to get the value of multiuserlookup
	 * @return An instance of Multiselectlookup
	 */
	public Multiselectlookup getMultiuserlookup()
	{
		return  this.multiuserlookup;

	}

	/**
	 * The method to set the value to multiuserlookup
	 * @param multiuserlookup An instance of Multiselectlookup
	 */
	public void setMultiuserlookup(Multiselectlookup multiuserlookup)
	{
		 this.multiuserlookup = multiuserlookup;

		 this.keyModified.put("multiuserlookup", 1);

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
	 * The method to get the value of allowedModules
	 * @return An instance of List<MinifiedModule>
	 */
	public List<MinifiedModule> getAllowedModules()
	{
		return  this.allowedModules;

	}

	/**
	 * The method to set the value to allowedModules
	 * @param allowedModules An instance of List<MinifiedModule>
	 */
	public void setAllowedModules(List<MinifiedModule> allowedModules)
	{
		 this.allowedModules = allowedModules;

		 this.keyModified.put("allowed_modules", 1);

	}

	/**
	 * The method to get the value of hipaaComplianceEnabled
	 * @return A Boolean representing the hipaaComplianceEnabled
	 */
	public Boolean getHipaaComplianceEnabled()
	{
		return  this.hipaaComplianceEnabled;

	}

	/**
	 * The method to set the value to hipaaComplianceEnabled
	 * @param hipaaComplianceEnabled A Boolean representing the hipaaComplianceEnabled
	 */
	public void setHipaaComplianceEnabled(Boolean hipaaComplianceEnabled)
	{
		 this.hipaaComplianceEnabled = hipaaComplianceEnabled;

		 this.keyModified.put("hipaa_compliance_enabled", 1);

	}

	/**
	 * The method to get the value of hipaaCompliance
	 * @return An instance of HipaaCompliance
	 */
	public HipaaCompliance getHipaaCompliance()
	{
		return  this.hipaaCompliance;

	}

	/**
	 * The method to set the value to hipaaCompliance
	 * @param hipaaCompliance An instance of HipaaCompliance
	 */
	public void setHipaaCompliance(HipaaCompliance hipaaCompliance)
	{
		 this.hipaaCompliance = hipaaCompliance;

		 this.keyModified.put("hipaa_compliance", 1);

	}

	/**
	 * The method to get the value of associatedModule
	 * @return An instance of MinifiedModule
	 */
	public MinifiedModule getAssociatedModule()
	{
		return  this.associatedModule;

	}

	/**
	 * The method to set the value to associatedModule
	 * @param associatedModule An instance of MinifiedModule
	 */
	public void setAssociatedModule(MinifiedModule associatedModule)
	{
		 this.associatedModule = associatedModule;

		 this.keyModified.put("associated_module", 1);

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
	 * The method to get the value of operationType
	 * @return An instance of OperationType
	 */
	public OperationType getOperationType()
	{
		return  this.operationType;

	}

	/**
	 * The method to set the value to operationType
	 * @param operationType An instance of OperationType
	 */
	public void setOperationType(OperationType operationType)
	{
		 this.operationType = operationType;

		 this.keyModified.put("operation_type", 1);

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
	 * The method to get the value of sequenceNumber
	 * @return An Integer representing the sequenceNumber
	 */
	public Integer getSequenceNumber()
	{
		return  this.sequenceNumber;

	}

	/**
	 * The method to set the value to sequenceNumber
	 * @param sequenceNumber An Integer representing the sequenceNumber
	 */
	public void setSequenceNumber(Integer sequenceNumber)
	{
		 this.sequenceNumber = sequenceNumber;

		 this.keyModified.put("sequence_number", 1);

	}

	/**
	 * The method to get the value of defaultValue
	 * @return A String representing the defaultValue
	 */
	public String getDefaultValue()
	{
		return  this.defaultValue;

	}

	/**
	 * The method to set the value to defaultValue
	 * @param defaultValue A String representing the defaultValue
	 */
	public void setDefaultValue(String defaultValue)
	{
		 this.defaultValue = defaultValue;

		 this.keyModified.put("default_value", 1);

	}

	/**
	 * The method to get the value of virtualField
	 * @return A Boolean representing the virtualField
	 */
	public Boolean getVirtualField()
	{
		return  this.virtualField;

	}

	/**
	 * The method to set the value to virtualField
	 * @param virtualField A Boolean representing the virtualField
	 */
	public void setVirtualField(Boolean virtualField)
	{
		 this.virtualField = virtualField;

		 this.keyModified.put("virtual_field", 1);

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
	 * The method to get the value of customizableProperties
	 * @return An instance of List<String>
	 */
	public List<String> getCustomizableProperties()
	{
		return  this.customizableProperties;

	}

	/**
	 * The method to set the value to customizableProperties
	 * @param customizableProperties An instance of List<String>
	 */
	public void setCustomizableProperties(List<String> customizableProperties)
	{
		 this.customizableProperties = customizableProperties;

		 this.keyModified.put("customizable_properties", 1);

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
	 * The method to get the value of businesscardSupported
	 * @return A Boolean representing the businesscardSupported
	 */
	public Boolean getBusinesscardSupported()
	{
		return  this.businesscardSupported;

	}

	/**
	 * The method to set the value to businesscardSupported
	 * @param businesscardSupported A Boolean representing the businesscardSupported
	 */
	public void setBusinesscardSupported(Boolean businesscardSupported)
	{
		 this.businesscardSupported = businesscardSupported;

		 this.keyModified.put("businesscard_supported", 1);

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
	 * The method to get the value of availableInUserLayout
	 * @return A Boolean representing the availableInUserLayout
	 */
	public Boolean getAvailableInUserLayout()
	{
		return  this.availableInUserLayout;

	}

	/**
	 * The method to set the value to availableInUserLayout
	 * @param availableInUserLayout A Boolean representing the availableInUserLayout
	 */
	public void setAvailableInUserLayout(Boolean availableInUserLayout)
	{
		 this.availableInUserLayout = availableInUserLayout;

		 this.keyModified.put("available_in_user_layout", 1);

	}

	/**
	 * The method to get the value of displayField
	 * @return A Boolean representing the displayField
	 */
	public Boolean getDisplayField()
	{
		return  this.displayField;

	}

	/**
	 * The method to set the value to displayField
	 * @param displayField A Boolean representing the displayField
	 */
	public void setDisplayField(Boolean displayField)
	{
		 this.displayField = displayField;

		 this.keyModified.put("display_field", 1);

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
	 * The method to get the value of layoutAssociations
	 * @return An instance of List<LayoutAssociation>
	 */
	public List<LayoutAssociation> getLayoutAssociations()
	{
		return  this.layoutAssociations;

	}

	/**
	 * The method to set the value to layoutAssociations
	 * @param layoutAssociations An instance of List<LayoutAssociation>
	 */
	public void setLayoutAssociations(List<LayoutAssociation> layoutAssociations)
	{
		 this.layoutAssociations = layoutAssociations;

		 this.keyModified.put("layout_associations", 1);

	}

	/**
	 * The method to get the value of separator
	 * @return A Boolean representing the separator
	 */
	public Boolean getSeparator()
	{
		return  this.separator;

	}

	/**
	 * The method to set the value to separator
	 * @param separator A Boolean representing the separator
	 */
	public void setSeparator(Boolean separator)
	{
		 this.separator = separator;

		 this.keyModified.put("separator", 1);

	}

	/**
	 * The method to get the value of searchable
	 * @return A Boolean representing the searchable
	 */
	public Boolean getSearchable()
	{
		return  this.searchable;

	}

	/**
	 * The method to set the value to searchable
	 * @param searchable A Boolean representing the searchable
	 */
	public void setSearchable(Boolean searchable)
	{
		 this.searchable = searchable;

		 this.keyModified.put("searchable", 1);

	}

	/**
	 * The method to get the value of enableColourCode
	 * @return A Boolean representing the enableColourCode
	 */
	public Boolean getEnableColourCode()
	{
		return  this.enableColourCode;

	}

	/**
	 * The method to set the value to enableColourCode
	 * @param enableColourCode A Boolean representing the enableColourCode
	 */
	public void setEnableColourCode(Boolean enableColourCode)
	{
		 this.enableColourCode = enableColourCode;

		 this.keyModified.put("enable_colour_code", 1);

	}

	/**
	 * The method to get the value of massUpdate
	 * @return A Boolean representing the massUpdate
	 */
	public Boolean getMassUpdate()
	{
		return  this.massUpdate;

	}

	/**
	 * The method to set the value to massUpdate
	 * @param massUpdate A Boolean representing the massUpdate
	 */
	public void setMassUpdate(Boolean massUpdate)
	{
		 this.massUpdate = massUpdate;

		 this.keyModified.put("mass_update", 1);

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
	 * The method to get the value of displayType
	 * @return An Integer representing the displayType
	 */
	public Integer getDisplayType()
	{
		return  this.displayType;

	}

	/**
	 * The method to set the value to displayType
	 * @param displayType An Integer representing the displayType
	 */
	public void setDisplayType(Integer displayType)
	{
		 this.displayType = displayType;

		 this.keyModified.put("display_type", 1);

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
	 * The method to get the value of colourCodeEnabledBySystem
	 * @return A Boolean representing the colourCodeEnabledBySystem
	 */
	public Boolean getColourCodeEnabledBySystem()
	{
		return  this.colourCodeEnabledBySystem;

	}

	/**
	 * The method to set the value to colourCodeEnabledBySystem
	 * @param colourCodeEnabledBySystem A Boolean representing the colourCodeEnabledBySystem
	 */
	public void setColourCodeEnabledBySystem(Boolean colourCodeEnabledBySystem)
	{
		 this.colourCodeEnabledBySystem = colourCodeEnabledBySystem;

		 this.keyModified.put("colour_code_enabled_by_system", 1);

	}

	/**
	 * The method to get the value of quickSequenceNumber
	 * @return A String representing the quickSequenceNumber
	 */
	public String getQuickSequenceNumber()
	{
		return  this.quickSequenceNumber;

	}

	/**
	 * The method to set the value to quickSequenceNumber
	 * @param quickSequenceNumber A String representing the quickSequenceNumber
	 */
	public void setQuickSequenceNumber(String quickSequenceNumber)
	{
		 this.quickSequenceNumber = quickSequenceNumber;

		 this.keyModified.put("quick_sequence_number", 1);

	}

	/**
	 * The method to get the value of emailParser
	 * @return An instance of EmailParser
	 */
	public EmailParser getEmailParser()
	{
		return  this.emailParser;

	}

	/**
	 * The method to set the value to emailParser
	 * @param emailParser An instance of EmailParser
	 */
	public void setEmailParser(EmailParser emailParser)
	{
		 this.emailParser = emailParser;

		 this.keyModified.put("email_parser", 1);

	}

	/**
	 * The method to get the value of rollupSummary
	 * @return An instance of RollupSummary
	 */
	public RollupSummary getRollupSummary()
	{
		return  this.rollupSummary;

	}

	/**
	 * The method to set the value to rollupSummary
	 * @param rollupSummary An instance of RollupSummary
	 */
	public void setRollupSummary(RollupSummary rollupSummary)
	{
		 this.rollupSummary = rollupSummary;

		 this.keyModified.put("rollup_summary", 1);

	}

	/**
	 * The method to get the value of referFromField
	 * @return An instance of ReferFromField
	 */
	public ReferFromField getReferFromField()
	{
		return  this.referFromField;

	}

	/**
	 * The method to set the value to referFromField
	 * @param referFromField An instance of ReferFromField
	 */
	public void setReferFromField(ReferFromField referFromField)
	{
		 this.referFromField = referFromField;

		 this.keyModified.put("refer_from_field", 1);

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
	 * The method to get the value of modifiedTime
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getModifiedTime()
	{
		return  this.modifiedTime;

	}

	/**
	 * The method to set the value to modifiedTime
	 * @param modifiedTime An instance of OffsetDateTime
	 */
	public void setModifiedTime(OffsetDateTime modifiedTime)
	{
		 this.modifiedTime = modifiedTime;

		 this.keyModified.put("modified_time", 1);

	}

	/**
	 * The method to get the value of showType
	 * @return An Integer representing the showType
	 */
	public Integer getShowType()
	{
		return  this.showType;

	}

	/**
	 * The method to set the value to showType
	 * @param showType An Integer representing the showType
	 */
	public void setShowType(Integer showType)
	{
		 this.showType = showType;

		 this.keyModified.put("show_type", 1);

	}

	/**
	 * The method to get the value of category
	 * @return An Integer representing the category
	 */
	public Integer getCategory()
	{
		return  this.category;

	}

	/**
	 * The method to set the value to category
	 * @param category An Integer representing the category
	 */
	public void setCategory(Integer category)
	{
		 this.category = category;

		 this.keyModified.put("category", 1);

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
	 * The method to get the value of subModule
	 * @return An instance of MinifiedModule
	 */
	public MinifiedModule getSubModule()
	{
		return  this.subModule;

	}

	/**
	 * The method to set the value to subModule
	 * @param subModule An instance of MinifiedModule
	 */
	public void setSubModule(MinifiedModule subModule)
	{
		 this.subModule = subModule;

		 this.keyModified.put("sub_module", 1);

	}

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
	 * The method to get the value of convertMapping
	 * @return An instance of ConvertMapping
	 */
	public ConvertMapping getConvertMapping()
	{
		return  this.convertMapping;

	}

	/**
	 * The method to set the value to convertMapping
	 * @param convertMapping An instance of ConvertMapping
	 */
	public void setConvertMapping(ConvertMapping convertMapping)
	{
		 this.convertMapping = convertMapping;

		 this.keyModified.put("convert_mapping", 1);

	}

	/**
	 * The method to get the value of autonumber
	 * @return An instance of AutoNumber
	 */
	public AutoNumber getAutonumber()
	{
		return  this.autonumber;

	}

	/**
	 * The method to set the value to autonumber
	 * @param autonumber An instance of AutoNumber
	 */
	public void setAutonumber(AutoNumber autonumber)
	{
		 this.autonumber = autonumber;

		 this.keyModified.put("autonumber", 1);

	}

	/**
	 * The method to get the value of autoNumber65
	 * @return An instance of AutoNumber
	 */
	public AutoNumber getAutoNumber65()
	{
		return  this.autoNumber65;

	}

	/**
	 * The method to set the value to autoNumber65
	 * @param autoNumber65 An instance of AutoNumber
	 */
	public void setAutoNumber65(AutoNumber autoNumber65)
	{
		 this.autoNumber65 = autoNumber65;

		 this.keyModified.put("auto_number", 1);

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
	 * The method to get the value of tooltip
	 * @return An instance of Tooltip
	 */
	public Tooltip getTooltip()
	{
		return  this.tooltip;

	}

	/**
	 * The method to set the value to tooltip
	 * @param tooltip An instance of Tooltip
	 */
	public void setTooltip(Tooltip tooltip)
	{
		 this.tooltip = tooltip;

		 this.keyModified.put("tooltip", 1);

	}

	/**
	 * The method to get the value of historyTracking
	 * @return An instance of HistoryTracking
	 */
	public HistoryTracking getHistoryTracking()
	{
		return  this.historyTracking;

	}

	/**
	 * The method to set the value to historyTracking
	 * @param historyTracking An instance of HistoryTracking
	 */
	public void setHistoryTracking(HistoryTracking historyTracking)
	{
		 this.historyTracking = historyTracking;

		 this.keyModified.put("history_tracking", 1);

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
	 * The method to get the value of additionalColumn
	 * @return A String representing the additionalColumn
	 */
	public String getAdditionalColumn()
	{
		return  this.additionalColumn;

	}

	/**
	 * The method to set the value to additionalColumn
	 * @param additionalColumn A String representing the additionalColumn
	 */
	public void setAdditionalColumn(String additionalColumn)
	{
		 this.additionalColumn = additionalColumn;

		 this.keyModified.put("additional_column", 1);

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
	 * The method to get the value of globalPicklist
	 * @return An instance of Picklist
	 */
	public Picklist getGlobalPicklist()
	{
		return  this.globalPicklist;

	}

	/**
	 * The method to set the value to globalPicklist
	 * @param globalPicklist An instance of Picklist
	 */
	public void setGlobalPicklist(Picklist globalPicklist)
	{
		 this.globalPicklist = globalPicklist;

		 this.keyModified.put("global_picklist", 1);

	}

	/**
	 * The method to get the value of updateExistingRecords
	 * @return A Boolean representing the updateExistingRecords
	 */
	public Boolean getUpdateExistingRecords()
	{
		return  this.updateExistingRecords;

	}

	/**
	 * The method to set the value to updateExistingRecords
	 * @param updateExistingRecords A Boolean representing the updateExistingRecords
	 */
	public void setUpdateExistingRecords(Boolean updateExistingRecords)
	{
		 this.updateExistingRecords = updateExistingRecords;

		 this.keyModified.put("_update_existing_records", 1);

	}

	/**
	 * The method to get the value of numberSeparator
	 * @return A Boolean representing the numberSeparator
	 */
	public Boolean getNumberSeparator()
	{
		return  this.numberSeparator;

	}

	/**
	 * The method to set the value to numberSeparator
	 * @param numberSeparator A Boolean representing the numberSeparator
	 */
	public void setNumberSeparator(Boolean numberSeparator)
	{
		 this.numberSeparator = numberSeparator;

		 this.keyModified.put("number_separator", 1);

	}

	/**
	 * The method to get the value of textarea
	 * @return An instance of Textarea
	 */
	public Textarea getTextarea()
	{
		return  this.textarea;

	}

	/**
	 * The method to set the value to textarea
	 * @param textarea An instance of Textarea
	 */
	public void setTextarea(Textarea textarea)
	{
		 this.textarea = textarea;

		 this.keyModified.put("textarea", 1);

	}

	/**
	 * The method to get the value of staticField
	 * @return A Boolean representing the staticField
	 */
	public Boolean getStaticField()
	{
		return  this.staticField;

	}

	/**
	 * The method to set the value to staticField
	 * @param staticField A Boolean representing the staticField
	 */
	public void setStaticField(Boolean staticField)
	{
		 this.staticField = staticField;

		 this.keyModified.put("static_field", 1);

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