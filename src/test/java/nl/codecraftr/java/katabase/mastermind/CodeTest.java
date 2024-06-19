package nl.codecraftr.java.katabase.mastermind;

import static nl.codecraftr.java.katabase.mastermind.Color.BLUE;
import static nl.codecraftr.java.katabase.mastermind.Color.GREEN;
import static nl.codecraftr.java.katabase.mastermind.Color.PURPLE;
import static nl.codecraftr.java.katabase.mastermind.Color.RED;
import static nl.codecraftr.java.katabase.mastermind.Color.YELLOW;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CodeTest {
  @Nested
  class Evaluate {
    public static final Code ALL_RED = new Code(RED, RED, RED, RED);

    @Test
    void should_return_zero_well_placed_zero_misplaced_given_different_colors() {
      var result = ALL_RED.evaluate(BLUE, BLUE, BLUE, BLUE);

      assertThat(result.correct()).isZero();
      assertThat(result.misplaced()).isZero();
    }

    @Test
    void should_return_four_well_placed_given_identical_guess() {
      var result = ALL_RED.evaluate(RED, RED, RED, RED);

      assertThat(result.correct()).isEqualTo(4);
    }

    @ParameterizedTest
    @MethodSource("partiallyCorrectCases")
    void should_return_amount_correct_pegs_given_partially_correct_guess(Code guess, int expected) {
      var result = ALL_RED.evaluate(guess);

      assertThat(result.correct()).isEqualTo(expected);
    }

    private static Stream<Arguments> partiallyCorrectCases() {
      return Stream.of(Arguments.of(new Code(RED, GREEN, GREEN, GREEN), 1),
        Arguments.of(new Code(GREEN, RED, GREEN, GREEN), 1),
        Arguments.of(new Code(GREEN, GREEN, RED, GREEN), 1),
        Arguments.of(new Code(GREEN, GREEN, GREEN, RED), 1),
        Arguments.of(new Code(RED, GREEN, GREEN, RED), 2),
        Arguments.of(new Code(GREEN, RED, RED, GREEN), 2));
    }

    @ParameterizedTest
    @MethodSource("misplacedCases")
    void should_return_amount_misplaced_pegs_given_partially_correct_guess(Code guess,
      int expected) {
      var secret = new Code(RED, GREEN, BLUE, YELLOW);

      var result = secret.evaluate(guess);

      assertThat(result.misplaced()).isEqualTo(expected);
    }

    private static Stream<Arguments> misplacedCases() {
      return Stream.of(
        Arguments.of(new Code(PURPLE, RED, PURPLE, PURPLE), 1),
        Arguments.of(new Code(PURPLE, PURPLE, RED, PURPLE), 1),
        Arguments.of(new Code(PURPLE, PURPLE, PURPLE, RED), 1),
        Arguments.of(new Code(YELLOW, BLUE, GREEN, RED), 4)
      );
    }

    @Disabled("TODO")
    @Test
    void should_not_count_correct_pegs_as_misplaced_ones() {
    }

    @Disabled("TODO")
    @Test
    void should_count_misplaced_pegs_once() {
    }
  }
}
