package samples.bulkread;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.bulkread.APIException;
import com.zoho.crm.api.bulkread.ActionHandler;
import com.zoho.crm.api.bulkread.ActionResponse;
import com.zoho.crm.api.bulkread.ActionWrapper;
import com.zoho.crm.api.bulkread.BulkReadOperations;
import com.zoho.crm.api.bulkread.CallBack;
import com.zoho.crm.api.bulkread.Criteria;
import com.zoho.crm.api.bulkread.Query;
import com.zoho.crm.api.bulkread.BodyWrapper;
import com.zoho.crm.api.bulkread.SuccessResponse;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.modules.MinifiedModule;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;

public class CreateBulkReadJob
{
	public static void createBulkReadJob(String moduleAPIName) throws Exception
	{
		BulkReadOperations bulkReadOperations = new BulkReadOperations();
		BodyWrapper bodyWrapper = new BodyWrapper();
		MinifiedModule module = new MinifiedModule();
		module.setAPIName(moduleAPIName);
		CallBack callback = new CallBack();
		callback.setUrl("https://www.example.com/callback");
		callback.setMethod(new Choice<String>("post"));
		bodyWrapper.setCallback(callback);
		Query query = new Query();
		query.setModule(module);
//		query.setCvid(347706108701l);
		List<String> fieldAPINames = new ArrayList<String>();
		fieldAPINames.add("Last_Name");
		query.setFields(fieldAPINames);
		query.setPage(1);
		Criteria criteria = new Criteria();
		criteria.setGroupOperator(new Choice<String>("or"));
		List<Criteria> criteriaList = new ArrayList<Criteria>();
		Criteria group11 = new Criteria();
		group11.setGroupOperator(new Choice<String>("and"));
		List<Criteria> groupList11 = new ArrayList<Criteria>();
		Criteria group111 = new Criteria();
		com.zoho.crm.api.fields.MinifiedField field111 = new com.zoho.crm.api.fields.MinifiedField();
		field111.setAPIName("Company");
		group111.setField(field111);
		group111.setComparator(new Choice<String>("equal"));
		group111.setValue("Zoho");
		groupList11.add(group111);
		Criteria group112 = new Criteria();
		com.zoho.crm.api.fields.MinifiedField field112 = new com.zoho.crm.api.fields.MinifiedField();
		field112.setAPIName("Owner");
		group112.setField(field112);
		group112.setComparator(new Choice<String>("in"));
		List<String> owner = new ArrayList<String>(Arrays.asList("3477061173021"));
		group112.setValue(owner);
		groupList11.add(group112);
		group11.setGroup(groupList11);
		criteriaList.add(group11);
		Criteria group12 = new Criteria();
		group12.setGroupOperator(new Choice<String>("or"));
		List<Criteria> groupList12 = new ArrayList<Criteria>();
		Criteria group121 = new Criteria();
		com.zoho.crm.api.fields.MinifiedField field121 = new com.zoho.crm.api.fields.MinifiedField();
		field121.setAPIName("Paid");
		group121.setField(field121);
		group121.setComparator(new Choice<String>("equal"));
		group121.setValue(true);
		groupList12.add(group121);
		Criteria group122 = new Criteria();
		com.zoho.crm.api.fields.MinifiedField field122 = new com.zoho.crm.api.fields.MinifiedField();
		field122.setAPIName("Created_Time");
		group122.setField(field122);
		group122.setComparator(new Choice<String>("between"));
		List<String> createdTime = new ArrayList<String>(Arrays.asList("2020-06-03T17:31:48+05:30", "2020-06-03T17:31:48+05:30"));
		group122.setValue(createdTime);
		groupList12.add(group122);
		group12.setGroup(groupList12);
		criteriaList.add(group12);
		criteria.setGroup(criteriaList);
		query.setCriteria(criteria);
		bodyWrapper.setQuery(query);
		// requestWrapper.setFileType(new Choice<String>("ics"));
		APIResponse<ActionHandler> response = bulkReadOperations.createBulkReadJob(bodyWrapper);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ActionWrapper)
				{
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
					List<ActionResponse> actionResponses = actionWrapper.getData();
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
							System.out.println("Message: " + successResponse.getMessage().getValue());
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
			createBulkReadJob(moduleAPIName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
