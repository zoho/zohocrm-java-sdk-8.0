package samples.fieldmapdependency;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.fieldmapdependency.APIException;
import com.zoho.crm.api.fieldmapdependency.ActionHandler;
import com.zoho.crm.api.fieldmapdependency.ActionResponse;
import com.zoho.crm.api.fieldmapdependency.ActionWrapper;
import com.zoho.crm.api.fieldmapdependency.BodyWrapper;
import com.zoho.crm.api.fieldmapdependency.Child;
import com.zoho.crm.api.fieldmapdependency.FieldMapDependencyOperations;
import com.zoho.crm.api.fieldmapdependency.MapDependency;
import com.zoho.crm.api.fieldmapdependency.Parent;
import com.zoho.crm.api.fieldmapdependency.PickListMapping;
import com.zoho.crm.api.fieldmapdependency.PicklistMap;
import com.zoho.crm.api.fieldmapdependency.SuccessResponse;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class CreateMapDependency
{
	public static void createMapDependency(Long layoutId, String module) throws Exception
	{
		FieldMapDependencyOperations fieldMapDependencyOperations = new FieldMapDependencyOperations(layoutId, module);
		BodyWrapper bodyWrapper = new BodyWrapper();
		List<MapDependency> mapDependencies = new ArrayList<MapDependency>();
		MapDependency mapdependency = new MapDependency();
		Parent parent = new Parent();
		parent.setAPIName("Lead_Status");
		parent.setId(3477061002611l);
		mapdependency.setParent(parent);
		Child child = new Child();
		child.setAPIName("Lead_Source");
		child.setId(347706116628001l);
		mapdependency.setChild(child);
		List<PickListMapping> pickListValues = new ArrayList<>();
		PickListMapping pickListValue = new PickListMapping();
		pickListValue.setDisplayValue("-None-");
		pickListValue.setId(3477061003409l);
		pickListValue.setActualValue("-None-");
		List<PicklistMap> picklistMaps = new ArrayList<>();
		PicklistMap picklistMap = new PicklistMap();
		picklistMap.setId(347706116628005l);
		picklistMap.setActualValue("Option 1");
		picklistMap.setDisplayValue("Option 1");
		picklistMaps.add(picklistMap);
		picklistMap = new PicklistMap();
		picklistMap.setId(347706116628003l);
		picklistMap.setActualValue("-None-");
		picklistMap.setDisplayValue("-None-");
		picklistMaps.add(picklistMap);
		pickListValue.setMaps(picklistMaps);
		pickListValues.add(pickListValue);
		mapdependency.setPickListValues(pickListValues);
		mapDependencies.add(mapdependency);
		bodyWrapper.setMapDependency(mapDependencies);
		APIResponse<ActionHandler> response = fieldMapDependencyOperations.createMapDependency(bodyWrapper);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ActionWrapper)
				{
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
					List<ActionResponse> actionResponses = actionWrapper.getMapDependency();
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
			Long layoutId = 347706111613002l;
			createMapDependency(layoutId, moduleAPIName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
