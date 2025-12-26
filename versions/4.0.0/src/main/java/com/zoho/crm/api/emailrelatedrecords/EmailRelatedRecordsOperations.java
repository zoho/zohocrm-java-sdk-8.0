package com.zoho.crm.api.emailrelatedrecords;

import com.zoho.crm.api.Param;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class EmailRelatedRecordsOperations
{
	private String moduleName;

	private Long recordId;

	private String type;

	private Long ownerId;

	/**
	 * Creates an instance of EmailRelatedRecordsOperations with the given parameters
	 * @param recordId A Long representing the recordId
	 * @param moduleName A String representing the moduleName
	 * @param type A String representing the type
	 * @param ownerId A Long representing the ownerId
	 */
	public EmailRelatedRecordsOperations(Long recordId, String moduleName, String type, Long ownerId)
	{
		 this.recordId = recordId;

		 this.moduleName = moduleName;

		 this.type = type;

		 this.ownerId = ownerId;


	}

	/**
	 * The method to get emails related records
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getEmailsRelatedRecords(ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat( this.recordId.toString());

		apiPath = apiPath.concat("/Emails");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.addParam(new Param<String>("type", "com.zoho.crm.api.EmailRelatedRecords.GetEmailsRelatedRecordsParam"),  this.type);

		handlerInstance.addParam(new Param<Long>("owner_id", "com.zoho.crm.api.EmailRelatedRecords.GetEmailsRelatedRecordsParam"),  this.ownerId);

		handlerInstance.setParam(paramInstance);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to get emails related record
	 * @param messageId A String representing the messageId
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getEmailsRelatedRecord(String messageId) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/");

		apiPath = apiPath.concat( this.moduleName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat( this.recordId.toString());

		apiPath = apiPath.concat("/Emails/");

		apiPath = apiPath.concat(messageId.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.addParam(new Param<String>("type", "com.zoho.crm.api.EmailRelatedRecords.GetEmailsRelatedRecordParam"),  this.type);

		handlerInstance.addParam(new Param<Long>("owner_id", "com.zoho.crm.api.EmailRelatedRecords.GetEmailsRelatedRecordParam"),  this.ownerId);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}
	public static class GetEmailsRelatedRecordsParam
	{
		public static final Param<Criteria> FILTER = new Param<Criteria>("filter", "com.zoho.crm.api.EmailRelatedRecords.GetEmailsRelatedRecordsParam");

		public static final Param<String> INDEX = new Param<String>("index", "com.zoho.crm.api.EmailRelatedRecords.GetEmailsRelatedRecordsParam");

	}

	public static class GetEmailsRelatedRecordParam
	{
	}
}