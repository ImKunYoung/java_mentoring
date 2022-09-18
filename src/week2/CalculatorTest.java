package week2;

import org.testng.annotations.Test;

import java.util.ArrayList;

@Test
public class CalculatorTest {


    @Test
    private void seperate() {
        System.out.println("sf");
        Calculator calculator = new Calculator();
        calculator.input = "12 * 32 - 14/22sv+42*23^ s21ss #*";

        ArrayList<String> inputs = calculator.seperate();
        System.out.println(inputs);
        System.out.println(inputs.indexOf("*"));
        System.out.println("sf: "+inputs.get(2));
        inputs.sort((o1, o2) -> o2.compareTo(o1));

        inputs.forEach(s -> System.out.print(s));

        System.out.println(inputs.size());

    }


    @Test
    private void calculate() throws Calculator.CustomException {
        Calculator calculator = new Calculator();
        calculator.input = "3  /3*6-2/4+3*4";
        ArrayList<String> inputs = calculator.seperate();
        calculator.calculate(inputs);
        inputs.forEach(s -> System.out.print(s));
    }

    @Test
    private void cal_Mul() throws Calculator.CustomException {
        Calculator calculator = new Calculator();
        calculator.input = "2*4";
        ArrayList<String> inputs = calculator.seperate();
        calculator.cal_Multiply(inputs);
        System.out.println(inputs);
    }

}
