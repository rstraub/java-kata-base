package nl.codecraftr.java.katabase.mastermind;

public record Code(Peg peg1, Peg peg2, Peg peg3, Peg peg4) {
  public Result evaluate(Peg peg1, Peg peg2, Peg peg3, Peg peg4) {
    var guess = new Code(peg1, peg2, peg3, peg4);

    if (this.equals(guess)) {
      return new Result(4, 0);
    }
    return new Result(0, 0);
  }
}

