package com.zoho.crm.api.tags;

import com.zoho.crm.api.Param;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class TagsOperations
{
	/**
	 * The method to get tags
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getTags(ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/tags");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.setParam(paramInstance);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to create tags
	 * @param request An instance of BodyWrapper
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> createTags(BodyWrapper request, ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/tags");

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
	 * The method to update tags
	 * @param request An instance of BodyWrapper
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> updateTags(BodyWrapper request, ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/tags");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_UPDATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.setParam(paramInstance);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to update tag
	 * @param id A Long representing the id
	 * @param request An instance of BodyWrapper
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> updateTag(Long id, BodyWrapper request, ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/tags/");

		apiPath = apiPath.concat(id.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_UPDATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setParam(paramInstance);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to delete tag
	 * @param id A Long representing the id
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> deleteTag(Long id) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/tags/");

		apiPath = apiPath.concat(id.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to merge tags
	 * @param id A Long representing the id
	 * @param request An instance of MergeWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> mergeTags(Long id, MergeWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/tags/");

		apiPath = apiPath.concat(id.toString());

		apiPath = apiPath.concat("/actions/merge");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_CREATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to add tags
	 * @param moduleAPIName A String representing the moduleAPIName
	 * @param recordId A Long representing the recordId
	 * @param request An instance of NewTagRequestWrapper
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<RecordActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<RecordActionHandler> addTags(String moduleAPIName, Long recordId, NewTagRequestWrapper request, ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat(moduleAPIName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(recordId.toString());

		apiPath = apiPath.concat("/actions/add_tags");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_CREATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.setParam(paramInstance);

		return handlerInstance.apiCall(RecordActionHandler.class, "application/json");

	}

	/**
	 * The method to remove tags
	 * @param moduleAPIName A String representing the moduleAPIName
	 * @param recordId A Long representing the recordId
	 * @param request An instance of ExistingTagRequestWrapper
	 * @return An instance of APIResponse<RecordActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<RecordActionHandler> removeTags(String moduleAPIName, Long recordId, ExistingTagRequestWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat(moduleAPIName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(recordId.toString());

		apiPath = apiPath.concat("/actions/remove_tags");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_CREATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		return handlerInstance.apiCall(RecordActionHandler.class, "application/json");

	}

	/**
	 * The method to add tags to multiple records
	 * @param moduleAPIName A String representing the moduleAPIName
	 * @param request An instance of NewTagRequestWrapper
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<RecordActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<RecordActionHandler> addTagsToMultipleRecords(String moduleAPIName, NewTagRequestWrapper request, ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat(moduleAPIName.toString());

		apiPath = apiPath.concat("/actions/add_tags");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_CREATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.setParam(paramInstance);

		return handlerInstance.apiCall(RecordActionHandler.class, "application/json");

	}

	/**
	 * The method to remove tags from multiple records
	 * @param moduleAPIName A String representing the moduleAPIName
	 * @param request An instance of ExistingTagRequestWrapper
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<RecordActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<RecordActionHandler> removeTagsFromMultipleRecords(String moduleAPIName, ExistingTagRequestWrapper request, ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat(moduleAPIName.toString());

		apiPath = apiPath.concat("/actions/remove_tags");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_CREATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.setParam(paramInstance);

		return handlerInstance.apiCall(RecordActionHandler.class, "application/json");

	}

	/**
	 * The method to get record count for tag
	 * @param id A Long representing the id
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getRecordCountForTag(Long id, ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/tags/");

		apiPath = apiPath.concat(id.toString());

		apiPath = apiPath.concat("/actions/records_count");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.setParam(paramInstance);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}
	public static class GetTagsParam
	{
		public static final Param<String> MODULE = new Param<String>("module", "com.zoho.crm.api.Tags.GetTagsParam");

		public static final Param<String> MY_TAGS = new Param<String>("my_tags", "com.zoho.crm.api.Tags.GetTagsParam");

		public static final Param<String> INCLUDE = new Param<String>("include", "com.zoho.crm.api.Tags.GetTagsParam");

	}

	public static class CreateTagsParam
	{
		public static final Param<String> MODULE = new Param<String>("module", "com.zoho.crm.api.Tags.CreateTagsParam");

		public static final Param<String> COLOR_CODE = new Param<String>("color_code", "com.zoho.crm.api.Tags.CreateTagsParam");

	}

	public static class UpdateTagsParam
	{
		public static final Param<String> MODULE = new Param<String>("module", "com.zoho.crm.api.Tags.UpdateTagsParam");

	}

	public static class UpdateTagParam
	{
		public static final Param<String> MODULE = new Param<String>("module", "com.zoho.crm.api.Tags.UpdateTagParam");

	}

	public static class AddTagsParam
	{
		public static final Param<String> OVER_WRITE = new Param<String>("over_write", "com.zoho.crm.api.Tags.AddTagsParam");

	}

	public static class AddTagsToMultipleRecordsParam
	{
		public static final Param<String> OVER_WRITE = new Param<String>("over_write", "com.zoho.crm.api.Tags.AddTagsToMultipleRecordsParam");

	}

	public static class RemoveTagsFromMultipleRecordsParam
	{
		public static final Param<String> IDS = new Param<String>("ids", "com.zoho.crm.api.Tags.RemoveTagsFromMultipleRecordsParam");

	}

	public static class GetRecordCountForTagParam
	{
		public static final Param<String> MODULE = new Param<String>("module", "com.zoho.crm.api.Tags.GetRecordCountForTagParam");

	}
}