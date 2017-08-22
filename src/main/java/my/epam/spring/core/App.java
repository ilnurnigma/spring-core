package my.epam.spring.core;

import my.epam.spring.core.beans.Client;
import my.epam.spring.core.beans.Event;
import my.epam.spring.core.loggers.ConsoleEventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private Client client;
    private EventLogger logger;

    public App(Client client, EventLogger logger) {
        this.client = client;
        this.logger = logger;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) context.getBean("app");

        context.close();
    }

    public void logEvent(String msg) {
//        logger.logEvent();
    }
}
