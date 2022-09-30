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
        ArrayList<String> shoutedNames = new ArrayList<>();
        for (String name : names) {
            if (isStringUpperCase(name)) {
                shoutedNames.add(name);
            }
        }
        return shoutedNames;
    }


    private static ArrayList<String> findNormalNames(String[] names) {
        ArrayList<String> normalNames = new ArrayList<>();
        for (String name : names) {
            if (!isStringUpperCase(name)) {
                normalNames.add(name);
            }
        }
        return normalNames;
    }

    private static String buildMultipleGreet(String[] names, int nameCount, int shoutedNameCount) {
        StringBuilder multipleGreet = new StringBuilder("Hello, ");
        ArrayList<String> normalNames = findNormalNames(names);
        // if the normal names are just two than do not add the comma before and
        if (countNormalNames(names) == 2) {
            multipleGreet.append(normalNames.get(0)).append(" and ").append(normalNames.get(1)).append(".");
        }
        else {
            for (int i = 0; i < countNormalNames(names); i++) {
                if (normalNames.size() - 1 != i) {
                    multipleGreet.append(normalNames.get(i)).append(", ");
                }
                else {
                    multipleGreet.append("and ").append(normalNames.get(i)).append(".");
                }
            }
        }

        ArrayList<String> shoutedNames = findShoutedNames(names);
        if (shoutedNameCount == 1) {
            multipleGreet.append(" AND HELLO, ").append(shoutedNames.get(0)).append("!");
            return multipleGreet.toString();
        }
        else if (shoutedNameCount > 1) {
            if (shoutedNameCount == 2) {
                multipleGreet.append(" AND HELLO, ").append(shoutedNames.get(0)).append(" AND ")
                        .append(shoutedNames.get(1)).append("!");
            }
            for (int i = 0; i < shoutedNameCount; i++) {
                if (shoutedNameCount - 1 != i) {
                    multipleGreet.append(shoutedNames.get(i)).append(", ");
                }
                else {
                    multipleGreet.append("AND ").append(shoutedNames.get(i)).append("!");
                }
            }
        }

        return multipleGreet.toString();
    }
}