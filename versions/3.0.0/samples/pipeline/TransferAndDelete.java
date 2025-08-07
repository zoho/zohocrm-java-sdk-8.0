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
import com.zoho.crm.api.pipeline.PipelineOperations;
import com.zoho.crm.api.pipeline.Stages;
import com.zoho.crm.api.pipeline.TransferPipelineActionHandler;
import com.zoho.crm.api.pipeline.TransferPipelineActionResponse;
import com.zoho.crm.api.pipeline.TransferPipeline;
import com.zoho.crm.api.pipeline.TransferPipelineActionWrapper;
import com.zoho.crm.api.pipeline.TransferPipelineWrapper;
import com.zoho.crm.api.pipeline.TransferPipelineSuccessResponse;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class TransferAndDelete
{
	public static void transferAndDelete(Long LayoutId) throws Exception
	{
		PipelineOperations pipelineOperations = new PipelineOperations(LayoutId);
		TransferPipelineWrapper request = new TransferPipelineWrapper();
		ArrayList<TransferPipeline> transferPipelines = new ArrayList<TransferPipeline>();
		TransferPipeline transferPipeline = new TransferPipeline();
		com.zoho.crm.api.pipeline.TPipeline pipeline = new com.zoho.crm.api.pipeline.TPipeline();
		pipeline.setFrom(347706116634118l);
		pipeline.setTo(34770619599012l);
		transferPipeline.setPipeline(pipeline);
		ArrayList<Stages> stages = new ArrayList<Stages>();
		Stages stage = new Stages();
		stage.setFrom(3652397006817L);
		stage.setTo(3652397006819L);
		stages.add(stage);
		transferPipeline.setStages(stages);
		transferPipelines.add(transferPipeline);
		request.setTransferPipeline(transferPipelines);
		APIResponse<TransferPipelineActionHandler> response = pipelineOperations.transferPipelines(request);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				TransferPipelineActionHandler transferActionHandler = response.getObject();
				if (transferActionHandler instanceof TransferPipelineActionWrapper)
				{
					TransferPipelineActionWrapper transferActionWrapper = (TransferPipelineActionWrapper) transferActionHandler;
					List<TransferPipelineActionResponse> transferPipelines1 = transferActionWrapper.getTransferPipeline();
					for (TransferPipelineActionResponse transferPipeline1 : transferPipelines1)
					{
						if (transferPipeline1 instanceof TransferPipelineSuccessResponse)
						{
							TransferPipelineSuccessResponse successResponse = (TransferPipelineSuccessResponse) transferPipeline1;
							System.out.println("Status: " + successResponse.getStatus().getValue());
							System.out.println("Code: " + successResponse.getCode().getValue());
							System.out.println("Details: ");
							for (Map.Entry<String, Object> entry : successResponse.getDetails().entrySet())
							{
								System.out.println(entry.getKey() + ": " + entry.getValue());
							}
							System.out.println("Message: " + successResponse.getMessage());
						}
						else if (transferPipeline1 instanceof APIException)
						{
							APIException exception = (APIException) transferPipeline1;
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
				else if (transferActionHandler instanceof APIException)
				{
					APIException exception = (APIException) transferActionHandler;
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
			transferAndDelete(layoutId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
