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

        inputs.forEach(System.out::print);

        System.out.println(inputs.size());

    }


    @Test
    private void calculate() {
        Calculator calculator = new Calculator();
        calculator.input = "3  /3*6-2/4+3*4";
        ArrayList<String> inputs = calculator.seperate();
        calculator.calculate(inputs);
        inputs.forEach(System.out::print);
    }

    @Test
    private void cal_Mul() {
        Calculator calculator = new Calculator();
        calculator.input = "2*4";
        ArrayList<String> inputs = calculator.seperate();
//        calculator.cal_Multiply(inputs, 2, 1, 3);
        System.out.println(inputs);
    }

}
