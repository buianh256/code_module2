package src;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    private  static Pattern pattern;
    private Matcher matcher;
    private static final String STRING_REGEX = "^[\\p{L}]+(?:[\\s'-][\\p{L}]+)*$";
    private static final String IDCODE_REGEX = "^[A-Z]+[0-9]+$";
    private static final String AGE_REGEX = "^[0-9]+$";

    public static boolean checkString(String string){
        Pattern pattern = Pattern.compile(STRING_REGEX);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
    public static boolean checkIdCode(String string){
        Pattern pattern = Pattern.compile(IDCODE_REGEX);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
    public static boolean checkAge(String string){
        Pattern pattern = Pattern.compile(AGE_REGEX);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
}
