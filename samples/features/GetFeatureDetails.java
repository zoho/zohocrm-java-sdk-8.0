package samples.features;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.features.APIException;
import com.zoho.crm.api.features.Component;
import com.zoho.crm.api.features.Detail;
import com.zoho.crm.api.features.Feature;
import com.zoho.crm.api.features.FeaturesOperations;
import com.zoho.crm.api.features.FeaturesOperations.GetFeatureDetailsParam;
import com.zoho.crm.api.features.Limit;
import com.zoho.crm.api.features.ResponseHandler;
import com.zoho.crm.api.features.ResponseWrapper;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;
import com.zoho.crm.api.dc.DataCenter.Environment;

public class GetFeatureDetails
{
	public static void getFeatureDetails() throws Exception
	{
		FeaturesOperations featuresOperations = new FeaturesOperations();
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(GetFeatureDetailsParam.MODULE, "Leads");
		paramInstance.add(GetFeatureDetailsParam.API_NAMES, "data_sharing_rules");
		APIResponse<ResponseHandler> response = featuresOperations.getFeatureDetails(paramInstance);
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
					List<Feature> features = responseWrapper.getFeatures();
					if (features != null)
					{
						for (Feature feature : features)
						{
							List<Component> components = feature.getComponents();
							if(components != null)
							{
								for(Component component : components)
								{
									System.out.println("Feature Component APIName : " + component.getAPIName());
									System.out.println("Feature Component ModuleSupported : " + component.getModuleSupported());
									Detail detail = component.getDetails();
									if (detail != null)
									{
										Limit limit = detail.getLimits();
										if(limit != null)
										{
											System.out.println("Feature Component Detail Limit EditionLimit: " + limit.getEditionLimit());
											System.out.println("Feature Component Detail Limit Total: " + limit.getTotal());
										}
									}
									System.out.println("Feature Component FeatureLabel : " + component.getFeatureLabel());
								}
							}
							System.out.println("Feature APIName : " + feature.getAPIName());
							Feature parentFeature = feature.getParentFeature();
							if(parentFeature != null)
							{
								System.out.println("Feature ParentFeature APIName: " + parentFeature.getAPIName());
							}
							System.out.println("Feature ModuleSupported : " + feature.getModuleSupported());
							Detail detail = feature.getDetails();
							if (detail != null)
							{
								Limit limit = detail.getLimits();
								if(limit != null)
								{
									System.out.println("Feature Detail Limit EditionLimit: " + limit.getEditionLimit());
									System.out.println("Feature Detail Limit Total: " + limit.getTotal());
								}
							}
							System.out.println("Feature FeatureLabel : " + feature.getFeatureLabel());
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
			getFeatureDetails();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
