package samples.pipeline;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.pipeline.APIException;
import com.zoho.crm.api.pipeline.ForecastCategory;
import com.zoho.crm.api.pipeline.Maps;
import com.zoho.crm.api.pipeline.PipelineOperations;
import com.zoho.crm.api.pipeline.ResponseHandler;
import com.zoho.crm.api.pipeline.ResponseWrapper;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetPipelines
{
	public static void getPipelines(Long layoutId) throws Exception
	{
		PipelineOperations pipelineOperations = new PipelineOperations(layoutId);
		APIResponse<ResponseHandler> response = pipelineOperations.getPipelines();
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
					List<com.zoho.crm.api.pipeline.Pipeline> pipelines = responseWrapper.getPipeline();
					if (pipelines != null)
					{
						for (com.zoho.crm.api.pipeline.Pipeline pipeline : pipelines)
						{
							System.out.println("Pipeline ID: " + pipeline.getId());
							System.out.println("Pipeline default  : " + pipeline.getDefault());
							System.out.println("Pipeline Display value : " + pipeline.getDisplayValue());
							System.out.println("Pipeline Actual value : " + pipeline.getActualValue());
							System.out.println("Pipeline child available  : " + pipeline.getChildAvailable());
							com.zoho.crm.api.pipeline.Pipeline parent = pipeline.getParent();
							if (parent != null)
							{
								System.out.println("Pipeline parent ID: " + parent.getId());
							}
							List<Maps> maps = pipeline.getMaps();
							for (Maps map : maps)
							{
								System.out.println("PickListValue Display Value: " + map.getDisplayValue());
								System.out.println("PickListValue Sequence Number: " + map.getSequenceNumber());
								ForecastCategory forecastCategory = map.getForecastCategory();
								if (forecastCategory != null)
								{
									System.out.println("Forecast Category Name: " + forecastCategory.getName());
									System.out.println("Forecast Category ID: " + forecastCategory.getId());
								}
								System.out.println("PickListValue Actual Value: " + map.getActualValue());
								System.out.println("PickListValue ID: " + map.getId());
								System.out.println("PickListValue Forecast type: " + map.getForecastType());
								System.out.println("PickListValue delete: " + map.getDelete());
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
					System.out.println("Message: " + exception.getMessage().getValue());
				}
			}
			else if (response.getStatusCode() != 204)
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
			Long layoutId = 4402480167l;
			getPipelines(layoutId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
