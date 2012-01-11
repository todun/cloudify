package org.cloudifysource.esc.installer;

import java.util.logging.Level;

import com.jcraft.jsch.Logger;
 
/**
 * Class to route log messages generated by JSch to Apache Commons Logging.
 *
 * @author mrabbitt
 * @see com.jcraft.jsch.Logger
 */
public class JschJdkLogger implements Logger {
    private java.util.logging.Logger logger;
     
    /**
     * Constructor with custom category name
     *
     * @param logName the category name used by the JDK Logger.
     */
    public JschJdkLogger(java.util.logging.Logger logger) {
    	this.logger = logger;
    }
 
    /* (non-Javadoc)
     * @see com.jcraft.jsch.Logger#isEnabled(int)
     */
    public boolean isEnabled(int level) {
        switch (level) {
        case DEBUG:
            return logger.isLoggable(Level.FINE);
        case INFO:
            return logger.isLoggable(Level.INFO);
        case WARN:
            return logger.isLoggable(Level.WARNING);
        case ERROR:
            return logger.isLoggable(Level.SEVERE);
        case FATAL:
            return logger.isLoggable(Level.SEVERE);
        }
        return false;
    }
 
    /* (non-Javadoc)
     * @see com.jcraft.jsch.Logger#log(int, java.lang.String)
     */
    public void log(int level, String message) {
        switch (level) {
        case DEBUG:
            logger.fine(message);
            break;
        case INFO:
            logger.info(message);
            break;
        case WARN:
            logger.warning(message);
            break;
        case ERROR:
            logger.severe(message);
            break;
        case FATAL:
            logger.severe(message);
            break;
        }
    }
 
}