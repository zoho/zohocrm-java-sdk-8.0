package samples.findandmerge;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.findandmerge.APIException;
import com.zoho.crm.api.findandmerge.ActionResponse;
import com.zoho.crm.api.findandmerge.ActionWrapper;
import com.zoho.crm.api.findandmerge.FindAndMergeOperations;
import com.zoho.crm.api.findandmerge.MasterRecordFields;
import com.zoho.crm.api.findandmerge.Merge;
import com.zoho.crm.api.findandmerge.MergeData;
import com.zoho.crm.api.findandmerge.SuccessResponse;
import com.zoho.crm.api.findandmerge.ActionHandler;
import com.zoho.crm.api.findandmerge.BodyWrapper;
import com.zoho.crm.api.findandmerge.DataFields;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class MergeRecords
{
	public static void mergeRecords(String module, Long masterrecordid) throws Exception
	{
		FindAndMergeOperations findAndMergeOperations = new FindAndMergeOperations(module, masterrecordid);
		BodyWrapper request = new BodyWrapper();
		List<Merge> mergeList = new ArrayList<>();
		Merge merge = new Merge();
		List<MergeData> data = new ArrayList<MergeData>();
		MergeData data1 = new MergeData();
		data1.setId(347701001l);
		List<DataFields> fields = new ArrayList<DataFields>();
		DataFields field = new DataFields();
		field.setAPIName("Last_Name");
		fields.add(field);
		data1.setFields(fields);
		merge.setData(data);
		List<MasterRecordFields> masterRecordFields = new ArrayList<MasterRecordFields>();
		MasterRecordFields masterRecordField = new MasterRecordFields();
		masterRecordField.setAPIName("Company");
		masterRecordFields.add(masterRecordField);
		merge.setMasterRecordFields(masterRecordFields);
		data.add(data1);
		merge.setData(data);
		mergeList.add(merge);
		request.setMerge(mergeList);
		APIResponse<ActionHandler> response = findAndMergeOperations.mergeRecords(request);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ActionWrapper)
				{
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
					List<ActionResponse> actionResponses = actionWrapper.getMerge();
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
				Field[] fields1 = clas.getDeclaredFields();
				for (Field field1 : fields1)
				{
					field1.setAccessible(true);
					System.out.println(field1.getName() + ":" + field1.get(responseObject));
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
			String module = "Leads";
			Long masterrecordid = 3477001l;
			mergeRecords(module, masterrecordid);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
