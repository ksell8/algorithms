package org.kurt.experiments.list;
import org.kurt.util.LoggerUtil;

import java.util.*;
import java.util.logging.Logger;

public class ArrayLists {
  private static final Logger LOGGER = LoggerUtil.getLogger();

  public ArrayLists(){}

  public void arrayListPadding(){
    ArrayList<Integer> arrayList = new ArrayList<>();
    arrayList.add(2);
    arrayList.add(3);
    arrayList.add(4);
    LOGGER.info(String.format("MAX for ArrayList %s, %s", arrayList,Collections.max(arrayList).toString()));
    ArrayList<Special> specialArrayList = new ArrayList<>();
    specialArrayList.add(new Special(1, "first"));
    specialArrayList.add(new Special(2, "second"));
    specialArrayList.add(new Special(3, "third"));
    LOGGER.info(String.format("MAX for ArrayListSpecial %s, %s", specialArrayList,Collections.max(specialArrayList).toString()));
  }

  public static void main(String[] args) {
    new ArrayLists().arrayListPadding();
  }

  public class Special implements Comparable<Special>{
    public int rank;
    public String name;

    public Special(int rank, String name){
      this.rank = rank;
      this.name = name;
    }

    @Override
    public int compareTo(Special o) {
      return Integer.compare(o.rank, rank);
    }

    @Override
    public String toString(){
      return String.format("rank: %d, name: %s", rank, name);
    }
  }

}
