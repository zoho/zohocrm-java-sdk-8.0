package com.zoho.crm.api.massdeletecvid;

import com.zoho.crm.api.Param;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class MassDeleteCvidOperations
{
	private String module;

	/**
	 * Creates an instance of MassDeleteCvidOperations with the given parameters
	 * @param module A String representing the module
	 */
	public MassDeleteCvidOperations(String module)
	{
		 this.module = module;


	}

	/**
	 * The method to mass delete by cvid
	 * @param request An instance of CvidBodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> massDeleteByCvid(CvidBodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.module.toString());

		apiPath = apiPath.concat("/actions/mass_delete");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_ACTION);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to mass delete by record id
	 * @param request An instance of RecordIdBodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> massDeleteByRecordId(RecordIdBodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.module.toString());

		apiPath = apiPath.concat("/actions/mass_delete");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_ACTION);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to get mass delete status
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getMassDeleteStatus(ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.module.toString());

		apiPath = apiPath.concat("/actions/mass_delete");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.setParam(paramInstance);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}
	public static class GetMassDeleteStatusParam
	{
		public static final Param<Long> JOB_ID = new Param<Long>("job_id", "com.zoho.crm.api.MassDeleteCvid.GetMassDeleteStatusParam");

	}
}