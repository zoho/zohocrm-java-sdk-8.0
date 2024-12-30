package com.zoho.crm.api.inventoryconvert;

import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class InventoryConvertOperations
{
	private String moduleAPIName;

	private Long id;

	/**
	 * Creates an instance of InventoryConvertOperations with the given parameters
	 * @param id A Long representing the id
	 * @param moduleAPIName A String representing the moduleAPIName
	 */
	public InventoryConvertOperations(Long id, String moduleAPIName)
	{
		 this.id = id;

		 this.moduleAPIName = moduleAPIName;


	}

	/**
	 * The method to convert inventory
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> convertInventory(BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat( this.id.toString());

		apiPath = apiPath.concat("/actions/convert");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_CREATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}
}