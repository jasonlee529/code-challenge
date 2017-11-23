package cn.lee.hackerrank.algrithms.implementation;

import java.util.Scanner;

/**
 * Anna and Brian order  items at a restaurant, but Anna declines to eat any of the  item (where ) due to an allergy. When the check comes, they decide to split the cost of all the items they shared; however, Brian may have forgotten that they didn't split the  item and accidentally charged Anna for it.
 * <p>
 * You are given , , the cost of each of the  items, and the total amount of money that Brian charged Anna for her portion of the bill. If the bill is fairly split, print Bon Appetit; otherwise, print the amount of money that Brian must refund to Anna.
 * <p>
 * Input Format
 * <p>
 * The first line contains two space-separated integers denoting the respective values of  (the number of items ordered) and  (the -based index of the item that Anna did not eat).
 * The second line contains  space-separated integers where each integer  denotes the cost, , of item  (where ).
 * The third line contains an integer, , denoting the amount of money that Brian charged Anna for her share of the bill.
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * If Brian did not overcharge Anna, print Bon Appetit on a new line; otherwise, print the difference (i.e., ) that Brian must refund to Anna (it is guaranteed that this will always be an integer).
 * <p>
 * Sample Input 0
 * <p>
 * 4 1
 * 3 10 2 9
 * 12
 * Sample Output 0
 * <p>
 * 5
 * Explanation 0
 * Anna didn't eat item , but she shared the rest of the items with Brian. The total cost of the shared items is  and, split in half, the cost per person is . Brian charged her  for her portion of the bill, which is more than the  dollars worth of food that she actually shared with him. Thus, we print the amount Anna was overcharged, , on a new line.
 * <p>
 * Sample Input 1
 * <p>
 * 4 1
 * 3 10 2 9
 * 7
 * Sample Output 1
 * <p>
 * Bon Appetit
 * Explanation 1
 * Anna didn't eat item , but she shared the rest of the items with Brian. The total cost of the shared items is  and, split in half, the cost per person is . Because this matches the amount, , that Brian charged Anna for her portion of the bill, we print Bon Appetit on a new line.
 * Created by jason on 17-11-23.
 */
public class BonAppétit {
    static int bonAppetit(int n, int k, int b, int[] ar) {
        // Complete this function
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (i == k) {
                continue;
            }
            sum += ar[i];
        }
        if (sum == b * 2) {
            System.out.println("Bon Appetit");
        } else {
            System.out.println(Math.abs(sum / 2 - b));
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] ar = new int[n];
        for (int ar_i = 0; ar_i < n; ar_i++) {
            ar[ar_i] = in.nextInt();
        }
        int b = in.nextInt();
        int result = bonAppetit(n, k, b, ar);
        bonAppetit(10, 2, 198, new int[]{
                40, 39, 97, 5, 2, 84, 35, 93, 59, 39}
        );
    }
}
