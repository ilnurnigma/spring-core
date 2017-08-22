package my.epam.spring.core;

import my.epam.spring.core.beans.Event;

import java.io.IOException;

public interface EventLogger {
    void logEvent(Event event) throws Exception;
}
