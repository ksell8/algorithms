package you.code;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.kurt.util.LoggerFormatter;

public class LIS {
  public static final Logger LOGGER = Logger.getLogger(LIS.class.getName());

  static {
    ConsoleHandler handler = new ConsoleHandler();
    handler.setFormatter(new LoggerFormatter());
    LOGGER.addHandler(handler);
    LOGGER.setLevel(Level.INFO);
  }

  private LIS() {} // ensures non-instantiability (static functions only)

  public static int longestIncreasingSubsequence(int[] seq) {
    return 0;
  }
}
