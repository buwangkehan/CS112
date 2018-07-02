/* LLBag.java
 * Kehan Wang
 * e-mail: wangkk@bu.edu
 */

import java.util.*;

public class LLBag implements Bag {
  /*construct Node class*/
  private class Node {
    private Object item;
    private Node next;
    
    private Node(Object i, Node n) {
      item = i;
      next = n;
    }
  }
  /*
   * LLBag's field
   */
  
  private Node head;
  private int numItems;
  public int numItems() {
    return numItems;
  }
  
  /*head*/    
  public LLBag() {
    head = new Node(null, null);
    numItems = 0;
  }
  
  /*
   * convert LLBags to String
   */
  public String toString() {
    String str = "{";
    Node trav = head.next;
    
    while(trav != null) {
      str = str + trav.item;
      if (trav.next != null) {
        str += ", ";
      }
      trav = trav.next;
    }
    
    str = str + "}";
    return str;
  }
  
  /* 
   * add item into LLbag, and always return true
   */
  public boolean add(Object item) {
    if (item == null) {
      throw new IllegalArgumentException("item must be non-null");
    } else { 
      Node trail = new Node(item, null);
      trail.next = head.next;
      head.next = trail;
      numItems ++;
      return true;
    }
  }
  
  
  
  /* remove item from LLBag, and return true 
   * if remove successfully, otherwise, return false*/
  
  public boolean remove(Object item) {
    Node trav = head.next;
    Node trail = head;
    
    while(trav != null) {
      if(trav.item.equals(item)) {
        trail.next = trav.next;
        numItems --;
        return true;
      }
      trail = trav;
      trav = trav.next;
    }
    
    return false;
  }  
  
  /*
   * contains - returns true if the specified item is in the Bag, and
   * false otherwise.
   */
  public boolean contains(Object item) {
    Node trav = head.next;
    Node trail = head;
    
    while(trav != null) {
      if(trav.item.equals(item)) {
        return true;
      }
      trail = trav;
      trav = trav.next;
    }
    
    return false;
  }  
  
  
  
  /*
   * grab - returns a reference to a randomly chosen item in this LLBag.
   */
  public Object grab() {
    if (numItems == 0) {
      throw new IllegalStateException("the bag is empty");
    }
    
    int whichOne = (int)(Math.random() * numItems);
    
    Node trav = head.next;    
    while (whichOne >0) {
      trav = trav.next;
      whichOne --;
    }
    return trav.item;
  }
  
  /*
   * toArray - return an array containing the current contents of the bag
   */
  public Object[] toArray() {
    Object[] copy = new Object[numItems];
    
    Node trav = head.next;   
    for (int i = 0; i < numItems; i++) {
      copy[i] = trav.item;
      trav = trav.next;
    }
    
    return copy;
  }
  
  /* Test the ArrayBag implementation. */
  public static void main(String[] args) {
    // Create a Scanner object for user input.
    Scanner scan = new Scanner(System.in);
    
    // Create an ArrayBag named bag1.
    System.out.print("number of items in bag 1: ");
    int numItems = scan.nextInt();
    Bag bag1 = new LLBag();
    scan.nextLine();    // consume the rest of the line
    
    // Read in strings, add them to bag1, and print out bag1.
    String itemStr;        
    for (int i = 0; i < numItems; i++) {
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
    
    // Iterate over the objects in bag1, printing them one per line.
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
  }    
}    
