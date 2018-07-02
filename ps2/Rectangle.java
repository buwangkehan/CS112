/*
 * Rectangle.java
 * 
 * Computer Science 112, Boston University
 * 
 * A class that acts as a blueprint for objects that represent a rectangle.
 */

public class Rectangle {
  /* 
   * Fields that capture the state of a Rectangle object.
   * We make them private to prevent direct access from outside the class.
   */
  private int width;
  private int height;
  
  /* 
   * A constructor that calls the mutator methods to initialize the 
   * fields, so that they can perform the necessary error-checking.
   */
  public Rectangle(int w, int h) {
    this.setWidth(w);
    this.setHeight(h);
  }
  
  /* 
   * getWidth - an accessor method for a Rectangle's width.
   */
  public int getWidth() {
    return this.width;
  }
  
  /*
   * getHeight - an accessor method for a Rectangle's height.
   */
  public int getHeight() {
    return this.height;
  }         
  
  /*
   * area - an accessor method for a Rectangle's area.
   */
  public int area() {
    return this.width * this.height;
  }
  
  /*
   * perimeter - an accessor method for a Rectangle's perimeter.
   */
  public int perimeter() {
    return (2*this.width + 2*this.height);
  }
  
  /*
   * setWidth - a mutator method that changes a Rectangle's width.
   *
   * precondition: w must be positive
   */
  public void setWidth(int w) {
    if (w <= 0) {
      throw new IllegalArgumentException();
    }
    
    this.width = w;
  }
  
  /*
   * setHeight - a mutator method that changes a Rectangle's height.
   *
   * precondition: h must be positive
   */
  public void setHeight(int h) {
    if (h <= 0) {
      throw new IllegalArgumentException();
    }
    
    this.height = h;
  }
  
  /*
   * grow - a mutator method that changes a Rectangle's width and height,
   * adding dw to the current width and dh to the current height.
   * 
   * It uses setWidth and setHeight so that they can perform the
   * necessary error-checking.
   *
   * precondition: the resulting width and height must be positive.
   */
  public void grow(int dw, int dh) {
    this.setWidth(this.width + dw);
    this.setHeight(this.height + dh);
  }
  
  /*
   * isSquare - returns true if the Rectangle is a square, and false otherwise.
   */
  public boolean isSquare() {
    return (this.height == this.width);
  }
  
  /*
   * equals - returns true if the Rectangle specified by the parameter
   * is equivalent to the calling object, and false otherwise.
   * 
   * Note: this method does *not* override the default equals method,
   * because its parameter is of type Rectangle.
   */
  public boolean equals(Rectangle other) {
    return (other != null           
              && this.width == other.width 
              && this.height == other.height);
  }
  
  /*
   * toString - returns a string representation of the Rectangle 
   * of the form "width x height".
   */
  public String toString() {
    return this.width + " x " + this.height;
  }
  
  /**** Add your methods for parts 1 and 2 here. ****/
  
  /*rotates a Rectangle object 90 degrees by swapping its width and height values.*/
  public void rotate()
  {
    int tem = this.width;
    this.width = this.height;
    this.height = tem;
  }
  /*takes another Rectangle object and determines if the called Rectangle object 
   * (i.e., the one on which the method is invoked) has a larger area than the other Rectangle object 
   * ¨C returning true if the called object has a larger area and false otherwise*/
  public boolean largerThan(Rectangle other)
  {
    if(other == null)
      throw new IllegalArgumentException();
    return this.area() > other.area();
  }
  
  
  public static void main(String[] args) {
    Rectangle r1 = new Rectangle(20, 50);
    System.out.println("r1's original dimensions: " + r1);
    
    r1.grow(10, 5);
    System.out.println("r1's new dimensions: " + r1);
    
    // Add your test calls from part 3 here.
    
    r1.rotate();
    System.out.println("After rotate r1 with dimensions: " + r1);
    
    
    r1.rotate();
    System.out.println("After twice rotate r1 with dimensions: " + r1);
    
    Rectangle r2 = new Rectangle(30, 30);
    if(r1.largerThan(r2))
    {
      System.out.println(r1+" is larger than "+r2);
    }
    else
    {
      System.out.println(r2+" is larger than "+r1);
    }
    
  }
  
  
  
  
  
}