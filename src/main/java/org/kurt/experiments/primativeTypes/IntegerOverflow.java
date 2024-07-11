package org.kurt.experiments.primativeTypes;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.kurt.util.LoggerFormatter;

public class IntegerOverflow {
  public static final Logger LOGGER = Logger.getLogger(IntegerOverflow.class.getName());

  static {
    ConsoleHandler handler = new ConsoleHandler();
    handler.setFormatter(new LoggerFormatter());
    LOGGER.addHandler(handler);
    LOGGER.setLevel(Level.INFO);
  }

  private IntegerOverflow() {}

  public static void integerOverflow() {
    int maxInt = Integer.MAX_VALUE; // 2^31 - 1
    int overflowInt = (int) Math.pow(2, 31) + 1; // This will overflow
    LOGGER.info(String.format("Maximum int value (2^31 - 1): %d", maxInt));
    LOGGER.warning(String.format("2^31+1 as an int (overflow): %d", overflowInt));
  }

  public static void main(String[] args) {
    integerOverflow();
  }
}
