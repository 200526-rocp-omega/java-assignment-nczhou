package com.revature.eval.java.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluationService {

	/**
	 * 1.A Speed Converter - Convert to MilesPerHour
	 * 
	 * Write a method called toMilesPerHour that has 1 parameter of type double with
	 * the name kilometersPerHour. This method needs to return the rounded value of
	 * the calculation of type long.
	 * 
	 * If the parameter kilometersPerHour is less than 0, the method toMilesPerHour
	 * needs to return -1 to indicate an invalid value.
	 * 
	 * Otherwise if it is positive, calculate the value of miles per hour, round it
	 * and return it. For conversion and rounding use Math.round().
	 */
	static class SpeedConverter {

		public static long toMilesPerHour(double kilometersPerHour) {
//			1 mile = 1.609 km,   1 km = 0.6214 mile
//			3 methods to process: multiplication, division and Math Class
			//may have very little different on round-up s
//			Should be able to run any of them when un-commented
			
			double milesPerHourRounded;
			long toMPH;
			
			if (kilometersPerHour < 0) {
				return -1;
			} else {
				milesPerHourRounded = Math.round(kilometersPerHour / 1.609);
			//      milesPerHourRounded = Math.round(kilometersPerHours*0.6214);   
            //      can be substituted 	
                toMPH = (long) milesPerHourRounded;
				return toMPH;
			}
			
					
			
		}

		/**
		 * 1.B Speed Converter - Print Conversion
		 * 
		 * Write another method called printConversion with 1 parameter of type double
		 * with the name kilometersPerHour. This method needs to return a String and
		 * needs to calculate milesPerHour from the kilometersPerHour parameter.
		 * 
		 * The String should print in the format: "XX km/h = YY mi/h"
		 * 
		 * XX represents the original value kilometersPerHour. YY represents the rounded
		 * milesPerHour from the kilometersPerHour parameter.
		 * 
		 * If the parameter kilometersPerHour is < 0, then print the text "Invalid
		 * Value"
		 */
		public static String printConversion(double kilometersPerHour) {
			
			String InvV = "Invalid Value";
			if(kilometersPerHour < 0) {
				System.out.println(InvV);
				
				return InvV;
				
			} else { 
				String KmMi =  kilometersPerHour + " km/h = " + toMilesPerHour(kilometersPerHour) + " mi/h";
				System.out.println(KmMi);
				return KmMi;
			}
			
		}
		}
	

	/**
	 * 2. MegaBytes and KiloBytes
	 * 
	 * Write a method called printMegaBytesAndKiloBytes that has 1 parameter of type
	 * int with the name kiloBytes.
	 * 
	 * The method should return a String and it needs to calculate the megabytes and
	 * remaining kilobytes from the kilobytes parameter.
	 * 
	 * Then it needs to print a message in the format "XX KB = YY MB and ZZ KB".
	 * 
	 * XX represents the original value kiloBytes. YY represents the calculated
	 * megabytes. ZZ represents the calculated remaining kilobytes.
	 * 
	 * For examples, when the parameter kiloBytes is 2500 it needs to print "2500 KB
	 * = 2 MB and 452 KB"
	 * 
	 * If the parameter kiloBytes is less than 0 then print the text "Invalid
	 * Value".
	 */
	public String printMegaBytesAndKiloBytes(int kiloBytes) {
		
		final int KBinMB = 1024;
		if(kiloBytes < 0) {
			return "Invalid Value";
		}
		int mb = kiloBytes / KBinMB;                
                           // get whole number 
		int kb = kiloBytes % KBinMB;                 
                           // get remainder 
		String printMbAndKb = kiloBytes + " KB = " + mb + " MB and " + kb + " KB";
		return printMbAndKb;
	
	
	}

	/**
	 * 3. Barking Dog
	 * 
	 * We have a dog that loves to bark. We need to wake up if the dog is barking at
	 * night!
	 * 
	 * Write a method shouldWakeUp that has 2 parameters.
	 * 
	 * 1st parameter should be of type boolean and be named "barking". It represents
	 * if our dog is currently barking. 2nd parameter represents the hour of the day
	 * and is of type int with the name hourOfDay and has a valid range of 0-23.
	 * 
	 * We have to wake up if the dog is barking before 8 or after 22 hours, so in
	 * that case return true.
	 * 
	 * In all other cases return false.
	 * 
	 * If the hourOfDay parameter is less than 0 or greater than 23, return false.
	 */
	public boolean shouldWakeUp(boolean isBarking, int hourOfDay) {
		
		
			
			if(hourOfDay > 23 || hourOfDay < 0 || !isBarking) { 
						return false;
					}
					
			if(isBarking &&(hourOfDay < 8 || hourOfDay >22)) { 
						return true;
					}
					return false; 
		
	}

	/**
	 * 4. DecimalComparator
	 * 
	 * Write a method areEqualByThreeDecimalPlaces with two parameters of type
	 * double.
	 * 
	 * The method should return boolean and it needs to return true if two double
	 * numbers are the same up to three decimal places.
	 * 
	 * Otherwise, return false;
	 */
	public boolean areEqualByThreeDecimalPlaces(double firstNum, double secondNum) {

		if (Math.floor(Math.abs(firstNum) * 1000) == Math.floor(Math.abs(secondNum) * 1000)) {
			return true;
		} else {
			return false;
		}
	
	
	
	}

	/**
	 * 5. Teen Number Checker
	 * 
	 * We'll say that a number is "teen" if it is in the range 13 -19 (inclusive).
	 * Write a method named hasTeen with 3 parameters of type int.
	 * 
	 * The method should return boolean and it needs to return true if ONE of the
	 * parameters is in range 13(inclusive) - 19 (inclusive). Otherwise return
	 * false.
	 */
	static class TeenNumberChecker {

		public static boolean hasTeen(int x, int y, int z) {

			int[] range = {x,y,z};
			for(int i : range) {
				if(isTeen(i)) return true; // loops through input, if one is true then it 'has teen'
			}
			return false;
		}

		// We can initialize isTeen method first
		// Then pass the parameter to hasTeen method

		public static boolean isTeen(int number) {

			if(number >= 13 && number <=19) {
				return true;            // if number is in 13-19 range (inclusive), it is a 'teen'
			}
			
			return false;
		}
	}

	/**
	 * 6. Minutes To Years and Days Calculator
	 * 
	 * Write a method printYearsAndDays with parameter of type long named minutes.
	 * The method should not return anything (void) and it needs to calculate the
	 * years and days from the minutes parameter.
	 * 
	 * If the parameter is less than 0, print text "Invalid Value".
	 * 
	 * Otherwise, if the parameter is valid then it needs to print a message in the
	 * format "XX min = YY y and ZZ d".
	 * 
	 * XX represents the original value minutes. YY represents the calculated years.
	 * ZZ represents the calculated days.
	 */
	public String printYearsAndDays(long minutes) {

		if(minutes < 0L) {
			return "Invalid Value"; 
		}
		
		final long MINUTES_PER_DAY = 1440L;
		
		final int DAYS_PER_YEAR = 365;
		
		int daysTotal = (int) (minutes/MINUTES_PER_DAY);             // total number of days
		int years = daysTotal/DAYS_PER_YEAR;                         // total number of years
		int daysLeft = daysTotal%DAYS_PER_YEAR;                      // days over whole year
		
		return (minutes + " min = " + years + " y and " + daysLeft + " d");
		
	}

	/**
	 * 7. Number In Word
	 * 
	 * Write a method called printNumberInWord. The method has one parameter number
	 * which is the whole number. The method needs to print "ZERO", "ONE", "TWO",
	 * ... "NINE", "OTHER" if the int parameter number is 0, 1, 2, .... 9 or other
	 * for any other number including negative numbers. You can use if-else
	 * statement or switch statement whatever is easier for you.
	 */
	public String printNumberInWord(int number) {

		switch(number) { 
		case 0: return "ZERO"; 
		case 1: return "ONE";
		case 2: return "TWO"; 
		case 3: return "THREE"; 
		case 4: return "FOUR"; 
		case 5: return "FIVE"; 
		case 6: return "SIX";
		case 7: return "SEVEN";
		case 8: return "EIGHT";
		case 9: return "NINE"; 
		default: return "OTHER";
		}
	}

	/**
	 * 8. Greatest Common Divisor
	 * 
	 * Write a method named getGreatestCommonDivisor with two parameters of type int
	 * named first and second.
	 * 
	 * If one of the parameters is < 10, the method should return -1 to indicate an
	 * invalid value. The method should return the greatest common divisor of the
	 * two numbers (int).
	 * 
	 * The greatest common divisor is the largest positive integer that can fully
	 * divide each of the integers (i.e. without leaving a remainder).
	 * 
	 * For example 12 and 30: 12 can be divided by 1, 2, 3, 4, 6, 12 30 can be
	 * divided by 1, 2, 3, 5, 6, 10, 15, 30
	 * 
	 * The greatest common divisor is 6 since both 12 and 30 can be divided by 6,
	 * and there is no resulting remainder.
	 */
	public int getGreatestCommonDivisor(int first, int second) {

		int greatestCommonDivisor = 0;
		int least;
		int greatest;
		int comparison;
		
		if(first < 10 || second < 10) {
			return -1;
		}
		
		comparison = first - second;
		if (comparison < 1) {
			greatest = second;
			least = first;
		} else {
			greatest = first;
			least = second;
		}

		
		for(int i = 1; i <= least; i++) {
			if((least % i == 0) && (greatest % i == 0)) {
				greatestCommonDivisor = i;
			}	
		}

		return greatestCommonDivisor;
	}
	

	/**
	 * 9. First and Last Digit Sum
	 * 
	 * Write a method named sumFirstAndLastDigit with one parameter of type int
	 * called number.
	 * 
	 * The method needs to find the first and the last digit of the parameter number
	 * passed to the method, using a loop and return the sum of the first and the
	 * last digit of that number.
	 * 
	 * If the number is negative then the method needs to return -1 to indicate an
	 * invalid value.
	 */
	public int sumFirstAndLastDigit(int num) {
		 
		List<Integer> numberList = new ArrayList<>();
	        int number = num;
	        int total;
	       
	        if(num < 0) {
				return -1;
			} else {
		        while(number > 0) {
		        	numberList.add(number % 10);
		        	number /= 10;
		        }
		        
		        if (num < 10) {
		        	return num;
		        } else {
			        total = numberList.get(0) + numberList.get(numberList.size() - 1);
			        return total;
		        }
			}
	}

	/**
	 * 10. Reverse String
	 * 
	 * Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 */
	public String reverse(String string) {

		char[] characters = new char[string.length()];
		int c = 0;
		
		for(int i = string.length() - 1; i >= 0; i--){
			characters[c] = string.charAt(i);
			
		 				
		 	c++;
		}
		String reverseString = new String(characters);
		return reverseString;
		
	
	}

	/**
	 * 11. Acronyms
	 * 
	 * Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 */
	public String acronym(String phrase) {
		String str = "";
		String strToUpperCase = "";
		//System.out.println(phrase.split(",\\s|\\s|,|-"));
		
		for(String word : phrase.split(",\\s|\\s|,|-")) {
			str += word.charAt(0);
			//System.out.println(str);
		}
		strToUpperCase = str.toUpperCase();
		return strToUpperCase;
	
	
	}

	/**
	 * 12. Triangles
	 * 
	 * Determine if a triangle is equilateral, isosceles, or scalene. An equilateral
	 * triangle has all three sides the same length. An isosceles triangle has at
	 * least two sides the same length.
	 * 
	 * (It is sometimes specified as having exactly two sides the same length, but
	 * for the purposes of this exercise we'll say at least two.) A scalene triangle
	 * has all sides of different lengths.
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			if(this.getSideOne() == this.getSideTwo() && this.getSideOne() == this.getSideThree()) {
				return true;
			} else {
				return false;
			}
			
		}

		public boolean isIsosceles() {
			if((this.getSideOne() == this.getSideTwo()) || (this.getSideOne() == this.getSideThree() || this.getSideTwo() == this.getSideThree())) {
				return true;
			} else {
				return false;
			}
		}

		public boolean isScalene() {
			if((this.getSideOne() != this.getSideTwo()) && (this.getSideOne() != this.getSideThree()) && (this.getSideTwo() != this.getSideThree())) {
				return true;
			} else {
				return false;
			}
		}

	}

	/**
	 * 13. Scrabble Score
	 * 
	 * Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 */
	public int getScrabbleScore(String string) {
		String str = string.toUpperCase();
		int points = 0;

		for(int i = 0; i < str.length(); i++) {
			switch(str.charAt(i)) {
			case 'A':
				points += 1;
				break;
			case 'E':
				points += 1;
				break;
			case 'I':
				points += 1;
				break;
			case 'O':
				points += 1;
				break;
			case 'U':
				points += 1;
				break;
			case 'L':
				points += 1;
				break;
			case 'N':
				points += 1;
				break;
			case 'R':
				points += 1;
				break;
			case 'S':
				points += 1;
				break;
			case 'T':
				points += 1;
				break;
			case 'D':
				points += 2;
				break;
			case 'G':
				points += 2;
				break;
			case 'B':
				points += 3;
				break;
			case 'C':
				points += 3;
				break;
			case 'M':
				points += 3;
				break;
			case 'P':
				points += 3;
				break;
			case 'F':
				points += 4;
				break;
			case 'H':
				points += 4;
				break;
			case 'V':
				points += 4;
				break;
			case 'W':
				points += 4;
				break;
			case 'Y':
				points += 4;
				break;
			case 'K':
				points += 5;
				break;
			case 'J':
				points += 8;
				break;
			case 'X':
				points += 8;
				break;
			case 'Q':
				points += 10;
				break;
			case 'Z':
				points += 10;
				break;
			}
		}
		
		return points;
	}
		
		
	/**
	 * 14. Clean the Phone Number
	 * 
	 * Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		
		String noSpace;
		String noDash;
		String noOpenParenthesis;
		String noCloseParenthesis;
		String noNumOne;
		String noPlusSign;
		String noDots;
		Long number;
		
		noDash = string.replaceAll("-","");
		noOpenParenthesis = noDash.replaceAll("\\(","");
		noCloseParenthesis = noOpenParenthesis.replaceAll("\\)","");;
		noPlusSign = noCloseParenthesis.replaceAll("\\+","");;
		noDots = noPlusSign.replaceAll("\\.","");;
		noSpace = noDots.replaceAll("\\s","");
		
		
		if (noSpace.charAt(0) == '1') {
			noNumOne = noSpace.substring(1);
		} else {
			noNumOne = noSpace;
		}
		
		
		if(noNumOne.length() > 10) {
			throw new IllegalArgumentException("must be less than 11");
		}

		number = Long.parseLong(noNumOne);
        System.out.println(number);	
		

        return noNumOne;
	}

	/**
	 * 15. Recurring Word Counter
	 * 
	 * Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 */
	public Map<String, Integer> wordCount(String string) {

		String[] str = string.split(",\\n|\\s|,");
		String[] str2 = str;
		for(int i = 0; i < str.length; i++) {
			System.out.println(str.length);
			System.out.println("first line  " + str[i]);
			System.out.println("second line  " + str2[i]);
		}
		
		Map<String, Integer> wordCountTotal = new HashMap<>();
		
		for(int i = 0; i < str.length; i++) {
			int counter = 0;
			for(int j = 0; j < str.length; j++) {
				if(str[i].equals(str2[j])) {
					counter++;
				}
			}
			wordCountTotal.put(str[i], counter);
			System.out.println(wordCountTotal);
		}		
		return wordCountTotal;
	}

	/**
	 * 16. Armstrong Number
	 * 
	 * An Armstrong number is a number that is the sum of its own digits each raised
	 * to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 */
	public boolean isArmstrongNumber(int input) {
		
		boolean armstrong = false;
		int checkInput = 0;
		String inputString = "" + input; // converts to string for an easy char array
		double length = inputString.length(); // Used for Math.pow
		for(int i = 0; i < inputString.length(); i++) { // Loop through each character
			String charSegment = "" +inputString.charAt(i);
			checkInput = (int) (checkInput + Math.pow(Double.parseDouble(charSegment), length));
			// In the above, we get the sum of each char raised to the 'length' power.
			// For example, if we got 123 input, checkInput should go 1^3 + 2^3 + 3^3 because it is 3 characters long
		}
		if(input == checkInput) {
			armstrong = true;
		}
		return armstrong;
	}


	/**
	 * 17. Prime Factors
	 * 
	 * Compute the prime factors of a given natural number. A prime number is only
	 * evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		
		List<Long> factors = new ArrayList<>(); 
		
        for (int i = 2; i <= l / i; i++) { 
             while (l % i == 0) { 
                  factors.add((long) i);
                  l /= i;
                  }
            }
        
        if (l > 1) { 
            factors.add(l);
        }
        return factors;
		
	}
	
	public boolean isPrime(long num) { 
		if(num==0 || num == 1) { 
			return false; 
		} 
		for(int i = 2; i <= (num / 2); i++) { 
			if(num%i == 0) { 
				return false; 
			}
		}		
		return true; 
	}

	/**
	 * 18. Calculate Nth Prime
	 * 
	 * Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 */
	public int calculateNthPrime(int k) {
		if(k < 1) {
			throw new IllegalArgumentException();
		}
		int count = 1; 
		int lastPrime = 2;  
		while(count < k) {  
			boolean loop = true;  
			int i = lastPrime;  
			while(loop) { 
				i++;  

				if(isPrime(i)) {  
					lastPrime = i;  
					loop = false; 
				}				
			}
			count++;  
		}
		return lastPrime;  
	}
	
	/**
	 * 19. Pangram
	 * 
	 * Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 */
	public boolean isPangram(String string) {

			
			List<Character> characters = new ArrayList<Character>();
			List<Character> charactersList = new ArrayList<Character>();
			String stringToLowerCase = string.toLowerCase();
			
			for(char c : stringToLowerCase.toCharArray()) {
				characters.add(c);
			}
			
			for(int i = 0; i < characters.size(); i++) {
				for(char c = 'a'; c <= 'z'; c++){
					if(characters.get(i) == c) {
						if(!charactersList.contains(characters.get(i))){
							charactersList.add(c);
						}				
					}
				}
			}
			
			for(char c = 'a'; c <= 'z'; c++){
				if(!charactersList.contains(c)) {
					return false;
				}
			}
			
			return true;
	
	}

	/**
	 * 20. Sum of Multiples 
	 * 
	 * Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 */
	public int getSumOfMultiples(int i, int[] set) {
		List<Integer> multiplesNumber = new ArrayList<>();
		int total = 0;
		int counter = 0;
		
		for(int j = 1; j < i; j++) {
			counter = 0;
			for(int x = 0; x < set.length; x++) {
				if(j % set[x] == 0 && counter == 0) {
					multiplesNumber.add(j);
					counter = 1;
				}
				
			}
		}
		
		for(int j = 0; j < multiplesNumber.size(); j++) {
			total += multiplesNumber.get(j);
		}
		
		return total;
	}
	
	/**
	 * 21. Three Magic Numbers
	 * 
	 * You work at a casino in Las Vegas.  Your job is to program a slot machine to
	 * return 3 random numbers using the java.util.Random class.
	 * 
	 * Write a method to return an int array of 3 random numbers between 1 - 100.
	 * Generate the 3 random numbers (1 - 100 inclusive) using the java.util.Random class.
	 */
	
	public int[] threeLuckyNumbers() {
			int[] magicNumbers = new int[3];
			
			for(int i= 0; i < 3; i++) {
				magicNumbers[i] = (int) (Math.random() * 100 + 0);
			}
			
			return magicNumbers;
	}
	
	/*
	 * 22. Easy Guessing Game
	 * 
	 * Create a program to generate a number between the given range:
	 * int x = minimum
	 * iny y = maximum (inclusive)
	 * 
	 * You must use the Math.random class to generate a random number between x and y.
	 */
	
	public int guessingGame(int x, int y) {
		int range = y - x + 1; 
        int randomNumber;

        randomNumber = (int)(Math.random() * range) + x; 

		return randomNumber;
	
	}
}
