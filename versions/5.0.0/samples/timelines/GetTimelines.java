package samples.timelines;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.timelines.APIException;
import com.zoho.crm.api.timelines.AutomationDetail;
import com.zoho.crm.api.timelines.FieldHistory;
import com.zoho.crm.api.timelines.FieldHistoryValue;
import com.zoho.crm.api.timelines.Module;
import com.zoho.crm.api.timelines.NameIdStructure;
import com.zoho.crm.api.timelines.PicklistDetail;
import com.zoho.crm.api.timelines.Record;
import com.zoho.crm.api.timelines.RelatedRecord;
import com.zoho.crm.api.timelines.ResponseHandler;
import com.zoho.crm.api.timelines.ResponseWrapper;
import com.zoho.crm.api.timelines.Timeline;
import com.zoho.crm.api.timelines.TimelinesOperations;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetTimelines
{
	public static void getTimelines(String module, String recordId) throws Exception
	{
		TimelinesOperations timelinesoperations = new TimelinesOperations();
		ParameterMap paramInstance = new ParameterMap();
		APIResponse<ResponseHandler> response = timelinesoperations.getTimelines(module, recordId, paramInstance);
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
					List<Timeline> timelines = responseWrapper.getTimeline();
					if (timelines != null)
					{
						for (Timeline timeline : timelines)
						{
							NameIdStructure doneBy = timeline.getDoneBy();
							if (doneBy != null)
							{
								System.out.println("DoneBy Name: " + doneBy.getName());
								System.out.println("DoneBy Id: " + doneBy.getId());
							}
							RelatedRecord relatedRecord = timeline.getRelatedRecord();
							if (relatedRecord != null)
							{
								System.out.println("RelatedRecord Id: " + relatedRecord.getId().toString());
								System.out.println("RelatedRecord Name: " + relatedRecord.getName());
								NameIdStructure module1 = relatedRecord.getModule();
								System.out.println("Module : ");
								if (module1 != null)
								{
									System.out.println("RelatedRecord Module Name: " + module1.getName());
									System.out.println("RelatedRecord Module Id: " + module1.getId());
								}
							}
							AutomationDetail automationDetails = timeline.getAutomationDetails();
							if (automationDetails != null)
							{
								System.out.println("automationdetails type: " + automationDetails.getType());
								NameIdStructure rule = automationDetails.getRule();
								if (rule != null)
								{
									System.out.println("automationDetails Rule Name :" + rule.getName());
									System.out.println("automationDetails Rule Id :" + rule.getId());
								}
							}
							Record record1 = timeline.getRecord();
							if (record1 != null)
							{
								System.out.println("Record Id: " + record1.getId());
								System.out.println("Record Name: " + record1.getName());
								Module module2 = record1.getModule();
								System.out.println("Module : ");
								if (module2 != null)
								{
									System.out.println("Record Module Name: " + module2.getAPIName());
									System.out.println("Record Module Id: " + module2.getId());
								}
							}
							System.out.println("auditedTime : " + timeline.getAuditedTime());
							System.out.println("action : " + timeline.getAction());
							System.out.println("Timeline Id: " + timeline.getId());
							System.out.println("source: " + timeline.getSource());
							System.out.println("extension: " + timeline.getExtension());
							System.out.println("Type:: " + timeline.getType());
							List<FieldHistory> fieldHistory = timeline.getFieldHistory();
							if (fieldHistory != null)
							{
								for (FieldHistory history : fieldHistory)
								{
									System.out.println("FieldHistory dataType: " + history.getDataType());
									System.out.println("FieldHistory enableColourCode: " + history.getEnableColourCode());
									System.out.println("FieldHistory fieldLabel: " + history.getFieldLabel());
									System.out.println("FieldHistory apiName: " + history.getAPIName());
									System.out.println("FieldHistory id: " + history.getId());
									FieldHistoryValue value = history.getValue();
									if (value != null)
									{
										System.out.println("new :" + value.getNew());
										System.out.println("old :" + value.getOld());
									}
									List<PicklistDetail> pickListValues = history.getPickListValues();
									if (pickListValues != null)
									{
										for (PicklistDetail pickListValue : pickListValues)
										{
											System.out.println("picklistvalue DisplayValue : " + pickListValue.getDisplayValue());
											System.out.println("picklistvalue sequenceNumber : " + pickListValue.getSequenceNumber());
											System.out.println("picklistvalue colourCode : " + pickListValue.getColourCode());
											System.out.println("picklistvalue actualValue : " + pickListValue.getActualValue());
											System.out.println("picklistvalue id : " + pickListValue.getId());
											System.out.println("picklistvalue type : " + pickListValue.getType());
										}
									}
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
			String module = "leads";
			String recordId = "440248001310027";
			getTimelines(module, recordId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
