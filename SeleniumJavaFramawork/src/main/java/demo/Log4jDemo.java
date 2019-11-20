package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {
	private static Logger logger=LogManager.getLogger(Log4jDemo.class);

	public static void main(String[] args) {
		System.out.println("Hello world...");
		logger.trace("This is a trace log");
		logger.info("This is info message");
		logger.error("This is an error message");
		logger.warn("This is a warning message");
		logger.fatal("This is a fatal message");
		
		System.out.println("\n completed");

	}

}
