package week2;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculate {

    // input 문자열 띄어내기
    // String 으로 입력받은 문자열을 정수형 (int) 타입으로 변환하기
    // 숫자, 문자열인지 파악
    // *, -, /, + 수식을 인식하여 계산하기
    // 계산된 결괏값을 출력하기

    public Calculate() {
        String input = this.write();
        System.out.println(input);

        ArrayList<String> inputs = this.toChar(input);
        System.out.println(inputs);

        this.seize(inputs);

    }

    /*숫자인지 문자열인지 파악한다*/
    private void seize(ArrayList<String> inputs) {
        System.out.println("/*숫자인지 문자열인지 파악한다*/");

        for(int i=0; i < inputs.size(); i++) {

            System.out.println(inputs.get(i));


        }

    }


    private String write() {
        System.out.println("값을 입력하세요!: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    private ArrayList<String> toChar(String input) {
        ArrayList<String> inputs = new ArrayList<>();

        for(int i=0; i < input.length(); i++) {

            System.out.println(input.charAt(i));

            // char -> String 형 변환
            inputs.add(String.valueOf(input.charAt(i)));

        }

        return inputs;

    }


    public static void main(String[] args) {
        new Calculate();
    }
}
