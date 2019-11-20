package demo;

public class ExceptionHandlingDemo {

	public static void main(String[] args) {
		demo();
		
		}

	
	
	
	public static void demo()
	{
		try
	{
	System.out.println("Hello world...");
	
	int i=1/0;
	System.out.println("completed");
	}
	catch(Exception exp)
	{
		System.out.println("Inside catch block");
		System.out.println("Message is "+exp.getMessage());
		System.out.println("Cause is "+exp.getCause());
		exp.printStackTrace();
	}
	finally
	{
		System.out.println("Inside finally block");
		
	}

}
}