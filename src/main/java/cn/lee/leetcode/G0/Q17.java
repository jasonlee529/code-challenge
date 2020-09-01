package cn.lee.leetcode.G0;

import ch.qos.logback.core.util.StringCollectionUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
    * @Title: Q17
    * @Description: 
    * @author libo
    * @date 2020/8/27 15:38
    * @Version 1.0
    */
@Slf4j
public class Q17 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
    public static List<String> letterCombinations(String digits) {
        Map<String,List<String>> map = new HashMap();
        map.put("2", Arrays.asList("a","b","c"));
        map.put("3", Arrays.asList("d","e","f"));
        map.put("4", Arrays.asList("g","h","i"));
        map.put("5", Arrays.asList("j","k","l"));
        map.put("6", Arrays.asList("m","n","o"));
        map.put("7", Arrays.asList("p","q","r","s"));
        map.put("8", Arrays.asList("t","u","v"));
        map.put("9", Arrays.asList("w","x","y","z"));
        List<String> res = new ArrayList<>();
        for(char str : digits.toCharArray()){
           List<String> test =  map.get(String.valueOf(str));
            List<String> tmp=new ArrayList<>();
           for(String key1:res){
               for(String key2:test){
                   tmp.add(key1+key2);
               }
           }
           if(res.size()==0){
               res=test;
           }else{
               res=tmp;
           }
        }
        return res;
    }
}
