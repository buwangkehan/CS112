import java.util.*;
public class Player{
  /**name¡¯s name (a single string) and the cards in the player¡¯s hand. **/
  private String name;
  private Card[] cards;
  private int cardCount;
  
  /**a constructor that takes a single parameter for the name of the player. **/
  public Player(String Name){
    this.name = Name;
    this.cards = new Card[Buno.MAX_CARDS];
    this.cardCount = 0;
    
  }
  
  /**an accessor named getName that returns the player¡¯s name.**/
  public String getName(){
    return this.name;
  }
  /**an accessor named getNumCards that returns the current number of cards in the player¡¯s hand.**/
  public int getNumCards(){
    return this.cardCount;
  }
  
  /**a toString method that just returns the player¡¯s name.**/
  public String toString(){
    return this.name;
  }
  
  /** mutator named addCardToHand that takes a Card object as a parameter 
    * and adds the specified card to the player¡¯s hand, filling the 
    * array from left to right**/
  public boolean addCardToHand(Card newcard){
    if(cards == null){
      throw new IllegalArgumentException();
    }
    else if(this.cardCount == Buno.MAX_CARDS){
      return false;}
    else{
      this.cards[this.cardCount] = newcard;
      this.cardCount++;
      return true;
    }}
  
  /** an accessor named getCardFromHand that takes
    * an integer index as a parameter and returns the Card at the 
    * specified position in the player¡¯s hand, 
    * without actually removing the card from the hand. **/
  
  public Card getCardFromHand(int index){
    if(index < 0 || index > this.cardCount){
      throw new IndexOutOfBoundsException();
    }
    return this.cards[index];
  }
  /**computes and returns the total value of the player¡¯s current hand**/
  public int getHandValue(){
    int sum = 0;
    for(int i = 0; i<this.cardCount;i++){
      sum += this.cards[i].getValue();
    }
    if(this.cardCount == Buno.MAX_CARDS){
      sum = sum + Buno.MAX_CARDS_PENALTY;
    }
    return sum;
  }
  
  /** prints the current contents of the player¡¯s hand,
    * preceded by a heading that includes the player¡¯s name.**/
  public void printHand(){
    System.out.println( this.name + "'s hand:");
    for(int i = 0; i< this.cardCount; i++){
      System.out.println( " " + i + ":" + this.cards[i].getColor() + " " + this.cards[i].getValue());
    }
  }
  /**takes an integer index as a parameter and both 
    * removes and returns the Card at that position of the player¡¯s hand.**/
  public Card removeCardFromHand(int index){
    if(index > this.cardCount && index < 0){
      throw new IndexOutOfBoundsException();
    }
    this.cards[index] = this.cards[this.cardCount -1];
    this.cards[this.cardCount -1] = null;
    this.cardCount--;
    
    return this.cards[index];
  }
  
  
  /**determines and returns the number corresponding to the pl
    * ayer¡¯s next play: either -1 if the player wants 
    * to draw a card, or the number/index of the card that the
    * player wants to discard from his/her hand.**/
  
  public int getPlay(Scanner scan, Card other) {
    System.out.print(this.name + ": number of card to play (-1 to draw)?");
    int index = scan.nextInt();
    while (index != -1 && (index > this.cardCount || index < -1)) {
      scan.nextLine();
      System.out.print(this.name + ": number of card to play (-1 to draw)?");
    }
    
    return index;
  }
  
}








