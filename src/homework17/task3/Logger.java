package homework17.task3;

import java.io.FileWriter;
import java.util.Date;

public class Logger {
    private static Logger logger;

    enum Level {
        FATAL,
        ERROR,
        WARN,
        INFO,
        DEBUG
    }

    private Logger() {
    }

    private void log(String message, Level level) {
        try (FileWriter fileWriter = new FileWriter("./src/homework17/task3/LoggerFile", true)) {
            Date date = new Date();
            fileWriter.write(level + ": " + date + ": " + message + '\n');
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fatal(String message) {
        log(message, Level.FATAL);
    }

    public void error(String message) {
        log(message, Level.ERROR);
    }

    public void warn(String message) {
        log(message, Level.WARN);
    }

    public void info(String message) {
        log(message, Level.INFO);
    }

    public void debug(String message) {
        log(message, Level.DEBUG);
    }

    public static Logger getLogger() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }
}
