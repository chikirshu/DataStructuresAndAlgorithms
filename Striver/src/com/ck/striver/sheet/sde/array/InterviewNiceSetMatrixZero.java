package com.ck.striver.sheet.sde.array;

// LC - 73 : Set Matrix Zeroes
// https://leetcode.com/problems/set-matrix-zeroes/description/
//
public class InterviewNiceSetMatrixZero {

    public static void main(String[] args){
        System.out.println("1st way");
        int[][] matrixI = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };

        setMatrixZeroI(matrixI);

        for(int i=0;i<matrixI.length;i++){
            for(int j=0;j<matrixI[0].length;j++){
                System.out.print(matrixI[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("2nd way");
        // 2nd way
        int[][] matrixII = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        setMatrixZeroII(matrixII);

        for(int i=0;i<matrixII.length;i++){
            for(int j=0;j<matrixII[0].length;j++){
                System.out.print(matrixII[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("3rd way");
        // 3rd way
        int[][] matrixIII = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        setMatrixZeroIII(matrixIII);

        for(int i=0;i<matrixIII.length;i++){
            for(int j=0;j<matrixIII[0].length;j++){
                System.out.print(matrixIII[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("4th way");
        // 3rd way
        int[][] matrixIV = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        setMatrixZeroIV(matrixIV);

        for(int i=0;i<matrixIV.length;i++){
            for(int j=0;j<matrixIV[0].length;j++){
                System.out.print(matrixIV[i][j] + " ");
            }
            System.out.println();
        }
    }

    // worst brute force
    //Time complexity - O(nxm)x(O(n+m))
    // Space complexity - O(nxm)
    private static void setMatrixZeroI(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(!visited[i][j] && matrix[i][j]==0){
                    markRowWithZerosI(matrix,i,visited);
                    markColumnWithZerosI(matrix,j,visited);
                }
            }
        }
    }

    private static void markRowWithZerosI(int[][] matrix, int row, boolean[][] visited) {
        for(int j=0;j<matrix[row].length;j++){
            if(matrix[row][j]!=0){
                matrix[row][j]=0;
                visited[row][j]=true;
            }
        }
    }

    private static void markColumnWithZerosI(int[][] matrix, int col, boolean[][] visited) {
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][col]!=0){
                matrix[i][col]=0;
                visited[i][col]=true;
            }
        }
    }

    // this will not work if any value in the matrix contains integer.MIN_VALUE . Ex = [[-2147483648],[2],[3]]
    // Time complexity - O(nxm)*O(n+m) + O(nxm)
    // Space complexity- O(1)
    private static void setMatrixZeroII(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    markRowWithZerosII(matrix,i);
                    markColumnWithZerosII(matrix,j);
                }
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==Integer.MIN_VALUE){
                    matrix[i][j]=0;
                }
            }
        }
    }

    private static void markRowWithZerosII(int[][] matrix, int row) {
        for(int j=0;j<matrix[row].length;j++){
            if(matrix[row][j]!=0){
                matrix[row][j]=Integer.MIN_VALUE;
            }
        }
    }

    private static void markColumnWithZerosII(int[][] matrix, int col) {
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][col]!=0){
                matrix[i][col]=Integer.MIN_VALUE;
            }
        }
    }

    // Better
    // Time Complexity - 2*O(nxm)
    // Space Complexity - O(n+m)
    private static void setMatrixZeroIII(int[][] matrix) {
        int[] decisionRow = new int[matrix.length];
        int[] decisionCol = new int[matrix[0].length];

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    decisionRow[i]=-1;
                    decisionCol[j]=-1;
                }
            }
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(decisionRow[i]==-1 || decisionCol[j]==-1){
                    matrix[i][j]=0;
                }
            }
        }
    }

    //Optimal
    // Time Complexity - 2*O(n*m) + O(n) + O(m)
    // Space Complexity - O(1)
    private static void setMatrixZeroIV(int[][] matrix){

        int decisionCol0 = -1;

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    if(j==0){
                        decisionCol0=0;
                    }
                    else{
                        matrix[0][j]=0;
                    }
                }
            }
        }

        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }

        if(matrix[0][0]==0){
            for(int j=1;j<matrix[0].length;j++){
                matrix[0][j]=0;
            }
        }

        if(decisionCol0==0){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0]=0;
            }
        }
    }
}
