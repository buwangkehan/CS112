import java.util.*;


/**
 *
 * ComputerPlayer.java
 * 
 * Computer Science 112
 */
/* extends from Player class*/
public class ComputerPlayer extends Player{
  
  /** own constructor, which should take the name of the player as its only parameter.**/
  public ComputerPlayer(String name){
    super(name); 
  }
  /**the method should simply print the number of cards in the ComputerPlayer¡®s hand.**/
  public void printHand(){
    if(this.getNumCards() == 1){
      System.out.println(this.getName() +"'s hand: ");
      System.out.println(" " + this.getNumCards() + " " + "card");
    }
    else{
      System.out.println(this.getName() +"'s hand: ");
      System.out.println(" " + this.getNumCards() + " " + "cards");
    }
  }
  
  /**if the computer has a card that matches the card at the top of the discard pile (this card is passed in as the second parameter of the method).**/
  /**computer player**/
  
  public int getPlay(Scanner scan, Card other) {
    int index = 0;
    int index2 = 0;
    
    Card[] temp = new Card[Buno.MAX_CARDS];
    for (int i = 0; i < this.getNumCards(); i++) {
      temp[i] = this.getCardFromHand(i);
    }
    
    
    for (int i = 0; i < this.getNumCards(); i++) {
      if (temp[i].getColor().equals(other.getColor())) {
        if (temp[i].getValue() > index) {
          index = i;
        }
      }
      if (temp[i].matches(other) == false) {
        index2++;
      }
      if (temp[i].getValue() == other.getValue()) {
        return i;
      }     
      
    }
    if (index2 == this.getNumCards()) {
      return -1;
    }
    
    return index;
  }
}



