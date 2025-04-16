package com.zoho.crm.api.emailsharingdetails;

import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class EmailSharingDetailsOperations
{
	private String module;

	private Long recordId;

	/**
	 * Creates an instance of EmailSharingDetailsOperations with the given parameters
	 * @param recordId A Long representing the recordId
	 * @param module A String representing the module
	 */
	public EmailSharingDetailsOperations(Long recordId, String module)
	{
		 this.recordId = recordId;

		 this.module = module;


	}

	/**
	 * The method to get email sharing details
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getEmailSharingDetails() throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.module.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat( this.recordId.toString());

		apiPath = apiPath.concat("/__emails_sharing_details");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}
}