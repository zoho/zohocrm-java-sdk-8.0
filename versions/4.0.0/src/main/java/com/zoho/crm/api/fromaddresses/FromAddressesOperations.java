package com.zoho.crm.api.fromaddresses;

import com.zoho.crm.api.Param;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class FromAddressesOperations
{
	private String userId;

	/**
	 * Creates an instance of FromAddressesOperations with the given parameters
	 * @param userId A String representing the userId
	 */
	public FromAddressesOperations(String userId)
	{
		 this.userId = userId;


	}

	/**
	 * The method to get from addresses
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getFromAddresses() throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/emails/actions/from_addresses");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.addParam(new Param<String>("user_id", "com.zoho.crm.api.FromAddresses.GetFromAddressesParam"),  this.userId);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}
	public static class GetFromAddressesParam
	{
	}
}