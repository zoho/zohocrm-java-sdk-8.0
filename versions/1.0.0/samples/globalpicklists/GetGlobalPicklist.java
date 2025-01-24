package samples.globalpicklists;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.globalpicklists.APIException;
import com.zoho.crm.api.globalpicklists.GlobalPicklistsOperations;
import com.zoho.crm.api.globalpicklists.PickListValues;
import com.zoho.crm.api.globalpicklists.Picklist;
import com.zoho.crm.api.globalpicklists.GlobalPicklistsOperations.GetGlobalPicklistParam;
import com.zoho.crm.api.globalpicklists.ResponseHandler;
import com.zoho.crm.api.globalpicklists.ResponseWrapper;
import com.zoho.crm.api.users.MinifiedUser;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetGlobalPicklist
{
	public static void getGlobalPicklist(Long id) throws Exception
	{
		GlobalPicklistsOperations sendMailsOperations = new GlobalPicklistsOperations();
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(GetGlobalPicklistParam.INCLUDE, null);
		paramInstance.add(GetGlobalPicklistParam.INCLUDE_INNER_DETAILS, "used_in_modules.plural_label");
		APIResponse<ResponseHandler> response = sendMailsOperations.getGlobalPicklist(id, paramInstance);
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
					ResponseWrapper responseWrapper = (ResponseWrapper) responseHandler;
					List<Picklist> globalPicklists = responseWrapper.getGlobalPicklists();
					for (Picklist globalPicklist : globalPicklists)
					{
						System.out.println("GlobalPicklists DisplayLabel: " + globalPicklist.getDisplayLabel());
						System.out.println("GlobalPicklists ModifiedTime: " + globalPicklist.getModifiedTime());
						System.out.println("GlobalPicklists APIName: " + globalPicklist.getAPIName());
						MinifiedUser modifiedBy = globalPicklist.getModifiedBy();
						if(modifiedBy != null)
						{
							System.out.println("GlobalPicklists ModifiedBy Name: " + modifiedBy.getName());
							System.out.println("GlobalPicklists ModifiedBy Id: " + modifiedBy.getId());
						}
						System.out.println("GlobalPicklists Description: " + globalPicklist.getDescription());
						System.out.println("GlobalPicklists PickListValuesSortedLexically: " + globalPicklist.getPickListValuesSortedLexically());
						System.out.println("GlobalPicklists Id: " + globalPicklist.getId());
						System.out.println("GlobalPicklists Presence: " + globalPicklist.getPresence());
						MinifiedUser createdBy = globalPicklist.getCreatedBy();
						if(createdBy != null)
						{
							System.out.println("GlobalPicklists CreatedBy Name: " + createdBy.getName());
							System.out.println("GlobalPicklists CreatedBy Id: " + createdBy.getId());
						}
						System.out.println("GlobalPicklists ActualLabel: " + globalPicklist.getActualLabel());
						List<PickListValues> pickListValues = globalPicklist.getPickListValues();
						if(pickListValues != null)
						{
							for(PickListValues pickListValue : pickListValues)
							{
								System.out.println("GlobalPicklists PickListValues DisplayValue: " + pickListValue.getDisplayValue());
								System.out.println("GlobalPicklists PickListValues SequenceNumber: " + pickListValue.getSequenceNumber());
								System.out.println("GlobalPicklists PickListValues ActualValue: " + pickListValue.getActualValue());
								System.out.println("GlobalPicklists PickListValues Id: " + pickListValue.getId());
								System.out.println("GlobalPicklists PickListValues Type: " + pickListValue.getType().getValue());
							}
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
			else if (response.getStatusCode() != 204)
			{
				Model responseObject = response.getModel();
				Class<? extends Model> clas = responseObject.getClass();
				Field[] fields = clas.getDeclaredFields();
				for (Field field : fields)
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
			Long id = 347706118437003l;
			getGlobalPicklist(id);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
