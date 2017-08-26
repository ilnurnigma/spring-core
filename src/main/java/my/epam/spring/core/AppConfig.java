package my.epam.spring.core;

import my.epam.spring.core.loggers.CombinedEventLogger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource(
        value={"classpath:client.properties"},
        ignoreResourceNotFound = true)
public class AppConfig {
    @Bean
    public Map<EventType, EventLogger> loggerMap(EventLogger eventLogger) {
        HashMap<EventType, EventLogger> map = new HashMap<EventType, EventLogger>();
        map.put(EventType.INFO, eventLogger);
        return map;
    }

    /**
     * Property placeholder configurer needed to process @Value annotations
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public Collection<EventLogger> eventLoggers(EventLogger eventLogger) {
        ArrayList<EventLogger> loggers = new ArrayList<EventLogger>();
        loggers.add(eventLogger);
        return loggers;

    }

}
