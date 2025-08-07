package com.zoho.crm.api.record;

import com.zoho.crm.api.layouts.Layouts;
import com.zoho.crm.api.users.MinifiedUser;
import com.zoho.crm.api.util.Choice;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

public class Field<T>
{
	private String apiName;

	/**
	 * Creates an instance of Field with the given parameters
	 * @param apiName A String representing the apiName
	 */
	public Field(String apiName)
	{
		 this.apiName = apiName;


	}

	/**
	 * The method to get the value of apiName
	 * @return A String representing the apiName
	 */
	public String getAPIName()
	{
		return  this.apiName;

	}
	public static class Products
	{
		public static final Field<Choice<String>> PRODUCT_CATEGORY = new Field<Choice<String>>("Product_Category");

		public static final Field<Double> QTY_IN_DEMAND = new Field<Double>("Qty_in_Demand");

		public static final Field<MinifiedUser> OWNER = new Field<MinifiedUser>("Owner");

		public static final Field<String> DESCRIPTION = new Field<String>("Description");

		public static final Field<Record> VENDOR_NAME = new Field<Record>("Vendor_Name");

		public static final Field<LocalDate> SALES_START_DATE = new Field<LocalDate>("Sales_Start_Date");

		public static final Field<List<Tax>> TAX = new Field<List<Tax>>("Tax");

		public static final Field<Boolean> PRODUCT_ACTIVE = new Field<Boolean>("Product_Active");

		public static final Field<String> RECORD_IMAGE = new Field<String>("Record_Image");

		public static final Field<MinifiedUser> MODIFIED_BY = new Field<MinifiedUser>("Modified_By");

		public static final Field<String> PRODUCT_CODE = new Field<String>("Product_Code");

		public static final Field<Choice<String>> MANUFACTURER = new Field<Choice<String>>("Manufacturer");

		public static final Field<Long> ID = new Field<Long>("id");

		public static final Field<LocalDate> SUPPORT_EXPIRY_DATE = new Field<LocalDate>("Support_Expiry_Date");

		public static final Field<OffsetDateTime> MODIFIED_TIME = new Field<OffsetDateTime>("Modified_Time");

		public static final Field<OffsetDateTime> CREATED_TIME = new Field<OffsetDateTime>("Created_Time");

		public static final Field<Double> COMMISSION_RATE = new Field<Double>("Commission_Rate");

		public static final Field<String> PRODUCT_NAME = new Field<String>("Product_Name");

		public static final Field<MinifiedUser> HANDLER = new Field<MinifiedUser>("Handler");

		public static final Field<LocalDate> SUPPORT_START_DATE = new Field<LocalDate>("Support_Start_Date");

		public static final Field<Choice<String>> RECORD_STATUS__S = new Field<Choice<String>>("Record_Status__s");

		public static final Field<Choice<String>> USAGE_UNIT = new Field<Choice<String>>("Usage_Unit");

		public static final Field<Double> QTY_ORDERED = new Field<Double>("Qty_Ordered");

		public static final Field<Boolean> LOCKED__S = new Field<Boolean>("Locked__s");

		public static final Field<Double> QTY_IN_STOCK = new Field<Double>("Qty_in_Stock");

		public static final Field<MinifiedUser> CREATED_BY = new Field<MinifiedUser>("Created_By");

		public static final Field<String> TAG = new Field<String>("Tag");

		public static final Field<LocalDate> SALES_END_DATE = new Field<LocalDate>("Sales_End_Date");

		public static final Field<Double> UNIT_PRICE = new Field<Double>("Unit_Price");

		public static final Field<Double> REORDER_LEVEL = new Field<Double>("Reorder_Level");

		public static final Field<Boolean> TAXABLE = new Field<Boolean>("Taxable");

	}

	public static class Consents
	{
		public static final Field<Boolean> CONTACT_THROUGH_EMAIL = new Field<Boolean>("Contact_Through_Email");

		public static final Field<MinifiedUser> OWNER = new Field<MinifiedUser>("Owner");

		public static final Field<OffsetDateTime> MODIFIED_TIME = new Field<OffsetDateTime>("Modified_Time");

		public static final Field<String> EMAIL = new Field<String>("Email");

		public static final Field<OffsetDateTime> CREATED_TIME = new Field<OffsetDateTime>("Created_Time");

		public static final Field<Choice<String>> CONSENT_THROUGH = new Field<Choice<String>>("Consent_Through");

		public static final Field<Boolean> CONTACT_THROUGH_SURVEY = new Field<Boolean>("Contact_Through_Survey");

		public static final Field<Choice<String>> RECORD_STATUS__S = new Field<Choice<String>>("Record_Status__s");

		public static final Field<Choice<String>> DATA_PROCESSING_BASIS = new Field<Choice<String>>("Data_Processing_Basis");

		public static final Field<Boolean> CONTACT_THROUGH_PHONE = new Field<Boolean>("Contact_Through_Phone");

		public static final Field<String> LAWFUL_REASON = new Field<String>("Lawful_Reason");

		public static final Field<OffsetDateTime> MAIL_SENT_TIME = new Field<OffsetDateTime>("Mail_Sent_Time");

		public static final Field<MinifiedUser> MODIFIED_BY = new Field<MinifiedUser>("Modified_By");

		public static final Field<LocalDate> CONSENT_DATE = new Field<LocalDate>("Consent_Date");

		public static final Field<Long> ID = new Field<Long>("id");

		public static final Field<MinifiedUser> CREATED_BY = new Field<MinifiedUser>("Created_By");

		public static final Field<String> CONSENT_REMARKS = new Field<String>("Consent_Remarks");

	}

	public static class Tasks
	{
		public static final Field<Choice<String>> STATUS = new Field<Choice<String>>("Status");

		public static final Field<MinifiedUser> OWNER = new Field<MinifiedUser>("Owner");

		public static final Field<OffsetDateTime> MODIFIED_TIME = new Field<OffsetDateTime>("Modified_Time");

		public static final Field<String> DESCRIPTION = new Field<String>("Description");

		public static final Field<LocalDate> DUE_DATE = new Field<LocalDate>("Due_Date");

		public static final Field<Choice<String>> PRIORITY = new Field<Choice<String>>("Priority");

		public static final Field<OffsetDateTime> CREATED_TIME = new Field<OffsetDateTime>("Created_Time");

		public static final Field<OffsetDateTime> CLOSED_TIME = new Field<OffsetDateTime>("Closed_Time");

		public static final Field<Choice<String>> RECORD_STATUS__S = new Field<Choice<String>>("Record_Status__s");

		public static final Field<String> SUBJECT = new Field<String>("Subject");

		public static final Field<Boolean> SEND_NOTIFICATION_EMAIL = new Field<Boolean>("Send_Notification_Email");

		public static final Field<MinifiedUser> MODIFIED_BY = new Field<MinifiedUser>("Modified_By");

		public static final Field<RecurringActivity> RECURRING_ACTIVITY = new Field<RecurringActivity>("Recurring_Activity");

		public static final Field<Record> WHAT_ID = new Field<Record>("What_Id");

		public static final Field<Boolean> LOCKED__S = new Field<Boolean>("Locked__s");

		public static final Field<MinifiedUser> CREATED_BY = new Field<MinifiedUser>("Created_By");

		public static final Field<String> TAG = new Field<String>("Tag");

		public static final Field<Long> ID = new Field<Long>("id");

		public static final Field<RemindAt> REMIND_AT = new Field<RemindAt>("Remind_At");

		public static final Field<Record> WHO_ID = new Field<Record>("Who_Id");

	}

	public static class Data_Subject_Requests
	{
		public static final Field<Choice<String>> REQUEST_TYPE = new Field<Choice<String>>("Request_Type");

		public static final Field<String> IS_CLOSED = new Field<String>("Is_Closed");

		public static final Field<Record> PARENT_ID = new Field<Record>("Parent_Id");

		public static final Field<Choice<String>> REQUEST_SOURCE = new Field<Choice<String>>("Request_Source");

		public static final Field<Long> ID = new Field<Long>("id");

		public static final Field<MinifiedUser> CLOSED_BY = new Field<MinifiedUser>("Closed_By");

		public static final Field<Choice<String>> RECORD_STATUS__S = new Field<Choice<String>>("Record_Status__s");

		public static final Field<MinifiedUser> REQUESTED_BY = new Field<MinifiedUser>("Requested_By");

		public static final Field<OffsetDateTime> REQUESTED_DATE = new Field<OffsetDateTime>("Requested_Date");

		public static final Field<OffsetDateTime> CLOSED_DATE = new Field<OffsetDateTime>("Closed_Date");

	}

	public static class Vendors
	{
		public static final Field<MinifiedUser> OWNER = new Field<MinifiedUser>("Owner");

		public static final Field<String> EMAIL = new Field<String>("Email");

		public static final Field<String> CATEGORY = new Field<String>("Category");

		public static final Field<String> DESCRIPTION = new Field<String>("Description");

		public static final Field<String> VENDOR_NAME = new Field<String>("Vendor_Name");

		public static final Field<String> WEBSITE = new Field<String>("Website");

		public static final Field<String> RECORD_IMAGE = new Field<String>("Record_Image");

		public static final Field<MinifiedUser> MODIFIED_BY = new Field<MinifiedUser>("Modified_By");

		public static final Field<Choice<String>> UNSUBSCRIBED_MODE = new Field<Choice<String>>("Unsubscribed_Mode");

		public static final Field<String> PHONE = new Field<String>("Phone");

		public static final Field<String> STREET = new Field<String>("Street");

		public static final Field<String> ZIP_CODE = new Field<String>("Zip_Code");

		public static final Field<Long> ID = new Field<Long>("id");

		public static final Field<Boolean> EMAIL_OPT_OUT = new Field<Boolean>("Email_Opt_Out");

		public static final Field<OffsetDateTime> MODIFIED_TIME = new Field<OffsetDateTime>("Modified_Time");

		public static final Field<OffsetDateTime> CREATED_TIME = new Field<OffsetDateTime>("Created_Time");

		public static final Field<OffsetDateTime> UNSUBSCRIBED_TIME = new Field<OffsetDateTime>("Unsubscribed_Time");

		public static final Field<String> CITY = new Field<String>("City");

		public static final Field<Choice<String>> RECORD_STATUS__S = new Field<Choice<String>>("Record_Status__s");

		public static final Field<String> STATE = new Field<String>("State");

		public static final Field<Choice<String>> GL_ACCOUNT = new Field<Choice<String>>("GL_Account");

		public static final Field<Boolean> LOCKED__S = new Field<Boolean>("Locked__s");

		public static final Field<String> COUNTRY = new Field<String>("Country");

		public static final Field<MinifiedUser> CREATED_BY = new Field<MinifiedUser>("Created_By");

		public static final Field<String> TAG = new Field<String>("Tag");

	}

	public static class Appointments__s
	{
		public static final Field<MinifiedUser> OWNER = new Field<MinifiedUser>("Owner");

		public static final Field<String> ADDRESS = new Field<String>("Address");

		public static final Field<OffsetDateTime> APPOINTMENT_START_TIME = new Field<OffsetDateTime>("Appointment_Start_Time");

		public static final Field<Choice<String>> CANCELLATION_REASON = new Field<Choice<String>>("Cancellation_Reason");

		public static final Field<Record> APPOINTMENT_FOR = new Field<Record>("Appointment_For");

		public static final Field<OffsetDateTime> RESCHEDULED_TO = new Field<OffsetDateTime>("Rescheduled_To");

		public static final Field<Choice<String>> RESCHEDULE_REASON = new Field<Choice<String>>("Reschedule_Reason");

		public static final Field<String> JOB_SHEET_NAME__S = new Field<String>("Job_Sheet_Name__s");

		public static final Field<String> ADDITIONAL_INFORMATION = new Field<String>("Additional_Information");

		public static final Field<Boolean> JOB_SHEET_CREATED__S = new Field<Boolean>("Job_Sheet_Created__s");

		public static final Field<OffsetDateTime> CANCELLED_TIME = new Field<OffsetDateTime>("Cancelled_Time");

		public static final Field<String> CANCELLATION_NOTE = new Field<String>("Cancellation_Note");

		public static final Field<MinifiedUser> MODIFIED_BY = new Field<MinifiedUser>("Modified_By");

		public static final Field<Integer> RESCHEDULE_COUNT = new Field<Integer>("Reschedule_Count");

		public static final Field<MinifiedUser> RESCHEDULED_BY = new Field<MinifiedUser>("Rescheduled_By");

		public static final Field<Long> ID = new Field<Long>("id");

		public static final Field<OffsetDateTime> RESCHEDULED_TIME = new Field<OffsetDateTime>("Rescheduled_Time");

		public static final Field<List<Reminder>> REMIND_AT = new Field<List<Reminder>>("Remind_At");

		public static final Field<OffsetDateTime> APPOINTMENT_END_TIME = new Field<OffsetDateTime>("Appointment_End_Time");

		public static final Field<Choice<String>> STATUS = new Field<Choice<String>>("Status");

		public static final Field<OffsetDateTime> MODIFIED_TIME = new Field<OffsetDateTime>("Modified_Time");

		public static final Field<Record> SERVICE_NAME = new Field<Record>("Service_Name");

		public static final Field<OffsetDateTime> CREATED_TIME = new Field<OffsetDateTime>("Created_Time");

		public static final Field<OffsetDateTime> RESCHEDULED_FROM = new Field<OffsetDateTime>("Rescheduled_From");

		public static final Field<MinifiedUser> CANCELLED_BY = new Field<MinifiedUser>("Cancelled_By");

		public static final Field<String> APPOINTMENT_NAME = new Field<String>("Appointment_Name");

		public static final Field<Integer> DURATION = new Field<Integer>("Duration");

		public static final Field<Choice<String>> JOB_SHEET_SECTION__S = new Field<Choice<String>>("Job_Sheet_Section__s");

		public static final Field<Choice<String>> RECORD_STATUS__S = new Field<Choice<String>>("Record_Status__s");

		public static final Field<String> JOB_SHEET_DESCRIPTION__S = new Field<String>("Job_Sheet_Description__s");

		public static final Field<MinifiedUser> CREATED_BY = new Field<MinifiedUser>("Created_By");

		public static final Field<String> TAG = new Field<String>("Tag");

		public static final Field<Choice<String>> LOCATION = new Field<Choice<String>>("Location");

		public static final Field<String> RESCHEDULE_NOTE = new Field<String>("Reschedule_Note");

	}

	public static class Calls
	{
		public static final Field<String> CALL_DURATION = new Field<String>("Call_Duration");

		public static final Field<MinifiedUser> OWNER = new Field<MinifiedUser>("Owner");

		public static final Field<String> DESCRIPTION = new Field<String>("Description");

		public static final Field<Boolean> CTI_ENTRY = new Field<Boolean>("CTI_Entry");

		public static final Field<String> CALLER_ID = new Field<String>("Caller_ID");

		public static final Field<String> CALL_AGENDA = new Field<String>("Call_Agenda");

		public static final Field<MinifiedUser> MODIFIED_BY = new Field<MinifiedUser>("Modified_By");

		public static final Field<Choice<String>> CALL_PURPOSE = new Field<Choice<String>>("Call_Purpose");

		public static final Field<Long> ID = new Field<Long>("id");

		public static final Field<Record> WHO_ID = new Field<Record>("Who_Id");

		public static final Field<Choice<String>> OUTGOING_CALL_STATUS = new Field<Choice<String>>("Outgoing_Call_Status");

		public static final Field<OffsetDateTime> MODIFIED_TIME = new Field<OffsetDateTime>("Modified_Time");

		public static final Field<Choice<String>> REMINDER = new Field<Choice<String>>("Reminder");

		public static final Field<String> VOICE_RECORDING__S = new Field<String>("Voice_Recording__s");

		public static final Field<OffsetDateTime> CREATED_TIME = new Field<OffsetDateTime>("Created_Time");

		public static final Field<OffsetDateTime> CALL_START_TIME = new Field<OffsetDateTime>("Call_Start_Time");

		public static final Field<Choice<String>> RECORD_STATUS__S = new Field<Choice<String>>("Record_Status__s");

		public static final Field<String> SUBJECT = new Field<String>("Subject");

		public static final Field<Choice<String>> CALL_TYPE = new Field<Choice<String>>("Call_Type");

		public static final Field<String> CALL_RESULT = new Field<String>("Call_Result");

		public static final Field<Choice<String>> SCHEDULED_IN_CRM = new Field<Choice<String>>("Scheduled_In_CRM");

		public static final Field<Record> WHAT_ID = new Field<Record>("What_Id");

		public static final Field<Integer> CALL_DURATION_IN_SECONDS = new Field<Integer>("Call_Duration_in_seconds");

		public static final Field<MinifiedUser> CREATED_BY = new Field<MinifiedUser>("Created_By");

		public static final Field<String> TAG = new Field<String>("Tag");

		public static final Field<String> DIALLED_NUMBER = new Field<String>("Dialled_Number");

	}

	public static class Leads
	{
		public static final Field<MinifiedUser> OWNER = new Field<MinifiedUser>("Owner");

		public static final Field<String> COMPANY = new Field<String>("Company");

		public static final Field<String> EMAIL = new Field<String>("Email");

		public static final Field<Long> VISITOR_SCORE = new Field<Long>("Visitor_Score");

		public static final Field<OffsetDateTime> LAST_ACTIVITY_TIME = new Field<OffsetDateTime>("Last_Activity_Time");

		public static final Field<Choice<String>> INDUSTRY = new Field<Choice<String>>("Industry");

		public static final Field<Choice<String>> UNSUBSCRIBED_MODE = new Field<Choice<String>>("Unsubscribed_Mode");

		public static final Field<Double> EXCHANGE_RATE = new Field<Double>("Exchange_Rate");

		public static final Field<Choice<String>> CURRENCY = new Field<Choice<String>>("Currency");

		public static final Field<String> STREET = new Field<String>("Street");

		public static final Field<String> ZIP_CODE = new Field<String>("Zip_Code");

		public static final Field<Consent> DATA_PROCESSING_BASIS_DETAILS = new Field<Consent>("Data_Processing_Basis_Details");

		public static final Field<Long> ID = new Field<Long>("id");

		public static final Field<Choice<String>> DATA_SOURCE = new Field<Choice<String>>("Data_Source");

		public static final Field<Choice<String>> ENRICH_STATUS__S = new Field<Choice<String>>("Enrich_Status__s");

		public static final Field<String> FIRST_VISITED_URL = new Field<String>("First_Visited_URL");

		public static final Field<Integer> DAYS_VISITED = new Field<Integer>("Days_Visited");

		public static final Field<OffsetDateTime> CREATED_TIME = new Field<OffsetDateTime>("Created_Time");

		public static final Field<OffsetDateTime> CHANGE_LOG_TIME__S = new Field<OffsetDateTime>("Change_Log_Time__s");

		public static final Field<String> CITY = new Field<String>("City");

		public static final Field<Integer> NO_OF_EMPLOYEES = new Field<Integer>("No_of_Employees");

		public static final Field<Choice<String>> DATA_PROCESSING_BASIS = new Field<Choice<String>>("Data_Processing_Basis");

		public static final Field<Boolean> CONVERTED__S = new Field<Boolean>("Converted__s");

		public static final Field<OffsetDateTime> CONVERTED_DATE_TIME = new Field<OffsetDateTime>("Converted_Date_Time");

		public static final Field<Record> CONVERTED_ACCOUNT = new Field<Record>("Converted_Account");

		public static final Field<String> STATE = new Field<String>("State");

		public static final Field<String> COUNTRY = new Field<String>("Country");

		public static final Field<OffsetDateTime> LAST_VISITED_TIME = new Field<OffsetDateTime>("Last_Visited_Time");

		public static final Field<MinifiedUser> CREATED_BY = new Field<MinifiedUser>("Created_By");

		public static final Field<Double> ANNUAL_REVENUE = new Field<Double>("Annual_Revenue");

		public static final Field<String> SECONDARY_EMAIL = new Field<String>("Secondary_Email");

		public static final Field<String> DESCRIPTION = new Field<String>("Description");

		public static final Field<Integer> NUMBER_OF_CHATS = new Field<Integer>("Number_Of_Chats");

		public static final Field<Choice<String>> RATING = new Field<Choice<String>>("Rating");

		public static final Field<String> WEBSITE = new Field<String>("Website");

		public static final Field<String> TWITTER = new Field<String>("Twitter");

		public static final Field<Double> AVERAGE_TIME_SPENT_MINUTES = new Field<Double>("Average_Time_Spent_Minutes");

		public static final Field<Choice<String>> SALUTATION = new Field<Choice<String>>("Salutation");

		public static final Field<String> FIRST_NAME = new Field<String>("First_Name");

		public static final Field<Choice<String>> LEAD_STATUS = new Field<Choice<String>>("Lead_Status");

		public static final Field<String> FULL_NAME = new Field<String>("Full_Name");

		public static final Field<String> RECORD_IMAGE = new Field<String>("Record_Image");

		public static final Field<MinifiedUser> MODIFIED_BY = new Field<MinifiedUser>("Modified_By");

		public static final Field<Record> CONVERTED_DEAL = new Field<Record>("Converted_Deal");

		public static final Field<Integer> LEAD_CONVERSION_TIME = new Field<Integer>("Lead_Conversion_Time");

		public static final Field<String> SKYPE_ID = new Field<String>("Skype_ID");

		public static final Field<String> PHONE = new Field<String>("Phone");

		public static final Field<Boolean> EMAIL_OPT_OUT = new Field<Boolean>("Email_Opt_Out");

		public static final Field<String> DESIGNATION = new Field<String>("Designation");

		public static final Field<OffsetDateTime> MODIFIED_TIME = new Field<OffsetDateTime>("Modified_Time");

		public static final Field<OffsetDateTime> UNSUBSCRIBED_TIME = new Field<OffsetDateTime>("Unsubscribed_Time");

		public static final Field<Record> CONVERTED_CONTACT = new Field<Record>("Converted_Contact");

		public static final Field<String> MOBILE = new Field<String>("Mobile");

		public static final Field<List<Territory>> TERRITORIES = new Field<List<Territory>>("Territories");

		public static final Field<Choice<String>> RECORD_STATUS__S = new Field<Choice<String>>("Record_Status__s");

		public static final Field<OffsetDateTime> FIRST_VISITED_TIME = new Field<OffsetDateTime>("First_Visited_Time");

		public static final Field<String> LAST_NAME = new Field<String>("Last_Name");

		public static final Field<Layouts> LAYOUT = new Field<Layouts>("Layout");

		public static final Field<String> REFERRER = new Field<String>("Referrer");

		public static final Field<Boolean> LOCKED__S = new Field<Boolean>("Locked__s");

		public static final Field<Choice<String>> LEAD_SOURCE = new Field<Choice<String>>("Lead_Source");

		public static final Field<String> TAG = new Field<String>("Tag");

		public static final Field<String> FAX = new Field<String>("Fax");

		public static final Field<OffsetDateTime> LAST_ENRICHED_TIME__S = new Field<OffsetDateTime>("Last_Enriched_Time__s");

	}

	public static class Deals
	{
		public static final Field<MinifiedUser> OWNER = new Field<MinifiedUser>("Owner");

		public static final Field<String> DESCRIPTION = new Field<String>("Description");

		public static final Field<Record> CAMPAIGN_SOURCE = new Field<Record>("Campaign_Source");

		public static final Field<LocalDate> CLOSING_DATE = new Field<LocalDate>("Closing_Date");

		public static final Field<OffsetDateTime> LAST_ACTIVITY_TIME = new Field<OffsetDateTime>("Last_Activity_Time");

		public static final Field<Choice<String>> REASON_FOR_LOSS__S = new Field<Choice<String>>("Reason_For_Loss__s");

		public static final Field<MinifiedUser> MODIFIED_BY = new Field<MinifiedUser>("Modified_By");

		public static final Field<Integer> LEAD_CONVERSION_TIME = new Field<Integer>("Lead_Conversion_Time");

		public static final Field<String> DEAL_NAME = new Field<String>("Deal_Name");

		public static final Field<Double> EXCHANGE_RATE = new Field<Double>("Exchange_Rate");

		public static final Field<Double> EXPECTED_REVENUE = new Field<Double>("Expected_Revenue");

		public static final Field<Choice<String>> CURRENCY = new Field<Choice<String>>("Currency");

		public static final Field<Integer> OVERALL_SALES_DURATION = new Field<Integer>("Overall_Sales_Duration");

		public static final Field<Choice<String>> STAGE = new Field<Choice<String>>("Stage");

		public static final Field<Record> ACCOUNT_NAME = new Field<Record>("Account_Name");

		public static final Field<Long> ID = new Field<Long>("id");

		public static final Field<OffsetDateTime> MODIFIED_TIME = new Field<OffsetDateTime>("Modified_Time");

		public static final Field<List<Territory>> TERRITORY = new Field<List<Territory>>("Territory");

		public static final Field<OffsetDateTime> CREATED_TIME = new Field<OffsetDateTime>("Created_Time");

		public static final Field<Double> AMOUNT = new Field<Double>("Amount");

		public static final Field<Integer> PROBABILITY = new Field<Integer>("Probability");

		public static final Field<String> NEXT_STEP = new Field<String>("Next_Step");

		public static final Field<OffsetDateTime> CHANGE_LOG_TIME__S = new Field<OffsetDateTime>("Change_Log_Time__s");

		public static final Field<Choice<String>> RECORD_STATUS__S = new Field<Choice<String>>("Record_Status__s");

		public static final Field<Record> CONTACT_NAME = new Field<Record>("Contact_Name");

		public static final Field<Choice<String>> PIPELINE = new Field<Choice<String>>("Pipeline");

		public static final Field<Integer> SALES_CYCLE_DURATION = new Field<Integer>("Sales_Cycle_Duration");

		public static final Field<Choice<String>> TYPE = new Field<Choice<String>>("Type");

		public static final Field<Boolean> LOCKED__S = new Field<Boolean>("Locked__s");

		public static final Field<Choice<String>> LEAD_SOURCE = new Field<Choice<String>>("Lead_Source");

		public static final Field<MinifiedUser> CREATED_BY = new Field<MinifiedUser>("Created_By");

		public static final Field<String> TAG = new Field<String>("Tag");

	}

	public static class Quotes
	{
		public static final Field<MinifiedUser> OWNER = new Field<MinifiedUser>("Owner");

		public static final Field<String> DESCRIPTION = new Field<String>("Description");

		public static final Field<Double> DISCOUNT = new Field<Double>("Discount");

		public static final Field<String> SHIPPING_STATE = new Field<String>("Shipping_State");

		public static final Field<Double> TAX = new Field<Double>("Tax");

		public static final Field<MinifiedUser> MODIFIED_BY = new Field<MinifiedUser>("Modified_By");

		public static final Field<Record> DEAL_NAME = new Field<Record>("Deal_Name");

		public static final Field<Double> EXCHANGE_RATE = new Field<Double>("Exchange_Rate");

		public static final Field<LocalDate> VALID_TILL = new Field<LocalDate>("Valid_Till");

		public static final Field<String> BILLING_COUNTRY = new Field<String>("Billing_Country");

		public static final Field<Choice<String>> CURRENCY = new Field<Choice<String>>("Currency");

		public static final Field<String> TEAM = new Field<String>("Team");

		public static final Field<Record> ACCOUNT_NAME = new Field<Record>("Account_Name");

		public static final Field<Choice<String>> CARRIER = new Field<Choice<String>>("Carrier");

		public static final Field<List<Record>> QUOTED_ITEMS = new Field<List<Record>>("Quoted_Items");

		public static final Field<Long> ID = new Field<Long>("id");

		public static final Field<Choice<String>> QUOTE_STAGE = new Field<Choice<String>>("Quote_Stage");

		public static final Field<Double> GRAND_TOTAL = new Field<Double>("Grand_Total");

		public static final Field<OffsetDateTime> MODIFIED_TIME = new Field<OffsetDateTime>("Modified_Time");

		public static final Field<Double> ADJUSTMENT = new Field<Double>("Adjustment");

		public static final Field<String> BILLING_STREET = new Field<String>("Billing_Street");

		public static final Field<OffsetDateTime> CREATED_TIME = new Field<OffsetDateTime>("Created_Time");

		public static final Field<String> TERMS_AND_CONDITIONS = new Field<String>("Terms_and_Conditions");

		public static final Field<Double> SUB_TOTAL = new Field<Double>("Sub_Total");

		public static final Field<String> BILLING_CODE = new Field<String>("Billing_Code");

		public static final Field<Choice<String>> RECORD_STATUS__S = new Field<Choice<String>>("Record_Status__s");

		public static final Field<String> SUBJECT = new Field<String>("Subject");

		public static final Field<Record> CONTACT_NAME = new Field<Record>("Contact_Name");

		public static final Field<String> SHIPPING_CITY = new Field<String>("Shipping_City");

		public static final Field<String> SHIPPING_COUNTRY = new Field<String>("Shipping_Country");

		public static final Field<String> SHIPPING_CODE = new Field<String>("Shipping_Code");

		public static final Field<String> BILLING_CITY = new Field<String>("Billing_City");

		public static final Field<String> QUOTE_NUMBER = new Field<String>("Quote_Number");

		public static final Field<Boolean> LOCKED__S = new Field<Boolean>("Locked__s");

		public static final Field<String> BILLING_STATE = new Field<String>("Billing_State");

		public static final Field<MinifiedUser> CREATED_BY = new Field<MinifiedUser>("Created_By");

		public static final Field<String> TAG = new Field<String>("Tag");

		public static final Field<String> SHIPPING_STREET = new Field<String>("Shipping_Street");

	}

	public static class Invoices
	{
		public static final Field<MinifiedUser> OWNER = new Field<MinifiedUser>("Owner");

		public static final Field<String> DESCRIPTION = new Field<String>("Description");

		public static final Field<Double> DISCOUNT = new Field<Double>("Discount");

		public static final Field<String> SHIPPING_STATE = new Field<String>("Shipping_State");

		public static final Field<Double> TAX = new Field<Double>("Tax");

		public static final Field<LocalDate> INVOICE_DATE = new Field<LocalDate>("Invoice_Date");

		public static final Field<MinifiedUser> MODIFIED_BY = new Field<MinifiedUser>("Modified_By");

		public static final Field<List<Record>> INVOICED_ITEMS = new Field<List<Record>>("Invoiced_Items");

		public static final Field<Double> EXCHANGE_RATE = new Field<Double>("Exchange_Rate");

		public static final Field<String> BILLING_COUNTRY = new Field<String>("Billing_Country");

		public static final Field<Choice<String>> CURRENCY = new Field<Choice<String>>("Currency");

		public static final Field<Record> ACCOUNT_NAME = new Field<Record>("Account_Name");

		public static final Field<Long> ID = new Field<Long>("id");

		public static final Field<Record> SALES_ORDER = new Field<Record>("Sales_Order");

		public static final Field<Choice<String>> STATUS = new Field<Choice<String>>("Status");

		public static final Field<Double> SALES_COMMISSION = new Field<Double>("Sales_Commission");

		public static final Field<Double> GRAND_TOTAL = new Field<Double>("Grand_Total");

		public static final Field<OffsetDateTime> MODIFIED_TIME = new Field<OffsetDateTime>("Modified_Time");

		public static final Field<LocalDate> DUE_DATE = new Field<LocalDate>("Due_Date");

		public static final Field<Double> ADJUSTMENT = new Field<Double>("Adjustment");

		public static final Field<String> BILLING_STREET = new Field<String>("Billing_Street");

		public static final Field<OffsetDateTime> CREATED_TIME = new Field<OffsetDateTime>("Created_Time");

		public static final Field<String> TERMS_AND_CONDITIONS = new Field<String>("Terms_and_Conditions");

		public static final Field<Double> SUB_TOTAL = new Field<Double>("Sub_Total");

		public static final Field<String> INVOICE_NUMBER = new Field<String>("Invoice_Number");

		public static final Field<String> BILLING_CODE = new Field<String>("Billing_Code");

		public static final Field<Choice<String>> RECORD_STATUS__S = new Field<Choice<String>>("Record_Status__s");

		public static final Field<String> SUBJECT = new Field<String>("Subject");

		public static final Field<Double> EXCISE_DUTY = new Field<Double>("Excise_Duty");

		public static final Field<Record> CONTACT_NAME = new Field<Record>("Contact_Name");

		public static final Field<String> SHIPPING_CITY = new Field<String>("Shipping_City");

		public static final Field<String> SHIPPING_COUNTRY = new Field<String>("Shipping_Country");

		public static final Field<String> SHIPPING_CODE = new Field<String>("Shipping_Code");

		public static final Field<String> BILLING_CITY = new Field<String>("Billing_City");

		public static final Field<Boolean> LOCKED__S = new Field<Boolean>("Locked__s");

		public static final Field<String> PURCHASE_ORDER = new Field<String>("Purchase_Order");

		public static final Field<String> BILLING_STATE = new Field<String>("Billing_State");

		public static final Field<MinifiedUser> CREATED_BY = new Field<MinifiedUser>("Created_By");

		public static final Field<String> TAG = new Field<String>("Tag");

		public static final Field<String> SHIPPING_STREET = new Field<String>("Shipping_Street");

	}

	public static class Campaigns
	{
		public static final Field<Choice<String>> STATUS = new Field<Choice<String>>("Status");

		public static final Field<MinifiedUser> OWNER = new Field<MinifiedUser>("Owner");

		public static final Field<OffsetDateTime> MODIFIED_TIME = new Field<OffsetDateTime>("Modified_Time");

		public static final Field<String> DESCRIPTION = new Field<String>("Description");

		public static final Field<String> CAMPAIGN_NAME = new Field<String>("Campaign_Name");

		public static final Field<OffsetDateTime> CREATED_TIME = new Field<OffsetDateTime>("Created_Time");

		public static final Field<LocalDate> END_DATE = new Field<LocalDate>("End_Date");

		public static final Field<Choice<String>> RECORD_STATUS__S = new Field<Choice<String>>("Record_Status__s");

		public static final Field<Choice<String>> TYPE = new Field<Choice<String>>("Type");

		public static final Field<MinifiedUser> MODIFIED_BY = new Field<MinifiedUser>("Modified_By");

		public static final Field<Long> NUM_SENT = new Field<Long>("Num_sent");

		public static final Field<Double> EXCHANGE_RATE = new Field<Double>("Exchange_Rate");

		public static final Field<Double> EXPECTED_REVENUE = new Field<Double>("Expected_Revenue");

		public static final Field<Choice<String>> CURRENCY = new Field<Choice<String>>("Currency");

		public static final Field<Double> ACTUAL_COST = new Field<Double>("Actual_Cost");

		public static final Field<Long> EXPECTED_RESPONSE = new Field<Long>("Expected_Response");

		public static final Field<MinifiedUser> CREATED_BY = new Field<MinifiedUser>("Created_By");

		public static final Field<String> TAG = new Field<String>("Tag");

		public static final Field<Record> PARENT_CAMPAIGN = new Field<Record>("Parent_Campaign");

		public static final Field<Long> ID = new Field<Long>("id");

		public static final Field<LocalDate> START_DATE = new Field<LocalDate>("Start_Date");

		public static final Field<Double> BUDGETED_COST = new Field<Double>("Budgeted_Cost");

	}

	public static class Attachments
	{
		public static final Field<MinifiedUser> OWNER = new Field<MinifiedUser>("Owner");

		public static final Field<MinifiedUser> MODIFIED_BY = new Field<MinifiedUser>("Modified_By");

		public static final Field<OffsetDateTime> MODIFIED_TIME = new Field<OffsetDateTime>("Modified_Time");

		public static final Field<String> FILE_NAME = new Field<String>("File_Name");

		public static final Field<OffsetDateTime> CREATED_TIME = new Field<OffsetDateTime>("Created_Time");

		public static final Field<Long> SIZE = new Field<Long>("Size");

		public static final Field<Record> PARENT_ID = new Field<Record>("Parent_Id");

		public static final Field<MinifiedUser> CREATED_BY = new Field<MinifiedUser>("Created_By");

		public static final Field<Long> ID = new Field<Long>("id");

		public static final Field<Choice<String>> RECORD_STATUS__S = new Field<Choice<String>>("Record_Status__s");

	}

	public static class Price_Books
	{
		public static final Field<MinifiedUser> OWNER = new Field<MinifiedUser>("Owner");

		public static final Field<OffsetDateTime> MODIFIED_TIME = new Field<OffsetDateTime>("Modified_Time");

		public static final Field<List<PricingDetails>> PRICING_DETAILS = new Field<List<PricingDetails>>("Pricing_Details");

		public static final Field<String> DESCRIPTION = new Field<String>("Description");

		public static final Field<OffsetDateTime> CREATED_TIME = new Field<OffsetDateTime>("Created_Time");

		public static final Field<Choice<String>> RECORD_STATUS__S = new Field<Choice<String>>("Record_Status__s");

		public static final Field<MinifiedUser> MODIFIED_BY = new Field<MinifiedUser>("Modified_By");

		public static final Field<Boolean> ACTIVE = new Field<Boolean>("Active");

		public static final Field<Choice<String>> PRICING_MODEL = new Field<Choice<String>>("Pricing_Model");

		public static final Field<Boolean> LOCKED__S = new Field<Boolean>("Locked__s");

		public static final Field<String> PRICE_BOOK_NAME = new Field<String>("Price_Book_Name");

		public static final Field<MinifiedUser> CREATED_BY = new Field<MinifiedUser>("Created_By");

		public static final Field<String> TAG = new Field<String>("Tag");

		public static final Field<Long> ID = new Field<Long>("id");

	}

	public static class Sales_Orders
	{
		public static final Field<MinifiedUser> OWNER = new Field<MinifiedUser>("Owner");

		public static final Field<String> DESCRIPTION = new Field<String>("Description");

		public static final Field<Double> DISCOUNT = new Field<Double>("Discount");

		public static final Field<String> CUSTOMER_NO = new Field<String>("Customer_No");

		public static final Field<String> SHIPPING_STATE = new Field<String>("Shipping_State");

		public static final Field<Double> TAX = new Field<Double>("Tax");

		public static final Field<MinifiedUser> MODIFIED_BY = new Field<MinifiedUser>("Modified_By");

		public static final Field<Record> DEAL_NAME = new Field<Record>("Deal_Name");

		public static final Field<Double> EXCHANGE_RATE = new Field<Double>("Exchange_Rate");

		public static final Field<String> BILLING_COUNTRY = new Field<String>("Billing_Country");

		public static final Field<Choice<String>> CURRENCY = new Field<Choice<String>>("Currency");

		public static final Field<Record> ACCOUNT_NAME = new Field<Record>("Account_Name");

		public static final Field<Choice<String>> CARRIER = new Field<Choice<String>>("Carrier");

		public static final Field<Long> ID = new Field<Long>("id");

		public static final Field<List<Record>> ORDERED_ITEMS = new Field<List<Record>>("Ordered_Items");

		public static final Field<Record> QUOTE_NAME = new Field<Record>("Quote_Name");

		public static final Field<Choice<String>> STATUS = new Field<Choice<String>>("Status");

		public static final Field<Double> SALES_COMMISSION = new Field<Double>("Sales_Commission");

		public static final Field<OffsetDateTime> MODIFIED_TIME = new Field<OffsetDateTime>("Modified_Time");

		public static final Field<LocalDate> DUE_DATE = new Field<LocalDate>("Due_Date");

		public static final Field<Double> ADJUSTMENT = new Field<Double>("Adjustment");

		public static final Field<String> BILLING_STREET = new Field<String>("Billing_Street");

		public static final Field<OffsetDateTime> CREATED_TIME = new Field<OffsetDateTime>("Created_Time");

		public static final Field<String> TERMS_AND_CONDITIONS = new Field<String>("Terms_and_Conditions");

		public static final Field<Double> SUB_TOTAL = new Field<Double>("Sub_Total");

		public static final Field<String> BILLING_CODE = new Field<String>("Billing_Code");

		public static final Field<Choice<String>> RECORD_STATUS__S = new Field<Choice<String>>("Record_Status__s");

		public static final Field<String> SUBJECT = new Field<String>("Subject");

		public static final Field<Record> CONTACT_NAME = new Field<Record>("Contact_Name");

		public static final Field<Double> EXCISE_DUTY = new Field<Double>("Excise_Duty");

		public static final Field<String> SHIPPING_CITY = new Field<String>("Shipping_City");

		public static final Field<String> SHIPPING_COUNTRY = new Field<String>("Shipping_Country");

		public static final Field<String> SHIPPING_CODE = new Field<String>("Shipping_Code");

		public static final Field<String> BILLING_CITY = new Field<String>("Billing_City");

		public static final Field<String> SO_NUMBER = new Field<String>("SO_Number");

		public static final Field<Boolean> LOCKED__S = new Field<Boolean>("Locked__s");

		public static final Field<String> PURCHASE_ORDER = new Field<String>("Purchase_Order");

		public static final Field<String> BILLING_STATE = new Field<String>("Billing_State");

		public static final Field<MinifiedUser> CREATED_BY = new Field<MinifiedUser>("Created_By");

		public static final Field<String> TAG = new Field<String>("Tag");

		public static final Field<String> PENDING = new Field<String>("Pending");

		public static final Field<String> SHIPPING_STREET = new Field<String>("Shipping_Street");

	}

	public static class Services__s
	{
		public static final Field<Choice<String>> JOB_SHEET_REQUIRED = new Field<Choice<String>>("Job_Sheet_Required");

		public static final Field<MinifiedUser> OWNER = new Field<MinifiedUser>("Owner");

		public static final Field<String> DESCRIPTION = new Field<String>("Description");

		public static final Field<List<Choice<String>>> AVAILABLE_DAYS = new Field<List<Choice<String>>>("Available_Days");

		public static final Field<List<Choice<String>>> TAX = new Field<List<Choice<String>>>("Tax");

		public static final Field<OffsetDateTime> UNAVAILABLE_FROM = new Field<OffsetDateTime>("Unavailable_From");

		public static final Field<String> RECORD_IMAGE = new Field<String>("Record_Image");

		public static final Field<MinifiedUser> MODIFIED_BY = new Field<MinifiedUser>("Modified_By");

		public static final Field<Long> ID = new Field<Long>("id");

		public static final Field<LocalDate> AVAILABLE_DATES = new Field<LocalDate>("Available_Dates");

		public static final Field<Choice<String>> STATUS = new Field<Choice<String>>("Status");

		public static final Field<OffsetDateTime> MODIFIED_TIME = new Field<OffsetDateTime>("Modified_Time");

		public static final Field<List<TimeRange>> AVAILABLE_TIMINGS = new Field<List<TimeRange>>("Available_Timings");

		public static final Field<String> SERVICE_NAME = new Field<String>("Service_Name");

		public static final Field<LocalDate> AVAILABLE_FROM = new Field<LocalDate>("Available_From");

		public static final Field<OffsetDateTime> CREATED_TIME = new Field<OffsetDateTime>("Created_Time");

		public static final Field<LocalDate> AVAILABLE_TILL = new Field<LocalDate>("Available_Till");

		public static final Field<Integer> DURATION = new Field<Integer>("Duration");

		public static final Field<Choice<String>> JOB_SHEET_SECTION__S = new Field<Choice<String>>("Job_Sheet_Section__s");

		public static final Field<Choice<String>> RECORD_STATUS__S = new Field<Choice<String>>("Record_Status__s");

		public static final Field<Double> PRICE = new Field<Double>("Price");

		public static final Field<MinifiedUser> CREATED_BY = new Field<MinifiedUser>("Created_By");

		public static final Field<String> TAG = new Field<String>("Tag");

		public static final Field<Choice<String>> AVAILABILITY_TYPE = new Field<Choice<String>>("Availability_Type");

		public static final Field<List<Record>> MEMBERS = new Field<List<Record>>("Members");

		public static final Field<Choice<String>> LOCATION = new Field<Choice<String>>("Location");

		public static final Field<OffsetDateTime> UNAVAILABLE_TILL = new Field<OffsetDateTime>("Unavailable_Till");

	}

	public static class Contacts
	{
		public static final Field<MinifiedUser> OWNER = new Field<MinifiedUser>("Owner");

		public static final Field<String> EMAIL = new Field<String>("Email");

		public static final Field<Long> VISITOR_SCORE = new Field<Long>("Visitor_Score");

		public static final Field<String> OTHER_PHONE = new Field<String>("Other_Phone");

		public static final Field<String> MAILING_STATE = new Field<String>("Mailing_State");

		public static final Field<String> OTHER_STATE = new Field<String>("Other_State");

		public static final Field<String> OTHER_COUNTRY = new Field<String>("Other_Country");

		public static final Field<OffsetDateTime> LAST_ACTIVITY_TIME = new Field<OffsetDateTime>("Last_Activity_Time");

		public static final Field<String> DEPARTMENT = new Field<String>("Department");

		public static final Field<Choice<String>> UNSUBSCRIBED_MODE = new Field<Choice<String>>("Unsubscribed_Mode");

		public static final Field<String> ASSISTANT = new Field<String>("Assistant");

		public static final Field<String> MAILING_COUNTRY = new Field<String>("Mailing_Country");

		public static final Field<Consent> DATA_PROCESSING_BASIS_DETAILS = new Field<Consent>("Data_Processing_Basis_Details");

		public static final Field<Long> ID = new Field<Long>("id");

		public static final Field<Choice<String>> DATA_SOURCE = new Field<Choice<String>>("Data_Source");

		public static final Field<Record> REPORTING_TO = new Field<Record>("Reporting_To");

		public static final Field<Choice<String>> ENRICH_STATUS__S = new Field<Choice<String>>("Enrich_Status__s");

		public static final Field<String> FIRST_VISITED_URL = new Field<String>("First_Visited_URL");

		public static final Field<Integer> DAYS_VISITED = new Field<Integer>("Days_Visited");

		public static final Field<String> OTHER_CITY = new Field<String>("Other_City");

		public static final Field<OffsetDateTime> CREATED_TIME = new Field<OffsetDateTime>("Created_Time");

		public static final Field<OffsetDateTime> CHANGE_LOG_TIME__S = new Field<OffsetDateTime>("Change_Log_Time__s");

		public static final Field<Choice<String>> DATA_PROCESSING_BASIS = new Field<Choice<String>>("Data_Processing_Basis");

		public static final Field<String> HOME_PHONE = new Field<String>("Home_Phone");

		public static final Field<OffsetDateTime> LAST_VISITED_TIME = new Field<OffsetDateTime>("Last_Visited_Time");

		public static final Field<MinifiedUser> CREATED_BY = new Field<MinifiedUser>("Created_By");

		public static final Field<String> SECONDARY_EMAIL = new Field<String>("Secondary_Email");

		public static final Field<String> DESCRIPTION = new Field<String>("Description");

		public static final Field<Record> VENDOR_NAME = new Field<Record>("Vendor_Name");

		public static final Field<String> MAILING_ZIP = new Field<String>("Mailing_Zip");

		public static final Field<String> REPORTS_TO = new Field<String>("Reports_To");

		public static final Field<Integer> NUMBER_OF_CHATS = new Field<Integer>("Number_Of_Chats");

		public static final Field<String> OTHER_ZIP = new Field<String>("Other_Zip");

		public static final Field<String> TWITTER = new Field<String>("Twitter");

		public static final Field<String> MAILING_STREET = new Field<String>("Mailing_Street");

		public static final Field<Double> AVERAGE_TIME_SPENT_MINUTES = new Field<Double>("Average_Time_Spent_Minutes");

		public static final Field<Choice<String>> SALUTATION = new Field<Choice<String>>("Salutation");

		public static final Field<String> FIRST_NAME = new Field<String>("First_Name");

		public static final Field<String> ASST_PHONE = new Field<String>("Asst_Phone");

		public static final Field<String> FULL_NAME = new Field<String>("Full_Name");

		public static final Field<String> RECORD_IMAGE = new Field<String>("Record_Image");

		public static final Field<MinifiedUser> MODIFIED_BY = new Field<MinifiedUser>("Modified_By");

		public static final Field<String> SKYPE_ID = new Field<String>("Skype_ID");

		public static final Field<String> PHONE = new Field<String>("Phone");

		public static final Field<Record> ACCOUNT_NAME = new Field<Record>("Account_Name");

		public static final Field<Boolean> EMAIL_OPT_OUT = new Field<Boolean>("Email_Opt_Out");

		public static final Field<OffsetDateTime> MODIFIED_TIME = new Field<OffsetDateTime>("Modified_Time");

		public static final Field<LocalDate> DATE_OF_BIRTH = new Field<LocalDate>("Date_of_Birth");

		public static final Field<String> MAILING_CITY = new Field<String>("Mailing_City");

		public static final Field<OffsetDateTime> UNSUBSCRIBED_TIME = new Field<OffsetDateTime>("Unsubscribed_Time");

		public static final Field<String> TITLE = new Field<String>("Title");

		public static final Field<String> OTHER_STREET = new Field<String>("Other_Street");

		public static final Field<String> MOBILE = new Field<String>("Mobile");

		public static final Field<List<Territory>> TERRITORIES = new Field<List<Territory>>("Territories");

		public static final Field<Choice<String>> RECORD_STATUS__S = new Field<Choice<String>>("Record_Status__s");

		public static final Field<OffsetDateTime> FIRST_VISITED_TIME = new Field<OffsetDateTime>("First_Visited_Time");

		public static final Field<String> LAST_NAME = new Field<String>("Last_Name");

		public static final Field<String> REFERRER = new Field<String>("Referrer");

		public static final Field<Boolean> LOCKED__S = new Field<Boolean>("Locked__s");

		public static final Field<Choice<String>> LEAD_SOURCE = new Field<Choice<String>>("Lead_Source");

		public static final Field<String> TAG = new Field<String>("Tag");

		public static final Field<String> FAX = new Field<String>("Fax");

		public static final Field<OffsetDateTime> LAST_ENRICHED_TIME__S = new Field<OffsetDateTime>("Last_Enriched_Time__s");

	}

	public static class Solutions
	{
		public static final Field<Choice<String>> STATUS = new Field<Choice<String>>("Status");

		public static final Field<MinifiedUser> OWNER = new Field<MinifiedUser>("Owner");

		public static final Field<OffsetDateTime> MODIFIED_TIME = new Field<OffsetDateTime>("Modified_Time");

		public static final Field<OffsetDateTime> CREATED_TIME = new Field<OffsetDateTime>("Created_Time");

		public static final Field<List<Comment>> COMMENTS = new Field<List<Comment>>("Comments");

		public static final Field<Integer> NO_OF_COMMENTS = new Field<Integer>("No_of_comments");

		public static final Field<Record> PRODUCT_NAME = new Field<Record>("Product_Name");

		public static final Field<String> ADD_COMMENT = new Field<String>("Add_Comment");

		public static final Field<Choice<String>> RECORD_STATUS__S = new Field<Choice<String>>("Record_Status__s");

		public static final Field<String> SOLUTION_NUMBER = new Field<String>("Solution_Number");

		public static final Field<String> ANSWER = new Field<String>("Answer");

		public static final Field<MinifiedUser> MODIFIED_BY = new Field<MinifiedUser>("Modified_By");

		public static final Field<String> SOLUTION_TITLE = new Field<String>("Solution_Title");

		public static final Field<Boolean> LOCKED__S = new Field<Boolean>("Locked__s");

		public static final Field<Boolean> PUBLISHED = new Field<Boolean>("Published");

		public static final Field<String> QUESTION = new Field<String>("Question");

		public static final Field<MinifiedUser> CREATED_BY = new Field<MinifiedUser>("Created_By");

		public static final Field<String> TAG = new Field<String>("Tag");

		public static final Field<Long> ID = new Field<Long>("id");

	}

	public static class Events
	{
		public static final Field<Boolean> ALL_DAY = new Field<Boolean>("All_day");

		public static final Field<MinifiedUser> OWNER = new Field<MinifiedUser>("Owner");

		public static final Field<String> CHECK_IN_STATE = new Field<String>("Check_In_State");

		public static final Field<String> CHECK_IN_ADDRESS = new Field<String>("Check_In_Address");

		public static final Field<String> DESCRIPTION = new Field<String>("Description");

		public static final Field<List<Reminder>> REMIND_PARTICIPANTS = new Field<List<Reminder>>("Remind_Participants");

		public static final Field<OffsetDateTime> START_DATETIME = new Field<OffsetDateTime>("Start_DateTime");

		public static final Field<Double> LATITUDE = new Field<Double>("Latitude");

		public static final Field<List<Participants>> PARTICIPANTS = new Field<List<Participants>>("Participants");

		public static final Field<String> EVENT_TITLE = new Field<String>("Event_Title");

		public static final Field<MinifiedUser> CHECK_IN_BY = new Field<MinifiedUser>("Check_In_By");

		public static final Field<OffsetDateTime> END_DATETIME = new Field<OffsetDateTime>("End_DateTime");

		public static final Field<MinifiedUser> MODIFIED_BY = new Field<MinifiedUser>("Modified_By");

		public static final Field<String> CHECK_IN_CITY = new Field<String>("Check_In_City");

		public static final Field<Long> ID = new Field<Long>("id");

		public static final Field<String> CHECK_IN_COMMENT = new Field<String>("Check_In_Comment");

		public static final Field<List<Reminder>> REMIND_AT = new Field<List<Reminder>>("Remind_At");

		public static final Field<Record> WHO_ID = new Field<Record>("Who_Id");

		public static final Field<String> CHECK_IN_STATUS = new Field<String>("Check_In_Status");

		public static final Field<String> CHECK_IN_COUNTRY = new Field<String>("Check_In_Country");

		public static final Field<OffsetDateTime> MODIFIED_TIME = new Field<OffsetDateTime>("Modified_Time");

		public static final Field<String> VENUE = new Field<String>("Venue");

		public static final Field<String> ZIP_CODE = new Field<String>("ZIP_Code");

		public static final Field<OffsetDateTime> CREATED_TIME = new Field<OffsetDateTime>("Created_Time");

		public static final Field<Double> LONGITUDE = new Field<Double>("Longitude");

		public static final Field<Choice<String>> RECORD_STATUS__S = new Field<Choice<String>>("Record_Status__s");

		public static final Field<OffsetDateTime> CHECK_IN_TIME = new Field<OffsetDateTime>("Check_In_Time");

		public static final Field<RecurringActivity> RECURRING_ACTIVITY = new Field<RecurringActivity>("Recurring_Activity");

		public static final Field<Record> WHAT_ID = new Field<Record>("What_Id");

		public static final Field<String> CHECK_IN_SUB_LOCALITY = new Field<String>("Check_In_Sub_Locality");

		public static final Field<MinifiedUser> CREATED_BY = new Field<MinifiedUser>("Created_By");

		public static final Field<String> TAG = new Field<String>("Tag");

	}

	public static class Purchase_Orders
	{
		public static final Field<MinifiedUser> OWNER = new Field<MinifiedUser>("Owner");

		public static final Field<String> DESCRIPTION = new Field<String>("Description");

		public static final Field<Double> DISCOUNT = new Field<Double>("Discount");

		public static final Field<Record> VENDOR_NAME = new Field<Record>("Vendor_Name");

		public static final Field<String> SHIPPING_STATE = new Field<String>("Shipping_State");

		public static final Field<Double> TAX = new Field<Double>("Tax");

		public static final Field<LocalDate> PO_DATE = new Field<LocalDate>("PO_Date");

		public static final Field<MinifiedUser> MODIFIED_BY = new Field<MinifiedUser>("Modified_By");

		public static final Field<Double> EXCHANGE_RATE = new Field<Double>("Exchange_Rate");

		public static final Field<String> BILLING_COUNTRY = new Field<String>("Billing_Country");

		public static final Field<Choice<String>> CURRENCY = new Field<Choice<String>>("Currency");

		public static final Field<List<Record>> PURCHASE_ITEMS = new Field<List<Record>>("Purchase_Items");

		public static final Field<Choice<String>> CARRIER = new Field<Choice<String>>("Carrier");

		public static final Field<Long> ID = new Field<Long>("id");

		public static final Field<Choice<String>> STATUS = new Field<Choice<String>>("Status");

		public static final Field<Double> SALES_COMMISSION = new Field<Double>("Sales_Commission");

		public static final Field<Double> GRAND_TOTAL = new Field<Double>("Grand_Total");

		public static final Field<OffsetDateTime> MODIFIED_TIME = new Field<OffsetDateTime>("Modified_Time");

		public static final Field<String> PO_NUMBER = new Field<String>("PO_Number");

		public static final Field<LocalDate> DUE_DATE = new Field<LocalDate>("Due_Date");

		public static final Field<Double> ADJUSTMENT = new Field<Double>("Adjustment");

		public static final Field<String> BILLING_STREET = new Field<String>("Billing_Street");

		public static final Field<OffsetDateTime> CREATED_TIME = new Field<OffsetDateTime>("Created_Time");

		public static final Field<String> TERMS_AND_CONDITIONS = new Field<String>("Terms_and_Conditions");

		public static final Field<Double> SUB_TOTAL = new Field<Double>("Sub_Total");

		public static final Field<String> BILLING_CODE = new Field<String>("Billing_Code");

		public static final Field<Choice<String>> RECORD_STATUS__S = new Field<Choice<String>>("Record_Status__s");

		public static final Field<String> SUBJECT = new Field<String>("Subject");

		public static final Field<String> TRACKING_NUMBER = new Field<String>("Tracking_Number");

		public static final Field<Record> CONTACT_NAME = new Field<Record>("Contact_Name");

		public static final Field<Double> EXCISE_DUTY = new Field<Double>("Excise_Duty");

		public static final Field<String> SHIPPING_CITY = new Field<String>("Shipping_City");

		public static final Field<String> SHIPPING_COUNTRY = new Field<String>("Shipping_Country");

		public static final Field<String> SHIPPING_CODE = new Field<String>("Shipping_Code");

		public static final Field<String> BILLING_CITY = new Field<String>("Billing_City");

		public static final Field<String> REQUISITION_NO = new Field<String>("Requisition_No");

		public static final Field<Boolean> LOCKED__S = new Field<Boolean>("Locked__s");

		public static final Field<String> BILLING_STATE = new Field<String>("Billing_State");

		public static final Field<MinifiedUser> CREATED_BY = new Field<MinifiedUser>("Created_By");

		public static final Field<String> TAG = new Field<String>("Tag");

		public static final Field<String> SHIPPING_STREET = new Field<String>("Shipping_Street");

	}

	public static class Accounts
	{
		public static final Field<MinifiedUser> OWNER = new Field<MinifiedUser>("Owner");

		public static final Field<Choice<String>> OWNERSHIP = new Field<Choice<String>>("Ownership");

		public static final Field<String> DESCRIPTION = new Field<String>("Description");

		public static final Field<Choice<String>> ACCOUNT_TYPE = new Field<Choice<String>>("Account_Type");

		public static final Field<Choice<String>> RATING = new Field<Choice<String>>("Rating");

		public static final Field<Integer> SIC_CODE = new Field<Integer>("SIC_Code");

		public static final Field<String> SHIPPING_STATE = new Field<String>("Shipping_State");

		public static final Field<String> WEBSITE = new Field<String>("Website");

		public static final Field<Integer> EMPLOYEES = new Field<Integer>("Employees");

		public static final Field<OffsetDateTime> LAST_ACTIVITY_TIME = new Field<OffsetDateTime>("Last_Activity_Time");

		public static final Field<Choice<String>> INDUSTRY = new Field<Choice<String>>("Industry");

		public static final Field<String> RECORD_IMAGE = new Field<String>("Record_Image");

		public static final Field<MinifiedUser> MODIFIED_BY = new Field<MinifiedUser>("Modified_By");

		public static final Field<String> ACCOUNT_SITE = new Field<String>("Account_Site");

		public static final Field<Double> EXCHANGE_RATE = new Field<Double>("Exchange_Rate");

		public static final Field<String> PHONE = new Field<String>("Phone");

		public static final Field<String> BILLING_COUNTRY = new Field<String>("Billing_Country");

		public static final Field<Choice<String>> CURRENCY = new Field<Choice<String>>("Currency");

		public static final Field<String> ACCOUNT_NAME = new Field<String>("Account_Name");

		public static final Field<Long> ID = new Field<Long>("id");

		public static final Field<Long> ACCOUNT_NUMBER = new Field<Long>("Account_Number");

		public static final Field<String> TICKER_SYMBOL = new Field<String>("Ticker_Symbol");

		public static final Field<OffsetDateTime> MODIFIED_TIME = new Field<OffsetDateTime>("Modified_Time");

		public static final Field<String> BILLING_STREET = new Field<String>("Billing_Street");

		public static final Field<Choice<String>> ENRICH_STATUS__S = new Field<Choice<String>>("Enrich_Status__s");

		public static final Field<OffsetDateTime> CREATED_TIME = new Field<OffsetDateTime>("Created_Time");

		public static final Field<OffsetDateTime> CHANGE_LOG_TIME__S = new Field<OffsetDateTime>("Change_Log_Time__s");

		public static final Field<String> BILLING_CODE = new Field<String>("Billing_Code");

		public static final Field<List<Territory>> TERRITORIES = new Field<List<Territory>>("Territories");

		public static final Field<Choice<String>> RECORD_STATUS__S = new Field<Choice<String>>("Record_Status__s");

		public static final Field<Record> PARENT_ACCOUNT = new Field<Record>("Parent_Account");

		public static final Field<String> SHIPPING_CITY = new Field<String>("Shipping_City");

		public static final Field<String> SHIPPING_COUNTRY = new Field<String>("Shipping_Country");

		public static final Field<String> SHIPPING_CODE = new Field<String>("Shipping_Code");

		public static final Field<String> BILLING_CITY = new Field<String>("Billing_City");

		public static final Field<Boolean> LOCKED__S = new Field<Boolean>("Locked__s");

		public static final Field<String> BILLING_STATE = new Field<String>("Billing_State");

		public static final Field<MinifiedUser> CREATED_BY = new Field<MinifiedUser>("Created_By");

		public static final Field<String> TAG = new Field<String>("Tag");

		public static final Field<String> FAX = new Field<String>("Fax");

		public static final Field<Double> ANNUAL_REVENUE = new Field<Double>("Annual_Revenue");

		public static final Field<OffsetDateTime> LAST_ENRICHED_TIME__S = new Field<OffsetDateTime>("Last_Enriched_Time__s");

		public static final Field<String> SHIPPING_STREET = new Field<String>("Shipping_Street");

	}

	public static class Cases
	{
		public static final Field<MinifiedUser> OWNER = new Field<MinifiedUser>("Owner");

		public static final Field<String> EMAIL = new Field<String>("Email");

		public static final Field<String> DESCRIPTION = new Field<String>("Description");

		public static final Field<String> INTERNAL_COMMENTS = new Field<String>("Internal_Comments");

		public static final Field<Integer> NO_OF_COMMENTS = new Field<Integer>("No_of_comments");

		public static final Field<String> REPORTED_BY = new Field<String>("Reported_By");

		public static final Field<String> CASE_NUMBER = new Field<String>("Case_Number");

		public static final Field<MinifiedUser> MODIFIED_BY = new Field<MinifiedUser>("Modified_By");

		public static final Field<Record> DEAL_NAME = new Field<Record>("Deal_Name");

		public static final Field<String> PHONE = new Field<String>("Phone");

		public static final Field<Record> ACCOUNT_NAME = new Field<Record>("Account_Name");

		public static final Field<Long> ID = new Field<Long>("id");

		public static final Field<String> SOLUTION = new Field<String>("Solution");

		public static final Field<Choice<String>> STATUS = new Field<Choice<String>>("Status");

		public static final Field<OffsetDateTime> MODIFIED_TIME = new Field<OffsetDateTime>("Modified_Time");

		public static final Field<Choice<String>> PRIORITY = new Field<Choice<String>>("Priority");

		public static final Field<OffsetDateTime> CREATED_TIME = new Field<OffsetDateTime>("Created_Time");

		public static final Field<List<Comment>> COMMENTS = new Field<List<Comment>>("Comments");

		public static final Field<Record> PRODUCT_NAME = new Field<Record>("Product_Name");

		public static final Field<String> ADD_COMMENT = new Field<String>("Add_Comment");

		public static final Field<Choice<String>> CASE_ORIGIN = new Field<Choice<String>>("Case_Origin");

		public static final Field<Choice<String>> RECORD_STATUS__S = new Field<Choice<String>>("Record_Status__s");

		public static final Field<Choice<String>> CASE_REASON = new Field<Choice<String>>("Case_Reason");

		public static final Field<String> SUBJECT = new Field<String>("Subject");

		public static final Field<Choice<String>> TYPE = new Field<Choice<String>>("Type");

		public static final Field<Boolean> LOCKED__S = new Field<Boolean>("Locked__s");

		public static final Field<MinifiedUser> CREATED_BY = new Field<MinifiedUser>("Created_By");

		public static final Field<String> TAG = new Field<String>("Tag");

		public static final Field<Record> RELATED_TO = new Field<Record>("Related_To");

	}

	public static class Notes
	{
		public static final Field<MinifiedUser> OWNER = new Field<MinifiedUser>("Owner");

		public static final Field<MinifiedUser> MODIFIED_BY = new Field<MinifiedUser>("Modified_By");

		public static final Field<OffsetDateTime> MODIFIED_TIME = new Field<OffsetDateTime>("Modified_Time");

		public static final Field<OffsetDateTime> CREATED_TIME = new Field<OffsetDateTime>("Created_Time");

		public static final Field<Record> PARENT_ID = new Field<Record>("Parent_Id");

		public static final Field<Long> ASSOCIATED_ID__S = new Field<Long>("Associated_Id__s");

		public static final Field<MinifiedUser> CREATED_BY = new Field<MinifiedUser>("Created_By");

		public static final Field<Long> ID = new Field<Long>("id");

		public static final Field<String> NOTE_TITLE = new Field<String>("Note_Title");

		public static final Field<String> NOTE_CONTENT = new Field<String>("Note_Content");

		public static final Field<Choice<String>> RECORD_STATUS__S = new Field<Choice<String>>("Record_Status__s");

	}
}