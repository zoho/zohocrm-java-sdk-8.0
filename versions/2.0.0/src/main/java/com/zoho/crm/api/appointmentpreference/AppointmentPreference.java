package com.zoho.crm.api.appointmentpreference;

import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class AppointmentPreference implements Model
{
	private Boolean showJobSheet;

	private String whenDurationExceeds;

	private Choice<String> whenAppointmentCompleted;

	private Boolean allowBookingOutsideServiceAvailability;

	private Boolean allowBookingOutsideBusinesshours;

	private DealRecordConfiguration dealRecordConfiguration;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of showJobSheet
	 * @return A Boolean representing the showJobSheet
	 */
	public Boolean getShowJobSheet()
	{
		return  this.showJobSheet;

	}

	/**
	 * The method to set the value to showJobSheet
	 * @param showJobSheet A Boolean representing the showJobSheet
	 */
	public void setShowJobSheet(Boolean showJobSheet)
	{
		 this.showJobSheet = showJobSheet;

		 this.keyModified.put("show_job_sheet", 1);

	}

	/**
	 * The method to get the value of whenDurationExceeds
	 * @return A String representing the whenDurationExceeds
	 */
	public String getWhenDurationExceeds()
	{
		return  this.whenDurationExceeds;

	}

	/**
	 * The method to set the value to whenDurationExceeds
	 * @param whenDurationExceeds A String representing the whenDurationExceeds
	 */
	public void setWhenDurationExceeds(String whenDurationExceeds)
	{
		 this.whenDurationExceeds = whenDurationExceeds;

		 this.keyModified.put("when_duration_exceeds", 1);

	}

	/**
	 * The method to get the value of whenAppointmentCompleted
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getWhenAppointmentCompleted()
	{
		return  this.whenAppointmentCompleted;

	}

	/**
	 * The method to set the value to whenAppointmentCompleted
	 * @param whenAppointmentCompleted An instance of Choice<String>
	 */
	public void setWhenAppointmentCompleted(Choice<String> whenAppointmentCompleted)
	{
		 this.whenAppointmentCompleted = whenAppointmentCompleted;

		 this.keyModified.put("when_appointment_completed", 1);

	}

	/**
	 * The method to get the value of allowBookingOutsideServiceAvailability
	 * @return A Boolean representing the allowBookingOutsideServiceAvailability
	 */
	public Boolean getAllowBookingOutsideServiceAvailability()
	{
		return  this.allowBookingOutsideServiceAvailability;

	}

	/**
	 * The method to set the value to allowBookingOutsideServiceAvailability
	 * @param allowBookingOutsideServiceAvailability A Boolean representing the allowBookingOutsideServiceAvailability
	 */
	public void setAllowBookingOutsideServiceAvailability(Boolean allowBookingOutsideServiceAvailability)
	{
		 this.allowBookingOutsideServiceAvailability = allowBookingOutsideServiceAvailability;

		 this.keyModified.put("allow_booking_outside_service_availability", 1);

	}

	/**
	 * The method to get the value of allowBookingOutsideBusinesshours
	 * @return A Boolean representing the allowBookingOutsideBusinesshours
	 */
	public Boolean getAllowBookingOutsideBusinesshours()
	{
		return  this.allowBookingOutsideBusinesshours;

	}

	/**
	 * The method to set the value to allowBookingOutsideBusinesshours
	 * @param allowBookingOutsideBusinesshours A Boolean representing the allowBookingOutsideBusinesshours
	 */
	public void setAllowBookingOutsideBusinesshours(Boolean allowBookingOutsideBusinesshours)
	{
		 this.allowBookingOutsideBusinesshours = allowBookingOutsideBusinesshours;

		 this.keyModified.put("allow_booking_outside_businesshours", 1);

	}

	/**
	 * The method to get the value of dealRecordConfiguration
	 * @return An instance of DealRecordConfiguration
	 */
	public DealRecordConfiguration getDealRecordConfiguration()
	{
		return  this.dealRecordConfiguration;

	}

	/**
	 * The method to set the value to dealRecordConfiguration
	 * @param dealRecordConfiguration An instance of DealRecordConfiguration
	 */
	public void setDealRecordConfiguration(DealRecordConfiguration dealRecordConfiguration)
	{
		 this.dealRecordConfiguration = dealRecordConfiguration;

		 this.keyModified.put("deal_record_configuration", 1);

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