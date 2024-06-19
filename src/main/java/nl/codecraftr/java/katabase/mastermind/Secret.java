package nl.codecraftr.java.katabase.mastermind;

public record Secret(Peg peg1, Peg peg2, Peg peg3, Peg peg4) {
  public Result guess(Peg peg, Peg peg1, Peg peg2, Peg peg3) {
    return new Result(0, 0);
  }
}

