package samples.mailmerge;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.crm.api.mailmerge.MailMergeOperations;
import com.zoho.crm.api.mailmerge.MailMergeTemplate;
import com.zoho.crm.api.mailmerge.MailMergeWrapper;
import com.zoho.crm.api.mailmerge.SuccessResponse;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;
import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.mailmerge.APIException;
import com.zoho.crm.api.mailmerge.ActionHandler;
import com.zoho.crm.api.mailmerge.ActionResponse;
import com.zoho.crm.api.mailmerge.ActionWrapper;
import com.zoho.crm.api.mailmerge.Address;
import com.zoho.crm.api.mailmerge.MailMerge;

public class SendMailMerge
{
	public static void sendMailMerge(String module, String id) throws Exception
	{
		MailMergeOperations mailMergeOperations = new MailMergeOperations(module, id);
		MailMergeWrapper request = new MailMergeWrapper();
		List<MailMerge> sendMailMerge = new ArrayList<>();
		MailMerge mailmerge = new MailMerge();
		MailMergeTemplate mailMergeTemplate = new MailMergeTemplate();
		mailMergeTemplate.setName("Test");
		mailmerge.setMailMergeTemplate(mailMergeTemplate);
		mailmerge.setAttachmentName("testdocument");
		Address fromAddress = new Address();
		fromAddress.setValue("abc@zoho.com");
		mailmerge.setFromAddress(fromAddress);
		List<Address> toAddress = new ArrayList<Address>();
		Address addressvaluemap1 = new Address();
		addressvaluemap1.setValue("abc@zoho.com");
		toAddress.add(addressvaluemap1);
		mailmerge.setToAddress(toAddress);
		List<Address> ccEmail = new ArrayList<Address>();
		Address addressvaluemap2 = new Address();
		addressvaluemap2.setValue("abc2@zoho.com");
		ccEmail.add(addressvaluemap2);
		mailmerge.setCcEmail(ccEmail);
		List<Address> bccEmail = new ArrayList<Address>();
		Address addressvaluemap3 = new Address();
		addressvaluemap3.setValue("abc3@zoho.com");
		bccEmail.add(addressvaluemap3);
		mailmerge.setBccEmail(bccEmail);
		mailmerge.setSubject("subject");
		mailmerge.setMessage("ewsadsqdwd");
		mailmerge.setType("attachment");
		sendMailMerge.add(mailmerge);
		request.setSendMailMerge(sendMailMerge);
		APIResponse<ActionHandler> response = mailMergeOperations.sendMailMerge(request);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ActionWrapper)
				{
					ActionWrapper responseWrapper = (ActionWrapper) actionHandler;
					List<ActionResponse> actionResponses = responseWrapper.getSendMailMerge();
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
							System.out.println("Message: " + successResponse.getMessage());
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
							System.out.println("Message: " + exception.getMessage());
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
					System.out.println("Message: " + exception.getMessage());
				}
			}
			else
			{
				Model responseObject = response.getModel();
				Class<? extends Model> clas = responseObject.getClass();
				java.lang.reflect.Field[] fields = clas.getDeclaredFields();
				for (java.lang.reflect.Field field : fields)
				{
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
			String Id = "3477001";
			String module = "Leads";
			sendMailMerge(module, Id);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
