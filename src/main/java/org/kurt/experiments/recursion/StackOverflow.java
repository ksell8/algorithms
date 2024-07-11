package org.kurt.experiments.recursion;


import org.kurt.util.LoggerFormatter;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StackOverflow {
  public static final Logger LOGGER = Logger.getLogger(StackOverflow.class.getName());

  static {
    ConsoleHandler handler = new ConsoleHandler();
    handler.setFormatter(new LoggerFormatter());
    LOGGER.addHandler(handler);
    LOGGER.setLevel(Level.INFO);
  }

  private StackOverflow() {}
  ;

  public static void recursionExperiment(int depth) {
    try {
      recursionExperiment(depth + 1);
    } catch (StackOverflowError e) {
      LOGGER.severe("Stack Overflow at recursion depth: " + depth);
    }
  }

  public static void main(String[] args) {
    recursionExperiment(0);
  }
}
