package org.kurt.experiments.list;
import org.kurt.util.LoggerUtil;

import java.util.*;
import java.util.logging.Logger;

/**
 * TODO: Add Sets, Queues, Maps, LinkedList
 *
 *
 */
public class Collections {
  private static final Logger LOGGER = LoggerUtil.getLogger();

  public Collections(){}

  public void arrayListPadding(){
    ArrayList<Integer> arrayList = new ArrayList<>();
    arrayList.add(2);
    arrayList.add(3);
    arrayList.add(4);
    LOGGER.info(String.format("MAX for ArrayList %s, %s", arrayList, java.util.Collections.max(arrayList).toString()));
    ArrayList<Special> specialArrayList = new ArrayList<>();
    specialArrayList.add(new Special(1, "first"));
    specialArrayList.add(new Special(2, "second"));
    specialArrayList.add(new Special(3, "third"));
    LOGGER.info(String.format("MAX for ArrayListSpecial %s, %s", specialArrayList, java.util.Collections.max(specialArrayList).toString()));
  }

  public static void main(String[] args) {
    new Collections().arrayListPadding();
  }

  /**
   * {@code Special} holds a name and rank.
   * The greatest rank is the lowest (1st).
   * Rank cannot be 0 or under.
   */
  public class Special implements Comparable<Special>{
    public int rank;
    public String name;

    public Special(int rank, String name){
      if(rank<=0){
        //if rank provided is no valid, set as minimum rank
        this.rank = Integer.MAX_VALUE;
      }
      else{
        this.rank = rank;
      }
      this.name = name;
    }

    /**
     * Compares two {@code Special} objects numerically.
     * Based on this code from <a href= "https://github.com/openjdk/jdk/blob/master/src/java.base/share/classes/java/lang/Integer.java#L1432">Integer.java</a>:
     * <pre>
     * {@code
     * public int compareTo(Integer anotherInteger) {
     *     return compare(this.value, anotherInteger.value);
     * }
     * public static int compare(int x, int y) {
     *     return (x < y) ? -1 : ((x == y) ? 0 : 1);
     * }
     * }
     * </pre>
     * How is {@code Special.compareTo} different from {@code Integer.compare}?
     * @param   o the {@code Special} to be compared.
     * @return  the value {@code 0} if this {@code Special} is
     *          equal to the argument {@code Special}; a value less than
     *          {@code 0} if this {@code Special} is ranked less
     *          than the argument {@code Special}; and a value greater
     *          than {@code 0} if this {@code Special} is ranked
     *          greater than the argument {@code Special} (signed
     *          comparison).
     */
    @Override
    public int compareTo(Special o) {
      return rank > o.rank ? -1: ((rank == o.rank) ? 0 : 1);
    }

    /**
     * If you do not override the toString of your class
     * then the string representation of your object will simply
     * be the class name and a unique hash.
     *
     * @return {@code String} - rank and name instance variables in a string
     */
    @Override
    public String toString(){
      return String.format("rank: %d, name: %s", rank, name);
    }
  }

}
