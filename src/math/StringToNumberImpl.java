package math;

public class StringToNumberImpl implements StringToNumber{
	
	@Override
	public boolean checkOneCharacter(char onechar) {
		return onechar=='0' || onechar=='1' || onechar=='2' || onechar=='3' || onechar=='4' ||
						onechar=='5' || onechar=='6' || onechar=='7' || onechar=='8' || onechar=='9';
		
	}
	
	@Override
	public boolean checkString(String number) {
		for(int i=0;i<number.length();i++) {
			char onechar=number.charAt(i);
			if(onechar=='0' || onechar=='1' || onechar=='2' || onechar=='3' || onechar=='4' ||
					onechar=='5' || onechar=='6' || onechar=='7' || onechar=='8' || onechar=='9'){			
			}else {
				return false;
			}			
		}
		return true;
	}
}
