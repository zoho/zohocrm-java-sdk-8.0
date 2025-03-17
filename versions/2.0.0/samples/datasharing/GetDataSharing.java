package samples.datasharing;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.datasharing.DataSharingOperations;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.datasharing.APIException;
import com.zoho.crm.api.datasharing.DataSharing;
import com.zoho.crm.api.datasharing.ResponseHandler;
import com.zoho.crm.api.datasharing.ResponseWrapper;
import com.zoho.crm.api.datasharing.Module;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetDataSharing
{

	public static void getDataSharing() throws Exception
	{
		DataSharingOperations dataSharingOperations = new DataSharingOperations();
		APIResponse<ResponseHandler> response = dataSharingOperations.getDataSharing();
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ResponseHandler responseHandler = response.getObject();
				if (responseHandler instanceof ResponseWrapper)
				{
					ResponseWrapper responseWrapper = (ResponseWrapper) responseHandler;
					List<DataSharing> dataSharing = responseWrapper.getDataSharing();
					for (DataSharing dataSharing1 : dataSharing)
					{
						System.out.println("DataSharing PublicInPortals: " + dataSharing1.getPublicInPortals());
						System.out.println("DataSharing ShareType: " + dataSharing1.getShareType().getValue());
						Module module = dataSharing1.getModule();
						if(module != null)
						{
							System.out.println("DataSharing Module APIName: " + module.getAPIName());
							System.out.println("DataSharing Module Id: " + module.getId());
						}
						System.out.println("DataSharing RuleComputationRunning: " + dataSharing1.getRuleComputationRunning());
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
			getDataSharing();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
