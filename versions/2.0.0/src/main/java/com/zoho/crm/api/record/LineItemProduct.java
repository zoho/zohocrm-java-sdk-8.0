package com.zoho.crm.api.record;

import com.zoho.crm.api.tags.Tag;
import com.zoho.crm.api.users.MinifiedUser;
import com.zoho.crm.api.util.Model;
import java.time.OffsetDateTime;
import java.util.List;

public class LineItemProduct extends Record implements Model
{

	/**
	 * The method to get the value of productCode
	 * @return A String representing the productCode
	 */
	public String getProductCode()
	{
		return (String) this.getKeyValue("Product_Code");

	}

	/**
	 * The method to set the value to productCode
	 * @param productCode A String representing the productCode
	 */
	public void setProductCode(String productCode)
	{
		 this.addKeyValue("Product_Code", productCode);

	}

	/**
	 * The method to get the value of currency
	 * @return A String representing the currency
	 */
	public String getCurrency()
	{
		return (String) this.getKeyValue("Currency");

	}

	/**
	 * The method to set the value to currency
	 * @param currency A String representing the currency
	 */
	public void setCurrency(String currency)
	{
		 this.addKeyValue("Currency", currency);

	}

	/**
	 * The method to get the value of name
	 * @return A String representing the name
	 */
	public String getName()
	{
		return (String) this.getKeyValue("name");

	}

	/**
	 * The method to set the value to name
	 * @param name A String representing the name
	 */
	public void setName(String name)
	{
		 this.addKeyValue("name", name);

	}

	/**
	 * The method to get the value of id
	 * @return A Long representing the id
	 */
	public Long getId()
	{
		return (Long) this.getKeyValue("id");

	}

	/**
	 * The method to set the value to id
	 * @param id A Long representing the id
	 */
	public void setId(Long id)
	{
		 this.addKeyValue("id", id);

	}

	/**
	 * The method to get the value of createdBy
	 * @return An instance of MinifiedUser
	 */
	public MinifiedUser getCreatedBy()
	{
		return (MinifiedUser) this.getKeyValue("Created_By");

	}

	/**
	 * The method to set the value to createdBy
	 * @param createdBy An instance of MinifiedUser
	 */
	public void setCreatedBy(MinifiedUser createdBy)
	{
		 this.addKeyValue("Created_By", createdBy);

	}

	/**
	 * The method to get the value of createdTime
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getCreatedTime()
	{
		return (OffsetDateTime) this.getKeyValue("Created_Time");

	}

	/**
	 * The method to set the value to createdTime
	 * @param createdTime An instance of OffsetDateTime
	 */
	public void setCreatedTime(OffsetDateTime createdTime)
	{
		 this.addKeyValue("Created_Time", createdTime);

	}

	/**
	 * The method to get the value of modifiedBy
	 * @return An instance of MinifiedUser
	 */
	public MinifiedUser getModifiedBy()
	{
		return (MinifiedUser) this.getKeyValue("Modified_By");

	}

	/**
	 * The method to set the value to modifiedBy
	 * @param modifiedBy An instance of MinifiedUser
	 */
	public void setModifiedBy(MinifiedUser modifiedBy)
	{
		 this.addKeyValue("Modified_By", modifiedBy);

	}

	/**
	 * The method to get the value of modifiedTime
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getModifiedTime()
	{
		return (OffsetDateTime) this.getKeyValue("Modified_Time");

	}

	/**
	 * The method to set the value to modifiedTime
	 * @param modifiedTime An instance of OffsetDateTime
	 */
	public void setModifiedTime(OffsetDateTime modifiedTime)
	{
		 this.addKeyValue("Modified_Time", modifiedTime);

	}

	/**
	 * The method to get the value of tag
	 * @return An instance of List<Tag>
	 */
	public List<Tag> getTag()
	{
		return (List<Tag>) this.getKeyValue("Tag");

	}

	/**
	 * The method to set the value to tag
	 * @param tag An instance of List<Tag>
	 */
	public void setTag(List<Tag> tag)
	{
		 this.addKeyValue("Tag", tag);

	}
}