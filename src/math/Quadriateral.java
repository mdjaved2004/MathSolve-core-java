package math;

import java.util.Scanner;

import math.OptionRelativeImpl;

public interface Quadriateral {
	
	int quadriateral();
	
	int rectangle(OptionRelativeImpl optionRelative, int option, Scanner sc);
	
	int square(OptionRelativeImpl optionRelative, int option, Scanner sc);
}

