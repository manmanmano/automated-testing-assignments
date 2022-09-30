package tdd_kata;

import java.util.ArrayList;

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
        // nameCount contains all the types of names, both shouted and normal
        int nameCount = countAllNames(names), normalNameCount = countNormalNames(names),
                shoutedNameCount = countUppercaseNames(names);
        if (nameCount == 0) {
            return "Hello, my friends.";
        }
        // if there are no shouted names, then we can just deal with normal names
        if (shoutedNameCount == 0) {
            if (normalNameCount == 2) {
                return String.format("Hello, %s and %s.", names[0], names[1]);
            }
            return buildMultipleGreet(names, nameCount, shoutedNameCount);
        }
        // if there is one shouted name, add the shouted name in the end
        else if (shoutedNameCount == 1) {
            return buildMultipleGreet(names, nameCount, shoutedNameCount);
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


    private static ArrayList<String> findShoutedNames(String[] names) {
        ArrayList<String> shoutedNames = new ArrayList<String>();
        for (String name : names) {
            if (isStringUpperCase(name)) {
                shoutedNames.add(name);
            }
        }
        return shoutedNames;
    }

    private static String buildMultipleGreet(String[] names, int nameCount, int shoutedNameCount) {
        StringBuilder multipleGreet = new StringBuilder("Hello, ");
        for (int i = 0; i < nameCount; i++) {
            if (i != nameCount - 1) {
                multipleGreet.append(names[i]).append(", ");
            }
            else {
                multipleGreet.append("and ").append(names[i]).append(".");
            }
        }
        if (shoutedNameCount == 0) {
            return multipleGreet.toString();
        }
        else if (shoutedNameCount == 1) {
            multipleGreet.append(" AND HELLO, %s");
            return multipleGreet.toString();
        }
        return multipleGreet.toString();
    }
}