package samples.record.createRecords;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
import com.zoho.crm.api.record.RecordOperations;
import com.zoho.crm.api.record.SuccessResponse;
import com.zoho.crm.api.tags.Tag;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;

public class Invoices
{
	public static void createInvoices(String moduleAPIName) throws Exception
	{
		RecordOperations recordOperations = new RecordOperations(moduleAPIName);
		BodyWrapper bodyWrapper = new BodyWrapper();
		List<com.zoho.crm.api.record.Record> records = new ArrayList<com.zoho.crm.api.record.Record>();
		com.zoho.crm.api.record.Record record1 = new com.zoho.crm.api.record.Record();
		com.zoho.crm.api.record.Record accountname = new com.zoho.crm.api.record.Record();
		accountname.addKeyValue("name", "automated");
		accountname.addFieldValue(Field.Accounts.ID, 440248884001L);
		record1.addFieldValue(Field.Invoices.ACCOUNT_NAME, accountname);
		record1.addFieldValue(Field.Invoices.SUBJECT, "new invoice");
		record1.addFieldValue(Field.Invoices.ADJUSTMENT, 10.0);
		record1.addFieldValue(Field.Invoices.INVOICE_DATE, LocalDate.of(2023, 10, 12));
		record1.addFieldValue(Field.Invoices.DUE_DATE, LocalDate.of(2023, 12, 12));
		record1.addFieldValue(Field.Invoices.SALES_COMMISSION, 20.0);
		record1.addFieldValue(Field.Invoices.PURCHASE_ORDER, "purchase order");
		record1.addFieldValue(Field.Invoices.EXCISE_DUTY, 10.0);
		record1.addFieldValue(Field.Invoices.STATUS, new Choice<String>("Created"));
		com.zoho.crm.api.record.Record contactname = new com.zoho.crm.api.record.Record();
		contactname.addFieldValue(Field.Contacts.ID, 347706111853001l);
		record1.addFieldValue(Field.Invoices.CONTACT_NAME, contactname);
		com.zoho.crm.api.record.Record dealname = new com.zoho.crm.api.record.Record();
		dealname.addFieldValue(Field.Deals.ID, 347706111383007l);
		record1.addKeyValue("Deal_Name__s", dealname);
		com.zoho.crm.api.record.Record sales_order = new com.zoho.crm.api.record.Record();
		sales_order.addFieldValue(Field.Sales_Orders.ID, 32203232899292L);
		record1.addFieldValue(Field.Invoices.SALES_ORDER, sales_order);
		record1.addFieldValue(Field.Invoices.TERMS_AND_CONDITIONS, "details of terms and conditions");
		record1.addFieldValue(Field.Invoices.DESCRIPTION, "description");
		ArrayList<com.zoho.crm.api.record.Record> inventoryLineItemList = new ArrayList<com.zoho.crm.api.record.Record>();
		com.zoho.crm.api.record.Record inventoryLineItem = new com.zoho.crm.api.record.Record();
		LineItemProduct lineItemProduct = new LineItemProduct();
		lineItemProduct.setId(4402480954344l);
//		com.zoho.crm.api.record.Record data = new com.zoho.crm.api.record.Record();
//		data.setId(440248954344L);
		inventoryLineItem.addKeyValue("Description", "asd");
		inventoryLineItem.addKeyValue("Discount", "5");
		inventoryLineItem.addKeyValue("Quantity", 10.0);
		inventoryLineItem.addKeyValue("List_Price", 100.0);
		inventoryLineItem.addKeyValue("Product_Name", lineItemProduct);
//		inventoryLineItem.addKeyValue("Product_Category_1", "hardware");
		inventoryLineItemList.add(inventoryLineItem);
		List<LineTax> productLineTaxes = new ArrayList<LineTax>();
		LineTax productLineTax = new LineTax();
		productLineTax.setName("Vat");
		productLineTax.setValue(10.0);
		productLineTax.setId(4402480020810l);
		productLineTax.setPercentage(10.0);
		productLineTaxes.add(productLineTax);
		inventoryLineItem.addKeyValue("Line_Tax", productLineTaxes);
		inventoryLineItemList.add(inventoryLineItem);
		record1.addFieldValue(Field.Invoices.INVOICED_ITEMS, inventoryLineItemList);
		List<LineTax> lineTaxes = new ArrayList<LineTax>();
		LineTax lineTax = new LineTax();
		lineTax.setName("MyTax1134");
		lineTax.setPercentage(20.0);
		lineTaxes.add(lineTax);
		record1.addKeyValue("$line_tax", lineTaxes);

		// Address info
		record1.addFieldValue(Field.Quotes.BILLING_CITY, "city");
		record1.addFieldValue(Field.Quotes.BILLING_CODE, "12345");
		record1.addFieldValue(Field.Quotes.BILLING_COUNTRY, "country");
		record1.addFieldValue(Field.Quotes.BILLING_STATE, "state");
		record1.addFieldValue(Field.Quotes.BILLING_STREET, "street");
		record1.addFieldValue(Field.Quotes.SHIPPING_CITY, "shipping city");
		record1.addFieldValue(Field.Quotes.SHIPPING_CODE, "shipping code");
		record1.addFieldValue(Field.Quotes.SHIPPING_COUNTRY, "shipping country");
		record1.addFieldValue(Field.Quotes.SHIPPING_STATE, "shipping state");
		record1.addFieldValue(Field.Quotes.SHIPPING_STREET, "shipping street");

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
		// for MultiSelectLookUp/custom MultiSelectLookUp
		List<com.zoho.crm.api.record.Record> Multirecords = new ArrayList<>();
		com.zoho.crm.api.record.Record record = new com.zoho.crm.api.record.Record();
		com.zoho.crm.api.record.Record linkingRecord = new com.zoho.crm.api.record.Record();
		record.addKeyValue("id", 440248884001L);
		linkingRecord.addKeyValue("Msl", record);
		Multirecords.add(linkingRecord);
		record1.addKeyValue("Msl", Multirecords);
		// for Custom Fields
		record1.addKeyValue("External", "Value12345");
		record1.addKeyValue("Custom_field", "Value");
		record1.addKeyValue("Date_Time_2", OffsetDateTime.of(2023, 11, 20, 10, 00, 01, 00, ZoneOffset.of("+05:30")));
		record1.addKeyValue("Date_1", LocalDate.of(2021, 1, 13));
		record1.addKeyValue("Subject", "AutomatedSDK");
		record1.addKeyValue("Product_Name", "AutomatedSDK");
		List<FileDetails> fileDetails = new ArrayList<FileDetails>();
		FileDetails fileDetail1 = new FileDetails();
		fileDetail1.setFileIdS("ae9c7cefa418aec1d6a5cc2d9ab7c6d90b0bd44183d280");
		fileDetails.add(fileDetail1);
		FileDetails fileDetail2 = new FileDetails();
		fileDetail2.setFileIdS("ae9c7cefa35c32e0063e7321b5b4ca878a934519e6cdb2");
		fileDetails.add(fileDetail2);
		record1.addKeyValue("File_Upload", fileDetails);
		// for Custom User LookUp
		com.zoho.crm.api.users.MinifiedUser user = new com.zoho.crm.api.users.MinifiedUser();
		user.setId(440248254001L);
		record1.addKeyValue("User_1", user);
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
		// headerInstance.add(CreateRecordsHeader.X_EXTERNAL, "Quotes.Quoted_Items.Product_Name.Products_External");
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
			String moduleAPIName = "Invoices";
			createInvoices(moduleAPIName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
