package com.zoho.crm.api.fieldmapdependency;

import com.zoho.crm.api.Param;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class FieldMapDependencyOperations
{
	private String module;

	private Long layoutId;

	/**
	 * Creates an instance of FieldMapDependencyOperations with the given parameters
	 * @param layoutId A Long representing the layoutId
	 * @param module A String representing the module
	 */
	public FieldMapDependencyOperations(Long layoutId, String module)
	{
		 this.layoutId = layoutId;

		 this.module = module;


	}

	/**
	 * The method to create map dependency
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> createMapDependency(BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/layouts/");

		apiPath = apiPath.concat( this.layoutId.toString());

		apiPath = apiPath.concat("/map_dependency");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_CREATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.addParam(new Param<String>("module", "com.zoho.crm.api.FieldMapDependency.CreateMapDependencyParam"),  this.module);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to get map dependencies
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getMapDependencies(ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/layouts/");

		apiPath = apiPath.concat( this.layoutId.toString());

		apiPath = apiPath.concat("/map_dependency");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.addParam(new Param<String>("module", "com.zoho.crm.api.FieldMapDependency.GetMapDependenciesParam"),  this.module);

		handlerInstance.setParam(paramInstance);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to update map dependency
	 * @param dependencyId A Long representing the dependencyId
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> updateMapDependency(Long dependencyId, BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/layouts/");

		apiPath = apiPath.concat( this.layoutId.toString());

		apiPath = apiPath.concat("/map_dependency/");

		apiPath = apiPath.concat(dependencyId.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_UPDATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.addParam(new Param<String>("module", "com.zoho.crm.api.FieldMapDependency.UpdateMapDependencyParam"),  this.module);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to get map dependency
	 * @param dependencyId A Long representing the dependencyId
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getMapDependency(Long dependencyId) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/layouts/");

		apiPath = apiPath.concat( this.layoutId.toString());

		apiPath = apiPath.concat("/map_dependency/");

		apiPath = apiPath.concat(dependencyId.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.addParam(new Param<String>("module", "com.zoho.crm.api.FieldMapDependency.GetMapDependencyParam"),  this.module);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to delete map dependency
	 * @param dependencyId A Long representing the dependencyId
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> deleteMapDependency(Long dependencyId) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/layouts/");

		apiPath = apiPath.concat( this.layoutId.toString());

		apiPath = apiPath.concat("/map_dependency/");

		apiPath = apiPath.concat(dependencyId.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.addParam(new Param<String>("module", "com.zoho.crm.api.FieldMapDependency.DeleteMapDependencyParam"),  this.module);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}
	public static class CreateMapDependencyParam
	{
	}

	public static class GetMapDependenciesParam
	{
		public static final Param<Integer> PAGE = new Param<Integer>("page", "com.zoho.crm.api.FieldMapDependency.GetMapDependenciesParam");

		public static final Param<Integer> PER_PAGE = new Param<Integer>("per_page", "com.zoho.crm.api.FieldMapDependency.GetMapDependenciesParam");

		public static final Param<String> FILTERS = new Param<String>("filters", "com.zoho.crm.api.FieldMapDependency.GetMapDependenciesParam");

	}

	public static class UpdateMapDependencyParam
	{
	}

	public static class GetMapDependencyParam
	{
	}

	public static class DeleteMapDependencyParam
	{
	}
}