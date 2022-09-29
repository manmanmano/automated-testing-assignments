package tdd_kata;

import org.junit.jupiter.api.Test;
import static com.google.common.truth.Truth.assertThat;

public class GreetingTest {

    @Test
    public void shouldReturnNameInGreeting() {
        // Arrange
        String name = "Sir Horse McSoftly";
        Greeting greeting = new Greeting();
        String expectedResult = String.format("Hello, %s!", name);

        // Act
        String actualResult = greeting.greet(name);

        // Assert
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturnStandIn_WhenEmptyStringIsGiven() {
        String name = "";
        Greeting greeting = new Greeting();

        String actualResult = greeting.greet(name);

        assertThat(actualResult).isNotEmpty();
    }

    @Test
    public void shouldReturnStandIn_WhenEmptyStringIsNull() {
        String name = null;
        Greeting greeting = new Greeting();

        String actualResult = greeting.greet(name);

        assertThat(actualResult).isNotNull();
    }

    @Test
    public void shouldReturnStandIn_WhenEmptyStringsAreMultiple() {
        Greeting greeting = new Greeting();
        String name1 = " ", name2 = "  ", name3 = "    ";

        String actualResult = greeting.greet(name1, name2, name3);
        String expectedResult = "Hello, my friends.";

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}