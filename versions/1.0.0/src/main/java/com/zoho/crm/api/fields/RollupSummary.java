package com.zoho.crm.api.fields;

import com.zoho.crm.api.modules.MinifiedModule;
import com.zoho.crm.api.relatedlists.RelatedList;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class RollupSummary implements Model
{
	private String returnType;

	private Expression expression;

	private MinifiedModule basedOnModule;

	private RelatedList relatedList;

	private String rollupBasedOn;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of returnType
	 * @return A String representing the returnType
	 */
	public String getReturnType()
	{
		return  this.returnType;

	}

	/**
	 * The method to set the value to returnType
	 * @param returnType A String representing the returnType
	 */
	public void setReturnType(String returnType)
	{
		 this.returnType = returnType;

		 this.keyModified.put("return_type", 1);

	}

	/**
	 * The method to get the value of expression
	 * @return An instance of Expression
	 */
	public Expression getExpression()
	{
		return  this.expression;

	}

	/**
	 * The method to set the value to expression
	 * @param expression An instance of Expression
	 */
	public void setExpression(Expression expression)
	{
		 this.expression = expression;

		 this.keyModified.put("expression", 1);

	}

	/**
	 * The method to get the value of basedOnModule
	 * @return An instance of MinifiedModule
	 */
	public MinifiedModule getBasedOnModule()
	{
		return  this.basedOnModule;

	}

	/**
	 * The method to set the value to basedOnModule
	 * @param basedOnModule An instance of MinifiedModule
	 */
	public void setBasedOnModule(MinifiedModule basedOnModule)
	{
		 this.basedOnModule = basedOnModule;

		 this.keyModified.put("based_on_module", 1);

	}

	/**
	 * The method to get the value of relatedList
	 * @return An instance of RelatedList
	 */
	public RelatedList getRelatedList()
	{
		return  this.relatedList;

	}

	/**
	 * The method to set the value to relatedList
	 * @param relatedList An instance of RelatedList
	 */
	public void setRelatedList(RelatedList relatedList)
	{
		 this.relatedList = relatedList;

		 this.keyModified.put("related_list", 1);

	}

	/**
	 * The method to get the value of rollupBasedOn
	 * @return A String representing the rollupBasedOn
	 */
	public String getRollupBasedOn()
	{
		return  this.rollupBasedOn;

	}

	/**
	 * The method to set the value to rollupBasedOn
	 * @param rollupBasedOn A String representing the rollupBasedOn
	 */
	public void setRollupBasedOn(String rollupBasedOn)
	{
		 this.rollupBasedOn = rollupBasedOn;

		 this.keyModified.put("rollup_based_on", 1);

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