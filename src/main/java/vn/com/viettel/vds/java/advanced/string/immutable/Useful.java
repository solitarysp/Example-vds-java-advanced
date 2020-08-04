package vn.com.viettel.vds.java.advanced.string.immutable;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Useful {
    private static String nameCompanyBase = "Viettel ";

    public static void main(String[] args) {
        // security();
        threadSafe();
    }

    private static void threadSafe() {
        try {
            ExecutorService executorService = Executors.newFixedThreadPool(10);
            IntStream.range(0, 5).forEach((i) -> executorService.submit(() -> {
                appendSubCompany(nameCompanyBase, String.valueOf(i));
            }));
            executorService.awaitTermination(3, TimeUnit.SECONDS);

            System.out.println("nameCompanyBase  "+nameCompanyBase);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static synchronized void appendSubCompany(String str, String s) {
        str = str + s;
        System.out.println(str);
    }

    private static void security() {
        String age = "12";
        if (!isNumber(age)) {
            throw new SecurityException();
        }
        changeAge(age);
        System.out.println(age + " is number");
    }

    private static boolean isNumber(String numberStr) {
        String regex = "\\d+";
        return numberStr.matches(regex);
    }

    private static void changeAge(String age) {
        try {
            Field field = String.class.getDeclaredField("value");
            field.setAccessible(true);
            char[] value = (char[]) field.get(age);
            for (int i = 0; i < value.length; i++) {
                value[i] = 't';
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
