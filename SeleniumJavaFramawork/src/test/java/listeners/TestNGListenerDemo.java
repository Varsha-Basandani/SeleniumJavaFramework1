package listeners;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.SkipException;



public class TestNGListenerDemo {
	
	@Test(priority=1)
	public void test1()
	{
		System.out.println("I am inside test1");
	}
	@Test(priority=2)
	public void test2()
	{
		System.out.println("I am inside test2");
		//Assert.assertTrue(false);
	
	}
	@Test(priority=0)
	public void test3()
	{
		System.out.println("I am inside test3");
		throw new SkipException("This test is skipped ");
	}


}
