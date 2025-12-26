package com.zoho.crm.api.recordshareemail;

import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class RecordShareEmailOperations
{
	private String moduleAPIName;

	/**
	 * Creates an instance of RecordShareEmailOperations with the given parameters
	 * @param moduleAPIName A String representing the moduleAPIName
	 */
	public RecordShareEmailOperations(String moduleAPIName)
	{
		 this.moduleAPIName = moduleAPIName;


	}

	/**
	 * The method to share emails
	 * @param id A Long representing the id
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> shareEmails(Long id) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(id.toString());

		apiPath = apiPath.concat("/actions/share_emails");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_ACTION);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to unshare emails
	 * @param id A Long representing the id
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> unshareEmails(Long id) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(id.toString());

		apiPath = apiPath.concat("/actions/unshare_emails");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_ACTION);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to share bulk emails
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> shareBulkEmails(BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/actions/share_emails");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_ACTION);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to unshare bulk emails
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> unshareBulkEmails(BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/actions/unshare_emails");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_ACTION);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}
}