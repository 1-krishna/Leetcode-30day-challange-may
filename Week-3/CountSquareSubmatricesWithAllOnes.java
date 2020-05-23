/*
Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

 

Example 1:

Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.
Example 2:

Input: matrix = 
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
Explanation: 
There are 6 squares of side 1.  
There is 1 square of side 2. 
Total number of squares = 6 + 1 = 7.
 

Constraints:

1 <= arr.length <= 300
1 <= arr[0].length <= 300
0 <= arr[i][j] <= 1
   Hide Hint #1  
Create an additive table that counts the sum of elements of submatrix with the superior corner at (0,0).
   Hide Hint #2  
Loop over all subsquares in O(n^3) and check if the sum make the whole array to be ones, if it checks then add 1 to the answer.
 */

class Solution {
    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] tempmatrix= new int[rows][cols];
        int sum=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(i==0 || j==0){
                    tempmatrix[i][j]=matrix[i][j];
                    sum+=tempmatrix[i][j];
                }else if(matrix[i][j]!=0){
                    tempmatrix[i][j]= Math.min(tempmatrix[i-1][j-1],Math.min(tempmatrix[i-1][j],tempmatrix[i][j-1]))+1;
                    sum+=tempmatrix[i][j];
                }else{
                    tempmatrix[i][j]=0;
                }
            }
        }
        return sum;
    }
}