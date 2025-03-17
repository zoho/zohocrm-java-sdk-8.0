package samples.record;

import java.util.ArrayList;
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
import com.zoho.crm.api.record.LineItemProduct;
import com.zoho.crm.api.record.LineTax;
import com.zoho.crm.api.record.RecordOperations;
import com.zoho.crm.api.record.SuccessResponse;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class UpdateRecords
{
	public static void updateRecords(String moduleAPIName) throws Exception
	{
		RecordOperations recordOperations = new RecordOperations(moduleAPIName);
		BodyWrapper request = new BodyWrapper();

		List<com.zoho.crm.api.record.Record> records = new ArrayList<com.zoho.crm.api.record.Record>();
		com.zoho.crm.api.record.Record record1 = new com.zoho.crm.api.record.Record();
		record1.setId(347706112081001l);

		/*
		 * Call addFieldValue method that takes two arguments 1 -> Call Field "." and choose the module from the displayed list and press "." and choose the field name from the displayed list. 2 -> Value
		 */
		record1.addFieldValue(Field.Leads.CITY, "City");
		record1.addFieldValue(Field.Leads.LAST_NAME, "Last Name");
		record1.addFieldValue(Field.Leads.FIRST_NAME, "First Name");
		record1.addFieldValue(Field.Leads.COMPANY, "KKRNP");

		/*
		 * Call addKeyValue method that takes two arguments 1 -> A string that is the Field's API Name 2 -> Value
		 */
		record1.addKeyValue("Custom_field", "Value");
		record1.addKeyValue("Custom_field_2", "value");

		// Used when GDPR is enabled
		Consent dataConsent = new Consent();
		dataConsent.setConsentRemarks("Approved.");
		dataConsent.setConsentThrough("Email");
		dataConsent.setContactThroughEmail(true);
		dataConsent.setContactThroughSocial(false);
		record1.addKeyValue("Data_Processing_Basis_Details", dataConsent);

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
		ArrayList<com.zoho.crm.api.record.Record> inventoryLineItemList = new ArrayList<com.zoho.crm.api.record.Record>();
		com.zoho.crm.api.record.Record inventoryLineItem = new com.zoho.crm.api.record.Record();
		LineItemProduct lineItemProduct = new LineItemProduct();
		lineItemProduct.setId(347706111217004l);
//		lineItemProduct.addKeyValue("Products_External", "TestExternalLead121");
		inventoryLineItem.addKeyValue("Description", "asd");
		inventoryLineItem.addKeyValue("Discount", "5");
		com.zoho.crm.api.record.Record parentId = new com.zoho.crm.api.record.Record();
		parentId.setId(35240337331017L);
		inventoryLineItem.addKeyValue("Parent_Id", parentId);
		LineItemProduct lineitemProduct = new LineItemProduct();
		lineitemProduct.setId(35240333659082L);
		inventoryLineItem.addKeyValue("Product_Name", lineItemProduct);
		inventoryLineItem.addKeyValue("Sequence_Number", 1l);
		inventoryLineItem.addKeyValue("Quantity", 123.2);
		inventoryLineItem.addKeyValue("Tax", 123.2);
		inventoryLineItemList.add(inventoryLineItem);
		List<LineTax> productLineTaxes = new ArrayList<LineTax>();
		LineTax productLineTax = new LineTax();
		productLineTax.setName("MyTax1134");
		productLineTax.setPercentage(20.0);
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

		// Add Record instance to the list
		records.add(record1);

		com.zoho.crm.api.record.Record record2 = new com.zoho.crm.api.record.Record();
		record2.setId(34770615844005l);

		/*
		 * Call addFieldValue method that takes two arguments 1 -> Call Field "." and choose the module from the displayed list and press "." and choose the field name from the displayed list. 2 -> Value
		 */
		record2.addFieldValue(Field.Leads.CITY, "City");
		record2.addFieldValue(Field.Leads.LAST_NAME, "Last Name");
		record2.addFieldValue(Field.Leads.FIRST_NAME, "First Name");
		record2.addFieldValue(Field.Leads.COMPANY, "KKRNP");

		/*
		 * Call addKeyValue method that takes two arguments 1 -> A string that is the Field's API Name 2 -> Value
		 */
		record2.addKeyValue("Custom_field", "Value");
		record2.addKeyValue("Custom_field_2", "value");

		records.add(record2);
		request.setData(records);

		List<String> trigger = new ArrayList<String>();
		trigger.add("approval");
		trigger.add("workflow");
		trigger.add("blueprint");
		request.setTrigger(trigger);

		HeaderMap headerInstance = new HeaderMap();
//		headerInstance.add(UpdateRecordsHeader.X_EXTERNAL, "Quotes.Quoted_Items.Product_Name.Products_External");
		APIResponse<ActionHandler> response = recordOperations.updateRecords(request, headerInstance);
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
			updateRecords(moduleAPIName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
