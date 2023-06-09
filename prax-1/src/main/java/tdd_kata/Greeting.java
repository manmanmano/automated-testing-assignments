package tdd_kata;

import java.util.ArrayList;
import java.util.Arrays;

public class Greeting {

    public String greet(String name) {
        if (name == null || name.isBlank()) {
            return "Hello, my friend.";
        }
        if (isNameUppercase(name)) {
            return String.format("HELLO, %s!", name);
        }
        return String.format("Hello, %s.", name);
    }


    public String greet(String... names) {
        // split names only if they have unescaped double quotes
        if (!areNamesEscaped(names)) {
            // split all the names if necessary
            if (!areNamesSplit(names)) {
                names = splitNames(names);
            }
        } else {
            names = deleteDoubleQuotes(names);
        }

        // definedNameCount = every name besides blanks and nulls, unshoutedNameCount = every unshouted name,
        // shoutedNameCount = every shouted name, undefinedNameCount = every null and blank
        int definedNameCount = findDefinedNames(names).size(), unshoutedNameCount = findUnshoutedNames(names).size(),
                shoutedNameCount = findShoutedNames(names).size(), undefinedNameCount = findUndefinedNames(names).size();

        if (definedNameCount == 0) {
            return "Hello, my friends.";
        }

        // only one shouted name and one unshouted name
        if (shoutedNameCount == 1 && unshoutedNameCount == 1) {
            return String.format("Hello, %s. AND HELLO, %s!", findUnshoutedNames(names).get(0), findShoutedNames(names).get(0));
        }

        return buildMultipleGreet(names, shoutedNameCount, unshoutedNameCount, undefinedNameCount);
    }


    // BELOW METHODS USED IN GREET METHODS


    private static boolean areNamesEscaped(String[] names) {
        for (String name : names) {
            if (name != null && name.contains("\"")) {
                return true;
            }
        }
        return false;
    }


    private static String[] deleteDoubleQuotes(String[] names) {
        ArrayList<String> fixedNames = new ArrayList<>();
        for (String name : names) {
            if (name != null && name.contains("\"")) {
                fixedNames.add(name.substring(1, name.length() - 1));
                continue;
            }
            fixedNames.add(name);
        }
        return fixedNames.toArray(new String[0]);
    }


    private static boolean areNamesSplit(String[] names) {
        for (String name : names) {
            if (name != null && name.contains(", ")) {
                return false;
            }
        }
        return true;
    }


    private static String[] splitNames(String[] names) {
        ArrayList<String> fixedNames = new ArrayList<>();
        for (String name : names) {
            if (name.contains(", ")) {
                String[] sepNames = name.split(", ");
                fixedNames.addAll(Arrays.asList(sepNames));
                continue;
            }
            fixedNames.add(name);
        }
        return fixedNames.toArray(new String[0]);
    }


    private static boolean isNameUppercase(String name) {
        if (name == null) {
            return false;
        }
        char[] nameChrArr = name.toCharArray();
        for (char c : nameChrArr) {
            if (name.contains(", ") && (c == ',' || c == ' ')) {
                continue;
            }
            if (!Character.isUpperCase(c)) {
                return false;
            }
        }
        return true;
    }


    // find all names besides blank and null
    private static ArrayList<String> findDefinedNames(String[] names) {
        ArrayList<String> definedNames = new ArrayList<>();
        for (String name : names) {
            if (name != null && !name.isBlank()) {
                definedNames.add(name);
            }
        }
        return definedNames;
    }


    // find only shouted names
    private static ArrayList<String> findShoutedNames(String[] names) {
        ArrayList<String> shoutedNames = new ArrayList<>();
        for (String name : names) {
            if (isNameUppercase(name)) {
                shoutedNames.add(name);
            }
        }
        return shoutedNames;
    }


    // find only unshouted names
    private static ArrayList<String> findUnshoutedNames(String[] names) {
        ArrayList<String> unshoutedNames = new ArrayList<>();
        for (String name : names) {
            if (!isNameUppercase(name)) {
                unshoutedNames.add(name);
            }
        }
        return unshoutedNames;
    }


    // create list with null, whitespaces, or empty strings aka undefined names
    private static ArrayList<String> findUndefinedNames(String[] names) {
        ArrayList<String> undefinedNames = new ArrayList<>();
        for (String name : names) {
            if (!isNameUppercase(name) && (name == null || name.isBlank())) {
                undefinedNames.add(name);
            }
        }
        return undefinedNames;
    }


    private static String buildMultipleGreet(String[] names, int shoutedNameCount, int unshoutedNameCount, int undefinedNameCount) {
        StringBuilder multipleGreet = new StringBuilder("Hello, ");

        // here we deal with unshouted names
        ArrayList<String> unshoutedNames = findUnshoutedNames(names);
        // if the unshouted names are just two than do not add the comma before and
        if (unshoutedNameCount == 2) {
            // if there is only one defined name add and my friend to the end
            if (findDefinedNames(names).size() == 1) {
                multipleGreet.append(unshoutedNames.get(0)).append(" and ").append("my friend").append(".");
            }
            multipleGreet.append(unshoutedNames.get(0)).append(" and ").append(unshoutedNames.get(1)).append(".");
        } else {
            for (int i = 0; i < unshoutedNameCount; i++) {
                if (unshoutedNameCount - 1 != i && findUnshoutedNames(names).get(i) != null) {
                    multipleGreet.append(unshoutedNames.get(i)).append(", ");
                } else if (undefinedNameCount == 1) {
                    multipleGreet.append("and ").append("my friend").append(".");
                } else if (undefinedNameCount > 1) {
                    // break in order to not repeat for every undefined name
                    multipleGreet.append("and ").append("my friends").append(".");
                    break;
                } else {
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
                multipleGreet.append(" AND HELLO, ");
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