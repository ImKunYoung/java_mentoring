## 키보드를 통해 숫자와 더하기, 곱하기, 나누기 표식을 입력받고 계산된 결과를 출력하기
> ex) 입력값: 2 * 4 → 출력값: 8

```java
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Calculator {

    /*field*/
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

    /*곱셈과 나눗셈*/
    private void MulDiv(ArrayList<String> inputs) {
        int i=0;
        while (i<inputs.size()){
            if(inputs.get(i).equals("*")) i = calculate(inputs, i, "*");
            if(inputs.get(i).equals("/")) i = calculate(inputs, i, "/");
            i++;
        }
    }
    /*덧셈과 뺄셈*/
    private void PluMin(ArrayList<String> inputs) {
        int i=0;
        while (i<inputs.size()){
            if(inputs.get(i).equals("+")) i = calculate(inputs, i, "+");
            if(inputs.get(i).equals("-")) i = calculate(inputs, i, "-");
            i++;
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.input();
        ArrayList<String> inputs = calculator.seperate();
        String result = calculator.calculate(inputs);
        System.out.println("result: "+result);
    }





    /*-------------utility-------------*/
    private int calculate(ArrayList<String> inputs, int operIndex, String operator) {
        this.printStatus(inputs);
        try {
            if(operIndex-1 > -1 && operIndex+1 < inputs.size()) {
                String prev = inputs.get(operIndex-1);
                String next = inputs.get(operIndex+1);

                switch (operator) {
                    case "+": cal_Plus(inputs, operIndex, prev, next);
                        break;
                    case "-": cal_Minus(inputs,operIndex, prev, next);
                        break;
                    case "*": cal_Multiply(inputs,operIndex, prev, next);
                        break;
                    case "/": cal_Divid(inputs,operIndex, prev, next);
                        break;
                }
                inputs.remove(operIndex+1);
                inputs.remove(operIndex-1);
            } else throw new CustomException("잘못입력하셨습니다");
        } catch (Exception e) {
            System.out.println("잘못입력하셨습니다");
            System.exit(-1);
        }
        return operIndex - 1;
    }
    private void cal_Plus(ArrayList<String> inputs, int operIndex, String prev, String next) {
        Double result = Double.parseDouble(prev) + Double.parseDouble(next);
        inputs.set(operIndex, String.valueOf(result));
    }
    private void cal_Minus(ArrayList<String> inputs, int operIndex, String prev, String next) {
        Double result = Double.parseDouble(prev) - Double.parseDouble(next);
        inputs.set(operIndex, String.valueOf(result));
    }
    private void cal_Multiply(ArrayList<String> inputs, int operIndex, String prev, String next) {
        Double result = Double.parseDouble(prev) * Double.parseDouble(next);
        inputs.set(operIndex, String.valueOf(result));
    }
    private void cal_Divid(ArrayList<String> inputs, int operIndex, String prev, String next) {
        double result = Double.parseDouble(prev) / Double.parseDouble(next);
        inputs.set(operIndex, String.valueOf(BigDecimal.valueOf(result)));
    }


    /*연산과정 출력*/
    static int i = 0;
    private void printStatus(ArrayList<String> inputs) {
        System.out.print(i+": ");
        inputs.forEach(System.out::print);
        System.out.println();
        i++;
    }
    /*예외처리*/
    public static class CustomException extends Exception {
        public CustomException(String message) {
            System.out.println(message);
            System.exit(-1);
        }
    }


}
```