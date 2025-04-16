package samples.inventoryconvert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.inventoryconvert.APIException;
import com.zoho.crm.api.inventoryconvert.ActionHandler;
import com.zoho.crm.api.inventoryconvert.ActionResponse;
import com.zoho.crm.api.inventoryconvert.ActionWrapper;
import com.zoho.crm.api.inventoryconvert.BodyWrapper;
import com.zoho.crm.api.inventoryconvert.ConvertTo;
import com.zoho.crm.api.inventoryconvert.InventoryConvertOperations;
import com.zoho.crm.api.inventoryconvert.InventoryConverter;
import com.zoho.crm.api.inventoryconvert.SuccessResponse;
import com.zoho.crm.api.inventoryconvert.Module;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class ConvertInventory
{
	public static void convertInventory(Long id, String moduleAPIName) throws Exception
	{
		InventoryConvertOperations inventoryConvertOperations = new InventoryConvertOperations(id, moduleAPIName);
		BodyWrapper request = new BodyWrapper();
		List<InventoryConverter> data = new ArrayList<InventoryConverter>();
		InventoryConverter record1 = new InventoryConverter();
		List<ConvertTo> convertToList = new ArrayList<ConvertTo>();
		ConvertTo convertTo = new ConvertTo();
		Module module = new Module();
		module.setAPIName("Sales_Orders");
		module.setId(34770602221l);
		convertTo.setModule(module);
		convertToList.add(convertTo);
		record1.setConvertTo(convertToList);
		data.add(record1);
		request.setData(data);
		APIResponse<ActionHandler> response = inventoryConvertOperations.convertInventory(request);
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
							System.out.println("Message: " + successResponse.getMessage().getValue());
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
							System.out.println("Message: " + exception.getMessage().getValue());
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
					System.out.println("Message: " + exception.getMessage().getValue());
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
			Long id = 347706121168l;
			String moduleAPIName = "Quotes";
			convertInventory(id, moduleAPIName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
