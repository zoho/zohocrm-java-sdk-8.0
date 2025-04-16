package samples.massconvert;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.massconvert.APIException;
import com.zoho.crm.api.massconvert.ActionResponse;
import com.zoho.crm.api.massconvert.AssignTo;
import com.zoho.crm.api.massconvert.BodyWrapper;
import com.zoho.crm.api.massconvert.MassConvertOperations;
import com.zoho.crm.api.massconvert.MoveAttachmentsTo;
import com.zoho.crm.api.massconvert.RelatedModule;
import com.zoho.crm.api.massconvert.SuccessResponse;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;

public class MassConvert
{
	public static void massConvert() throws Exception
	{
		MassConvertOperations massConvertOperations = new MassConvertOperations();
		BodyWrapper bodyWrapper = new BodyWrapper();
		bodyWrapper.setIds(new ArrayList<Long>(Arrays.asList(347706116634119l)));
		com.zoho.crm.api.record.Record deals = new com.zoho.crm.api.record.Record();
		deals.addFieldValue(com.zoho.crm.api.record.Field.Deals.AMOUNT, 1d);
		deals.addFieldValue(com.zoho.crm.api.record.Field.Deals.DEAL_NAME, "V4SDK");
		deals.addFieldValue(com.zoho.crm.api.record.Field.Deals.CLOSING_DATE, LocalDate.of(2022, 12, 13));
		deals.addFieldValue(com.zoho.crm.api.record.Field.Deals.PIPELINE, new Choice<String>("Standard(Standard)"));
		deals.addFieldValue(com.zoho.crm.api.record.Field.Deals.STAGE, new Choice<String>("Closed Won"));
		bodyWrapper.setDeals(deals);
		MoveAttachmentsTo carryovertags = new MoveAttachmentsTo();
		carryovertags.setId(3652397002179l);
		carryovertags.setAPIName("Contacts");
		bodyWrapper.setCarryOverTags(new ArrayList<MoveAttachmentsTo>(Arrays.asList(carryovertags)));
		List<RelatedModule> related_modules = new ArrayList<>();
		RelatedModule relatedmodule = new RelatedModule();
		relatedmodule.setAPIName("Tasks");
		relatedmodule.setId(3652397002193l);
		related_modules.add(relatedmodule);
		bodyWrapper.setRelatedModules(related_modules);
		AssignTo assign_to = new AssignTo();
		assign_to.setId(3652397281001l);
		bodyWrapper.setAssignTo(assign_to);
		MoveAttachmentsTo move_attachments_to = new MoveAttachmentsTo();
		move_attachments_to.setAPIName("Contacts");
		move_attachments_to.setId(3652397002179l);
//		bodyWrapper.setMoveAttachmentsTo(move_attachments_to);
		APIResponse<ActionResponse> response = massConvertOperations.massConvert(bodyWrapper);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionResponse actionHandler = response.getObject();
				if (actionHandler instanceof SuccessResponse)
				{
					SuccessResponse successResponse = (SuccessResponse) actionHandler;
					System.out.println("Status: " + successResponse.getStatus().getValue());
					System.out.println("Code: " + successResponse.getCode().getValue());
					System.out.println("Details: ");
					for (Map.Entry<String, Object> entry : successResponse.getDetails().entrySet())
					{
						System.out.println(entry.getKey() + ": " + entry.getValue());
					}
					System.out.println("Message: " + successResponse.getMessage());
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
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			massConvert();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
