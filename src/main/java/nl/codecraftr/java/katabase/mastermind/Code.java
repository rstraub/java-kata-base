package nl.codecraftr.java.katabase.mastermind;

import java.util.ArrayList;
import java.util.List;

public record Code(Peg peg1, Peg peg2, Peg peg3, Peg peg4) {
  private List<Peg> pegs() {
    return List.of(peg1, peg2, peg3, peg4);
  }

  public Result evaluate(Peg peg1, Peg peg2, Peg peg3, Peg peg4) {
    return evaluate(new Code(peg1, peg2, peg3, peg4));
  }

  public Result evaluate(Code guess) {
    var matchedPegs = new ArrayList<>();

    if (guess.peg1().equals(peg1())) {
      matchedPegs.add(peg1());
    }
    if (guess.peg2().equals(peg2())) {
      matchedPegs.add(peg2());
    }
    if (guess.peg3().equals(peg3())) {
      matchedPegs.add(peg3());
    }
    if (guess.peg4().equals(peg4())) {
      matchedPegs.add(peg4());
    }
    var correct = matchedPegs.size();

    var misplaced = 0;

    return new Result(correct, misplaced);
  }
}

