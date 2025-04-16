package samples.customstore;

import java.util.List;

import com.zoho.api.authenticator.Token;
import com.zoho.api.authenticator.store.TokenStore;
import com.zoho.crm.api.exception.SDKException;

public class CustomStore implements TokenStore
{

	@Override
	public Token findToken(Token token) throws SDKException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Token findTokenById(String id) throws SDKException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveToken(Token token) throws SDKException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteToken(String id) throws SDKException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public List<Token> getTokens() throws SDKException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTokens() throws SDKException
	{
		// TODO Auto-generated method stub

	}

}
