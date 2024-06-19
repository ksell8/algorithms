package org.kurt.util;

import java.util.logging.*;
import org.kurt.teaches.Fibonacci;

public class LoggerUtil {
  public static final Logger LOGGER = Logger.getLogger(Fibonacci.class.getName());

  static {
    ConsoleHandler handler = new ConsoleHandler();
    handler.setFormatter(
        new SimpleFormatter() {
          private static final String format = "[%1$tF %1$tT] [%2$s] [%3$s] %4$s %n";

          @Override
          public synchronized String format(LogRecord record) {
            return String.format(
                format,
                new java.util.Date(record.getMillis()),
                record.getLevel().getLocalizedName(),
                Thread.currentThread().getName(),
                formatMessage(record));
          }
        });
    LOGGER.addHandler(handler);
    LOGGER.setLevel(Level.INFO);
  }

  public static Logger getLogger() {
    return LOGGER;
  }
}
