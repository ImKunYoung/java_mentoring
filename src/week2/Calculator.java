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
    // 3. 계산한다
    ArrayList<String> calculate(ArrayList<String> inputs) {
        inputs = MulDiv(inputs);
        inputs = PluMin(inputs, true);
        return inputs;
    }

    ArrayList<String> MulDiv(ArrayList<String> inputs) {
        this.printStatus(inputs);

        for(int i=0;i<inputs.size();i++) {
            if(inputs.get(i).equals("*")) {
                cal_Multiply(inputs);
            } else if(inputs.get(i).equals("/")) {
                cal_Divid(inputs);
            }
        }

        return inputs;
    }

    private void printStatus(ArrayList<String> inputs) {
        inputs.forEach(System.out::print);
        System.out.println();
    }

    ArrayList<String> MulDiv(ArrayList<String> inputs, boolean hasMulDiv) {
        this.printStatus(inputs);

        if (!hasMulDiv) return inputs;
        if(inputs.contains("*")) {
            inputs = cal_Multiply(inputs);
            return MulDiv(inputs, true);
        } else if(inputs.contains("/")) {
            inputs = cal_Divid(inputs);
            return MulDiv(inputs, true);
        } else {
            return MulDiv(inputs,false);
        }
    }
    ArrayList<String> PluMin(ArrayList<String> inputs, boolean hasPluMin) {
        this.printStatus(inputs);

        if (!hasPluMin) return inputs;
        if(inputs.contains("+")) {
            inputs = cal_Plus(inputs);
            return PluMin(inputs, true);
        } else if(inputs.contains("-")) {
            inputs = cal_Minus(inputs);
            return PluMin(inputs, true);
        } else {
            return PluMin(inputs,false);
        }
    }

    ArrayList<String> cal_Plus(ArrayList<String> inputs) {
        int operIndex = inputs.indexOf("+");

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
        return inputs;
    }
    ArrayList<String> cal_Minus(ArrayList<String> inputs) {
        int operIndex = inputs.indexOf("-");
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
        return inputs;
    }
    ArrayList<String> cal_Multiply(ArrayList<String> inputs) {
        int operIndex = inputs.indexOf("*");
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
        return inputs;
    }
    private ArrayList<String> cal_Divid(ArrayList<String> inputs) {
        int operIndex = inputs.indexOf("/");
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
        return inputs;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.input();
        ArrayList<String> inputs = calculator.seperate();
        calculator.calculate(inputs);
    }

    public static class CustomException extends Exception {
        public CustomException(String message) {
            System.out.println(message);
            System.exit(-1);
        }
    }


}
