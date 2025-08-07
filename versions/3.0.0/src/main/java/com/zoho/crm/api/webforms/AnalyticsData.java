package com.zoho.crm.api.webforms;

import com.zoho.crm.api.util.Model;
import java.time.OffsetDateTime;
import java.util.HashMap;

public class AnalyticsData implements Model
{
	private String iframeUrlTrackingCode;

	private Boolean urlAnalyticsEnabled;

	private Boolean analyticsEnabled;

	private OffsetDateTime analyticsEnabledTime;

	private String trackingCode;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of iframeUrlTrackingCode
	 * @return A String representing the iframeUrlTrackingCode
	 */
	public String getIframeUrlTrackingCode()
	{
		return  this.iframeUrlTrackingCode;

	}

	/**
	 * The method to set the value to iframeUrlTrackingCode
	 * @param iframeUrlTrackingCode A String representing the iframeUrlTrackingCode
	 */
	public void setIframeUrlTrackingCode(String iframeUrlTrackingCode)
	{
		 this.iframeUrlTrackingCode = iframeUrlTrackingCode;

		 this.keyModified.put("iframe_url_tracking_code", 1);

	}

	/**
	 * The method to get the value of urlAnalyticsEnabled
	 * @return A Boolean representing the urlAnalyticsEnabled
	 */
	public Boolean getUrlAnalyticsEnabled()
	{
		return  this.urlAnalyticsEnabled;

	}

	/**
	 * The method to set the value to urlAnalyticsEnabled
	 * @param urlAnalyticsEnabled A Boolean representing the urlAnalyticsEnabled
	 */
	public void setUrlAnalyticsEnabled(Boolean urlAnalyticsEnabled)
	{
		 this.urlAnalyticsEnabled = urlAnalyticsEnabled;

		 this.keyModified.put("url_analytics_enabled", 1);

	}

	/**
	 * The method to get the value of analyticsEnabled
	 * @return A Boolean representing the analyticsEnabled
	 */
	public Boolean getAnalyticsEnabled()
	{
		return  this.analyticsEnabled;

	}

	/**
	 * The method to set the value to analyticsEnabled
	 * @param analyticsEnabled A Boolean representing the analyticsEnabled
	 */
	public void setAnalyticsEnabled(Boolean analyticsEnabled)
	{
		 this.analyticsEnabled = analyticsEnabled;

		 this.keyModified.put("analytics_enabled", 1);

	}

	/**
	 * The method to get the value of analyticsEnabledTime
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getAnalyticsEnabledTime()
	{
		return  this.analyticsEnabledTime;

	}

	/**
	 * The method to set the value to analyticsEnabledTime
	 * @param analyticsEnabledTime An instance of OffsetDateTime
	 */
	public void setAnalyticsEnabledTime(OffsetDateTime analyticsEnabledTime)
	{
		 this.analyticsEnabledTime = analyticsEnabledTime;

		 this.keyModified.put("analytics_enabled_time", 1);

	}

	/**
	 * The method to get the value of trackingCode
	 * @return A String representing the trackingCode
	 */
	public String getTrackingCode()
	{
		return  this.trackingCode;

	}

	/**
	 * The method to set the value to trackingCode
	 * @param trackingCode A String representing the trackingCode
	 */
	public void setTrackingCode(String trackingCode)
	{
		 this.trackingCode = trackingCode;

		 this.keyModified.put("tracking_code", 1);

	}

	/**
	 * The method to check if the user has modified the given key
	 * @param key A String representing the key
	 * @return An Integer representing the modification
	 */
	public Integer isKeyModified(String key)
	{
		if((( this.keyModified.containsKey(key))))
		{
			return  this.keyModified.get(key);

		}
		return null;

	}

	/**
	 * The method to mark the given key as modified
	 * @param key A String representing the key
	 * @param modification An Integer representing the modification
	 */
	public void setKeyModified(String key, Integer modification)
	{
		 this.keyModified.put(key, modification);

	}
}