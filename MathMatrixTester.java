import java.util.Random;

/*  Student information for assignment:
 *
 *  UTEID: el26609
 *  email address: ethanlao@cs.utexas.edu
 *  Grader name:
 *  Number of slip days I am using: 0
 */



/* CS314 Students. Put your experiment results and
 * answers to questions here.
 * 
 * Experiment 1:
 * Matrix size: 700, N, Total time: 1.683519416
 * Matrix size: 1400, 2N, Total time: 6.235344582
 * Matrix size: 2800, 4N, Total time: 25.65539528
 * 
 * Experiment 2:
 * Matrix size: 250, N, Total time: 1.633703566
 * Matrix size: 500, 2N, Total time: 24.762974353
 * Matrix size: 1000, 4N, Total time: 325.099368875
 * 
 * Questions:
 * 1. about 102.62156 seconds
 * 2. O(N^2). The timing data supports this, where doubling N quadruples the time
 * 3. about 4268.04946 seconds
 * 4. O(N^3). The timing data does not quite support this, multiplying by a factor of about 13
 * 5. Matrix of size 14939. This is equivalent to 59756 bytes
 */

/**
 * A class to run tests on the MathMatrix class
 */
public class MathMatrixTester {

    /**
     * main method that runs simple test on the MathMatrix class
     *
     * @param args not used
     */
    public static void main(String[] args) {
    	
    	//experiment 1
    	Random randNumGen = new Random(1234567);
    	MathMatrix matEx1;// = createMat(randNumGen, 700, 700, 100);
    	MathMatrix matEx2;// = createMat(randNumGen, 700, 700, 100);
    	Stopwatch st = new Stopwatch();
    	/*st.start();
    	for (int i = 0; i < 1000; i++) {
    		matEx1.add(matEx2);
    	}
    	st.stop();
    	System.out.println("Matrix size: 700, N, Total time: " + st.time());
    	
    	matEx1 = createMat(randNumGen, 1400, 1400, 100);
    	matEx2 = createMat(randNumGen, 1400, 1400, 100);
    	st.start();
    	for (int i = 0; i < 1000; i++) {
    		matEx1.add(matEx2);
    	}
    	st.stop();
    	System.out.println("Matrix size: 1400, 2N, Total time: " + st.time());
    	
    	matEx1 = createMat(randNumGen, 2800, 2800, 100);
    	matEx2 = createMat(randNumGen, 2800, 2800, 100);
    	st.start();
    	for (int i = 0; i < 1000; i++) {
    		matEx1.add(matEx2);
    	}
    	st.stop();
    	System.out.println("Matrix size: 2800, 4N, Total time: " + st.time());
    	*/
    	//Experiment 2
    	matEx1 = createMat(randNumGen, 220, 220, 100);
    	matEx2 = createMat(randNumGen, 220, 220, 100);
    	st.start();
    	for (int i = 0; i < 100; i++) {
    		matEx1.multiply(matEx2);
    	}
    	st.stop();
    	System.out.println("Matrix size: 250, N, Total time: " + st.time());
    	
    	matEx1 = createMat(randNumGen, 440, 440, 100);
    	matEx2 = createMat(randNumGen, 440, 440, 100);
    	st.start();
    	for (int i = 0; i < 100; i++) {
    		matEx1.multiply(matEx2);
    	}
    	st.stop();
    	System.out.println("Matrix size: 500, 2N, Total time: " + st.time());
    	
    	matEx1 = createMat(randNumGen, 880, 880, 100);
    	matEx2 = createMat(randNumGen, 880, 880, 100);
    	st.start();
    	for (int i = 0; i < 100; i++) {
    		matEx1.multiply(matEx2);
    	}
    	st.stop();
    	System.out.println("Matrix size: 1000, 4N, Total time: " + st.time());
    	System.exit(0);
    	
    	//test 1
    	int[][] data1 = new int[200][200];
    	MathMatrix matTester1 = new MathMatrix(data1);
    	int [][] ans1 = new int[200][200];
    	printTestResult(get2DArray(matTester1), ans1, 1, "Constructor with 2D array provided");
    	
    	//test 2
    	data1 = new int[][] { { 2, 7, 3, -3, 15, 12 },
    						 { -8, 2, 11, -5, 5, -3 } };
        int[][] data2 = { {6, 2, -5, 12, -6, 3},
        		          {7, 8, -3, 0, -1, 13} };
    	matTester1 = new MathMatrix(data1);
    	ans1 = new int[][] { { 2, 7, 3, -3, 15, 12 },
    					     { -8, 2, 11, -5, 5, -3 } };
    	printTestResult(get2DArray(matTester1), ans1, 2, "Constructor with 2D array provided");
    	
    	//test 3
    	matTester1 = new MathMatrix(4, 6, Integer.MAX_VALUE);
    	ans1 = new int[][] { {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE },
    						{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE },
    						{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE },
    						{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE } };
    	printTestResult(get2DArray(matTester1), ans1, 3, "Constructor with size and initial value specified");
    	
    	//test 4
    	matTester1 = new MathMatrix(200, 200, 0);
    	ans1 = new int[200][200];
    	printTestResult(get2DArray(matTester1), ans1, 4, "Constructor with size and initial value specified");
    	
    	//test 5
    	matTester1 = new MathMatrix(200, 300, 0);
    	int ans2 = 200;
    	if (matTester1.getNumRows() == ans2) {
    		System.out.println("Test number 5: Get number of rows in matrix. The test passed");
    	}
    	else {
    		System.out.println("Test number 5: Get number of rows in matrix. The test failed");
    	}
    	
    	//test 6
    	matTester1 = new MathMatrix(data1);
    	ans2 = 2;
    	if (matTester1.getNumRows() == ans2) {
    		System.out.println("Test number 6: Get number of rows in matrix. The test passed");
    	}
    	else {
    		System.out.println("Test number 6: Get number of rows in matrix. The test failed");
    	}
    	
    	//test 7
    	matTester1 = new MathMatrix(data1);
    	ans2 = 6;
    	if (matTester1.getNumColumns() == ans2) {
    		System.out.println("Test number 7: Get number of columns in matrix. The test passed");
    	}
    	else {
    		System.out.println("Test number 7: Get number of columns in matrix. The test failed");
    	}
    	
    	//test 8
    	matTester1 = new MathMatrix(200, 300, 0);
    	ans2 = 300;
    	if (matTester1.getNumColumns() == ans2) {
    		System.out.println("Test number 8: Get number of columns in matrix. The test passed");
    	}
    	else {
    		System.out.println("Test number 8: Get number of columns in matrix. The test failed");
    	}
    	
    	//test 9
    	ans2 = 0;
    	if (matTester1.getVal(135, 242) == ans2) {
    		System.out.println("Test number 9: Get number value with row and col index specified. The test passed");
    	}
    	else {
    		System.out.println("Test number 9: Get number value with row and col index specified. The test failed");
    	}
    	
    	//test 10
    	matTester1 = new MathMatrix(data1);
    	ans2 = -5;
    	if (matTester1.getVal(1, 3) == ans2) {
    		System.out.println("Test number 10: Get number value with row and col index specified. The test passed");
    	}
    	else {
    		System.out.println("Test number 10: Get number value with row and col index specified. The test failed");
    	}
    	
    	//test 11
    	MathMatrix matTester2 = new MathMatrix(data2);
    	ans1 = new int[][] { {8, 9, -2, 9, 9, 15},
    						 {-1, 10, 8, -5, 4, 10} };
    	printTestResult(get2DArray(matTester1.add(matTester2)), ans1, 11, "Adding two matrices");
    	
    	//test 12
    	matTester1 = new MathMatrix(200, 500, Integer.MAX_VALUE);
    	matTester2 = new MathMatrix(200, 500, Integer.MIN_VALUE + 1);
    	ans1 = new int[200][500];
    	printTestResult(get2DArray(matTester1.add(matTester2)), ans1, 12, "Adding two matrices");
    	
    	//test 13
    	matTester1 = new MathMatrix(200, 500, Integer.MAX_VALUE);
    	matTester2 = new MathMatrix(200, 500, Integer.MAX_VALUE);
    	ans1 = new int[200][500];
    	printTestResult(get2DArray(matTester1.subtract(matTester2)), ans1, 13, "Subtracting two matrices");
    	
    	//test 14
    	matTester1 = new MathMatrix(data1);
    	matTester2 = new MathMatrix(data2);
    	ans1 = new int[][] { {-4, 5, 8, -15, 21, 9},
					 		 {-15, -6, 14, -5, 6, -16} };
		printTestResult(get2DArray(matTester1.subtract(matTester2)), ans1, 14, "Subtracting two matrices");
    	
    	//test 15
    	int[][] data3 = { { 0, 1 },
    					  { 5, 6 } };
    	int[][] data4 = { { 2, 3, 7 },
				  		  { 7, 2, 9 } };
    	matTester1 = new MathMatrix(data3);
    	matTester2 = new MathMatrix(data4);
    	ans1 = new int[][] { { 7, 2, 9 },
	 		 				 { 52 , 27, 89 } };
	 	printTestResult(get2DArray(matTester1.multiply(matTester2)), ans1, 15, "Multiplying two matrices");
    	
	 	//test 16
	 	matTester1 = new MathMatrix(20, 15, 2);
	 	matTester2 = new MathMatrix(15, 4, 3);
	 	ans1 = new int[][] { { 90, 90, 90, 90 }, { 90, 90, 90, 90 }, { 90, 90, 90, 90 }, { 90, 90, 90, 90 }, { 90, 90, 90, 90 }, 
	 						 { 90, 90, 90, 90 }, { 90, 90, 90, 90 }, { 90, 90, 90, 90 }, { 90, 90, 90, 90 }, { 90, 90, 90, 90 }, 
	 						 { 90, 90, 90, 90 }, { 90, 90, 90, 90 }, { 90, 90, 90, 90 }, { 90, 90, 90, 90 }, { 90, 90, 90, 90 }, 
	 						 { 90, 90, 90, 90 }, { 90, 90, 90, 90 }, { 90, 90, 90, 90 }, { 90, 90, 90, 90 }, { 90, 90, 90, 90 } };
    	printTestResult(get2DArray(matTester1.multiply(matTester2)), ans1, 16, "Multiplying two matrices");
    	
    	//test 17
    	matTester1 = new MathMatrix(6, 4, 2);
    	ans1 = new int[][] { { 6, 6, 6, 6 }, { 6, 6, 6, 6 }, { 6, 6, 6, 6 }, 
    			   			 { 6, 6, 6, 6 }, { 6, 6, 6, 6 }, { 6, 6, 6, 6 } };
        printTestResult(get2DArray(matTester1.getScaledMatrix(3)), ans1, 17, "Scaling the matrix by 3");
    	
    	//test 18
        matTester1 = new MathMatrix(data1);
        ans1 = new int[][] { { 14, 49, 21, -21, 105, 84 },
        				     { -56, 14, 77, -35, 35, -21 } };
        printTestResult(get2DArray(matTester1.getScaledMatrix(7)), ans1, 18, "Scaling the matrix by 7");
    	
    	//test 19
        matTester1 = new MathMatrix(1842, 4813, 0);
    	ans1 = new int[4813][1842];
    	printTestResult(get2DArray(matTester1.getTranspose()), ans1, 19, "Transposing the matrix");
    	
    	//test 20
    	matTester1 = new MathMatrix(data1);
    	ans1 = new int[][] { { 2, -8 }, { 7, 2 }, { 3, 11 }, 
    						 { -3, -5 }, { 15, 5 }, { 12, -3 } };
    	printTestResult(get2DArray(matTester1.getTranspose()), ans1, 20, "Transposing the matrix");
    	
    	//test 21
    	matTester2 = new MathMatrix(data2);
    	if (!matTester1.equals(matTester2)) {
    		System.out.println("Test number 21: Matrices are equivalent. The test passed");
    	}
    	else {
    		System.out.println("Test number 21: Matrices are equivalent. The test failed");
    	}
    	
    	//test 22
    	matTester2 = new MathMatrix(data1);
    	if (matTester1.equals(matTester2)) {
    		System.out.println("Test number 22: Matrices are equivalent. The test passed");
    	}
    	else {
    		System.out.println("Test number 22: Matrices are equivalent. The test failed");
    	}
    	
    	//test 23
    	matTester1 = new MathMatrix(data1);
    	String ans3 = "|  2  7  3 -3 15 12|\n| -8  2 11 -5  5 -3|\n";
    	if (ans3.equals(matTester1.toString())) {
    		System.out.println("Test number 23: Returning a toString. The test passed");
    	}
    	else {
    		System.out.println("Test number 23: Returning a toString. The test failed");
    	}
    	
    	//test 24
    	data3 = new int[][] { { 7, 1, 5, 2, 6, 1, 3, 1, 2, 7, 3, 6, 4, 6, 2, 2, 5 },
    						  { 3, 5, 7, 2, 3, 1, 1, 2, 4, 2, 6, 8, 3, 6, 3, 5, 6 },
    						  { 7, 3, 3, 4, 4, 4, 2, 6, 7, 2, 9, 0, 6, 3, 3, 6, 3 },
    						  { 1, 4, 3, 2, 8, 7, 4, 5, 8, 8125, 2, 6, 2, 1, 1, 1, 3 },
    						  { 4, 7, 1, 7, 3, 8, 9, 0, 0, 6, 9, 3, 8, 5, 6, 1, 8 } };
    	matTester1 = new MathMatrix(data3);
    	ans3 = "|    7    1    5    2    6    1    3    1    2    7    3    6    4    6    2    2    5|\n" + 
    		   "|    3    5    7    2    3    1    1    2    4    2    6    8    3    6    3    5    6|\n" +
    		   "|    7    3    3    4    4    4    2    6    7    2    9    0    6    3    3    6    3|\n" +
    		   "|    1    4    3    2    8    7    4    5    8 8125    2    6    2    1    1    1    3|\n" +
    		   "|    4    7    1    7    3    8    9    0    0    6    9    3    8    5    6    1    8|\n";
    	if (ans3.equals(matTester1.toString())) {
    		System.out.println("Test number 24: Returning a toString. The test passed");
    	}
    	else {
    		System.out.println("Test number 24: Returning a toString. The test failed");
    	}
    	
    	//test 25
    	matTester1 = new MathMatrix(600, 600, 0);
    	if (matTester1.isUpperTriangular()) {
    		System.out.println("Test number 25: The matrix is triangular. The test passed");
    	}
    	else {
    		System.out.println("Test number 25: The matrix is triangular. The test failed");
    	}
    	
    	//test 26
    	data3 = new int[][] { { 1, -6, 3, -2, 5, 2 },
    						  { -8, 3, 0, 7, 1, 0 },
    						  { 1, -3, -8, 3, 0, 0 },
    						  { -5, 7, 2, 0, 0, 0 },
    						  { -9, -1, 0, 0, 0, 0 },
    						  { 7, 0, 0, 0, 0, 0 } };
    	if (matTester1.isUpperTriangular()) {
    		System.out.println("Test number 26: The matrix is triangular. The test passed");
    	}
    	else {
    		System.out.println("Test number 26: The matrix is triangular. The test failed");
    	}
    	
    }

    // method that sums elements of mat, may overflow int!
    // pre: mat != null
    private static int sumVals(MathMatrix mat) {
        if (mat == null) {
            throw new IllegalArgumentException("mat may not be null");
        } 
        int result = 0;
        final int ROWS =  mat.getNumRows();
        final int COLS = mat.getNumColumns();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                result += mat.getVal(r, c); // likely to overflow, but can still do simple check
            }
        }
        return result;
    }

    // create a matrix with random values
    // pre: rows > 0, cols > 0, randNumGen != null
    public static MathMatrix createMat(Random randNumGen, int rows,
            int cols, final int LIMIT) {

        if (randNumGen == null) {
            throw new IllegalArgumentException("randomNumGen variable may no be null");
        } else if(rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("rows and columns must be greater than 0. " +
                    "rows: " + rows + ", cols: " + cols);
        }

        int[][] temp = new int[rows][cols];
        final int SUB = LIMIT / 4;
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                temp[r][c] = randNumGen.nextInt(LIMIT) - SUB;
            }
        }

        return new MathMatrix(temp);
    }

    private static void printTestResult(int[][] data1, int[][] data2, int testNum, String testingWhat) {
        System.out.print("Test number " + testNum + ": " + testingWhat +". The test ");
        String result = equals(data1, data2) ? "passed" : "failed";
        System.out.println(result);
    }

    // pre: m != null, m is at least 1 by 1 in size
    // return a 2d array of ints the same size as m and with 
    // the same elements
    private static int[][] get2DArray(MathMatrix m) {
        //check precondition
        if  ((m == null) || (m.getNumRows() == 0) 
                || (m.getNumColumns() == 0)) {
            throw new IllegalArgumentException("Violation of precondition: get2DArray");
        }

        int[][] result = new int[m.getNumRows()][m.getNumColumns()];
        for(int r = 0; r < result.length; r++) {
            for(int c = 0; c < result[0].length; c++) {
                result[r][c] = m.getVal(r,c);
            }
        }
        return result;
    }

    // pre: data1 != null, data2 != null, data1 and data2 are at least 1 by 1 matrices
    //      data1 and data2 are rectangular matrices
    // post: return true if data1 and data2 are the same size and all elements are
    //      the same
    private static boolean equals(int[][] data1, int[][] data2) {
        //check precondition
        if((data1 == null) || (data1.length == 0) 
                || (data1[0].length == 0) || !rectangularMatrix(data1)
                ||  (data2 == null) || (data2.length == 0)
                || (data2[0].length == 0) || !rectangularMatrix(data2)) {
            throw new IllegalArgumentException( "Violation of precondition: equals check on 2d arrays of ints");
        }
        boolean result = (data1.length == data2.length) && (data1[0].length == data2[0].length);
        int row = 0;
        while (result && row < data1.length) {
            int col = 0;
            while (result && col < data1[0].length) {
                result = (data1[row][col] == data2[row][col]);
                col++;
            }
            row++;
        }

        return result;
    }


    // method to ensure mat is rectangular
    // pre: mat != null, mat is at least 1 by 1
    private static boolean rectangularMatrix( int[][] mat ) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            throw new IllegalArgumentException("Violation of precondition: "
                    + " Parameter mat may not be null" 
                    + " and must be at least 1 by 1");
        }
        return MathMatrix.rectangularMatrix(mat);
    }
}
