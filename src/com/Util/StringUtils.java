public class StringUtils {
    public static String upperFirstLetter(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1, str.length());
    }

    public static String lowerFirstLetter(String str) {
        return str.substring(0, 1).toLowerCase() + str.substring(1, str.length());
    }

    public static String strAfterLastDot(String str) {
        return str.substring(str.lastIndexOf(".") + 1, str.length());
    }
}
