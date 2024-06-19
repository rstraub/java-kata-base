package nl.codecraftr.java.kata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class KataTest {

    @Test
    void shouldUnitTest() {
        Kata.main(new String[0]);

        assertThat(true).isTrue();
    }
}
