package samples.associateemails;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.associateemail.APIException;
import com.zoho.crm.api.associateemail.ActionHandler;
import com.zoho.crm.api.associateemail.ActionResponse;
import com.zoho.crm.api.associateemail.ActionWrapper;
import com.zoho.crm.api.associateemail.AssociateEmail;
import com.zoho.crm.api.associateemail.AssociateEmailOperations;
import com.zoho.crm.api.associateemail.Attachments;
import com.zoho.crm.api.associateemail.BodyWrapper;
import com.zoho.crm.api.associateemail.From;
import com.zoho.crm.api.associateemail.SuccessResponse;
import com.zoho.crm.api.associateemail.To;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.lang.reflect.Field;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Associate
{
	public static void associate(Long recordId, String module) throws Exception
	{
		AssociateEmailOperations associate_email_operations = new AssociateEmailOperations();
		BodyWrapper request = new BodyWrapper();
		List<AssociateEmail> emails = new ArrayList<>();
		for (int i = 0; i < 1; i++)
		{
			AssociateEmail associateEmail = new AssociateEmail();
			From from = new From();
			from.setEmail("abc555@zoho.com");
			from.setUserName("username");
			associateEmail.setFrom(from);
			List<To> tos = new ArrayList<>();
			To to = new To();
			to.setEmail("abc1@zoho.com");
			to.setUserName("username1");
			tos.add(to);
			List<To> tos1 = new ArrayList<>();
			To to1 = new To();
			to1.setEmail("abc2@zoho.com");
			to1.setUserName("user_name2");
			tos1.add(to1);
			List<To> tos2 = new ArrayList<>();
			To to2 = new To();
			to2.setEmail("abc3@zoho.com");
			to2.setUserName("user_name3");
			tos2.add(to2);
			associateEmail.setTo(tos);
			associateEmail.setCc(tos1);
			associateEmail.setBcc(tos2);
			associateEmail.setSubject("Subject");
			associateEmail.setOriginalMessageId("c6085fab75001d80ffefab46b9c6a7521a63e163835aecd3937749712");
			associateEmail.setDateTime(OffsetDateTime.now());
//			associateEmail.setDateTime(OffsetDateTime.of(2023, 05, 9, 11, 26, 25, 00, ZoneOffset.of("+05:30")));
			associateEmail.setSent(true);
			associateEmail.setContent("<h3><span style=\\\"background-color: rgb(254, 255, 102)\\\">Mail is of rich text format</span></h3><h3><span style=\\\"background-color: rgb(254, 255, 102)\\\">REGARDS,</span></h3><div><span style=\\\"background-color: rgb(254, 255, 102)\\\">AZ</span></div><div><span style=\\\"background-color: rgb(254, 255, 102)\\\">ADMIN</span></div> <div></div>");
			associateEmail.setMailFormat(new Choice<String>("html"));
			List<Attachments> attachments = new ArrayList<>();
			Attachments attachment = new Attachments();
			attachment.setId("c6085fae06cbd7b75001d806b1061e063a64154e30b905c6e1efa82c6");
			attachments.add(attachment);
			associateEmail.setAttachments(attachments);
			emails.add(associateEmail);
		}
		request.setEmails(emails);
		APIResponse<ActionHandler> response = associate_email_operations.associate(recordId, module, request);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ActionWrapper)
				{
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
					List<ActionResponse> actionresponses = actionWrapper.getEmails();
					for (ActionResponse actionresponse : actionresponses)
					{
						if (actionresponse instanceof SuccessResponse)
						{
							SuccessResponse successresponse = (SuccessResponse) actionresponse;
							System.out.println("Status: " + successresponse.getStatus().getValue());
							System.out.println("Code: " + successresponse.getCode().getValue());
							System.out.println("Details: ");
							for (Map.Entry<String, Object> entry : successresponse.getDetails().entrySet())
							{
								System.out.println(entry.getKey() + ": " + entry.getValue());
							}
							System.out.println("Message: " + successresponse.getMessage());
						}
						else if (actionresponse instanceof APIException)
						{
							APIException exception = (APIException) actionresponse;
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
				Field[] fields = clas.getDeclaredFields();
				for (Field field : fields)
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
			Long recordId = 4402401304002l;
			String moduleAPIName = "Leads";
			associate(recordId, moduleAPIName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
