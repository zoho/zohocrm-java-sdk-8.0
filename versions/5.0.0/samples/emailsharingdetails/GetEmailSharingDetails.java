package samples.emailsharingdetails;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.emailsharingdetails.APIException;
import com.zoho.crm.api.emailsharingdetails.EmailSharingDetailsOperations;
import com.zoho.crm.api.emailsharingdetails.EmailSharings;
import com.zoho.crm.api.emailsharingdetails.ResponseHandler;
import com.zoho.crm.api.emailsharingdetails.ResponseWrapper;
import com.zoho.crm.api.emailsharingdetails.ShareFromUser;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetEmailSharingDetails
{
	public static void getEmailSharingDetails(Long recordId, String module) throws Exception
	{
		EmailSharingDetailsOperations emailsharingoperations = new EmailSharingDetailsOperations(recordId, module);
		APIResponse<ResponseHandler> response = emailsharingoperations.getEmailSharingDetails();
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (Arrays.asList(204, 304).contains(response.getStatusCode()))
			{
				System.out.println(response.getStatusCode() == 204 ? "No Content" : "Not Modified");
				return;
			}
			if (response.isExpected())
			{
				ResponseHandler responseHandler = response.getObject();
				if (responseHandler instanceof ResponseWrapper)
				{
					ResponseWrapper responseWrapper = (ResponseWrapper) responseHandler;
					List<EmailSharings> emailSharingdetails = responseWrapper.getEmailsSharingDetails();
					if (emailSharingdetails != null)
					{
						for (EmailSharings getemailsharing : emailSharingdetails)
						{
							System.out.println("Email_Sharing_Details : ");
							List<ShareFromUser> sharefromUsers = getemailsharing.getShareFromUsers();
							if (sharefromUsers != null)
							{
								System.out.println("ShareFromUsers : ");
								for (ShareFromUser sharefromuser : sharefromUsers)
								{
									System.out.println("id : " + sharefromuser.getId());
									System.out.println("name : " + sharefromuser.getName());
									System.out.println("type : " + sharefromuser.getType());
								}
							}
							List<String> availableTypes = getemailsharing.getAvailableTypes();
							if (availableTypes != null)
							{
								System.out.println("AvailableTypes : ");
								for (String availabletype : availableTypes)
								{
									System.out.println(availabletype);
								}
							}
						}
					}
				}
				else if (responseHandler instanceof APIException)
				{
					APIException exception = (APIException) responseHandler;
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
				java.lang.reflect.Field[] Fields = clas.getDeclaredFields();
				for (java.lang.reflect.Field field : Fields)
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
			String module = "Leads";
			Long recordId = 4402480774074l;
			getEmailSharingDetails(recordId, module);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
