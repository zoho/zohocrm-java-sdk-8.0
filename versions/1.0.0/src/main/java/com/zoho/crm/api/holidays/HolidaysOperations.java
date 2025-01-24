package com.zoho.crm.api.holidays;

import com.zoho.crm.api.Header;
import com.zoho.crm.api.Param;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class HolidaysOperations
{
	private String xCrmOrg;

	/**
	 * Creates an instance of HolidaysOperations with the given parameters
	 * @param xCrmOrg A String representing the xCrmOrg
	 */
	public HolidaysOperations(String xCrmOrg)
	{
		 this.xCrmOrg = xCrmOrg;


	}

	/**
	 * The method to get holidays
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getHolidays(ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/holidays");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.addHeader(new Header<String>("X-CRM-ORG", "com.zoho.crm.api.Holidays.GetHolidaysHeader"),  this.xCrmOrg);

		handlerInstance.setParam(paramInstance);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to create holidays
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> createHolidays(BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/holidays");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_CREATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.addHeader(new Header<String>("X-CRM-ORG", "com.zoho.crm.api.Holidays.CreateHolidaysHeader"),  this.xCrmOrg);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to update holidays
	 * @param request An instance of Holidays
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> updateHolidays(Holidays request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/holidays");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_UPDATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.addHeader(new Header<String>("X-CRM-ORG", "com.zoho.crm.api.Holidays.UpdateHolidaysHeader"),  this.xCrmOrg);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to update holiday
	 * @param holidayId A Long representing the holidayId
	 * @param request An instance of Holidays
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> updateHoliday(Long holidayId, Holidays request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/holidays/");

		apiPath = apiPath.concat(holidayId.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_UPDATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.addHeader(new Header<String>("X-CRM-ORG", "com.zoho.crm.api.Holidays.UpdateHolidayHeader"),  this.xCrmOrg);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to get holiday
	 * @param holidayId A Long representing the holidayId
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getHoliday(Long holidayId) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/holidays/");

		apiPath = apiPath.concat(holidayId.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.addHeader(new Header<String>("X-CRM-ORG", "com.zoho.crm.api.Holidays.GetHolidayHeader"),  this.xCrmOrg);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to delete holiday
	 * @param holidayId A Long representing the holidayId
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> deleteHoliday(Long holidayId) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/holidays/");

		apiPath = apiPath.concat(holidayId.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.setCategoryMethod(Constants.REQUEST_METHOD_DELETE);

		handlerInstance.addHeader(new Header<String>("X-CRM-ORG", "com.zoho.crm.api.Holidays.DeleteHolidayHeader"),  this.xCrmOrg);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}
	public static class GetHolidaysHeader
	{
	}

	public static class GetHolidaysParam
	{
		public static final Param<Integer> YEAR = new Param<Integer>("year", "com.zoho.crm.api.Holidays.GetHolidaysParam");

		public static final Param<Choice<String>> TYPE = new Param<Choice<String>>("type", "com.zoho.crm.api.Holidays.GetHolidaysParam");

		public static final Param<Long> SHIFT_ID = new Param<Long>("shift_id", "com.zoho.crm.api.Holidays.GetHolidaysParam");

	}

	public static class CreateHolidaysHeader
	{
	}

	public static class UpdateHolidaysHeader
	{
	}

	public static class UpdateHolidayHeader
	{
	}

	public static class GetHolidayHeader
	{
	}

	public static class DeleteHolidayHeader
	{
	}
}