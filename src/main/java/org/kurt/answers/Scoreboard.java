package org.kurt.answers;
import java.util.Scanner;

/**
 * Solution to <a href="https://open.kattis.com/problems/basketballoneonone">Problem</a>
 * Found at <a href="https://usaco.guide/general/intro-cp">USACO</a>
 */
class Scoreboard{

  public static void main(String []args){
    Scanner input = new Scanner(System.in);
    String scoreboard = input.nextLine();
    int length = scoreboard.length();
    int aliceScore = 0;
    int barbaraScore = 0;
    for(int i = 0; i<length; i=i+2){
      if(scoreboard.charAt(i) == 'A'){
        aliceScore += Integer.parseInt(String.valueOf(scoreboard.charAt(i+1)));
      }
      else{
        barbaraScore += Integer.parseInt(String.valueOf(scoreboard.charAt(i+1)));
      }
      if(aliceScore >= 11 && aliceScore > barbaraScore+1){
        System.out.print('A');
        return;
      }
      else if(barbaraScore >= 11 && barbaraScore > aliceScore+1){
        System.out.print('B');
        return;
      }
    }
  }

}