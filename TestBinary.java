/**
* A test program for the Binary class in CS318 Programming Assignment 1.
* Your Binary.java will be graded using a different test program and this
* program will be used to test my Binary.java file.
*
* This program tests all of the methods that you are
* required to implement, but it does not test all possible situations. Consider
* the edge cases that might occur and make sure that your code can handle those
* cases and make sure to add such test cases. You are expected to write one additional
* test for each method you wrote.
*
* @author Christine Reilly, Aarathi Prasad, and Nick Cipriani
*/
// import java.util.Random;
import java.util.Arrays;

public class TestBinary {
		public static void main(String[] args) {

				// A random number class. If you want the same set of random numbers
				// every time you run the program (useful when debugging), put an
				// integer as the parameter to the Random constructor.
				// Random random = new Random();

				long decNum; // a decimal number
				long decNum1; // a decimal number
				long decNum2; // a decimal number
				// long decNum3; // a decimal number
				boolean[] binNum; // a binary number
				boolean[] binNum1 = new boolean[32]; // a binary number
				boolean[] binNum2 = new boolean[32]; // a binary number
				// boolean[] binNum3 = new boolean[32]; // a binary number
				// boolean[] binNum4 = new boolean[32]; // a binary number
				// boolean[] badBin = {true,true,false,true,false,true}; // a binary number less than 32 bits
				String binString; // string representation of a binary number
				String hexString; // string representation of a hexadecimal number

				// Set test number
				decNum1 = 2290649224L;
				decNum2 = -2004318072;

				for (int i = 0; i < binNum1.length; i++) {
					if ((i + 1) % 4 == 0) {
						binNum1[i] = true;
					} else {
						binNum1[i] = false;
					}
				}
				if (!Binary.toString(binNum1).equals("1000_1000_1000_1000_1000_1000_1000_1000")) {
					System.out.println("FAIL Test 0A: ");
					System.out.println("binNum from code: " + Binary.toString(binNum1));
					System.out.println("correct binary string: 1000_1000_1000_1000_1000_1000_1000_1000");
				} else {
					System.out.println("PASSED Test 0A");
				}

				//STUDENT MUST ADD: For every TEST xA below, add a Test xB
				//to check whether your method works. If it does not work
				//print a FAIL message similar to the ones below, and if it passes
				//print PASSED Test xB

				//STUDENT MUST ADD: Test 0B
				//To add a Test 0B, you must generate your own binary number binNum2
				//and repeat what I did for Test 0A.

				for (int i = 0; i < binNum2.length; i++) {
					if ((i + 1) % 2 == 0) {
						binNum2[i] = true;
					} else {
						binNum2[i] = false;
					}
				}

				if (!Binary.toString(binNum2).equals("1010_1010_1010_1010_1010_1010_1010_1010")) {
					System.out.println("FAIL Test 0B: ");
					System.out.println("binNum from code: " + Binary.toString(binNum2));
					System.out.println("correct binary string: 1010_1010_1010_1010_1010_1010_1010_1010");
				} else {
					System.out.println("PASSED Test 0B");
				}

				System.out.println("***** Testing unsigned numbers ....");

				binNum = Binary.uDecToBin(74951, 32);
				binString = Binary.toString(binNum);
				if(!binString.equals("0000_0000_0000_0001_0010_0100_1100_0111")) {
						System.out.println("FAIL Test 1A:");
						System.out.println("    binary string from code: " + binString);
						System.out.println("    correct binary string: 0000_0000_0000_0001_0010_0100_1100_0111");
				} else {
						System.out.println("PASSED Test 1A");
				}

				//STUDENT MUST ADD: Test 1B
				//To add a Test 1B, create binNum using uDecToBin with decimal number 64656
				//and repeat what I did for Test 1A.
				binNum = Binary.uDecToBin(64656, 32);
				binString = Binary.toString(binNum);
				if(!binString.equals("0000_0000_0000_0000_1111_1100_1001_0000")) {
						System.out.println("FAIL Test 1B:");
						System.out.println("    binary string from code: " + binString);
						System.out.println("    correct binary string: 0000_0000_0000_0000_1111_1100_1001_0000");
				} else {
						System.out.println("PASSED Test 1B");
				}

				decNum = Binary.binToUDec(binNum1);
				if(!(decNum == decNum1)) {
						System.out.println("FAIL Test 2A:");
						System.out.println("    decimal number from code: " + decNum);
						System.out.println("    correct decimal number: " + decNum1);
				} else {
						System.out.println("PASSED Test 2A");
				}

				//STUDENT MUST ADD: Test 2B
				//To add a Test 2B, manually compute using place values what the
				//decimal equivalent of binNum2 must be. Then you must generate decimal decNum using binToUDec from your binNum2
				//and compare with the number you computed manually, and repeat what I did for Test 2A.

				decNum = Binary.binToUDec(binNum2);
				if(!(decNum == 2863311530L)) {
						System.out.println("FAIL Test 2B:");
						System.out.println("    decimal number from code: " + decNum);
						System.out.println("    correct decimal number: " + 2863311530L);
				} else {
						System.out.println("PASSED Test 2B");
				}

				System.out.println(".... Finished unsigned numbers *****\n");

				System.out.println("***** Testing signed numbers ....");

				binNum = Binary.sDecToBin(-74951, 32);
				binString = Binary.toString(binNum);
				if(!binString.equals("1111_1111_1111_1110_1101_1011_0011_1001")) {
						System.out.println("FAIL Test 3A:");
						System.out.println("    binary string from code: " + binString);
						System.out.println("    correct binary string: 1111_1111_1111_1110_1101_1011_0011_1001");
				} else {
						System.out.println("PASSED Test 3A");
				}

				//STUDENT MUST ADD: Test 3B
				//To add a Test 3B, create binNum using sDecToBin with decimal number -64656
				//and repeat what I did for Test 3A.

				binNum = Binary.sDecToBin(-64656, 32);
				binString = Binary.toString(binNum);
				if(!binString.equals("1111_1111_1111_1111_0000_0011_0111_0000")) {
						System.out.println("FAIL Test 3B:");
						System.out.println("    binary string from code: " + binString);
						System.out.println("    correct binary string: 1111_1111_1111_1111_0000_0011_0111_0000");
				} else {
						System.out.println("PASSED Test 3B");
				}

				decNum = Binary.binToSDec(binNum1);
				if(!(decNum == decNum2)) {
						System.out.println("FAIL Test 4A:");
						System.out.println("    decimal number from code: " + decNum);
						System.out.println("    correct decimal number: " + decNum2);
				} else {
						System.out.println("PASSED Test 4A");
				}

				//STUDENT MUST ADD: Test 4B
				//To add a Test 4B, make sure your binNum returns -64656
				//and repeat what I did for Test 4A

				binNum = new boolean[]{false, false, false, false, true, true, true, false, true, true,
				false, false, false, false, false, false, true, true, true, true,
				true, true, true, true, true, true, true, true, true, true, true, true};
				decNum = Binary.binToSDec(binNum);
				if(!(decNum == -64656)) {
						System.out.println("FAIL Test 4B:");
						System.out.println("    decimal number from code: " + decNum);
						System.out.println("    correct decimal number: " + -64656);
				} else {
						System.out.println("PASSED Test 4B");
				}

				System.out.println(".... Finished signed numbers *****\n");

				System.out.println("***** Testing toHexString method ....");

				hexString = Binary.toHexString(binNum1);
				if(!hexString.equals("8888_8888")) {
						System.out.println("FAIL Test 5A:");
						System.out.println("    hex string from code: " + hexString);
						System.out.println("    correct hex string: 8888_8888");
				} else {
						System.out.println("PASSED Test 5A");
				}

				//STUDENT MUST ADD: Test 5B
				//Compute manually the hex string for your binNum2.
				//To add a Test 5B, make sure your toHexString returns the same string
				//as what you computed
				//and repeat what I did for Test 5A

				hexString = Binary.toHexString(binNum2);
				if(!hexString.equals("AAAA_AAAA")) {
						System.out.println("FAIL Test 5B:");
						System.out.println("    hex string from code: " + hexString);
						System.out.println("    correct hex string: AAAA_AAAA");
				} else {
						System.out.println("PASSED Test 5B");
				}

				System.out.println(".... Finished toHexString method *****\n");

				System.out.println("***** Testing smaller numbers ....");
				boolean[] twoFive = {true, false, false, true, true};
				if (!Arrays.equals(Binary.uDecToBin(25L, 5), twoFive)) {
						System.out.println("FAIL Test 6A:");
						System.out.println("25 in 5 bits converted: " + Binary.toString(Binary.uDecToBin(25L, 5)));
						System.out.println("Correct value: " + Binary.toString(twoFive));
				} else {
					System.out.println("PASSED Test 6A");
				}

				//STUDENT MUST ADD: Test 6B
				//To add a Test 6B, make sure to test uDecToBin on a smaller number (other than 32 bits)
				//and repeat what I did for Test 6A

				boolean[] twoTen = {true, false, false, true, true, true, false, false, true, true};
				if (!Arrays.equals(Binary.uDecToBin(825L, 10), twoTen)) {
						System.out.println("FAIL Test 6B:");
						System.out.println("825 in 10 bits converted: " + Binary.toString(Binary.uDecToBin(825L, 10)));
						System.out.println("Correct value: " + Binary.toString(twoTen));
				} else {
					System.out.println("PASSED Test 6B");
				}

				//STUDENT MUST ADD: Test 6C
				//To add a Test 6C, make sure to test sDecToBin on a smaller number (other than 32 bits)
				//and repeat what I did for Test 6A

				boolean[] twoTwo = {false, true};
				if (!Arrays.equals(Binary.uDecToBin(2L, 2), twoTwo)) {
						System.out.println("FAIL Test 6C:");
						System.out.println("2 in 2 bits converted: " + Binary.toString(Binary.uDecToBin(2L, 2)));
						System.out.println("Correct value: " + Binary.toString(twoTwo));
				} else {
					System.out.println("PASSED Test 6C");
				}

				System.out.println(".... Finished smaller numbers *****\n");


				System.out.println("***** Testing exceptions ....");
				System.out.println("You should see PASS messages A, B, C, & D:");

				try {
					binNum = Binary.uDecToBin(4300000000L, 32);
				} catch(IllegalArgumentException e) {
					System.out.println("PASS A");
				}

				try {
					binNum = Binary.sDecToBin(2300000000L, 32);
				} catch(IllegalArgumentException e) {
					System.out.println("PASS B");
				}

				//STUDENT MUST ADD: PASS C and PASS D to
				//generate additional IllegalArgumentExceptions for
				//both uDecToBin and sDecToBin respectively

				try {
					binNum = Binary.uDecToBin(-1L, 32);
				} catch(IllegalArgumentException e) {
					System.out.println("PASS C");
				}

				try {
					binNum = Binary.sDecToBin(-2300000000L, 32);
				} catch(IllegalArgumentException e) {
					System.out.println("PASS D");
				}

				System.out.println(".... Finished exceptions *****\n");
		}
}
