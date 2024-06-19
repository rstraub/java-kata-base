package nl.codecraftr.java.katabase.mastermind;

import static nl.codecraftr.java.katabase.mastermind.Peg.BLUE;
import static nl.codecraftr.java.katabase.mastermind.Peg.GREEN;
import static nl.codecraftr.java.katabase.mastermind.Peg.RED;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
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

      assertThat(result).isEqualTo(new Result(0, 0));
    }

    @Test
    void should_return_four_well_placed_given_identical_guess() {
      var result = ALL_RED.evaluate(RED, RED, RED, RED);

      assertThat(result).isEqualTo(new Result(4, 0));
    }

    @ParameterizedTest
    @MethodSource("partiallyCorrectCases")
    void should_return_amount_well_placed_given_partially_correct_guess(Code guess,
      Result expected) {
      var result = ALL_RED.evaluate(guess);

      assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> partiallyCorrectCases() {
      return Stream.of(
        Arguments.of(new Code(RED, GREEN, GREEN, GREEN), new Result(1, 0)),
        Arguments.of(new Code(GREEN, RED, GREEN, GREEN), new Result(1, 0)),
        Arguments.of(new Code(GREEN, GREEN, RED, GREEN), new Result(1, 0)),
        Arguments.of(new Code(GREEN, GREEN, GREEN, RED), new Result(1, 0)),
        Arguments.of(new Code(RED, GREEN, GREEN, RED), new Result(2, 0)),
        Arguments.of(new Code(GREEN, RED, RED, GREEN), new Result(2, 0))
      );
    }
  }
}
