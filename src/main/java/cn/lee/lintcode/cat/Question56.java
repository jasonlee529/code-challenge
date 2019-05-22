package cn.lee.lintcode.cat;

public class Question56 {

    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        int[] strs = new int[numbers.length];
        int t = 0;
        for (int i = 0; i < numbers.length; i++) {
            int x = numbers[i];
            strs[t] = i;
            for (int m = 0; m < t; m++) {
                int y = numbers[strs[m]];
                if (y + x == target) {
                    System.out.println(strs[m]+"____"+i);
                    return new int[]{strs[m],i};
                }
            }
            t++;
        }
        return null;
    }

    public void charToInt(char a) {
        System.out.println(Character.getNumericValue(a));
    }

    public static void main(String[] args) {
        Question56 question = new Question56();
        question.charToInt('1');
        question.twoSum(new int[]{2, 7, 11, 15}, 9);
        question.twoSum(new int[]{15, 2, 7, 11}, 9);
        question.twoSum(new int[]{1, 0, -1}, 0);
    }
}
