package com.zoho.crm.api.fieldattachments;

import com.zoho.crm.api.Param;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class FieldAttachmentsOperations
{
	private Long fieldsAttachmentId;

	private Long recordId;

	private String moduleAPIName;

	/**
	 * Creates an instance of FieldAttachmentsOperations with the given parameters
	 * @param moduleAPIName A String representing the moduleAPIName
	 * @param recordId A Long representing the recordId
	 * @param fieldsAttachmentId A Long representing the fieldsAttachmentId
	 */
	public FieldAttachmentsOperations(String moduleAPIName, Long recordId, Long fieldsAttachmentId)
	{
		 this.moduleAPIName = moduleAPIName;

		 this.recordId = recordId;

		 this.fieldsAttachmentId = fieldsAttachmentId;


	}

	/**
	 * The method to get field attachments
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getFieldAttachments() throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat( this.recordId.toString());

		apiPath = apiPath.concat("/actions/download_fields_attachment");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.addParam(new Param<Long>("fields_attachment_id", "com.zoho.crm.api.FieldAttachments.GetFieldAttachmentsParam"),  this.fieldsAttachmentId);

		return handlerInstance.apiCall(ResponseHandler.class, "application/x-download");

	}
	public static class GetFieldAttachmentsParam
	{
	}
}