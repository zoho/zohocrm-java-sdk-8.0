package com.zoho.crm.api.getrelatedrecordscount;

import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class GetRelatedRecordsCountOperations
{
	private String moduleAPIName;

	private Long recordId;

	/**
	 * Creates an instance of GetRelatedRecordsCountOperations with the given parameters
	 * @param recordId A Long representing the recordId
	 * @param moduleAPIName A String representing the moduleAPIName
	 */
	public GetRelatedRecordsCountOperations(Long recordId, String moduleAPIName)
	{
		 this.recordId = recordId;

		 this.moduleAPIName = moduleAPIName;


	}

	/**
	 * The method to get related records count
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> getRelatedRecordsCount(BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat( this.recordId.toString());

		apiPath = apiPath.concat("/actions/get_related_records_count");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_ACTION);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}
}