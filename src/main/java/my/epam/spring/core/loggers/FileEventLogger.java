package my.epam.spring.core.loggers;

import my.epam.spring.core.EventLogger;
import my.epam.spring.core.beans.Event;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

/**
 * Created on 8/22/2017.
 */
@Component("fileLogger")
public class FileEventLogger implements EventLogger {

    private String fileName;
    private File file;

    @Autowired
    public FileEventLogger(@Value("log.txt")String fileName) {
        this.fileName = fileName;
    }

    @PostConstruct
    public void init() throws IOException {
        file = new File(fileName);
        if (!file.canWrite()) {
            throw new IOException();
        }
    }

    @Override
    public void logEvent(Event event) throws IOException {
        FileUtils.writeStringToFile(file, event.toString() + "\n", true);
    }
}
