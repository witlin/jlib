package com.vitek.jlib.challenges;
import java.util.Scanner;

/**
 * Introduces the Scanner class and the modules operator.
 * @author Victor Smolinski
 */
public class EvenOdd {
  
  /**
   * 
   * @param number
   * @return
   */
  public static boolean isEven (int number) {
    try {
	  if (number % 2 > 0) return false;
      if (number % 2 == 0) return true;
      if (number % 2 < 0) throw new Exception("[ERROR] reminder is less than zero!");	
	} catch (Exception e) {
	  System.err.println("[ERROR] dividing number by 2");
	}
	return false;
  }
  
  /**
   * 
   * @param args
   */
  public static void run () {
    try (Scanner scanner = new Scanner (System.in)) {
		System.out.print("pick a number: ");
	  int usrNum = scanner.nextInt();
	  String numStr = String.valueOf(usrNum);
	  System.out.println ("is "
	                      .concat(numStr)
						  .concat(" an even number? ... ")
						  .concat(String.valueOf(isEven(usrNum))));
    scanner.close();
	} catch (Exception e) {
	  System.err.println("[ERROR] Closing scanner down ...");
	}
  }
}