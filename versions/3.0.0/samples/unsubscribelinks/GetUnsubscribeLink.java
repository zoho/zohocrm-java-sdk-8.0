package samples.unsubscribelinks;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.unsubscribelinks.APIException;
import com.zoho.crm.api.unsubscribelinks.ResponseHandler;
import com.zoho.crm.api.unsubscribelinks.ResponseWrapper;
import com.zoho.crm.api.unsubscribelinks.UnsubscribeLinks;
import com.zoho.crm.api.unsubscribelinks.UnsubscribeLinksOperations;
import com.zoho.crm.api.unsubscribelinks.User;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class GetUnsubscribeLink
{
	public static void getUnsubscribeLink(Long id) throws Exception
	{
		UnsubscribeLinksOperations unsubscribeLinksOperations = new UnsubscribeLinksOperations();
		APIResponse<ResponseHandler> response = unsubscribeLinksOperations.getUnsubscribeLink(id);
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
					List<UnsubscribeLinks> unsubscribeLinks = responseWrapper.getUnsubscribeLinks();
					if (unsubscribeLinks != null)
					{
						for (UnsubscribeLinks unsubscribeLink : unsubscribeLinks)
						{
							System.out.println("UnsubscribeLinks Name: " + unsubscribeLink.getName());
							System.out.println("UnsubscribeLinks Id: " + unsubscribeLink.getId());
							System.out.println("UnsubscribeLinks PageType: " + unsubscribeLink.getPageType().getValue());
							System.out.println("UnsubscribeLinks CustomLocationUrl: " + unsubscribeLink.getCustomLocationUrl());
							System.out.println("UnsubscribeLinks StandardPageMessage: " + unsubscribeLink.getStandardPageMessage());
							System.out.println("UnsubscribeLinks SubmissionActionType: " + unsubscribeLink.getSubmissionActionType().getValue());
							System.out.println("UnsubscribeLinks SubmissionRedirectUrl: " + unsubscribeLink.getSubmissionRedirectUrl());
							System.out.println("UnsubscribeLinks SubmissionMessage: " + unsubscribeLink.getSubmissionMessage());
							System.out.println("UnsubscribeLinks CreatedTime: " + unsubscribeLink.getCreatedTime());
							User createdBy = unsubscribeLink.getCreatedBy();
							if (createdBy != null)
							{
								System.out.println("UnsubscribeLinks CreatedBy Name: " + createdBy.getName());
								System.out.println("UnsubscribeLinks CreatedBy Id: " + createdBy.getId());
							}
							System.out.println("UnsubscribeLinks ModifiedTime: " + unsubscribeLink.getModifiedTime());
							User modifiedBy = unsubscribeLink.getModifiedBy();
							if (modifiedBy != null)
							{
								System.out.println("UnsubscribeLinks ModifiedBy( Name: " + modifiedBy.getName());
								System.out.println("UnsubscribeLinks ModifiedBy( Id: " + modifiedBy.getId());
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
			Long id = 11111162001l;
			getUnsubscribeLink(id);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
