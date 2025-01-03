package com.ck.striver.basics.basic;

/*
    Time Complexity:O(1), as the number of conditional checks is constant
    Space Complexity:O(1), as no additional space is used that grows with input
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/language-basics/if-elseif/submissions
public class PrintGradeOfStudent {

    public static void main(String[] args){
        int marks = 90;
        System.out.print(getGrade(marks));
    }

    private static String getGrade(int marks) {
        if(marks>=90) return "Grade A";
        else if(marks>=70) return "Grade B";
        else if(marks>=50) return "Grade C";
        else if(marks>=35) return "Grade D";
        else return "Fail";
    }
}
