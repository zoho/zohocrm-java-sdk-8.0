package samples.record;

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
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
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

public class UpdateRecord
{
	public static void updateRecord(String moduleAPIName, long recordId) throws Exception
	{
		RecordOperations recordOperations = new RecordOperations(moduleAPIName);
		BodyWrapper request = new BodyWrapper();
		List<com.zoho.crm.api.record.Record> records = new ArrayList<com.zoho.crm.api.record.Record>();
		com.zoho.crm.api.record.Record record1 = new com.zoho.crm.api.record.Record();

		/*
		 * Call addFieldValue method that takes two arguments 1 -> Call Field "." and choose the module from the displayed list and press "." and choose the field name from the displayed list. 2 -> Value
		 */
		record1.addFieldValue(Field.Leads.CITY, "City");
		record1.addFieldValue(Field.Leads.LAST_NAME, "Last Name");
		record1.addFieldValue(Field.Leads.FIRST_NAME, "First Name");
		record1.addFieldValue(Field.Leads.LAST_NAME, "Last Name");
		record1.addFieldValue(Field.Leads.COMPANY, "KKRNP");

		/*
		 * Call addKeyValue method that takes two arguments 1 -> A string that is the Field's API Name 2 -> Value
		 */

		com.zoho.crm.api.record.Record data = new com.zoho.crm.api.record.Record();
		data.setId(440248774074L);
		record1.addKeyValue("Lookup_2", data);
		record1.addKeyValue("Multiselect", new ArrayList<>(Arrays.asList(new Choice<String>("Option 1"))));
		record1.addKeyValue("Custom_field", "Value");
		record1.addKeyValue("Custom_field_2", "value");
		record1.addKeyValue("Date_Time_2", OffsetDateTime.of(2019, 11, 20, 10, 00, 01, 00, ZoneOffset.of("+05:30")));
		record1.addKeyValue("Date_1", LocalDate.of(2017, 1, 13));
		List<FileDetails> fileDetails = new ArrayList<FileDetails>();
		FileDetails fileDetail1 = new FileDetails();
		fileDetail1.setFileIdS("ae9c7cefa418aec1d6a5cc2d9ab35c326ef5c");
		fileDetail1.setDelete(null);
		fileDetails.add(fileDetail1);
		FileDetails fileDetail2 = new FileDetails();
		fileDetail2.setFileIdS("ae9c7cefa418aec1d6a5cc2d9ab35c326ef5c");
		fileDetail2.setDelete(null);
		fileDetails.add(fileDetail2);
		FileDetails fileDetail3 = new FileDetails();
		fileDetail3.setFileIdS("ae9c7cef4b32b984bad140a629d9f4d4fc8e2");
		fileDetail3.setDelete(null);
		fileDetails.add(fileDetail3);
		record1.addKeyValue("File_Upload", fileDetails);
		com.zoho.crm.api.users.MinifiedUser recordOwner = new com.zoho.crm.api.users.MinifiedUser();
		recordOwner.setEmail("abc.d@zoho.com");
		record1.addKeyValue("Owner", recordOwner);

		// Used when GDPR is enabled
		Consent dataConsent = new Consent();
		dataConsent.setConsentRemarks("Approved.");
		dataConsent.setConsentThrough("Email");
		dataConsent.setContactThroughEmail(true);
		dataConsent.setContactThroughSocial(false);
		record1.addKeyValue("Data_Processing_Basis_Details", dataConsent);

		// Subform sample code
		List<com.zoho.crm.api.record.Record> subformList = new ArrayList<com.zoho.crm.api.record.Record>();
		com.zoho.crm.api.record.Record subform = new com.zoho.crm.api.record.Record();
		subform.addKeyValue("Subform FieldAPIName", "FieldValue");
		subformList.add(subform);
		com.zoho.crm.api.record.Record deletesubform = new com.zoho.crm.api.record.Record();
		deletesubform.setId(34770619314010l);	
		deletesubform.addKeyValue("_delete", null);
		subformList.add(deletesubform);
		record1.addKeyValue("Subform Name", subformList);

		/** Following methods are being used only by Inventory modules */
		com.zoho.crm.api.record.Record dealName = new com.zoho.crm.api.record.Record();
		dealName.addFieldValue(Field.Deals.ID, 34770614995070l);
		record1.addFieldValue(Field.Sales_Orders.DEAL_NAME, dealName);
		com.zoho.crm.api.record.Record contactName = new com.zoho.crm.api.record.Record();
		contactName.addFieldValue(Field.Contacts.ID, 34770614977055l);
		record1.addFieldValue(Field.Purchase_Orders.CONTACT_NAME, contactName);
		com.zoho.crm.api.record.Record accountName = new com.zoho.crm.api.record.Record();
		accountName.addKeyValue("name", "automatedAccount");
		record1.addFieldValue(Field.Quotes.ACCOUNT_NAME, accountName);
		ArrayList<com.zoho.crm.api.record.Record> inventoryLineItemList = new ArrayList<com.zoho.crm.api.record.Record>();
		com.zoho.crm.api.record.Record inventoryLineItem = new com.zoho.crm.api.record.Record();
		LineItemProduct lineItemProduct = new LineItemProduct();
		lineItemProduct.setId(34770615356009L);
		inventoryLineItem.addKeyValue("Description", "asd");
		inventoryLineItem.addKeyValue("Discount", "5");
		com.zoho.crm.api.record.Record parentId = new com.zoho.crm.api.record.Record();
		parentId.setId(35240337331017L);
//		inventoryLineItem.addKeyValue("Parent_Id", 5);
		inventoryLineItem.addKeyValue("Sequence_Number", 1L);
		LineItemProduct lineitemProduct = new LineItemProduct();
		lineitemProduct.setId(35240333659082L);
		inventoryLineItem.addKeyValue("Product_Name", lineItemProduct);
		inventoryLineItem.addKeyValue("Sequence_Number", 1l);
		inventoryLineItem.addKeyValue("Quantity", 123.2);
		inventoryLineItem.addKeyValue("Tax", 123.2);
		inventoryLineItemList.add(inventoryLineItem);
		List<LineTax> productLineTaxes = new ArrayList<LineTax>();
		LineTax productLineTax = new LineTax();
		productLineTax.setName("Sales Tax");
		productLineTax.setPercentage(20.0);
		productLineTaxes.add(productLineTax);
		inventoryLineItem.addKeyValue("line_tax", productLineTaxes);
		inventoryLineItemList.add(inventoryLineItem);
		record1.addKeyValue("Quoted_Items", inventoryLineItemList);
		List<LineTax> lineTaxes = new ArrayList<LineTax>();
		LineTax lineTax = new LineTax();
		lineTax.setName("Sales Tax");
		lineTax.setPercentage(20.0);
		lineTaxes.add(lineTax);
		record1.addKeyValue("$line_tax", lineTaxes);
		/** End Inventory **/

		List<Tag> tagList = new ArrayList<Tag>();
		Tag tag = new Tag();
		tag.setName("Testtask1");
		tagList.add(tag);
		record1.setTag(tagList);

		// Add Record instance to the list
		records.add(record1);
		request.setData(records);

		List<String> trigger = new ArrayList<String>();
		trigger.add("approval");
		trigger.add("workflow");
		trigger.add("blueprint");
		request.setTrigger(trigger);

		HeaderMap headerInstance = new HeaderMap();
//		headerInstance.add(UpdateRecordHeader.X_EXTERNAL, "Leads.External");
		APIResponse<ActionHandler> response = recordOperations.updateRecord(recordId, request, headerInstance);
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
			long recordId = 4402481018118L;
			updateRecord(moduleAPIName, recordId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
