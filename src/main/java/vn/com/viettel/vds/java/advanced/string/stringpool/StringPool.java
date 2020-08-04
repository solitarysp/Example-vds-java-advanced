package vn.com.viettel.vds.java.advanced.string.stringpool;

public class StringPool {
    public static void main(String[] args) {
        question1();
        question2();
        question3();
    }

    /**
     * câu hỏi 1 : các sout sẽ trả về false hay true ?
     * <p>
     * Câu trả lời
     * Khi sử dụng hashCode java sẽ sử dụng các giá trị của object để tạo mã hash, vì vậy 2  mã hash của question1 và question2 là bằng nhau.
     * Tuy nhiên 2 object này sẽ là object khác nhau, question1 = string pool, question2 sẽ là một object mới được tạo trong bộ nhớ heap
     * Lưu ý: Vì String là bất biến nên hashCode sẽ chỉ được tạo một lần khi String được khởi tạo
     */
    private static void question1() {
        String question1 = "Question 1";

        String question2 = new String("Question 1");
        System.out.println("question1.hashCode == question2.hashCode is :  " + (question1.hashCode() == question2.hashCode()));
        System.out.println("question1 equals question2 is : " + question1.equals(question2));

        System.out.println("question2 == question1 is :  " + question1 == question2);
    }

    /**
     * câu hỏi 2 : identityHashCode của question1 và question1Clone sẽ bằng nhau hay khác nhau
     * Câu trả lời:
     * bởi vì 2 sting đều là constant nên cùng trỏ đến một reference address nên sẽ true tất
     * cả 2 string này đều sẽ được thêm vào String pool
     */
    private static void question2() {
        String question1 = "Question 1";
        String question1Clone = "Question 1";
        System.out.println("identityHashCode question1 " + System.identityHashCode(question1)
                + " and " + "identityHashCode question1Clone " + System.identityHashCode(question1Clone));
        System.out.println(question1 == question1Clone);
    }

    /**
     * câu hỏi 3 : các giá trị identityHashCode, hashCode bằng nhau hay không. So sánh 2 string true hay false
     * Câu trả lời :
     * question1 và questionBase sẽ được thêm vào String pool.
     * Tuy nhiên question1Clone không phải là một constant vì vậy theo mặc định sẽ không được thêm vào String pool mà sẽ được tạo object mới
     * 3 cách để tạo string là Constant
     *   1: Sử dụng dấu ngoặc kép để tạo string (question1Clone = Question 1)
     *   2: Nối chuỗi String là dấu ngoặc kép (question1Clone = "Question "+"1")
     *   3: Các String được khai báo là final sẽ có thể nối chuỗi string thông qua biến
     */

    /**
     * String question1 = "Question 1";
     * String question1Clone = questionBase+"1";
     * Kiểu nối này không được thêm vào String pool với vì questionBase không phải là một Constant.
     * Chúng ta có thể gắn  questionBase thành một giá trị khác, khi sử dụng final thì chúng ta không thể thay đổi nên sẽ là Constant
     */
    private static void question3() {
        String questionBase = "Question ";

        String question1 = "Question 1";
        String question1Clone = questionBase + "1";
        System.out.println("question1 " + System.identityHashCode(question1));
        System.out.println("question1 hash " + question1.hashCode());
        System.out.println("question1Clone " + System.identityHashCode(question1Clone));
        System.out.println("question1Clone hash " + question1Clone.hashCode());

        System.out.println(question1 == question1Clone);
    }
}
