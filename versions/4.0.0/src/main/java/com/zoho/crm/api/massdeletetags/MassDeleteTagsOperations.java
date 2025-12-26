package com.zoho.crm.api.massdeletetags;

import com.zoho.crm.api.Param;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class MassDeleteTagsOperations
{
	/**
	 * The method to mass delete tags
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionResponse>
	 * @throws SDKException
	 */
	public APIResponse<ActionResponse> massDeleteTags(BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/tags/actions/mass_delete");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_ACTION);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		return handlerInstance.apiCall(ActionResponse.class, "application/json");

	}

	/**
	 * The method to get status
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<StatusResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<StatusResponseHandler> getStatus(ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/tags/actions/mass_delete");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.setParam(paramInstance);

		return handlerInstance.apiCall(StatusResponseHandler.class, "application/json");

	}
	public static class GetStatusParam
	{
		public static final Param<String> JOB_ID = new Param<String>("job_id", "com.zoho.crm.api.MassDeleteTags.GetStatusParam");

	}
}