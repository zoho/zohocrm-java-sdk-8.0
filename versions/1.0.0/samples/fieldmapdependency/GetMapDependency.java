package samples.fieldmapdependency;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.fieldmapdependency.APIException;
import com.zoho.crm.api.fieldmapdependency.ResponseWrapper;
import com.zoho.crm.api.fieldmapdependency.Child;
import com.zoho.crm.api.fieldmapdependency.FieldMapDependencyOperations;
import com.zoho.crm.api.fieldmapdependency.MapDependency;
import com.zoho.crm.api.fieldmapdependency.Parent;
import com.zoho.crm.api.fieldmapdependency.PickListMapping;
import com.zoho.crm.api.fieldmapdependency.PicklistMap;
import com.zoho.crm.api.fieldmapdependency.ResponseHandler;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetMapDependency
{
	public static void getMapDependency(Long layoutId, String module, Long dependencyId) throws Exception
	{
		FieldMapDependencyOperations fieldMapDependencyOperations = new FieldMapDependencyOperations(layoutId, module);
		APIResponse<ResponseHandler> response = fieldMapDependencyOperations.getMapDependency(dependencyId);
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
					List<MapDependency> mapDependencies = responseWrapper.getMapDependency();
					for (MapDependency mapDependency : mapDependencies)
					{
						Parent parent = mapDependency.getParent();
						if (parent != null)
						{
							System.out.println("MapDependency Map ID: " + parent.getId());
							System.out.println("MapDependency Map APIName: " + parent.getAPIName());
						}
						Child child = mapDependency.getChild();
						if (child != null)
						{
							System.out.println("MapDependency Child ID: " + child.getId());
							System.out.println("MapDependency Child APIName: " + child.getAPIName());
						}
						List<PickListMapping> pickListValues = mapDependency.getPickListValues();
						if (pickListValues != null)
						{
							pickListValues.forEach(pickListValue ->
							{
								System.out.println("MapDependency PickListValue ID: " + pickListValue.getId());
								System.out.println("MapDependency PickListValue ActualValue: " + pickListValue.getActualValue());
								System.out.println("MapDependency PickListValue DisplayValue: " + pickListValue.getDisplayValue());
								List<PicklistMap> picklistMaps = pickListValue.getMaps();
								if (picklistMaps != null)
								{
									picklistMaps.forEach(picklistMap ->
									{
										System.out.println("MapDependency PickListValue Map ID: " + picklistMap.getId());
										System.out.println("MapDependency PickListValue Map ActualValue: " + picklistMap.getActualValue());
										System.out.println("MapDependency PickListValue Map DisplayValue: " + picklistMap.getDisplayValue());
									});
								}
							});
						}
						System.out.println("MapDependency Internal: " + mapDependency.getInternal());
						System.out.println("MapDependency Active: " + mapDependency.getActive());
						System.out.println("MapDependency ID: " + mapDependency.getId());
						System.out.println("MapDependency Active: " + mapDependency.getSource());
						System.out.println("MapDependency Category: " + mapDependency.getCategory());
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
			Long dependencyId = 347706111613002l;
			getMapDependency(layoutId, moduleAPIName, dependencyId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
