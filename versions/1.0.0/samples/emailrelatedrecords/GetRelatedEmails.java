package samples.emailrelatedrecords;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.emailrelatedrecords.APIException;
import com.zoho.crm.api.emailrelatedrecords.Email;
import com.zoho.crm.api.emailrelatedrecords.EmailRelatedRecordsOperations;
import com.zoho.crm.api.emailrelatedrecords.EmailRelatedRecordsOperations.GetEmailsRelatedRecordsParam;
import com.zoho.crm.api.emailrelatedrecords.Info;
import com.zoho.crm.api.emailrelatedrecords.LinkedRecord;
import com.zoho.crm.api.emailrelatedrecords.ResponseHandler;
import com.zoho.crm.api.emailrelatedrecords.ResponseWrapper;
import com.zoho.crm.api.emailrelatedrecords.Status;
import com.zoho.crm.api.emailrelatedrecords.UserDetails;
import com.zoho.crm.api.users.MinifiedUser;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetRelatedEmails
{
	public static void getRelatedEmails(String moduleAPIName, Long id, String type, Long ownerId, String index) throws Exception
	{
		EmailRelatedRecordsOperations emailTemplatesOperations = new EmailRelatedRecordsOperations(id, moduleAPIName, type, ownerId);
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(GetEmailsRelatedRecordsParam.INDEX, index);	
		APIResponse<ResponseHandler> response = emailTemplatesOperations.getEmailsRelatedRecords(paramInstance);
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
					List<Email> emailTemplates = responseWrapper.getEmails();
					for (Email emailTemplate : emailTemplates)
					{
						List<UserDetails> userDetails = emailTemplate.getCc();
						if (userDetails != null)
						{
							for (UserDetails userDetail : userDetails)
							{
								System.out.println("EmailRelatedRecords User Email: " + userDetail.getEmail());
								System.out.println("EmailRelatedRecords User Name: " + userDetail.getUserName());
							}
						}
						System.out.println("EmailRelatedRecords HasThreadAttachment: " + emailTemplate.getHasThreadAttachment());
						System.out.println("EmailRelatedRecords Summary: " + emailTemplate.getSummary());
						MinifiedUser owner = emailTemplate.getOwner();
						if (owner != null)
						{
							System.out.println("EmailRelatedRecords User ID: " + owner.getId());
							System.out.println("EmailRelatedRecords User Name: " + owner.getName());
						}
						System.out.println("EmailRelatedRecords Read: " + emailTemplate.getRead());
						System.out.println("EmailRelatedRecords Subject: " + emailTemplate.getSubject());
						System.out.println("EmailRelatedRecords MessageId: " + emailTemplate.getMessageId());
						System.out.println("EmailRelatedRecords HasAttachment: " + emailTemplate.getHasAttachment());
						System.out.println("EmailRelatedRecords Source: " + emailTemplate.getSource());
						System.out.println("EmailRelatedRecords Sent: " + emailTemplate.getSent());
						System.out.println("EmailRelatedRecords Intent: " + emailTemplate.getIntent());
						System.out.println("EmailRelatedRecords SentimentInfo: " + emailTemplate.getSentimentInfo());
						LinkedRecord linkedRecord = emailTemplate.getLinkedRecord();
						if (linkedRecord != null)
						{
							System.out.println("EmailRelatedRecords LinkedRecord id : " + linkedRecord.getId());
							com.zoho.crm.api.emailrelatedrecords.Module module = linkedRecord.getModule();
							if (module != null)
							{
								System.out.println("EmailRelatedRecords LinkedRecord Module APIName : " + module.getAPIName());
								System.out.println("EmailRelatedRecords LinkedRecord Module Id : " + module.getId());
							}
						}
						System.out.println("EmailRelatedRecords Emotion: " + emailTemplate.getEmotion());
						UserDetails from = emailTemplate.getFrom();
						if (from != null)
						{
							System.out.println("EmailRelatedRecords From User Email: " + from.getEmail());
							System.out.println("EmailRelatedRecords From User Name: " + from.getUserName());
						}
						List<UserDetails> toUserDetails = emailTemplate.getTo();
						if (toUserDetails != null)
						{
							for (UserDetails userDetail : toUserDetails)
							{
								System.out.println("EmailRelatedRecords User Email: " + userDetail.getEmail());
								System.out.println("EmailRelatedRecords User Name: " + userDetail.getUserName());
							}
						}
						System.out.println("EmailRelatedRecords Time: " + emailTemplate.getTime());
						List<Status> status = emailTemplate.getStatus();
						if (status != null)
						{
							for (Status status1 : status)
							{
								System.out.println("EmailRelatedRecords Status Type: " + status1.getType());
								System.out.println("EmailRelatedRecords Status BouncedTime: " + status1.getBouncedTime());
								System.out.println("EmailRelatedRecords Status BouncedReason: " + status1.getBouncedReason());
							}
						}
					}
					Info info = responseWrapper.getInfo();
					if (info != null)
					{
						if (info.getCount() != null)
						{
							System.out.println("Record Info Count: " + info.getCount().toString());
						}
						if (info.getNextIndex() != null)
						{
							System.out.println("Record Info NextIndex: " + info.getNextIndex().toString());
						}
						if (info.getPrevIndex() != null)
						{
							System.out.println("Record Info PrevIndex: " + info.getPrevIndex().toString());
						}
						if (info.getPerPage() != null)
						{
							System.out.println("Record Info PerPage: " + info.getPerPage().toString());
						}
						if (info.getMoreRecords() != null)
						{
							System.out.println("Record Info MoreRecords: " + info.getMoreRecords().toString());
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
			String moduleAPIName = "Leads";
			Long Id = 4402480774074l;
			String type = "user_emails";
			String index = "487a357e461a6f16f38eabb8ce0d9236a16fe897";
			Long ownerId = 347773021l;
			getRelatedEmails(moduleAPIName, Id, type, ownerId, index);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
