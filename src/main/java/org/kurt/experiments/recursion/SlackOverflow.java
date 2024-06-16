package org.kurt.experiments.recursion;

import java.util.logging.Logger;
import org.kurt.util.LoggerUtil;

public class SlackOverflow {
  private static final Logger LOGGER = LoggerUtil.getLogger();

  private SlackOverflow() {}
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
