package com.zoho.crm.api.recyclebin;

import com.zoho.crm.api.Param;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class RecycleBinOperations
{
	/**
	 * The method to get recyclebin records
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getRecyclebinRecords(ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/recycle_bin");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.setParam(paramInstance);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to delete recyclebin records
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> deleteRecyclebinRecords(ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/recycle_bin");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.setParam(paramInstance);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to get recyclebin record
	 * @param recordId A Long representing the recordId
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getRecyclebinRecord(Long recordId) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/recycle_bin/");

		apiPath = apiPath.concat(recordId.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to delete recyclebin record
	 * @param recordId A Long representing the recordId
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> deleteRecyclebinRecord(Long recordId) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/recycle_bin/");

		apiPath = apiPath.concat(recordId.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}
	public static class GetRecycleBinRecordsParam
	{
		public static final Param<String> IDS = new Param<String>("ids", "com.zoho.crm.api.RecycleBin.GetRecycleBinRecordsParam");

		public static final Param<String> SORT_BY = new Param<String>("sort_by", "com.zoho.crm.api.RecycleBin.GetRecycleBinRecordsParam");

		public static final Param<String> SORT_ORDER = new Param<String>("sort_order", "com.zoho.crm.api.RecycleBin.GetRecycleBinRecordsParam");

		public static final Param<Integer> PAGE = new Param<Integer>("page", "com.zoho.crm.api.RecycleBin.GetRecycleBinRecordsParam");

		public static final Param<Integer> PER_PAGE = new Param<Integer>("per_page", "com.zoho.crm.api.RecycleBin.GetRecycleBinRecordsParam");

		public static final Param<String> FILTERS = new Param<String>("filters", "com.zoho.crm.api.RecycleBin.GetRecycleBinRecordsParam");

	}

	public static class DeleteRecycleBinRecordsParam
	{
		public static final Param<String> FILTERS = new Param<String>("filters", "com.zoho.crm.api.RecycleBin.DeleteRecycleBinRecordsParam");

		public static final Param<String> IDS = new Param<String>("ids", "com.zoho.crm.api.RecycleBin.DeleteRecycleBinRecordsParam");

	}
}