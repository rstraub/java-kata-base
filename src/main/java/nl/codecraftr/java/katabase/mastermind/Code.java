package nl.codecraftr.java.katabase.mastermind;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public record Code(Peg peg1, Peg peg2, Peg peg3, Peg peg4) {
  private List<Peg> pegs() {
    return List.of(peg1, peg2, peg3, peg4);
  }

  public Result evaluate(Peg peg1, Peg peg2, Peg peg3, Peg peg4) {
    return evaluate(new Code(peg1, peg2, peg3, peg4));
  }

  public Result evaluate(Code guess) {
    var matchedPegs = new ArrayList<>();
    IntStream.range(0, guess.pegs().size()).forEach(idx -> {
      var currentPeg = guess.pegs().get(idx);
      if (currentPeg.equals(pegs().get(idx))) {
        matchedPegs.add(currentPeg);
      }
    });
    var correct = matchedPegs.size();

    var misplaced = guess.pegs().stream().filter(peg -> pegs().contains(peg)).toList().size();

    return new Result(correct, misplaced);
  }
}

