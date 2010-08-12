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

File: Card.java - basic playing card
*/

package minor.cards;

import java.util.Comparator;

public class Card implements Comparable<Card> {

  public static final Card $AC = new Card(Rank.ACE, Suit.CLUBS);
  public static final Card $AD = new Card(Rank.ACE, Suit.DIAMONDS);
  public static final Card $AH = new Card(Rank.ACE, Suit.HEARTS);
  public static final Card $AS = new Card(Rank.ACE, Suit.SPADES);
  public static final Card $2C = new Card(Rank.TWO, Suit.CLUBS);
  public static final Card $2D = new Card(Rank.TWO, Suit.DIAMONDS);
  public static final Card $2H = new Card(Rank.TWO, Suit.HEARTS);
  public static final Card $2S = new Card(Rank.TWO, Suit.SPADES);
  public static final Card $3C = new Card(Rank.THREE, Suit.CLUBS);
  public static final Card $3D = new Card(Rank.THREE, Suit.DIAMONDS);
  public static final Card $3H = new Card(Rank.THREE, Suit.HEARTS);
  public static final Card $3S = new Card(Rank.THREE, Suit.SPADES);
  public static final Card $4C = new Card(Rank.FOUR, Suit.CLUBS);
  public static final Card $4D = new Card(Rank.FOUR, Suit.DIAMONDS);
  public static final Card $4H = new Card(Rank.FOUR, Suit.HEARTS);
  public static final Card $4S = new Card(Rank.FOUR, Suit.SPADES);
  public static final Card $5C = new Card(Rank.FIVE, Suit.CLUBS);
  public static final Card $5D = new Card(Rank.FIVE, Suit.DIAMONDS);
  public static final Card $5H = new Card(Rank.FIVE, Suit.HEARTS);
  public static final Card $5S = new Card(Rank.FIVE, Suit.SPADES);
  public static final Card $6C = new Card(Rank.SIX, Suit.CLUBS);
  public static final Card $6D = new Card(Rank.SIX, Suit.DIAMONDS);
  public static final Card $6H = new Card(Rank.SIX, Suit.HEARTS);
  public static final Card $6S = new Card(Rank.SIX, Suit.SPADES);
  public static final Card $7C = new Card(Rank.SEVEN, Suit.CLUBS);
  public static final Card $7D = new Card(Rank.SEVEN, Suit.DIAMONDS);
  public static final Card $7H = new Card(Rank.SEVEN, Suit.HEARTS);
  public static final Card $7S = new Card(Rank.SEVEN, Suit.SPADES);
  public static final Card $8C = new Card(Rank.EIGHT, Suit.CLUBS);
  public static final Card $8D = new Card(Rank.EIGHT, Suit.DIAMONDS);
  public static final Card $8H = new Card(Rank.EIGHT, Suit.HEARTS);
  public static final Card $8S = new Card(Rank.EIGHT, Suit.SPADES);
  public static final Card $9C = new Card(Rank.NINE, Suit.CLUBS);
  public static final Card $9D = new Card(Rank.NINE, Suit.DIAMONDS);
  public static final Card $9H = new Card(Rank.NINE, Suit.HEARTS);
  public static final Card $9S = new Card(Rank.NINE, Suit.SPADES);
  public static final Card $TC = new Card(Rank.TEN, Suit.CLUBS);
  public static final Card $TD = new Card(Rank.TEN, Suit.DIAMONDS);
  public static final Card $TH = new Card(Rank.TEN, Suit.HEARTS);
  public static final Card $TS = new Card(Rank.TEN, Suit.SPADES);
  public static final Card $JC = new Card(Rank.JACK, Suit.CLUBS);
  public static final Card $JD = new Card(Rank.JACK, Suit.DIAMONDS);
  public static final Card $JH = new Card(Rank.JACK, Suit.HEARTS);
  public static final Card $JS = new Card(Rank.JACK, Suit.SPADES);
  public static final Card $QC = new Card(Rank.QUEEN, Suit.CLUBS);
  public static final Card $QD = new Card(Rank.QUEEN, Suit.DIAMONDS);
  public static final Card $QH = new Card(Rank.QUEEN, Suit.HEARTS);
  public static final Card $QS = new Card(Rank.QUEEN, Suit.SPADES);
  public static final Card $KC = new Card(Rank.KING, Suit.CLUBS);
  public static final Card $KD = new Card(Rank.KING, Suit.DIAMONDS);
  public static final Card $KH = new Card(Rank.KING, Suit.HEARTS);
  public static final Card $KS = new Card(Rank.KING, Suit.SPADES);
  
  private Rank rank;
  private Suit suit;

  /**
   * Creates a new card. Prefer the public static cards
   * over creating new card objects. See also get().
   */
  public Card(Rank rank, Suit suit) {
    this.rank = rank;
    this.suit = suit;
  }

  /**
   * Retrieve a static instance of the card by name. E.g., "As" returns $AS. 
   * Not case sensitive. Characters beyond the first two are ignored.
   */
  public static Card get(String cardName) {
	if (cardName == null || cardName.length() < 2)
	  return null;
	switch (cardName.charAt(0)) {
	case 'a': case 'A':
		switch (cardName.charAt(1)) {
		case 's': case 'S': return $AS;
		case 'h': case 'H': return $AH;
		case 'd': case 'D': return $AD;
		case 'c': case 'C': return $AC;
		}
		break;
	case '2':
		switch (cardName.charAt(1)) {
		case 's': case 'S': return $2S;
		case 'h': case 'H': return $2H;
		case 'd': case 'D': return $2D;
		case 'c': case 'C': return $2C;
		}
		break;
	case '3':
		switch (cardName.charAt(1)) {
		case 's': case 'S': return $3S;
		case 'h': case 'H': return $3H;
		case 'd': case 'D': return $3D;
		case 'c': case 'C': return $3C;
		}
		break;
	case '4':
		switch (cardName.charAt(1)) {
		case 's': case 'S': return $4S;
		case 'h': case 'H': return $4H;
		case 'd': case 'D': return $4D;
		case 'c': case 'C': return $4C;
		}
		break;
	case '5':
		switch (cardName.charAt(1)) {
		case 's': case 'S': return $5S;
		case 'h': case 'H': return $5H;
		case 'd': case 'D': return $5D;
		case 'c': case 'C': return $5C;
		}
		break;
	case '6':
		switch (cardName.charAt(1)) {
		case 's': case 'S': return $6S;
		case 'h': case 'H': return $6H;
		case 'd': case 'D': return $6D;
		case 'c': case 'C': return $6C;
		}
		break;
	case '7':
		switch (cardName.charAt(1)) {
		case 's': case 'S': return $7S;
		case 'h': case 'H': return $7H;
		case 'd': case 'D': return $7D;
		case 'c': case 'C': return $7C;
		}
		break;
	case '8':
		switch (cardName.charAt(1)) {
		case 's': case 'S': return $8S;
		case 'h': case 'H': return $8H;
		case 'd': case 'D': return $8D;
		case 'c': case 'C': return $8C;
		}
		break;
	case '9':
		switch (cardName.charAt(1)) {
		case 's': case 'S': return $9S;
		case 'h': case 'H': return $9H;
		case 'd': case 'D': return $9D;
		case 'c': case 'C': return $9C;
		}
		break;
	case 't': case 'T':
		switch (cardName.charAt(1)) {
		case 's': case 'S': return $TS;
		case 'h': case 'H': return $TH;
		case 'd': case 'D': return $TD;
		case 'c': case 'C': return $TC;
		}
		break;
	case 'j': case 'J':
		switch (cardName.charAt(1)) {
		case 's': case 'S': return $JS;
		case 'h': case 'H': return $JH;
		case 'd': case 'D': return $JD;
		case 'c': case 'C': return $JC;
		}
		break;
	case 'q': case 'Q':
		switch (cardName.charAt(1)) {
		case 's': case 'S': return $QS;
		case 'h': case 'H': return $QH;
		case 'd': case 'D': return $QD;
		case 'c': case 'C': return $QC;
		}
		break;
	case 'k': case 'K':
		switch (cardName.charAt(1)) {
		case 's': case 'S': return $KS;
		case 'h': case 'H': return $KH;
		case 'd': case 'D': return $KD;
		case 'c': case 'C': return $KC;
		}
		break;
	}
	return null;
  }
  
  /**
   * Get the rank of the card.
   */
  public Rank getRank() {
    return rank;
  }

  /**
   * Get the suit of the card.
   */
  public Suit getSuit() {
    return suit;
  }

  /**
   * Compare to cards.
   */
  public int compareTo(Card card) {
    if (this == card)
      return 0;

    int comp = rank.compareTo(card.getRank());
    if (comp != 0)
      return comp;

    return suit.compareTo(card.getSuit());
  }

  public static final Comparator<Card> ACE_HIGH_COMPARATOR = new Comparator<Card>() {
	public int compare(Card card1, Card card2) {
	  if (card1 == card2)
	    return 0;
	  
	  int comp = Rank.ACE_HIGH_COMPARATOR.compare(card1.getRank(), card2.getRank());
	  if (comp != 0)
		return comp;
	  
	  return card1.getSuit().compareTo(card2.getSuit());
	}
  };
  
  private String name;

  public String toString() {
    if (name == null)
      name = rank.toString() + suit.toString();
    
    return name;
  }
}

