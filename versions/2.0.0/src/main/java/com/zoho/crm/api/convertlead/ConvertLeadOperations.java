package com.zoho.crm.api.convertlead;

import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Utility;
import com.zoho.crm.api.util.Constants;

public class ConvertLeadOperations
{
	private Long leadId;

	/**
	 * Creates an instance of ConvertLeadOperations with the given parameters
	 * @param leadId A Long representing the leadId
	 */
	public ConvertLeadOperations(Long leadId)
	{
		 this.leadId = leadId;


	}

	/**
	 * The method to convert lead
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> convertLead(BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/Leads/");

		apiPath = apiPath.concat( this.leadId.toString());

		apiPath = apiPath.concat("/actions/convert");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_CREATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.setModuleAPIName("Deals");

		Utility.getFields("Deals", handlerInstance);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}
}