package com.ck.striver.array.medium;

import java.util.ArrayList;
import java.util.List;

// https://takeuforward.org/plus/data-structures-and-algorithm/arrays/faqs-medium/print-the-matrix-in-spiral-manner/submissions
public class NicePrintMatrixInSpiral {

    enum Direction{
        TOP,LEFT,DOWN,RIGHT;
    }
    public static void main(String[] args){
        int[][] matrix= {
                {42,30,-38,24,-23,27,-16,38,-36},
                {48,4,9,-49,-39,-6,16,-23,3},
                {-8,0,2,26,-14,-36,4,45,41},
                {-37,-20,-5,-2,33,22,11,44,16},
                {-46,23,32,-16,-28,-49,17,44,6},
                {43,5,31,-8,15,-33,-13,37,-34},
                {1,17,13,13,-41,-26,-42,-25,-20},
                {-27,47,21,-23,-28,-23,-22,-32,-17}
        };

        //int[][] matrix={{1},{2},{3}};
        //int[][] matrix={{1,2,3}};

        // this was not needed as it was mentioned the matrix is mxn
//        List<List<Boolean>> visited = new ArrayList<>();
//        for(int i=0;i<matrix.length;i++){
//            List<Boolean> ithRow = new ArrayList<>();
//            for (int j=0;j<matrix[i].length;j++){
//                ithRow.add(false);
//            }
//            visited.add(ithRow);
//        }
        int[][] visited = new int[matrix.length][matrix[0].length];
        System.out.println(getSpiralList(matrix, visited, 0, 0, new ArrayList<>()));
        System.out.println();
        System.out.println(getSpiralListII(matrix));
    }

    /*
        Time Complexity:O(m*n) where m is the number of rows and n is the number of columns since we visit each element once
        Space Complexity:O(m*n) for storing the result list containing all elements of the matrix
     */
    // more optimized less elegant
    private static List<Integer>getSpiralListII(int[][] matrix){
        int top=0,left=0,bottom=matrix.length-1,right=matrix[0].length-1;
        List<Integer> ans = new ArrayList<>();
        while (top<=bottom && left<=right){
            //right
            for(int j=left;j<=right;j++){
                ans.add(matrix[top][j]);
            }
            top++;
            //bottom
            for(int i=top;i<=bottom;i++){
                ans.add(matrix[i][right]);
            }
            right--;
            //left
            if(top<=bottom){
                for(int j=right;j>=left;j--){
                    ans.add(matrix[bottom][j]);
                }
            }
            bottom--;
            //top
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    ans.add(matrix[i][left]);
                }
            }
            left++;
        }
        return ans;
    }

    /*
        Time Complexity:The time complexity is O(m * n) due to visiting each element in the matrix once, where m is the number of rows and n is the number of columns.
        Space Complexity:The space complexity is O(m * n) used for the visited array and the recursive call stack.
    */
    // less optimized more elegant
    private static List<Integer> getSpiralList(int[][] matrix, int[][] visited, int i, int j, List<Integer> ans) {
        if(i<0 || i>=matrix.length || j<0 || j>=matrix[i].length || visited[i][j]==1) return ans;

        ans.add(matrix[i][j]);
        visited[i][j]=1;

        // in enhanced switch loop this will fail, Talking about case RIGHT-> instead of case RIGHT:
        /*switch (direction){
            case RIGHT :
                    ans = getSpiralList(matrix,visited,i,j+1,ans, Direction.RIGHT);//right
            case DOWN :
                    ans = getSpiralList(matrix,visited,i+1,j,ans, Direction.DOWN);//down
            case LEFT :
                    ans = getSpiralList(matrix,visited,i,j-1,ans, Direction.LEFT);//left
            case TOP :
                    ans = getSpiralList(matrix,visited,i-1,j,ans, Direction.TOP);//top
        }*/

        if(!(i-1>=0 && visited[i-1][j]==0)){
            ans = getSpiralList(matrix,visited,i,j+1,ans);
        }
        ans = getSpiralList(matrix,visited,i+1,j,ans);
        ans = getSpiralList(matrix,visited,i,j-1,ans);
        ans = getSpiralList(matrix,visited,i-1,j,ans);


        return ans;
    }
}
