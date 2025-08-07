package samples.notes;

import java.lang.reflect.Field;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.HeaderMap;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.attachments.Attachment;
import com.zoho.crm.api.attachments.ParentId;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.notes.APIException;
import com.zoho.crm.api.notes.Info;
import com.zoho.crm.api.notes.NotesOperations;
import com.zoho.crm.api.notes.ResponseHandler;
import com.zoho.crm.api.notes.ResponseWrapper;
import com.zoho.crm.api.notes.NotesOperations.GetNotesHeader;
import com.zoho.crm.api.notes.NotesOperations.GetNotesParam;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetNotes
{
	public static void getNotes() throws Exception
	{
		NotesOperations notesOperations = new NotesOperations();
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(GetNotesParam.PAGE, "1");
		paramInstance.add(GetNotesParam.PER_PAGE, "1");
		paramInstance.add(GetNotesParam.FIELDS, "id");
		paramInstance.add(GetNotesParam.IDS, "34770208207");
		HeaderMap headerInstance = new HeaderMap();
		OffsetDateTime startdatetime = OffsetDateTime.of(2021, 06, 01, 10, 00, 01, 00, ZoneOffset.of("+05:30"));
		headerInstance.add(GetNotesHeader.IF_MODIFIED_SINCE, startdatetime);
		APIResponse<ResponseHandler> response = notesOperations.getNotes(paramInstance, headerInstance);
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
					List<com.zoho.crm.api.notes.Note> notes = responseWrapper.getData();
					for (com.zoho.crm.api.notes.Note note : notes)
					{
						com.zoho.crm.api.users.MinifiedUser owner = note.getOwner();
						if (owner != null)
						{
							System.out.println("Note Owner User-Name: " + owner.getName());
							System.out.println("Note Owner User-ID: " + owner.getId());
							System.out.println("Note Owner Email: " + owner.getEmail());
						}
						System.out.println("Note ModifiedTime: " + note.getModifiedTime());
						List<Attachment> attachments = note.getAttachments();
						if (attachments != null)
						{
							for (Attachment attachment : attachments)
							{
								printAttachment(attachment);
							}
						}
						System.out.println("Note CreatedTime: " + note.getCreatedTime());
						com.zoho.crm.api.notes.ParentId parentId = note.getParentId();
						if (parentId != null)
						{
							System.out.println("Note parent record Name: " + parentId.getName());
							System.out.println("Note parent record ID: " + parentId.getId());
						}
						System.out.println("Note Editable: " + note.getEditable());
						System.out.println("Note SharingPermission: " + note.getSharingPermission());
						System.out.println("Note IsSharedToClient: " + note.getIsSharedToClient());
						com.zoho.crm.api.users.MinifiedUser modifiedBy = note.getModifiedBy();
						if (modifiedBy != null)
						{
							System.out.println("Note Modified By User-Name: " + modifiedBy.getName());
							System.out.println("Note Modified By User-ID: " + modifiedBy.getId());
							System.out.println("Note Modified By User-Email: " + modifiedBy.getEmail());
						}
						System.out.println("Note Size: " + note.getSize());
						System.out.println("Note State: " + note.getState());
						System.out.println("Note VoiceNote: " + note.getVoiceNote());
						System.out.println("Note Id: " + note.getId());
						com.zoho.crm.api.users.MinifiedUser createdBy = note.getCreatedBy();
						if (createdBy != null)
						{
							System.out.println("Note Created By User-Name: " + createdBy.getName());
							System.out.println("Note Created By User-ID: " + createdBy.getId());
							System.out.println("Note Created By User-Email: " + createdBy.getEmail());
						}
						System.out.println("Note NoteTitle: " + note.getNoteTitle());
						System.out.println("Note NoteContent: " + note.getNoteContent());
					}
					Info info = responseWrapper.getInfo();
					if (info != null)
					{
						if (info.getPerPage() != null)
						{
							System.out.println("Note Info PerPage: " + info.getPerPage().toString());
						}
						if (info.getCount() != null)
						{
							System.out.println("Note Info Count: " + info.getCount().toString());
						}
						if (info.getPage() != null)
						{
							System.out.println("Note Info Page: " + info.getPage());
						}
						if (info.getMoreRecords() != null)
						{
							System.out.println("Note Info MoreRecords: " + info.getMoreRecords().toString());
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
					System.out.println("Message: " + exception.getMessage().getValue());
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

	private static void printAttachment(Attachment attachment)
	{
		com.zoho.crm.api.users.MinifiedUser owner = attachment.getOwner();
		if (owner != null)
		{
			System.out.println("Note Attachment Owner User-Name: " + owner.getName());
			System.out.println("Note Attachment Owner User-ID: " + owner.getId());
			System.out.println("Note Attachment Owner User-Email: " + owner.getEmail());
		}
		System.out.println("Note Attachment Modified Time: " + attachment.getModifiedTime().toString());
		System.out.println("Note Attachment File Name: " + attachment.getFileName());
		System.out.println("Note Attachment Created Time: " + attachment.getCreatedTime().toString());
		System.out.println("Note Attachment File Size: " + attachment.getSize().toString());
		ParentId parentId = attachment.getParentId();
		if (parentId != null)
		{
			System.out.println("Note Attachment parent record Name: " + parentId.getName());
			System.out.println("Note Attachment parent record ID: " + parentId.getId());
		}
		System.out.println("Note Attachment is Editable: " + attachment.getEditable().toString());
		System.out.println("Note Attachment is SharingPermission: " + attachment.getSharingPermission().toString());
		System.out.println("Note Attachment File ID: " + attachment.getFileId());
		System.out.println("Note Attachment File Type: " + attachment.getType());
		System.out.println("Note Attachment seModule: " + attachment.getSeModule());
		com.zoho.crm.api.users.MinifiedUser modifiedBy = attachment.getModifiedBy();
		if (modifiedBy != null)
		{
			System.out.println("Note Attachment Modified By User-Name: " + modifiedBy.getName());
			System.out.println("Note Attachment Modified By User-ID: " + modifiedBy.getId());
			System.out.println("Note Attachment Modified By User-Email: " + modifiedBy.getEmail());
		}
		System.out.println("Note Attachment State: " + attachment.getState());
		System.out.println("Note Attachment ID: " + attachment.getId());
		com.zoho.crm.api.users.MinifiedUser createdBy = attachment.getCreatedBy();
		if (createdBy != null)
		{
			System.out.println("Note Attachment Created By User-Name: " + createdBy.getName());
			System.out.println("Note Attachment Created By User-ID: " + createdBy.getId());
			System.out.println("Note Attachment Created By User-Email: " + createdBy.getEmail());
		}
		System.out.println("Note Attachment LinkUrl: " + attachment.getLinkUrl());
	}

	public static void main(String[] args)
	{
		try
		{
			Environment environment = USDataCenter.PRODUCTION;
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").redirectURL("Redirect_URL").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			getNotes();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
