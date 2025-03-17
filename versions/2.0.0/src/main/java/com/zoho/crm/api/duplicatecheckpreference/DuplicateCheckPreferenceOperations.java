package com.zoho.crm.api.duplicatecheckpreference;

import com.zoho.crm.api.Param;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class DuplicateCheckPreferenceOperations
{
	private String module;

	/**
	 * Creates an instance of DuplicateCheckPreferenceOperations with the given parameters
	 * @param module A String representing the module
	 */
	public DuplicateCheckPreferenceOperations(String module)
	{
		 this.module = module;


	}

	/**
	 * The method to get duplicate check preference
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getDuplicateCheckPreference() throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/duplicate_check_preference");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.addParam(new Param<String>("module", "com.zoho.crm.api.DuplicateCheckPreference.GetDuplicateCheckPreferenceParam"),  this.module);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to create duplicate check preference
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> createDuplicateCheckPreference(BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/duplicate_check_preference");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_CREATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.addParam(new Param<String>("module", "com.zoho.crm.api.DuplicateCheckPreference.CreateDuplicateCheckPreferenceParam"),  this.module);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to update duplicate check preference
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> updateDuplicateCheckPreference(BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/duplicate_check_preference");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_UPDATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.addParam(new Param<String>("module", "com.zoho.crm.api.DuplicateCheckPreference.UpdateDuplicateCheckPreferenceParam"),  this.module);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to delete duplicate check preference
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> deleteDuplicateCheckPreference() throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/duplicate_check_preference");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.addParam(new Param<String>("module", "com.zoho.crm.api.DuplicateCheckPreference.DeleteDuplicateCheckPreferenceParam"),  this.module);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}
	public static class GetDuplicateCheckPreferenceParam
	{
	}

	public static class CreateDuplicateCheckPreferenceParam
	{
	}

	public static class UpdateDuplicateCheckPreferenceParam
	{
	}

	public static class DeleteDuplicateCheckPreferenceParam
	{
	}
}