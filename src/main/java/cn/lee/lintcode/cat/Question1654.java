package cn.lee.lintcode.cat;

/**
 * https://www.lintcode.com/problem/most-frequently-appearing-letters/description?_from=cat
 */
public class Question1654 {

    public int mostFrequentlyAppearingLetters(String str) {
        // Write your code here.
        int max = 0;
        int[] counts = new int[Character.MAX_CODE_POINT];
        for(char c : str.toCharArray()){
            counts[c]+= 1;
        }
        for(int i:counts){
            if(i>max){
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Question1654 question = new Question1654();
        System.out.println(question.mostFrequentlyAppearingLetters("ABCabcA"));
        System.out.println(question.mostFrequentlyAppearingLetters("abca"));
    }
}
