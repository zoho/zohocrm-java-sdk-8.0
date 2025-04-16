package samples.changeowner;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.changeowner.APIException;
import com.zoho.crm.api.changeowner.ActionHandler;
import com.zoho.crm.api.changeowner.ActionResponse;
import com.zoho.crm.api.changeowner.ActionWrapper;
import com.zoho.crm.api.changeowner.BodyWrapper;
import com.zoho.crm.api.changeowner.ChangeOwnerOperations;
import com.zoho.crm.api.changeowner.Owner;
import com.zoho.crm.api.changeowner.RelatedModules;
import com.zoho.crm.api.changeowner.SuccessResponse;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class UpdateRecordOwner
{
	public static void updateRecordOwner(String moduleAPIName, Long recordId) throws Exception
	{
		ChangeOwnerOperations changeOwnerOperations = new ChangeOwnerOperations(moduleAPIName);
		BodyWrapper bodyWrapper = new BodyWrapper();
		Owner owner = new Owner();
		owner.setId(4402480254001l);
		bodyWrapper.setOwner(owner);
		bodyWrapper.setNotify(true);
		List<RelatedModules> relatedModules = new ArrayList<RelatedModules>();
		RelatedModules relatedModule = new RelatedModules();
		relatedModule.setId(347706114686005l);
		relatedModule.setAPIName("Tasks");
		relatedModules.add(relatedModule);
		relatedModule = new RelatedModules();
		relatedModule.setId(347706114686005l);
		relatedModule.setAPIName("Tasks");
		relatedModules.add(relatedModule);
		bodyWrapper.setRelatedModules(relatedModules);
		APIResponse<ActionHandler> response = changeOwnerOperations.singleUpdate(recordId, bodyWrapper);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ActionWrapper)
				{
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
					List<ActionResponse> actionResponses = actionWrapper.getData();
					for (ActionResponse actionResponse : actionResponses)
					{
						if (actionResponse instanceof SuccessResponse)
						{
							SuccessResponse successResponse = (SuccessResponse) actionResponse;
							System.out.println("Status: " + successResponse.getStatus().getValue());
							System.out.println("Code: " + successResponse.getCode().getValue());
							System.out.println("Details: ");
							for (Map.Entry<String, Object> entry : successResponse.getDetails().entrySet())
							{
								System.out.println(entry.getKey() + ": " + entry.getValue());
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
			else
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
			String moduleAPIName = "Leads";
			Long recordId = 44024801216009l;
			updateRecordOwner(moduleAPIName, recordId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
