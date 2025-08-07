package com.zoho.crm.api.recordlockingconfiguration;

import com.zoho.crm.api.Param;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class RecordLockingConfigurationOperations
{
	private String module;

	/**
	 * Creates an instance of RecordLockingConfigurationOperations with the given parameters
	 * @param module A String representing the module
	 */
	public RecordLockingConfigurationOperations(String module)
	{
		 this.module = module;


	}

	/**
	 * The method to get record locking configurations
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getRecordLockingConfigurations(ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/record_locking_configurations");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.addParam(new Param<String>("module", "com.zoho.crm.api.RecordLockingConfiguration.GetRecordLockingConfigurationsParam"),  this.module);

		handlerInstance.setParam(paramInstance);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to add record locking configuration
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> addRecordLockingConfiguration(BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/record_locking_configurations");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_CREATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.addParam(new Param<String>("module", "com.zoho.crm.api.RecordLockingConfiguration.AddRecordLockingConfigurationParam"),  this.module);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to update record locking configurations
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> updateRecordLockingConfigurations(BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/record_locking_configurations");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_UPDATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.addParam(new Param<String>("module", "com.zoho.crm.api.RecordLockingConfiguration.UpdateRecordLockingConfigurationsParam"),  this.module);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to update record locking configuration
	 * @param recordLockingConfigId A Long representing the recordLockingConfigId
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> updateRecordLockingConfiguration(Long recordLockingConfigId, BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/record_locking_configurations/");

		apiPath = apiPath.concat(recordLockingConfigId.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_UPDATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.addParam(new Param<String>("module", "com.zoho.crm.api.RecordLockingConfiguration.UpdateRecordLockingConfigurationParam"),  this.module);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to delete record locking configuration
	 * @param recordLockingConfigId A Long representing the recordLockingConfigId
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> deleteRecordLockingConfiguration(Long recordLockingConfigId) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/record_locking_configurations/");

		apiPath = apiPath.concat(recordLockingConfigId.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.addParam(new Param<String>("module", "com.zoho.crm.api.RecordLockingConfiguration.DeleteRecordLockingConfigurationParam"),  this.module);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}
	public static class GetRecordLockingConfigurationsParam
	{
		public static final Param<String> FEATURE_TYPE = new Param<String>("feature_type", "com.zoho.crm.api.RecordLockingConfiguration.GetRecordLockingConfigurationsParam");

	}

	public static class AddRecordLockingConfigurationParam
	{
	}

	public static class UpdateRecordLockingConfigurationsParam
	{
	}

	public static class UpdateRecordLockingConfigurationParam
	{
	}

	public static class DeleteRecordLockingConfigurationParam
	{
	}
}