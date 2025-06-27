public class Validator {
    public static boolean isNotEmpty(String input) {
        return !input.isEmpty();
    }

    public static boolean isValidLogin(String login){
        return login != null && !login.trim().isEmpty();
    }

    public static boolean isValidPassword(String password) {
        return password.length() >= 8;
    }

    public static boolean isPositiveAmount(double amount) {
        return !(amount < 0);
    }

    public static boolean isValidMenuChoice(int choice, int min, int max) {
        return choice >= min && choice <= max;
    }
}
