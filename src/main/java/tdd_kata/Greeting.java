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
        int nameCount = countDefinedNames(names), normalNameCount = countNormalNames(names),
                shoutedNameCount = countUppercaseNames(names);

        if (nameCount == 0) {
            return "Hello, my friends.";
        }

        // if there are no shouted names, then we can just deal with normal names
        if (shoutedNameCount == 0) {
            if (normalNameCount == 2) {
                return String.format("Hello, %s and %s.", names[0], names[1]);
            }
            return buildMultipleGreet(names, shoutedNameCount);
        }

        // if there is one shouted name, add the shouted name in the end
        if (shoutedNameCount == 1) {
            if (normalNameCount == 1) {
                return String.format("Hello, %s. AND HELLO, %s!", findNormalNames(names).get(0), findShoutedNames(names).get(0));
            }
            return buildMultipleGreet(names, shoutedNameCount);
        }

        return buildMultipleGreet(names, shoutedNameCount);
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


    // count both uppercase and non uppercase names
    private static int countDefinedNames(String[] names) {
        int namesCounter = names.length;
        for (String name : names) {
            if (name == null || name.isEmpty() || name.isBlank()) {
                namesCounter--;
            }
        }
        return namesCounter;
    }


    // count undefined names such as null, " " or empty strings
    private static int countUndefinedNames(String[] names) {
        int namesCounter = 0;
        for (String name : names) {
            if (name == null || name.isEmpty() || name.isBlank()) {
                namesCounter++;
            }
        }
        return namesCounter;
    }


    // counts non uppercase names
    private static int countNormalNames(String[] names) {
        int namesCounter = 0;
        for (String name : names) {
            if (!isStringUpperCase(name) && (!name.isBlank() || !name.isBlank())) {
                namesCounter++;
            }
        }
        return namesCounter;
    }


    // count uppercase names
    private static int countUppercaseNames(String[] names) {
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

    private static String buildMultipleGreet(String[] names, int shoutedNameCount) {
        StringBuilder multipleGreet = new StringBuilder("Hello, ");

        // here we deal with normal names
        ArrayList<String> normalNames = findNormalNames(names);
        // if the normal names are just two than do not add the comma before and
        if (countNormalNames(names) == 2) {
            if (countUndefinedNames(names) == 1) {
                multipleGreet.append(normalNames.get(0)).append(" and ").append("my friend").append(".");
            }
            multipleGreet.append(normalNames.get(0)).append(" and ").append(normalNames.get(1)).append(".");
        } else {
            for (int i = 0; i < countNormalNames(names); i++) {
                if (normalNames.size() - 1 != i) {
                    multipleGreet.append(normalNames.get(i)).append(", ");
                } else {
                    multipleGreet.append("and ").append(normalNames.get(i)).append(".");
                }
            }
        }

        // here we deal with shouted names
        ArrayList<String> shoutedNames = findShoutedNames(names);
        // shouted name is one
        if (shoutedNameCount == 1) {
            multipleGreet.append(" AND HELLO, ").append(shoutedNames.get(0)).append("!");
        } else if (shoutedNameCount > 1) {
            // if shouted names are two than do not put comma before and
            if (shoutedNameCount == 2) {
                multipleGreet.append(" AND HELLO, ").append(shoutedNames.get(0)).append(" AND ")
                        .append(shoutedNames.get(1)).append("!");
            } else {
                for (int i = 0; i < shoutedNameCount; i++) {
                    if (shoutedNameCount - 1 != i) {
                        multipleGreet.append(shoutedNames.get(i)).append(", ");
                    } else {
                        multipleGreet.append("AND ").append(shoutedNames.get(i)).append("!");
                    }
                }
            }
        }

        return multipleGreet.toString();
    }
}