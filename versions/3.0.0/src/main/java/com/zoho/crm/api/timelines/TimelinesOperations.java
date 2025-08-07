package com.zoho.crm.api.timelines;

import com.zoho.crm.api.Param;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class TimelinesOperations
{
	/**
	 * The method to get timelines
	 * @param module A String representing the module
	 * @param recordId A String representing the recordId
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getTimelines(String module, String recordId, ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat(module.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(recordId.toString());

		apiPath = apiPath.concat("/__timeline");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.setParam(paramInstance);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}
	public static class GetTimelinesParam
	{
		public static final Param<Choice<String>> INCLUDE_INNER_DETAILS = new Param<Choice<String>>("include_inner_details", "com.zoho.crm.api.Timelines.GetTimelinesParam");

		public static final Param<String> SORT_BY = new Param<String>("sort_by", "com.zoho.crm.api.Timelines.GetTimelinesParam");

		public static final Param<Choice<String>> SORT_ORDER = new Param<Choice<String>>("sort_order", "com.zoho.crm.api.Timelines.GetTimelinesParam");

		public static final Param<String> INCLUDE_TIMELINE_TYPE = new Param<String>("include_timeline_type", "com.zoho.crm.api.Timelines.GetTimelinesParam");

		public static final Param<Choice<String>> INCLUDE = new Param<Choice<String>>("include", "com.zoho.crm.api.Timelines.GetTimelinesParam");

		public static final Param<String> FILTERS = new Param<String>("filters", "com.zoho.crm.api.Timelines.GetTimelinesParam");

		public static final Param<String> PER_PAGE = new Param<String>("per_page", "com.zoho.crm.api.Timelines.GetTimelinesParam");

		public static final Param<String> PAGE = new Param<String>("page", "com.zoho.crm.api.Timelines.GetTimelinesParam");

		public static final Param<String> PAGE_TOKEN = new Param<String>("page_token", "com.zoho.crm.api.Timelines.GetTimelinesParam");

	}
}