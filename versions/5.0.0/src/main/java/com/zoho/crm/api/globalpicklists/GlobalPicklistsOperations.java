package com.zoho.crm.api.globalpicklists;

import com.zoho.crm.api.Param;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class GlobalPicklistsOperations
{
	/**
	 * The method to get global picklists
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getGlobalPicklists(ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/global_picklists");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.setParam(paramInstance);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to create global picklist
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> createGlobalPicklist(BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/global_picklists");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_CREATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to update global picklists
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> updateGlobalPicklists(BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/global_picklists");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PATCH);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_UPDATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to delete global picklists
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> deleteGlobalPicklists(ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/global_picklists");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.setParam(paramInstance);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to get global picklist
	 * @param id A Long representing the id
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getGlobalPicklist(Long id, ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/global_picklists/");

		apiPath = apiPath.concat(id.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.setParam(paramInstance);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to update global picklist
	 * @param id A Long representing the id
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> updateGlobalPicklist(Long id, BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/global_picklists/");

		apiPath = apiPath.concat(id.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PATCH);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_UPDATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to delete global picklist
	 * @param id A Long representing the id
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> deleteGlobalPicklist(Long id) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/global_picklists/");

		apiPath = apiPath.concat(id.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to replace picklist values
	 * @param id A Long representing the id
	 * @param request An instance of ReplaceBodyWrapper
	 * @return An instance of APIResponse<ReplaceActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ReplaceActionHandler> replacePicklistValues(Long id, ReplaceBodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/global_picklists/");

		apiPath = apiPath.concat(id.toString());

		apiPath = apiPath.concat("/actions/replace_picklist_values");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_ACTION);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		return handlerInstance.apiCall(ReplaceActionHandler.class, "application/json");

	}

	/**
	 * The method to get replace values
	 * @param id A Long representing the id
	 * @return An instance of APIResponse<ReplacedResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ReplacedResponseHandler> getReplaceValues(Long id) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/global_picklists/");

		apiPath = apiPath.concat(id.toString());

		apiPath = apiPath.concat("/actions/replaced_values");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_ACTION);

		return handlerInstance.apiCall(ReplacedResponseHandler.class, "application/json");

	}

	/**
	 * The method to get associations
	 * @param id A Long representing the id
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<AssociationsResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<AssociationsResponseHandler> getAssociations(Long id, ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/global_picklists/");

		apiPath = apiPath.concat(id.toString());

		apiPath = apiPath.concat("/actions/associations");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_ACTION);

		handlerInstance.setParam(paramInstance);

		return handlerInstance.apiCall(AssociationsResponseHandler.class, "application/json");

	}

	/**
	 * The method to get pick list value associations
	 * @param id A Long representing the id
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<PickListValuesAssociationsResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<PickListValuesAssociationsResponseHandler> getPickListValueAssociations(Long id, ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/global_picklists/");

		apiPath = apiPath.concat(id.toString());

		apiPath = apiPath.concat("/actions/pick_list_values_associations");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_ACTION);

		handlerInstance.setParam(paramInstance);

		return handlerInstance.apiCall(PickListValuesAssociationsResponseHandler.class, "application/json");

	}
	public static class GetGlobalPicklistsParam
	{
		public static final Param<String> INCLUDE = new Param<String>("include", "com.zoho.crm.api.GlobalPicklists.GetGlobalPicklistsParam");

		public static final Param<String> INCLUDE_INNER_DETAILS = new Param<String>("include_inner_details", "com.zoho.crm.api.GlobalPicklists.GetGlobalPicklistsParam");

	}

	public static class DeleteGlobalPicklistsParam
	{
		public static final Param<String> IDS = new Param<String>("ids", "com.zoho.crm.api.GlobalPicklists.DeleteGlobalPicklistsParam");

	}

	public static class GetGlobalPicklistParam
	{
		public static final Param<String> INCLUDE = new Param<String>("include", "com.zoho.crm.api.GlobalPicklists.GetGlobalPicklistParam");

		public static final Param<String> INCLUDE_INNER_DETAILS = new Param<String>("include_inner_details", "com.zoho.crm.api.GlobalPicklists.GetGlobalPicklistParam");

	}

	public static class GetAssociationsParam
	{
		public static final Param<String> INCLUDE_INNER_DETAILS = new Param<String>("include_inner_details", "com.zoho.crm.api.GlobalPicklists.GetAssociationsParam");

		public static final Param<Integer> PAGE = new Param<Integer>("page", "com.zoho.crm.api.GlobalPicklists.GetAssociationsParam");

		public static final Param<Integer> PER_PAGE = new Param<Integer>("per_page", "com.zoho.crm.api.GlobalPicklists.GetAssociationsParam");

	}

	public static class GetPickListValueAssociationsParam
	{
		public static final Param<Long> PICKLIST_VALUE_ID = new Param<Long>("picklist_value_id", "com.zoho.crm.api.GlobalPicklists.GetPickListValueAssociationsParam");

	}
}