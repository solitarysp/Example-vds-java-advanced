package vn.com.viettel.vds.java.advanced.string.stringpool;

import java.util.Random;

public class StringPoolInternStringTableSize {
    public static void main(String[] args) {
        long timeStart = System.nanoTime();
        for (int i = 0; i < 90000; i++) {
            new String(String.valueOf(i + new Random(System.nanoTime()).nextInt())).intern();
        }
        System.out.println(System.nanoTime() - timeStart);
    }
}
