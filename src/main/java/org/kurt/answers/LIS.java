package org.kurt.answers;

import java.util.Arrays;
import java.util.logging.Logger;
import org.kurt.util.LoggerUtil;
import static org.kurt.teaches.sort.bubblesort.BubbleSort.bubbleSort;
import java.util.ArrayList;
import static org.kurt.teaches.search.binary.BinarySearch.binarySearch;
import org.kurt.util.IntArrayFunction;

public class LIS {
  private static final Logger LOGGER = LoggerUtil.getLogger();
  public static IntArrayFunction longestIncreasingSubsequence;
  public static IntArrayFunction longestIncreasingSubsequenceQuick;
  private LIS(){} //ensures non-instantiability

  static{
    longestIncreasingSubsequence = seq -> {
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
      bubbleSort(longestEndingAtN);
      return longestEndingAtN[length - 1];
    };

    longestIncreasingSubsequenceQuick = seq -> {
      int length = seq.length;
      ArrayList<Integer> answer = new ArrayList<>();
      answer.add(seq[0]);
      for(int i=1; i<length; i++){
        int curr = seq[i];
        if(answer.getLast()<curr){
          answer.add(curr);
        }
        else{
          int index = binarySearch(answer, curr);
          // if index is positive it's already in the list, except for corner case of 0
          if(index <= 0){
            index = index*-1;
            if(answer.get(index) > curr){
              answer.set(index, curr);
            }
          }
        }
      }
      return answer.size();
    };
  }

}
