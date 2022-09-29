package tdd_kata;

public class Greeting {
    public String greet(String name) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            return "Hello, my friend.";
        }
        return String.format("Hello, %s.", name);
    }

    public String greet(String ... names) {
        int emptinessCounter = 0;
        for (String name : names) {
            if (name == null || name.isEmpty() || name.isBlank()) {
                emptinessCounter++;
            }
        }
        if (emptinessCounter == names.length) {
            return "Hello, my friends.";
        }
        return "";
    }
}
