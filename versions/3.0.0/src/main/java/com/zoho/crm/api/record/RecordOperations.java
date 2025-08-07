package com.zoho.crm.api.record;

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

public class RecordOperations
{
	private String moduleAPIName;

	/**
	 * Creates an instance of RecordOperations with the given parameters
	 * @param moduleAPIName A String representing the moduleAPIName
	 */
	public RecordOperations(String moduleAPIName)
	{
		 this.moduleAPIName = moduleAPIName;


	}

	/**
	 * The method to get record
	 * @param id A Long representing the id
	 * @param paramInstance An instance of ParameterMap
	 * @param headerInstance An instance of HeaderMap
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getRecord(Long id, ParameterMap paramInstance, HeaderMap headerInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(id.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.setParam(paramInstance);

		handlerInstance.setHeader(headerInstance);

		handlerInstance.setModuleAPIName( this.moduleAPIName);

		Utility.getFields( this.moduleAPIName, handlerInstance);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to update record
	 * @param id A Long representing the id
	 * @param request An instance of BodyWrapper
	 * @param headerInstance An instance of HeaderMap
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> updateRecord(Long id, BodyWrapper request, HeaderMap headerInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(id.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_UPDATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.setHeader(headerInstance);

		handlerInstance.setModuleAPIName( this.moduleAPIName);

		Utility.getFields( this.moduleAPIName, handlerInstance);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to delete record
	 * @param id A Long representing the id
	 * @param paramInstance An instance of ParameterMap
	 * @param headerInstance An instance of HeaderMap
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> deleteRecord(Long id, ParameterMap paramInstance, HeaderMap headerInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(id.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.setParam(paramInstance);

		handlerInstance.setHeader(headerInstance);

		Utility.getFields( this.moduleAPIName, handlerInstance);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to get records
	 * @param paramInstance An instance of ParameterMap
	 * @param headerInstance An instance of HeaderMap
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getRecords(ParameterMap paramInstance, HeaderMap headerInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.setParam(paramInstance);

		handlerInstance.setHeader(headerInstance);

		handlerInstance.setModuleAPIName( this.moduleAPIName);

		Utility.getFields( this.moduleAPIName, handlerInstance);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to create records
	 * @param request An instance of BodyWrapper
	 * @param headerInstance An instance of HeaderMap
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> createRecords(BodyWrapper request, HeaderMap headerInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_CREATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setHeader(headerInstance);

		handlerInstance.setModuleAPIName( this.moduleAPIName);

		Utility.getFields( this.moduleAPIName, handlerInstance);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to update records
	 * @param request An instance of BodyWrapper
	 * @param headerInstance An instance of HeaderMap
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> updateRecords(BodyWrapper request, HeaderMap headerInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_UPDATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setHeader(headerInstance);

		handlerInstance.setModuleAPIName( this.moduleAPIName);

		Utility.getFields( this.moduleAPIName, handlerInstance);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to delete records
	 * @param paramInstance An instance of ParameterMap
	 * @param headerInstance An instance of HeaderMap
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> deleteRecords(ParameterMap paramInstance, HeaderMap headerInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.setParam(paramInstance);

		handlerInstance.setHeader(headerInstance);

		Utility.getFields( this.moduleAPIName, handlerInstance);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to upsert records
	 * @param request An instance of BodyWrapper
	 * @param headerInstance An instance of HeaderMap
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> upsertRecords(BodyWrapper request, HeaderMap headerInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/upsert");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_ACTION);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setHeader(headerInstance);

		handlerInstance.setModuleAPIName( this.moduleAPIName);

		Utility.getFields( this.moduleAPIName, handlerInstance);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to get deleted records
	 * @param paramInstance An instance of ParameterMap
	 * @param headerInstance An instance of HeaderMap
	 * @return An instance of APIResponse<DeletedRecordsHandler>
	 * @throws SDKException
	 */
	public APIResponse<DeletedRecordsHandler> getDeletedRecords(ParameterMap paramInstance, HeaderMap headerInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/deleted");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.setParam(paramInstance);

		handlerInstance.setHeader(headerInstance);

		Utility.getFields( this.moduleAPIName, handlerInstance);

		return handlerInstance.apiCall(DeletedRecordsHandler.class, "application/json");

	}

	/**
	 * The method to search records
	 * @param paramInstance An instance of ParameterMap
	 * @param headerInstance An instance of HeaderMap
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> searchRecords(ParameterMap paramInstance, HeaderMap headerInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/search");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.setParam(paramInstance);

		handlerInstance.setHeader(headerInstance);

		handlerInstance.setModuleAPIName( this.moduleAPIName);

		Utility.getFields( this.moduleAPIName, handlerInstance);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to get photo
	 * @param id A Long representing the id
	 * @return An instance of APIResponse<DownloadHandler>
	 * @throws SDKException
	 */
	public APIResponse<DownloadHandler> getPhoto(Long id) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(id.toString());

		apiPath = apiPath.concat("/photo");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		Utility.getFields( this.moduleAPIName, handlerInstance);

		return handlerInstance.apiCall(DownloadHandler.class, "application/x-download");

	}

	/**
	 * The method to upload photo
	 * @param id A Long representing the id
	 * @param request An instance of FileBodyWrapper
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<FileHandler>
	 * @throws SDKException
	 */
	public APIResponse<FileHandler> uploadPhoto(Long id, FileBodyWrapper request, ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(id.toString());

		apiPath = apiPath.concat("/photo");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_CREATE);

		handlerInstance.setContentType("multipart/form-data");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.setParam(paramInstance);

		Utility.getFields( this.moduleAPIName, handlerInstance);

		Utility.verifyPhotoSupport( this.moduleAPIName);

		return handlerInstance.apiCall(FileHandler.class, "application/json");

	}

	/**
	 * The method to delete photo
	 * @param id A Long representing the id
	 * @return An instance of APIResponse<FileHandler>
	 * @throws SDKException
	 */
	public APIResponse<FileHandler> deletePhoto(Long id) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(id.toString());

		apiPath = apiPath.concat("/photo");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE);

		Utility.getFields( this.moduleAPIName, handlerInstance);

		return handlerInstance.apiCall(FileHandler.class, "application/json");

	}

	/**
	 * The method to mass update records
	 * @param request An instance of MassUpdateBodyWrapper
	 * @return An instance of APIResponse<MassUpdateActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<MassUpdateActionHandler> massUpdateRecords(MassUpdateBodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/actions/mass_update");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_UPDATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.setModuleAPIName( this.moduleAPIName);

		Utility.getFields( this.moduleAPIName, handlerInstance);

		return handlerInstance.apiCall(MassUpdateActionHandler.class, "application/json");

	}

	/**
	 * The method to get mass update status
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<MassUpdateResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<MassUpdateResponseHandler> getMassUpdateStatus(ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/actions/mass_update");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.setParam(paramInstance);

		Utility.getFields( this.moduleAPIName, handlerInstance);

		return handlerInstance.apiCall(MassUpdateResponseHandler.class, "application/json");

	}

	/**
	 * The method to assign territories to multiple records
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> assignTerritoriesToMultipleRecords(BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/actions/assign_territories");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_UPDATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.setModuleAPIName( this.moduleAPIName);

		Utility.getFields( this.moduleAPIName, handlerInstance);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to assign territory to record
	 * @param id A Long representing the id
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> assignTerritoryToRecord(Long id, BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(id.toString());

		apiPath = apiPath.concat("/actions/assign_territories");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_UPDATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.setModuleAPIName( this.moduleAPIName);

		Utility.getFields( this.moduleAPIName, handlerInstance);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to remove territories from multiple records
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> removeTerritoriesFromMultipleRecords(BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/actions/remove_territories");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_UPDATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.setModuleAPIName( this.moduleAPIName);

		Utility.getFields( this.moduleAPIName, handlerInstance);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to remove territories from record
	 * @param id A Long representing the id
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> removeTerritoriesFromRecord(Long id, BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(id.toString());

		apiPath = apiPath.concat("/actions/remove_territories");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_UPDATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.setModuleAPIName( this.moduleAPIName);

		Utility.getFields( this.moduleAPIName, handlerInstance);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to record count
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<CountHandler>
	 * @throws SDKException
	 */
	public APIResponse<CountHandler> recordCount(ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/actions/count");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.setParam(paramInstance);

		return handlerInstance.apiCall(CountHandler.class, "application/json");

	}

	/**
	 * The method to get record using external id
	 * @param externalFieldValue A String representing the externalFieldValue
	 * @param paramInstance An instance of ParameterMap
	 * @param headerInstance An instance of HeaderMap
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getRecordUsingExternalId(String externalFieldValue, ParameterMap paramInstance, HeaderMap headerInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(externalFieldValue.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.setParam(paramInstance);

		handlerInstance.setHeader(headerInstance);

		handlerInstance.setModuleAPIName( this.moduleAPIName);

		Utility.getFields( this.moduleAPIName, handlerInstance);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to update record using external id
	 * @param externalFieldValue A String representing the externalFieldValue
	 * @param request An instance of BodyWrapper
	 * @param headerInstance An instance of HeaderMap
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> updateRecordUsingExternalId(String externalFieldValue, BodyWrapper request, HeaderMap headerInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(externalFieldValue.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_UPDATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.setHeader(headerInstance);

		handlerInstance.setModuleAPIName( this.moduleAPIName);

		Utility.getFields( this.moduleAPIName, handlerInstance);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to delete record using external id
	 * @param externalFieldValue A String representing the externalFieldValue
	 * @param paramInstance An instance of ParameterMap
	 * @param headerInstance An instance of HeaderMap
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> deleteRecordUsingExternalId(String externalFieldValue, ParameterMap paramInstance, HeaderMap headerInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(externalFieldValue.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.setParam(paramInstance);

		handlerInstance.setHeader(headerInstance);

		Utility.getFields( this.moduleAPIName, handlerInstance);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to get full data for rich text
	 * @param id A Long representing the id
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getFullDataForRichText(Long id, ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(id.toString());

		apiPath = apiPath.concat("/actions/fetch_full_data");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.setParam(paramInstance);

		Utility.getFields( this.moduleAPIName, handlerInstance);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to get rich text records
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getRichTextRecords(ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/actions/fetch_full_data");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.setParam(paramInstance);

		handlerInstance.setModuleAPIName( this.moduleAPIName);

		Utility.getFields( this.moduleAPIName, handlerInstance);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to clone record
	 * @param id A Long representing the id
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> cloneRecord(Long id) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(id.toString());

		apiPath = apiPath.concat("/actions/clone");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_CREATE);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.setModuleAPIName( this.moduleAPIName);

		Utility.getFields( this.moduleAPIName, handlerInstance);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}
	public static class GetRecordParam
	{
		public static final Param<String> APPROVED = new Param<String>("approved", "com.zoho.crm.api.Record.GetRecordParam");

		public static final Param<String> CONVERTED = new Param<String>("converted", "com.zoho.crm.api.Record.GetRecordParam");

		public static final Param<String> CVID = new Param<String>("cvid", "com.zoho.crm.api.Record.GetRecordParam");

		public static final Param<String> UID = new Param<String>("uid", "com.zoho.crm.api.Record.GetRecordParam");

		public static final Param<String> FIELDS = new Param<String>("fields", "com.zoho.crm.api.Record.GetRecordParam");

		public static final Param<OffsetDateTime> STARTDATETIME = new Param<OffsetDateTime>("startDateTime", "com.zoho.crm.api.Record.GetRecordParam");

		public static final Param<OffsetDateTime> ENDDATETIME = new Param<OffsetDateTime>("endDateTime", "com.zoho.crm.api.Record.GetRecordParam");

		public static final Param<String> TERRITORY_ID = new Param<String>("territory_id", "com.zoho.crm.api.Record.GetRecordParam");

		public static final Param<String> INCLUDE_CHILD = new Param<String>("include_child", "com.zoho.crm.api.Record.GetRecordParam");

		public static final Param<String> ON_DEMAND_PROPERTIES = new Param<String>("on_demand_properties", "com.zoho.crm.api.Record.GetRecordParam");

	}

	public static class GetRecordHeader
	{
		public static final Header<OffsetDateTime> IF_MODIFIED_SINCE = new Header<OffsetDateTime>("If-Modified-Since", "com.zoho.crm.api.Record.GetRecordHeader");

		public static final Header<String> X_EXTERNAL = new Header<String>("X-EXTERNAL", "com.zoho.crm.api.Record.GetRecordHeader");

	}

	public static class UpdateRecordHeader
	{
		public static final Header<String> X_EXTERNAL = new Header<String>("X-EXTERNAL", "com.zoho.crm.api.Record.UpdateRecordHeader");

	}

	public static class DeleteRecordParam
	{
		public static final Param<Boolean> WF_TRIGGER = new Param<Boolean>("wf_trigger", "com.zoho.crm.api.Record.DeleteRecordParam");

	}

	public static class DeleteRecordHeader
	{
		public static final Header<String> X_EXTERNAL = new Header<String>("X-EXTERNAL", "com.zoho.crm.api.Record.DeleteRecordHeader");

	}

	public static class GetRecordsParam
	{
		public static final Param<String> APPROVED = new Param<String>("approved", "com.zoho.crm.api.Record.GetRecordsParam");

		public static final Param<String> CONVERTED = new Param<String>("converted", "com.zoho.crm.api.Record.GetRecordsParam");

		public static final Param<String> CVID = new Param<String>("cvid", "com.zoho.crm.api.Record.GetRecordsParam");

		public static final Param<String> IDS = new Param<String>("ids", "com.zoho.crm.api.Record.GetRecordsParam");

		public static final Param<String> UID = new Param<String>("uid", "com.zoho.crm.api.Record.GetRecordsParam");

		public static final Param<String> FIELDS = new Param<String>("fields", "com.zoho.crm.api.Record.GetRecordsParam");

		public static final Param<String> SORT_BY = new Param<String>("sort_by", "com.zoho.crm.api.Record.GetRecordsParam");

		public static final Param<String> SORT_ORDER = new Param<String>("sort_order", "com.zoho.crm.api.Record.GetRecordsParam");

		public static final Param<Integer> PAGE = new Param<Integer>("page", "com.zoho.crm.api.Record.GetRecordsParam");

		public static final Param<Integer> PER_PAGE = new Param<Integer>("per_page", "com.zoho.crm.api.Record.GetRecordsParam");

		public static final Param<OffsetDateTime> STARTDATETIME = new Param<OffsetDateTime>("startDateTime", "com.zoho.crm.api.Record.GetRecordsParam");

		public static final Param<OffsetDateTime> ENDDATETIME = new Param<OffsetDateTime>("endDateTime", "com.zoho.crm.api.Record.GetRecordsParam");

		public static final Param<String> TERRITORY_ID = new Param<String>("territory_id", "com.zoho.crm.api.Record.GetRecordsParam");

		public static final Param<String> INCLUDE_CHILD = new Param<String>("include_child", "com.zoho.crm.api.Record.GetRecordsParam");

		public static final Param<String> PAGE_TOKEN = new Param<String>("page_token", "com.zoho.crm.api.Record.GetRecordsParam");

	}

	public static class GetRecordsHeader
	{
		public static final Header<OffsetDateTime> IF_MODIFIED_SINCE = new Header<OffsetDateTime>("If-Modified-Since", "com.zoho.crm.api.Record.GetRecordsHeader");

		public static final Header<String> X_EXTERNAL = new Header<String>("X-EXTERNAL", "com.zoho.crm.api.Record.GetRecordsHeader");

	}

	public static class CreateRecordsHeader
	{
		public static final Header<String> X_EXTERNAL = new Header<String>("X-EXTERNAL", "com.zoho.crm.api.Record.CreateRecordsHeader");

	}

	public static class UpdateRecordsHeader
	{
		public static final Header<String> X_EXTERNAL = new Header<String>("X-EXTERNAL", "com.zoho.crm.api.Record.UpdateRecordsHeader");

	}

	public static class DeleteRecordsParam
	{
		public static final Param<String> IDS = new Param<String>("ids", "com.zoho.crm.api.Record.DeleteRecordsParam");

		public static final Param<Boolean> WF_TRIGGER = new Param<Boolean>("wf_trigger", "com.zoho.crm.api.Record.DeleteRecordsParam");

	}

	public static class DeleteRecordsHeader
	{
		public static final Header<String> X_EXTERNAL = new Header<String>("X-EXTERNAL", "com.zoho.crm.api.Record.DeleteRecordsHeader");

	}

	public static class UpsertRecordsHeader
	{
		public static final Header<String> X_EXTERNAL = new Header<String>("X-EXTERNAL", "com.zoho.crm.api.Record.UpsertRecordsHeader");

	}

	public static class GetDeletedRecordsParam
	{
		public static final Param<String> TYPE = new Param<String>("type", "com.zoho.crm.api.Record.GetDeletedRecordsParam");

		public static final Param<Integer> PAGE = new Param<Integer>("page", "com.zoho.crm.api.Record.GetDeletedRecordsParam");

		public static final Param<Integer> PER_PAGE = new Param<Integer>("per_page", "com.zoho.crm.api.Record.GetDeletedRecordsParam");

	}

	public static class GetDeletedRecordsHeader
	{
		public static final Header<OffsetDateTime> IF_MODIFIED_SINCE = new Header<OffsetDateTime>("If-Modified-Since", "com.zoho.crm.api.Record.GetDeletedRecordsHeader");

	}

	public static class SearchRecordsParam
	{
		public static final Param<String> CRITERIA = new Param<String>("criteria", "com.zoho.crm.api.Record.SearchRecordsParam");

		public static final Param<String> EMAIL = new Param<String>("email", "com.zoho.crm.api.Record.SearchRecordsParam");

		public static final Param<String> PHONE = new Param<String>("phone", "com.zoho.crm.api.Record.SearchRecordsParam");

		public static final Param<String> WORD = new Param<String>("word", "com.zoho.crm.api.Record.SearchRecordsParam");

		public static final Param<String> CONVERTED = new Param<String>("converted", "com.zoho.crm.api.Record.SearchRecordsParam");

		public static final Param<String> APPROVED = new Param<String>("approved", "com.zoho.crm.api.Record.SearchRecordsParam");

		public static final Param<Integer> PAGE = new Param<Integer>("page", "com.zoho.crm.api.Record.SearchRecordsParam");

		public static final Param<Integer> PER_PAGE = new Param<Integer>("per_page", "com.zoho.crm.api.Record.SearchRecordsParam");

		public static final Param<String> FIELDS = new Param<String>("fields", "com.zoho.crm.api.Record.SearchRecordsParam");

		public static final Param<String> CVID = new Param<String>("cvid", "com.zoho.crm.api.Record.SearchRecordsParam");

		public static final Param<String> TYPE = new Param<String>("type", "com.zoho.crm.api.Record.SearchRecordsParam");

	}

	public static class SearchRecordsHeader
	{
		public static final Header<String> X_EXTERNAL = new Header<String>("X-EXTERNAL", "com.zoho.crm.api.Record.SearchRecordsHeader");

	}

	public static class UploadPhotoParam
	{
		public static final Param<String> RESTRICT_TRIGGERS = new Param<String>("restrict_triggers", "com.zoho.crm.api.Record.UploadPhotoParam");

	}

	public static class GetMassUpdateStatusParam
	{
		public static final Param<String> JOB_ID = new Param<String>("job_id", "com.zoho.crm.api.Record.GetMassUpdateStatusParam");

	}

	public static class RecordCountParam
	{
		public static final Param<String> CVID = new Param<String>("cvid", "com.zoho.crm.api.Record.RecordCountParam");

		public static final Param<String> CRITERIA = new Param<String>("criteria", "com.zoho.crm.api.Record.RecordCountParam");

		public static final Param<String> EMAIL = new Param<String>("email", "com.zoho.crm.api.Record.RecordCountParam");

		public static final Param<String> PHONE = new Param<String>("phone", "com.zoho.crm.api.Record.RecordCountParam");

		public static final Param<String> WORD = new Param<String>("word", "com.zoho.crm.api.Record.RecordCountParam");

	}

	public static class GetRecordUsingExternalIDParam
	{
		public static final Param<String> APPROVED = new Param<String>("approved", "com.zoho.crm.api.Record.GetRecordUsingExternalIDParam");

		public static final Param<String> CONVERTED = new Param<String>("converted", "com.zoho.crm.api.Record.GetRecordUsingExternalIDParam");

		public static final Param<String> CVID = new Param<String>("cvid", "com.zoho.crm.api.Record.GetRecordUsingExternalIDParam");

		public static final Param<String> UID = new Param<String>("uid", "com.zoho.crm.api.Record.GetRecordUsingExternalIDParam");

		public static final Param<String> FIELDS = new Param<String>("fields", "com.zoho.crm.api.Record.GetRecordUsingExternalIDParam");

		public static final Param<OffsetDateTime> STARTDATETIME = new Param<OffsetDateTime>("startDateTime", "com.zoho.crm.api.Record.GetRecordUsingExternalIDParam");

		public static final Param<OffsetDateTime> ENDDATETIME = new Param<OffsetDateTime>("endDateTime", "com.zoho.crm.api.Record.GetRecordUsingExternalIDParam");

		public static final Param<String> TERRITORY_ID = new Param<String>("territory_id", "com.zoho.crm.api.Record.GetRecordUsingExternalIDParam");

		public static final Param<String> INCLUDE_CHILD = new Param<String>("include_child", "com.zoho.crm.api.Record.GetRecordUsingExternalIDParam");

	}

	public static class GetRecordUsingExternalIDHeader
	{
		public static final Header<OffsetDateTime> IF_MODIFIED_SINCE = new Header<OffsetDateTime>("If-Modified-Since", "com.zoho.crm.api.Record.GetRecordUsingExternalIDHeader");

		public static final Header<String> X_EXTERNAL = new Header<String>("X-EXTERNAL", "com.zoho.crm.api.Record.GetRecordUsingExternalIDHeader");

	}

	public static class UpdateRecordUsingExternalIDHeader
	{
		public static final Header<String> X_EXTERNAL = new Header<String>("X-EXTERNAL", "com.zoho.crm.api.Record.UpdateRecordUsingExternalIDHeader");

	}

	public static class DeleteRecordUsingExternalIDParam
	{
		public static final Param<Boolean> WF_TRIGGER = new Param<Boolean>("wf_trigger", "com.zoho.crm.api.Record.DeleteRecordUsingExternalIDParam");

	}

	public static class DeleteRecordUsingExternalIDHeader
	{
		public static final Header<String> X_EXTERNAL = new Header<String>("X-EXTERNAL", "com.zoho.crm.api.Record.DeleteRecordUsingExternalIDHeader");

	}

	public static class GetFullDataForRichTextParam
	{
		public static final Param<String> FIELDS = new Param<String>("fields", "com.zoho.crm.api.Record.GetFullDataForRichTextParam");

	}

	public static class GetRichTextRecordsParam
	{
		public static final Param<String> IDS = new Param<String>("ids", "com.zoho.crm.api.Record.GetRichTextRecordsParam");

		public static final Param<String> FIELDS = new Param<String>("fields", "com.zoho.crm.api.Record.GetRichTextRecordsParam");

	}
}