package cn.lee.lintcode.cat;

import java.util.*;

/**
 * https://www.lintcode.com/problem/a-b-problem/description?_from=cat
 */
public class Question200 {

    public String longestPalindrome(String s) {
        // write your code here
        String result = "";
        int max = 0;
        List<String> lineups = new ArrayList<>();
        for (int j = s.length(); j > 0; j--) {
            for (int i = 0; i < j; i++) {
                String t = s.substring(i, j);
                lineups.add(t);

            }
        }
        for (String t : lineups) {
            if (t.length() <= result.length()) {
                continue;
            }
            if (isPalindromes(t)) {
                if (result.length() < t.length()) {
                    result = t;
                }
            }
        }
        return result;
    }

    private boolean isPalindromes(String str) {
        Queue<Character> queue = new LinkedList<>();
        Deque<Character> stack = new LinkedList();
        for (char c : str.toCharArray()) {
            queue.add(c);
            stack.push(c);
        }
        while (queue.size() > 0) {
            if (queue.poll() != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Question200 question = new Question200();
        System.out.println(question.longestPalindrome("abcdzdcab"));
        System.out.println(question.longestPalindrome("aba"));
        System.out.println(question.longestPalindrome("a"));
        System.out.println(question.longestPalindrome("abb"));
        System.out.println(question.longestPalindrome("jglknendplocymmvwtoxvebkekzfdhykknufqdkntnqvgfbahsljkobhbxkvyictzkqjqydczuxjkgecdyhixdttxfqmgksrkyvopwprsgoszftuhawflzjyuyrujrxluhzjvbflxgcovilthvuihzttzithnsqbdxtafxrfrblulsakrahulwthhbjcslceewxfxtavljpimaqqlcbrdgtgjryjytgxljxtravwdlnrrauxplempnbfeusgtqzjtzshwieutxdytlrrqvyemlyzolhbkzhyfyttevqnfvmpqjngcnazmaagwihxrhmcibyfkccyrqwnzlzqeuenhwlzhbxqxerfifzncimwqsfatudjihtumrtjtggzleovihifxufvwqeimbxvzlxwcsknksogsbwwdlwulnetdysvsfkonggeedtshxqkgbhoscjgpiel"));

    }
}
