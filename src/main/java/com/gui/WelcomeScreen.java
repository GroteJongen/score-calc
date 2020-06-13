package com.gui;

import com.Calculators.CalculateService;
import com.Calculators.ClassifyService;
import com.counter.CountingService;
import com.display.DisplayService;
import com.display.Messages;
import com.input.FileReaderService;
import com.input.FormatterService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class WelcomeScreen extends JFrame implements ActionListener {
  private final String ariMsg = "Ari result is equal to: ";
  private final String fkMsg = "Fk result is equal to: ";
  private final String smogMsg = "SMOG result is equal to: ";
  private final String clMsg = "CL result is equal to: ";
  private final String wrongFileMsg = "File does not exist";

  private JPanel jPanel = new JPanel();
  private JFrame calculateWindow = new JFrame();
  private JPanel panelWindow = new JPanel();
  private JFrame jFrame = new JFrame();
  private JButton jButton = new JButton("Tekst z konsoli");
  private JButton fileButton = new JButton("Wczytanie Z pliku");
  private JButton ari = new JButton("ARI Method");
  private JButton fk = new JButton("FK Method");
  private JButton smog = new JButton("SMOG Method");
  private JButton cl = new JButton("CL Method");
  private JButton all = new JButton("ALL Method");

  private JLabel label = new JLabel();
  private JLabel labelWithParams = new JLabel();
  private JLabel scoreLabel = new JLabel();
  private JTextField nameTextField = new JTextField();

  private CountingService countingService = new CountingService();
  private DisplayService displayService = new DisplayService(countingService);
  private FormatterService formatterService = new FormatterService();
  private CalculateService calculateService = new CalculateService(countingService);
  private DecimalFormat decimalFormat = new DecimalFormat("##.00");
  private ClassifyService classifyService = new ClassifyService();
  private FileReaderService fileReaderService = new FileReaderService(formatterService);

  public WelcomeScreen() {
    prepareAll();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    labelWithParams.setText(displayService.printAllParametersOfText(getFormattedInput()));
    jFrame.setVisible(false);
    calculateWindow.setVisible(true);
  }

  private String getPrepareMsgForAllParameters() {
    final String yearsMsg = " years old";
    final String splitter = " ";
    final String rowSplitter = " | ";
    double ariAge =
        classifyService.classify(
            Messages.ARI_METHOD_NAME, calculateService.calculateScore(getFormattedInput()));
    double fkAge =
        classifyService.classify(
            Messages.FK_METHOD_NAME, calculateService.fleshKincaidMethod(getFormattedInput()));
    double smogAge =
        classifyService.classify(
            Messages.SMOG_METHOD_NAME,
            calculateService.smogMethod(getFormattedInput(), getFormattedInput().split(splitter)));
    double clAge =
        classifyService.classify(
            Messages.CL_METHOD_NAME, calculateService.calculateScore(getFormattedInput()));

    String ariResult =
        ariMsg
            + decimalFormat.format(calculateService.calculateScore(getFormattedInput()))
            + rowSplitter
            + ariAge
            + yearsMsg;
    String fkResult =
        fkMsg
            + decimalFormat.format(calculateService.fleshKincaidMethod(getFormattedInput()))
            + rowSplitter
            + fkAge
            + yearsMsg;
    String smogResult =
        smogMsg
            + decimalFormat.format(
                calculateService.smogMethod(
                    getFormattedInput(), getFormattedInput().split(splitter)))
            + rowSplitter
            + smogAge
            + yearsMsg;
    String clResult =
        clMsg
            + decimalFormat.format(calculateService.colemanMethod(getFormattedInput()))
            + rowSplitter
            + clAge
            + yearsMsg;

    return ariResult + rowSplitter + fkResult + rowSplitter + smogResult + rowSplitter + clResult;
  }

  private String getFormattedInput() {
    return formatterService.formatText(nameTextField.getText());
  }

  private String getRawInput() {
    return nameTextField.getText();
  }

  private void prepareFrame() {
    calculateWindow.setSize(1100, 500);
    calculateWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    calculateWindow.setTitle("All parameters window");

    jFrame.setSize(850, 500);
    jFrame.setVisible(true);
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.setTitle("My first gui");
    calculateWindow.add(panelWindow, BorderLayout.CENTER);
    nameTextField.setBounds(80, 20, 100, 30);
    add(nameTextField);
  }

  private void prepareLabels() {
    Font paramsFont = new Font("Courier", Font.PLAIN, 15);
    labelWithParams.setFont(paramsFont);
    labelWithParams.setText("");
    labelWithParams.setBounds(20, 20, 70, 30);
    add(labelWithParams);
    scoreLabel.setFont(paramsFont);
    fk.setFont(paramsFont);

    label.setText(
        "Select console input if you want to paste text or file input if you want to load it from file!");
    label.setFont(paramsFont);
    label.setBounds(40, 20, 100, 30);
    add(label);
  }

  private void preparePanels() {
    panelWindow.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
    panelWindow.setLayout(new GridLayout(0, 1));
    ari.setBounds(5, 5, 5, 5);
    fileButton.setBounds(5, 5, 5, 5);
    panelWindow.add(labelWithParams);
    panelWindow.add(ari);
    panelWindow.add(fk);
    panelWindow.add(smog);
    panelWindow.add(cl);
    panelWindow.add(all);
    panelWindow.add(scoreLabel);

    jPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
    jPanel.setLayout(new GridLayout(0, 1));
    jPanel.add(label);
    jPanel.add(nameTextField);
    jPanel.add(jButton);
    jPanel.add(fileButton);
    jFrame.add(jPanel, BorderLayout.CENTER);
  }

  private void prepareButtons() {
    fileButton.addActionListener(
        (item) -> {
          jFrame.setVisible(false);
          calculateWindow.setVisible(true);
        });
    jButton.setBounds(5, 5, 5, 5);
    jButton.addActionListener(this);
    fk.addActionListener(
        e -> {
          scoreLabel.setText(
              fkMsg
                  + decimalFormat.format(calculateService.fleshKincaidMethod(getFormattedInput())));
        });
    ari.addActionListener(
        e -> {
          scoreLabel.setText(
              ariMsg + decimalFormat.format(calculateService.calculateScore(getFormattedInput())));
        });
    smog.addActionListener(
        e -> {
          scoreLabel.setText(
              smogMsg
                  + decimalFormat.format(
                      calculateService.smogMethod(
                          getFormattedInput(), getFormattedInput().split(" "))));
        });
    cl.addActionListener(
        e -> {
          scoreLabel.setText(
              clMsg + decimalFormat.format(calculateService.colemanMethod(getFormattedInput())));
        });

    all.addActionListener(
        e -> {
          scoreLabel.setText(getPrepareMsgForAllParameters());
        });
    fileButton.addActionListener(
        e -> {
          String content = fileReaderService.readFromFile(getRawInput());
          if (content.equals("file does not exist")) {
            labelWithParams.setText(wrongFileMsg);
          } else {
            labelWithParams.setText(content);
          }
        });
  }

  private void prepareAll() {
    prepareFrame();
    prepareLabels();
    preparePanels();
    prepareButtons();
  }
}
