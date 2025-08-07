package samples.threading.multiuser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.api.authenticator.store.DBStore;
import com.zoho.api.authenticator.store.TokenStore;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.record.RecordOperations;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.record.RecordOperations.GetRecordsParam;
import com.zoho.crm.api.ParameterMap;

public class SingleThread
{
	Environment environment;
	Token token;
	String moduleAPIName;

	public SingleThread(String moduleAPIName)
	{
		this.moduleAPIName = moduleAPIName;
	}

	public SingleThread(Environment environment, Token token, String moduleAPIName)
	{
		this.environment = environment;
		this.token = token;
		this.moduleAPIName = moduleAPIName;
	}

	public void run()
	{
		try
		{
			new Initializer.Builder().environment(environment).token(token).switchUser();
			RecordOperations cro = new RecordOperations(this.moduleAPIName);
			ParameterMap paramInstance = new ParameterMap();
			List<String> fieldNames = new ArrayList<String>(Arrays.asList("Company", "Email"));
			paramInstance.add(GetRecordsParam.FIELDS, String.join(",", fieldNames));
			@SuppressWarnings("rawtypes")
			APIResponse getResponse = cro.getRecords(paramInstance, null);
			System.out.println(getResponse.getObject());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception
	{
		Environment env = USDataCenter.PRODUCTION;
		TokenStore tokenstore = new DBStore.Builder().build();
		Token token1 = new OAuthToken.Builder().clientID("1000.xxxx").clientSecret("xxx").refreshToken("1000.xxx.xx").redirectURL("https://www.zoho.com").build();
		new Initializer.Builder().environment(env).token(token1).store(tokenstore).initialize();
		SingleThread singleThread = new SingleThread(env, token1, "Students");
		singleThread.run();
		Environment environment = USDataCenter.PRODUCTION;
		Token token2 = new OAuthToken.Builder().clientID("1000.xxxxx").clientSecret("xxxx").refreshToken("1000.xxx.xxx").build();
		singleThread = new SingleThread(environment, token2, "Leads");
		singleThread.run();
	}
}
