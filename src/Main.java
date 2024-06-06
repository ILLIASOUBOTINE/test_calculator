
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("Введите ваше выражение: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        try {
            System.out.println(calc(input));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }

    public static String calc(String input) throws Exception {
        int result;
        int a,b;
        char singOperation;

        if (input.matches(Calculator.REGEX_ARAB)) {

            singOperation = Calculator.getSignOperation(input);
            String[] arrAandB = Calculator.getArrAandB(input, singOperation);

            a = Integer.parseInt(arrAandB[0]);
            b = Integer.parseInt(arrAandB[1]);
            result = Calculator.switchOperation(singOperation,a,b);

            return String.valueOf(result);

        }else if (input.matches(Calculator.ROMAN_REGEX)) {

            singOperation =  Calculator.getSignOperation(input);
            String[] arrAandB = Calculator.getArrAandB(input,singOperation);
//            System.out.println(Arrays.toString(arrAandB));

            a = Calculator.romanToArabic(arrAandB[0]);
            b = Calculator.romanToArabic(arrAandB[1]);

            result = Calculator.switchOperation(singOperation,a,b);
            return Calculator.arabicToRoman(result);

        }else {
            return "формат математической операции должен удовлетворять заданию - два операнда и один оператор" +
                    " (+, -, /, *), нельзя использовать одновременно разные системы счисления, " +
                    "операнды должны быть в диапозоне больше [1;10]";
        }
    }
}