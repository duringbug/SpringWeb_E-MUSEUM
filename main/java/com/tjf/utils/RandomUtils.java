package com.tjf.utils;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomUtils {
    public static Set getInfo(int num) {
        Random random = new Random();
        HashSet<String> set = new HashSet<String>();
        for(int i=0;i<num;i++) {
            set.add(String.valueOf(random.nextInt(10)));
        }
        return set;
    }
}
