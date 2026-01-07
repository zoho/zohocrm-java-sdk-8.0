package com.zoho.crm.api.functions;

import com.zoho.crm.api.Header;
import com.zoho.crm.api.HeaderMap;
import com.zoho.crm.api.Param;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import java.util.Map;
import com.zoho.crm.api.util.Constants;

public class FunctionsOperations
{
	private String authType;

	private String functionName;

	private Map<String, Object> arguments;

	/**
	 * Creates an instance of FunctionsOperations with the given parameters
	 * @param functionName A String representing the functionName
	 * @param authType A String representing the authType
	 * @param arguments An instance of Map<String,Object>
	 */
	public FunctionsOperations(String functionName, String authType, Map<String, Object> arguments)
	{
		 this.functionName = functionName;

		 this.authType = authType;

		 this.arguments = arguments;


	}

	/**
	 * The method to execute function using request body
	 * @param request An instance of BodyWrapper
	 * @param paramInstance An instance of ParameterMap
	 * @param headerInstance An instance of HeaderMap
	 * @return An instance of APIResponse<ResponseWrapper>
	 * @throws SDKException
	 */
	public APIResponse<ResponseWrapper> executeFunctionUsingRequestBody(BodyWrapper request, ParameterMap paramInstance, HeaderMap headerInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/functions/");

		apiPath = apiPath.concat( this.functionName.toString());

		apiPath = apiPath.concat("/actions/execute");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_CREATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.addParam(new Param<String>("auth_type", "com.zoho.crm.api.Functions.ExecuteFunctionUsingRequestBodyParam"),  this.authType);

		handlerInstance.addParam(new Param<Map<String, Object>>("arguments", "com.zoho.crm.api.Functions.ExecuteFunctionUsingRequestBodyParam"),  this.arguments);

		handlerInstance.setParam(paramInstance);

		handlerInstance.setHeader(headerInstance);

		return handlerInstance.apiCall(ResponseWrapper.class, "application/json");

	}

	/**
	 * The method to execute function using parameters
	 * @param paramInstance An instance of ParameterMap
	 * @param headerInstance An instance of HeaderMap
	 * @return An instance of APIResponse<ResponseWrapper>
	 * @throws SDKException
	 */
	public APIResponse<ResponseWrapper> executeFunctionUsingParameters(ParameterMap paramInstance, HeaderMap headerInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/functions/");

		apiPath = apiPath.concat( this.functionName.toString());

		apiPath = apiPath.concat("/actions/execute");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.addParam(new Param<String>("auth_type", "com.zoho.crm.api.Functions.ExecuteFunctionUsingParametersParam"),  this.authType);

		handlerInstance.addParam(new Param<Map<String, Object>>("arguments", "com.zoho.crm.api.Functions.ExecuteFunctionUsingParametersParam"),  this.arguments);

		handlerInstance.setParam(paramInstance);

		handlerInstance.setHeader(headerInstance);

		return handlerInstance.apiCall(ResponseWrapper.class, "application/json");

	}

	/**
	 * The method to execute function using file
	 * @param request An instance of FileBodyWrapper
	 * @param paramInstance An instance of ParameterMap
	 * @param headerInstance An instance of HeaderMap
	 * @return An instance of APIResponse<ResponseWrapper>
	 * @throws SDKException
	 */
	public APIResponse<ResponseWrapper> executeFunctionUsingFile(FileBodyWrapper request, ParameterMap paramInstance, HeaderMap headerInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/functions/");

		apiPath = apiPath.concat( this.functionName.toString());

		apiPath = apiPath.concat("/actions/execute");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_CREATE);

		handlerInstance.setContentType("multipart/form-data");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.addParam(new Param<String>("auth_type", "com.zoho.crm.api.Functions.ExecuteFunctionUsingFileParam"),  this.authType);

		handlerInstance.addParam(new Param<Map<String, Object>>("arguments", "com.zoho.crm.api.Functions.ExecuteFunctionUsingFileParam"),  this.arguments);

		handlerInstance.setParam(paramInstance);

		handlerInstance.setHeader(headerInstance);

		return handlerInstance.apiCall(ResponseWrapper.class, "application/json");

	}
	public static class ExecuteFunctionUsingRequestBodyParam
	{
		public static final Param<Map<String, Object>> CUSTOM_FUNCTIONS_PARAM = new Param<Map<String, Object>>("custom_functions_param", "com.zoho.crm.api.Functions.ExecuteFunctionUsingRequestBodyParam");

	}

	public static class ExecuteFunctionUsingRequestBodyHeader
	{
		public static final Header<Map<String, Object>> CUSTOM_FUNCTIONS_HEADER = new Header<Map<String, Object>>("custom_functions_header", "com.zoho.crm.api.Functions.ExecuteFunctionUsingRequestBodyHeader");

	}

	public static class ExecuteFunctionUsingParametersParam
	{
		public static final Param<Map<String, Object>> GET_CUSTOM_FUNCTIONS_PARAM = new Param<Map<String, Object>>("get_custom_functions_param", "com.zoho.crm.api.Functions.ExecuteFunctionUsingParametersParam");

	}

	public static class ExecuteFunctionUsingParametersHeader
	{
		public static final Header<Map<String, Object>> GET_CUSTOM_FUNCTIONS_HEADER = new Header<Map<String, Object>>("get_custom_functions_header", "com.zoho.crm.api.Functions.ExecuteFunctionUsingParametersHeader");

	}

	public static class ExecuteFunctionUsingFileParam
	{
		public static final Param<Map<String, Object>> UPLOAD_FILE_PARAM = new Param<Map<String, Object>>("upload_file_param", "com.zoho.crm.api.Functions.ExecuteFunctionUsingFileParam");

	}

	public static class ExecuteFunctionUsingFileHeader
	{
		public static final Header<Map<String, Object>> UPLOAD_FILE_HEADER = new Header<Map<String, Object>>("upload_file_header", "com.zoho.crm.api.Functions.ExecuteFunctionUsingFileHeader");

	}
}