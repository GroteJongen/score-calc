package com.company;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Score {
   private double ariScore;
   private double fkScore;
   private double smogScore;
   private double clScore;
}
