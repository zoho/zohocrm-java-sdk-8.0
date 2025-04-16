package com.zoho.api.logger;

/**
 * This class represents the Logger level and log file path.
 */
public class Logger
{
	public static class Builder
	{
		private Levels level;
		private String filePath;

		public Builder()
		{
		}

		public Builder level(Levels level)
		{
			this.level = level;
			return this;
		}

		public Builder filePath(String filePath)
		{
			this.filePath = filePath;
			return this;
		}

		public Logger build()
		{
			return new Logger(level, filePath);
		}
	}

	private String level;
	private String filePath;

	private Logger(Levels level, String filePath)
	{
		this.level = level.name();
		this.filePath = filePath;
	}

	/**
	 * This is a getter method to get logger level.
	 * 
	 * @return A String representing the logger level.
	 */
	public String getLevel()
	{
		return level;
	}

	/**
	 * This is a getter method to get log file path.
	 * 
	 * @return A String representing the Absolute file path, where messages need to be logged.
	 */
	public String getFilePath()
	{
		return filePath;
	}

	/**
	 * This enum used to give logger levels.
	 */
	public static enum Levels
	{
		OFF, FINE, FINEST, WARNING, ALL, FINER, CONFIG, INFO, SEVERE
	}
}
