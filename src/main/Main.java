package main;

import java.util.Scanner;

import math.ArrayImpl;
import math.CircleImpl;
import math.FactorialImpl;
import math.MatrixImpl;
import math.OptionRelativeImpl;
import math.PolynomialsImpl;
import math.QuadriateralImpl;
import math.SimpleCalculatorImpl;

// Home page.
//This project is represent normal to advance  calculator  for practice purpose .

public class Main {
	public static void main(String []arg) {
		int option=0;
		
		while(true) {	
			System.out.println(new OptionRelativeImpl().welcom("home page"));
			Scanner sc = new Scanner(System.in);
			System.out.println("Choose opetion (only number) :- ");
			System.out.println("  1. Simple Calculater \n  2. Matrix(2D Array) \n  3. Factorial \n  4. Array \n  5. Circle \n  6. Quadriateral \n  7. Polynomials \n  13. Exit \n");
			try {
				System.out.print("Enter option : ");
				option = sc.nextInt();
				
				switch (option) {
					case 1:
							option=new SimpleCalculatorImpl().calculate();
							break;
							
					case 2:
							option=new MatrixImpl().matrixCalculate();
							break;
							
					case 3:	
							option=new FactorialImpl().factorial();
							break;
							
					case 4:
							option=new ArrayImpl().array();
							break;
							
					case 5:
							option=new CircleImpl().circle();
							break;
							
					case 6:
							option=new QuadriateralImpl().quadriateral();
							break;
							
					case 7:
							option=new PolynomialsImpl().polynomials();
							break;
							
					default: System.out.println("Not available");
				}
				if(option==13) {
					System.out.println("Program is successfuly terminated ");
					break;
				}
			} catch (Exception e) {
					sc.nextLine();
					System.out.println(new OptionRelativeImpl().errorWrongInputNumber());	     
			}	
		}
		
	}
}
