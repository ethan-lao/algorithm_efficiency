import java.util.Arrays;
//MathMatrix.java - CS314 Assignment 2

/*  Student information for assignment:
*
*  On my honor, Ethan Lao, this programming assignment is my own work
*  and I have not provided this code to any other student.
*
*  UTEID: el25598
*  email address: ethanlao@cs.utexas.edu
*  Unique section number: 50265
*  Number of slip days I am using: 0
*/

/**
 * A class that models systems of linear equations (Math Matrices)
 * as used in linear algebra.
 */
public class MathMatrix {
    
    // instance variables
	private int[][] matrixArray;

    /**
     * create a MathMatrix with cells equal to the values in mat.
     * A "deep" copy of mat is made.
     * Changes to mat after this constructor do not affect this
     * Matrix and changes to this MathMatrix do not affect mat
     * @param  mat  mat !=null, mat.length > 0, mat[0].length > 0,
     * mat is a rectangular matrix
     */
    public MathMatrix(int[][] mat) {
    	//check preconditions
    	if (mat == null || mat.length == 0 || mat[0].length == 0 || !rectangularMatrix(mat)) {
    		throw new IllegalArgumentException("Violation of precondition: "
					+ "MathMatrix. Parameter may not equal null, it must have a length greater than 0, "
    				+ "the length of the parameter's first element must be greater than 0, "
					+ "and the parameter must be a rectangular matrix.");
    	}
    	
    	//create array of size mat
    	matrixArray = new int[mat.length][mat[0].length];
    	
    	//deep copy mat into matrixArray
    	for (int rIndex = 0; rIndex < mat.length; rIndex++) {
    		for (int cIndex = 0; cIndex < mat[0].length; cIndex++) {
    			matrixArray[rIndex][cIndex] = mat[rIndex][cIndex];
    		}
    	}
    }


    /**
     * create a MathMatrix of the specified size with all cells set to the intialValue.
     * <br>pre: numRows > 0, numCols > 0
     * <br>post: create a matrix with numRows rows and numCols columns. 
     * All elements of this matrix equal initialVal.
     * In other words after this method has been called getVal(r,c) = initialVal 
     * for all valid r and c.
     * @param numRows numRows > 0
     * @param numCols numCols > 0
     * @param initialVal all cells of this Matrix are set to initialVal
     */
    public MathMatrix(int numRows, int numCols, int initialVal) {
    	//check preconditions
    	if (numRows <= 0 || numCols <= 0) {
    		throw new IllegalArgumentException("Violation of precondition: "
					+ "MathMatrix. First two paramaters must be greater than 0. "
    				+ "numRows: " + numRows + ", numCols: " + numCols);
    	}
    	
    	//create array of size mat
    	matrixArray = new int[numRows][numCols];
    	
    	//set all values in matrixArray to initialVal
    	for (int rIndex = 0; rIndex < numRows; rIndex++) {
    		for (int cIndex = 0; cIndex < numCols; cIndex++) {
    			matrixArray[rIndex][cIndex] = initialVal;
    		}
    	}
    }

    
    /**
     * Get the number of rows.
     * @return the number of rows in this MathMatrix
     */
    public int getNumRows() {
        return matrixArray.length;
    }


    /**
     * Get the number of columns.
     * @return the number of columns in this MathMatrix
     */
    public int getNumColumns(){
        return matrixArray[0].length;
    }


    /**
     * get the value of a cell in this MathMatrix.
     * <br>pre: row  0 <= row < getNumRows(), col  0 <= col < getNumColumns()
     * @param  row  0 <= row < getNumRows()
     * @param  col  0 <= col < getNumColumns()
     * @return the value at the specified position
     */
    public int getVal(int row, int col) {
    	//check preconditions
    	if (row < 0 || row >= getNumRows() || col < 0 || col >= getNumColumns()) {
    		throw new IndexOutOfBoundsException("Violation of precondition: "
					+ "getVal. Both paramaters must be greater than 0, "
    				+ "first parameter must be less than getNumRows(), "
					+ "second parameter must be less than getNumCols(). "
    				+ "row: " + row + ", col: " + col);
    	}
    	
        return matrixArray[row][col];
    }


    /**
     * implements MathMatrix addition, (this MathMatrix) + rightHandSide.
     * <br>pre: rightHandSide.getNumRows() = getNumRows(), rightHandSide.numCols() = getNumColumns()
     * <br>post: This method does not alter the calling object or rightHandSide
     * @param rightHandSide rightHandSide.getNumRows() = getNumRows(), rightHandSide.numCols() = getNumColumns()
     * @return a new MathMatrix that is the result of adding this Matrix to rightHandSide.
     * The number of rows in the returned Matrix is equal to the number of rows in this MathMatrix.
     * The number of columns in the returned Matrix is equal to the number of columns in this MathMatrix.
     */
    public MathMatrix add(MathMatrix rightHandSide){
    	//check preconditions
    	if (rightHandSide.getNumRows() != getNumRows() || rightHandSide.getNumColumns() != getNumColumns()) {
    		throw new IllegalArgumentException("Violation of precondition: "
					+ "add. Parameter must have the same number of rows and columns as this matrix.");
    	}
    	
    	//create new array the size of this matrix
    	int[][] addArray = new int[getNumRows()][getNumColumns()];
    	
    	for (int rIndex = 0; rIndex < getNumRows(); rIndex++) {
    		for (int cIndex = 0; cIndex < getNumColumns(); cIndex++) {
    			//index in addArray set to sum of values at same index in this matrix and RHS
    			addArray[rIndex][cIndex] = getVal(rIndex, cIndex) + rightHandSide.getVal(rIndex, cIndex);
    		}
    	}
    	
        return new MathMatrix(addArray);
    }


    /**
     * implements MathMatrix subtraction, (this MathMatrix) - rightHandSide.
     * <br>pre: rightHandSide.getNumRows() = getNumRows(), rightHandSide.numCols() = getNumColumns()
     * <br>post: This method does not alter the calling object or rightHandSide
     * @param rightHandSide rightHandSide.getNumRows() = getNumRows(), rightHandSide.numCols() = getNumColumns()
     * @return a new MathMatrix that is the result of subtracting rightHandSide from this MathMatrix.
     * The number of rows in the returned MathMatrix is equal to the number of rows in this MathMatrix.
     * The number of columns in the returned MathMatrix is equal to the number of columns in this MathMatrix.
     */
    public MathMatrix subtract(MathMatrix rightHandSide){
    	//check preconditions
    	if (rightHandSide.getNumRows() != getNumRows() || rightHandSide.getNumColumns() != getNumColumns()) {
    		throw new IllegalArgumentException("Violation of precondition: "
					+ "add. Parameter must have the same number of rows and columns as this matrix.");
    	}
    	
    	//create new array the size of this matrix
    	int[][] subtractArray = new int[getNumRows()][getNumColumns()];
    	
    	for (int rIndex = 0; rIndex < getNumRows(); rIndex++) {
    		for (int cIndex = 0; cIndex < getNumColumns(); cIndex++) {
    			//index in subtractArray set to value in this matrix minus value in RHS at same index
    			subtractArray[rIndex][cIndex] = getVal(rIndex, cIndex) - rightHandSide.getVal(rIndex, cIndex);
    		}
    	}
    	
        return new MathMatrix(subtractArray);
    }


    /**
     * implements matrix multiplication, (this MathMatrix) * rightHandSide.
     * <br>pre: rightHandSide.getNumRows() = getNumColumns()
     * <br>post: This method should not alter the calling object or rightHandSide
     * @param rightHandSide rightHandSide.getNumRows() = getNumColumns()
     * @return a new MathMatrix that is the result of multiplying this MathMatrix and rightHandSide.
     * The number of rows in the returned MathMatrix is equal to the number of rows in this MathMatrix.
     * The number of columns in the returned MathMatrix is equal to the number of columns in rightHandSide.
     */
    public MathMatrix multiply(MathMatrix rightHandSide){
    	//check preconditions
    	if (rightHandSide.getNumRows() != getNumColumns()) {
    		throw new IllegalArgumentException("Violation of precondition: "
					+ "add. Parameter must have the same number of rows as columns in this matrix.");
    	}
    	
    	//create new array with rows the size of this matrix and columns the size of RHS
    	int[][] multArray = new int[getNumRows()][rightHandSide.getNumColumns()];
    	
    	//loop for number of ROWS in THIS matrix
    	for (int rIndex = 0; rIndex < getNumRows(); rIndex++) {
    		//loop for number of COLUMNS in RHS matrix
    		for (int cIndex = 0; cIndex < rightHandSide.getNumColumns(); cIndex++) {
    			//sum the row of this matrix with the column of rightHandSide
    			int sum = 0;
    			for (int sumIndex = 0; sumIndex < getNumColumns(); sumIndex++) {
    				sum += (getVal(rIndex, sumIndex) * rightHandSide.getVal(sumIndex, cIndex));
    			}
    			
    			//index of multArray set to the sum of products of rIndex of this matrix and cIndex of RHS
    			multArray[rIndex][cIndex] = sum;
    		}
    	}
    	
        return new MathMatrix(multArray);
    }

    
    /**
     * Create and return a new Matrix that is a copy
     * of this matrix, but with all values multiplied by a scale
     * value.
     * <br>pre: none
     * <br>post: returns a new Matrix with all elements in this matrix 
     * multiplied by factor. 
     * In other words after this method has been called 
     * returned_matrix.getVal(r,c) = original_matrix.getVal(r, c) * factor
     * for all valid r and c.
     * @param factor the value to multiply every cell in this Matrix by.
     * @return a MathMatrix that is a copy of this MathMatrix, but with all
     * values in the result multiplied by factor.
     */
    public MathMatrix getScaledMatrix(int factor) {
    	//create new array the size of this matrix
    	int[][] scaledArray = new int[getNumRows()][getNumColumns()];
    	
    	for (int rIndex = 0; rIndex < getNumRows(); rIndex++) {
    		for (int cIndex = 0; cIndex < getNumColumns(); cIndex++) {
    			//index in scaledArray set to value in this matrix at same index times factor
    			scaledArray[rIndex][cIndex] = (factor * getVal(rIndex, cIndex));
    		}
    	}
    	
        return new MathMatrix(scaledArray);
    }

    
    /**
     * accessor: get a transpose of this MathMatrix. 
     * This Matrix is not changed.
     * <br>pre: none
     * @return a transpose of this MathMatrix
     */
    public MathMatrix getTranspose() {
    	//create new array the size of this matrix
    	int[][] transposedArray = new int[getNumColumns()][getNumRows()];
    	
    	for (int rIndex = 0; rIndex < getNumRows(); rIndex++) {
    		for (int cIndex = 0; cIndex < getNumColumns(); cIndex++) {
    			//index in transposedArray set to value in this matrix where cIndex and rIndex are reversed
    			transposedArray[cIndex][rIndex] = getVal(rIndex, cIndex);
    		}
    	}
    	
        return new MathMatrix(transposedArray);
    }

    
    /**
     * override equals.
     * @return true if rightHandSide is the same size as this MathMatrix and all values in the
     * two MathMatrix objects are the same, false otherwise
     */
    public boolean equals(Object rightHandSide){
        /* CS314 Students. The following is standard equals
         * method code. We will learn about in the coming weeks.
         */
        boolean result = false;
        if( rightHandSide != null && this.getClass() == rightHandSide.getClass()){
            // rightHandSide is a non null MathMatrix
            MathMatrix otherMatrix = (MathMatrix) rightHandSide;
            result = true;
            
            //check if it is the same object 
            if (otherMatrix == this) {
            	return true;
            }
            
            //check if they have the same size
            if (otherMatrix.getNumRows() != getNumRows() || otherMatrix.getNumColumns() != getNumColumns()) {
            	result = false;
            }
            
            //check if all elements in matrices match
            int rIndex = 0;
            while (result && rIndex < getNumRows()) {
            	int cIndex = 0;
            	while (result && cIndex < getNumColumns()) {
            		result = getVal(rIndex, cIndex) == otherMatrix.getVal(rIndex, cIndex);
            		cIndex++;
            	}
            	rIndex++;
            }
            
        }
        return result;
    }

    
    /**
     * override toString.
     * @return a String with all elements of this MathMatrix. 
     * Each row is on a separate line.
     * Spacing based on longest element in this Matrix.
     */
    public String toString() {
    	//find longest element
    	int maxLength = 0;
    	for (int rIndex = 0; rIndex < getNumRows(); rIndex++) {
    		for (int cIndex = 0; cIndex < getNumColumns(); cIndex++) {
    			String sVal = "" + getVal(rIndex, cIndex);
    			if (sVal.length() > maxLength) {
    				maxLength = sVal.length();
    			}
    		}
    	}
    	
    	//increment max length to add 1 to padding
    	maxLength++;
    	
    	StringBuilder returnString = new StringBuilder();
    	//append each value in matrix to returnString
    	for (int rIndex = 0; rIndex < getNumRows(); rIndex++) {
    		//new row
    		returnString.append("|");
    		for (int cIndex = 0; cIndex < getNumColumns(); cIndex++) {
    			//right justify with maxLength padding
    			returnString.append(String.format("%" + maxLength + "s", "" + getVal(rIndex, cIndex)));
    		}
    		returnString.append("|\n");
    	}
    	
        return returnString.toString();
    }

    
    /**
     * Return true if this MathMatrix is upper triangular. To
     * be upper triangular all elements below the main 
     * diagonal must be 0.<br>
     * pre: this is a square matrix. getNumRows() == getNumColumns()  
     * @return <tt>true</tt> if this MathMatrix is upper triangular,
     * <tt>false</tt> otherwise. 
     */
    public boolean isUpperTriangular() {
    	//check preconditions
    	if (getNumRows() != getNumColumns()) {
    		throw new IllegalArgumentException("Violation of precondition: "
					+ "isUpperTriangular. This matrix must have the same number of rows and columns.");
    	}
    	
    	//cInRow starts at last index and adds on the previous element for each row     	
    	int cInRow = getNumColumns() - 1;
    	
    	//start on row 2, row 1 does not require any 0s
    	for (int rIndex = 1; rIndex < getNumRows(); rIndex++) {
    		int cIndex = cInRow;
    		//check each position at cInRow and onwards for 0s
    		while (cIndex < getNumColumns()) {
    			//return false if 0 found
    			if (getVal(rIndex, cIndex) != 0) {
    				return false;
    			}
    			cIndex++;
    		}
    		cInRow--;
    	}
    	
        return true;
    }

    
    // method to ensure mat is rectangular
    // pre: mat != null, mat has at least one row
    // return true if all rows in mat have the same
    // number of columns false otherwise.
    public static boolean rectangularMatrix(int[][] mat) {
        if (mat == null || mat.length == 0) {
            throw new IllegalArgumentException("argument mat may not be null and must "
                    + " have at least one row. mat = " + Arrays.toString(mat));
        }
        boolean isRectangular = true;
        int row = 1;
        final int COLUMNS = mat[0].length;
        while (isRectangular && row < mat.length) {
            isRectangular = (mat[row].length == COLUMNS);
            row++;
        }
        return isRectangular;
    }
}