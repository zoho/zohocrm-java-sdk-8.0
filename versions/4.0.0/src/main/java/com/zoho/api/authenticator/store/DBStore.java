package com.zoho.api.authenticator.store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.UserSignature;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.Constants;

public class DBStore implements TokenStore
{
	private String userName;
	private String portNumber;
	private String password;
	private String host;
	private String databaseName;
	private String connectionString;
	private String tableName;

	/**
	 * Creates a DBStore class instance with the specified parameters.
	 * 
	 * @param host         A String containing the DataBase host name.
	 * @param databaseName A String containing the DataBase name.
	 * @param userName     A String containing the DataBase user name.
	 * @param password     A String containing the DataBase password.
	 * @param portNumber   A String containing the DataBase port number.
	 */
	private DBStore(String host, String databaseName, String tableName, String userName, String password, String portNumber)
	{
		this.host = host;
		this.databaseName = databaseName;
		this.tableName = tableName;
		this.userName = userName;
		this.password = password;
		this.portNumber = portNumber;
		this.connectionString = Constants.MYSQL_DRIVER + this.host + ":" + this.portNumber + "/" + this.databaseName + "?allowPublicKeyRetrieval=true&useSSL=false";
	}

	@Override
	public Token findToken(Token token) throws SDKException
	{
		try
		{
			OAuthToken oauthToken = (OAuthToken) token;
			StringBuilder query = new StringBuilder("SELECT * FROM ").append(this.tableName);
			Object param = null;
			if (oauthToken.getUserSignature() != null)
			{
				String name = oauthToken.getUserSignature().getName();
				if (name != null && name.length() > 0)
				{
					query.append(" WHERE user_name = ?");
					param = name;
				}
			}
			else if (oauthToken.getAccessToken() != null && areAllObjectsNull(oauthToken.getClientId(), oauthToken.getClientSecret()))
			{
				query.append(" WHERE access_token = ?");
				param = oauthToken.getAccessToken();
			}
			else if ((oauthToken.getRefreshToken() != null || oauthToken.getGrantToken() != null) && oauthToken.getClientId() != null && oauthToken.getClientSecret() != null)
			{
				if (oauthToken.getGrantToken() != null && oauthToken.getGrantToken().length() > 0)
				{
					query.append(" WHERE grant_token = ?");
					param = oauthToken.getGrantToken();
				}
				else if (oauthToken.getRefreshToken() != null && oauthToken.getRefreshToken().length() > 0)
				{
					query.append(" WHERE refresh_token = ?");
					param = oauthToken.getRefreshToken();
				}
			}
			query.append(" LIMIT 1");
			Class.forName(Constants.JDBC_DRIVER_NAME);
			try (Connection connection = DriverManager.getConnection(connectionString, userName, password))
			{	
				try (PreparedStatement statement = connection.prepareStatement(query.toString()))
				{
					statement.setObject(1, param);
					try (ResultSet result = statement.executeQuery();)
					{
						if (!result.next())
						{
							return null;
						}
						do
						{
							setMergeData(oauthToken, result);
							break;
						}
						while (result.next());
					}
				}
			}
		}
		catch (Exception ex)
		{
			throw new SDKException(Constants.TOKEN_STORE, Constants.GET_TOKEN_DB_ERROR1, ex);
		}
		return token;
	}

	@Override
	public void saveToken(Token token) throws SDKException
	{
		if (!(token instanceof OAuthToken))
		{
			return;
		}

		try
		{
			OAuthToken oauthToken = (OAuthToken) token;
			StringBuilder query = new StringBuilder().append("update ").append(this.tableName).append(" set ");
			Object param = null;
			if (oauthToken.getUserSignature() != null)
			{
				String name = oauthToken.getUserSignature().getName();
				if (name != null && name.length() > 0)
				{
					query.append(setToken(oauthToken)).append(" where user_name = ?");
					param = name;
				}
			}
			else if (oauthToken.getAccessToken() != null && oauthToken.getAccessToken().length() > 0 && areAllObjectsNull(oauthToken.getClientId(), oauthToken.getClientSecret()))
			{
				query.append(setToken(oauthToken)).append(" where access_token = ?");
				param = oauthToken.getAccessToken();
			}
			else if (((oauthToken.getRefreshToken() != null && oauthToken.getRefreshToken().length() > 0) || (oauthToken.getGrantToken() != null && oauthToken.getGrantToken().length() > 0)) && oauthToken.getClientId() != null && oauthToken.getClientSecret() != null)
			{
				if (oauthToken.getGrantToken() != null && oauthToken.getGrantToken().length() > 0)
				{
					query.append(setToken(oauthToken)).append(" where grant_token = ?");
					param = oauthToken.getGrantToken();
				}
				else if (oauthToken.getRefreshToken() != null && oauthToken.getRefreshToken().length() > 0)
				{
					query.append(setToken(oauthToken)).append(" where refresh_token = ?");
					param = oauthToken.getRefreshToken();
				}
			}
			query.append(" limit 1");
			Class.forName(Constants.JDBC_DRIVER_NAME);
			try (Connection connection = DriverManager.getConnection(this.connectionString, this.userName, this.password);)
			{
				int rowaffected = 0;
				try (PreparedStatement statement = connection.prepareStatement(query.toString());) // No i18N
				{
					statement.setObject(1, param);
					rowaffected = statement.executeUpdate();
				}
				if (rowaffected == 0)
				{
					if (oauthToken.getId() != null || oauthToken.getUserSignature() != null)
					{
						if (oauthToken.getRefreshToken() == null && oauthToken.getGrantToken() == null && oauthToken.getAccessToken() == null)
						{
							throw new SDKException(Constants.TOKEN_STORE, Constants.GET_TOKEN_DB_ERROR1);
						}
					}
					if (oauthToken.getId() == null)
					{
						String newId = String.valueOf(generateId());
						oauthToken.setId(newId);
					}
					try (PreparedStatement statement = connection.prepareStatement("insert into " + this.tableName + "(id,user_name,client_id,client_secret,refresh_token,access_token,grant_token,expiry_time,redirect_url,api_domain) values(?,?,?,?,?,?,?,?,?,?) on duplicate key update user_name=values(user_name),client_id=values(client_id),client_secret=values(client_secret),refresh_token=values(refresh_token),access_token=values(access_token),grant_token=values(grant_token),expiry_time=values(expiry_time),redirect_url=values(redirect_url),api_domain=values(api_domain);");) // No i18N
					{
						statement.setString(1, oauthToken.getId());
						statement.setString(2, oauthToken.getUserSignature() != null ? oauthToken.getUserSignature().getName() : null);
						statement.setString(3, oauthToken.getClientId());
						statement.setString(4, oauthToken.getClientSecret());
						statement.setString(5, oauthToken.getRefreshToken());
						statement.setString(6, oauthToken.getAccessToken());
						statement.setString(7, oauthToken.getGrantToken());
						statement.setString(8, oauthToken.getExpiresIn());
						statement.setString(9, oauthToken.getRedirectURL());
						statement.setString(10, oauthToken.getAPIDomain());
						statement.executeUpdate();
					}
				}
			}
		}
		catch (Exception ex)
		{
			throw new SDKException(Constants.TOKEN_STORE, Constants.SAVE_TOKEN_DB_ERROR, ex);
		}
	}

	@Override
	public void deleteToken(String id) throws SDKException
	{
		try
		{
			Class.forName(Constants.JDBC_DRIVER_NAME);
			try (Connection connection = DriverManager.getConnection(this.connectionString, this.userName, this.password);)
			{
				try (PreparedStatement statement = connection.prepareStatement("DELETE FROM " + this.tableName + " WHERE id = ?");)
				{
					statement.setString(1, id);
					statement.executeUpdate();
				}
			}
		}
		catch (Exception ex)
		{
			throw new SDKException(Constants.TOKEN_STORE, Constants.DELETE_TOKEN_DB_ERROR, ex);
		}
	}

	@Override
	public List<Token> getTokens() throws SDKException
	{
		List<Token> tokens = new ArrayList<Token>();
		try
		{
			Class.forName(Constants.JDBC_DRIVER_NAME);
			try (Connection connection = DriverManager.getConnection(connectionString, userName, password);)
			{
				try (Statement statement = connection.createStatement();)
				{
					String query = "select * from " + this.tableName + ";";// No i18N
					try (ResultSet result = statement.executeQuery(query);)
					{
						while (result.next())
						{
							OAuthToken oauthToken = new OAuthToken();
							setMergeData(oauthToken, result);
							tokens.add(oauthToken);
						}
					}
				}
			}
		}
		catch (Exception ex)
		{
			throw new SDKException(Constants.TOKEN_STORE, Constants.GET_TOKENS_DB_ERROR, ex);
		}

		return tokens;
	}

	@Override
	public void deleteTokens() throws SDKException
	{
		try
		{
			Class.forName(Constants.JDBC_DRIVER_NAME);
			try (Connection connection = DriverManager.getConnection(this.connectionString, this.userName, this.password);)
			{
				String query = "delete from " + this.tableName; // No i18N
				try (PreparedStatement statement = connection.prepareStatement(query);)
				{
					statement.executeUpdate();
				}
			}
		}
		catch (Exception ex)
		{
			throw new SDKException(Constants.TOKEN_STORE, Constants.DELETE_TOKENS_DB_ERROR, ex);
		}

	}

	public Token findTokenById(String id) throws SDKException
	{
		try
		{
			Class.forName(Constants.JDBC_DRIVER_NAME);
			try (Connection connection = DriverManager.getConnection(connectionString, userName, password))
			{
				OAuthToken oauthToken = new OAuthToken();
				try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + this.tableName + " WHERE id = ?")) // No i18N
				{
					statement.setString(1, id);
					try (ResultSet result = statement.executeQuery();)
					{
						if (!result.next())
						{
							throw new SDKException(Constants.TOKEN_STORE, Constants.GET_TOKEN_BY_ID_DB_ERROR);
						}
						do
						{
							setMergeData(oauthToken, result);
							return oauthToken;
						}
						while (result.next());
					}
				}
			}
		}
		catch (SDKException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw new SDKException(Constants.TOKEN_STORE, Constants.GET_TOKEN_BY_ID_DB_ERROR, ex);
		}
	}

	private void setMergeData(OAuthToken oauthToken, ResultSet result) throws SQLException, SDKException
	{
		if (oauthToken.getId() == null)
		{
			oauthToken.setId(result.getString(1));
		}
		if (oauthToken.getUserSignature() == null)
		{
			String name = result.getString(2);
			if (name != null)
			{
				oauthToken.setUserSignature(new UserSignature(name));
			}
		}
		if (oauthToken.getClientId() == null)
		{
			oauthToken.setClientId(result.getString(3));
		}
		if (oauthToken.getClientSecret() == null)
		{
			oauthToken.setClientSecret(result.getString(4));
		}
		if (oauthToken.getRefreshToken() == null)
		{
			oauthToken.setRefreshToken(result.getString(5));
		}
		if (oauthToken.getAccessToken() == null)
		{
			oauthToken.setAccessToken(result.getString(6));
		}
		if (oauthToken.getGrantToken() == null)
		{
			oauthToken.setGrantToken(result.getString(7));
		}
		if (oauthToken.getExpiresIn() == null)
		{
			String expiresIn = result.getString(8);
			if (expiresIn != null)
			{
				oauthToken.setExpiresIn(String.valueOf(expiresIn));
			}
		}
		if (oauthToken.getRedirectURL() == null)
		{
			oauthToken.setRedirectURL(result.getString(9));
		}
		if (oauthToken.getAPIDomain() == null)
		{
			oauthToken.setAPIDomain(result.getString(10));
		}
	}

	private String setToken(OAuthToken oauthToken)
	{
		ArrayList<String> query = new ArrayList<String>();
		if (oauthToken.getUserSignature() != null)
		{
			String name = oauthToken.getUserSignature().getName();
			if (name != null && name.length() > 0)
			{
				query.add(setTokenInfo(Constants.USER_NAME, name));
			}
		}
		if (oauthToken.getClientId() != null)
		{
			query.add(setTokenInfo(Constants.CLIENT_ID, oauthToken.getClientId()));
		}
		if (oauthToken.getClientSecret() != null)
		{
			query.add(setTokenInfo(Constants.CLIENT_SECRET, oauthToken.getClientSecret()));
		}
		if (oauthToken.getRefreshToken() != null)
		{
			query.add(setTokenInfo(Constants.REFRESH_TOKEN, oauthToken.getRefreshToken()));
		}
		if (oauthToken.getAccessToken() != null)
		{
			query.add(setTokenInfo(Constants.ACCESS_TOKEN, oauthToken.getAccessToken()));
		}
		if (oauthToken.getGrantToken() != null)
		{
			query.add(setTokenInfo(Constants.GRANT_TOKEN, oauthToken.getGrantToken()));
		}
		if (oauthToken.getExpiresIn() != null)
		{
			query.add(setTokenInfo(Constants.EXPIRY_TIME, oauthToken.getExpiresIn()));
		}
		if (oauthToken.getRedirectURL() != null)
		{
			query.add(setTokenInfo(Constants.REDIRECT_URL, oauthToken.getRedirectURL()));
		}
		if (oauthToken.getAPIDomain() != null)
		{
			query.add(setTokenInfo(Constants.API_DOMAIN, oauthToken.getAPIDomain()));
		}
		return String.join(",", query);
	}

	private String setTokenInfo(String key, String value)
	{
		return new StringBuilder().append(key).append("='").append(value).append("'").toString();
	}

	private int generateId() throws SDKException
	{
		int id = 0;
		try
		{
			Class.forName(Constants.JDBC_DRIVER_NAME);
			try (Connection connection = DriverManager.getConnection(connectionString, userName, password);)
			{
				try (Statement statement = connection.createStatement();)
				{
					String query = "select coalesce(max(`id`), 0) as id from " + this.tableName + ";"; // No i18N
					try (ResultSet result = statement.executeQuery(query);)
					{
						if (result.next() == false)
						{
							return id;
						}
						do
						{
							Integer max = result.getInt(1);
							if (max != null)
							{
								return max + 1;
							}
						}
						while (result.next());
					}
				}
			}
			return id;
		}
		catch (Exception ex)
		{
			throw new SDKException(Constants.TOKEN_STORE, Constants.GENERATE_TOKEN_ID_ERROR, ex);
		}
	}

	public boolean areAllObjectsNull(Object... objects)
	{
		for (Object o : objects)
		{
			if (o != null)
			{
				return false;
			}
		}
		return true;
	}

	public static class Builder
	{
		private String userName = Constants.MYSQL_USER_NAME;
		private String portNumber = Constants.MYSQL_PORT_NUMBER;
		private String password = "";
		private String host = Constants.MYSQL_HOST;
		private String databaseName = Constants.MYSQL_DATABASE_NAME;
		private String tableName = Constants.MYSQL_TABLE_NAME;

		public Builder userName(String userName)
		{
			this.userName = userName;
			return this;
		}

		public Builder portNumber(String portNumber)
		{
			this.portNumber = portNumber;
			return this;
		}

		public Builder password(String password)
		{
			this.password = password;
			return this;
		}

		public Builder host(String host)
		{
			this.host = host;
			return this;
		}

		public Builder databaseName(String databaseName)
		{
			this.databaseName = databaseName;
			return this;
		}

		public Builder tableName(String tableName)
		{
			this.tableName = tableName;
			return this;
		}

		public DBStore build()
		{
			return new DBStore(this.host, this.databaseName, this.tableName, this.userName, this.password, this.portNumber);
		}
	}
}
