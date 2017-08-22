package my.epam.spring.core.loggers;

import my.epam.spring.core.EventLogger;
import my.epam.spring.core.beans.Event;

import java.util.Collection;

/**
 * Created on 8/22/2017.
 */
public class CombinedEventLogger implements EventLogger {
    private Collection<EventLogger> loggers;

    public CombinedEventLogger(Collection<EventLogger> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) throws Exception {
        for (EventLogger logger : loggers) {
            logger.logEvent(event);
        }
    }
}
