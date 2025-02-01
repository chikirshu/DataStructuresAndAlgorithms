package com.ck.striver.sheet.sde.array;

import java.util.ArrayList;
import java.util.List;

// Reading Material - Combination formula- https://www.geeksforgeeks.org/ncr-formula/
public class InterviewPascalTriangle {

    public static void main(String[] args){
        int n=6;
        //System.out.println(getPascalTriangleI(n));
        System.out.println(getPascalTriangleII(n));
        System.out.println(getPascalTriangleIII(n));
        System.out.println(getPascalNumberForRowAndCol(6,2));
        System.out.println(getRowI(6));
        System.out.println(getRowII(6));
    }

    /*
        Time Complexity:O(col). For running a loop r times, where r is col - 1.
        Space Complexity: O(1) no extra space used.
    */
    // VarietyI - To print pascal number at a given row and column
    private static long getPascalNumberForRowAndCol(int row, int col){
        int n = row-1, r = col-1;
        return getUsingCombinationFormula(n, r);
    }

    // nCr = n!/(r!*(n-r)!) can be further shorten. ex 10C3 = 10*9*8/(3*2*1)
    private static long getUsingCombinationFormula(int n, int r) {
        int res = 1;
        for(int i=0;i<r;i++){
            res=res*(n-i)/(i+1);
        }
        return res;
    }

    // VarietyII - To print the entire row of a pascal triangle
    // Brute force - Apply the nCr (Binomial Coefficient - Number of ways to choose r objects from n objects) formula to calculate each element of the row.
    // Note - At row n there will always be n elements
    /*
        Time Complexity:O(row*col).
        Space Complexity: O(col) for storing ans
    */
    private static List<Integer> getRowI(int row){
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        for(int col=1;col<row;col++){
            ans.add((int)getUsingCombinationFormula(row-1, col)); // col is already considered as 0 based index so not considering col-1
        }
        return ans;
    }

    // Optimized
    // ex -> [1, 5, 10, 10, 5, 1] =
    // 1, (row-1)/1, ((row-1)/1)*(row-2)/2, (((row-1)/1)*(row-2)/2)*(row-3)/3, ((((row-1)/1)*(row-2)/2)*(row-3)/3)*(row-4)/4, (((((row-1)/1)*(row-2)/2)*(row-3)/3)*(row-4)/4)*(row-5)/5
    /*
        Time Complexity:O(row).
        Space Complexity: O(col) for storing ans
    */
    private static List<Integer> getRowII(int row){
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        long prevAns=1;
        for(int col=1;col<row;col++){
            prevAns= prevAns*(row-col)/col;//prevAns*((row-col)/col); Note - Remember not to use this thing ((row-col)/col) as for numerator<denomitor this will give zero. So divide should be done on whole ans instead
            ans.add((int)prevAns); // currently casting to int. But otherwise the ans should itself be List<Long>
        }
        return ans;
    }


    /*
        Time Complexity:The time complexity is O(n^2) because for each row, a new list is created with a length proportional to the row index,
        and the total number of elements across all rows is proportional to n^2.
        Space Complexity:The space complexity is O(n^2) as we are storing all elements in a List of Lists,
        each list corresponding to a row in Pascal's Triangle, making the total storage proportional to n^2.
    */
    //VarietyIII - Brute Force (Better)
    private static List<List<Integer>> getPascalTriangleII(int n){
        List<List<Integer>> finalAns = new ArrayList<>();
        List<Integer> prevAns = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> crntAns = getPascalNumbers(i, prevAns);
            finalAns.add(crntAns);
            prevAns = crntAns;
        }
        return finalAns;
    }

    private static List<Integer> getPascalNumbers(int n, List<Integer> prevAns) {
        List<Integer> crntAns = new ArrayList<>();

        if(n==0){
            crntAns.add(1);
            return crntAns;
        }

        if(n==1){
            crntAns.add(1);
            crntAns.add(1);
            return crntAns;
        }

        crntAns.add(1);
        int val=0;
        for(int i=1;i<=n-1;i++){
            val = prevAns.get(i-1)+prevAns.get(i);
            crntAns.add(val);
        }
        crntAns.add(1);
        return crntAns;
    }

    //VarietyIII - Brute Force (Worst and Better)
    private static List<List<Integer>> getPascalTriangleIII(int n){
        List<List<Integer>> finalAns = new ArrayList<>();
        for(int i=0;i<n;i++){
            // worst
                /*
                    Time Complexity - O(row*col*col)
                */
            /*for(int j=1;j<=i;j++){
              crntRow.add((int)getUsingCombinationFormula(i,j));
            }*/

            // Better
            /*
                Time Complexity - O(row*row)
            */
            finalAns.add(getRowII(i+1));
        }
        return finalAns;
    }

    // this will fail for n=6
    private static List<List<Integer>> getPascalTriangleFailed(int n) {
        List<List<Integer>> finalAns = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> crntAns = getAllDigits(i);
            finalAns.add(crntAns);
        }
        return finalAns;
    }

    private static List<Integer> getAllDigits(int i) {
        long num = (long)Math.pow(11,i);
        List<Integer> crntAns = new ArrayList<>();

        while(num>0){
            int rem = (int) num%10;
            crntAns.add(rem);
            num=num/10;
        }
        return crntAns;
    }
}
