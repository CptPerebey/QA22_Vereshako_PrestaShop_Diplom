package myUtils;


public class MyUtils {
    public static String getItemName(String item) {
    int bracketPos = item.indexOf("[") +1;
    int newLinePos = item.indexOf("\n", bracketPos);
    return item.substring(bracketPos, newLinePos);
    }
}
