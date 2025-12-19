package math;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PolynomialsImpl implements Polynomials {
	private int option=0;
	
	// this method to start calculate polynomials
	@Override
	public int polynomials(){
		byte numberOfPolynomials=0, powerOfPolynomial=0;
		Scanner sc = new Scanner(System.in);
		OptionRelativeImpl optionRelative = new OptionRelativeImpl();
		StringToNumberImpl stringToNumber = new StringToNumberImpl();

		while (true) {
			while (true) {
				System.out.println(optionRelative.welcom("Polynomials"));
				System.out.println(optionRelative.showOptionNumber());
		        System.out.print("Enter number of polynomial (1 or 2 or 3): ");
		        try {
		        		numberOfPolynomials=sc.nextByte();
		        		if(numberOfPolynomials==11 || numberOfPolynomials==12 ||numberOfPolynomials==13) {
		        			option=numberOfPolynomials;
		        			break;
		        		}else if(numberOfPolynomials==1 || numberOfPolynomials==2 ||numberOfPolynomials==3){
		        			while (true) {
							 System.out.print("Enter maximum power of polynomial (2 or 3): ");
					        try {
					        		powerOfPolynomial=sc.nextByte();
								if(powerOfPolynomial==2 || powerOfPolynomial==3){						
					                 break;
								}else {	
									System.out.println("this power is not avalable, try again ");
								}
							}catch (Exception e) {
								sc.nextLine();
								System.out.println(optionRelative.errorWrongInputNumber());	     
							}
						}
						break;
					}else {	
						System.out.println("this number is not avalable, try again ");
					}
				}catch (Exception e) {
					sc.nextLine();
					System.out.println(optionRelative.errorWrongInputNumber());	     
				}
			}
			
			/* this switch statement to redirect to other method based on number of polynomials and
			 * power of polynomials */
			switch(numberOfPolynomials) {
				case 1:
						if(powerOfPolynomial==2) {
							option=onePolynomialsPowerTwo(sc, optionRelative);				
						}else if(powerOfPolynomial==3) {
							option=onePolynomialsPowerThree(sc, optionRelative);	
						}
						break;
						
				case 2:
						if(powerOfPolynomial==2) {
							option=twoPolynomialsPowerTwo(sc, optionRelative);				
						}else if(powerOfPolynomial==3) {
							option=twoPolynomialsPowerThree(sc, optionRelative);	
						}
						break;
						
				case 3:
						if(powerOfPolynomial==2) {
							option=threePolynomialsPowerTwo(sc, optionRelative);				
						}else if(powerOfPolynomial==3) {
							option=threePolynomialsPowerThree(sc, optionRelative);	
						}
						break;
			}
			
			if(option==11 || option==12 || option==13) {
				break;
			}
			
		}
			
		return option;	
	}
	
	// This method stable for only one polynomials and power 2
	@Override
	public int onePolynomialsPowerTwo(Scanner sc, OptionRelativeImpl optionRelative){	
		float firstPolynomials[] = inputOfPolynomials(sc, 1, 2);	
		List<float[]> polynomialList = new ArrayList<>();
		polynomialList.add(firstPolynomials);
		
		outputOfPolynomials(polynomialList, 2);
	
		while(true) {
			option=optionOfPolinomials(sc, optionRelative, 1);
			if(option==1) {
				outputOfPolynomials(polynomialList, 2);
				resultOfRootsPolynomials(polynomialList, 2);	
			}else{
				if(option==11) {
					option=-1;
					break;
				}else if(option==12 || option==13) {
					break;
				}else {
					System.out.println("\nYou are enter wrong option , Please try again");
				}
			}
		}	
		
		return option;		
	}
	
	//Two polynomials and power 2
	@Override
	public int twoPolynomialsPowerTwo(Scanner sc, OptionRelativeImpl optionRelative){
		float firstPolynomials[] = inputOfPolynomials(sc, 1, 2);	
		float twoPolynomials[] = inputOfPolynomials(sc, 2, 2);	
		
		List<float[]> polynomialList = new ArrayList<>();
		polynomialList.add(firstPolynomials);
		polynomialList.add(twoPolynomials);
		
		outputOfPolynomials(polynomialList, 2);
		
		while(true) {
			option=optionOfPolinomials(sc, optionRelative, 2);
			if(option>0&&option<5) {
				outputOfPolynomials(polynomialList, 2);
				float resultPolynomials[] =null;
				switch(option) {
					case 1:	
							resultOfRootsPolynomials(polynomialList, 2);
							break;
					case 2:	
							resultPolynomials=resultOfPolynomials(polynomialList, 2, '+');
							outputOnlyResultPolynomials(resultPolynomials);
							break;
					case 3:	
							resultPolynomials=resultOfPolynomials(polynomialList, 2, '-');
							outputOnlyResultPolynomials(resultPolynomials);
							break;
					case 4:	
							resultPolynomials=resultOfPolynomials(polynomialList, 2, '*');
							outputOnlyResultPolynomials(resultPolynomials);
							break;
				}
			}else{
				if(option==11) {
					option=-1;
					break;
				}else if(option==12 || option==13) {
					break;
				}else {
					System.out.println("\nYou are enter wrong option , Please try again");
				}
			}
		}	
		
		return option;
		
	}
	
	//Three polynomials and power 2
	@Override
	public int threePolynomialsPowerTwo(Scanner sc, OptionRelativeImpl optionRelative){
		float firstPolynomials[] = inputOfPolynomials(sc, 1, 2);	
		float twoPolynomials[] = inputOfPolynomials(sc, 2, 2);	
		float threePolynomials[] = inputOfPolynomials(sc, 3, 2);	
		
		List<float[]> polynomialList = new ArrayList<>();
		polynomialList.add(firstPolynomials);
		polynomialList.add(twoPolynomials);
		polynomialList.add(threePolynomials);
		
		outputOfPolynomials(polynomialList, 2);
		
		while(true) {
			option=optionOfPolinomials(sc, optionRelative, 3);
			if(option>0&&option<5) {
				outputOfPolynomials(polynomialList, 2);
				float resultPolynomials[] =null;
				switch(option) {
					case 1:	
							resultOfRootsPolynomials(polynomialList, 2);
							break;
					case 2:	
							resultPolynomials=resultOfPolynomials(polynomialList, 2, '+');
							outputOnlyResultPolynomials(resultPolynomials);
							break;
					case 3:	
							resultPolynomials=resultOfPolynomials(polynomialList, 2, '-');
							outputOnlyResultPolynomials(resultPolynomials);
							break;
					case 4:	
							resultPolynomials=resultOfPolynomials(polynomialList, 2, '*');
							outputOnlyResultPolynomials(resultPolynomials);
							break;
				}
			}else{
				if(option==11) {
					option=-1;
					break;
				}else if(option==12 || option==13) {
					break;
				}else {
					System.out.println("\nYou are enter wrong option , Please try again");
				}
			}
		}	
		
		return option;	
	}
	
	//one polynomials and power 3
	@Override
	public int onePolynomialsPowerThree(Scanner sc, OptionRelativeImpl optionRelative){
		float firstPolynomials[] = inputOfPolynomials(sc, 1, 3);	

		List<float[]> polynomialList = new ArrayList<>();
		polynomialList.add(firstPolynomials);
		
		outputOfPolynomials(polynomialList, 3);
		
		while(true) {
			option=optionOfPolinomials(sc, optionRelative, 1);
			if(option==1) {
				outputOfPolynomials(polynomialList, 3);
				resultOfRootsPolynomials(polynomialList, 3);
			}else{
				if(option==11) {
					option=-1;
					break;
				}else if(option==12 || option==13) {
					break;
				}else {
					System.out.println("\nYou are enter wrong option , Please try again");
				}
			}
		}	
		
		return option;
	}
	
	//Two polynomials and power 3
	@Override
	public int twoPolynomialsPowerThree(Scanner sc, OptionRelativeImpl optionRelative){
		float firstPolynomials[] = inputOfPolynomials(sc, 1, 3);
		float twoPolynomials[] = inputOfPolynomials(sc, 2, 3);
		
		List<float[]> polynomialList = new ArrayList<>();
		polynomialList.add(firstPolynomials);
		polynomialList.add(twoPolynomials);
		
		outputOfPolynomials(polynomialList, 3);

		while(true) {
			option=optionOfPolinomials(sc, optionRelative,2);
			if(option>0&&option<5) {
				outputOfPolynomials(polynomialList, 3);
				float resultPolynomials[] =null;
				switch(option) {
					case 1:	
							resultOfRootsPolynomials(polynomialList, 3);
							break;
					case 2:	
							resultPolynomials=resultOfPolynomials(polynomialList, 3, '+');
							outputOnlyResultPolynomials(resultPolynomials);
							break;
					case 3:	
							resultPolynomials=resultOfPolynomials(polynomialList, 3, '-');
							outputOnlyResultPolynomials(resultPolynomials);
							break;
					case 4:	
							resultPolynomials=resultOfPolynomials(polynomialList, 3, '*');
							outputOnlyResultPolynomials(resultPolynomials);
							break;
				}
			}else{
				if(option==11) {
					option=-1;
					break;
				}else if(option==12 || option==13) {
					break;
				}else {
					System.out.println("\nYou are enter wrong option , Please try again");
				}
			}
		}	
		
		return option;	
	}
	
	//Three polynomials and power 3
	@Override
	public int threePolynomialsPowerThree(Scanner sc, OptionRelativeImpl optionRelative){
		float firstPolynomials[] = inputOfPolynomials(sc, 1, 3);
		float twoPolynomials[] = inputOfPolynomials(sc, 2, 3);
		float threePolynomials[] = inputOfPolynomials(sc, 3, 3);
		
		List<float[]> polynomialList = new ArrayList<>();
		polynomialList.add(firstPolynomials);
		polynomialList.add(twoPolynomials);
		polynomialList.add(threePolynomials);
		
		outputOfPolynomials(polynomialList, 3);
		
		while(true) {
			option=optionOfPolinomials(sc, optionRelative,3);
			if(option>0&&option<5) {
				outputOfPolynomials(polynomialList, 3);
				float resultPolynomials[] =null;
				switch(option) {
					case 1:	
							resultOfRootsPolynomials(polynomialList, 3);
							break;
					case 2:	
							resultPolynomials=resultOfPolynomials(polynomialList, 3, '+');
							outputOnlyResultPolynomials(resultPolynomials);
							break;
					case 3:	
							resultPolynomials=resultOfPolynomials(polynomialList, 3, '-');
							outputOnlyResultPolynomials(resultPolynomials);
							break;
					case 4:	
							resultPolynomials=resultOfPolynomials(polynomialList, 3, '*');
							outputOnlyResultPolynomials(resultPolynomials);
							break;
				}
			}else{
				if(option==11) {
					option=-1;
					break;
				}else if(option==12 || option==13) {
					break;
				}else {
					System.out.println("\nYou are enter wrong option , Please try again");
				}
			}
		}	
		
		return option;
	}
		
	//input of polynomials
	@Override
	public float[] inputOfPolynomials(Scanner sc, int number, int power){
		float polyArray[] = null;

		if(power == 2) {
		    polyArray = new float[3]; 
		} else if(power == 3) {
		    polyArray = new float[4]; 
		}
	     System.out.println("Enter coefficients for  polynomial "+number+" (a"+number+"x^2 + b"+number+"x + c"+number+"): ");
	     char element='a';
	     for(int i=0;i<polyArray.length; i++) {
		     while (true) {
		        try {
		        	System.out.print("\t"+element+number+" :"); 	
		        	polyArray[i]=sc.nextFloat();
		        	element++;
		        	break;
				}catch (Exception e) {
					sc.nextLine();
					System.out.println("invalid value only number allow");	     
				}
			}
	     }   
	     System.out.println();
	     return polyArray;
	}
	
	//Output of polynomials
	@Override
	public void outputOfPolynomials(List<float[]> polynomialList, int power){	
		int polyNumber=1;
		float a=0.0f,b=0.0f,c=0.0f,d=0.0f;
		
		for(float coeff[] : polynomialList){			
			System.out.println("Polynomial "+polyNumber+" : "); 
			for(int i=0;i<coeff.length; i++) {
				if(i==0) {
					a=coeff[i];
				}else if(i==1) {
					b=coeff[i];
				}else if(i==2) {
					c=coeff[i];
				}else if(i==3) {
					d=coeff[i];
				}		
			}
			if(power==2) {
				System.out.println("\t "+a+"x^2 + "+b+"x + "+c);		
			}else if(power==3) {
				System.out.println("\t "+a+"x^3 + "+b+"x^2 + "+c+"x"+d);
			}
			System.out.println();
			polyNumber++;
		}	
	}
	
	//Output only result
	@Override
	public void outputOnlyResultPolynomials(float[] resultPolynomials){	
		int polyPower = resultPolynomials.length;
		System.out.println("\t" + polyPower);
		String tempary = "";
		System.out.println("Result  : "); 

		for (int i = 0; i < resultPolynomials.length; i++) {
		    tempary += resultPolynomials[i] + "x^" + (polyPower - 1) ;
		    if (i != resultPolynomials.length - 1) { 
		        tempary += " + ";
		    }
		    polyPower--;
		}
		System.out.println("\t" + tempary);
	}
	
	
	//Find roots of polynomials
	@Override
	public void resultOfRootsPolynomials(List<float[]> polynomialList, int power){
		int polyNumber=1;
		float a=0.0f,b=0.0f,c=0.0f,d=0.0f;
		
		for(float coeff[] : polynomialList){			
			System.out.println("Polynomial "+polyNumber+" : "); 
			for(int i=0;i<coeff.length; i++) {
				if(i==0) {
					a=coeff[i];
				}else if(i==1) {
					b=coeff[i];
				}else if(i==2) {
					c=coeff[i];
				}else if(i==3) {
					d=coeff[i];
				}		
			}
			try {
				if(power==2) {
		            double disc = (b * b) - (4 * a * c);
		            if (disc >= 0) {
		                double r1 = (-b + Math.sqrt(disc)) / (2 * a);
		                double r2 = (-b - Math.sqrt(disc)) / (2 * a);
		                System.out.println("\t x = " + r1 + " ,\tx' = " + r2);
		            } else {
		                System.out.println("Roots are imaginary.");
		            }
				}else if(power==3) {
					double p = (3*a*c - b*b) / (3*a*a);
					double q = (2*b*b*b - 9*a*b*c + 27*a*a*d) / (27*a*a*a);
					double discriminant = (q*q)/4 + (p*p*p)/27;

					if (discriminant >= 0) {
					    // One real root and two possibly complex roots
					    double u = Math.cbrt(-q/2 + Math.sqrt(discriminant));
					    double v = Math.cbrt(-q/2 - Math.sqrt(discriminant));
					    double root1 = u + v - b/(3*a);
					    System.out.println("Root 1: " + root1);

					    // Complex roots
					    double realPart = -0.5*(u+v) - b/(3*a);
					    double imaginaryPart = Math.sqrt(3)/2 * (u-v);
					    System.out.println("Root 2: " + realPart + " + " + imaginaryPart + "i");
					    System.out.println("Root 3: " + realPart + " - " + imaginaryPart + "i");
					} else {
					    // Three real roots
					    double r = Math.sqrt(-p*p*p/27);
					    double phi = Math.acos(-q/(2*r));
					    double t = 2 * Math.cbrt(r);
					    double root1 = t * Math.cos(phi/3) - b/(3*a);
					    double root2 = t * Math.cos((phi + 2*Math.PI)/3) - b/(3*a);
					    double root3 = t * Math.cos((phi + 4*Math.PI)/3) - b/(3*a);
					    System.out.println("Root 1: " + root1);
					    System.out.println("Root 2: " + root2);
					    System.out.println("Root 3: " + root3);
					}
				}
			}catch (Exception e) {
				System.out.println("Somthing went wrong");
			}
			System.out.println();
			polyNumber++;
		}		
	}
	
	//solve polynomials (addition, subtraction, multiply)
	@Override
	public float[] resultOfPolynomials(List<float[]> polynomialList, int power, char operator){	
		float firstPolynomials[] =null, twoPolynomials[] =null, threePolynomials[] =null, resultPolynomials[]=null;	
		int lenghtOfPolyInput=power+1;
		//for(float coeff[] : polynomialList){
		for (int i = 0; i < polynomialList.size(); i++) {
			if(i==0) {
				firstPolynomials = polynomialList.get(i);	
			}else if(i==1) {
				twoPolynomials = polynomialList.get(i);
			}else if(i==2) {
				threePolynomials = polynomialList.get(i);
			}
		}
		
		switch(operator) {
			case '+':
					resultPolynomials =new float[lenghtOfPolyInput];
					if(twoPolynomials==null) {
						resultPolynomials=firstPolynomials;
					}else if(threePolynomials==null) {
						for(int i=0;i<lenghtOfPolyInput;i++) {
							resultPolynomials[i]=firstPolynomials[i]+twoPolynomials[i];
						}
					}else if(threePolynomials!=null) {
						for(int i=0;i<lenghtOfPolyInput;i++) {
							resultPolynomials[i]=firstPolynomials[i]+twoPolynomials[i]+threePolynomials[i];
						}
					}
					
					break;
			case '-':
					resultPolynomials =new float[lenghtOfPolyInput];
					if(twoPolynomials==null) {
						resultPolynomials=firstPolynomials;
					}else if(threePolynomials==null) {
						for(int i=0;i<lenghtOfPolyInput;i++) {
							resultPolynomials[i]=firstPolynomials[i]-twoPolynomials[i];
						}
					}else if(threePolynomials!=null) {
						for(int i=0;i<lenghtOfPolyInput;i++) {
							resultPolynomials[i]=firstPolynomials[i]-twoPolynomials[i]-threePolynomials[i];
						}
					}
					break;
			case '*':
					if(twoPolynomials==null) {
						resultPolynomials=firstPolynomials;
					}else if(threePolynomials==null) {
						resultPolynomials =multiplyPolynomials(firstPolynomials,twoPolynomials);	
						
//						resultPolynomials[0]=firstPolynomials[0]*twoPolynomials[0];
//						resultPolynomials[1]=(firstPolynomials[0]*twoPolynomials[1])+(firstPolynomials[1]*twoPolynomials[0]);
//						resultPolynomials[2]=(firstPolynomials[0]*twoPolynomials[2])+(firstPolynomials[1]*twoPolynomials[1])+(firstPolynomials[2]*twoPolynomials[0]);
//						resultPolynomials[3]=(firstPolynomials[1]*twoPolynomials[2])+(firstPolynomials[2]*twoPolynomials[1]);
//						resultPolynomials[4]=firstPolynomials[2]*twoPolynomials[2];		

//		         System.out.println("Multiplication = (" + (a1 * a2) + ")x^4 + (" + ((a1 * b2) + (b1 * a2)) + ")x^3 + (" +
//                ((a1 * c2) + (b1 * b2) + (c1 * a2)) + ")x^2 + (" + ((b1 * c2) + (c1 * b2)) + ")x + (" + (c1 * c2) + ")");	
				
					}else if(threePolynomials!=null) {
						resultPolynomials =multiplyPolynomials(firstPolynomials, twoPolynomials);
						resultPolynomials=multiplyPolynomials(resultPolynomials, twoPolynomials);
						
//						resultPolynomials =new float[7];	
//						resultPolynomials[0]=firstPolynomials[0]*twoPolynomials[0];
//						resultPolynomials[1]=(firstPolynomials[0]*twoPolynomials[1])+(firstPolynomials[1]*twoPolynomials[0]);
//						resultPolynomials[2]=(firstPolynomials[0]*twoPolynomials[2])+(firstPolynomials[1]*twoPolynomials[1])+(firstPolynomials[2]*twoPolynomials[0]);
//						resultPolynomials[3]=(firstPolynomials[0]*twoPolynomials[3])+(firstPolynomials[1]*twoPolynomials[2])+(firstPolynomials[2]*twoPolynomials[1])+(firstPolynomials[3]*twoPolynomials[0]);
//						
//						resultPolynomials[4]=(firstPolynomials[1]*twoPolynomials[3])+(firstPolynomials[2]*twoPolynomials[2])+(firstPolynomials[3]*twoPolynomials[1]);
//						resultPolynomials[5]=(firstPolynomials[2]*twoPolynomials[3])+(firstPolynomials[3]*twoPolynomials[2]);	
//						resultPolynomials[6]=firstPolynomials[3]*twoPolynomials[3];		
					}
					break;
		}
		
		return resultPolynomials;
	}
	
	//multiply of polynomials
	@Override
	public float[] multiplyPolynomials(float[] firstPolynomials, float[] twoPolynomials) {
		int degree1 = firstPolynomials.length;
		int degree2 = twoPolynomials.length;
		// Resultant polynomial degree = degree1 + degree2 - 2
		float[] resultPolynomials = new float[degree1 + degree2 - 1];
		
		for (int i = 0; i < degree1; i++) {
		    for (int j = 0; j < degree2; j++) {
		        resultPolynomials[i + j] += firstPolynomials[i] * twoPolynomials[j];
		    }
		}
		return resultPolynomials;
	}
	
	//option of polynomials
	@Override
	public int optionOfPolinomials(Scanner sc, OptionRelativeImpl optionRelative, int numberOfPolinomial) {
		int option=0;
		
		while(true) {
			if(numberOfPolinomial==1) {
				System.out.println("Options :\n\t 1. Roots \n\t"+optionRelative.showOptionNumber());
			}else {
				System.out.println("Options :\n\t 1. Roots \n\t 2. Addition of Polynomials \n\t 3. Subtruction of Polynomials \n\t 4. Multiplication of Polynomials \n\t"+optionRelative.showOptionNumber());
			}
			try {
				System.out.print("Enter Option : ");
	    			option=sc.nextInt();
	    			if((option>0 && option<5)||(option>10 && option<14)) {
	    				break;
	    			}else {
	    				System.out.println("this option is not available, try again \n");
	    			}
			}catch (Exception e) {
				sc.nextLine();
				System.out.println(optionRelative.errorWrongInputNumber());	     
			}
		}
		return option;
	}
}