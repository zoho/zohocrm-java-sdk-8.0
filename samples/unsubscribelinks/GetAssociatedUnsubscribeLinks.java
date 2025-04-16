package samples.unsubscribelinks;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.unsubscribelinks.APIException;
import com.zoho.crm.api.unsubscribelinks.AssociatedPlaces;
import com.zoho.crm.api.unsubscribelinks.AssociationDetails;
import com.zoho.crm.api.unsubscribelinks.AssociationsResponseHandler;
import com.zoho.crm.api.unsubscribelinks.AssociationsResponseWrapper;
import com.zoho.crm.api.unsubscribelinks.Detail;
import com.zoho.crm.api.unsubscribelinks.Resource;
import com.zoho.crm.api.unsubscribelinks.UnsubscribeLinksOperations;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetAssociatedUnsubscribeLinks
{
	public static void getAssociatedUnsubscribeLinks() throws Exception
	{
		UnsubscribeLinksOperations unsubscribeLinksOperations = new UnsubscribeLinksOperations();
		APIResponse<AssociationsResponseHandler> response = unsubscribeLinksOperations.getAssociatedUnsubscribeLinks();
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
					List<AssociationDetails> associations = responseWrapper.getAssociations();
					if (associations != null)
					{
						for (AssociationDetails association : associations)
						{
							System.out.println("AssociationDetails Id: " + association.getId());
							List<AssociatedPlaces> associatedPlaces = association.getAssociatedPlaces();
							if(associatedPlaces != null)
							{
								for(AssociatedPlaces associatedPlace : associatedPlaces)
								{
									System.out.println("AssociationDetails AssociatedPlaces Type: " + associatedPlace.getType());
									Resource resource = associatedPlace.getResource();
									if (resource != null)
									{
										System.out.println("AssociationDetails AssociatedPlaces Resource Name: " + resource.getName());
										System.out.println("AssociationDetails AssociatedPlaces Resource Id: " + resource.getId());
									}
									Detail details = associatedPlace.getDetails();
									if (details != null)
									{
										com.zoho.crm.api.unsubscribelinks.Module module = details.getModule();
										if (module != null)
										{
											System.out.println("AssociationDetails AssociatedPlaces Detail Module Name: " + module.getAPIName());
											System.out.println("AssociationDetails AssociatedPlaces Detail Module Id: " + module.getId());
										}
									}
								}
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
			getAssociatedUnsubscribeLinks();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
