package my.epam.spring.core.beans;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

@Component
public class Event {
    private int id = new Random().nextInt();
    private String msg;
    private Date date;
    private DateFormat dateFormat;

    public Event() {
        this.date = new Date();
        this.dateFormat = DateFormat.getDateTimeInstance();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + dateFormat.format(date) +
                '}';
    }
}
