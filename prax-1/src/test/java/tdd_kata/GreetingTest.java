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
        String expectedResult = String.format("HELLO, %s!", shoutedName);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturnShoutedNameWhenUppercaseNameContainsUnicodeChars() {
        String shoutedName = "ÜLO";
        Greeting greeting = new Greeting();

        String actualResult = greeting.greet(shoutedName);
        String expectedResult = String.format("HELLO, %s!", shoutedName);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturnTwoNamesInGreetingAndNotEmptyString() {
        String[] names = {"Mario", "Luigi"};
        Greeting greeting = new Greeting();

        String actualResult = greeting.greet(names);

        assertThat(actualResult).isNotEmpty();
    }

    @Test
    public void shouldReturnMultipleNamesInGreetingWithFourNames() {
        String[] names = {"Mario", "Luigi", "Wario", "Waluigi"};
        Greeting greeting = new Greeting();

        String actualResult = greeting.greet(names);
        String expectedResult = String.format("Hello, %s, %s, %s, and %s.", names[0], names[1], names[2], names[3]);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturnMultipleNamesInGreetingWithThreeNames() {
        String[] names = {"Daisy", "Peach", "Todd"};
        Greeting greeting = new Greeting();

        String actualResult = greeting.greet(names);
        String expectedResult = String.format("Hello, %s, %s, and %s.", names[0], names[1], names[2]);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturnMultipleNamesInGreetingAndStandInWithBlank() {
        String[] names = {"Daisy", "Peach", "Todd", " "};
        Greeting greeting = new Greeting();

        String actualResult = greeting.greet(names);
        String expectedResult = String.format("Hello, %s, %s, %s, and my friend.", names[0], names[1], names[2]);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturnMultipleNamesInGreetingAndStandInWithNull() {
        String[] names = {"Daisy", "Peach", "Todd", null};
        Greeting greeting = new Greeting();

        String actualResult = greeting.greet(names);
        String expectedResult = String.format("Hello, %s, %s, %s, and my friend.", names[0], names[1], names[2]);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturnMultipleNamesInGreetingAndPluralStandIn() {
        String[] names = {"Mario", "Luigi", "Wario", "Waluigi", null, " "};
        Greeting greeting = new Greeting();

        String actualResult = greeting.greet(names);
        String expectedResult = String.format("Hello, %s, %s, %s, %s, and my friends.", names[0], names[1], names[2], names[3]);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturnMultipleNamesInGreetingAndNotEmptyString() {
        String[] names = {"Mario", "Luigi", "Wario", "Waluigi"};
        Greeting greeting = new Greeting();

        String actualResult = greeting.greet(names);

        assertThat(actualResult).isNotEmpty();
    }

    @Test
    public void shouldReturnMixOfNormalAndShoutedNamesInGreetingWithThreeNames() {
        String[] names = {"Mario", "BOWSER", "Luigi"};
        Greeting greeting = new Greeting();

        String actualResult = greeting.greet(names);
        String expectedResult = String.format("Hello, %s and %s. AND HELLO, %s!", names[0], names[2], names[1]);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturnMixOfNormalAndTwoShoutedNamesInGreetingWithFiveNames() {
        String[] names = {"Mario", "Yoshi", "Luigi", "BOWSER", "BOO"};
        Greeting greeting = new Greeting();

        String actualResult = greeting.greet(names);
        String expectedResult = String.format("Hello, %s, %s, and %s. AND HELLO, %s AND %s!",
                names[0], names[1], names[2], names[3], names[4]);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturnMixOfNormalAndShoutedNamesAndNotEmptyString() {
        String[] names = {"Mario", "BOWSER", "Luigi"};
        Greeting greeting = new Greeting();

        String actualResult = greeting.greet(names);

        assertThat(actualResult).isNotEmpty();
    }

    @Test
    public void shouldReturnMixOfNormalAndShoutedNamesInGreetingWithOneAndOne() {
        String[] names = {"Mario", "LUIGI"};
        Greeting greeting = new Greeting();

        String actualResult = greeting.greet(names);
        String expectedResult = String.format("Hello, %s. AND HELLO, %s!", names[0], names[1]);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturnMixOfNormalAndMultipleShoutedNamesInGreetingWithSixNames() {
        String[] names = {"Mario", "Yoshi", "Luigi", "BOWSER", "BOO", "KOOPA"};
        Greeting greeting = new Greeting();

        String actualResult = greeting.greet(names);
        String expectedResult = String.format("Hello, %s, %s, and %s. AND HELLO, %s, %s, AND %s!",
                names[0], names[1], names[2], names[3], names[4], names[5]);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturnSplitUnescapedCommaNamesInGreetingWithThreeNames() {
        String[] unsplitNames = {"Mario, Luigi", "Yoshi"};
        String[] names = {"Mario", "Luigi", "Yoshi"};
        Greeting greeting = new Greeting();

        String actualResult = greeting.greet(unsplitNames);
        String expectedResult = String.format("Hello, %s, %s, and %s.", names[0], names[1], names[2]);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturnSplitUnescapedCommaNamesInGreetingWithTwoNames() {
        String[] names = {"Mario", "Luigi"};
        String[] unsplitNames = {"Mario, Luigi"};
        Greeting greeting = new Greeting();

        String actualResult = greeting.greet(unsplitNames);
        String expectedResult = String.format("Hello, %s and %s.", names[0], names[1]);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturnSplitUnescapedCommaNamesInGreetingWithTwoShoutedNames() {
        String[] names = {"Mario", "Luigi", "PEACH", "DAISY"};
        String[] unsplitNames = {"Mario", "Luigi", "PEACH, DAISY"};
        Greeting greeting = new Greeting();

        String actualResult = greeting.greet(unsplitNames);
        String expectedResult = String.format("Hello, %s and %s. AND HELLO, %s AND %s!", names[0], names[1],
                names[2], names[3]);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturnSplitUnescapedCommaNamesInGreetingWithThreeShoutedNames() {
        String[] names = {"Mario", "Luigi", "PEACH", "DAISY", "TODD"};
        String[] unsplitNames = {"Mario", "Luigi", "PEACH, DAISY", "TODD"};
        Greeting greeting = new Greeting();

        String actualResult = greeting.greet(unsplitNames);
        String expectedResult = String.format("Hello, %s and %s. AND HELLO, %s, %s, AND %s!", names[0], names[1],
                names[2], names[3], names[4]);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturnEscapedDoubleQuotedNamesInGreetingWithThreeNames() {
        String[] names = {"Yoshi", "Mario", "Luigi"};
        String[] escapedNames = {"Yoshi", "\"Mario, Luigi\""};
        Greeting greeting = new Greeting();

        String actualResult = greeting.greet(escapedNames);

        String expectedResult = String.format("Hello, %s and %s, %s.", names[0], names[1], names[2]);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturnEscapedDoubleQuotedNamesInGreetingWithFourNames() {
        String[] names = {"Yoshi", "Todd", "Mario", "Luigi"};
        String[] escapedNames = {"Yoshi", "Todd", "\"Mario, Luigi\""};
        Greeting greeting = new Greeting();

        String actualResult = greeting.greet(escapedNames);

        String expectedResult = String.format("Hello, %s, %s, and %s, %s.", names[0], names[1], names[2], names[3]);

        assertThat(actualResult).isEqualTo(expectedResult);
    }


    @Test
    public void shouldReturnEscapedDoubleQuotedNamesInGreetingWithShoutedNames() {
        String[] names = {"Yoshi", "Todd", "MARIO", "LUIGI"};
        String[] escapedNames = {"Yoshi", "Todd", "\"MARIO, LUIGI\""};
        Greeting greeting = new Greeting();

        String actualResult = greeting.greet(escapedNames);

        String expectedResult = String.format("Hello, %s and %s. AND HELLO, %s, %s!", names[0], names[1], names[2], names[3]);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}