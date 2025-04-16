package com.zoho.crm.api.ziapeopleenrichment;

import com.zoho.crm.api.Param;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class ZiaPeopleEnrichmentOperations
{
	/**
	 * The method to get zia people enrichments
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getZiaPeopleEnrichments(ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/__zia_people_enrichment");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.setParam(paramInstance);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to create zia people enrichment
	 * @param request An instance of BodyWrapper
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> createZiaPeopleEnrichment(BodyWrapper request, ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/__zia_people_enrichment");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_CREATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.setParam(paramInstance);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to get zia people enrichment
	 * @param ziaPeopleEnrichmentId A Long representing the ziaPeopleEnrichmentId
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getZiaPeopleEnrichment(Long ziaPeopleEnrichmentId) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/__zia_people_enrichment/");

		apiPath = apiPath.concat(ziaPeopleEnrichmentId.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}
	public static class GetZiaPeopleEnrichmentsParam
	{
		public static final Param<Choice<String>> STATUS = new Param<Choice<String>>("status", "com.zoho.crm.api.ZiaPeopleEnrichment.GetZiaPeopleEnrichmentsParam");

		public static final Param<String> SORT_ORDER = new Param<String>("sort_order", "com.zoho.crm.api.ZiaPeopleEnrichment.GetZiaPeopleEnrichmentsParam");

		public static final Param<String> SORT_BY = new Param<String>("sort_by", "com.zoho.crm.api.ZiaPeopleEnrichment.GetZiaPeopleEnrichmentsParam");

		public static final Param<Integer> PAGE = new Param<Integer>("page", "com.zoho.crm.api.ZiaPeopleEnrichment.GetZiaPeopleEnrichmentsParam");

		public static final Param<Integer> PER_PAGE = new Param<Integer>("per_page", "com.zoho.crm.api.ZiaPeopleEnrichment.GetZiaPeopleEnrichmentsParam");

		public static final Param<Integer> COUNT = new Param<Integer>("count", "com.zoho.crm.api.ZiaPeopleEnrichment.GetZiaPeopleEnrichmentsParam");

	}

	public static class CreateZiaPeopleEnrichmentParam
	{
		public static final Param<String> MODULE = new Param<String>("module", "com.zoho.crm.api.ZiaPeopleEnrichment.CreateZiaPeopleEnrichmentParam");

		public static final Param<Long> RECORD_ID = new Param<Long>("record_id", "com.zoho.crm.api.ZiaPeopleEnrichment.CreateZiaPeopleEnrichmentParam");

	}
}