package samples.relatedrecords;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
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
import com.zoho.crm.api.record.Comment;
import com.zoho.crm.api.record.Consent;
import com.zoho.crm.api.record.FileDetails;
import com.zoho.crm.api.record.ImageUpload;
import com.zoho.crm.api.record.LineTax;
import com.zoho.crm.api.record.PricingDetails;
import com.zoho.crm.api.relatedrecords.APIException;
import com.zoho.crm.api.relatedrecords.FileBodyWrapper;
import com.zoho.crm.api.relatedrecords.RelatedRecordsOperations;
import com.zoho.crm.api.relatedrecords.ResponseHandler;
import com.zoho.crm.api.relatedrecords.ResponseWrapper;
import com.zoho.crm.api.relatedrecords.RelatedRecordsOperations.GetRelatedRecordUsingExternalIDHeader;
import com.zoho.crm.api.tags.Tag;
import com.zoho.crm.api.users.MinifiedUser;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import com.zoho.crm.api.util.StreamWrapper;

public class GetRelatedRecordUsingExternalId
{
	public static void getRelatedRecordUsingExternalId(String moduleAPIName, String externalValue, String relatedListAPIName, String externalFieldValue, String destinationFolder) throws Exception
	{
		String xExternal = "Leads.External,Products.Products_External";
		RelatedRecordsOperations relatedRecordsOperations = new RelatedRecordsOperations(relatedListAPIName, moduleAPIName);
		ParameterMap paramInstance = new ParameterMap();
		HeaderMap headerInstance = new HeaderMap();
		OffsetDateTime startdatetime = OffsetDateTime.of(2019, 06, 01, 10, 00, 01, 00, ZoneOffset.of("+05:30"));
		headerInstance.add(GetRelatedRecordUsingExternalIDHeader.IF_MODIFIED_SINCE, startdatetime);
		headerInstance.add(GetRelatedRecordUsingExternalIDHeader.X_EXTERNAL, xExternal);
		APIResponse<ResponseHandler> response = relatedRecordsOperations.getRelatedRecordUsingExternalId(externalFieldValue, externalValue, paramInstance, headerInstance);
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
					List<com.zoho.crm.api.record.Record> records = responseWrapper.getData();
					for (com.zoho.crm.api.record.Record record : records)
					{
						System.out.println("RelatedRecord ID: " + record.getId());
						com.zoho.crm.api.users.MinifiedUser createdBy = record.getCreatedBy();
						if (createdBy != null)
						{
							System.out.println("RelatedRecord Created By User-ID: " + createdBy.getId());
							System.out.println("RelatedRecord Created By User-Name: " + createdBy.getName());
							System.out.println("RelatedRecord Created By User-Email: " + createdBy.getEmail());
						}
						System.out.println("RelatedRecord CreatedTime: " + record.getCreatedTime());
						com.zoho.crm.api.users.MinifiedUser modifiedBy = record.getModifiedBy();
						if (modifiedBy != null)
						{
							System.out.println("RelatedRecord Modified By User-ID: " + modifiedBy.getId());
							System.out.println("RelatedRecord Modified By User-Name: " + modifiedBy.getName());
							System.out.println("RelatedRecord Modified By User-Email: " + modifiedBy.getEmail());
						}
						System.out.println("RelatedRecord ModifiedTime: " + record.getModifiedTime());
						List<Tag> tags = record.getTag();
						if (tags != null)
						{
							for (Tag tag : tags)
							{
								System.out.println("RelatedRecord Tag Name: " + tag.getName());
								System.out.println("RelatedRecord Tag ID: " + tag.getId());
							}
						}
						// To get particular field value
						System.out.println("RelatedRecord Field Value: " + record.getKeyValue("Last_Name"));// FieldApiName
						System.out.println("RelatedRecord KeyValues: ");
						for (Map.Entry<String, Object> entry : record.getKeyValues().entrySet())
						{
							String keyName = entry.getKey();
							Object value = entry.getValue();
							if (value instanceof List)
							{
								List<?> dataList = (List<?>) value;
								if (dataList.size() > 0)
								{
									if (dataList.get(0) instanceof FileDetails)
									{
										@SuppressWarnings("unchecked")
										List<FileDetails> fileDetails = (List<FileDetails>) value;
										for (FileDetails fileDetail : fileDetails)
										{
											System.out.println("Record FileDetails FileIds: " + fileDetail.getFileIdS());
											System.out.println("Record FileDetails FileNameS: " + fileDetail.getFileNameS());
											System.out.println("Record FileDetails SizeS: " + fileDetail.getSizeS());
											System.out.println("Record FileDetails Id: " + fileDetail.getId());
										}
									}
									else if (dataList.get(0) instanceof Tag)
									{
										@SuppressWarnings("unchecked")
										List<Tag> tagList = (List<Tag>) value;
										for (Tag tag : tagList)
										{
											System.out.println("RelatedRecord Tag Name: " + tag.getName());
											System.out.println("RelatedRecord Tag ID: " + tag.getId());
										}
									}
									else if (dataList.get(0) instanceof PricingDetails)
									{
										@SuppressWarnings("unchecked")
										List<PricingDetails> pricingDetails = (List<PricingDetails>) value;
										for (PricingDetails pricingDetail : pricingDetails)
										{
											System.out.println("RelatedRecord PricingDetails ToRange: " + pricingDetail.getToRange().toString());
											System.out.println("RelatedRecord PricingDetails Discount: " + pricingDetail.getDiscount().toString());
											System.out.println("RelatedRecord PricingDetails ID: " + pricingDetail.getId());
											System.out.println("RelatedRecord PricingDetails FromRange: " + pricingDetail.getFromRange().toString());
										}
									}
									else if (dataList.get(0) instanceof com.zoho.crm.api.record.Record)
									{
										@SuppressWarnings("unchecked")
										List<com.zoho.crm.api.record.Record> recordList = (List<com.zoho.crm.api.record.Record>) dataList;
										for (com.zoho.crm.api.record.Record record1 : recordList)
										{
											for (Map.Entry<String, Object> entry1 : record1.getKeyValues().entrySet())
											{
												System.out.println(entry1.getKey() + ": " + entry1.getValue());
											}
										}
									}
									else if (dataList.get(0) instanceof LineTax)
									{
										@SuppressWarnings("unchecked")
										List<LineTax> lineTaxes = (List<LineTax>) dataList;
										for (LineTax lineTax : lineTaxes)
										{
											System.out.println("RelatedRecord ProductDetails LineTax Percentage: " + lineTax.getPercentage().toString());
											System.out.println("RelatedRecord ProductDetails LineTax Name: " + lineTax.getName());
											System.out.println("RelatedRecord ProductDetails LineTax Id: " + lineTax.getId());
											System.out.println("RelatedRecord ProductDetails LineTax Value: " + lineTax.getValue().toString());
										}
									}
									else if (dataList.get(0) instanceof Choice)
									{
										@SuppressWarnings({ "unchecked", "rawtypes" })
										List<Choice> choice = (List<Choice>) dataList;
										for (@SuppressWarnings("rawtypes")
										Choice choiceValue : choice)
										{
											System.out.println("RelatedRecord " + keyName + " : " + choiceValue.getValue());
										}
									}
									else if (dataList.get(0) instanceof Comment)
									{
										@SuppressWarnings("unchecked")
										List<Comment> comments = (List<Comment>) dataList;
										for (Comment comment : comments)
										{
											System.out.println("Record Comment CommentedBy: " + comment.getCommentedBy());
											System.out.println("Record Comment CommentedTime: " + comment.getCommentedTime().toString());
											System.out.println("Record Comment CommentContent: " + comment.getCommentContent());
											System.out.println("Record Comment Id: " + comment.getId());
										}
									}
									else if (dataList.get(0) instanceof ImageUpload)
									{
										@SuppressWarnings("unchecked")
										List<ImageUpload> imageUploads = (List<ImageUpload>) dataList;
										for (ImageUpload imageUpload : imageUploads)
										{
											System.out.println("Record  Description: " + imageUpload.getDescriptionS());
											System.out.println("Record  FileIds: " + imageUpload.getFileIdS());
											System.out.println("Record  FileNameS: " + imageUpload.getFileNameS());
											System.out.println("Record PreviewIdS: " + imageUpload.getPreviewIdS());
											System.out.println("Record  SizeS: " + imageUpload.getSizeS());
											System.out.println("Record  States: " + imageUpload.getStateS());
											System.out.println("Record  ID: " + imageUpload.getId());
											System.out.println("Record  SequenceNumber: " + imageUpload.getSequenceNumberS());
										}
									}
									else if (dataList.get(0) instanceof Attachment)
									{
										@SuppressWarnings("unchecked")
										List<com.zoho.crm.api.attachments.Attachment> attachments = (List<Attachment>) dataList;
										for (com.zoho.crm.api.attachments.Attachment attachment : attachments)
										{
											com.zoho.crm.api.users.MinifiedUser owner = attachment.getOwner();
											if (owner != null)
											{
												System.out.println("Record Attachment Owner User-Name: " + owner.getName());
												System.out.println("Record Attachment Owner User-ID: " + owner.getId());
												System.out.println("Record Attachment Owner User-Email: " + owner.getEmail());
											}
											System.out.println("Record Attachment Modified Time: " + attachment.getModifiedTime().toString());
											System.out.println("Record Attachment File Name: " + attachment.getFileName());
											System.out.println("Record Attachment Created Time: " + attachment.getCreatedTime().toString());
											System.out.println("Record Attachment File Size: " + attachment.getSize().toString());
											ParentId parentId = attachment.getParentId();
											if (parentId != null)
											{
												System.out.println("Record Attachment parent record Name: " + parentId.getName());
												System.out.println("Record Attachment parent record ID: " + parentId.getId());
											}
											System.out.println("Record Attachment is Editable: " + attachment.getEditable().toString());
											System.out.println("Record Attachment File ID: " + attachment.getFileId());
											System.out.println("Record Attachment File Type: " + attachment.getType());
											System.out.println("Record Attachment seModule: " + attachment.getSeModule());
											modifiedBy = attachment.getModifiedBy();
											if (modifiedBy != null)
											{
												System.out.println("Record Attachment Modified By User-Name: " + modifiedBy.getName());
												System.out.println("Record Attachment Modified By User-ID: " + modifiedBy.getId());
												System.out.println("Record Attachment Modified By User-Email: " + modifiedBy.getEmail());
											}
											System.out.println("Record Attachment State: " + attachment.getState());
											System.out.println("Record Attachment ID: " + attachment.getId());
											createdBy = attachment.getCreatedBy();
											if (createdBy != null)
											{
												System.out.println("Record Attachment Created By User-Name: " + createdBy.getName());
												System.out.println("Record Attachment Created By User-ID: " + createdBy.getId());
												System.out.println("Record Attachment Created By User-Email: " + createdBy.getEmail());
											}
											System.out.println("Record Attachment LinkUrl: " + attachment.getLinkUrl());
										}
									}
									else
									{
										System.out.println(keyName + ": " + value);
									}
								}
							}
							else if (value instanceof com.zoho.crm.api.layouts.Layouts)
							{
								com.zoho.crm.api.layouts.Layouts layout = (com.zoho.crm.api.layouts.Layouts) value;
								if (layout != null)
								{
									System.out.println("RelatedRecord " + keyName + " ID: " + layout.getId());
									System.out.println("RelatedRecord " + keyName + " Name: " + layout.getName());
								}
							}
							else if (value instanceof MinifiedUser)
							{
								com.zoho.crm.api.users.MinifiedUser user = (MinifiedUser) value;
								if (user != null)
								{
									System.out.println("RelatedRecord " + keyName + " User-ID: " + user.getId());
									System.out.println("RelatedRecord " + keyName + " User-Name: " + user.getName());
									System.out.println("RelatedRecord " + keyName + " User-Email: " + user.getEmail());
								}
							}
							else if (value instanceof com.zoho.crm.api.record.Record)
							{
								com.zoho.crm.api.record.Record recordValue = (com.zoho.crm.api.record.Record) value;
								System.out.println("RelatedRecord " + keyName + " ID: " + recordValue.getId());
								System.out.println("RelatedRecord " + keyName + " Name: " + recordValue.getKeyValue("name"));
							}
							else if (value instanceof Choice)
							{
								@SuppressWarnings("rawtypes")
								Choice choiceValue = (Choice) value;
								System.out.println("RelatedRecord " + keyName + " : " + choiceValue.getValue());
							}
							else if (value instanceof Consent)
							{
								Consent consent = (Consent) value;
								System.out.println("Record Consent ID: " + consent.getId());
								MinifiedUser owner = consent.getOwner();
								if (owner != null)
								{
									System.out.println("Record Consent Owner Name: " + owner.getName());
									System.out.println("Record Consent Owner ID: " + owner.getId());
									System.out.println("Record Consent Owner Email: " + owner.getEmail());
								}
								MinifiedUser consentCreatedBy = consent.getCreatedBy();
								if (consentCreatedBy != null)
								{
									System.out.println("Record Consent CreatedBy Name: " + consentCreatedBy.getName());
									System.out.println("Record Consent CreatedBy ID: " + consentCreatedBy.getId());
									System.out.println("Record Consent CreatedBy Email: " + consentCreatedBy.getEmail());
								}
								MinifiedUser consentModifiedBy = consent.getModifiedBy();
								if (consentModifiedBy != null)
								{
									System.out.println("Record Consent ModifiedBy Name: " + consentModifiedBy.getName());
									System.out.println("Record Consent ModifiedBy ID: " + consentModifiedBy.getId());
									System.out.println("Record Consent ModifiedBy Email: " + consentModifiedBy.getEmail());
								}
								System.out.println("Record Consent CreatedTime: " + consent.getCreatedTime());
								System.out.println("Record Consent ModifiedTime: " + consent.getModifiedTime());
								System.out.println("Record Consent ContactThroughEmail: " + consent.getContactThroughEmail());
								System.out.println("Record Consent ContactThroughSocial: " + consent.getContactThroughSocial());
								System.out.println("Record Consent ContactThroughSurvey: " + consent.getContactThroughSurvey());
								System.out.println("Record Consent ContactThroughPhone: " + consent.getContactThroughPhone());
								System.out.println("Record Consent MailSentTime: " + consent.getMailSentTime().toString());
								System.out.println("Record Consent ConsentDate: " + consent.getConsentDate().toString());
								System.out.println("Record Consent ConsentRemarks: " + consent.getConsentRemarks());
								System.out.println("Record Consent ConsentThrough: " + consent.getConsentThrough());
								System.out.println("Record Consent DataProcessingBasis: " + consent.getDataProcessingBasis());
								// To get custom values
								System.out.println("Record Consent Lawful Reason: " + consent.getKeyValue("Lawful_Reason"));
							}
							else
							{
								System.out.println(keyName + ": " + value);
							}
						}
					}
				}
				else if (responseHandler instanceof FileBodyWrapper)
				{
					FileBodyWrapper fileBodyWrapper = (FileBodyWrapper) responseHandler;
					StreamWrapper streamWrapper = fileBodyWrapper.getFile();
					File file = new File(destinationFolder + File.separatorChar + streamWrapper.getName());
					InputStream is = streamWrapper.getStream();
					OutputStream os = new FileOutputStream(file);
					byte[] buffer = new byte[1024];
					int bytesRead;
					while ((bytesRead = is.read(buffer)) != -1)
					{
						os.write(buffer, 0, bytesRead);
					}
					is.close();
					os.flush();
					os.close();
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
			String externalValue = "34770615177002";
			String relatedListAPIName = "Products";
			String externalFieldValue = "34770614994115";
			String destinationFolder = "/Users/zohocrm-java-sdk-sample/file/";
			getRelatedRecordUsingExternalId(moduleAPIName, externalValue, relatedListAPIName, externalFieldValue, destinationFolder);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
