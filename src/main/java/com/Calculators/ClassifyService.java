package com.Calculators;

import java.text.DecimalFormat;

public class ClassifyService {

    public double classify(String method, double score) {
        DecimalFormat decimalFormat = new DecimalFormat("##.00");

        if (Math.round(score) == 0) {
            System.out.println(method + " " + decimalFormat.format(score) + " about 5-6 year olds.");
            return 6;
        }
        if (Math.round(score) <= 1) {
            System.out.println(method + " " + decimalFormat.format(score) + " about 6 year olds.");
            return 6;
        }
        if (Math.round(score) == 2) {
            System.out.println(method + " " + decimalFormat.format(score) + " about 7 year olds.");
            return 7;
        }
        if (Math.round(score) == 3) {
            System.out.println(method + " " + decimalFormat.format(score) + " about 9 year olds.");
            return 9;
        }
        if (Math.round(score) == 4) {
            System.out.println(method + " " + decimalFormat.format(score) + " about 10 year olds.");
            return 10;
        }
        if (Math.round(score) == 5) {
            System.out.println(method + " " + decimalFormat.format(score) + " about 11 year olds.");
            return 11;
        }
        if (Math.round(score) == 6) {
            System.out.println(method + " " + decimalFormat.format(score) + " about 12 year olds.");
            return 12;
        }
        if (Math.round(score) == 7) {
            System.out.println(method + " " + decimalFormat.format(score) + " about 13 year olds.");
            return 13;
        }
        if (Math.round(score) == 8) {
            System.out.println(method + " " + decimalFormat.format(score) + " about 14 year olds.");
            return 14;
        }
        if (Math.round(score) == 9) {
            System.out.println(method + " " + decimalFormat.format(score) + " about 15 year olds.");
            return 15;
        }
        if (Math.round(score) == 10) {
            System.out.println(method + " " + decimalFormat.format(score) + " about 16 year olds.");
            return 16;
        }
        if (Math.round(score) == 11) {
            System.out.println(method + " " + decimalFormat.format(score) + " about 17 year olds.");
            return 17;
        }
        if (Math.round(score) == 12) {
            System.out.println(method + " " + decimalFormat.format(score) + " about 18 year olds.");
            return 18;
        }
        if (Math.round(score) == 13) {
            System.out.println(method + " " + decimalFormat.format(score) + " about 24 year olds.");
            return 24;
        }
        if (Math.round(score) >= 14) {
            System.out.println(method + " " + decimalFormat.format(score) + " about 24+ year olds.");
            return 24;
        }
        return 0;
    }

}
