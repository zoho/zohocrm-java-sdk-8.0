package samples.attachments;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.attachments.APIException;
import com.zoho.crm.api.attachments.AttachmentsOperations;
import com.zoho.crm.api.attachments.ParentId;
import com.zoho.crm.api.attachments.ResponseHandler;
import com.zoho.crm.api.attachments.ResponseWrapper;
import com.zoho.crm.api.attachments.AttachmentsOperations.GetAttachmentsParam;
import com.zoho.crm.api.attachments.Info;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetAttachments
{
	public static void getAttachments(String moduleAPIName, Long recordId) throws Exception
	{
		AttachmentsOperations attachmentsOperations = new AttachmentsOperations();
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(GetAttachmentsParam.PAGE, 1);
		paramInstance.add(GetAttachmentsParam.PER_PAGE, 10);
		paramInstance.add(GetAttachmentsParam.FIELDS, "id");
		paramInstance.add(GetAttachmentsParam.IDS, "347706117069001");
		APIResponse<ResponseHandler> response = attachmentsOperations.getAttachments(recordId, moduleAPIName, paramInstance);
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
					List<com.zoho.crm.api.attachments.Attachment> attachments = responseWrapper.getData();
					for (com.zoho.crm.api.attachments.Attachment attachment : attachments)
					{
						com.zoho.crm.api.users.MinifiedUser owner = attachment.getOwner();
						if (owner != null)
						{
							System.out.println("Attachment Owner User-Name: " + owner.getName());
							System.out.println("Attachment Owner User-ID: " + owner.getId());
							System.out.println("Attachment Owner User-Email: " + owner.getEmail());
						}
						System.out.println("Attachment Modified Time: " + attachment.getModifiedTime());
						System.out.println("Attachment File Name: " + attachment.getFileName());
						System.out.println("Attachment FieldStates: " + attachment.getFieldStates());
						System.out.println("Attachment Created Time: " + attachment.getCreatedTime());
						System.out.println("Attachment File Size: " + attachment.getSize());
						ParentId parentId = attachment.getParentId();
						if (parentId != null)
						{
							System.out.println("Attachment parent record Name: " + parentId.getName());
							System.out.println("Attachment parent record ID: " + parentId.getId());
						}
						System.out.println("Attachment is Editable: " + attachment.getEditable());
						System.out.println("Attachment SharingPermission: " + attachment.getSharingPermission());
						System.out.println("Attachment RecordStatusS: " + attachment.getRecordStatusS());
						System.out.println("Attachment File ID: " + attachment.getFileId());
						System.out.println("Attachment File Type: " + attachment.getType());
						System.out.println("Attachment seModule: " + attachment.getSeModule());
						com.zoho.crm.api.users.MinifiedUser modifiedBy = attachment.getModifiedBy();
						if (modifiedBy != null)
						{
							System.out.println("Attachment Modified By User-Name: " + modifiedBy.getName());
							System.out.println("Attachment Modified By User-ID: " + modifiedBy.getId());
							System.out.println("Attachment Modified By User-Email: " + modifiedBy.getEmail());
						}
						System.out.println("Attachment ID: " + attachment.getId());
						com.zoho.crm.api.users.MinifiedUser createdBy = attachment.getCreatedBy();
						if (createdBy != null)
						{
							System.out.println("Attachment Created By User-Name: " + createdBy.getName());
							System.out.println("Attachment Created By User-ID: " + createdBy.getId());
							System.out.println("Attachment Created By User-Email: " + createdBy.getEmail());
						}
						System.out.println("Attachment Type: " + attachment.getAttachmentType());
						System.out.println("Attachment State: " + attachment.getState());
						System.out.println("Attachment LinkUrl: " + attachment.getLinkUrl());
						System.out.println("Attachment ZiaVisions: " + attachment.getZiaVisions());
					}
					Info info = responseWrapper.getInfo();
					if (info != null)
					{
						if (info.getPerPage() != null)
						{
							System.out.println("Attachment Info PerPage: " + info.getPerPage().toString());
						}
						if (info.getCount() != null)
						{
							System.out.println("Attachment Info Count: " + info.getCount().toString());
						}
						if (info.getPage() != null)
						{
							System.out.println("Attachment Info Page: " + info.getPage().toString());
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
			Long recordId = 4402480774074l;
			getAttachments(moduleAPIName, recordId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
