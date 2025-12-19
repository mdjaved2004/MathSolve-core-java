package math;

import java.util.Scanner;

//double array1[]=null, array2[]=null, array3[]=null, array4[]=null,array5[]=null;

public class ArrayImpl implements Array {
	
	@Override
	public int array() {
		int numberOfArray, option=0;
		Scanner sc = new Scanner(System.in);
		OptionRelativeImpl optionRelative = new OptionRelativeImpl();
		
		while(true) {
			System.out.println(optionRelative.welcom("Array"));
			while(true) {
				try {
					System.out.print("Enter the number of  array(max = 5): ");
					numberOfArray = sc.nextInt();	
					if(numberOfArray<=5) {
						break;
					}else {
						System.out.println("\nNOTE :- only number allow less than or equal to 38\n");
					}
				}catch(Exception e) {
					sc.nextLine();
					System.out.println(optionRelative.errorWrongInputNumber());
				}
			}
				switch(numberOfArray) {
					case 1:
						oneArray(optionRelative, sc);
						break;
					case 2:
						option=twoArray(optionRelative,sc);
						break;
					case 3:
						option=threeArray(optionRelative,sc);
						break;
					case 4:
						option=fourArray(optionRelative,sc);
						break;
					case 5:
						option=fiveArray(optionRelative,sc);
						break;	
		          }
				
				if(option==12 || option==13) {
					break;
				}
		}
		return option;
	}
	
	@Override
	public void oneArray(OptionRelativeImpl optionRelative, Scanner sc) {	
		double array1[]=	inputArray(1, 0, sc);
		showArrayResult(array1);
	}
	
	@Override
	public int twoArray(OptionRelativeImpl optionRelative, Scanner sc) {
		double array1[] = inputArray(1, 0, sc);
		int size=array1.length;
		double array2[] = inputArray(2, size,  sc);
		double result[] = new double[size];
		char operator;
		
		showArray(1,array1);
		showArray(2,array2);
		boolean temp=false;
		
		while(true) {
			try {
				if(temp==true) {
					System.out.println("\nOptions :\n\t 1. Same Array different operators  \n\t "+optionRelative.showOption());
					System.out.print("Choose Option : ");		
				}else {	
					temp=true;
					System.out.println("Options :\n\t Chose operator('+' '-' '*' '/') : \" \n\t"+optionRelative.showOption());
				}
				operator= sc.next().charAt(0);	
				if(operator=='b' || operator=='h' || operator=='e') {
					break;
				}else if(operator=='+' || operator=='-' || operator=='*' || operator=='/') {
					switch(operator) {
					case '+':
					        for (int i = 0; i <size; i++) {
					            result[i] = array1[i] + array2[i];
					        }
					        showArrayResult(result);
					        break;
				    case '-':
					        for (int i = 0; i < size; i++) {
					            result[i] = array1[i] - array2[i];
					        }
					        showArrayResult(result);
					        break;
				    case '*':
					        for (int i = 0; i < size; i++) {
					            result[i] = array1[i] * array2[i];
					        }
					        showArrayResult(result);
					        break;
				    case '/':boolean tempswitfh=false;
				        for (int i = 0; i < size; i++) {
					            if (array2[i] != 0) {
					                result[i] = array1[i] / array2[i];
					            } else {
					            	tempswitfh=true;
					                System.out.println("Division by zero infinite ");
					               break;
					            }
					        }
					        if(tempswitfh!=true){
					        		showArrayResult(result);
					        }
					        break;
					}
				}else if(operator=='1') {
					temp=false;
				}else {				
					System.out.println("This Option is not avalable, try again");
				}
			}catch(Exception e) {
				sc.nextLine();
				System.out.println("only allow one Charecter like (+,-,*,/,b,h,e");
			}		
		
		}
			
		return optionRelative.textToNumber(String.valueOf(operator));
	}
	
	@Override
	public int threeArray(OptionRelativeImpl optionRelative, Scanner sc) {
		double array1[]  =	inputArray(1, 0, sc);
		int size=array1.length;
		double array2[]  =	inputArray(2, size, sc);
		double array3[]  =	inputArray(3, size, sc);
		
		double result[] = new double[size];
		char operator;
		
		boolean temp=false;
		
		showArray(1,array1);
		showArray(2,array2);
		showArray(3,array3);
		while(true) {
			try {
				if(temp==true) {
					System.out.println("Options :\n\t 1. Same Array different operators  \n\t "+optionRelative.showOption());
					System.out.print("Choose Option : ");	
				}else {	
					temp=true;
					System.out.println("Options :\n\t Chose operator('+' '-' '*' '/') : \" \n\t"+optionRelative.showOption());
				}
				operator= sc.next().charAt(0);	
				if(operator=='b' || operator=='h' || operator=='e') {
					break;
				}else if(operator=='+' || operator=='-' || operator=='*' || operator=='/') {
					switch(operator) {
					case '+':
					        for (int i = 0; i <size; i++) {
					            result[i] = array1[i] + array2[i] + array3[i];
					        }
					        showArrayResult(result);
					        break;
				    case '-':
					        for (int i = 0; i < size; i++) {
					            result[i] = array1[i] - array2[i] - array3[i];
					        }
					        showArrayResult(result);
					        break;
				    case '*':
					        for (int i = 0; i < size; i++) {
					            result[i] = array1[i] * array2[i] * array3[i];
					        }
					        showArrayResult(result);
					        break;
				    case '/':boolean tempswitfh=false;
				        for (int i = 0; i < size; i++) {
					            if (array2[i] != 0) {
					                result[i] = array1[i] / array2[i] / array3[i];
					            } else {
					            	tempswitfh=true;
					                System.out.println("Division by zero infinite ");
					               break;
					            }
					        }
					        if(tempswitfh!=true){
					        		showArrayResult(result);
					        }
					        break;
					}
				}else {				
					System.out.println("This Option is not avalable, try again");
				}
			}catch(Exception e) {
				sc.nextLine();
				System.out.println("only allow one Charecter like (+,-,*,/,b,h,e");
			}		
		
		}
			
		return optionRelative.textToNumber(String.valueOf(operator));
	}
	
	@Override
	public int fourArray(OptionRelativeImpl optionRelative, Scanner sc) {
		double array1[]  =	inputArray(1, 0, sc);
		int size=array1.length;
		double array2[]  =	inputArray(2, size, sc);
		double array3[]  =	inputArray(3, size, sc);
		double array4[]  =	inputArray(4, size, sc);
		
		double result[] = new double[size];
		char operator;
		boolean temp=false;
		
		showArray(1,array1);
		showArray(2,array2);
		showArray(3,array3);
		showArray(4,array3);
		
		while(true) {
			try {
				if(temp==true) {
					System.out.println("Options :\n\t 1. Same Array different operators  \n\t "+optionRelative.showOption());
					System.out.print("Choose Option : ");	
				}else {	
					temp=true;
					System.out.println("Options :\n\t Chose operator('+' '-' '*' '/') : \" \n\t"+optionRelative.showOption());
				}
				operator= sc.next().charAt(0);	
				if(operator=='b' || operator=='h' || operator=='e') {
					break;
				}else if(operator=='+' || operator=='-' || operator=='*' || operator=='/') {
					
					switch(operator) {
						case '+':
						        for (int i = 0; i <size; i++) {
						            result[i] = array1[i] + array2[i] + array3[i] + array4[i];
						        }
						        showArrayResult(result);
						        break;
					    case '-':
						        for (int i = 0; i < size; i++) {
						            result[i] = array1[i] - array2[i] - array3[i] - array4[i];
						        }
						        showArrayResult(result);
						        break;
					    case '*':
						        for (int i = 0; i < size; i++) {
						            result[i] = array1[i] * array2[i] *  array3[i] * array4[i];
						        }
						        showArrayResult(result);
						        break;
					    case '/':
					    		boolean tempswitfh=false;
					        for (int i = 0; i < size; i++) {
						            if (array2[i] != 0) {
						                result[i] = array1[i] / array2[i] / array3[i] / array4[i];
						            } else {
						            	tempswitfh=true;
						                System.out.println("Division by zero infinite ");
						               break;
						            }
						        }
						        if(tempswitfh!=true){
						        		showArrayResult(result);
						        }
						        break;
					}
				}else {				
					System.out.println("This Option is not avalable, try again");
				}
			}catch(Exception e) {
				sc.nextLine();
				System.out.println("only allow one Charecter like (+,-,*,/,b,h,e");
			}		
		}
			
		return optionRelative.textToNumber(String.valueOf(operator));
	}
	
	@Override
	public int fiveArray(OptionRelativeImpl optionRelative, Scanner sc) {
		double array1[]  =	inputArray(1, 0, sc);
		int size=array1.length;
		double array2[]  =	inputArray(2, size, sc);
		double array3[]  =	inputArray(3, size, sc);
		double array4[]  =	inputArray(4, size, sc);
		double array5[]  =	inputArray(5, size, sc);
		
		double result[] = new double[size];
		char operator;
		boolean temp=false;
		
		showArray(1,array1);
		showArray(2,array2);
		showArray(3,array3);
		showArray(4,array4);
		showArray(5,array5);
		
		while(true) {
			try {
				if(temp==true) {
					System.out.println("Options :\n\t 1. Same Array different operators  \n\t "+optionRelative.showOption());
					System.out.print("Choose Option : ");	
				}else {	
					temp=true;
					System.out.println("Options :\n\t Chose operator('+' '-' '*' '/') : \" \n\t"+optionRelative.showOption());
				}
				operator= sc.next().charAt(0);	
				if(operator=='b' || operator=='h' || operator=='e') {
					break;
				}else if(operator=='+' || operator=='-' || operator=='*' || operator=='/') {
					switch(operator) {
					case '+':
					        for (int i = 0; i <size; i++) {
					            result[i] = array1[i] + array2[i] + array3[i] + array4[i] + array5[i];
					        }
					        showArrayResult(result);
					        break;
				    case '-':
					        for (int i = 0; i < size; i++) {
					            result[i] = array1[i] - array2[i] - array3[i] - array4[i] - array5[i];
					        }
					        showArrayResult(result);
					        break;
				    case '*':
					        for (int i = 0; i < size; i++) {
					            result[i] = array1[i] * array2[i] * array3[i] * array4[i] * array5[i];
					        }
					        showArrayResult(result);
					        break;
				    case '/':
				    		boolean tempswitfh=false;
				        for (int i = 0; i < size; i++) {
					            if (array2[i] != 0) {
					                result[i] = array1[i] / array2[i] / array3[i] / array4[i] / array5[i];
					            } else {
					            	tempswitfh=true;
					                System.out.println("Division by zero infinite ");
					               break;
					            }
					        }
					        if(tempswitfh!=true){
					        		showArrayResult(result);
					        }
					        break;
					}
				}else {				
					System.out.println("This Option is not avalable, try again");
				}
			}catch(Exception e) {
				sc.nextLine();
				System.out.println("only allow one Charecter like (+,-,*,/,b,h,e");
			}		
		}
		
		return optionRelative.textToNumber(String.valueOf(operator));
	}
	
	@Override
	public double[] inputArray(int number, int sizeOfarray, Scanner sc) {
		double element=0.00d;
		if(sizeOfarray==0) {
			System.out.print("\nEnter the size of  array  : ");
			sizeOfarray = sc.nextInt();		
		}
		double[] array0 = new double[sizeOfarray];
		System.out.println("\nEnter the values of array"+number+" : ");
		for (int i = 0; i <sizeOfarray; i++) {
			while(true) {
				try {
					System.out.print("\t array"+number+"[" + i + "] : ");
					element=sc.nextDouble();
					array0[i] = element;
					break;
				}catch(Exception e) {
					sc.nextLine();
					System.out.println("invalid value only number allow");
				}
			}	
		}	
		
		return array0;	
	}
	
	@Override
	public void showArray(int number, double array0[]) {
		int a= array0.length;
		System.out.println("\n Array"+number+" : ");
		for (int i = 0; i <a; i++) {
			System.out.println("\t array"+number+"[" + a + "] : "+array0[i]);
		}
	}
	
	@Override
	public void showArrayResult(double arrayr[]) {
		int arrayLength= arrayr.length;
		System.out.println("\n Result (left to right) = : ");
		for (int i = 0; i <arrayLength; i++) {
			System.out.println("\t array r[" + i + "] : "+arrayr[i]);
		}
	}
	
}