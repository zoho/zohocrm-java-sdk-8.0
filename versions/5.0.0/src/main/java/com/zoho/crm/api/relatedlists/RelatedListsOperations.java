package com.zoho.crm.api.relatedlists;

import com.zoho.crm.api.Param;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class RelatedListsOperations
{
	private Long layoutId;

	/**
	 * Creates an instance of RelatedListsOperations with the given parameters
	 * @param layoutId A Long representing the layoutId
	 */
	public RelatedListsOperations(Long layoutId)
	{
		 this.layoutId = layoutId;


	}

	/**
	 * The method to get related lists
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getRelatedLists(ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/related_lists");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.addParam(new Param<Long>("layout_id", "com.zoho.crm.api.RelatedLists.GetRelatedListsParam"),  this.layoutId);

		handlerInstance.setParam(paramInstance);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to get related list
	 * @param id A Long representing the id
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getRelatedList(Long id, ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/related_lists/");

		apiPath = apiPath.concat(id.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.addParam(new Param<Long>("layout_id", "com.zoho.crm.api.RelatedLists.GetRelatedListParam"),  this.layoutId);

		handlerInstance.setParam(paramInstance);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}
	public static class GetRelatedListsParam
	{
		public static final Param<String> MODULE = new Param<String>("module", "com.zoho.crm.api.RelatedLists.GetRelatedListsParam");

	}

	public static class GetRelatedListParam
	{
		public static final Param<String> MODULE = new Param<String>("module", "com.zoho.crm.api.RelatedLists.GetRelatedListParam");

	}
}