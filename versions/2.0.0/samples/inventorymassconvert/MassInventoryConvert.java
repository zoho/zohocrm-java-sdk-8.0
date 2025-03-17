package samples.inventorymassconvert;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.inventorymassconvert.APIException;
import com.zoho.crm.api.inventorymassconvert.ActionResponse;
import com.zoho.crm.api.inventorymassconvert.BodyWrapper;
import com.zoho.crm.api.inventorymassconvert.ConvertTo;
import com.zoho.crm.api.inventorymassconvert.InventoryMassConvertOperations;
import com.zoho.crm.api.inventorymassconvert.SuccessResponse;
import com.zoho.crm.api.inventorymassconvert.Module;
import com.zoho.crm.api.inventorymassconvert.User;
import com.zoho.crm.api.inventorymassconvert.RelatedModules;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class MassInventoryConvert
{
	public static void massInventoryConvert(String moduleAPIName) throws Exception
	{
		InventoryMassConvertOperations inventoryMassConvertOperations = new InventoryMassConvertOperations(moduleAPIName);
		BodyWrapper bodyWrapper = new BodyWrapper();
		
		List<ConvertTo> convertToList = new ArrayList<ConvertTo>();
		ConvertTo convertTo = new ConvertTo();
		Module module = new Module();
		module.setAPIName("Sales_Orders");
		module.setId(3477061221l);
		convertTo.setModule(module);
		convertTo.setCarryOverTags(false);
		convertToList.add(convertTo);
		bodyWrapper.setConvertTo(convertToList);
		
		User assignTo = new User();
		assignTo.setId(347703021l);
		bodyWrapper.setAssignTo(assignTo);
		
		List<RelatedModules> relatedModules = new ArrayList<RelatedModules>();
		
		RelatedModules relatedModule = new RelatedModules();
		relatedModule.setAPIName("Calls");
		relatedModule.setId(34770613015l);
		relatedModules.add(relatedModule);
		
		relatedModule = new RelatedModules();
		relatedModule.setAPIName("Tasks");
		relatedModule.setId(347706193l);
		relatedModules.add(relatedModule);
		
		bodyWrapper.setRelatedModules(relatedModules);
		
		bodyWrapper.setIds(new ArrayList<Long>(Arrays.asList(347706121155l, 3477061128l)));
		
		APIResponse<ActionResponse> response = inventoryMassConvertOperations.massInventoryConvert(bodyWrapper);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionResponse actionHandler = response.getObject();
				if (actionHandler instanceof SuccessResponse)
				{
					SuccessResponse successResponse = (SuccessResponse) actionHandler;
					System.out.println("Status: " + successResponse.getStatus().getValue());
					System.out.println("Code: " + successResponse.getCode().getValue());
					System.out.println("Details: ");
					for (Map.Entry<String, Object> entry : successResponse.getDetails().entrySet())
					{
						System.out.println(entry.getKey() + ": " + entry.getValue());
					}
					System.out.println("Message: " + successResponse.getMessage());
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
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			String moduleAPIName = "Quotes";
			massInventoryConvert(moduleAPIName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
