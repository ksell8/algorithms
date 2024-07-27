package org.kurt.answers;

import java.io.*;
import java.util.StringTokenizer;

/***
 * Solution to <a href="https://cses.fi/problemset/task/1068">Problem.</a>
 * Found at <a href="https://usaco.guide/general/input-output">USACO.</a>
 */
public class WeirdAlgorithm {

  public static void getToOne(long start, PrintWriter pw){
    if(start == 1){
      pw.print(1);
    }else{
      pw.printf("%d ", start);
      if(start%2 == 0){
        getToOne(start/2, pw);
      }else{
        getToOne(start*3+1, pw);
      }
    }
  }

  public static void main(String [] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    StringTokenizer st = new StringTokenizer(br.readLine());
    Long n = Long.parseLong(st.nextToken());

    getToOne(n, pw);
    pw.close();
  }
}
