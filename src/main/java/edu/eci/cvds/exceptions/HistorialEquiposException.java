package edu.eci.cvds.exceptions;

import edu.eci.cvds.view.AplicationLogger;

public class HistorialEquiposException extends Exception{

    private AplicationLogger aplicationLogger = new AplicationLogger();

    public HistorialEquiposException(String message) {
        aplicationLogger.getLoggerApp().error(message);
    }

}
