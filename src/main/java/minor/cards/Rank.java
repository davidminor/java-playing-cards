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

  public static final int ACE_VALUE = 1;
  public static final int TWO_VALUE = 2;
  public static final int THREE_VALUE = 3; 
  public static final int FOUR_VALUE = 4; 
  public static final int FIVE_VALUE = 5; 
  public static final int SIX_VALUE = 6; 
  public static final int SEVEN_VALUE = 7; 
  public static final int EIGHT_VALUE = 8; 
  public static final int NINE_VALUE = 9; 
  public static final int TEN_VALUE = 10; 
  public static final int JACK_VALUE = 11; 
  public static final int QUEEN_VALUE = 12; 
  public static final int KING_VALUE = 13; 

  public static final Rank ACE = new Rank(ACE_VALUE);
  public static final Rank TWO = new Rank(TWO_VALUE);
  public static final Rank THREE = new Rank(THREE_VALUE);
  public static final Rank FOUR = new Rank(FOUR_VALUE);
  public static final Rank FIVE = new Rank(FIVE_VALUE);
  public static final Rank SIX = new Rank(SIX_VALUE);
  public static final Rank SEVEN = new Rank(SEVEN_VALUE);
  public static final Rank EIGHT = new Rank(EIGHT_VALUE);
  public static final Rank NINE = new Rank(NINE_VALUE);
  public static final Rank TEN = new Rank(TEN_VALUE);
  public static final Rank JACK = new Rank(JACK_VALUE);
  public static final Rank QUEEN = new Rank(QUEEN_VALUE);
  public static final Rank KING = new Rank(KING_VALUE);
  
  public static final Comparator<Rank> ACE_HIGH_COMPARATOR =
    new Comparator<Rank>() {
      public int compare(Rank r1, Rank r2) {
        if (r1 == r2)
          return 0;
        int r1Value = r1.getValue();
        int r2Value = r2.getValue();
        if (r1Value == r2Value)
          return 0;
        if (r1Value == ACE_VALUE)
          return 1;
        if (r2Value == ACE_VALUE)
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

  private String name;

  public String toString() {
    if (name == null)
      switch(value) {
      case ACE_VALUE: name = "A"; break;
      case TWO_VALUE: name = "2"; break;
      case THREE_VALUE: name = "3"; break;
      case FOUR_VALUE: name = "4"; break;
      case FIVE_VALUE: name = "5"; break;
      case SIX_VALUE: name = "6"; break;
      case SEVEN_VALUE: name = "7"; break;
      case EIGHT_VALUE: name = "8"; break;
      case NINE_VALUE: name = "9"; break;
      case TEN_VALUE: name = "T"; break;
      case JACK_VALUE: name = "J"; break;
      case QUEEN_VALUE: name = "Q"; break;
      case KING_VALUE: name = "K"; break;
      }
    return name;
  }
}

