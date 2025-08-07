package com.zoho.crm.api.conversionoption;

import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Utility;
import com.zoho.crm.api.util.Constants;

public class ConversionOptionOperations
{
	private Long leadId;

	/**
	 * Creates an instance of ConversionOptionOperations with the given parameters
	 * @param leadId A Long representing the leadId
	 */
	public ConversionOptionOperations(Long leadId)
	{
		 this.leadId = leadId;


	}

	/**
	 * The method to lead conversion options
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> leadConversionOptions() throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/Leads/");

		apiPath = apiPath.concat( this.leadId.toString());

		apiPath = apiPath.concat("/__conversion_options");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.setModuleAPIName("Leads");

		Utility.getFields("Leads,Contacts,Deals,Accounts", handlerInstance);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}
}