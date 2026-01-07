package samples.findandmerge;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.dc.INDataCenter;
import com.zoho.crm.api.findandmerge.FindAndMergeOperations;
import com.zoho.crm.api.findandmerge.ResponseHandler;
import com.zoho.crm.api.findandmerge.FindAndMergeOperations.GetRecordMergeParam;
import com.zoho.crm.api.findandmerge.Merge;
import com.zoho.crm.api.findandmerge.ResponseWrapper;
import com.zoho.crm.api.findandmerge.APIException;

public class GetRecordMerge
{
	public static void getRecordMerge(String module, Long masterrecordid) throws Exception
	{
		FindAndMergeOperations findAndMergeOperations = new FindAndMergeOperations(module, masterrecordid);
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(GetRecordMergeParam.JOB_ID, 347703001l);
		APIResponse<ResponseHandler> response = findAndMergeOperations.getRecordMerge(paramInstance);
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
					List<Merge> mergeList = responseWrapper.getMerge();
					for(Merge merge : mergeList)
					{
						System.out.println("RecordMerge JobId :" + merge.getJobId());
						System.out.println("RecordMerge Status :" + merge.getStatus());
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
			Environment environment = INDataCenter.PRODUCTION;
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").redirectURL("Redirect_URL").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			String module = "Leads";
			Long masterrecordid = 347001l;
			getRecordMerge(module, masterrecordid);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
