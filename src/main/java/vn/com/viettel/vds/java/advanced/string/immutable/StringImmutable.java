package vn.com.viettel.vds.java.advanced.string.immutable;

import java.lang.reflect.Field;

public class StringImmutable {
    public static void main(String[] args) {
       // question2();
        bypass();
    }

    private static void question2() {
        String question1 = "Question 1";
        System.out.println(System.identityHashCode(question1));
        question1 = question1 + "1";
        System.out.println(System.identityHashCode(question1));
    }

    // Sử dụng reflection để sửa data của string
    // Bởi vì hashcode sẽ được tạo khi string bắt đầu được tạo việc này để làm tăng hiệu suất của ứng dụng.
    // Vì khi chỉnh sửa string  data lại thay đổi và không phải tạo mới nên đoạn hash không thay đổi.
    private static void bypass() {
        try {
            String s1 = "Hello World";
            System.out.println("hashCode " + s1.hashCode());
            System.out.println("identityHashCode " + System.identityHashCode(s1));

            Field field = String.class.getDeclaredField("value");
            field.setAccessible(true);
            char[] value = (char[]) field.get(s1);
            value[6] = 'J';
            value[7] = 'a';
            value[8] = 'v';
            value[9] = 'a';
            value[10] = '!';
            System.out.println();

            System.out.println("Data mới : " + s1);
            System.out.println(" hashcode khi đã thay đổi data");

            System.out.println("hashCode " + s1.hashCode());
            System.out.println("identityHashCode " + System.identityHashCode(s1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
