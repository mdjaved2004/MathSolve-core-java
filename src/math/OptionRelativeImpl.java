package math;

public class OptionRelativeImpl implements OptionRelative{
	
	@Override
	public String showOption() {	
		return "(back=b, Home page=h, exit program=e) \n\t";
    }
	
	@Override
	public String showOptionNumber() {	
		return "(back=11, Home page=12, exit program=13) \n\t";
    }
	
	@Override
	public String errorWrongInputNumber() {	
		return "Invalid Option, Only number allow.";
    }
	
	@Override
	public int textToNumber(String text) {
		if(text.equals("b") ) {
			return 11;
		}else if(text.equals("h")) {
			return 12;
		}else if(text.equals("e")) {
			return 13;
		}else {
			 return -1;
		}
    }
	
	@Override
	public int option11(int number) {
		if(number==11) {
			return -1;
		}
		else {
			return number;
		}
			
    }
	
	@Override
	public String welcom(String welcomName) {	
		welcomName=welcomName.trim().toUpperCase();
		return "\n\t\t\t\t\t>> WELCOME TO "+welcomName+ " <<\n";
    }
	
	@Override
	public boolean checkOption(String text) {
		if(text.equals("b") || text.equals("h") || text.equals("e")) {
			return true;
		}
		else {
			return false;
		} 
    }	
}
