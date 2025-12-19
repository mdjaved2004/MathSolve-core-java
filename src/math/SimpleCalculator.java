package math;

import java.util.Scanner;

import math.OptionRelativeImpl;
import math.StringToNumberImpl;

public interface SimpleCalculator {
	//This method is entry point to simple calculator
		public int calculate();
		
			
		int simpleCalculate(OptionRelativeImpl optionRelative, StringToNumberImpl stringToNumber, Scanner sc);
		
		String logicSimpleCalculate(Float result,char operator, String temp);
		
		
		int square(OptionRelativeImpl optionRelative, StringToNumberImpl stringToNumber, Scanner sc);
		
		int squareRoot(OptionRelativeImpl optionRelative, StringToNumberImpl stringToNumber, Scanner sc);
		
		int cube(OptionRelativeImpl optionRelative, StringToNumberImpl stringToNumber, Scanner sc);
		
		int cubeRoot(OptionRelativeImpl optionRelative, StringToNumberImpl stringToNumber, Scanner sc);
		
		int table(OptionRelativeImpl optionRelative, StringToNumberImpl stringToNumber, Scanner sc);
		
}
