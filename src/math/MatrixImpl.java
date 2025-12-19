package math;

import java.util.Scanner;

/*Start to solve matrix problems
 * >> calculate is main method in matrix
 * >> this Matrix starting point is calculate method.
 * >> this Matrix class is solved some problems :-
 * 		1. Addition of two matrix.
 * 		2. Subtraction of two matrix.
 * 		3. Multiply of two matrix.
 * 
 * 
 */
public class MatrixImpl implements Matrix{
	
	@Override
	public int matrixCalculate() {
		int option=0;
		Scanner sc = new Scanner(System.in);
		OptionRelativeImpl optionRelative = new OptionRelativeImpl();
		StringToNumberImpl stringToNumber = new StringToNumberImpl();
		while(true){
			System.out.println(optionRelative.welcom("Matrix"));
			System.out.println("Options :\n\t1. Matrix Addition \n\t2. Matrix Subtruction \n\t3. Matrix Multiplication \n\t4. Determinant \n\t5. Co-factor  \n\t6. adjA \n\t7. invers \n\t"+optionRelative.showOptionNumber());
			System.out.print("Choose Option : ");
			try {
				option=sc.nextInt();
			}catch (Exception e) {
				sc.nextLine();
				System.out.println(optionRelative.errorWrongInputNumber());	     
			}
            switch(option) {
	            case 1:// this case performance the + operator
	            	option=inputOfMatrix('+', optionRelative, sc);
	            	break;
	            case 2:// this case performance the - operator
	            	option=inputOfMatrix('-', optionRelative, sc);
	            	break;
	            case 3:// this method performance the * operator
	            	option=inputOfMatrix('*', optionRelative, sc);
	            	break;
	            case 4:option=inputSquareMatrixStart('d', optionRelative, sc);
//	            	determinantOfMatrix();
	            	break;
	            case 5:option=inputSquareMatrixStart('c', optionRelative, sc);
//	            		coFactorOfMatrix();
	            	break;
	            case 6:option=inputSquareMatrixStart('a', optionRelative, sc);
//	            		adjAMatrix();
	            	break;
	            case 7:option=inputSquareMatrixStart('i', optionRelative, sc);
//	            		inversMatrix();
	            	break;
            	default: System.out.println("Not available, try again");
            }
			if(option==11||option==12||option==13) {
				break;
			}
		}
		return option;
	}
	
	@Override
	public int inputOfMatrix(char operator, OptionRelativeImpl optionRelative, Scanner sc) {
		int r1, r2, c1, c2, i, j, option=0;	
		System.out.print("enter number of row and column of first matrix : ");
		Scanner obj = new Scanner(System.in);
		r1 = obj.nextInt();
		c1 = obj.nextInt();
		System.out.print("enter number of row and column of second matrix :");
		r2 = obj.nextInt();
		c2 = obj.nextInt();
		// Declare first matrix.
		int[][] a = new int[r1][c1];
		// Declare Second matrix.
		int[][] b = new int[r2][c2];
		System.out.println("\n Enter the element in fist matix");
		// Input the first matrix.
		for (i = 0; i < r1; i++) {
			for (j = 0; j < c1; j++) {
				System.out.print("\ta[" + i + "][" + j + "] : ");
				a[i][j] = obj.nextInt();
			}
			System.out.println();
		}
		System.out.println("enter the element in second matix");
		// Input the second matrix.
		for (i = 0; i < r2; i++) {
			for (j = 0; j < c2; j++) {
				System.out.print("\t b[" + i + "][" + j + "] : ");
				b[i][j] = obj.nextInt();
			}
			System.out.println();
		}
		boolean checkValidation=true;
		while(true) {
			//matrix shows
			System.out.println("First Matrix : ");
			for (i = 0; i < r1; i++) {
				for (j = 0; j < c1; j++) {
					System.out.print("\t" + a[i][j]);
				}
				System.out.print("\n");
			}
			System.out.println("Second Matrix : ");
			for (i = 0; i < r2; i++) {
				for (j = 0; j < c2; j++) {
					System.out.print("\t" + b[i][j]);
				}
				System.out.print("\n");
			}
			if(operator=='+'||operator=='-') {
				if (r1 != r2 || c1 != c2) {
					System.out.println("> ADDITION and SUBTRACTION is not possible of matrix");
					System.out.println("> because,The first and second matrix are not equal the Number of rows and number of colums.");
					System.out.println("> Row1=!row2 && Colums1=!colums2");
					checkValidation=false;
				}
			}else if(operator=='*') {
				if (c1 != r2) {
					System.out.print("> MULTIPLICATION is not possible of MATRIX\n");
					System.out.print("> because,Colums are first matrix are not equal to Rows are second matrix.\n");
					System.out.print("> Colums1=!row2\n");
					checkValidation=false;
				}
			}
			if(checkValidation) {
				switch(operator) {
					case '+':matrixAdditionLogic(r1, c1, r2, c2, a, b);
						break;
					case '-':matrixSubtractionLogic(r1, c1, r2, c2, a, b);
						break;
					case '*':matrixMultiplicationLogic(r1, c1, r2, c2, a, b);
						break;
				 }
				System.out.println("Options :\n\t 1. Same Matrix different operators  \n\t "+optionRelative.showOptionNumber());
				System.out.print("Choose Option : ");
				try {
					option = sc.nextInt();
					if(option!=1) {
						break;
					}else {
						System.out.println("Options :\n\t 1. Addition of Matrix  \n\t 2. Subtruction of Matrix \n\t 3. Multiply of Matrix \n\t "+optionRelative.showOptionNumber());
						System.out.print("Choose Option : ");
						option = sc.nextInt();
						if(option==1) {
							operator='+';
						}else if(option==2) {
							operator='-';
						}else if(option==3) {
							operator='*';
						}
					}
				}catch (Exception e) {
					sc.nextLine();
					System.out.println(optionRelative.errorWrongInputNumber());	     
				}
			}else {
				 option=11;
				break;
				
			}
				
		}
		return optionRelative.option11(option);		
	}
	
	@Override
	public int inputSquareMatrixStart(char operator, OptionRelativeImpl optionRelative, Scanner sc) {
		int i, j, row, column, option=0;
		System.out.print("enter number of row and column(row=column)  : ");
		row = sc.nextInt();
		column = sc.nextInt();

		int[][] m1 = new int[row][column];
		if (row == column) {
			for (i = 0; i < row; i++) {
				for (j = 0; j < column; j++) {
					System.out.print("enter element in pocket[" + i + "][" + j + "]=");
					m1[i][j] = sc.nextInt();
				}
			}
			while(true) {
				System.out.println("value of  matix");
				for (i = 0; i < row; i++) {
					for (j = 0; j < column; j++) {
						System.out.print("\t" + m1[i][j]);
					}
					System.out.print("\n");
				}
				switch (operator) {
					case 'd': // row and column values are same, so one value pass this method
						System.out.print("determinent of matrix = ");
						determinant(row, m1);
						break;
					case 'c':
						coFactor(row, column, m1);
						break;
					case 'a':
						System.out.print("a1dj of ma1trix\n");
						adjOfMatrix(row, column, m1);
					     break;
					case 'i':System.out.println("Inverse of matrix : ");
						    adjOfMatrix(row, column, m1);
						    System.out.print("________________________\n ");
						    determinant(row, m1);	
						    System.out.println();
						// InverseMatrix.inverse(row, column, m1);
					 break;
				}
				System.out.println("Options :\n\t 1. Same Matrix different operators  \n\t "+optionRelative.showOptionNumber());
				System.out.print("Choose Option : ");
				try {
					option = sc.nextInt();
					if(option!=1) {
						break;
					}else {
						System.out.println("Options :\n\t 1. Determinant of Matrix  \n\t 2. Co-factor of Matrix \n\t 3. adjA of Matrix \n\t 4. invers of Matrix \n\t"+optionRelative.showOptionNumber());
						System.out.print("Choose Option : ");
						option = sc.nextInt();
						if(option==1) {
							operator='d';
						}else if(option==2) {
							operator='c';
						}else if(option==3) {
							operator='a';
						}else if(option==4) {
							operator='i';
						}
					}
				}catch (Exception e) {
					sc.nextLine();
					System.out.println(optionRelative.errorWrongInputNumber());	     
				}
				if(option == 11 || option == 12 || option == 13) {
					break;
				}
			}
		}else {
			System.out.print("Only for valid Square matrix");
		}
		return optionRelative.option11(option);
	}
	
	@Override
	public void matrixAdditionLogic(int r1, int c1, int r2, int c2, int[][] a1, int[][] b1) {
		int i, j;
		// Declare third matrix for store data.
		int[][] c = new int[r1][c1];
		for (i = 0; i < r1; i++) {
			for (j = 0; j < c1; j++) {
				c[i][j] = a1[i][j] + b1[i][j];
				System.out.print("\n");
			}
		}
		System.out.print("addition of  matrix\n");
		for (i = 0; i < r1; i++) {
			for (j = 0; j < c1; j++) {
				System.out.print("\t" + c[i][j]);
			}
			System.out.print("\n");
		}	
		System.out.print(c.length);
	}
	
	@Override
	public void matrixSubtractionLogic(int r1, int c1, int r2, int c2, int[][] a1, int[][] b1) {
		int i, j;
		// Declare third matrix for store data.
		int[][] c = new int[r1][c1];
		for (i = 0; i < r1; i++) {
			for (j = 0; j < c1; j++) {
				c[i][j] = a1[i][j] - b1[i][j];
				System.out.print("\n");
			}
		}
		System.out.print("subtruction of  matrix\n");
		for (i = 0; i < r1; i++) {
			for (j = 0; j < c1; j++) {
				System.out.print("\t" + c[i][j]);
			}
			System.out.print("\n");
		}
	}

	@Override
	public void matrixMultiplicationLogic(int r1, int c1, int r2, int c2, int[][] a1, int[][] b1) {
		int i, j, k;
		// Declare third matrix for store data.
		int[][] c = new int[r1][c1];
		for (i = 0; i < r1; i++) { // r1*c1&r2*c2=r1*c2
			for (j = 0; j < c2; j++) // m*n&n*p=m*n
			{
				c[i][j] = 0;
				for (k = 0; k < r2; k++) // c1=r2, r1*(c1&r2)*c2=r1*c2:(under value) is common.
				{
					c[i][j] += a1[i][k] * b1[k][j];
				}
			}
		}
		System.out.print("multiplication of  matrix \n");
		for (i = 0; i < r1; i++) {
			for (j = 0; j < c2; j++) {
				System.out.print("\t" + c[i][j]);
			}
			System.out.print("\n");
		}
	}

	@Override
	public void determinant(int row, int[][] a1) {
		float determinant = 0;
		if (row == 2) {
			determinant = a1[0][0] * a1[1][1] - a1[0][1] * a1[1][0];
			System.out.println("\t"+determinant);
			//System.out.println("determinant of matrix = " + determinant);
		}
		if (row == 3) {
			determinant = a1[0][0] * (a1[1][1] * a1[2][2] - a1[2][1] * a1[1][2])
					- a1[0][1] * (a1[1][0] * a1[2][2] - a1[2][0] * a1[1][2])
					+ a1[0][2] * (a1[1][0] * a1[2][1] - a1[2][0] * a1[1][1]);
			System.out.println("\t" + determinant);
			//System.out.println("determinant of matrix = " + determinant);
		}
	}

	@Override
	public void coFactor(int row, int column, int[][] a1) {
		// this is a square matrix.
		int i, j;
		int[][] m2 = new int[row][column];
		if (row == 2) {
			for (i = 0; i < row; i++) {
				// here row==column
				for (j = 0; j < column; j++) {
					if (i == 0 && j == 0) {
						m2[i][j] = +1 * a1[1][1];
					}
					if (i == 0 && j == 1) {
						m2[i][j] = -1 * a1[1][0];
					}
					if (i == 1 && j == 0) {
						m2[i][j] = -1 * a1[0][1];
					}
					if (i == 1 && j == 1) {
						m2[i][j] = +1 * a1[0][0];
					}
				}
			}
			System.out.println("co-factor of matrix\n");
			for (i = 0; i < row; i++) {
				for (j = 0; j < column; j++) {
					System.out.print("\t" + m2[i][j]);
				}

				System.out.print("\n");
			}
		}

		if (row == 3) {
			for (i = 0; i < row; i++) {
				for (j = 0; j < column; j++) {
					if (i == 0 && j == 0) {
						m2[i][j] = (a1[1][1] * a1[2][2] - a1[2][1] * a1[1][2]);
					}
					if (i == 0 && j == 1) {
						m2[i][j] = -1 * (a1[1][0] * a1[2][2] - a1[2][0] * a1[1][2]);
					}
					if (i == 0 && j == 2) {
						m2[i][j] = (a1[1][0] * a1[2][1] - a1[2][0] * a1[1][1]);
					}
					if (i == 1 && j == 0) {
						m2[i][j] = -1 * (a1[0][1] * a1[2][2] - a1[2][1] * a1[0][2]);
					}
					if (i == 1 && j == 1) {
						m2[i][j] = (a1[0][0] * a1[2][2] - a1[2][0] * a1[0][2]);
					}
					if (i == 1 && j == 2) {
						m2[i][j] = -1 * (a1[0][0] * a1[2][1] - a1[2][0] * a1[0][1]);
					}
					if (i == 2 && j == 0) {
						m2[i][j] = (a1[0][1] * a1[1][2] - a1[1][1] * a1[0][2]);
					}
					if (i == 2 && j == 1) {
						m2[i][j] = -1 * (a1[0][0] * a1[1][2] - a1[1][0] * a1[0][2]);
					}
					if (i == 2 && j == 2) {
						m2[i][j] = (a1[0][0] * a1[1][1] - a1[1][0] * a1[0][1]);
					}
				}

			}
			System.out.print("co-fa1ctor of ma1trix\n");
			for (i = 0; i < row; i++) {
				for (j = 0; j < column; j++) {
					System.out.print("\t" + m2[i][j]);
				}

				System.out.print("\n");
			}

		}

	}
	
	@Override
	public void adjOfMatrix(int row, int column, int[][] a1) {  
		//here is square matrix
		int[][] m2 = new int[row][column];
		int i,j;
		if(row==2){                     
            for(i=0; i<row; i++){
                       for(j=0; j<column;j++){
                               if(i==0&&j==0){
                                  m2[i][j]=+1*a1[1][1];}
                               if(i==0&&j==1){
                                  m2[i][j]=-1*a1[0][1];}
                               if(i==1&&j==0){
                                  m2[i][j]=-1*a1[1][0];}                                               
                               if(i==1&&j==1){
                                  m2[i][j]=+1*a1[0][0];}
                      }
                   }
                   
         //           System.out.print("a1dj of ma1trix\n");
                   for(i=0; i<row; i++){
                       for(j=0; j<column;j++){
                               System.out.print("\t"+m2[i][j]);
                      }

                      System.out.print("\n");
                   }
                   
                   
               }
               if(row==3){              
               for(i=0; i<row; i++){
                   for(j=0; j<column;j++){
                       if(i==0&&j==0){
                           m2[i][j]=(a1[1][1]*a1[2][2]-a1[2][1]*a1[1][2]);}
                       if(i==0&&j==1){
                           m2[i][j]=-1*(a1[0][1]*a1[2][2]-a1[0][2]*a1[2][1]);}
                       if(i==0&&j==2){
                           m2[i][j]=(a1[0][1]*a1[1][2]-a1[0][2]*a1[1][1]);}   
                       if(i==1&&j==0){
                           m2[i][j]=-1*(a1[1][0]*a1[2][2]-a1[1][2]*a1[2][0]);}                                               
                       if(i==1&&j==1){
                           m2[i][j]=(a1[0][0]*a1[2][2]-a1[0][2]*a1[2][0]);}                                           
                       if(i==1&&j==2){
                           m2[i][j]=-1*(a1[0][0]*a1[1][2]-a1[0][2]*a1[1][0]);}
                       if(i==2&&j==0){
                           m2[i][j]=(a1[1][0]*a1[2][1]-a1[1][1]*a1[2][0]);}                                               
                       if(i==2&&j==1){
                           m2[i][j]=-1*(a1[0][0]*a1[2][1]-a1[0][1]*a1[2][0]);}
                       if(i==2&&j==2){
                           m2[i][j]=(a1[0][0]*a1[1][1]-a1[1][0]*a1[0][1]);}
               
                   }
                                               
               }
             //  System.out.print("a1dj of ma1trix\n");
                       for(i=0; i<row; i++){
                           for(j=0; j<column;j++){
                                   System.out.print("\t"+m2[i][j]);
                           }
                           System.out.print("\n");
                       }
           
           } 
	}

}
	
	