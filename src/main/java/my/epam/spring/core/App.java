package my.epam.spring.core;

import my.epam.spring.core.beans.Client;
import my.epam.spring.core.beans.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

@Component
public class App {
    @Autowired
    private Client client;


    private EventLogger defaultLogger;
    private Map<EventType, EventLogger> loggers;
    private static AnnotationConfigApplicationContext context;

    public App(Client client, @Qualifier("cacheFileLogger") EventLogger defaultLogger, @Qualifier("loggerMap") Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.defaultLogger = defaultLogger;
        this.loggers = loggers;
    }

    public static void main(String[] args) throws Exception {
//        context = new ClassPathXmlApplicationContext("spring.xml");
        context = new AnnotationConfigApplicationContext();
//        context.register(AppConfig.class);
        context.scan("my.epam.spring.core");
        context.refresh();

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

        System.out.println(client);
        Event event = (Event) context.getBean("event");
        msg = client.getGreeting() + " " + msg.replace(client.getId(), client.getFullName());
        event.setMsg(msg);
        logger.logEvent(event);

    }
}
