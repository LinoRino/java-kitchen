package models;

public class Notification {
    public static void notify(String message) {
        System.out.printf("🔔 %s\n", message);
    }
    public static void progress(String message) {
        System.out.printf("⏰ %s\n", message);
    }
    public static void success(String message) {
        System.out.printf("✅ %s\n", message);
    }
    public static void fail(String message) {
        System.out.printf("❌ %s\n", message);
    }
}
