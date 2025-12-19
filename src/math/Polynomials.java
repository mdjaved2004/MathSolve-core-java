package math;

import java.util.List;
import java.util.Scanner;

import math.OptionRelativeImpl;

public interface Polynomials {
	// this method to start calculate polynomials
	public int polynomials();
	
	// This method stable for only one polynomials and power 2
	int onePolynomialsPowerTwo(Scanner sc, OptionRelativeImpl optionRelative);
	//Two polynomials and power 2
	int twoPolynomialsPowerTwo(Scanner sc, OptionRelativeImpl optionRelative);
	//Three polynomials and power 2
	int threePolynomialsPowerTwo(Scanner sc, OptionRelativeImpl optionRelative);
	
	//one polynomials and power 3
	int onePolynomialsPowerThree(Scanner sc, OptionRelativeImpl optionRelative);
	
	//Two polynomials and power 3
	int twoPolynomialsPowerThree(Scanner sc, OptionRelativeImpl optionRelative);
	
	//Three polynomials and power 3
	int threePolynomialsPowerThree(Scanner sc, OptionRelativeImpl optionRelative);
		
	//input of polynomials
	float[] inputOfPolynomials(Scanner sc, int number, int power);
	
	//Output of polynomials
	void outputOfPolynomials(List<float[]> polynomialList, int power);
	//Output only result
	void outputOnlyResultPolynomials(float[] resultPolynomials);
	
	
	//Find roots of polynomials
	void resultOfRootsPolynomials(List<float[]> polynomialList, int power);
	
	//solve polynomials (addition, subtraction, multiply)
	float[] resultOfPolynomials(List<float[]> polynomialList, int power, char operator);
	
	//multiply of polynomials
	float[] multiplyPolynomials(float[] firstPolynomials, float[] twoPolynomials);
	
	//option of polynomials
	int optionOfPolinomials(Scanner sc, OptionRelativeImpl optionRelative, int numberOfPolinomial);
}