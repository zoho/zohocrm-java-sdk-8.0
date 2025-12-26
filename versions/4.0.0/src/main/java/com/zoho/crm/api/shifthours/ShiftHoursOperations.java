package com.zoho.crm.api.shifthours;

import com.zoho.crm.api.Header;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class ShiftHoursOperations
{
	private String xCrmOrg;

	/**
	 * Creates an instance of ShiftHoursOperations with the given parameters
	 * @param xCrmOrg A String representing the xCrmOrg
	 */
	public ShiftHoursOperations(String xCrmOrg)
	{
		 this.xCrmOrg = xCrmOrg;


	}

	/**
	 * The method to get shift hours
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getShiftHours() throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/business_hours/shift_hours");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.addHeader(new Header<String>("X-CRM-ORG", "com.zoho.crm.api.ShiftHours.GetShiftHoursHeader"),  this.xCrmOrg);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to create shifts hours
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> createShiftsHours(BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/business_hours/shift_hours");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_CREATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.addHeader(new Header<String>("X-CRM-ORG", "com.zoho.crm.api.ShiftHours.CreateShiftsHoursHeader"),  this.xCrmOrg);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to update shift hours
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> updateShiftHours(BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/business_hours/shift_hours");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_UPDATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.addHeader(new Header<String>("X-CRM-ORG", "com.zoho.crm.api.ShiftHours.UpdateShiftHoursHeader"),  this.xCrmOrg);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to get shift hour
	 * @param shiftId A Long representing the shiftId
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getShiftHour(Long shiftId) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/business_hours/shift_hours/");

		apiPath = apiPath.concat(shiftId.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.addHeader(new Header<String>("X-CRM-ORG", "com.zoho.crm.api.ShiftHours.GetShiftHourHeader"),  this.xCrmOrg);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to update shift hour
	 * @param shiftId A Long representing the shiftId
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> updateShiftHour(Long shiftId, BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/business_hours/shift_hours/");

		apiPath = apiPath.concat(shiftId.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_UPDATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.addHeader(new Header<String>("X-CRM-ORG", "com.zoho.crm.api.ShiftHours.UpdateShiftHourHeader"),  this.xCrmOrg);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to delete shift hour
	 * @param shiftId A Long representing the shiftId
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> deleteShiftHour(Long shiftId) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/business_hours/shift_hours/");

		apiPath = apiPath.concat(shiftId.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.addHeader(new Header<String>("X-CRM-ORG", "com.zoho.crm.api.ShiftHours.DeleteShiftHourHeader"),  this.xCrmOrg);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}
	public static class GetShiftHoursHeader
	{
	}

	public static class CreateShiftsHoursHeader
	{
	}

	public static class UpdateShiftHoursHeader
	{
	}

	public static class GetShiftHourHeader
	{
	}

	public static class UpdateShiftHourHeader
	{
	}

	public static class DeleteShiftHourHeader
	{
	}
}