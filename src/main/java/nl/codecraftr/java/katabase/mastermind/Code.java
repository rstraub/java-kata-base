package nl.codecraftr.java.katabase.mastermind;

public record Code(Peg peg1, Peg peg2, Peg peg3, Peg peg4) {
  public Result evaluate(Peg peg1, Peg peg2, Peg peg3, Peg peg4) {
    return evaluate(new Code(peg1, peg2, peg3, peg4));
  }

  public Result evaluate(Code guess) {
    var correct = 0;
    if (peg1().equals(guess.peg1())) {
      correct++;
    }
    if (peg2().equals(guess.peg2())) {
      correct++;
    }
    if (peg3().equals(guess.peg3())) {
      correct++;
    }
    if (peg4().equals(guess.peg4())) {
      correct++;
    }

    return new Result(correct, 0);
  }
}

