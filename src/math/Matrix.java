package math;

import java.util.Scanner;

import math.OptionRelativeImpl;

public interface Matrix {
	
	//this is main method for Matrix Class
	int matrixCalculate();
	
	int inputOfMatrix(char operator, OptionRelativeImpl optionRelative, Scanner sc);
	int inputSquareMatrixStart(char operator, OptionRelativeImpl optionRelative, Scanner sc);
	
	void matrixAdditionLogic(int r1, int c1, int r2, int c2, int[][] a1, int[][] b1);
	
	void matrixSubtractionLogic(int r1, int c1, int r2, int c2, int[][] a1, int[][] b1);

	void matrixMultiplicationLogic(int r1, int c1, int r2, int c2, int[][] a1, int[][] b1);

	void determinant(int row, int[][] a1);

	void coFactor(int row, int column, int[][] a1);
	
	void adjOfMatrix(int row, int column, int[][] a1);
}
	
	