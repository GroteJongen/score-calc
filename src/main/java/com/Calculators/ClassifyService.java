package com.Calculators;

import java.text.DecimalFormat;

public class ClassifyService {
  // TODO wyniesienie do finali
  //TODO switch case
  public Classification classify(String method, double score) {
    final DecimalFormat decimalFormat = new DecimalFormat("##.00");

    if (Math.round(score) == 0) {
      System.out.println(method + " " + decimalFormat.format(score) + " about 5-6 years old.");
      return new Classification(method," about 5-6 years old.", 6);
    }
    if (Math.round(score) <= 1) {
      System.out.println(method + " " + decimalFormat.format(score) + " about 6 years old.");
      return new Classification(method,"about 6 years old. ", 7);
    }
    if (Math.round(score) == 2) {
      System.out.println(method + " " + decimalFormat.format(score) + " about 7 years old.");
      return new Classification(method,"about 7 years old.", 8);
    }
    if (Math.round(score) == 3) {
      System.out.println(method + " " + decimalFormat.format(score) + " about 9 years old.");
      return new Classification(method," about 9 years old.", 9);
    }
    if (Math.round(score) == 4) {
      System.out.println(method + " " + decimalFormat.format(score) + " about 10 years old.");
      return new Classification(method," about 10 years old.", 10);
    }
    if (Math.round(score) == 5) {
      System.out.println(method + " " + decimalFormat.format(score) + " about 11 years old.");
      return new Classification(method," about 11 years old.", 11);
    }
    if (Math.round(score) == 6) {
      System.out.println(method + " " + decimalFormat.format(score) + " about 12 years old.");
      return new Classification(method," about 12 years old.", 12);
    }
    if (Math.round(score) == 7) {
      System.out.println(method + " " + decimalFormat.format(score) + " about 13 years old.");
      return new Classification(method," about 13 years old.", 13);
    }
    if (Math.round(score) == 8) {
      System.out.println(method + " " + decimalFormat.format(score) + " about 14 years old.");
      return new Classification(method," about 14 years old.", 14);
    }
    if (Math.round(score) == 9) {
      System.out.println(method + " " + decimalFormat.format(score) + " about 15 years old.");
      return new Classification(method," about 15 years old.", 15);
    }
    if (Math.round(score) == 10) {
      System.out.println(method + " " + decimalFormat.format(score) + " about 16 years old.");
      return new Classification(method," about 16 years old.", 16);
    }
    if (Math.round(score) == 11) {
      System.out.println(method + " " + decimalFormat.format(score) + " about 17 years old.");
      return new Classification(method," about 17 years old.", 17);
    }
    if (Math.round(score) == 12) {
      System.out.println(method + " " + decimalFormat.format(score) + " about 18 years old.");
      return new Classification(method," about 18 years old.", 18);
    }
    if (Math.round(score) == 13) {
      System.out.println(method + " " + decimalFormat.format(score) + " about 24 years old.");
      return new Classification(method," about 24 years old.", 24);
    }
    if (Math.round(score) >= 14) {
      System.out.println(method + " " + decimalFormat.format(score) + " about 24+ years old.");
      return new Classification(method," about 25 years old.", 25);
    }
    return new Classification(method," EEEEMPTYYYYYY", 0);
  }
}
