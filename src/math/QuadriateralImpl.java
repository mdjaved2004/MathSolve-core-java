package math;

import java.util.Scanner;

public class QuadriateralImpl implements Quadriateral{
	
	@Override
	public int quadriateral() {
		int option=0;
		Scanner sc = new Scanner(System.in);
		OptionRelativeImpl optionRelative = new OptionRelativeImpl();
		StringToNumberImpl stringToNumber = new StringToNumberImpl();
		while(true){
			System.out.println(optionRelative.welcom("Quadriateral"));
		   while(true) {
				try {
					//\tTrapezoid = 3 \tParallelogram = 4 \tIsosceies = 5 \t Quadriateral = '6'\n
					System.out.println("Options :\n\t Rectangle = 1 \n\t Square = 2 \n\t"+optionRelative.showOptionNumber());
					System.out.print("Enter the option : ");
					option=sc.nextInt();
					if(option==1 || option==2 || option==11 || option==12 || option==13){
					     if(option==1) {
					    	  	option=rectangle(optionRelative, option, sc);
					     }else if(option==2) {
					    	 	option=square(optionRelative, option, sc);
					     }else {
					    	 	break;
					     }
					}else {
						System.out.println("Only number allow , Try again ");
					}
				}catch (Exception e) {
					sc.nextLine();
					System.out.println(optionRelative.errorWrongInputNumber());	     
				}
				if(option==11 || option==12 || option==13){
					   break;
				  }
		   }
		   if(option==11 || option==12 || option==13){
			   break;
		   }
		}
	return option;
            
	}
	
	@Override
	public int rectangle(OptionRelativeImpl optionRelative, int option, Scanner sc) {
		System.out.print(optionRelative.welcom("RECTANGLE"));                                 
	
		char operator;
		float length,width;
		while(true){
			try {
				System.out.print("Enter Rectangle length = ");
				length=sc.nextFloat();
				System.out.print("Enter Rectangle width = ");
				width=sc.nextFloat();
				break;
			}catch (Exception e) {
				sc.nextLine();
				System.out.println("Only allow number , try again");
			}
		}
		while(true){
			try {
				System.out.println("\nOptions :\n\t Area = 'A' \tPerimeter = 'P' \t Diagonal == 'D' \n\t"+optionRelative.showOption());
				System.out.print("Enter operation : ");
				operator=sc.next().charAt(0);
				if( operator=='b' || operator=='h' || operator=='e') {
					option=optionRelative.textToNumber(String.valueOf(operator));
					break;
				}else if(operator=='A' || operator=='P' || operator=='D') {
					switch(operator) {
						case 'A'://find the area of rectangle.
							System.out.println("Area of the Rectangle = "+ length*width);
							break;
						case 'P': //find the perimeter of rectangle.
							System.out.println("Perimeter of the Rectangle  = "+2*(length+width));
							break; 
						case 'D': //find diagonal of the rectangle.
							System.out.println(" Diagonal of the Rectangle  = "+Math.sqrt((length*length)+(width*width)));  
							break;                    
						default:
							System.out.print("\n");
					} 
					try {
						System.out.println("\nOptions :\n\t 1. Same height and width but different operators  \n\t "+optionRelative.showOptionNumber());
						System.out.print("Choose Option : ");
						option=sc.nextInt();
						if(option==11 || option==12 ||option==13) {
							break;
						}
					}catch (Exception e) {
						sc.nextLine();
						System.out.println("Only allow number , try again");
					}
				}else {
					System.out.println("Invalid option , try again");
				}
			}catch (Exception e) {
				sc.nextLine();
				System.out.println("Invalid option , try again");
			}
		}
		if(option==11) {
			option=-1;
		}
		return option;     
	}
	
	@Override
	public int square(OptionRelativeImpl optionRelative, int option, Scanner sc) {
		System.out.print(optionRelative.welcom("SQUARE"));
        char operator;
     	float side;
     	while(true){
			try {
				System.out.print("enter the  side of square ");
				side=sc.nextFloat();	
				break;
			}catch (Exception e) {
				sc.nextLine();
				System.out.println("Only allow number , try again");
			}
		}
           
     	while(true){
			try {
				System.out.println("\nOptions :\n\t Area = 'A' \tPerimeter = 'P' \t Diagonal == 'D' \n\t "+optionRelative.showOption());
				System.out.print("Enter operation ");
				operator=sc.next().charAt(0);
				if( operator=='b' || operator=='h' || operator=='e') {
					option=optionRelative.textToNumber(String.valueOf(operator));
					break;
				}else if(operator=='A' || operator=='P' || operator=='D') {
					switch(operator) {
		                case 'A':
		                        System.out.println("Area of the Square = "+ side*side);
		                        break;
		                case 'P': 
		                        System.out.println("Perimeter of the Square = "+4*side);
		                        break; 
		                 case 'D': System.out.println("Diagonal of the Square  = "+side*Math.sqrt(2));  
		                             break;                    
		                default:System.out.print("\n");
		                
	                   }                
	     
					try {
						System.out.println("\nOptions :\n\t 1. side but different operators  \n\t "+optionRelative.showOptionNumber());
						System.out.print("Choose Option : ");
						option=sc.nextInt();
						if(option==11 || option==12 ||option==13) {
							break;
						}
					}catch (Exception e) {
						sc.nextLine();
						System.out.println("Only allow number , try again");
					}
				}else {
					System.out.println("Invalid option , try again");
				}
			}catch (Exception e) {
				sc.nextLine();
				System.out.println("Invalid option , try again");
			}
		}
		if(option==11) {
			option=-1;
		}
		return option;
     	
	}

}

