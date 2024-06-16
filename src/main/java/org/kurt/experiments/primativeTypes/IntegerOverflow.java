package org.kurt.experiments.primativeTypes;

import java.util.logging.Logger;
import org.kurt.util.LoggerUtil;

public class IntegerOverflow {
  private static final Logger LOGGER = LoggerUtil.getLogger();

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
