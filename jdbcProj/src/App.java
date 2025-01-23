import vo.day1.Customer;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Customer test = new Customer();
        test.setAge(23);
        test.setName("홍길동");
        test.setCustomId("hongGD");
        System.out.println(test);
        System.out.println("이름 : " + test.getName());
    }
}
