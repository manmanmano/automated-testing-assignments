package tdd_kata;

public class Greeting {
    public String greet(String name) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            return "Hello, my friend.";
        }
        return String.format("Hello, %s!", name);
    }

}
