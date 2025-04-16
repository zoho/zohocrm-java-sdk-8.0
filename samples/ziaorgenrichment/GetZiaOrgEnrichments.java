package samples.ziaorgenrichment;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.ziaorgenrichment.APIException;
import com.zoho.crm.api.ziaorgenrichment.Info;
import com.zoho.crm.api.ziaorgenrichment.ZiaOrgEnrichmentOperations;
import com.zoho.crm.api.ziaorgenrichment.ResponseHandler;
import com.zoho.crm.api.ziaorgenrichment.ResponseWrapper;
import com.zoho.crm.api.ziaorgenrichment.User;
import com.zoho.crm.api.ziaorgenrichment.ZiaOrgEnrichment;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetZiaOrgEnrichments
{
	public static void getZiaOrgEnrichments() throws Exception
	{
		ZiaOrgEnrichmentOperations ziaOrgEnrichmentOperations = new ZiaOrgEnrichmentOperations();
		ParameterMap paramInstance = new ParameterMap();
		APIResponse<ResponseHandler> response = ziaOrgEnrichmentOperations.getZiaOrgEnrichments(paramInstance);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.getStatusCode() == 204)
			{
				System.out.println("No Content");
				return;
			}
			if (response.isExpected())
			{
				ResponseHandler responseHandler = response.getObject();
				if (responseHandler instanceof ResponseWrapper)
				{
					ResponseWrapper responseWrapper = (ResponseWrapper) responseHandler;
					List<ZiaOrgEnrichment> ziaorgenrichment = responseWrapper.getZiaOrgEnrichment();
					if(ziaorgenrichment != null)
					{
						for(ZiaOrgEnrichment ziaorgenrichment1 : ziaorgenrichment)
						{
							System.out.println("ZiaOrgEnrichment CreatedTime : " + ziaorgenrichment1.getCreatedTime());
							System.out.println("ZiaOrgEnrichment Id : " + ziaorgenrichment1.getId());
							User user = ziaorgenrichment1.getCreatedBy();
							if(user != null)
							{
								System.out.println("ZiaOrgEnrichment User Id : " + user.getId());
								System.out.println("ZiaOrgEnrichment User Name : " + user.getName());
							}
							System.out.println("ZiaOrgEnrichment Status : " + ziaorgenrichment1.getStatus());
						}
					}
					
					Info info = responseWrapper.getInfo();
					if (info != null)
					{
						if (info.getPerPage() != null)
						{
							System.out.println("ZiaOrgEnrichment Info PerPage: " + info.getPerPage().toString());
						}
						if (info.getCount() != null)
						{
							System.out.println("ZiaOrgEnrichment Info Count: " + info.getCount().toString());
						}
						if (info.getPage() != null)
						{
							System.out.println("ZiaOrgEnrichment Info Page: " + info.getPage().toString());
						}
						if (info.getMoreRecords() != null)
						{
							System.out.println("ZiaOrgEnrichment Info MoreRecords: " + info.getMoreRecords().toString());
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
			else if (response.getStatusCode() != 204)
			{
				Model responseObject = response.getModel();
				Class<? extends Model> clas = responseObject.getClass();
				Field[] fields = clas.getDeclaredFields();
				for (Field field1 : fields)
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
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			getZiaOrgEnrichments();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
