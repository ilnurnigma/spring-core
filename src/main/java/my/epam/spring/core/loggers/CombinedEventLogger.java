package my.epam.spring.core.loggers;

import my.epam.spring.core.EventLogger;
import my.epam.spring.core.beans.Event;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * Created on 8/22/2017.
 */
@Component("combinedLogger")
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
