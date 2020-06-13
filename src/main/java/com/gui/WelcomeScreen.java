package com.gui;

import com.Calculators.CalculateService;
import com.Calculators.ClassifyService;
import com.counter.CountingService;
import com.display.DisplayService;
import com.display.Messages;
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

  public WelcomeScreen() {
    prepareAll();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    labelWithParams.setText(displayService.printAllParametersOfText(getInput()));
    jFrame.setVisible(false);
    calculateWindow.setVisible(true);
  }

  private String getPrepareMsgForAllParameters() {
    final String yearsMsg = " years old";
    final String splitter = " ";
    double ariAge =
        classifyService.classify(
            Messages.ARI_METHOD_NAME, calculateService.calculateScore(getInput()));
    double fkAge =
        classifyService.classify(
            Messages.FK_METHOD_NAME, calculateService.fleshKincaidMethod(getInput()));
    double smogAge =
        classifyService.classify(
            Messages.SMOG_METHOD_NAME,
            calculateService.smogMethod(getInput(), getInput().split(" ")));
    double clAge =
        classifyService.classify(
            Messages.CL_METHOD_NAME, calculateService.calculateScore(getInput()));

    String ariResult =
        ariMsg
            + decimalFormat.format(calculateService.calculateScore(getInput()))
            + splitter
            + ariAge
            + yearsMsg;
    String fkResult =
        fkMsg
            + decimalFormat.format(calculateService.fleshKincaidMethod(getInput()))
            + splitter
            + fkAge
            + yearsMsg;
    String smogResult =
        smogMsg
            + decimalFormat.format(
                calculateService.smogMethod(getInput(), getInput().split(splitter)))
            + splitter
            + smogAge
            + yearsMsg;
    String clResult =
        clMsg
            + decimalFormat.format(calculateService.colemanMethod(getInput()))
            + splitter
            + clAge
            + yearsMsg;

    return ariResult + splitter + fkResult + splitter + smogResult + splitter + clResult;
  }

  private String getInput() {
    return formatterService.formatText(nameTextField.getText());
  }

  private void prepareFrame() {
    calculateWindow.setSize(500, 400);
    calculateWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    calculateWindow.setTitle("All parameters window");

    jFrame.setSize(500, 400);
    jFrame.setVisible(true);
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.setTitle("My first gui");
    calculateWindow.add(panelWindow, BorderLayout.CENTER);
    nameTextField.setBounds(80, 20, 100, 30);
    add(nameTextField);
  }

  public void prepareLabels() {
    Font paramsFont = new Font("Courier", Font.PLAIN, 20);
    labelWithParams.setFont(paramsFont);
    labelWithParams.setText("");
    labelWithParams.setBounds(20, 20, 70, 30);
    add(labelWithParams);
    scoreLabel.setFont(paramsFont);
    fk.setFont(paramsFont);

    label.setText("My first gui!");
    label.setFont(paramsFont);
    label.setBounds(40, 20, 100, 30);
    add(label);
  }

  public void preparePanels() {
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
    jFrame.add(jPanel, BorderLayout.CENTER);
  }

  public void prepareButtons() {
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
              fkMsg + decimalFormat.format(calculateService.fleshKincaidMethod(getInput())));
        });
    ari.addActionListener(
        e -> {
          scoreLabel.setText(
              ariMsg + decimalFormat.format(calculateService.calculateScore(getInput())));
        });
    smog.addActionListener(
        e -> {
          scoreLabel.setText(
              smogMsg
                  + decimalFormat.format(
                      calculateService.smogMethod(getInput(), getInput().split(" "))));
        });
    cl.addActionListener(
        e -> {
          scoreLabel.setText(
              clMsg + decimalFormat.format(calculateService.colemanMethod(getInput())));
        });

    all.addActionListener(
        e -> {
          scoreLabel.setText(getPrepareMsgForAllParameters());
        });
  }

  public void prepareAll() {
    prepareFrame();
    prepareLabels();
    preparePanels();
    prepareButtons();
  }
}
