package samples.scoringrules;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.scoringrules.APIException;
import com.zoho.crm.api.scoringrules.Criteria;
import com.zoho.crm.api.scoringrules.FieldRule;
import com.zoho.crm.api.scoringrules.Info;
import com.zoho.crm.api.scoringrules.Layout;
import com.zoho.crm.api.scoringrules.ResponseHandler;
import com.zoho.crm.api.scoringrules.ResponseWrapper;
import com.zoho.crm.api.scoringrules.ScoringRulesOperations;
import com.zoho.crm.api.scoringrules.Signal;
import com.zoho.crm.api.scoringrules.SignalRule;
import com.zoho.crm.api.users.MinifiedUser;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetScoringRule
{
	public static void getScoringRule(Long id) throws Exception
	{
		ScoringRulesOperations scoringRulesOperations = new ScoringRulesOperations();
		ParameterMap paramInstance = new ParameterMap();
		APIResponse<ResponseHandler> response = scoringRulesOperations.getScoringRule(id, paramInstance);
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
					List<com.zoho.crm.api.scoringrules.ScoringRule> scoringRules = responseWrapper.getScoringRules();
					for (com.zoho.crm.api.scoringrules.ScoringRule scoringRule : scoringRules)
					{
						Layout layout = scoringRule.getLayout();
						if (layout != null)
						{
							System.out.println("ScoringRule Layout ID: " + layout.getId());
							System.out.println("ScoringRule Layout APIName: " + layout.getAPIName());
						}
						System.out.println("ScoringRule CreatedTime: " + scoringRule.getCreatedTime());
						System.out.println("ScoringRule ModifiedTime: " + scoringRule.getModifiedTime());
						List<FieldRule> fieldRules = scoringRule.getFieldRules();
						for (FieldRule fieldRule : fieldRules)
						{
							System.out.println("ScoringRule FieldRule Score: " + fieldRule.getScore());
							Criteria criteria = fieldRule.getCriteria();
							if (criteria != null)
							{
								printCriteria(criteria);
							}
							System.out.println("ScoringRule FieldRule Id: " + fieldRule.getId());
						}
						com.zoho.crm.api.modules.Modules module1 = scoringRule.getModule();
						if (module1 != null)
						{
							System.out.println("ScoringRule Module ID: " + module1.getId());
							System.out.println("ScoringRule Module APIName: " + module1.getAPIName());
						}
						System.out.println("ScoringRule Name: " + scoringRule.getName());
						MinifiedUser modifiedBy = scoringRule.getModifiedBy();
						if (modifiedBy != null)
						{
							System.out.println("ScoringRule Modified By Name : " + modifiedBy.getName());
							System.out.println("ScoringRule Modified By id : " + modifiedBy.getId());
						}
						System.out.println("ScoringRule Active: " + scoringRule.getActive());
						System.out.println("ScoringRule Description: " + scoringRule.getDescription());
						System.out.println("ScoringRule Id: " + scoringRule.getId());
						List<SignalRule> signalRules = scoringRule.getSignalRules();
						if (signalRules != null)
						{
							for (SignalRule signalRule : signalRules)
							{
								System.out.println("ScoringRule SignalRule Score: " + signalRule.getScore());
								System.out.println("ScoringRule SignalRule Id: " + signalRule.getId());
								Signal signal = signalRule.getSignal();
								if (signal != null)
								{
									System.out.println("ScoringRule SignalRule Signal Namespace: " + signal.getNamespace());
									System.out.println("ScoringRule SignalRule Signal Id: " + signal.getId());
								}
							}
						}
						MinifiedUser createdBy = scoringRule.getCreatedBy();
						if (createdBy != null)
						{
							System.out.println("ScoringRule Created By Name : " + createdBy.getName());
							System.out.println("ScoringRule Created By id : " + createdBy.getId());
						}
					}
					Info info = responseWrapper.getInfo();
					if (info != null)
					{
						if (info.getPerPage() != null)
						{
							System.out.println("Info PerPage: " + info.getPerPage().toString());
						}
						if (info.getCount() != null)
						{
							System.out.println("Info Count: " + info.getCount().toString());
						}
						if (info.getPage() != null)
						{
							System.out.println("Info Page: " + info.getPage());
						}
						if (info.getMoreRecords() != null)
						{
							System.out.println("Info MoreRecords: " + info.getMoreRecords().toString());
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
			else if (response.getStatusCode() != 204)
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

	private static void printCriteria(Criteria criteria)
	{
		if (criteria.getComparator() != null)
		{
			System.out.println("CustomView Criteria Comparator: " + criteria.getComparator());
		}
		if (criteria.getField() != null)
		{
			System.out.println("CustomView Criteria field name: " + criteria.getField().getAPIName());
		}
		if (criteria.getValue() != null)
		{
			System.out.println("CustomView Criteria Value: " + criteria.getValue().toString());
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
			System.out.println("CustomView Criteria Group Operator: " + criteria.getGroupOperator());
		}
	}

	public static void main(String[] args)
	{
		try
		{
			Environment environment = USDataCenter.PRODUCTION;
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").redirectURL("Redirect_URL").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			Long id = 440248001310044l;
			getScoringRule(id);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
