package samples.entityscores;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.entityscores.APIException;
import com.zoho.crm.api.entityscores.Entity;
import com.zoho.crm.api.entityscores.EntityScores;
import com.zoho.crm.api.entityscores.EntityScoresOperations;
import com.zoho.crm.api.entityscores.ResponseHandler;
import com.zoho.crm.api.entityscores.ResponseWrapper;
import com.zoho.crm.api.entityscores.ScoringRule;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;
import com.zoho.crm.api.dc.DataCenter.Environment;

public class GetEntityScore
{
	public static void getEntityScore(Long recordId) throws Exception
	{
		EntityScoresOperations entityScoresOperations = new EntityScoresOperations(null, null);
		APIResponse<ResponseHandler> response = entityScoresOperations.getEntityScore(recordId);
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
					List<EntityScores> data = responseWrapper.getData();
					if (data != null)
					{
						for (EntityScores score : data)
						{
							Entity entity = score.getEntity();
							if(entity != null)
							{
								com.zoho.crm.api.entityscores.Module module = entity.getModule();
								if (module != null)
								{
									System.out.println("ScoringRule Entity Module APIName : " + module.getAPIName());
									System.out.println("ScoringRule Entity Module Id : " + module.getId());
								}
								System.out.println("ScoringRule Entity Id : " + entity.getId());
								System.out.println("ScoringRule Entity Name : " + entity.getName());
							}
							System.out.println("ScoringRule PositiveScore : " + score.getPositiveScore());
							System.out.println("ScoringRule TouchPointScore : " + score.getTouchPointScore());
							System.out.println("ScoringRule Score : " + score.getScore());
							System.out.println("ScoringRule NegativeScore : " + score.getNegativeScore());
							System.out.println("ScoringRule TouchPointNegativeScore : " + score.getTouchPointNegativeScore());
							ScoringRule scoringRule = score.getScoringRule();
							if (scoringRule != null)
							{
								System.out.println("ScoringRule Id : " + scoringRule.getId());
								System.out.println("ScoringRule Name : " + scoringRule.getName());
							}
							List<String> fieldStates = score.getFieldStates();
							if(fieldStates != null)
							{
								System.out.println("ScoringRule FieldStates : ");
								for (String field : fieldStates)
								{
									System.out.println(field);
								}
							}
							System.out.println("ScoringRule Id : " + score.getId());
							System.out.println("ScoringRule ZiaVisions : " + score.getZiaVisions());
							System.out.println("ScoringRule TouchPointPositiveScore : " + score.getTouchPointPositiveScore());
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
			long recordId = 3475072l;
			getEntityScore(recordId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
