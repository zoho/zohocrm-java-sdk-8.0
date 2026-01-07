package samples.relatedlist;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.relatedlists.APIException;
import com.zoho.crm.api.relatedlists.RelatedListsOperations;
import com.zoho.crm.api.relatedlists.ResponseHandler;
import com.zoho.crm.api.relatedlists.ResponseWrapper;
import com.zoho.crm.api.relatedlists.RelatedListsOperations.GetRelatedListsParam;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetRelatedList
{
	public static void getRelatedList(String moduleAPIName, Long relatedListId, long layoutId) throws Exception
	{
		RelatedListsOperations relatedListsOperations = new RelatedListsOperations(layoutId);
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(GetRelatedListsParam.MODULE, moduleAPIName);
		APIResponse<ResponseHandler> response = relatedListsOperations.getRelatedList(relatedListId, paramInstance);
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
					List<com.zoho.crm.api.relatedlists.RelatedList> relatedLists = responseWrapper.getRelatedLists();
					for (com.zoho.crm.api.relatedlists.RelatedList relatedList : relatedLists)
					{
						System.out.println("RelatedList SequenceNumber: " + relatedList.getSequenceNumber());
						System.out.println("RelatedList DisplayLabel: " + relatedList.getDisplayLabel());
						System.out.println("RelatedList APIName: " + relatedList.getAPIName());
						System.out.println("RelatedList Module: " + relatedList.getModule());
						System.out.println("RelatedList Name: " + relatedList.getName());
						System.out.println("RelatedList Action: " + relatedList.getAction());
						System.out.println("RelatedList ID: " + relatedList.getId());
						System.out.println("RelatedList Href: " + relatedList.getHref());
						System.out.println("RelatedList Type: " + relatedList.getType());
						System.out.println("RelatedList Connectedmodule: " + relatedList.getConnectedmodule());
						System.out.println("RelatedList Linkingmodule: " + relatedList.getLinkingmodule());
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
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			String moduleAPIName = "Leads";
			Long relatedListId = 5255085067912l;
			Long layoutId = 323131431l;
			getRelatedList(moduleAPIName, relatedListId, layoutId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
