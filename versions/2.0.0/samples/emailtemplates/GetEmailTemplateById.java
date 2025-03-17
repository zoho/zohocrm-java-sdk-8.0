package samples.emailtemplates;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.crm.api.emailtemplates.EmailTemplatesOperations;
import com.zoho.crm.api.emailtemplates.ResponseHandler;
import com.zoho.crm.api.emailtemplates.ResponseWrapper;
import com.zoho.crm.api.inventorytemplates.Folder;
import com.zoho.crm.api.inventorytemplates.ModuleMap;
import com.zoho.crm.api.inventorytemplates.User;
import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.emailtemplates.APIException;
import com.zoho.crm.api.emailtemplates.Attachment;
import com.zoho.crm.api.emailtemplates.EmailTemplate;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetEmailTemplateById
{
	public static void getEmailTemplateById(Long emailTemplateID) throws Exception
	{
		EmailTemplatesOperations emailTemplatesOperations = new EmailTemplatesOperations();
		APIResponse<ResponseHandler> response = emailTemplatesOperations.getEmailTemplate(emailTemplateID);
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
					List<EmailTemplate> emailTemplates = responseWrapper.getEmailTemplates();
					for (EmailTemplate emailTemplate : emailTemplates)
					{
						System.out.println("EmailTemplate MailContent: " + emailTemplate.getMailContent());
						System.out.println("EmailTemplate CreatedTime: " + emailTemplate.getCreatedTime());
						List<Attachment> attachments = emailTemplate.getAttachments();
						if (attachments != null)
						{
							for (Attachment attachment : attachments)
							{
								System.out.println("EmailTemplate Attachment File ID: " + attachment.getFileId());
								System.out.println("EmailTemplate Attachment File Name: " + attachment.getFileName());
								System.out.println("EmailTemplate Attachment Size: " + attachment.getSize());
								System.out.println("EmailTemplate Attachment ID: " + attachment.getId());
							}
						}
						System.out.println("EmailTemplate Subject: " + emailTemplate.getSubject());
						ModuleMap module = emailTemplate.getModule();
						if (module != null)
						{
							System.out.println("EmailTemplate Module ID: " + module.getId());
							System.out.println("EmailTemplate Module apiName: " + module.getAPIName());
						}
						User createdBy = emailTemplate.getCreatedBy();
						if (createdBy != null)
						{
							System.out.println("EmailTemplate Created By Name : " + createdBy.getName());
							System.out.println("EmailTemplate Created By id : " + createdBy.getId());
						}
						System.out.println("EmailTemplate Content: " + emailTemplate.getContent());
						Folder folder = emailTemplate.getFolder();
						if (folder != null)
						{
							System.out.println("EmailTemplate Folder  id : " + folder.getId());
							System.out.println("EmailTemplate Folder  Name : " + folder.getName());
						}
						System.out.println("EmailTemplate ModifiedTime: " + emailTemplate.getModifiedTime());
						System.out.println("EmailTemplate Last Usage Time: " + emailTemplate.getLastUsageTime());
						System.out.println("EmailTemplate Associated: " + emailTemplate.getAssociated());
						System.out.println("EmailTemplate Name: " + emailTemplate.getName());
						User modifiedBy = emailTemplate.getModifiedBy();
						if (modifiedBy != null)
						{
							System.out.println("EmailTemplate Modified By Name : " + modifiedBy.getName());
							System.out.println("EmailTemplate Modified By id : " + modifiedBy.getId());
						}
						System.out.println("EmailTemplate Consent Linked: " + emailTemplate.getConsentLinked());
						System.out.println("EmailTemplate ID: " + emailTemplate.getId());
						System.out.println("EmailTemplate EditorMode: " + emailTemplate.getEditorMode());
						System.out.println("EmailTemplate Category: " + emailTemplate.getCategory());
						System.out.println("EmailTemplate Favourite: " + emailTemplate.getFavorite());
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
			Long emailTemplateID = 4402480627040l;
			getEmailTemplateById(emailTemplateID);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
