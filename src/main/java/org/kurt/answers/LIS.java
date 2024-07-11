package org.kurt.answers;

import static org.kurt.teaches.search.binary.BinarySearch.binarySearch;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.kurt.teaches.nonGenericIntArrays.IntArray;
import org.kurt.util.IntArrayFunction;
import org.kurt.util.LoggerFormatter;

public class LIS {
  public static final Logger LOGGER = Logger.getLogger(LIS.class.getName());

  public static IntArrayFunction longestIncreasingSubsequence;
  public static IntArrayFunction longestIncreasingSubsequenceQuick;

  private LIS() {} // ensures non-instantiability

  static {
    ConsoleHandler handler = new ConsoleHandler();
    handler.setFormatter(new LoggerFormatter());
    LOGGER.addHandler(handler);
    LOGGER.setLevel(Level.INFO);

    longestIncreasingSubsequence =
        seq -> {
          int length = seq.length;
          IntArray longestEndingAtN = new IntArray(new int[length]);
          for (int i = 0; i < length; i++) {
            longestEndingAtN.put(i, 1); // minimally contains itself
            for (int j = 0; j < i; j++) {
              if (seq[j] < seq[i] && longestEndingAtN.get(i) < longestEndingAtN.get(j) + 1) {
                longestEndingAtN.put(i, longestEndingAtN.get(j) + 1);
              }
            }
          }
          return longestEndingAtN.max();
        };

    longestIncreasingSubsequenceQuick =
        seq -> {
          int length = seq.length;
          IntArray answer = new IntArray(new int[] {seq[0]});
          for (int i = 1; i < length; i++) {
            int curr = seq[i];
            if (answer.get(answer.size() - 1) < curr) {
              answer.append(curr);
            } else {
              int index = binarySearch(answer.toArray(), curr);
              // if index is positive it's already in the list, except for corner case of 0
              if (index <= 0) {
                index = index * -1;
                if (answer.get(index) > curr) {
                  answer.put(index, curr);
                }
              }
            }
          }
          return answer.size();
        };
  }
}
