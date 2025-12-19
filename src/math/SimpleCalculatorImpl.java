package math;

import java.util.Scanner;

//This class is Simple SimpleCalculator
public class SimpleCalculatorImpl implements SimpleCalculator {
	
	//This method is entry point to simple calculator
	@Override
	public int calculate() {
		int option=0;
		
		OptionRelativeImpl optionRelative=new OptionRelativeImpl();
		StringToNumberImpl stringToNumber = new StringToNumberImpl();
		Scanner sc=new Scanner(System.in);
		System.out.println(optionRelative.welcom("Simple_calculater"));
		
		while(true) {
			System.out.println("Options :\n\t1. Simple Calculate \n\t2. Squre \n\t3. Squre Root \n\t4. Cube \n\t5. Cube Root \n\t6. Table \n\t"+optionRelative.showOptionNumber()+"\n ");
			System.out.print("Choose option (only number) :");
			try {
				option = sc.nextInt();
				sc.nextLine();
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("");
				System.out.println("You are choosen Wrong OptionRelative");
			}
			switch(option) {
				case 1:// simple calculate.
					option=simpleCalculate(optionRelative, stringToNumber, sc);
					break;
				case 2:// Find square value.
					option=square(optionRelative, stringToNumber, sc);
					break;
				case 3:// Find squareRoot value.
					option=squareRoot(optionRelative, stringToNumber, sc);
					break;
				case 4:// Find cube value.
					option=cube(optionRelative, stringToNumber, sc);
					break;
				case 5:// Find cubeRoot value.
					option=cubeRoot(optionRelative, stringToNumber, sc);
					break;
				case 6:
					option=table(optionRelative, stringToNumber, sc);
					break;
				default:
					System.out.println("number is nut valid");
			}
			//back=0, Home page=8, exit program=9
			if(option==11 ||option==12 ||option==13) {
				break;
			}
		}
		
		return option;
		
	}
	
		
	/* this method performance the addition, subtraction, multiply and devision use
	 * single line input
	 */
	@Override
	public int simpleCalculate(OptionRelativeImpl optionRelative, StringToNumberImpl stringToNumber, Scanner sc){
		char operator='*';
		boolean validation=true;
		float result=0.00f;
		
		System.out.println("\t\t\t\t\t>> WELCOME TO Simple calculater <<\n");
		String element="",temp="";
		
		while(true) {
			// showText() ------> Show the option
			System.out.print("ENTER VALUE AND OPRATOR ONE LINE "+optionRelative.showOption());
			element=sc.nextLine();
			element=element.trim();
			//check string are b, h, e
			if(optionRelative.checkOption(element)) {
				break;
			}
			for(int i=0;i<element.length();i++) {
				char onechar=element.charAt(i);
				if(onechar=='+' || onechar=='-' || onechar=='*' || onechar=='/') {
					if(operator=='*') {
						if(temp=="")temp="0";
						operator=onechar;
						result=Float.parseFloat(temp);
						temp="";		
					}else {
						result =Float.parseFloat(logicSimpleCalculate(result,operator,temp));
						operator=onechar;
						temp="";
					}		
				}else if(onechar=='0' || onechar=='1' || onechar=='2' || onechar=='3' || onechar=='4' ||
						onechar=='5' || onechar=='6' || onechar=='7' || onechar=='8' || onechar=='9' ||onechar=='='){		
					if(i==(element.length()-1) && onechar!='='){
						temp+=onechar;
						if(operator=='*') {
							operator=onechar;
							result=Float.parseFloat(temp);
							temp="";		
						}else {
							result =Float.parseFloat(logicSimpleCalculate(result,operator,temp));
						}
						temp="";	
					}else if(onechar=='='){
						result =Float.parseFloat(logicSimpleCalculate(result,operator,temp));
						temp="";
					}else {
						temp+=onechar;
					}
					
				}else {
					System.out.println("Invalid input . Only allow nummber");
					validation=false;
				}
			}	
			if(validation) {
				System.out.println("Result(left to right) = "+result+"\n");
			}else {
				validation=true;
			}	
			result=0.00f;
			temp="";
			operator='*';
			element="";
		}
		
		return optionRelative.option11(optionRelative.textToNumber(element));
	}
	
	//inner this method to write some logic to Simple calculator 
	@Override
	public String logicSimpleCalculate(Float result,char operator, String temp) {
		if(temp=="") {
			temp="0";
		}
		if (operator == '/' && result == 0.00) {
			System.out.println("Division by zero is not allowed.");
			return 0+"";
		}else {
			result = (operator == '+') ? result + Float.parseFloat(temp) :
				(operator == '-') ? result - Float.parseFloat(temp) :
					(operator == '*') ? result * Float.parseFloat(temp) :
						(operator == '/') ? result / Float.parseFloat(temp) : result;
			return result+"";
		}
	}
	
	@Override
	public int square(OptionRelativeImpl optionRelative, StringToNumberImpl stringToNumber, Scanner sc) {
		String number="";
		
		while(true) {
			System.out.print("\nENTER VALUE TO FIND SQURE "+optionRelative.showOption());
			number=sc.nextLine();
			number=number.trim();
			if(optionRelative.checkOption(number)) {
				break;
			}else if(stringToNumber.checkString(number)) {
				System.out.println("Result = "+(Float.parseFloat(number) *Float.parseFloat(number)));
			}else {
				System.out.println("Only number allow, Try again");
			}	
		}
		
		return optionRelative.option11(optionRelative.textToNumber(number));		
	}
	
	@Override
	public int squareRoot(OptionRelativeImpl optionRelative, StringToNumberImpl stringToNumber, Scanner sc) {
		String number="";
		
		while(true) {
			System.out.print("\nENTER NUMBER TO FIND SQUREROOT "+optionRelative.showOption());
			number=sc.nextLine(); 
			number=number.trim();
			if(optionRelative.checkOption(number)) {
				break;
			}else if(stringToNumber.checkString(number)) {
				System.out.println("Result = "+Math.sqrt(Float.parseFloat(number)));
			}else {
				System.out.println("Only number allow(1,2,3,...) , Try again");
			}	
		}
		
		return optionRelative.option11(optionRelative.textToNumber(number));		
	}
	
	@Override
	public int cube(OptionRelativeImpl optionRelative, StringToNumberImpl stringToNumber, Scanner sc) {
		String number="";
		
		while(true) {
			System.out.print("\nENTER VALUE TO FIND CUBE "+optionRelative.showOption());
			number=sc.nextLine(); 
			number=number.trim();
			if(optionRelative.checkOption(number)) {
				break;
			}else if(stringToNumber.checkString(number)) {
				System.out.println("Result = "+(Float.parseFloat(number)*Float.parseFloat(number)*Float.parseFloat(number)));
			}else {
				System.out.println("Only number allow, Try again");
			}	
		}
		
		return optionRelative.option11(optionRelative.textToNumber(number));		
	}
	
	@Override
	public int cubeRoot(OptionRelativeImpl optionRelative, StringToNumberImpl stringToNumber, Scanner sc) {
		String number="";
		
		while(true) {
			System.out.print("\nENTER VALUE TO FIND SQUREROOT "+optionRelative.showOption());
			number=sc.nextLine(); 
			number=number.trim();
			if(optionRelative.checkOption(number)) {
				break;
			}else if(stringToNumber.checkString(number)) {
				System.out.println("Result = "+Math.cbrt(Float.parseFloat(number)));
			}else {
				System.out.println("Only number allow, Try again");
			}	
		}
		
		return optionRelative.option11(optionRelative.textToNumber(number));		
	}
	
	@Override
	public int table(OptionRelativeImpl optionRelative, StringToNumberImpl stringToNumber, Scanner sc) {
		String number="";
		
		while(true) {
			System.out.print("\nENTER VALUE TO FIND TABLE "+optionRelative.showOption());
			number=sc.nextLine(); 
			number=number.trim();
			if(optionRelative.checkOption(number)) {
				break;
			}else if(stringToNumber.checkString(number)) {
				System.out.println("Table of "+number+" :-");
				for(int i=1;i<=10;i++) {
					System.out.println("\t"+number+"*"+i+" = "+ (Integer.parseInt(number)*i));
				}
			}else {
				System.out.println("Only number allow, Try again \n");
			}	
		}
		
		return optionRelative.option11(optionRelative.textToNumber(number));		
	}
	
}
