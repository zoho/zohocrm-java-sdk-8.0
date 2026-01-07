package samples.inventorytemplates;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.inventorytemplates.APIException;
import com.zoho.crm.api.inventorytemplates.Folder;
import com.zoho.crm.api.inventorytemplates.Info;
import com.zoho.crm.api.inventorytemplates.InventoryTemplates;
import com.zoho.crm.api.inventorytemplates.InventoryTemplatesOperations;
import com.zoho.crm.api.inventorytemplates.ResponseHandler;
import com.zoho.crm.api.inventorytemplates.ResponseWrapper;
import com.zoho.crm.api.inventorytemplates.User;
import com.zoho.crm.api.inventorytemplates.InventoryTemplatesOperations.GetInventoryTemplatesParam;
import com.zoho.crm.api.inventorytemplates.ModuleMap;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetInventoryTemplates
{
	public static void getInventoryTemplates(String moduleAPIName) throws Exception
	{
		InventoryTemplatesOperations inventoryTemplatesOperations = new InventoryTemplatesOperations();
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(GetInventoryTemplatesParam.MODULE, moduleAPIName);
		APIResponse<ResponseHandler> response = inventoryTemplatesOperations.getInventoryTemplates(paramInstance);
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
					List<InventoryTemplates> inventoryTemplates = responseWrapper.getInventoryTemplates();
					for (InventoryTemplates inventoryTemplate : inventoryTemplates)
					{
						System.out.println("InventoryTemplate CreatedTime: " + inventoryTemplate.getCreatedTime());
						ModuleMap module = inventoryTemplate.getModule();
						if (module != null)
						{
							System.out.println("InventoryTemplate Module ID: " + module.getId());
							System.out.println("InventoryTemplate Module apiName: " + module.getAPIName());
						}
						User createdBy = inventoryTemplate.getCreatedBy();
						if (createdBy != null)
						{
							System.out.println("InventoryTemplate Created By Name : " + createdBy.getName());
							System.out.println("InventoryTemplate Created By id : " + createdBy.getId());
						}
						System.out.println("InventoryTemplate ModifiedTime: " + inventoryTemplate.getModifiedTime());
						Folder folder = inventoryTemplate.getFolder();
						if (folder != null)
						{
							System.out.println("InventoryTemplate Folder  id : " + folder.getId());
							System.out.println("InventoryTemplate Folder  Name : " + folder.getName());
						}
						System.out.println("InventoryTemplate Last Usage Time: " + inventoryTemplate.getLastUsageTime());
						System.out.println("InventoryTemplate Name: " + inventoryTemplate.getName());
						User modifiedBy = inventoryTemplate.getModifiedBy();
						if (modifiedBy != null)
						{
							System.out.println("InventoryTemplate Modified By Name : " + modifiedBy.getName());
							System.out.println("InventoryTemplate Modified By id : " + modifiedBy.getId());
						}
						System.out.println("InventoryTemplate ID: " + inventoryTemplate.getId());
						System.out.println("InventoryTemplate EditorMode : " + inventoryTemplate.getEditorMode());
						System.out.println("InventoryTemplate Content: " + inventoryTemplate.getContent());
						System.out.println("InventoryTemplate Favourite: " + inventoryTemplate.getFavorite());
					}
					Info info = responseWrapper.getInfo();
					if (info != null)
					{
						if (info.getPerPage() != null)
						{
							System.out.println("Record Info PerPage: " + info.getPerPage().toString());
						}
						if (info.getCount() != null)
						{
							System.out.println("Record Info Count: " + info.getCount().toString());
						}
						if (info.getPage() != null)
						{
							System.out.println("Record Info Page: " + info.getPage().toString());
						}
						if (info.getMoreRecords() != null)
						{
							System.out.println("Record Info MoreRecords: " + info.getMoreRecords().toString());
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
			else
			{
				Model responseObject = response.getModel();
				Class<? extends Model> clas = responseObject.getClass();
				java.lang.reflect.Field[] Fields = clas.getDeclaredFields();
				for (java.lang.reflect.Field field : Fields)
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
			String moduleAPIName = "Quotes";
			getInventoryTemplates(moduleAPIName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
