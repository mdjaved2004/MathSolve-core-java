package math;

import java.util.Scanner;

public interface Array {

	//this is main method for Array Class
	int array();
		
	void oneArray(OptionRelativeImpl optionRelative, Scanner sc);
	int twoArray(OptionRelativeImpl  optionRelative, Scanner sc);
    int threeArray(OptionRelativeImpl optionRelative, Scanner sc); 
	int fourArray(OptionRelativeImpl optionRelative, Scanner sc) ;
	int fiveArray(OptionRelativeImpl optionRelative, Scanner sc);
		
	double[] inputArray(int number, int sizeOfarray, Scanner sc);
	void showArray(int number, double array0[]);
	void showArrayResult(double arrayr[]); 
	
}