package com.rabbit.site.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 随机数相关工具
 * @author rabbit
 * @date 2015年9月24日 上午9:05:01
 */
public class RandomUtil {
    private static Random random = new Random();
    private static final char[] CODE_ARRAY = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

    public static String getRandString(int length) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            sb.append(CODE_ARRAY[random.nextInt(CODE_ARRAY.length)]);
        }
        return sb.toString();
    }

    public static int getRandNumber(int bound) {
        return random.nextInt(bound);
    }

    public static <T> List<T> randomList(List<T> list, int needSize) {
        Collections.shuffle(list);
        int size = list.size();
        if (size <= needSize || size == 0) {
            return list;
        }
        List<T> results = new ArrayList<T>();
        for (int i = 0; i < size; i++) {
            if (random.nextInt(Integer.MAX_VALUE) % (size - i) < needSize) {
                results.add(list.get(i));
                needSize--;
            }
        }
        return results;
    }

    // 0 ~ maxValue之间等概率随机找到size个数字，升序
    public static List<Integer> randomList(int maxValue, int size) {

        List<Integer> result = new LinkedList<Integer>();
        if ((size <= 0) || (maxValue < size)) {
            throw new IllegalArgumentException("size must > 0");
        }
        int remines = size;
        for (int i = 0; i < maxValue; i++) {
            if (random.nextInt(Integer.MAX_VALUE) % (maxValue - i) < remines) {
                result.add(i);
                remines--;
            }
        }

        return result;
    }
    
    //分段
    public static List<Integer> genRandomSeg(int total, int segNum, int size){
        List<Integer> result = new LinkedList<Integer>();
        
        List<Integer> list = RandomUtil.randomList(total/size, segNum);
        
        for(int index : list){
            int begin = index * size;
            int end = begin + size;
            System.out.println(String.format("limit %d--->%d", begin, end ));
        }
        
        return result;
    }

    public static <T> T random(List<T> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        return randomList(list, 1).get(0);
    }



    /**
     * 随即生成 0 - ( maxValue -1 ) 的序列
     * 
     * @param maxValue
     * @return
     */
    public static List<Integer> randomSequence(int maxValue) {
        List<Integer> r = new ArrayList<Integer>();
        if (maxValue <= 1) {
            r.add(0);
            return r;
        }
        for (int i = 0; i < maxValue; i++) {
            r.add(i);
        }
        Collections.shuffle(r);
        return r;
    }

    /**
     * small----big区间，随机找到count个数，概率一样
     * 
     * 
     * @author tengfei
     * @param small
     * @param big
     * @param count
     * @return
     */
    public static List<Integer> randomSortSequence(int small, int big, int count) {
        List<Integer> r = new ArrayList<Integer>();
        if (small > big) {
            small = big + (big = small) * 0;
        }
        if (small == big) {
            return r;
        }
        int bound = big - small;
        if (bound == (count - 1)) {
            for (int i = small; i <= big; i++) {
                r.add(i);
            }
        } else {
            while (count > 0) {
                int rd = getRandNumber(bound);
                r.add(small + rd);
                count--;
            }
        }
        return r;
    }

    public static <K, V> List<Map.Entry<K, V>> randomMap(Map<K, V> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        List<Map.Entry<K, V>> list = new ArrayList<Map.Entry<K, V>>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            list.add(entry);
        }
        Collections.shuffle(list);
        return list;
    }

    public static void main(String[] args) {

        for(int i  = 0 ;i<100;i++){
        	System.out.println(getRandString(16));
        }
    }


}
