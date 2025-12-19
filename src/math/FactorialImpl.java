package math;

import java.util.Scanner;

// which find factorial number.
// Negative number is not exist factorial.
// Only positive number is exist factorial.
public class FactorialImpl implements Factorial{
	
	@Override
	public int factorial() {
		int number=0,option=0;
		long factorialResult;
		
		OptionRelativeImpl optionRelative = new OptionRelativeImpl();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print(optionRelative.welcom("Factorial"));		
			try {
				while(true) {
					System.out.print("Enter the numbetr(max 38): ");
					number=sc.nextInt();
					if(number<=38) {
						break;
					}else {
						System.out.println("\nNOTE :- only number allow less than or equal to 38\n");
					}	
				}
				if (number < 0) {
					System.out.print("> factorial is not posible\n");
					System.out.print("> because, Factorial is possitive values\n");
				} else {
					factorialResult = factorialOutput(number);
					System.out.println("\nFactorial of " + number + " is = " + factorialResult+"\n");
				}
				while(true) {
					try {
						System.out.println("Choose Options :\n\t 1. Continue  \n\t "+optionRelative.showOptionNumber());
						System.out.print("Choose Option(Only number) : ");
						option = sc.nextInt();
						break;
					}catch (Exception e) {
						sc.nextLine();
						System.out.println(optionRelative.errorWrongInputNumber()+" try again");	     
					}
				}
				if(option == 11 || option == 12 || option == 13) {
					break;
				}
			}catch (Exception e) {
				sc.nextLine();
				System.out.println(optionRelative.errorWrongInputNumber());	     
			}
		}

		return option;
	}

	@Override
	public long factorialOutput(int number) {
		// Number 1 and 0 is factorial always 1.
		if (number == 0 || number == 1) {
			return 1;
		} else {
			return number * factorialOutput(number - 1);
		}
	}

}
	
	
	
	
//use to store unlimited value
//	public BigInteger factorialOutput(int number) {
//	    if (number == 0 || number == 1) {
//	        return BigInteger.ONE; // BigInteger me constant
//	    } else {
//	        return BigInteger.valueOf(number)
//	                         .multiply(factorialOutput(number - 1));
//	    }
//	}

