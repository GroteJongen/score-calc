package com.input;

import java.io.BufferedReader;

public class FileReaderService {
  private FormatterService formatterService;

  public FileReaderService(FormatterService formatterService) {
    this.formatterService = formatterService;
  }

  public String readFromFile(String fileName) {
    try (java.io.FileReader fileReader = new java.io.FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader)) {
      StringBuilder stringBuilder = new StringBuilder();
      String line = bufferedReader.readLine();
      while (line != null) {
        if (line.isEmpty()) {
          bufferedReader.readLine();
          continue;
        }
        stringBuilder.append(line);
        line = bufferedReader.readLine();
      }
      return formatterService.formatText(stringBuilder.toString());
    } catch (Exception e) {
     return "file does not exist";
    }
  }
}
