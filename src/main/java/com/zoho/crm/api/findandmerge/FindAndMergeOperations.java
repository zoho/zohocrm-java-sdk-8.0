package com.zoho.crm.api.findandmerge;

import com.zoho.crm.api.Param;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class FindAndMergeOperations
{
	private Long masterrecordid;

	private String module;

	/**
	 * Creates an instance of FindAndMergeOperations with the given parameters
	 * @param module A String representing the module
	 * @param masterrecordid A Long representing the masterrecordid
	 */
	public FindAndMergeOperations(String module, Long masterrecordid)
	{
		 this.module = module;

		 this.masterrecordid = masterrecordid;


	}

	/**
	 * The method to get record merge
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getRecordMerge(ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.module.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat( this.masterrecordid.toString());

		apiPath = apiPath.concat("/actions/merge");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.setParam(paramInstance);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to merge records
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> mergeRecords(BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.module.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat( this.masterrecordid.toString());

		apiPath = apiPath.concat("/actions/merge");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_CREATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}
	public static class GetRecordMergeParam
	{
		public static final Param<Long> JOB_ID = new Param<Long>("job_id", "com.zoho.crm.api.FindAndMerge.GetRecordMergeParam");

	}
}