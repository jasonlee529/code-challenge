package cn.lee.leetcode.probolems.g7;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @Title: Q721
 * @Description: https://leetcode-cn.com/problems/accounts-merge/
 * @author: libo
 * @date: 2021/1/18 9:12
 * @Version: 1.0
 */
@Slf4j
public class Q721 {
    @Test
    public void test1() {
        Assert.assertEquals("",
                accountsMerge(Arrays.asList(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com")
                        , Arrays.asList("John", "johnnybravo@mail.com")
                        , Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com")
                        , Arrays.asList("Mary", "mary@mail.com"))).toString());
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<String>> res = new HashMap<>();
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            String name = account.get(0);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (map.containsKey(email)) {
                    String key = map.get(email);
                    List<String> tmp = res.getOrDefault(key, new ArrayList<String>() {{
                        this.add(name);
                    }});
                    tmp.add(email);
                    res.put(key, tmp);
                } else {
                    String key = name + "__" + i;
                    map.put(email, name + "__" + i);
                    List<String> tmp = res.getOrDefault(key, new ArrayList<String>() {{
                        this.add(name);
                    }});
                    tmp.add(email);
                    res.put(key, tmp);
                }
            }
        }
        return new ArrayList<>(res.values());
    }
}
