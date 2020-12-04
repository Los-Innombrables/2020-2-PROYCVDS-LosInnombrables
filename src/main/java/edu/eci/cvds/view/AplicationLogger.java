package edu.eci.cvds.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AplicationLogger {

    private Logger loggerApp;

    public AplicationLogger(){
        loggerApp = LoggerFactory.getLogger(AplicationLogger.class);
    }

    public Logger getLoggerApp() {
        return loggerApp;
    }

    public void setLoggerApp(Logger loggerApp) {
        this.loggerApp = loggerApp;
    }

}
