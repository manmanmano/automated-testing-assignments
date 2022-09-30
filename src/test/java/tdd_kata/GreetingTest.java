package tdd_kata;

import org.junit.jupiter.api.Test;
import static com.google.common.truth.Truth.assertThat;

public class GreetingTest {

    @Test
    public void shouldReturnNameInGreeting() {
        // Arrange
        String name = "Sir Horse McSoftly";
        Greeting greeting = new Greeting();
        String expectedResult = String.format("Hello, %s.", name);

        // Act
        String actualResult = greeting.greet(name);

        // Assert
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturnStandInWhenEmptyStringIsGiven() {
        String name = "";
        Greeting greeting = new Greeting();

        String actualResult = greeting.greet(name);

        assertThat(actualResult).isNotEmpty();
    }

    @Test
    public void shouldReturnStandInWhenEmptyStringIsNull() {
        String name = null;
        Greeting greeting = new Greeting();

        String actualResult = greeting.greet(name);

        assertThat(actualResult).isNotNull();
    }

    @Test
    public void shouldReturnStandInWhenEmptyStringsAreMultiple() {
        Greeting greeting = new Greeting();
        String name1 = " ", name2 = "  ", name3 = "    ";

        String actualResult = greeting.greet(name1, name2, name3);
        String expectedResult = "Hello, my friends.";

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturnShoutedName() {
      String shoutedName = "FRANK";
      Greeting greeting = new Greeting();

      String actualResult = greeting.greet(shoutedName);
      String expectedResult = "HELLO, FRANK!";

      assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturnShoutedNameNotLowercase() {
        String shoutedName = "FRANK";
        Greeting greeting = new Greeting();

        String actualResult = greeting.greet(shoutedName);
        String unexpectedResult = "Hello, Frank.";

        assertThat(actualResult).isNotEqualTo(unexpectedResult);
    }

    @Test
    public void shouldReturnShoutedNameWhenUppercaseNameContainsUnicodeChars() {
        String shoutedName = "ÜLO";
        Greeting greeting = new Greeting();

        String actualResult = greeting.greet(shoutedName);
        String expectedResult = "HELLO, ÜLO!";

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}