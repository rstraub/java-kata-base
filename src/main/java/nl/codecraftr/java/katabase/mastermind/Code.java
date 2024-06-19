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
    var correctPegs = correctPegs(guess);
    var misplacedPegs = misplacedPegs(guess);

    return new Result(correctPegs.size(), misplacedPegs.size());
  }

  private List<Peg> misplacedPegs(Code guess) {
    return guess.pegs().stream().filter(peg -> pegs().contains(peg)).toList();
  }

  private ArrayList<Peg> correctPegs(Code guess) {
    var matchedPegs = new ArrayList<Peg>();
    IntStream.range(0, guess.pegs().size()).forEach(idx -> {
      var currentPeg = guess.pegs().get(idx);
      if (currentPeg.equals(pegs().get(idx))) {
        matchedPegs.add(currentPeg);
      }
    });
    return matchedPegs;
  }
}

