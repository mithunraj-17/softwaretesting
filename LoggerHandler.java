package utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.PatternLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggerHandler {

	 private static final Logger logger = Logger.getLogger(LoggerHandler.class);

	    public static Logger getLogger() {
	        return logger;
	    }
 // utils/LoggerHandler
 public static void initLog4j() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
    String timestamp = sdf.format(new Date());

    // Create the appender manually
    DailyRollingFileAppender appender = new DailyRollingFileAppender();
    appender.setFile("logs/logfile_" + timestamp + ".logs");
    appender.setDatePattern("'.'yyyy-MM-dd");
    appender.setLayout(new PatternLayout("%p %d %c %M - %m%n"));
    appender.activateOptions();

    Logger.getRootLogger().addAppender(appender);
}
    public static void logInfo(String message) {
        logger.info(message);
    }

    public static void logDebug(String message) {
        logger.debug(message);
    }

    public static void logWarn(String message) {
        logger.warn(message);
    }

    public static void logError(String message) {
        logger.error(message);
    }

    public static void logFatal(String message) {
        logger.fatal(message);
    }

    public static void logTrace(String message) {
        logger.trace(message);
    }
}
