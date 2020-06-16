package com.Calculators;

import java.text.DecimalFormat;

public class ClassifyService {

  private final String lowestAgeMsg = " about 5-6 years old.";
  private final String about24yearsOldMsg = " about 24 years old.";
  private final String about18YearsOldMsg = " about 18 years old.";
  private final String about17YearsOldMsg = " about 17 years old.";
  private final String about16YearsOldMsg = " about 16 years old.";
  private final String about15YearsOldMsg = " about 15 years old.";
  private final String about14YearsOldMsg = " about 14 years old.";
  private final String about13YearsOldMsg = " about 13 years old.";
  private final String about12YearsOldMsg = " about 12 years old.";
  private final String about11YearsOldMsg = " about 11 years old.";
  private final String about10YearsOlMsg = " about 10 years old.";
  private final String about9YearsOldMsg = " about 9 years old.";
  private final String about7YearsOldMsg = " about 7 years old.";
  private final String about6YearsOldMsg = " about 6 years old.";
  private final String emptyMsg = " is empty ";
  final DecimalFormat decimalFormat = new DecimalFormat("##.00");

  // TODO switch case
  public Classification classify(String method, double score) {
    switch ((int) Math.round(score)) {
      case 0:
        System.out.println(method + " " + decimalFormat.format(score) + lowestAgeMsg);
        return new Classification(method, lowestAgeMsg, 6);
      case 1:
        System.out.println(method + " " + decimalFormat.format(score) + about6YearsOldMsg);
        return new Classification(method, about6YearsOldMsg, 7);
      case 2:
        System.out.println(method + " " + decimalFormat.format(score) + about7YearsOldMsg);
        return new Classification(method, about7YearsOldMsg, 8);
      case 3:
        System.out.println(method + " " + decimalFormat.format(score) + about9YearsOldMsg);
        return new Classification(method, about9YearsOldMsg, 9);
      case 4:
        System.out.println(method + " " + decimalFormat.format(score) + about10YearsOlMsg);
        return new Classification(method, about10YearsOlMsg, 10);
      case 5:
        System.out.println(method + " " + decimalFormat.format(score) + about11YearsOldMsg);
        return new Classification(method, about11YearsOldMsg, 11);
      case 6:
        System.out.println(method + " " + decimalFormat.format(score) + about12YearsOldMsg);
        return new Classification(method, about12YearsOldMsg, 12);
      case 7:
        System.out.println(method + " " + decimalFormat.format(score) + about13YearsOldMsg);
        return new Classification(method, about13YearsOldMsg, 13);
      case 8:
        System.out.println(method + " " + decimalFormat.format(score) + about14YearsOldMsg);
        return new Classification(method, about14YearsOldMsg, 14);
      case 9:
        System.out.println(method + " " + decimalFormat.format(score) + about15YearsOldMsg);
        return new Classification(method, about15YearsOldMsg, 15);
      case 10:
        System.out.println(method + " " + decimalFormat.format(score) + about16YearsOldMsg);
        return new Classification(method, about16YearsOldMsg, 16);
      case 11:
        System.out.println(method + " " + decimalFormat.format(score) + about17YearsOldMsg);
        return new Classification(method, about17YearsOldMsg, 17);
      case 12:
        System.out.println(method + " " + decimalFormat.format(score) + about18YearsOldMsg);
        return new Classification(method, about18YearsOldMsg, 18);
      case 13:
        System.out.println(method + " " + decimalFormat.format(score) + about24yearsOldMsg);
        return new Classification(method, about24yearsOldMsg, 24);
      case 14:
        System.out.println(method + " " + decimalFormat.format(score) + about24yearsOldMsg);
        return new Classification(method, about24yearsOldMsg, 25);
      default:
        return new Classification(method, emptyMsg, 0);
    }
  }
}
