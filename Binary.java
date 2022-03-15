import java.util.Arrays;

/**
* Methods for converting between binary and decimal.
*
* @author Nick Cipriani
*/
public class Binary {

	/** Constant defines the maximum length of binary numbers. */
	private static final int MAX_LENGTH = 32;

	/**
	* Converts a two's complement binary number to signed decimal
	*
	* @param b The two's complement binary number
	* @return The equivalent decimal value
	* @exception IllegalArgumentException Parameter array length is longer than MAX_LENGTH.
	*/
	public static long binToSDec(boolean[] b) {
		// PROGRAM 1: Student must complete this method
		// return value is a placeholder, student should replace with correct return

		// Example of throwing an IllegalArgumentException
		// Student must write code for the required exceptions in other methods.
		// If the exception condition is true, throw the exception
		if (b.length > MAX_LENGTH) {
			// If the condition is true, the exception will be thrown
			// and the method execution will stop.
			throw new IllegalArgumentException("parameter array is longer than " + MAX_LENGTH + " bits.");
		}
		// If the method execution reaches this point, the exception was
		// not thrown.
		// Write the rest of the method here.
		long result = 0;
		for (int i = 0; i < b.length; i++) {
			// If b[i] is true, AKA a 1, then count it. If not, move on.
			if (b[i]) {
				// If we're on the last element (the MSB), subtract instead of add.
				if (i == b.length - 1) {
					result -= Math.pow(2, i);
				} else {
					result += Math.pow(2, i);
				}
			}
		}
		return result;
	}

	/**
	* Converts an unsigned binary number to unsigned decimal
	*
	* @param b The unsigned binary number
	* @return The equivalent decimal value
	* @exception IllegalArgumentException Parameter array length is longer than MAX_LENGTH.
	*/
	public static long binToUDec(boolean[] b) {
		// PROGRAM 1: Student must complete this method
		// return value is a placeholder, student should replace with correct return
		if (b.length > MAX_LENGTH) {
			throw new IllegalArgumentException("parameter array is longer than " + MAX_LENGTH + " bits.");
		}

		long result = 0;
		for (int i = 0; i < b.length; i++) {
			// Similar to binToSDec but no subtraction logic necessary
			if (b[i]) {
				result += Math.pow(2, i);
			}
		}
		return result;
	}

	/**
	* Converts a signed decimal number to two's complement binary
	*
	* @param d The decimal value
	* @param bits The number of bits to use for the binary number.
	* @return The equivalent two's complement binary representation.
	* @exception IllegalArgumentException Parameter is outside valid range that can be represented with the given number of bits.
	*/
	public static boolean[] sDecToBin(long d, int bits) {
		// PROGRAM 1: Student must complete this method
		// return value is a placeholder, student should replace with correct return
		// If the input is too large to fit in the # of bits given or too small, throw error.
		if ((d > Math.pow(2, bits - 1) - 1) || (d < -(Math.pow(2, bits - 1)))) {
			throw new IllegalArgumentException("Parameter is outside valid range that can be represented with " + bits + " bits.");
		}

		// The first step is converting to binary as if it were positive so we can use the
		// function we made for that
		boolean[] result = uDecToBin(Math.abs(d), bits);

		// Positive decimals are done at this point but if negative, we have to continue converting
		if (d < 0) {
			for (int j = 0; j < result.length; j++) {
				// Invert result
				if (result[j]) {
					result[j] = false;
				} else {
					result[j] = true;
				}
			}
			// Add 1
			for (int j2 = 0; j2 < result.length; j2++) {
				// If last digit is 0, add 1 and we're done
				if (!result[j2]) {
					result[j2] = true;
					break;
				} else { // If it's a 1, change to zero
					result[j2] = false;
					// If next digit is 0, change to 1 and we're done
					if (!result[j2 + 1]) {
						result[j2 + 1] = true;
						break;
					} // If next digit is a 1, repeat loop
				}
			}
		}
		return result;
	}

	/**
	* Converts an unsigned decimal number to binary
	*
	* @param d The decimal value
	* @param bits The number of bits to use for the binary number.
	* @return The equivalent binary representation.
	* @exception IllegalArgumentException Parameter is outside valid range that can be represented with the given number of bits.
	*/
	public static boolean[] uDecToBin(long d, int bits) {
		// PROGRAM 1: Student must complete this method
		// return value is a placeholder, student should replace with correct return
		if (d > Math.pow(2, bits) - 1 || d < 0) {
			throw new IllegalArgumentException("Parameter is outside valid range that can be represented with " + bits + " bits.");
		}

		boolean[] result = new boolean[bits];
		long quotient = Math.abs(d);
		int i = 0;
		while (quotient > 0) {
			// Check the remainder and assign T/F appropriately
			if (quotient % 2 == 1) {
				result[i] = true;
				// System.out.println("IF REACHED!");
			} else {
				result[i] = false;
				// System.out.println("ELSE REACHED!");
			}
			// Update the quotient for next division
			quotient = Math.floorDiv(quotient, 2);
			// System.out.println(quotient);
			i++;
		}

		return result;
	}

	/**
	* Returns a string representation of the binary number. Uses an underscore
	* to separate each group of 4 bits.
	*
	* @param b The binary number.
	* @return The string representation of the binary number.
	*/
	public static String toString(boolean[] b) {
		// PROGRAM 1: Student must complete this method
		// return value is a placeholder, student should replace with correct return
		String result = "";
		for (int i = 0; i < b.length; i++) {
			// Put an underscore every 4 characters but not at 0
			if (i != 0 && i % 4 == 0) {
				result = "_" + result;
			}
			// Put a 1 in the front for true and 0 in the front for false
			if (b[i]) {
				result = "1" + result;
			} else {
				result = "0" + result;
			}
		}
		return result;
	}

	/**
	* Splits a 1D array into a 2D array with the nested arrays being a set length.
	*
	* @param b The array you want to split.
	* @param chunkLength How big you want each chunk to be.
	* @return A 2D array where each sub array is a group of specified chunk length.
	*/
	public static boolean[][] splitBoolArray(boolean[] b, int chunkLength) {
		boolean[][] chunks = new boolean[(int) Math.ceil(b.length / chunkLength)][chunkLength];
		for (int i = 0; i < chunks.length ; i++) {
			for (int j = 0; j < b.length; j += chunkLength) {
				chunks[i] = Arrays.copyOfRange(b, j, Math.min(b.length, j + chunkLength));
			}
		}
		return chunks;
	} // How to split a string array: https://stackoverflow.com/questions/27857011/how-to-split-a-string-array-into-small-chunk-arrays-in-java

	/**
	* Returns a hexadecimal representation of the unsigned binary number.
	* Uses an underscore to separate each group of 4 characters.
	*
	* @param b The binary number.
	* @return The hexadecimal representation of the binary number.
	*/
	public static String toHexString(boolean[] b) {
		// PROGRAM 1: Student must complete this method return value
		// is a placeholder, student should replace with correct return
		String result = "";
		int temp;
		// Split array into chunks of 4
		boolean[][] binaryChunks = splitBoolArray(b, 4);

		for (int i = 0; i < binaryChunks.length; i++) {
			temp = (int) binToUDec(binaryChunks[i]);
			// Insert underscore every 4 characters
			if (i != 0 && i % 4 == 0) {
				result = "_" + result;
			}
			// Interpret numbers over 10 correctly
			if (temp < 10) {
				result = temp + result;
			} else {
				switch(temp) {
					case 10:
						result = "A" + result;
						break;
					case 11:
						result = "B" + result;
						break;
					case 12:
						result = "C" + result;
						break;
					case 13:
						result = "D" + result;
						break;
					case 14:
						result = "E" + result;
						break;
					case 15:
						result = "F" + result;
						break;
				}
			}
		}
		return result;
	}
}
