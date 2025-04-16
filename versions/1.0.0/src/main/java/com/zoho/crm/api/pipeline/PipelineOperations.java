package com.zoho.crm.api.pipeline;

import com.zoho.crm.api.Param;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class PipelineOperations
{
	private Long layoutId;

	/**
	 * Creates an instance of PipelineOperations with the given parameters
	 * @param layoutId A Long representing the layoutId
	 */
	public PipelineOperations(Long layoutId)
	{
		 this.layoutId = layoutId;


	}

	/**
	 * The method to get pipelines
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getPipelines() throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/pipeline");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.addParam(new Param<Long>("layout_id", "com.zoho.crm.api.Pipeline.GetPipelinesParam"),  this.layoutId);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to create pipeline
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> createPipeline(BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/pipeline");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_CREATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.addParam(new Param<Long>("layout_id", "com.zoho.crm.api.Pipeline.CreatePipelineParam"),  this.layoutId);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to update pipelines
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> updatePipelines(BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/pipeline");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_UPDATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.addParam(new Param<Long>("layout_id", "com.zoho.crm.api.Pipeline.UpdatePipelinesParam"),  this.layoutId);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to get pipeline
	 * @param id A Long representing the id
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getPipeline(Long id) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/pipeline/");

		apiPath = apiPath.concat(id.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.addParam(new Param<Long>("layout_id", "com.zoho.crm.api.Pipeline.GetPipelineParam"),  this.layoutId);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to update pipeline
	 * @param id A Long representing the id
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> updatePipeline(Long id, BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/pipeline/");

		apiPath = apiPath.concat(id.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_UPDATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.addParam(new Param<Long>("layout_id", "com.zoho.crm.api.Pipeline.UpdatePipelineParam"),  this.layoutId);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to delete pipeline
	 * @param id A Long representing the id
	 * @param request An instance of DPipelineWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> deletePipeline(Long id, DPipelineWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/pipeline/");

		apiPath = apiPath.concat(id.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PATCH);

		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.addParam(new Param<Long>("layout_id", "com.zoho.crm.api.Pipeline.DeletePipelineParam"),  this.layoutId);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to transfer pipelines
	 * @param request An instance of TransferPipelineWrapper
	 * @return An instance of APIResponse<TransferPipelineActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<TransferPipelineActionHandler> transferPipelines(TransferPipelineWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/pipeline/actions/transfer");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_ACTION);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.addParam(new Param<Long>("layout_id", "com.zoho.crm.api.Pipeline.TransferPipelinesParam"),  this.layoutId);

		return handlerInstance.apiCall(TransferPipelineActionHandler.class, "application/json");

	}
	public static class GetPipelinesParam
	{
	}

	public static class CreatePipelineParam
	{
	}

	public static class UpdatePipelinesParam
	{
	}

	public static class GetPipelineParam
	{
	}

	public static class UpdatePipelineParam
	{
	}

	public static class DeletePipelineParam
	{
	}

	public static class TransferPipelinesParam
	{
	}
}