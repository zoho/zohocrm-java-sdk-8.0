package com.zoho.crm.api.reschedulehistory;

import com.zoho.crm.api.util.Model;
import java.time.OffsetDateTime;
import java.util.HashMap;

public class RescheduleHistory implements Model
{
	private String currencySymbol;

	private OffsetDateTime rescheduledTo;

	private Boolean reviewProcess;

	private String rescheduleReason;

	private String sharingPermission;

	private String name;

	private User modifiedBy;

	private Boolean review;

	private User rescheduledBy;

	private String state;

	private String canvasId;

	private Boolean processFlow;

	private Long id;

	private OffsetDateTime rescheduledTime;

	private Boolean ziaVisions;

	private Boolean approved;

	private OffsetDateTime modifiedTime;

	private Approval approval;

	private OffsetDateTime createdTime;

	private OffsetDateTime rescheduledFrom;

	private AppointmentName appointmentName;

	private Boolean editable;

	private Boolean orchestration;

	private Boolean inMerge;

	private User createdBy;

	private String approvalState;

	private String rescheduleNote;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of currencySymbol
	 * @return A String representing the currencySymbol
	 */
	public String getCurrencySymbol()
	{
		return  this.currencySymbol;

	}

	/**
	 * The method to set the value to currencySymbol
	 * @param currencySymbol A String representing the currencySymbol
	 */
	public void setCurrencySymbol(String currencySymbol)
	{
		 this.currencySymbol = currencySymbol;

		 this.keyModified.put("$currency_symbol", 1);

	}

	/**
	 * The method to get the value of rescheduledTo
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getRescheduledTo()
	{
		return  this.rescheduledTo;

	}

	/**
	 * The method to set the value to rescheduledTo
	 * @param rescheduledTo An instance of OffsetDateTime
	 */
	public void setRescheduledTo(OffsetDateTime rescheduledTo)
	{
		 this.rescheduledTo = rescheduledTo;

		 this.keyModified.put("Rescheduled_To", 1);

	}

	/**
	 * The method to get the value of reviewProcess
	 * @return A Boolean representing the reviewProcess
	 */
	public Boolean getReviewProcess()
	{
		return  this.reviewProcess;

	}

	/**
	 * The method to set the value to reviewProcess
	 * @param reviewProcess A Boolean representing the reviewProcess
	 */
	public void setReviewProcess(Boolean reviewProcess)
	{
		 this.reviewProcess = reviewProcess;

		 this.keyModified.put("$review_process", 1);

	}

	/**
	 * The method to get the value of rescheduleReason
	 * @return A String representing the rescheduleReason
	 */
	public String getRescheduleReason()
	{
		return  this.rescheduleReason;

	}

	/**
	 * The method to set the value to rescheduleReason
	 * @param rescheduleReason A String representing the rescheduleReason
	 */
	public void setRescheduleReason(String rescheduleReason)
	{
		 this.rescheduleReason = rescheduleReason;

		 this.keyModified.put("Reschedule_Reason", 1);

	}

	/**
	 * The method to get the value of sharingPermission
	 * @return A String representing the sharingPermission
	 */
	public String getSharingPermission()
	{
		return  this.sharingPermission;

	}

	/**
	 * The method to set the value to sharingPermission
	 * @param sharingPermission A String representing the sharingPermission
	 */
	public void setSharingPermission(String sharingPermission)
	{
		 this.sharingPermission = sharingPermission;

		 this.keyModified.put("$sharing_permission", 1);

	}

	/**
	 * The method to get the value of name
	 * @return A String representing the name
	 */
	public String getName()
	{
		return  this.name;

	}

	/**
	 * The method to set the value to name
	 * @param name A String representing the name
	 */
	public void setName(String name)
	{
		 this.name = name;

		 this.keyModified.put("Name", 1);

	}

	/**
	 * The method to get the value of modifiedBy
	 * @return An instance of User
	 */
	public User getModifiedBy()
	{
		return  this.modifiedBy;

	}

	/**
	 * The method to set the value to modifiedBy
	 * @param modifiedBy An instance of User
	 */
	public void setModifiedBy(User modifiedBy)
	{
		 this.modifiedBy = modifiedBy;

		 this.keyModified.put("Modified_By", 1);

	}

	/**
	 * The method to get the value of review
	 * @return A Boolean representing the review
	 */
	public Boolean getReview()
	{
		return  this.review;

	}

	/**
	 * The method to set the value to review
	 * @param review A Boolean representing the review
	 */
	public void setReview(Boolean review)
	{
		 this.review = review;

		 this.keyModified.put("$review", 1);

	}

	/**
	 * The method to get the value of rescheduledBy
	 * @return An instance of User
	 */
	public User getRescheduledBy()
	{
		return  this.rescheduledBy;

	}

	/**
	 * The method to set the value to rescheduledBy
	 * @param rescheduledBy An instance of User
	 */
	public void setRescheduledBy(User rescheduledBy)
	{
		 this.rescheduledBy = rescheduledBy;

		 this.keyModified.put("Rescheduled_By", 1);

	}

	/**
	 * The method to get the value of state
	 * @return A String representing the state
	 */
	public String getState()
	{
		return  this.state;

	}

	/**
	 * The method to set the value to state
	 * @param state A String representing the state
	 */
	public void setState(String state)
	{
		 this.state = state;

		 this.keyModified.put("$state", 1);

	}

	/**
	 * The method to get the value of canvasId
	 * @return A String representing the canvasId
	 */
	public String getCanvasId()
	{
		return  this.canvasId;

	}

	/**
	 * The method to set the value to canvasId
	 * @param canvasId A String representing the canvasId
	 */
	public void setCanvasId(String canvasId)
	{
		 this.canvasId = canvasId;

		 this.keyModified.put("$canvas_id", 1);

	}

	/**
	 * The method to get the value of processFlow
	 * @return A Boolean representing the processFlow
	 */
	public Boolean getProcessFlow()
	{
		return  this.processFlow;

	}

	/**
	 * The method to set the value to processFlow
	 * @param processFlow A Boolean representing the processFlow
	 */
	public void setProcessFlow(Boolean processFlow)
	{
		 this.processFlow = processFlow;

		 this.keyModified.put("$process_flow", 1);

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
	 * The method to get the value of rescheduledTime
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getRescheduledTime()
	{
		return  this.rescheduledTime;

	}

	/**
	 * The method to set the value to rescheduledTime
	 * @param rescheduledTime An instance of OffsetDateTime
	 */
	public void setRescheduledTime(OffsetDateTime rescheduledTime)
	{
		 this.rescheduledTime = rescheduledTime;

		 this.keyModified.put("Rescheduled_Time", 1);

	}

	/**
	 * The method to get the value of ziaVisions
	 * @return A Boolean representing the ziaVisions
	 */
	public Boolean getZiaVisions()
	{
		return  this.ziaVisions;

	}

	/**
	 * The method to set the value to ziaVisions
	 * @param ziaVisions A Boolean representing the ziaVisions
	 */
	public void setZiaVisions(Boolean ziaVisions)
	{
		 this.ziaVisions = ziaVisions;

		 this.keyModified.put("$zia_visions", 1);

	}

	/**
	 * The method to get the value of approved
	 * @return A Boolean representing the approved
	 */
	public Boolean getApproved()
	{
		return  this.approved;

	}

	/**
	 * The method to set the value to approved
	 * @param approved A Boolean representing the approved
	 */
	public void setApproved(Boolean approved)
	{
		 this.approved = approved;

		 this.keyModified.put("$approved", 1);

	}

	/**
	 * The method to get the value of modifiedTime
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getModifiedTime()
	{
		return  this.modifiedTime;

	}

	/**
	 * The method to set the value to modifiedTime
	 * @param modifiedTime An instance of OffsetDateTime
	 */
	public void setModifiedTime(OffsetDateTime modifiedTime)
	{
		 this.modifiedTime = modifiedTime;

		 this.keyModified.put("Modified_Time", 1);

	}

	/**
	 * The method to get the value of approval
	 * @return An instance of Approval
	 */
	public Approval getApproval()
	{
		return  this.approval;

	}

	/**
	 * The method to set the value to approval
	 * @param approval An instance of Approval
	 */
	public void setApproval(Approval approval)
	{
		 this.approval = approval;

		 this.keyModified.put("$approval", 1);

	}

	/**
	 * The method to get the value of createdTime
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getCreatedTime()
	{
		return  this.createdTime;

	}

	/**
	 * The method to set the value to createdTime
	 * @param createdTime An instance of OffsetDateTime
	 */
	public void setCreatedTime(OffsetDateTime createdTime)
	{
		 this.createdTime = createdTime;

		 this.keyModified.put("Created_Time", 1);

	}

	/**
	 * The method to get the value of rescheduledFrom
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getRescheduledFrom()
	{
		return  this.rescheduledFrom;

	}

	/**
	 * The method to set the value to rescheduledFrom
	 * @param rescheduledFrom An instance of OffsetDateTime
	 */
	public void setRescheduledFrom(OffsetDateTime rescheduledFrom)
	{
		 this.rescheduledFrom = rescheduledFrom;

		 this.keyModified.put("Rescheduled_From", 1);

	}

	/**
	 * The method to get the value of appointmentName
	 * @return An instance of AppointmentName
	 */
	public AppointmentName getAppointmentName()
	{
		return  this.appointmentName;

	}

	/**
	 * The method to set the value to appointmentName
	 * @param appointmentName An instance of AppointmentName
	 */
	public void setAppointmentName(AppointmentName appointmentName)
	{
		 this.appointmentName = appointmentName;

		 this.keyModified.put("Appointment_Name", 1);

	}

	/**
	 * The method to get the value of editable
	 * @return A Boolean representing the editable
	 */
	public Boolean getEditable()
	{
		return  this.editable;

	}

	/**
	 * The method to set the value to editable
	 * @param editable A Boolean representing the editable
	 */
	public void setEditable(Boolean editable)
	{
		 this.editable = editable;

		 this.keyModified.put("$editable", 1);

	}

	/**
	 * The method to get the value of orchestration
	 * @return A Boolean representing the orchestration
	 */
	public Boolean getOrchestration()
	{
		return  this.orchestration;

	}

	/**
	 * The method to set the value to orchestration
	 * @param orchestration A Boolean representing the orchestration
	 */
	public void setOrchestration(Boolean orchestration)
	{
		 this.orchestration = orchestration;

		 this.keyModified.put("$orchestration", 1);

	}

	/**
	 * The method to get the value of inMerge
	 * @return A Boolean representing the inMerge
	 */
	public Boolean getInMerge()
	{
		return  this.inMerge;

	}

	/**
	 * The method to set the value to inMerge
	 * @param inMerge A Boolean representing the inMerge
	 */
	public void setInMerge(Boolean inMerge)
	{
		 this.inMerge = inMerge;

		 this.keyModified.put("$in_merge", 1);

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

		 this.keyModified.put("Created_By", 1);

	}

	/**
	 * The method to get the value of approvalState
	 * @return A String representing the approvalState
	 */
	public String getApprovalState()
	{
		return  this.approvalState;

	}

	/**
	 * The method to set the value to approvalState
	 * @param approvalState A String representing the approvalState
	 */
	public void setApprovalState(String approvalState)
	{
		 this.approvalState = approvalState;

		 this.keyModified.put("$approval_state", 1);

	}

	/**
	 * The method to get the value of rescheduleNote
	 * @return A String representing the rescheduleNote
	 */
	public String getRescheduleNote()
	{
		return  this.rescheduleNote;

	}

	/**
	 * The method to set the value to rescheduleNote
	 * @param rescheduleNote A String representing the rescheduleNote
	 */
	public void setRescheduleNote(String rescheduleNote)
	{
		 this.rescheduleNote = rescheduleNote;

		 this.keyModified.put("Reschedule_Note", 1);

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