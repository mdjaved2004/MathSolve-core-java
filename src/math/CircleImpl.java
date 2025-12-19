package math;

import java.util.Scanner;

public class CircleImpl implements Circle {
	
	@Override
	public int circle() {
	    int option=0;
		char operator;
		float redius;
		
		Scanner sc = new Scanner(System.in);
		OptionRelativeImpl optionRelative = new OptionRelativeImpl();
		while(true){
			System.out.println(optionRelative.welcom("Matrix"));
			System.out.print("Enter the redius ");
		   while(true) {
				try {
					redius=sc.nextFloat();
					if(redius<=0){
					     System.out.print("Redius, Negative value Not accepted \n");
					     System.out.print("Again, Enter the redius");
					}else {	
						break;
					}
				}catch (Exception e) {
					sc.nextLine();
					System.out.println(optionRelative.errorWrongInputNumber());	     
				}
		   }

			System.out.println("Options :\n\t Area = 'A' \tDiameter = 'D' \tCircumfarence = 'C' Semicircle aria = 'S'  \n\t"+optionRelative.showOption());
			 
			System.out.print("Enter the operator : ");
					
			  while(true) {
					try {
						operator=sc.next().charAt(0);
						if(operator=='A' || operator=='D' || operator=='C' || operator=='S' || operator=='b' || operator=='h' || operator=='e') {
							if(operator=='b' || operator=='h' || operator=='e') {
								option=optionRelative.textToNumber(String.valueOf(operator));
								break;												
							}else {
								circleOutput(operator,redius);
								try {
										System.out.println("Options :\n\t 1. Same redius different operators  \n\t "+optionRelative.showOptionNumber());
										System.out.print("Choose Option : ");
										option=sc.nextInt();
										if(option==11 || option==12 ||option==13) {
											break;
										}
								}catch (Exception e) {
									sc.nextLine();
									System.out.println("Only allow number , try again");
								}
							}			
						}
					}catch (Exception e) {
						sc.nextLine();
						System.out.println("This Operator is not available");	     
					}
			   }	  
			  if(option==11 || option==12 ||option==13) {
					break;
				}
		}
		return option;
	}
	
	@Override
	public void circleOutput(char operator,float redius){
		switch(operator) {
	         case 'A':
                 System.out.println("Area of the circle = "+ 3.14*redius*redius);
                 break;
		     case 'D': 
		         System.out.println("Diameter of a circle = "+2*redius);
		         break;
		     case 'C':
                 System.out.println("Circumfarence of a circle = "+2*3.14*redius);
                 break;
		     case 'S':   
		    	 	System.out.println("Area of a Semicircle  = "+(3.14*redius*redius)/2);
		    	 	break;
		     
		     default:
                 System.out.print("\n");
		}
	     
	
	}

}
 
