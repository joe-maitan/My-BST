import java.lang.Math;

public class Calculator {

    public int hexToInt(String hexadecimal_number) {
        int integer_value = 0;

        if (hexadecimal_number.startsWith("0x") || hexadecimal_number.startsWith("0X")) {
            hexadecimal_number = hexadecimal_number.substring(2);
        }

        String curr_char = "";
        int curr_num = 0;
        int power_of = 0;

        for (int i = hexadecimal_number.length() - 1; i >= 0; --i) {
            curr_char = "";
            curr_char += hexadecimal_number.charAt(i);
            curr_num = Integer.parseInt(curr_char);
            integer_value += curr_num * Math.pow(16, power_of);
            power_of++;
        }
        
        return integer_value;
    }
    
}
