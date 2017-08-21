package my.epam.spring.core.loggers;

import my.epam.spring.core.EventLogger;
import my.epam.spring.core.beans.Event;

public class ConsoleEventLogger implements EventLogger {
    @Override
    public void logEvent(Event event) {
        System.out.println(event);
    }
}
