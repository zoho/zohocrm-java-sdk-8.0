package samples.cadences;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.cadences.APIException;
import com.zoho.crm.api.cadences.Cadences;
import com.zoho.crm.api.cadences.CadencesOperations;
import com.zoho.crm.api.cadences.CustomView;
import com.zoho.crm.api.cadences.ExecuteEvery;
import com.zoho.crm.api.cadences.ExecutionDetail;
import com.zoho.crm.api.cadences.Info;
import com.zoho.crm.api.cadences.ResponseHandler;
import com.zoho.crm.api.cadences.ResponseWrapper;
import com.zoho.crm.api.cadences.Summary;
import com.zoho.crm.api.cadences.UnenrollProperty;
import com.zoho.crm.api.cadences.User;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetCadences
{
	public static void getDetails() throws Exception
	{
		CadencesOperations cadencesOperations = new CadencesOperations();
		APIResponse<ResponseHandler> response = cadencesOperations.getCadences();
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
					List<Cadences> cadences = responseWrapper.getCadences();
					for (Cadences cadence : cadences)
					{
						Summary summary = cadence.getSummary();
						if(summary != null)
						{
							System.out.println("Cadences Summary TaskFollowUpCount: " + summary.getTaskFollowUpCount());
							System.out.println("Cadences Summary CallFollowUpCount: " + summary.getCallFollowUpCount());
							System.out.println("Cadences Summary EmailFollowUpCount: " + summary.getEmailFollowUpCount());
						}
						System.out.println("Cadences CreatedTime: " + cadence.getCreatedTime());
						com.zoho.crm.api.cadences.Module module = cadence.getModule();
						if(module != null)
						{
							System.out.println("Cadences Module APIName: " + module.getAPIName());
							System.out.println("Cadences Module Id: " + module.getId());
						}
						System.out.println("Cadences Active: " + cadence.getActive());
						ExecutionDetail executionDetails = cadence.getExecutionDetails();
						if(executionDetails != null)
						{
							UnenrollProperty unenrollProperties = executionDetails.getUnenrollProperties();
							if(unenrollProperties != null)
							{
								System.out.println("Cadences ExecutionDetails UnenrollProperty EndDate: " + unenrollProperties.getEndDate());
								System.out.println("Cadences ExecutionDetails UnenrollProperty Type: " + unenrollProperties.getType());
							}
							System.out.println("Cadences ExecutionDetails EndDate: " + executionDetails.getEndDate());
							System.out.println("Cadences ExecutionDetails AutomaticUnenroll: " + executionDetails.getAutomaticUnenroll());
							System.out.println("Cadences ExecutionDetails Type: " + executionDetails.getType());
							ExecuteEvery executeEvery = executionDetails.getExecuteEvery();
							if(executeEvery != null)
							{
								System.out.println("Cadences ExecutionDetails ExecuteEvery Unit: " + executeEvery.getUnit());
								System.out.println("Cadences ExecutionDetails ExecuteEvery Period: " + executeEvery.getPeriod());
							}
						}
						System.out.println("Cadences Published: " + cadence.getPublished());
						System.out.println("Cadences Type: " + cadence.getType());
						User createdBy = cadence.getCreatedBy();
						if(createdBy != null)
						{
							System.out.println("Cadences CreatedBy User Name: " + createdBy.getName());
							System.out.println("Cadences CreatedBy User Id: " + createdBy.getId());
						}
						System.out.println("Cadences ModifiedTime: " + cadence.getModifiedTime());
						System.out.println("Cadences Name: " + cadence.getName());
						User modifiedBy = cadence.getModifiedBy();
						if(modifiedBy != null)
						{
							System.out.println("Cadences ModifiedBy User Name: " + modifiedBy.getName());
							System.out.println("Cadences ModifiedBy User Id: " + modifiedBy.getId());
						}
						System.out.println("Cadences Id: " + cadence.getId());
						CustomView customView = cadence.getCustomView();
						if(customView != null)
						{
							System.out.println("Cadences CustomView Id: " + customView.getId());
							System.out.println("Cadences CustomView Name: " + customView.getName());
						}
						System.out.println("Cadences Status: " + cadence.getStatus());
					}
					
					Info info = responseWrapper.getInfo();
					if(info != null)
					{
						System.out.println("Cadences Info PerPage: " + info.getPerPage());
						System.out.println("Cadences Info Page: " + info.getPage());
						System.out.println("Cadences Info Count: " + info.getCount());
						System.out.println("Cadences Info MoreRecords: " + info.getMoreRecords());
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
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			getDetails();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
