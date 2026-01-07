package samples.pipeline;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.pipeline.APIException;
import com.zoho.crm.api.pipeline.ActionHandler;
import com.zoho.crm.api.pipeline.ActionResponse;
import com.zoho.crm.api.pipeline.ActionWrapper;
import com.zoho.crm.api.pipeline.BodyWrapper;
import com.zoho.crm.api.pipeline.Maps;
import com.zoho.crm.api.pipeline.PipelineOperations;
import com.zoho.crm.api.pipeline.SuccessResponse;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class UpdatePipelines
{
	public static void updatePipelines(Long LayoutID) throws Exception
	{
		BodyWrapper bodyWrapper = new BodyWrapper();
		ArrayList<com.zoho.crm.api.pipeline.Pipeline> pipelines = new ArrayList<com.zoho.crm.api.pipeline.Pipeline>();
		com.zoho.crm.api.pipeline.Pipeline pipeLine = new com.zoho.crm.api.pipeline.Pipeline();
		pipeLine.setDisplayValue("Pipeline222123");
		pipeLine.setDefault(true);
		ArrayList<Maps> maps = new ArrayList<Maps>();
		Maps pickListValue = new Maps();
		pickListValue.setSequenceNumber(1);
		pickListValue.setId(3477061006801l);
		pickListValue.setDisplayValue("Closed Won");
		maps.add(pickListValue);
		pipeLine.setMaps(maps);
		pipelines.add(pipeLine);
		pipeLine.setId(34770619599012l);
		bodyWrapper.setPipeline(pipelines);
		PipelineOperations pipelineOperations = new PipelineOperations(LayoutID);
		APIResponse<ActionHandler> response = pipelineOperations.updatePipelines(bodyWrapper);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ActionWrapper)
				{
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
					List<ActionResponse> actionResponses = actionWrapper.getPipeline();
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
			Long layoutId = 3477061091023l;
			updatePipelines(layoutId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
