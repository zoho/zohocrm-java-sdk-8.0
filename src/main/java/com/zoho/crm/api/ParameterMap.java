package com.zoho.crm.api;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.zoho.api.logger.SDKLogger;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.Constants;
import com.zoho.crm.api.util.DataTypeConverter;
import com.zoho.crm.api.util.HeaderParamValidator;

/**
 * This class represents the HTTP parameter name and value.
 */
public class ParameterMap
{
	protected static final Logger LOGGER = Logger.getLogger(SDKLogger.class.getName());
	private HashMap<String, String> parameterMap = new HashMap<String, String>();

	/**
	 * This is a getter method to get parameter map.
	 * 
	 * @return A HashMap&lt;String, String&gt; representing the API request parameters.
	 */
	public HashMap<String, String> getParameterMap()
	{
		return parameterMap;
	}

	/**
	 * This method to add parameter name and value.
	 * 
	 * @param <T>   A T containing the specified data type.
	 * @param param A Param&lt;T&gt; class instance.
	 * @param value A T containing the parameter value.
	 */
	public <T> void add(Param<T> param, T value) throws SDKException
	{
		if (param == null)
		{
			throw new SDKException(Constants.PARAMETER_NULL_ERROR, Constants.PARAM_INSTANCE_NULL_ERROR);
		}
		String paramName = param.getName();
		if (paramName == null)
		{
			throw new SDKException(Constants.PARAM_NAME_NULL_ERROR, Constants.PARAM_NAME_NULL_ERROR_MESSAGE);
		}
		if (value == null)
		{
			throw new SDKException(Constants.PARAMETER_NULL_ERROR, paramName + Constants.NULL_VALUE_ERROR_MESSAGE);
		}
		try
		{
			String paramClassName = param.getClassName();
			String parsedParamValue;
			if (paramClassName != null)
			{
				HeaderParamValidator<T> headerParamValidator = new HeaderParamValidator<>();
				parsedParamValue = headerParamValidator.validate(paramName, paramClassName, value);
			}
			else
			{
				try
				{
					parsedParamValue = DataTypeConverter.postConvert(value, value.getClass().getName()).toString();
				}
				catch (Exception e)
				{
					parsedParamValue = value.toString();
				}
			}
			if (parameterMap.containsKey(paramName) && !parameterMap.get(paramName).isEmpty())
			{
				String existingParamValue = parameterMap.get(paramName);
				existingParamValue = existingParamValue + "," + parsedParamValue;
				parameterMap.put(paramName, existingParamValue);
			}
			else
			{
				parameterMap.put(paramName, parsedParamValue);
			}
		}
		catch (SDKException e)
		{
			LOGGER.log(Level.SEVERE, Constants.PARAM_EXCEPTION, e);
			throw e;
		}
		catch (Exception e)
		{
			SDKException exception = new SDKException(e);
			LOGGER.log(Level.SEVERE, Constants.PARAM_EXCEPTION, exception);
			throw exception;
		}
	}
}
