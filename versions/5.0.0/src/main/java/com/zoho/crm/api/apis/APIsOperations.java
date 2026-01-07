package com.zoho.crm.api.apis;

import com.zoho.crm.api.Param;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class APIsOperations
{
	private String filters;

	/**
	 * Creates an instance of ApisOperations with the given parameters
	 * @param filters A String representing the filters
	 */
	public APIsOperations(String filters)
	{
		 this.filters = filters;


	}

	/**
	 * The method to get supported api
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getSupportedAPI() throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/__apis");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.addParam(new Param<String>("filters", "com.zoho.crm.api.Apis.GetSupportedAPIParam"),  this.filters);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}
	public static class GetSupportedAPIParam
	{
	}
}