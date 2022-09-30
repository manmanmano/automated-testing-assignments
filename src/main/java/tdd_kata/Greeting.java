package tdd_kata;

public class Greeting {

    public String greet(String name) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            return "Hello, my friend.";
        }
        if (isStringUpperCase(name)) {
            return String.format("HELLO, %s!", name);
        }
        return String.format("Hello, %s.", name);
    }


    public String greet(String... names) {
        if (countEmptiness(names) == names.length) {
            return "Hello, my friends.";
        }
        return "";
    }


    // BELOW METHODS USED IN GREET METHODS


    private static boolean isStringUpperCase(String name) {
        char[] nameChrArr = name.toCharArray();
        for (char c : nameChrArr) {
            if (!Character.isUpperCase(c)) {
                return false;
            }
        }
        return true;
    }


    private static int countNames(String[] names) {
        int namesCounter = 0;
        for (String name : names) {
            if (name == null || name.isEmpty() || name.isBlank()) {
                namesCounter++;
            }
        }
        return namesCounter;
    }
}