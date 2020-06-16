package biszczak.marek.score_calculator.gui;

import biszczak.marek.score_calculator.Score;
import biszczak.marek.score_calculator.ScoreService;
import biszczak.marek.score_calculator.calculators.*;
import biszczak.marek.score_calculator.display.DisplayService;
import biszczak.marek.score_calculator.display.ParameterService;
import biszczak.marek.score_calculator.input.FormatterService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class WelcomeScreen extends JFrame implements ActionListener {

  private JPanel firstPanel = new JPanel();
  private JFrame calculateWindow = new JFrame();
  private JPanel parametersWindow = new JPanel();
  private JFrame jFrame = new JFrame();
  private JButton jButton = new JButton("Tekst z konsoli");
  private JButton ari = new JButton("ARI Method");
  private JButton fk = new JButton("FK Method");
  private JButton smog = new JButton("SMOG Method");
  private JButton cl = new JButton("CL Method");
  private JButton all = new JButton("ALL Method");

  private JLabel label = new JLabel();
  private JLabel labelWithParams = new JLabel();
  private JLabel scoreLabel = new JLabel();
  private JTextField nameTextField = new JTextField();

  private DisplayService displayService = new DisplayService();
  private FormatterService formatterService = new FormatterService();
  private DecimalFormat decimalFormat = new DecimalFormat("##.00");
  private ParameterService parameterService = new ParameterService();

  private AriIndexScore ariIndexScore = new AriIndexScore();
  private SmogScore smogScore = new SmogScore();
  private FleschKincaidScore fleschKincaidScore = new FleschKincaidScore();
  private ColemanScore colemanScore = new ColemanScore();
  private ClassifyService classifyService = new ClassifyService();
  private MsgCreationService msgCreationService = new MsgCreationService(classifyService);
  private ScoreService scoreService = new ScoreService(smogScore,fleschKincaidScore,colemanScore,ariIndexScore);
  private Score score;


  public WelcomeScreen() {
    prepareAll();
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    labelWithParams.setText(displayService.printAllParametersOfText(parameterService.createParametersFromText(getFormattedInput())));
    score = scoreService.calculateScoresFromText(getFormattedInput());
    jFrame.setVisible(false);
    calculateWindow.setVisible(true);
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
    calculateWindow.add(parametersWindow, BorderLayout.CENTER);
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
    parametersWindow.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
    parametersWindow.setLayout(new GridLayout(0, 1));
    ari.setBounds(5, 5, 5, 5);
    parametersWindow.add(labelWithParams);
    parametersWindow.add(ari);
    parametersWindow.add(fk);
    parametersWindow.add(smog);
    parametersWindow.add(cl);
    parametersWindow.add(all);
    parametersWindow.add(scoreLabel);

    firstPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
    firstPanel.setLayout(new GridLayout(0, 1));
    firstPanel.add(label);
    firstPanel.add(nameTextField);
    firstPanel.add(jButton);
    jFrame.add(firstPanel, BorderLayout.CENTER);
  }

  private void prepareButtons() {
    jButton.setBounds(5, 5, 5, 5);
    jButton.addActionListener(this);
    fk.addActionListener(
        e -> {
          scoreLabel.setText(
              GuiMessages.FK_MSG
                  + decimalFormat.format(score.getFkScore()));
        });
    ari.addActionListener(
        e -> {
          scoreLabel.setText(
              GuiMessages.ARI_MSG
                  + decimalFormat.format(score.getAriScore()));
        });
    smog.addActionListener(
        e -> {
          scoreLabel.setText(
              GuiMessages.SMOG_MSG
                  + decimalFormat.format(score.getSmogScore()));
        });
    cl.addActionListener(
        e -> {
          scoreLabel.setText(
              GuiMessages.COLEMAN_MSG
                  + decimalFormat.format(score.getClScore()));
        });

    all.addActionListener(
        e -> {
          scoreLabel.setText(msgCreationService.prepareMsg(score));
        });
  }

  private void prepareAll() {
    prepareFrame();
    prepareLabels();
    preparePanels();
    prepareButtons();
  }
}
