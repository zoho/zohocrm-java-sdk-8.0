package samples.userstransferanddelete;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.userstransferdelete.APIException;
import com.zoho.crm.api.userstransferdelete.ActionHandler;
import com.zoho.crm.api.userstransferdelete.ActionResponse;
import com.zoho.crm.api.userstransferdelete.ActionWrapper;
import com.zoho.crm.api.userstransferdelete.BodyWrapper;
import com.zoho.crm.api.userstransferdelete.MoveSubordinate;
import com.zoho.crm.api.userstransferdelete.SuccessResponse;
import com.zoho.crm.api.userstransferdelete.Transfer;
import com.zoho.crm.api.userstransferdelete.TransferAndDelete;
import com.zoho.crm.api.userstransferdelete.UsersTransferDeleteOperations;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class UserTransferAndDelete
{
	public static void userTransferAndDelete(Long id) throws Exception
	{
		UsersTransferDeleteOperations usersTransferDeleteOperations = new UsersTransferDeleteOperations();
		BodyWrapper request = new BodyWrapper();
		ArrayList<TransferAndDelete> transferAndDeletes = new ArrayList<TransferAndDelete>();
		TransferAndDelete transferAndDelete = new TransferAndDelete();
		Transfer transfer = new Transfer();
		transfer.setRecords(true);
		transfer.setAssignment(true);
		transfer.setCriteria(false);
		transfer.setId(34349178323l);
		transferAndDelete.setTransfer(transfer);
		MoveSubordinate moveSubordinate = new MoveSubordinate();
		moveSubordinate.setId(323234872984342l);
		transferAndDelete.setMoveSubordinate(moveSubordinate);
		transferAndDeletes.add(transferAndDelete);
		request.setTransferAndDelete(transferAndDeletes);
		APIResponse<ActionHandler> response = usersTransferDeleteOperations.userTransferAndDelete(id, request);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ActionWrapper)
				{
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
					List<ActionResponse> actionResponses = actionWrapper.getTransferAndDelete();
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
			long id = 3376487238733l;
			userTransferAndDelete(id);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
