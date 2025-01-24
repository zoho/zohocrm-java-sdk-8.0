package samples.reschedulehistory;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.reschedulehistory.APIException;
import com.zoho.crm.api.reschedulehistory.AppointmentName;
import com.zoho.crm.api.reschedulehistory.Approval;
import com.zoho.crm.api.reschedulehistory.Info;
import com.zoho.crm.api.reschedulehistory.RescheduleHistory;
import com.zoho.crm.api.reschedulehistory.RescheduleHistoryOperations;
import com.zoho.crm.api.reschedulehistory.ResponseHandler;
import com.zoho.crm.api.reschedulehistory.ResponseWrapper;
import com.zoho.crm.api.reschedulehistory.User;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetAppointmentRescheduledHistory
{
	public static void getAppointmentRescheduledHistory(Long id) throws Exception
	{
		RescheduleHistoryOperations rescheduleHistoryOperations = new RescheduleHistoryOperations();
		ParameterMap paramInstance = new ParameterMap();
		APIResponse<ResponseHandler> response = rescheduleHistoryOperations.getAppointmentRescheduledHistory(id, paramInstance);
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
					List<RescheduleHistory> data = responseWrapper.getData();
					if (data != null)
					{
						for (RescheduleHistory history : data)
						{
							System.out.println("CurrencySymbol: " + history.getCurrencySymbol());
							System.out.println("reviewProcess: " + history.getReviewProcess());
							System.out.println("rescheduleReason: " + history.getRescheduleReason());
							System.out.println("sharingPermission: " + history.getSharingPermission());
							System.out.println("Name: " + history.getName());
							System.out.println("Review: " + history.getReview());
							System.out.println("State: " + history.getState());
							System.out.println("canvasId: " + history.getCanvasId());
							System.out.println("processFlow: " + history.getProcessFlow());
							System.out.println("ziaVisions: " + history.getZiaVisions());
							System.out.println("approved: " + history.getApproved());
							System.out.println("ziaVisions: " + history.getZiaVisions());
							System.out.println("editable: " + history.getEditable());
							System.out.println("orchestration: " + history.getOrchestration());
							System.out.println("inMerge: " + history.getInMerge());
							System.out.println("approvalState: " + history.getApprovalState());
							System.out.println("rescheduleNote: " + history.getRescheduleNote());
							System.out.println("rescheduledTo: " + history.getRescheduledTo());
							System.out.println("rescheduledTime: " + history.getRescheduledTime());
							System.out.println("rescheduledFrom: " + history.getRescheduledFrom());
							AppointmentName appointmentName = history.getAppointmentName();
							if (appointmentName != null)
							{
								System.out.println("Appointment Name: " + appointmentName.getName());
								System.out.println("Appointmnet Id: " + appointmentName.getId());
							}
							Approval approval = history.getApproval();
							if (approval != null)
							{
								System.out.println("delegate : " + approval.getDelegate());
								System.out.println("approve : " + approval.getApprove());
								System.out.println("reject : " + approval.getReject());
								System.out.println("resubmit : " + approval.getResubmit());
							}
							User modifiedBy = history.getModifiedBy();
							if (modifiedBy != null)
							{
								System.out.println("modifiedBy : " + modifiedBy.getId());
								System.out.println("modifiedBy : " + modifiedBy.getName());
								System.out.println("modifiedBy : " + modifiedBy.getEmail());
							}
							User rescheduledBy = history.getRescheduledBy();
							if (rescheduledBy != null)
							{
								System.out.println("rescheduledBy : " + rescheduledBy.getId());
								System.out.println("rescheduledBy : " + rescheduledBy.getName());
								System.out.println("rescheduledBy" + rescheduledBy.getEmail());
							}
							User createdBy = history.getCreatedBy();
							if (createdBy != null)
							{
								System.out.println("createdBy : " + createdBy.getId());
								System.out.println("createdBy : " + createdBy.getName());
								System.out.println("createdBy : " + createdBy.getEmail());
							}
						}
					}
					Info info = responseWrapper.getInfo();
					
					if (info != null)
					{
						if (info.getPerPage() != null)
						{
							System.out.println("RelatedRecord Info PerPage: " + info.getPerPage().toString());
						}
						if (info.getCount() != null)
						{
							System.out.println("RelatedRecord Info Count: " + info.getCount().toString());
						}
						if (info.getPage() != null)
						{
							System.out.println("RelatedRecord Info Page: " + info.getPage().toString());
						}
						if (info.getMoreRecords() != null)
						{
							System.out.println("RelatedRecord Info MoreRecords: " + info.getMoreRecords().toString());
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
					System.out.println("Message: " + exception.getMessage().getValue());
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
			long id = 3048374923478l;
			getAppointmentRescheduledHistory(id);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
