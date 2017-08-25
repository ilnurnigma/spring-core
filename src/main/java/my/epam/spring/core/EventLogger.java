package my.epam.spring.core;

import my.epam.spring.core.beans.Event;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component("eventLogger")
public interface EventLogger {
    void logEvent(Event event) throws Exception;
}
