package com.sample.basics;

public class CustomUnCheckedException extends RuntimeException
{

    private static final long serialVersionUID = 1997753363232807009L;

		public CustomUnCheckedException()
		{
		}

		public CustomUnCheckedException(String message)
		{
			super(message);
		}

		public CustomUnCheckedException(Throwable cause)
		{
			super(cause);
		}

		public CustomUnCheckedException(String message, Throwable cause)
		{
			super(message, cause);
		}

		public CustomUnCheckedException(String message, Throwable cause, 
                                           boolean enableSuppression, boolean writableStackTrace)
		{
			super(message, cause, enableSuppression, writableStackTrace);
		}

}