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
        int nameCount = countAllNames(names);
        if (nameCount == 0) {
            return "Hello, my friends.";
        }
        else if (nameCount == 2) {
            return String.format("Hello, %s and %s.", names[0], names[1]);
        }
        else if (nameCount > 2) {
            return buildMultipleGreet(names, nameCount);
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


    private static int countAllNames(String[] names) {
        int namesCounter = names.length;
        for (String name : names) {
            if (name == null || name.isEmpty() || name.isBlank()) {
                namesCounter--;
            }
        }
        return namesCounter;
    }


    private static int countNormalNames(String[] names) {
        int namesCounter = 0;
        for (String name : names) {
            if (!isStringUpperCase(name)) {
                namesCounter++;
            }
        }
        return namesCounter;
    }


    private static int countUppercaseNames (String[] names) {
        int namesCounter = 0;
        for (String name : names) {
            if (isStringUpperCase(name)) {
                namesCounter++;
            }
        }
        return namesCounter;
    }


    private static String buildMultipleGreet(String[] names, int nameCount) {
        StringBuilder multipleGreet = new StringBuilder("Hello, ");
        for (int i = 0; i < nameCount; i++) {
            if (i != nameCount - 1) {
                multipleGreet.append(names[i]).append(", ");
            }
            else {
                multipleGreet.append("and ").append(names[i]).append(".");
            }
        }
        return multipleGreet.toString();
    }
}