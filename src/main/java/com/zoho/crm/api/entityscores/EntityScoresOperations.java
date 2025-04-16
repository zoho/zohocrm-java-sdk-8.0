package com.zoho.crm.api.entityscores;

import com.zoho.crm.api.Header;
import com.zoho.crm.api.HeaderMap;
import com.zoho.crm.api.Param;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import java.time.OffsetDateTime;
import com.zoho.crm.api.util.Constants;

public class EntityScoresOperations
{
	private String fields;

	private String cvid;

	/**
	 * Creates an instance of EntityScoresOperations with the given parameters
	 * @param fields A String representing the fields
	 * @param cvid A String representing the cvid
	 */
	public EntityScoresOperations(String fields, String cvid)
	{
		 this.fields = fields;

		 this.cvid = cvid;


	}

	/**
	 * The method to get entity score
	 * @param recordId A Long representing the recordId
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getEntityScore(Long recordId) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/Entity_Scores__s/");

		apiPath = apiPath.concat(recordId.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.addParam(new Param<String>("fields", "com.zoho.crm.api.EntityScores.GetEntityScoreParam"),  this.fields);

		handlerInstance.addParam(new Param<String>("cvid", "com.zoho.crm.api.EntityScores.GetEntityScoreParam"),  this.cvid);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to get entity scores
	 * @param paramInstance An instance of ParameterMap
	 * @param headerInstance An instance of HeaderMap
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getEntityScores(ParameterMap paramInstance, HeaderMap headerInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/Entity_Scores__s");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.addParam(new Param<String>("fields", "com.zoho.crm.api.EntityScores.GetEntityScoresParam"),  this.fields);

		handlerInstance.addParam(new Param<String>("cvid", "com.zoho.crm.api.EntityScores.GetEntityScoresParam"),  this.cvid);

		handlerInstance.setParam(paramInstance);

		handlerInstance.setHeader(headerInstance);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}
	public static class GetEntityScoreParam
	{
	}

	public static class GetEntityScoresParam
	{
		public static final Param<String> IDS = new Param<String>("ids", "com.zoho.crm.api.EntityScores.GetEntityScoresParam");

		public static final Param<String> SORT_BY = new Param<String>("sort_by", "com.zoho.crm.api.EntityScores.GetEntityScoresParam");

		public static final Param<String> SORT_ORDER = new Param<String>("sort_order", "com.zoho.crm.api.EntityScores.GetEntityScoresParam");

		public static final Param<Integer> PAGE = new Param<Integer>("page", "com.zoho.crm.api.EntityScores.GetEntityScoresParam");

		public static final Param<Integer> PER_PAGE = new Param<Integer>("per_page", "com.zoho.crm.api.EntityScores.GetEntityScoresParam");

		public static final Param<String> PAGE_TOKEN = new Param<String>("page_token", "com.zoho.crm.api.EntityScores.GetEntityScoresParam");

	}

	public static class GetEntityScoresHeader
	{
		public static final Header<OffsetDateTime> IF_MODIFIED_SINCE = new Header<OffsetDateTime>("If-Modified-Since", "com.zoho.crm.api.EntityScores.GetEntityScoresHeader");

	}
}