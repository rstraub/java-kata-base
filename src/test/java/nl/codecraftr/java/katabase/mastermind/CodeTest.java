package nl.codecraftr.java.katabase.mastermind;

import static nl.codecraftr.java.katabase.mastermind.Peg.BLUE;
import static nl.codecraftr.java.katabase.mastermind.Peg.RED;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CodeTest {
  @Nested
  class Evaluate {
    private final Code secret = new Code(RED, RED, RED, RED);

    @Test
    void should_return_zero_well_placed_zero_misplaced_given_different_colors() {
      var result = secret.evaluate(BLUE, BLUE, BLUE, BLUE);

      assertThat(result).isEqualTo(new Result(0, 0));
    }

    @Test
    void should_return_four_well_placed_given_identical_code() {
      var result = secret.evaluate(RED, RED, RED, RED);

      assertThat(result).isEqualTo(new Result(4, 0));
    }
  }
}
