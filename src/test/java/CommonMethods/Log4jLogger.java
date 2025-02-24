package CommonMethods;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jLogger {
    public static Logger getLogger(Class<?> classname) {
        return LogManager.getLogger(classname);
    }
}
