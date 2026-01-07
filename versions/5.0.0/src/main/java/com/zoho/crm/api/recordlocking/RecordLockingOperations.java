package com.zoho.crm.api.recordlocking;

import com.zoho.crm.api.Param;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Utility;
import com.zoho.crm.api.util.Constants;

public class RecordLockingOperations
{
	private String moduleName;

	private Long recordId;

	/**
	 * Creates an instance of RecordLockingOperations with the given parameters
	 * @param recordId A Long representing the recordId
	 * @param moduleName A String representing the moduleName
	 */
	public RecordLockingOperations(Long recordId, String moduleName)
	{
		 this.recordId = recordId;

		 this.moduleName = moduleName;


	}

	/**
	 * The method to get record locking informations
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getRecordLockingInformations(ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat( this.recordId.toString());

		apiPath = apiPath.concat("/Locking_Information__s");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.setParam(paramInstance);

		handlerInstance.setModuleAPIName("Locking_Information__s");

		Utility.getFields("Locking_Information__s", handlerInstance);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to lock records
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> lockRecords(BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat( this.recordId.toString());

		apiPath = apiPath.concat("/Locking_Information__s");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_CREATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.setModuleAPIName("Locking_Information__s");

		Utility.getFields("Locking_Information__s", handlerInstance);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to get record locking information
	 * @param lockId A Long representing the lockId
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getRecordLockingInformation(Long lockId, ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat( this.recordId.toString());

		apiPath = apiPath.concat("/Locking_Information__s/");

		apiPath = apiPath.concat(lockId.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.setParam(paramInstance);

		handlerInstance.setModuleAPIName("Locking_Information__s");

		Utility.getFields("Locking_Information__s", handlerInstance);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to update record locking information
	 * @param lockId A Long representing the lockId
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> updateRecordLockingInformation(Long lockId, BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat( this.recordId.toString());

		apiPath = apiPath.concat("/Locking_Information__s/");

		apiPath = apiPath.concat(lockId.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_UPDATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.setModuleAPIName("Locking_Information__s");

		Utility.getFields("Locking_Information__s", handlerInstance);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to unlock record
	 * @param lockId A Long representing the lockId
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> unlockRecord(Long lockId) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat( this.recordId.toString());

		apiPath = apiPath.concat("/Locking_Information__s/");

		apiPath = apiPath.concat(lockId.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.setModuleAPIName("Locking_Information__s");

		Utility.getFields("Locking_Information__s", handlerInstance);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}
	public static class GetRecordLockingInformationsParam
	{
		public static final Param<String> FIELDS = new Param<String>("fields", "com.zoho.crm.api.RecordLocking.GetRecordLockingInformationsParam");

		public static final Param<String> PAGE_TOKEN = new Param<String>("page_token", "com.zoho.crm.api.RecordLocking.GetRecordLockingInformationsParam");

		public static final Param<Integer> PAGE = new Param<Integer>("page", "com.zoho.crm.api.RecordLocking.GetRecordLockingInformationsParam");

		public static final Param<Integer> PER_PAGE = new Param<Integer>("per_page", "com.zoho.crm.api.RecordLocking.GetRecordLockingInformationsParam");

		public static final Param<String> IDS = new Param<String>("ids", "com.zoho.crm.api.RecordLocking.GetRecordLockingInformationsParam");

	}

	public static class GetRecordLockingInformationParam
	{
		public static final Param<String> FIELDS = new Param<String>("fields", "com.zoho.crm.api.RecordLocking.GetRecordLockingInformationParam");

	}
}