//  CodeCamp.java - CS314 Assignment 1

/*  Student information for assignment:
 * 
 *  On my honor, Ethan Lao, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  Name: Ethan Lao
 *  email address: ethanlao@cs.utexas.edu
 *  UTEID: el26698
 *  Section 5 digit ID: 50265
 *  Grader name: 
 *  Number of slip days used on this assignment: 0
 */

public class CodeCamp {

	/**
	 * Determine the Hamming distance between two arrays of ints. Neither the
	 * parameter <tt>aList</tt> or <tt>bList</tt> are altered as a result of this
	 * method.<br>
	 * 
	 * @param aList != null, aList.length == bList.length
	 * @param bList != null, bList.length == aList.length
	 * @return the Hamming Distance between the two arrays of ints.
	 */
	public static int hammingDistance(int[] aList, int[] bList) {
		// check preconditions
		if (aList == null || bList == null || aList.length != bList.length)
			throw new IllegalArgumentException("Violation of precondition: "
					+ "hammingDistance. neither parameter may equal null, arrays" + " must be equal length.");

		//create counter for number of differences found
		int hammingDistanceCount = 0;
		
		//loop through each index of the arrays
		for (int index = 0; index < aList.length; index++) {
			//increment hammingDistanceCount if the position is different
			if (aList[index] != bList[index]) {
				hammingDistanceCount++;
			}
		}
		
		return hammingDistanceCount;
	}

	/**
	 * Determine if one array of ints is a permutation of another. Neither the
	 * parameter <tt>listA</tt> or the parameter <tt>listB</tt> are altered as a
	 * result of this method.<br>
	 * 
	 * @param listA != null
	 * @param listB != null
	 * @return <tt>true</tt> if listB is a permutation of listA, <tt>false</tt>
	 *         otherwise
	 * 
	 */
	public static boolean isPermutation(int[] listA, int[] listB) {
		// check preconditions
		if (listA == null || listB == null)
			throw new IllegalArgumentException(
					"Violation of precondition: " + "isPermutation. neither parameter may equal null.");

		//returns false if the arrays are different sizes
		if (listA.length != listB.length) {
			return false;
		}
		
		//boolean array to track whether each position in listB has already been matched
		boolean[] usedListB = new boolean[listB.length];
		
		for (int indexA = 0; indexA < listA.length; indexA++) {
			
			//loop through listB until it finds a match for listA
			boolean foundMatch = false;
			int indexB = 0;
			while (!foundMatch) {
				//if match is found
				if (!usedListB[indexB] && (listA[indexA] == listB[indexB])) {
					//update usedListB to indicate the position in listB has been matched
					usedListB[indexB] = true;
					foundMatch = true;
				}
				else {
					//if no match is found return false
					if (indexB == listB.length - 1) {
						return false;
					}
					indexB++;
				}
			}
		}
		
		//return true if each index found a match
		return true;
	}

	/**
	 * Determine the index of the String that has the largest number of vowels.
	 * Vowels are defined as <tt>'A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 
	 * 'U', and 'u'</tt>. The parameter <tt>list</tt> is not altered as a result of
	 * this method.
	 * <p>
	 * pre: <tt>list != null</tt>, <tt>list.length > 0</tt>, there is an least 1 non
	 * null element in list
	 * <p>
	 * post: return the index of the non-null element in list that has the largest
	 * number of characters that are vowels. If there is a tie return the index
	 * closest to zero. The empty String, "", has zero vowels. It is possible for
	 * the maximum number of vowels to be 0.<br>
	 * 
	 * @param list the array to check
	 * @return the index of the non-null element in list that has the largest number
	 *         of vowels.
	 */
	public static int mostVowels(String[] list) {
		// check preconditions
		if (list == null || list.length == 0 || !atLeastOneNonNull(list))
			throw new IllegalArgumentException("Violation of precondition: "
					+ "mostVowels. parameter may not equal null and must contain " + "at least one none null value.");

		//index of string with most vowels
		int mostVowelsIndex = 0;
		//number of vowels in mostVowelsIndex (set to -1 to allow strings with 0 vowels to take its place)
		int mostVowelsCount = -1;
		
		//loop through every string in list
		for (int index = 0; index < list.length; index++) {
			if (list[index] != null) {
				//number of vowels in this string
				int vowelCount = 0;
				
				//convert to lower case to avoid comparing capital vowels
				String words = list[index].toLowerCase();
				
				for (int letter = 0; letter < words.length(); letter++) {
					//increment vowelCount if a vowel is found
					if (words.charAt(letter) == 'a' || words.charAt(letter) == 'e' || words.charAt(letter) == 'i' ||
						words.charAt(letter) == 'o' || words.charAt(letter) == 'u') {
						vowelCount++;
					}
				}
				
				//update mostVowelsCount and mostVowelsIndex if vowelCount is the new max value
				if (vowelCount > mostVowelsCount) {
					mostVowelsCount = vowelCount;
					mostVowelsIndex = index;
				}
			}
		}
		return mostVowelsIndex;
	}

	/**
     * Perform an experiment simulating the birthday problem.
     * Pick random birthdays for the given number of people. 
     * Return the number of pairs of people that share the
     * same birthday.<br>
     * @param numPeople The number of people in the experiment.
     * This value must be > 0
     * @param numDaysInYear The number of days in the year for this experiement.
     * This value must be > 0
     * @return The number of pairs of people that share a birthday 
     * after running the simulation.
     */
    public static int sharedBirthdays(int numPeople, int numDaysInYear) {
        // check preconditions
        if (numPeople <= 0 || numDaysInYear <= 0)
            throw new IllegalArgumentException("Violation of precondition: " +
            		"sharedBirthdays. both parameters must be greater than 0. " +
                    "numPeople: " + numPeople + 
                    ", numDaysInYear: " + numDaysInYear);
        
        //create int array, where index is the day and value is the number of occurrences for that day
        int[] sharedDaysCount = new int[numDaysInYear];
        
        //randomly generate numPeople number of birthdays
        for (int person = 0; person < numPeople; person++) {
        	int day = (int) (Math.random() * numDaysInYear);
        	//increment the number of birthdays on that day
        	sharedDaysCount[day]++;
        }

        int totalPairs = 0;
        
        //loop through the number of birthday occurrences for each day
        for (int day = 0; day < sharedDaysCount.length; day++) {
        	//calculate the number of pairs on each birthday
        	while (sharedDaysCount[day] > 1) {
        		sharedDaysCount[day]--;
        		totalPairs+= sharedDaysCount[day];
        	}
        }
        
        return totalPairs;
    }
    
    /*
     * Perform 1,000,000 experiments with 365 days per year and 182 people per experiment
     * and return the average number of pairs of people with shared birthdays
     */
    public static double sharedBirthdaysExperimentOne() {
    	double totalPairs = 0;
    	for (int experiment = 0; experiment < 1_000_000; experiment++) {
    		totalPairs += sharedBirthdays(182, 365);
    	}
    	return totalPairs / 1_000_000;
    }
    
    /*
     * Perform 50,000 experiments with 365 days per year, varying the number of people from 2 to 100
     * and return the percentage of experiments where at least one pair of people shared a birthday
     */
    public static void sharedBirthdaysExperimentTwo() {
    	for (int numPeople = 2; numPeople < 101; numPeople++) {
    		int hasSharedBirthdayNum = 0;
    		for (int experiment = 0; experiment < 50_000; experiment++) {
    			if (sharedBirthdays(numPeople, 365) > 0) {
    				hasSharedBirthdayNum++;
    			}
    		}
    		double percentage = 100 * (hasSharedBirthdayNum / 50_000.0);
    		System.out.println("Num people: " + numPeople + ", number of experiments with one or more shared birthday: " + hasSharedBirthdayNum + ", percentage: " + percentage);
    	}
    }

	/**
	 * Determine if the chess board represented by board is a safe set up.
	 * <p>
	 * pre: board != null, board.length > 0, board is a square matrix. (In other
	 * words all rows in board have board.length columns.), all elements of board ==
	 * 'q' or '.'. 'q's represent queens, '.'s represent open spaces.<br>
	 * <p>
	 * post: return true if the configuration of board is safe, that is no queen can
	 * attack any other queen on the board. false otherwise. the parameter
	 * <tt>board</tt> is not altered as a result of this method.<br>
	 * 
	 * @param board the chessboard
	 * @return true if the configuration of board is safe, that is no queen can
	 *         attack any other queen on the board. false otherwise.
	 */
	public static boolean queensAreSafe(char[][] board) {
		char[] validChars = { 'q', '.' };
		// check preconditions
		if (board == null || board.length == 0 || !isSquare(board) || !onlyContains(board, validChars))
			throw new IllegalArgumentException(
					"Violation of precondition: " + "queensAreSafe. The board may not be null, must be square, "
							+ "and may only contain 'q's and '.'s");

		//create boolean arrays that indicate whether a row/col/diag is unsafe
		//index is true if that row/col/diag is unsafe
		boolean[] rows = new boolean[board.length];
		boolean[] cols = new boolean[board.length];
		//diagsOne is for diagonals from bottom-left to top-right, index 0 starts at top-left corner
		boolean[] diagsOne = new boolean[2 * board.length - 1];
		//diagsTwo is for diagonals from top-left to bottom-right, index 0 starts at bottom-left corner
		boolean[] diagsTwo = new boolean[2 * board.length - 1];
		
		//loop through every index in the board
		for (int rindex = 0; rindex < board.length; rindex++) {
			for (int cindex = 0; cindex < board[rindex].length; cindex++) {
				
				//skips if queen not found
				if (board[rindex][cindex] == 'q') {
					//return false if a queen is found in a row/col/diag already marked as unsafe
					if (diagsOne[rindex + cindex] ||
						diagsTwo[(board.length - 1 - rindex) + cindex] ||
						cols[cindex] || rows[rindex]) {
						return false;
					}
					
					//update all the boolean arrays to indicate this row/col/diag is unsafe
					rows[rindex] = true;
					cols[cindex] = true;
					diagsOne[rindex + cindex] = true;
					diagsTwo[(board.length - 1 - rindex) + cindex] = true;
				}
			}
		}
		
		//return true if no conflicts are found
		return true;
	}

	/**
	 * Given a 2D array of ints return the value of the most valuable contiguous sub
	 * rectangle in the 2D array. The sub rectangle must be at least 1 by 1.
	 * <p>
	 * pre: <tt>mat != null, mat.length > 0, mat[0].length > 0,
	 * mat</tt> is a rectangular matrix.
	 * <p>
	 * post: return the value of the most valuable contigous sub rectangle in
	 * <tt>city</tt>.<br>
	 * 
	 * @param city The 2D array of ints representing the value of each block in a
	 *             portion of a city.
	 * @return return the value of the most valuable contigous sub rectangle in
	 *         <tt>city</tt>.
	 */
	public static int getValueOfMostValuablePlot(int[][] city) {
		// check preconditions
		if (city == null || city.length == 0 || city[0].length == 0 || !isRectangular(city))
			throw new IllegalArgumentException(
					"Violation of precondition: " + "getValueOfMostValuablePlot. The parameter may not be null,"
							+ " must value at least one row and at least" + " one column, and must be rectangular.");
		
		//max value of every possible subplot (yet to be found)
		int maxSubplotValue = city[0][0];
		
		//rIndex and cIndex determine the starting point for the subplot we are comparing
		for (int rIndex = 0; rIndex < city.length; rIndex++) {
			for (int cIndex = 0; cIndex < city[rIndex].length; cIndex++) {
				
				//plotRows and plotCols determine the size of the subplot, starting at [rIndex][cIndex]
				for (int plotRows = rIndex + 1; plotRows < city.length + 1; plotRows++) {
					for (int plotCols = cIndex + 1; plotCols < city[rIndex].length + 1; plotCols++) {
						
						int subplotValue = 0;
						
						//sum the positions of the subplot to calculate the subplot value
						for (int rAddIndex = rIndex; rAddIndex < plotRows; rAddIndex++) {
							for (int cAddIndex = cIndex; cAddIndex < plotCols; cAddIndex++) {
								subplotValue += city[rAddIndex][cAddIndex];
							}
						}
						
						//update maxSubplotValue if subplotValue is the new max value
						if (subplotValue > maxSubplotValue) {
							maxSubplotValue = subplotValue;
						}
					}
				}
			}
		}

		return maxSubplotValue;
	}

	// !!!!! ***** !!!!! ***** !!!!! ****** !!!!! ****** !!!!! ****** !!!!!!
	// CS314 STUDENTS: Put your birthday problem experiment code here:

	// pre: list != null
	// post: return true if at least one element in list is null
	// otherwise return false.
	private static boolean atLeastOneNonNull(String[] list) {
		// check precondition
		if (list == null)
			throw new IllegalArgumentException(
					"Violation of precondition: " + "atLeastOneNonNull. parameter may not equal null.");

		boolean foundNonNull = false;
		int i = 0;
		while (!foundNonNull && i < list.length) {
			foundNonNull = list[i] != null;
			i++;
		}
		return foundNonNull;
	}

	/*
	 * pre: mat != null post: return true if mat is a square matrix, false otherwise
	 */
	private static boolean isSquare(char[][] mat) {
		if (mat == null)
			throw new IllegalArgumentException("Violation of precondition: " + "isSquare. paremeter may not be null.");

		final int numRows = mat.length;
		int row = 0;
		boolean isSquare = true;
		while (isSquare && row < numRows) {
			isSquare = (mat[row] != null) && (mat[row].length == numRows);
			row++;
		}
		return isSquare;
	}

	/*
	 * pre: mat != null, valid != null post: return true if all elements in mat are
	 * one of the characters in valid
	 */
	private static boolean onlyContains(char[][] mat, char[] valid) {
		// check preconditions
		if (mat == null || valid == null)
			throw new IllegalArgumentException(
					"Violation of precondition: " + "onlyContains. paremeters may not be null.");

		int row = 0;
		boolean correct = true;
		while (correct && row < mat.length) {
			int col = 0;
			while (correct && col < mat[row].length) {
				correct = contains(valid, mat[row][col]);
				col++;
			}
			row++;
		}
		return correct;
	}

	/*
	 * pre: list != null post: return true if c is in list
	 */
	private static boolean contains(char[] list, char tgtChar) {
		// check preconditions
		if (list == null)
			throw new IllegalArgumentException("Violation of precondition: " + "contains. paremeter may not be null.");

		boolean found = false;
		int index = 0;
		while (!found && index < list.length) {
			found = list[index] == tgtChar;
			index++;
		}
		return found;
	}

	// pre: mat != null, mat.length > 0
	// post: return true if mat is rectangular
	private static boolean isRectangular(int[][] mat) {
		// check preconditions
		if (mat == null || mat.length == 0)
			throw new IllegalArgumentException("Violation of precondition: "
					+ "isRectangular. paremeter may not be null and must contain" + " at least one row.");

		boolean correct = mat[0] != null;
		int row = 0;
		while (correct && row < mat.length) {
			correct = (mat[row] != null) && (mat[row].length == mat[0].length);
			row++;
		}
		return correct;
	}

	// make constructor private so no instances of CodeCamp can be created
	private CodeCamp() {
		
	}
}