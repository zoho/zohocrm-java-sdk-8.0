package samples.digest;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.digest.APIException;
import com.zoho.crm.api.digest.ActionHandler;
import com.zoho.crm.api.digest.ActionResponse;
import com.zoho.crm.api.digest.ActionWrapper;
import com.zoho.crm.api.digest.BodyWrapper;
import com.zoho.crm.api.digest.Digest;
import com.zoho.crm.api.digest.DigestOperations;
import com.zoho.crm.api.digest.SuccessResponse;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CreateDigest
{
	public static void createDigest() throws SDKException
	{
		DigestOperations digestOperations = new DigestOperations();
		BodyWrapper request = new BodyWrapper();
		Digest digest = new Digest();
		digest.setRecordId(347706119827001l);
		digest.setModule("Leads");
		digest.setType("zsurvey_tracking");
		request.setDigest(new ArrayList<>(Arrays.asList(digest)));
		APIResponse<ActionHandler> response = digestOperations.createDigest(request);
		if (response != null)
		{
			System.out.println("Status code : " + response.getStatusCode());
			ActionHandler actionHandler = response.getObject();
			if (actionHandler instanceof ActionWrapper)
			{
				ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
				List<ActionResponse> actionResponses = actionWrapper.getDigest();
				for (ActionResponse actionResponse : actionResponses)
				{
					if (actionResponse instanceof SuccessResponse)
					{
						SuccessResponse successResponse = (SuccessResponse) actionResponse;
						System.out.println("Status: " + successResponse.getStatus().getValue());
						System.out.println("Code: " + successResponse.getCode().getValue());
						System.out.println("Details: ");
						if (successResponse.getDetails() != null)
						{
							for (Map.Entry<String, Object> entry : successResponse.getDetails().entrySet())
							{
								System.out.println(entry.getKey() + ": " + entry.getValue());
							}
						}
						System.out.println("Message: " + successResponse.getMessage());
					}
					else if (actionResponse instanceof APIException)
					{
						APIException exception = (APIException) actionResponse;
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
			}
			else if (actionHandler instanceof APIException)
			{
				APIException exception = (APIException) actionHandler;
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
	}

	public static void main(String[] args)
	{
		try
		{
			Environment environment = USDataCenter.PRODUCTION;
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").redirectURL("Redirect_URL").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			createDigest();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
