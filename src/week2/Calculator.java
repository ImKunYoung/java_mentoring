package week2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Calculator {

    String input;

    /*1. 문자열을 입력받는다*/
    private void input() {
        System.out.print("값을 입력하세요!: ");
        Scanner scanner = new Scanner(System.in);
        this.input = scanner.nextLine();
    }
    /*2. 문자열을 정리한다*/
    ArrayList<String> seperate() {
        ArrayList<String> inputs = new ArrayList<>();
        StringBuilder temp = new StringBuilder();

        for(int i=0; i < this.input.length(); i++) {
            if(this.input.charAt(i)=='*' || this.input.charAt(i)=='-'|| this.input.charAt(i)=='+'|| this.input.charAt(i)=='/') {
                inputs.add(temp.toString());
                temp = new StringBuilder();
                inputs.add(String.valueOf(this.input.charAt(i)));
            } else if(this.input.charAt(i) >= '0' && this.input.charAt(i) <= '9') {
                temp.append(this.input.charAt(i));
            }
        }
        inputs.add(temp.toString());
        inputs.removeAll(Collections.singleton(""));

        return inputs;
    }
    /*3. 계산한다*/
    String calculate(ArrayList<String> inputs) {
        this.MulDiv(inputs);
        this.PluMin(inputs);
        return inputs.get(0);
    }

    ArrayList<String> MulDiv(ArrayList<String> inputs) {
        int i=0;
        while (i<inputs.size()){
            if(inputs.get(i).equals("*")) i = cal_Multiply(inputs, i);
            if(inputs.get(i).equals("/")) i = cal_Divid(inputs, i);
            i++;
        }
        return inputs;
    }
    ArrayList<String> PluMin(ArrayList<String> inputs) {
        int i=0;
        while (i<inputs.size()){
            if(inputs.get(i).equals("+")) i = cal_Plus(inputs, i);
            if(inputs.get(i).equals("-")) i = cal_Minus(inputs, i);
            i++;
        }
        return inputs;
    }



    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.input();
        ArrayList<String> inputs = calculator.seperate();
        String result = calculator.calculate(inputs);
        System.out.println("result: "+result);
    }

    static int i = 0;
    private void printStatus(ArrayList<String> inputs) {
        System.out.print(i+": ");
        inputs.forEach(System.out::print);
        System.out.println();
        i++;
    }

    int cal_Plus(ArrayList<String> inputs, int operIndex) {
        this.printStatus(inputs);
        try {
            if(operIndex-1 > -1 && operIndex+1 < inputs.size()) {
                String prev = inputs.get(operIndex-1);
                String next = inputs.get(operIndex+1);

                Double result = Double.parseDouble(prev) + Double.parseDouble(next);

                inputs.set(operIndex, String.valueOf(result));

                inputs.remove(operIndex+1);
                inputs.remove(operIndex-1);
            } else throw new CustomException("잘못입력하셨습니다");
        } catch (Exception e) {
            System.out.println("잘못입력하셨습니다");
            System.exit(-1);
        }
        return operIndex-1;
    }
    int cal_Minus(ArrayList<String> inputs, int operIndex) {
        this.printStatus(inputs);
        try {
            if(operIndex-1 > -1 && operIndex+1 < inputs.size()) {
                String prev = inputs.get(operIndex-1);
                String next = inputs.get(operIndex+1);

                Double result = Double.parseDouble(prev) - Double.parseDouble(next);

                inputs.set(operIndex, String.valueOf(result));

                inputs.remove(operIndex+1);
                inputs.remove(operIndex-1);
            } else throw new CustomException("잘못입력하셨습니다");
        } catch (Exception e) {
            System.out.println("잘못입력하셨습니다");
            System.exit(-1);
        }
        return operIndex-1;
    }
    int cal_Multiply(ArrayList<String> inputs, int operIndex) {
        this.printStatus(inputs);
        try {
            if(operIndex-1 > -1 && operIndex+1 < inputs.size()) {
                String prev = inputs.get(operIndex-1);
                String next = inputs.get(operIndex+1);

                Double result = Double.parseDouble(prev) * Double.parseDouble(next);

                inputs.set(operIndex, String.valueOf(result));

                inputs.remove(operIndex+1);
                inputs.remove(operIndex-1);
            } else throw new CustomException("잘못입력하셨습니다");
        } catch (Exception e) {
            System.out.println("잘못입력하셨습니다");
            System.exit(-1);
        }
        return operIndex - 1;
    }
    int cal_Divid(ArrayList<String> inputs, int operIndex) {
        this.printStatus(inputs);
        try {
            if(operIndex-1 > -1 && operIndex+1 < inputs.size()) {
                String prev = inputs.get(operIndex-1);
                String next = inputs.get(operIndex+1);

                double result = Double.parseDouble(prev) / Double.parseDouble(next);

                inputs.set(operIndex, String.valueOf(BigDecimal.valueOf(result)));

                inputs.remove(operIndex+1);
                inputs.remove(operIndex-1);
            } else throw new CustomException("잘못입력하셨습니다");
        } catch (Exception e) {
            System.out.println("잘못입력하셨습니다");
            System.exit(-1);
        }
        return operIndex - 1;
    }

    public static class CustomException extends Exception {
        public CustomException(String message) {
            System.out.println(message);
            System.exit(-1);
        }
    }


}
