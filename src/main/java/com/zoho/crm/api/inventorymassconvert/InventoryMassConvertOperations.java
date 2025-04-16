package com.zoho.crm.api.inventorymassconvert;

import com.zoho.crm.api.Param;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class InventoryMassConvertOperations
{
	private String moduleAPIName;

	/**
	 * Creates an instance of InventoryMassConvertOperations with the given parameters
	 * @param moduleAPIName A String representing the moduleAPIName
	 */
	public InventoryMassConvertOperations(String moduleAPIName)
	{
		 this.moduleAPIName = moduleAPIName;


	}

	/**
	 * The method to mass inventory convert
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionResponse>
	 * @throws SDKException
	 */
	public APIResponse<ActionResponse> massInventoryConvert(BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/actions/mass_convert");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_CREATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		return handlerInstance.apiCall(ActionResponse.class, "application/json");

	}

	/**
	 * The method to get scheduled jobs details
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getScheduledJobsDetails(ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/actions/mass_convert");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_ACTION);

		handlerInstance.setParam(paramInstance);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}
	public static class GetScheduledJobsDetailsParam
	{
		public static final Param<Long> JOB_ID = new Param<Long>("job_id", "com.zoho.crm.api.InventoryMassConvert.GetScheduledJobsDetailsParam");

	}
}