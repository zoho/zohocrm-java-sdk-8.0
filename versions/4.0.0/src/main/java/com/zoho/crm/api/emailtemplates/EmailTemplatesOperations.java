package com.zoho.crm.api.emailtemplates;

import com.zoho.crm.api.Param;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class EmailTemplatesOperations
{
	/**
	 * The method to get email templates
	 * @param paramInstance An instance of ParameterMap
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getEmailTemplates(ParameterMap paramInstance) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/email_templates");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.setParam(paramInstance);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to get email template
	 * @param template A Long representing the template
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getEmailTemplate(Long template) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v8/settings/email_templates/");

		apiPath = apiPath.concat(template.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}
	public static class GetEmailTemplatesParam
	{
		public static final Param<String> MODULE = new Param<String>("module", "com.zoho.crm.api.EmailTemplates.GetEmailTemplatesParam");

		public static final Param<String> CATEGORY = new Param<String>("category", "com.zoho.crm.api.EmailTemplates.GetEmailTemplatesParam");

		public static final Param<String> SORT_BY = new Param<String>("sort_by", "com.zoho.crm.api.EmailTemplates.GetEmailTemplatesParam");

		public static final Param<String> SORT_ORDER = new Param<String>("sort_order", "com.zoho.crm.api.EmailTemplates.GetEmailTemplatesParam");

		public static final Param<String> FILTERS = new Param<String>("filters", "com.zoho.crm.api.EmailTemplates.GetEmailTemplatesParam");

	}
}