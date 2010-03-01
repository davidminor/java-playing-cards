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

File: Deck.java - deck of playing cards
*/

package minor.cards;

import java.util.Random;
import java.util.Comparator;
import java.util.Arrays;
import static minor.cards.Card.*;

public class Deck implements Cloneable {
  
  private int cardIndex;
  private Random random;
  private Card [] cards;
  private int [] discardIndex;
  private int maxRank;
  private int maxSuit;

  private static class NotEnoughCardsException extends RuntimeException {

  }
  
  private static final Deck STANDARD = new Deck(
      $AC, $AD, $AH, $AS, $2C, $2D, $2H, $2S,
      $3C, $3D, $3H, $3S, $4C, $4D, $4H, $4S,
      $5C, $5D, $5H, $5S, $6C, $6D, $6H, $6S,
      $7C, $7D, $7H, $7S, $8C, $8D, $8H, $8S,
      $9C, $9D, $9H, $9S, $TC, $TD, $TH, $TS,
      $JC, $JD, $JH, $JS, $QC, $QD, $QH, $QS,
      $KC, $KD, $KH, $KS
  ); 

  /**
   * Returns a standard deck of playing cards.
   *
   * @return standard deck
   */
  public static Deck getStandardDeck() {
    try {
      Deck standard = (Deck)STANDARD.clone();
      standard.shuffle();
      return standard;
    } catch(CloneNotSupportedException cnse) {
      //should never happen
      return null;
    }
  }
  
  /**
   * Constructor for new deck. See also getStandardDeck().
   * 
   * @param cards cards included in deck
   */
  public Deck(Card ... cards) {
    this.cards = cards;

    //Sparse array for discard index
    maxRank = 0;
    maxSuit = 0;
    for(Card card : cards) {
      if (maxRank < card.getRank().getValue())
        maxRank = card.getRank().getValue();
      if (maxSuit < card.getSuit().getValue())
        maxSuit = card.getSuit().getValue();
    }
    discardIndex = new int[maxRank*maxSuit];
    Arrays.fill(discardIndex, -1);
    shuffle();
  }

  /**
   * Return all the cards in the deck into play.
   */
  public final void shuffle() {
    Card card;
    //return discard array to initial state
    for(int index = cards.length - 1; index > cardIndex; index--) {
      card = cards[index];
      discardIndex[card.getSuit().getValue()-1 + 
        (card.getRank().getValue()-1)*maxSuit] = -1;
    }
    //put all cards into play
    cardIndex = cards.length - 1;
  }
  
  /**
   * Deal a single card, chosen at random from the 
   * remaining cards in the deck. Default implementation
   * uses a Random object - use setRandom() to use a different
   * Random subclass, or override getRandomInt() to implement
   * something different.
   * 
   * @return dealt card
   */
  public final Card deal() throws NotEnoughCardsException {
    if (cardIndex < 0)
      throw new NotEnoughCardsException();

    //choose a random card from the cards remaining
    //and swap into current position
    int rand = getRandomInt(cardIndex);
    Card temp = cards[rand];

    //keep track of the dealt card for discards later on
    discardIndex[temp.getSuit().getValue()-1 + 
      (temp.getRank().getValue()-1)*maxSuit] = cardIndex;
    cards[rand] = cards[cardIndex];
    cards[cardIndex--] = temp;
    return temp;
  }
  
  /**
   * Deal multiple cards, chosen at random from the 
   * remaining cards in the deck, returned in a new array. 
   * Default implementation uses a Random object - use setRandom() 
   * to use a different Random subclass, or override getRandomInt() 
   * to implement something different.
   * 
   * @param numCards number of cards to deal
   * @return dealt cards
   */
  public final Card [] deal(int numCards) throws NotEnoughCardsException {
    if (numCards > cardIndex + 1)
      throw new NotEnoughCardsException();

    int rand;
    Card temp;
    for(int index = numCards; index > 0; index--) {
      //choose a random card from the cards remaining
      //and swap into current position
      rand = getRandomInt(cardIndex);
      temp = cards[rand];

      //keep track of the dealt card for discards later on
      discardIndex[temp.getSuit().getValue()-1 + 
        (temp.getRank().getValue()-1)*maxSuit] = cardIndex;
      cards[rand] = cards[cardIndex];
      cards[cardIndex--] = temp;
    }

    Card [] dealt = new Card[numCards];
    System.arraycopy(cards, cardIndex + 1, dealt, 0, numCards);
    return dealt;
  }

  /**
   * Return a card back into play.
   */
  public void discard(Card card) {
    int discard = card.getSuit().getValue()-1 + 
      (card.getRank().getValue()-1)*maxSuit;
    int index = discardIndex[discard];

    //card isn't out of play
    if (index == -1)
      return;

    //shouldn't ever happen - wrong card passed in?
    if (cards[index] != card)
      return;

    discardIndex[discard] = -1;
    cardIndex++;
    cards[index] = cards[cardIndex];
    cards[cardIndex] = card;
  }

  /**
   * Return cards back into play.
   */
  public void discard(Card [] discards) {
    for(Card card : discards)
      discard(card);
  }
  
  /**
   * Get the number of cards left in the deck.
   */
  public int remaining() {
    return cardIndex + 1;
  }

  /**
   * Return a random int between 0 and rangeInclusive, e.g. if you
   * call with 51, return value can be 0, 51, or anything in between.
   * 
   * @param rangeInclusive
   * @return random int
   */
  public int getRandomInt(int rangeInclusive) {
    return getRandom().nextInt(rangeInclusive + 1);
  }
  
  /**
   * Seed the (Random) source of entropy.
   * 
   * @param seed
   */
  public void seed(long seed) {
    getRandom().setSeed(seed);
  } 

  /**
   * Get the (Random) source of entropy
   *
   * @return the entropy
   */
  public Random getRandom() {
    if (random == null) {
      random = new Random();
    }
    return random;
  }

  /**
   * Set the (Random) source of entropy.
   *
   * @param random the entropy to set
   */
  public void setRandom(Random random) {
    this.random = random;
  }
}
