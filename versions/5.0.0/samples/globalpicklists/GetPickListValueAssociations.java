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
import com.zoho.crm.api.globalpicklists.PickListValuesAssociation;
import com.zoho.crm.api.globalpicklists.PickListValuesAssociationsResponseHandler;
import com.zoho.crm.api.globalpicklists.PickListValuesAssociationsResponseWrapper;
import com.zoho.crm.api.globalpicklists.Resource;
import com.zoho.crm.api.globalpicklists.GlobalPicklistsOperations.GetPickListValueAssociationsParam;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetPickListValueAssociations
{
	public static void getPickListValueAssociations(Long id) throws Exception
	{
		GlobalPicklistsOperations sendMailsOperations = new GlobalPicklistsOperations();
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(GetPickListValueAssociationsParam.PICKLIST_VALUE_ID, 347755026l);
		APIResponse<PickListValuesAssociationsResponseHandler> response = sendMailsOperations.getPickListValueAssociations(id, paramInstance);
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
				PickListValuesAssociationsResponseHandler responseHandler = response.getObject();
				if (responseHandler instanceof PickListValuesAssociationsResponseWrapper)
				{
					PickListValuesAssociationsResponseWrapper responseWrapper = (PickListValuesAssociationsResponseWrapper) responseHandler;
					List<PickListValuesAssociation> pickListValuesAssociations = responseWrapper.getPickListValuesAssociations();
					for (PickListValuesAssociation pickListValuesAssociation : pickListValuesAssociations)
					{
						System.out.println("GlobalPicklists PickListValuesAssociation Type: " + pickListValuesAssociation.getType());
						List<Resource> resources = pickListValuesAssociation.getResources();
						if(resources != null)
						{
							for(Resource resource : resources)
							{
								System.out.println("GlobalPicklists Resource Name: " + resource.getName());
								System.out.println("GlobalPicklists Resource Id: " + resource.getId());
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
			Long id = 3477003l;
			getPickListValueAssociations(id);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
