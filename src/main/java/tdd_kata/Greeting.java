package tdd_kata;

import java.util.ArrayList;

public class Greeting {

    public String greet(String name) {
        if (name == null || name.isBlank()) {
            return "Hello, my friend.";
        }
        if (isStringUpperCase(name)) {
            return String.format("HELLO, %s!", name);
        }
        return String.format("Hello, %s.", name);
    }


    public String greet(String... names) {
        // nameCount contains all the types of names, both shouted and unshouted, not blank, null, or "  "
        int nameCount = findDefinedNames(names).size(), unshoutedNameCount = findUnshoutedNames(names).size(),
                shoutedNameCount = findShoutedNames(names).size();

        if (nameCount == 0) {
            return "Hello, my friends.";
        }

        // if there are no shouted names, then we can just deal with unshouted names
        if (shoutedNameCount == 0) {
            if (unshoutedNameCount == 2) {
                return String.format("Hello, %s and %s.", names[0], names[1]);
            }
            return buildMultipleGreet(names, shoutedNameCount, unshoutedNameCount);
        }

        // if there is one shouted name, add the shouted name in the end
        if (shoutedNameCount == 1) {
            if (unshoutedNameCount == 1) {
                return String.format("Hello, %s. AND HELLO, %s!", findUnshoutedNames(names).get(0), findShoutedNames(names).get(0));
            }
            return buildMultipleGreet(names, shoutedNameCount, unshoutedNameCount);
        }

        return buildMultipleGreet(names, shoutedNameCount, unshoutedNameCount);
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


    private static ArrayList<String> findDefinedNames(String[] names) {
        ArrayList<String> definedNames = new ArrayList<>();
        for (String name : names) {
            if (name != null && !name.isBlank()) {
                definedNames.add(name);
            }
        }
        return definedNames;
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


    private static ArrayList<String> findUnshoutedNames(String[] names) {
        ArrayList<String> unshoutedNames = new ArrayList<>();
        for (String name : names) {
            if (!isStringUpperCase(name)) {
                unshoutedNames.add(name);
            }
        }
        return unshoutedNames;
    }


    // create list with null, whitespaces, or empty strings aka undefined names
    private static ArrayList<String> findUndefinedNames(String[] names) {
        ArrayList<String> undefinedNames = new ArrayList<>();
        for (String name : names) {
            if (!isStringUpperCase(name) && name.isBlank()) {
                undefinedNames.add(name);
            }
        }
        return undefinedNames;
    }


    private static String buildMultipleGreet(String[] names, int shoutedNameCount, int unshoutedNameCount) {
        StringBuilder multipleGreet = new StringBuilder("Hello, ");

        // here we deal with unshouted names
        ArrayList<String> unshoutedNames = findUnshoutedNames(names);
        // if the unshouted names are just two than do not add the comma before and
        if (findUnshoutedNames(names).size() == 2) {
            if (findUnshoutedNames(names).size() == 1) {
                multipleGreet.append(unshoutedNames.get(0)).append(" and ").append("my friend").append(".");
            }
            multipleGreet.append(unshoutedNames.get(0)).append(" and ").append(unshoutedNames.get(1)).append(".");
        } else {
            for (int i = 0; i < findUnshoutedNames(names).size(); i++) {
                if (unshoutedNames.size() - 1 != i) {
                    multipleGreet.append(unshoutedNames.get(i)).append(", ");
                } else if (findUndefinedNames(names).size() == 1) {
                    multipleGreet.append("and ").append("my friend").append(".");
                    break;
                }
                else {
                    multipleGreet.append("and ").append(unshoutedNames.get(i)).append(".");
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