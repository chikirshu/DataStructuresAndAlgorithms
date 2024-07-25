package com.ck.arrays.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// LC - 68 : Text Justification
// https://leetcode.com/problems/text-justification/
public class TextJustification {

    public static void main(String[] args){
        String[] words = new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        System.out.println(fullJustifyII(words, 20));
    }

    public static List<String> fullJustifyII(String[] words, int maxWidth){
        int n = words.length;
        List<String> ans = new ArrayList<>();
        for(int i=0; i< n; i++){
            int j=i+1;
            int currentWordsLength = words[i].length();
            int availableSpaceCandidate = 0;
            while(j<n && currentWordsLength+availableSpaceCandidate+1+words[j].length()<=maxWidth){
                currentWordsLength += words[j].length();
                availableSpaceCandidate++;
                j++;
            }
            //int remainingSpaces = maxWidth-currentWordsLength-availableSpaceCandidate;

            StringBuilder sb = new StringBuilder();

            int totalSpace = maxWidth-currentWordsLength;
            int evenDistribution = availableSpaceCandidate==0?0:totalSpace/availableSpaceCandidate;
            int remainderSpace = availableSpaceCandidate==0?0:totalSpace%availableSpaceCandidate;

            for(int k=i;k<j;k++){
                sb.append(words[k]);

                // if last line
                if(j==n) {
                    evenDistribution=1;
                    remainderSpace=0;
                }

                // extra spaces should not be put at the last
                if(k!=j-1){
                    for(int l = evenDistribution;l>0;l--) sb.append(" ");
                    if(remainderSpace>0){
                        sb.append(" ");
                        remainderSpace--;
                    }
                }
            }

            // Add trailing spaces for last line of lines with just 1 word
            while(sb.length()<maxWidth)sb.append(" ");
            String s = sb.toString();

            i=j-1;
            ans.add(s);
        }
        return ans;
    }

    // will fail for String[] words = new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
    public static List<String> fullJustifyI(String[] words, int maxWidth) {

        Queue<String> wordsQueue = new LinkedList<>();
        Queue<String> currentLineQueue = new LinkedList<>();
        List<String> ans = new ArrayList<>();
        int totalChars = 0, minSpace = words.length-1;

        for(String s: words){
            totalChars+=s.length();
            wordsQueue.add(s);
        }

        int totalIterations = (int) Math.ceil((double)(totalChars+minSpace)/maxWidth);

        for(int i=0;i<totalIterations;i++){
            int remainingChars = maxWidth, currentNonSpaceChars=0;
            StringBuilder str = new StringBuilder();
            minSpace = 0;
            while(!wordsQueue.isEmpty()){
                String s = wordsQueue.peek();
                if(currentLineQueue.isEmpty()){
                    currentLineQueue.add(s);
                    currentNonSpaceChars+=s.length();
                    remainingChars-=currentNonSpaceChars;
                    wordsQueue.poll();
                }
                else if(1+s.length()<=remainingChars){
                    currentLineQueue.add(s);
                    minSpace+=1;
                    currentNonSpaceChars+=s.length();
                    remainingChars=maxWidth-currentNonSpaceChars-minSpace;
                    wordsQueue.poll();
                }
                else
                    break;
            }

            int evenExtraSpace=0;
            if(minSpace>0) evenExtraSpace = remainingChars/minSpace;
            int remainderSpaces=remainingChars-(evenExtraSpace*minSpace);
            int totalWordsInCurrentAns = currentLineQueue.size();
            while(!currentLineQueue.isEmpty()){
                int extraSpace = evenExtraSpace;
                str.append(currentLineQueue.poll());

                if(minSpace>0){
                    str.append(" ");
                    minSpace--;
                }

                // logic of adding/distributing extra spaces, which is not applicable if i=totalIterations-1
                if(i==totalIterations-1){
                    if(currentLineQueue.isEmpty()){
                        while(remainingChars>0) {
                            str.append(" ");
                            remainingChars--;
                        }
                    }
                }
                else{
                    if(remainderSpaces>0){
                        if(totalWordsInCurrentAns==1){
                            while(remainderSpaces>0){
                                str.append(" ");
                                remainderSpaces--;
                            }
                        }
                        else{
                            str.append(" ");
                            remainderSpaces--;
                        }
                    }
                    if(!currentLineQueue.isEmpty()){
                        while(extraSpace>0){
                            str.append(" ");
                            extraSpace--;
                        }
                    }
                }
            }
            ans.add(str.toString());
        }
        return ans;
    }
}
