
import java.util.regex.Pattern;

public class Calculator {
    public static final char[] OPERATION_SIGNS = {'+', '-', '/', '*'};
    public static final String REGEX_ARAB = "^\\s*(10|[1-9])\\s*[\\+\\-\\*/]\\s*(10|[1-9])\\s*$";
    public static final String ROMAN_REGEX = "^\\s*(X|IX|IV|V?I{0,3})\\s*[\\+\\-\\*/]\\s*(X|IX|IV|V?I{0,3})\\s*$";

    public static int  addOperation(int a, int b){
        return a+b;
    }

    public static int  subtrOperation(int a, int b){
        return a-b;
    }

    public static int  devisOperation(int a, int b) throws Exception {
        if (b == 0){
            throw new Exception("Делить на ноль нельзя!");
        }
        return a/b;
    }

    public static int  multiplOperation(int a, int b){
        return a*b;
    }

   public static char getSignOperation(String input) {
       char signOperation = ' ';
       for(char sign :  OPERATION_SIGNS){
           if(input.contains(Character.toString(sign))){
              signOperation = sign;
              break;
           }
       }
       return signOperation;
   }

    public static int  switchOperation(char singOperation,int a, int b) throws Exception {
        int result;
        result = switch (singOperation) {
            case '*' -> multiplOperation(a, b);
            case '/' -> devisOperation(a, b);
            case '+' -> addOperation(a, b);
            case '-' -> subtrOperation(a, b);
            default -> 0;
        };

        return  result;
    }

   public static String[] getArrAandB(String input, char delim) {
       String delimiter = Pattern.quote(Character.toString(delim));
       //String delimiter = "\\" + Character.toString(delim);
       String[] arrAandB = input.split(delimiter);
       String a = arrAandB[0].trim();
       String b = arrAandB[1].trim();
       return new String[]{a,b};
   }

    public static String arabicToRoman(int number) throws Exception {
        String resultStr = "";
        if (number <= 0 ) {
            throw new Exception("Результат от вычисления Римских чисел должен быть больше 0. Римские числа не должны быть отрицательными");
        }
        int decNum = number/10;
        int unitNum = number - decNum*10;

        RomanNum[] romanNumerals = RomanNum.values();

        for (RomanNum romanNum:  romanNumerals) {
           if(romanNum.getValue() == decNum*10){
             resultStr = romanNum.name();
             break;
           }
        }

        for (RomanNum romanNum:  romanNumerals) {
            if(romanNum.getValue() == unitNum){
                resultStr =resultStr + romanNum.name();
                break;
            }
        }
        return resultStr;
    }

    public static int romanToArabic(String str)  {
        int resultNum = 0;

        RomanNum[] romanNumerals = RomanNum.values();

        for (RomanNum romanNum:  romanNumerals) {
            if(romanNum.name().equals(str)){
               resultNum = romanNum.getValue();
                break;
            }
        }
        return resultNum;
    }


}
