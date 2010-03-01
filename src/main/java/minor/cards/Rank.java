/**
Copyright 2010 David Minor

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

File: Rank.java - card rank
*/

package minor.cards;

import java.util.Comparator;

public class Rank implements Comparable<Rank> {

  public static final Rank ACE = new Rank(1);
  public static final Rank TWO = new Rank(2);
  public static final Rank THREE = new Rank(3);
  public static final Rank FOUR = new Rank(4);
  public static final Rank FIVE = new Rank(5);
  public static final Rank SIX = new Rank(6);
  public static final Rank SEVEN = new Rank(7);
  public static final Rank EIGHT = new Rank(8);
  public static final Rank NINE = new Rank(9);
  public static final Rank TEN = new Rank(10);
  public static final Rank JACK = new Rank(11);
  public static final Rank QUEEN = new Rank(12);
  public static final Rank KING = new Rank(13);
  
  public static final Comparator<Rank> ACE_HIGH_COMPARATOR =
    new Comparator<Rank>() {
      public int compare(Rank r1, Rank r2) {
        if (r1 == r2)
          return 0;
        int r1Value = r1.getValue();
        int r2Value = r2.getValue();
        if (r1Value == r2Value)
          return 0;
        int aceValue = Rank.ACE.getValue();
        if (r1Value == aceValue)
          return 1;
        if (r2Value == aceValue)
          return -1;
        return r1Value - r2Value;
      }
    };

  private int value;

  /**
   * Creates a new rank. Prefer the public static ranks
   * over creating new rank objects.
   */
  public Rank(int value) {
    this.value = value;
  }

  /**
   * Get the value of the rank.
   */
  public int getValue() {
    return value;
  }

  /**
   * Compare two rank objects.
   */
  public int compareTo(Rank rank) {
    if (this == rank)
      return 0;

    return this.value - rank.getValue();
  }

  private static String RANK_NAMES = "A23456789TJQK";
  private String name;

  public String toString() {
    if (name == null)
      name = RANK_NAMES.substring(value-1,1);
    return name;
  }
}

