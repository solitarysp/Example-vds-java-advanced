package vn.com.viettel.vds.java.advanced.string.stringbufferbuilder;

public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("VDS ");
        for (int i = 0; i < 20; i++) {
            stringBuilder.append(i + System.nanoTime());
        }
        System.out.println(stringBuilder.toString());
    }

}
