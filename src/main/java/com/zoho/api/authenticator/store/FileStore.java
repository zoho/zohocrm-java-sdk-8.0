package com.zoho.api.authenticator.store;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.UserSignature;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.Constants;

public class FileStore implements TokenStore
{
	private String filePath;
	private String[] headers = new String[] { Constants.ID, Constants.USER_NAME, Constants.CLIENT_ID, Constants.CLIENT_SECRET, Constants.REFRESH_TOKEN, Constants.ACCESS_TOKEN, Constants.GRANT_TOKEN, Constants.EXPIRY_TIME, Constants.REDIRECT_URL, Constants.API_DOMAIN };

	/**
	 * Creates an FileStore class instance with the specified parameters.
	 * 
	 * @param filePath A String containing the absolute file path to store tokens.
	 * @throws Exception if a problem occurs.
	 */
	public FileStore(String filePath) throws Exception
	{
		this.filePath = filePath;
		boolean isCreate = false;
		try (CSVWriter csvWriter = new CSVWriter(new FileWriter(new File(this.filePath), true)); FileReader fileReader = new FileReader(this.filePath);)
		{
			if (fileReader.read() == -1)
			{
				isCreate = true;
				csvWriter.writeNext(this.headers);
			}
			csvWriter.flush();
		}

		if (!isCreate)
		{
			try (CSVReader csvReader = new CSVReader(new FileReader(this.filePath)))
			{
				List<String[]> allContents = csvReader.readAll();
				String[] headers = allContents.get(0);
				if (headers.length == 9)
				{
					allContents = allContents.stream().map(arr -> Arrays.copyOf(arr, arr.length + 1)).collect(Collectors.toList());
					allContents.set(0, this.headers);
					try (CSVWriter csvWriter = new CSVWriter(new FileWriter(new File(this.filePath)));)
					{
						csvWriter.writeAll(allContents);
						csvWriter.flush();
					}
				}
			}
		}
	}

	@Override
	public Token findToken(Token token) throws SDKException
	{
		if (!(token instanceof OAuthToken))
		{
			return token;
		}
		try (CSVReader csvReader = new CSVReader(new FileReader(this.filePath)))
		{
			OAuthToken oauthToken = (OAuthToken) token;
			List<String[]> allContents = csvReader.readAll();
			Boolean isRowPresent = Boolean.FALSE;
			for (int index = 1; index < allContents.size(); index++)
			{
				String[] nextRecord = allContents.get(index);
				if (nextRecord.length > 1)
				{
					isRowPresent = checkCondition(oauthToken, nextRecord);
					if (isRowPresent)
					{
						setMergeData(oauthToken, nextRecord);
						return oauthToken;
					}
				}
			}
			if (!isRowPresent)
			{
				return null;
			}
		}
		catch (Exception ex)
		{
			throw new SDKException(Constants.TOKEN_STORE, Constants.GET_TOKEN_FILE_ERROR1, ex);
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
		try (CSVReader csvReader = new CSVReader(new FileReader(this.filePath)))
		{
			Boolean isRowPresent = Boolean.FALSE;
			OAuthToken oauthToken = (OAuthToken) token;
			List<String[]> allContents = csvReader.readAll();
			for (int index = 1; index < allContents.size(); index++)
			{
				String[] nextRecord = allContents.get(index);
				if (nextRecord.length > 1)
				{
					if (oauthToken.getId() != null)
					{
						String id = getData(nextRecord[0]);
						if (id != null && oauthToken.getId() != null && id.equals(oauthToken.getId()))
						{
							isRowPresent = Boolean.TRUE;
						}
					}
					else
					{
						isRowPresent = checkCondition(oauthToken, nextRecord);
					}

					if (isRowPresent)
					{
						setMergeData(oauthToken, nextRecord);
						allContents.set(index, setToken(oauthToken));
						break;
					}
				}
				else
				{
					allContents.remove(index);
				}
			}

			if (!isRowPresent)
			{
				if (oauthToken.getId() != null || oauthToken.getUserSignature() != null)
				{
					if (oauthToken.getRefreshToken() == null && oauthToken.getGrantToken() == null && oauthToken.getAccessToken() == null)
					{
						throw new SDKException(Constants.TOKEN_STORE, Constants.GET_TOKEN_FILE_ERROR1);
					}
				}

				if (oauthToken.getId() == null)
				{
					String newId = generateId(allContents);
					oauthToken.setId(newId);
				}
				allContents.add(setToken(oauthToken));
			}

			try (CSVWriter csvWriter = new CSVWriter(new FileWriter(new File(this.filePath)));)
			{
				csvWriter.writeAll(allContents);
			}
		}
		catch (SDKException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw new SDKException(Constants.TOKEN_STORE, Constants.SAVE_TOKEN_FILE_ERROR, ex);
		}
	}

	@Override
	public void deleteToken(String id) throws SDKException
	{
		try (CSVReader csvReader = new CSVReader(new FileReader(new File(this.filePath)));)
		{
			Boolean isRowPresent = Boolean.FALSE;
			List<String[]> allContents = csvReader.readAll();
			for (int index = 1; index < allContents.size(); index++)
			{
				String[] nextRecord = allContents.get(index);
				if (nextRecord.length > 1)
				{
					String recordId = getData(nextRecord[0]);
					if (recordId != null && recordId.equals(id))
					{
						isRowPresent = Boolean.TRUE;
						allContents.remove(index);
						break;
					}
				}
			}
			try (CSVWriter csvWriter = new CSVWriter(new FileWriter(new File(this.filePath)));)
			{
				csvWriter.writeAll(allContents);
			}
			if (!isRowPresent)
			{
				throw new SDKException(Constants.TOKEN_STORE, Constants.TOKEN_BY_ID_FILE_ERROR);
			}
		}
		catch (SDKException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw new SDKException(Constants.TOKEN_STORE, Constants.DELETE_TOKEN_FILE_ERROR, ex);
		}
	}

	@Override
	public List<Token> getTokens() throws SDKException
	{
		List<Token> tokens = new ArrayList<Token>();
		try (CSVReader csvReader = new CSVReader(new FileReader(this.filePath)))
		{
			List<String[]> allContents = csvReader.readAll();
			for (int index = 1; index < allContents.size(); index++)
			{
				String[] nextRecord = allContents.get(index);
				if (nextRecord.length > 1)
				{
					OAuthToken oauthToken = new OAuthToken();
					setMergeData(oauthToken, nextRecord);
					tokens.add(oauthToken);
				}
			}
		}
		catch (Exception ex)
		{
			throw new SDKException(Constants.TOKEN_STORE, Constants.GET_TOKENS_FILE_ERROR, ex);
		}
		return tokens;
	}

	@Override
	public void deleteTokens() throws SDKException
	{
		try (CSVWriter csvWriter = new CSVWriter(new FileWriter(new File(this.filePath), false));)
		{
			csvWriter.writeNext(this.headers);
			csvWriter.flush();
		}
		catch (Exception ex)
		{
			throw new SDKException(Constants.TOKEN_STORE, Constants.DELETE_TOKENS_FILE_ERROR, ex);
		}
	}

	@Override
	public Token findTokenById(String id) throws SDKException
	{
		try (CSVReader csvReader = new CSVReader(new FileReader(this.filePath)))
		{
			OAuthToken oauthToken = new OAuthToken();
			List<String[]> allContents = csvReader.readAll();
			Boolean isRowPresent = Boolean.FALSE;
			for (int index = 1; index < allContents.size(); index++)
			{
				String[] nextRecord = allContents.get(index);
				if (nextRecord[0].equals(id))
				{
					isRowPresent = Boolean.TRUE;
					setMergeData(oauthToken, nextRecord);
					return oauthToken;
				}
			}
			if (!isRowPresent)
			{
				throw new SDKException(Constants.TOKEN_STORE, Constants.TOKEN_BY_ID_FILE_ERROR);
			}
		}
		catch (SDKException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw new SDKException(Constants.TOKEN_STORE, Constants.TOKEN_BY_ID_FILE_ERROR, ex);
		}
		return null;
	}

	private Boolean checkCondition(OAuthToken oauthToken, String[] nextRecord)
	{
		Boolean isRowPresent = Boolean.FALSE;
		if (oauthToken.getUserSignature() != null)
		{
			String name = oauthToken.getUserSignature().getName();
			String userName = getData(nextRecord[1]);
			if (name != null && name.length() > 0 && userName != null && userName.length() > 0 && name.equals(userName))
			{
				isRowPresent = Boolean.TRUE;
			}
		}
		else if (oauthToken.getAccessToken() != null && areAllObjectsNull(oauthToken.getClientId(), oauthToken.getClientSecret()))
		{
			String accessToken = getData(nextRecord[5]);
			if (accessToken != null && accessToken.length() > 0 && oauthToken.getAccessToken().length() > 0 && oauthToken.getAccessToken().equals(accessToken))
			{
				isRowPresent = Boolean.TRUE;
			}
		}
		else if ((oauthToken.getRefreshToken() != null || oauthToken.getGrantToken() != null) && oauthToken.getClientId() != null && oauthToken.getClientSecret() != null)
		{
			String grantToken = getData(nextRecord[6]);
			String refreshToken = getData(nextRecord[4]);
			if (grantToken != null && grantToken.length() > 0 && oauthToken.getGrantToken() != null && oauthToken.getGrantToken().length() > 0 && oauthToken.getGrantToken().equals(grantToken))
			{
				isRowPresent = Boolean.TRUE;
			}
			else if (refreshToken != null && refreshToken.length() > 0 && oauthToken.getRefreshToken() != null && oauthToken.getRefreshToken().length() > 0 && oauthToken.getRefreshToken().equals(refreshToken))
			{
				isRowPresent = Boolean.TRUE;
			}
		}
		return isRowPresent;
	}

	private String getData(String value)
	{
		return (value != null && !value.isEmpty() && value.length() > 0) ? value : null;
	}

	private void setMergeData(OAuthToken oauthToken, String[] nextRecord) throws SDKException
	{
		if (oauthToken.getId() == null)
		{
			oauthToken.setId(getData(nextRecord[0]));
		}
		if (oauthToken.getUserSignature() == null)
		{
			String name = getData(nextRecord[1]);
			if (name != null)
			{
				oauthToken.setUserSignature(new UserSignature(name));
			}
		}
		if (oauthToken.getClientId() == null)
		{
			oauthToken.setClientId(getData(nextRecord[2]));
		}
		if (oauthToken.getClientSecret() == null)
		{
			oauthToken.setClientSecret(getData(nextRecord[3]));
		}
		if (oauthToken.getRefreshToken() == null)
		{
			oauthToken.setRefreshToken(getData(nextRecord[4]));
		}
		if (oauthToken.getAccessToken() == null)
		{
			oauthToken.setAccessToken(getData(nextRecord[5]));
		}
		if (oauthToken.getGrantToken() == null)
		{
			oauthToken.setGrantToken(getData(nextRecord[6]));
		}
		if (oauthToken.getExpiresIn() == null)
		{
			String expiresIn = getData(nextRecord[7]);
			if (expiresIn != null)
			{
				oauthToken.setExpiresIn(String.valueOf(expiresIn));
			}
		}
		if (oauthToken.getRedirectURL() == null)
		{
			oauthToken.setRedirectURL(getData(nextRecord[8]));
		}
		if (oauthToken.getAPIDomain() == null)
		{
			oauthToken.setAPIDomain(getData(nextRecord[9]));
		}
	}

	private String[] setToken(OAuthToken oauthToken)
	{
		String[] data = new String[10];
		data[0] = oauthToken.getId();
		data[1] = oauthToken.getUserSignature() != null ? oauthToken.getUserSignature().getName() : null;
		data[2] = oauthToken.getClientId();
		data[3] = oauthToken.getClientSecret();
		data[4] = oauthToken.getRefreshToken();
		data[5] = oauthToken.getAccessToken();
		data[6] = oauthToken.getGrantToken();
		data[7] = oauthToken.getExpiresIn();
		data[8] = oauthToken.getRedirectURL();
		data[9] = oauthToken.getAPIDomain();
		return data;
	}

	private String generateId(List<String[]> allContents)
	{
		int maxValue = 0;
		if (allContents.size() > 1)
		{
			for (int index = 1; index < allContents.size(); index++)
			{
				String[] nextRecord = allContents.get(index);
				if (nextRecord.length > 1 && nextRecord[0] != null && nextRecord[0].length() > 0)
				{
					if (maxValue < Integer.parseInt(nextRecord[0]))
					{
						maxValue = Integer.parseInt(nextRecord[0]);
					}
				}
			}
		}
		return String.valueOf(maxValue + 1);
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
}
