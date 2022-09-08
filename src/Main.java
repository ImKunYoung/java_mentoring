public class Main {

    /*Constructor - 클래스 초기화*/
    public Main() {
        System.out.println("Constructor");
    }

    public void calculate() {
        System.out.println("calculate");
    }

    public static void main(String[] args) {
        System.out.println("hello world");

        int temp = 1;
        System.out.println("temp: "+temp);

        String a = "문자입니다";
        System.out.println(a);

        Main main = new Main();
        main.calculate();


    }

}
