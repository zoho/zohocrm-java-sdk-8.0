package com.zoho.crm.api.modules;

import com.zoho.crm.api.customviews.CustomViews;
import com.zoho.crm.api.fields.LayoutAssociation;
import com.zoho.crm.api.fields.MinifiedField;
import com.zoho.crm.api.profiles.MinifiedProfile;
import com.zoho.crm.api.relatedlists.RelatedList;
import com.zoho.crm.api.users.MinifiedUser;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;

public class Modules implements Model
{
	private Boolean hasMoreProfiles;

	private Boolean subMenuAvailable;

	private Boolean globalSearchSupported;

	private Boolean deletable;

	private String description;

	private Boolean creatable;

	private Boolean recycleBinOnDelete;

	private Boolean inventoryTemplateSupported;

	private OffsetDateTime modifiedTime;

	private String pluralLabel;

	private Boolean presenceSubMenu;

	private Boolean triggersSupported;

	private Long id;

	private Boolean chartView;

	private Boolean isblueprintsupported;

	private Integer visibility;

	private Boolean visible;

	private Boolean convertable;

	private Boolean editable;

	private Boolean emailtemplateSupport;

	private Boolean emailParserSupported;

	private Boolean filterSupported;

	private Boolean showAsTab;

	private String webLink;

	private Integer sequenceNumber;

	private String singularLabel;

	private Boolean viewable;

	private Boolean apiSupported;

	private String apiName;

	private Boolean quickCreate;

	private Choice<String> generatedType;

	private Boolean feedsRequired;

	private Boolean scoringSupported;

	private Boolean webformSupported;

	private Territory territory;

	private List<Argument> arguments;

	private String moduleName;

	private Boolean chartViewSupported;

	private Integer profileCount;

	private Integer businessCardFieldLimit;

	private Boolean trackCurrentData;

	private MinifiedUser modifiedBy;

	private List<MinifiedProfile> profiles;

	private MinifiedModule parentModule;

	private Choice<String> activityBadge;

	private List<String> fieldStates;

	private List<String> businessCardFields;

	private Integer perPage;

	private List<String> properties;

	private List<String> onDemandProperties;

	private List<String> searchLayoutFields;

	private Boolean kanbanViewSupported;

	private LookupFieldProperties lookupFieldProperties;

	private Boolean kanbanView;

	private List<RelatedList> relatedLists;

	private Boolean filterStatus;

	private RelatedListProperties relatedListProperties;

	private Object displayField;

	private List<Object> layouts;

	private List<ModuleFields> fields;

	private CustomViews customView;

	private Boolean ziaView;

	private List<MinifiedField> defaultMappingFields;

	private String status;

	private StaticSubformProperties staticSubformProperties;

	private List<LayoutAssociation> layoutAssociations;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of hasMoreProfiles
	 * @return A Boolean representing the hasMoreProfiles
	 */
	public Boolean getHasMoreProfiles()
	{
		return  this.hasMoreProfiles;

	}

	/**
	 * The method to set the value to hasMoreProfiles
	 * @param hasMoreProfiles A Boolean representing the hasMoreProfiles
	 */
	public void setHasMoreProfiles(Boolean hasMoreProfiles)
	{
		 this.hasMoreProfiles = hasMoreProfiles;

		 this.keyModified.put("has_more_profiles", 1);

	}

	/**
	 * The method to get the value of subMenuAvailable
	 * @return A Boolean representing the subMenuAvailable
	 */
	public Boolean getSubMenuAvailable()
	{
		return  this.subMenuAvailable;

	}

	/**
	 * The method to set the value to subMenuAvailable
	 * @param subMenuAvailable A Boolean representing the subMenuAvailable
	 */
	public void setSubMenuAvailable(Boolean subMenuAvailable)
	{
		 this.subMenuAvailable = subMenuAvailable;

		 this.keyModified.put("sub_menu_available", 1);

	}

	/**
	 * The method to get the value of globalSearchSupported
	 * @return A Boolean representing the globalSearchSupported
	 */
	public Boolean getGlobalSearchSupported()
	{
		return  this.globalSearchSupported;

	}

	/**
	 * The method to set the value to globalSearchSupported
	 * @param globalSearchSupported A Boolean representing the globalSearchSupported
	 */
	public void setGlobalSearchSupported(Boolean globalSearchSupported)
	{
		 this.globalSearchSupported = globalSearchSupported;

		 this.keyModified.put("global_search_supported", 1);

	}

	/**
	 * The method to get the value of deletable
	 * @return A Boolean representing the deletable
	 */
	public Boolean getDeletable()
	{
		return  this.deletable;

	}

	/**
	 * The method to set the value to deletable
	 * @param deletable A Boolean representing the deletable
	 */
	public void setDeletable(Boolean deletable)
	{
		 this.deletable = deletable;

		 this.keyModified.put("deletable", 1);

	}

	/**
	 * The method to get the value of description
	 * @return A String representing the description
	 */
	public String getDescription()
	{
		return  this.description;

	}

	/**
	 * The method to set the value to description
	 * @param description A String representing the description
	 */
	public void setDescription(String description)
	{
		 this.description = description;

		 this.keyModified.put("description", 1);

	}

	/**
	 * The method to get the value of creatable
	 * @return A Boolean representing the creatable
	 */
	public Boolean getCreatable()
	{
		return  this.creatable;

	}

	/**
	 * The method to set the value to creatable
	 * @param creatable A Boolean representing the creatable
	 */
	public void setCreatable(Boolean creatable)
	{
		 this.creatable = creatable;

		 this.keyModified.put("creatable", 1);

	}

	/**
	 * The method to get the value of recycleBinOnDelete
	 * @return A Boolean representing the recycleBinOnDelete
	 */
	public Boolean getRecycleBinOnDelete()
	{
		return  this.recycleBinOnDelete;

	}

	/**
	 * The method to set the value to recycleBinOnDelete
	 * @param recycleBinOnDelete A Boolean representing the recycleBinOnDelete
	 */
	public void setRecycleBinOnDelete(Boolean recycleBinOnDelete)
	{
		 this.recycleBinOnDelete = recycleBinOnDelete;

		 this.keyModified.put("recycle_bin_on_delete", 1);

	}

	/**
	 * The method to get the value of inventoryTemplateSupported
	 * @return A Boolean representing the inventoryTemplateSupported
	 */
	public Boolean getInventoryTemplateSupported()
	{
		return  this.inventoryTemplateSupported;

	}

	/**
	 * The method to set the value to inventoryTemplateSupported
	 * @param inventoryTemplateSupported A Boolean representing the inventoryTemplateSupported
	 */
	public void setInventoryTemplateSupported(Boolean inventoryTemplateSupported)
	{
		 this.inventoryTemplateSupported = inventoryTemplateSupported;

		 this.keyModified.put("inventory_template_supported", 1);

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
	 * The method to get the value of pluralLabel
	 * @return A String representing the pluralLabel
	 */
	public String getPluralLabel()
	{
		return  this.pluralLabel;

	}

	/**
	 * The method to set the value to pluralLabel
	 * @param pluralLabel A String representing the pluralLabel
	 */
	public void setPluralLabel(String pluralLabel)
	{
		 this.pluralLabel = pluralLabel;

		 this.keyModified.put("plural_label", 1);

	}

	/**
	 * The method to get the value of presenceSubMenu
	 * @return A Boolean representing the presenceSubMenu
	 */
	public Boolean getPresenceSubMenu()
	{
		return  this.presenceSubMenu;

	}

	/**
	 * The method to set the value to presenceSubMenu
	 * @param presenceSubMenu A Boolean representing the presenceSubMenu
	 */
	public void setPresenceSubMenu(Boolean presenceSubMenu)
	{
		 this.presenceSubMenu = presenceSubMenu;

		 this.keyModified.put("presence_sub_menu", 1);

	}

	/**
	 * The method to get the value of triggersSupported
	 * @return A Boolean representing the triggersSupported
	 */
	public Boolean getTriggersSupported()
	{
		return  this.triggersSupported;

	}

	/**
	 * The method to set the value to triggersSupported
	 * @param triggersSupported A Boolean representing the triggersSupported
	 */
	public void setTriggersSupported(Boolean triggersSupported)
	{
		 this.triggersSupported = triggersSupported;

		 this.keyModified.put("triggers_supported", 1);

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
	 * The method to get the value of chartView
	 * @return A Boolean representing the chartView
	 */
	public Boolean getChartView()
	{
		return  this.chartView;

	}

	/**
	 * The method to set the value to chartView
	 * @param chartView A Boolean representing the chartView
	 */
	public void setChartView(Boolean chartView)
	{
		 this.chartView = chartView;

		 this.keyModified.put("chart_view", 1);

	}

	/**
	 * The method to get the value of isblueprintsupported
	 * @return A Boolean representing the isblueprintsupported
	 */
	public Boolean getIsblueprintsupported()
	{
		return  this.isblueprintsupported;

	}

	/**
	 * The method to set the value to isblueprintsupported
	 * @param isblueprintsupported A Boolean representing the isblueprintsupported
	 */
	public void setIsblueprintsupported(Boolean isblueprintsupported)
	{
		 this.isblueprintsupported = isblueprintsupported;

		 this.keyModified.put("isBlueprintSupported", 1);

	}

	/**
	 * The method to get the value of visibility
	 * @return An Integer representing the visibility
	 */
	public Integer getVisibility()
	{
		return  this.visibility;

	}

	/**
	 * The method to set the value to visibility
	 * @param visibility An Integer representing the visibility
	 */
	public void setVisibility(Integer visibility)
	{
		 this.visibility = visibility;

		 this.keyModified.put("visibility", 1);

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
	 * The method to get the value of convertable
	 * @return A Boolean representing the convertable
	 */
	public Boolean getConvertable()
	{
		return  this.convertable;

	}

	/**
	 * The method to set the value to convertable
	 * @param convertable A Boolean representing the convertable
	 */
	public void setConvertable(Boolean convertable)
	{
		 this.convertable = convertable;

		 this.keyModified.put("convertable", 1);

	}

	/**
	 * The method to get the value of editable
	 * @return A Boolean representing the editable
	 */
	public Boolean getEditable()
	{
		return  this.editable;

	}

	/**
	 * The method to set the value to editable
	 * @param editable A Boolean representing the editable
	 */
	public void setEditable(Boolean editable)
	{
		 this.editable = editable;

		 this.keyModified.put("editable", 1);

	}

	/**
	 * The method to get the value of emailtemplateSupport
	 * @return A Boolean representing the emailtemplateSupport
	 */
	public Boolean getEmailtemplateSupport()
	{
		return  this.emailtemplateSupport;

	}

	/**
	 * The method to set the value to emailtemplateSupport
	 * @param emailtemplateSupport A Boolean representing the emailtemplateSupport
	 */
	public void setEmailtemplateSupport(Boolean emailtemplateSupport)
	{
		 this.emailtemplateSupport = emailtemplateSupport;

		 this.keyModified.put("emailTemplate_support", 1);

	}

	/**
	 * The method to get the value of emailParserSupported
	 * @return A Boolean representing the emailParserSupported
	 */
	public Boolean getEmailParserSupported()
	{
		return  this.emailParserSupported;

	}

	/**
	 * The method to set the value to emailParserSupported
	 * @param emailParserSupported A Boolean representing the emailParserSupported
	 */
	public void setEmailParserSupported(Boolean emailParserSupported)
	{
		 this.emailParserSupported = emailParserSupported;

		 this.keyModified.put("email_parser_supported", 1);

	}

	/**
	 * The method to get the value of filterSupported
	 * @return A Boolean representing the filterSupported
	 */
	public Boolean getFilterSupported()
	{
		return  this.filterSupported;

	}

	/**
	 * The method to set the value to filterSupported
	 * @param filterSupported A Boolean representing the filterSupported
	 */
	public void setFilterSupported(Boolean filterSupported)
	{
		 this.filterSupported = filterSupported;

		 this.keyModified.put("filter_supported", 1);

	}

	/**
	 * The method to get the value of showAsTab
	 * @return A Boolean representing the showAsTab
	 */
	public Boolean getShowAsTab()
	{
		return  this.showAsTab;

	}

	/**
	 * The method to set the value to showAsTab
	 * @param showAsTab A Boolean representing the showAsTab
	 */
	public void setShowAsTab(Boolean showAsTab)
	{
		 this.showAsTab = showAsTab;

		 this.keyModified.put("show_as_tab", 1);

	}

	/**
	 * The method to get the value of webLink
	 * @return A String representing the webLink
	 */
	public String getWebLink()
	{
		return  this.webLink;

	}

	/**
	 * The method to set the value to webLink
	 * @param webLink A String representing the webLink
	 */
	public void setWebLink(String webLink)
	{
		 this.webLink = webLink;

		 this.keyModified.put("web_link", 1);

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
	 * The method to get the value of singularLabel
	 * @return A String representing the singularLabel
	 */
	public String getSingularLabel()
	{
		return  this.singularLabel;

	}

	/**
	 * The method to set the value to singularLabel
	 * @param singularLabel A String representing the singularLabel
	 */
	public void setSingularLabel(String singularLabel)
	{
		 this.singularLabel = singularLabel;

		 this.keyModified.put("singular_label", 1);

	}

	/**
	 * The method to get the value of viewable
	 * @return A Boolean representing the viewable
	 */
	public Boolean getViewable()
	{
		return  this.viewable;

	}

	/**
	 * The method to set the value to viewable
	 * @param viewable A Boolean representing the viewable
	 */
	public void setViewable(Boolean viewable)
	{
		 this.viewable = viewable;

		 this.keyModified.put("viewable", 1);

	}

	/**
	 * The method to get the value of apiSupported
	 * @return A Boolean representing the apiSupported
	 */
	public Boolean getAPISupported()
	{
		return  this.apiSupported;

	}

	/**
	 * The method to set the value to apiSupported
	 * @param apiSupported A Boolean representing the apiSupported
	 */
	public void setAPISupported(Boolean apiSupported)
	{
		 this.apiSupported = apiSupported;

		 this.keyModified.put("api_supported", 1);

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
	 * The method to get the value of quickCreate
	 * @return A Boolean representing the quickCreate
	 */
	public Boolean getQuickCreate()
	{
		return  this.quickCreate;

	}

	/**
	 * The method to set the value to quickCreate
	 * @param quickCreate A Boolean representing the quickCreate
	 */
	public void setQuickCreate(Boolean quickCreate)
	{
		 this.quickCreate = quickCreate;

		 this.keyModified.put("quick_create", 1);

	}

	/**
	 * The method to get the value of generatedType
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getGeneratedType()
	{
		return  this.generatedType;

	}

	/**
	 * The method to set the value to generatedType
	 * @param generatedType An instance of Choice<String>
	 */
	public void setGeneratedType(Choice<String> generatedType)
	{
		 this.generatedType = generatedType;

		 this.keyModified.put("generated_type", 1);

	}

	/**
	 * The method to get the value of feedsRequired
	 * @return A Boolean representing the feedsRequired
	 */
	public Boolean getFeedsRequired()
	{
		return  this.feedsRequired;

	}

	/**
	 * The method to set the value to feedsRequired
	 * @param feedsRequired A Boolean representing the feedsRequired
	 */
	public void setFeedsRequired(Boolean feedsRequired)
	{
		 this.feedsRequired = feedsRequired;

		 this.keyModified.put("feeds_required", 1);

	}

	/**
	 * The method to get the value of scoringSupported
	 * @return A Boolean representing the scoringSupported
	 */
	public Boolean getScoringSupported()
	{
		return  this.scoringSupported;

	}

	/**
	 * The method to set the value to scoringSupported
	 * @param scoringSupported A Boolean representing the scoringSupported
	 */
	public void setScoringSupported(Boolean scoringSupported)
	{
		 this.scoringSupported = scoringSupported;

		 this.keyModified.put("scoring_supported", 1);

	}

	/**
	 * The method to get the value of webformSupported
	 * @return A Boolean representing the webformSupported
	 */
	public Boolean getWebformSupported()
	{
		return  this.webformSupported;

	}

	/**
	 * The method to set the value to webformSupported
	 * @param webformSupported A Boolean representing the webformSupported
	 */
	public void setWebformSupported(Boolean webformSupported)
	{
		 this.webformSupported = webformSupported;

		 this.keyModified.put("webform_supported", 1);

	}

	/**
	 * The method to get the value of territory
	 * @return An instance of Territory
	 */
	public Territory getTerritory()
	{
		return  this.territory;

	}

	/**
	 * The method to set the value to territory
	 * @param territory An instance of Territory
	 */
	public void setTerritory(Territory territory)
	{
		 this.territory = territory;

		 this.keyModified.put("territory", 1);

	}

	/**
	 * The method to get the value of arguments
	 * @return An instance of List<Argument>
	 */
	public List<Argument> getArguments()
	{
		return  this.arguments;

	}

	/**
	 * The method to set the value to arguments
	 * @param arguments An instance of List<Argument>
	 */
	public void setArguments(List<Argument> arguments)
	{
		 this.arguments = arguments;

		 this.keyModified.put("arguments", 1);

	}

	/**
	 * The method to get the value of moduleName
	 * @return A String representing the moduleName
	 */
	public String getModuleName()
	{
		return  this.moduleName;

	}

	/**
	 * The method to set the value to moduleName
	 * @param moduleName A String representing the moduleName
	 */
	public void setModuleName(String moduleName)
	{
		 this.moduleName = moduleName;

		 this.keyModified.put("module_name", 1);

	}

	/**
	 * The method to get the value of chartViewSupported
	 * @return A Boolean representing the chartViewSupported
	 */
	public Boolean getChartViewSupported()
	{
		return  this.chartViewSupported;

	}

	/**
	 * The method to set the value to chartViewSupported
	 * @param chartViewSupported A Boolean representing the chartViewSupported
	 */
	public void setChartViewSupported(Boolean chartViewSupported)
	{
		 this.chartViewSupported = chartViewSupported;

		 this.keyModified.put("chart_view_supported", 1);

	}

	/**
	 * The method to get the value of profileCount
	 * @return An Integer representing the profileCount
	 */
	public Integer getProfileCount()
	{
		return  this.profileCount;

	}

	/**
	 * The method to set the value to profileCount
	 * @param profileCount An Integer representing the profileCount
	 */
	public void setProfileCount(Integer profileCount)
	{
		 this.profileCount = profileCount;

		 this.keyModified.put("profile_count", 1);

	}

	/**
	 * The method to get the value of businessCardFieldLimit
	 * @return An Integer representing the businessCardFieldLimit
	 */
	public Integer getBusinessCardFieldLimit()
	{
		return  this.businessCardFieldLimit;

	}

	/**
	 * The method to set the value to businessCardFieldLimit
	 * @param businessCardFieldLimit An Integer representing the businessCardFieldLimit
	 */
	public void setBusinessCardFieldLimit(Integer businessCardFieldLimit)
	{
		 this.businessCardFieldLimit = businessCardFieldLimit;

		 this.keyModified.put("business_card_field_limit", 1);

	}

	/**
	 * The method to get the value of trackCurrentData
	 * @return A Boolean representing the trackCurrentData
	 */
	public Boolean getTrackCurrentData()
	{
		return  this.trackCurrentData;

	}

	/**
	 * The method to set the value to trackCurrentData
	 * @param trackCurrentData A Boolean representing the trackCurrentData
	 */
	public void setTrackCurrentData(Boolean trackCurrentData)
	{
		 this.trackCurrentData = trackCurrentData;

		 this.keyModified.put("track_current_data", 1);

	}

	/**
	 * The method to get the value of modifiedBy
	 * @return An instance of MinifiedUser
	 */
	public MinifiedUser getModifiedBy()
	{
		return  this.modifiedBy;

	}

	/**
	 * The method to set the value to modifiedBy
	 * @param modifiedBy An instance of MinifiedUser
	 */
	public void setModifiedBy(MinifiedUser modifiedBy)
	{
		 this.modifiedBy = modifiedBy;

		 this.keyModified.put("modified_by", 1);

	}

	/**
	 * The method to get the value of profiles
	 * @return An instance of List<MinifiedProfile>
	 */
	public List<MinifiedProfile> getProfiles()
	{
		return  this.profiles;

	}

	/**
	 * The method to set the value to profiles
	 * @param profiles An instance of List<MinifiedProfile>
	 */
	public void setProfiles(List<MinifiedProfile> profiles)
	{
		 this.profiles = profiles;

		 this.keyModified.put("profiles", 1);

	}

	/**
	 * The method to get the value of parentModule
	 * @return An instance of MinifiedModule
	 */
	public MinifiedModule getParentModule()
	{
		return  this.parentModule;

	}

	/**
	 * The method to set the value to parentModule
	 * @param parentModule An instance of MinifiedModule
	 */
	public void setParentModule(MinifiedModule parentModule)
	{
		 this.parentModule = parentModule;

		 this.keyModified.put("parent_module", 1);

	}

	/**
	 * The method to get the value of activityBadge
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getActivityBadge()
	{
		return  this.activityBadge;

	}

	/**
	 * The method to set the value to activityBadge
	 * @param activityBadge An instance of Choice<String>
	 */
	public void setActivityBadge(Choice<String> activityBadge)
	{
		 this.activityBadge = activityBadge;

		 this.keyModified.put("activity_badge", 1);

	}

	/**
	 * The method to get the value of fieldStates
	 * @return An instance of List<String>
	 */
	public List<String> getFieldStates()
	{
		return  this.fieldStates;

	}

	/**
	 * The method to set the value to fieldStates
	 * @param fieldStates An instance of List<String>
	 */
	public void setFieldStates(List<String> fieldStates)
	{
		 this.fieldStates = fieldStates;

		 this.keyModified.put("$field_states", 1);

	}

	/**
	 * The method to get the value of businessCardFields
	 * @return An instance of List<String>
	 */
	public List<String> getBusinessCardFields()
	{
		return  this.businessCardFields;

	}

	/**
	 * The method to set the value to businessCardFields
	 * @param businessCardFields An instance of List<String>
	 */
	public void setBusinessCardFields(List<String> businessCardFields)
	{
		 this.businessCardFields = businessCardFields;

		 this.keyModified.put("business_card_fields", 1);

	}

	/**
	 * The method to get the value of perPage
	 * @return An Integer representing the perPage
	 */
	public Integer getPerPage()
	{
		return  this.perPage;

	}

	/**
	 * The method to set the value to perPage
	 * @param perPage An Integer representing the perPage
	 */
	public void setPerPage(Integer perPage)
	{
		 this.perPage = perPage;

		 this.keyModified.put("per_page", 1);

	}

	/**
	 * The method to get the value of properties
	 * @return An instance of List<String>
	 */
	public List<String> getProperties()
	{
		return  this.properties;

	}

	/**
	 * The method to set the value to properties
	 * @param properties An instance of List<String>
	 */
	public void setProperties(List<String> properties)
	{
		 this.properties = properties;

		 this.keyModified.put("$properties", 1);

	}

	/**
	 * The method to get the value of onDemandProperties
	 * @return An instance of List<String>
	 */
	public List<String> getOnDemandProperties()
	{
		return  this.onDemandProperties;

	}

	/**
	 * The method to set the value to onDemandProperties
	 * @param onDemandProperties An instance of List<String>
	 */
	public void setOnDemandProperties(List<String> onDemandProperties)
	{
		 this.onDemandProperties = onDemandProperties;

		 this.keyModified.put("$on_demand_properties", 1);

	}

	/**
	 * The method to get the value of searchLayoutFields
	 * @return An instance of List<String>
	 */
	public List<String> getSearchLayoutFields()
	{
		return  this.searchLayoutFields;

	}

	/**
	 * The method to set the value to searchLayoutFields
	 * @param searchLayoutFields An instance of List<String>
	 */
	public void setSearchLayoutFields(List<String> searchLayoutFields)
	{
		 this.searchLayoutFields = searchLayoutFields;

		 this.keyModified.put("search_layout_fields", 1);

	}

	/**
	 * The method to get the value of kanbanViewSupported
	 * @return A Boolean representing the kanbanViewSupported
	 */
	public Boolean getKanbanViewSupported()
	{
		return  this.kanbanViewSupported;

	}

	/**
	 * The method to set the value to kanbanViewSupported
	 * @param kanbanViewSupported A Boolean representing the kanbanViewSupported
	 */
	public void setKanbanViewSupported(Boolean kanbanViewSupported)
	{
		 this.kanbanViewSupported = kanbanViewSupported;

		 this.keyModified.put("kanban_view_supported", 1);

	}

	/**
	 * The method to get the value of lookupFieldProperties
	 * @return An instance of LookupFieldProperties
	 */
	public LookupFieldProperties getLookupFieldProperties()
	{
		return  this.lookupFieldProperties;

	}

	/**
	 * The method to set the value to lookupFieldProperties
	 * @param lookupFieldProperties An instance of LookupFieldProperties
	 */
	public void setLookupFieldProperties(LookupFieldProperties lookupFieldProperties)
	{
		 this.lookupFieldProperties = lookupFieldProperties;

		 this.keyModified.put("lookup_field_properties", 1);

	}

	/**
	 * The method to get the value of kanbanView
	 * @return A Boolean representing the kanbanView
	 */
	public Boolean getKanbanView()
	{
		return  this.kanbanView;

	}

	/**
	 * The method to set the value to kanbanView
	 * @param kanbanView A Boolean representing the kanbanView
	 */
	public void setKanbanView(Boolean kanbanView)
	{
		 this.kanbanView = kanbanView;

		 this.keyModified.put("kanban_view", 1);

	}

	/**
	 * The method to get the value of relatedLists
	 * @return An instance of List<RelatedList>
	 */
	public List<RelatedList> getRelatedLists()
	{
		return  this.relatedLists;

	}

	/**
	 * The method to set the value to relatedLists
	 * @param relatedLists An instance of List<RelatedList>
	 */
	public void setRelatedLists(List<RelatedList> relatedLists)
	{
		 this.relatedLists = relatedLists;

		 this.keyModified.put("related_lists", 1);

	}

	/**
	 * The method to get the value of filterStatus
	 * @return A Boolean representing the filterStatus
	 */
	public Boolean getFilterStatus()
	{
		return  this.filterStatus;

	}

	/**
	 * The method to set the value to filterStatus
	 * @param filterStatus A Boolean representing the filterStatus
	 */
	public void setFilterStatus(Boolean filterStatus)
	{
		 this.filterStatus = filterStatus;

		 this.keyModified.put("filter_status", 1);

	}

	/**
	 * The method to get the value of relatedListProperties
	 * @return An instance of RelatedListProperties
	 */
	public RelatedListProperties getRelatedListProperties()
	{
		return  this.relatedListProperties;

	}

	/**
	 * The method to set the value to relatedListProperties
	 * @param relatedListProperties An instance of RelatedListProperties
	 */
	public void setRelatedListProperties(RelatedListProperties relatedListProperties)
	{
		 this.relatedListProperties = relatedListProperties;

		 this.keyModified.put("related_list_properties", 1);

	}

	/**
	 * The method to get the value of displayField
	 * @return An instance of Object
	 */
	public Object getDisplayField()
	{
		return  this.displayField;

	}

	/**
	 * The method to set the value to displayField
	 * @param displayField An instance of Object
	 */
	public void setDisplayField(Object displayField)
	{
		 this.displayField = displayField;

		 this.keyModified.put("display_field", 1);

	}

	/**
	 * The method to get the value of layouts
	 * @return An instance of List<Object>
	 */
	public List<Object> getLayouts()
	{
		return  this.layouts;

	}

	/**
	 * The method to set the value to layouts
	 * @param layouts An instance of List<Object>
	 */
	public void setLayouts(List<Object> layouts)
	{
		 this.layouts = layouts;

		 this.keyModified.put("layouts", 1);

	}

	/**
	 * The method to get the value of fields
	 * @return An instance of List<ModuleFields>
	 */
	public List<ModuleFields> getFields()
	{
		return  this.fields;

	}

	/**
	 * The method to set the value to fields
	 * @param fields An instance of List<ModuleFields>
	 */
	public void setFields(List<ModuleFields> fields)
	{
		 this.fields = fields;

		 this.keyModified.put("fields", 1);

	}

	/**
	 * The method to get the value of customView
	 * @return An instance of CustomViews
	 */
	public CustomViews getCustomView()
	{
		return  this.customView;

	}

	/**
	 * The method to set the value to customView
	 * @param customView An instance of CustomViews
	 */
	public void setCustomView(CustomViews customView)
	{
		 this.customView = customView;

		 this.keyModified.put("custom_view", 1);

	}

	/**
	 * The method to get the value of ziaView
	 * @return A Boolean representing the ziaView
	 */
	public Boolean getZiaView()
	{
		return  this.ziaView;

	}

	/**
	 * The method to set the value to ziaView
	 * @param ziaView A Boolean representing the ziaView
	 */
	public void setZiaView(Boolean ziaView)
	{
		 this.ziaView = ziaView;

		 this.keyModified.put("zia_view", 1);

	}

	/**
	 * The method to get the value of defaultMappingFields
	 * @return An instance of List<MinifiedField>
	 */
	public List<MinifiedField> getDefaultMappingFields()
	{
		return  this.defaultMappingFields;

	}

	/**
	 * The method to set the value to defaultMappingFields
	 * @param defaultMappingFields An instance of List<MinifiedField>
	 */
	public void setDefaultMappingFields(List<MinifiedField> defaultMappingFields)
	{
		 this.defaultMappingFields = defaultMappingFields;

		 this.keyModified.put("default_mapping_fields", 1);

	}

	/**
	 * The method to get the value of status
	 * @return A String representing the status
	 */
	public String getStatus()
	{
		return  this.status;

	}

	/**
	 * The method to set the value to status
	 * @param status A String representing the status
	 */
	public void setStatus(String status)
	{
		 this.status = status;

		 this.keyModified.put("status", 1);

	}

	/**
	 * The method to get the value of staticSubformProperties
	 * @return An instance of StaticSubformProperties
	 */
	public StaticSubformProperties getStaticSubformProperties()
	{
		return  this.staticSubformProperties;

	}

	/**
	 * The method to set the value to staticSubformProperties
	 * @param staticSubformProperties An instance of StaticSubformProperties
	 */
	public void setStaticSubformProperties(StaticSubformProperties staticSubformProperties)
	{
		 this.staticSubformProperties = staticSubformProperties;

		 this.keyModified.put("static_subform_properties", 1);

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