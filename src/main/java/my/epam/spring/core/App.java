package my.epam.spring.core;

import my.epam.spring.core.beans.Client;
import my.epam.spring.core.beans.Event;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class App {
    private Client client;
    private EventLogger defaultLogger;
    private Map<EventType, EventLogger> loggers;
    private static ConfigurableApplicationContext context;

    public App(Client client, EventLogger defaultLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.defaultLogger = defaultLogger;
        this.loggers = loggers;
    }

    public static void main(String[] args) throws Exception {
        context = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App) context.getBean("app");
        app.logEvent(EventType.INFO, "My some message1");
        app.logEvent(EventType.ERROR, "My some message2");

        context.close();
    }

    public void logEvent(EventType eventType, String msg) throws Exception {
        EventLogger logger = loggers.get(eventType);
        if (logger == null) {
            logger = defaultLogger;
        }

        Event event = (Event) context.getBean("event");
        event.setMsg(msg);
        logger.logEvent(event);

    }
}
