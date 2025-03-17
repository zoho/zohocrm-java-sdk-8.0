package com.zoho.crm.api.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.exception.SDKException;

/**
 * This abstract class is to construct API request and response.
 */
public abstract class Converter
{
	protected CommonAPIHandler commonAPIHandler;

	/**
	 * Creates a Converter class instance with no parameters.
	 */
	public Converter()
	{
	}

	/**
	 * Creates a Converter class instance with the CommonAPIHandler class instance.
	 * 
	 * @param commonAPIHandler A CommonAPIHandler class instance.
	 */
	public Converter(CommonAPIHandler commonAPIHandler)
	{
		this.commonAPIHandler = commonAPIHandler;
	}

	/**
	 * This abstract method is to process the API response.
	 * 
	 * @param response A Object containing the API response contents or response.
	 * @param pack     A String containing the expected method return type.
	 * @return A Object representing the POJO class instance.
	 * @throws Exception if a problem occurs.
	 */
	public abstract Object getResponse(Object response, String pack) throws Exception;

	/**
	 * This abstract method is to construct the API request.
	 * 
	 * @param requestInstance A Object containing the POJO class instance.
	 * @param pack            A String containing the expected method return type.
	 * @param instanceNumber  An Integer containing the POJO class instance list number.
	 * @param memberDetail    An JSONObject containing the member properties
	 * @return A Object representing the API request body object.
	 * @throws Exception if a problem occurs.
	 */
	public abstract Object formRequest(Object requestInstance, String pack, Integer instanceNumber, JSONObject memberDetail) throws Exception;

	/**
	 * This abstract method is to construct the API request body.
	 * 
	 * @param requestBase   A HttpEntityEnclosingRequestBase class instance.
	 * @param requestObject A Object containing the API request body object.
	 * @throws Exception if a problem occurs.
	 */
	public abstract void appendToRequest(HttpEntityEnclosingRequestBase requestBase, Object requestObject) throws Exception;

	/**
	 * This abstract method is to process the API response.
	 * 
	 * @param response A Object containing the HttpResponse class instance.
	 * @param pack     A String containing the expected method return type.
	 * @return ArrayList<Object> representing the POJO class instance and response JSON.
	 * @throws Exception if a problem occurs.
	 */
	public abstract ArrayList<Object> getWrappedResponse(Object response, String pack) throws Exception;

	/**
	 * This method is to validate if the input values satisfy the constraints for the respective fields.
	 * 
	 * @param className       A String containing the class name.
	 * @param memberName      A String containing the member name.
	 * @param keyDetails      A JSONObject containing the key JSON details.
	 * @param value           A Object containing the key value.
	 * @param uniqueValuesMap A HashMap&lt;String,ArrayList&lt;Object&gt;&gt; containing the construct objects.
	 * @param instanceNumber  An Integer containing the POJO class instance list number.
	 * @return A Boolean representing the key value is expected pattern, unique, length, and values.
	 * @throws SDKException              if a problem occurs.
	 * @throws ClassNotFoundException
	 * @throws SecurityException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public boolean valueChecker(String className, String memberName, JSONObject keyDetails, Object value, HashMap<String, ArrayList<Object>> uniqueValuesMap, Integer instanceNumber) throws SDKException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		JSONObject detailsJO = new JSONObject();
		String name = keyDetails.getString(Constants.NAME);
		String type = keyDetails.getString(Constants.TYPE);
		String varType = null;
		Boolean check = true;
		if (value != null)
		{
			if (keyDetails.has(Constants.INTERFACE) && keyDetails.getBoolean(Constants.INTERFACE))
			{
				JSONObject interfaceDetail = Initializer.jsonDetails.getJSONObject(keyDetails.getString(Constants.STRUCTURE_NAME));
				JSONArray classes = interfaceDetail.getJSONArray(Constants.CLASSES);
				check = false;
				for (Object eachClass : classes)
				{
					if (value.getClass().getCanonicalName().equalsIgnoreCase(eachClass.toString()))
					{
						check = true;
						break;
					}
				}
			}
			else
			{
				varType = value.getClass().getCanonicalName();
				check = varType.equalsIgnoreCase(type);
				if (!check)
				{
					if (value instanceof TimeZone && type.equalsIgnoreCase(Constants.TIME_ZONE))
					{
						check = Boolean.TRUE;
					}
				}
			}
		}
		if (value instanceof List)
		{
			Boolean expectedListType = true;
			if (keyDetails.has(Constants.STRUCTURE_NAME))
			{
				String structureName = keyDetails.getString(Constants.STRUCTURE_NAME);
				int index = 0;
				List<?> listValue = (List<?>) value;
				for (Object data : listValue)
				{
					className = data.getClass().getCanonicalName();
					if (!className.equalsIgnoreCase(structureName))
					{
						instanceNumber = index;
						type = Constants.LIST_NAMESPACE + "(" + structureName + ")";
						varType = Constants.LIST_NAMESPACE + "(" + className + ")";
						expectedListType = false;
						check = false;
						break;
					}
					index++;
				}
			}
			if (expectedListType)
			{
				check = varType.equalsIgnoreCase(type) ? true : varType.equalsIgnoreCase(Constants.ARRAYLIST_NAMESPACE);
			}
		}
		else if (value instanceof Map)
		{
			check = varType.equalsIgnoreCase(type) ? true : varType.equalsIgnoreCase(Constants.HASHMAP_NAMESPACE);
		}
		if (!check && !type.equalsIgnoreCase(Constants.OBJECT_NAMESPACE))
		{
			detailsJO.put(Constants.FIELD, memberName);
			detailsJO.put(Constants.CLASS, className);
			detailsJO.put(Constants.INDEX, instanceNumber);
			detailsJO.put(Constants.EXPECTED_TYPE, type);
			detailsJO.put(Constants.GIVEN_TYPE, varType);
			throw new SDKException(Constants.TYPE_ERROR, detailsJO);
		}
		if (keyDetails.has(Constants.VALUES) && (!keyDetails.has(Constants.PICKLIST) || (keyDetails.getBoolean(Constants.PICKLIST) && Initializer.getInitializer().getSDKConfig().getPickListValidation())))
		{
			JSONArray valuesJA = keyDetails.getJSONArray(Constants.VALUES);
			List<String> pickListValue = IntStream.range(0, valuesJA.length()).mapToObj(valuesJA::get).map(Object::toString).collect(Collectors.toList());
			checkChoiceValue(memberName, className, instanceNumber, valuesJA, value, detailsJO, pickListValue);
		}
		if (keyDetails.has(Constants.UNIQUE))
		{
			ArrayList<Object> valuesArray = uniqueValuesMap.get(name);
			if (valuesArray != null && valuesArray.contains(value))
			{
				detailsJO.put(Constants.FIELD, memberName);
				detailsJO.put(Constants.CLASS, className);
				detailsJO.put(Constants.FIRST_INDEX, valuesArray.indexOf(value));
				detailsJO.put(Constants.NEXT_INDEX, instanceNumber);
				throw new SDKException(Constants.UNIQUE_KEY_ERROR, detailsJO);
			}
			else
			{
				if (valuesArray == null)
				{
					valuesArray = new ArrayList<Object>();
				}
				valuesArray.add(value);
				uniqueValuesMap.put(name, valuesArray);
			}
		}

		if (keyDetails.has(Constants.MIN_LENGTH) || keyDetails.has(Constants.MAX_LENGTH))
		{
			int count = value.toString().length();
			if (value instanceof List<?>)
			{
				count = ((List<?>) value).size();
			}
			if (keyDetails.has(Constants.MAX_LENGTH) && (count > keyDetails.getInt(Constants.MAX_LENGTH)))
			{
				detailsJO.put(Constants.FIELD, memberName);
				detailsJO.put(Constants.CLASS, className);
				detailsJO.put(Constants.GIVEN_LENGTH, count);
				detailsJO.put(Constants.MAXIMUM_LENGTH, keyDetails.getInt(Constants.MAX_LENGTH));
				throw new SDKException(Constants.MAXIMUM_LENGTH_ERROR, detailsJO);
			}
			if (keyDetails.has(Constants.MIN_LENGTH) && (count < keyDetails.getInt(Constants.MIN_LENGTH)))
			{
				detailsJO.put(Constants.FIELD, memberName);
				detailsJO.put(Constants.CLASS, className);
				detailsJO.put(Constants.GIVEN_LENGTH, count);
				detailsJO.put(Constants.MINIMUM_LENGTH, keyDetails.getInt(Constants.MIN_LENGTH));
				throw new SDKException(Constants.MINIMUM_LENGTH_ERROR, detailsJO);
			}
		}
		return true;
	}
	
	public void checkChoiceValue(String className, JSONObject keyDetails, Object value) throws JSONException, SDKException
	{
		String name = keyDetails.optString(Constants.NAME);
		if (keyDetails.has(Constants.VALUES) && name != null && Initializer.getInitializer().getSDKConfig().getPickListValidation())
		{
			JSONArray valuesJA = keyDetails.getJSONArray(Constants.VALUES);
			List<String> pickListValue = IntStream.range(0, valuesJA.length()).mapToObj(valuesJA::get).map(Object::toString).collect(Collectors.toList());
			checkChoiceValue(name, className, 0, valuesJA, value, new JSONObject(), pickListValue);
		}
	}

	private void checkChoiceValue(String memberName, String className, Integer instanceNumber, JSONArray valuesJA, Object value, JSONObject detailsJO, List<String> pickListValue) throws SDKException
	{
		if (value instanceof List)
		{
			@SuppressWarnings("unchecked")
			List<Object> value_1 = (List<Object>) value;
			for (Object value_2 : value_1)
			{
				if (value_2 instanceof Choice)
				{
					Choice<?> choice = (Choice<?>) value_2;
					value_2 = choice.getValue();
				}
				if (!pickListValue.contains(value_2.toString()))
				{
					detailsJO.put(Constants.FIELD, memberName);
					detailsJO.put(Constants.CLASS, className);
					detailsJO.put(Constants.INDEX, instanceNumber);
					detailsJO.put(Constants.GIVEN_VALUE, value);
					detailsJO.put(Constants.ACCEPTED_VALUES, valuesJA);
					throw new SDKException(Constants.UNACCEPTED_VALUES_ERROR, detailsJO);
				}
			}
		}
		else
		{
			if (value instanceof Choice)
			{
				Choice<?> choice = (Choice<?>) value;
				value = choice.getValue();
			}
			if (!pickListValue.contains(value.toString()))
			{
				detailsJO.put(Constants.FIELD, memberName);
				detailsJO.put(Constants.CLASS, className);
				detailsJO.put(Constants.INDEX, instanceNumber);
				detailsJO.put(Constants.GIVEN_VALUE, value);
				detailsJO.put(Constants.ACCEPTED_VALUES, valuesJA);
				throw new SDKException(Constants.UNACCEPTED_VALUES_ERROR, detailsJO);
			}
		}
	}
	/**
	 * This method to get the module field JSON details file path.
	 * 
	 * @return A String representing the module field JSON details file path.
	 * @throws UnsupportedEncodingException if a problem occurs.
	 * @throws SDKException
	 */
	public String getEncodedFileName() throws UnsupportedEncodingException, SDKException
	{
		Initializer initializer = Initializer.getInitializer();
		Token token = initializer.getToken();
		String accessToken = "";
		String refreshToken = "";
		String tokenKey = "";
		if (token instanceof OAuthToken)
		{
			OAuthToken oauthToken = (OAuthToken) token;
			if(oauthToken.getUserSignature() != null)
			{
				tokenKey = oauthToken.getUserSignature().getName();
			}
			else
			{
				refreshToken = oauthToken.getRefreshToken();
				if (refreshToken != null && refreshToken.length() > 0)
				{
					tokenKey = refreshToken.substring(refreshToken.length() - 32);
				}
				else
				{
					accessToken = oauthToken.getAccessToken();
					if (accessToken != null && accessToken.length() > 0)
					{
						tokenKey = accessToken.substring(accessToken.length() - 32);
					}
				}	
			}
		}
		String fileName = initializer.getEnvironment().getUrl();
		if (tokenKey != null && tokenKey.length() > 0)
		{
			fileName = fileName + tokenKey;
		}
		byte[] input = fileName.getBytes("UTF-8");
		String str = Base64.getEncoder().encodeToString(input);
		return str + ".json";
	}
}
