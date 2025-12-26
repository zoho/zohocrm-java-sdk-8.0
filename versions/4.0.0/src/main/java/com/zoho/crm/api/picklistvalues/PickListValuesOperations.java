package com.zoho.crm.api.picklistvalues;

import com.zoho.crm.api.Param;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class PickListValuesOperations
{
	private Long fieldId;

	private String module;

	/**
	 * Creates an instance of PickListValuesOperations with the given parameters
	 * @param fieldId A Long representing the fieldId
	 * @param module A String representing the module
	 */
	public PickListValuesOperations(Long fieldId, String module)
	{
		 this.fieldId = fieldId;

		 this.module = module;


	}

	/**
	 * The method to get pick list values
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getPickListValues() throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/fields/");

		apiPath = apiPath.concat( this.fieldId.toString());

		apiPath = apiPath.concat("/pick_list_values");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.addParam(new Param<String>("module", "com.zoho.crm.api.PickListValues.GetPickListValuesParam"),  this.module);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}
	public static class GetPickListValuesParam
	{
	}
}