package com.peng.clazz;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class HashSetExample {

    public static void main(String args[]){

        Random r = new Random();

        Set<Integer> set = new HashSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);

//        set.add(5);
//        set.add(4);
//        set.add(3);
//        set.add(2);
//        set.add(1);
//
//        set.add(3);
//        set.add(4);
//        set.add(5);
//        set.add(1);
//        set.add(2);



//        default capacity 16
//        set.add(3);
//        set.add(4);
//        set.add(5);
//        set.add(17);
//        set.add(2);

//        for (int v : set) {
//            System.out.println(v);
//        }


        Iterator it = set.iterator();
        while (it.hasNext())
            System.out.println(it.next());
//        int h ;
//int i;
//

//int n  = 16;
//
//int hash = 1231236;
//        System.out.println(i = (n - 1) & hash);

//        System.out.println( h = 9);
        System.out.println(String.format("total size: %s", set.size()));
    }


}


/**
 * 取余数 ，如果n是2的密，n-1就全是1，1&一个整数，便是该整数hash和n的余数
 *
 *
 * 结合jmh
 *
 *
 * HashMap
 * Computes key.hashCode() and spreads (XORs) higher bits of hash
 * to lower.  Because the table uses power-of-two masking, sets of
 * hashes that vary only in bits above the current mask will
 * always collide. (Among known examples are sets of Float keys
 * holding consecutive whole numbers in small tables.)  So we
 * apply a transform that spreads the impact of higher bits
 * downward. There is a tradeoff between speed, utility, and
 * quality of bit-spreading. Because many common sets of hashes
 * are already reasonably distributed (so don't benefit from
 * spreading), and because we use trees to handle large sets of
 * collisions in bins, we just XOR some shifted bits in the
 * cheapest possible way to reduce systematic lossage, as well as
 * to incorporate impact of the highest bits that would otherwise
 * never be used in index calculations because of table bounds.
//static final int hash(Object key) {
//    int h;
//    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
//}
// */
