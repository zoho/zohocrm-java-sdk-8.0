package com.zoho.crm.api.downloadattachments;

import com.zoho.crm.api.Param;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class DownloadAttachmentsOperations
{
	/**
	 * The method to get download attachments details
	 * @param recordId A Long representing the recordId
	 * @param module A String representing the module
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getDownloadAttachmentsDetails(Long recordId, String module, ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat(module.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(recordId.toString());

		apiPath = apiPath.concat("/Emails/actions/download_attachments");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.setParam(paramInstance);

		return handlerInstance.apiCall(ResponseHandler.class, "multipart/form-data");

	}
	public static class GetDownloadAttachmentsDetailsParam
	{
		public static final Param<Long> USER_ID = new Param<Long>("user_id", "com.zoho.crm.api.DownloadAttachments.GetDownloadAttachmentsDetailsParam");

		public static final Param<String> MESSAGE_ID = new Param<String>("message_id", "com.zoho.crm.api.DownloadAttachments.GetDownloadAttachmentsDetailsParam");

		public static final Param<String> ID = new Param<String>("id", "com.zoho.crm.api.DownloadAttachments.GetDownloadAttachmentsDetailsParam");

		public static final Param<String> NAME = new Param<String>("name", "com.zoho.crm.api.DownloadAttachments.GetDownloadAttachmentsDetailsParam");

	}
}