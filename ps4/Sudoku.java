/**
 * Sudoku.java
 * 
 * Implementation of a class that represents a Sudoku puzzle and solves
 * it using recursive backtracking.
 *
 * Computer Science 112, Boston University
 *
 * name: Kehan Wang
 * email:wangkk@bu.edu
 */

import java.io.*;   // allows us to read from a file
import java.util.*;

public class Sudoku {    
  // The current contents of the cells of the puzzle. 
  private int[][] grid;
  
  /*
   * Indicates whether the value in a given cell is fixed 
   * (i.e., part of the initial configuration).
   * valIsFixed[r][c] is true if the value in the cell 
   * at row r, column c is fixed, and false otherwise.
   */
  private boolean[][] valIsFixed;
  
  /*
   * This 3-D array allows us to determine if a given subgrid 
   * (i.e., a given 3x3 region of the puzzle) already contains a given value.
   * We use 2 indices to identify a given subgrid:
   *
   *    (0,0)   (0,1)   (0,2)
   *
   *    (1,0)   (1,1)   (1,2)
   * 
   *    (2,0)   (2,1)   (2,2)
   * 
   * For example, subgridHasVal[0][2][5] will be true if the subgrid in the 
   * upper right-hand corner already has a 5 in it, and false otherwise.
   */
  private boolean[][][] subgridHasVal;
  
  /*** ADD YOUR ADDITIONAL FIELDS HERE. ***/
  private boolean[][] rowHasVal;
  private boolean[][] colHasVal;
  
  
  /* 
   * Constructs a new Puzzle object, which initially
   * has all empty cells.
   */
  public Sudoku() {
    this.grid = new int[9][9];
    this.valIsFixed = new boolean[9][9];     
    
    /* 
     * Note that the third dimension of the following array is 10,
     * because we need to be able to use the possible values 
     * (1 through 9) as indices.
     */
    this.subgridHasVal = new boolean[9][9][10];        
    
    /*** INITIALIZE YOUR ADDITIONAL FIELDS HERE. ***/
  }
  
  /*
   * Place the specified value in the cell with the specified coordinates, 
   * and update the state of the puzzle accordingly.
   */
  public void placeVal(int val, int row, int col) {
    this.grid[row][col] = val;
    this.subgridHasVal[row/3][col/3][val] = true;
    
    /*** UPDATE YOUR ADDITIONAL FIELDS HERE. ***/
    int[] list = this.FindAvailable(row, col);
  }
  
  /*
   * remove the specified value from the cell with the specified coordinates, 
   * and update the state of the puzzle accordingly.
   */
  public void removeVal(int val, int row, int col) {
    this.grid[row][col] = 0;
    this.subgridHasVal[row/3][col/3][val] = false;
    
    /*** UPDATE YOUR ADDITIONAL FIELDS HERE. ***/
    int[] list = this.FindAvailable(row, col);
  }  
  
  /*
   * read in the initial configuration of the puzzle from the specified 
   * Scanner, and use that config to initialize the state of the puzzle.  
   * The configuration should consist of one line for each row, with the
   * values in the row specified as integers separated by spaces.
   * A value of 0 should be used to indicate an empty cell.
   * 
   * You should not change this method.
   */
  public void readConfig(Scanner input) {
    for (int r = 0; r < 9; r++) {
      for (int c = 0; c < 9; c++) {
        int val = input.nextInt();
        this.placeVal(val, r, c);
        if (val != 0) {
          this.valIsFixed[r][c] = true;
        }
      }
      input.nextLine();
    }
  }
  
  /*
   * Displays the current state of the puzzle.
   * You should not change this method.
   */        
  public void printGrid() {
    for (int r = 0; r < 9; r++) {
      this.printRowSeparator();
      for (int c = 0; c < 9; c++) {
        System.out.print("|");
        if (this.grid[r][c] == 0)
          System.out.print("   ");
        else
          System.out.print(" " + this.grid[r][c] + " ");
      }
      System.out.println("|");
    }
    this.printRowSeparator();
  }
  
  // A private helper method used by display() 
  // to print a line separating two rows of the puzzle.
  private static void printRowSeparator() {
    for (int i = 0; i < 9; i++)
      System.out.print("----");
    System.out.println("-");
  }
  
  /*** ADD ANY ADDITIONAL METHODS HERE. ***/
  /** check the number is avaiable or not **/
  private boolean checkAvailable(int val, int row, int col){
    if (this.subgridHasVal[row / 3][col / 3][val]) {
      return false;
    }
    
    for (int i = 0; i < 9; i ++) {
      if (this.grid[i][col] == val) {
        return false;
      }
    }
    for (int i = 0; i <9; i ++) {
      if (this.grid[row][i] == val) {
        return false;
      }
    }
    return true;
  }
  /** find the list conatains available number**/
  private int[] FindAvailable(int row, int col) {
    int[] list = new int[9];
    int availableOne = 0;
    for (int i = 1; i <= 9; i++) {
      if (this.checkAvailable(i, row, col)) {
        list[availableOne] = i;
        availableOne++;
      }
    }
    int[] list2 = new int[availableOne];
    for (int i = 0; i < availableOne; i++) {
      list2[i] = list[i];
    }
    return list2;
  }
  
  
  /*
   * This is the key recursive-backtracking method.
   * Returns true if a solution has already been found, and false otherwise.
   * 
   * There are different ways to use parameters in this method, 
   * and you will need to decide how many parameters you want to use 
   * and what they should mean.
   */
  private boolean solveRB() {     // ADD IN YOUR PARAMETERS!
    
    /* 
     * The following return statement allows the initial code to compile.
     * Replace it with your full implementation of the recursive-backtracking
     * method.
     */
    int numRow = 0;
    int numCol = 0;
    int index = 0;
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (this.valIsFixed[i][j] == false) {
          numRow = i;
          numCol = j;
          break;
        }
        else {
          index++;
        }
      }
    }
    
    if (index == 81) {
      return true;
    }
    int[] list = this.FindAvailable(numRow, numCol);
    int i = 0;
    if(list.length==0){
      return false;
    }
    while (i < list.length) {
      this.placeVal(list[i], numRow, numCol);
      this.valIsFixed[numRow][numCol] = true;
      if (this.solveRB() == false) {
        this.subgridHasVal[numRow / 3][numCol / 3][list[i]] = false;
        i++;
      }
      else {
        return true;
      }
    }
    
    
    
    this.removeVal(list[i - 1], numRow, numCol);
    this.valIsFixed[numRow][numCol] = false;
    return false;
  } 
  
  
  
  
  /*
   * public "wrapper" method for solveRB().
   * Makes the initial call to solveRB, and returns whatever it returns.
   */
  public boolean solve() { 
    boolean foundSol = this.solveRB(); // ADD THE INITIAL PARAMETER VALS!
    return foundSol;
  }
  
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Sudoku puzzle = new Sudoku();
    
    System.out.print("Enter the name of the puzzle file: ");
    String filename = scan.nextLine();
    
    try {
      Scanner input = new Scanner(new File(filename));
      puzzle.readConfig(input);
    } catch (IOException e) {
      System.out.println("error accessing file " + filename);
      System.out.println(e);
      System.exit(1);
    }
    
    System.out.println();
    System.out.println("Here is the initial puzzle: ");
    puzzle.printGrid();
    System.out.println();
    
    if (puzzle.solve()) {
      System.out.println("Here is the solution: ");
    } else {
      System.out.println("No solution could be found.");
      System.out.println("Here is the current state of the puzzle:");
    }
    puzzle.printGrid();  
  }    
}
