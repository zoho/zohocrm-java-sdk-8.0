package com.zoho.crm.api.util;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;

import org.apache.hc.client5.http.auth.AuthScope;
import org.apache.hc.client5.http.auth.NTCredentials;
import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPatch;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.auth.BasicCredentialsProvider;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.client5.http.protocol.HttpClientContext;
import org.apache.hc.client5.http.ssl.NoopHostnameVerifier;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactoryBuilder;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpHeaders;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.net.URIBuilder;
import org.apache.hc.core5.util.Timeout;

import com.zoho.api.logger.SDKLogger;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.RequestProxy;

/**
 * This module is to make HTTP connections, trigger the requests and receive the response.
 */
public class APIHTTPConnector
{
	private String url;
	private String requestMethod;
	private HashMap<String, String> headers = new HashMap<String, String>();
	private HashMap<String, String> parameters = new HashMap<String, String>();
	private Object requestBody;
	private String contentType;
	private static final Logger LOGGER = Logger.getLogger(SDKLogger.class.getName());

	public String getContentType()
	{
		return contentType;
	}

	public void setContentType(String contentType)
	{
		this.contentType = contentType;
	}

	public void setURL(String url)
	{
		this.url = url;
	}

	public void setRequestMethod(String httpMethod)
	{
		this.requestMethod = httpMethod;
	}

	public HashMap<String, String> getHeaders()
	{
		return headers;
	}

	public void setHeaders(HashMap<String, String> headers)
	{
		this.headers = headers;
	}

	public void addHeader(String headerName, String headerValue)
	{
		this.headers.put(headerName, headerValue);
	}

	public HashMap<String, String> getParams()
	{
		return parameters;
	}

	public void setParams(HashMap<String, String> params)
	{
		this.parameters = params;
	}

	public void addParam(String paramName, String paramValue)
	{
		this.parameters.put(paramName, paramValue);
	}

	public void setRequestBody(Object requestBody)
	{
		this.requestBody = requestBody;
	}

	/**
	 * This method makes a Zoho CRM Rest API request.
	 * 
	 * @param converterInstance A Converter class instance to call appendToRequest method.
	 * @return HttpResponse class instance or null
	 * @throws Exception if a problem occurs.
	 */
	public ClassicHttpResponse fireRequest(Converter converterInstance) throws Exception
	{
		CloseableHttpClient httpclient = getHttpClient();
		URIBuilder uriBuilder = new URIBuilder(this.url);
		this.setQueryParams(uriBuilder);
		ClassicHttpRequest requestObj = getRequestObject(uriBuilder.build());
		if (this.contentType != null)
		{
			this.setContentTypeHeader();
		}
		if (this.requestBody != null && requestObj instanceof ClassicHttpRequest)
		{
			ClassicHttpRequest requestBase = (ClassicHttpRequest) requestObj;
			converterInstance.appendToRequest(requestBase, this.requestBody);
		}
		this.setQueryHeaders(requestObj);
		LOGGER.log(Level.INFO, this.toString(uriBuilder));
		return httpclient.executeOpen(null, requestObj, HttpClientContext.create());
	}

	private ClassicHttpRequest getRequestObject(URI urlPath) throws UnsupportedEncodingException
	{
		switch (this.requestMethod)
		{
			case "GET":
				return new HttpGet(urlPath);
			case "DELETE":
				return new HttpDelete(urlPath);
			case "POST":
				return new HttpPost(urlPath);
			case "PUT":
				return new HttpPut(urlPath);
			case "PATCH":
				return new HttpPatch(urlPath);
		}
		return null;
	}

	private CloseableHttpClient getHttpClient() throws NoSuchAlgorithmException
	{
		HttpClientBuilder httpClientBuilder = HttpClients.custom();
		RequestProxy requestProxy = Initializer.getInitializer().getRequestProxy();
		RequestConfig config = RequestConfig.custom()
				.setConnectTimeout(Timeout.ofMilliseconds(Initializer.getInitializer().getSDKConfig().getConnectionTimeout()))
				.setConnectionRequestTimeout(Timeout.ofMilliseconds(Initializer.getInitializer().getSDKConfig().getRequestTimeout()))
				.setResponseTimeout(Timeout.ofMilliseconds(Initializer.getInitializer().getSDKConfig().getSocketTimeout())).build();
		httpClientBuilder.setDefaultRequestConfig(config);
		if (requestProxy != null)
		{
			String proxyHost = requestProxy.getHost();
			Integer proxyPort = requestProxy.getPort();
			HttpHost proxy = new HttpHost(proxyHost, proxyPort);
			if (requestProxy.getUser() != null)
			{
				BasicCredentialsProvider credsProvider = new BasicCredentialsProvider();
				NTCredentials ntCredentials = new NTCredentials(requestProxy.getUser(), requestProxy.getPassword().toCharArray(), null, requestProxy.getUserDomain());
				credsProvider.setCredentials(new AuthScope(proxyHost, proxyPort), ntCredentials);
				httpClientBuilder.setDefaultCredentialsProvider(credsProvider);
			}
			httpClientBuilder.setProxy(proxy);
			LOGGER.log(Level.INFO, this.proxyLog(requestProxy));
		}
		SSLContext sslContext = SSLContext.getDefault();
		SSLConnectionSocketFactory sslSocketFactory = SSLConnectionSocketFactoryBuilder.create()
	            .setSslContext(sslContext)
	            .setHostnameVerifier(NoopHostnameVerifier.INSTANCE)
	            .build();
	    PoolingHttpClientConnectionManager cm = PoolingHttpClientConnectionManagerBuilder.create()
	            .setSSLSocketFactory(sslSocketFactory)
	            .build();
		return httpClientBuilder.setConnectionManager(cm).build();
	}

	private void setQueryHeaders(ClassicHttpRequest request)
	{
		HashMap<String, String> headersMap = this.headers;
		Iterator<String> headers = headersMap.keySet().iterator();
		while (headers.hasNext())
		{
			String header = (String) headers.next();
			request.addHeader(header, headersMap.get(header));
		}
	}

	private void setQueryParams(URIBuilder uriBuilder)
	{
		HashMap<String, String> paramsMap = this.parameters;
		Iterator<String> params = paramsMap.keySet().iterator();
		while (params.hasNext())
		{
			String param = (String) params.next();
			uriBuilder.addParameter(param, paramsMap.get(param));
		}
	}

	private void setContentTypeHeader()
	{
		for (String contentType : Constants.SET_CONTENT_TYPE_HEADER)
		{
			if (this.url.contains(contentType))
			{
				this.headers.put(HttpHeaders.CONTENT_TYPE, this.contentType);
				return;
			}
		}
	}

	public String toString(URIBuilder uriBuilder)
	{
		HashMap<String, String> reqHeaders = new HashMap<String, String>();
		reqHeaders.putAll(this.headers);
		reqHeaders.put(Constants.AUTHORIZATION, Constants.CANT_DISCLOSE);
		StringBuilder requestStringBuilder = new StringBuilder();
		requestStringBuilder.append(this.requestMethod).append(" - ");
		requestStringBuilder.append(Constants.URL).append(" = ").append(uriBuilder.toString()).append(" , ");
		requestStringBuilder.append(Constants.HEADERS).append(" = ").append(reqHeaders.toString()).append(" , ");
		requestStringBuilder.append(Constants.PARAMS).append(" = ").append(this.parameters.toString()).append(".");
		return requestStringBuilder.toString();
	}

	private String proxyLog(RequestProxy requestProxy)
	{
		StringBuilder proxyStringBuilder = new StringBuilder();
		proxyStringBuilder.append(Constants.PROXY_SETTINGS);
		proxyStringBuilder.append(Constants.PROXY_HOST).append(requestProxy.getHost()).append(" , ");
		proxyStringBuilder.append(Constants.PROXY_PORT).append(requestProxy.getPort().toString());
		if (requestProxy.getUser() != null)
		{
			proxyStringBuilder.append(" , ").append(Constants.PROXY_USER).append(requestProxy.getUser());
		}
		if (requestProxy.getUserDomain() != null)
		{
			proxyStringBuilder.append(" , ").append(Constants.PROXY_DOMAIN).append(requestProxy.getUserDomain());
		}
		return proxyStringBuilder.toString();
	}
}
