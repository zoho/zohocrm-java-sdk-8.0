package com.zoho.crm.api.usertypeusers;

import com.zoho.crm.api.Param;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class UserTypeUsersOperations
{
	private String portalName;

	private Long userTypeId;

	/**
	 * Creates an instance of UserTypeUsersOperations with the given parameters
	 * @param userTypeId A Long representing the userTypeId
	 * @param portalName A String representing the portalName
	 */
	public UserTypeUsersOperations(Long userTypeId, String portalName)
	{
		 this.userTypeId = userTypeId;

		 this.portalName = portalName;


	}

	/**
	 * The method to get users of user type
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getUsersOfUserType(ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/portals/");

		apiPath = apiPath.concat( this.portalName.toString());

		apiPath = apiPath.concat("/user_type/");

		apiPath = apiPath.concat( this.userTypeId.toString());

		apiPath = apiPath.concat("/users");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.setParam(paramInstance);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to delete user from the portal
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> deleteUserFromThePortal(ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/portals/");

		apiPath = apiPath.concat( this.portalName.toString());

		apiPath = apiPath.concat("/user_type/");

		apiPath = apiPath.concat( this.userTypeId.toString());

		apiPath = apiPath.concat("/users");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.setParam(paramInstance);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to transfer users of a user type
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> transferUsersOfAUserType(ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/portals/");

		apiPath = apiPath.concat( this.portalName.toString());

		apiPath = apiPath.concat("/user_type/");

		apiPath = apiPath.concat( this.userTypeId.toString());

		apiPath = apiPath.concat("/users/action/transfer");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_CREATE);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.setParam(paramInstance);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to change users status
	 * @param userId A Long representing the userId
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<StatusActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<StatusActionHandler> changeUsersStatus(Long userId, ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/portals/");

		apiPath = apiPath.concat( this.portalName.toString());

		apiPath = apiPath.concat("/user_type/");

		apiPath = apiPath.concat( this.userTypeId.toString());

		apiPath = apiPath.concat("/users/");

		apiPath = apiPath.concat(userId.toString());

		apiPath = apiPath.concat("/actions/change_status");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_UPDATE);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.setParam(paramInstance);

		return handlerInstance.apiCall(StatusActionHandler.class, "application/json");

	}
	public static class GetUsersOfUserTypeParam
	{
		public static final Param<String> FILTERS = new Param<String>("filters", "com.zoho.crm.api.UserTypeUsers.GetUsersOfUserTypeParam");

		public static final Param<String> TYPE = new Param<String>("type", "com.zoho.crm.api.UserTypeUsers.GetUsersOfUserTypeParam");

	}

	public static class DeleteUserFromThePortalParam
	{
		public static final Param<String> PERSONALITY_IDS = new Param<String>("personality_ids", "com.zoho.crm.api.UserTypeUsers.DeleteUserFromThePortalParam");

	}

	public static class TransferUsersOfAUserTypeParam
	{
		public static final Param<String> PERSONALITY_IDS = new Param<String>("personality_ids", "com.zoho.crm.api.UserTypeUsers.TransferUsersOfAUserTypeParam");

		public static final Param<String> TRANSFER_TO = new Param<String>("transfer_To", "com.zoho.crm.api.UserTypeUsers.TransferUsersOfAUserTypeParam");

	}

	public static class ChangeUsersStatusParam
	{
		public static final Param<Boolean> ACTIVE = new Param<Boolean>("active", "com.zoho.crm.api.UserTypeUsers.ChangeUsersStatusParam");

	}
}