package my.epam.spring.core.loggers;

import my.epam.spring.core.EventLogger;
import my.epam.spring.core.beans.Event;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;

public class DBLogger implements EventLogger {
    private JdbcTemplate jdbcTemplate;

    @Override
    public void logEvent(Event event) throws Exception {
        jdbcTemplate.update("INSERT INTO t_event (id, msg) VALUES (?, ?)", event.getId(), event.getMsg());
        Integer integer = jdbcTemplate.queryForObject("select count(*) from t_event", Integer.class);
        System.out.println(integer);
    }

    public void init() {
        jdbcTemplate.execute("CREATE TABLE t_event (id INTEGER, msg VARCHAR(255))");
    }

    public void destroy() {
        System.out.println("table:");
        Event msg = jdbcTemplate.queryForObject("SELECT * FROM t_event",
                new RowMapper<Event>() {
                    @Override
                    public Event mapRow(ResultSet resultSet, int i) throws SQLException {
                        Event event = new Event(new Date(), DateFormat.getDateTimeInstance());
                        event.setMsg(resultSet.getString("msg"));
                        return event;
                    }
                });

        System.out.println(msg);
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
