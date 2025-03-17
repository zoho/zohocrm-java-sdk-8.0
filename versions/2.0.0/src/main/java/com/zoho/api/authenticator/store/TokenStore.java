package com.zoho.api.authenticator.store;

import java.util.List;

import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.exception.SDKException;

/**
 * This interface stores the user token details.
 */
public interface TokenStore
{
	public Token findToken(Token token) throws SDKException;

	public Token findTokenById(String id) throws SDKException;

	public void saveToken(Token token) throws SDKException;

	public void deleteToken(String id) throws SDKException;

	public List<Token> getTokens() throws SDKException;

	public void deleteTokens() throws SDKException;
}
