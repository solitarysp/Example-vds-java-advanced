package vn.com.viettel.vds.java.advanced.string.stringpool;

public class StringPoolIntern {
    /**
     * bởi vì intern() sẽ truy cập trong pool và tạo mới một object sau đó lưu vào pool
     * nên 2 object này cùng một address bộ nhớ
     *
     * @param args
     */
    public static void main(String[] args) {
        String question1 = new String("Question 1").intern();
        String question1Clone = "Question 1";
        System.out.println(question1 == question1Clone);

        String question1Clone2 = new String("Question 1").intern();
        System.out.println(question1Clone2 == question1Clone);


    }
}
