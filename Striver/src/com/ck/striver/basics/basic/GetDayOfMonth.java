package com.ck.striver.basics.basic;

/*
    Time Complexity:O(1) since the switch statement executes a constant number of operations regardless of input
    Space Complexity:O(1) as there are no data structures that grow with input size, only individual strings are returned
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/language-basics/switch-case/submissions
public class GetDayOfMonth {

    public static void main(String[] args){
        int n = 2;
        System.out.print(getDay(n));
    }

    private static String getDay(int n) {
        switch(n){
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            case 7:
                return "Sunday";
            default:
                return "Invalid";
        }
    }
}
