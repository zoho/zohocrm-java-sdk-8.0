package com.zoho.crm.api.dealcontactroles;

import com.zoho.crm.api.Param;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Utility;
import com.zoho.crm.api.util.Constants;

public class DealContactRolesOperations
{
	/**
	 * The method to get associated contact roles
	 * @param deal A Long representing the deal
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getAssociatedContactRoles(Long deal, ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/Deals/");

		apiPath = apiPath.concat(deal.toString());

		apiPath = apiPath.concat("/Contact_Roles");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.setParam(paramInstance);

		handlerInstance.setModuleAPIName("Contacts");

		Utility.getFields("Contacts", handlerInstance);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to delete associated contact roles
	 * @param deal A Long representing the deal
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> deleteAssociatedContactRoles(Long deal, ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/Deals/");

		apiPath = apiPath.concat(deal.toString());

		apiPath = apiPath.concat("/Contact_Roles");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.setParam(paramInstance);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to get associated contact roles specific to contact
	 * @param contact A Long representing the contact
	 * @param deal A Long representing the deal
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getAssociatedContactRolesSpecificToContact(Long contact, Long deal) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/Deals/");

		apiPath = apiPath.concat(deal.toString());

		apiPath = apiPath.concat("/Contact_Roles/");

		apiPath = apiPath.concat(contact.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.setModuleAPIName("Contacts");

		Utility.getFields("Contacts", handlerInstance);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to associate contact role to deal
	 * @param contact A Long representing the contact
	 * @param deal A Long representing the deal
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> associateContactRoleToDeal(Long contact, Long deal, BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/Deals/");

		apiPath = apiPath.concat(deal.toString());

		apiPath = apiPath.concat("/Contact_Roles/");

		apiPath = apiPath.concat(contact.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_UPDATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to delete contact role relation
	 * @param contact A Long representing the contact
	 * @param deal A Long representing the deal
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> deleteContactRoleRelation(Long contact, Long deal) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/Deals/");

		apiPath = apiPath.concat(deal.toString());

		apiPath = apiPath.concat("/Contact_Roles/");

		apiPath = apiPath.concat(contact.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}
	public static class GetAssociatedContactRolesParam
	{
		public static final Param<String> IDS = new Param<String>("ids", "com.zoho.crm.api.DealContactRoles.GetAssociatedContactRolesParam");

		public static final Param<String> FIELDS = new Param<String>("fields", "com.zoho.crm.api.DealContactRoles.GetAssociatedContactRolesParam");

	}

	public static class DeleteAssociatedContactRolesParam
	{
		public static final Param<String> IDS = new Param<String>("ids", "com.zoho.crm.api.DealContactRoles.DeleteAssociatedContactRolesParam");

	}
}