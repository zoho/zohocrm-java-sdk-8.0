package samples.recyclebin;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.modules.MinifiedModule;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.recyclebin.APIException;
import com.zoho.crm.api.recyclebin.RecycleBin;
import com.zoho.crm.api.recyclebin.RecycleBinOperations;
import com.zoho.crm.api.recyclebin.RecycleBinOperations.GetRecycleBinRecordsParam;
import com.zoho.crm.api.recyclebin.ResponseHandler;
import com.zoho.crm.api.recyclebin.ResponseWrapper;
import com.zoho.crm.api.recyclebin.Info;
import com.zoho.crm.api.users.MinifiedUser;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetRecyclebinRecords
{
	public static void getRecyclebinRecords() throws Exception
	{
		RecycleBinOperations recycleBinOperations = new RecycleBinOperations();
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(GetRecycleBinRecordsParam.IDS, "347704108020");
		paramInstance.add(GetRecycleBinRecordsParam.SORT_BY, "");
		paramInstance.add(GetRecycleBinRecordsParam.SORT_ORDER, "");
		paramInstance.add(GetRecycleBinRecordsParam.PAGE, 1);
		paramInstance.add(GetRecycleBinRecordsParam.PER_PAGE, 10);
		paramInstance.add(GetRecycleBinRecordsParam.FILTERS, "{\"group_operator\": \"AND\",\"group\": [{\"field\": {\"api_name\": \"module\"},\"comparator\": \"equal\",\"value\": \"Leads\"}]}}");
		APIResponse<ResponseHandler> response = recycleBinOperations.getRecyclebinRecords(paramInstance);
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
					List<RecycleBin> recycleBin = responseWrapper.getRecycleBin();
					for (RecycleBin recycleBin1 : recycleBin)
					{
						MinifiedUser owner = recycleBin1.getOwner();
						if (owner != null)
						{
							System.out.println("RecycleBin Owner Name: " + owner.getName());
							System.out.println("RecycleBin Owner Id: " + owner.getId());
						}
						MinifiedModule module = recycleBin1.getModule();
						if (module != null)
						{
							System.out.println("RecycleBin Module APIName: " + module.getAPIName());
							System.out.println("RecycleBin Module Id: " + module.getId());
						}
						MinifiedUser deletedBy = recycleBin1.getDeletedBy();
						if (deletedBy != null)
						{
							System.out.println("RecycleBin DeletedBy User Name: " + deletedBy.getName());
							System.out.println("RecycleBin DeletedBy User Id: " + deletedBy.getId());
						}
						System.out.println("RecycleBin ID: " + recycleBin1.getId());
						System.out.println("RecycleBin DisplayName: " + recycleBin1.getDisplayName());
						System.out.println("RecycleBin DeletedTime: " + recycleBin1.getDeletedTime());
					}
					
					Info info = responseWrapper.getInfo();
					System.out.println("RecycleBin Info Count: " + info.getCount());
					System.out.println("RecycleBin Info Page: " + info.getPage());
					System.out.println("RecycleBin Info PerPage: " + info.getPerPage());
					System.out.println("RecycleBin Info MoreRecords: " + info.getMoreRecords());
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
			getRecyclebinRecords();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
