/*
 * Card.java
 * 
 * A blueprint class for objects that represent a single playing card 
 * for the game Buno.
 */

public class Card {
  /* The smallest possible value that a Card can have. */
  /* the smallest value of the card*/
  public static final int MIN_VALUE = 0;
  
  /* The possible colors that a Card can have. */
  public static final String[] COLORS = {"blue", "green", "red", "yellow"};
  
  /* Define the third class constant here. */
  public static final int MAX_VALUE = 9;
  /* Put the rest of your class definition below. */
  /*take the name of a color as a parameter, and it should return true 
   * if the specified color is valid (i.e., if it is one of the colors listed in 
   * the COLORS array), and false otherwise.*/
  public static boolean isValidColor(String name){
    for(int i = 0; i<COLORS.length;i++){
      if (COLORS[i] == name){
        return true;}
    }
    return false;
  }
  
  private String color;
  private int value;
  
  /*constructor that takes a string for the Card¡®s 
   * color and an integer for the Card¡®s value (in that order)
   * , and initializes the values of the fields*/
  public Card(String c, int v){
    this.setColor(c);
    this.setValue(v);
  }
  /* takes a String representing a color and sets the value of 
   * the Card object¡¯s color field to the specified color*/
  public void setColor(String c){
    if(Card.isValidColor(c) == false){
      throw new IllegalArgumentException();
    }
    this.color = c;
  }
  /*takes an integer and sets the value of the Card 
   * object¡¯s value field to the specified number*/
  public void setValue(int v){
    if(v < 0||v > 9){
      throw new IllegalArgumentException();
    }
    this.value = v;
  }
  /*getColor, which returns the string representing the Card object¡¯s color.
   getValue, which returns the integer representing the Card object¡¯s value.*/
  public String getColor(){
    return this.color;}
  public int getValue(){
    return this.value;}
  
  /* returns a String representation of the Card object that 
   * can be used when printing it or concatenating it to a String.*/
  public String toString(){
    return this.color + " " + this.value;
  }
  /*takes another Card object as a parameter and returns true if the called Card 
   * object matches the color and/or value of the other Card object, 
   * and false if it doesn¡¯t match either the color or the value. If a value o 
   * .null is passed in for the parameter, the method should return false.*/
  public boolean matches(Card other){
    if(other == null){
      return false;
    }else if (this.color == other.color){
      return true;
    }else if (this.value == other.value){
      return true;
    }else{
      return false;
    }
  }
  
  
  
  /*takes another Card object as a parameter and determines if 
   * it is equivalent to the called object, returning true if it is equivalent and
   * false if it is not equivalent. Two Card objects should be 
   * considered equivalent if their color and value are the same. If a value of null is 
   * passed in for the parameter, the method should return false.*/
  public boolean equals(Card other){
    return(other != null           
              && this.value == other.value 
              &&this.color == other.color);
  }
    


    
    
    
    
  }


