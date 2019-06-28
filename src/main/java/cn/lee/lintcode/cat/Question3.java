package cn.lee.lintcode.cat;

/**
 * https://www.lintcode.com/problem/digit-counts/description
 */
public class Question3 {

    public int digitCounts(int k, int n) {
        int[] arr = new int[10];
        for (int i = 0; i <= n; i++) {
            int j = i;
            if(j==0){
                arr[0] +=1;
            }
            while (j != 0) {
                arr[j % 10] += 1;
                j = j / 10;
            }
        }
        return arr[k];
    }

    public static void main(String[] args) {
        Question3 question = new Question3();
        System.out.println(question.digitCounts(1, 1));
        System.out.println(question.digitCounts(1, 12));
        System.out.println(question.digitCounts(0, 9));
    }
}
