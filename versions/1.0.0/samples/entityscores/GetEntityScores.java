package samples.entityscores;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.HeaderMap;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.entityscores.APIException;
import com.zoho.crm.api.entityscores.Entity;
import com.zoho.crm.api.entityscores.EntityScores;
import com.zoho.crm.api.entityscores.EntityScoresOperations;
import com.zoho.crm.api.entityscores.Info;
import com.zoho.crm.api.entityscores.ResponseHandler;
import com.zoho.crm.api.entityscores.ResponseWrapper;
import com.zoho.crm.api.entityscores.ScoringRule;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;
import com.zoho.crm.api.dc.DataCenter.Environment;

public class GetEntityScores
{
	public static void getEntityScores() throws Exception
	{
		EntityScoresOperations entityScoresOperations = new EntityScoresOperations("Positive_Score", null);
		APIResponse<ResponseHandler> response = entityScoresOperations.getEntityScores(new ParameterMap(), new HeaderMap());
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
									System.out.println("EntityScores Entity Module APIName : " + module.getAPIName());
									System.out.println("EntityScores Entity Module Id : " + module.getId());
								}
								System.out.println("EntityScores Entity Id : " + entity.getId());
								System.out.println("EntityScores Entity Name : " + entity.getName());
							}
							System.out.println("EntityScores PositiveScore : " + score.getPositiveScore());
							System.out.println("EntityScores TouchPointScore : " + score.getTouchPointScore());
							System.out.println("EntityScores Score : " + score.getScore());
							System.out.println("EntityScores NegativeScore : " + score.getNegativeScore());
							System.out.println("EntityScores TouchPointNegativeScore : " + score.getTouchPointNegativeScore());
							ScoringRule scoringRule = score.getScoringRule();
							if (scoringRule != null)
							{
								System.out.println("EntityScores ScoringRule Id : " + scoringRule.getId());
								System.out.println("EntityScores ScoringRule Name : " + scoringRule.getName());
							}
							List<String> fieldStates = score.getFieldStates();
							if(fieldStates != null)
							{
								System.out.println("EntityScores FieldStates : ");
								for (String field : fieldStates)
								{
									System.out.println(field);
								}
							}
							System.out.println("EntityScores Id : " + score.getId());
							System.out.println("EntityScores ZiaVisions : " + score.getZiaVisions());
							System.out.println("EntityScores TouchPointPositiveScore : " + score.getTouchPointPositiveScore());
						}
					}
					Info info = responseWrapper.getInfo();
					if (info != null)
					{
						if (info.getPerPage() != null)
						{
							System.out.println("Info PerPage: " + info.getPerPage());
						}
						if (info.getNextPageToken() != null)
						{
							System.out.println("Info NextPageToken: " + info.getNextPageToken());
						}
						if (info.getCount() != null)
						{
							System.out.println("Info Count: " + info.getCount());
						}
						if (info.getSortBy() != null)
						{
							System.out.println("Info SortBy: " + info.getSortBy());
						}
						if (info.getPage() != null)
						{
							System.out.println("Info Page: " + info.getPage());
						}
						if (info.getPreviousPageToken() != null)
						{
							System.out.println("Info PreviousPageToken: " + info.getPreviousPageToken());
						}
						if (info.getPageTokenExpiry() != null)
						{
							System.out.println("Info PageTokenExpiry: " + info.getPageTokenExpiry());
						}
						if (info.getSortOrder() != null)
						{
							System.out.println("Info SortOrder: " + info.getSortOrder());
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
			getEntityScores();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
