import java.util.Random;

/**
* Simulates the arithmetic and logic unit (ALU) of a processor. Follows the
* ARMv8 architecture, with the exception of the number of bits used for input
* and output values. Uses the BINARY_LENGTH constant from the Binary class as
* the number of bits for inputs and output.
*
* The ALU must be implemented using logic operations (AND, OR, NOT) on each
* set of input bits because the goal of this assignment is to learn about how
* a computer processor uses logic gates to perform arithmetic. The Java
* arithmetic operations should not be used in this class.
*
* @author Nick Cipriani
*/
public class ALU {

	/** Number of bits used to represent an integer in this ALU */
	public static final int INT_LENGTH = 32;

	/** Input A: an INT_LENGTH bit binary value */
	private boolean[] inputA = new boolean[INT_LENGTH];

	/** Input B: an INT_LENGTH bit binary value */
	private boolean[] inputB = new boolean[INT_LENGTH];

	/** Output: an INT_LENGTH bit binary value */
	private boolean[] output = new boolean[INT_LENGTH];

	/** ALU Control input */
	private int control;

	/** Zero flag */
	private boolean zeroFlag;

	/** Carry flag */
	private boolean carryFlag;

	/** Overflow flag */
	private boolean overflowFlag;

	/**
	* Constructor initializes inputs and output to random binary values,
	* intializes control to 15, initializes zero flag to false.
	* Inputs and output arrays should have length INT_LENGTH.
	*/
	public ALU() {
		// PROGRAM 1: Student must complete this method
		Random rand = new Random();
		for (int i = 0; i < INT_LENGTH; i++) {
			inputA[i] = rand.nextBoolean();
			inputB[i] = rand.nextBoolean();
			output[i] = rand.nextBoolean();
		}
		control = 15;
		zeroFlag = false;
	}

	/**
	* Sets the value of inputA.
	*
	* @param b The value to set inputA to
	*
	* @exception IllegalArgumentException if array b does not have length
	* INT_LENGTH
	*/
	public void setInputA(boolean[] b) {
		// PROGRAM 1: Student must complete this method
		if (b.length != INT_LENGTH) {
			throw new IllegalArgumentException("Array does not have length INT_LENGTH (" + INT_LENGTH + ").");
		}
		inputA = b;
	}

	/**
	* Sets the value of inputB.
	*
	* @param b The value to set inputB to
	*
	* @exception IllegalArgumentException if array b does not have length INT_LENGTH
	*/
	public void setInputB(boolean[] b) {
		// PROGRAM 1: Student must complete this method
		if (b.length != INT_LENGTH) {
			throw new IllegalArgumentException("Array does not have length INT_LENGTH (" + INT_LENGTH + ").");
		}
		inputB = b;
	}

	/**
	* Sets the value of the control line to one of the following values. Note
	* that we are not implementing all possible control line values.
	* 0 for AND;
	* 1 for OR;
	* 2 for ADD;
	* 6 for SUBTRACT;
	* 7 for PASS INPUT B.
	*
	* @param c The value to set the control to.
	* @exception IllegalArgumentException if c is not 0, 1, 2, 6, or 7.
	*/
	public void setControl(int c) {
		// PROGRAM 1: Student must complete this method
		if (c != 0 && c != 1 && c != 2 && c != 6 && c != 7) {
			throw new IllegalArgumentException("Input " + c + " is not a valid control value.\nPlease use 0, 1, 2, 6, or 7 instead.");
		} 
		control = c;
	}

	/**
	* Returns a copy of the value in the output.
	*
	* @return The value in the output
	*/
	public boolean[] getOutput() {
		// PROGRAM 1: Student must complete this method
		// return value is a placeholder, student should replace with correct return
		return output;
	}

	/**
	* Returns the value of the zero data member. The zero data member should
	* have been set to true if the result of the operation was zero.
	*
	* @return The value of the zeroFlag data member
	*/
	public boolean getZeroFlag() {
		// PROGRAM 1: Student must complete this method
		// return value is a placeholder, student should replace with correct return
		return zeroFlag;
	}

	/**
	* Returns the value of the carryFlag data member. The carryFlag data member
	* is set to true if the ALU addition operation has a carry out of the most
	* significant bit.
	*
	* @return The value of the carryFlag data member
	*/
	public boolean getCarryFlag() {
		// PROGRAM 1: Student must complete this method
		// return value is a placeholder, student should replace with correct return
		return carryFlag;
	}

	/**
	* Returns the value of the overflowFlag data member. The overflowFlag data
	* member is set to true if the ALU addition operation has a result that
	* is overflow when the operands are signed integers.
	*
	* @return The value of the overflowFlag data member
	*/
	public boolean getOverflowFlag() {
		// PROGRAM 1: Student must complete this method
		// return value is a placeholder, student should replace with correct return
		return overflowFlag;
	}

	/**
	* Activates the ALU so that the ALU performs the operation specified by
	* the control data member on the two input values. When this method is
	* finished, the output data member contains the result of the operation.
	*
	* @exception RuntimeException if the control data member is not set to
	* a valid operation code.
	*/
	public void activate() {
		// PROGRAM 1: Student must complete this method
		if (control != 0 && control != 1 && control != 2 && control != 6 && control != 7) {
			throw new RuntimeException("The control flag is set to " + control + " and is not a valid control value. Please use 0, 1, 2, 6, or 7 instead.");
		}
		carryFlag = false;
		overflowFlag = false;
		switch(control) {
			case 0:
				and();
				break;
			case 1:
				or();
				break;
			case 2:
				add();
				break;
			case 6:
				sub();
				break;
			case 7:
				passB();
				break;
		}
	}

	/**
	* Performs the bitwise AND operation: output = inputA AND inputB
	*/
	private void and() {
		// PROGRAM 1: Student must complete this method
		// output = inputA & inputB;
		for (int i = 0; i < inputA.length; i++) {
			if (inputA[i] && inputB[i]) {
				output[i] = true;
			} else {
				output[i] = false;
			}
		}
	}

	/**
	* Performs the bitwise OR operation: output = inputA OR inputB
	*/
	private void or() {
		// PROGRAM 1: Student must complete this method
		for (int i = 0; i < inputA.length; i++) {
			if (inputA[i] || inputB[i]) {
				output[i] = true;
			} else {
				output[i] = false;
			}
		}
	}

	// From when I tried using XOR but it didn't end up working
	// private boolean xor(boolean a, boolean b) {
	// 	if ((a || b) && !(a && b)) {
	// 		return true;
	// 	} else {
	// 		return false;
	// 	}
	// }

	/**
	* Performs the addition operation using ripple-carry addition of each bit:
	* output = inputA + inputB
	*/
	private void add() {
		// PROGRAM 1: Student must complete this method
		// This method must use the addBit method for bitwise addition.
		for (int i = 0; i < inputA.length; i++) {
			output[i] = addBit(inputA[i], inputB[i], carryFlag)[0];
			// If there's a carry on the MSB, flag overflow
			// if (i == inputA.length - 1 && carryFlag) {
			// 	overflowFlag = true;
			// } else {
			// 	overflowFlag = false;
			// }
		}
	}

	/**
	* Performs the subtraction operation using a ripple-carry adder:
	* output = inputA - inputB
	* In order to perform subtraction, set the first carry-in to 1 and invert
	* the bits of inputB.
	*/
	private void sub() {
		// PROGRAM 1: Student must complete this method
		// This method must use the addBit method for bitwise subtraction.
		carryFlag = true;
		for (int i = 0; i < inputA.length; i++) {
			output[i] = addBit(inputA[i], !inputB[i], carryFlag)[0];
		}
		carryFlag = false;
	}

	/**
	* Copies inputB to the output: output = inputB
	*/
	private void passB() {
		// PROGRAM 1: Student must complete this method
		output = inputB;
		if (!output[0]) {
			zeroFlag = true;
		} else {
			zeroFlag = false;
		}
	}

	/**
	* Simulates a 1-bit adder.
	*
	* @param a Represents an input bit
	* @param b Represents an input bit
	* @param c Represents the carry in bit
	* @return An array of length 2, index 0 holds the output bit and index 1
	* holds the carry out
	*/
	private boolean[] addBit(boolean a, boolean b, boolean c) {
		// PROGRAM 1: Student must complete this method

		// This method may only use the Java logic operations && (logical and),
		// || (logical or), and ! (logical not). Do not use any Java arithmetic
		// operators in this method.

		// return value is a placeholder, student should replace with correct return
		boolean[] result;
		if (a && b && c) { // If all 3 are true
			result = new boolean[] {true, true};
		} else if ((a && b && !c) || (!a && b && c) || (a && !b && c)) { // If only 2 are true
			result = new boolean[] {false, true};
		} else if (!a && !b && !c) { // If all 3 are false
			result = new boolean[] {false, false};
		} else { // If only 1 is true
			result = new boolean[] {true, false};
		}
		// If result[0] is false, there was a 0 and zeroFlag should be true. Vice versa.
		zeroFlag = !result[0];
		// If result[1] is true, there is a carry and carryFlag should be true. Vice versa.
		carryFlag = result[1];
		// Tried using the equations from slides but it didn't work
		// boolean[] result = new boolean[2];
		// if (xor(xor(a, b), c)) {
		// 	result[0] = true;
		// 	zeroFlag = false;
		// } else {
		// 	result[0] = false;
		// 	zeroFlag = true;
		// }
		// if ((a && b) || ((xor(a, b)) && c)) {
		// 	result[1] = true;
		// 	carryFlag = true;
		// } else {
		// 	result[0] = false;
		// 	carryFlag = false;
		// }
		return result;
	}
}