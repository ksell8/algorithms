package org.kurt.answers;
import static org.kurt.util.Math.max;

public class LCS {
  private LCS(){}

  public static int LCS(String x, String y){
    int xLength = x.length();
    int yLength = y.length();
    char[] xCharArray = x.toCharArray();
    char[] yCharArray = y.toCharArray();
    int[][] longestCommon = new int[xLength+1][yLength+1];
    for(int i=1; i<=xLength; i++){
      for(int j=1; j<=yLength; j++){
        if(xCharArray[i-1] == yCharArray[j-1]){
          longestCommon[i][j] = 1 + longestCommon[i-1][j-1];
        }else{
          longestCommon[i][j] = max(longestCommon[i-1][j], longestCommon[i][j-1]);
        }
      }
    }
    return longestCommon[xLength][yLength];
  }
}
