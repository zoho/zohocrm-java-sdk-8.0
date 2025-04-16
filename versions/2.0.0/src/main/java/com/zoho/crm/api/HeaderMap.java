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
 * This class represents the HTTP header name and value.
 */
public class HeaderMap
{
	protected static final Logger LOGGER = Logger.getLogger(SDKLogger.class.getName());
	private HashMap<String, String> headerMap = new HashMap<String, String>();

	/**
	 * This is a getter method to get header map.
	 * 
	 * @return A HashMap&lt;String, String&gt; representing the API request headers.
	 */
	public HashMap<String, String> getHeaderMap()
	{
		return headerMap;
	}

	/**
	 * This method is to add header name and value.
	 * 
	 * @param <T>    A T containing the specified data type.
	 * @param header A Header&lt;T&gt; class instance.
	 * @param value  A T containing the header value.
	 */
	public <T> void add(Header<T> header, T value) throws SDKException
	{
		if (header == null)
		{
			throw new SDKException(Constants.HEADER_NULL_ERROR, Constants.HEADER_INSTANCE_NULL_ERROR);
		}
		String headerName = header.getName();
		if (headerName == null)
		{
			throw new SDKException(Constants.HEADER_NAME_NULL_ERROR, Constants.HEADER_NAME_NULL_ERROR_MESSAGE);
		}
		if (value == null)
		{
			throw new SDKException(Constants.HEADER_NULL_ERROR, headerName + Constants.NULL_VALUE_ERROR_MESSAGE);
		}
		try
		{
			String headerClassName = header.getClassName();
			String parsedHeaderValue;
			if (headerClassName != null)
			{
				HeaderParamValidator<T> headerParamValidator = new HeaderParamValidator<>();
				parsedHeaderValue = headerParamValidator.validate(headerName, headerClassName, value);
			}
			else
			{
				try
				{
					parsedHeaderValue = DataTypeConverter.postConvert(value, value.getClass().getName()).toString();
				}
				catch (Exception e)
				{
					parsedHeaderValue = value.toString();
				}
			}
			if (headerMap.containsKey(headerName) && !headerMap.get(headerName).isEmpty())
			{
				String existingHeaderValue = headerMap.get(headerName);
				existingHeaderValue = existingHeaderValue + "," + parsedHeaderValue;
				headerMap.put(headerName, existingHeaderValue);
			}
			else
			{
				headerMap.put(headerName, parsedHeaderValue);
			}
		}
		catch (SDKException e)
		{
			LOGGER.log(Level.SEVERE, Constants.HEADER_EXCEPTION, e);
			throw e;
		}
		catch (Exception e)
		{
			SDKException exception = new SDKException(e);
			LOGGER.log(Level.SEVERE, Constants.HEADER_EXCEPTION, exception);
			throw exception;
		}
	}
}
