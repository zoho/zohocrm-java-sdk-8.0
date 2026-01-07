package com.zoho.crm.api.sendmail;

import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class SendMailOperations
{
	private String modulename;

	private Long id;

	/**
	 * Creates an instance of SendMailOperations with the given parameters
	 * @param id A Long representing the id
	 * @param modulename A String representing the modulename
	 */
	public SendMailOperations(Long id, String modulename)
	{
		 this.id = id;

		 this.modulename = modulename;


	}

	/**
	 * The method to send mail
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> sendMail(BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.modulename.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat( this.id.toString());

		apiPath = apiPath.concat("/actions/send_mail");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_CREATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}
}