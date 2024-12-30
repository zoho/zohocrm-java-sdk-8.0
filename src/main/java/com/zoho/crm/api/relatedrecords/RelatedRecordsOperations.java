package com.zoho.crm.api.relatedrecords;

import com.zoho.crm.api.Header;
import com.zoho.crm.api.HeaderMap;
import com.zoho.crm.api.Param;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Utility;
import java.time.OffsetDateTime;
import com.zoho.crm.api.util.Constants;

public class RelatedRecordsOperations
{
	private String moduleAPIName;

	private String relatedListAPIName;

	/**
	 * Creates an instance of RelatedRecordsOperations with the given parameters
	 * @param relatedListAPIName A String representing the relatedListAPIName
	 * @param moduleAPIName A String representing the moduleAPIName
	 */
	public RelatedRecordsOperations(String relatedListAPIName, String moduleAPIName)
	{
		 this.relatedListAPIName = relatedListAPIName;

		 this.moduleAPIName = moduleAPIName;


	}

	/**
	 * The method to get related records
	 * @param recordId A Long representing the recordId
	 * @param paramInstance An instance of ParameterMap
	 * @param headerInstance An instance of HeaderMap
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getRelatedRecords(Long recordId, ParameterMap paramInstance, HeaderMap headerInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(recordId.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat( this.relatedListAPIName.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.setParam(paramInstance);

		handlerInstance.setHeader(headerInstance);

		Utility.getRelatedLists( this.relatedListAPIName,  this.moduleAPIName, handlerInstance);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to update related records
	 * @param recordId A Long representing the recordId
	 * @param request An instance of BodyWrapper
	 * @param headerInstance An instance of HeaderMap
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> updateRelatedRecords(Long recordId, BodyWrapper request, HeaderMap headerInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(recordId.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat( this.relatedListAPIName.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_UPDATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setHeader(headerInstance);

		Utility.getRelatedLists( this.relatedListAPIName,  this.moduleAPIName, handlerInstance);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to delink records
	 * @param recordId A Long representing the recordId
	 * @param paramInstance An instance of ParameterMap
	 * @param headerInstance An instance of HeaderMap
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> delinkRecords(Long recordId, ParameterMap paramInstance, HeaderMap headerInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(recordId.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat( this.relatedListAPIName.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.setParam(paramInstance);

		handlerInstance.setHeader(headerInstance);

		Utility.getFields( this.moduleAPIName, handlerInstance);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to get related records using external id
	 * @param externalValue A String representing the externalValue
	 * @param paramInstance An instance of ParameterMap
	 * @param headerInstance An instance of HeaderMap
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getRelatedRecordsUsingExternalId(String externalValue, ParameterMap paramInstance, HeaderMap headerInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(externalValue.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat( this.relatedListAPIName.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.setParam(paramInstance);

		handlerInstance.setHeader(headerInstance);

		Utility.getRelatedLists( this.relatedListAPIName,  this.moduleAPIName, handlerInstance);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to update related records using external id
	 * @param externalValue A String representing the externalValue
	 * @param request An instance of BodyWrapper
	 * @param headerInstance An instance of HeaderMap
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> updateRelatedRecordsUsingExternalId(String externalValue, BodyWrapper request, HeaderMap headerInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(externalValue.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat( this.relatedListAPIName.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_UPDATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setHeader(headerInstance);

		Utility.getRelatedLists( this.relatedListAPIName,  this.moduleAPIName, handlerInstance);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to delete related records using external id
	 * @param externalValue A String representing the externalValue
	 * @param paramInstance An instance of ParameterMap
	 * @param headerInstance An instance of HeaderMap
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> deleteRelatedRecordsUsingExternalId(String externalValue, ParameterMap paramInstance, HeaderMap headerInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(externalValue.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat( this.relatedListAPIName.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.setParam(paramInstance);

		handlerInstance.setHeader(headerInstance);

		Utility.getRelatedLists( this.relatedListAPIName,  this.moduleAPIName, handlerInstance);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to get related record
	 * @param relatedRecordId A Long representing the relatedRecordId
	 * @param recordId A Long representing the recordId
	 * @param paramInstance An instance of ParameterMap
	 * @param headerInstance An instance of HeaderMap
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getRelatedRecord(Long relatedRecordId, Long recordId, ParameterMap paramInstance, HeaderMap headerInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(recordId.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat( this.relatedListAPIName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(relatedRecordId.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.setParam(paramInstance);

		handlerInstance.setHeader(headerInstance);

		Utility.getRelatedLists( this.relatedListAPIName,  this.moduleAPIName, handlerInstance);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to update related record
	 * @param relatedRecordId A Long representing the relatedRecordId
	 * @param recordId A Long representing the recordId
	 * @param request An instance of BodyWrapper
	 * @param headerInstance An instance of HeaderMap
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> updateRelatedRecord(Long relatedRecordId, Long recordId, BodyWrapper request, HeaderMap headerInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(recordId.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat( this.relatedListAPIName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(relatedRecordId.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_UPDATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.setHeader(headerInstance);

		Utility.getRelatedLists( this.relatedListAPIName,  this.moduleAPIName, handlerInstance);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to delink record
	 * @param relatedRecordId A Long representing the relatedRecordId
	 * @param recordId A Long representing the recordId
	 * @param headerInstance An instance of HeaderMap
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> delinkRecord(Long relatedRecordId, Long recordId, HeaderMap headerInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(recordId.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat( this.relatedListAPIName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(relatedRecordId.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.setHeader(headerInstance);

		Utility.getFields( this.moduleAPIName, handlerInstance);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to get related record using external id
	 * @param externalFieldValue A String representing the externalFieldValue
	 * @param externalValue A String representing the externalValue
	 * @param paramInstance An instance of ParameterMap
	 * @param headerInstance An instance of HeaderMap
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getRelatedRecordUsingExternalId(String externalFieldValue, String externalValue, ParameterMap paramInstance, HeaderMap headerInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(externalValue.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat( this.relatedListAPIName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(externalFieldValue.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.setParam(paramInstance);

		handlerInstance.setHeader(headerInstance);

		Utility.getRelatedLists( this.relatedListAPIName,  this.moduleAPIName, handlerInstance);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to update related record using external id
	 * @param externalFieldValue A String representing the externalFieldValue
	 * @param externalValue A String representing the externalValue
	 * @param request An instance of BodyWrapper
	 * @param headerInstance An instance of HeaderMap
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> updateRelatedRecordUsingExternalId(String externalFieldValue, String externalValue, BodyWrapper request, HeaderMap headerInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(externalValue.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat( this.relatedListAPIName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(externalFieldValue.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_UPDATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.setHeader(headerInstance);

		Utility.getRelatedLists( this.relatedListAPIName,  this.moduleAPIName, handlerInstance);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to delete related record using external id
	 * @param externalFieldValue A String representing the externalFieldValue
	 * @param externalValue A String representing the externalValue
	 * @param headerInstance An instance of HeaderMap
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> deleteRelatedRecordUsingExternalId(String externalFieldValue, String externalValue, HeaderMap headerInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(externalValue.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat( this.relatedListAPIName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(externalFieldValue.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.setHeader(headerInstance);

		Utility.getRelatedLists( this.relatedListAPIName,  this.moduleAPIName, handlerInstance);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to get deleted parent records related record
	 * @param recordId A Long representing the recordId
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getDeletedParentRecordsRelatedRecord(Long recordId, ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/deleted/");

		apiPath = apiPath.concat(recordId.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat( this.relatedListAPIName.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.setParam(paramInstance);

		Utility.getRelatedLists( this.relatedListAPIName,  this.moduleAPIName, handlerInstance);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}
	public static class GetRelatedRecordsParam
	{
		public static final Param<Integer> PAGE = new Param<Integer>("page", "com.zoho.crm.api.RelatedRecords.GetRelatedRecordsParam");

		public static final Param<Integer> PER_PAGE = new Param<Integer>("per_page", "com.zoho.crm.api.RelatedRecords.GetRelatedRecordsParam");

		public static final Param<String> FIELDS = new Param<String>("fields", "com.zoho.crm.api.RelatedRecords.GetRelatedRecordsParam");

	}

	public static class GetRelatedRecordsHeader
	{
		public static final Header<OffsetDateTime> IF_MODIFIED_SINCE = new Header<OffsetDateTime>("If-Modified-Since", "com.zoho.crm.api.RelatedRecords.GetRelatedRecordsHeader");

		public static final Header<String> X_EXTERNAL = new Header<String>("X-EXTERNAL", "com.zoho.crm.api.RelatedRecords.GetRelatedRecordsHeader");

	}

	public static class UpdateRelatedRecordsHeader
	{
		public static final Header<String> X_EXTERNAL = new Header<String>("X-EXTERNAL", "com.zoho.crm.api.RelatedRecords.UpdateRelatedRecordsHeader");

	}

	public static class DelinkRecordsParam
	{
		public static final Param<String> IDS = new Param<String>("ids", "com.zoho.crm.api.RelatedRecords.DelinkRecordsParam");

	}

	public static class DelinkRecordsHeader
	{
		public static final Header<String> X_EXTERNAL = new Header<String>("X-EXTERNAL", "com.zoho.crm.api.RelatedRecords.DelinkRecordsHeader");

	}

	public static class GetRelatedRecordsUsingExternalIDParam
	{
		public static final Param<Integer> PAGE = new Param<Integer>("page", "com.zoho.crm.api.RelatedRecords.GetRelatedRecordsUsingExternalIDParam");

		public static final Param<Integer> PER_PAGE = new Param<Integer>("per_page", "com.zoho.crm.api.RelatedRecords.GetRelatedRecordsUsingExternalIDParam");

		public static final Param<String> FIELDS = new Param<String>("fields", "com.zoho.crm.api.RelatedRecords.GetRelatedRecordsUsingExternalIDParam");

	}

	public static class GetRelatedRecordsUsingExternalIDHeader
	{
		public static final Header<OffsetDateTime> IF_MODIFIED_SINCE = new Header<OffsetDateTime>("If-Modified-Since", "com.zoho.crm.api.RelatedRecords.GetRelatedRecordsUsingExternalIDHeader");

		public static final Header<String> X_EXTERNAL = new Header<String>("X-EXTERNAL", "com.zoho.crm.api.RelatedRecords.GetRelatedRecordsUsingExternalIDHeader");

	}

	public static class UpdateRelatedRecordsUsingExternalIDHeader
	{
		public static final Header<String> X_EXTERNAL = new Header<String>("X-EXTERNAL", "com.zoho.crm.api.RelatedRecords.UpdateRelatedRecordsUsingExternalIDHeader");

	}

	public static class DeleteRelatedRecordsUsingExternalIDParam
	{
		public static final Param<String> IDS = new Param<String>("ids", "com.zoho.crm.api.RelatedRecords.DeleteRelatedRecordsUsingExternalIDParam");

	}

	public static class DeleteRelatedRecordsUsingExternalIDHeader
	{
		public static final Header<String> X_EXTERNAL = new Header<String>("X-EXTERNAL", "com.zoho.crm.api.RelatedRecords.DeleteRelatedRecordsUsingExternalIDHeader");

	}

	public static class GetRelatedRecordParam
	{
		public static final Param<String> FIELDS = new Param<String>("fields", "com.zoho.crm.api.RelatedRecords.GetRelatedRecordParam");

	}

	public static class GetRelatedRecordHeader
	{
		public static final Header<OffsetDateTime> IF_MODIFIED_SINCE = new Header<OffsetDateTime>("If-Modified-Since", "com.zoho.crm.api.RelatedRecords.GetRelatedRecordHeader");

		public static final Header<String> X_EXTERNAL = new Header<String>("X-EXTERNAL", "com.zoho.crm.api.RelatedRecords.GetRelatedRecordHeader");

	}

	public static class UpdateRelatedRecordHeader
	{
		public static final Header<String> X_EXTERNAL = new Header<String>("X-EXTERNAL", "com.zoho.crm.api.RelatedRecords.UpdateRelatedRecordHeader");

	}

	public static class DelinkRecordHeader
	{
		public static final Header<String> X_EXTERNAL = new Header<String>("X-EXTERNAL", "com.zoho.crm.api.RelatedRecords.DelinkRecordHeader");

	}

	public static class GetRelatedRecordUsingExternalIDParam
	{
		public static final Param<String> FIELDS = new Param<String>("fields", "com.zoho.crm.api.RelatedRecords.GetRelatedRecordUsingExternalIDParam");

	}

	public static class GetRelatedRecordUsingExternalIDHeader
	{
		public static final Header<OffsetDateTime> IF_MODIFIED_SINCE = new Header<OffsetDateTime>("If-Modified-Since", "com.zoho.crm.api.RelatedRecords.GetRelatedRecordUsingExternalIDHeader");

		public static final Header<String> X_EXTERNAL = new Header<String>("X-EXTERNAL", "com.zoho.crm.api.RelatedRecords.GetRelatedRecordUsingExternalIDHeader");

	}

	public static class UpdateRelatedRecordUsingExternalIDHeader
	{
		public static final Header<String> X_EXTERNAL = new Header<String>("X-EXTERNAL", "com.zoho.crm.api.RelatedRecords.UpdateRelatedRecordUsingExternalIDHeader");

	}

	public static class DeleteRelatedRecordUsingExternalIDHeader
	{
		public static final Header<String> X_EXTERNAL = new Header<String>("X-EXTERNAL", "com.zoho.crm.api.RelatedRecords.DeleteRelatedRecordUsingExternalIDHeader");

	}

	public static class GetDeletedParentRecordsRelatedRecordParam
	{
		public static final Param<String> FIELDS = new Param<String>("fields", "com.zoho.crm.api.RelatedRecords.GetDeletedParentRecordsRelatedRecordParam");

		public static final Param<Integer> PAGE = new Param<Integer>("page", "com.zoho.crm.api.RelatedRecords.GetDeletedParentRecordsRelatedRecordParam");

		public static final Param<Integer> PER_PAGE = new Param<Integer>("per_page", "com.zoho.crm.api.RelatedRecords.GetDeletedParentRecordsRelatedRecordParam");

		public static final Param<String> IDS = new Param<String>("ids", "com.zoho.crm.api.RelatedRecords.GetDeletedParentRecordsRelatedRecordParam");

	}
}