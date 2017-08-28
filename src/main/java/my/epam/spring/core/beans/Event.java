package my.epam.spring.core.beans;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

public class Event {
    private int id = new Random().nextInt();
    private String msg;
    private Date date;
    private DateFormat dateFormat;

    public Event(Date date, DateFormat dateFormat) {
        this.date = date;
        this.dateFormat = dateFormat;
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

    public int getId() {
        return id;
    }
}
