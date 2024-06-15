package org.kurt.answers;

import java.util.Arrays;
import java.util.logging.Logger;
import org.kurt.util.LoggerUtil;

public class LIS {
  private static final Logger LOGGER = LoggerUtil.getLogger();

  public static int longestIncreasingSubsequence(int[] seq) {
    int length = seq.length;
    int[] longestEndingAtN = new int[length];
    for (int i = 0; i < length; i++) {
      longestEndingAtN[i] = 1; // minimally contains itself
      for (int j = 0; j < i; j++) {
        if (seq[j] < seq[i] && longestEndingAtN[i] < longestEndingAtN[j] + 1) {
          longestEndingAtN[i] = longestEndingAtN[j] + 1;
        }
      }
    }
    Arrays.sort(longestEndingAtN);
    return longestEndingAtN[length - 1];
  }
}
