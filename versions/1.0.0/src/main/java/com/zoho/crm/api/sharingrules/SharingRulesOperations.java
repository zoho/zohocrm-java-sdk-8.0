package com.zoho.crm.api.sharingrules;

import com.zoho.crm.api.Param;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class SharingRulesOperations
{
	private String module;

	/**
	 * Creates an instance of SharingRulesOperations with the given parameters
	 * @param module A String representing the module
	 */
	public SharingRulesOperations(String module)
	{
		 this.module = module;


	}

	/**
	 * The method to get sharing rules
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getSharingRules(ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/data_sharing/rules");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.addParam(new Param<String>("module", "com.zoho.crm.api.SharingRules.GetSharingRulesParam"),  this.module);

		handlerInstance.setParam(paramInstance);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to create sharing rules
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> createSharingRules(BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/data_sharing/rules");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_CREATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.addParam(new Param<String>("module", "com.zoho.crm.api.SharingRules.CreateSharingRulesParam"),  this.module);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to update sharing rules
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> updateSharingRules(BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/data_sharing/rules");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_UPDATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.addParam(new Param<String>("module", "com.zoho.crm.api.SharingRules.UpdateSharingRulesParam"),  this.module);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to get sharing rule
	 * @param id A Long representing the id
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getSharingRule(Long id) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/data_sharing/rules/");

		apiPath = apiPath.concat(id.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.addParam(new Param<String>("module", "com.zoho.crm.api.SharingRules.GetSharingRuleParam"),  this.module);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to update sharing rule
	 * @param id A Long representing the id
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> updateSharingRule(Long id, BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/data_sharing/rules/");

		apiPath = apiPath.concat(id.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_UPDATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.addParam(new Param<String>("module", "com.zoho.crm.api.SharingRules.UpdateSharingRuleParam"),  this.module);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to delete sharing rule
	 * @param id A Long representing the id
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> deleteSharingRule(Long id) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/data_sharing/rules/");

		apiPath = apiPath.concat(id.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.addParam(new Param<String>("module", "com.zoho.crm.api.SharingRules.DeleteSharingRuleParam"),  this.module);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to search sharing rules
	 * @param request An instance of FiltersBody
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> searchSharingRules(FiltersBody request, ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/data_sharing/rules/search");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_ACTION);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.addParam(new Param<String>("module", "com.zoho.crm.api.SharingRules.SearchSharingRulesParam"),  this.module);

		handlerInstance.setParam(paramInstance);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to deactivate sharing rule
	 * @param id A Long representing the id
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> deactivateSharingRule(Long id) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/data_sharing/rules/");

		apiPath = apiPath.concat(id.toString());

		apiPath = apiPath.concat("/actions/activate");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_ACTION);

		handlerInstance.addParam(new Param<String>("module", "com.zoho.crm.api.SharingRules.DeactivateSharingRuleParam"),  this.module);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to activate sharing rule
	 * @param id A Long representing the id
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> activateSharingRule(Long id) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/data_sharing/rules/");

		apiPath = apiPath.concat(id.toString());

		apiPath = apiPath.concat("/actions/activate");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_ACTION);

		handlerInstance.addParam(new Param<String>("module", "com.zoho.crm.api.SharingRules.ActivateSharingRuleParam"),  this.module);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to get sharing rule summary
	 * @return An instance of APIResponse<SummaryResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<SummaryResponseHandler> getSharingRuleSummary() throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/data_sharing/rules/actions/summary");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.addParam(new Param<String>("module", "com.zoho.crm.api.SharingRules.GetSharingRuleSummaryParam"),  this.module);

		return handlerInstance.apiCall(SummaryResponseHandler.class, "application/json");

	}

	/**
	 * The method to search sharing rules summary
	 * @param request An instance of FiltersBody
	 * @return An instance of APIResponse<SummaryResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<SummaryResponseHandler> searchSharingRulesSummary(FiltersBody request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/data_sharing/rules/actions/summary");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_ACTION);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.addParam(new Param<String>("module", "com.zoho.crm.api.SharingRules.SearchSharingRulesSummaryParam"),  this.module);

		return handlerInstance.apiCall(SummaryResponseHandler.class, "application/json");

	}

	/**
	 * The method to rerun sharing rules
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> rerunSharingRules() throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/data_sharing/rules/actions/run");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_ACTION);

		handlerInstance.addParam(new Param<String>("module", "com.zoho.crm.api.SharingRules.RerunSharingRulesParam"),  this.module);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}
	public static class GetSharingRulesParam
	{
		public static final Param<Integer> PAGE = new Param<Integer>("page", "com.zoho.crm.api.SharingRules.GetSharingRulesParam");

		public static final Param<Integer> PER_PAGE = new Param<Integer>("per_page", "com.zoho.crm.api.SharingRules.GetSharingRulesParam");

	}

	public static class CreateSharingRulesParam
	{
	}

	public static class UpdateSharingRulesParam
	{
	}

	public static class GetSharingRuleParam
	{
	}

	public static class UpdateSharingRuleParam
	{
	}

	public static class DeleteSharingRuleParam
	{
	}

	public static class SearchSharingRulesParam
	{
		public static final Param<Integer> PAGE = new Param<Integer>("page", "com.zoho.crm.api.SharingRules.SearchSharingRulesParam");

		public static final Param<Integer> PER_PAGE = new Param<Integer>("per_page", "com.zoho.crm.api.SharingRules.SearchSharingRulesParam");

	}

	public static class DeactivateSharingRuleParam
	{
	}

	public static class ActivateSharingRuleParam
	{
	}

	public static class GetSharingRuleSummaryParam
	{
	}

	public static class SearchSharingRulesSummaryParam
	{
	}

	public static class RerunSharingRulesParam
	{
	}
}