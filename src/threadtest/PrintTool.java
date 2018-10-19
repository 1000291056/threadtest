package threadtest;

public class PrintTool {
    public static void println(String log) {
        System.out.println(log);
    }

    public static void println(int intValue) {
        System.out.println(intValue);
    }

    public static void println(boolean boolValue) {
        System.out.println(boolValue);
    }
    public static void println(Object object) {
        System.out.println(object.toString());
    }
}
