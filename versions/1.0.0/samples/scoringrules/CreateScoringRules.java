package samples.scoringrules;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.scoringrules.APIException;
import com.zoho.crm.api.scoringrules.ActionHandler;
import com.zoho.crm.api.scoringrules.ActionResponse;
import com.zoho.crm.api.scoringrules.ActionWrapper;
import com.zoho.crm.api.scoringrules.BodyWrapper;
import com.zoho.crm.api.scoringrules.Criteria;
import com.zoho.crm.api.scoringrules.FieldRule;
import com.zoho.crm.api.scoringrules.Layout;
import com.zoho.crm.api.scoringrules.ScoringRulesOperations;
import com.zoho.crm.api.scoringrules.Signal;
import com.zoho.crm.api.scoringrules.SignalRule;
import com.zoho.crm.api.scoringrules.SuccessResponse;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class CreateScoringRules
{
	public static void createScoringRules() throws Exception
	{
		ScoringRulesOperations scoringRulesOperations = new ScoringRulesOperations();
		BodyWrapper bodyWrapper = new BodyWrapper();
		List<com.zoho.crm.api.scoringrules.ScoringRule> scoringRules = new ArrayList<com.zoho.crm.api.scoringrules.ScoringRule>();
		com.zoho.crm.api.scoringrules.ScoringRule scoringRule = new com.zoho.crm.api.scoringrules.ScoringRule();
		scoringRule.setName("Rule 10");
		scoringRule.setDescription("Rule for Module Leads");
		com.zoho.crm.api.modules.Modules module = new com.zoho.crm.api.modules.Modules();
		module.setAPIName("Leads");
		module.setId(440248001216009l);
		scoringRule.setModule(module);
		Layout layout = new Layout();
		layout.setAPIName("Standard");
		layout.setId(4402480167l);
		scoringRule.setLayout(layout);
		scoringRule.setActive(false);
		List<FieldRule> fieldRules = new ArrayList<FieldRule>();
		FieldRule fieldRule = new FieldRule();
		fieldRule.setScore(10);
		Criteria criteria = new Criteria();
		criteria.setGroupOperator("or");
		List<Criteria> group = new ArrayList<Criteria>();
		Criteria criteria1 = new Criteria();
		com.zoho.crm.api.scoringrules.Field field1 = new com.zoho.crm.api.scoringrules.Field();
		field1.setAPIName("Company");
		criteria1.setField(field1);
		criteria1.setComparator("equal");
		criteria1.setValue("zoho");
		group.add(criteria1);
		Criteria criteria2 = new Criteria();
		com.zoho.crm.api.scoringrules.Field field2 = new com.zoho.crm.api.scoringrules.Field();
		field2.setAPIName("Designation");
		criteria2.setField(field1);
		criteria2.setComparator("equal");
		criteria2.setValue("review");
		group.add(criteria2);
		criteria.setGroup(group);
		fieldRule.setCriteria(criteria);
		fieldRules.add(fieldRule);
		scoringRule.setFieldRules(fieldRules);
		List<SignalRule> signalRules = new ArrayList<SignalRule>();
		SignalRule signalRule = new SignalRule();
		signalRule.setId("4836976111233");
		signalRule.setScore(10);
		Signal signal = new Signal();
		signal.setId(4876876112019L);
		signal.setNamespace("Email_Incoming__s");
		signalRule.setSignal(signal);
		signalRules.add(signalRule);
		scoringRule.setSignalRules(signalRules);
		scoringRules.add(scoringRule);
		bodyWrapper.setScoringRules(scoringRules);
		APIResponse<ActionHandler> response = scoringRulesOperations.createScoringRules(bodyWrapper);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ActionWrapper)
				{
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
					List<ActionResponse> actionResponses = actionWrapper.getScoringRules();
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
							System.out.println("Message: " + successResponse.getMessage().getValue());
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
							System.out.println("Message: " + exception.getMessage().getValue());
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
					System.out.println("Message: " + exception.getMessage().getValue());
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
			createScoringRules();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
