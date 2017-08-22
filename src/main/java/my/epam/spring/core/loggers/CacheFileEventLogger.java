package my.epam.spring.core.loggers;

import my.epam.spring.core.beans.Event;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 8/22/2017.
 */
public class CacheFileEventLogger extends FileEventLogger {
    private int cacheSize;
    private List<Event> cache = new ArrayList<Event>();

    public CacheFileEventLogger(String fileName, int cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
    }

    @Override
    public void logEvent(Event event) throws IOException {
        cache.add(event);

        if (cache.size() >= cacheSize) {
            writeEventFromCache();
        }
    }

    private void writeEventFromCache() throws IOException {
        for (Event event : cache) {
            super.logEvent(event);
        }
        cache.clear();
    }

    public void destroy() throws IOException {
        writeEventFromCache();
    }
}
