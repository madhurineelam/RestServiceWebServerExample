package com.gaic.services.submissionsearch.exception;

public class SubmissionSearchException extends RuntimeException
{
	private static final long serialVersionUID = -1892707192744138993L;

	public SubmissionSearchException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public SubmissionSearchException(String message)
	{
		super(message);
	}

	public SubmissionSearchException(Throwable cause)
	{
		super(cause);
	}
}
