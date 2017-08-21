package my.epam.spring.core;

import my.epam.spring.core.beans.Client;
import my.epam.spring.core.loggers.ConsoleEventLogger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private Client client;
    private EventLogger logger;

    public App(Client client, EventLogger logger) {
        this.client = client;
        this.logger = logger;
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) context.getBean("app");

        app.client = new Client("1", "John Smith");
        app.logger = new ConsoleEventLogger();

        app.logEvent("Some new event for user 1");
        app.logEvent("Some new event for user 2");
    }

    public void logEvent(String msg) {
        /*logger.logEvent(msg.replaceAll(client.getId(), client.getFullName()));*/
    }
}
