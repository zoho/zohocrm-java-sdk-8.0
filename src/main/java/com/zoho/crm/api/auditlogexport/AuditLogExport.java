package com.zoho.crm.api.auditlogexport;

import com.zoho.crm.api.util.Model;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;

public class AuditLogExport implements Model
{
	private Criteria criteria;

	private Long id;

	private String status;

	private User createdBy;

	private List<String> downloadLinks;

	private OffsetDateTime jobStartTime;

	private OffsetDateTime jobEndTime;

	private OffsetDateTime expiryDate;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of criteria
	 * @return An instance of Criteria
	 */
	public Criteria getCriteria()
	{
		return  this.criteria;

	}

	/**
	 * The method to set the value to criteria
	 * @param criteria An instance of Criteria
	 */
	public void setCriteria(Criteria criteria)
	{
		 this.criteria = criteria;

		 this.keyModified.put("criteria", 1);

	}

	/**
	 * The method to get the value of id
	 * @return A Long representing the id
	 */
	public Long getId()
	{
		return  this.id;

	}

	/**
	 * The method to set the value to id
	 * @param id A Long representing the id
	 */
	public void setId(Long id)
	{
		 this.id = id;

		 this.keyModified.put("id", 1);

	}

	/**
	 * The method to get the value of status
	 * @return A String representing the status
	 */
	public String getStatus()
	{
		return  this.status;

	}

	/**
	 * The method to set the value to status
	 * @param status A String representing the status
	 */
	public void setStatus(String status)
	{
		 this.status = status;

		 this.keyModified.put("status", 1);

	}

	/**
	 * The method to get the value of createdBy
	 * @return An instance of User
	 */
	public User getCreatedBy()
	{
		return  this.createdBy;

	}

	/**
	 * The method to set the value to createdBy
	 * @param createdBy An instance of User
	 */
	public void setCreatedBy(User createdBy)
	{
		 this.createdBy = createdBy;

		 this.keyModified.put("created_by", 1);

	}

	/**
	 * The method to get the value of downloadLinks
	 * @return An instance of List<String>
	 */
	public List<String> getDownloadLinks()
	{
		return  this.downloadLinks;

	}

	/**
	 * The method to set the value to downloadLinks
	 * @param downloadLinks An instance of List<String>
	 */
	public void setDownloadLinks(List<String> downloadLinks)
	{
		 this.downloadLinks = downloadLinks;

		 this.keyModified.put("download_links", 1);

	}

	/**
	 * The method to get the value of jobStartTime
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getJobStartTime()
	{
		return  this.jobStartTime;

	}

	/**
	 * The method to set the value to jobStartTime
	 * @param jobStartTime An instance of OffsetDateTime
	 */
	public void setJobStartTime(OffsetDateTime jobStartTime)
	{
		 this.jobStartTime = jobStartTime;

		 this.keyModified.put("job_start_time", 1);

	}

	/**
	 * The method to get the value of jobEndTime
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getJobEndTime()
	{
		return  this.jobEndTime;

	}

	/**
	 * The method to set the value to jobEndTime
	 * @param jobEndTime An instance of OffsetDateTime
	 */
	public void setJobEndTime(OffsetDateTime jobEndTime)
	{
		 this.jobEndTime = jobEndTime;

		 this.keyModified.put("job_end_time", 1);

	}

	/**
	 * The method to get the value of expiryDate
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getExpiryDate()
	{
		return  this.expiryDate;

	}

	/**
	 * The method to set the value to expiryDate
	 * @param expiryDate An instance of OffsetDateTime
	 */
	public void setExpiryDate(OffsetDateTime expiryDate)
	{
		 this.expiryDate = expiryDate;

		 this.keyModified.put("expiry_date", 1);

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