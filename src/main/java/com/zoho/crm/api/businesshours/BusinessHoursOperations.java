package com.zoho.crm.api.businesshours;

import com.zoho.crm.api.Header;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class BusinessHoursOperations
{
	private String xCrmOrg;

	/**
	 * Creates an instance of BusinessHoursOperations with the given parameters
	 * @param xCrmOrg A String representing the xCrmOrg
	 */
	public BusinessHoursOperations(String xCrmOrg)
	{
		 this.xCrmOrg = xCrmOrg;


	}

	/**
	 * The method to create business hours
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> createBusinessHours(BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/business_hours");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_CREATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.addHeader(new Header<String>("X-CRM-ORG", "com.zoho.crm.api.BusinessHours.CreateBusinessHoursHeader"),  this.xCrmOrg);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to update business hours
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> updateBusinessHours(BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/business_hours");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_UPDATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.addHeader(new Header<String>("X-CRM-ORG", "com.zoho.crm.api.BusinessHours.UpdateBusinessHoursHeader"),  this.xCrmOrg);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to get business hours
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getBusinessHours() throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/business_hours");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.addHeader(new Header<String>("X-CRM-ORG", "com.zoho.crm.api.BusinessHours.GetBusinessHoursHeader"),  this.xCrmOrg);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}
	public static class CreateBusinessHoursHeader
	{
	}

	public static class UpdateBusinessHoursHeader
	{
	}

	public static class GetBusinessHoursHeader
	{
	}
}