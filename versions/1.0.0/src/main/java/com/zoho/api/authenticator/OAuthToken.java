package com.zoho.api.authenticator;

import java.io.IOException;
import java.lang.reflect.Field;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.SSLContext;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.zoho.api.authenticator.store.TokenStore;
import com.zoho.api.logger.SDKLogger;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.SDKConfig;
import com.zoho.crm.api.UserSignature;
import com.zoho.crm.api.dc.DataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIHTTPConnector;
import com.zoho.crm.api.util.Constants;
import com.zoho.crm.api.util.Utility;

/**
 * This class maintains the tokens and authenticates every request.
 */
public class OAuthToken implements Token
{
	private static final Logger LOGGER = Logger.getLogger(SDKLogger.class.getName());

	private String clientID;
	private String clientSecret;
	private String redirectURL;
	private String grantToken;
	private String refreshToken;
	private String accessToken;
	private String expiresIn;
	private UserSignature userSignature;
	private String id;
	private String apiDomain;
	private boolean findUser;

	public OAuthToken()
	{

	}

	private OAuthToken(String clientID, String clientSecret, String grantToken, String refreshToken, String redirectURL, String id, String accessToken, UserSignature userSignature, boolean findUser)
	{
		this.clientID = clientID;
		this.clientSecret = clientSecret;
		this.grantToken = grantToken;
		this.refreshToken = refreshToken;
		this.redirectURL = redirectURL;
		this.accessToken = accessToken;
		this.id = id;
		this.userSignature = userSignature;
		this.findUser = findUser;
	}

	/**
	 * This is a getter method to get OAuth client id.
	 * 
	 * @return A String representing the OAuth client id.
	 */
	public String getClientId()
	{
		return clientID;
	}

	/**
	 * This is a getter method to get OAuth client secret.
	 * 
	 * @return A String representing the OAuth client secret.
	 */
	public String getClientSecret()
	{
		return clientSecret;
	}

	/**
	 * This is a getter method to get OAuth redirect URL.
	 * 
	 * @return A String representing the OAuth redirect URL.
	 */
	public String getRedirectURL()
	{
		return redirectURL;
	}

	/**
	 * This is a getter method to get grant token.
	 * 
	 * @return A String representing the grant token.
	 */
	public String getGrantToken()
	{
		return grantToken;
	}

	/**
	 * This is a getter method to get refresh token.
	 * 
	 * @return A String representing the refresh token.
	 */
	public String getRefreshToken()
	{
		return refreshToken;
	}

	/**
	 * This is a setter method to set refresh token.
	 * 
	 * @param refreshToken A String containing the refresh token.
	 */
	public void setRefreshToken(String refreshToken)
	{
		this.refreshToken = refreshToken;
	}

	/**
	 * This is a setter method to set redirect URL.
	 * 
	 * @param redirectURL A String containing the redirect URL.
	 */
	public void setRedirectURL(String redirectURL)
	{
		this.redirectURL = redirectURL;
	}

	/**
	 * This is a getter method to get OAuth client id.
	 *
	 */
	public void setClientId(String clientID)
	{
		this.clientID = clientID;
	}

	/**
	 * This is a getter method to get OAuth client secret.
	 *
	 */
	public void setClientSecret(String clientSecret)
	{
		this.clientSecret = clientSecret;
	}

	/**
	 * This is a setter method to set grant token.
	 * 
	 * @param grantToken A String containing the grant token.
	 */
	public void setGrantToken(String grantToken)
	{
		this.grantToken = grantToken;
	}

	/**
	 * This is a getter method to get access token.
	 * 
	 * @return A String representing the access token.
	 */
	public String getAccessToken()
	{
		return accessToken;
	}

	/**
	 * This is a setter method to set access token.
	 * 
	 * @param accessToken A String containing the access token.
	 */
	public void setAccessToken(String accessToken)
	{
		this.accessToken = accessToken;
	}

	/**
	 * This is a getter method to get token expire time.
	 * 
	 * @return A String representing the token expire time.
	 */
	public String getExpiresIn()
	{
		return expiresIn;
	}

	/**
	 * This is a setter method to set token expire time.
	 * 
	 * @param expiresIn A String containing the token expire time.
	 */
	public void setExpiresIn(String expiresIn)
	{
		this.expiresIn = expiresIn;
	}

	public UserSignature getUserSignature()
	{
		return userSignature;
	}

	public void setUserSignature(UserSignature userSignature)
	{
		this.userSignature = userSignature;
	}

	public String getAPIDomain()
	{
		return apiDomain;
	}

	public void setAPIDomain(String apiDomain)
	{
		this.apiDomain = apiDomain;
	}

	/**
	 * @return the id
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id)
	{
		this.id = id;
	}

	@Override
	public void generateToken() throws SDKException
	{
		getToken();
	}

	public String getToken() throws SDKException
	{
		Initializer initializer = Initializer.getInitializer();
		TokenStore store = initializer.getStore();

		OAuthToken oauthToken = null;
		if (this.getId() != null)
		{
			oauthToken = (OAuthToken) store.findTokenById(this.getId());
			mergeObjects(this, oauthToken);
			oauthToken.findUser = this.findUser;
		}
		else
		{
			oauthToken = (OAuthToken) store.findToken(this);
		}
		if (oauthToken == null)
		{
			if (this.getUserSignature() != null)
			{
				checkTokenDetails();
			}
			oauthToken = this;
		}
		if (oauthToken.getAPIDomain() == null || oauthToken.getAPIDomain().length() <= 0)
		{
			if (initializer.getEnvironment() == null)
			{
				throw new SDKException(Constants.ENVIRONMENT_ERROR_1, Constants.ENVIRONMENT_ERROR_MESSAGE.concat(" : "));
			}
			oauthToken.setAPIDomain(initializer.getEnvironment().getUrl());
		}
		Environment environment = DataCenter.get(oauthToken.getAPIDomain());
		if (environment != null)
		{
			Class<?> cl = initializer.getClass();
			Field member;
			try
			{
				member = cl.getDeclaredField(Constants.ENVIRONMENT);
				member.setAccessible(true);
				member.set(initializer, environment);
			}
			catch (Exception e)
			{
				throw new SDKException(Constants.ENVIRONMENT_ERROR_RESPONSE.concat(" : "), e);
			}
		}
		else
		{
			if (initializer.getEnvironment() == null)
			{
				throw new SDKException(Constants.ENVIRONMENT_ERROR_1, Constants.ENVIRONMENT_ERROR_MESSAGE.concat(" : "));
			}
		}
		String url = initializer.getEnvironment().getAccountsUrl();
		boolean save = false;
		if (oauthToken.getAccessToken() == null || oauthToken.getAccessToken().length() == 0)
		{
			if (oauthToken.getRefreshToken() != null && oauthToken.getRefreshToken().length() > 0)
			{
				LOGGER.log(Level.INFO, Constants.ACCESS_TOKEN_USING_REFRESH_TOKEN_MESSAGE);
				oauthToken.refreshAccessToken(oauthToken, url);
			}
			else
			{
				LOGGER.log(Level.INFO, Constants.ACCESS_TOKEN_USING_GRANT_TOKEN_MESSAGE);
				oauthToken.generateAccessToken(oauthToken, url);
			}
			save = true;
		}
		else if (oauthToken.getExpiresIn() != null && oauthToken.getExpiresIn().length() > 0 && (Long.valueOf(oauthToken.getExpiresIn()) - System.currentTimeMillis()) < 5000)// access token will expire in next 5 seconds or less
		{
			LOGGER.log(Level.INFO, Constants.REFRESH_TOKEN_MESSAGE);
			oauthToken.refreshAccessToken(oauthToken, url);
			save = true;
		}
		else if (oauthToken.getExpiresIn() == null && oauthToken.getAccessToken() != null && oauthToken.getId() == null)
		{
			save = true;
		}
		if (save)
		{
			try
			{
				if (oauthToken.getUserSignature() == null && oauthToken.findUser)
				{
					try
					{
						String userName = new Utility().getUserName(oauthToken.getAccessToken());
						if (userName != null)
						{
							oauthToken.setUserSignature(new UserSignature(userName));
						}
					}
					catch (SDKException ex)
					{
						LOGGER.log(Level.SEVERE, Constants.API_EXCEPTION, ex);
					}
				}
				store.saveToken(oauthToken);
			}
			catch (Exception ex)
			{
				throw new SDKException(Constants.SAVE_TOKEN_ERROR, ex);
			}
		}
		return oauthToken.getAccessToken();
	}

	private Boolean checkTokenDetails() throws SDKException
	{
		if (areAllObjectsNull(this.grantToken, this.refreshToken))
		{
			throw new SDKException(Constants.MANDATORY_VALUE_ERROR, Constants.GET_TOKEN_BY_USER_NAME_ERROR.concat(" - ").concat(String.join(", ", Constants.OAUTH_MANDATORY_KEYS2)));
		}
		return true;
	}

	@Override
	public synchronized void authenticate(APIHTTPConnector urlConnection) throws SDKException
	{
		if (!urlConnection.getHeaders().containsKey(Constants.AUTHORIZATION))
		{
			urlConnection.addHeader(Constants.AUTHORIZATION, Constants.OAUTH_HEADER_PREFIX.concat(getToken()));
		}
	}

	private String getResponseFromServer(HashMap<String, String> requestParams, String url) throws SDKException
	{
		try
		{
			final String USER_AGENT = Constants.USER_AGENT;
			HttpClient client = getHttpClient();
			HttpPost post = new HttpPost(url);
			post.setHeader(Constants.USER_AGENT_KEY, USER_AGENT);
			List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
			/*
			 * Set request Parameters
			 */
			if (requestParams != null && requestParams.size() > 0)
			{
				for (String key : requestParams.keySet())
				{
					urlParameters.add(new BasicNameValuePair(key, requestParams.get(key)));
				}
			}
			post.setEntity(new UrlEncodedFormEntity(urlParameters));
			LOGGER.log(Level.INFO, this.toString(url));
			return EntityUtils.toString(client.execute(post).getEntity());
		}
		catch (NoSuchAlgorithmException | IOException ex)
		{
			throw new SDKException(ex);
		}
	}

	public String toString(String url)
	{
		StringBuilder requestStringBuilder = new StringBuilder();
		requestStringBuilder.append("POST - ");
		requestStringBuilder.append(Constants.URL).append(" = ").append(url.toString()).append(".");
		return requestStringBuilder.toString();
	}

	private CloseableHttpClient getHttpClient() throws NoSuchAlgorithmException
	{
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		SSLContext sslContext = SSLContext.getDefault();
		SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
		return httpClientBuilder.setSSLSocketFactory(sslConnectionSocketFactory).build();
	}

	private OAuthToken refreshAccessToken(OAuthToken oauthToken, String url) throws SDKException
	{
		HashMap<String, String> requestParams = new HashMap<String, String>();
		requestParams.put(Constants.CLIENT_ID, oauthToken.getClientId());
		requestParams.put(Constants.CLIENT_SECRET, oauthToken.getClientSecret());
		requestParams.put(Constants.GRANT_TYPE, Constants.REFRESH_TOKEN);
		requestParams.put(Constants.REFRESH_TOKEN, oauthToken.getRefreshToken());
		try
		{
			parseResponse(oauthToken, getResponseFromServer(requestParams, url));
		}
		catch (SDKException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw new SDKException(Constants.REFRESH_TOKEN_ERROR, ex);
		}
		return oauthToken;
	}

	private OAuthToken generateAccessToken(OAuthToken oauthToken, String url) throws SDKException
	{
		HashMap<String, String> requestParams = new HashMap<String, String>();
		requestParams.put(Constants.CLIENT_ID, oauthToken.getClientId());
		requestParams.put(Constants.CLIENT_SECRET, oauthToken.getClientSecret());
		if (oauthToken.getRedirectURL() != null)
		{
			requestParams.put(Constants.REDIRECT_URI, oauthToken.getRedirectURL());
		}
		requestParams.put(Constants.GRANT_TYPE, Constants.GRANT_TYPE_AUTH_CODE);
		requestParams.put(Constants.CODE, oauthToken.getGrantToken());
		try
		{
			parseResponse(oauthToken, getResponseFromServer(requestParams, url));
		}
		catch (SDKException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw new SDKException(Constants.ACCESS_TOKEN_ERROR, ex);
		}
		return oauthToken;
	}

	private Boolean revokeRefreshToken(String refreshToken, String url) throws SDKException
	{
		HashMap<String, String> requestParams = new HashMap<String, String>();
		requestParams.put(Constants.TOKEN, refreshToken);
		String response = "";
		try
		{
			response = getResponseFromServer(requestParams, url);
			JSONObject responseJSON = new JSONObject(response);
			if (responseJSON != null && responseJSON.has(Constants.STATUS) && responseJSON.getString(Constants.STATUS).equals(Constants.SUCCESS))
			{
				return Boolean.TRUE;
			}
			return Boolean.FALSE;
		}
		catch (JSONException ex)
		{
			throw new SDKException(Constants.PARSE_RESPONSE.concat(" : ").concat(response), ex);
		}
		catch (SDKException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw new SDKException(Constants.REVOKE_TOKEN_ERROR, ex);
		}
	}

	private void parseResponse(OAuthToken oauthToken, String response) throws Exception
	{
		try
		{
			Initializer initializer = Initializer.getInitializer();
			SDKConfig sdkConfig = initializer.getSDKConfig();
			JSONObject responseJSON = new JSONObject(response);
			if (!responseJSON.has(Constants.ACCESS_TOKEN))
			{
				throw new SDKException(Constants.INVALID_TOKEN_ERROR, responseJSON.has(Constants.ERROR_KEY) ? responseJSON.getString(Constants.ERROR_KEY) : Constants.NO_ACCESS_TOKEN_ERROR);
			}
			oauthToken.setAccessToken(responseJSON.getString(Constants.ACCESS_TOKEN));
			oauthToken.setExpiresIn(String.valueOf(this.getTokenExpiresIn(responseJSON)));
			if (responseJSON.has(Constants.REFRESH_TOKEN))
			{
				oauthToken.setRefreshToken(responseJSON.getString(Constants.REFRESH_TOKEN));
			}
			if (sdkConfig.applyAPIDomainUpdate() && responseJSON.has(Constants.API_DOMAIN))
			{
				oauthToken.setAPIDomain(responseJSON.getString(Constants.API_DOMAIN));
			}
		}
		catch (JSONException ex)
		{
			throw new SDKException(Constants.PARSE_RESPONSE.concat(" : ").concat(response), ex);
		}
	}

	private Long getTokenExpiresIn(JSONObject response)
	{
		return System.currentTimeMillis() + (response.has(Constants.EXPIRES_IN_SEC) ? response.getLong(Constants.EXPIRES_IN) : response.getInt(Constants.EXPIRES_IN) * 1000);
	}

	@Override
	public void remove() throws SDKException
	{
		try
		{
			if (Initializer.getInitializer() == null)
			{
				throw new SDKException(Constants.SDK_UNINITIALIZATION_ERROR, Constants.SDK_UNINITIALIZATION_MESSAGE);
			}

			Initializer.getInitializer().getStore().deleteToken(this.getId());
		}
		catch (SDKException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw new SDKException(ex);
		}
	}

	/**
	 * To revoke the user refresh token information
	 */
	@Override
	public Boolean revoke(String id) throws SDKException
	{
		try
		{
			if (Initializer.getInitializer() == null)
			{
				throw new SDKException(Constants.SDK_UNINITIALIZATION_ERROR, Constants.SDK_UNINITIALIZATION_MESSAGE);
			}
			Initializer initializer = Initializer.getInitializer();
			TokenStore store = initializer.getStore();
			String url = initializer.getEnvironment().getAccountsUrl();
			Boolean isRevoke = Boolean.FALSE;
			OAuthToken oauthToken = new OAuthToken();
			oauthToken.setId(id);
			store.findToken(oauthToken);
			if (oauthToken != null && oauthToken.getRefreshToken() != null)
			{
				isRevoke = this.revokeRefreshToken(oauthToken.getRefreshToken(), url.concat(Constants.REVOKE_URL));
				LOGGER.log(Level.INFO, new StringBuffer().append(Constants.ID).append(" : ").append(id).append(Constants.REFRESH_TOKEN_REMOVED).toString());
			}
			else
			{
				LOGGER.log(Level.WARNING, new StringBuffer().append(Constants.ID).append(" : ").append(id).append(Constants.TOKEN_NOT_FOUND).toString());
			}
			return isRevoke;
		}
		catch (SDKException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw new SDKException(ex);
		}
	}

	public <T> void mergeObjects(T first, T second) throws SDKException
	{
		try
		{
			Class<?> clas = first.getClass();
			Field[] fields = clas.getDeclaredFields();
			for (Field field : fields)
			{
				if (Constants.OAUTH_TOKEN_FIELDS.contains(field.getName()))
				{
					field.setAccessible(true);
					Object value1 = field.get(first);
					Object value2 = field.get(second);
					Object value = (value1 != null) ? value1 : value2;
					field.set(first, value);
				}
			}
		}
		catch (Exception ex)
		{
			throw new SDKException(Constants.MERGE_OBJECT, ex);
		}
	}

	public static boolean areAllObjectsNull(Object... objects)
	{
		for (Object o : objects)
		{
			if (o != null)
			{
				return false;
			}
		}
		return true;
	}

	public static class Builder
	{
		private String clientID;
		private String clientSecret;
		private String redirectURL;
		private String refreshToken;
		private String grantToken;
		private String accessToken;
		private String id;
		private UserSignature userSignature;
		private boolean findUser = true;

		public Builder id(String id)
		{
			this.id = id;
			return this;
		}

		public Builder clientID(String clientID) throws SDKException
		{
			Utility.assertNotNull(clientID, Constants.TOKEN_ERROR, Constants.CLIENT_ID_NULL_ERROR_MESSAGE);
			this.clientID = clientID;
			return this;
		}

		public Builder clientSecret(String clientSecret) throws SDKException
		{
			Utility.assertNotNull(clientSecret, Constants.TOKEN_ERROR, Constants.CLIENT_SECRET_NULL_ERROR_MESSAGE);
			this.clientSecret = clientSecret;
			return this;
		}

		public Builder redirectURL(String redirectURL)
		{
			this.redirectURL = redirectURL;
			return this;
		}

		public Builder refreshToken(String refreshToken)
		{
			this.refreshToken = refreshToken;
			return this;
		}

		public Builder grantToken(String grantToken)
		{
			this.grantToken = grantToken;
			return this;
		}

		public Builder accessToken(String accessToken)
		{
			this.accessToken = accessToken;
			return this;
		}

		public Builder userSignature(UserSignature userSignature)
		{
			this.userSignature = userSignature;
			return this;
		}

		public Builder findUser(boolean findUser)
		{
			this.findUser = findUser;
			return this;
		}

		public OAuthToken build() throws SDKException
		{
			if (areAllObjectsNull(this.grantToken, this.refreshToken, this.id, this.accessToken, this.userSignature))
			{
				throw new SDKException(Constants.MANDATORY_VALUE_ERROR, Constants.MANDATORY_KEY_ERROR.concat(" - ").concat(String.join(", ", Constants.OAUTH_MANDATORY_KEYS)));
			}
			if (!areAllObjectsNull(this.grantToken, this.refreshToken))
			{
				if (areAllObjectsNull(this.clientID, this.clientSecret))
				{
					throw new SDKException(Constants.MANDATORY_VALUE_ERROR, Constants.MANDATORY_KEY_ERROR.concat(" - ").concat(String.join(", ", Constants.OAUTH_MANDATORY_KEYS1)));
				}
				else
				{
					Utility.assertNotNull(this.clientID, Constants.MANDATORY_VALUE_ERROR, Constants.MANDATORY_KEY_ERROR.concat(" - ").concat(Constants.CLIENT_ID));
					Utility.assertNotNull(this.clientSecret, Constants.MANDATORY_VALUE_ERROR, Constants.MANDATORY_KEY_ERROR.concat(" - ").concat(Constants.CLIENT_SECRET));
				}
			}
			return new OAuthToken(this.clientID, this.clientSecret, this.grantToken, this.refreshToken, this.redirectURL, this.id, this.accessToken, this.userSignature, this.findUser);
		}
	}
}
