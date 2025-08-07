package samples.mailmerge;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.mailmerge.APIException;
import com.zoho.crm.api.mailmerge.Address;
import com.zoho.crm.api.mailmerge.MailMergeOperations;
import com.zoho.crm.api.mailmerge.MailMergeTemplate;
import com.zoho.crm.api.mailmerge.SignActionHandler;
import com.zoho.crm.api.mailmerge.SignActionResponse;
import com.zoho.crm.api.mailmerge.SignActionWrapper;
import com.zoho.crm.api.mailmerge.SignMailMerge;
import com.zoho.crm.api.mailmerge.SignMailMergeWrapper;
import com.zoho.crm.api.mailmerge.Signers;
import com.zoho.crm.api.mailmerge.SuccessResponse;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;

public class SignmailMerge
{
	public static void signMailMerge(String module, String id) throws Exception
	{
		MailMergeOperations mailMergeOperations = new MailMergeOperations(module, id);
		SignMailMergeWrapper request = new SignMailMergeWrapper();
		List<SignMailMerge> signMailMerge = new ArrayList<>();
		SignMailMerge mailmerge = new SignMailMerge();
		MailMergeTemplate mailMergeTemplate = new MailMergeTemplate();
		mailMergeTemplate.setName("Test");
		mailmerge.setMailMergeTemplate(mailMergeTemplate);
		mailmerge.setFileName("testfile");
		mailmerge.setSignInOrder(true);
		List<Signers> signers = new ArrayList<>();
		Signers signer = new Signers();
		signer.setActionType(new Choice<String>("sign"));
		Address recipent = new Address();
		recipent.setValue("abc@zoho.com");
		signer.setRecipient(recipent);
		signers.add(signer);
		mailmerge.setSigners(signers);
		signMailMerge.add(mailmerge);
		request.setSignMailMerge(signMailMerge);
		APIResponse<SignActionHandler> response = mailMergeOperations.signMailMerge(request);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				SignActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof SignActionWrapper)
				{
					SignActionWrapper responseWrapper = (SignActionWrapper) actionHandler;
					List<SignActionResponse> actionResponses = responseWrapper.getSignMailMerge();
					for (SignActionResponse actionResponse : actionResponses)
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
			String Id = "3477827001";
			String module = "Leads";
			signMailMerge(module, Id);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
