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

File: Suit.java - card suit
*/

package minor.cards;

import java.util.Comparator;

public class Suit implements Comparable<Suit> {

  public static final int CLUB_VALUE = 1;
  public static final int DIAMOND_VALUE = 2;
  public static final int HEART_VALUE = 3;
  public static final int SPADE_VALUE = 4;

  public static final Suit CLUBS = new Suit(CLUB_VALUE);
  public static final Suit DIAMONDS = new Suit(DIAMOND_VALUE);
  public static final Suit HEARTS = new Suit(HEART_VALUE);
  public static final Suit SPADES = new Suit(SPADE_VALUE);
  
  public static final Comparator<Suit> REVERSE_COMPARE = 
    new Comparator<Suit>() {
      public int compare(Suit s1, Suit s2) {
        if (s1 == s2)
          return 0;

        return s2.getValue() - s1.getValue();
      }
    };
  
  private int value;

  /**
   * Creates a new suit. Prefer the public static suits
   * over creating new suit objects.
   */
  public Suit(int value) {
    this.value = value;
  }

  /**
   * Get the value of the suit.
   */
  public int getValue() {
    return value;
  }

  /**
   * Compare two suit objects.
   */
  public int compareTo(Suit suit) {
    if (this == suit)
      return 0;

    return this.value - suit.getValue();
  }

  private static String SUIT_NAMES = "cdhs";
  private String name;

  public String toString() {
    if (name == null)
      switch(value) {
      case CLUB_VALUE: name = "c"; break; 
      case DIAMOND_VALUE: name = "d"; break; 
      case HEART_VALUE: name = "h"; break; 
      case SPADE_VALUE: name = "s"; break; 
      }

    return name;
  }
}

