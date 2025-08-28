package com.jspiders.User_App.Exception;

public class IdNotFoundException  extends RuntimeException
{
	
	
	public IdNotFoundException(String message)
	{
		super(message);
		
	}
	
 /*  @Override
   public String getMessage()
   {
	   return "Invalid id";
   }*/
}
