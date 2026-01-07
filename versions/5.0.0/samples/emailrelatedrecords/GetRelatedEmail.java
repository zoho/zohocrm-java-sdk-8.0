package samples.emailrelatedrecords;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.emailrelatedrecords.APIException;
import com.zoho.crm.api.emailrelatedrecords.Attachments;
import com.zoho.crm.api.emailrelatedrecords.Email;
import com.zoho.crm.api.emailrelatedrecords.EmailRelatedRecordsOperations;
import com.zoho.crm.api.emailrelatedrecords.Info;
import com.zoho.crm.api.emailrelatedrecords.LinkedRecord;
import com.zoho.crm.api.emailrelatedrecords.ResponseHandler;
import com.zoho.crm.api.emailrelatedrecords.ResponseWrapper;
import com.zoho.crm.api.emailrelatedrecords.Status;
import com.zoho.crm.api.emailrelatedrecords.UserDetails;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetRelatedEmail
{
	public static void getRelatedEmail(String moduleAPIName, Long id, String messageId) throws Exception
	{
		EmailRelatedRecordsOperations emailTemplatesOperations = new EmailRelatedRecordsOperations(id, moduleAPIName, null, null);
		APIResponse<ResponseHandler> response = emailTemplatesOperations.getEmailsRelatedRecord(messageId);
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
						List<Attachments> attachments = emailTemplate.getAttachments();
						if (attachments != null)
						{
							for (Attachments attachment : attachments)
							{
								System.out.println("EmailRelatedRecords Attachmnet Size :" + attachment.getSize());
								System.out.println("EmailRelatedRecords Attachmnet Name :" + attachment.getName());
								System.out.println("EmailRelatedRecords Attachmnet Id :" + attachment.getId());
							}
						}
						System.out.println("EmailRelatedRecords Subject: " + emailTemplate.getSubject());
						System.out.println("EmailRelatedRecords ActivityInfo: " + emailTemplate.getActivityInfo());
						System.out.println("EmailRelatedRecords Editable: " + emailTemplate.getEditable());
						System.out.println("EmailRelatedRecords MailFormat: " + emailTemplate.getMailFormat());
						System.out.println("EmailRelatedRecords Intent: " + emailTemplate.getIntent());
						System.out.println("EmailRelatedRecords Content: " + emailTemplate.getContent());
						System.out.println("EmailRelatedRecords SentimentInfo: " + emailTemplate.getSentimentInfo());
						System.out.println("EmailRelatedRecords SentTime: " + emailTemplate.getSentTime());
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
						System.out.println("EmailRelatedRecords ThreadId: " + emailTemplate.getThreadId());
						System.out.println("EmailRelatedRecords Emotion: " + emailTemplate.getEmotion());
						UserDetails replyTo = emailTemplate.getReplyTo();
						if (replyTo != null)
						{
							System.out.println("EmailRelatedRecords ReplyTo Email : " + replyTo.getEmail());
							System.out.println("EmailRelatedRecords ReplyTo UserName : " + replyTo.getUserName());
							
						}
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
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			String moduleAPIName = "Leads";
			Long Id = 4402480774074l;
			String messageId = "c6085fae06cbd7b75001d80ffefab46b7d76f8540fc65c6bc779dfe4aab8d727";
			getRelatedEmail(moduleAPIName, Id, messageId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
