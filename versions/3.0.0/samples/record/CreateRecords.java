package samples.record;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.HeaderMap;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.record.APIException;
import com.zoho.crm.api.record.ActionHandler;
import com.zoho.crm.api.record.ActionResponse;
import com.zoho.crm.api.record.ActionWrapper;
import com.zoho.crm.api.record.BodyWrapper;
import com.zoho.crm.api.record.Consent;
import com.zoho.crm.api.record.Field;
import com.zoho.crm.api.record.FileDetails;
import com.zoho.crm.api.record.LineItemProduct;
import com.zoho.crm.api.record.LineTax;
import com.zoho.crm.api.record.Participants;
import com.zoho.crm.api.record.PricingDetails;
import com.zoho.crm.api.record.RecordOperations;
import com.zoho.crm.api.record.RecurringActivity;
import com.zoho.crm.api.record.RemindAt;
import com.zoho.crm.api.record.Reminder;
import com.zoho.crm.api.record.SuccessResponse;
import com.zoho.crm.api.tags.Tag;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CreateRecords
{
	public static void createRecords(String moduleAPIName) throws Exception
	{
		RecordOperations recordOperations = new RecordOperations(moduleAPIName);
		BodyWrapper bodyWrapper = new BodyWrapper();
		List<com.zoho.crm.api.record.Record> records = new ArrayList<com.zoho.crm.api.record.Record>();
		com.zoho.crm.api.record.Record record1 = new com.zoho.crm.api.record.Record();

		/*
		 * Call addFieldValue method that takes two arguments 1 -> Call Field "." and choose the module from the displayed list and press "." and choose the field name from the displayed list. 2 -> Value
		 */
		record1.addFieldValue(Field.Leads.LAST_NAME, "Last Name");
		record1.addFieldValue(Field.Leads.FIRST_NAME, "First Name");
		record1.addFieldValue(Field.Leads.COMPANY, "Company Name");
		record1.addFieldValue(Field.Leads.ANNUAL_REVENUE, 1221.2);
		record1.addFieldValue(Field.Leads.LEAD_STATUS, new Choice<String>("Not Contacted"));

		/** Following methods are being used only by Inventory modules */
		com.zoho.crm.api.record.Record dealName = new com.zoho.crm.api.record.Record();
		dealName.addFieldValue(Field.Deals.ID, 347706111383007l);
		record1.addFieldValue(Field.Sales_Orders.DEAL_NAME, dealName);
		com.zoho.crm.api.record.Record contactName = new com.zoho.crm.api.record.Record();
		contactName.addFieldValue(Field.Contacts.ID, 347706111853001l);
		record1.addFieldValue(Field.Purchase_Orders.CONTACT_NAME, contactName);
		com.zoho.crm.api.record.Record accountName = new com.zoho.crm.api.record.Record();
		accountName.addKeyValue("name", "automatedAccount");
		record1.addFieldValue(Field.Quotes.ACCOUNT_NAME, accountName);
		record1.addFieldValue(Field.Sales_Orders.ACCOUNT_NAME, null);
		ArrayList<com.zoho.crm.api.record.Record> inventoryLineItemList = new ArrayList<com.zoho.crm.api.record.Record>();
		com.zoho.crm.api.record.Record inventoryLineItem = new com.zoho.crm.api.record.Record();
		LineItemProduct lineItemProduct = new LineItemProduct();
		lineItemProduct.setId(440248954344L);
		lineItemProduct.addKeyValue("Products_External", "ProductExternal");
		inventoryLineItem.addKeyValue("Description", "asd");
		inventoryLineItem.addKeyValue("Discount", "5");
		record1.addKeyValue("Singleline", "customField");
		inventoryLineItem.addKeyValue("Desc", "customField");
		com.zoho.crm.api.record.Record parentId = new com.zoho.crm.api.record.Record();
		parentId.setId(35240337331017L);
		inventoryLineItem.addKeyValue("Parent_Id", parentId);
		record1.addFieldValue(Field.Quotes.SUBJECT, "new Quote");
		LineItemProduct lineitemProduct = new LineItemProduct();
		lineitemProduct.setId(440248954344L);
		inventoryLineItem.addKeyValue("Product_Name", lineitemProduct);
		inventoryLineItem.addKeyValue("Sequence_Number", 2l);
		inventoryLineItem.addKeyValue("Quantity", 123.2);
		inventoryLineItem.addKeyValue("Tax", 123.2);
		inventoryLineItemList.add(inventoryLineItem);
		List<LineTax> productLineTaxes = new ArrayList<LineTax>();
		LineTax productLineTax = new LineTax();
		productLineTax.setName("MyTax1134");
		productLineTax.setValue(0.0);
		productLineTax.setId(347706110743003l);
		productLineTax.setPercentage(15.0);
		productLineTaxes.add(productLineTax);
		inventoryLineItem.addKeyValue("Line_Tax", productLineTaxes);
		inventoryLineItemList.add(inventoryLineItem);
		record1.addKeyValue("Quoted_Items", inventoryLineItemList);
		List<LineTax> lineTaxes = new ArrayList<LineTax>();
		LineTax lineTax = new LineTax();
		lineTax.setName("MyTax1134");
		lineTax.setPercentage(20.0);
		lineTaxes.add(lineTax);
		record1.addKeyValue("$line_tax", lineTaxes);
		/** End Inventory **/

		/** Following methods are being used only by Activity modules */
		//Tasks
		record1.addFieldValue(Field.Tasks.DESCRIPTION, "Test Task");
		record1.addKeyValue("Currency", new Choice<String>("INR"));
		RemindAt remindAt = new RemindAt();
		remindAt.setAlarm("ACTION=EMAILANDPOPUP;TRIGGER=DATE-TIME:2020-07-03T12:30:00+05:30");
		record1.addFieldValue(Field.Tasks.REMIND_AT, remindAt);
		com.zoho.crm.api.record.Record whoId = new com.zoho.crm.api.record.Record();
		whoId.setId(34770614977055L);
		record1.addFieldValue(Field.Tasks.WHO_ID, whoId);
		record1.addFieldValue(Field.Tasks.STATUS, new Choice<String>("Waiting on someone else"));
		record1.addFieldValue(Field.Tasks.DUE_DATE, LocalDate.of(2021, 1, 13));
		record1.addFieldValue(Field.Tasks.PRIORITY, new Choice<String>("High"));
		record1.addFieldValue(Field.Tasks.SUBJECT, "Email1");
		record1.addKeyValue("$se_module", "Accounts");
		com.zoho.crm.api.record.Record whatId = new com.zoho.crm.api.record.Record();
		whatId.setId(3477061207118L);
		record1.addFieldValue(Field.Tasks.WHAT_ID, whatId);

		/** Recurring Activity can be provided in any activity module */
		RecurringActivity recurringActivity = new RecurringActivity();
		recurringActivity.setRrule("FREQ=DAILY;INTERVAL=10;UNTIL=2023-08-14;DTSTART=2020-07-03");
		record1.addFieldValue(Field.Events.RECURRING_ACTIVITY, recurringActivity);

		// Events
		record1.addFieldValue(Field.Events.DESCRIPTION, "Test Events");
		OffsetDateTime startDateTime = OffsetDateTime.of(2020, 01, 02, 10, 00, 00, 00, ZoneOffset.of("+05:30"));
		record1.addFieldValue(Field.Events.START_DATETIME, startDateTime);
		List<Participants> participants = new ArrayList<Participants>();
		Participants participant1 = new Participants();
		participant1.setEmail("abc@zoho.com");
		participant1.setType("email");
		participant1.setId(34770615902017L);
		participants.add(participant1);
		Participants participant2 = new Participants();
		participant2.addKeyValue("participant", "34770617425");
		participant2.addKeyValue("type", "lead");
		participants.add(participant2);
		record1.addFieldValue(Field.Events.PARTICIPANTS, participants);
		record1.addKeyValue("$send_notification", true);
		record1.addFieldValue(Field.Events.EVENT_TITLE, "New Automated Event");
		OffsetDateTime enddatetime = OffsetDateTime.of(2020, 05, 02, 10, 00, 00, 00, ZoneOffset.of("+05:30"));
		record1.addFieldValue(Field.Events.END_DATETIME, enddatetime);
		ArrayList<Reminder> reminderList = new ArrayList<Reminder>();
		Reminder remindAt1 = new Reminder();
		remindAt1.setPeriod("minutes");
		remindAt1.setUnit(15);
		reminderList.add(remindAt1);
		remindAt1 = new Reminder();
		remindAt1.setPeriod("days");
		remindAt1.setUnit(1);
		remindAt1.setTime("10.30");
		reminderList.add(remindAt1);
		record1.addFieldValue(Field.Events.REMIND_AT, reminderList);
		record1.addFieldValue(Field.Events.CHECK_IN_STATUS, "PLANNED");
		record1.addKeyValue("$se_module", "Leads");
		com.zoho.crm.api.record.Record whatId1 = new com.zoho.crm.api.record.Record();
		whatId1.setId(34770614381002L);
		record1.addFieldValue(Field.Events.WHAT_ID, whatId1);
		record1.addKeyValue("Currency", new Choice<String>("USD"));
		/** End Activity **/

		/** Following methods are being used only by Price_Books modules */
		List<PricingDetails> pricingDetails = new ArrayList<PricingDetails>();
		PricingDetails pricingDetail1 = new PricingDetails();
		pricingDetail1.setFromRange(1.0);
		pricingDetail1.setToRange(5.0);
		pricingDetail1.setDiscount(2.0);
		pricingDetails.add(pricingDetail1);
		PricingDetails pricingDetail2 = new PricingDetails();
		pricingDetail2.addKeyValue("from_range", 6.0);
		pricingDetail2.addKeyValue("to_range", 11.0);
		pricingDetail2.addKeyValue("discount", 3.0);
		pricingDetails.add(pricingDetail2);
		record1.addFieldValue(Field.Price_Books.PRICING_DETAILS, pricingDetails);
		record1.addKeyValue("Email", "abc.d@zoho.com");
		record1.addFieldValue(Field.Price_Books.DESCRIPTION, "TEST");
		record1.addFieldValue(Field.Price_Books.PRICE_BOOK_NAME, "book_name");
		record1.addFieldValue(Field.Price_Books.PRICING_MODEL, new Choice<String>("Flat"));
		
		// Used when GDPR is enabled
		Consent dataConsent = new Consent();
		dataConsent.setConsentRemarks("Approved.");
		dataConsent.setConsentThrough("Email");
		dataConsent.setContactThroughEmail(true);
		dataConsent.setContactThroughSocial(false);
		dataConsent.setContactThroughPhone(true);
		dataConsent.setContactThroughSurvey(true);
		dataConsent.setConsentDate(LocalDate.of(2023, 10, 11));
		dataConsent.setDataProcessingBasis("Obtained");
		record1.addKeyValue("Data_Processing_Basis_Details", dataConsent);

		/*
		 * Call addKeyValue method that takes two arguments 1 -> A string that is the Field's API Name 2 -> Value
		 */
		record1.addKeyValue("External", "Value12345");
		record1.addKeyValue("Custom_field", "Value");
		record1.addKeyValue("Date_Time_2", OffsetDateTime.of(2023, 11, 20, 10, 00, 01, 00, ZoneOffset.of("+05:30")));
		record1.addKeyValue("Date_1", LocalDate.of(2021, 1, 13));
		record1.addKeyValue("Subject", "AutomatedSDK");
		record1.addKeyValue("Product_Name", "AutomatedSDK");
		List<FileDetails> fileDetails = new ArrayList<FileDetails>();
		FileDetails fileDetail1 = new FileDetails();
		fileDetail1.setFileIdS("ae9c7cefa418aec1d6a5cc2d9ab35c32a6ae23bd44183d280");
		fileDetails.add(fileDetail1);
		FileDetails fileDetail2 = new FileDetails();
		fileDetail2.setFileIdS("ae9c7cefa418aec1d6a5cc27321b5b4ca878a934519e6cdb2");
		fileDetails.add(fileDetail2);
		record1.addKeyValue("File_Upload", fileDetails);
		// for Custom User LookUp
		com.zoho.crm.api.users.MinifiedUser user = new com.zoho.crm.api.users.MinifiedUser();
		user.setId(440248254001L);
		record1.addKeyValue("User_1", user);
		record1.addKeyValue("new", OffsetDateTime.now());
		// for Custom LookUp
		com.zoho.crm.api.record.Record data = new com.zoho.crm.api.record.Record();
		data.setId(440248774074L);
		record1.addKeyValue("Lookup_2", data);
		// for Custom pickList
		record1.addKeyValue("pick", new Choice<String>("true"));
		// for Custom MultiSelect
		record1.addKeyValue("Multiselect", new ArrayList<>(Arrays.asList(new Choice<String>("Option 1"), new Choice<String>("Option 2"))));
		// Subform sample code
		List<com.zoho.crm.api.record.Record> subformList = new ArrayList<com.zoho.crm.api.record.Record>();
		com.zoho.crm.api.record.Record subform = new com.zoho.crm.api.record.Record();
		subform.addKeyValue("customfield", "customvalue");
		com.zoho.crm.api.users.MinifiedUser user1 = new com.zoho.crm.api.users.MinifiedUser();
		user1.setId(440248254001L);
		subform.addKeyValue("Userfield", user1);
		subformList.add(subform);
		record1.addKeyValue("Subform_2", subformList);
		// sample code for MultiSelectLookUp Field
		List<com.zoho.crm.api.record.Record> Multirecords = new ArrayList<>();
		com.zoho.crm.api.record.Record record = new com.zoho.crm.api.record.Record();
		com.zoho.crm.api.record.Record linkingRecord = new com.zoho.crm.api.record.Record();
		record.addKeyValue("id", 440248884001L);
		linkingRecord.addKeyValue("Msl", record);
		Multirecords.add(linkingRecord);
		record1.addKeyValue("Msl", Multirecords);

		List<Tag> tagList = new ArrayList<Tag>();
		Tag tag = new Tag();
		tag.setName("Testtask");
		tagList.add(tag);
		record1.setTag(tagList);

		// Add Record instance to the list
		records.add(record1);
		bodyWrapper.setData(records);

		List<String> trigger = new ArrayList<String>();
		trigger.add("approval");
		trigger.add("workflow");
		trigger.add("blueprint");
		bodyWrapper.setTrigger(trigger);

		 bodyWrapper.setLarId("3477061087515");
		HeaderMap headerInstance = new HeaderMap();
		//headerInstance.add(CreateRecordsHeader.X_EXTERNAL, "Quotes.Quoted_Items.Product_Name.Products_External");
		APIResponse<ActionHandler> response = recordOperations.createRecords(bodyWrapper, headerInstance);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ActionWrapper)
				{
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
					List<ActionResponse> actionResponses = actionWrapper.getData();
					for (ActionResponse actionResponse : actionResponses)
					{
						if (actionResponse instanceof SuccessResponse)
						{
							SuccessResponse successResponse = (SuccessResponse) actionResponse;
							System.out.println("Status: " + successResponse.getStatus().getValue());
							System.out.println("Code: " + successResponse.getCode().getValue());
							System.out.println("Details: ");
							for (Map.Entry<String, Object> entry : successResponse.getDetails().entrySet())
							{
								System.out.println(entry.getKey() + ": " + entry.getValue());
							}
							System.out.println("Message: " + successResponse.getMessage().getValue());
						}
						else if (actionResponse instanceof APIException)
						{
							APIException exception = (APIException) actionResponse;
							System.out.println("Status: " + exception.getStatus().getValue());
							System.out.println("Code: " + exception.getCode().getValue());
							System.out.println("Details: ");
							for (Map.Entry<String, Object> entry : exception.getDetails().entrySet())
							{
								System.out.println(entry.getKey() + ": " + entry.getValue());
							}
							System.out.println("Message: " + exception.getMessage().getValue());
						}
					}
				}
				else if (actionHandler instanceof APIException)
				{
					APIException exception = (APIException) actionHandler;
					System.out.println("Status: " + exception.getStatus().getValue());
					System.out.println("Code: " + exception.getCode().getValue());
					System.out.println("Details: ");
					for (Map.Entry<String, Object> entry : exception.getDetails().entrySet())
					{
						System.out.println(entry.getKey() + ": " + entry.getValue());
					}
					System.out.println("Message: " + exception.getMessage().getValue());
				}
			}
			else
			{
				Model responseObject = response.getModel();
				Class<? extends Model> clas = responseObject.getClass();
				java.lang.reflect.Field[] fields = clas.getDeclaredFields();
				for (java.lang.reflect.Field field : fields)
				{
					field.setAccessible(true);
					System.out.println(field.getName() + ":" + field.get(responseObject));
				}
			}
		}
	}

	public static void main(String[] args)
	{
		try
		{
			Environment environment = USDataCenter.PRODUCTION;

			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").redirectURL("Redirect_URL").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			String moduleAPIName = "Leads";
			createRecords(moduleAPIName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
