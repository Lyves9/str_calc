import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        String op = operand(input);
        String[] res_str = input.split(" " + op + " ");
        chek_error(res_str[0],res_str[1],op );
//        System.out.println(Arrays.toString(res_str));
        for (int i = 0; i < res_str.length; i++) {
            res_str[i] = res_str[i].trim();
        }
        for (int i = 0; i < res_str.length; i++) {
            res_str[i] = res_str[i].replace("\"", "");
        }
//        System.out.println("num1: " +res_str[0]);
//        System.out.println("num2: " +res_str[1]);
        String res_math = math(res_str[0],res_str[1], op);
        if (res_math.length() < 40) {
            System.out.println("\"" + res_math + "\"");
        } else {
            System.out.println("\"" + res_math.substring(0, 40) + "...\"");

        }

    }

    public static String multiple(String str,int num){
        String multiple_res ="";
        for (int i = 0; i < num; i++) {
            multiple_res += str;
        }
        return multiple_res;
    }
    public static String divide(String str,int num){
        int divided_res = str.length() / num;
        return str.substring(0, divided_res);
    }

    public static String operand(String in) {
        String op = "e";
        for (int i = 0; i < in.length(); i++) {
            if (in.charAt(i) == '+' && (i != 0 && in.charAt(i - 1) == ' ')) {
                op = "\\+";
            }
            else if (in.charAt(i) == '*' && (i != 0 && in.charAt(i - 1) == ' ')) {
                op = "\\*";
            }
            else if (in.charAt(i) == '/' && (i != 0 && in.charAt(i - 1) == ' ')) {
                op = "\\/";
            }
            else if (in.charAt(i) == '-' && (i != 0 && in.charAt(i - 1) == ' ')) {
                op = "-";
            }
        }
        if (op.equals("e")) throw new RuntimeException("Введены некорректные данные");
        return op;

    }

    public static String math(String str, String num2, String per) {

        return switch (per) {
            case "\\+" -> str + num2;
            case "-" -> str.replace(num2, "");
            case "\\*" -> multiple(str,Integer.parseInt(num2));
            case "\\/" -> divide(str,Integer.parseInt(num2));
            default -> throw new IllegalStateException("Unexpected value: " + per);
        };
    }
    public static String multiple(String str1,int str2,char oper){
        String res = null;
        for (int i = 1; i < str2; i++) {
            res += str1;

        }
        return res;
    }
    public static void chek_error(String str1,String str2,String op){
        if (!str1.contains("\"")) throw new RuntimeException("Введены некорректные данные");
        if (!str2.contains("\"")) {
            int digit = Integer.parseInt(str2);
            if (!(digit > 0 && digit <= 10)) throw new RuntimeException("Введены некорректные данные");
        } else {
            if (Objects.equals(op, "\\*") || Objects.equals(op, "\\/")) throw new RuntimeException("Введены некорректные данные");
        }
    }
}


