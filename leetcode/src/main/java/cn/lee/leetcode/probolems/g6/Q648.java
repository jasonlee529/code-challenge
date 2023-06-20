package cn.lee.leetcode.probolems.g6;

import sun.java2d.windows.GDIRenderer;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Title : Q648
 * @Description: : https://leetcode.cn/problems/replace-words/?envType=study-plan-v2&envId=bytedance-2023-spring-sprint
 * @author: liboar@yonyou.com 81915
 * @date: 2023/6/20 18:36
 * @Version:1.0 在英语中，我们有一个叫做 词根(root) 的概念，可以词根后面添加其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 * <p>
 * 现在，给定一个由许多词根组成的词典 dictionary 和一个用空格分隔单词形成的句子 sentence。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 * <p>
 * 你需要输出替换之后的句子。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 * 示例 2：
 * <p>
 * 输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
 * 输出："a a b c"
 */
public class Q648 {

    public String replaceWords(List<String> dictionary, String sentence) {
        Collections.sort(dictionary, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        if (sentence == null || sentence.length() == 0) {
            return sentence;
        }
        String[] keys = sentence.split(" ");
        String white = "";
        StringBuilder res = new StringBuilder();
        for (String key : keys) {
            res.append(white).append(start(key,dictionary));
            white=" ";
        }
        return res.toString();
    }

    private String start(String key, List<String> dictionary) {
        for(String s : dictionary){
            if(key.startsWith(s)){
                return s;
            }
        }
        return key;

    }
}
