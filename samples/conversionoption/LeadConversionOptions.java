package samples.conversionoption;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.conversionoption.APIException;
import com.zoho.crm.api.conversionoption.ConversionOptionOperations;
import com.zoho.crm.api.conversionoption.ConversionOptions;
import com.zoho.crm.api.conversionoption.Field;
import com.zoho.crm.api.conversionoption.PreferenceFieldMatch;
import com.zoho.crm.api.conversionoption.PreferenceFieldMatchedValue;
import com.zoho.crm.api.conversionoption.ResponseHandler;
import com.zoho.crm.api.conversionoption.ResponseWrapper;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeadConversionOptions
{
	@SuppressWarnings("unchecked")
	public static void leadConversionOptions(Long recordId) throws Exception
	{
		ConversionOptionOperations conversionOptionOperations = new ConversionOptionOperations(recordId);
		APIResponse<ResponseHandler> response = conversionOptionOperations.leadConversionOptions();
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (Arrays.asList(204, 304).contains(response.getStatusCode()))
			{
				System.out.println(response.getStatusCode() == 204 ? "No Content" : "Not Modified");
				return;
			}
			if (response.isExpected())
			{
				ResponseHandler responseHandler = response.getObject();
				if (responseHandler instanceof ResponseWrapper)
				{
					ResponseWrapper conversionOptionResponseWrapper = (ResponseWrapper) responseHandler;
					ConversionOptions conversionOption = conversionOptionResponseWrapper.getConversionOptions();
					com.zoho.crm.api.modules.Modules module = conversionOption.getModulePreference();
					if (module != null)
					{
						System.out.println("ConversionOptions ModulePreference API-Name: " + module.getAPIName());
						System.out.println("ConversionOptions ModulePreference ID: " + module.getId());
					}
					List<com.zoho.crm.api.record.Record> contacts = conversionOption.getContacts();
					if (contacts != null)
					{
						for (com.zoho.crm.api.record.Record contact : contacts)
						{
							System.out.println("Record ID: " + contact.getId());
							System.out.println("Record KeyValues: ");
							for (Map.Entry<String, Object> entry : contact.getKeyValues().entrySet())
							{
								String keyName = entry.getKey();
								Object value = entry.getValue();
								if (value instanceof List)
								{
									System.out.println("Record KeyName : " + keyName);
									List<?> dataList = (List<?>) value;
									for (Object data : dataList)
									{
										if (data instanceof Map)
										{
											System.out.println("Record KeyName : " + keyName + " - Value : ");
											for (Map.Entry<String, Object> mapValue : ((HashMap<String, Object>) data).entrySet())
											{
												System.out.println(mapValue.getKey() + " : " + mapValue.getValue());
											}
										}
										else
										{
											System.out.println(data);
										}
									}
								}
								else if (value instanceof Map)
								{
									System.out.println("Record KeyName : " + keyName + " - Value : ");
									for (Map.Entry<String, Object> mapValue : ((HashMap<String, Object>) value).entrySet())
									{
										System.out.println(mapValue.getKey() + " : " + mapValue.getValue());
									}
								}
								else
								{
									System.out.println("Record KeyName : " + keyName + " - Value : " + value);
								}
							}
						}
					}
					PreferenceFieldMatchedValue preferenceFieldMatchedValue = conversionOption.getPreferenceFieldMatchedValue();
					if (preferenceFieldMatchedValue != null)
					{
						List<PreferenceFieldMatch> contactsPreferenceField = preferenceFieldMatchedValue.getContacts();
						if (contactsPreferenceField != null)
						{
							for (PreferenceFieldMatch contact : contactsPreferenceField)
							{
								System.out.println("Contacts field MatchedLeadValue: " + contact.getMatchedLeadValue());
								System.out.println("Contacts field: ");
								Field field = contact.getField();
								if(field != null)
								{
									System.out.println("Contacts field Id: " + field.getId());
									System.out.println("Contacts field APIName: " + field.getAPIName());
								}
							}
						}
						List<PreferenceFieldMatch> accountsPreferenceField = preferenceFieldMatchedValue.getAccounts();
						if (accountsPreferenceField != null)
						{
							for (PreferenceFieldMatch account : accountsPreferenceField)
							{
								System.out.println("Accounts field MatchedLeadValue: " + account.getMatchedLeadValue());
								System.out.println("Accounts field: ");
								Field field = account.getField();
								if(field != null)
								{
									System.out.println("Accounts field Id: " + field.getId());
									System.out.println("Accounts field APIName: " + field.getAPIName());
								}
							}
						}
						List<PreferenceFieldMatch> dealsPreferenceField = preferenceFieldMatchedValue.getDeals();
						if (dealsPreferenceField != null)
						{
							for (PreferenceFieldMatch deals : dealsPreferenceField)
							{
								System.out.println("Deals field MatchedLeadValue: " + deals.getMatchedLeadValue());
								System.out.println("Deals field: ");
								Field field = deals.getField();
								if(field != null)
								{
									System.out.println("Deals field Id: " + field.getId());
									System.out.println("Deals field APIName: " + field.getAPIName());
								}
							}
						}
					}
					List<com.zoho.crm.api.record.Record> accoutns = conversionOption.getAccounts();
					if (accoutns != null)
					{
						for (com.zoho.crm.api.record.Record account : accoutns)
						{
							System.out.println("Record ID: " + account.getId());
							System.out.println("Record KeyValues: ");
							for (Map.Entry<String, Object> entry : account.getKeyValues().entrySet())
							{
								String keyName = entry.getKey();
								Object value = entry.getValue();
								if (value instanceof List)
								{
									System.out.println("Record KeyName : " + keyName);
									List<?> dataList = (List<?>) value;
									for (Object data : dataList)
									{
										if (data instanceof Map)
										{
											System.out.println("Record KeyName : " + keyName + " - Value : ");
											for (Map.Entry<String, Object> mapValue : ((HashMap<String, Object>) data).entrySet())
											{
												System.out.println(mapValue.getKey() + " : " + mapValue.getValue());
											}
										}
										else
										{
											System.out.println(data);
										}
									}
								}
								else if (value instanceof Map)
								{
									System.out.println("Record KeyName : " + keyName + " - Value : ");
									for (Map.Entry<String, Object> mapValue : ((HashMap<String, Object>) value).entrySet())
									{
										System.out.println(mapValue.getKey() + " : " + mapValue.getValue());
									}
								}
								else
								{
									System.out.println("Record KeyName : " + keyName + " - Value : " + value);
								}
							}
						}
					}
					List<com.zoho.crm.api.record.Record> deals = conversionOption.getDeals();
					if (deals != null)
					{
						for (com.zoho.crm.api.record.Record deal : deals)
						{
							System.out.println("Record ID: " + deal.getId());
							System.out.println("Record KeyValues: ");
							for (Map.Entry<String, Object> entry : deal.getKeyValues().entrySet())
							{
								String keyName = entry.getKey();
								Object value = entry.getValue();
								if (value instanceof List)
								{
									System.out.println("Record KeyName : " + keyName);
									List<?> dataList = (List<?>) value;
									for (Object data : dataList)
									{
										if (data instanceof Map)
										{
											System.out.println("Record KeyName : " + keyName + " - Value : ");
											for (Map.Entry<String, Object> mapValue : ((HashMap<String, Object>) data).entrySet())
											{
												System.out.println(mapValue.getKey() + " : " + mapValue.getValue());
											}
										}
										else
										{
											System.out.println(data);
										}
									}
								}
								else if (value instanceof Map)
								{
									System.out.println("Record KeyName : " + keyName + " - Value : ");
									for (Map.Entry<String, Object> mapValue : ((HashMap<String, Object>) value).entrySet())
									{
										System.out.println(mapValue.getKey() + " : " + mapValue.getValue());
									}
								}
								else
								{
									System.out.println("Record KeyName : " + keyName + " - Value : " + value);
								}
							}
						}
					}
					List<com.zoho.crm.api.modules.Modules> modulesWithMultipleLayouts = conversionOption.getModulesWithMultipleLayouts();
					if (modulesWithMultipleLayouts != null)
					{
						for (com.zoho.crm.api.modules.Modules module_1 : modulesWithMultipleLayouts)
						{
							System.out.println("ConversionOptions ModulesWithMultipleLayouts API-Name: " + module_1.getAPIName());
							System.out.println("ConversionOptions ModulesWithMultipleLayouts ID: " + module_1.getId());
						}
					}
				}
				else if (responseHandler instanceof APIException)
				{
					APIException exception = (APIException) responseHandler;
					System.out.println("Status: " + exception.getStatus().getValue());
					System.out.println("Code: " + exception.getCode().getValue());
					System.out.println("Details: ");
					for (Map.Entry<String, Object> entry : exception.getDetails().entrySet())
					{
						System.out.println(entry.getKey() + ": " + entry.getValue());
					}
					System.out.println("Message: " + exception.getMessage());
				}
			}
			else
			{
				Model responseObject = response.getModel();
				Class<? extends Model> clas = responseObject.getClass();
				java.lang.reflect.Field[] fields = clas.getDeclaredFields();
				for (java.lang.reflect.Field field : fields)
				{
					field.setAccessible(true);
					System.out.println(field.getName() + ":" + field.get(responseObject));
				}
			}
		}
	}

	public static void main(String[] args)
	{
		try
		{
			Environment environment = USDataCenter.PRODUCTION;
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").redirectURL("Redirect_URL").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			Long recordId = 347706120797057l;
			leadConversionOptions(recordId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
