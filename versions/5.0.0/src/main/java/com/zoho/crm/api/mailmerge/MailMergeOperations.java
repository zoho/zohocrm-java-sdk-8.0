package com.zoho.crm.api.mailmerge;

import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class MailMergeOperations
{
	private String id;

	private String module;

	/**
	 * Creates an instance of MailMergeOperations with the given parameters
	 * @param module A String representing the module
	 * @param id A String representing the id
	 */
	public MailMergeOperations(String module, String id)
	{
		 this.module = module;

		 this.id = id;


	}

	/**
	 * The method to send mail merge
	 * @param request An instance of MailMergeWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> sendMailMerge(MailMergeWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.module.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat( this.id.toString());

		apiPath = apiPath.concat("/actions/send_mail_merge");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_CREATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to download mail merge
	 * @param request An instance of DownloadMailMergeWrapper
	 * @return An instance of APIResponse<DownloadResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<DownloadResponseHandler> downloadMailMerge(DownloadMailMergeWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.module.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat( this.id.toString());

		apiPath = apiPath.concat("/actions/download_mail_merge");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_CREATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		return handlerInstance.apiCall(DownloadResponseHandler.class, "application/json");

	}

	/**
	 * The method to sign mail merge
	 * @param request An instance of SignMailMergeWrapper
	 * @return An instance of APIResponse<SignActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<SignActionHandler> signMailMerge(SignMailMergeWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.module.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat( this.id.toString());

		apiPath = apiPath.concat("/actions/sign_mail_merge");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_CREATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		return handlerInstance.apiCall(SignActionHandler.class, "application/json");

	}
}