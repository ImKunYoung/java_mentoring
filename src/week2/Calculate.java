package week2;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculate {

    // 1. 문자열을 입력받는다
    // 2. input 문자열 띄어내기
    // 3. String 으로 입력받은 문자열을 정수형 (int) 타입으로 변환하기
    // 4. 숫자, 문자열인지 파악
    // 5. *, -, /, + 수식을 인식하여 계산하기
    // 6. 계산된 결괏값을 출력하기

    public Calculate() {
        String input = this.write();
        System.out.println(input);

        ArrayList<Character> inputs = this.toChar(input);
        System.out.println(inputs);

        this.seize(inputs);

    }

    /*4. 숫자, 문자열인지 파악*/
    private void seize(ArrayList<Character> inputs) {
        System.out.println("/*숫자인지 문자열인지 파악한다*/");

        for(int i=0; i < inputs.size(); i++) {

            char input = inputs.get(i);


            int ascii = (int) input;
            System.out.println(ascii);



        }

    }

    /*1. 문자열을 입력받는다*/
    private String write() {
        System.out.println("값을 입력하세요!: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    /**/
    private ArrayList<Character> toChar(String input) {
        ArrayList<Character> inputs = new ArrayList<>();

        for(int i=0; i < input.length(); i++) {

            System.out.println(input.charAt(i));

            // char -> String 형 변환
            inputs.add(input.charAt(i));

        }

        return inputs;

    }


    public static void main(String[] args) {
        new Calculate();
    }
}
