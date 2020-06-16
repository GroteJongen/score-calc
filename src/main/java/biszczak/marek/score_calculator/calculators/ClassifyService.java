package biszczak.marek.score_calculator.calculators;

public class ClassifyService {

  public Classification classify(String method, double score) {

    final int roundScore = (int) Math.round(score);

    switch (roundScore) {
      case 0:
        return new Classification(method, 6);
      case 1:
        return new Classification(method, 7);
      case 2:
        return new Classification(method, 8);
      case 3:
        return new Classification(method, 9);
      case 4:
        return new Classification(method, 10);
      case 5:
        return new Classification(method, 11);
      case 6:
        return new Classification(method, 12);
      case 7:
        return new Classification(method, 13);
      case 8:
        return new Classification(method, 14);
      case 9:
        return new Classification(method, 15);
      case 10:
        return new Classification(method, 16);
      case 11:
        return new Classification(method, 17);
      case 12:
        return new Classification(method, 18);
      case 13:
        return new Classification(method, 24);
      case 14:
        return new Classification(method, 25);
      default:
        return new Classification(method, 0);
    }
  }
}
