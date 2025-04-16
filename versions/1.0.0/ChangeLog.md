# Migrating from Zoho CRM JAVA SDK 7.0-v6.0.0 to 8.0-v1.0.0

1. [Attachments](#attachments)
   - [Get Attachments](#get-attachments)

2. [ConversionOptions](#conversionOptions)
   - [LeadConversionOptions](#leadconversionoptions)

3. [Fields](#fields)
   - [Get Fields](#get-fields)
   - [Update Field](#update-field)
   - [Update Fields](#update-fields)
   
4. [Layouts](#layouts)
   - [Get Layouts](#get-layouts)

5. [Notification](#notification)
   - [Disable Notification](#disable-notification)
   
6. [ZiaOrgEnrichment](#ziaOrgEnrichment)
    - [Create ZiaOrgEnrichment](#create-ziaorgenrichment)
    - [Get ZiaOrgEnrichment](#get-ziaorgenrichment)
    - [Get ZiaOrgEnrichments](#get-ziaorgenrichments)

7. [ZiaPeopleEnrichment](#ziaPeopleEnrichment)
    - [Create ZiaPeopleEnrichment](#create-ziapeopleenrichment)
    - [Get ZiaPeopleEnrichment](#get-ziapeopleenrichment)
    - [Get ZiaPeopleEnrichments](#get-ziapeopleenrichments)
   
8. [FromAddresses](#fromAddresses)
    - [Get EmailAddresses](#get-emailaddresses)

9. [EmailSharingDetails](#emailSharingDetails)
    - [Get EmailSharingDetails](#get-emailsharingdetails)

10. [Profile](#profile)
    - [Get Profiles](#get-profiles)


## Attachments

### Get Attachments

- Changes Note : Introduced recordStatusS, attachmentSourceS, fileIdS, fieldStates and ziaVisions fields in Attachment  

- JAVA SDK 7.0-v6.0.0

    ```java
    List<com.zoho.crm.api.attachments.Attachment> attachments = responseWrapper.getData();
    for (com.zoho.crm.api.attachments.Attachment attachment : attachments)
    {
        System.out.println("Attachment ID: " + attachment.getId());
    }
    ```
  
- JAVA SDK 8.0-v1.0.0

    ```java
    List<com.zoho.crm.api.attachments.Attachment> attachments = responseWrapper.getData();
    for (com.zoho.crm.api.attachments.Attachment attachment : attachments)
    {
	    System.out.println("Attachment ID: " + attachment.getId());
        System.out.println("Attachment RecordStatusS: " + attachment.getRecordStatusS());
        System.out.println("Attachment FieldStates: " + attachment.getFieldStates());
        System.out.println("Attachment ZiaVisions: " + attachment.getZiaVisions());
        System.out.println("Attachment FileIds: " + attachment.getFileIdS());
		System.out.println("Attachment AttachmentSourceS: " + attachment.getAttachmentSourceS());
    }
    ```

## ConversionOptions

### LeadConversionOptions

- Changes Note: method name updated from getConversionoptions to getConversionOptions in ResponseWrapper

- JAVA SDK 7.0-v6.0.0

    ```java
    ResponseHandler responseHandler = response.getObject();
    if (responseHandler instanceof ResponseWrapper)
    {
        ResponseWrapper conversionOptionResponseWrapper = (ResponseWrapper) responseHandler;
	    ConversionOptions conversionOption = conversionOptionResponseWrapper.getConversionoptions();    
    }
    ```
- JAVA SDK 8.0-v1.0.0

    ```java
    ResponseHandler responseHandler = response.getObject();
    if (responseHandler instanceof ResponseWrapper)
    {
        ResponseWrapper conversionOptionResponseWrapper = (ResponseWrapper) responseHandler;
	    ConversionOptions conversionOption = conversionOptionResponseWrapper.getConversionOptions();    
    }
    ```


## Fields

### Get Fields

- Changes Note : New Fields[linkingDetails, connectedDetails, relatedList] introduced in MultiSelectLookup and fields[displayLabel, linkingModule, connectedModule, lookupApiname, apiName, connectedfieldApiname, connectedlookupApiname, id] are removed and Introduced globalPicklistValue field in PickListValue.

- JAVA SDK 7.0-v6.0.0

    ```java
    AssociationDetails associationDetails = field.getAssociationDetails();
    if (associationDetails != null)
    {
        MinifiedModule lookupField = associationDetails.getLookupField();
    }
    //get multi select lookup for field
    Multiselectlookup multiSelectLookup = field.getMultiselectlookup();
    if (multiSelectLookup != null)
    {
        System.out.println("Field MultiSelectLookup DisplayLabel: " + multiSelectLookup.getDisplayLabel());
        System.out.println("Field MultiSelectLookup LinkingModule: " + multiSelectLookup.getLinkingModule());
        System.out.println("Field MultiSelectLookup LookupApiname: " + multiSelectLookup.getLookupApiname());
        System.out.println("Field MultiSelectLookup APIName: " + multiSelectLookup.getAPIName());
        System.out.println("Field MultiSelectLookup ConnectedlookupApiname: " + multiSelectLookup.getConnectedlookupApiname());
        System.out.println("Field MultiSelectLookup ID: " + multiSelectLookup.getId());
        System.out.println("Field MultiSelectLookup connected module: " + multiSelectLookup.getConnectedModule());
    }
    //get multi user lookup for field
    if (field.getMultiuserlookup() != null)
    {
        Multiselectlookup multiuserlookup = field.getMultiuserlookup();
        System.out.println("Get Multiselectlookup DisplayLabel" + multiuserlookup.getDisplayLabel());
        System.out.println("Get Multiselectlookup LinkingModule" + multiuserlookup.getLinkingModule());
        System.out.println("Get Multiselectlookup LookupAPIName" + multiuserlookup.getLookupApiname());
        System.out.println("Get Multiselectlookup APIName" + multiuserlookup.getAPIName());
        System.out.println("Get Multiselectlookup Id" + multiuserlookup.getId());
        System.out.println("Get Multiselectlookup ConnectedModule" + multiuserlookup.getConnectedModule());
        System.out.println("Get Multiselectlookup ConnectedlookupAPIName" + multiuserlookup.getConnectedlookupApiname());
    }
    ```

- JAVA SDK 8.0-v1.0.0

    ```java
    AssociationDetails associationDetails = field.getAssociationDetails();
    if (associationDetails != null)
    {
        LookupField lookupField = associationDetails.getLookupField();
    }
    //get the multi select lookup for field
    Multiselectlookup multiSelectLookup = field.getMultiselectlookup();
    if (multiSelectLookup != null)
    {
        LinkingDetails linkingDetails = multiSelectLookup.getLinkingDetails();
        LinkingModule module = linkingDetails.getModule();
        System.out.println("Field Multiselectlookup LinkingDetails Module Visibility: " + module.getVisibility());
        System.out.println("Field Multiselectlookup LinkingDetails Module PluralLabel: " + module.getPluralLabel());
        System.out.println("Field Multiselectlookup LinkingDetails Module APIName: " + module.getAPIName());
        System.out.println("Field Multiselectlookup LinkingDetails Module Id: " + module.getId());

        LookupField lookupfield = linkingDetails.getLookupField();
        System.out.println("Field MultiSelectLookup LinkingDetails LookupField APIName: " + lookupfield.getAPIName());
        System.out.println("Field MultiSelectLookup LinkingDetails LookupField FieldLabel: " + lookupfield.getFieldLabel());
        System.out.println("Field MultiSelectLookup LinkingDetails LookupField Id: " + lookupfield.getId());

        LookupField connectedLookupField = linkingDetails.getConnectedLookupField();
        System.out.println("Field MultiSelectLookup LinkingDetails ConnectedLookupField APIName: " + connectedLookupField.getAPIName());
        System.out.println("Field MultiSelectLookup LinkingDetails ConnectedLookupField FieldLabel: " + connectedLookupField.getFieldLabel());
        System.out.println("Field MultiSelectLookup LinkingDetails ConnectedLookupField Id: " + connectedLookupField.getId());

        ConnectedDetails connectedDetails = multiSelectLookup.getConnectedDetails();
        LookupField lookupField = connectedDetails.getField();
        System.out.println("Field Multiselectlookup ConnectedDetails Field APIName: " + lookupField.getAPIName());
        System.out.println("Field Multiselectlookup ConnectedDetails Field FieldLabel: " + lookupField.getFieldLabel());
        System.out.println("Field Multiselectlookup ConnectedDetails Field id: " + lookupField.getId());

        LinkingModule connectedModule = connectedDetails.getModule();
        System.out.println("Field MultiSelectLookup ConnectedDetails Module PluralLabel: " + connectedModule.getPluralLabel());
        System.out.println("Field MultiSelectLookup ConnectedDetails Module APIName: " + connectedModule.getAPIName());
        System.out.println("Field MultiSelectLookup ConnectedDetails Module Id: " + connectedModule.getId());

        List<LookupLayout> layouts = connectedDetails.getLayouts();
        if (layouts != null)
        {
            for (LookupLayout layout : layouts)
            {
                System.out.println("Field MultiSelectLookup ConnectedDetails Layouts APIName: " + layout.getAPIName());
                System.out.println("Field MultiSelectLookup ConnectedDetails Layouts Id: " + layout.getId());
            }
        }

        LookupRelatedList relatedList = multiSelectLookup.getRelatedList();
        if (relatedList != null)
        {
            System.out.println("Field MultiSelectLookup RelatedList DisplayLabel: " + relatedList.getDisplayLabel());
            System.out.println("Field MultiSelectLookup RelatedList APIName: " + relatedList.getAPIName());
            System.out.println("Field MultiSelectLookup RelatedList Id: " + relatedList.getId());
        }
    }
    // get the multi user lookup for field
    if (field.getMultiuserlookup() != null)
    {
        Multiselectlookup multiuserlookup = field.getMultiuserlookup();
        LinkingDetails linkingDetails = multiuserlookup.getLinkingDetails();
        LinkingModule module = linkingDetails.getModule();
        System.out.println("Field Multiuserlookup LinkingDetails Module Visibility: " + module.getVisibility());
        System.out.println("Field Multiuserlookup LinkingDetails Module PluralLabel: " + module.getPluralLabel());
        System.out.println("Field Multiuserlookup LinkingDetails Module APIName: " + module.getAPIName());
        System.out.println("Field Multiuserlookup LinkingDetails Module Id: " + module.getId());

        LookupField lookupfield = linkingDetails.getLookupField();
        System.out.println("Field Multiuserlookup LinkingDetails LookupField APIName: " + lookupfield.getAPIName());
        System.out.println("Field Multiuserlookup LinkingDetails LookupField FieldLabel: " + lookupfield.getFieldLabel());
        System.out.println("Field Multiuserlookup LinkingDetails LookupField Id: " + lookupfield.getId());

        LookupField connectedLookupField = linkingDetails.getConnectedLookupField();
        System.out.println("Field Multiuserlookup LinkingDetails ConnectedLookupField APIName: " + connectedLookupField.getAPIName());
        System.out.println("Field Multiuserlookup LinkingDetails ConnectedLookupField FieldLabel: " + connectedLookupField.getFieldLabel());
        System.out.println("Field Multiuserlookup LinkingDetails ConnectedLookupField Id: " + connectedLookupField.getId());

        System.out.println("Field Multiuserlookup RecordAccess: " + multiuserlookup.getRecordAccess());
    }
    Picklist globalPicklist = field.getGlobalPicklist();
    if (globalPicklist != null)
    {
        System.out.println("Fields GlobalPicklist Id: " + globalPicklist.getId());
        System.out.println("Fields GlobalPicklist APIName: " + globalPicklist.getAPIName());
    }
    Picklist globalPicklist = pickListValue.getGlobalPicklistValue();
    if (globalPicklist != null)
    {
        System.out.println("Fields GlobalPicklistValue Id: " + globalPicklist.getId());
        System.out.println("Fields GlobalPicklistValue APIName: " + globalPicklist.getAPIName());
    }
    ```
  
### Update Field

- Changes Note : Sample Input for rollup summary fields where basedOnModule field type changed from MinifiedField to MinifiedModule and relatedList field type changed from MinifiedField to RelatedList.

- JAVA SDK 7.0-v6.0.0

    ```java
    FieldsOperations fieldsOperations = new FieldsOperations();
    BodyWrapper bodyWrapper = new BodyWrapper();
    List<Fields> fields = new ArrayList<Fields>();
    
    /**Sample Input: Field Type - Text*/
    Fields field = new Fields();
    field.setFieldLabel("SDK");
    field.setDisplayLabel("SDK");
    field.setDataType("text");
    field.setLength(180);
    Tooltip toolTip = new Tooltip();
    toolTip.setName("static_text");
    toolTip.setValue("Enter your name");
    field.setTooltip(toolTip);
    Unique unique = new Unique();
    unique.setCasesensitive("false");
    field.setUnique(unique);
    Crypt crypt = new Crypt();
    crypt.setMode("decryption");
    field.setCrypt(crypt);
    External external = new External();
    external.setType("user");
    external.setShow(true);
    field.setExternal(external);
    List<Profile> profiles = new ArrayList<Profile>();
    Profile profile = new Profile();
    profile.setId(34770610026014l);
    profile.setPermissionType("read_write");
    profiles.add(profile);
    field.setProfiles(profiles);
    fields.add(field);
    /** end*/
    ```

- JAVA SDK 8.0-v1.0.0

    ```java
    FieldsOperations fieldsOperations = new FieldsOperations();
    BodyWrapper bodyWrapper = new BodyWrapper();
    List<Fields> fields = new ArrayList<Fields>();
    
    /**Sample Input: Field Type - Text*/
    Fields field = new Fields();
    field.setFieldLabel("SDK");
    field.setDisplayLabel("SDK");
    field.setDataType("text");
    field.setLength(180);
    Tooltip toolTip = new Tooltip();
    toolTip.setName("static_text");
    toolTip.setValue("Enter your name");
    field.setTooltip(toolTip);
    Unique unique = new Unique();
    unique.setCasesensitive("false");
    field.setUnique(unique);
    Crypt crypt = new Crypt();
    crypt.setMode("decryption");
    field.setCrypt(crypt);
    External external = new External();
    external.setType("user");
    external.setShow(true);
    field.setExternal(external);
    List<Profile> profiles = new ArrayList<Profile>();
    Profile profile = new Profile();
    profile.setId(34770610026014l);
    profile.setPermissionType("read_write");
    profiles.add(profile);
    field.setProfiles(profiles);
    fields.add(field);
    /** end*/
    /** Rollup Summary Field */
    Fields rollupSummaryField = new Fields();
    rollupSummaryField.setFieldLabel("Total");
    rollupSummaryField.setDataType("rollup_summary");
    RollupSummary rollupSummary = new RollupSummary();
    rollupSummary.setReturnType("currency");
    Expression expression = new Expression();
    FunctionParameter functionParameter = new FunctionParameter();
    functionParameter.setAPIName("Total");
    expression.setFunctionParameters(new ArrayList<>(Arrays.asList(functionParameter)));
    Criteria criteria = new Criteria();
    criteria.setComparator("AND");
    List<Criteria> group = new ArrayList<>();
    
    Criteria groupCriteria1 = new Criteria();
    groupCriteria1.setComparator("equal");
    MinifiedField groupCriteria1Field = new MinifiedField();
    groupCriteria1Field.setAPIName("Billing_Country");
    groupCriteria1.setValue("United States");
    groupCriteria1.setField(groupCriteria1Field);
    group.add(groupCriteria1);
    
    Criteria groupCriteria2 = new Criteria();
    groupCriteria2.setComparator("greater_than");
    MinifiedField groupCriteria2Field = new MinifiedField();
    groupCriteria2Field.setAPIName("Invoice_Date");
    groupCriteria2.setValue("2024-11-27");
    groupCriteria2.setField(groupCriteria2Field);
    group.add(groupCriteria2);
    
    criteria.setGroup(group);
    expression.setCriteria(criteria);
    expression.setFunction("SUM");
    
    MinifiedModule basedOnModule = new MinifiedModule();
    basedOnModule.setAPIName("Invoices");
    rollupSummary.setBasedOnModule(basedOnModule);
    
    RelatedList relatedList = new RelatedList();
    relatedList.setAPIName("Invoices");
    rollupSummary.setRelatedList(relatedList);
    
    rollupSummary.setExpression(expression);
    rollupSummaryField.setRollupSummary(rollupSummary);
    fields.add(rollupSummaryField);
    ```

## Layouts

### Get Layouts

- Changes Note : Updated getDefaultview method name to getDefaultView and introduced new fields in MutliSelectLookup.

- JAVA SDk 7.0-v6.0.0

    ```java
    List<com.zoho.crm.api.layouts.Layouts> layouts = responseWrapper.getLayouts();
    for (com.zoho.crm.api.layouts.Layouts layout : layouts)
    {
        List<Profiles> profiles = layout.getProfiles();
        if (profiles != null)
        {
            for (Profiles profile : profiles)
            {
                DefaultView defaultView = profile.getDefaultview();
            }
        }
    }
    AssociationDetails associationDetails = field.getAssociationDetails();
    if (associationDetails != null)
    {
        MinifiedModule lookupField = associationDetails.getLookupField();
    }
    //get multi select lookup for field
 	Multiselectlookup multiSelectLookup = field.getMultiselectlookup();
    if (multiSelectLookup != null)
    {
        System.out.println("Field MultiSelectLookup DisplayLabel: " + multiSelectLookup.getDisplayLabel());
        System.out.println("Field MultiSelectLookup LinkingModule: " + multiSelectLookup.getLinkingModule());
        System.out.println("Field MultiSelectLookup LookupApiname: " + multiSelectLookup.getLookupApiname());
        System.out.println("Field MultiSelectLookup APIName: " + multiSelectLookup.getAPIName());
        System.out.println("Field MultiSelectLookup ConnectedlookupApiname: " + multiSelectLookup.getConnectedlookupApiname());
        System.out.println("Field MultiSelectLookup ID: " + multiSelectLookup.getId());
        System.out.println("Field MultiSelectLookup connected module: " + multiSelectLookup.getConnectedModule());
    }
    //get multi user lookup for field
	if (field.getMultiuserlookup() != null)
    {
        Multiselectlookup multiuserlookup = field.getMultiuserlookup();
        System.out.println("Get Multiselectlookup DisplayLabel" + multiuserlookup.getDisplayLabel());
        System.out.println("Get Multiselectlookup LinkingModule" + multiuserlookup.getLinkingModule());
        System.out.println("Get Multiselectlookup LookupAPIName" + multiuserlookup.getLookupApiname());
        System.out.println("Get Multiselectlookup APIName" + multiuserlookup.getAPIName());
        System.out.println("Get Multiselectlookup Id" + multiuserlookup.getId());
        System.out.println("Get Multiselectlookup ConnectedModule" + multiuserlookup.getConnectedModule());
        System.out.println("Get Multiselectlookup ConnectedlookupAPIName" + multiuserlookup.getConnectedlookupApiname());
    }
    ```

- JAVA SDK 8.0-v1.0.0

    ```java
    List<com.zoho.crm.api.layouts.Layouts> layouts = responseWrapper.getLayouts();
    for (com.zoho.crm.api.layouts.Layouts layout : layouts)
    {
        List<Profiles> profiles = layout.getProfiles();
        if (profiles != null)
        {
            for (Profiles profile : profiles)
            {
                DefaultView defaultView = profile.getDefaultView();
            }
        }
    }
    AssociationDetails associationDetails = field.getAssociationDetails();
    if (associationDetails != null)
    {
        LookupField lookupField = associationDetails.getLookupField();
    }
    //get multi select lookup for field
    Multiselectlookup multiSelectLookup = field.getMultiselectlookup();
	if (multiSelectLookup != null)
	{
        LinkingDetails linkingDetails = multiSelectLookup.getLinkingDetails();
        LinkingModule module = linkingDetails.getModule();
        System.out.println("Field Multiselectlookup LinkingDetails Module Visibility: " + module.getVisibility());
        System.out.println("Field Multiselectlookup LinkingDetails Module PluralLabel: " + module.getPluralLabel());
        System.out.println("Field Multiselectlookup LinkingDetails Module APIName: " + module.getAPIName());
        System.out.println("Field Multiselectlookup LinkingDetails Module Id: " + module.getId());
        
        LookupField lookupfield = linkingDetails.getLookupField();
        System.out.println("Field MultiSelectLookup LinkingDetails LookupField APIName: " + lookupfield.getAPIName());
        System.out.println("Field MultiSelectLookup LinkingDetails LookupField FieldLabel: " + lookupfield.getFieldLabel());
        System.out.println("Field MultiSelectLookup LinkingDetails LookupField Id: " + lookupfield.getId());
        
        LookupField connectedLookupField = linkingDetails.getConnectedLookupField();
        System.out.println("Field MultiSelectLookup LinkingDetails ConnectedLookupField APIName: " + connectedLookupField.getAPIName());
        System.out.println("Field MultiSelectLookup LinkingDetails ConnectedLookupField FieldLabel: " + connectedLookupField.getFieldLabel());
        System.out.println("Field MultiSelectLookup LinkingDetails ConnectedLookupField Id: " + connectedLookupField.getId());
        
        ConnectedDetails connectedDetails = multiSelectLookup.getConnectedDetails();
        LookupField lookupField = connectedDetails.getField();
        System.out.println("Field Multiselectlookup ConnectedDetails Field APIName: " + lookupField.getAPIName());
        System.out.println("Field Multiselectlookup ConnectedDetails Field FieldLabel: " + lookupField.getFieldLabel());
        System.out.println("Field Multiselectlookup ConnectedDetails Field id: " + lookupField.getId());
        
        LinkingModule connectedModule = connectedDetails.getModule();
        System.out.println("Field MultiSelectLookup ConnectedDetails Module PluralLabel: " + connectedModule.getPluralLabel());
        System.out.println("Field MultiSelectLookup ConnectedDetails Module APIName: " + connectedModule.getAPIName());
        System.out.println("Field MultiSelectLookup ConnectedDetails Module Id: " + connectedModule.getId());
        
        List<LookupLayout> layouts = connectedDetails.getLayouts();
        if(layouts != null)
        {
            for(LookupLayout layout : layouts)
            {
                System.out.println("Field MultiSelectLookup ConnectedDetails Layouts APIName: " + layout.getAPIName());
                System.out.println("Field MultiSelectLookup ConnectedDetails Layouts Id: " + layout.getId());
            }
        }
        
        LookupRelatedList relatedList = multiSelectLookup.getRelatedList();
        if(relatedList != null)
        {
            System.out.println("Field MultiSelectLookup RelatedList DisplayLabel: " + relatedList.getDisplayLabel());
            System.out.println("Field MultiSelectLookup RelatedList APIName: " + relatedList.getAPIName());
            System.out.println("Field MultiSelectLookup RelatedList Id: " + relatedList.getId());
        }
    }
  
    //get multi select lookup for field
    if (field.getMultiuserlookup() != null)
    {
        Multiselectlookup multiuserlookup = field.getMultiuserlookup();
        LinkingDetails linkingDetails = multiuserlookup.getLinkingDetails();
        LinkingModule module = linkingDetails.getModule();
        System.out.println("Field Multiuserlookup LinkingDetails Module Visibility: " + module.getVisibility());
        System.out.println("Field Multiuserlookup LinkingDetails Module PluralLabel: " + module.getPluralLabel());
        System.out.println("Field Multiuserlookup LinkingDetails Module APIName: " + module.getAPIName());
        System.out.println("Field Multiuserlookup LinkingDetails Module Id: " + module.getId());
        
        LookupField lookupfield = linkingDetails.getLookupField();
        System.out.println("Field Multiuserlookup LinkingDetails LookupField APIName: " + lookupfield.getAPIName());
        System.out.println("Field Multiuserlookup LinkingDetails LookupField FieldLabel: " + lookupfield.getFieldLabel());
        System.out.println("Field Multiuserlookup LinkingDetails LookupField Id: " + lookupfield.getId());
        
        LookupField connectedLookupField = linkingDetails.getConnectedLookupField();
        System.out.println("Field Multiuserlookup LinkingDetails ConnectedLookupField APIName: " + connectedLookupField.getAPIName());
        System.out.println("Field Multiuserlookup LinkingDetails ConnectedLookupField FieldLabel: " + connectedLookupField.getFieldLabe());
        System.out.println("Field Multiuserlookup LinkingDetails ConnectedLookupField Id: " + connectedLookupField.getId());
        
        System.out.println("Field Multiuserlookup RecordAccess: " + multiuserlookup.getRecordAccess());
	}
    ```

## Notification

### Disable Notification

- Changes Note: Updated setDeleteevents method name to setDeleteEvents.

- JAVA SDK 7.0-v6.0.0

    ```java
    com.zoho.crm.api.notifications.Notification notification = new com.zoho.crm.api.notifications.Notification();
    notification.setDeleteevents(new Choice<>(true));    
    ```
- JAVA SDK 8.0-v1.0.0

    ```java
     com.zoho.crm.api.notifications.Notification notification = new com.zoho.crm.api.notifications.Notification();
    notification.setDeleteEvents(new Choice<>(true));      
    ```

## ZiaOrgEnrichment

### Create ZiaOrgEnrichment

- Changes Note: Updated setZiaorgenrichment and getZiaorgenrichment method names to setZiaOrgEnrichment and getZiaOrgEnrichment respectively.

- JAVA SDK 7.0-v6.0.0
    ```java
    BodyWrapper request = new BodyWrapper();
    request.setZiaorgenrichment(ziaorgenrichment);
    ParameterMap paramInstance = new ParameterMap();
    paramInstance.add(CreateZiaOrgEnrichmentParam.MODULE, "Vendors");
    APIResponse<ActionHandler> response = ziaOrgEnrichmentOperations.createZiaOrgEnrichment(request, paramInstance);
    if (response != null)
    {
        ActionHandler actionHandler = response.getObject();
        if (actionHandler instanceof ActionWrapper)
        {
            ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
            List<ActionResponse> actionresponses = actionWrapper.getZiaorgenrichment();
        }
    }
    ```
- JAVA SDK 8.0-v1.0.0
    ```java
    BodyWrapper request = new BodyWrapper();
    request.setZiaOrgEnrichment(ziaorgenrichment);
    ParameterMap paramInstance = new ParameterMap();
    paramInstance.add(CreateZiaOrgEnrichmentParam.MODULE, "Vendors");
    APIResponse<ActionHandler> response = ziaOrgEnrichmentOperations.createZiaOrgEnrichment(request, paramInstance);
    if (response != null)
    {
        ActionHandler actionHandler = response.getObject();
        if (actionHandler instanceof ActionWrapper)
        {
            ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
            List<ActionResponse> actionresponses = actionWrapper.getZiaOrgEnrichment();
        }
    }
    ```

### Get ZiaOrgEnrichment

- Changes Note: Updated getZiaorgenrichment method name to getZiaOrgEnrichment.

- JAVA SDK 7.0-v6.0.0
    ```java
    ZiaOrgEnrichmentOperations ziaOrgEnrichmentOperations = new ZiaOrgEnrichmentOperations();
    APIResponse<ResponseHandler> response = ziaOrgEnrichmentOperations.getZiaOrgEnrichment(ziaOrgEnrichmentId);
    ResponseHandler responseHandler = response.getObject();
    if (responseHandler instanceof ResponseWrapper)
    {
        ResponseWrapper responseWrapper = (ResponseWrapper) responseHandler;
        List<ZiaOrgEnrichment> ziaorgenrichment = responseWrapper.getZiaorgenrichment();
    }
    ```
- JAVA SDK 8.0-v1.0.0
    
    ```java
    ZiaOrgEnrichmentOperations ziaOrgEnrichmentOperations = new ZiaOrgEnrichmentOperations();
    APIResponse<ResponseHandler> response = ziaOrgEnrichmentOperations.getZiaOrgEnrichment(ziaOrgEnrichmentId);
    ResponseHandler responseHandler = response.getObject();
    if (responseHandler instanceof ResponseWrapper)
    {
        ResponseWrapper responseWrapper = (ResponseWrapper) responseHandler;
        List<ZiaOrgEnrichment> ziaorgenrichment = responseWrapper.getZiaOrgEnrichment();
    }
    ```
  
### Get ZiaOrgEnrichments

- Changes Note: Updated getZiaorgenrichment method name to getZiaOrgEnrichment.

- JAVA SDK 7.0-v6.0.0
    ```java
    ZiaOrgEnrichmentOperations ziaOrgEnrichmentOperations = new ZiaOrgEnrichmentOperations();
    ParameterMap paramInstance = new ParameterMap();
    APIResponse<ResponseHandler> response = ziaOrgEnrichmentOperations.getZiaOrgEnrichments(paramInstance);
    ResponseHandler responseHandler = response.getObject();
    if (responseHandler instanceof ResponseWrapper)
    {
        ResponseWrapper responseWrapper = (ResponseWrapper) responseHandler;
        List<ZiaOrgEnrichment> ziaorgenrichment = responseWrapper.getZiaorgenrichment();
    }
    ```
- JAVA SDK 8.0-v1.0.0
    ```java
    ZiaOrgEnrichmentOperations ziaOrgEnrichmentOperations = new ZiaOrgEnrichmentOperations();
    ParameterMap paramInstance = new ParameterMap();
    APIResponse<ResponseHandler> response = ziaOrgEnrichmentOperations.getZiaOrgEnrichments(paramInstance);
    ResponseHandler responseHandler = response.getObject();
    if (responseHandler instanceof ResponseWrapper)
    {
        ResponseWrapper responseWrapper = (ResponseWrapper) responseHandler;
        List<ZiaOrgEnrichment> ziaorgenrichment = responseWrapper.getZiaOrgEnrichment();
    }
   ```
  
## ZiaPeopleEnrichment

### Create ZiaPeopleEnrichment

- Changes Note : Updated setZiapeopleenrichment and getZiapeopleenrichment methods name to setZiaPeopleEnrichment and getZiaPeopleEnrichment respectively.

- JAVA SDK 7.0-v6.0.0
    ```java
    BodyWrapper request = new BodyWrapper();
    request.setZiapeopleenrichment(ziapeopleenrichment);
    ParameterMap paramInstance = new ParameterMap();
    paramInstance.add(CreateZiaPeopleEnrichmentParam.MODULE, "Leads");
    APIResponse<ActionHandler> response = ziaPeopleEnrichmentOperations.createZiaPeopleEnrichment(request, paramInstance);
    if (response != null)
    {
        ActionHandler actionHandler = response.getObject();
        if (actionHandler instanceof ActionWrapper)
        {
            ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
            List<ActionResponse> actionresponses = actionWrapper.getZiapeopleenrichment();
        } 
    }
    ```

- JAVA SDK 8.0-v1.0.0
    ```java
    BodyWrapper request = new BodyWrapper();
    request.setZiaPeopleEnrichment(ziapeopleenrichment);
    ParameterMap paramInstance = new ParameterMap();
    paramInstance.add(CreateZiaPeopleEnrichmentParam.MODULE, "Leads");
    APIResponse<ActionHandler> response = ziaPeopleEnrichmentOperations.createZiaPeopleEnrichment(request, paramInstance);
    if (response != null)
    {
        ActionHandler actionHandler = response.getObject();
        if (actionHandler instanceof ActionWrapper)
        {
            ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
            List<ActionResponse> actionresponses = actionWrapper.getZiaPeopleEnrichment();
        } 
    }
    ```
  
### Get ZiaPeopleEnrichment

- Changes Note : Updated getZiapeopleenrichment method name to getZiaPeopleEnrichment.

- JAVA SDK 7.0-v6.0.0
    ```java
    ZiaPeopleEnrichmentOperations ziaPeopleEnrichmentOperations = new ZiaPeopleEnrichmentOperations(); 
    APIResponse<ResponseHandler> response = ziaOrgEnrichmentOperations.getZiaPeopleEnrichment(ziaOrgEnrichmentId);
    ResponseHandler responseHandler = response.getObject();
    if (responseHandler instanceof ResponseWrapper)
    {
        ResponseWrapper responseWrapper = (ResponseWrapper) responseHandler;
        List<ZiaOrgEnrichment> ziaorgenrichment = responseWrapper.getZiapeopleenrichment();
    }
    ```

- JAVA SDK 8.0-v1.0.0
    ```java
    ZiaPeopleEnrichmentOperations ziaPeopleEnrichmentOperations = new ZiaPeopleEnrichmentOperations(); 
    APIResponse<ResponseHandler> response = ziaOrgEnrichmentOperations.getZiaPeopleEnrichment(ziaOrgEnrichmentId);
    ResponseHandler responseHandler = response.getObject();
    if (responseHandler instanceof ResponseWrapper)
    {
        ResponseWrapper responseWrapper = (ResponseWrapper) responseHandler;
        List<ZiaOrgEnrichment> ziaorgenrichment = responseWrapper.getZiaPeopleEnrichment();
    }
    ```

### Get ZiaPeopleEnrichments

- Changes Note : Updated getZiapeopleenrichment method name to getZiaPeopleEnrichment.

- JAVA SDK 7.0-v6.0.0
    ```java
    ZiaPeopleEnrichmentOperations ziaPeopleEnrichmentOperations = new ZiaPeopleEnrichmentOperations(); 
    ParameterMap paramInstance = new ParameterMap();
    APIResponse<ResponseHandler> response = ziaOrgEnrichmentOperations.getZiaPeopleEnrichments(paramInstance);
    ResponseHandler responseHandler = response.getObject();
    if (responseHandler instanceof ResponseWrapper)
    {
        ResponseWrapper responseWrapper = (ResponseWrapper) responseHandler;
        List<ZiaOrgEnrichment> ziaorgenrichment = responseWrapper.getZiapeopleenrichment();
    }
    ```

- JAVA SDK 8.0-v1.0.0
    ```java
    ZiaPeopleEnrichmentOperations ziaPeopleEnrichmentOperations = new ZiaPeopleEnrichmentOperations(); 
    ParameterMap paramInstance = new ParameterMap();
    APIResponse<ResponseHandler> response = ziaOrgEnrichmentOperations.getZiaPeopleEnrichments(paramInstance);
    ResponseHandler responseHandler = response.getObject();
    if (responseHandler instanceof ResponseWrapper)
    {
        ResponseWrapper responseWrapper = (ResponseWrapper) responseHandler;
        List<ZiaOrgEnrichment> ziaorgenrichment = responseWrapper.getZiaPeopleEnrichment();
    }
    ```
  
## FromAddresses

### Get EmailAddresses

- Changes Note: Introduced new param userId in getEmailAddresses method.

- JAVA SDK 7.0-v6.0.0
    ```java
    public class FromAddresses {
        public static void getEmailAddresses() throws Exception {
            FromAddressesOperations sendMailsOperations = new FromAddressesOperations();
        }
    }
    getEmailAddresses();
    ```

- JAVA SDK 8.0-v1.0.0

    ```java
    public class FromAddresses {
        public static void getEmailAddresses(String userId) throws Exception{
            FromAddressesOperations sendMailsOperations = new FromAddressesOperations(userId);
        }
    }
    String userID = "342312312";
    getEmailAddresses(userID);
    ```

## EmailSharingDetails

### Get EmailSharingDetails

- Changes Note : Updated getEmailssharingdetails method name to getEmailsSharingDetails.

- JAVA SDK 7.0-v6.0.0

    ```java
    ResponseHandler responseHandler = response.getObject();
    if (responseHandler instanceof ResponseWrapper)
    {
        ResponseWrapper responseWrapper = (ResponseWrapper) responseHandler;
        List<EmailSharings> emailSharingdetails = responseWrapper.getEmailssharingdetails();
    }
    ```

- JAVA SDK 8.0-v1.0.0

    ```java
    ResponseHandler responseHandler = response.getObject();
    if (responseHandler instanceof ResponseWrapper)
    {
        ResponseWrapper responseWrapper = (ResponseWrapper) responseHandler;
        List<EmailSharings> emailSharingdetails = responseWrapper.getEmailsSharingDetails();
    }
    ```
  
## Profile

### Get Profiles

- Changes Note : Updated getDefaultview method name to getDefaultView

- JAVA SDK 7.0-v6.0.0

    ```java
    ResponseHandler responseHandler = response.getObject();
    if (responseHandler instanceof ResponseWrapper)
    {
        ResponseWrapper responseWrapper = (ResponseWrapper) responseHandler;
        List<com.zoho.crm.api.profiles.Profile> profiles = responseWrapper.getProfiles();
        for (com.zoho.crm.api.profiles.Profile profile : profiles)
        {
            DefaultView defaultView = profile.getDefaultview();
        }
    }
    ```

- JAVA SDK 8.0-v1.0.0

    ```java
    ResponseHandler responseHandler = response.getObject();
    if (responseHandler instanceof ResponseWrapper)
    {
        ResponseWrapper responseWrapper = (ResponseWrapper) responseHandler;
        List<com.zoho.crm.api.profiles.Profile> profiles = responseWrapper.getProfiles();
        for (com.zoho.crm.api.profiles.Profile profile : profiles)
        {
            DefaultView defaultView = profile.getDefaultView();
        }
    }
    ```

