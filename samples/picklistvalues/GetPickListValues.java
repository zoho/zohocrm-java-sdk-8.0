package samples.picklistvalues;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.picklistvalues.APIException;
import com.zoho.crm.api.picklistvalues.LayoutAssociation;
import com.zoho.crm.api.picklistvalues.PickListValues;
import com.zoho.crm.api.picklistvalues.PickListValuesOperations;
import com.zoho.crm.api.picklistvalues.ResponseHandler;
import com.zoho.crm.api.picklistvalues.ResponseWrapper;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetPickListValues
{
	public static void getPickListValues(Long fieldId, String moduleAPIName) throws Exception
	{
		PickListValuesOperations pickListValuesOperations = new PickListValuesOperations(fieldId, moduleAPIName);
		APIResponse<ResponseHandler> response = pickListValuesOperations.getPickListValues();
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
					List<PickListValues> pickListValues = responseWrapper.getPickListValues();
					if(pickListValues != null)
					{
						for(PickListValues pickListValue : pickListValues)
						{
							System.out.println("PickListValues SequenceNumber : " + pickListValue.getSequenceNumber());
							System.out.println("PickListValues DisplayValue : " + pickListValue.getDisplayValue());
							System.out.println("PickListValues ReferenceValue : " + pickListValue.getReferenceValue());
							System.out.println("PickListValues ColourCode( : " + pickListValue.getColourCode());
							System.out.println("PickListValues ActualValue : " + pickListValue.getActualValue());
							System.out.println("PickListValues Id : " + pickListValue.getId());
							System.out.println("PickListValues Type : " + pickListValue.getType());
							List<LayoutAssociation> layoutAssociations = pickListValue.getLayoutAssociations();
							if(layoutAssociations != null)
							{
								for(LayoutAssociation layoutAssociation : layoutAssociations)
								{
									System.out.println("PickListValues LayoutAssociation Id : " + layoutAssociation.getId());
									System.out.println("PickListValues LayoutAssociation Name : " + layoutAssociation.getName());
									System.out.println("PickListValues LayoutAssociation APIName : " + layoutAssociation.getAPIName());
								}
							}
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
			String moduleAPIName = "Leads";
			Long fieldId = 34770612619l;
			getPickListValues(fieldId, moduleAPIName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
