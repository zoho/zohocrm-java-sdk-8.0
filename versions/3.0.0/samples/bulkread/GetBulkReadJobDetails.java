package samples.bulkread;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.bulkread.APIException;
import com.zoho.crm.api.bulkread.BulkReadOperations;
import com.zoho.crm.api.bulkread.Criteria;
import com.zoho.crm.api.bulkread.JobDetail;
import com.zoho.crm.api.bulkread.Query;
import com.zoho.crm.api.bulkread.ResponseHandler;
import com.zoho.crm.api.bulkread.ResponseWrapper;
import com.zoho.crm.api.bulkread.Result;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.modules.MinifiedModule;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetBulkReadJobDetails
{
	public static void getBulkReadJobDetails(Long jobId) throws Exception
	{
		BulkReadOperations bulkReadOperations = new BulkReadOperations();
		APIResponse<ResponseHandler> response = bulkReadOperations.getBulkReadJobDetails(jobId);
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
					List<JobDetail> jobDetails = responseWrapper.getData();
					for (JobDetail jobDetail : jobDetails)
					{
						System.out.println("Bulk read Job ID: " + jobDetail.getId());
						System.out.println("Bulk read Operation: " + jobDetail.getOperation());
						System.out.println("Bulk read State: " + jobDetail.getState().getValue());
						Result result = jobDetail.getResult();
						if (result != null)
						{
							System.out.println("Bulkread Result Page: " + result.getPage().toString());
							System.out.println("Bulkread Result Count: " + result.getCount().toString());
							System.out.println("Bulkread Result Download URL: " + result.getDownloadUrl());
							System.out.println("Bulkread Result Per_Page: " + result.getPerPage().toString());
							System.out.println("Bulkread Result MoreRecords: " + result.getMoreRecords().toString());
						}
						Query query = jobDetail.getQuery();
						if (query != null)
						{
							MinifiedModule module = query.getModule();
							if (module != null)
							{
								System.out.println("Bulkread Resource Module Name : " + module.getAPIName());
								System.out.println("Bulkread Resource Module Id : " + module.getId());
							}
							System.out.println("Bulk read Query Page: " + query.getPage().toString());
							System.out.println("Bulk read Query cvid: " + query.getCvid());
							List<String> fields = query.getFields();
							if (fields != null)
							{
								for (Object fieldName : fields)
								{
									System.out.println("Bulk read Query Fields: " + fieldName);
								}
							}
							Criteria criteria = query.getCriteria();
							if (criteria != null)
							{
								printCriteria(criteria);
							}
						}
						com.zoho.crm.api.users.MinifiedUser createdBy = jobDetail.getCreatedBy();
						if (createdBy != null)
						{
							System.out.println("Bulkread Created By User-ID: " + createdBy.getId());
							System.out.println("Bulkread Created By user-Name: " + createdBy.getName());
						}
						System.out.println("Bulkread CreatedTime: " + jobDetail.getCreatedTime());
						System.out.println("Bulkread File Type: " + jobDetail.getFileType());
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

	private static void printCriteria(Criteria criteria)
	{
		System.out.println("Bulk read Query Criteria APIName: " + criteria.getAPIName());
		if (criteria.getComparator() != null)
		{
			System.out.println("Bulk read Query Criteria Comparator: " + criteria.getComparator().getValue());
		}
		if (criteria.getValue() != null)
		{
			System.out.println("Bulk read Query Criteria Value: " + criteria.getValue().toString());
		}
		if (criteria.getField() != null)
		{
			System.out.println("Bulk read Query Criteria field name: " + criteria.getField().getAPIName());
		}
		List<Criteria> criteriaGroup = criteria.getGroup();
		if (criteriaGroup != null)
		{
			for (Criteria criteria1 : criteriaGroup)
			{
				printCriteria(criteria1);
			}
		}
		if (criteria.getGroupOperator() != null)
		{
			System.out.println("Bulk read Query Criteria Group Operator: " + criteria.getGroupOperator().getValue());
		}
	}

	public static void main(String[] args)
	{
		try
		{
			Environment environment = USDataCenter.PRODUCTION;
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").redirectURL("Redirect_URL").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			Long jobId = 3477061l;
			getBulkReadJobDetails(jobId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
