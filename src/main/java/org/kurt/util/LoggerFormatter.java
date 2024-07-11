package org.kurt.util;

import java.util.logging.*;

public class LoggerFormatter extends Formatter {
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
}
