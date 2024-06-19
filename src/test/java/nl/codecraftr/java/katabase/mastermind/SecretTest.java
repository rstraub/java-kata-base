package nl.codecraftr.java.katabase.mastermind;

import static nl.codecraftr.java.katabase.mastermind.Peg.BLUE;
import static nl.codecraftr.java.katabase.mastermind.Peg.RED;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class SecretTest {
  @Nested
  class Guess {
    @Test
    void should_return_zero_well_placed_zero_misplaced_given_different_colors() {
      var secret = new Secret(RED, RED, RED, RED);

      var result = secret.guess(BLUE, BLUE, BLUE, BLUE);

      assertThat(result.wellPlaced()).isZero();
      assertThat(result.misPlaced()).isZero();
    }
  }
}
