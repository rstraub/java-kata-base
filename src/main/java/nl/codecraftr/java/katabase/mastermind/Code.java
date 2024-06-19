package nl.codecraftr.java.katabase.mastermind;

import java.util.List;

public record Code(Color peg1, Color peg2, Color peg3, Color peg4) {
  private record Peg(int position, Color color) {
  }

  private List<Peg> pegs() {
    return List.of(new Peg(0, peg1), new Peg(1, peg2), new Peg(2, peg3), new Peg(3, peg4));
  }

  public Result evaluate(Color peg1, Color peg2, Color peg3, Color peg4) {
    return evaluate(new Code(peg1, peg2, peg3, peg4));
  }

  public Result evaluate(Code guess) {
    var correctPegs = correctPegs(guess);
    var misplacedPegs = misplacedPegs(guess);

    return new Result(correctPegs.size(), misplacedPegs.size());
  }

  private List<Color> misplacedPegs(Code guess) {
    var secretColors = pegs().stream().map(Peg::color).toList();
    return guess.pegs().stream().map(Peg::color).filter(secretColors::contains).toList();
  }

  private List<Peg> correctPegs(Code guess) {
    return guess.pegs().stream().filter(peg -> pegs().contains(peg)).toList();
  }
}

