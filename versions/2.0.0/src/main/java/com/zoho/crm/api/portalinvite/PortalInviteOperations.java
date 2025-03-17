package com.zoho.crm.api.portalinvite;

import com.zoho.crm.api.Param;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class PortalInviteOperations
{
	private String module;

	/**
	 * Creates an instance of PortalInviteOperations with the given parameters
	 * @param module A String representing the module
	 */
	public PortalInviteOperations(String module)
	{
		 this.module = module;


	}

	/**
	 * The method to invite users
	 * @param record A Long representing the record
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> inviteUsers(Long record, ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.module.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(record.toString());

		apiPath = apiPath.concat("/actions/portal_invite");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_ACTION);

		handlerInstance.setParam(paramInstance);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}
	public static class InviteUsersParam
	{
		public static final Param<Long> USER_TYPE_ID = new Param<Long>("user_type_id", "com.zoho.crm.api.PortalInvite.InviteUsersParam");

		public static final Param<Choice<String>> TYPE = new Param<Choice<String>>("type", "com.zoho.crm.api.PortalInvite.InviteUsersParam");

		public static final Param<Choice<String>> LANGUAGE = new Param<Choice<String>>("language", "com.zoho.crm.api.PortalInvite.InviteUsersParam");

	}
}