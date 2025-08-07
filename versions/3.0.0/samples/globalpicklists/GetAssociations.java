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
import com.zoho.crm.api.globalpicklists.Association;
import com.zoho.crm.api.globalpicklists.GlobalPicklistsOperations;
import com.zoho.crm.api.globalpicklists.Layout;
import com.zoho.crm.api.globalpicklists.GlobalPicklistsOperations.GetAssociationsParam;
import com.zoho.crm.api.globalpicklists.AssociationsResponseHandler;
import com.zoho.crm.api.globalpicklists.AssociationsResponseWrapper;
import com.zoho.crm.api.globalpicklists.Info;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetAssociations
{
	public static void getAssociations(Long id) throws Exception
	{
		GlobalPicklistsOperations sendMailsOperations = new GlobalPicklistsOperations();
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(GetAssociationsParam.INCLUDE_INNER_DETAILS, "used_in_modules.plural_label");
		APIResponse<AssociationsResponseHandler> response = sendMailsOperations.getAssociations(id, paramInstance);
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
				AssociationsResponseHandler responseHandler = response.getObject();
				if (responseHandler instanceof AssociationsResponseWrapper)
				{
					AssociationsResponseWrapper responseWrapper = (AssociationsResponseWrapper) responseHandler;
					List<Association> associations = responseWrapper.getAssociations();
					for (Association association : associations)
					{
						com.zoho.crm.api.globalpicklists.Field field = association.getField();
						if (field != null)
						{
							System.out.println("GlobalPicklists Field APIName: " + field.getAPIName());
							System.out.println("GlobalPicklists Field Id: " + field.getId());
						}
						com.zoho.crm.api.globalpicklists.Module module = association.getModule();
						if (module != null)
						{
							System.out.println("GlobalPicklists Module APIName: " + module.getAPIName());
							System.out.println("GlobalPicklists Module Id: " + module.getId());
							System.out.println("GlobalPicklists Module PluralLabel: " + module.getPluralLabel());
						}
						List<Layout> layouts = association.getLayouts();
						if (layouts != null)
						{
							for (Layout layout : layouts)
							{
								System.out.println("GlobalPicklists Layout Name: " + layout.getName());
								System.out.println("GlobalPicklists Layout Id: " + layout.getId());
								System.out.println("GlobalPicklists Layout Status: " + layout.getStatus());
							}
						}
					}
					Info info = responseWrapper.getInfo();
					if (info != null)
					{
						if (info.getPerPage() != null)
						{
							System.out.println("Note Info PerPage: " + info.getPerPage().toString());
						}
						if (info.getCount() != null)
						{
							System.out.println("Note Info Count: " + info.getCount().toString());
						}
						if (info.getPage() != null)
						{
							System.out.println("Note Info Page: " + info.getPage());
						}
						if (info.getMoreRecords() != null)
						{
							System.out.println("Note Info MoreRecords: " + info.getMoreRecords().toString());
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
			getAssociations(id);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
