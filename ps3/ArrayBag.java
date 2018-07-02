/* 
 * ArrayBag.java
 * 
 * Computer Science 112
 */

import java.util.*;

/**
 * An implementation of a bag data structure using an array.
 */
public class ArrayBag {
  /** 
   * The array used to store the items in the bag.
   */
  private Object[] items;
  
  /** 
   * The number of items in the bag.
   */
  private int numItems;
  
  public static final int DEFAULT_MAX_SIZE = 50;
  
  /**
   * Constructor with no parameters - creates a new, empty ArrayBag with 
   * the default maximum size.
   */
  public ArrayBag() {
    this.items = new Object[DEFAULT_MAX_SIZE];
    this.numItems = 0;
  }
  
  /** 
   * A constructor that creates a new, empty ArrayBag with the specified
   * maximum size.
   */
  public ArrayBag(int maxSize) {
    if (maxSize <= 0) {
      throw new IllegalArgumentException("maxSize must be > 0");
    }
    this.items = new Object[maxSize];
    this.numItems = 0;
  }
  
  /**
   * numItems - accessor method that returns the number of items 
   * in this ArrayBag.
   */
  public int numItems() {
    return this.numItems;
  }
  
  /** 
   * add - adds the specified item to this ArrayBag. Returns true if there 
   * is room to add it, and false otherwise.
   * Throws an IllegalArgumentException if the item is null.
   */
  public boolean add(Object item) {
    if (item == null) {
      throw new IllegalArgumentException("item must be non-null");
    } else if (this.numItems == this.items.length) {
      return false;    // no more room!
    } else {
      this.items[this.numItems] = item;
      this.numItems++;
      return true;
    }
  }
  
  /** 
   * remove - removes one occurrence of the specified item (if any)
   * from this ArrayBag.  Returns true on success and false if the
   * specified item (i.e., an object equal to item) is not in this ArrayBag.
   */
  public boolean remove(Object item) {
    for (int i = 0; i < this.numItems; i++) {
      if (this.items[i].equals(item)) {
        // Shift the remaining items left by one.
        for (int j = i; j < this.numItems - 1; j++) 
          this.items[j] = this.items[j + 1];
        this.items[this.numItems - 1] = null;
        
        this.numItems--;
        return true;
      }
    }
    
    return false;  // item not found
  }
  
  /**
   * contains - returns true if the specified item is in the Bag, and
   * false otherwise.
   */
  public boolean contains(Object item) {
    for (int i = 0; i < this.numItems; i++) {
      if (this.items[i].equals(item)) {
        return true;
      }
    }
    
    return false;
  }
  
  /**
   * grab - returns a reference to a randomly chosen item in this ArrayBag.
   */
  public Object grab() {
    if (this.numItems == 0) {
      throw new IllegalStateException("the bag is empty");
    }
    
    int whichOne = (int)(Math.random() * this.numItems);
    return this.items[whichOne];
  }
  
  /**
   * toArray - return an array containing the current contents of the bag
   */
  public Object[] toArray() {
    Object[] copy = new Object[this.numItems];
    
    for (int i = 0; i < this.numItems; i++) {
      copy[i] = this.items[i];
    }
    
    return copy;
  }
  
  /**
   * toString - converts this ArrayBag into a string that can be printed.
   * Overrides the version of this method inherited from the Object class.
   */
  public String toString() {
    String str = "{";
    
    for (int i = 0; i < this.numItems; i++) {
      str = str + this.items[i];
      if (i != this.numItems - 1) {
        str += ", ";
      }
    }
    
    str = str + "}";
    return str;
  }
  /**return the maximum number of items that the ArrayBag is able to hold.**/
  public int capacity(){
    return items.length;}
  
  /**This method should return true if the ArrayBag is empty, and false otherwise.**/
  public boolean isEmpty(){
    for(int i=0;i<this.capacity();i++){
      if (items[i] != null){
        return false;
      }
    }
    return true;
  }
  
  /**This method should attempt to add to the called ArrayBag 
    * all of the items found in the array newItems that is passed 
    * as a parameter, and it should return a boolean value indicating success or failure.**/
  public boolean addAll(Object[] newItems){
    if (newItems.length > this.capacity() - this.numItems()){
      return false;
    }
    for(int i = 0; i<(newItems.length); i++){
      add(newItems[i]);
    }
    return true;
  }
  
  public ArrayBag merge(ArrayBag other){
    int n = this.capacity() + other.capacity();
    ArrayBag x = new ArrayBag(n);
    if(other == null){
      throw new IllegalArgumentException();
    }
      
    else{
      Object[] arraybag1 = this.toArray();
      Object[] arraybag2 = other.toArray();
      
      for(int i = 0; i< x.capacity(); i++){
        if(i<arraybag1.length){
          if(x.contains(arraybag1[i]) == false){
            x.add(arraybag1[i]);
          }
        }
        if(i<arraybag2.length){
          if(x.contains(arraybag2[i]) == false){
            x.add(arraybag2[i]);
          }
        }
      }
    }
    return x;
  }
    
        
    
  
  
  
  
  
  /* Test the ArrayBag implementation. */
  public static void main(String[] args) {
    // Create a Scanner object for user input.
    Scanner scan = new Scanner(System.in);
    
    // Create an ArrayBag named bag1.
    System.out.print("size of bag 1: ");
    int size = scan.nextInt();
    ArrayBag bag1 = new ArrayBag(size);
    scan.nextLine();    // consume the rest of the line
    
    // Read in strings, add them to bag1, and print out bag1.
    String itemStr;        
    for (int i = 0; i < size; i++) {
      System.out.print("item " + i + ": ");
      itemStr = scan.nextLine();
      bag1.add(itemStr);
    }
    System.out.println("bag 1 = " + bag1);
    System.out.println();
    
    // Select a random item and print it.
    Object item = bag1.grab();
    System.out.println("grabbed " + item);
    System.out.println();
    
    // Iterate over the objects in bag1, printing them one per
    // line.
    Object[] items = bag1.toArray();
    for (int i = 0; i < items.length; i++) {
      System.out.println(items[i]);
    }
    System.out.println();
    
    // Get an item to remove from bag1, remove it, and reprint the bag.
    System.out.print("item to remove: ");
    itemStr = scan.nextLine();
    if (bag1.contains(itemStr)) {
      bag1.remove(itemStr);
    }
    System.out.println("bag 1 = " + bag1);
    System.out.println();
    ArrayBag b1 = new ArrayBag(10);
    System.out.println(b1.capacity());
    b1.add("hello");
    System.out.println(b1.capacity());
    
    ArrayBag b2 = new ArrayBag(10);
    System.out.println(b2.isEmpty());
    b2.add("hello");
    System.out.println(b2.isEmpty());
    
    ArrayBag b3 = new ArrayBag(6);
    String[] words = {"hello", "how", "are", "you?"};
    b3.addAll(words);
    System.out.println(b3);
    
    ArrayBag b4 = new ArrayBag(10);
    String[] letters1 = {"a", "a", "b", "d", "f", "f", "f", "g"};
    b4.addAll(letters1);
    ArrayBag b5 = new ArrayBag(8);
    String[] letters2 = {"a", "b", "c", "d", "d", "e", "f"};
    b5.addAll(letters2);
    ArrayBag b6 = b4.merge(b5);
    System.out.println(b6);
    
  }
}
