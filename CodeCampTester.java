import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

//  CodeCamp.java - CS314 Assignment 1 - Tester class

/*  Student information for assignment:
 *
 *  Name: Ethan Lao
 *  email address: ethanlao@cs.utexas.edu
 *  UTEID: el26698
 *  Section 5 digit ID: 50265 
 *  Grader name:
 *  Number of slip days used on this assignment: 0
 */

/* CS314 Students: place results of shared birthdays experiments in this comment.
 * Average number of pairs (182 people, 365 days): 45.132181
 * 
 * Number of people to have a 50% chance of there being at least 1 shared birthday: 23
 * Num people: 2, number of experiments with one or more shared birthday: 129, percentage: .26
 * Num people: 3, number of experiments with one or more shared birthday: 397, percentage: .79
 * Num people: 4, number of experiments with one or more shared birthday: 836, percentage: 1.67
 * Num people: 5, number of experiments with one or more shared birthday: 1315, percentage: 2.63
 * Num people: 6, number of experiments with one or more shared birthday: 2008, percentage: 4.02
 * Num people: 7, number of experiments with one or more shared birthday: 2807, percentage: 5.61
 * Num people: 8, number of experiments with one or more shared birthday: 3744, percentage: 7.49
 * Num people: 9, number of experiments with one or more shared birthday: 4732, percentage: 9.46
 * Num people: 10, number of experiments with one or more shared birthday: 5803, percentage: 11.61
 * Num people: 11, number of experiments with one or more shared birthday: 7022, percentage: 14.04
 * Num people: 12, number of experiments with one or more shared birthday: 8379, percentage: 16.76
 * Num people: 13, number of experiments with one or more shared birthday: 9627, percentage: 19.25
 * Num people: 14, number of experiments with one or more shared birthday: 11063, percentage: 22.13
 * Num people: 15, number of experiments with one or more shared birthday: 12529, percentage: 25.06
 * Num people: 16, number of experiments with one or more shared birthday: 14331, percentage: 28.66
 * Num people: 17, number of experiments with one or more shared birthday: 15875, percentage: 31.75
 * Num people: 18, number of experiments with one or more shared birthday: 17182, percentage: 34.36
 * Num people: 19, number of experiments with one or more shared birthday: 18888, percentage: 37.78
 * Num people: 20, number of experiments with one or more shared birthday: 20534, percentage: 41.07
 * Num people: 21, number of experiments with one or more shared birthday: 22216, percentage: 44.43
 * Num people: 22, number of experiments with one or more shared birthday: 23714, percentage: 47.43
 * Num people: 23, number of experiments with one or more shared birthday: 25184, percentage: 50.37
 * Num people: 24, number of experiments with one or more shared birthday: 26988, percentage: 53.98
 * Num people: 25, number of experiments with one or more shared birthday: 28348, percentage: 56.70
 * Num people: 26, number of experiments with one or more shared birthday: 29962, percentage: 59.92
 * Num people: 27, number of experiments with one or more shared birthday: 31363, percentage: 62.73
 * Num people: 28, number of experiments with one or more shared birthday: 32751, percentage: 65.50
 * Num people: 29, number of experiments with one or more shared birthday: 33978, percentage: 67.96
 * Num people: 30, number of experiments with one or more shared birthday: 35312, percentage: 70.62
 * Num people: 31, number of experiments with one or more shared birthday: 36585, percentage: 73.17
 * Num people: 32, number of experiments with one or more shared birthday: 37655, percentage: 75.31
 * Num people: 33, number of experiments with one or more shared birthday: 38602, percentage: 77.20
 * Num people: 34, number of experiments with one or more shared birthday: 39723, percentage: 79.45
 * Num people: 35, number of experiments with one or more shared birthday: 40706, percentage: 81.41
 * Num people: 36, number of experiments with one or more shared birthday: 41520, percentage: 83.04
 * Num people: 37, number of experiments with one or more shared birthday: 42435, percentage: 84.87
 * Num people: 38, number of experiments with one or more shared birthday: 43291, percentage: 86.58
 * Num people: 39, number of experiments with one or more shared birthday: 44004, percentage: 88.01
 * Num people: 40, number of experiments with one or more shared birthday: 44522, percentage: 89.04
 * Num people: 41, number of experiments with one or more shared birthday: 45159, percentage: 90.32
 * Num people: 42, number of experiments with one or more shared birthday: 45700, percentage: 91.40
 * Num people: 43, number of experiments with one or more shared birthday: 46271, percentage: 92.54
 * Num people: 44, number of experiments with one or more shared birthday: 46548, percentage: 93.10
 * Num people: 45, number of experiments with one or more shared birthday: 47084, percentage: 94.17
 * Num people: 46, number of experiments with one or more shared birthday: 47428, percentage: 94.86
 * Num people: 47, number of experiments with one or more shared birthday: 47784, percentage: 95.57
 * Num people: 48, number of experiments with one or more shared birthday: 48105, percentage: 96.21
 * Num people: 49, number of experiments with one or more shared birthday: 48320, percentage: 96.64
 * Num people: 50, number of experiments with one or more shared birthday: 48572, percentage: 97.14
 * Num people: 51, number of experiments with one or more shared birthday: 48764, percentage: 97.53
 * Num people: 52, number of experiments with one or more shared birthday: 48919, percentage: 97.84
 * Num people: 53, number of experiments with one or more shared birthday: 49028, percentage: 98.06
 * Num people: 54, number of experiments with one or more shared birthday: 49172, percentage: 98.34
 * Num people: 55, number of experiments with one or more shared birthday: 49304, percentage: 98.61
 * Num people: 56, number of experiments with one or more shared birthday: 49383, percentage: 98.77
 * Num people: 57, number of experiments with one or more shared birthday: 49492, percentage: 98.98
 * Num people: 58, number of experiments with one or more shared birthday: 49543, percentage: 99.09
 * Num people: 59, number of experiments with one or more shared birthday: 49628, percentage: 99.26
 * Num people: 60, number of experiments with one or more shared birthday: 49676, percentage: 99.35
 * Num people: 61, number of experiments with one or more shared birthday: 49773, percentage: 99.55
 * Num people: 62, number of experiments with one or more shared birthday: 49765, percentage: 99.53
 * Num people: 63, number of experiments with one or more shared birthday: 49837, percentage: 99.67
 * Num people: 64, number of experiments with one or more shared birthday: 49866, percentage: 99.73
 * Num people: 65, number of experiments with one or more shared birthday: 49890, percentage: 99.78
 * Num people: 66, number of experiments with one or more shared birthday: 49902, percentage: 99.80
 * Num people: 67, number of experiments with one or more shared birthday: 49928, percentage: 99.86
 * Num people: 68, number of experiments with one or more shared birthday: 49940, percentage: 99.88
 * Num people: 69, number of experiments with one or more shared birthday: 49942, percentage: 99.88
 * Num people: 70, number of experiments with one or more shared birthday: 49956, percentage: 99.91
 * Num people: 71, number of experiments with one or more shared birthday: 49972, percentage: 99.94
 * Num people: 72, number of experiments with one or more shared birthday: 49971, percentage: 99.94
 * Num people: 73, number of experiments with one or more shared birthday: 49980, percentage: 99.96
 * Num people: 74, number of experiments with one or more shared birthday: 49978, percentage: 99.96
 * Num people: 75, number of experiments with one or more shared birthday: 49987, percentage: 99.97
 * Num people: 76, number of experiments with one or more shared birthday: 49986, percentage: 99.97
 * Num people: 77, number of experiments with one or more shared birthday: 49992, percentage: 99.98
 * Num people: 78, number of experiments with one or more shared birthday: 49989, percentage: 99.98
 * Num people: 79, number of experiments with one or more shared birthday: 49996, percentage: 99.99
 * Num people: 80, number of experiments with one or more shared birthday: 49995, percentage: 99.99
 * Num people: 81, number of experiments with one or more shared birthday: 49996, percentage: 99.99
 * Num people: 82, number of experiments with one or more shared birthday: 49997, percentage: 99.99
 * Num people: 83, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * Num people: 84, number of experiments with one or more shared birthday: 49998, percentage: 100.00
 * Num people: 85, number of experiments with one or more shared birthday: 49999, percentage: 100.00
 * Num people: 86, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * Num people: 87, number of experiments with one or more shared birthday: 49999, percentage: 100.00
 * Num people: 88, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * Num people: 89, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * Num people: 90, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * Num people: 91, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * Num people: 92, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * Num people: 93, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * Num people: 94, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * Num people: 95, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * Num people: 96, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * Num people: 97, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * Num people: 98, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * Num people: 99, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * Num people: 100, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 *
 */

public class CodeCampTester {

	public static void main(String[] args) {
		final String newline = System.getProperty("line.separator");

		// test 1, hamming distance
		int[] h1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] h2 = { 1, 2, 3, -1, 5, 6, -1, -1, 9 };
		int expected = 3;
		int actual = CodeCamp.hammingDistance(h1, h2);
		System.out.println("Test 1 hamming distance: expected value: " + expected + ", actual value: " + actual);
		if (expected == actual)
			System.out.println(" passed test 1, hamming distance");
		else
			System.out.println(" ***** FAILED ***** test 1, hamming distance");

		// test 2, hamming distance
		h1 = new int[] { 10, 2, 4, 53, 1, 46, 2, 7, 5, -15256, 52 };
		h2 = new int[] { 10, 2, 4, 53, 1, 46, 2, 7, 5, -15256, 52 };
		expected = 0;
		actual = CodeCamp.hammingDistance(h1, h2);
		System.out.println(
				newline + "Test 2 hamming distance: expected value: " + expected + ", actual value: " + actual);
		if (expected == actual)
			System.out.println(" passed test 2, hamming distance");
		else
			System.out.println(" ***** FAILED ***** test 2, hamming distance");
		
		// test 3, hamming distance
				h1 = new int[] { 10, 2, 4, 53, 1, 46, 2, 7, 5, 15256, 52 };
				h2 = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
				expected = 11;
				actual = CodeCamp.hammingDistance(h1, h2);
				System.out.println(
						newline + "Test 3 hamming distance: expected value: " + expected + ", actual value: " + actual);
				if (expected == actual)
					System.out.println(" passed test 3, hamming distance");
				else
					System.out.println(" ***** FAILED ***** test 3, hamming distance");

		// test 4, hamming distance
		h1 = new int[0];
		h2 = new int[0];
		expected = 0;
		actual = CodeCamp.hammingDistance(h1, h2);
		System.out.println(
				newline + "Test 4 hamming distance: expected value: " + expected + ", actual value: " + actual);
		if (expected == actual)
			System.out.println(" passed test 4, hamming distance");
		else
			System.out.println(" ***** FAILED ***** test 4, hamming distance");

		// test 5, isPermutation
		int[] a = { 5 };
		int[] b = { 1 };
		boolean expectedBool = false;
		boolean actualBool = CodeCamp.isPermutation(a, b);
		System.out.println(
				newline + "Test 5 isPermutation: expected value: " + expectedBool + ", actual value: " + actualBool);
		if (expectedBool == actualBool)
			System.out.println(" passed test 5, isPermutation");
		else
			System.out.println(" ***** FAILED ***** test 5, isPermutation");

		// test 6, is Permutation
		a = new int[] { -1 };
		b = new int[] { -1 };
		expectedBool = true;
		actualBool = CodeCamp.isPermutation(a, b);
		System.out.println(
				newline + "Test 6 isPermutation: expected value: " + expectedBool + ", actual value: " + actualBool);
		if (expectedBool == actualBool)
			System.out.println(" passed test 6, isPermutation");
		else
			System.out.println(" ***** FAILED ***** test 6, isPermutation");

		// test 7, is Permutation
		a = new int[] { Integer.MAX_VALUE - 1, Integer.MAX_VALUE, Integer.MAX_VALUE - 2, -1 };
		b = new int[] { Integer.MAX_VALUE - 2, -1, Integer.MAX_VALUE, Integer.MAX_VALUE - 1 };
		expectedBool = true;
		actualBool = CodeCamp.isPermutation(a, b);
		System.out.println(
				newline + "Test 7 isPermutation: expected value: " + expectedBool + ", actual value: " + actualBool);
		if (expectedBool == actualBool)
			System.out.println(" passed test 7, isPermutation");
		else
			System.out.println(" ***** FAILED ***** test 7, isPermutation");

		// test 8, is Permutation
		a = new int[9999];
		b = new int[9999];
		expectedBool = true;
		actualBool = CodeCamp.isPermutation(a, b);
		System.out.println(
				newline + "Test 8 isPermutation: expected value: " + expectedBool + ", actual value: " + actualBool);
		if (expectedBool == actualBool)
			System.out.println(" passed test 8, isPermutation");
		else
			System.out.println(" ***** FAILED ***** test 8, isPermutation");

		// test 9, is Permutation
		a = new int[9999];
		b = new int[9998];
		expectedBool = false;
		actualBool = CodeCamp.isPermutation(a, b);
		System.out.println(
				newline + "Test 9 isPermutation: expected value: " + expectedBool + ", actual value: " + actualBool);
		if (expectedBool == actualBool)
			System.out.println(" passed test 9, isPermutation");
		else
			System.out.println(" ***** FAILED ***** test 9, isPermutation");

		// test 10, is Permutation
		a = new int[] { Integer.MIN_VALUE };
		b = new int[] { Integer.MIN_VALUE };
		expectedBool = true;
		actualBool = CodeCamp.isPermutation(a, b);
		System.out.println(
				newline + "Test 10 isPermutation: expected value: " + expectedBool + ", actual value: " + actualBool);
		if (expectedBool == actualBool)
			System.out.println(" passed test 10, isPermutation");
		else
			System.out.println(" ***** FAILED ***** test 10, isPermutation");

		// test 11, is Permutation
		a = new int[] { Integer.MAX_VALUE };
		b = new int[] { Integer.MIN_VALUE };
		expectedBool = false;
		actualBool = CodeCamp.isPermutation(a, b);
		System.out.println(
				newline + "Test 11 isPermutation: expected value: " + expectedBool + ", actual value: " + actualBool);
		if (expectedBool == actualBool)
			System.out.println(" passed test 11, isPermutation");
		else
			System.out.println(" ***** FAILED ***** test 11, isPermutation");

		// test 12, is Permutation
		a = new int[] { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 };
		b = new int[] { 5, 5, 5, 5, 5, 4, 5, 5, 5, 5, 5 };
		expectedBool = false;
		actualBool = CodeCamp.isPermutation(a, b);
		System.out.println(
				newline + "Test 12 isPermutation: expected value: " + expectedBool + ", actual value: " + actualBool);
		if (expectedBool == actualBool)
			System.out.println(" passed test 12, isPermutation");
		else
			System.out.println(" ***** FAILED ***** test 12, isPermutation");

		// test 13, is Permutation
		a = new int[] { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 };
		b = new int[] { 5 };
		expectedBool = false;
		actualBool = CodeCamp.isPermutation(a, b);
		System.out.println(
				newline + "Test 13 isPermutation: expected value: " + expectedBool + ", actual value: " + actualBool);
		if (expectedBool == actualBool)
			System.out.println(" passed test 13, isPermutation");
		else
			System.out.println(" ***** FAILED ***** test 13, isPermutation");

		// test 14, is Permutation
		final int NUM_ELEMENTS = 10000;
		ArrayList<Integer> temp = new ArrayList<Integer>(NUM_ELEMENTS);
		for (int i = 0; i < NUM_ELEMENTS; i++) {
			temp.add(i);
		}

		a = intListToArray(temp);
		Collections.reverse(temp);
		b = intListToArray(temp);

		expectedBool = true;
		actualBool = CodeCamp.isPermutation(a, b);
		System.out.println(
				newline + "Test 14 isPermutation: expected value: " + expectedBool + ", actual value: " + actualBool);
		if (expectedBool == actualBool)
			System.out.println(" passed test 14, isPermutation");
		else
			System.out.println(" ***** FAILED ***** test 14, isPermutation");

		// test 15, mostVowels
		String[] sList = { "ccccc", "c" };
		int expectedResult = 0;
		int actualResult = CodeCamp.mostVowels(sList);
		System.out.println(newline + "Test 15 mostVowels: expected result: " + expectedResult + ", actual result: "
				+ actualResult);
		if (actualResult == expectedResult)
			System.out.println("passed test 15, mostVowels");
		else
			System.out.println("***** FAILED ***** test 15, mostVowels");

		// test 16, mostVowels
		sList = new String[] { null, "", "", "", "" };
		expectedResult = 1;
		actualResult = CodeCamp.mostVowels(sList);
		System.out.println(newline + "Test 16 mostVowels: expected result: " + expectedResult + ", actual result: "
				+ actualResult);
		if (actualResult == expectedResult)
			System.out.println("passed test 16, mostVowels");
		else
			System.out.println("***** FAILED ***** test 16, mostVowels");

		// test 17, mostVowels
		sList = new String[] { null, null, null, null, null, null, "e", null };
		expectedResult = 6;
		actualResult = CodeCamp.mostVowels(sList);
		System.out.println(newline + "Test 17 mostVowels: expected result: " + expectedResult + ", actual result: "
				+ actualResult);
		if (actualResult == expectedResult)
			System.out.println("passed test 17, mostVowels");
		else
			System.out.println("***** FAILED ***** test 17, mostVowels");

		// test 18 mostVowels
		sList = new String[] { null, null, null, null, null, "", null, null, "4", "u", null, "" };
		expectedResult = 9;
		actualResult = CodeCamp.mostVowels(sList);
		System.out.println(newline + "Test 18 mostVowels: expected result: " + expectedResult + ", actual result: "
				+ actualResult);
		if (actualResult == expectedResult)
			System.out.println("passed test 18, mostVowels");
		else
			System.out.println("***** FAILED ***** test 18, mostVowels");

		// test 19 mostVowels
		sList = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		expectedResult = 0;
		actualResult = CodeCamp.mostVowels(sList);
		System.out.println(newline + "Test 19 mostVowels: expected result: " + expectedResult + ", actual result: "
				+ actualResult);
		if (actualResult == expectedResult)
			System.out.println("passed test 19, mostVowels");
		else
			System.out.println("***** FAILED ***** test 19, mostVowels");

		// test 20 mostVowels
		sList = new String[] { "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
							   "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
							   "aaaaaaaaaaaaaaaa",
							   "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
							   "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
							   "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"};
		expectedResult = 3;
		actualResult = CodeCamp.mostVowels(sList);
		System.out.println(newline + "Test 20 mostVowels: expected result: " + expectedResult + ", actual result: "
				+ actualResult);
		if (actualResult == expectedResult)
			System.out.println("passed test 20, mostVowels");
		else
			System.out.println("***** FAILED ***** test 20, mostVowels");
		
		// test 21, mostVowels
		sList = new String[NUM_ELEMENTS];
		for (int i = 0; i < NUM_ELEMENTS; i++) {
			sList[i] = "" + i;
		}
		sList[100] = "u";

		expectedResult = 100;
		actualResult = CodeCamp.mostVowels(sList);
		System.out.println(newline + "Test 21 mostVowels: expected result: " + expectedResult + ", actual result: "
				+ actualResult);
		if (actualResult == expectedResult)
			System.out.println("passed test 21, mostVowels");
		else
			System.out.println("***** FAILED ***** test 21, mostVowels");

		// test 22, sharedBirthdays, simple test
		int pairs = CodeCamp.sharedBirthdays(1, 500);
		System.out.println(newline + "Test 22 shared birthdays: expected: 0" + pairs);
		if (pairs == 0)
			System.out.println("passed test 22, shared birthdays");
		else
			System.out.println("***** FAILED ***** test 22, shared birthdays. "
					+ "Expected pairs to be 0. Value returned: " + pairs);

		// test 23, sharedBirthdays, simple test
		pairs = CodeCamp.sharedBirthdays(1, 1000000);
		System.out.println(newline + "Test 23 shared birthdays: expected: 0" + ", actual: " + pairs);
		if (pairs == 0)
			System.out.println("passed test 23, shared birthdays");
		else
			System.out.println("***** FAILED ***** test 23, shared birthdays. "
					+ "Expected pairs to be 0. Value returned: " + pairs);

		// test 24, sharedBirthdays, simple test
		pairs = CodeCamp.sharedBirthdays(2, 1000000);
		System.out.println(newline + "Test 24 shared birthdays: expected: 0" + ", actual: " + pairs);
		if (pairs == 0)
			System.out.println("passed test 24, shared birthdays");
		else
			System.out.println("***** FAILED ***** test 24, shared birthdays. "
					+ "Expected pairs to be 0. Value returned: " + pairs);

		// test 25, sharedBirthdays, simple test
		pairs = CodeCamp.sharedBirthdays(10, 1);
		System.out.println(newline + "Test 25 shared birthdays: expected: 45" + ", actual: " + pairs);
		if (pairs == 45)
			System.out.println("passed test 25, shared birthdays");
		else
			System.out.println("***** FAILED ***** test 25, shared birthdays. "
					+ "Expected pairs to be 45. Value returned: " + pairs);

		// test 26, sharedBirthdays, simple test
		pairs = CodeCamp.sharedBirthdays(1000, 1);
		System.out.println(newline + "Test 26 shared birthdays: expected: 499500" + ", actual: " + pairs);
		if (pairs == 499500)
			System.out.println("passed test 26, shared birthdays");
		else
			System.out.println("***** FAILED ***** test 26, shared birthdays. "
					+ "Expected pairs to be 499500. Value returned: " + pairs);

		// test 27, sharedBirthdays, simple test
		pairs = CodeCamp.sharedBirthdays(2000, 1);
		System.out.println(newline + "Test 27 shared birthdays: expected: 1999000" + ", actual: " + pairs);
		if (pairs == 1999000)
			System.out.println("passed test 27, shared birthdays");
		else
			System.out.println("***** FAILED ***** test 27, shared birthdays. "
					+ "Expected pairs to be 1999000. Value returned: " + pairs);

		// test 28, sharedBirthdays, stress test
		pairs = CodeCamp.sharedBirthdays(50000, 1);
		System.out.println(newline + "Test 28 shared birthdays - stress test. (Is solution slow?) : expected: > 0"
				+ ", actual: " + pairs);
		if (pairs == 1249975000)
			System.out.println("passed test 28, shared birthdays");
		else
			System.out.println("***** FAILED ***** test 28, shared birthdays. "
					+ "Expected at least 1 pair. Value returned: " + pairs);
		
		// test 29, queensAreASafe
		char[][] board = { { 'q', 'q' }, { 'q', 'q' } };

		expectedBool = false;
		actualBool = CodeCamp.queensAreSafe(board);
		System.out.println(
				newline + "Test 29 queensAreSafe: expected value: " + expectedBool + ", actual value: " + actualBool);
		if (expectedBool == actualBool)
			System.out.println(" passed test 29, queensAreSafe");
		else
			System.out.println(" ***** FAILED ***** test 29, queensAreSafe");
		
		// test 30, queensAreASafe
		board = new char[][] { { '.', '.', '.', '.' }, { '.', '.', '.', '.' }, { '.', '.', '.', '.' }, 
							   { '.', '.', '.', '.' } };

		expectedBool = true;
		actualBool = CodeCamp.queensAreSafe(board);
		System.out.println(
				newline + "Test 30 queensAreSafe: expected value: " + expectedBool + ", actual value: " + actualBool);
		if (expectedBool == actualBool)
			System.out.println(" passed test 30, queensAreSafe");
		else
			System.out.println(" ***** FAILED ***** test 30, queensAreSafe");

		// test 31, queensAreASafe
		board = new char[][] { { 'q', '.', '.', '.' }, { 'q', '.', '.', '.' }, { '.', '.', '.', '.' },
				               { '.', '.', '.', '.' } };
		expectedBool = false;
		actualBool = CodeCamp.queensAreSafe(board);
		System.out.println(
				newline + "Test 31 queensAreSafe: expected value: " + expectedBool + ", actual value: " + actualBool);
		if (expectedBool == actualBool)
			System.out.println(" passed test 31, queensAreSafe");
		else
			System.out.println(" ***** FAILED ***** test 31, queensAreSafe");

		// test 32, queensAreASafe
		board = new char[][] { { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' }, 
			   				   { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			   				   { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			   				   { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			   				   { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			   				   { '.', '.', '.', '.', 'q', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			   				   { '.', '.', '.', '.', '.', '.', 'q', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			   				   { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			   				   { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			   				   { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			   				   { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			   				   { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			   				   { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			   				   { '.', 'q', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			   				   { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			   				   { '.', '.', '.', '.', '.', 'q', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },};
		expectedBool = true;
		actualBool = CodeCamp.queensAreSafe(board);
		System.out.println(
				newline + "Test 32 queensAreSafe: expected value: " + expectedBool + ", actual value: " + actualBool);
		if (expectedBool == actualBool)
			System.out.println(" passed test 32, queensAreSafe");
		else
			System.out.println(" ***** FAILED ***** test 32, queensAreSafe");

		// test 33, queensAreASafe
		board = new char[][] { { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' }, 
							   { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
							   { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
							   { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
							   { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
							   { '.', '.', '.', '.', 'q', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
							   { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
							   { '.', '.', '.', '.', '.', '.', 'q', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
							   { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
							   { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
							   { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
							   { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
							   { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
							   { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
							   { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
							   { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },};
		expectedBool = false;
		actualBool = CodeCamp.queensAreSafe(board);
		System.out.println(
				newline + "Test 33 queensAreSafe: expected value: " + expectedBool + ", actual value: " + actualBool);
		if (expectedBool == actualBool)
			System.out.println(" passed test 33, queensAreSafe");
		else
			System.out.println(" ***** FAILED ***** test 33, queensAreSafe");
		
		// test 34, queensAreASafe
		board = new char[1000][1000];
		for (int r = 0; r < 1000; r++) {
			for (int c = 0; c < 1000; c++) {
				board[r][c] = '.';
			}
		}
		board[0][0] = 'q';
		board[999][999] = 'q';
		
		expectedBool = false;
		actualBool = CodeCamp.queensAreSafe(board);
		System.out.println(
				newline + "Test 34 queensAreSafe: expected value: " + expectedBool + ", actual value: " + actualBool);
		if (expectedBool == actualBool)
			System.out.println(" passed test 34, queensAreSafe");
		else
			System.out.println(" ***** FAILED ***** test 34, queensAreSafe");

		// test 35, getValueOfMostValuablePlot
		int[][] city = { { -1, 1 } };

		expected = 1;
		actual = CodeCamp.getValueOfMostValuablePlot(city);
		System.out.println(newline + "Test 35 getValueOfMostValuablePlot: expected value: " + expected
				+ ", actual value: " + actual);
		if (expected == actual)
			System.out.println(" passed test 35, getValueOfMostValuablePlot");
		else
			System.out.println(" ***** FAILED ***** test 35, getValueOfMostValuablePlot");

		// test 36, getValueOfMostValuablePlot
		city = new int[][] { { 0, 0, 1, 0, 1, -2, 6 } };
		expected = 6;
		actual = CodeCamp.getValueOfMostValuablePlot(city);
		System.out.println(newline + "Test 36 getValueOfMostValuablePlot: expected value: " + expected
				+ ", actual value: " + actual);
		if (expected == actual)
			System.out.println(" passed test 36, getValueOfMostValuablePlot");
		else
			System.out.println(" ***** FAILED ***** test 36, getValueOfMostValuablePlot");

		// test 37, getValueOfMostValuablePlot
		city = new int[][] { { 0, 8, 1, 0, 1, -2, 6 } };
		expected = 14;
		actual = CodeCamp.getValueOfMostValuablePlot(city);
		System.out.println(
				"\nTest 37 getValueOfMostValuablePlot: expected value: " + expected + ", actual value: " + actual);
		if (expected == actual)
			System.out.println(" passed test 37, getValueOfMostValuablePlot");
		else
			System.out.println(" ***** FAILED ***** test 37, getValueOfMostValuablePlot");

		// test 38, getValueOfMostValuablePlot
		city = new int[][] { { 1, 2, 3, 4, 5, 6, 7 },
							 { -1, -1, -1, -1, -1, -50, 50} };
		expected = 57;
		actual = CodeCamp.getValueOfMostValuablePlot(city);
		System.out.println(newline + "Test 38 getValueOfMostValuablePlot: expected value: " + expected
				+ ", actual value: " + actual);
		if (expected == actual)
			System.out.println(" passed test 38, getValueOfMostValuablePlot");
		else
			System.out.println(" ***** FAILED ***** test 38, getValueOfMostValuablePlot");

		// test 39, getValueOfMostValuablePlot
		city = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
							 { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
							 { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
							 { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
							 { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
							 { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
							 { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
							 { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
							 { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
							 { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
							 { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
							 { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
							 { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
							 { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
							 { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
							 { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
							 { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
							 { 0, 0, 0, 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0 },};

		expected = 2;
		actual = CodeCamp.getValueOfMostValuablePlot(city);
		System.out.println(
				"\nTest 38 getValueOfMostValuablePlot: expected value: " + expected + ", actual value: " + actual);
		if (expected == actual)
			System.out.println(" passed test 39, getValueOfMostValuablePlot");
		else
			System.out.println(" ***** FAILED ***** test 39, getValueOfMostValuablePlot");
		
		// test 40, getValueOfMostValuablePlot
		city = new int[][] { { 5, 10, 6, 23, -46, 32, -1, -61 }, { 16, 34, 6, -23, -12, 37, -17, 16 },
			                 { 2, -23, 8, -50, 23, -12, -36, 34 }, { 3, -18, -11, 24, -34, 38, -23, -37 },
			                 { 8, 1, 43, 20, 15, 17, -40, 43 }, { 40, 9, 5, -31, -50, -22, 2, 33 },
			                 { 38, 43, -21, -30, -11, -2, 0, 7 }, { 10, -18, 26, 30, 0, 22, -4, 14 },
			                 { -30, 1, -20, 43, -35, 45, -6, -33 }, { 13, -4, 24, -35, 3, 28, -25, 30 },
			                 { 10, -42, 6, -9, 5, -20, 17, 12 }, { 17, -9, 5, 46, -35, 2, -9, 44 },
			                 { -37, 26, -17, -23, -6, 35, -22, 29 }, { 27, -13, -11, -31, 26, 19, 40, -37 },
			                 { 1, -17, -3, -6, 10, 31, 50, 6 }, { 45, 22, 1, 39, 36, 7, 3, 48 },
			                 { 26, -2, -34, -7, 9, 45, 2, 47 }, { 0, -13, 40, 37, -3, 11, 0, 27 },
			                 { 44, -39, -36, -11, 43, -18, 46, 6 }, { 11, -3, 31, 24, -19, -23, 25, -42 },
			                 { -22, 10, 32, 18, 46, 44, 48, -47 }, { 47, -50, 14, 13, -40, -45, 17, 5 },
			                 { 4, 20, 40, -47, 45, -11, 12, -45 }, { 16, -8, 48, 14, -26, 6, 41, 28 },
			                 { -16, 20, 12, -31, 47, 30, 1, -25 }, { -39, 24, 41, 16, 33, -28, 2, 41 },
			                 { -8, -44, -49, 19, -47, 44, 0, -47 }, { -28, 42, -11, -20, -12, 12, 5, -33 },
			                 { -13, 23, 32, -23, 10, 25, -1, 1 }, { -37, 12, -18, 42, 37, -28, -8, -6 },
			                 { -9, 12, 27, -38, -4, 43, -16, 12 }, { -23, 16, 17, -9, -2, -39, -30, 50 },
			                 { 22, -23, 34, 41, -28, 25, 28, -30 }, { -47, -21, 20, -32, 32, 12, 47, 31 },
			                 { 4, 39, -15, 1, 26, -8, 47, 19 }, { -20, -6, 0, 50, 22, 45, -1, 22 } };

		expected = 1307;
		actual = CodeCamp.getValueOfMostValuablePlot(city);
		System.out.println(
				"\nTest 40 getValueOfMostValuablePlot: expected value: " + expected + ", actual value: " + actual);
		if (expected == actual)
			System.out.println(" passed test 40, getValueOfMostValuablePlot");
		else
			System.out.println(" ***** FAILED ***** test 40, getValueOfMostValuablePlot");

	} // end of main method

	// pre: list != null
	private static int[] intListToArray(List<Integer> list) {
		if (list == null)
			throw new IllegalArgumentException("list parameter may not be null.");
		int[] result = new int[list.size()];
		int arrayIndex = 0;
		for (int x : list) {
			result[arrayIndex++] = x;
		}
		return result;
	}
}