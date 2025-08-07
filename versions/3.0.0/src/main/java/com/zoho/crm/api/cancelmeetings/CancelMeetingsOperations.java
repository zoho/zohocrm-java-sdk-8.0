package com.zoho.crm.api.cancelmeetings;

import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class CancelMeetingsOperations
{
	private Long event;

	/**
	 * Creates an instance of CancelMeetingsOperations with the given parameters
	 * @param event A Long representing the event
	 */
	public CancelMeetingsOperations(Long event)
	{
		 this.event = event;


	}

	/**
	 * The method to cancel meetings
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> cancelMeetings(BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/Events/");

		apiPath = apiPath.concat( this.event.toString());

		apiPath = apiPath.concat("/actions/cancel");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_ACTION);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}
}